package com.starbuckscompose.navigation

import androidx.navigation.NamedNavArgument

sealed class StarbucksScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name:String = route.appendArguments(navArguments)

    object DashboardScreen : StarbucksScreen("dashboard")
    object OrderProcessingScreen : StarbucksScreen("order_processing_screen")
}

sealed class StarbucksRoute(val name:String){
    object Order : StarbucksRoute("order_route")
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