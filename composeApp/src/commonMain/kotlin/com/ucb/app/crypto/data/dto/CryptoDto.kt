package com.ucb.app.crypto.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoDto(
    val id: String?,
    val name: String?,
    val symbol: String?,
    val image: String?,
    @SerialName(value = "current_price")
    val price: Double?,
    @SerialName(value = "market_cap_rank")
    val marketCapRank: Int?,
    @SerialName(value = "price_change_24h")
    val priceChange24h: Double?,
    @SerialName(value = "high_24h")
    val high24h: Double?,
    @SerialName(value = "low_24h")
    val low24h: Double?
)