package com.ruthvikbr.starbucksindiacompose.di

import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksComposeNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideComposeNavigator(starbucksComposeNavigator: StarbucksComposeNavigator): ComposeNavigator {
        return starbucksComposeNavigator
    }
}