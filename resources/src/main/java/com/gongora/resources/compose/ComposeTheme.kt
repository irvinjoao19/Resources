package com.gongora.resources.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gongora.resources.tokens.Colors

/**
 * Sistema de temas para Jetpack Compose basado en el sistema de diseño BCP
 *
 * Proporciona temas Material 3 con colores, tipografía y formas
 * basados en los tokens de diseño de BCP.
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object ComposeTheme {
    
    /**
     * Esquema de colores para tema claro
     */
    val LightColorScheme = lightColorScheme(
        // Colores primarios
        primary = Color(Colors.Brand.BcpBlue.blue500),
        onPrimary = Color(Colors.Neutral.white),
        primaryContainer = Color(Colors.Brand.BcpBlue.blue100),
        onPrimaryContainer = Color(Colors.Brand.BcpBlue.blue900),
        
        // Colores secundarios
        secondary = Color(Colors.Brand.BcpOrange.orange500),
        onSecondary = Color(Colors.Neutral.white),
        secondaryContainer = Color(Colors.Brand.BcpOrange.orange100),
        onSecondaryContainer = Color(Colors.Brand.BcpOrange.orange900),
        
        // Colores terciarios
        tertiary = Color(Colors.Functional.Sky.sky500),
        onTertiary = Color(Colors.Neutral.white),
        tertiaryContainer = Color(Colors.Functional.Sky.sky100),
        onTertiaryContainer = Color(Colors.Functional.Sky.sky900),
        
        // Colores de error
        error = Color(Colors.Functional.Red.red600),
        onError = Color(Colors.Neutral.white),
        errorContainer = Color(Colors.Functional.Red.red100),
        onErrorContainer = Color(Colors.Functional.Red.red900),
        
        // Colores de fondo
        background = Color(Colors.Neutral.white),
        onBackground = Color(Colors.Neutral.Gray.gray800),
        surface = Color(Colors.Neutral.Gray.gray050),
        onSurface = Color(Colors.Neutral.Gray.gray800),
        
        // Colores de superficie variantes
        surfaceVariant = Color(Colors.Neutral.Gray.gray100),
        onSurfaceVariant = Color(Colors.Neutral.Gray.gray600),
        outline = Color(Colors.Neutral.Gray.gray200),
        outlineVariant = Color(Colors.Neutral.Gray.gray100),
        
        // Colores de estado
        inverseSurface = Color(Colors.Neutral.Gray.gray800),
        inverseOnSurface = Color(Colors.Neutral.white),
        inversePrimary = Color(Colors.Brand.BcpBlue.blue200),
        
        // Colores de superficie con elevación
        surfaceTint = Color(Colors.Brand.BcpBlue.blue500),
        scrim = Color(Colors.Neutral.black).copy(alpha = 0.32f)
    )
    
    /**
     * Esquema de colores para tema oscuro
     */
    val DarkColorScheme = darkColorScheme(
        // Colores primarios
        primary = Color(Colors.Brand.BcpBlue.blue400),
        onPrimary = Color(Colors.Neutral.Gray.gray900),
        primaryContainer = Color(Colors.Brand.BcpBlue.blue200),
        onPrimaryContainer = Color(Colors.Brand.BcpBlue.blue900),
        
        // Colores secundarios
        secondary = Color(Colors.Brand.BcpOrange.orange400),
        onSecondary = Color(Colors.Neutral.Gray.gray900),
        secondaryContainer = Color(Colors.Brand.BcpOrange.orange200),
        onSecondaryContainer = Color(Colors.Brand.BcpOrange.orange900),
        
        // Colores terciarios
        tertiary = Color(Colors.Functional.Sky.sky400),
        onTertiary = Color(Colors.Neutral.Gray.gray900),
        tertiaryContainer = Color(Colors.Functional.Sky.sky200),
        onTertiaryContainer = Color(Colors.Functional.Sky.sky900),
        
        // Colores de error
        error = Color(Colors.Functional.Red.red400),
        onError = Color(Colors.Neutral.Gray.gray900),
        errorContainer = Color(Colors.Functional.Red.red200),
        onErrorContainer = Color(Colors.Functional.Red.red900),
        
        // Colores de fondo
        background = Color(Colors.Neutral.Gray.gray900),
        onBackground = Color(Colors.Neutral.white),
        surface = Color(Colors.Neutral.Gray.gray800),
        onSurface = Color(Colors.Neutral.white),
        
        // Colores de superficie variantes
        surfaceVariant = Color(Colors.Neutral.Gray.gray700),
        onSurfaceVariant = Color(Colors.Neutral.Gray.gray200),
        outline = Color(Colors.Neutral.Gray.gray600),
        outlineVariant = Color(Colors.Neutral.Gray.gray500),
        
        // Colores de estado
        inverseSurface = Color(Colors.Neutral.white),
        inverseOnSurface = Color(Colors.Neutral.Gray.gray800),
        inversePrimary = Color(Colors.Brand.BcpBlue.blue600),
        
        // Colores de superficie con elevación
        surfaceTint = Color(Colors.Brand.BcpBlue.blue400),
        scrim = Color(Colors.Neutral.black).copy(alpha = 0.32f)
    )
}

