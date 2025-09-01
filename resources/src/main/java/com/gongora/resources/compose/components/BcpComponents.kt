package com.gongora.resources.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gongora.resources.compose.bcpTheme

/**
 * Componentes Compose reutilizables basados en el sistema de diseño BCP
 *
 * Proporciona componentes predefinidos que siguen las directrices
 * de diseño de BCP y utilizan los tokens del sistema.
 *
 * @author BCP Design System Developer Team
 * @version 1.0.0
 * @since 1.0.0
 */
object BcpComponents {
    
    /**
     * Botón primario BCP
     */
    @Composable
    fun PrimaryButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        content: @Composable RowScope.() -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            content()
        }
    }
    
    /**
     * Botón secundario BCP
     */
    @Composable
    fun SecondaryButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        content: @Composable RowScope.() -> Unit
    ) {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.primary
            ),
            border = androidx.compose.foundation.BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            content()
        }
    }
    
    /**
     * Botón de texto BCP
     */
    @Composable
    fun TextButton(
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        content: @Composable RowScope.() -> Unit
    ) {
        androidx.compose.material3.TextButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            content()
        }
    }
    
    /**
     * Tarjeta BCP
     */
    @Composable
    fun Card(
        modifier: Modifier = Modifier,
        content: @Composable ColumnScope.() -> Unit
    ) {
        androidx.compose.material3.Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            content()
        }
    }
    
    /**
     * Tarjeta elevada BCP
     */
    @Composable
    fun ElevatedCard(
        modifier: Modifier = Modifier,
        content: @Composable ColumnScope.() -> Unit
    ) {
        androidx.compose.material3.ElevatedCard(
            modifier = modifier,
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 8.dp
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            content()
        }
    }
    
    /**
     * Campo de texto BCP
     */
    @Composable
    fun TextField(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        label: @Composable (() -> Unit)? = null,
        placeholder: @Composable (() -> Unit)? = null,
        isError: Boolean = false,
        enabled: Boolean = true,
        singleLine: Boolean = false
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = label,
            placeholder = placeholder,
            isError = isError,
            enabled = enabled,
            singleLine = singleLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                errorBorderColor = MaterialTheme.colorScheme.error
            ),
            shape = RoundedCornerShape(8.dp)
        )
    }
    
    /**
     * Texto de título BCP
     */
    @Composable
    fun TitleText(
        text: String,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        color: Color = MaterialTheme.colorScheme.onSurface
    ) {
        Text(
            text = text,
            modifier = modifier,
            textAlign = textAlign,
            color = color,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )
    }
    
    /**
     * Texto de subtítulo BCP
     */
    @Composable
    fun SubtitleText(
        text: String,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        color: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        Text(
            text = text,
            modifier = modifier,
            textAlign = textAlign,
            color = color,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 24.sp
        )
    }
    
    /**
     * Texto de cuerpo BCP
     */
    @Composable
    fun BodyText(
        text: String,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        color: Color = MaterialTheme.colorScheme.onSurface
    ) {
        Text(
            text = text,
            modifier = modifier,
            textAlign = textAlign,
            color = color,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp
        )
    }
    
    /**
     * Texto de caption BCP
     */
    @Composable
    fun CaptionText(
        text: String,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        color: Color = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        Text(
            text = text,
            modifier = modifier,
            textAlign = textAlign,
            color = color,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp
        )
    }
    
    /**
     * Badge de estado BCP
     */
    @Composable
    fun StatusBadge(
        text: String,
        status: BcpStatus = BcpStatus.Info,
        modifier: Modifier = Modifier
    ) {
        val backgroundColor = when (status) {
            BcpStatus.Success -> Color(0xFFE6F7ED) // Green 050
            BcpStatus.Error -> Color(0xFFFEE6E6)   // Red 050
            BcpStatus.Warning -> Color(0xFFFFF8E6) // Yellow 050
            BcpStatus.Info -> Color(0xFFE4F5FB)    // Sky 050
        }
        
        val textColor = when (status) {
            BcpStatus.Success -> Color(0xFF057A3E) // Green 600
            BcpStatus.Error -> Color(0xFFE10505)   // Red 600
            BcpStatus.Warning -> Color(0xFFE1A505) // Yellow 600
            BcpStatus.Info -> Color(0xFF0A78CD)    // Sky 600
        }
        
        Box(
            modifier = modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 12.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
    
    /**
     * Divider BCP
     */
    @Composable
    fun Divider(
        modifier: Modifier = Modifier,
        color: Color = MaterialTheme.colorScheme.outline
    ) {
        androidx.compose.material3.Divider(
            modifier = modifier,
            color = color,
            thickness = 1.dp
        )
    }
    
    /**
     * Spacer BCP
     */
    @Composable
    fun Spacer(
        size: BcpSpacingSize = BcpSpacingSize.Medium
    ) {
        val spacing = when (size) {
            BcpSpacingSize.None -> 0.dp
            BcpSpacingSize.Small -> 8.dp
            BcpSpacingSize.Medium -> 16.dp
            BcpSpacingSize.Large -> 24.dp
            BcpSpacingSize.XLarge -> 32.dp
        }
        
        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(spacing)
        )
    }
    
    /**
     * Horizontal Spacer BCP
     */
    @Composable
    fun HorizontalSpacer(
        size: BcpSpacingSize = BcpSpacingSize.Medium
    ) {
        val spacing = when (size) {
            BcpSpacingSize.None -> 0.dp
            BcpSpacingSize.Small -> 8.dp
            BcpSpacingSize.Medium -> 16.dp
            BcpSpacingSize.Large -> 24.dp
            BcpSpacingSize.XLarge -> 32.dp
        }
        
        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.width(spacing)
        )
    }
}

/**
 * Estados de badge BCP
 */
enum class BcpStatus {
    Success,
    Error,
    Warning,
    Info
}

/**
 * Tamaños de espaciado BCP
 */
enum class BcpSpacingSize {
    None,
    Small,
    Medium,
    Large,
    XLarge
}
