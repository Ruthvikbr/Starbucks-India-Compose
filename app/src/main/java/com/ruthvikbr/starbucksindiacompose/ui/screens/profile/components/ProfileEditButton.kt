package com.ruthvikbr.starbucksindiacompose.ui.screens.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun ProfileEditButton(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            Icons.Outlined.Edit,
            contentDescription = "Edit button",
            modifier = Modifier.size(16.dp),
            tint = PrimaryWhite,
        )
    }
}
