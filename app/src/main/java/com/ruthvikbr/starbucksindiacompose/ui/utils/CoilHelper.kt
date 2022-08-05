package com.ruthvikbr.starbucksindiacompose.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

@Composable
fun rememberCoilImageRequest(
    data: Any?
): ImageRequest {
    val context = LocalContext.current
    return remember(data) {
        ImageRequest
            .Builder(context)
            .data(data)
            .crossfade(true)
            .build()
    }
}