# 🎨 BCP Android Resources

**Librería de recursos de diseño para Android con Jetpack Compose**

Una librería completa que proporciona un sistema de tokens de diseño, temas dinámicos y componentes Compose para aplicaciones Android modernas, siguiendo las directrices de diseño de BCP (Banco de Crédito del Perú).

## 📱 Características

- ✅ **Sistema completo de tokens de diseño** (colores, tipografía, espaciado, bordes, efectos)
- ✅ **Alias Tokens** con estructura equivalente a React Native
- ✅ **Temas Material 3** con esquemas de colores claro y oscuro
- ✅ **Hook `useBcpAliasTokens()`** para gestión reactiva de temas
- ✅ **Estados interactivos** (default, hover, pressed, disabled)
- ✅ **Componentes Compose** predefinidos y reutilizables
- ✅ **Gestión de temas** con cambio dinámico
- ✅ **Tipos seguros** con Kotlin
- ✅ **Integración completa** con Material 3
- ✅ **Compatibilidad hacia atrás** con tokens legacy

## 🚀 Instalación

### 1. Agregar la dependencia

```gradle
// En el build.gradle del módulo app
dependencies {
    implementation project(':resources')
    
    // Compose dependencies (usando Version Catalog)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
}
```

### 2. Habilitar Compose

```gradle
android {
    buildFeatures {
        compose = true
    }
    
    kotlin {
        jvmToolchain(17)
    }
}
```

### 3. Configurar en settings.gradle

```gradle
// En settings.gradle
include ':resources'
```

## 🎯 Alias Tokens - Guía Completa

### ¿Qué son los Alias Tokens?

Los **Alias Tokens** son tokens contextuales que mapean tokens de diseño base a roles funcionales específicos. Proporcionan una estructura equivalente a React Native con estados interactivos completos.

### Estructura de Alias Tokens

```kotlin
data class AliasTokens(
    val surface: SurfaceTokens,    // Tokens de superficie
    val text: TextTokens,          // Tokens de texto
    val border: BorderTokens,      // Tokens de borde
    val icon: IconTokens,          // Tokens de iconos
    val effects: EffectsTokens     // Tokens de efectos
)
```

### Hook Principal: `useBcpAliasTokens()`

El hook `useBcpAliasTokens()` es el mecanismo principal para acceder a los Alias Tokens. Proporciona acceso reactivo a todos los tokens de diseño que se adaptan automáticamente al tema actual.

#### Uso Básico

```kotlin
@Composable
fun MyComponent() {
    val (tokens, isDark, toggleTheme) = useBcpAliasTokens()
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(tokens.surface.static.regular.flat.primary))
            .padding(16.dp)
    ) {
        Text(
            text = "Tema: ${if (isDark) "Oscuro" else "Claro"}",
            color = Color(tokens.text.static.regular.primary),
            style = MaterialTheme.typography.headlineMedium
        )
        
        Button(onClick = toggleTheme) {
            Text("Cambiar Tema")
        }
    }
}
```

#### Acceso Directo a Categorías

```kotlin
@Composable
fun ComponentWithDirectAccess() {
    val (surface, text, border, icon) = useBcpAliasTokens()
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(surface.static.regular.flat.primary)
        ),
        border = BorderStroke(1.dp, Color(border.static.regular.medium))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Título Principal",
                color = Color(text.static.regular.primary),
                style = MaterialTheme.typography.headlineSmall
            )
            
            Text(
                text = "Texto secundario",
                color = Color(text.static.regular.secondary),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
```

#### Estados Interactivos

```kotlin
@Composable
fun InteractiveButton() {
    val (tokens) = useBcpAliasTokens()
    var isPressed by remember { mutableStateOf(false) }
    
    Button(
        onClick = { /* acción */ },
        modifier = Modifier
            .background(
                color = if (isPressed) 
                    Color(tokens.surface.interactive.base.regular.primary.pressed)
                else 
                    Color(tokens.surface.interactive.base.regular.primary.default)
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            }
    ) {
        Text(
            text = "Botón Interactivo",
            color = Color(tokens.text.static.regular.primary)
        )
    }
}
```

