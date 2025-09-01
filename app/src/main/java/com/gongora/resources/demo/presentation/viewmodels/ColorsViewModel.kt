package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.domain.models.ColorCategory
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.demo.domain.usecases.GetColorTokensUseCase
import com.gongora.resources.tokens.Colors

/**
 * ViewModel for the colors screen.
 * This ViewModel follows Clean Architecture principles by delegating business logic to use cases.
 */
class ColorsViewModel : ViewModel() {
    private val getColorTokensUseCase = GetColorTokensUseCase()
    
    /**
     * Color tokens organized by categories.
     */
    val colorCategories: Map<ColorCategory, List<ColorToken>> = getColorTokensUseCase().also { categories ->
        // Debug: verificar que se obtuvieron todas las categorías
        println("DEBUG ViewModel: Total categories: ${categories.size}")
        categories.forEach { (category, colors) ->
            println("DEBUG ViewModel: ${category.name} -> ${colors.size} colors")
        }
        
        // Debug: verificar que se pueden acceder a los colores de la librería
        try {
            println("DEBUG ViewModel: Testing Colors.Brand.BcpBlue.blue500 = ${Colors.Brand.BcpBlue.blue500}")
            println("DEBUG ViewModel: Testing Colors.Neutral.Gray.gray500 = ${Colors.Neutral.Gray.gray500}")
            println("DEBUG ViewModel: Testing Colors.Functional.Green.green500 = ${Colors.Functional.Green.green500}")
            println("DEBUG ViewModel: Testing Colors.Decorative.Teal.teal500 = ${Colors.Decorative.Teal.teal500}")
        } catch (e: Exception) {
            println("DEBUG ViewModel: ERROR accessing colors: ${e.message}")
            e.printStackTrace()
        }
    }
}
