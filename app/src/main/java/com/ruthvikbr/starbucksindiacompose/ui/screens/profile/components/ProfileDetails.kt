package com.ruthvikbr.starbucksindiacompose.ui.screens.profile.components

import ProfilePicture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun ProfileDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        ProfilePicture()
        SpacerComponent(spaceInDp = 16.dp)
        Text(text = "Ruthvik B.R", style = MaterialTheme.typography.h2, color = PrimaryWhite)
        SpacerComponent(spaceInDp = 4.dp)
        Text(
            text = "Welcome Tier",
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Normal),
            color = PrimaryWhite,
        )
        SpacerComponent(spaceInDp = 16.dp)
    }
}
