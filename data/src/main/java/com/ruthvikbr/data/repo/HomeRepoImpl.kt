package com.ruthvikbr.data.repo

import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.repo.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepoImpl():HomeRepository {
    override fun fetchCarouselItems(): Flow<List<DMCarouselItem>> {
        val dmCarouselItemList = listOf(
            DMCarouselItem(
                1,
                "Irresistible Fruitilicious delights",
                "https://iili.io/UHRSfV.jpg",
                "Bringing you a delectable range of Fruit beverages!"
            ),
            DMCarouselItem(
                2,
                "Starbucks on Tata Cliq",
                "https://iili.io/UH7hZb.jpg",
                "An exquisite range of essentials from Starbucks*! \n Choose from the versatile collection"
            ),
            DMCarouselItem(
                3,
                "Grapiest Beverages at your nearest Starbucks",
                "https://iili.io/UH7wnj.jpg",
                "Bringing you a delectable range of Fruit beverages!"
            ),
            DMCarouselItem(
                4,
                "Celebrate your special day",
                "https://iili.io/UH7NMx.jpg",
                "With the Starbucks-India mobile app now you can avail a free tall beverage of your choice for free in your birthday month at your nearest Starbucks"
            ),
            DMCarouselItem(
                5,
                "Coffee Heaven",
                "https://iili.io/UH7O6Q.jpg",
                "Get the Mocha cookie crumble frappuccino at your doorstep via Zomato and Swiggy"
            )

        )
       return flow {
          emit(dmCarouselItemList)
       }
    }
}