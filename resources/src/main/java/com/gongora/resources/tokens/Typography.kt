package com.gongora.resources.tokens

/**
 * Tokens de tipografía para el sistema de diseño BCP
 *
 * Define un sistema tipográfico completo que incluye:
 * - Familias de fuentes (Brand: Flexo, Supportive: SourceSans3)
 * - Pesos de fuente (thin a black: 100-900)
 * - Tamaños de fuente (xsmall a xlarge: 10px-32px)
 * - Alturas de línea (small a 2xlarge: 16px-40px)
 * - Espaciado de letras (xsmall a none: -2px a 0px)
 */
object Typography {
    
    /**
     * Familias de fuentes disponibles en el sistema de diseño
     */
    object FontFamily {
        /**
         * Fuente principal para títulos y elementos destacados
         * Flexo - Soporta múltiples variantes con nombres específicos por plataforma
         */
        object Brand {
            val thin = "durotype_flexo_thin"
            val light = "durotype_flexo_light"
            val regular = "durotype_flexo_regular"
            val medium = "durotype_flexo_medium"
            val demi = "durotype_flexo_demi"
            val bold = "durotype_flexo_bold"
            val heavy = "durotype_flexo_heavy"
            val black = "durotype_flexo_black"
        }
        
        /**
         * Fuente de apoyo para texto de cuerpo y contenido general
         * SourceSans3 - Soporta múltiples variantes con archivos específicos por peso
         */
        object Supportive {
            val thin = "sourcesans3_extralight"
            val light = "sourcesans3_light"
            val regular = "sourcesans3_regular"
            val medium = "sourcesans3_medium"
            val demi = "sourcesans3_semibold"
            val bold = "sourcesans3_bold"
            val heavy = "sourcesans3_extrabold"
            val black = "sourcesans3_black"
        }
    }
    
    /**
     * Pesos de fuente disponibles en el sistema de diseño
     */
    object FontWeight {
        val thin = 100
        val light = 300
        val regular = 400
        val medium = 500
        val demi = 600
        val bold = 700
        val heavy = 800
        val black = 900
    }
    
    /**
     * Tamaños de fuente disponibles en el sistema de diseño
     */
    object FontSize {
        val xsmall = 10
        val small = 12
        val regular = 16
        val medium = 20
        val large = 24
        val xlarge = 32
    }
    
    /**
     * Alturas de línea disponibles en el sistema de diseño
     */
    object LineHeight {
        val small = 16
        val medium = 24
        val large = 28
        val xlarge = 32
        val x2large = 40
    }
    
    /**
     * Espaciado de letras disponible en el sistema de diseño
     */
    object LetterSpacing {
        val xsmall = -2
        val small = -1
        val none = 0
    }
}
