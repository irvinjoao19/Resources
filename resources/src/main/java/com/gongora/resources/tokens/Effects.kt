package com.gongora.resources.tokens

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color

/**
 * Tokens de efectos visuales para el sistema de diseño BCP
 *
 * Define una colección completa de efectos visuales para crear interfaces con profundidad
 * y modernidad visual. Incluye efectos de vidrio (glass), gradientes con transparencia,
 * efectos de desenfoque (blur) y sombras con diferentes intensidades.
 *
 * Los efectos están organizados en categorías funcionales:
 * - Glass: Efectos de vidrio con transparencia y bordes difuminados
 * - Gradient Glass: Gradientes temáticos con efecto de vidrio
 * - Blur: Efectos de desenfoque para fondos y overlays
 * - Shadows: Sombras con diferentes elevaciones y opacidades
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object Effects {

    // ===== GLASS EFFECTS =====

    /**
     * Efectos de cristal (glass morphism)
     */
    object Glass {
        /**
         * Efecto de cristal para tarjetas
         */
        object EffectGlass {
            val xlarge = Blur.XLarge
            val glassBG = GradientGlass.GlassBG
        }
    }

    /**
     * Efectos de gradiente con cristal
     */
    object GradientGlass {

        /**
         * Gradiente glass para logo
         */
        object GlassBG {
            const val startX = 1f
            const val startY = 0f
            const val endX = -0.33f
            const val endY = 1.41f
            const val alpha = Colors.AlphaValues.alpha_15
        }
    }

    /**
     * Efectos de desenfoque (blur)
     */
    object Blur {
        /**
         * Efecto de blur para formas
         */
        object XLarge {
            const val blurAmount = 64f
            const val tintAlpha = 0.25f
        }
    }

    // ===== SHADOW EFFECTS =====


    object Shadows {
        object ShadowLarge {
            val shadowColor = Color(Colors.Neutral.black).copy(alpha = Colors.AlphaValues.alpha_10)
            const val offsetX = 0f
            const val offsetY = 8f
            const val blur = 32f
            const val spread = 0f
            const val elevation = 10f
        }
    }
}
