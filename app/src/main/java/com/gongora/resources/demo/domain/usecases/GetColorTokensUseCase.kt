package com.gongora.resources.demo.domain.usecases

import com.gongora.resources.demo.data.repositories.ColorsRepository
import com.gongora.resources.demo.domain.models.ColorCategory
import com.gongora.resources.demo.domain.models.ColorToken

/**
 * Use case for retrieving and organizing color tokens by categories.
 * 
 * This use case follows Clean Architecture principles by providing a clean interface
 * for the presentation layer to access color tokens from the resources library.
 */
class GetColorTokensUseCase(
    private val colorsRepository: ColorsRepository
) {
    
    /**
     * Executes the use case and returns color tokens organized by categories.
     * @return Map of color categories to their respective tokens
     */
    suspend operator fun invoke(): Map<ColorCategory, List<ColorToken>> {
        return colorsRepository.getColorTokens()
    }
}
