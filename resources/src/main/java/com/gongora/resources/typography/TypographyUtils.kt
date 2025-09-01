package com.gongora.resources.typography

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.gongora.resources.fonts.Fonts
import com.gongora.resources.tokens.Typography

/**
 * Utilidades para trabajar con tipografía en el sistema de diseño BCP
 */
object TypographyUtils {
    
    /**
     * Obtiene la FontFamily de Flexo (Brand) según el peso especificado
     */
    fun getBrandFontFamily(weight: Int): FontFamily = when (weight) {
        Typography.FontWeight.thin -> Fonts.Brand.thin
        Typography.FontWeight.light -> Fonts.Brand.light
        Typography.FontWeight.regular -> Fonts.Brand.regular
        Typography.FontWeight.medium -> Fonts.Brand.medium
        Typography.FontWeight.demi -> Fonts.Brand.demi
        Typography.FontWeight.bold -> Fonts.Brand.bold
        Typography.FontWeight.heavy -> Fonts.Brand.heavy
        Typography.FontWeight.black -> Fonts.Brand.black
        else -> Fonts.Brand.regular
    }
    
    /**
     * Obtiene la FontFamily de Source Sans 3 (Supportive) según el peso especificado
     */
    fun getSupportiveFontFamily(weight: Int): FontFamily = when (weight) {
        Typography.FontWeight.thin -> Fonts.Supportive.thin
        Typography.FontWeight.light -> Fonts.Supportive.light
        Typography.FontWeight.regular -> Fonts.Supportive.regular
        Typography.FontWeight.medium -> Fonts.Supportive.medium
        Typography.FontWeight.demi -> Fonts.Supportive.demi
        Typography.FontWeight.bold -> Fonts.Supportive.bold
        Typography.FontWeight.heavy -> Fonts.Supportive.heavy
        Typography.FontWeight.black -> Fonts.Supportive.black
        else -> Fonts.Supportive.regular
    }
    
    /**
     * Obtiene la FontFamily según el nombre de la fuente
     */
    fun getFontFamily(fontName: String): FontFamily = when (fontName) {
        // Flexo - Brand
        Typography.FontFamily.Brand.thin -> Fonts.Brand.thin
        Typography.FontFamily.Brand.light -> Fonts.Brand.light
        Typography.FontFamily.Brand.regular -> Fonts.Brand.regular
        Typography.FontFamily.Brand.medium -> Fonts.Brand.medium
        Typography.FontFamily.Brand.demi -> Fonts.Brand.demi
        Typography.FontFamily.Brand.bold -> Fonts.Brand.bold
        Typography.FontFamily.Brand.heavy -> Fonts.Brand.heavy
        Typography.FontFamily.Brand.black -> Fonts.Brand.black
        
        // SourceSans3 - Supportive
        Typography.FontFamily.Supportive.thin -> Fonts.Supportive.thin
        Typography.FontFamily.Supportive.light -> Fonts.Supportive.light
        Typography.FontFamily.Supportive.regular -> Fonts.Supportive.regular
        Typography.FontFamily.Supportive.medium -> Fonts.Supportive.medium
        Typography.FontFamily.Supportive.demi -> Fonts.Supportive.demi
        Typography.FontFamily.Supportive.bold -> Fonts.Supportive.bold
        Typography.FontFamily.Supportive.heavy -> Fonts.Supportive.heavy
        Typography.FontFamily.Supportive.black -> Fonts.Supportive.black
        
        else -> Fonts.Supportive.regular // Fallback
    }
    
    /**
     * Mapea un peso numérico a FontWeight de Compose
     */
    fun mapToComposeFontWeight(weight: Int): FontWeight = when (weight) {
        Typography.FontWeight.thin -> FontWeight.Thin
        Typography.FontWeight.light -> FontWeight.Light
        Typography.FontWeight.regular -> FontWeight.Normal
        Typography.FontWeight.medium -> FontWeight.Medium
        Typography.FontWeight.demi -> FontWeight.SemiBold
        Typography.FontWeight.bold -> FontWeight.Bold
        Typography.FontWeight.heavy -> FontWeight.ExtraBold
        Typography.FontWeight.black -> FontWeight.Black
        else -> FontWeight.Normal
    }
}

