package com.ruthvikbr.starbucksindiacompose.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.usecases.FetchCarouselItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchCarouselItemsUseCase: FetchCarouselItemsUseCase
) : ViewModel() {
    private val _carouselItemList = MutableStateFlow<Flow<List<DMCarouselItem>>>(emptyFlow())
    val carouselItemList = _carouselItemList.asStateFlow()

    init {
        fetchCarouselItems()
    }

    private fun fetchCarouselItems() {
        viewModelScope.launch {
            _carouselItemList.value = fetchCarouselItemsUseCase()
        }
    }

}