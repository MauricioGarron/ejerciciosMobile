package com.ucb.app.crypto.presentation.state

sealed interface CryptoEvent {
    data object OnLoad : CryptoEvent
    data object OnRefresh : CryptoEvent
    data object OnSave : CryptoEvent
}