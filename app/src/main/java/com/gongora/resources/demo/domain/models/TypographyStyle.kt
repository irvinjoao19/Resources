package com.gongora.resources.demo.domain.models

import androidx.compose.ui.text.TextStyle

/**
 * Model representing a typography style with all its properties
 */
data class TypographyStyle(
    val name: String,
    val description: String,
    val textStyle: TextStyle,
    val properties: TypographyProperties
)

/**
 * Model representing the properties of a typography style
 */
data class TypographyProperties(
    val fontFamily: String,
    val fontSize: Float,
    val fontWeight: Int,
    val lineHeight: Float,
    val letterSpacing: Float,
    val textDecoration: String? = null
)

