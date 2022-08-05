package com.ruthvikbr.starbucksindiacompose.ui.route

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ruthvikbr.starbucksindiacompose.ui.screens.*
import com.ruthvikbr.starbucksindiacompose.ui.utils.Route
import com.ruthvikbr.starbucksindiacompose.ui.utils.Screen


fun NavGraphBuilder.dashboardRoute(navController: NavController) {
    navigation(startDestination = Screen.Dashboard.route, route = Route.Dashboard.route) {
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
    }
}
