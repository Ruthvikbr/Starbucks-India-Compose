package com.ruthvikbr.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ruthvikbr.data.models.OrderItem
import kotlinx.coroutines.flow.Flow

@Dao
interface StarbucksDao {
    @Insert
    fun insertOrderItem(orderItem: OrderItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrderItem(orderItem: OrderItem)

    @Delete
    fun deleteOrderItem(orderItem: OrderItem)

    @Query("SELECT * FROM `order`")
    fun getOrderItems(): Flow<List<OrderItem>>

    @Query("SELECT * FROM `order` WHERE itemCount >= 1")
    fun getCartItems(): Flow<List<OrderItem>>
}
