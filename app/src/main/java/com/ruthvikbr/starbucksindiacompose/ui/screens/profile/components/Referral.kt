package com.ruthvikbr.starbucksindiacompose.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.CoffeeColor
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.ReferralCardBackground

@Composable
fun Referral() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(ReferralCardBackground),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Refer and Earn Stars",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Starbucks is best when it's shared. Invite your loved ones and get one bonus star on each registraion.",
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            color = CoffeeColor,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = "Share invite code",
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryWhite,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(PrimaryBlack)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .clickable { },
        )
    }
}

@Preview
@Composable
fun ReferralCardPreview() {
    Referral()
}
