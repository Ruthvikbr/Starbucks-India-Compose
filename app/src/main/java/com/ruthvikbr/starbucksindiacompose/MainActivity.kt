package com.ruthvikbr.starbucksindiacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ruthvikbr.starbucksindiacompose.ui.screens.DashboardScreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksIndiaComposeTheme
import com.ruthvikbr.starbucksindiacompose.ui.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_StarbucksIndiaCompose)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StarbucksIndiaComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.DashboardScreen.route
                ) {
                    composable(Screen.DashboardScreen.route) {
                        DashboardScreen(navController = navController)
                    }
                }
            }
        }
    }
}
