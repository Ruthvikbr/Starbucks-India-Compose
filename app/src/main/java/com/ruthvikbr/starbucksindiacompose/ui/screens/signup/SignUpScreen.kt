package com.ruthvikbr.starbucksindiacompose.ui.screens.signup

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.AppBar
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.CredentialsForm
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.OtpVerification
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.PersonalDetailsForm
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.RegistrationSuccess
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.StepProgress
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.REGISTRATION_SCREEN_SLIDE_IN_ANIMATION
import com.ruthvikbr.starbucksindiacompose.ui.utils.REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION
import com.ruthvikbr.starbucksindiacompose.ui.utils.RegistrationStage
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignupScreen(composeNavigator: ComposeNavigator) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var mobileNumber by remember {
        mutableStateOf("")
    }

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var birthday by remember {
        mutableStateOf("")
    }

    var referralCode by remember {
        mutableStateOf("")
    }

    var isSmsEnabled by remember {
        mutableStateOf(false)
    }

    var isEmailEnabled by remember {
        mutableStateOf(false)
    }

    var currentRegistrationStep: RegistrationStage by remember {
        mutableStateOf(RegistrationStage.CredentialsStage)
    }

    val initialAppBarTitle = LocalContext.current.resources.getString(R.string.create_an_account)
    val personalDetailsAppBarTitle =
        LocalContext.current.resources.getString(R.string.personal_details)
    val otpVerificationAppBarTitle = LocalContext.current.resources.getString(R.string.verification)
    val registrationSuccessAppBarTitle =
        LocalContext.current.resources.getString(R.string.registration_success)

    var appBarTitle by remember {
        mutableStateOf(initialAppBarTitle)
    }

    var registrationStage by remember {
        mutableStateOf(1)
    }

    LaunchedEffect(key1 = currentRegistrationStep) {
        when (currentRegistrationStep) {
            RegistrationStage.CredentialsStage -> {
                appBarTitle = initialAppBarTitle
                registrationStage = 1
            }
            RegistrationStage.OtpVerificationStage -> {
                appBarTitle = otpVerificationAppBarTitle
                registrationStage = 2
            }
            RegistrationStage.PersonalDetailsStage -> {
                appBarTitle = personalDetailsAppBarTitle
                registrationStage = 3
            }
            RegistrationStage.RegistrationSuccessStage -> {
                appBarTitle = registrationSuccessAppBarTitle
                registrationStage = 4
            }
        }
    }

    Scaffold(
        topBar = {
            AppBar(
                title = appBarTitle,
                onBackClicked = {
                    composeNavigator.navigateUp()
                },
                backgroundColor = HouseGreen,
                backButtonVisible = currentRegistrationStep != RegistrationStage.RegistrationSuccessStage,
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(PrimaryWhite),
        ) {
            StepProgress(steps = 3, currentStep = registrationStage)
            AnimatedVisibility(
                visible = currentRegistrationStep == RegistrationStage.CredentialsStage,
                enter = slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                    ),
                ),
            ) {
                CredentialsForm(
                    onSubmitClicked = {
                        currentRegistrationStep = RegistrationStage.OtpVerificationStage
                    },
                    email = email,
                    onEmailChanged = { email = it },
                    mobile = mobileNumber,
                    onMobileChanged = { mobileNumber = it },
                    password = password,
                    onPasswordChanged = { password = it },
                    confirmPassword = confirmPassword,
                    onConfirmPasswordChanged = { confirmPassword = it },
                )
            }
            AnimatedVisibility(
                visible = currentRegistrationStep == RegistrationStage.OtpVerificationStage,
                enter = slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                        delayMillis = REGISTRATION_SCREEN_SLIDE_IN_ANIMATION,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                    ),
                ),
            ) {
                OtpVerification(mobileNumber, onConfirmClicked = {
                    currentRegistrationStep = RegistrationStage.PersonalDetailsStage
                })
            }
            AnimatedVisibility(
                visible = currentRegistrationStep == RegistrationStage.PersonalDetailsStage,
                enter = slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                        delayMillis = REGISTRATION_SCREEN_SLIDE_IN_ANIMATION,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                    ),
                ),
            ) {
                PersonalDetailsForm(
                    firstName = firstName,
                    lastName = lastName,
                    birthday = birthday,
                    referralCode = referralCode,
                    isSmsEnabled = isSmsEnabled,
                    isEmailEnabled = isEmailEnabled,
                    onFirstNameChanged = {
                        firstName = it
                    },
                    onLastNameChanged = {
                        lastName = it
                    },
                    onBirthdayChanged = {
                        birthday = it
                    },
                    onReferralCodeChanged = {
                        referralCode = it
                    },
                    onReferralCodeSubmitted = {},
                    onSmsPreferenceChanged = {
                        isSmsEnabled = it
                    },
                    onEmailPreferenceChanged = {
                        isEmailEnabled = it
                    },
                    onSubmitClicked = {
                        currentRegistrationStep = RegistrationStage.RegistrationSuccessStage
                    },
                )
            }
            AnimatedVisibility(
                visible = currentRegistrationStep == RegistrationStage.RegistrationSuccessStage,
                enter = slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                        delayMillis = REGISTRATION_SCREEN_SLIDE_IN_ANIMATION,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = REGISTRATION_SCREEN_SLIDE_OUT_ANIMATION,
                        easing = LinearEasing,
                    ),
                ),
            ) {
                RegistrationSuccess(
                    onSuccess = {
                        composeNavigator.navigate(StarbucksScreen.Dashboard.name)
                    },
                )
            }
        }
    }
}
