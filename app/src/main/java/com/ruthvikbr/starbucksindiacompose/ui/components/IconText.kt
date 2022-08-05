package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksTypography

@Composable
fun IconText(icon: ImageVector, text: String) {
    Row( verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {  }) {
        Icon(icon, contentDescription = text, modifier = Modifier.size(24.dp))
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 10.dp),
            style = StarbucksTypography.body1
        )
    }
}

@Preview
@Composable
fun IconTextPreview() {
    IconText(icon = Icons.Filled.Person, text = stringResource(id = R.string.sign_in))
}