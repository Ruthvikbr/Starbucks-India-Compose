package com.ruthvikbr.starbucksindiacompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StarbucksApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}