#### Tema Forzado

```kotlin
@Composable
fun ForcedThemeComponent() {
    // Forzar tema claro
    val (lightTokens) = useBcpAliasTokens(ThemeManager.ThemeType.LIGHT)
    
    // Forzar tema oscuro
    val (darkTokens) = useBcpAliasTokens(ThemeManager.ThemeType.DARK)
    
    // Comparar ambos temas
    Row {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(lightTokens.surface.static.regular.flat.primary))
        ) {
            Text("Tema Claro")
        }
        
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(darkTokens.surface.static.regular.flat.primary))
        ) {
            Text("Tema Oscuro")
        }
    }
}
```

### Modos de Uso del Hook

#### 1. Modo Automático (Recomendado)
```kotlin
// Escucha automáticamente los cambios de tema del sistema
val (tokens, isDark) = useBcpAliasTokens()

// O con más propiedades
val (tokens, isDark, isLight, theme, toggleTheme) = useBcpAliasTokens()
```

#### 2. Modo Forzado
```kotlin
// Siempre tema claro
val (tokens) = useBcpAliasTokens(ThemeManager.ThemeType.LIGHT)

// Siempre tema oscuro
val (tokens) = useBcpAliasTokens(ThemeManager.ThemeType.DARK)

// O usando el resultado completo
val result = useBcpAliasTokens(ThemeManager.ThemeType.LIGHT)
val tokens = result.tokens
val isDark = result.isDark
```

### Estructura Completa de Tokens

#### Surface Tokens
```kotlin
// Superficies estáticas
tokens.surface.static.regular.flat.primary      // Fondo principal
tokens.surface.static.regular.flat.secondary    // Fondo secundario
tokens.surface.static.regular.flat.tertiary     // Fondo terciario

// Superficies semánticas
tokens.surface.static.semantic.success          // Fondo de éxito
tokens.surface.static.semantic.error            // Fondo de error
tokens.surface.static.semantic.warning          // Fondo de advertencia
tokens.surface.static.semantic.information      // Fondo de información

// Superficies interactivas (con estados)
tokens.surface.interactive.base.regular.primary.default    // Botón primario
tokens.surface.interactive.base.regular.primary.hover      // Botón primario hover
tokens.surface.interactive.base.regular.primary.pressed    // Botón primario presionado
tokens.surface.interactive.base.regular.primary.disabled   // Botón primario deshabilitado

// Superficies de peligro
tokens.surface.interactive.base.danger.primary.default     // Botón de peligro
tokens.surface.interactive.base.danger.primary.hover       // Botón de peligro hover
```

#### Text Tokens
```kotlin
// Texto estático
tokens.text.static.regular.primary              // Texto principal
tokens.text.static.regular.secondary            // Texto secundario
tokens.text.static.regular.inverse              // Texto inverso

// Texto semántico
tokens.text.static.semantic.success             // Texto de éxito
tokens.text.static.semantic.error               // Texto de error
tokens.text.static.semantic.warning             // Texto de advertencia
tokens.text.static.semantic.information         // Texto de información

// Texto interactivo
tokens.text.interactive.regular.default         // Enlace por defecto
tokens.text.interactive.regular.hover           // Enlace hover
tokens.text.interactive.regular.pressed         // Enlace presionado
tokens.text.interactive.regular.disabled        // Enlace deshabilitado
```

