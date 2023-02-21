package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun AppBar(
    onBackClicked: () -> Unit,
    title: String,
    backgroundColor: Color,
    backButtonVisible: Boolean = true,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(backgroundColor)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (backButtonVisible) {
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
        }
        Text(
            text = title,
            color = PrimaryWhite,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}
