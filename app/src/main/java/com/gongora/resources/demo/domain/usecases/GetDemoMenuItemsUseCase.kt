package com.gongora.resources.demo.domain.usecases

import com.gongora.resources.demo.domain.models.DemoMenuItem

/**
 * Use case for retrieving demo menu items.
 * This follows Clean Architecture principles by containing business logic.
 */
class GetDemoMenuItemsUseCase {
    
    /**
     * Executes the use case and returns the list of demo menu items.
     * @return List of demo menu items
     */
    operator fun invoke(): List<DemoMenuItem> = listOf(
        DemoMenuItem(
            id = "1",
            title = "Colores",
            description = "Explora la paleta de colores del sistema de diseño",
            route = "colors",
            icon = "🎨"
        ),
        DemoMenuItem(
            id = "2",
            title = "Tipografía",
            description = "Revisa los estilos tipográficos y variaciones de fuente",
            route = "typography",
            icon = "📝"
        ),
        DemoMenuItem(
            id = "3",
            title = "Bordes",
            description = "Explora los tokens de border radius y width",
            route = "border",
            icon = "🔲"
        ),
        DemoMenuItem(
            id = "4",
            title = "Espaciado",
            description = "Revisa los tokens de spacing y dimensiones",
            route = "spacing",
            icon = "📏"
        ),
        DemoMenuItem(
            id = "5",
            title = "Efectos",
            description = "Explora efectos visuales como gradientes y blur",
            route = "effects",
            icon = "✨"
        ),
        DemoMenuItem(
            id = "6",
            title = "Iconos",
            description = "Explora la biblioteca de iconos del sistema de diseño",
            route = "icons",
            icon = "🔍"
        )
    )
}
