package com.ucb.app.crypto.presentation.state

import com.ucb.app.crypto.domain.model.CryptoModel

data class CryptoState(
    val isLoading: Boolean = false,
    val cryptos: List<CryptoModel> = emptyList(),
    val error: String? = null,
    val greeting: String = ""
)