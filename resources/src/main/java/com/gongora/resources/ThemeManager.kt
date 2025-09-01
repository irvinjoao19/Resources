package com.gongora.resources

import com.gongora.resources.theme.DarkTheme
import com.gongora.resources.theme.LightTheme
import com.gongora.resources.theme.Theme

/**
 * Gestor de temas para el sistema de diseño BCP
 *
 * Proporciona funcionalidad para gestionar y cambiar entre temas
 * claro y oscuro, así como acceder al tema actual.
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object ThemeManager {
    
    /**
     * Tipos de tema disponibles
     */
    enum class ThemeType {
        LIGHT,
        DARK
    }
    
    /**
     * Tema actual (por defecto es claro)
     */
    private var currentTheme: ThemeType = ThemeType.LIGHT
    
    /**
     * Obtiene el tema actual
     */
    fun getCurrentTheme(): Theme {
        return when (currentTheme) {
            ThemeType.LIGHT -> LightTheme
            ThemeType.DARK -> DarkTheme
        }
    }
    
    /**
     * Obtiene el tipo de tema actual
     */
    fun getCurrentThemeType(): ThemeType {
        return currentTheme
    }
    
    /**
     * Cambia al tema especificado
     */
    fun setTheme(themeType: ThemeType) {
        currentTheme = themeType
    }
    
    /**
     * Cambia al tema claro
     */
    fun setLightTheme() {
        currentTheme = ThemeType.LIGHT
    }
    
    /**
     * Cambia al tema oscuro
     */
    fun setDarkTheme() {
        currentTheme = ThemeType.DARK
    }
    
    /**
     * Alterna entre tema claro y oscuro
     */
    fun toggleTheme() {
        currentTheme = when (currentTheme) {
            ThemeType.LIGHT -> ThemeType.DARK
            ThemeType.DARK -> ThemeType.LIGHT
        }
    }
    
    /**
     * Verifica si el tema actual es claro
     */
    fun isLightTheme(): Boolean {
        return currentTheme == ThemeType.LIGHT
    }
    
    /**
     * Verifica si el tema actual es oscuro
     */
    fun isDarkTheme(): Boolean {
        return currentTheme == ThemeType.DARK
    }
    
    /**
     * Obtiene el tema basado en el tipo especificado
     */
    fun getTheme(themeType: ThemeType): Theme {
        return when (themeType) {
            ThemeType.LIGHT -> LightTheme
            ThemeType.DARK -> DarkTheme
        }
    }
}
