package com.ucb.app.payment_card.domain.usecase

import com.ucb.app.payment_card.domain.model.CreditCard
import com.ucb.app.payment_card.domain.repository.PaymentRepository
import com.ucb.app.product.domain.model.Product
import com.ucb.app.product.domain.repository.ProductRepository
import com.ucb.app.warehouse.domain.repository.WarehouseRepository

class DoPaymentUseCase(
    val paymentRepository: PaymentRepository,
    val productRepository: ProductRepository,
    val warehouseRepository: WarehouseRepository
) {
    suspend fun invoke(
        productModel: Product,
        creditCard: CreditCard
    ) {
        val product = productRepository.findById(productModel.id)
        if(warehouseRepository.verifyStock(product.id)) {
            val resultPayment = paymentRepository.executePayment(creditCard, product.price)
            if(resultPayment) {
                warehouseRepository.reduceProduct(product.id)
            }
        }
    }
}