package com.ruthvikbr.starbucksindiacompose.ui.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components.GetHelpBottomSheet
import com.ruthvikbr.starbucksindiacompose.ui.screens.landing.components.LoginBottomSheet
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreenSecondary
import com.ruthvikbr.starbucksindiacompose.ui.theme.LightGreen
import com.ruthvikbr.starbucksindiacompose.ui.utils.LandingScreenBottomSheet
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LandingScreen(composeNavigator: ComposeNavigator) {
    var currentBottomSheet: LandingScreenBottomSheet? by remember {
        mutableStateOf(LandingScreenBottomSheet.LoginSheet)
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    val closeSheet: () -> Unit = {
        scope.launch {
            scaffoldState.bottomSheetState.collapse()
        }
    }

    val openSheet: (LandingScreenBottomSheet) -> Unit = {
        currentBottomSheet = it
        scope.launch { scaffoldState.bottomSheetState.expand() }
    }

    BottomSheetScaffold(
        sheetPeekHeight = 0.dp,
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            currentBottomSheet?.let { currentSheet ->
                SheetLayout(
                    currentSheet,
                    closeSheet,
                    { openSheet(LandingScreenBottomSheet.GetHelpSheet) },
                    { composeNavigator.navigate(StarbucksScreen.SignUp.route) },
                )
            }
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Image(
                painter = painterResource(id = R.drawable.landing),
                contentDescription = stringResource(id = R.string.landing_img),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 100.dp)
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(LightGreen),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = stringResource(id = R.string.start_login_btn),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            openSheet(currentBottomSheet ?: LandingScreenBottomSheet.LoginSheet)
                        },
                    tint = HouseGreenSecondary,
                )
            }
        }
    }
}

@Composable
fun SheetLayout(
    currentScreen: LandingScreenBottomSheet,
    onCloseBottomSheet: () -> Unit,
    onGetHelpClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    when (currentScreen) {
        LandingScreenBottomSheet.LoginSheet -> LoginBottomSheet(
            onGetHelpClicked = onGetHelpClicked,
            onSignUpClicked = onSignUpClicked,
        )
        LandingScreenBottomSheet.GetHelpSheet -> GetHelpBottomSheet(onCloseBottomSheet)
    }
}
