package com.ruthvikbr.starbucksindiacompose.ui.screens.profile.components

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
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreenSecondary
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun ProfileAppBar(
    onBackButtonClicked: () -> Unit,
    onNotificationsButtonClicked: () -> Unit,
    onSettingsButtonClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(HouseGreenSecondary),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Filled.KeyboardArrowLeft,
            contentDescription = "Back Button",
            Modifier.weight(1f).clickable { onBackButtonClicked() },
            tint = PrimaryWhite,
        )
        Text(
            text = "Account",
            Modifier.weight(3f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1.copy(
                color = PrimaryWhite,
                fontWeight = FontWeight.SemiBold,
            ),
        )
        Icon(
            Icons.Outlined.Notifications,
            contentDescription = "Notifications Button",
            Modifier.weight(0.5f).clickable { onNotificationsButtonClicked() },
            tint = PrimaryWhite,
        )
        Icon(
            Icons.Outlined.Settings,
            contentDescription = "Settings Button",
            Modifier.weight(0.5f).clickable { onSettingsButtonClicked() },
            tint = PrimaryWhite,
        )
    }
}
