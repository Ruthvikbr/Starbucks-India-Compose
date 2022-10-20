package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest

@Composable
fun NewsItem(
    onNewsItemClicked: (String, String, String) -> Unit,
    title: String,
    subTitle: String,
    imageUrl: String
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp - 32

    Box(
        modifier = Modifier
            .width(screenWidth.dp)
            .height(300.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onNewsItemClicked(title, imageUrl, subTitle)
            },
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            model = rememberCoilImageRequest(data = imageUrl),
            contentDescription = "news item",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = title,
                color = PrimaryWhite,
                style = MaterialTheme.typography.h4
            )
            SpacerComponent(spaceInDp = 4.dp)
            Text(
                text = subTitle,
                color = PrimaryWhite,
                maxLines = 1,
                style = MaterialTheme.typography.subtitle1,
            )
            SpacerComponent(spaceInDp = 16.dp)
            Text(
                text = stringResource(id = R.string.learn_more),
                color = PrimaryWhite,
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .clickable {
                        onNewsItemClicked(title, imageUrl, subTitle)
                    }
                    .background(AccentGreen)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                style = MaterialTheme.typography.subtitle2
            )
            SpacerComponent(spaceInDp = 24.dp)
        }
    }
}