package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.utils.QuickLoginModes

@Composable
fun QuickLoginList(
    selectedQuickLoginMode: QuickLoginModes,
    onLoginModeChange: (QuickLoginModes) -> Unit,
) {
    Column {
        QuickLoginMode(
            label = "Enable device lock",
            description = "Use your current device lock",
            selected = selectedQuickLoginMode == QuickLoginModes.BIOMETRIC,
            onLoginModeChange = onLoginModeChange,
            loginMode = QuickLoginModes.BIOMETRIC,
            icon = R.drawable.ic_fingerprint,
        )
        // TODO : 4 digit pin setup
        QuickLoginMode(
            label = "Set 4 digit pin",
            description = "Create a starbucks pin so that only you can access / Pay with your phone",
            selected = selectedQuickLoginMode == QuickLoginModes.DEVICE_PIN,
            onLoginModeChange = onLoginModeChange,
            loginMode = QuickLoginModes.DEVICE_PIN,
            icon = R.drawable.ic_pin,
        )
    }
}

@Composable
fun QuickLoginMode(
    label: String,
    description: String,
    selected: Boolean,
    onLoginModeChange: (QuickLoginModes) -> Unit,
    loginMode: QuickLoginModes,
    icon: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.h5,
                color = PrimaryBlack,
            )
            RadioButton(
                selected = selected,
                onClick = {
                    onLoginModeChange(loginMode)
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = HouseGreen,
                ),
            )
        }
        Row {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Finger Print Icon",
            )
            SpacerComponent(spaceInDp = 8.dp, isVerticalSpace = false)
            Text(
                text = description,
                style = MaterialTheme.typography.subtitle1,
                color = PrimaryBlack,
                modifier = Modifier.fillMaxWidth(0.65f),
            )
        }
    }
}
