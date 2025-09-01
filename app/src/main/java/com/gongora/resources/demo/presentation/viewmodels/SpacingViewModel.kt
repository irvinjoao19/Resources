package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.presentation.screens.SpacingToken

/**
 * ViewModel for the spacing screen.
 * This ViewModel follows Clean Architecture principles by providing spacing data from BCP tokens.
 */
class SpacingViewModel : ViewModel() {
    
    /**
     * Spacing tokens with their values and usage examples.
     */
    val spacingTokens: List<SpacingToken> = listOf(
        SpacingToken(
            name = "XSmall (4dp)",
            description = "Espaciado mínimo para elementos muy pequeños",
            value = 4,
            usage = "Padding interno de iconos, separación mínima entre elementos"
        ),
        SpacingToken(
            name = "Small (8dp)",
            description = "Espaciado pequeño para elementos cercanos",
            value = 8,
            usage = "Padding de botones pequeños, margen entre elementos relacionados"
        ),
        SpacingToken(
            name = "Medium (16dp)",
            description = "Espaciado estándar para la mayoría de elementos",
            value = 16,
            usage = "Padding de tarjetas, margen entre secciones, espaciado de contenido"
        ),
        SpacingToken(
            name = "Large (24dp)",
            description = "Espaciado grande para separar secciones",
            value = 24,
            usage = "Margen entre grupos de elementos, padding de pantallas"
        ),
        SpacingToken(
            name = "XLarge (32dp)",
            description = "Espaciado extra grande para separación importante",
            value = 32,
            usage = "Separación entre pantallas, margen de secciones principales"
        ),
        SpacingToken(
            name = "XXLarge (48dp)",
            description = "Espaciado muy grande para elementos destacados",
            value = 48,
            usage = "Margen de pantallas completas, separación de componentes principales"
        ),
        SpacingToken(
            name = "XXXLarge (64dp)",
            description = "Espaciado máximo para elementos de máxima importancia",
            value = 64,
            usage = "Separación de secciones principales, margen de pantallas especiales"
        )
    )
}
