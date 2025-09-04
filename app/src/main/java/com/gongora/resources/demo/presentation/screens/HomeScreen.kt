package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.compose.bcpAliasTokens
import com.gongora.resources.demo.presentation.components.DemoMenuItem
import com.gongora.resources.demo.presentation.viewmodels.HomeViewModel

/**
 * Home screen displaying the demo menu with all available token categories.
 * Esta pantalla ahora usa Alias Tokens para demostrar el sistema de diseño.
 * 
 * @param onNavigateToColors Navigation callback for colors screen
 * @param onNavigateToTypography Navigation callback for typography screen
 * @param onNavigateToBorder Navigation callback for border screen
 * @param onNavigateToSpacing Navigation callback for spacing screen
 * @param onNavigateToEffects Navigation callback for effects screen
 * @param onNavigateToIcons Navigation callback for icons screen
 */
@Composable
fun HomeScreen(
    onNavigateToColors: (Boolean) -> Unit,
    onNavigateToTypography: (Boolean) -> Unit,
    onNavigateToBorder: (Boolean) -> Unit,
    onNavigateToSpacing: (Boolean) -> Unit,
    onNavigateToEffects: (Boolean) -> Unit,
    onNavigateToIcons: (Boolean) -> Unit
) {
    val viewModel: HomeViewModel = viewModel()
    val menuItems = viewModel.menuItems

    val (tokens , isDark ,_,_, toggleTheme) = bcpAliasTokens()
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(tokens.surface.static.regular.flat.secondary)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header con Alias Tokens
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(tokens.surface.static.regular.flat.primary),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BCP Android Resources 📚",
                    style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(tokens.text.static.regular.primary),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Sistema de Diseño BCP",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                    color = Color(tokens.text.static.regular.secondary),
                    textAlign = TextAlign.Center
                )
                
                // Indicador de tema actual (clickeable)
                Card(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable {
                            toggleTheme()
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) {
                            Color(tokens.surface.static.regular.flat.tertiary)
                        } else {
                            Color(tokens.surface.static.regular.flat.secondary)
                        }
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Tema: ${if (isDark) "🌙 Oscuro" else "☀️ Claro"} (Toca para cambiar)",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                        color = Color(tokens.text.static.regular.secondary),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            // Menu Items con Alias Tokens
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(menuItems) { menuItem ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(tokens.surface.static.regular.flat.primary)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        DemoMenuItem(
                            item = menuItem,
                            onClick = {
                                when (menuItem.route) {
                                    "colors" -> onNavigateToColors(isDark)
                                    "typography" -> onNavigateToTypography(isDark)
                                    "border" -> onNavigateToBorder(isDark)
                                    "spacing" -> onNavigateToSpacing(isDark)
                                    "effects" -> onNavigateToEffects(isDark)
                                    "icons" -> onNavigateToIcons(isDark)
                                }
                            },
                            containerColor = Color(tokens.surface.static.regular.flat.primary),
                            textPrimaryColor = Color(tokens.text.static.regular.primary),
                            textSecondaryColor = Color(tokens.text.static.regular.secondary)
                        )
                    }
                }
            }
            
            // Footer con Alias Tokens
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(tokens.surface.static.regular.flat.tertiary),
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🎯 Alias Tokens en Acción",
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(tokens.text.static.regular.primary),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Esta pantalla usa tokens.surface.static.regular.flat.*",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = Color(tokens.text.static.regular.secondary),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Toca cualquier opción para explorar los recursos",
                    style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                    color = Color(tokens.text.static.regular.secondary),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
