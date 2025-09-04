package com.gongora.resources.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gongora.resources.BCPResources
import com.gongora.resources.ThemeManager
import com.gongora.resources.theme.AliasTokens

/**
 * Hook para acceder a los tokens de diseño reactivos al tema
 *
 * Este hook puede funcionar de dos maneras:
 * 1. Sin parámetros: Escucha automáticamente los cambios de tema del sistema
 * 2. Con tema forzado: Usa el tema especificado y no escucha cambios del sistema
 *
 * @param theme - Tema forzado ('light' | 'dark'). Si no se proporciona, usa el tema actual
 *
 * @example
 * ```kotlin
 * // Modo automático (escucha cambios del sistema)
 * val { tokens, isDark } = useBcpAliasTokens()
 *
 * // Modo forzado (siempre claro)
 * val { tokens } = useBcpAliasTokens(ThemeType.LIGHT)
 *
 * // Modo forzado (siempre oscuro)
 * val { tokens } = useBcpAliasTokens(ThemeType.DARK)
 * ```
 */
@Composable
fun bcpAliasTokens(theme: ThemeManager.ThemeType? = null): UseBcpAliasTokensReturn {
    var localTheme by remember { mutableStateOf(theme ?: BCPResources.themeManager.getCurrentThemeType()) }

    val effectiveTheme = theme ?: localTheme
    val isDark = effectiveTheme == ThemeManager.ThemeType.DARK
    val tokens: AliasTokens = if (isDark) {
        BCPResources.themeManager.getTheme(ThemeManager.ThemeType.DARK).aliasTokens
    } else {
        BCPResources.themeManager.getTheme(ThemeManager.ThemeType.LIGHT).aliasTokens
    }

    val toggleTheme: () -> Unit = {
        if (theme == null) {

            BCPResources.themeManager.toggleTheme()

            localTheme = BCPResources.themeManager.getCurrentThemeType()
        }
    }

    val setTheme: (ThemeManager.ThemeType) -> Unit = { newTheme ->
        if (theme == null) {
            BCPResources.themeManager.setTheme(newTheme)
            localTheme = newTheme
        }
    }
    
    return UseBcpAliasTokensReturn(
        tokens = tokens,
        isDark = isDark,
        isLight = !isDark,
        theme = effectiveTheme,
        toggleTheme = toggleTheme,
        setTheme = setTheme,
        surface = tokens.surface,
        text = tokens.text,
        border = tokens.border,
        icon = tokens.icon
    )
}

/**
 * Valor de retorno del hook useBcpAliasTokens
 */
data class UseBcpAliasTokensReturn(
    /** Tokens de diseño del tema actual */
    val tokens: AliasTokens,
    /** Indica si el tema actual es oscuro */
    val isDark: Boolean,
    /** Indica si el tema actual es claro */
    val isLight: Boolean,
    /** Tema actual */
    val theme: ThemeManager.ThemeType,
    /** Función para alternar entre temas (solo funciona en modo automático) */
    val toggleTheme: () -> Unit,
    /** Función para establecer un tema específico (solo funciona en modo automático) */
    val setTheme: (ThemeManager.ThemeType) -> Unit,
    /** Acceso directo a tokens de superficie */
    val surface: com.gongora.resources.theme.SurfaceTokens,
    /** Acceso directo a tokens de texto */
    val text: com.gongora.resources.theme.TextTokens,
    /** Acceso directo a tokens de borde */
    val border: com.gongora.resources.theme.BorderTokens,
    /** Acceso directo a tokens de iconos */
    val icon: com.gongora.resources.theme.IconTokens
)

/**
 * Función auxiliar para obtener los AliasTokens para un tema específico
 *
 * Esta función es útil cuando necesitas:
 * - Acceder a tokens de un tema específico sin depender del tema actual del dispositivo
 * - Realizar comparaciones entre temas
 * - Implementar lógica personalizada de selección de temas
 * - Obtener valores de tokens en contextos donde no puedes usar hooks
 *
 * @param themeType - Tipo de tema del cual obtener los tokens
 * @return AliasTokens del tema especificado
 */
fun getTheme(themeType: ThemeManager.ThemeType): AliasTokens {
    return BCPResources.themeManager.getTheme(themeType).aliasTokens
}

/**
 * Función auxiliar para obtener el tema actual
 *
 * @return AliasTokens del tema actual
 */
@Composable
@ReadOnlyComposable
fun getCurrentTheme(): AliasTokens {
    return BCPResources.currentTheme.aliasTokens
}
