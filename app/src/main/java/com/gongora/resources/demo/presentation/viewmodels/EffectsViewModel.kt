package com.gongora.resources.demo.presentation.viewmodels

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.presentation.screens.EffectToken
import com.gongora.resources.demo.presentation.screens.EffectType

/**
 * ViewModel for the effects screen.
 * This ViewModel follows Clean Architecture principles by providing visual effects data.
 */
class EffectsViewModel : ViewModel() {
    
    /**
     * Visual effects tokens with examples and usage information.
     */
    val effectsTokens: List<EffectToken> = listOf(
        EffectToken(
            name = "Sombra Suave",
            description = "Sombra sutil para elementos elevados",
            type = EffectType.SHADOW,
            value = 2,
            usage = "Tarjetas, botones, elementos con elevación mínima",
            previewText = "S"
        ),
        EffectToken(
            name = "Sombra Media",
            description = "Sombra moderada para elementos destacados",
            type = EffectType.SHADOW,
            value = 4,
            usage = "Modales, diálogos, elementos de alta importancia",
            previewText = "M"
        ),
        EffectToken(
            name = "Sombra Fuerte",
            description = "Sombra intensa para elementos principales",
            type = EffectType.SHADOW,
            value = 8,
            usage = "Navegación, elementos de máxima elevación",
            previewText = "F"
        ),
        EffectToken(
            name = "Gradiente Primario",
            description = "Gradiente usando colores primarios del sistema",
            type = EffectType.GRADIENT,
            value = 0,
            usage = "Botones principales, elementos destacados",
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF1976D2), // Blue
                    Color(0xFF42A5F5)  // Light Blue
                )
            ),
            previewText = "G"
        ),
        EffectToken(
            name = "Gradiente Secundario",
            description = "Gradiente usando colores secundarios",
            type = EffectType.GRADIENT,
            value = 0,
            usage = "Elementos decorativos, fondos especiales",
            gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF7B1FA2), // Purple
                    Color(0xFFBA68C8)  // Light Purple
                )
            ),
            previewText = "G2"
        ),
        EffectToken(
            name = "Borde Sutil",
            description = "Borde muy fino para separación",
            type = EffectType.BORDER,
            value = 1,
            usage = "Separadores, divisores de contenido",
            previewText = "B"
        ),
        EffectToken(
            name = "Borde Destacado",
            description = "Borde más grueso para elementos importantes",
            type = EffectType.BORDER,
            value = 2,
            usage = "Botones, campos de entrada, elementos activos",
            previewText = "B2"
        )
    )
}
