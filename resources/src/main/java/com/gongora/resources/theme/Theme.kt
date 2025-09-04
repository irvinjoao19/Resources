package com.gongora.resources.theme

import androidx.compose.ui.graphics.Color

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
 * Tokens de alias para roles funcionales - Estructura completa equivalente a React Native
 */
data class AliasTokens(
    val surface: SurfaceTokens,
    val text: TextTokens,
    val border: BorderTokens,
    val icon: IconTokens,
    val effects: EffectsTokens
)

// ===== SURFACE TOKENS =====

data class SurfaceTokens(
    val static: StaticSurfaceTokens,
    val interactive: InteractiveSurfaceTokens
)

data class StaticSurfaceTokens(
    val regular: RegularSurfaceTokens,
    val semantic: SemanticSurfaceTokens
)

data class RegularSurfaceTokens(
    val flat: FlatSurfaceTokens,
    val gradient: GradientSurfaceTokens
)

data class FlatSurfaceTokens(
    val brand: Int,
    val primary: Int,
    val secondary: Int,
    val tertiary: Int,
    val onDarkSoft: Int
)

data class GradientSurfaceTokens(
    val glassStart: Int,
    val glassEnd: Int
)

data class SemanticSurfaceTokens(
    val success: Int,
    val successSoft: Int,
    val error: Int,
    val errorSoft: Int,
    val information: Int,
    val informationSoft: Int,
    val warning: Int,
    val warningSoft: Int
)

data class InteractiveSurfaceTokens(
    val base: BaseInteractiveTokens,
    val contrast: ContrastInteractiveTokens
)

data class BaseInteractiveTokens(
    val regular: RegularInteractiveTokens,
    val danger: DangerInteractiveTokens
)

data class ContrastInteractiveTokens(
    val regular: RegularInteractiveTokens,
    val danger: DangerInteractiveTokens
)

data class RegularInteractiveTokens(
    val primary: InteractiveStateTokens,
    val secondary: InteractiveStateTokens,
    val tertiary: InteractiveStateTokens
)

data class DangerInteractiveTokens(
    val primary: InteractiveStateTokens,
    val secondary: InteractiveStateTokens,
    val tertiary: InteractiveStateTokens
)

data class InteractiveStateTokens(
    val default: Int,
    val hover: Int,
    val pressed: Int,
    val disabled: Int
)

// ===== TEXT TOKENS =====

data class TextTokens(
    val static: StaticTextTokens,
    val interactive: InteractiveTextTokens
)

data class StaticTextTokens(
    val regular: RegularTextTokens,
    val semantic: SemanticTextTokens
)

data class RegularTextTokens(
    val brand: Int,
    val primary: Int,
    val secondary: Int,
    val onDark: Int,
    val onLight: Int,
    val inverse: Int
)

data class SemanticTextTokens(
    val success: Int,
    val error: Int,
    val information: Int,
    val warning: Int
)

data class InteractiveTextTokens(
    val regular: InteractiveTextStateTokens,
    val danger: InteractiveTextStateTokens
)

data class InteractiveTextStateTokens(
    val default: Int,
    val hover: Int,
    val pressed: Int,
    val disabled: Int
)

// ===== BORDER TOKENS =====

data class BorderTokens(
    val static: StaticBorderTokens,
    val interactive: InteractiveBorderTokens
)

data class StaticBorderTokens(
    val regular: RegularBorderTokens,
    val semantic: SemanticBorderTokens
)

data class RegularBorderTokens(
    val strong: Int,
    val medium: Int,
    val soft: Int,
    val onDark: Int,
    val onDarkSoft: Int,
    val onLight: Int,
    val inverse: Int
)

data class SemanticBorderTokens(
    val success: Int,
    val error: Int,
    val information: Int,
    val warning: Int
)

data class InteractiveBorderTokens(
    val regular: InteractiveBorderStateTokens,
    val danger: InteractiveBorderStateTokens
)

data class InteractiveBorderStateTokens(
    val default: Int,
    val hover: Int,
    val pressed: Int,
    val active: Int,
    val disabled: Int
)

// ===== ICON TOKENS =====

data class IconTokens(
    val static: StaticIconTokens,
    val interactive: InteractiveIconTokens
)

data class StaticIconTokens(
    val regular: RegularIconTokens,
    val semantic: SemanticIconTokens
)

