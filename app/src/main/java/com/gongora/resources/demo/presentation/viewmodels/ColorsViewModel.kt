package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.data.repositories.ColorsRepositoryImpl
import com.gongora.resources.demo.domain.models.ColorCategory
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.demo.domain.usecases.GetColorTokensUseCase
import kotlinx.coroutines.runBlocking

/**
 * ViewModel for the colors screen.
 * This ViewModel follows Clean Architecture principles by delegating business logic to use cases.
 */
class ColorsViewModel : ViewModel() {
    private val colorsRepository = ColorsRepositoryImpl()
    private val getColorTokensUseCase = GetColorTokensUseCase(colorsRepository)

    /**
     * Color tokens organized by categories.
     * This property provides access to all color tokens from the resources library,
     * organized by their respective categories (Brand, Neutral, Functional, Decorative).
     */
    val colorCategories: Map<ColorCategory, List<ColorToken>> = runBlocking {
        getColorTokensUseCase()
    }
}
