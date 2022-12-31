package com.ruthvikbr.domain.usecases

import com.ruthvikbr.domain.repo.OrderRepository
import javax.inject.Inject

class FetchCartItemsUseCase @Inject constructor(private val orderRepository: OrderRepository) {
    operator fun invoke() = orderRepository.getCartItems()
}
