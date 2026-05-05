package com.ucb.app.crypto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.commonutils.domain.usecase.GetGreetingTextUseCase
import com.ucb.app.crypto.domain.usecase.GetCryptoUseCase
import com.ucb.app.crypto.presentation.state.CryptoEffect
import com.ucb.app.crypto.presentation.state.CryptoEvent
import com.ucb.app.crypto.presentation.state.CryptoState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull

class CryptoViewModel(
    private val getCryptoUseCase: GetCryptoUseCase,
    private val getGreetingTextUsecase: GetGreetingTextUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CryptoState())
    val state = _state.asStateFlow()

    private val _effect = Channel<CryptoEffect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: CryptoEvent) {
        when (event) {
            CryptoEvent.OnLoad -> loadCrypto()
            CryptoEvent.OnRefresh -> loadCrypto()
            CryptoEvent.OnSave -> Unit
        }
    }

    private fun loadCrypto() {
        _state.update {
            it.copy(
                isLoading = true,
                error = null
            )
        }

        viewModelScope.launch {
            try {
                val greetingMessage = withTimeoutOrNull(5000) {
                    getGreetingTextUsecase.invoke()
                } ?: "Sin configuración remota"

                val cryptosList = withTimeoutOrNull(7000) {
                    getCryptoUseCase.invoke()
                } ?: emptyList()

                _state.update {
                    it.copy(
                        isLoading = false,
                        greeting = greetingMessage,
                        cryptos = cryptosList,
                        error = null
                    )
                }

            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        cryptos = emptyList(),
                        error = e.message ?: "No se pudieron cargar las criptomonedas"
                    )
                }

                _effect.send(
                    CryptoEffect.ShowError("No se pudieron cargar las criptomonedas")
                )
            }
        }
    }
}