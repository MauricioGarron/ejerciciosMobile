package com.ucb.app.crypto.data.datasource

import com.google.firebase.database.FirebaseDatabase
import com.ucb.app.crypto.data.dto.CryptoDto
import com.ucb.app.crypto.domain.model.CryptoModel
import kotlinx.coroutines.tasks.await

actual class RealtimeFirebaseDatasource actual constructor() {
    private val database = FirebaseDatabase.getInstance().reference

    actual suspend fun saveCrypto(path: String, crypto: CryptoModel) {
        try {
            database.child(path).setValue(crypto).await()
            println("Firebase Android: Guardado exitoso en $path")
        } catch (e: Exception) {
            println("Firebase Android: Error - ${e.message}")
        }
    }

    actual suspend fun getCryptos(path: String): List<CryptoDto> {
        return try {
            val snapshot = database.child(path).get().await()
            snapshot.children.mapNotNull { child ->
                CryptoDto(
                    id = child.child("id").getValue(String::class.java),
                    name = child.child("name").getValue(String::class.java),
                    symbol = child.child("symbol").getValue(String::class.java),
                    image = child.child("image").getValue(String::class.java),
                    price = child.child("price").getValue(Double::class.java)
                        ?: child.child("price").getValue(Long::class.java)?.toDouble(),
                    marketCapRank = child.child("marketCapRank").getValue(Int::class.java)
                        ?: child.child("marketCapRank").getValue(Long::class.java)?.toInt(),
                    priceChange24h = child.child("priceChange24h").getValue(Double::class.java)
                        ?: child.child("priceChange24h").getValue(Long::class.java)?.toDouble(),
                    high24h = child.child("high24h").getValue(Double::class.java)
                        ?: child.child("high24h").getValue(Long::class.java)?.toDouble(),
                    low24h = child.child("low24h").getValue(Double::class.java)
                        ?: child.child("low24h").getValue(Long::class.java)?.toDouble()
                )
            }
        } catch (e: Exception) {
            println("Firebase Android: Error - ${e.message}")
            emptyList()
        }
    }
}
