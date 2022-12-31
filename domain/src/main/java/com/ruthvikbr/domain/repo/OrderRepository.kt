package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMOrderItem
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getOrderItems(): Flow<List<DMOrderItem>>
    fun getCartItems(): Flow<List<DMOrderItem>>
    suspend fun deleteAllCartItems()
    suspend fun updateOrderItem(dmOrderItem: DMOrderItem)
}
