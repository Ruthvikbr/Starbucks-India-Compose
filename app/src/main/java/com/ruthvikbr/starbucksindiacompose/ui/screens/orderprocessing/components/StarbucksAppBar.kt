package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun StarbucksAppBar(
    onBackPressed: () -> Unit,
    title: String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(AccentGreen)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            tint = PrimaryWhite,
            contentDescription = "Go back",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onBackPressed()
                }
        )
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(0.9f),
            textAlign = TextAlign.Center
        )
    }
}
