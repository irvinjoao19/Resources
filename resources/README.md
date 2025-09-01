# BCP Android Resources

**Librería de recursos de diseño para Android con Jetpack Compose**

Esta librería proporciona un sistema completo de tokens de diseño, temas y componentes Compose para aplicaciones Android modernas, siguiendo las directrices de diseño de BCP.

## 📱 Características

- **Sistema completo de tokens de diseño** (colores, tipografía, espaciado, bordes, efectos)
- **Temas Material 3** con esquemas de colores claro y oscuro
- **Componentes Compose reutilizables** predefinidos
- **Gestión de temas** con cambio dinámico
- **Tipos seguros** con Kotlin
- **Integración completa** con Material 3

## 🚀 Instalación

### 1. Agregar la dependencia

```gradle
// En el build.gradle del módulo app
dependencies {
    implementation project(':resources')
    
    // Compose dependencies (using Version Catalog)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.activity.compose)
}
```

### 2. Habilitar Compose

```gradle
android {
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}
```

### 3. Configurar en settings.gradle

```gradle
// En settings.gradle
include ':resources'
```

## 📖 Uso

### Aplicar el Tema BCP

```kotlin
import com.gongora.resources.compose.BcpTheme

@Composable
fun MyApp() {
    BcpTheme {
        // Tu contenido aquí
        MyScreen()
    }
}
```

### Usar Componentes BCP

```kotlin
import com.gongora.resources.compose.components.BcpComponents
import com.gongora.resources.compose.components.BcpStatus
import com.gongora.resources.compose.components.BcpSpacingSize

@Composable
fun MyScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // Título
        BcpComponents.TitleText(
            text = "Mi Título",
            textAlign = TextAlign.Center
        )
        
        BcpComponents.Spacer(BcpSpacingSize.Medium)
        
        // Botón primario
        BcpComponents.PrimaryButton(
            onClick = { /* Acción */ }
        ) {
            Text("Botón Primario")
        }
        
        // Tarjeta
        BcpComponents.Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                BcpComponents.SubtitleText("Contenido de la tarjeta")
                BcpComponents.BodyText("Este es el contenido de la tarjeta.")
            }
        }
    }
}
```

### Tokens de Tipografía

```kotlin
import com.gongora.resources.BCPResources

// Obtener Typeface
val brandTypeface = BCPResources.typography.getBrandTypeface(Typography.FontWeight.bold)
val supportiveTypeface = BCPResources.typography.getSupportiveTypeface(Typography.FontWeight.regular)

// Tamaños de fuente
val fontSize = BCPResources.typography.FontSize.large // 16sp
val lineHeight = BCPResources.typography.LineHeight.medium // 20sp
```

### Tokens de Espaciado

```kotlin
import com.gongora.resources.BCPResources

// Espaciado común
val padding = BCPResources.spacing.Common.md // 12dp
val margin = BCPResources.spacing.Margin.lg // 16dp

// Espaciado específico
val smallSpacing = BCPResources.spacing.Small.small // 16dp
val largeSpacing = BCPResources.spacing.Large.large // 64dp
```

### Tokens de Bordes

```kotlin
import com.gongora.resources.BCPResources

// Radios de borde
val radius = BCPResources.border.Radius.medium // 8dp
val width = BCPResources.border.Width.thin // 1dp

// Calcular radio por tamaño
val buttonRadius = BCPResources.border.getRadiusBySize(48f) // 8dp
```

### Tokens de Efectos

```kotlin
import com.gongora.resources.BCPResources

// Elevación
val elevation = BCPResources.effects.Shadow.Medium.elevation // 4dp

// Sombras
val shadowRadius = BCPResources.effects.getShadowRadius(2) // 8dp
val shadowColor = BCPResources.effects.getShadowColor(2) // Color con alpha
```

### Sistema de Temas

```kotlin
import com.gongora.resources.BCPResources
import com.gongora.resources.ThemeManager

// Obtener tema actual
val currentTheme = BCPResources.currentTheme
val aliasTokens = BCPResources.aliasTokens

// Cambiar tema
BCPResources.setTheme(ThemeManager.ThemeType.DARK)
BCPResources.toggleTheme()

// Verificar tema actual
if (BCPResources.isLightTheme()) {
    // Usar colores del tema claro
    val textColor = BCPResources.aliasTokens.textPrimary
    val backgroundColor = BCPResources.aliasTokens.surfacePrimary
}
```

### AliasTokens

Los AliasTokens proporcionan acceso contextual a los tokens:

