package com.gongora.resources.demo.domain.models

import androidx.compose.ui.graphics.Brush

/**
 * Domain model representing an effect token for display in the demo.
 */
data class EffectToken(
    val key: String,
    val name: String,
    val description: String,
    val category: EffectCategory,
    val elevation: Float = 0f,
    val shadowRadius: Float = 0f,
    val shadowOffsetY: Float = 0f,
    val shadowAlpha: Float = 0f,
    val blurRadius: Float = 0f,
    val glassAlpha: Float = 0f,
    val gradient: Brush? = null,
    val tintColor: Int? = null,
    val blurAmount: Float = 0f,
    val tintAlpha: Float = 0f,
)

/**
 * Enum representing different effect categories.
 */
enum class EffectCategory {
    SHADOW,
    BLUR,
    GLASS,
    GRADIENT
}

