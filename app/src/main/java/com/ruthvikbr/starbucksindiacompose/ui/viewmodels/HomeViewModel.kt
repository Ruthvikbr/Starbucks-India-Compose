package com.ruthvikbr.starbucksindiacompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruthvikbr.domain.models.DMNewsItem
import com.ruthvikbr.domain.usecases.FetchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel() {

    private val _newsItemList = MutableStateFlow<Flow<List<DMNewsItem>>>(emptyFlow())
    val newsItemList = _newsItemList.asStateFlow()


    init {
        fetchNews()
    }

    private fun fetchNews(){
        viewModelScope.launch {
            _newsItemList.value = fetchNewsUseCase()
        }
    }

}