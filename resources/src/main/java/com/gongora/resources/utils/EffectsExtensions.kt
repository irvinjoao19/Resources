package com.gongora.resources.utils

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gongora.resources.tokens.Effects.GradientGlass.GlassBG
import com.gongora.resources.tokens.Effects.Blur.XLarge
import com.gongora.resources.tokens.Effects.Shadows.ShadowLarge

private const val GRADIENT_STOP_START = 0.15f
private const val GRADIENT_STOP_END = 1f

fun Modifier.shadowLarge(
    color: Color = ShadowLarge.shadowColor,
    offsetX: Dp = ShadowLarge.offsetX.dp,
    offsetY: Dp = ShadowLarge.offsetY.dp,
    blur: Dp = ShadowLarge.blur.dp,
    spread: Dp = ShadowLarge.spread.dp,
    cornerRadius: Dp = 12.dp
): Modifier = this.then(
    Modifier.drawBehind {
        val frameworkPaint = android.graphics.Paint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.FILL
            setShadowLayer(
                blur.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                android.graphics.Color.argb(
                    (color.alpha * 255).toInt(),
                    (color.red * 255).toInt(),
                    (color.green * 255).toInt(),
                    (color.blue * 255).toInt()
                )
            )
        }

        val spreadPx = spread.toPx()
        val shadowRect = android.graphics.RectF(
            -spreadPx,
            -spreadPx,
            size.width + spreadPx,
            size.height + spreadPx
        )

        drawIntoCanvas { canvas ->
            canvas.nativeCanvas.drawRoundRect(
                shadowRect,
                cornerRadius.toPx(),
                cornerRadius.toPx(),
                frameworkPaint
            )
        }
    }
)

fun Modifier.blurGlass(
    color: Color,
    blur: Dp = XLarge.blurAmount.dp,
    tintAlpha: Float = XLarge.tintAlpha,
): Modifier = this
    .blur(blur)
    .background(color.copy(alpha = tintAlpha))


fun Modifier.gradientGlass(
    startColor: Color,
    endColor: Color,
    cornerRadius: Dp = 0.dp
): Modifier = this.then(
    Modifier.drawWithCache {
        val gradientStart = Offset(size.width * GlassBG.startX, size.height * GlassBG.startY)
        val gradientEnd = Offset(size.width * GlassBG.endX, size.height * GlassBG.endY)

        val gradientStartColor = startColor.copy(alpha = GlassBG.alpha)

        val gradientBrush = Brush.linearGradient(
            colorStops = arrayOf(
                GRADIENT_STOP_START to gradientStartColor,
                GRADIENT_STOP_END to endColor
            ),
            start = gradientStart,
            end = gradientEnd
        )

        onDrawBehind {
            drawRoundRect(
                brush = gradientBrush,
                cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx())
            )
        }
    }
)

fun Modifier.glassEffect(
    startColor: Color,
    endColor: Color,
    tintColor: Color = Color.White,
    cornerRadius: Dp = 16.dp,
    blur: Dp = XLarge.blurAmount.dp,
    tintAlpha: Float = XLarge.tintAlpha,
): Modifier = this
    .blur(blur)
    .drawWithCache {
        val gradientStart = Offset(size.width * GlassBG.startX, size.height * GlassBG.startY)
        val gradientEnd = Offset(size.width * GlassBG.endX, size.height * GlassBG.endY)

        val gradientStartColor = startColor.copy(alpha = GlassBG.alpha)

        val gradientBrush = Brush.linearGradient(
            colorStops = arrayOf(
                GRADIENT_STOP_START to gradientStartColor,
                GRADIENT_STOP_END to endColor
            ),
            start = gradientStart,
            end = gradientEnd
        )

        onDrawBehind {
            drawRoundRect(
                brush = gradientBrush,
                cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx())
            )

            drawRoundRect(
                color = tintColor.copy(alpha = tintAlpha),
                cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx())
            )
        }
    }