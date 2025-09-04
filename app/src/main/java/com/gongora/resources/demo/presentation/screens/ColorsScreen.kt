package com.gongora.resources.demo.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.gongora.resources.compose.bcpAliasTokens
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.CardCornerRadius
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.CardElevation
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.CardPadding
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.GridGap
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SectionGap
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SeparatorPadding
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SwatchRadius
import com.gongora.resources.demo.presentation.screens.UiColorsScreenTokens.SwatchSize
import com.gongora.resources.demo.presentation.viewmodels.ColorsViewModel

@Composable
fun ColorsScreen(
    onNavigateBack: () -> Unit
) {
    val viewModel: ColorsViewModel = viewModel()
    val colorCategories = viewModel.colorCategories

    var isSearchVisible by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }

    val result = bcpAliasTokens()
    val tokens = result.tokens

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
        containerColor = Color(tokens.surface.static.regular.flat.secondary),
        topBar = {
            AppTopBar(
                isSearchVisible = isSearchVisible,
                onBack = onNavigateBack,
                onToggleSearch = {
                    isSearchVisible = !isSearchVisible
                    if (!isSearchVisible) query = ""
                },
                surfaceTokens = tokens.surface,
                textTokens = tokens.text
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
                onValueChange = { query = it },
                surfaceTokens = tokens.surface,
                textTokens = tokens.text
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(SectionGap)
            ) {
                if (filteredCategories.isEmpty()) {
                    item { EmptyState(message = "No se encontraron colores para \"$query\"", textTokens = tokens.text) }
                } else {
                    filteredCategories.forEach { (category, colors) ->
                        item {
                            ColorCategorySection(
                                categoryName = category.name,
                                colors = colors,
                                textTokens = tokens.text,
                                surfaceTokens = tokens.surface,
                                borderTokens = tokens.border
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
    onToggleSearch: () -> Unit,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens,
    textTokens: com.gongora.resources.theme.TextTokens
) {
    TopAppBar(
        title = { Text("Colores BCP") },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
            }
        },
        actions = {
            // Botón de búsqueda
            IconButton(onClick = onToggleSearch) {
                Icon(
                    imageVector = if (isSearchVisible) Icons.Filled.Close else Icons.Filled.Search,
                    contentDescription = if (isSearchVisible) "Cerrar búsqueda" else "Buscar colores"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(surfaceTokens.static.regular.flat.primary),
            titleContentColor = Color(textTokens.static.regular.primary),
            navigationIconContentColor = Color(textTokens.static.regular.primary),
            actionIconContentColor = Color(textTokens.static.regular.primary)
        )
    )
}

@Composable
private fun SearchBar(
    visible: Boolean,
    value: String,
    onValueChange: (String) -> Unit,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens,
    textTokens: com.gongora.resources.theme.TextTokens
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
                    focusedContainerColor = Color(surfaceTokens.static.regular.flat.tertiary),
                    unfocusedContainerColor = Color(surfaceTokens.static.regular.flat.tertiary),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(textTokens.static.regular.primary)
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
private fun ColorCategorySection(
    categoryName: String, 
    colors: List<ColorToken>, 
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens,
    borderTokens: com.gongora.resources.theme.BorderTokens
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        CategoryHeader(name = categoryName, count = colors.size, textTokens = textTokens)
        Spacer(Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(GridGap)) {
            colors.chunked(2).forEach { pair ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GridGap)
                ) {
                    pair.getOrNull(0)?.let {
                        ColorCard(
                            token = it, 
                            modifier = Modifier.weight(1f), 
                            textTokens = textTokens, 
                            surfaceTokens = surfaceTokens,
                            borderTokens = borderTokens
                        )
                    }
                    pair.getOrNull(1)?.let {
                        ColorCard(
                            token = it, 
                            modifier = Modifier.weight(1f), 
                            textTokens = textTokens, 
                            surfaceTokens = surfaceTokens,
                            borderTokens = borderTokens
                        )
                    } ?: Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun CategoryHeader(
    name: String, 
    count: Int,
    textTokens: com.gongora.resources.theme.TextTokens
) {
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
            color = Color(textTokens.static.regular.primary)
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "$count colores",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(textTokens.static.regular.secondary)
        )
    }
}

@Composable
private fun ColorCard(
    token: ColorToken, 
    modifier: Modifier = Modifier, 
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens,
    borderTokens: com.gongora.resources.theme.BorderTokens
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(CardCornerRadius),
        elevation = CardDefaults.cardElevation(defaultElevation = CardElevation),
        colors = CardDefaults.cardColors(
            containerColor = Color(surfaceTokens.static.regular.flat.primary)
        )
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
                        color = Color(borderTokens.static.regular.soft),
                        shape = RoundedCornerShape(SwatchRadius)
                    )
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = token.name.replace('_', ' '),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color(textTokens.static.regular.primary),
                textAlign = TextAlign.Center,
                maxLines = 2
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = token.hexLabel(),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Monospace),
                color = Color(textTokens.static.regular.secondary),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = token.key,
                style = MaterialTheme.typography.labelSmall,
                color = Color(textTokens.static.regular.secondary),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun EmptyState(
    message: String,
    textTokens: com.gongora.resources.theme.TextTokens
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(textTokens.static.regular.secondary),
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
    val CardCornerRadius = 16.dp
    val CardElevation = 6.dp
    val CardPadding = 16.dp
    val SeparatorPadding = 16.dp

    val SwatchSize = 64.dp
    val SwatchRadius = 14.dp

    val GridGap = 14.dp
    val SectionGap = 24.dp
}