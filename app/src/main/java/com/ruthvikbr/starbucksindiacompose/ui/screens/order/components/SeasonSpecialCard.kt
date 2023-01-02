package com.ruthvikbr.starbucksindiacompose.ui.screens.order.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SpecialItemColor
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest

@Composable
fun SeasonSpecialCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(200.dp)
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(SpecialItemColor)
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = rememberCoilImageRequest(data = "https://iili.io/bKcFJ2.png"),
            contentDescription = "",
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier.fillMaxHeight().padding(vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = stringResource(id = R.string.seasonal_special),
                    style = MaterialTheme.typography.subtitle2,
                    color = PrimaryWhite
                )
                Text(
                    text = "Iced frappuccino",
                    style = MaterialTheme.typography.h4,
                    color = PrimaryWhite
                )
            }
            Row {
                Column {
                    Text(
                        text = stringResource(id = R.string.starting_from),
                        style = MaterialTheme.typography.subtitle2,
                        color = PrimaryWhite
                    )
                    Text(
                        text = stringResource(id = R.string.currency_symbol, 200),
                        style = MaterialTheme.typography.h5,
                        color = PrimaryWhite
                    )
                }
                SpacerComponent(
                    spaceInDp = 16.dp,
                    isVerticalSpace = false
                )
                Text(
                    text = stringResource(id = R.string.add_to_cart),
                    style = MaterialTheme.typography.subtitle1,
                    color = PrimaryBlack,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(PrimaryWhite)
                        .clickable {
                            // TODO: Add season special item to cart
                        }
                        .padding(
                            vertical = 8.dp,
                            horizontal = 16.dp
                        )
                )
            }
        }
    }
}