#### Border Tokens
```kotlin
// Bordes estáticos
tokens.border.static.regular.strong             // Borde fuerte
tokens.border.static.regular.medium             // Borde medio
tokens.border.static.regular.soft               // Borde suave

// Bordes semánticos
tokens.border.static.semantic.success           // Borde de éxito
tokens.border.static.semantic.error             // Borde de error
tokens.border.static.semantic.warning           // Borde de advertencia
tokens.border.static.semantic.information       // Borde de información

// Bordes interactivos
tokens.border.interactive.regular.default       // Borde interactivo por defecto
tokens.border.interactive.regular.hover         // Borde interactivo hover
tokens.border.interactive.regular.active        // Borde interactivo activo
tokens.border.interactive.regular.disabled      // Borde interactivo deshabilitado
```

#### Icon Tokens
```kotlin
// Iconos estáticos
tokens.icon.static.regular.primary              // Icono primario
tokens.icon.static.regular.secondary            // Icono secundario
tokens.icon.static.regular.inverse              // Icono inverso

// Iconos semánticos
tokens.icon.static.semantic.success             // Icono de éxito
tokens.icon.static.semantic.error               // Icono de error
tokens.icon.static.semantic.warning             // Icono de advertencia
tokens.icon.static.semantic.information         // Icono de información

// Iconos interactivos
tokens.icon.interactive.regular.default         // Icono interactivo por defecto
tokens.icon.interactive.regular.hover           // Icono interactivo hover
tokens.icon.interactive.regular.pressed         // Icono interactivo presionado
tokens.icon.interactive.regular.disabled        // Icono interactivo deshabilitado
```

## 📖 Uso Básico

### Aplicar el Tema BCP

```kotlin
import com.gongora.resources.compose.useBcpAliasTokens

@Composable
fun MyApp() {
    val (isDark) = useBcpAliasTokens()
    
    MaterialTheme(
        colorScheme = if (isDark) {
            androidx.compose.material3.darkColorScheme()
        } else {
            androidx.compose.material3.lightColorScheme()
        }
    ) {
        // Tu contenido aquí
        MyScreen()
    }
}
```

### Usar Tokens en Componentes

```kotlin
@Composable
fun MyComponent() {
    val (tokens) = useBcpAliasTokens()
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(tokens.border.static.regular.medium),
                shape = RoundedCornerShape(8.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(tokens.surface.static.regular.flat.primary)
        )
    ) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
            Text(
                text = "Título",
                color = Color(tokens.text.static.regular.primary),
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = "Contenido",
                color = Color(tokens.text.static.regular.secondary)
            )
        }
    }
}
```

## 🎨 Ejemplos Avanzados

### Botón con Estados Interactivos

```kotlin
@Composable
fun BcpButton(
    text: String,
    onClick: () -> Unit,
    variant: ButtonVariant = ButtonVariant.PRIMARY,
    enabled: Boolean = true
) {
    val (tokens) = useBcpAliasTokens()
    
    val backgroundColor = when (variant) {
        ButtonVariant.PRIMARY -> tokens.surface.interactive.base.regular.primary.default
        ButtonVariant.SECONDARY -> tokens.surface.interactive.base.regular.secondary.default
        ButtonVariant.DANGER -> tokens.surface.interactive.base.danger.primary.default
    }
    
    val textColor = when (variant) {
        ButtonVariant.PRIMARY -> tokens.text.static.regular.inverse
        ButtonVariant.SECONDARY -> tokens.text.static.regular.primary
        ButtonVariant.DANGER -> tokens.text.static.regular.inverse
    }
    
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(backgroundColor),
            contentColor = Color(textColor)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text)
    }
}

enum class ButtonVariant {
    PRIMARY, SECONDARY, DANGER
}
```

### Card con Estados Semánticos

