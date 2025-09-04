package com.gongora.resources.demo.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gongora.resources.compose.bcpAliasTokens
import com.gongora.resources.demo.R
import com.gongora.resources.demo.presentation.screens.constants.EffectsScreenConstants
import com.gongora.resources.demo.presentation.screens.models.EffectSectionParams
import com.gongora.resources.tokens.Effects
import com.gongora.resources.utils.blurGlass
import com.gongora.resources.utils.glassEffect
import com.gongora.resources.utils.gradientGlass
import com.gongora.resources.utils.shadowLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EffectsScreen(
    onNavigateBack: () -> Unit
) {
    val tokens = bcpAliasTokens()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(tokens.surface.static.regular.flat.secondary),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Efectos ✨",
                        color = Color(tokens.text.static.regular.primary)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color(tokens.text.static.regular.primary)
                        )
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
            contentPadding = PaddingValues(EffectsScreenConstants.CONTENT_PADDING),
            verticalArrangement = Arrangement.spacedBy(EffectsScreenConstants.SECTION_SPACING)
        ) {

            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Efectos Visuales",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(tokens.text.static.regular.primary)
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "Tokens de efectos visuales del sistema de diseño",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(tokens.text.static.regular.secondary)
                    )
                }
            }

            item {
                val sectionParams = EffectSectionParams(
                    title = "🌑 Efectos de Sombra",
                    description = "Sombras para dar profundidad a los elementos",
                    textPrimary = Color(tokens.text.static.regular.primary),
                    textSecondary = Color(tokens.text.static.regular.secondary),
                    surface = Color(tokens.surface.static.regular.flat.primary)
                )
                EffectSection(params = sectionParams) {
                    BoxShadowLarge()
                }
            }

            item {
                val sectionParams = EffectSectionParams(
                    title = "🌫️ Efecto Blur",
                    description = "Efecto de desenfoque usando RenderEffect (fallback < API 31)",
                    textPrimary = Color(tokens.text.static.regular.primary),
                    textSecondary = Color(tokens.text.static.regular.secondary),
                    surface = Color(tokens.surface.static.regular.flat.primary)
                )
                EffectSection(params = sectionParams) {
                    BoxBlurGlass(color = Color(tokens.surface.static.regular.gradient.glassStart))
                }
            }

            item {
                val sectionParams = EffectSectionParams(
                    title = "🌈 Gradiente Radial Glass Simple",
                    description = "Aproximación radial con LinearGradient",
                    textPrimary = Color(tokens.text.static.regular.primary),
                    textSecondary = Color(tokens.text.static.regular.secondary),
                    surface = Color(tokens.surface.static.regular.flat.primary)
                )
                EffectSection(params = sectionParams) {
                    BoxGradientGlass(
                        startColor = Color(tokens.surface.static.regular.gradient.glassStart),
                        endColor = Color(tokens.surface.static.regular.gradient.glassEnd),
                        modifier = Modifier
                            .size(width = EffectsScreenConstants.EFFECT_DEMO_WIDTH, height = EffectsScreenConstants.EFFECT_DEMO_HEIGHT)
                    )
                }
            }

            item {
                val sectionParams = EffectSectionParams(
                    title = "🌫️ Efecto Glass",
                    description = "Efecto glass combinado (blur + gradiente radial + shadow)",
                    textPrimary = Color(tokens.text.static.regular.primary),
                    textSecondary = Color(tokens.text.static.regular.secondary),
                    surface = Color(tokens.surface.static.regular.flat.primary)
                )
                EffectSection(params = sectionParams) {
                    BoxGlassEffect(
                        startColor = Color(tokens.surface.static.regular.gradient.glassStart),
                        endColor = Color(tokens.surface.static.regular.gradient.glassEnd)
                    )
                }
            }
        }
    }
}

@Composable
private fun EffectSection(
    params: EffectSectionParams,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = params.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = EffectsScreenConstants.CARD_ELEVATION)
    ) {
        Column(Modifier.padding(EffectsScreenConstants.CARD_INTERNAL_PADDING)) {
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = params.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = params.textPrimary,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.height(EffectsScreenConstants.TITLE_DESCRIPTION_SPACING))
                Text(
                    text = params.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = params.textSecondary,
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(Modifier.height(EffectsScreenConstants.DESCRIPTION_CONTENT_SPACING))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(EffectsScreenConstants.EFFECT_DEMO_AREA_HEIGHT),
                contentAlignment = Alignment.Center
            ) {
                content()
            }
        }
    }
}

@Composable
private fun BoxShadowLarge() {
    Box(
        modifier = Modifier
            .size(width = EffectsScreenConstants.EFFECT_DEMO_WIDTH, height = EffectsScreenConstants.EFFECT_DEMO_HEIGHT)
            .shadowLarge()
            .background(Color.White)
    )
}


@Composable
private fun BoxBlurGlass(
    color: Color
) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bcp),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(EffectsScreenConstants.BLUR_EFFECT_PADDING)
                .blurGlass(color = color)
        )

        Text(
            text = "Texto nítido sobre fondo difuminado",
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun BoxGradientGlass(
    startColor: Color,
    endColor: Color,
    modifier: Modifier = Modifier,
    corner: Dp = EffectsScreenConstants.GRADIENT_GLASS_CORNER_RADIUS,
    whiteTintAlpha: Float = EffectsScreenConstants.GLASS_WHITE_TINT_ALPHA,
    borderColor: Color = Color(EffectsScreenConstants.GLASS_BORDER_COLOR_HEX), // TODO: Replace with alias token
    borderWidth: Dp = EffectsScreenConstants.GLASS_BORDER_WIDTH,
) {
    val shape = RoundedCornerShape(corner)

    Box(
        modifier = modifier
            .clip(shape)
            .background(Color.White.copy(alpha = whiteTintAlpha))
            .gradientGlass(startColor, endColor, cornerRadius = corner)
            .border(borderWidth, borderColor, shape)
    )
}


@Composable
private fun BoxGlassEffect(startColor: Color, endColor: Color) {
    Box(
        modifier = Modifier
            .size(width = EffectsScreenConstants.EFFECT_DEMO_WIDTH, height = EffectsScreenConstants.EFFECT_DEMO_HEIGHT)
            .shadowLarge()
            .clip(RoundedCornerShape(EffectsScreenConstants.GLASS_CORNER_RADIUS))
    ) {
        Image(
            painter = painterResource(R.drawable.bcp),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(EffectsScreenConstants.BLUR_EFFECT_PADDING)
                .glassEffect(
                    startColor = startColor,
                    endColor = endColor,
                    tintColor = Color.White,
                    cornerRadius = EffectsScreenConstants.GLASS_CORNER_RADIUS,
                    blur = Effects.Blur.XLarge.blurAmount.dp,
                    tintAlpha = Effects.Blur.XLarge.tintAlpha
                )
        )
    }
}
