package com.ruthvikbr.starbucksindiacompose.ui.utils

import com.ruthvikbr.starbucksindiacompose.R
import com.starbuckscompose.navigation.StarbucksScreen

data class NavigationItem(
    val label: String,
    val icon: Int,
    val route: String
)

object BottomNavigationItems {
    val items = listOf(
        NavigationItem("Home", R.drawable.ic_home, StarbucksScreen.Home.route),
        NavigationItem("Order", R.drawable.ic_coffee, StarbucksScreen.Order.name),
        NavigationItem("Profile", R.drawable.ic_person, StarbucksScreen.Profile.route),
        NavigationItem("Settings", R.drawable.ic_settings, StarbucksScreen.Settings.route)
    )
}
