package com.ruthvikbr.domain.usecases

import com.ruthvikbr.domain.repo.HomeRepository
import javax.inject.Inject

class FetchPopularMenuItemsUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    operator fun invoke() = homeRepository.fetchPopularMenuItems()
}
