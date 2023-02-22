package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun StarbucksCheckbox(
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    label: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                onCheckedChanged(it)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = HouseGreen,
            ),
            modifier = Modifier.size(48.dp).clip(RoundedCornerShape(8.dp)),
        )
        SpacerComponent(spaceInDp = 4.dp, isVerticalSpace = false)
        Text(
            text = label,
            style = MaterialTheme.typography.h5,
            color = PrimaryBlack,
        )
    }
}
