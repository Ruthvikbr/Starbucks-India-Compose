package com.ruthvikbr.starbucksindiacompose.ui.screens.order

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksColumn
import com.starbuckscompose.navigation.ComposeNavigator

@Composable
fun OrderScreen(composeNavigator: ComposeNavigator) {
    StarbucksColumn {
        Text(text = "Order")
    }
}