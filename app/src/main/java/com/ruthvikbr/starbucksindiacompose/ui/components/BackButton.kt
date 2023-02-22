package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun BackButton(onBackButtonClicked: () -> Unit) {
    Icon(
        Icons.Filled.KeyboardArrowLeft,
        contentDescription = stringResource(id = R.string.back_button),
        tint = PrimaryBlack,
        modifier = Modifier.size(24.dp).clickable {
            onBackButtonClicked()
        },
    )
}
