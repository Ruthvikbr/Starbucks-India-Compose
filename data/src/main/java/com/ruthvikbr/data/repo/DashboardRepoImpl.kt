package com.ruthvikbr.data.repo

import com.ruthvikbr.domain.models.DMNewsItem
import com.ruthvikbr.domain.repo.DashboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DashboardRepoImpl():DashboardRepository {
    override fun fetchNewsItems(): Flow<List<DMNewsItem>> {
        val newsList = listOf(
            DMNewsItem(
                1,
                "FEATURED",
                "Irresistible Fruitilicious delights",
                1,
                "Bringing you a delectable range of Fruit beverages!"
            ),

        )
       return flow {
          emit(newsList)
       }
    }

    override fun checkIsUserLoggedIn(): Boolean {
        return false
    }
}