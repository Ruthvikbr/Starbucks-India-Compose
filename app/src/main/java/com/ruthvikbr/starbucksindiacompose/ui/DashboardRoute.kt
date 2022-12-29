package com.ruthvikbr.starbucksindiacompose.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ruthvikbr.starbucksindiacompose.ui.screens.dashboard.DashboardScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.HomeScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.NewsScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.OrderScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.CheckoutScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.OrderProcessingScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.profile.ProfileScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.SettingsScreen
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksRoute
import com.starbuckscompose.navigation.StarbucksScreen

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.dashboardRoute(composeNavigator: ComposeNavigator) {
    navigation(
        startDestination = StarbucksScreen.Dashboard.name,
        route = StarbucksRoute.DashboardRoute.name
    ) {
        composable(route = StarbucksScreen.Dashboard.name) {
            DashboardScreen(composeNavigator)
        }
        composable(route = StarbucksScreen.OrderProcessing.name) {
            OrderProcessingScreen(composeNavigator)
        }
        composable(
            route = StarbucksScreen.NewsScreen.name
        ) {
            val title = it.arguments?.getString("title")
            val imageUrl = it.arguments?.getString("imageUrl")
            val content = it.arguments?.getString("content")

            NewsScreen(composeNavigator, title, imageUrl, content)
        }
        composable(route = StarbucksScreen.Checkout.name) {
            CheckoutScreen(composeNavigator = composeNavigator)
        }
        composable(route = StarbucksScreen.OrderProcessing.name) {
            OrderProcessingScreen(composeNavigator = composeNavigator)
        }
        bottomBarRoute(composeNavigator)
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
fun NavGraphBuilder.bottomBarRoute(composeNavigator: ComposeNavigator) {
    navigation(
        startDestination = StarbucksScreen.Home.route,
        route = StarbucksRoute.DashboardBottomNavRoute.name
    ) {
        composable(StarbucksScreen.Home.route) {
            HomeScreen(
                composeNavigator
            )
        }
        composable(StarbucksScreen.Order.name) { backStackEntry ->
            val selectedCategory = backStackEntry
                .arguments?.getString("selectedCategory")
            OrderScreen(
                composeNavigator,
                selectedCategory
            )
        }
        composable(StarbucksScreen.Profile.route) {
            ProfileScreen(
                composeNavigator
            )
        }
        composable(StarbucksScreen.Settings.route) {
            SettingsScreen(
                composeNavigator
            )
        }
    }
}
