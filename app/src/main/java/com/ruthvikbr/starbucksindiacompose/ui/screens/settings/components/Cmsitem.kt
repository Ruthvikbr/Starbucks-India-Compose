package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@Composable
fun CmsItem(
    label: String,
    icon: Int,
    onClick: () -> Unit,
    leadingIconTint: Color = HouseGreen,
    textColor: Color = PrimaryBlack,
    arrowIconTint: Color = HouseGreen,
) {
    Column(
        modifier = Modifier.fillMaxWidth().clickable {
            onClick()
        },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(60.dp)
                .clickable { },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label.uppercase(),
                tint = leadingIconTint,
                modifier = Modifier.size(16.dp),
            )
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.h5,
                color = textColor,
                modifier = Modifier.weight(2f).padding(horizontal = 16.dp),
            )
            Icon(
                Icons.Filled.KeyboardArrowRight,
                contentDescription = label,
                tint = arrowIconTint,
            )
        }
        Divider(color = Color.Gray, thickness = 0.5.dp)
    }
}
