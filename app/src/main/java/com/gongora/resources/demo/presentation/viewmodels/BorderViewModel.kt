package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.tokens.Border

/**
 * ViewModel for the border screen.
 * This ViewModel follows Clean Architecture principles by providing border data from BCP tokens.
 */
class BorderViewModel : ViewModel() {
    
    /**
     * Border width tokens from BCP design system.
     */
    val borderWidthTokens: Map<String, Float> = mapOf(
        "none" to Border.Width.none,
        "regular" to Border.Width.regular,
        "medium" to Border.Width.medium
    )
    
    /**
     * Border radius tokens from BCP design system.
     */
    val borderRadiusTokens: Map<String, Float> = mapOf(
        "none" to Border.Radius.none,
        "small" to Border.Radius.small,
        "base" to Border.Radius.base,
        "medium" to Border.Radius.medium,
        "large" to Border.Radius.large,
        "xl" to Border.Radius.xl,
        "xxl" to Border.Radius.xxl,
        "full" to Border.Radius.full
    )
}
