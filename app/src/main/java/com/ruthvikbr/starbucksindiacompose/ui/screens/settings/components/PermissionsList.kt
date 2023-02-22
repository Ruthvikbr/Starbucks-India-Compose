package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun PermissionsList(
    notificationsPermissionEnabled: Boolean,
    locationPermissionEnabled: Boolean,
    onNotificationAccessChanged: (Boolean) -> Unit,
    onLocationAccessChanged: (Boolean) -> Unit,
) {
    Column {
        PermissionItem(
            label = stringResource(id = R.string.notifications),
            selected = notificationsPermissionEnabled,
            onCheckedChange = onNotificationAccessChanged,
        )
        PermissionItem(
            label = stringResource(id = R.string.location),
            selected = locationPermissionEnabled,
            onCheckedChange = onLocationAccessChanged,
        )
    }
}

@Composable
fun PermissionItem(
    label: String,
    selected: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.h5,
            color = PrimaryBlack,
        )
        Switch(
            checked = selected,
            onCheckedChange = {
                onCheckedChange(it)
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = HouseGreen,
                checkedTrackAlpha = 1.0f,
                checkedThumbColor = PrimaryWhite,
            ),
        )
    }
}
