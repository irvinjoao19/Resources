package com.gongora.resources.demo.presentation.screens.constants

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Constants for the Effects Screen.
 * 
 * This object contains all the magic numbers and hardcoded values used in the EffectsScreen,
 * making the code more maintainable and easier to understand.
 */
object EffectsScreenConstants {
    
    // ===== DEMO BOX DIMENSIONS =====
    
    /**
     * Width of the effect demonstration boxes
     */
    val EFFECT_DEMO_WIDTH: Dp = 280.dp
    
    /**
     * Height of the effect demonstration boxes
     */
    val EFFECT_DEMO_HEIGHT: Dp = 120.dp
    
    // ===== GLASS EFFECT CONSTANTS =====
    
    /**
     * Default corner radius for glass effects
     */
    val GLASS_CORNER_RADIUS: Dp = 12.dp
    
    /**
     * Default corner radius for gradient glass effects
     */
    val GRADIENT_GLASS_CORNER_RADIUS: Dp = 10.dp
    
    /**
     * Alpha value for white tint in glass effects
     */
    const val GLASS_WHITE_TINT_ALPHA: Float = 0.55f
    
    /**
     * Default border width for glass effects
     */
    val GLASS_BORDER_WIDTH: Dp = 1.dp
    
    /**
     * Default border color for glass effects (hex: #9AA3AF)
     */
    const val GLASS_BORDER_COLOR_HEX: Long = 0xFF9AA3AF
    
    // ===== BLUR EFFECT CONSTANTS =====
    
    /**
     * Padding for blur effect boxes
     */
    val BLUR_EFFECT_PADDING: Dp = 20.dp
    
    // ===== LAYOUT CONSTANTS =====
    
    /**
     * Spacing between effect sections
     */
    val SECTION_SPACING: Dp = 24.dp
    
    /**
     * Padding for the main content
     */
    val CONTENT_PADDING: Dp = 16.dp
    
    /**
     * Height for effect demonstration areas
     */
    val EFFECT_DEMO_AREA_HEIGHT: Dp = 120.dp
    
    // ===== CARD CONSTANTS =====
    
    /**
     * Default elevation for effect cards
     */
    val CARD_ELEVATION: Dp = 2.dp
    
    /**
     * Padding inside effect cards
     */
    val CARD_INTERNAL_PADDING: Dp = 16.dp
    
    /**
     * Spacing between title and description in cards
     */
    val TITLE_DESCRIPTION_SPACING: Dp = 8.dp
    
    /**
     * Spacing between description and content in cards
     */
    val DESCRIPTION_CONTENT_SPACING: Dp = 16.dp
}
