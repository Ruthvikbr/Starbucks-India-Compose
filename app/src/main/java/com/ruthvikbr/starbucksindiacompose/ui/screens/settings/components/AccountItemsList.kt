package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ruthvikbr.starbucksindiacompose.R

@Composable
fun AccountItemsList(
    onFeedbackClicked: () -> Unit,
    onChangePasswordClicked: () -> Unit,
    onRequestAccountDeletionClicked: () -> Unit,
) {
    Column {
        CmsItem(
            label = "Feedback",
            icon = R.drawable.ic_chat,
            onClick = onFeedbackClicked,
        )
        CmsItem(
            label = "Change Password",
            icon = R.drawable.ic_password,
            onClick = onChangePasswordClicked,
        )
        CmsItem(
            label = "Request Account Deletion",
            icon = R.drawable.ic_account_delete,
            onClick = onRequestAccountDeletionClicked,
            leadingIconTint = Color.Red,
            textColor = Color.Red,
            arrowIconTint = Color.Red,
        )
    }
}
