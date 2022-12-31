package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.usecases.DeleteCartItemsUseCase
import com.ruthvikbr.domain.usecases.FetchCartItemsUseCase
import com.ruthvikbr.domain.usecases.UpdateOrderItemAction
import com.ruthvikbr.domain.usecases.UpdateOrderItemUseCase
import com.ruthvikbr.starbucksindiacompose.ui.utils.BillSummary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val updateOrderItemUseCase: UpdateOrderItemUseCase,
    private val fetchCartItemsUseCase: FetchCartItemsUseCase,
    private val deleteCartItemsUseCase: DeleteCartItemsUseCase
) : ViewModel() {

    private val _cartItems = MutableStateFlow<Flow<List<DMOrderItem>>>(emptyFlow())
    val cartItems = _cartItems.asStateFlow()

    private var coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
        }

    init {
        fetchCartItems()
    }

    suspend fun updateOrderItem(
        dmOrderItem: DMOrderItem,
        updateOrderItemAction: UpdateOrderItemAction
    ) {
        viewModelScope.launch {
            updateOrderItemUseCase(dmOrderItem, updateOrderItemAction)
        }
    }

    private fun fetchCartItems() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _cartItems.value = fetchCartItemsUseCase()
        }
    }

    fun calculateOrderTotal(cartItems: List<DMOrderItem>): BillSummary {
        var subTotal = 0
        cartItems.map {
            subTotal += it.itemCount * it.itemPrice
        }
        val tax = (subTotal * 0.18).toInt()
        return BillSummary(subTotal, tax, tax + subTotal)
    }

    fun clearCart() {
        viewModelScope.launch {
            deleteCartItemsUseCase()
        }
    }
}
