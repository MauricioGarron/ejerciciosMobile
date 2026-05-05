package com.ucb.app.crypto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.app.crypto.domain.model.CryptoModel
import com.ucb.app.crypto.domain.usecase.SaveCryptoUseCase
import com.ucb.app.crypto.presentation.state.CryptoEffect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddCryptoViewModel(
    private val saveCryptoUseCase: SaveCryptoUseCase
) : ViewModel() {
    private val _effect = Channel<CryptoEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

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
                _effect.send(CryptoEffect.ShowSuccess("Crypto guardada correctamente"))
            } catch (e: Exception) {
                _effect.send(CryptoEffect.ShowError("No se pudo guardar la crypto"))
            }
        }
    }
}
