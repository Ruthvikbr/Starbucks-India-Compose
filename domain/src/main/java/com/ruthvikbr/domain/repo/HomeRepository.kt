package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun fetchCarouselItems(): Flow<List<DMCarouselItem>>
    fun fetchPopularMenuItems(): Flow<List<DMPopularMenuItem>>
}