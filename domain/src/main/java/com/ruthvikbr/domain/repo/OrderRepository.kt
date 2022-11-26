package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMOrderItem
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getOrderItems(): Flow<List<DMOrderItem>>
}
