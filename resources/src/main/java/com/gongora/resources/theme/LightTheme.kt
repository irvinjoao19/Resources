package com.gongora.resources.theme

import com.gongora.resources.tokens.Border
import com.gongora.resources.tokens.Colors
import com.gongora.resources.tokens.Effects
import com.gongora.resources.tokens.Spacing
import com.gongora.resources.tokens.Typography

/**
 * Tema claro para el sistema de diseño BCP
 *
 * Define la configuración visual para el modo claro de la aplicación,
 * incluyendo colores, tipografía, espaciado y efectos optimizados
 * para entornos con buena iluminación.
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object LightTheme : Theme {
    
    override val aliasTokens = AliasTokens(
        // Surface tokens
        surfacePrimary = Colors.Neutral.white,
        surfaceSecondary = Colors.Neutral.Gray.gray050,
        surfaceTertiary = Colors.Neutral.Gray.gray100,
        surfaceQuaternary = Colors.Neutral.Gray.gray200,
        surfaceInverse = Colors.Neutral.Gray.gray800,
        
        // Text tokens
        textPrimary = Colors.Neutral.Gray.gray800,
        textSecondary = Colors.Neutral.Gray.gray600,
        textTertiary = Colors.Neutral.Gray.gray400,
        textInverse = Colors.Neutral.white,
        textDisabled = Colors.Neutral.Gray.gray300,
        
        // Border tokens
        borderPrimary = Colors.Neutral.Gray.gray200,
        borderSecondary = Colors.Neutral.Gray.gray100,
        borderTertiary = Colors.Neutral.Gray.gray050,
        borderInverse = Colors.Neutral.Gray.gray600,
        
        // Icon tokens
        iconPrimary = Colors.Neutral.Gray.gray800,
        iconSecondary = Colors.Neutral.Gray.gray600,
        iconTertiary = Colors.Neutral.Gray.gray400,
        iconInverse = Colors.Neutral.white,
        iconDisabled = Colors.Neutral.Gray.gray300,
        
        // Interactive tokens
        interactivePrimary = Colors.Brand.BcpBlue.blue500,
        interactiveSecondary = Colors.Brand.BcpBlue.blue100,
        interactiveTertiary = Colors.Neutral.Gray.gray100,
        interactiveInverse = Colors.Neutral.white,
        interactiveDisabled = Colors.Neutral.Gray.gray200,
        
        // Status tokens
        statusSuccess = Colors.Functional.Green.green600,
        statusWarning = Colors.Functional.Yellow.yellow600,
        statusError = Colors.Functional.Red.red600,
        statusInfo = Colors.Functional.Sky.sky600
    )
    
    override val colors = ThemeColors(
        primary = Colors.Brand.BcpBlue.blue500,
        secondary = Colors.Brand.BcpOrange.orange500,
        accent = Colors.Brand.BcpBlue.blue100,
        background = Colors.Neutral.white,
        surface = Colors.Neutral.Gray.gray050,
        error = Colors.Functional.Red.red600,
        warning = Colors.Functional.Yellow.yellow600,
        success = Colors.Functional.Green.green600,
        info = Colors.Functional.Sky.sky600
    )
    
    override val typography = ThemeTypography(
        fontFamilyPrimary = Typography.FontFamily.Brand.regular,
        fontFamilySecondary = Typography.FontFamily.Supportive.regular,
        fontSizeBase = Typography.FontSize.medium.toFloat(),
        lineHeightBase = Typography.LineHeight.medium.toFloat()
    )
    
    override val spacing = ThemeSpacing(
        base = Spacing.base,
        small = Spacing.Small.small,
        medium = Spacing.Medium.medium,
        large = Spacing.Large.large
    )
    
    override val border = ThemeBorder(
        radiusSmall = Border.Radius.small,
        radiusMedium = Border.Radius.medium,
        radiusLarge = Border.Radius.large,
        widthThin = Border.Width.regular,
        widthMedium = Border.Width.medium
    )
    
    override val effects = ThemeEffects(
        elevationSmall = Effects.Shadow.Small.elevation,
        elevationMedium = Effects.Shadow.Medium.elevation,
        elevationLarge = Effects.Shadow.Large.elevation,
        shadowColor = Effects.Shadow.Small.shadowColor,
        shadowAlpha = Effects.Shadow.Small.shadowAlpha
    )
}
