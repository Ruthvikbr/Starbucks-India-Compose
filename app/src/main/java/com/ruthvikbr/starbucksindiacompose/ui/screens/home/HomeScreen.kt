package com.ruthvikbr.starbucksindiacompose.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksColumn
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.components.CoffeeNews
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.components.OfferCarousel
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.components.PopularMenuItems
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.components.StarbucksNews
import com.ruthvikbr.starbucksindiacompose.ui.screens.home.components.Title
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksScreen
import java.net.URLEncoder

@Composable
fun HomeScreen(
    composeNavigator: ComposeNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val carouselList by viewModel.carouselItemList.collectAsState()
    val carouselItems by carouselList.collectAsState(initial = emptyList())

    val popularItemsList by viewModel.popularMenuItemsList.collectAsState()
    val popularItems by popularItemsList.collectAsState(initial = emptyList())

    val starbucksNewsList by viewModel.starbucksNewsItemsList.collectAsState()
    val starbucksNews by starbucksNewsList.collectAsState(initial = emptyList())

    StarbucksColumn {
        Title()
        OfferCarousel(items = carouselItems)
        PopularMenuItems(onMenuItemClicked = { itemName ->
            composeNavigator.navigate(StarbucksScreen.Order.route.plus("/$itemName"))
        }, popularMenuItems = popularItems)
        CoffeeNews { title, imageUrl, content ->
            composeNavigator.navigate(
                StarbucksScreen.NewsScreen.route
                    .plus("/$title/${URLEncoder.encode(imageUrl,"UTF-8")}/$content")
            )
        }
        StarbucksNews(onNewsItemClicked = { title, imageUrl, content ->
            composeNavigator.navigate(
                StarbucksScreen.NewsScreen.route
                    .plus("/$title/${URLEncoder.encode(imageUrl,"UTF-8")}/$content")
            )
        }, newsList = starbucksNews)
    }
}
