package com.ucb.app.crypto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_draft")
data class CryptoDraftEntity(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double,
    val updatedAt: Long = System.currentTimeMillis()
)