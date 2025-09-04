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
        // ===== SURFACE TOKENS =====
        surface = SurfaceTokens(
            static = StaticSurfaceTokens(
                regular = RegularSurfaceTokens(
                    flat = FlatSurfaceTokens(
                        brand = Colors.Brand.BcpBlue.blue500,
                        primary = Colors.Neutral.white,
                        secondary = Colors.Neutral.Gray.gray050,
                        tertiary = Colors.Neutral.Gray.gray100,
                        onDarkSoft = Colors.Neutral.Gray.gray200
                    ),
                    gradient = GradientSurfaceTokens(
                        glassStart = Colors.colorWithAlpha(
                            Colors.Neutral.white,
                            Colors.AlphaValues.alpha_10
                        ),
                        glassEnd = Colors.Neutral.white
                    )
                ),
                semantic = SemanticSurfaceTokens(
                    success = Colors.Functional.Green.green100,
                    successSoft = Colors.Functional.Green.green050,
                    error = Colors.Functional.Red.red100,
                    errorSoft = Colors.Functional.Red.red050,
                    information = Colors.Functional.Sky.sky100,
                    informationSoft = Colors.Functional.Sky.sky050,
                    warning = Colors.Functional.Yellow.yellow100,
                    warningSoft = Colors.Functional.Yellow.yellow050
                )
            ),
            interactive = InteractiveSurfaceTokens(
                base = BaseInteractiveTokens(
                    regular = RegularInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Brand.BcpBlue.blue500,
                            hover = Colors.Brand.BcpBlue.blue600,
                            pressed = Colors.Brand.BcpBlue.blue700,
                            disabled = Colors.Neutral.Gray.gray200
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Brand.BcpBlue.blue100,
                            hover = Colors.Brand.BcpBlue.blue200,
                            pressed = Colors.Brand.BcpBlue.blue300,
                            disabled = Colors.Neutral.Gray.gray100
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray100,
                            hover = Colors.Neutral.Gray.gray200,
                            pressed = Colors.Neutral.Gray.gray300,
                            disabled = Colors.Neutral.Gray.gray050
                        )
                    ),
                    danger = DangerInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red600,
                            hover = Colors.Functional.Red.red700,
                            pressed = Colors.Functional.Red.red800,
                            disabled = Colors.Neutral.Gray.gray200
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red100,
                            hover = Colors.Functional.Red.red200,
                            pressed = Colors.Functional.Red.red300,
                            disabled = Colors.Neutral.Gray.gray100
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray100,
                            hover = Colors.Neutral.Gray.gray200,
                            pressed = Colors.Neutral.Gray.gray300,
                            disabled = Colors.Neutral.Gray.gray050
                        )
                    )
                ),
                contrast = ContrastInteractiveTokens(
                    regular = RegularInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Neutral.white,
                            hover = Colors.Neutral.Gray.gray050,
                            pressed = Colors.Neutral.Gray.gray100,
                            disabled = Colors.Neutral.Gray.gray200
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray800,
                            hover = Colors.Neutral.Gray.gray700,
                            pressed = Colors.Neutral.Gray.gray600,
                            disabled = Colors.Neutral.Gray.gray400
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray600,
                            hover = Colors.Neutral.Gray.gray500,
                            pressed = Colors.Neutral.Gray.gray400,
                            disabled = Colors.Neutral.Gray.gray300
                        )
                    ),
                    danger = DangerInteractiveTokens(
                        primary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red400,
                            hover = Colors.Functional.Red.red500,
                            pressed = Colors.Functional.Red.red600,
                            disabled = Colors.Neutral.Gray.gray400
                        ),
                        secondary = InteractiveStateTokens(
                            default = Colors.Functional.Red.red200,
                            hover = Colors.Functional.Red.red300,
                            pressed = Colors.Functional.Red.red400,
                            disabled = Colors.Neutral.Gray.gray300
                        ),
                        tertiary = InteractiveStateTokens(
                            default = Colors.Neutral.Gray.gray400,
                            hover = Colors.Neutral.Gray.gray500,
                            pressed = Colors.Neutral.Gray.gray600,
                            disabled = Colors.Neutral.Gray.gray200
                        )
                    )
                )
            )
        ),

        // ===== TEXT TOKENS =====
        text = TextTokens(
            static = StaticTextTokens(
                regular = RegularTextTokens(
                    brand = Colors.Brand.BcpBlue.blue600,
                    primary = Colors.Neutral.Gray.gray800,
                    secondary = Colors.Neutral.Gray.gray600,
                    onDark = Colors.Neutral.white,
                    onLight = Colors.Neutral.Gray.gray800,
                    inverse = Colors.Neutral.white
                ),
                semantic = SemanticTextTokens(
                    success = Colors.Functional.Green.green700,
                    error = Colors.Functional.Red.red700,
                    information = Colors.Functional.Sky.sky700,
                    warning = Colors.Functional.Yellow.yellow700
                )
            ),
            interactive = InteractiveTextTokens(
                regular = InteractiveTextStateTokens(
                    default = Colors.Brand.BcpBlue.blue600,
                    hover = Colors.Brand.BcpBlue.blue700,
                    pressed = Colors.Brand.BcpBlue.blue800,
                    disabled = Colors.Neutral.Gray.gray400
                ),
                danger = InteractiveTextStateTokens(
                    default = Colors.Functional.Red.red600,
                    hover = Colors.Functional.Red.red700,
                    pressed = Colors.Functional.Red.red800,
                    disabled = Colors.Neutral.Gray.gray400
                )
            )
        ),

        // ===== BORDER TOKENS =====
        border = BorderTokens(
            static = StaticBorderTokens(
                regular = RegularBorderTokens(
                    strong = Colors.Neutral.Gray.gray300,
                    medium = Colors.Neutral.Gray.gray200,
                    soft = Colors.Neutral.Gray.gray100,
                    onDark = Colors.Neutral.Gray.gray600,
                    onDarkSoft = Colors.Neutral.Gray.gray500,
                    onLight = Colors.Neutral.Gray.gray200,
                    inverse = Colors.Neutral.Gray.gray600
                ),
                semantic = SemanticBorderTokens(
                    success = Colors.Functional.Green.green500,
                    error = Colors.Functional.Red.red500,
                    information = Colors.Functional.Sky.sky500,
                    warning = Colors.Functional.Yellow.yellow500
                )
            ),
            interactive = InteractiveBorderTokens(
                regular = InteractiveBorderStateTokens(
                    default = Colors.Brand.BcpBlue.blue500,
                    hover = Colors.Brand.BcpBlue.blue600,
                    pressed = Colors.Brand.BcpBlue.blue700,
                    active = Colors.Brand.BcpBlue.blue600,
                    disabled = Colors.Neutral.Gray.gray300
                ),
                danger = InteractiveBorderStateTokens(
                    default = Colors.Functional.Red.red500,
                    hover = Colors.Functional.Red.red600,
                    pressed = Colors.Functional.Red.red700,
                    active = Colors.Functional.Red.red600,
                    disabled = Colors.Neutral.Gray.gray300
                )
            )
        ),

        // ===== ICON TOKENS =====
        icon = IconTokens(
            static = StaticIconTokens(
                regular = RegularIconTokens(
                    primary = Colors.Neutral.Gray.gray800,
                    secondary = Colors.Neutral.Gray.gray600,
                    onDark = Colors.Neutral.white,
                    onLight = Colors.Neutral.Gray.gray800,
                    inverse = Colors.Neutral.white
                ),
                semantic = SemanticIconTokens(
                    success = Colors.Functional.Green.green600,
                    error = Colors.Functional.Red.red600,
                    information = Colors.Functional.Sky.sky600,
                    warning = Colors.Functional.Yellow.yellow600
                )
            ),
            interactive = InteractiveIconTokens(
                regular = InteractiveIconStateTokens(
                    default = Colors.Brand.BcpBlue.blue600,
                    hover = Colors.Brand.BcpBlue.blue700,
                    pressed = Colors.Brand.BcpBlue.blue800,
                    disabled = Colors.Neutral.Gray.gray400
                ),
                danger = InteractiveIconStateTokens(
                    default = Colors.Functional.Red.red600,
                    hover = Colors.Functional.Red.red700,
                    pressed = Colors.Functional.Red.red800,
                    disabled = Colors.Neutral.Gray.gray400
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
