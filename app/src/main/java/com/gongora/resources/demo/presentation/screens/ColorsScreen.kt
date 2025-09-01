package com.gongora.resources.demo.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.CardElevation
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.CardCornerRadius
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.CardPadding
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.GridGap
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.ScreenBackground
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SearchBackground
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SectionGap
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SeparatorPadding
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SwatchRadius
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SwatchSize
import com.gongora.resources.demo.presentation.viewmodels.ColorsViewModel

@Composable
fun ColorsScreen(onNavigateBack: () -> Unit) {
    val viewModel: ColorsViewModel = viewModel()
    val colorCategories = viewModel.colorCategories

    var isSearchVisible by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }

    val filteredCategories by remember(query, colorCategories) {
        derivedStateOf {
            if (query.isBlank()) colorCategories
            else colorCategories
                .mapValues { list -> list.value.filter { it.matches(query) } }
                .filterValues { it.isNotEmpty() }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ScreenBackground,
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

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(SectionGap)
            ) {
                if (filteredCategories.isEmpty()) {
                    item { EmptyState(message = "No se encontraron colores para \"$query\"") }
                } else {
                    filteredCategories.forEach { (category, colors) ->
                        item {
                            ColorCategorySection(
                                categoryName = category.name,
                                colors = colors
                            )
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
        title = { Text("Colores BCP") },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
            }
        },
        actions = {
            IconButton(onClick = onToggleSearch) {
                Icon(
                    imageVector = if (isSearchVisible) Icons.Filled.Close else Icons.Filled.Search,
                    contentDescription = if (isSearchVisible) "Cerrar búsqueda" else "Buscar colores"
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
    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current

    AnimatedVisibility(visible = visible) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text("Buscar colores…") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                keyboardActions = KeyboardActions(onSearch = { keyboard?.hide() }),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = SearchBackground,
                    unfocusedContainerColor = SearchBackground,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

        LaunchedEffect(Unit) { focusRequester.requestFocus() }
    }

    AnimatedVisibility(visible = !visible) {
        Spacer(modifier = Modifier.height(SeparatorPadding))
    }
}

@Composable
private fun ColorCategorySection(categoryName: String, colors: List<ColorToken>) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        CategoryHeader(name = categoryName, count = colors.size)
        Spacer(Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(GridGap)) {
            colors.chunked(2).forEach { pair ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GridGap)
                ) {
                    pair.getOrNull(0)?.let {
                        ColorCard(token = it, modifier = Modifier.weight(1f))
                    }
                    pair.getOrNull(1)?.let {
                        ColorCard(token = it, modifier = Modifier.weight(1f))
                    } ?: Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun CategoryHeader(name: String, count: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(
                    color = when (name.uppercase()) {
                        "BRAND" -> Color(0xFF175EFB)
                        "NEUTRAL" -> Color(0xFF66717E)
                        "FUNCTIONAL" -> Color(0xFF398439)
                        "DECORATIVE" -> Color(0xFF44A294)
                        else -> MaterialTheme.colorScheme.primary
                    },
                    shape = RoundedCornerShape(4.dp)
                )
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = name.replace("_", " ").uppercase(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "$count colores",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ColorCard(token: ColorToken, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(CardCornerRadius),
        elevation = CardDefaults.cardElevation(defaultElevation = CardElevation),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CardPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(SwatchSize)
                    .background(
                        color = token.asComposeColor(),
                        shape = RoundedCornerShape(SwatchRadius)
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f),
                        shape = RoundedCornerShape(SwatchRadius)
                    )
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = token.name.replace('_', ' '),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 2
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = token.hexLabel(),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Monospace),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = token.key,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun EmptyState(message: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

private fun ColorToken.asComposeColor(): Color = when (val v = value) {
    is Int -> Color(v)
    is String -> Color(android.graphics.Color.parseColor(v))
    else -> Color.Gray
}

private fun ColorToken.hexLabel(): String = when (val v = value) {
    is Int -> String.format("#%06X", v and 0xFFFFFF)
    is String -> v.uppercase()
    else -> "#000000"
}

private fun ColorToken.matches(rawQuery: String): Boolean {
    val q = rawQuery.normalize()
    if (q.isBlank()) return true

    val hex = when (val v = value) {
        is Int -> String.format("#%06X", v and 0xFFFFFF)
        is String -> v
        else -> ""
    }.lowercase()

    return name.normalize().contains(q) ||
            key.normalize().contains(q) ||
            hex.contains(q)
}

private fun String.normalize(): String =
    lowercase().replace("_", " ").trim()


private object UiColorsScreenTokens {
    val ScreenBackground = Color(0xFFF8FBFF)
    val SearchBackground = Color(0xFFF2F7FF)

    val CardCornerRadius = 16.dp
    val CardElevation = 6.dp
    val CardPadding = 16.dp
    val SeparatorPadding = 16.dp

    val SwatchSize = 64.dp
    val SwatchRadius = 14.dp

    val GridGap = 14.dp
    val SectionGap = 24.dp
}