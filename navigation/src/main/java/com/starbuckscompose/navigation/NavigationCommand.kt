package com.starbuckscompose.navigation

import androidx.navigation.NavOptions

sealed class NavigationCommand {
    object NavigateUp : NavigationCommand()
}

sealed class ComposeNavigationCommand : NavigationCommand() {
    data class NavigateToRoute(val route: String, val options: NavOptions? = null) :
        ComposeNavigationCommand()

    data class PopUpToRoute(val route: String, val inclusive: Boolean) : ComposeNavigationCommand()
}