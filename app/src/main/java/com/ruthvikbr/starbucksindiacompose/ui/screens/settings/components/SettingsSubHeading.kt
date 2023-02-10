package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun SettingsSubHeading(label: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h4,
            color = PrimaryBlack,
            fontWeight = FontWeight.Bold,
        )
        SpacerComponent(spaceInDp = 16.dp)
        Divider(thickness = 0.5.dp, color = PrimaryBlack.copy(alpha = 0.3f))
    }
}

@Preview
@Composable
fun SettingsSubHeadingPreview() {
    SettingsSubHeading(label = "App Permissions")
}
