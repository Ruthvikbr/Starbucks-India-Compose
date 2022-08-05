package com.ruthvikbr.starbucksindiacompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val StarbucksGreen = Color(0xFF006241)
val AccentGreen = Color(0xFF00754A)
val LightGreen = Color(0xFFD4E9E2)
val HouseGreen = Color(0xFF1E3932)

val bottom_bar_background_color
    @Composable get() = if (isSystemInDarkTheme()) {
        Color.Black
    } else {
        Color.White
    }

val bottom_bar_text_color
    @Composable get() = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }