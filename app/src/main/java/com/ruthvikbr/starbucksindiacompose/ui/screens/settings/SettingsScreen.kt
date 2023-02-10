package com.ruthvikbr.starbucksindiacompose.ui.screens.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.components.AppVersion
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.AccountItemsList
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.CommunicationPreferencesList
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.LegalItemsList
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.PermissionsList
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.QuickLoginList
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.SettingsAppBar
import com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components.SettingsSubHeading
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.QuickLoginModes
import com.starbuckscompose.navigation.ComposeNavigator

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun SettingsScreen(composeNavigator: ComposeNavigator) {
    var isNotificationsPermissionSelected by remember {
        mutableStateOf(true)
    }

    var isLocationPermissionSelected by remember {
        mutableStateOf(false)
    }

    var isSmsCommunicationEnabled by remember {
        mutableStateOf(false)
    }

    var isEmailCommunicationEnabled by remember {
        mutableStateOf(false)
    }

    var selectedQuickLoginMode by remember {
        mutableStateOf(QuickLoginModes.BIOMETRIC)
    }

    Scaffold(
        topBar = {
            SettingsAppBar {
                composeNavigator.navigateUp()
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(PrimaryWhite)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                SettingsSubHeading(label = "App permissions")
                PermissionsList(
                    notificationsPermissionEnabled = isNotificationsPermissionSelected,
                    locationPermissionEnabled = isLocationPermissionSelected,
                    onNotificationAccessChanged = {
                        isNotificationsPermissionSelected = it
                    },
                    onLocationAccessChanged = {
                        isLocationPermissionSelected = it
                    },
                )
            }
            item {
                SettingsSubHeading(label = "Preferences & Terms")
                CommunicationPreferencesList(
                    smsEnabled = isSmsCommunicationEnabled,
                    emailEnabled = isEmailCommunicationEnabled,
                    onSmsPreferenceChanged = {
                        isSmsCommunicationEnabled = it
                    },
                    onEmailPreferenceChanged = {
                        isEmailCommunicationEnabled = it
                    },
                )
            }
            item {
                SettingsSubHeading(label = "Quick Login")
                QuickLoginList(
                    selectedQuickLoginMode = selectedQuickLoginMode,
                    onLoginModeChange = {
                        selectedQuickLoginMode = it
                    },
                )
            }
            item {
                SettingsSubHeading(label = "Legal")
                LegalItemsList(
                    onTermsAndConditionsClicked = {},
                    onPrivacyPolicyClicked = {},
                )
                SpacerComponent(spaceInDp = 16.dp)
            }
            item {
                SettingsSubHeading(label = "Account")
                AccountItemsList(
                    onFeedbackClicked = { },
                    onChangePasswordClicked = { },
                    onRequestAccountDeletionClicked = { },
                )
            }
            item {
                SpacerComponent(spaceInDp = 32.dp)
                AppVersion()
                SpacerComponent(spaceInDp = 128.dp)
            }
        }
    }
}
