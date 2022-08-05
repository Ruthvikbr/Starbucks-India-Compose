package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMNewsItem
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun fetchNewsItems(): Flow<List<DMNewsItem>>
}