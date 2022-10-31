package com.ruthvikbr.starbucksindiacompose.ui.screens.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val fetchPopularMenuItemsUseCase: FetchPopularMenuItemsUseCase
) : ViewModel() {

    private val _menuCategories = MutableStateFlow<Flow<List<DMPopularMenuItem>>>(emptyFlow())
    val menuCategories = _menuCategories.asStateFlow()

    var coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
        }

    init {
        fetchMenuCategories()
    }

    private fun fetchMenuCategories() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _menuCategories.value = fetchPopularMenuItemsUseCase()
        }
    }
}
