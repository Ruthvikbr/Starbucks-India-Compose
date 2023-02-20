package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OtpVerification(onSubmitClicked: () -> Unit) {
    Text(text = "Otp verification", modifier = Modifier.clickable { onSubmitClicked() })
}
