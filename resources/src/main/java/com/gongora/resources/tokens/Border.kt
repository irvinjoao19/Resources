package com.gongora.resources.tokens

/**
 * Tokens de bordes para el sistema de diseño BCP
 *
 * Define un sistema de bordes consistente que incluye:
 * - Anchos de borde (thin a thick)
 * - Radios de borde (none a xlarge)
 * - Estilos de borde predefinidos
 *
 * **Escala de anchos:**
 * - Thin: 1dp
 * - Medium: 2dp
 * - Thick: 4dp
 *
 * **Escala de radios:**
 * - None: 0dp
 * - Small: 4dp
 * - Medium: 8dp
 * - Large: 12dp
 * - XLarge: 16dp
 * - XXLarge: 24dp
 * - XXXLarge: 32dp
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object Border {
    
    // ===== BORDER WIDTHS =====
    
    /**
     * Anchos de borde disponibles
     */
    object Width {
        const val none = 0f
        const val regular = 1f
        const val medium = 2f
    }
    
    // ===== BORDER RADIUS =====
    
    /**
     * Radios de borde disponibles
     */
    object Radius {
        const val none = 0f
        const val small = 2f
        const val base = 4f
        const val medium = 8f
        const val large = 16f
        const val xl = 24f
        const val xxl = 32f
        const val full = 999f
    }
    
    // ===== BORDER STYLES =====
    
    /**
     * Estilos de borde predefinidos
     */
    object Style {
        /**
         * Bordes para botones
         */
        object Button {
            const val primary = "button_primary"
            const val secondary = "button_secondary"
            const val outline = "button_outline"
            const val ghost = "button_ghost"
        }
        
        /**
         * Bordes para tarjetas
         */
        object Card {
            const val default = "card_default"
            const val elevated = "card_elevated"
            const val outlined = "card_outlined"
        }
        
        /**
         * Bordes para inputs
         */
        object Input {
            const val default = "input_default"
            const val focused = "input_focused"
            const val error = "input_error"
            const val disabled = "input_disabled"
        }
        
        /**
         * Bordes para modales
         */
        object Modal {
            const val default = "modal_default"
            const val bottomSheet = "modal_bottom_sheet"
            const val dialog = "modal_dialog"
        }
    }
    
    // ===== UTILITY FUNCTIONS =====
    
    /**
     * Obtiene el ancho de borde para un nivel específico
     */
    fun getWidth(level: Int): Float {
        return when (level) {
            0 -> Width.none
            1 -> Width.regular
            2 -> Width.medium
            else -> Width.regular
        }
    }
    
    /**
     * Obtiene el radio de borde para un nivel específico
     */
    fun getRadius(level: Int): Float {
        return when (level) {
            0 -> Radius.none
            1 -> Radius.small
            2 -> Radius.base
            3 -> Radius.medium
            4 -> Radius.large
            5 -> Radius.xl
            6 -> Radius.xxl
            7 -> Radius.full
            else -> Radius.none
        }
    }
    
    /**
     * Calcula el radio de borde basado en el tamaño del elemento
     */
    fun getRadiusBySize(size: Float): Float {
        return when {
            size <= 24f -> Radius.small
            size <= 48f -> Radius.base
            size <= 96f -> Radius.medium
            size <= 160f -> Radius.large
            else -> Radius.xl
        }
    }
    
    /**
     * Obtiene el radio de borde para elementos circulares
     */
    fun getCircularRadius(size: Float): Float {
        return Radius.full
    }
}
