package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun CommunicationPreferencesList(
    smsEnabled: Boolean,
    emailEnabled: Boolean,
    onSmsPreferenceChanged: (Boolean) -> Unit,
    onEmailPreferenceChanged: (Boolean) -> Unit,
) {
    Column {
        SpacerComponent(spaceInDp = 12.dp)
        Text(
            text = stringResource(id = R.string.communication_preference_heading),
            style = MaterialTheme.typography.h5,
            color = PrimaryBlack,
            modifier = Modifier.fillMaxWidth(0.65f),
        )
        CommunicationPreference(
            label = stringResource(id = R.string.sms),
            checked = smsEnabled,
            onCheckedChanged = onSmsPreferenceChanged,
        )
        CommunicationPreference(
            label = stringResource(id = R.string.email),
            checked = emailEnabled,
            onCheckedChanged = onEmailPreferenceChanged,
        )
    }
}

@Composable
fun CommunicationPreference(label: String, checked: Boolean, onCheckedChanged: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h5,
            color = PrimaryBlack,
        )
        Checkbox(
            checked = checked,
            onCheckedChange = {
                onCheckedChanged(it)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = HouseGreen,
            ),
        )
    }
}