/**
 * LocalComposition para el tema personalizado de BCP
 */
val LocalBcpTheme = staticCompositionLocalOf { BcpTheme() }

/**
 * Clase que contiene el tema personalizado de BCP
 */
data class BcpTheme(
    val colors: BcpColors = BcpColors(),
    val typography: BcpTypography = BcpTypography(),
    val spacing: BcpSpacing = BcpSpacing(),
    val shapes: BcpShapes = BcpShapes()
)

/**
 * Colores personalizados de BCP
 */
data class BcpColors(
    val brand: BcpBrandColors = BcpBrandColors(),
    val functional: BcpFunctionalColors = BcpFunctionalColors(),
    val neutral: BcpNeutralColors = BcpNeutralColors(),
    val decorative: BcpDecorativeColors = BcpDecorativeColors()
)

/**
 * Colores de marca BCP
 */
data class BcpBrandColors(
    val blue: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Brand.BcpBlue.blue050),
        color100 = Color(Colors.Brand.BcpBlue.blue100),
        color200 = Color(Colors.Brand.BcpBlue.blue200),
        color300 = Color(Colors.Brand.BcpBlue.blue300),
        color400 = Color(Colors.Brand.BcpBlue.blue400),
        color500 = Color(Colors.Brand.BcpBlue.blue500),
        color600 = Color(Colors.Brand.BcpBlue.blue600),
        color700 = Color(Colors.Brand.BcpBlue.blue700),
        color800 = Color(Colors.Brand.BcpBlue.blue800),
        color900 = Color(Colors.Brand.BcpBlue.blue900)
    ),
    val orange: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Brand.BcpOrange.orange050),
        color100 = Color(Colors.Brand.BcpOrange.orange100),
        color200 = Color(Colors.Brand.BcpOrange.orange200),
        color300 = Color(Colors.Brand.BcpOrange.orange300),
        color400 = Color(Colors.Brand.BcpOrange.orange400),
        color500 = Color(Colors.Brand.BcpOrange.orange500),
        color600 = Color(Colors.Brand.BcpOrange.orange600),
        color700 = Color(Colors.Brand.BcpOrange.orange700),
        color800 = Color(Colors.Brand.BcpOrange.orange800),
        color900 = Color(Colors.Brand.BcpOrange.orange900)
    )
)

/**
 * Colores funcionales BCP
 */
