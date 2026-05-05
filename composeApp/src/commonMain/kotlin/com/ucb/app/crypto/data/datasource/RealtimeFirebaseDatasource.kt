package com.ucb.app.crypto.data.datasource

import com.ucb.app.crypto.data.dto.CryptoDto
import com.ucb.app.crypto.domain.model.CryptoModel

expect class RealtimeFirebaseDatasource() {
    suspend fun saveCrypto(path: String, crypto: CryptoModel)
    suspend fun getCryptos(path: String) : List<CryptoDto>
}
