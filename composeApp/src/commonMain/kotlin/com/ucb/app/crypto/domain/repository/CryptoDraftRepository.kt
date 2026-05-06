package com.ucb.app.crypto.domain.repository

interface CryptoDraftRepository {
    suspend fun saveDraft(id: String, name: String, price: Double)
    suspend fun clearDraft()
}