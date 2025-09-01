package com.gongora.resources.demo.domain.models

import androidx.annotation.ColorInt

/**
 * Domain model representing a color token for display in the demo.
 */
data class ColorToken(
    val key: String,
    val value: Any, // Can be String (hex) or ColorInt
    val name: String,
    val category: ColorCategory
)

/**
 * Enum representing different color categories.
 */
enum class ColorCategory {
    BRAND,
    NEUTRAL,
    FUNCTIONAL,
    DECORATIVE
}
