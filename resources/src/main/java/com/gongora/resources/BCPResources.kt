package com.gongora.resources

import com.gongora.resources.theme.AliasTokens
import com.gongora.resources.theme.Theme
import com.gongora.resources.tokens.*

/**
 * Punto de entrada principal del paquete de recursos BCP para Android
 * 
 * Exporta todos los tokens de diseño, temas, tipos y utilidades
 * 
 * @author BCP Design System Developer Team
 * @since 1.0.0
 * @module BCPAndroidResources
 */
object BCPResources {
    
    // ===== TOKENS EXPORTS =====
    
    /**
     * Tokens de colores
     */
    val colors: Colors = Colors
    
    /**
     * Tokens de tipografía
     */
    val typography: Typography = Typography
    
    /**
     * Tokens de espaciado
     */
    val spacing: Spacing = Spacing
    
    /**
     * Tokens de bordes
     */
    val border: Border = Border
    
    /**
     * Tokens de efectos
     */
    val effects: Effects = Effects
    
    /**
     * Tokens de iconos
     */
    val icons: Icons = Icons
    
    // ===== THEME EXPORTS =====
    
    /**
     * Gestor de temas
     */
    val themeManager: ThemeManager = ThemeManager
    
    /**
     * Tema actual
     */
    val currentTheme: Theme
        get() = ThemeManager.getCurrentTheme()
    
    /**
     * AliasTokens del tema actual
     */
    val aliasTokens: AliasTokens
        get() = currentTheme.aliasTokens
    
    // ===== UTILITY FUNCTIONS =====
    
    /**
     * Obtiene el tema especificado
     */
    fun getTheme(themeType: ThemeManager.ThemeType): Theme {
        return ThemeManager.getTheme(themeType)
    }
    
    /**
     * Cambia al tema especificado
     */
    fun setTheme(themeType: ThemeManager.ThemeType) {
        ThemeManager.setTheme(themeType)
    }
    
    /**
     * Alterna entre tema claro y oscuro
     */
    fun toggleTheme() {
        ThemeManager.toggleTheme()
    }
    
    /**
     * Verifica si el tema actual es claro
     */
    fun isLightTheme(): Boolean {
        return ThemeManager.isLightTheme()
    }
    
    /**
     * Verifica si el tema actual es oscuro
     */
    fun isDarkTheme(): Boolean {
        return ThemeManager.isDarkTheme()
    }

    // ===== COMPOSE HOOKS =====
    
    /**
     * Hook para acceder a AliasTokens reactivos al tema
     * 
     * @see com.gongora.resources.compose.bcpAliasTokens
     */
    // Función eliminada para evitar conflicto con la propiedad aliasTokens
}
