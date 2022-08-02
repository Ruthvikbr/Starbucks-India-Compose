package com.ruthvikbr.starbucksindiacompose.ui.utils

sealed class Screen (val route:String){
    object DashboardScreen:Screen("dashboard_screen")
}