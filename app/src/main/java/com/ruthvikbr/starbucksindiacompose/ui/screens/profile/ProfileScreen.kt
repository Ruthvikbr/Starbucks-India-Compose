package com.ruthvikbr.starbucksindiacompose.ui.screens.profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksColumn
import com.starbuckscompose.navigation.ComposeNavigator

@Composable
fun ProfileScreen(composeNavigator: ComposeNavigator) {
    StarbucksColumn {
        Text(text = "Profile")
    }
}