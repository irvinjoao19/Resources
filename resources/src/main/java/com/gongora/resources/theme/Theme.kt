package com.gongora.resources.theme

/**
 * Sistema de temas para el sistema de diseño BCP
 *
 * Define la estructura base para temas claros y oscuros,
 * incluyendo AliasTokens que mapean tokens de diseño a roles funcionales.
 *
 * **Estructura del tema:**
 * - **AliasTokens**: Tokens contextuales para roles funcionales
 * - **Colors**: Colores específicos del tema
 * - **Typography**: Configuración tipográfica del tema
 * - **Spacing**: Espaciado específico del tema
 * - **Border**: Configuración de bordes del tema
 * - **Effects**: Efectos visuales del tema
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
interface Theme {
    
    /**
     * Tokens de alias que mapean tokens de diseño a roles funcionales
     */
    val aliasTokens: AliasTokens
    
    /**
     * Colores específicos del tema
     */
    val colors: ThemeColors
    
    /**
     * Configuración tipográfica del tema
     */
    val typography: ThemeTypography
    
    /**
     * Espaciado específico del tema
     */
    val spacing: ThemeSpacing
    
    /**
     * Configuración de bordes del tema
     */
    val border: ThemeBorder
    
    /**
     * Efectos visuales del tema
     */
    val effects: ThemeEffects
}

/**
 * Tokens de alias para roles funcionales
 */
data class AliasTokens(
    // Surface tokens
    val surfacePrimary: Int,
    val surfaceSecondary: Int,
    val surfaceTertiary: Int,
    val surfaceQuaternary: Int,
    val surfaceInverse: Int,
    
    // Text tokens
    val textPrimary: Int,
    val textSecondary: Int,
    val textTertiary: Int,
    val textInverse: Int,
    val textDisabled: Int,
    
    // Border tokens
    val borderPrimary: Int,
    val borderSecondary: Int,
    val borderTertiary: Int,
    val borderInverse: Int,
    
    // Icon tokens
    val iconPrimary: Int,
    val iconSecondary: Int,
    val iconTertiary: Int,
    val iconInverse: Int,
    val iconDisabled: Int,
    
    // Interactive tokens
    val interactivePrimary: Int,
    val interactiveSecondary: Int,
    val interactiveTertiary: Int,
    val interactiveInverse: Int,
    val interactiveDisabled: Int,
    
    // Status tokens
    val statusSuccess: Int,
    val statusWarning: Int,
    val statusError: Int,
    val statusInfo: Int
)

/**
 * Colores específicos del tema
 */
data class ThemeColors(
    val primary: Int,
    val secondary: Int,
    val accent: Int,
    val background: Int,
    val surface: Int,
    val error: Int,
    val warning: Int,
    val success: Int,
    val info: Int
)

/**
 * Configuración tipográfica del tema
 */
data class ThemeTypography(
    val fontFamilyPrimary: String,
    val fontFamilySecondary: String,
    val fontSizeBase: Float,
    val lineHeightBase: Float
)

/**
 * Espaciado específico del tema
 */
data class ThemeSpacing(
    val base: Float,
    val small: Float,
    val medium: Float,
    val large: Float
)

/**
 * Configuración de bordes del tema
 */
data class ThemeBorder(
    val radiusSmall: Float,
    val radiusMedium: Float,
    val radiusLarge: Float,
    val widthThin: Float,
    val widthMedium: Float
)

/**
 * Efectos visuales del tema
 */
data class ThemeEffects(
    val elevationSmall: Float,
    val elevationMedium: Float,
    val elevationLarge: Float,
    val shadowColor: Int,
    val shadowAlpha: Float
)
