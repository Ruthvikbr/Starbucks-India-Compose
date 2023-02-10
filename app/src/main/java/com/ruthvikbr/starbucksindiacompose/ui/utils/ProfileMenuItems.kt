package com.ruthvikbr.starbucksindiacompose.ui.utils

import com.ruthvikbr.starbucksindiacompose.R

data class ProfileMenuItem(
    val label: String,
    val icon: Int,
)

object ProfileMenuItemsList {
    val items = listOf(
        ProfileMenuItem("Starbucks Rewards", R.drawable.rewards),
        ProfileMenuItem("Orders", R.drawable.coffee),
        ProfileMenuItem("Starbucks Pay", R.drawable.credit),
        ProfileMenuItem("Other Payment Modes", R.drawable.other_payment),
        ProfileMenuItem("Help Center", R.drawable.help_center),
        ProfileMenuItem("Saved Articles and News", R.drawable.saved),
        ProfileMenuItem("Rate Us On The Play Store", R.drawable.playstore),
    )
}
