package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.compose.bcpAliasTokens
import com.gongora.resources.demo.domain.models.SpacingToken
import com.gongora.resources.demo.presentation.viewmodels.SpacingViewModel

/**
 * Screen displaying spacing tokens and dimension examples from BCP design system.
 * Esta pantalla ahora usa la estrategia híbrida: Base tokens para valores + Alias tokens para UI
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpacingScreen(
    onNavigateBack: () -> Unit
) {
    val viewModel: SpacingViewModel = viewModel()
    val spacingTokens = viewModel.spacingTokens
    
    // 🎯 USO DE ALIAS TOKENS - Hook principal para cambio de tema automático
    val result = bcpAliasTokens()
    val tokens = result.tokens
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(tokens.surface.static.regular.flat.secondary),
        topBar = {
            TopAppBar(
                title = { Text("Espaciado BCP") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(tokens.surface.static.regular.flat.primary),
                    titleContentColor = Color(tokens.text.static.regular.primary),
                    navigationIconContentColor = Color(tokens.text.static.regular.primary)
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Header
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Spacing Tokens",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(tokens.text.static.regular.primary),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Valores de espaciado para márgenes, padding y gaps",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(tokens.text.static.regular.secondary),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            // Spacing tokens (same as React Native)
            spacingTokens.forEach { token ->
                item {
                    SpacingTokenCard(
                        token = token, 
                        textTokens = tokens.text,
                        surfaceTokens = tokens.surface,
                        borderTokens = tokens.border
                    )
                }
            }
        }
    }
}

@Composable
private fun SpacingTokenCard(
    token: SpacingToken,
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens,
    borderTokens: com.gongora.resources.theme.BorderTokens
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(surfaceTokens.static.regular.flat.primary))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Token info (same as React Native)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = token.key,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    color = Color(textTokens.static.regular.primary)
                )
                Text(
                    text = "${token.value.toInt()}dp",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(textTokens.static.regular.secondary)
                )
            }
            
            Spacer(Modifier.height(12.dp))
            
            // Spacing example (same as React Native)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Spacing bar (same as React Native)
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .width(token.value.dp.coerceAtLeast(2.dp))
                        .background(
                            color = Color(borderTokens.static.regular.strong),
                            shape = RoundedCornerShape(2.dp)
                        )
                )
                
                // Spacing demo with two boxes (same as React Native)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(token.value.dp.coerceAtLeast(2.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Box A (same as React Native)
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                color = Color(surfaceTokens.interactive.base.regular.primary.default),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color(borderTokens.static.regular.medium),
                                shape = RoundedCornerShape(4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "A",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                            color = Color(textTokens.static.regular.primary)
                        )
                    }
                    
                    // Box B (same as React Native)
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                color = Color(surfaceTokens.interactive.base.regular.primary.default),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color(borderTokens.static.regular.medium),
                                shape = RoundedCornerShape(4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "B",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                            color = Color(textTokens.static.regular.primary)
                        )
                    }
                }
            }
        }
    }
}