```kotlin
@Composable
fun BcpStatusCard(
    status: StatusType,
    title: String,
    content: String
) {
    val (tokens) = useBcpAliasTokens()
    
    val borderColor = when (status) {
        StatusType.SUCCESS -> tokens.border.static.semantic.success
        StatusType.ERROR -> tokens.border.static.semantic.error
        StatusType.WARNING -> tokens.border.static.semantic.warning
        StatusType.INFO -> tokens.border.static.semantic.information
    }
    
    val backgroundColor = when (status) {
        StatusType.SUCCESS -> tokens.surface.static.semantic.successSoft
        StatusType.ERROR -> tokens.surface.static.semantic.errorSoft
        StatusType.WARNING -> tokens.surface.static.semantic.warningSoft
        StatusType.INFO -> tokens.surface.static.semantic.informationSoft
    }
    
    val textColor = when (status) {
        StatusType.SUCCESS -> tokens.text.static.semantic.success
        StatusType.ERROR -> tokens.text.static.semantic.error
        StatusType.WARNING -> tokens.text.static.semantic.warning
        StatusType.INFO -> tokens.text.static.semantic.information
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color(borderColor),
                shape = RoundedCornerShape(8.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color(backgroundColor)
        )
    ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
            Text(
                text = title,
                color = Color(textColor),
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = content,
                color = Color(tokens.text.static.regular.secondary)
            )
        }
    }
}

enum class StatusType {
    SUCCESS, ERROR, WARNING, INFO
}
```

### Toggle de Tema

```kotlin
@Composable
fun ThemeToggle() {
    val (isDark, toggleTheme) = useBcpAliasTokens()
    
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Tema ${if (isDark) "Oscuro" else "Claro"}",
            style = MaterialTheme.typography.titleMedium
        )
        
        Switch(
            checked = isDark,
            onCheckedChange = { toggleTheme() }
        )
    }
}
```

## 🔧 Funciones Auxiliares

### Obtener Tema Específico

```kotlin
// Obtener tokens de un tema específico
val lightTheme = getTheme(ThemeManager.ThemeType.LIGHT)
val darkTheme = getTheme(ThemeManager.ThemeType.DARK)

// Comparar tokens
val lightBackground = lightTheme.surface.static.regular.flat.primary
val darkBackground = darkTheme.surface.static.regular.flat.primary
```

### Obtener Tema Actual

```kotlin
@Composable
fun MyComponent() {
    val currentTokens = getCurrentTheme()
    
    Text(
        text = "Hola Mundo",
        color = Color(currentTokens.text.static.regular.primary)
    )
}
```

## 🎯 Tokens Base

### Colores

```kotlin
import com.gongora.resources.BCPResources

// Colores de marca
val brandBlue = BCPResources.colors.brand.blue.color500
val brandOrange = BCPResources.colors.brand.orange.color500

// Colores funcionales
val successGreen = BCPResources.colors.functional.success.color600
val errorRed = BCPResources.colors.functional.error.color600
val warningYellow = BCPResources.colors.functional.warning.color600
```

### Tipografía

```kotlin
// Obtener Typeface
val brandTypeface = BCPResources.typography.getBrandTypeface(Typography.FontWeight.bold)
val supportiveTypeface = BCPResources.typography.getSupportiveTypeface(Typography.FontWeight.regular)

// Tamaños de fuente
val fontSize = BCPResources.typography.FontSize.large // 16sp
val lineHeight = BCPResources.typography.LineHeight.medium // 20sp
```

### Fuentes en Jetpack Compose

```kotlin
// Usar fuentes en Compose
@Composable
fun MyText() {
    Text(
        text = "Texto con fuente personalizada",
        fontFamily = BCPResources.typography.getBrandFontFamily(),
        fontSize = BCPResources.typography.FontSize.large.sp,
        lineHeight = BCPResources.typography.LineHeight.medium.sp
    )
}

// Configurar tipografía en MaterialTheme
@Composable
fun MyApp() {
    MaterialTheme(
        typography = Typography(
            headlineLarge = TextStyle(
                fontFamily = BCPResources.typography.getBrandFontFamily(),
                fontSize = BCPResources.typography.FontSize.xLarge.sp,
                lineHeight = BCPResources.typography.LineHeight.large.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = BCPResources.typography.getSupportiveFontFamily(),
                fontSize = BCPResources.typography.FontSize.medium.sp,
                lineHeight = BCPResources.typography.LineHeight.medium.sp
            )
        )
    ) {
        // Tu contenido aquí
    }
}
```

