package com.ruthvikbr.starbucksindiacompose.ui.utils

sealed class Screen (val route:String){
    object Dashboard:Screen("dashboard")
    object Order:Screen("order")
    object Stores:Screen("stores")
    object Profile:Screen("profile")
    object Settings:Screen("settings")
}

sealed class Route(val route: String) {
    object Dashboard : Route("dashboardRoute")
}