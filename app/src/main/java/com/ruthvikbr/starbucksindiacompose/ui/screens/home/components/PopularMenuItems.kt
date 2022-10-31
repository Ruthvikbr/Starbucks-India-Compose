package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
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
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest

@Composable
fun PopularMenuItems(
    onMenuItemClicked: (String) -> Unit,
    popularMenuItems: List<DMPopularMenuItem>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SpacerComponent(spaceInDp = 16.dp)
        Text(
            text = stringResource(id = R.string.popular_menu_items),
            style = MaterialTheme.typography.h4,
            color = HouseGreen
        )
        SpacerComponent(spaceInDp = 16.dp)
        LazyHorizontalGrid(
            modifier = Modifier.height(250.dp),
            rows = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(popularMenuItems) { item ->
                PopularMenuItem(onMenuItemClicked = { onMenuItemClicked(item.label) }, popularMenuItem = item)
            }
        }
    }
}

@Composable
fun PopularMenuItem(
    onMenuItemClicked: () -> Unit,
    popularMenuItem: DMPopularMenuItem
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = rememberCoilImageRequest(data = popularMenuItem.imageUrl),
            contentDescription = popularMenuItem.label,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .clickable {
                    onMenuItemClicked()
                },
            contentScale = ContentScale.Fit
        )
        SpacerComponent(spaceInDp = 8.dp)
        Text(text = popularMenuItem.label, style = MaterialTheme.typography.subtitle1)
    }
}
