package com.gongora.resources.theme

import com.gongora.resources.tokens.Border
import com.gongora.resources.tokens.Colors
import com.gongora.resources.tokens.Effects
import com.gongora.resources.tokens.Spacing
import com.gongora.resources.tokens.Typography

/**
 * Tema oscuro para el sistema de diseño BCP
 *
 * Define la configuración visual para el modo oscuro de la aplicación,
 * incluyendo colores, tipografía, espaciado y efectos optimizados
 * para entornos con poca iluminación.
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object DarkTheme : Theme {
    
    override val aliasTokens = AliasTokens(
        // Surface tokens
        surfacePrimary = Colors.Neutral.Gray.gray800,
        surfaceSecondary = Colors.Neutral.Gray.gray700,
        surfaceTertiary = Colors.Neutral.Gray.gray600,
        surfaceQuaternary = Colors.Neutral.Gray.gray500,
        surfaceInverse = Colors.Neutral.white,
        
        // Text tokens
        textPrimary = Colors.Neutral.white,
        textSecondary = Colors.Neutral.Gray.gray200,
        textTertiary = Colors.Neutral.Gray.gray400,
        textInverse = Colors.Neutral.Gray.gray800,
        textDisabled = Colors.Neutral.Gray.gray500,
        
        // Border tokens
        borderPrimary = Colors.Neutral.Gray.gray600,
        borderSecondary = Colors.Neutral.Gray.gray500,
        borderTertiary = Colors.Neutral.Gray.gray400,
        borderInverse = Colors.Neutral.Gray.gray200,
        
        // Icon tokens
        iconPrimary = Colors.Neutral.white,
        iconSecondary = Colors.Neutral.Gray.gray200,
        iconTertiary = Colors.Neutral.Gray.gray400,
        iconInverse = Colors.Neutral.Gray.gray800,
        iconDisabled = Colors.Neutral.Gray.gray500,
        
        // Interactive tokens
        interactivePrimary = Colors.Brand.BcpBlue.blue400,
        interactiveSecondary = Colors.Brand.BcpBlue.blue200,
        interactiveTertiary = Colors.Neutral.Gray.gray600,
        interactiveInverse = Colors.Neutral.Gray.gray800,
        interactiveDisabled = Colors.Neutral.Gray.gray500,
        
        // Status tokens
        statusSuccess = Colors.Functional.Green.green400,
        statusWarning = Colors.Functional.Yellow.yellow400,
        statusError = Colors.Functional.Red.red400,
        statusInfo = Colors.Functional.Sky.sky400
    )
    
    override val colors = ThemeColors(
        primary = Colors.Brand.BcpBlue.blue400,
        secondary = Colors.Brand.BcpOrange.orange400,
        accent = Colors.Brand.BcpBlue.blue200,
        background = Colors.Neutral.Gray.gray900,
        surface = Colors.Neutral.Gray.gray800,
        error = Colors.Functional.Red.red400,
        warning = Colors.Functional.Yellow.yellow400,
        success = Colors.Functional.Green.green400,
        info = Colors.Functional.Sky.sky400
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
        shadowColor = Colors.Neutral.black,
        shadowAlpha = 0.3f
    )
}
