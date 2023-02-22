package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.components.StarbucksTextField
import com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components.AuthButton
import com.ruthvikbr.starbucksindiacompose.ui.theme.DarkGray
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.ReferralCardBackground

@Composable
fun PersonalDetailsForm(
    firstName: String,
    lastName: String,
    birthday: String,
    referralCode: String,
    isSmsEnabled: Boolean,
    isEmailEnabled: Boolean,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onBirthdayChanged: (String) -> Unit,
    onReferralCodeChanged: (String) -> Unit,
    onReferralCodeSubmitted: () -> Unit,
    onSmsPreferenceChanged: (Boolean) -> Unit,
    onEmailPreferenceChanged: (Boolean) -> Unit,
    onSubmitClicked: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryWhite),
    ) {
        item {
            Header()
        }
        item {
            Form(
                firstName,
                lastName,
                birthday,
                referralCode,
                onFirstNameChanged,
                onLastNameChanged,
                onBirthdayChanged,
                onReferralCodeChanged,
                onReferralCodeSubmitted,
            )
        }
        item {
            PreferencesForm(
                isSmsEnabled = isSmsEnabled,
                isEmailEnabled = isEmailEnabled,
                onSmsPreferenceChanged = onSmsPreferenceChanged,
                onEmailPreferenceChanged = onEmailPreferenceChanged,
            )
        }
        item {
            Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
                AuthButton(
                    enabled = true,
                    text = stringResource(id = R.string.finish_sign_up),
                    onButtonClicked = onSubmitClicked,
                )
            }
            SpacerComponent(spaceInDp = 64.dp)
        }
    }
}

@Composable
fun Header() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.personal_details_form_title),
            color = PrimaryBlack,
            modifier = Modifier
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        SpacerComponent(spaceInDp = 24.dp)
        Divider(thickness = 1.5.dp, color = Color.DarkGray)
    }
}

@Composable
fun Form(
    firstName: String,
    lastName: String,
    birthday: String,
    referralCode: String,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onBirthdayChanged: (String) -> Unit,
    onReferralCodeChanged: (String) -> Unit,
    onReferralCodeSubmitted: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
        StarbucksTextField(
            value = firstName,
            placeholder = stringResource(id = R.string.firstname_hint),
            onValueChange = onFirstNameChanged,
            label = stringResource(id = R.string.firstname),
        )
        SpacerComponent(spaceInDp = 12.dp)
        StarbucksTextField(
            value = lastName,
            placeholder = stringResource(id = R.string.lastname_hint),
            onValueChange = onLastNameChanged,
            label = stringResource(id = R.string.lastname),
        )
        SpacerComponent(spaceInDp = 12.dp)
        StarbucksTextField(
            value = birthday,
            placeholder = stringResource(id = R.string.date_of_birth_hint),
            onValueChange = onBirthdayChanged,
            label = stringResource(id = R.string.birthdate),
            trailingIcon = {
                Icon(
                    Icons.Outlined.CalendarMonth,
                    contentDescription = stringResource(id = R.string.date_of_birth),
                    modifier = Modifier.size(24.dp).clickable { },
                    tint = HouseGreen,
                )
            },
        )
        SpacerComponent(spaceInDp = 8.dp)
        Text(
            text = stringResource(id = R.string.birthdate_info_text),
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryBlack,
        )
        SpacerComponent(spaceInDp = 24.dp)
        ReferralForm(
            referralCode = referralCode,
            onReferralCodeChanged = onReferralCodeChanged,
            onReferralCodeSubmitted = onReferralCodeSubmitted,
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReferralForm(
    referralCode: String,
    onReferralCodeChanged: (String) -> Unit,
    onReferralCodeSubmitted: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(ReferralCardBackground)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(id = R.string.got_a_referral_code),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        BasicTextField(
            value = referralCode,
            onValueChange = onReferralCodeChanged,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .drawBehind {
                    val borderWidth = 1.dp.toPx()
                    val y = size.height - borderWidth / 2
                    drawLine(
                        color = PrimaryBlack,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = borderWidth,
                    )
                },
            decorationBox = @Composable {
                TextFieldDefaults.TextFieldDecorationBox(
                    value = referralCode,
                    innerTextField = it,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = VisualTransformation.None,
                    interactionSource = MutableInteractionSource(),
                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                        0.dp,
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.referral_code_hint),
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Light,
                            color = Color.DarkGray,
                        )
                    },
                )
            },

        )
        Text(
            text = stringResource(id = R.string.enter_referral_code),
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryWhite,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(PrimaryBlack)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .clickable {
                    onReferralCodeSubmitted()
                },
        )
    }
}

@Composable
fun PreferencesForm(
    isSmsEnabled: Boolean,
    isEmailEnabled: Boolean,
    onSmsPreferenceChanged: (Boolean) -> Unit,
    onEmailPreferenceChanged: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth().background(PrimaryWhite)) {
        Text(
            text = stringResource(id = R.string.preferences_terms),
            color = PrimaryBlack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
        )
        SpacerComponent(spaceInDp = 24.dp)
        Divider(thickness = 1.dp, color = Color.LightGray)
        SpacerComponent(spaceInDp = 16.dp)
        Text(
            text = stringResource(id = R.string.where_shall_we_reach_you),
            style = MaterialTheme.typography.subtitle1,
            color = DarkGray,
            modifier = Modifier.padding(horizontal = 24.dp),
        )
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            StarbucksCheckbox(
                checked = isSmsEnabled,
                onCheckedChanged = onSmsPreferenceChanged,
                label = stringResource(
                    id = R.string.sms,
                ),
            )
            SpacerComponent(spaceInDp = 48.dp, isVerticalSpace = false)
            StarbucksCheckbox(
                checked = isEmailEnabled,
                onCheckedChanged = onEmailPreferenceChanged,
                label = stringResource(
                    id = R.string.email,
                ),
            )
        }
        Text(
            text = stringResource(id = R.string.agreement),
            style = MaterialTheme.typography.subtitle1,
            color = DarkGray,
            modifier = Modifier.padding(horizontal = 24.dp),
        )
        SpacerComponent(spaceInDp = 24.dp)
    }
}
