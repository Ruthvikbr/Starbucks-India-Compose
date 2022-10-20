package com.ruthvikbr.domain.di

import com.ruthvikbr.domain.repo.HomeRepository
import com.ruthvikbr.domain.usecases.FetchCarouselItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import com.ruthvikbr.domain.usecases.FetchStarbucksNewsItemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideFetchCarouselItemsUseCase(homeRepository: HomeRepository) =
        FetchCarouselItemsUseCase(homeRepository)

    @Singleton
    @Provides
    fun provideFetchPopularMenuItemsItemsUseCase(homeRepository: HomeRepository) =
        FetchPopularMenuItemsUseCase(homeRepository)

    @Singleton
    @Provides
    fun provideFetchStarbucksNewsItemsUseCase(homeRepository: HomeRepository) =
        FetchStarbucksNewsItemsUseCase(homeRepository)
}