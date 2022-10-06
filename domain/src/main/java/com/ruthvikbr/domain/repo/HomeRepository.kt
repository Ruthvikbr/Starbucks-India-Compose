package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMCarouselItem
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun fetchCarouselItems(): Flow<List<DMCarouselItem>>
}