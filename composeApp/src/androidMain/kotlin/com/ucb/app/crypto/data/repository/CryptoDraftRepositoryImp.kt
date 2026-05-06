package com.ucb.app.crypto.data.repository

import com.ucb.app.crypto.data.local.CryptoDraftDao
import com.ucb.app.crypto.data.local.CryptoDraftEntity
import com.ucb.app.crypto.domain.repository.CryptoDraftRepository

class CryptoDraftRepositoryImp(
    private val dao: CryptoDraftDao
) : CryptoDraftRepository {

    override suspend fun saveDraft(id: String, name: String, price: Double) {
        dao.saveDraft(
            CryptoDraftEntity(
                id = id,
                name = name,
                price = price
            )
        )
    }

    override suspend fun clearDraft() {
        dao.clearDraft()
    }
}