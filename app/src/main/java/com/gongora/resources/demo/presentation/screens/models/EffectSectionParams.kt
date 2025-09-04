package com.gongora.resources.demo.presentation.screens.models

import androidx.compose.ui.graphics.Color

/**
 * Parameters for the EffectSection composable.
 * 
 * This data class encapsulates all the parameters needed to create an effect section,
 * making the function signature cleaner and more maintainable.
 */
data class EffectSectionParams(
    val title: String,
    val description: String,
    val textPrimary: Color,
    val textSecondary: Color,
    val surface: Color
)
