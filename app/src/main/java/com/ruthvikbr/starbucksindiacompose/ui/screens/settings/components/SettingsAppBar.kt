package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun SettingsAppBar(
    onBackButtonClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(PrimaryWhite),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Filled.KeyboardArrowLeft,
            contentDescription = stringResource(id = R.string.back_button),
            Modifier.weight(0.5f).clickable { onBackButtonClicked() },
            tint = PrimaryBlack,
        )
        Text(
            text = stringResource(id = R.string.settings),
            Modifier.weight(4f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1.copy(
                color = PrimaryBlack,
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}
