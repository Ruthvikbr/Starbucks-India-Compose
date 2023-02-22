package com.ruthvikbr.starbucksindiacompose.ui.utils

sealed class LandingScreenBottomSheet {
    object LoginSheet : LandingScreenBottomSheet()
    object GetHelpSheet : LandingScreenBottomSheet()
}
