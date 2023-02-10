package com.ruthvikbr.starbucksindiacompose.ui.screens.profile.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun Logout(onLogoutButtonClicked: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp).background(PrimaryWhite)
            .clickable {
                onLogoutButtonClicked()
            }.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logout),
            contentDescription = "Logout Button",
            modifier = Modifier.size(16.dp),
            tint = Color.Red,
        )
        Text(
            text = "LOGOUT",
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Normal),
            color = Color.Red,
            modifier = Modifier.weight(2f).padding(horizontal = 16.dp),
        )
    }
}
