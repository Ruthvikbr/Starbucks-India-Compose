package com.ruthvikbr.domain.usecases

import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.repo.OrderRepository
import javax.inject.Inject

class UpdateOrderItemUseCase @Inject constructor(private val orderRepository: OrderRepository) {
    suspend operator fun invoke(
        dmOrderItem: DMOrderItem,
        updateOrderItemAction: UpdateOrderItemAction
    ) {
        when (updateOrderItemAction) {
            UpdateOrderItemAction.INCREASE_PRODUCT_COUNT -> {
                orderRepository.updateOrderItem(dmOrderItem.copy(itemCount = dmOrderItem.itemCount + 1))
            }
            UpdateOrderItemAction.DECREASE_PRODUCT_COUNT -> {
                if (dmOrderItem.itemCount >= 1) {
                    orderRepository.updateOrderItem(dmOrderItem.copy(itemCount = dmOrderItem.itemCount - 1))
                } else {
                    orderRepository.updateOrderItem(dmOrderItem.copy(itemCount = 0))
                }
            }
        }
    }
}

enum class UpdateOrderItemAction {
    DECREASE_PRODUCT_COUNT,
    INCREASE_PRODUCT_COUNT,
}
