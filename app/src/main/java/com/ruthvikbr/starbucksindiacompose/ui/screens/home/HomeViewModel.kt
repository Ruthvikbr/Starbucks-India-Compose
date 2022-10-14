package com.ruthvikbr.starbucksindiacompose.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.usecases.FetchCarouselItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchCarouselItemsUseCase: FetchCarouselItemsUseCase,
    private val fetchPopularMenuItemsUseCase: FetchPopularMenuItemsUseCase,
) : ViewModel() {
    private val _carouselItemList = MutableStateFlow<Flow<List<DMCarouselItem>>>(emptyFlow())
    val carouselItemList = _carouselItemList.asStateFlow()

    private val _popularMenuItemsList = MutableStateFlow<Flow<List<DMPopularMenuItem>>>(emptyFlow())
    val popularMenuItemsList = _popularMenuItemsList.asStateFlow()

    init {
        fetchCarouselItems()
        fetchPopularMenuItems()
    }

    private fun fetchCarouselItems() {
        viewModelScope.launch {
            _carouselItemList.value = fetchCarouselItemsUseCase()
        }
    }

    private fun fetchPopularMenuItems() {
        viewModelScope.launch {
            _popularMenuItemsList.value = fetchPopularMenuItemsUseCase()
        }
    }
}