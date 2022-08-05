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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ruthvikbr.domain.models.DMNewsItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.*

@Composable
fun HomeScreen(navController: NavController) {
    val newsList = listOf(
        DMNewsItem(
            1,
            "FEATURED",
            "Irresistible Fruitilicious delights",
            R.drawable.news_item1,
            "Bringing you a delectable range of Fruit beverages!"
        ),
        DMNewsItem(
            2,
            "SPECIAL ANNOUNCEMENT",
            "Starbucks on Tata Cliq",
            R.drawable.news_item2,
            "An exquisite range of essentials from Starbucks*! \n Choose from the versatile collection"
        ),
        DMNewsItem(
            3,
            "FEATURED",
            "Grapiest Beverages at your nearest Starbucks",
            R.drawable.news_item3,
            "Bringing you a delectable range of Fruit beverages!"
        ),
        DMNewsItem(
            4,
            "MEMBER EXCLUSIVE",
            "Celebrate your special day",
            R.drawable.news_item4,
            "With the Starbucks-India mobile app now you can avail a free tall beverage of your choice for free in your birthday month at your nearest Starbucks"
        ),
        DMNewsItem(
            5,
            "FEATURED",
            "Coffee Heaven",
            R.drawable.news_item5,
            "Get the Mocha cookie crumble frappuccino at your doorstep via Zomato and Swiggy"
        )
    )
    Scaffold(floatingActionButton = {
        StarbucksFloatingActionButton(text = stringResource(id = R.string.join_now)) {

        }
    }) {


        StarbucksColumn {
            Header(title = stringResource(id = R.string.home_header_logged_out))
            ActionItemsRow()
            NewsSection(newsList)
        }
    }
}

@Composable
fun ActionItemsRow(isLoggedIn: Boolean = false) {

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
            modifier = Modifier.clickable {  }
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