package com.ruthvikbr.starbucksindiacompose.ui.screens.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksColumn
import com.starbuckscompose.navigation.ComposeNavigator

@Composable
fun HomeScreen(composeNavigator: ComposeNavigator) {
    StarbucksColumn {
        Text(text = "Home")
    }
}