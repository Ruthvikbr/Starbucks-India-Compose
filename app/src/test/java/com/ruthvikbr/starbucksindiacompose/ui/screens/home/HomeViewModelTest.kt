package com.ruthvikbr.starbucksindiacompose.ui.screens.home

import com.ruthvikbr.domain.usecases.FetchCarouselItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import com.ruthvikbr.domain.usecases.FetchStarbucksNewsItemsUseCase
import com.ruthvikbr.starbucksindiacompose.ui.screens.repo.FakeHomeRepository
import com.ruthvikbr.starbucksindiacompose.util.MainDispatcherRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val homeRepository = FakeHomeRepository()
    private val fetchCarouselItemsUseCase = FetchCarouselItemsUseCase(homeRepository)
    private val fetchStarbucksNewsItemsUseCase = FetchStarbucksNewsItemsUseCase(homeRepository)
    private val fetchPopularMenuItemsUseCase = FetchPopularMenuItemsUseCase(homeRepository)

    // Subject Under Test
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(
            fetchCarouselItemsUseCase,
            fetchPopularMenuItemsUseCase,
            fetchStarbucksNewsItemsUseCase
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun fetchCarouselItems_ReturnsListOfDMCarouselItems_onViewModelCreate() = runTest {
        assert(viewModel.popularMenuItemsList.first().first().isNotEmpty())
    }

    @Test
    fun fetchStarbucksNewsItems_ReturnsListOfDMStarbucksNewsItems_onViewModelCreate() = runTest {
        assert(viewModel.starbucksNewsItemsList.first().first().isNotEmpty())
    }

    @Test
    fun fetchPopularMenuListItems_ReturnsListOfDMPopularMenuItems_onViewModelCreate() = runTest {
        assert(viewModel.starbucksNewsItemsList.first().first().isNotEmpty())
    }
}
