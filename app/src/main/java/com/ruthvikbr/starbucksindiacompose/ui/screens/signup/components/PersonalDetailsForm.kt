package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PersonalDetailsForm(onSubmitClicked: () -> Unit) {
    Text(text = "Personal Details", modifier = Modifier.clickable { onSubmitClicked() })
}
