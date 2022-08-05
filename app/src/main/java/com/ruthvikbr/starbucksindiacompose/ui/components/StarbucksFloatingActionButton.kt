package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksTypography

@Composable
fun StarbucksFloatingActionButton(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .clip(RoundedCornerShape(36.dp))
            .background(HouseGreen)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            ,
        style = StarbucksTypography.subtitle1.copy(color = Color.White),
    )
}

@Preview
@Composable
fun StarbucksFloatingActionButtonPreview() {
    StarbucksFloatingActionButton(text = stringResource(id = R.string.join_now)) {

    }
}