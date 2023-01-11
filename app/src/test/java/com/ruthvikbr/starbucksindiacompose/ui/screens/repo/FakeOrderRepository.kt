package com.ruthvikbr.starbucksindiacompose.ui.screens.repo

import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.repo.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeOrderRepository : OrderRepository {

    private var orderItems = mutableListOf(
        DMOrderItem(
            "Item1",
            0,
            200,
            "sample img url",
            "Sample desc 1",
            "Hot coffee",
            1L
        ),
        DMOrderItem(
            "Item2",
            2,
            200,
            "sample img url",
            "Sample desc 2",
            "Hot coffee",
            2L
        ),
        DMOrderItem(
            "Item3",
            2,
            200,
            "sample img url",
            "Sample desc 3",
            "Hot Tea",
            3L
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
        orderItems = mutableListOf()
    }

    override suspend fun updateOrderItem(dmOrderItem: DMOrderItem) {
        val index = orderItems.indexOfFirst {
            it.itemId == dmOrderItem.itemId
        }
        orderItems.removeIf {
            it.itemId == dmOrderItem.itemId
        }
        orderItems.add(index, dmOrderItem)
    }
}
