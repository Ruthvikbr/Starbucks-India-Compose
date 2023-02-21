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
import androidx.compose.ui.platform.LocalDensity
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.AppBar
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.CredentialsForm
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.OtpVerification
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.PersonalDetailsForm
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.RegistrationSuccess
import com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components.StepProgress
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.RegistrationStage
import com.starbuckscompose.navigation.ComposeNavigator

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
        mutableStateOf("6360151024")
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

    val density = LocalDensity.current

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

    val animationTime = 300
    val animationDelayTime = 700

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
                        durationMillis = animationTime,
                        easing = LinearEasing,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = animationTime,
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
                        durationMillis = animationTime,
                        easing = LinearEasing,
                        delayMillis = animationDelayTime,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = animationTime,
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
                        durationMillis = animationTime,
                        easing = LinearEasing,
                        delayMillis = animationDelayTime,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = animationTime,
                        easing = LinearEasing,
                    ),
                ),
            ) {
                PersonalDetailsForm(onSubmitClicked = {
                    currentRegistrationStep = RegistrationStage.RegistrationSuccessStage
                })
            }
            AnimatedVisibility(
                visible = currentRegistrationStep == RegistrationStage.RegistrationSuccessStage,
                enter = slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = animationTime,
                        easing = LinearEasing,
                        delayMillis = animationDelayTime,
                    ),
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = animationTime,
                        easing = LinearEasing,
                    ),
                ),
            ) {
                RegistrationSuccess(onSubmitClicked = {
                    currentRegistrationStep = RegistrationStage.RegistrationSuccessStage
                })
            }
        }
    }
}