data class BcpFunctionalColors(
    val success: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Functional.Green.green050),
        color100 = Color(Colors.Functional.Green.green100),
        color200 = Color(Colors.Functional.Green.green200),
        color300 = Color(Colors.Functional.Green.green300),
        color400 = Color(Colors.Functional.Green.green400),
        color500 = Color(Colors.Functional.Green.green500),
        color600 = Color(Colors.Functional.Green.green600),
        color700 = Color(Colors.Functional.Green.green700),
        color800 = Color(Colors.Functional.Green.green800),
        color900 = Color(Colors.Functional.Green.green900)
    ),
    val error: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Functional.Red.red050),
        color100 = Color(Colors.Functional.Red.red100),
        color200 = Color(Colors.Functional.Red.red200),
        color300 = Color(Colors.Functional.Red.red300),
        color400 = Color(Colors.Functional.Red.red400),
        color500 = Color(Colors.Functional.Red.red500),
        color600 = Color(Colors.Functional.Red.red600),
        color700 = Color(Colors.Functional.Red.red700),
        color800 = Color(Colors.Functional.Red.red800),
        color900 = Color(Colors.Functional.Red.red900)
    ),
    val warning: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Functional.Yellow.yellow050),
        color100 = Color(Colors.Functional.Yellow.yellow100),
        color200 = Color(Colors.Functional.Yellow.yellow200),
        color300 = Color(Colors.Functional.Yellow.yellow300),
        color400 = Color(Colors.Functional.Yellow.yellow400),
        color500 = Color(Colors.Functional.Yellow.yellow500),
        color600 = Color(Colors.Functional.Yellow.yellow600),
        color700 = Color(Colors.Functional.Yellow.yellow700),
        color800 = Color(Colors.Functional.Yellow.yellow800),
        color900 = Color(Colors.Functional.Yellow.yellow900)
    ),
    val info: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Functional.Sky.sky050),
        color100 = Color(Colors.Functional.Sky.sky100),
        color200 = Color(Colors.Functional.Sky.sky200),
        color300 = Color(Colors.Functional.Sky.sky300),
        color400 = Color(Colors.Functional.Sky.sky400),
        color500 = Color(Colors.Functional.Sky.sky500),
        color600 = Color(Colors.Functional.Sky.sky600),
        color700 = Color(Colors.Functional.Sky.sky700),
        color800 = Color(Colors.Functional.Sky.sky800),
        color900 = Color(Colors.Functional.Sky.sky900)
    )
)

/**
 * Colores neutrales BCP
 */
data class BcpNeutralColors(
    val gray: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Neutral.Gray.gray050),
        color100 = Color(Colors.Neutral.Gray.gray100),
        color200 = Color(Colors.Neutral.Gray.gray200),
        color300 = Color(Colors.Neutral.Gray.gray300),
        color400 = Color(Colors.Neutral.Gray.gray400),
        color500 = Color(Colors.Neutral.Gray.gray500),
        color600 = Color(Colors.Neutral.Gray.gray600),
        color700 = Color(Colors.Neutral.Gray.gray700),
        color800 = Color(Colors.Neutral.Gray.gray800),
        color900 = Color(Colors.Neutral.Gray.gray900)
    ),
    val white: Color = Color(Colors.Neutral.white),
    val black: Color = Color(Colors.Neutral.black)
)

/**
 * Colores decorativos BCP
 */
data class BcpDecorativeColors(
    val teal: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Decorative.Teal.teal050),
        color100 = Color(Colors.Decorative.Teal.teal100),
        color200 = Color(Colors.Decorative.Teal.teal200),
        color300 = Color(Colors.Decorative.Teal.teal300),
        color400 = Color(Colors.Decorative.Teal.teal400),
        color500 = Color(Colors.Decorative.Teal.teal500),
        color600 = Color(Colors.Decorative.Teal.teal600),
        color700 = Color(Colors.Decorative.Teal.teal700),
        color800 = Color(Colors.Decorative.Teal.teal800),
        color900 = Color(Colors.Decorative.Teal.teal900)
    ),
    val violet: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Decorative.Violet.violet050),
        color100 = Color(Colors.Decorative.Violet.violet100),
        color200 = Color(Colors.Decorative.Violet.violet200),
        color300 = Color(Colors.Decorative.Violet.violet300),
        color400 = Color(Colors.Decorative.Violet.violet400),
        color500 = Color(Colors.Decorative.Violet.violet500),
        color600 = Color(Colors.Decorative.Violet.violet600),
        color700 = Color(Colors.Decorative.Violet.violet700),
        color800 = Color(Colors.Decorative.Violet.violet800),
        color900 = Color(Colors.Decorative.Violet.violet900)
    ),
    val pink: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Decorative.Pink.pink050),
        color100 = Color(Colors.Decorative.Pink.pink100),
        color200 = Color(Colors.Decorative.Pink.pink200),
        color300 = Color(Colors.Decorative.Pink.pink300),
        color400 = Color(Colors.Decorative.Pink.pink400),
        color500 = Color(Colors.Decorative.Pink.pink500),
        color600 = Color(Colors.Decorative.Pink.pink600),
        color700 = Color(Colors.Decorative.Pink.pink700),
        color800 = Color(Colors.Decorative.Pink.pink800),
        color900 = Color(Colors.Decorative.Pink.pink900)
    ),
    val cyan: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Decorative.Cyan.cyan050),
        color100 = Color(Colors.Decorative.Cyan.cyan100),
        color200 = Color(Colors.Decorative.Cyan.cyan200),
        color300 = Color(Colors.Decorative.Cyan.cyan300),
        color400 = Color(Colors.Decorative.Cyan.cyan400),
        color500 = Color(Colors.Decorative.Cyan.cyan500),
        color600 = Color(Colors.Decorative.Cyan.cyan600),
        color700 = Color(Colors.Decorative.Cyan.cyan700),
        color800 = Color(Colors.Decorative.Cyan.cyan800),
        color900 = Color(Colors.Decorative.Cyan.cyan900)
    ),
    val lime: BcpColorScale = BcpColorScale(
        color050 = Color(Colors.Decorative.Lime.lime050),
        color100 = Color(Colors.Decorative.Lime.lime100),
        color200 = Color(Colors.Decorative.Lime.lime200),
        color300 = Color(Colors.Decorative.Lime.lime300),
        color400 = Color(Colors.Decorative.Lime.lime400),
        color500 = Color(Colors.Decorative.Lime.lime500),
        color600 = Color(Colors.Decorative.Lime.lime600),
        color700 = Color(Colors.Decorative.Lime.lime700),
        color800 = Color(Colors.Decorative.Lime.lime800),
        color900 = Color(Colors.Decorative.Lime.lime900)
    )
)

