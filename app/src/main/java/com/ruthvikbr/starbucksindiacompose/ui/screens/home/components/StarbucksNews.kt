package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.domain.models.DMSocialNewsItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent

@Composable
fun StarbucksNews(onNewsItemClicked: (String,String,String) -> Unit, newsList: List<DMSocialNewsItem>) {

    Column {
        SpacerComponent(spaceInDp = 16.dp)
        Text(
            text = stringResource(id = R.string.news_for_you),
            color = Color.Black,
            style = MaterialTheme.typography.h4
        )
        SpacerComponent(spaceInDp = 16.dp)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(newsList) { item ->
                NewsItem(
                    onNewsItemClicked = onNewsItemClicked,
                    title = item.newsTitle,
                    subTitle = item.newsContent,
                    imageUrl = item.imageUrl
                )
            }
        }
    }
}