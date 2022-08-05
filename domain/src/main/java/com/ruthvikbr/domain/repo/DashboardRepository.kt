package com.ruthvikbr.domain.repo

import com.ruthvikbr.domain.models.DMNewsItem
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    fun fetchNewsItems(): Flow<List<DMNewsItem>>
    fun checkIsUserLoggedIn(): Boolean
}