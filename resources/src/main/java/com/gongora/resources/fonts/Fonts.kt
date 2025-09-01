package com.gongora.resources.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.gongora.resources.R

/**
 * Definición de fuentes personalizadas para el sistema de diseño BCP.
 * Mapea los tokens de tipografía a las fuentes reales de la librería.
 */
object Fonts {

    object Brand {
        val thin = FontFamily(
            Font(R.font.durotype_flexo_thin, FontWeight.Thin)
        )
        val light = FontFamily(
            Font(R.font.durotype_flexo_light, FontWeight.Light)
        )
        val regular = FontFamily(
            Font(R.font.durotype_flexo_regular, FontWeight.Normal)
        )
        val medium = FontFamily(
            Font(R.font.durotype_flexo_medium, FontWeight.Medium)
        )
        val demi = FontFamily(
            Font(R.font.durotype_flexo_demi, FontWeight.SemiBold)
        )
        val bold = FontFamily(
            Font(R.font.durotype_flexo_bold, FontWeight.Bold)
        )
        val heavy = FontFamily(
            Font(R.font.durotype_flexo_heavy, FontWeight.ExtraBold)
        )
        val black = FontFamily(
            Font(R.font.durotype_flexo_black, FontWeight.Black)
        )

        val family = FontFamily(
            Font(R.font.durotype_flexo_thin, FontWeight.Thin),
            Font(R.font.durotype_flexo_light, FontWeight.Light),
            Font(R.font.durotype_flexo_regular, FontWeight.Normal),
            Font(R.font.durotype_flexo_medium, FontWeight.Medium),
            Font(R.font.durotype_flexo_demi, FontWeight.SemiBold),
            Font(R.font.durotype_flexo_bold, FontWeight.Bold),
            Font(R.font.durotype_flexo_heavy, FontWeight.ExtraBold),
            Font(R.font.durotype_flexo_black, FontWeight.Black)
        )
    }

    object Supportive {
        val thin = FontFamily(
            Font(R.font.sourcesans3_extralight, FontWeight.Thin)
        )
        val light = FontFamily(
            Font(R.font.sourcesans3_light, FontWeight.Light)
        )
        val regular = FontFamily(
            Font(R.font.sourcesans3_regular, FontWeight.Normal)
        )
        val medium = FontFamily(
            Font(R.font.sourcesans3_medium, FontWeight.Medium)
        )
        val demi = FontFamily(
            Font(R.font.sourcesans3_semibold, FontWeight.SemiBold)
        )
        val bold = FontFamily(
            Font(R.font.sourcesans3_bold, FontWeight.Bold)
        )
        val heavy = FontFamily(
            Font(R.font.sourcesans3_extrabold, FontWeight.ExtraBold)
        )
        val black = FontFamily(
            Font(R.font.sourcesans3_black, FontWeight.Black)
        )

        val family = FontFamily(
            Font(R.font.sourcesans3_extralight, FontWeight.Thin),
            Font(R.font.sourcesans3_light, FontWeight.Light),
            Font(R.font.sourcesans3_regular, FontWeight.Normal),
            Font(R.font.sourcesans3_medium, FontWeight.Medium),
            Font(R.font.sourcesans3_semibold, FontWeight.SemiBold),
            Font(R.font.sourcesans3_bold, FontWeight.Bold),
            Font(R.font.sourcesans3_extrabold, FontWeight.ExtraBold),
            Font(R.font.sourcesans3_black, FontWeight.Black)
        )
    }
}
