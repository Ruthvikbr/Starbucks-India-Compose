package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.usecases.UpdateOrderItemAction
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.BillSummary

@Composable
fun Checkout(
    billSummary: BillSummary,
    cartItems: List<DMOrderItem>,
    onBackPressed: () -> Unit,
    onCartItemCountUpdate: (DMOrderItem, UpdateOrderItemAction) -> Unit,
    onPaymentStatusUpdate: (selectedPaymentMode: String) -> Unit,
    selectedPaymentMode: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(SecondaryWhite)
    ) {
        StarbucksAppBar(title = "Checkout", onBackPressed = {
            onBackPressed()
        })
        OrderSummary(cartItems = cartItems, onCartItemCountUpdate = onCartItemCountUpdate)
        OrderBillSummary(billSummary = billSummary)
        PaymentOptions(onPaymentStatusUpdate = onPaymentStatusUpdate, selectedPaymentMode)
    }
}
