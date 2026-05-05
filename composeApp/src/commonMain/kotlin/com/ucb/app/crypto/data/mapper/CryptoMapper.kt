package com.ucb.app.crypto.data.mapper

import com.ucb.app.crypto.data.dto.CryptoDto
import com.ucb.app.crypto.domain.model.CryptoModel

fun CryptoDto.toModel() = CryptoModel(
    id = id.orEmpty(),
    name = name.orEmpty(),
    symbol = symbol.orEmpty(),
    image = image.orEmpty(),
    price = price ?: 0.0,
    marketCapRank = marketCapRank ?: 0,
    priceChange24h = priceChange24h ?: 0.0,
    high24h = high24h ?: 0.0,
    low24h = low24h ?: 0.0
)
