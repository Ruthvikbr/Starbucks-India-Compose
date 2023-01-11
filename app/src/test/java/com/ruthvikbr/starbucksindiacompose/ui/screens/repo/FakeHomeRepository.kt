package com.ruthvikbr.starbucksindiacompose.ui.screens.repo

import com.ruthvikbr.domain.models.DMCarouselItem
import com.ruthvikbr.domain.models.DMPopularMenuItem
import com.ruthvikbr.domain.models.DMSocialNewsItem
import com.ruthvikbr.domain.repo.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeHomeRepository : HomeRepository {

    override fun fetchCarouselItems(): Flow<List<DMCarouselItem>> {
        return flowOf(
            listOf(
                DMCarouselItem(1, "Carousel1", "sample img", "Desc1"),
                DMCarouselItem(2, "Carousel2", "sample img", "Desc2"),
                DMCarouselItem(3, "Carousel3", "sample img", "Desc3"),
                DMCarouselItem(4, "Carousel4", "sample img", "Desc4")
            )
        )
    }

    override fun fetchPopularMenuItems(): Flow<List<DMPopularMenuItem>> {
        return flowOf(
            listOf(
                DMPopularMenuItem("Hot Coffee", "Sample img1"),
                DMPopularMenuItem("Hot Tea", "Sample img2"),
                DMPopularMenuItem("Cold Coffee", "Sample img3")
            )
        )
    }

    override fun fetchStarbucksNews(): Flow<List<DMSocialNewsItem>> {
        return flowOf(
            listOf(
                DMSocialNewsItem("Sample img1", "Starbucks news", "News Desc 1"),
                DMSocialNewsItem("Sample img2", "Starbucks news", "News Desc 2"),
                DMSocialNewsItem("Sample img3", "Starbucks news", "News Desc 3")
            )
        )
    }
}
