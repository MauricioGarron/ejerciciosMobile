package com.ucb.app.payment_card.domain.repository

import com.ucb.app.payment_card.domain.model.CreditCard
import com.ucb.app.product.domain.model.Product

interface PaymentRepository {
    suspend fun executePayment(
        paymentModel: CreditCard,
        price: Double
    ): Boolean
}