/**
 * Escala de colores BCP
 */
data class BcpColorScale(
    val color050: Color,
    val color100: Color,
    val color200: Color,
    val color300: Color,
    val color400: Color,
    val color500: Color,
    val color600: Color,
    val color700: Color,
    val color800: Color,
    val color900: Color
)

/**
 * Tipografía personalizada de BCP
 */
data class BcpTypography(
    val fontFamily: BcpFontFamily = BcpFontFamily(),
    val fontSize: BcpFontSize = BcpFontSize(),
    val fontWeight: BcpFontWeight = BcpFontWeight(),
    val lineHeight: BcpLineHeight = BcpLineHeight()
)

/**
 * Familias de fuentes BCP
 */
data class BcpFontFamily(
    val brand: BcpBrandFontFamily = BcpBrandFontFamily(),
    val supportive: BcpSupportiveFontFamily = BcpSupportiveFontFamily()
)

/**
 * Familias de fuentes de marca
 */
data class BcpBrandFontFamily(
    val thin: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val light: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val regular: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val medium: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val demi: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val bold: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val heavy: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val black: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default
)

/**
 * Familias de fuentes de apoyo
 */
data class BcpSupportiveFontFamily(
    val thin: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val light: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val regular: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val medium: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val semiBold: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val bold: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default,
    val black: androidx.compose.ui.text.font.FontFamily = androidx.compose.ui.text.font.FontFamily.Default
)

/**
 * Tamaños de fuente BCP
 */
data class BcpFontSize(
    val xsmall: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val small: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val medium: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val large: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val xlarge: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val xxlarge: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val xxxlarge: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val display: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val hero: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified
)

/**
 * Pesos de fuente BCP
 */
data class BcpFontWeight(
    val thin: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Thin,
    val light: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Light,
    val regular: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
    val medium: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
    val semiBold: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
    val bold: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
    val heavy: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.ExtraBold,
    val black: androidx.compose.ui.text.font.FontWeight = androidx.compose.ui.text.font.FontWeight.Black
)

/**
 * Alturas de línea BCP
 */
data class BcpLineHeight(
    val small: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val medium: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val large: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val xlarge: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val xxlarge: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val xxxlarge: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified,
    val display: androidx.compose.ui.unit.TextUnit = androidx.compose.ui.unit.TextUnit.Unspecified
)

/**
 * Espaciado personalizado de BCP
 */
