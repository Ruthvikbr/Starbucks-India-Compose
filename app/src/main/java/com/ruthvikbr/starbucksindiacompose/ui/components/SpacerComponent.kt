package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpacerComponent(isVerticalSpace: Boolean = true, spaceInDp: Dp) {
    if (isVerticalSpace) {
        Spacer(modifier = Modifier.height(spaceInDp))
    } else {
        Spacer(modifier = Modifier.width(spaceInDp))
    }
}
