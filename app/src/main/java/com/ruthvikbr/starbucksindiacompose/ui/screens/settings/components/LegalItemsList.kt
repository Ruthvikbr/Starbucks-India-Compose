package com.ruthvikbr.starbucksindiacompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ruthvikbr.starbucksindiacompose.R

@Composable
fun LegalItemsList(
    onTermsAndConditionsClicked: () -> Unit,
    onPrivacyPolicyClicked: () -> Unit,
) {
    Column {
        CmsItem(
            label = "Terms and Conditions",
            icon = R.drawable.ic_terms,
            onClick = onTermsAndConditionsClicked,
        )
        CmsItem(
            label = "Privacy Policy",
            icon = R.drawable.ic_privacy,
            onClick = onPrivacyPolicyClicked,
        )
    }
}
