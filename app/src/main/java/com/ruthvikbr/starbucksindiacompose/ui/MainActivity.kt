package com.ruthvikbr.starbucksindiacompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.screens.Loader
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksIndiaComposeTheme
import com.starbuckscompose.navigation.ComposeNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var composeNavigator: ComposeNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_StarbucksIndiaCompose)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            LaunchedEffect(Unit) {
                composeNavigator.handleNavigationCommands(navController)
            }
            StarbucksIndiaComposeTheme {
               Loader()
            }
        }
    }
}
