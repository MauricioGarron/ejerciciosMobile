package com.ucb.app.crypto.domain.usecase

import com.ucb.app.crypto.domain.model.CryptoModel
import com.ucb.app.crypto.domain.repository.CryptoRepository

class GetCryptoUseCase(
    val repository: CryptoRepository
) {
    suspend fun invoke(): List<CryptoModel> {
        return repository.getCryptos();
    }
}