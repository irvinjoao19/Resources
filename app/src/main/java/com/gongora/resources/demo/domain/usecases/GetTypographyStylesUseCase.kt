package com.gongora.resources.demo.domain.usecases

import com.gongora.resources.demo.domain.models.TypographyProperties
import com.gongora.resources.demo.domain.models.TypographyStyle
import com.gongora.resources.tokens.Typography
import com.gongora.resources.typography.TypographyUtils
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextDecoration

class GetTypographyStylesUseCase {

    operator fun invoke(): List<TypographyStyle> {
        return listOf(
            // Headings
            createTypographyStyle(
                name = "h1",
                description = "Título principal - Para encabezados de página",
                fontFamily = Typography.FontFamily.Brand.medium,
                fontSize = Typography.FontSize.xlarge,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.x2large,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "h2",
                description = "Título secundario - Para secciones importantes",
                fontFamily = Typography.FontFamily.Brand.medium,
                fontSize = Typography.FontSize.large,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.xlarge,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "h3",
                description = "Título terciario - Para subsecciones",
                fontFamily = Typography.FontFamily.Brand.medium,
                fontSize = Typography.FontSize.medium,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.large,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "h4",
                description = "Título cuaternario - Para elementos menores",
                fontFamily = Typography.FontFamily.Brand.medium,
                fontSize = Typography.FontSize.regular,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.medium,
                letterSpacing = Typography.LetterSpacing.none
            ),
            
            // Body Text
            createTypographyStyle(
                name = "body",
                description = "Texto de cuerpo - Para contenido principal",
                fontFamily = Typography.FontFamily.Supportive.regular,
                fontSize = Typography.FontSize.regular,
                fontWeight = Typography.FontWeight.regular,
                lineHeight = Typography.LineHeight.medium,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "bodyLink",
                description = "Enlaces en texto de cuerpo",
                fontFamily = Typography.FontFamily.Supportive.regular,
                fontSize = Typography.FontSize.regular,
                fontWeight = Typography.FontWeight.regular,
                lineHeight = Typography.LineHeight.medium,
                letterSpacing = Typography.LetterSpacing.none,
                hasUnderline = true
            ),
            createTypographyStyle(
                name = "bodyStrong",
                description = "Texto de cuerpo enfatizado",
                fontFamily = Typography.FontFamily.Supportive.medium,
                fontSize = Typography.FontSize.regular,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.medium,
                letterSpacing = Typography.LetterSpacing.none
            ),
            
            // Small Body Text
            createTypographyStyle(
                name = "bodySmall",
                description = "Texto de cuerpo pequeño",
                fontFamily = Typography.FontFamily.Supportive.regular,
                fontSize = Typography.FontSize.small,
                fontWeight = Typography.FontWeight.regular,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "bodySmallLink",
                description = "Enlaces en texto pequeño",
                fontFamily = Typography.FontFamily.Supportive.regular,
                fontSize = Typography.FontSize.small,
                fontWeight = Typography.FontWeight.regular,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none,
                hasUnderline = true
            ),
            createTypographyStyle(
                name = "bodySmallStrong",
                description = "Texto pequeño enfatizado",
                fontFamily = Typography.FontFamily.Supportive.medium,
                fontSize = Typography.FontSize.small,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none
            ),
            
            // Button Text
            createTypographyStyle(
                name = "button",
                description = "Texto para botones principales",
                fontFamily = Typography.FontFamily.Brand.medium,
                fontSize = Typography.FontSize.regular,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.medium,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "buttonSmall",
                description = "Texto para botones pequeños",
                fontFamily = Typography.FontFamily.Brand.medium,
                fontSize = Typography.FontSize.small,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none
            ),
            
            // Caption Text
            createTypographyStyle(
                name = "caption",
                description = "Texto de descripción o metadatos",
                fontFamily = Typography.FontFamily.Supportive.regular,
                fontSize = Typography.FontSize.xsmall,
                fontWeight = Typography.FontWeight.regular,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none
            ),
            createTypographyStyle(
                name = "captionLink",
                description = "Enlaces en texto de descripción",
                fontFamily = Typography.FontFamily.Supportive.regular,
                fontSize = Typography.FontSize.xsmall,
                fontWeight = Typography.FontWeight.regular,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none,
                hasUnderline = true
            ),
            createTypographyStyle(
                name = "captionStrong",
                description = "Texto de descripción enfatizado",
                fontFamily = Typography.FontFamily.Supportive.medium,
                fontSize = Typography.FontSize.xsmall,
                fontWeight = Typography.FontWeight.medium,
                lineHeight = Typography.LineHeight.small,
                letterSpacing = Typography.LetterSpacing.none
            )
        )
    }

    private fun createTypographyStyle(
        name: String,
        description: String,
        fontFamily: String,
        fontSize: Int,
        fontWeight: Int,
        lineHeight: Int,
        letterSpacing: Int,
        hasUnderline: Boolean = false
    ): TypographyStyle {
        
        // Mapear la familia de fuente a FontFamily de Compose usando TypographyUtils
        val composeFontFamily = TypographyUtils.getFontFamily(fontFamily)
        
        val textStyle = TextStyle(
            fontFamily = composeFontFamily,
            fontWeight = TypographyUtils.mapToComposeFontWeight(fontWeight),
            fontSize = fontSize.sp,
            lineHeight = lineHeight.sp,
            letterSpacing = letterSpacing.sp,
            textDecoration = if (hasUnderline) TextDecoration.Underline else null
        )

        val properties = TypographyProperties(
            fontFamily = fontFamily,
            fontSize = fontSize.toFloat(),
            fontWeight = fontWeight,
            lineHeight = lineHeight.toFloat(),
            letterSpacing = letterSpacing.toFloat(),
            textDecoration = if (hasUnderline) "underline" else null
        )

        return TypographyStyle(
            name = name,
            description = description,
            textStyle = textStyle,
            properties = properties
        )
    }
}
