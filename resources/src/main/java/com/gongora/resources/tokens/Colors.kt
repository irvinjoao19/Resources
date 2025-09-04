package com.gongora.resources.tokens

import androidx.annotation.ColorInt

/**
 * Tokens de colores para el sistema de diseño BCP
 *
 * Define la paleta completa de colores organizados por categorías semánticas:
 * - Brand: Colores de identidad corporativa (azul y naranja BCP)
 * - Neutral: Escala de grises, blanco y negro para elementos base
 * - Functional: Colores con significado funcional (éxito, error, advertencia, información)
 * - Decorative: Colores adicionales para elementos decorativos y de apoyo
 *
 * Cada categoría sigue una escala numérica de 050 (más claro) a 900 (más oscuro)
 * basada en los principios de Material Design para garantizar consistencia
 * y accesibilidad en toda la aplicación.
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object Colors {
    
    // ===== BRAND COLORS =====
    
    /**
     * Colores de marca BCP - Azul corporativo
     */
    object Brand {
        object BcpBlue {
            @ColorInt val blue050 = 0xFFE6EDFC.toInt()
            @ColorInt val blue100 = 0xFFC4D7FF.toInt()
            @ColorInt val blue200 = 0xFF98B9FE.toInt()
            @ColorInt val blue300 = 0xFF6D9BFD.toInt()
            @ColorInt val blue400 = 0xFF427DFC.toInt()
            @ColorInt val blue500 = 0xFF175EFB.toInt()
            @ColorInt val blue600 = 0xFF0549E1.toInt()
            @ColorInt val blue700 = 0xFF043AB5.toInt()
            @ColorInt val blue800 = 0xFF042C89.toInt()
            @ColorInt val blue900 = 0xFF031E5E.toInt()
        }
        
        object BcpOrange {
            @ColorInt val orange050 = 0xFFFFEBE0.toInt()
            @ColorInt val orange100 = 0xFFFFD7C3.toInt()
            @ColorInt val orange200 = 0xFFFFBA95.toInt()
            @ColorInt val orange300 = 0xFFFF9D68.toInt()
            @ColorInt val orange400 = 0xFFFF803B.toInt()
            @ColorInt val orange500 = 0xFFF7630C.toInt()
            @ColorInt val orange600 = 0xFFCC4B00.toInt()
            @ColorInt val orange700 = 0xFFB24200.toInt()
            @ColorInt val orange800 = 0xFF843200.toInt()
            @ColorInt val orange900 = 0xFF562100.toInt()
        }
    }
    
    // ===== NEUTRAL COLORS =====
    
    /**
     * Colores neutrales - Grises, blanco y negro
     */
    object Neutral {
        object Gray {
            @ColorInt val gray050 = 0xFFF1F4F8.toInt()
            @ColorInt val gray100 = 0xFFD7DBE0.toInt()
            @ColorInt val gray200 = 0xFFB9BFC7.toInt()
            @ColorInt val gray300 = 0xFF9CA4AE.toInt()
            @ColorInt val gray400 = 0xFF818A95.toInt()
            @ColorInt val gray500 = 0xFF66717E.toInt()
            @ColorInt val gray600 = 0xFF4C5867.toInt()
            @ColorInt val gray700 = 0xFF344151.toInt()
            @ColorInt val gray800 = 0xFF16202C.toInt()
            @ColorInt val gray900 = 0xFF071525.toInt()
        }
        
        object Orange {
            @ColorInt val orange0501 = 0xFFFFEBE0.toInt()
        }
        
        @ColorInt val white = 0xFFFFFFFF.toInt()
        @ColorInt val black = 0xFF000000.toInt()
    }
    
    // ===== FUNCTIONAL COLORS =====
    
    /**
     * Colores funcionales - Con significado semántico
     */
    object Functional {
        object Green {
            @ColorInt val green050 = 0xFFE7F9E7.toInt()
            @ColorInt val green100 = 0xFFC2F3C2.toInt()
            @ColorInt val green200 = 0xFFA1E8A1.toInt()
            @ColorInt val green300 = 0xFF7AD17A.toInt()
            @ColorInt val green400 = 0xFF65B965.toInt()
            @ColorInt val green500 = 0xFF4DA34D.toInt()
            @ColorInt val green600 = 0xFF398439.toInt()
            @ColorInt val green700 = 0xFF266A26.toInt()
            @ColorInt val green800 = 0xFF114B11.toInt()
            @ColorInt val green900 = 0xFF022C02.toInt()
        }
        
        object Red {
            @ColorInt val red050 = 0xFFFFEBEF.toInt()
            @ColorInt val red100 = 0xFFFFD6E0.toInt()
            @ColorInt val red200 = 0xFFFFB9C9.toInt()
            @ColorInt val red300 = 0xFFFE90A9.toInt()
            @ColorInt val red400 = 0xFFFE6C8A.toInt()
            @ColorInt val red500 = 0xFFFB2D55.toInt()
            @ColorInt val red600 = 0xFFD80329.toInt()
            @ColorInt val red700 = 0xFFB00320.toInt()
            @ColorInt val red800 = 0xFF820317.toInt()
            @ColorInt val red900 = 0xFF46010C.toInt()
        }
        
        object Yellow {
            @ColorInt val yellow050 = 0xFFFFF5D6.toInt()
            @ColorInt val yellow100 = 0xFFFFEDB9.toInt()
            @ColorInt val yellow200 = 0xFFFEDF91.toInt()
            @ColorInt val yellow300 = 0xFFFECE6A.toInt()
            @ColorInt val yellow400 = 0xFFFDBB43.toInt()
            @ColorInt val yellow500 = 0xFFFCA51D.toInt()
            @ColorInt val yellow600 = 0xFFE28404.toInt()
            @ColorInt val yellow700 = 0xFFAF6204.toInt()
            @ColorInt val yellow800 = 0xFF7C4103.toInt()
            @ColorInt val yellow900 = 0xFF3C1E02.toInt()
        }
        
        object Sky {
            @ColorInt val sky050 = 0xFFE4F5FB.toInt()
            @ColorInt val sky100 = 0xFFCAEAF8.toInt()
            @ColorInt val sky200 = 0xFFA1D9F4.toInt()
            @ColorInt val sky300 = 0xFF77C6F2.toInt()
            @ColorInt val sky400 = 0xFF4BB1F1.toInt()
            @ColorInt val sky500 = 0xFF1E9AF1.toInt()
            @ColorInt val sky600 = 0xFF0A78CD.toInt()
            @ColorInt val sky700 = 0xFF0561B0.toInt()
            @ColorInt val sky800 = 0xFF02366A.toInt()
            @ColorInt val sky900 = 0xFF001B38.toInt()
        }
    }
    
    // ===== DECORATIVE COLORS =====
    
    /**
     * Colores decorativos - Para elementos de apoyo
     */
    object Decorative {
        object Teal {
            @ColorInt val teal050 = 0xFFE3FCF7.toInt()
            @ColorInt val teal100 = 0xFFBBF7ED.toInt()
            @ColorInt val teal200 = 0xFF7DE8D8.toInt()
            @ColorInt val teal300 = 0xFF6AD3C4.toInt()
            @ColorInt val teal400 = 0xFF57BDAE.toInt()
            @ColorInt val teal500 = 0xFF44A294.toInt()
            @ColorInt val teal600 = 0xFF328E81.toInt()
            @ColorInt val teal700 = 0xFF207569.toInt()
            @ColorInt val teal800 = 0xFF0D544B.toInt()
            @ColorInt val teal900 = 0xFF003B34.toInt()
        }
        
        object Violet {
            @ColorInt val violet050 = 0xFFF4EEFB.toInt()
            @ColorInt val violet100 = 0xFFDBCEF4.toInt()
            @ColorInt val violet200 = 0xFFC0A9ED.toInt()
            @ColorInt val violet300 = 0xFFA482E7.toInt()
            @ColorInt val violet400 = 0xFF885AE2.toInt()
            @ColorInt val violet500 = 0xFF733EDA.toInt()
            @ColorInt val violet600 = 0xFF561CC6.toInt()
            @ColorInt val violet700 = 0xFF4414A1.toInt()
            @ColorInt val violet800 = 0xFF330E7B.toInt()
            @ColorInt val violet900 = 0xFF220854.toInt()
        }
        
        object Pink {
            @ColorInt val pink050 = 0xFFFFEBF7.toInt()
            @ColorInt val pink100 = 0xFFFFCCEA.toInt()
            @ColorInt val pink200 = 0xFFFF9CD6.toInt()
            @ColorInt val pink300 = 0xFFFA6CBF.toInt()
            @ColorInt val pink400 = 0xFFFA4BB1.toInt()
            @ColorInt val pink500 = 0xFFED2F9E.toInt()
            @ColorInt val pink600 = 0xFFB30A6D.toInt()
            @ColorInt val pink700 = 0xFF81094F.toInt()
            @ColorInt val pink800 = 0xFF5A0737.toInt()
            @ColorInt val pink900 = 0xFF370623.toInt()
        }
        
        object Cyan {
            @ColorInt val cyan050 = 0xFFE0FBFF.toInt()
            @ColorInt val cyan100 = 0xFFCCF7FF.toInt()
            @ColorInt val cyan200 = 0xFF8EEAFA.toInt()
            @ColorInt val cyan300 = 0xFF74DBED.toInt()
            @ColorInt val cyan400 = 0xFF6ACDDE.toInt()
            @ColorInt val cyan500 = 0xFF24B1CA.toInt()
            @ColorInt val cyan600 = 0xFF159BB3.toInt()
            @ColorInt val cyan700 = 0xFF096F81.toInt()
            @ColorInt val cyan800 = 0xFF074E5A.toInt()
            @ColorInt val cyan900 = 0xFF063037.toInt()
        }
        
        object Lime {
            @ColorInt val lime050 = 0xFFF9F6DC.toInt()
            @ColorInt val lime100 = 0xFFF7F3B4.toInt()
            @ColorInt val lime200 = 0xFFF5ED83.toInt()
            @ColorInt val lime300 = 0xFFF5EA54.toInt()
            @ColorInt val lime400 = 0xFFF2E524.toInt()
            @ColorInt val lime500 = 0xFFDBCD08.toInt()
            @ColorInt val lime600 = 0xFFB0A506.toInt()
            @ColorInt val lime700 = 0xFF7F7704.toInt()
            @ColorInt val lime800 = 0xFF5D5704.toInt()
            @ColorInt val lime900 = 0xFF3B3702.toInt()
        }
    }
    
    // ===== ALPHA UTILITIES =====
    
    /**
     * Valores de transparencia predefinidos para mantener consistencia
     * Matching React Native alphaValues
     */
    object AlphaValues {
        const val alpha_00 = 0.0f
        const val alpha_10 = 0.1f
        const val alpha_15 = 0.15f
        const val alpha_20 = 0.2f
        const val alpha_30 = 0.3f
        const val alpha_40 = 0.4f
        const val alpha_50 = 0.5f
        const val alpha_60 = 0.6f
        const val alpha_70 = 0.7f
        const val alpha_80 = 0.8f
        const val alpha_90 = 0.9f
    }
    
    /**
     * Función helper para aplicar alpha a un color
     * Matching React Native colorWithAlpha function
     * 
     * @param color Color base del sistema
     * @param alpha Valor de alpha entre 0.0f y 1.0f
     * @return Color con transparencia aplicada
     * 
     * @example
     * ```kotlin
     * val transparentBlue = colorWithAlpha(Colors.Brand.BcpBlue.blue500, AlphaValues.alpha_70)
     * val transparentWhite = colorWithAlpha(Colors.Neutral.white, AlphaValues.alpha_20)
     * ```
     */
    fun colorWithAlpha(@ColorInt color: Int, alpha: Float): Int {
        // Extraer componentes RGB del color
        val red = android.graphics.Color.red(color)
        val green = android.graphics.Color.green(color)
        val blue = android.graphics.Color.blue(color)
        
        // Aplicar alpha y convertir de vuelta a Int
        return android.graphics.Color.argb(
            (alpha * 255).toInt(),
            red,
            green,
            blue
        )
    }
}
