package com.ucb.app.crypto.data.datasource

import com.ucb.app.crypto.data.dto.CryptoDto
import com.ucb.app.crypto.domain.model.CryptoModel

actual class RealtimeFirebaseDatasource actual constructor() {
    actual suspend fun saveCrypto(path: String, crypto: CryptoModel) {
        // iOS implementation not available yet
    }

    actual suspend fun getCryptos(path: String): List<CryptoDto> {
        return emptyList()
    }
}