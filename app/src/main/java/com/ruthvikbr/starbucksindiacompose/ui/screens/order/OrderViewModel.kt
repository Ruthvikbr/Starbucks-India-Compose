package com.ruthvikbr.starbucksindiacompose.ui.screens.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.usecases.FetchCartItemsUseCase
import com.ruthvikbr.domain.usecases.FetchOrderItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import com.ruthvikbr.domain.usecases.UpdateOrderItemAction
import com.ruthvikbr.domain.usecases.UpdateOrderItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val fetchPopularMenuItemsUseCase: FetchPopularMenuItemsUseCase,
    private val fetchOrderItemsUseCase: FetchOrderItemsUseCase,
    private val updateOrderItemUseCase: UpdateOrderItemUseCase,
    private val fetchCartItemsUseCase: FetchCartItemsUseCase
) : ViewModel() {

    private val _menuCategories = MutableStateFlow<Flow<List<DMPopularMenuItem>>>(emptyFlow())
    val menuCategories = _menuCategories.asStateFlow()

    private val _orderItems = MutableStateFlow<Flow<List<DMOrderItem>>>(emptyFlow())
    private val _activeCategoryIndex = MutableStateFlow(0)

    private val _activeTabItems = MutableStateFlow<Flow<List<DMOrderItem>>>(emptyFlow())
    val activeTabItems = _activeTabItems.asStateFlow()

    private val _cartItems = MutableStateFlow<Flow<List<DMOrderItem>>>(emptyFlow())
    val cartItems = _cartItems.asStateFlow()

    private var coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
        }

    init {
        fetchMenuCategories()
        fetchOrderItems()
        fetchCartItems()
    }

    private fun fetchMenuCategories() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _menuCategories.value = fetchPopularMenuItemsUseCase()
        }
    }

    private fun fetchOrderItems() {
        viewModelScope.launch(coroutineExceptionHandler) {
            val activeCategory = _menuCategories.value.first()[0].label
            _orderItems.value = fetchOrderItemsUseCase(activeCategory)
        }

        onActiveTabChanged(_activeCategoryIndex.value)
    }

    suspend fun updateOrderItem(dmOrderItem: DMOrderItem, updateOrderItemAction: UpdateOrderItemAction) {
        viewModelScope.launch {
            updateOrderItemUseCase(dmOrderItem, updateOrderItemAction)
        }
    }

    private fun fetchCartItems() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _cartItems.value = fetchCartItemsUseCase()
        }
    }

    fun onActiveTabChanged(activeIndex: Int) {
        viewModelScope.launch {
            _activeCategoryIndex.value = activeIndex
            val activeCategory = _menuCategories.value.first()[activeIndex].label

            _activeTabItems.value = fetchOrderItemsUseCase(activeCategory)
        }
    }
}
