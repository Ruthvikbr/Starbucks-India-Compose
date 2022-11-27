package com.ruthvikbr.starbucksindiacompose.ui.screens.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.ruthvikbr.data.repo.Constants
import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.usecases.UpdateOrderItemAction
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.components.AppBar
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.components.OrderItemCard
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.components.SeasonSpecialCard
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreenSecondary
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OrderScreen(
    composeNavigator: ComposeNavigator,
    selectedCategory: String?,
    viewModel: OrderViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState()
    var activeIndex by remember {
        mutableStateOf(Constants.HOT_COFFEE)
    }

    val coroutineScope = rememberCoroutineScope()

    val menuCategoriesState by viewModel.menuCategories.collectAsState()
    val menuCategories by menuCategoriesState.collectAsState(initial = emptyList())

    val orderItemsState by viewModel.orderItems.collectAsState()
    val orderItems by orderItemsState.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(HouseGreenSecondary)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppBar {
                composeNavigator.navigate(
                    StarbucksScreen.Home.route
                )
            }
            SeasonSpecialCard()
        }
        if (menuCategories.isNotEmpty()) {
            Tabs(pagerState = pagerState, menuCategories) {
                activeIndex = it
            }
            TabsContent(
                pagerState = pagerState,
                menuCategories,
                activeIndex,
                orderItems
            ) { orderItem, action ->
                coroutineScope.launch {
                    viewModel.updateOrderItem(orderItem, action)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    pagerState: PagerState,
    menuCategories: List<DMPopularMenuItem>,
    onTabSelected: (String) -> Unit
) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = HouseGreenSecondary,
        contentColor = PrimaryWhite,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = PrimaryWhite
            )
        }
    ) {
        menuCategories.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        text = menuCategories[index].label,
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                        onTabSelected(menuCategories[index].label)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(
    pagerState: PagerState,
    menuCategories: List<DMPopularMenuItem>,
    activeCategory: String,
    orderItems: List<DMOrderItem>,
    updateOrderItem: (DMOrderItem, UpdateOrderItemAction) -> Unit
) {
    HorizontalPager(state = pagerState, count = menuCategories.size) { _ ->
        TabContentScreen(orderItems = orderItems, activeCategory, updateOrderItem)
    }
}

@Composable
fun TabContentScreen(
    orderItems: List<DMOrderItem>,
    activeCategory: String,
    updateOrderItem: (DMOrderItem, UpdateOrderItemAction) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(SecondaryWhite)
            .padding(16.dp)
    ) {
        items(
            orderItems.filter {
                it.itemCategory == activeCategory
            }
        ) { item ->
            Column {
                SpacerComponent(spaceInDp = 8.dp)
                OrderItemCard(dmOrderItem = item, updateOrderItem)
                SpacerComponent(spaceInDp = 8.dp)
            }
        }
    }
}
