package com.ruthvikbr.starbucksindiacompose.ui.utils

sealed class RegistrationStage {
    object CredentialsStage : RegistrationStage()
    object OtpVerificationStage : RegistrationStage()
    object PersonalDetailsStage : RegistrationStage()
    object RegistrationSuccessStage : RegistrationStage()
}
