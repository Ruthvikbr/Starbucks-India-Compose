package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components.OrderBillSummary
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components.OrderSummary
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components.StarbucksAppBar
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.starbuckscompose.navigation.ComposeNavigator
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CheckoutScreen(
    composeNavigator: ComposeNavigator,
    viewModel: CheckoutViewModel = hiltViewModel()
) {
    val cartItemsState by viewModel.cartItems.collectAsState()
    val cartItems by cartItemsState.collectAsState(initial = emptyList())

    val coroutineScope = rememberCoroutineScope()

    val sheetState =
        rememberBottomSheetState(initialValue = if (cartItems.isEmpty()) BottomSheetValue.Collapsed else BottomSheetValue.Expanded)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    LaunchedEffect(key1 = cartItems) {
        if (cartItems.isEmpty()) {
            coroutineScope.launch {
                sheetState.collapse()
            }
        } else {
            coroutineScope.launch {
                sheetState.expand()
            }
        }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            PlaceOrder(viewModel.calculateOrderTotal(cartItems).grandTotal) {
            }
        },
        sheetPeekHeight = 0.dp,
        modifier = Modifier.background(SecondaryWhite)
    ) {
        if (cartItems.isEmpty()) {
            // TODO: move into a seperate composable
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Your cart is empty", style = MaterialTheme.typography.h4)
                SpacerComponent(spaceInDp = 8.dp)
                Text(
                    text = "Order now",
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(40.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(AccentGreen)
                        .wrapContentHeight()
                        .clickable {
                            composeNavigator.navigateUp()
                        },
                    textAlign = TextAlign.Center,
                    color = PrimaryWhite
                )
            }
        } else {
            // TODO: move into a seperate composable
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(SecondaryWhite)
            ) {
                StarbucksAppBar(title = "Checkout", onBackPressed = {
                    composeNavigator.navigateUp()
                })
                OrderSummary(cartItems = cartItems, onCartItemCountUpdate = { item, action ->
                    coroutineScope.launch {
                        viewModel.updateOrderItem(item, action)
                    }
                })
                OrderBillSummary(billSummary = viewModel.calculateOrderTotal(cartItems))
            }
        }
    }
}

// TODO: create a common composable
@Composable
fun PlaceOrder(grandTotal: Int, onCheckoutClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(PrimaryWhite)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Your order total is ${
            stringResource(
                id = R.string.currency_symbol,
                grandTotal
            )
            }",
            style = MaterialTheme.typography.subtitle2,
            color = PrimaryBlack,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Place Order",
            style = MaterialTheme.typography.subtitle2,
            color = PrimaryWhite,
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AccentGreen)
                .clickable {
                    onCheckoutClicked()
                }
                .wrapContentHeight(),
            textAlign = TextAlign.Center
        )
    }
}
