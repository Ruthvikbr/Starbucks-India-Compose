package com.ruthvikbr.starbucksindiacompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator

@Composable
fun HomeScreen(navController:NavController) {
    Column() {
        Text(text = "Home")
    }
}