```kotlin
import com.gongora.resources.BCPResources

val theme = BCPResources.currentTheme

// Surface tokens
val surfacePrimary = theme.aliasTokens.surfacePrimary
val surfaceSecondary = theme.aliasTokens.surfaceSecondary

// Text tokens
val textPrimary = theme.aliasTokens.textPrimary
val textSecondary = theme.aliasTokens.textSecondary
val textDisabled = theme.aliasTokens.textDisabled

// Border tokens
val borderPrimary = theme.aliasTokens.borderPrimary
val borderSecondary = theme.aliasTokens.borderSecondary

// Icon tokens
val iconPrimary = theme.aliasTokens.iconPrimary
val iconSecondary = theme.aliasTokens.iconSecondary

// Interactive tokens
val interactivePrimary = theme.aliasTokens.interactivePrimary
val interactiveSecondary = theme.aliasTokens.interactiveSecondary

// Status tokens
val statusSuccess = theme.aliasTokens.statusSuccess
val statusError = theme.aliasTokens.statusError
val statusWarning = theme.aliasTokens.statusWarning
val statusInfo = theme.aliasTokens.statusInfo
```

## 🎨 Uso en XML

### Colores

```xml
<!-- En layout XML -->
<TextView
    android:textColor="@color/bcp_blue_500"
    android:background="@color/neutral_gray_050" />

<Button
    android:backgroundTint="@color/functional_green_600"
    android:textColor="@color/neutral_white" />
```

### Dimensiones

```xml
<!-- En layout XML -->
<LinearLayout
    android:padding="@dimen/spacing_md"
    android:layout_margin="@dimen/spacing_lg" />

<TextView
    android:textSize="@dimen/font_size_large"
    android:lineSpacingExtra="@dimen/line_height_medium" />

<CardView
    android:elevation="@dimen/elevation_medium"
    app:cardCornerRadius="@dimen/border_radius_medium" />
```

## 🔧 Configuración Avanzada

### Gestión de Temas Personalizada

```kotlin
import com.gongora.resources.ThemeManager

// Configurar tema inicial
ThemeManager.setTheme(ThemeManager.ThemeType.DARK)

// Escuchar cambios de tema
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Aplicar tema actual
        applyCurrentTheme()
    }
    
    private fun applyCurrentTheme() {
        val theme = BCPResources.currentTheme
        
        // Aplicar colores del tema
        window.statusBarColor = theme.aliasTokens.surfacePrimary
        window.navigationBarColor = theme.aliasTokens.surfacePrimary
    }
}
```

### Integración con ViewBinding

```kotlin
import com.gongora.resources.BCPResources

class MyFragment : Fragment() {
    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val theme = BCPResources.currentTheme
        
        // Aplicar tokens del tema
        binding.titleText.setTextColor(theme.aliasTokens.textPrimary)
        binding.container.setBackgroundColor(theme.aliasTokens.surfacePrimary)
        binding.button.setBackgroundColor(theme.aliasTokens.interactivePrimary)
    }
}
```

## 📚 Estructura del Proyecto

```
resources/
├── src/main/
│   ├── java/com/gongora/resources/
│   │   ├── tokens/
│   │   │   ├── Colors.kt          # Tokens de colores
│   │   │   ├── Typography.kt      # Tokens de tipografía
│   │   │   ├── Spacing.kt         # Tokens de espaciado
│   │   │   ├── Border.kt          # Tokens de bordes
│   │   │   └── Effects.kt         # Tokens de efectos
│   │   ├── theme/
│   │   │   ├── Theme.kt           # Interfaz base del tema
│   │   │   ├── LightTheme.kt      # Tema claro
│   │   │   └── DarkTheme.kt       # Tema oscuro
│   │   ├── ThemeManager.kt        # Gestor de temas
│   │   └── BCPResources.kt        # Punto de entrada principal
│   └── res/
│       └── values/
│           ├── colors.xml         # Colores XML
│           └── dimens.xml         # Dimensiones XML
└── README.md
```

## 🎯 Mejores Prácticas

1. **Usar AliasTokens**: Siempre usa AliasTokens en lugar de tokens directos para mejor mantenimiento
2. **Gestión de temas**: Implementa un sistema de gestión de temas consistente
3. **Consistencia**: Mantén consistencia en el uso de tokens en toda la aplicación
4. **Documentación**: Documenta cualquier token personalizado que agregues

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👥 Autores

- **BCP Design System Developer Team**

## 📚 Documentación Adicional

Para información más detallada sobre el uso de Compose, consulta:
- [README_COMPOSE.md](README_COMPOSE.md) - Guía completa de Compose

## 📞 Soporte

Para soporte técnico o preguntas sobre la implementación, contacta al equipo de desarrollo de BCP.
