package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gongora.resources.compose.bcpAliasTokens
import com.gongora.resources.demo.domain.models.TypographyStyle
import com.gongora.resources.demo.presentation.screens.UiTypographyScreenTokens.ScreenPadding
import com.gongora.resources.demo.presentation.screens.UiTypographyScreenTokens.SectionSpacing
import com.gongora.resources.demo.presentation.screens.UiTypographyScreenTokens.ContentPadding
import com.gongora.resources.demo.presentation.screens.UiTypographyScreenTokens.SamplePadding
import com.gongora.resources.demo.presentation.screens.UiTypographyScreenTokens.CardCornerRadius
import com.gongora.resources.demo.presentation.screens.UiTypographyScreenTokens.ChipCornerRadius
import com.gongora.resources.demo.presentation.viewmodels.TypographyViewModel
import com.gongora.resources.tokens.Typography
import com.gongora.resources.typography.TypographyUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypographyScreen(
    onNavigateBack: () -> Unit
) {
    val vm: TypographyViewModel = viewModel()

    // 🎯 USO DE ALIAS TOKENS - Hook principal para cambio de tema automático
    val result = bcpAliasTokens()
    val tokens = result.tokens

    Scaffold(
        containerColor = Color(tokens.surface.static.regular.flat.secondary),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(tokens.surface.static.regular.flat.primary),
                    titleContentColor = Color(tokens.text.static.regular.primary),
                    navigationIconContentColor = Color(tokens.text.static.regular.primary)
                ),
                title = { Text("Tipografía ✏️") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },

            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(ScreenPadding),
            verticalArrangement = Arrangement.spacedBy(SectionSpacing)
        ) {
            sectionHeader("Estilos de Texto", tokens.text)
            items(vm.typographyStyles) { style -> 
                TypographySampleCard(
                    style, 
                    textTokens = tokens.text, 
                    surfaceTokens = tokens.surface
                ) 
            }

            sectionHeader("Tokens de Tipografía", tokens.text)
            fontFamilySection(
                title = "👨‍💼 Fuente de Marca (Flexo)",
                fontFamilies = mapOf(
                    "Thin" to Typography.FontFamily.Brand.thin,
                    "Light" to Typography.FontFamily.Brand.light,
                    "Regular" to Typography.FontFamily.Brand.regular,
                    "Medium" to Typography.FontFamily.Brand.medium,
                    "Demi" to Typography.FontFamily.Brand.demi,
                    "Bold" to Typography.FontFamily.Brand.bold,
                    "Heavy" to Typography.FontFamily.Brand.heavy,
                    "Black" to Typography.FontFamily.Brand.black
                ),
                textTokens = tokens.text,
                surfaceTokens = tokens.surface
            )
            fontFamilySection(
                title = "📝 Fuente de Apoyo (SourceSans3)",
                fontFamilies = mapOf(
                    "Thin" to Typography.FontFamily.Supportive.thin,
                    "Light" to Typography.FontFamily.Supportive.light,
                    "Regular" to Typography.FontFamily.Supportive.regular,
                    "Medium" to Typography.FontFamily.Supportive.medium,
                    "Demi" to Typography.FontFamily.Supportive.demi,
                    "Bold" to Typography.FontFamily.Supportive.bold,
                    "Heavy" to Typography.FontFamily.Supportive.heavy,
                    "Black" to Typography.FontFamily.Supportive.black
                ),
                textTokens = tokens.text,
                surfaceTokens = tokens.surface
            )
            tokenSection(
                title = "⚖️ Pesos de Fuente",
                tokens = mapOf(
                    "Thin" to Typography.FontWeight.thin.toString(),
                    "Light" to Typography.FontWeight.light.toString(),
                    "Regular" to Typography.FontWeight.regular.toString(),
                    "Medium" to Typography.FontWeight.medium.toString(),
                    "Demi" to Typography.FontWeight.demi.toString(),
                    "Bold" to Typography.FontWeight.bold.toString(),
                    "Heavy" to Typography.FontWeight.heavy.toString(),
                    "Black" to Typography.FontWeight.black.toString()
                ),
                textTokens = tokens.text,
                surfaceTokens = tokens.surface
            )
            tokenSection(
                title = "📏 Tamaños de Fuente",
                tokens = mapOf(
                    "XSmall" to "${Typography.FontSize.xsmall}px",
                    "Small" to "${Typography.FontSize.small}px",
                    "Regular" to "${Typography.FontSize.regular}px",
                    "Medium" to "${Typography.FontSize.medium}px",
                    "Large" to "${Typography.FontSize.large}px",
                    "XLarge" to "${Typography.FontSize.xlarge}px"
                ),
                textTokens = tokens.text,
                surfaceTokens = tokens.surface
            )
            tokenSection(
                title = "📐 Alturas de Línea",
                tokens = mapOf(
                    "Small" to "${Typography.LineHeight.small}px",
                    "Medium" to "${Typography.LineHeight.medium}px",
                    "Large" to "${Typography.LineHeight.large}px",
                    "XLarge" to "${Typography.LineHeight.xlarge}px"
                ),
                textTokens = tokens.text,
                surfaceTokens = tokens.surface
            )
            tokenSection(
                title = "🔤 Espaciado de Letras",
                tokens = mapOf(
                    "XSmall" to "${Typography.LetterSpacing.xsmall}px",
                    "Small" to "${Typography.LetterSpacing.small}px",
                    "None" to "${Typography.LetterSpacing.none}px"
                ),
                textTokens = tokens.text,
                surfaceTokens = tokens.surface
            )

            sectionHeader("Demostración de Pesos", tokens.text)
            sectionSubHeader("🎨 Flexo - Todos los Pesos", tokens.text)
            items(
                listOf(
                    "Thin" to Typography.FontWeight.thin,
                    "Light" to Typography.FontWeight.light,
                    "Regular" to Typography.FontWeight.regular,
                    "Medium" to Typography.FontWeight.medium,
                    "Demi" to Typography.FontWeight.demi,
                    "Bold" to Typography.FontWeight.bold,
                    "Heavy" to Typography.FontWeight.heavy,
                    "Black" to Typography.FontWeight.black
                )
            ) { (name, value) ->
                WeightDemoCard(
                    weightName = name, 
                    weightValue = value,
                    textTokens = tokens.text,
                    surfaceTokens = tokens.surface
                )
            }

            sectionSubHeader("📖 SourceSans3 - Todos los Pesos", tokens.text)
            items(
                listOf(
                    "Thin" to Typography.FontFamily.Supportive.thin,
                    "Light" to Typography.FontFamily.Supportive.light,
                    "Regular" to Typography.FontFamily.Supportive.regular,
                    "Medium" to Typography.FontFamily.Supportive.medium,
                    "Demi" to Typography.FontFamily.Supportive.demi,
                    "Bold" to Typography.FontFamily.Supportive.bold,
                    "Heavy" to Typography.FontFamily.Supportive.heavy,
                    "Black" to Typography.FontFamily.Supportive.black
                )
            ) { (weight, fontName) ->
                SourceSans3DemoCard(
                    weight = weight, 
                    fontName = fontName,
                    textTokens = tokens.text,
                    surfaceTokens = tokens.surface
                )
            }
        }
    }
}

