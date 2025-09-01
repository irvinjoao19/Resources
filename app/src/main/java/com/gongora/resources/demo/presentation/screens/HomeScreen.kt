package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.demo.presentation.components.DemoMenuItem
import com.gongora.resources.demo.presentation.viewmodels.HomeViewModel

/**
 * Home screen displaying the demo menu with all available token categories.
 * @param onNavigateToColors Navigation callback for colors screen
 * @param onNavigateToTypography Navigation callback for typography screen
 * @param onNavigateToBorder Navigation callback for border screen
 * @param onNavigateToSpacing Navigation callback for spacing screen
 * @param onNavigateToEffects Navigation callback for effects screen
 * @param onNavigateToIcons Navigation callback for icons screen
 */
@Composable
fun HomeScreen(
    onNavigateToColors: () -> Unit,
    onNavigateToTypography: () -> Unit,
    onNavigateToBorder: () -> Unit,
    onNavigateToSpacing: () -> Unit,
    onNavigateToEffects: () -> Unit,
    onNavigateToIcons: () -> Unit
) {
    val viewModel: HomeViewModel = viewModel()
    val menuItems = viewModel.menuItems
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BCP Android Resources 📚",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Sistema de Diseño BCP",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
            
            // Menu Items
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(menuItems) { menuItem ->
                    DemoMenuItem(
                        item = menuItem,
                        onClick = {
                            when (menuItem.route) {
                                "colors" -> onNavigateToColors()
                                "typography" -> onNavigateToTypography()
                                "border" -> onNavigateToBorder()
                                "spacing" -> onNavigateToSpacing()
                                "effects" -> onNavigateToEffects()
                                "icons" -> onNavigateToIcons()
                            }
                        }
                    )
                }
            }
            
            // Footer
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Toca cualquier opción para explorar los recursos",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
            }
        }
    }
}
