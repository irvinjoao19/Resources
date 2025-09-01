package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.demo.presentation.viewmodels.BorderViewModel
import com.gongora.resources.tokens.Border

/**
 * Screen displaying border tokens and radius examples.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BorderScreen(
    onNavigateBack: () -> Unit
) {
    val viewModel: BorderViewModel = viewModel()
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = UiBorderScreenTokens.ScreenBackground,
        topBar = {
            TopAppBar(
                title = { Text("Bordes 🔲") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = UiBorderScreenTokens.TopBarBackground,
                    titleContentColor = UiBorderScreenTokens.TopBarContent,
                    navigationIconContentColor = UiBorderScreenTokens.TopBarContent
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(UiBorderScreenTokens.ScreenPadding),
            verticalArrangement = Arrangement.spacedBy(UiBorderScreenTokens.SectionSpacing)
        ) {
            renderBorderWidthSection(viewModel)
            renderBorderRadiusSection(viewModel)
        }
    }
}

private fun LazyListScope.renderBorderWidthSection(viewModel: BorderViewModel) {
    item {
        Text(
            text = "Border Width",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
    
    viewModel.borderWidthTokens.forEach { (key, value) ->
        item {
            BorderWidthTokenCard(
                tokenName = key,
                tokenValue = value
            )
        }
    }
}

private fun LazyListScope.renderBorderRadiusSection(viewModel: BorderViewModel) {
    item {
        Text(
            text = "Border Radius",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
    
    viewModel.borderRadiusTokens.forEach { (key, value) ->
        item {
            BorderRadiusTokenCard(
                tokenName = key,
                tokenValue = value
            )
        }
    }
}

@Composable
private fun BorderWidthTokenCard(
    tokenName: String,
    tokenValue: Float
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = UiBorderScreenTokens.SurfaceBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(UiBorderScreenTokens.CardCornerRadius)
    ) {
        Row(
            modifier = Modifier.padding(UiBorderScreenTokens.ContentPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = tokenName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = UiBorderScreenTokens.AccentBlue
                )
                Text(
                    text = "${tokenValue.toInt()}px",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Box(
                modifier = Modifier
                    .size(80.dp, 40.dp)
                    .border(
                        width = tokenValue.dp,
                        color = UiBorderScreenTokens.BorderColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(
                        color = UiBorderScreenTokens.SampleBackground,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Ejemplo",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun BorderRadiusTokenCard(
    tokenName: String,
    tokenValue: Float
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = UiBorderScreenTokens.SurfaceBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(UiBorderScreenTokens.CardCornerRadius)
    ) {
        Row(
            modifier = Modifier.padding(UiBorderScreenTokens.ContentPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = tokenName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = UiBorderScreenTokens.AccentBlue
                )
                Text(
                    text = "${tokenValue.toInt()}px",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Box(
                modifier = Modifier
                    .size(80.dp, 40.dp)
                    .border(
                        width = 2.dp,
                        color = UiBorderScreenTokens.BorderColor,
                        shape = RoundedCornerShape(tokenValue.dp)
                    )
                    .background(
                        color = UiBorderScreenTokens.SampleBackground,
                        shape = RoundedCornerShape(tokenValue.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Ejemplo",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

private object UiBorderScreenTokens {
    val ScreenBackground = Color(0xFFF8FBFF)
    val TopBarBackground = Color(0xFF0D47A1)
    val TopBarContent = Color.White
    val AccentBlue = Color(0xFF175EFB)
    val SampleBackground = Color(0xFFEFF4FB)
    val SurfaceBackground = Color.White
    val BorderColor = Color(0xFF175EFB)

    val ScreenPadding = 16.dp
    val SectionSpacing = 32.dp
    val ContentPadding = 12.dp
    val CardCornerRadius = 8.dp
}
