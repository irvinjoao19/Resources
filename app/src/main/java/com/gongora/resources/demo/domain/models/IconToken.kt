package com.gongora.resources.demo.domain.models

import androidx.annotation.DrawableRes

/**
 * Domain model representing an icon token for display in the demo.
 */
data class IconToken(
    val key: String,
    @DrawableRes val drawableRes: Int,
    val name: String,
    val category: String
) {
    /**
     * Verifica si el icono coincide con el término de búsqueda
     */
    fun matches(query: String): Boolean {
        val normalizedQuery = query.normalize()
        if (normalizedQuery.isBlank()) return true
        
        return name.normalize().contains(normalizedQuery) ||
               key.normalize().contains(normalizedQuery) ||
               category.normalize().contains(normalizedQuery)
    }
    
    private fun String.normalize(): String =
        lowercase().replace("_", " ").trim()
}
