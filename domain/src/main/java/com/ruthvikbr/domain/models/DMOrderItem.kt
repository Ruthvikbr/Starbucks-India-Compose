package com.ruthvikbr.domain.models

data class DMOrderItem(
    val itemName: String,
    val itemCount: Int,
    val itemPrice: Int,
    val itemImageUrl: String,
    val itemDescription: String,
    val itemCategory: String,
    val itemId: Long = 0L
)
