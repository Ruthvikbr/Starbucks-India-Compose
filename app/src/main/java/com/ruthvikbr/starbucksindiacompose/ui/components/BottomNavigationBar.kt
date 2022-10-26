package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksTypography
import com.ruthvikbr.starbucksindiacompose.ui.theme.bottom_bar_background_color
import com.ruthvikbr.starbucksindiacompose.ui.theme.bottom_bar_text_color
import com.ruthvikbr.starbucksindiacompose.ui.utils.NavigationItem

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    navController: NavController
) {
    BottomNavigation(
        backgroundColor = bottom_bar_background_color
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = item.icon
                        ),
                        contentDescription = item.label,
                        modifier = Modifier.size(32.dp),
                        tint = if (isSelected) AccentGreen else Color.Black
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (isSelected) StarbucksGreen else bottom_bar_text_color,
                        style = StarbucksTypography.h6.copy(fontSize = 12.sp)
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