data class BcpSpacing(
    val base: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val tiny: BcpTinySpacing = BcpTinySpacing(),
    val small: BcpSmallSpacing = BcpSmallSpacing(),
    val medium: BcpMediumSpacing = BcpMediumSpacing(),
    val large: BcpLargeSpacing = BcpLargeSpacing(),
    val xlarge: BcpXLargeSpacing = BcpXLargeSpacing(),
    val xxlarge: BcpXXLargeSpacing = BcpXXLargeSpacing(),
    val common: BcpCommonSpacing = BcpCommonSpacing()
)

/**
 * Espaciado mínimo
 */
data class BcpTinySpacing(
    val xsmall: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Espaciado pequeño
 */
data class BcpSmallSpacing(
    val xsmall: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Espaciado medio
 */
data class BcpMediumSpacing(
    val xsmall: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val medium: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Espaciado grande
 */
data class BcpLargeSpacing(
    val xsmall: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val medium: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val large: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Espaciado extra grande
 */
data class BcpXLargeSpacing(
    val xsmall: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val medium: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Espaciado máximo
 */
data class BcpXXLargeSpacing(
    val xsmall: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val medium: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val large: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Espaciado común
 */
data class BcpCommonSpacing(
    val none: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xs: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val sm: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val md: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val lg: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xl: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xxl: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xxxl: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xxxxl: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Formas personalizadas de BCP
 */
data class BcpShapes(
    val border: BcpBorder = BcpBorder(),
    val effects: BcpEffects = BcpEffects()
)

/**
 * Bordes BCP
 */
data class BcpBorder(
    val width: BcpBorderWidth = BcpBorderWidth(),
    val radius: BcpBorderRadius = BcpBorderRadius()
)

/**
 * Anchos de borde BCP
 */
data class BcpBorderWidth(
    val none: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val thin: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val medium: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val thick: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Radios de borde BCP
 */
data class BcpBorderRadius(
    val none: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val small: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val medium: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val large: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xlarge: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xxlarge: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val xxxlarge: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val round: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified
)

/**
 * Efectos BCP
 */
data class BcpEffects(
    val shadow: BcpShadow = BcpShadow(),
    val blur: BcpBlur = BcpBlur(),
    val glass: BcpGlass = BcpGlass()
)

/**
 * Sombras BCP
 */
data class BcpShadow(
    val small: BcpShadowValues = BcpShadowValues(),
    val medium: BcpShadowValues = BcpShadowValues(),
    val large: BcpShadowValues = BcpShadowValues(),
    val xlarge: BcpShadowValues = BcpShadowValues()
)

/**
 * Valores de sombra BCP
 */
data class BcpShadowValues(
    val elevation: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val shadowRadius: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val shadowOffsetX: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val shadowOffsetY: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val shadowColor: Color = Color.Unspecified,
    val shadowAlpha: Float = 0f
)

/**
 * Efectos de blur BCP
 */
data class BcpBlur(
    val light: BcpBlurValues = BcpBlurValues(),
    val medium: BcpBlurValues = BcpBlurValues(),
    val heavy: BcpBlurValues = BcpBlurValues()
)

/**
 * Valores de blur BCP
 */
data class BcpBlurValues(
    val radius: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val alpha: Float = 0f
)

/**
 * Efectos de glass BCP
 */
data class BcpGlass(
    val light: BcpGlassValues = BcpGlassValues(),
    val medium: BcpGlassValues = BcpGlassValues(),
    val heavy: BcpGlassValues = BcpGlassValues()
)

/**
 * Valores de glass BCP
 */
data class BcpGlassValues(
    val alpha: Float = 0f,
    val blurRadius: androidx.compose.ui.unit.Dp = androidx.compose.ui.unit.Dp.Unspecified,
    val tintColor: Color = Color.Unspecified
)

/**
 * Composable principal para aplicar el tema BCP
 */
@Composable
fun BcpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        ComposeTheme.DarkColorScheme
    } else {
        ComposeTheme.LightColorScheme
    }
    
    val bcpTheme = BcpTheme(
        colors = BcpColors(),
        typography = BcpTypography(),
        spacing = BcpSpacing(),
        shapes = BcpShapes()
    )
    
    CompositionLocalProvider(LocalBcpTheme provides bcpTheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

/**
 * Obtener el tema BCP actual
 */
@Composable
@ReadOnlyComposable
fun bcpTheme(): BcpTheme = LocalBcpTheme.current
