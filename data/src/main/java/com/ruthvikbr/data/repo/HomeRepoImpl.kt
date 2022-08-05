package com.ruthvikbr.data.repo

import com.ruthvikbr.domain.models.DMNewsItem
import com.ruthvikbr.domain.repo.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepoImpl():HomeRepository {
    override fun fetchNewsItems(): Flow<List<DMNewsItem>> {
        val newsList = listOf(
            DMNewsItem(
                1,
                "FEATURED",
                "Irresistible Fruitilicious delights",
                "https://iili.io/UHRSfV.jpg",
                "Bringing you a delectable range of Fruit beverages!"
            ),
            DMNewsItem(
                2,
                "SPECIAL ANNOUNCEMENT",
                "Starbucks on Tata Cliq",
                "https://iili.io/UH7hZb.jpg",
                "An exquisite range of essentials from Starbucks*! \n Choose from the versatile collection"
            ),
            DMNewsItem(
                3,
                "FEATURED",
                "Grapiest Beverages at your nearest Starbucks",
                "https://iili.io/UH7wnj.jpg",
                "Bringing you a delectable range of Fruit beverages!"
            ),
            DMNewsItem(
                4,
                "MEMBER EXCLUSIVE",
                "Celebrate your special day",
                "https://iili.io/UH7NMx.jpg",
                "With the Starbucks-India mobile app now you can avail a free tall beverage of your choice for free in your birthday month at your nearest Starbucks"
            ),
            DMNewsItem(
                5,
                "FEATURED",
                "Coffee Heaven",
                "https://iili.io/UH7O6Q.jpg",
                "Get the Mocha cookie crumble frappuccino at your doorstep via Zomato and Swiggy"
            )

        )
       return flow {
          emit(newsList)
       }
    }
}