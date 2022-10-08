package com.ruthvikbr.starbucksindiacompose.ui.screens.home.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import com.ruthvikbr.domain.models.DMPopularMenuItems

@Composable
fun PopularMenuItems(
    onMenuItemClicked: () -> Unit,
    popularMenuItems: List<DMPopularMenuItems>
) {
    LazyHorizontalGrid(rows = GridCells.Fixed(2)) {

    }
}

@Composable
fun PopularMenuItems(
    onMenuItemClicked: () -> Unit,
    popularMenuItems: DMPopularMenuItems
) {

}