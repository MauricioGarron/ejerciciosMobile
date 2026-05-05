package com.ucb.app.crypto.domain.repository

import com.ucb.app.crypto.domain.model.CryptoModel

interface CryptoRepository {
    suspend fun getCryptos(): List<CryptoModel>
    suspend fun saveCrypto(crypto: CryptoModel)
}