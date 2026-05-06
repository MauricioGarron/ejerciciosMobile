package com.ucb.app.crypto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.crypto.domain.model.CryptoModel
import com.ucb.app.crypto.domain.repository.CryptoDraftRepository
import com.ucb.app.crypto.domain.usecase.SaveCryptoUseCase
import com.ucb.app.crypto.presentation.state.CryptoEffect
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddCryptoViewModel(
    private val saveCryptoUseCase: SaveCryptoUseCase,
    private val cryptoDraftRepository: CryptoDraftRepository
) : ViewModel() {

    private val _effect = Channel<CryptoEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    private var autoSaveJob: Job? = null

    fun startAutoSave(
        getId: () -> String,
        getName: () -> String,
        getPriceText: () -> String
    ) {
        if (autoSaveJob != null) return

        autoSaveJob = viewModelScope.launch {
            while (true) {
                delay(30_000)

                val id = getId()
                val name = getName()
                val price = getPriceText().toDoubleOrNull() ?: 0.0

                if (id.isNotBlank() || name.isNotBlank() || getPriceText().isNotBlank()) {
                    cryptoDraftRepository.saveDraft(
                        id = id.ifBlank { "draft" },
                        name = name,
                        price = price
                    )
                    _effect.send(CryptoEffect.ShowSuccess("Formulario guardado automáticamente en Room"))
                }
            }
        }
    }

    fun saveCrypto(id: String, name: String, price: Double) {
        viewModelScope.launch {
            try {
                val crypto = CryptoModel(
                    id = id,
                    name = name,
                    symbol = "",
                    image = "",
                    price = price,
                    marketCapRank = 0,
                    priceChange24h = 0.0,
                    high24h = 0.0,
                    low24h = 0.0
                )

                saveCryptoUseCase.invoke(crypto)
                cryptoDraftRepository.clearDraft()

                _effect.send(CryptoEffect.ShowSuccess("Crypto sincronizada correctamente con Firebase"))
            } catch (e: Exception) {
                _effect.send(CryptoEffect.ShowError("No se pudo sincronizar la crypto"))
            }
        }
    }

    override fun onCleared() {
        autoSaveJob?.cancel()
        super.onCleared()
    }
}