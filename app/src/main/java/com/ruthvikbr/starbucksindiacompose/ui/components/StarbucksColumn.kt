package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StarbucksColumn(
    modifier: Modifier = Modifier.fillMaxSize(),
    alignment: Alignment.Horizontal = Alignment.Start,
    children: @Composable () -> Unit = { Text(text = "Sample Composable") }
) {
    Column(modifier = modifier, horizontalAlignment = alignment) {
        children()
    }
}