package com.ruthvikbr.starbucksindiacompose.ui.utils

fun secureMobileNNumber(mobile: String): String {
    val secureString = mobile.mapIndexed { index, c ->
        if (index > 1 && mobile.length - index > 2) "*" else c
    }.joinToString("")

    return "+91$secureString"
}
