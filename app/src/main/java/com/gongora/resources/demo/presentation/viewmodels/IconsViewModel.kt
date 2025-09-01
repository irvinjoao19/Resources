package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.domain.models.IconToken
import com.gongora.resources.demo.domain.usecases.GetIconsUseCase

/**
 * ViewModel for the icons screen.
 * This ViewModel follows Clean Architecture principles by delegating business logic to use cases.
 */
class IconsViewModel : ViewModel() {
    private val getIconsUseCase = GetIconsUseCase()
    
    /**
     * Icon tokens organized by categories.
     */
    val iconCategories: Map<String, List<IconToken>> = getIconsUseCase().also { categories ->
        // Debug: verificar que se obtuvieron todas las categorías
        println("DEBUG IconsViewModel: Total categories: ${categories.size}")
        categories.forEach { (category, icons) ->
            println("DEBUG IconsViewModel: $category -> ${icons.size} icons")
        }
    }
}
