package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.usecases.UpdateOrderItemAction
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.components.OrderItemCard
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun OrderSummary(
    cartItems: List<DMOrderItem>,
    onCartItemCountUpdate: (DMOrderItem, UpdateOrderItemAction) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        SpacerComponent(spaceInDp = 16.dp)
        Text(
            text = "Your Order",
            style = MaterialTheme.typography.h4,
            color = PrimaryBlack
        )
        SpacerComponent(spaceInDp = 16.dp)
        cartItems.forEach { item ->
            SpacerComponent(spaceInDp = 4.dp)
            OrderItemCard(dmOrderItem = item, onCartItemCountUpdate)
            SpacerComponent(spaceInDp = 4.dp)
        }
    }
}
