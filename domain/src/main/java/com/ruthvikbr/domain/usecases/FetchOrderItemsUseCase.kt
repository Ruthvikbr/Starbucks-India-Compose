package com.ruthvikbr.domain.usecases

import com.ruthvikbr.domain.repo.OrderRepository
import javax.inject.Inject

class FetchOrderItemsUseCase @Inject constructor(private val orderRepository: OrderRepository) {
    operator fun invoke(activeCategory: String) = orderRepository.getOrderItems(activeCategory)
}
