package com.ruthvikbr.starbucksindiacompose.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ruthvikbr.starbucksindiacompose.ui.components.BottomNavigationBar
import com.ruthvikbr.starbucksindiacompose.ui.utils.BottomNavigationItems
import com.ruthvikbr.starbucksindiacompose.ui.utils.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    val bottomBarNavController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigationBar(items = BottomNavigationItems.items,bottomBarNavController)
    }) {
        NavHost(
            navController = bottomBarNavController,
            startDestination = Screen.Home.route,
            Modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navController
                )
            }
            composable(Screen.Pay.route) {
                PayScreen(
                    navController
                )
            }
            composable(Screen.Order.route) {
                OrderScreen(
                    navController
                )
            }
            composable(Screen.Gift.route) {
                GiftScreen(
                    navController
                )
            }
            composable(Screen.Stores.route) {
                StoresScreen(
                    navController
                )
            }
        }
    }
}

