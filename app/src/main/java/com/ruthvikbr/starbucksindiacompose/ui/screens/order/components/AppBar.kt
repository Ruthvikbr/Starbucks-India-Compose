package com.ruthvikbr.starbucksindiacompose.ui.screens.order.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun AppBar(onBackClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            contentDescription = "",
            tint = PrimaryWhite,
            modifier = Modifier
                .fillMaxWidth(0.1f)
                .clickable {
                    onBackClicked()
                },
        )
        Text(
            text = stringResource(id = R.string.order_screen),
            color = PrimaryWhite,
            modifier = Modifier.fillMaxWidth(0.8f),
            textAlign = TextAlign.Center,
        )
    }
}
