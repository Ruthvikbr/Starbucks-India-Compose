package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun News(onNewsItemClicked: () -> Unit) {
    Column(modifier = Modifier.background(Color.White)) {
        SpacerComponent(spaceInDp = 16.dp)
        Text(
            text = stringResource(id = R.string.news_headline),
            color = Color.Black,
            style = MaterialTheme.typography.h4
        )
        SpacerComponent(spaceInDp = 16.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    onNewsItemClicked()
                },
            contentAlignment = Alignment.BottomStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.coffee_bg),
                contentDescription = "news item",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = stringResource(id = R.string.news_title),
                    color = PrimaryWhite,
                    style = MaterialTheme.typography.h4
                )
                SpacerComponent(spaceInDp = 4.dp)
                Text(
                    text = stringResource(id = R.string.news_subtitle),
                    color = PrimaryWhite,
                    maxLines = 2,
                    style = MaterialTheme.typography.subtitle1
                )
                SpacerComponent(spaceInDp = 16.dp)
                Text(
                    text = stringResource(id = R.string.learn_more),
                    color = PrimaryWhite,
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .clickable { }
                        .background(AccentGreen)
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.subtitle2
                )
                SpacerComponent(spaceInDp = 24.dp)
            }
        }
    }
}