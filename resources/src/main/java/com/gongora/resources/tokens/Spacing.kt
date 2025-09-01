package com.gongora.resources.tokens

/**
 * Tokens de espaciado para el sistema de diseño BCP
 *
 * Define un sistema de espaciado consistente basado en múltiplos de 4dp
 * que garantiza coherencia visual en toda la aplicación.
 *
 * **Escala de espaciado:**
 * - Base: 4dp (unidad fundamental)
 * - Escala: 4, 8, 12, 16, 20, 24, 32, 40, 48, 56, 64, 80, 96, 128, 160, 192, 224, 256
 *
 * **Categorías:**
 * - **Tiny**: Espaciado mínimo (4-8dp)
 * - **Small**: Espaciado pequeño (12-16dp)
 * - **Medium**: Espaciado medio (20-32dp)
 * - **Large**: Espaciado grande (40-64dp)
 * - **XLarge**: Espaciado extra grande (80-128dp)
 * - **XXLarge**: Espaciado máximo (160-256dp)
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object Spacing {
    
    // ===== BASE SPACING =====
    
    /**
     * Espaciado base - unidad fundamental del sistema
     */
    const val base = 4f
    
    // ===== TINY SPACING =====
    
    /**
     * Espaciado mínimo para elementos muy cercanos
     */
    object Tiny {
        const val xsmall = 4f
        const val small = 8f
    }
    
    // ===== SMALL SPACING =====
    
    /**
     * Espaciado pequeño para elementos relacionados
     */
    object Small {
        const val xsmall = 12f
        const val small = 16f
    }
    
    // ===== MEDIUM SPACING =====
    
    /**
     * Espaciado medio para secciones y grupos
     */
    object Medium {
        const val xsmall = 20f
        const val small = 24f
        const val medium = 32f
    }
    
    // ===== LARGE SPACING =====
    
    /**
     * Espaciado grande para secciones principales
     */
    object Large {
        const val xsmall = 40f
        const val small = 48f
        const val medium = 56f
        const val large = 64f
    }
    
    // ===== XLARGE SPACING =====
    
    /**
     * Espaciado extra grande para contenedores principales
     */
    object XLarge {
        const val xsmall = 80f
        const val small = 96f
        const val medium = 128f
    }
    
    // ===== XXLARGE SPACING =====
    
    /**
     * Espaciado máximo para layouts principales
     */
    object XXLarge {
        const val xsmall = 160f
        const val small = 192f
        const val medium = 224f
        const val large = 256f
    }
    
    // ===== UTILITY VALUES =====
    
    /**
     * Valores de espaciado comúnmente utilizados
     */
    object Common {
        const val none = 0f
        const val xs = Tiny.xsmall
        const val sm = Tiny.small
        const val md = Small.xsmall
        const val lg = Small.small
        const val xl = Medium.xsmall
        const val xxl = Medium.small
        const val xxxl = Medium.medium
        const val xxxxl = Large.xsmall
    }
    
    // ===== MARGIN & PADDING =====
    
    /**
     * Espaciado específico para márgenes
     */
    object Margin {
        const val none = 0f
        const val xs = Tiny.xsmall
        const val sm = Tiny.small
        const val md = Small.xsmall
        const val lg = Small.small
        const val xl = Medium.xsmall
        const val xxl = Medium.small
        const val xxxl = Medium.medium
        const val xxxxl = Large.xsmall
    }
    
    /**
     * Espaciado específico para padding
     */
    object Padding {
        const val none = 0f
        const val xs = Tiny.xsmall
        const val sm = Tiny.small
        const val md = Small.xsmall
        const val lg = Small.small
        const val xl = Medium.xsmall
        const val xxl = Medium.small
        const val xxxl = Medium.medium
        const val xxxxl = Large.xsmall
    }
    
    // ===== UTILITY FUNCTIONS =====
    
    /**
     * Calcula el espaciado basado en múltiplos del valor base
     */
    fun multiply(baseMultiplier: Int): Float {
        return base * baseMultiplier
    }
    
    /**
     * Obtiene el espaciado para un nivel específico
     */
    fun getLevel(level: Int): Float {
        return when (level) {
            0 -> Common.none
            1 -> Common.xs
            2 -> Common.sm
            3 -> Common.md
            4 -> Common.lg
            5 -> Common.xl
            6 -> Common.xxl
            7 -> Common.xxxl
            8 -> Common.xxxxl
            else -> multiply(level)
        }
    }
}
