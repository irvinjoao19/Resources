package com.gongora.resources.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gongora.resources.compose.bcpAliasTokens
import com.gongora.resources.demo.presentation.navigation.DemoNavigation

/**
 * Main activity for the BCP Resources Demo application.
 * This activity sets up the demo navigation and theme.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoApp()
        }
    }
}

/**
 * Main demo application composable.
 * Sets up navigation for the demo screens.
 */
@Composable
fun DemoApp() {
    val navController = rememberNavController()
    
    // 🎯 USO DE ALIAS TOKENS - Hook principal para obtener el estado del tema
    val result = bcpAliasTokens()
    val isDark = result.isDark
    
    // 🎨 APLICAR TEMA DINÁMICO - Usar MaterialTheme con el tema detectado
    MaterialTheme(
        colorScheme = if (isDark) {
            androidx.compose.material3.darkColorScheme()
        } else {
            androidx.compose.material3.lightColorScheme()
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DemoNavigation(
                navController = navController,
                isDarkMode = isDark
            )
        }
    }
}