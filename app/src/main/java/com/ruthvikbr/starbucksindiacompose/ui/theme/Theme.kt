package com.ruthvikbr.starbucksindiacompose.ui.theme // ktlint-disable filename

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = StarbucksGreen,
    primaryVariant = AccentGreen,
    secondary = HouseGreen,
    onPrimary = LightGreen
)

private val LightColorPalette = lightColors(
    primary = StarbucksGreen,
    primaryVariant = AccentGreen,
    secondary = HouseGreen,
    onPrimary = LightGreen

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun StarbucksIndiaComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = StarbucksTypography,
        shapes = Shapes,
        content = content
    )
}
