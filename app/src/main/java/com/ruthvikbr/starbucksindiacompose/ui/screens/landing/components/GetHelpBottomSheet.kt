package com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.BackButton
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksTextField
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun GetHelpBottomSheet(onBackButtonClicked: () -> Unit) {
    var username by remember {
        mutableStateOf("")
    }
    var dateOfBirth by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.65f)
            .background(PrimaryWhite)
            .padding(24.dp),
    ) {
        BackButton(onBackButtonClicked)
        SpacerComponent(spaceInDp = 8.dp)
        Text(text = stringResource(id = R.string.get_help), style = MaterialTheme.typography.h2, color = PrimaryBlack)
        SpacerComponent(spaceInDp = 4.dp)
        Text(
            text = stringResource(id = R.string.get_help_description),
            style = MaterialTheme.typography.body1,
            color = PrimaryBlack,
            modifier = Modifier.fillMaxWidth(0.85f),
        )
        SpacerComponent(spaceInDp = 32.dp)
        StarbucksTextField(
            username,
            stringResource(id = R.string.username_hint),
            onValueChange = {
                username = it
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            label = stringResource(id = R.string.username),
        )
        SpacerComponent(spaceInDp = 24.dp)
        StarbucksTextField(
            dateOfBirth,
            stringResource(id = R.string.date_of_birth_hint),
            onValueChange = {
                dateOfBirth = it
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            visualTransformation = PasswordVisualTransformation(),
            label = stringResource(id = R.string.date_of_birth),
        )
        SpacerComponent(spaceInDp = 48.dp)
        AuthButton(enabled = true, text = stringResource(id = R.string.reset_password), onButtonClicked = {})
    }
}
