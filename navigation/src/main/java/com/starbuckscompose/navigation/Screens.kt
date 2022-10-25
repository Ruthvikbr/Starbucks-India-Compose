package com.starbuckscompose.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class StarbucksScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    object Dashboard : StarbucksScreen("dashboard")
    object Home : StarbucksScreen("home")
    object Profile : StarbucksScreen("profile")
    object Settings : StarbucksScreen("settings")
    object Order : StarbucksScreen("order")
    object OrderProcessing : StarbucksScreen("order_processing")
    object NewsScreen : StarbucksScreen(
        "news", listOf(
            navArgument("title") {
                type = NavType.StringType
            },
            navArgument("imageUrl") {
                type = NavType.StringType
            },
            navArgument("content") {
                type = NavType.StringType
            },
        )
    )
}

sealed class StarbucksRoute(val name: String) {
    object DashboardRoute : StarbucksRoute("dashboard_route")
    object DashboardBottomNavRoute : StarbucksRoute("dashboard_bottom_nav_route")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}