package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun EmptyCheckoutScreen(onButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your cart is empty", style = MaterialTheme.typography.h4)
        SpacerComponent(spaceInDp = 8.dp)
        Text(
            text = "Order now",
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(40.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AccentGreen)
                .wrapContentHeight()
                .clickable {
                    onButtonClicked()
                },
            textAlign = TextAlign.Center,
            color = PrimaryWhite
        )
    }
}
