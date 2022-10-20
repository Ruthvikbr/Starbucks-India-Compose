package com.ruthvikbr.starbucksindiacompose.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.ruthvikbr.starbucksindiacompose.ui.screens.dashboard.DashboardScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.NewsScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.OrderProcessing
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksRoute
import com.starbuckscompose.navigation.StarbucksScreen

fun NavGraphBuilder.dashboardRoute(composeNavigator: ComposeNavigator) {
    navigation(
        startDestination = StarbucksScreen.Dashboard.name,
        route = StarbucksRoute.DashboardRoute.name
    ) {
        composable(route = StarbucksScreen.Dashboard.name) {
            DashboardScreen(composeNavigator)
        }
        composable(route = StarbucksScreen.OrderProcessing.name) {
            OrderProcessing(composeNavigator)
        }
        composable(
            route = StarbucksScreen.NewsScreen.name
        ) {
            NewsScreen(composeNavigator)
        }
    }
}