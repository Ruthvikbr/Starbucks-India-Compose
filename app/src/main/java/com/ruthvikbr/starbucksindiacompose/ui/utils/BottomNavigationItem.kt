package com.ruthvikbr.starbucksindiacompose.ui.utils

import com.ruthvikbr.starbucksindiacompose.R

data class NavigationItem(
    val label: String,
    val icon: Int,
    val route: String,
)

object BottomNavigationItems {
    val items = listOf(
        NavigationItem("Home", R.drawable.ic_home, Screen.Dashboard.route),
        NavigationItem("Order", R.drawable.ic_coffee, Screen.Order.route),
        NavigationItem("Profile", R.drawable.ic_person, Screen.Profile.route),
        NavigationItem("Settings", R.drawable.ic_settings, Screen.Settings.route),
    )
}

