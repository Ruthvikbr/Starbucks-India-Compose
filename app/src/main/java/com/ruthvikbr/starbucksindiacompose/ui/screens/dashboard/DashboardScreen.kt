package com.ruthvikbr.starbucksindiacompose.ui.screens.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ruthvikbr.starbucksindiacompose.ui.bottomBarRoute
import com.ruthvikbr.starbucksindiacompose.ui.components.BottomNavigationBar
import com.ruthvikbr.starbucksindiacompose.ui.utils.BottomNavigationItems
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksRoute

@Composable
fun DashboardScreen(composeNavigator: ComposeNavigator) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigationBar(items = BottomNavigationItems.items, navController)
    }) {
        NavHost(
            navController = navController,
            startDestination = StarbucksRoute.DashboardBottomNavRoute.name,
            Modifier.padding(it),
        ) {
            bottomBarRoute(composeNavigator)
        }
    }
}
