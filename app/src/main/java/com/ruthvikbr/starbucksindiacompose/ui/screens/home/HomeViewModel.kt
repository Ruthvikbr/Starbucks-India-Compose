package com.ruthvikbr.starbucksindiacompose.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.models.DMSocialNewsItem
import com.ruthvikbr.domain.usecases.FetchCarouselItemsUseCase
import com.ruthvikbr.domain.usecases.FetchPopularMenuItemsUseCase
import com.ruthvikbr.domain.usecases.FetchStarbucksNewsItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
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
    private val fetchStarbucksNewsItemsUseCase: FetchStarbucksNewsItemsUseCase,
) : ViewModel() {
    private val _carouselItemList = MutableStateFlow<Flow<List<DMCarouselItem>>>(emptyFlow())
    val carouselItemList = _carouselItemList.asStateFlow()

    private val _popularMenuItemsList = MutableStateFlow<Flow<List<DMPopularMenuItem>>>(emptyFlow())
    val popularMenuItemsList = _popularMenuItemsList.asStateFlow()

    private val _starbucksNewsItemsList =
        MutableStateFlow<Flow<List<DMSocialNewsItem>>>(emptyFlow())
    val starbucksNewsItemsList = _starbucksNewsItemsList.asStateFlow()

    var coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
        }

    init {
        fetchCarouselItems()
        fetchPopularMenuItems()
        fetchStarbucksNewsItems()
    }

    private fun fetchCarouselItems() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _carouselItemList.value = fetchCarouselItemsUseCase()
        }
    }

    private fun fetchPopularMenuItems() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _popularMenuItemsList.value = fetchPopularMenuItemsUseCase()
        }
    }

    private fun fetchStarbucksNewsItems() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _starbucksNewsItemsList.value = fetchStarbucksNewsItemsUseCase()
        }
    }
}