package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.LinkerText
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components.AuthButton
import com.ruthvikbr.starbucksindiacompose.ui.theme.DarkGray
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksGreen
import com.ruthvikbr.starbucksindiacompose.ui.utils.secureMobileNNumber

@Composable
fun OtpVerification(mobileNumber: String, onConfirmClicked: () -> Unit) {
    var otp by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth().background(PrimaryWhite).padding(24.dp),
    ) {
        LinkerText(
            primaryText = stringResource(id = R.string.otp_sent),
            link = secureMobileNNumber(mobileNumber),
            onLinkClicked = {},
            horizontalArrangement = Arrangement.Start,
        )
        SpacerComponent(spaceInDp = 24.dp)
        Text(
            text = stringResource(id = R.string.otp_description),
            style = MaterialTheme.typography.subtitle1,
            color = DarkGray,
        )
        SpacerComponent(spaceInDp = 24.dp)
        OtpView(otp = otp, onOtpChange = {
            if (it.length <= 6) {
                otp = it
            }
        })
        SpacerComponent(spaceInDp = 36.dp)
        AuthButton(
            enabled = true,
            text = stringResource(id = R.string.confirm),
            onButtonClicked = onConfirmClicked,
        )
    }
}

@Composable
fun OtpView(otp: String, onOtpChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.enter_otp),
            style = MaterialTheme.typography.subtitle1,
            color = DarkGray,
        )
        SpacerComponent(spaceInDp = 12.dp)
        BasicTextField(
            value = otp,
            onValueChange = onOtpChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            decorationBox = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    repeat(6) { index ->
                        val char = when {
                            index >= otp.length -> ""
                            else -> otp[index].toString()
                        }
                        val isFocussed = otp.length == index
                        Text(
                            text = char,
                            modifier = Modifier
                                .width(50.dp)
                                .border(
                                    if (isFocussed) {
                                        2.dp
                                    } else {
                                        1.dp
                                    },
                                    if (isFocussed) {
                                        StarbucksGreen
                                    } else {
                                        DarkGray
                                    },
                                    RoundedCornerShape(8.dp),
                                )
                                .padding(vertical = 16.dp),
                            style = MaterialTheme.typography.h4,
                            color = StarbucksGreen,
                            textAlign = TextAlign.Center,
                        )
                        SpacerComponent(spaceInDp = 12.dp, isVerticalSpace = false)
                    }
                }
            },
        )
        SpacerComponent(spaceInDp = 16.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "${stringResource(id = R.string.time_remaining)} 0:59s",
                style = MaterialTheme.typography.subtitle1,
                color = DarkGray,
            )
            LinkerText(
                primaryText = stringResource(id = R.string.didnt_receive_otp),
                link = stringResource(id = R.string.resend),
                onLinkClicked = {},
                isEnabled = false,
                horizontalArrangement = Arrangement.End,
            )
        }
    }
}
