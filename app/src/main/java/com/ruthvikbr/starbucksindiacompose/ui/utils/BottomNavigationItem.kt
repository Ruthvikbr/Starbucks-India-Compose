package com.ruthvikbr.starbucksindiacompose.ui.utils

import com.ruthvikbr.starbucksindiacompose.R

data class NavigationItem(
    val label:String,
    val icon:Int,
    val selectedIcon:Int,
    val route:String,
)

object BottomNavigationItems {
    val items = listOf(
        NavigationItem("Home", R.drawable.ic_star,R.drawable.ic_star_selected,Screen.Home.route),
        NavigationItem("Pay", R.drawable.ic_pay,R.drawable.ic_pay_selected,Screen.Pay.route),
        NavigationItem("Profile", R.drawable.ic_order,R.drawable.ic_order_selected,Screen.Order.route),
        NavigationItem("Settings", R.drawable.ic_gift,R.drawable.ic_gift_selected,Screen.Gift.route),
    )
}

