package com.ruthvikbr.data.models.mappers // ktlint-disable filename

import com.ruthvikbr.data.models.OrderItem
import com.ruthvikbr.domain.models.DMOrderItem

fun OrderItem.toDmOrderItem(): DMOrderItem {
    return DMOrderItem(
        this.itemName,
        this.itemCount,
        this.itemPrice,
        this.itemImageUrl,
        this.itemDescription,
        this.itemCategory,
        this.itemId
    )
}

fun DMOrderItem.toOrderItem(): OrderItem {
    return OrderItem(
        this.itemName,
        this.itemCount,
        this.itemPrice,
        this.itemImageUrl,
        this.itemDescription,
        this.itemCategory,
        this.itemId
    )
}