### Espaciado

```kotlin
// Espaciado común
val padding = BCPResources.spacing.Common.md // 12dp
val margin = BCPResources.spacing.Margin.lg // 16dp

// Espaciado específico
val smallSpacing = BCPResources.spacing.Small.small // 16dp
val largeSpacing = BCPResources.spacing.Large.large // 64dp
```

### Bordes

```kotlin
// Radios de borde
val radius = BCPResources.border.Radius.medium // 8dp
val width = BCPResources.border.Width.thin // 1dp

// Calcular radio por tamaño
val buttonRadius = BCPResources.border.getRadiusBySize(48f) // 8dp
```

### Efectos

```kotlin
// Elevación
val elevation = BCPResources.effects.Shadow.Medium.elevation // 4dp

// Sombras
val shadowRadius = BCPResources.effects.getShadowRadius(2) // 8dp
val shadowColor = BCPResources.effects.getShadowColor(2) // Color con alpha
```

### Iconos y Drawables

```kotlin
// Usar iconos en Compose
@Composable
fun MyIcon() {
    Icon(
        painter = painterResource(id = R.drawable.ic_bcp_logo),
        contentDescription = "Logo BCP",
        tint = Color(tokens.icon.static.regular.primary)
    )
}

// Usar imágenes
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.bcp_background),
        contentDescription = "Fondo BCP",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

// Iconos con estados
@Composable
fun InteractiveIcon(
    isPressed: Boolean,
    isEnabled: Boolean
) {
    val (tokens) = useBcpAliasTokens()
    
    val iconColor = when {
        !isEnabled -> tokens.icon.interactive.regular.disabled
        isPressed -> tokens.icon.interactive.regular.pressed
        else -> tokens.icon.interactive.regular.default
    }
    
    Icon(
        painter = painterResource(id = R.drawable.ic_heart),
        contentDescription = "Favorito",
        tint = Color(iconColor)
    )
}
```


## 🔄 Migración desde Tokens Legacy

### Tokens Legacy (Deprecados pero Funcionales)

```kotlin
// ❌ DEPRECATED - Usar nueva estructura
val backgroundColor = BCPResources.aliasTokens.surfacePrimary
val textColor = BCPResources.aliasTokens.textPrimary

// ✅ NUEVA FORMA - Estructura anidada
val (tokens) = useBcpAliasTokens()
val backgroundColor = tokens.surface.static.regular.flat.primary
val textColor = tokens.text.static.regular.primary
```

### Mapeo de Tokens Legacy

| Legacy Token | Nueva Estructura |
|--------------|------------------|
| `surfacePrimary` | `tokens.surface.static.regular.flat.primary` |
| `surfaceSecondary` | `tokens.surface.static.regular.flat.secondary` |
| `textPrimary` | `tokens.text.static.regular.primary` |
| `textSecondary` | `tokens.text.static.regular.secondary` |
| `interactivePrimary` | `tokens.surface.interactive.base.regular.primary.default` |
| `statusSuccess` | `tokens.surface.static.semantic.success` |
| `statusError` | `tokens.surface.static.semantic.error` |

## 📚 Estructura del Proyecto

