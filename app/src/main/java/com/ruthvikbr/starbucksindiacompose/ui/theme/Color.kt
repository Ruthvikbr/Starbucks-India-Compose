package com.ruthvikbr.starbucksindiacompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val StarbucksGreen = Color(0xFF006241)
val AccentGreen = Color(0xFF00754A)
val LightGreen = Color(0xFFD4E9E2)
val HouseGreen = Color(0xFF1E3932)

val PrimaryBlack = Color(0xFF1A1A1A)
val SecondaryBlack = Color(0xFF202020)
val SeparatorBlack = Color(0xFF222222)

val PrimaryWhite = Color.White
val SecondaryWhite = Color(0xFFf8f8f8)
val SeparatorWhite = Color(0xFFd4d4d4)

val OffWhiteBackground = Color(0xFFf9f9f9)
val HeadingDark = Color(0xFFA0A0A0)
val SettingsItemTextDark = Color(0xFFE6E6E6)

val HeadingLight = Color(0xFF626262)
val SettingsItemTextLight = Color(0xFF1c1c1c)
val CoffeeColor = Color(0xFF6f4e37)

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

val secondary_header_background_color
    @Composable get() = if (isSystemInDarkTheme()) {
        PrimaryBlack
    } else {
        PrimaryWhite
    }

val secondary_background_color
    @Composable get() = if (isSystemInDarkTheme()) {
        SecondaryBlack
    } else {
        SecondaryWhite
    }

val separator
    @Composable get() = if (isSystemInDarkTheme()) {
        SeparatorBlack
    } else {
        SeparatorWhite
    }

val settings_header_text_color
    @Composable get() = if (isSystemInDarkTheme()) {
        HeadingDark
    } else {
        HeadingLight
    }

val settings_item_text__color
    @Composable get() = if (isSystemInDarkTheme()) {
        SettingsItemTextDark
    } else {
        SettingsItemTextLight
    }
