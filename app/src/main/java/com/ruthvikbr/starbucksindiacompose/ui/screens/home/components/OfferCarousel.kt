package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OfferCarousel(items: List<DMCarouselItem>) {
    val pagerState = rememberPagerState(initialPage = 0)

    if (items.isNotEmpty()) {
        Column {
            Text(
                text = stringResource(id = R.string.latest_updates),
                style = MaterialTheme.typography.h4,
                color = HouseGreen
            )
            SpacerComponent(spaceInDp = 16.dp)
            HorizontalPager(
                count = items.size,
                state = pagerState
            ) { index ->
                CarouselItem(dmCarouselItem = items[index])
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    } else {
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun CarouselItem(dmCarouselItem: DMCarouselItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {}
    ) {
        AsyncImage(
            model = rememberCoilImageRequest(data = dmCarouselItem.image),
            contentDescription = "Starbucks Offer",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.FillBounds
        )
    }
}
