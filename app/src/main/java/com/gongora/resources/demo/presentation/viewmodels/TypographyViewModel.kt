package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.domain.usecases.GetTypographyStylesUseCase
import com.gongora.resources.demo.domain.models.TypographyStyle
import com.gongora.resources.tokens.Typography

/**
 * ViewModel for the typography screen.
 * This ViewModel follows Clean Architecture principles by providing typography data from BCP tokens.
 */
class TypographyViewModel : ViewModel() {
    
    private val getTypographyStylesUseCase = GetTypographyStylesUseCase()
    
    /**
     * Typography styles with sample text for demonstration using BCP design tokens.
     */
    val typographyStyles: List<TypographyStyle> = getTypographyStylesUseCase()
    
    /**
     * Font weights available in the BCP design system.
     */
    val fontWeights: Map<String, Int> = mapOf(
        "Thin (100)" to Typography.FontWeight.thin,
        "Light (300)" to Typography.FontWeight.light,
        "Regular (400)" to Typography.FontWeight.regular,
        "Medium (500)" to Typography.FontWeight.medium,
        "Demi (600)" to Typography.FontWeight.demi,
        "Bold (700)" to Typography.FontWeight.bold,
        "Heavy (800)" to Typography.FontWeight.heavy,
        "Black (900)" to Typography.FontWeight.black
    )
    
    /**
     * Font families available in the BCP design system.
     */
    val fontFamilies: Map<String, String> = mapOf(
        "Brand - Flexo" to "Fuente principal para títulos y elementos destacados",
        "Supportive - SourceSans3" to "Fuente de apoyo para contenido general"
    )
    
    /**
     * Line heights available in the BCP design system.
     */
    val lineHeights: Map<String, Float> = mapOf(
        "Small (16dp)" to Typography.LineHeight.small.toFloat(),
        "Medium (24dp)" to Typography.LineHeight.medium.toFloat(),
        "Large (28dp)" to Typography.LineHeight.large.toFloat(),
        "XLarge (32dp)" to Typography.LineHeight.xlarge.toFloat(),
        "2XLarge (40dp)" to Typography.LineHeight.x2large.toFloat()
    )
    
    /**
     * Font sizes available in the BCP design system.
     */
    val fontSizes: Map<String, Float> = mapOf(
        "XSmall (10sp)" to Typography.FontSize.xsmall.toFloat(),
        "Small (12sp)" to Typography.FontSize.small.toFloat(),
        "Regular (16sp)" to Typography.FontSize.regular.toFloat(),
        "Medium (20sp)" to Typography.FontSize.medium.toFloat(),
        "Large (24sp)" to Typography.FontSize.large.toFloat(),
        "XLarge (32sp)" to Typography.FontSize.xlarge.toFloat()
    )
    
    /**
     * Letter spacing available in the BCP design system.
     */
    val letterSpacing: Map<String, Float> = mapOf(
        "XSmall (-2dp)" to Typography.LetterSpacing.xsmall.toFloat(),
        "Small (-1dp)" to Typography.LetterSpacing.small.toFloat(),
        "None (0dp)" to Typography.LetterSpacing.none.toFloat()
    )
}
