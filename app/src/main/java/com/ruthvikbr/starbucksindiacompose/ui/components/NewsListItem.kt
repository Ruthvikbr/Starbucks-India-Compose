package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ruthvikbr.domain.models.DMNewsItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.*
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest

@Composable
fun NewsListItem(
    dmNewsItem: DMNewsItem,
    onItemClick: (dmNewsItem: DMNewsItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(LightGreen)
            .clickable {
                onItemClick(dmNewsItem)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = dmNewsItem.category, style = StarbucksTypography.h5.copy(color = HouseGreen))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = dmNewsItem.title,
                    style = StarbucksTypography.body2.copy(color = HouseGreen),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(text = stringResource(id = R.string.details),
                style = StarbucksTypography.subtitle1.copy(color = Color.White),
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .background(StarbucksGreen)
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .clickable {
                        onItemClick(dmNewsItem)
                    }
            )
        }
        AsyncImage(
            model = rememberCoilImageRequest(data = dmNewsItem.image),
            contentDescription = "",
            modifier = Modifier
                .weight(1f),
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview
@Composable
fun NewsListItemPreview() {
    val newsItem =
        DMNewsItem(
            1,
            "FEATURED",
            "Join the Starbucks family now!",
            "https://iili.io/UHRSfV.jpg",
            ""
        )
    NewsListItem(dmNewsItem = newsItem) {

    }
}