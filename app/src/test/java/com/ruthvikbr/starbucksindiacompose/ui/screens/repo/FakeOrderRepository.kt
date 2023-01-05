package com.ruthvikbr.starbucksindiacompose.ui.screens.repo

import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.repo.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeOrderRepository : OrderRepository {

    private val orderItems = mutableListOf(
        DMOrderItem(
            "Item1",
            0,
            200,
            "sample img url",
            "Sample desc 1",
            "Hot coffee",
            0L
        ),
        DMOrderItem(
            "Item2",
            2,
            200,
            "sample img url",
            "Sample desc 2",
            "Hot coffee",
            1L
        ),
        DMOrderItem(
            "Item3",
            2,
            200,
            "sample img url",
            "Sample desc 3",
            "Hot Tea",
            1L
        )
    )

    override fun getOrderItems(activeCategory: String): Flow<List<DMOrderItem>> {
        return flowOf(
            orderItems.filter {
                it.itemCategory == activeCategory
            }
        )
    }

    override fun getCartItems(): Flow<List<DMOrderItem>> {
        return flowOf(
            orderItems.filter {
                it.itemCount > 0
            }
        )
    }

    override suspend fun deleteAllCartItems() {
        orderItems.removeAll {
            true
        }
    }

    override suspend fun updateOrderItem(dmOrderItem: DMOrderItem) {
        orderItems.removeIf {
            it.itemId == dmOrderItem.itemId
        }
        orderItems.add(dmOrderItem)
    }
}
