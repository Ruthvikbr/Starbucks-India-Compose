package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent

@Composable
fun CoffeeNews(onNewsItemClicked: (String, String, String) -> Unit) {
    Column(modifier = Modifier.background(Color.White)) {
        SpacerComponent(spaceInDp = 16.dp)
        Text(
            text = stringResource(id = R.string.news_headline),
            color = Color.Black,
            style = MaterialTheme.typography.h4
        )
        SpacerComponent(spaceInDp = 16.dp)
        NewsItem(
            onNewsItemClicked = onNewsItemClicked,
            imageUrl = "https://iili.io/t8OdvV.png",
            title = stringResource(id = R.string.news_title),
            subTitle = stringResource(id = R.string.news_subtitle)
        )
    }
}