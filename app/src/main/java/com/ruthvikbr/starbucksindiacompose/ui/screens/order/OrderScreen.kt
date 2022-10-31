package com.ruthvikbr.starbucksindiacompose.ui.screens.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.ruthvikbr.data.repo.Constants
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.components.AppBar
import com.ruthvikbr.starbucksindiacompose.ui.screens.order.components.SeasonSpecialCard
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreenSecondary
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
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
        mutableStateOf("")
    }

    val menuCategoriesState by viewModel.menuCategories.collectAsState()
    val menuCategories by menuCategoriesState.collectAsState(initial = emptyList())

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
            TabsContent(pagerState = pagerState, menuCategories, activeIndex)
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
    activeCategory: String
) {
    HorizontalPager(state = pagerState, count = menuCategories.size) { _ ->
        when (activeCategory) {
            Constants.HOT_COFFEE -> TabContentScreen(data = "Welcome to Hot Coffee Screen")
            Constants.HOT_TEA -> TabContentScreen(data = "Welcome to Hot Tea Screen")
            Constants.HOT_BEVERAGES -> TabContentScreen(data = "Welcome to Hot Beverage Screen")
            Constants.COLD_COFFEE -> TabContentScreen(data = "Welcome to Cold Coffee Screen")
            Constants.COLD_BEVERAGES -> TabContentScreen(data = "Welcome to Cold Beverage Screen")
            Constants.FRAPPUCCINO -> TabContentScreen(data = "Welcome to Frappuccinno Screen")
            Constants.BOTTLED_DRINKS -> TabContentScreen(data = "Welcome to Bottled drinks Screen")
            Constants.BAKERY -> TabContentScreen(data = "Welcome to Bakery Screen")
            Constants.DESERTS -> TabContentScreen(data = "Welcome to Deserts Screen")
            Constants.SALADS -> TabContentScreen(data = "Welcome to Salads Screen")
            Constants.CROISSANT -> TabContentScreen(data = "Welcome to Croissant Screen")
        }
    }
}

@Composable
fun TabContentScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = data,
            style = MaterialTheme.typography.h5,
            color = AccentGreen,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
