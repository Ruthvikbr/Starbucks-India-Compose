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
        NavigationItem("Home", R.drawable.star,R.drawable.star_selected,Screen.Home.route),
        NavigationItem("Pay", R.drawable.pay,R.drawable.pay_selected,Screen.Pay.route),
        NavigationItem("Order", R.drawable.order,R.drawable.order_selected,Screen.Order.route),
        NavigationItem("Gift", R.drawable.gift,R.drawable.gift_selected,Screen.Gift.route),
        NavigationItem("Stores", R.drawable.stores,R.drawable.stores_selected,Screen.Stores.route),
    )
}

