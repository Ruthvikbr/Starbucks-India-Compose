package com.ruthvikbr.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Order")
data class OrderItem(
    val itemName: String,
    val itemCount: Int,
    val itemPrice: Int,
    val itemImageUrl: String,
    val itemDescription: String,
    val itemCategory: String,
    @PrimaryKey(autoGenerate = true)
    val itemId: Long = 0L
)
