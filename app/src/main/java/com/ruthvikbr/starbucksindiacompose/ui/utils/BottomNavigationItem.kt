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
        NavigationItem("Order", R.drawable.ic_order,R.drawable.ic_order_selected,Screen.Order.route),
        NavigationItem("Gift", R.drawable.ic_gift,R.drawable.ic_gift_selected,Screen.Gift.route),
        NavigationItem("Stores", R.drawable.ic_stores,R.drawable.ic_stores_selected,Screen.Stores.route),
    )
}