data class RegularIconTokens(
    val primary: Int,
    val secondary: Int,
    val onDark: Int,
    val onLight: Int,
    val inverse: Int
)

data class SemanticIconTokens(
    val success: Int,
    val error: Int,
    val information: Int,
    val warning: Int
)

data class InteractiveIconTokens(
    val regular: InteractiveIconStateTokens,
    val danger: InteractiveIconStateTokens
)

data class InteractiveIconStateTokens(
    val default: Int,
    val hover: Int,
    val pressed: Int,
    val disabled: Int
)

// ===== TOKENS LEGACY (MANTENER COMPATIBILIDAD) =====

/**
 * @deprecated Usar la nueva estructura anidada en su lugar
 * Estos tokens se mantienen para compatibilidad hacia atrás
 */
@Deprecated("Usar aliasTokens.surface.static.regular.flat.primary en su lugar")
val AliasTokens.surfacePrimary: Int
    get() = surface.static.regular.flat.primary

@Deprecated("Usar aliasTokens.surface.static.regular.flat.secondary en su lugar")
val AliasTokens.surfaceSecondary: Int
    get() = surface.static.regular.flat.secondary

@Deprecated("Usar aliasTokens.surface.static.regular.flat.tertiary en su lugar")
val AliasTokens.surfaceTertiary: Int
    get() = surface.static.regular.flat.tertiary

@Deprecated("Usar aliasTokens.text.static.regular.primary en su lugar")
val AliasTokens.textPrimary: Int
    get() = text.static.regular.primary

@Deprecated("Usar aliasTokens.text.static.regular.secondary en su lugar")
val AliasTokens.textSecondary: Int
    get() = text.static.regular.secondary

@Deprecated("Usar aliasTokens.border.static.regular.medium en su lugar")
val AliasTokens.borderPrimary: Int
    get() = border.static.regular.medium

@Deprecated("Usar aliasTokens.icon.static.regular.primary en su lugar")
val AliasTokens.iconPrimary: Int
    get() = icon.static.regular.primary

@Deprecated("Usar aliasTokens.surface.interactive.base.regular.primary.default en su lugar")
val AliasTokens.interactivePrimary: Int
    get() = surface.interactive.base.regular.primary.default

@Deprecated("Usar aliasTokens.surface.interactive.base.regular.secondary.default en su lugar")
val AliasTokens.interactiveSecondary: Int
    get() = surface.interactive.base.regular.secondary.default

@Deprecated("Usar aliasTokens.surface.static.semantic.success en su lugar")
val AliasTokens.statusSuccess: Int
    get() = surface.static.semantic.success

@Deprecated("Usar aliasTokens.surface.static.semantic.error en su lugar")
val AliasTokens.statusError: Int
    get() = surface.static.semantic.error

@Deprecated("Usar aliasTokens.surface.static.semantic.warning en su lugar")
val AliasTokens.statusWarning: Int
    get() = surface.static.semantic.warning

@Deprecated("Usar aliasTokens.surface.static.semantic.information en su lugar")
val AliasTokens.statusInfo: Int
    get() = surface.static.semantic.information

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
    val shadowColor: Color,
    val offsetX: Float,
    val offsetY: Float,
    val blur: Float,
    val spread: Float,
)

// ===== EFFECTS TOKENS =====

/**
 * Tokens de alias para efectos visuales - Estructura equivalente a React Native
 */
data class EffectsTokens(
    val shadows: ShadowToken,
    val blur: BlurTokens,
    val glass: GradientGlassTokens,
    val effectGlass: EffectGlassToken
)

/**
 * Token individual para efecto de sombra
 */
data class ShadowToken(
    val shadowColor: Color,
    val offsetX: Float,
    val offsetY: Float,
    val blur: Float,
    val spread: Float,
)

/**
 * Tokens para efectos de blur
 */
data class BlurTokens(
    val blurAmount: Float,
    val tintAlpha: Float
)

/**
 * Tokens para efectos de glass
 */
data class GradientGlassTokens(
    val startX: Float,
    val startY: Float,
    val endX: Float,
    val endY: Float,
    val alpha: Float
)

/**
 * Token para efecto glass
 */
data class EffectGlassToken(
    val xlarge: BlurTokens,
    val glassBG: GradientGlassTokens
)
