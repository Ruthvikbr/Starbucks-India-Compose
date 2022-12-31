package com.ruthvikbr.domain.usecases

import com.ruthvikbr.domain.repo.OrderRepository
import javax.inject.Inject

class DeleteCartItemsUseCase @Inject constructor(private val orderRepository: OrderRepository) {
    suspend operator fun invoke() = orderRepository.deleteAllCartItems()
}
