package com.ruthvikbr.data.repo

import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.models.DMSocialNewsItem
import com.ruthvikbr.domain.repo.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepoImpl : HomeRepository {
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

    override fun fetchPopularMenuItems(): Flow<List<DMPopularMenuItem>> {
        val popularMenuItemsList = listOf(
            DMPopularMenuItem(
                "Hot coffee",
                "https://iili.io/ZNfI3X.png"
            ),
            DMPopularMenuItem(
                "Hot tea",
                "https://iili.io/ZNCcnR.png"
            ),
            DMPopularMenuItem(
                "Hot beverages",
                "https://iili.io/ZNoVhG.png"
            ),
            DMPopularMenuItem(
                "Cold coffee",
                "https://iili.io/ZNokv9.png"
            ),
            DMPopularMenuItem(
                "Cold beverages",
                "https://iili.io/ZNx3vt.png"
            ),
            DMPopularMenuItem(
                "Frappuccino",
                "https://iili.io/ZNxu87.png"
            ),
            DMPopularMenuItem(
                "Bottled drinks",
                "https://iili.io/ZNxXAF.png"
            ),
            DMPopularMenuItem(
                "Bakery",
                "https://iili.io/ZNxLP4.png"
            ),
            DMPopularMenuItem(
                "Desserts",
                "https://iili.io/ZNzIWJ.png"
            ),
            DMPopularMenuItem(
                "Salads",
                "https://iili.io/ZNzaRt.png"
            ),
            DMPopularMenuItem(
                "Packed foods",
                "https://iili.io/ZNzGsf.png"
            ),
            DMPopularMenuItem(
                "Croissant",
                "https://iili.io/ZNz6dB.png"
            )
        )
        return flow {
            emit(popularMenuItemsList)
        }
    }

    override fun fetchStarbucksNews(): Flow<List<DMSocialNewsItem>> {
        val starbucksNewsList = listOf(
            DMSocialNewsItem(
                "https://iili.io/t8XPbn.png",
                "Starbucks",
                "Tata Starbucks Private Limited has announced the launch of a new store in the capital city of Uttarakhand, Dehradun in September 2022. The new state entry demonstrates the company's commitment in strategically expanding its stores in India, where it now serves across 35 cities and 300 stores. Located at Rajpur road, the new store will offer the city’s residents with a new spot to connect over their favorite cup of coffee while experiencing the iconic Starbucks Experience.\n" +
                    "\n" +
                    "“Tata Starbucks has had an incredible journey in India, and we are honoured to celebrate our 10th year by creating a welcoming Third Place experience for Dehradun’s discerning customers and vibrant communities. As we expand into new markets, our goal is to provide every customer with the distinctive Starbucks experience.” said Sushant Dash, ceo, Tata Starbucks Pvt. Ltd.\n" +
                    "\n" +
                    "Inspired by Dehradun's heritage and local architecture, the overall ambience of both stores is rustic yet modern. The unique high ceiling and arched windows give the space a chalet like feel. The warm terracotta floor tiles and wall paneling playfully interacts with the light and shadow cast by the surrounding environment. The vibrant custom tapestry is a celebration of nature with delicate touches from flora and fauna of the coffee world.\n" +
                    "\n" +
                    "The new store will offer Starbucks signature beverages and food options including the all-time favourites such as Java Chip Frappuccino®, Cafe Mocha, Signature Hot Chocolate and Caramel Macchiato. Customers can also enjoy the limited-time Autumn offerings like Pumpkin Spice Latte, Pumkin Spice Frappuccino® and Hazelnut Mocha Cheesecake Frappuccino®, Hazelnut Mocha Cheesecake Latte and As an accompaniment to the array of coffee offerings, a range of delectable food items such as the Egg White & Chicken in Multigrain Croissant, Dutch Truffle Gateau, Red Velvet & Orange Cake, Chilli Cheese Toast, Basil Tomato & Mozzarella Cheese Sandwich, Butter Croissant, Kakori Kebab Wrap etc. can also be enjoyed by the customers.\n" +
                    "\n" +
                    "Exclusive Starbucks merchandise and free Wi-Fi is also available at the stores. In addition, the company will bring My Starbucks Rewards™ loyalty program to the city, which provides members with rewards and personalized benefits as they make Starbucks a part of their daily lives."
            ),
            DMSocialNewsItem(
                "https://iili.io/t8h0mX.png",
                "10th Year Anniversary",
                "Tata Starbucks is celebrating its 10th anniversary.\n" +
                    "\n" +
                    "After 10 years of brewing, serving, and creating the best possible coffee experience, Starbucks India celebrates its momentous 10th anniversary in India. Having built a strong community of customers and partners over the last decade, Starbucks India is certainly on a mission of growth and expansion to observe several more milestone moments.\n" +
                    "\n" +
                    "Commemorating this special occasion, Starbucks India invited its patrons to participate in the campaign #BrewYourOwnStarbucks. As an extension of their community culture, they aim to build a deeper connection with this initiative by shining the spotlight on their customers.\n" +
                    "\n" +
                    "Whether they take pride in being a coffee connoisseur, enjoy experimenting with their brews, or simply love a good cup of coffee, each customer was invited to craft their dream beverage. Building their own recipe, they were encouraged to share it with the brand and some were featured on the Starbucks India menu which you can spot in some of our stores."
            )
        )

        return flow {
            emit(starbucksNewsList)
        }
    }
}
