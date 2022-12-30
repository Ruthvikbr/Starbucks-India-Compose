package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing

import androidx.compose.foundation.background
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.BottomSheetComposable
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components.Checkout
import com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components.EmptyCheckoutScreen
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
            BottomSheetComposable(
                "Your order total is ${
                stringResource(
                    id = R.string.currency_symbol,
                    viewModel.calculateOrderTotal(cartItems).grandTotal
                )
                }",
                "Place Order"
            ) {
            }
        },
        sheetPeekHeight = 0.dp,
        modifier = Modifier.background(SecondaryWhite)
    ) {
        if (cartItems.isEmpty()) {
            EmptyCheckoutScreen {
                composeNavigator.navigateUp()
            }
        } else {
            Checkout(
                billSummary = viewModel.calculateOrderTotal(cartItems),
                cartItems = cartItems,
                onBackPressed = {
                    composeNavigator.navigateUp()
                },
                onCartItemCountUpdate = { item, action ->
                    coroutineScope.launch {
                        viewModel.updateOrderItem(item, action)
                    }
                }
            )
        }
    }
}
