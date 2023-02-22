package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ruthvikbr.starbucksindiacompose.R

@Composable
fun AccountItemsList(
    onFeedbackClicked: () -> Unit,
    onChangePasswordClicked: () -> Unit,
    onRequestAccountDeletionClicked: () -> Unit,
) {
    Column {
        CmsItem(
            label = stringResource(id = R.string.feedback),
            icon = R.drawable.ic_chat,
            onClick = onFeedbackClicked,
        )
        CmsItem(
            label = stringResource(id = R.string.change_password),
            icon = R.drawable.ic_password,
            onClick = onChangePasswordClicked,
        )
        CmsItem(
            label = stringResource(id = R.string.request_account_deletion),
            icon = R.drawable.ic_account_delete,
            onClick = onRequestAccountDeletionClicked,
            leadingIconTint = Color.Red,
            textColor = Color.Red,
            arrowIconTint = Color.Red,
        )
    }
}
