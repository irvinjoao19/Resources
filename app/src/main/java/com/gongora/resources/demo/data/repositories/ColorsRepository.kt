package com.gongora.resources.demo.data.repositories

import com.gongora.resources.demo.domain.models.ColorCategory
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.tokens.Colors

/**
 * Repository interface for color tokens.
 * 
 * This interface defines the contract for accessing color tokens from the resources library,
 * following Clean Architecture principles by abstracting the data source.
 */
interface ColorsRepository {
    
    /**
     * Retrieves all color tokens organized by categories.
     * @return Map of color categories to their respective tokens
     */
    suspend fun getColorTokens(): Map<ColorCategory, List<ColorToken>>
}

/**
 * Implementation of ColorsRepository that accesses the resources library directly.
 * 
 * This implementation provides access to color tokens from the BCP resources library,
 * organizing them by categories for the demo application.
 */
class ColorsRepositoryImpl : ColorsRepository {
    
    override suspend fun getColorTokens(): Map<ColorCategory, List<ColorToken>> {
        return buildMap {
            put(ColorCategory.BRAND, createBrandColors())
            put(ColorCategory.NEUTRAL, createNeutralColors())
            put(ColorCategory.FUNCTIONAL, createFunctionalColors())
            put(ColorCategory.DECORATIVE, createDecorativeColors())
        }
    }
    
    /**
     * Creates brand color tokens (BCP Blue and Orange)
     */
    private fun createBrandColors(): List<ColorToken> = listOf(
        createColorTokens("brand.bcp_blue", Colors.Brand.BcpBlue, "BCP Blue", ColorCategory.BRAND),
        createColorTokens("brand.bcp_orange", Colors.Brand.BcpOrange, "BCP Orange", ColorCategory.BRAND)
    ).flatten()
    
    /**
     * Creates neutral color tokens (Gray, White, Black)
     */
    private fun createNeutralColors(): List<ColorToken> = listOf(
        createColorTokens("neutral.gray", Colors.Neutral.Gray, "Gray", ColorCategory.NEUTRAL),
        createSpecialTokens("neutral", Colors.Neutral, ColorCategory.NEUTRAL)
    ).flatten()
    
    /**
     * Creates functional color tokens (Green, Red, Yellow, Sky)
     */
    private fun createFunctionalColors(): List<ColorToken> = listOf(
        createColorTokens("functional.green", Colors.Functional.Green, "Green", ColorCategory.FUNCTIONAL),
        createColorTokens("functional.red", Colors.Functional.Red, "Red", ColorCategory.FUNCTIONAL),
        createColorTokens("functional.yellow", Colors.Functional.Yellow, "Yellow", ColorCategory.FUNCTIONAL),
        createColorTokens("functional.sky", Colors.Functional.Sky, "Sky", ColorCategory.FUNCTIONAL)
    ).flatten()
    
    /**
     * Creates decorative color tokens (Teal, Violet, Pink, Cyan, Lime)
     */
    private fun createDecorativeColors(): List<ColorToken> = listOf(
        createColorTokens("decorative.teal", Colors.Decorative.Teal, "Teal", ColorCategory.DECORATIVE),
        createColorTokens("decorative.violet", Colors.Decorative.Violet, "Violet", ColorCategory.DECORATIVE),
        createColorTokens("decorative.pink", Colors.Decorative.Pink, "Pink", ColorCategory.DECORATIVE),
        createColorTokens("decorative.cyan", Colors.Decorative.Cyan, "Cyan", ColorCategory.DECORATIVE),
        createColorTokens("decorative.lime", Colors.Decorative.Lime, "Lime", ColorCategory.DECORATIVE)
    ).flatten()
    
    /**
     * Creates color tokens for a specific color group using reflection
     */
    private fun createColorTokens(
        prefix: String,
        colorGroup: Any,
        displayName: String,
        category: ColorCategory
    ): List<ColorToken> {
        return try {
            val colorTokens = mutableListOf<ColorToken>()
            val fields = colorGroup.javaClass.declaredFields
            
            fields.forEach { field ->
                field.isAccessible = true
                val value = field.get(colorGroup) as? Int
                val fieldName = field.name
                
                if (value != null && fieldName.matches(Regex("\\w+\\d{3}"))) {
                    val shade = fieldName.takeLast(3)
                    val tokenKey = "$prefix.$shade"
                    val tokenName = "$displayName $shade"
                    
                    colorTokens.add(
                        ColorToken(tokenKey, value, tokenName, category)
                    )
                }
            }
            
            colorTokens.sortedBy { it.key }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    /**
     * Creates special tokens for colors that don't follow the standard naming pattern
     */
    private fun createSpecialTokens(
        prefix: String,
        colorGroup: Any,
        category: ColorCategory
    ): List<ColorToken> {
        return try {
            val colorTokens = mutableListOf<ColorToken>()
            val fields = colorGroup.javaClass.declaredFields
            
            fields.forEach { field ->
                field.isAccessible = true
                val value = field.get(colorGroup) as? Int
                val fieldName = field.name
                
                if (value != null && !fieldName.matches(Regex("\\w+\\d{3}"))) {
                    val tokenKey = "$prefix.$fieldName"
                    val tokenName = fieldName.replaceFirstChar { it.uppercase() } + " 100"
                    
                    colorTokens.add(
                        ColorToken(tokenKey, value, tokenName, category)
                    )
                }
            }
            
            colorTokens
        } catch (e: Exception) {
            emptyList()
        }
    }
}