```
resources/
├── src/main/
│   ├── java/com/gongora/resources/
│   │   ├── tokens/                    # Tokens base
│   │   │   ├── Colors.kt             # Tokens de colores
│   │   │   ├── Typography.kt         # Tokens de tipografía
│   │   │   ├── Spacing.kt            # Tokens de espaciado
│   │   │   ├── Border.kt             # Tokens de bordes
│   │   │   ├── Effects.kt            # Tokens de efectos
│   │   │   └── Icons.kt              # Tokens de iconos
│   │   ├── theme/                     # Temas base
│   │   │   ├── Theme.kt              # Interfaz base del tema
│   │   │   ├── LightTheme.kt         # Tema claro
│   │   │   └── DarkTheme.kt          # Tema oscuro
│   │   ├── compose/                   # Integración con Compose
│   │   │   ├── useBcpAliasTokens.kt  # Hook principal
│   │   │   └── ComposeTheme.kt       # Sistema de temas Compose
│   │   ├── fonts/                     # Gestión de fuentes
│   │   │   └── Fonts.kt              # Configuración de fuentes
│   │   ├── utils/                     # Utilidades
│   │   │   └── EffectsExtensions.kt  # Extensiones para efectos
│   │   ├── ThemeManager.kt            # Gestor de temas
│   │   └── BCPResources.kt           # Punto de entrada principal
│   └── res/
│       ├── font/                      # Fuentes TTF/OTF
│       │   ├── brand_font_bold.ttf
│       │   ├── brand_font_regular.ttf
│       │   ├── supportive_font_bold.ttf
│       │   └── supportive_font_regular.ttf
│       └── drawable/                  # Recursos gráficos
│           ├── ic_*.xml              # Iconos vectoriales
│           └── *.webp                # Imágenes
└── README.md
```

### 📝 Notas sobre la Estructura

**✅ Recursos Necesarios:**
- **`res/font/`** - Fuentes TTF/OTF para tipografía
- **`res/drawable/`** - Iconos vectoriales e imágenes
- **Tokens Kotlin** - Colores, espaciado, bordes, efectos

**🎯 Ventajas de esta Estructura:**
- **Tipos seguros** - Todos los valores en Kotlin
- **IntelliSense completo** - Autocompletado en IDE
- **Refactoring seguro** - Cambios automáticos en todo el código
- **Validación en tiempo de compilación** - Errores detectados temprano
- **Optimizado para Compose** - Sin recursos XML innecesarios

## 🎯 Mejores Prácticas

### 1. Usar Alias Tokens
```kotlin
// ✅ CORRECTO - Usar Alias Tokens
val (tokens) = useBcpAliasTokens()
val backgroundColor = tokens.surface.static.regular.flat.primary

// ❌ EVITAR - Usar tokens directos
val backgroundColor = BCPResources.colors.brand.blue.color500
```

### 2. Gestión de Temas
```kotlin
// ✅ CORRECTO - Usar hook para gestión reactiva
val (isDark, toggleTheme) = useBcpAliasTokens()

// ❌ EVITAR - Cambiar tema directamente
BCPResources.setTheme(ThemeManager.ThemeType.DARK)
```

### 3. Estados Interactivos
```kotlin
// ✅ CORRECTO - Usar estados apropiados
val buttonColor = tokens.surface.interactive.base.regular.primary.hover

// ❌ EVITAR - Usar solo estado default
val buttonColor = tokens.surface.interactive.base.regular.primary.default
```

### 4. Consistencia
```kotlin
// ✅ CORRECTO - Mantener consistencia en el uso de tokens
val cardBackground = tokens.surface.static.regular.flat.primary
val cardBorder = tokens.border.static.regular.medium
val cardText = tokens.text.static.regular.primary
```

## 🚨 Notas Importantes

1. **Los tokens legacy siguen funcionando** pero están marcados como deprecated
2. **La nueva estructura es más verbosa** pero más clara y flexible
3. **El hook `useBcpAliasTokens()`** es la forma recomendada de usar tokens
4. **La compatibilidad hacia atrás** se mantiene para facilitar la migración
5. **Los temas se aplican automáticamente** cuando usas el hook

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

## 📞 Soporte

Para soporte técnico o preguntas sobre la implementación, contacta al equipo de desarrollo de BCP.

---

**¿Necesitas ayuda con la implementación o tienes alguna pregunta sobre Alias Tokens?** ¡Estamos aquí para ayudarte!