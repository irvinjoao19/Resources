package com.gongora.resources.tokens

import android.graphics.Color
import androidx.annotation.ColorInt

/**
 * Tokens de efectos visuales para el sistema de diseño BCP
 *
 * Define efectos visuales consistentes que incluyen:
 * - Sombras (elevation, shadow)
 * - Efectos de blur
 * - Efectos de glass (cristal)
 * - Gradientes
 *
 * **Tipos de efectos:**
 * - **Shadow**: Sombras para elevación y profundidad
 * - **Blur**: Efectos de desenfoque
 * - **Glass**: Efectos de cristal con transparencia
 * - **Gradient**: Gradientes lineales y radiales
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object Effects {
    
    // ===== SHADOW EFFECTS =====
    
    /**
     * Efectos de sombra para elevación y profundidad
     */
    object Shadow {
        /**
         * Sombra pequeña para elementos ligeramente elevados
         */
        object Small {
            const val elevation = 2f
            const val shadowRadius = 4f
            const val shadowOffsetX = 0f
            const val shadowOffsetY = 2f
            @ColorInt val shadowColor = Color.parseColor("#000000")
            const val shadowAlpha = 0.1f
        }
        
        /**
         * Sombra media para elementos moderadamente elevados
         */
        object Medium {
            const val elevation = 4f
            const val shadowRadius = 8f
            const val shadowOffsetX = 0f
            const val shadowOffsetY = 4f
            @ColorInt val shadowColor = Color.parseColor("#000000")
            const val shadowAlpha = 0.15f
        }
        
        /**
         * Sombra grande para elementos altamente elevados
         */
        object Large {
            const val elevation = 8f
            const val shadowRadius = 16f
            const val shadowOffsetX = 0f
            const val shadowOffsetY = 8f
            @ColorInt val shadowColor = Color.parseColor("#000000")
            const val shadowAlpha = 0.2f
        }
        
        /**
         * Sombra extra grande para elementos muy elevados
         */
        object XLarge {
            const val elevation = 16f
            const val shadowRadius = 24f
            const val shadowOffsetX = 0f
            const val shadowOffsetY = 12f
            @ColorInt val shadowColor = Color.parseColor("#000000")
            const val shadowAlpha = 0.25f
        }
    }
    
    // ===== BLUR EFFECTS =====
    
    /**
     * Efectos de desenfoque (blur)
     */
    object Blur {
        /**
         * Blur ligero para efectos sutiles
         */
        object Light {
            const val radius = 4f
            const val alpha = 0.8f
        }
        
        /**
         * Blur medio para efectos moderados
         */
        object Medium {
            const val radius = 8f
            const val alpha = 0.9f
        }
        
        /**
         * Blur fuerte para efectos intensos
         */
        object Heavy {
            const val radius = 16f
            const val alpha = 0.95f
        }
    }
    
    // ===== GLASS EFFECTS =====
    
    /**
     * Efectos de cristal (glass morphism)
     */
    object Glass {
        /**
         * Efecto de cristal ligero
         */
        object Light {
            const val alpha = 0.1f
            const val blurRadius = 4f
            @ColorInt val tintColor = Color.parseColor("#FFFFFF")
        }
        
        /**
         * Efecto de cristal medio
         */
        object Medium {
            const val alpha = 0.2f
            const val blurRadius = 8f
            @ColorInt val tintColor = Color.parseColor("#FFFFFF")
        }
        
        /**
         * Efecto de cristal fuerte
         */
        object Heavy {
            const val alpha = 0.3f
            const val blurRadius = 16f
            @ColorInt val tintColor = Color.parseColor("#FFFFFF")
        }
    }
    
    // ===== GRADIENT EFFECTS =====
    
    /**
     * Efectos de gradiente
     */
    object Gradient {
        /**
         * Gradientes lineales predefinidos
         */
        object Linear {
            /**
             * Gradiente azul BCP
             */
            object BcpBlue {
                @ColorInt val startColor = Color.parseColor("#175EFB")
                @ColorInt val endColor = Color.parseColor("#0549E1")
                const val angle = 45f
            }
            
            /**
             * Gradiente naranja BCP
             */
            object BcpOrange {
                @ColorInt val startColor = Color.parseColor("#F7630C")
                @ColorInt val endColor = Color.parseColor("#CC4B00")
                const val angle = 45f
            }
            
            /**
             * Gradiente neutral
             */
            object Neutral {
                @ColorInt val startColor = Color.parseColor("#F1F4F8")
                @ColorInt val endColor = Color.parseColor("#D7DBE0")
                const val angle = 45f
            }
        }
        
        /**
         * Gradientes radiales predefinidos
         */
        object Radial {
            /**
             * Gradiente radial azul
             */
            object Blue {
                @ColorInt val centerColor = Color.parseColor("#175EFB")
                @ColorInt val edgeColor = Color.parseColor("#0549E1")
                const val radius = 100f
            }
            
            /**
             * Gradiente radial naranja
             */
            object Orange {
                @ColorInt val centerColor = Color.parseColor("#F7630C")
                @ColorInt val edgeColor = Color.parseColor("#CC4B00")
                const val radius = 100f
            }
        }
    }
    
    // ===== UTILITY FUNCTIONS =====
    
    /**
     * Obtiene la elevación para un nivel específico
     */
    fun getElevation(level: Int): Float {
        return when (level) {
            0 -> 0f
            1 -> Shadow.Small.elevation
            2 -> Shadow.Medium.elevation
            3 -> Shadow.Large.elevation
            4 -> Shadow.XLarge.elevation
            else -> Shadow.Small.elevation
        }
    }
    
    /**
     * Obtiene el radio de sombra para un nivel específico
     */
    fun getShadowRadius(level: Int): Float {
        return when (level) {
            0 -> 0f
            1 -> Shadow.Small.shadowRadius
            2 -> Shadow.Medium.shadowRadius
            3 -> Shadow.Large.shadowRadius
            4 -> Shadow.XLarge.shadowRadius
            else -> Shadow.Small.shadowRadius
        }
    }
    
    /**
     * Obtiene el offset Y de sombra para un nivel específico
     */
    fun getShadowOffsetY(level: Int): Float {
        return when (level) {
            0 -> 0f
            1 -> Shadow.Small.shadowOffsetY
            2 -> Shadow.Medium.shadowOffsetY
            3 -> Shadow.Large.shadowOffsetY
            4 -> Shadow.XLarge.shadowOffsetY
            else -> Shadow.Small.shadowOffsetY
        }
    }
    
    /**
     * Obtiene el color de sombra con alpha para un nivel específico
     */
    fun getShadowColor(level: Int): Int {
        val alpha = when (level) {
            0 -> 0f
            1 -> Shadow.Small.shadowAlpha
            2 -> Shadow.Medium.shadowAlpha
            3 -> Shadow.Large.shadowAlpha
            4 -> Shadow.XLarge.shadowAlpha
            else -> Shadow.Small.shadowAlpha
        }
        
        return Color.argb(
            (alpha * 255).toInt(),
            Color.red(Shadow.Small.shadowColor),
            Color.green(Shadow.Small.shadowColor),
            Color.blue(Shadow.Small.shadowColor)
        )
    }
}
