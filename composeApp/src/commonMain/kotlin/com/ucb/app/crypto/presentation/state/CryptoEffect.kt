package com.ucb.app.crypto.presentation.state

sealed interface CryptoEffect {
    data class ShowError(val message: String) : CryptoEffect
    data class ShowSuccess(val message: String) : CryptoEffect
}