package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.models.DMSocialNewsItem
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun fetchCarouselItems(): Flow<List<DMCarouselItem>>
    fun fetchPopularMenuItems(): Flow<List<DMPopularMenuItem>>
    fun fetchStarbucksNews(): Flow<List<DMSocialNewsItem>>
}
