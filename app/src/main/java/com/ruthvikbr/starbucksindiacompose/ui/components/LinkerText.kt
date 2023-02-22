package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.ruthvikbr.starbucksindiacompose.ui.theme.DarkGray
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun LinkerText(
    primaryText: String,
    link: String,
    onLinkClicked: () -> Unit,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    isEnabled: Boolean = true,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$primaryText ",
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryBlack,
        )
        Text(
            text = link,
            style = MaterialTheme.typography.subtitle1,
            color = if (isEnabled) HouseGreen else DarkGray,
            modifier = Modifier.clickable {
                if (isEnabled) {
                    onLinkClicked()
                }
            },
            textDecoration = TextDecoration.Underline,
        )
    }
}
