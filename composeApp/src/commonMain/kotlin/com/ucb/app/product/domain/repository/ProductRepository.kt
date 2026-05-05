package com.ucb.app.product.domain.repository

import com.ucb.app.product.domain.model.Product

interface ProductRepository {
    suspend fun findById(id: String): Product
}