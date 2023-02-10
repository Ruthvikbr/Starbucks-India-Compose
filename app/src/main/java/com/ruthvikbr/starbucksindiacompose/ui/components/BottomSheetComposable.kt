package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun BottomSheetComposable(
    primaryText: String,
    buttonText: String,
    onCheckoutClicked: () -> Unit,
    buttonEnabled: Boolean = true,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(PrimaryWhite)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = primaryText,
            style = MaterialTheme.typography.subtitle2,
            color = PrimaryBlack,
            textAlign = TextAlign.Center,
        )
        Text(
            text = buttonText,
            style = MaterialTheme.typography.subtitle2,
            color = PrimaryWhite,
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(16.dp))
                .alpha(if (buttonEnabled) 1f else ContentAlpha.disabled)
                .background(AccentGreen)
                .clickable(enabled = buttonEnabled) {
                    onCheckoutClicked()
                }
                .wrapContentHeight(),
            textAlign = TextAlign.Center,
        )
    }
}
