package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.BuildConfig
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.Grey
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun AppVersion() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(PrimaryWhite)
            .border(
                1.dp,
                PrimaryBlack.copy(alpha = 0.4f),
                RoundedCornerShape(4.dp),
            )
            .padding(
                horizontal = 12.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = R.string.starbucks_version),
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Light,
            color = Grey,
        )
        Text(text = BuildConfig.VERSION_NAME)
    }
}

@Preview
@Composable
fun AppVersionPreview() {
    AppVersion()
}
