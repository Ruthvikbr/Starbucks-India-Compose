package com.ruthvikbr.starbucksindiacompose.ui.screens.order

import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.usecases.FetchCartItemsUseCase
import com.ruthvikbr.domain.usecases.FetchOrderItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import com.ruthvikbr.domain.usecases.UpdateOrderItemUseCase
import com.ruthvikbr.starbucksindiacompose.ui.screens.repo.FakeHomeRepository
import com.ruthvikbr.starbucksindiacompose.ui.screens.repo.FakeOrderRepository
import com.ruthvikbr.starbucksindiacompose.util.MainDispatcherRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OrderViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    // Subject under test
    private lateinit var viewModel: OrderViewModel

    private val orderRepository = FakeOrderRepository()
    private val homeRepository = FakeHomeRepository()

    private val fetchPopularMenuItemsUseCase = FetchPopularMenuItemsUseCase(homeRepository)
    private val fetchOrderItemsUseCase = FetchOrderItemsUseCase(orderRepository)
    private val updateOrderItemUseCase = UpdateOrderItemUseCase(orderRepository)
    private val fetchCartItemsUseCase = FetchCartItemsUseCase(orderRepository)

    @Before
    fun setup() {
        viewModel = OrderViewModel(
            fetchPopularMenuItemsUseCase,
            fetchOrderItemsUseCase,
            updateOrderItemUseCase,
            fetchCartItemsUseCase
        )
    }

    @Test
    fun fetchMenuCategories_returnsMenuCategoryItems() = runTest {
        assert(viewModel.menuCategories.first().first().isNotEmpty())
    }

    @Test
    fun fetchOrderItems_returnsActiveTabMenuItems() = runTest {
        viewModel.fetchOrderItems("Hot coffee")
        assertEquals(
            mutableListOf(
                DMOrderItem(
                    "Item1",
                    0,
                    200,
                    "sample img url",
                    "Sample desc 1",
                    "Hot coffee",
                    1L
                ),
                DMOrderItem(
                    "Item2",
                    2,
                    200,
                    "sample img url",
                    "Sample desc 2",
                    "Hot coffee",
                    2L
                )
            ),
            viewModel.orderItems.first().first()
        )
    }

    @Test
    fun fetchCartItems_returnsCartItems() = runTest {
        assert(viewModel.cartItems.first().first().isNotEmpty())
    }
}
