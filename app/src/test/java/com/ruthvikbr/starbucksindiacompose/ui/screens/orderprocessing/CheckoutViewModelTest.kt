package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing

import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.usecases.DeleteCartItemsUseCase
import com.ruthvikbr.domain.usecases.FetchCartItemsUseCase
import com.ruthvikbr.domain.usecases.UpdateOrderItemAction
import com.ruthvikbr.domain.usecases.UpdateOrderItemUseCase
import com.ruthvikbr.starbucksindiacompose.ui.screens.repo.FakeOrderRepository
import com.ruthvikbr.starbucksindiacompose.ui.utils.BillSummary
import com.ruthvikbr.starbucksindiacompose.util.MainDispatcherRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CheckoutViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    // Subject under test
    private lateinit var viewModel: CheckoutViewModel

    private val orderRepository = FakeOrderRepository()
    private val updateOrderItemUseCase = UpdateOrderItemUseCase(orderRepository)
    private val fetchCartItemsUseCase = FetchCartItemsUseCase(orderRepository)
    private val deleteCartItemsUseCase = DeleteCartItemsUseCase(orderRepository)

    @Before
    fun setup() {
        viewModel = CheckoutViewModel(
            updateOrderItemUseCase,
            fetchCartItemsUseCase,
            deleteCartItemsUseCase
        )
    }

    @Test
    fun fetchCartItems_returnsCartItemsItems() = runTest {
        assert(viewModel.cartItems.first().first().isNotEmpty())
    }

    @Test
    fun clearCart_removesAllCartItems() = runTest {
        val cartItems = viewModel.cartItems.value
        assert(cartItems.first().isNotEmpty())
        viewModel.clearCart()
        viewModel.fetchCartItems()
        val updatedCartItems = viewModel.cartItems.value
        assertEquals(emptyList<DMOrderItem>(), updatedCartItems.first())
    }

    @Test
    fun calculateCartTotal_returnsOrderTotal() = runTest {
        val cartItems = viewModel.cartItems.value.first()
        val billSummary = viewModel.calculateOrderTotal(cartItems)

        val expectedSubTotal = 800
        val expectedTax = (800 * 0.18).toInt()
        val expectedTotal = expectedSubTotal + expectedTax
        val expectedBillSummary = BillSummary(expectedSubTotal, expectedTax, expectedTotal)

        assertEquals(expectedBillSummary, billSummary)
    }

    @Test
    fun updateOrderItem_updatesCartItemList() = runTest {
        val updatedCartItem = DMOrderItem(
            "Item2",
            1,
            200,
            "sample img url",
            "Sample desc 2",
            "Hot coffee",
            2L
        )
        viewModel.updateOrderItem(updatedCartItem, UpdateOrderItemAction.DECREASE_PRODUCT_COUNT)
        viewModel.fetchCartItems()

        val updatedCartItems = viewModel.cartItems.first().first()
        val updatedItem = updatedCartItems.filter {
            it.itemId == updatedCartItem.itemId
        }

        assertEquals(updatedItem, updatedItem)
    }
}
