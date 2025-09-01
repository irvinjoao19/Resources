package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.demo.domain.models.IconToken
import com.gongora.resources.demo.presentation.viewmodels.IconsViewModel

@Composable
fun IconsScreen(onNavigateBack: () -> Unit) {
    val vm: IconsViewModel = viewModel()
    val iconCategories = vm.iconCategories

    var isSearchVisible by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }

    val filtered by remember(query, iconCategories) {
        derivedStateOf {
            if (query.isBlank()) iconCategories
            else iconCategories
                .mapValues { list -> list.value.filter { it.matches(query) } }
                .filterValues { it.isNotEmpty() }
        }
    }

    Scaffold(
        containerColor = UiTokens.ScreenBackground,
        topBar = {
            AppTopBar(
                isSearchVisible = isSearchVisible,
                onBack = onNavigateBack,
                onToggleSearch = {
                    isSearchVisible = !isSearchVisible
                    if (!isSearchVisible) query = ""
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            SearchBar(
                visible = isSearchVisible,
                value = query,
                onValueChange = { query = it }
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // 👈 tres columnas
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(UiTokens.ScreenPadding),
                horizontalArrangement = Arrangement.spacedBy(UiTokens.GridHorizontalGap),
                verticalArrangement = Arrangement.spacedBy(UiTokens.GridVerticalGap)
            ) {
                if (filtered.isEmpty()) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        EmptyState("No se encontraron iconos para \"$query\"")
                    }
                } else {
                    filtered.forEach { (category, icons) ->
                        item(span = { GridItemSpan(maxLineSpan) }) {
                            IconCategoryHeader(categoryName = category, count = icons.size)
                            Spacer(Modifier.height(UiTokens.SectionGap))
                        }
                        items(icons) { token ->
                            IconTile(token) // tarjeta cuadrada, contenido centrado
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar(
    isSearchVisible: Boolean,
    onBack: () -> Unit,
    onToggleSearch: () -> Unit
) {
    TopAppBar(
        title = { Text("Iconos BCP") },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
            }
        },
        actions = {
            IconButton(onClick = onToggleSearch) {
                Icon(
                    imageVector = if (isSearchVisible) Icons.Filled.Close else Icons.Filled.Search,
                    contentDescription = if (isSearchVisible) "Cerrar búsqueda" else "Buscar"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

@Composable
private fun SearchBar(
    visible: Boolean,
    value: String,
    onValueChange: (String) -> Unit
) {
    val focusRequester = remember { androidx.compose.ui.focus.FocusRequester() }
    val keyboard = androidx.compose.ui.platform.LocalSoftwareKeyboardController.current

    androidx.compose.animation.AnimatedVisibility(
        visible = visible,
        enter = androidx.compose.animation.expandVertically() + androidx.compose.animation.fadeIn(),
        exit = androidx.compose.animation.shrinkVertically() + androidx.compose.animation.fadeOut()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = UiTokens.ScreenPadding, vertical = 8.dp)
                .focusRequester(focusRequester),
            placeholder = { Text("Buscar iconos…") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(onClick = { onValueChange("") }) {
                        Icon(Icons.Filled.Close, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true,
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = androidx.compose.foundation.text.KeyboardActions(
                onSearch = { keyboard?.hide() }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                focusedBorderColor = MaterialTheme.colorScheme.primary
            )
        )
    }

    LaunchedEffect(visible) { if (visible) focusRequester.requestFocus() }

    androidx.compose.animation.AnimatedVisibility(visible = !visible) {
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun IconCategoryHeader(categoryName: String, count: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(
                    color = getCategoryColor(categoryName),
                    shape = RoundedCornerShape(4.dp)
                )
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = categoryName.uppercase(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "$count iconos",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun IconTile(token: IconToken) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(UiTokens.TileAspectRatio), // 👈 cuadrada
        shape = RoundedCornerShape(UiTokens.CardCornerRadius),
        elevation = CardDefaults.cardElevation(defaultElevation = UiTokens.CardElevation),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        // Contenido centrado vertical y horizontalmente
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(UiTokens.CardPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(UiTokens.IconContainerSize)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primaryContainer,
                                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
                            )
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = token.drawableRes),
                    contentDescription = token.name,
                    modifier = Modifier.size(UiTokens.IconFlagSize),
                    tint =
                    if (token.category.equals("Flags", ignoreCase = true))
                        Color.Unspecified
                    else
                        MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(Modifier.height(10.dp))

            Text(
                text = token.name,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 2,
                fontWeight = FontWeight.Medium
            )

            Spacer(Modifier.height(2.dp))

            Text(
                text = token.key,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Composable
private fun EmptyState(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

private fun IconToken.matches(raw: String): Boolean {
    val q = raw.lowercase().trim()
    if (q.isBlank()) return true
    return name.lowercase().contains(q) ||
            key.lowercase().contains(q) ||
            category.lowercase().contains(q)
}

@Composable
private fun getCategoryColor(categoryName: String): Color = when (categoryName.uppercase()) {
    "COMMUNICATION" -> Color(0xFF2196F3)
    "DOCUMENTS" -> Color(0xFF4CAF50)
    "FINANCES" -> Color(0xFFFF9800)
    "EMOTIONS" -> Color(0xFFE91E63)
    "E-COMMERCE" -> Color(0xFF9C27B0)
    "NAVIGATION" -> Color(0xFF607D8B)
    "SECURITY" -> Color(0xFFF44336)
    "PEOPLE" -> Color(0xFF00BCD4)
    "PAYMENT" -> Color(0xFF8BC34A)
    "FLAGS" -> Color(0xFF3F51B5)
    else -> MaterialTheme.colorScheme.primary
}

private object UiTokens {
    val ScreenBackground = Color(0xFFF8FBFF)

    val GridHorizontalGap = 16.dp
    val GridVerticalGap = 16.dp
    val ScreenPadding = 16.dp
    val SectionGap = 16.dp

    val CardCornerRadius = 14.dp
    val CardElevation = 4.dp
    val CardPadding = 12.dp

    val TileAspectRatio = 1f
    val IconContainerSize = 64.dp
    val IconFlagSize = 44.dp
    val IconRegularSize = 28.dp
}