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
        surface = SurfaceTokens(
            static = StaticSurfaceTokens(
                regular = RegularSurfaceTokens(
                    flat = FlatSurfaceTokens(
                        brand = Colors.Brand.BcpBlue.blue400,
                        primary = Colors.Neutral.Gray.gray800,
                        secondary = Colors.Neutral.Gray.gray700,
                        tertiary = Colors.Neutral.Gray.gray600,
                        onDarkSoft = Colors.Neutral.Gray.gray500
                    ),
                    gradient = GradientSurfaceTokens(
                        glassStart = Colors.colorWithAlpha(
                            Colors.Neutral.Gray.gray800,
                            Colors.AlphaValues.alpha_10
                        ),
                        glassEnd = Colors.Neutral.Gray.gray800
                    )
                ),
                semantic = SemanticSurfaceTokens(
                    success = Colors.Functional.Green.green900,
                    successSoft = Colors.Functional.Green.green800,
                    error = Colors.Functional.Red.red900,
                    errorSoft = Colors.Functional.Red.red800,
                    information = Colors.Functional.Sky.sky900,
                    informationSoft = Colors.Functional.Sky.sky800,
                    warning = Colors.Functional.Yellow.yellow900,
                    warningSoft = Colors.Functional.Yellow.yellow800
                )
            ),
            interactive = InteractiveSurfaceTokens(
                base = BaseInteractiveTokens(
                    regular = RegularInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Brand.BcpBlue.blue400,
                            hover = Colors.Brand.BcpBlue.blue500,
                            pressed = Colors.Brand.BcpBlue.blue600,
                            disabled = Colors.Neutral.Gray.gray600
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Brand.BcpBlue.blue200,
                            hover = Colors.Brand.BcpBlue.blue300,
                            pressed = Colors.Brand.BcpBlue.blue400,
                            disabled = Colors.Neutral.Gray.gray500
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray600,
                            hover = Colors.Neutral.Gray.gray500,
                            pressed = Colors.Neutral.Gray.gray400,
                            disabled = Colors.Neutral.Gray.gray700
                        )
                    ),
                    danger = DangerInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red400,
                            hover = Colors.Functional.Red.red500,
                            pressed = Colors.Functional.Red.red600,
                            disabled = Colors.Neutral.Gray.gray600
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red200,
                            hover = Colors.Functional.Red.red300,
                            pressed = Colors.Functional.Red.red400,
                            disabled = Colors.Neutral.Gray.gray500
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray600,
                            hover = Colors.Neutral.Gray.gray500,
                            pressed = Colors.Neutral.Gray.gray400,
                            disabled = Colors.Neutral.Gray.gray700
                        )
                    )
                ),
                contrast = ContrastInteractiveTokens(
                    regular = RegularInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray800,
                            hover = Colors.Neutral.Gray.gray700,
                            pressed = Colors.Neutral.Gray.gray600,
                            disabled = Colors.Neutral.Gray.gray900
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray200,
                            hover = Colors.Neutral.Gray.gray300,
                            pressed = Colors.Neutral.Gray.gray400,
                            disabled = Colors.Neutral.Gray.gray600
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray400,
                            hover = Colors.Neutral.Gray.gray500,
                            pressed = Colors.Neutral.Gray.gray600,
                            disabled = Colors.Neutral.Gray.gray700
                        )
                    ),
                    danger = DangerInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red300,
                            hover = Colors.Functional.Red.red400,
                            pressed = Colors.Functional.Red.red500,
                            disabled = Colors.Neutral.Gray.gray600
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red100,
                            hover = Colors.Functional.Red.red200,
                            pressed = Colors.Functional.Red.red300,
                            disabled = Colors.Neutral.Gray.gray500
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray600,
                            hover = Colors.Neutral.Gray.gray500,
                            pressed = Colors.Neutral.Gray.gray400,
                            disabled = Colors.Neutral.Gray.gray700
                        )
                    )
                )
            )
        ),

        // ===== TEXT TOKENS =====
        text = TextTokens(
            static = StaticTextTokens(
                regular = RegularTextTokens(
                    brand = Colors.Brand.BcpBlue.blue300,
                    primary = Colors.Neutral.white,
                    secondary = Colors.Neutral.Gray.gray200,
                    onDark = Colors.Neutral.Gray.gray800,
                    onLight = Colors.Neutral.white,
                    inverse = Colors.Neutral.Gray.gray800
                ),
                semantic = SemanticTextTokens(
                    success = Colors.Functional.Green.green300,
                    error = Colors.Functional.Red.red300,
                    information = Colors.Functional.Sky.sky300,
                    warning = Colors.Functional.Yellow.yellow300
                )
            ),
            interactive = InteractiveTextTokens(
                regular = InteractiveTextStateTokens(
                    default = Colors.Brand.BcpBlue.blue300,
                    hover = Colors.Brand.BcpBlue.blue400,
                    pressed = Colors.Brand.BcpBlue.blue500,
                    disabled = Colors.Neutral.Gray.gray500
                ),
                danger = InteractiveTextStateTokens(
                    default = Colors.Functional.Red.red300,
                    hover = Colors.Functional.Red.red400,
                    pressed = Colors.Functional.Red.red500,
                    disabled = Colors.Neutral.Gray.gray500
                )
            )
        ),

        // ===== BORDER TOKENS =====
        border = BorderTokens(
            static = StaticBorderTokens(
                regular = RegularBorderTokens(
                    strong = Colors.Neutral.Gray.gray500,
                    medium = Colors.Neutral.Gray.gray600,
                    soft = Colors.Neutral.Gray.gray700,
                    onDark = Colors.Neutral.Gray.gray400,
                    onDarkSoft = Colors.Neutral.Gray.gray500,
                    onLight = Colors.Neutral.Gray.gray800,
                    inverse = Colors.Neutral.Gray.gray200
                ),
                semantic = SemanticBorderTokens(
                    success = Colors.Functional.Green.green400,
                    error = Colors.Functional.Red.red400,
                    information = Colors.Functional.Sky.sky400,
                    warning = Colors.Functional.Yellow.yellow400
                )
            ),
            interactive = InteractiveBorderTokens(
                regular = InteractiveBorderStateTokens(
                    default = Colors.Brand.BcpBlue.blue400,
                    hover = Colors.Brand.BcpBlue.blue500,
                    pressed = Colors.Brand.BcpBlue.blue600,
                    active = Colors.Brand.BcpBlue.blue500,
                    disabled = Colors.Neutral.Gray.gray600
                ),
                danger = InteractiveBorderStateTokens(
                    default = Colors.Functional.Red.red400,
                    hover = Colors.Functional.Red.red500,
                    pressed = Colors.Functional.Red.red600,
                    active = Colors.Functional.Red.red500,
                    disabled = Colors.Neutral.Gray.gray600
                )
            )
        ),

        // ===== ICON TOKENS =====
        icon = IconTokens(
            static = StaticIconTokens(
                regular = RegularIconTokens(
                    primary = Colors.Neutral.white,
                    secondary = Colors.Neutral.Gray.gray200,
                    onDark = Colors.Neutral.Gray.gray800,
                    onLight = Colors.Neutral.white,
                    inverse = Colors.Neutral.Gray.gray800
                ),
                semantic = SemanticIconTokens(
                    success = Colors.Functional.Green.green400,
                    error = Colors.Functional.Red.red400,
                    information = Colors.Functional.Sky.sky400,
                    warning = Colors.Functional.Yellow.yellow400
                )
            ),
            interactive = InteractiveIconTokens(
                regular = InteractiveIconStateTokens(
                    default = Colors.Brand.BcpBlue.blue400,
                    hover = Colors.Brand.BcpBlue.blue500,
                    pressed = Colors.Brand.BcpBlue.blue600,
                    disabled = Colors.Neutral.Gray.gray500
                ),
                danger = InteractiveIconStateTokens(
                    default = Colors.Functional.Red.red400,
                    hover = Colors.Functional.Red.red500,
                    pressed = Colors.Functional.Red.red600,
                    disabled = Colors.Neutral.Gray.gray500
                )
            )
        ),

        // ===== EFFECTS TOKENS =====
        effects = EffectsTokens(
            shadows = ShadowToken(
                shadowColor = Effects.Shadows.ShadowLarge.shadowColor,
                offsetX = Effects.Shadows.ShadowLarge.offsetX,
                offsetY = Effects.Shadows.ShadowLarge.offsetY,
                blur = Effects.Shadows.ShadowLarge.blur,
                spread = Effects.Shadows.ShadowLarge.spread
            ),
            blur = BlurTokens(
                blurAmount = Effects.Blur.XLarge.blurAmount,
                tintAlpha = Effects.Blur.XLarge.tintAlpha,
            ),
            glass = GradientGlassTokens(
                startX = Effects.GradientGlass.GlassBG.startX,
                startY = Effects.GradientGlass.GlassBG.startY,
                endX = Effects.GradientGlass.GlassBG.endX,
                endY = Effects.GradientGlass.GlassBG.endY,
                alpha = Effects.GradientGlass.GlassBG.alpha,
            ),
            effectGlass = EffectGlassToken(
                xlarge = BlurTokens(
                    blurAmount = Effects.Blur.XLarge.blurAmount,
                    tintAlpha = Effects.Blur.XLarge.tintAlpha,
                ),
                glassBG = GradientGlassTokens(
                    startX = Effects.GradientGlass.GlassBG.startX,
                    startY = Effects.GradientGlass.GlassBG.startY,
                    endX = Effects.GradientGlass.GlassBG.endX,
                    endY = Effects.GradientGlass.GlassBG.endY,
                    alpha = Effects.GradientGlass.GlassBG.alpha,
                ),
            )
        )
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
        base = Spacing.medium,
        small = Spacing.small,
        medium = Spacing.medium,
        large = Spacing.large
    )

    override val border = ThemeBorder(
        radiusSmall = Border.Radius.small,
        radiusMedium = Border.Radius.medium,
        radiusLarge = Border.Radius.large,
        widthThin = Border.Width.regular,
        widthMedium = Border.Width.medium
    )

    override val effects = ThemeEffects(
        shadowColor = Effects.Shadows.ShadowLarge.shadowColor,
        offsetX = Effects.Shadows.ShadowLarge.offsetX,
        offsetY = Effects.Shadows.ShadowLarge.offsetY,
        blur = Effects.Shadows.ShadowLarge.blur,
        spread = Effects.Shadows.ShadowLarge.spread
    )
}