private fun LazyListScope.sectionHeader(
    text: String,
    textTokens: com.gongora.resources.theme.TextTokens
) {
    item {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            color = Color(textTokens.static.regular.primary)
        )
        Spacer(Modifier.height(8.dp))
    }
}

private fun LazyListScope.sectionSubHeader(
    text: String,
    textTokens: com.gongora.resources.theme.TextTokens
) {
    item {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(textTokens.static.regular.primary)
        )
        Spacer(Modifier.height(8.dp))
    }
}

private fun LazyListScope.fontFamilySection(
    title: String, 
    fontFamilies: Map<String, String>,
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens
) {
    sectionSubHeader(title, textTokens)
    items(fontFamilies.toList()) { (weight, fontName) ->
        Card(
            modifier = Modifier.fillParentMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(surfaceTokens.static.regular.flat.primary)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(CardCornerRadius)
        ) {
            Column(Modifier.padding(ContentPadding)) {
                Text(
                    text = weight,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(textTokens.static.regular.primary)
                )
                Text(
                    text = fontName, 
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
                Text(
                    text = "Ejemplo de $weight", 
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(textTokens.static.regular.primary)
                )
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}

private fun LazyListScope.tokenSection(
    title: String, 
    tokens: Map<String, String>,
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens
) {
    sectionSubHeader(title, textTokens)
    items(tokens.toList()) { (key, value) ->
        Card(
            modifier = Modifier.fillParentMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(surfaceTokens.static.regular.flat.primary)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(CardCornerRadius)
        ) {
            Column(Modifier.padding(ContentPadding)) {
                Text(
                    text = key,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(textTokens.static.regular.primary)
                )
                Text(
                    text = value, 
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun TypographySampleCard(
    typographyStyle: TypographyStyle,
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(surfaceTokens.static.regular.flat.primary)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(CardCornerRadius)
    ) {
        Column(Modifier.padding(ContentPadding)) {
            Text(
                text = typographyStyle.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(textTokens.static.regular.primary)
            )
            Text(
                text = typographyStyle.description,
                style = MaterialTheme.typography.bodySmall,
                fontStyle = FontStyle.Italic,
                color = Color(textTokens.static.regular.secondary)
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Nam porta sapien eget ante dictum rhoncus. vitae enim placerat condimentum.",
                style = typographyStyle.textStyle.copy(
                    color = Color(textTokens.static.regular.primary)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(surfaceTokens.static.regular.flat.secondary), 
                        shape = RoundedCornerShape(ChipCornerRadius)
                    )
                    .padding(SamplePadding)
            )
            Spacer(Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(surfaceTokens.static.regular.flat.secondary), 
                        shape = RoundedCornerShape(ChipCornerRadius)
                    )
                    .padding(SamplePadding)
            ) {
                Text(
                    text = "Propiedades:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(textTokens.static.regular.primary)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Familia: ${typographyStyle.properties.fontFamily}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
                Text(
                    text = "Tamaño: ${typographyStyle.properties.fontSize}px",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
                Text(
                    text = "Peso: ${typographyStyle.properties.fontWeight}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
                Text(
                    text = "Altura línea: ${typographyStyle.properties.lineHeight}px",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
                Text(
                    text = "Espaciado: ${typographyStyle.properties.letterSpacing}px",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(textTokens.static.regular.secondary)
                )
                typographyStyle.properties.textDecoration?.let {
                    Text(
                        text = "Decoración: $it", 
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(textTokens.static.regular.secondary)
                    )
                }
            }
        }
    }
}

@Composable
private fun WeightDemoCard(
    weightName: String, 
    weightValue: Int,
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(surfaceTokens.static.regular.flat.primary)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(CardCornerRadius)
    ) {
        Column(Modifier.padding(ContentPadding)) {
            Text(
                text = "$weightName ($weightValue)",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = Color(textTokens.static.regular.primary)
            )
            Text(
                text = "The quick brown fox jumps over the lazy dog",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = TypographyUtils.getBrandFontFamily(weightValue),
                    fontWeight = mapToFontWeight(weightValue),
                    color = Color(textTokens.static.regular.primary)
                )
            )
        }
    }
}

@Composable
private fun SourceSans3DemoCard(
    weight: String, 
    fontName: String,
    textTokens: com.gongora.resources.theme.TextTokens,
    surfaceTokens: com.gongora.resources.theme.SurfaceTokens
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(surfaceTokens.static.regular.flat.primary)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(CardCornerRadius)
    ) {
        Column(Modifier.padding(ContentPadding)) {
            Text(
                text = "$weight ($fontName)",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = Color(textTokens.static.regular.primary)
            )
            Text(
                text = "The quick brown fox jumps over the lazy dog",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = TypographyUtils.getFontFamily(fontName),
                    color = Color(textTokens.static.regular.primary)
                )
            )
        }
    }
}

private fun mapToFontWeight(value: Int): FontWeight = TypographyUtils.mapToComposeFontWeight(value)
private object UiTypographyScreenTokens {
    val ScreenBackground = Color(0xFFF8FBFF)
    val TopBarBackground = Color(0xFF0D47A1)
    val TopBarContent = Color.White
    val AccentBlue = Color(0xFF175EFB)
    val SampleBackground = Color(0xFFEFF4FB)
    val SurfaceBackground = Color.White

    val ScreenPadding = 16.dp
    val SectionSpacing = 16.dp
    val ContentPadding = 12.dp
    val SamplePadding = 16.dp

    val CardCornerRadius = 16.dp
    val ChipCornerRadius = 12.dp
}

