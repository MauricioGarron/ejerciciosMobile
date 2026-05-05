package com.ucb.app.crypto.data.repository

import com.ucb.app.crypto.data.datasource.RealtimeFirebaseDatasource
import com.ucb.app.crypto.data.dto.CryptoDto
import com.ucb.app.crypto.data.mapper.toModel
import com.ucb.app.crypto.domain.model.CryptoModel
import com.ucb.app.crypto.domain.repository.CryptoRepository

class RealtimeFirebaseRepositoryImp (
    val remote: RealtimeFirebaseDatasource
): CryptoRepository {
    override suspend fun getCryptos(): List<CryptoModel> {
        val response = remote.getCryptos("cryptos/")
        return response.map{ it.toModel() }
    }

    override suspend fun saveCrypto(crypto: CryptoModel) {
        remote.saveCrypto(path = "cryptos/${crypto.id}", crypto)
    }
}