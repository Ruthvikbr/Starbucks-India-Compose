package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ruthvikbr.starbucksindiacompose.R

@Composable
fun LegalItemsList(
    onTermsAndConditionsClicked: () -> Unit,
    onPrivacyPolicyClicked: () -> Unit,
) {
    Column {
        CmsItem(
            label = stringResource(id = R.string.terms_conditions),
            icon = R.drawable.ic_terms,
            onClick = onTermsAndConditionsClicked,
        )
        CmsItem(
            label = stringResource(id = R.string.privacy_policy),
            icon = R.drawable.ic_privacy,
            onClick = onPrivacyPolicyClicked,
        )
    }
}
