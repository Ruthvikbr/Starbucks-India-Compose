package com.ruthvikbr.starbucksindiacompose.ui.screens.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.ruthvikbr.starbucksindiacompose.ui.components.BottomNavigationBar
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.HomeScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.OrderScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.profile.ProfileScreen
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.SettingsScreen
import com.ruthvikbr.starbucksindiacompose.ui.utils.BottomNavigationItems
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksRoute
import com.starbuckscompose.navigation.StarbucksScreen

@Composable
fun DashboardScreen(composeNavigator: ComposeNavigator) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigationBar(items = BottomNavigationItems.items, navController)
    }) {
        NavHost(
            navController = navController,
            startDestination = StarbucksRoute.DashboardBottomNavRoute.name,
            Modifier.padding(it)
        ) {
            navigation(
                startDestination = StarbucksScreen.Home.route,
                route = StarbucksRoute.DashboardBottomNavRoute.name
            ) {
                composable(StarbucksScreen.Home.route) {
                    HomeScreen(
                        composeNavigator
                    )
                }
                composable(StarbucksScreen.Order.route) {
                    OrderScreen(
                        composeNavigator
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
    }
}