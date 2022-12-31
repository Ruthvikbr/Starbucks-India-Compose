package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.OrderPaymentOptions

@Composable
fun PaymentOptions(
    onPaymentStatusUpdate: (
        paymentMode: String
    ) -> Unit,
    selectedPaymentMode: String
) {
    Column(
        modifier = Modifier
            .background(SecondaryWhite)
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(PrimaryWhite)
            .padding(16.dp)
    ) {
        PaymentOption(
            label = OrderPaymentOptions.PhonePe.label,
            imageId = OrderPaymentOptions.PhonePe.imageId,
            onPaymentStatusUpdate = onPaymentStatusUpdate,
            selectedPaymentMode
        )
        PaymentOption(
            label = OrderPaymentOptions.GooglePay.label,
            imageId = OrderPaymentOptions.GooglePay.imageId,
            onPaymentStatusUpdate = onPaymentStatusUpdate,
            selectedPaymentMode
        )
        PaymentOption(
            label = OrderPaymentOptions.Store.label,
            imageId = OrderPaymentOptions.Store.imageId,
            onPaymentStatusUpdate = onPaymentStatusUpdate,
            selectedPaymentMode
        )
    }
}

@Composable
fun PaymentOption(
    label: String,
    imageId: Int,
    onPaymentStatusUpdate: (paymentMode: String) -> Unit,
    selectedPaymentMode: String
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(40.dp).clickable {
            onPaymentStatusUpdate(label)
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RadioButton(
            selected = selectedPaymentMode == label,
            onClick = {
                onPaymentStatusUpdate(label)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = AccentGreen,
                unselectedColor = Color.Gray
            )
        )
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Payment logo",
            modifier = Modifier.padding(horizontal = 8.dp).size(24.dp).clip(CircleShape)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryBlack,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}
