package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.LightGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksScreen

@Composable
fun OrderSuccessScreen(
    composeNavigator: ComposeNavigator,
    checkoutViewModel: CheckoutViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().background(LightGreen),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.qrcode),
            contentDescription = stringResource(id = R.string.qr_code_content_description),
            modifier = Modifier.size(250.dp)
        )
        SpacerComponent(spaceInDp = 24.dp)
        Text(
            text = stringResource(id = R.string.order_success_instruction_qr_code),
            style = MaterialTheme.typography.h4,
            color = PrimaryBlack,
            textAlign = TextAlign.Center
        )
        SpacerComponent(spaceInDp = 8.dp)
        Text(
            text = stringResource(id = R.string.order_success_instruction),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            color = PrimaryBlack
        )
        SpacerComponent(spaceInDp = 48.dp)
        Text(
            text = stringResource(id = R.string.order_success_btn_text),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(40.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AccentGreen)
                .clickable {
                    checkoutViewModel.clearCart()
                    composeNavigator.popUpTo(StarbucksScreen.Dashboard.route, false)
                }
                .wrapContentHeight(),
            textAlign = TextAlign.Center,
            color = PrimaryWhite
        )
    }
}
