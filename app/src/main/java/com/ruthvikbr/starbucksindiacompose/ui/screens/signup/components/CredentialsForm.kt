package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksTextField
import com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components.AuthButton
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksGreen

@Composable
fun CredentialsForm(
    onSubmitClicked: () -> Unit,
    email: String,
    onEmailChanged: (String) -> Unit,
    mobile: String,
    onMobileChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChanged: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(id = R.string.login_to_starbucks),
            color = PrimaryBlack,
            modifier = Modifier
                .padding(horizontal = 24.dp),
            fontWeight = FontWeight.Bold,
        )
        SpacerComponent(spaceInDp = 24.dp)
        Divider(thickness = 1.5.dp, color = Color.DarkGray)
        Form(
            email = email,
            onEmailChanged = onEmailChanged,
            mobile = mobile,
            onMobileChanged = onMobileChanged,
            password = password,
            onPasswordChanged = onPasswordChanged,
            confirmPassword = confirmPassword,
            onConfirmPasswordChanged = onConfirmPasswordChanged,
            onSubmitClicked = onSubmitClicked,
        )
    }
}

@Composable
fun Form(
    email: String,
    onEmailChanged: (String) -> Unit,
    mobile: String,
    onMobileChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChanged: (String) -> Unit,
    onSubmitClicked: () -> Unit,
) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
    ) {
        StarbucksTextField(
            email,
            stringResource(id = R.string.email_hint),
            onValueChange = onEmailChanged,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
            ),
            label = stringResource(id = R.string.email_id),
        )
        SpacerComponent(spaceInDp = 16.dp)
        StarbucksTextField(
            password,
            stringResource(id = R.string.password_hint),
            onValueChange = onPasswordChanged,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = stringResource(id = R.string.create_password),
            trailingIcon = {
                Icon(
                    if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = stringResource(id = R.string.password_toggle_icon),
                    modifier = Modifier.size(20.dp)
                        .clickable { passwordVisible = !passwordVisible },
                    tint = HouseGreen,
                )
            },
        )
        PasswordFormatChips(password = password)
        SpacerComponent(spaceInDp = 16.dp)
        StarbucksTextField(
            confirmPassword,
            stringResource(id = R.string.confirm_password_hint),
            onValueChange = onConfirmPasswordChanged,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            visualTransformation = PasswordVisualTransformation(),
            label = stringResource(id = R.string.confirm_password),
        )
        SpacerComponent(spaceInDp = 16.dp)
        StarbucksTextField(
            mobile,
            stringResource(id = R.string.mobile_hint),
            onValueChange = onMobileChanged,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Phone,
            ),
            label = stringResource(id = R.string.mobile),
        )
        SpacerComponent(spaceInDp = 8.dp)
        Text(
            text = stringResource(id = R.string.otp_info),
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryBlack,
        )
        SpacerComponent(spaceInDp = 48.dp)
        AuthButton(
            enabled = true,
            text = stringResource(id = R.string.continue_btn),
            onButtonClicked = {
                onSubmitClicked()
            },
        )
    }
}

@Composable
fun PasswordFormatChips(password: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        FormatChip(
            text = stringResource(id = R.string.character_constraint),
            isValid = password.length >= 8,
        )
        SpacerComponent(spaceInDp = 16.dp, isVerticalSpace = false)
        FormatChip(
            text = stringResource(id = R.string.case_constraint),
            isValid = checkPassword(password, Regex("[A-Z]")),
        )
        SpacerComponent(spaceInDp = 16.dp, isVerticalSpace = false)
        FormatChip(
            text = stringResource(id = R.string.numeric_constraint),
            isValid = checkPassword(password, Regex("[0-9]")),
        )
        SpacerComponent(spaceInDp = 16.dp, isVerticalSpace = false)
        FormatChip(
            text = stringResource(id = R.string.symbolic_constraint),
            isValid = checkPassword(password, ".*[!@#\$%^&*+=/?].*".toRegex()),
        )
    }
}

@Composable
fun FormatChip(text: String, isValid: Boolean) {
    Text(
        text = text,
        style = MaterialTheme.typography.subtitle2,
        color = if (isValid) StarbucksGreen else Color.DarkGray,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(if (isValid) PrimaryWhite else SecondaryWhite)
            .border(
                1.dp,
                if (isValid) StarbucksGreen else PrimaryWhite,
                RoundedCornerShape(4.dp),
            )
            .padding(horizontal = 8.dp),
    )
}

fun checkPassword(password: String, regex: Regex): Boolean {
    return password.contains(regex)
}
