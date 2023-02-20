package com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun AuthButton(enabled: Boolean, text: String, onButtonClicked: () -> Unit) {
    Button(
        onClick = onButtonClicked,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(24.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = HouseGreen,
            disabledBackgroundColor = Color.DarkGray,
        ),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryWhite,
        )
    }
}
