package com.ruthvikbr.domain.di

import com.ruthvikbr.domain.repo.HomeRepository
import com.ruthvikbr.domain.repo.OrderRepository
import com.ruthvikbr.domain.usecases.FetchCarouselItemsUseCase
import com.ruthvikbr.domain.usecases.FetchOrderItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import com.ruthvikbr.domain.usecases.FetchStarbucksNewsItemsUseCase
import com.ruthvikbr.domain.usecases.UpdateOrderItemUseCase
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

    @Singleton
    @Provides
    fun provideFetchOrderItemsUseCase(orderRepository: OrderRepository) =
        FetchOrderItemsUseCase(orderRepository)

    @Singleton
    @Provides
    fun provideUpdateOrderItemUseCase(orderRepository: OrderRepository) =
        UpdateOrderItemUseCase(orderRepository)
}
