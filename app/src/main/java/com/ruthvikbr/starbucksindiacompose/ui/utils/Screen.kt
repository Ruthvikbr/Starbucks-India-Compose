package com.ruthvikbr.starbucksindiacompose.ui.utils

sealed class Screen (val route:String){
    object Dashboard:Screen("dashboard")
    object Home:Screen("home")
    object Pay:Screen("pay")
    object Order:Screen("order")
    object Gift:Screen("gift")
    object Stores:Screen("stores")
    object Settings:Screen("settings")
}

sealed class Route(val route: String) {
    object Dashboard : Route("dashboardRoute")
}