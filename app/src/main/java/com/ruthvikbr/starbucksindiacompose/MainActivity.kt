package com.ruthvikbr.starbucksindiacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ruthvikbr.starbucksindiacompose.ui.route.dashboardRoute
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksIndiaComposeTheme
import com.ruthvikbr.starbucksindiacompose.ui.utils.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_StarbucksIndiaCompose)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StarbucksIndiaComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = Route.Dashboard.route
                ) {
                    dashboardRoute(navController)
                }
            }
        }
    }
}
