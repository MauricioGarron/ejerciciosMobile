package com.ucb.app.crypto.domain.usecase

import com.ucb.app.crypto.domain.model.CryptoModel
import com.ucb.app.crypto.domain.repository.CryptoRepository

class SaveCryptoUseCase (
    val repository: CryptoRepository
) {
    suspend fun invoke(cryptoData: CryptoModel) {
        repository.saveCrypto(cryptoData)
    }
}