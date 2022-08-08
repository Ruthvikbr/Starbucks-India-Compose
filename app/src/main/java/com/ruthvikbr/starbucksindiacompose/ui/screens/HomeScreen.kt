package com.ruthvikbr.starbucksindiacompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ruthvikbr.domain.models.DMNewsItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.*
import com.ruthvikbr.starbucksindiacompose.ui.utils.Screen
import com.ruthvikbr.starbucksindiacompose.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

    val newsList by viewModel.newsItemList.collectAsState()
    val news by newsList.collectAsState(initial = emptyList())

    Scaffold(floatingActionButton = {
        StarbucksFloatingActionButton(text = stringResource(id = R.string.join_now)) {

        }
    }) {


        StarbucksColumn {
            Header(title = stringResource(id = R.string.home_header_logged_out))
            ActionItemsRow(navController = navController)
            NewsSection(news)
        }
    }
}

@Composable
fun ActionItemsRow(isLoggedIn: Boolean = false, navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isLoggedIn) {
                IconText(icon = Icons.Filled.Person, text = stringResource(id = R.string.profile))
            } else {
                IconText(icon = Icons.Filled.Person, text = stringResource(id = R.string.sign_in))
            }
            Spacer(modifier = Modifier.width(16.dp))
            IconText(icon = Icons.Filled.Email, text = stringResource(id = R.string.inbox))
        }
        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = stringResource(id = R.string.settings),
            modifier = Modifier.clickable {
                navController.navigate(Screen.Settings.route)
            }
        )
    }

}

@Composable
fun NewsSection(list: List<DMNewsItem>) {
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(list) { item ->
            NewsListItem(dmNewsItem = item) {

            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}