package com.ruthvikbr.data.di

import com.ruthvikbr.data.repo.HomeRepoImpl
import com.ruthvikbr.domain.repo.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepo(): HomeRepository = HomeRepoImpl()
}