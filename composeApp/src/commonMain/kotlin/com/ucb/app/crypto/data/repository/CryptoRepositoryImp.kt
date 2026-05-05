package com.ucb.app.crypto.data.repository

import com.ucb.app.crypto.data.datasource.CoingeckoRemoteDataSource
import com.ucb.app.crypto.data.mapper.toModel
import com.ucb.app.crypto.domain.model.CryptoModel
import com.ucb.app.crypto.domain.repository.CryptoRepository

class CryptoRepositoryImp(
    val remote: CoingeckoRemoteDataSource
): CryptoRepository {
    override suspend fun getCryptos(): List<CryptoModel> {
        val response = remote.getCryptos()
        return response.map{ it.toModel() }
    }

    override suspend fun saveCrypto(crypto: CryptoModel) {
        TODO("Not yet implemented")
    }
}