# BCP Android Resources - Compose

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
        
        BcpComponents.Spacer(BcpSpacingSize.Small)
        
        // Botón secundario
        BcpComponents.SecondaryButton(
            onClick = { /* Acción */ }
        ) {
            Text("Botón Secundario")
        }
        
        BcpComponents.Spacer(BcpSpacingSize.Medium)
        
        // Tarjeta
        BcpComponents.Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                BcpComponents.SubtitleText("Contenido de la tarjeta")
                BcpComponents.BodyText("Este es el contenido de la tarjeta.")
            }
        }
        
        BcpComponents.Spacer(BcpSpacingSize.Medium)
        
        // Badges de estado
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BcpComponents.StatusBadge(
                text = "Éxito",
                status = BcpStatus.Success
            )
            BcpComponents.StatusBadge(
                text = "Error",
                status = BcpStatus.Error
            )
            BcpComponents.StatusBadge(
                text = "Advertencia",
                status = BcpStatus.Warning
            )
            BcpComponents.StatusBadge(
                text = "Info",
                status = BcpStatus.Info
            )
        }
    }
}
```

### Usar Tokens Específicos

```kotlin
import com.gongora.resources.compose.bcpTheme

@Composable
fun TokenExamples() {
    val theme = bcpTheme()
    
    Column {
        // Usar colores específicos
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    color = theme.colors.brand.blue.color500,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = "Color BCP Blue 500",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        
        // Usar colores funcionales
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = theme.colors.functional.success.color600,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = "Success",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
```

### Cambio Dinámico de Temas

```kotlin
import com.gongora.resources.compose.BcpTheme

@Composable
fun ThemeToggleExample() {
    var isDarkTheme by remember { mutableStateOf(false) }
    
    BcpTheme(darkTheme = isDarkTheme) {
        Column {
            BcpComponents.PrimaryButton(
                onClick = { isDarkTheme = !isDarkTheme }
            ) {
                Text(
                    if (isDarkTheme) "Cambiar a Tema Claro" 
                    else "Cambiar a Tema Oscuro"
                )
            }
            
            // El resto de tu contenido se adaptará automáticamente
        }
    }
}
```

## 🎨 Componentes Disponibles

### Botones
- `BcpComponents.PrimaryButton` - Botón primario con color de marca
- `BcpComponents.SecondaryButton` - Botón secundario con borde
- `BcpComponents.TextButton` - Botón de texto

### Tarjetas
- `BcpComponents.Card` - Tarjeta estándar con elevación
- `BcpComponents.ElevatedCard` - Tarjeta con elevación aumentada

### Texto
- `BcpComponents.TitleText` - Texto de título principal
- `BcpComponents.SubtitleText` - Texto de subtítulo
- `BcpComponents.BodyText` - Texto de cuerpo
- `BcpComponents.CaptionText` - Texto de caption

### Campos de Entrada
- `BcpComponents.TextField` - Campo de texto con validación

### Estados
- `BcpComponents.StatusBadge` - Badge de estado (Success, Error, Warning, Info)

### Utilidades
- `BcpComponents.Divider` - Separador
- `BcpComponents.Spacer` - Espaciador vertical
- `BcpComponents.HorizontalSpacer` - Espaciador horizontal

## 🎯 Esquemas de Colores

### Tema Claro
- **Primary**: BCP Blue 500 (#175EFB)
- **Secondary**: BCP Orange 500 (#F7630C)
- **Background**: White (#FFFFFF)
- **Surface**: Gray 050 (#F1F4F8)
- **Error**: Red 600 (#E10505)
- **Success**: Green 600 (#057A3E)
- **Warning**: Yellow 600 (#E1A505)
- **Info**: SkyBlue 600 (#057AE1)

### Tema Oscuro
- **Primary**: BCP Blue 400 (#427DFC)
- **Secondary**: BCP Orange 400 (#FF803B)
- **Background**: Gray 900 (#0F1419)
- **Surface**: Gray 800 (#16202C)
- **Error**: Red 400 (#FE4242)
- **Success**: Green 400 (#42AC71)
- **Warning**: Yellow 400 (#FFC742)
- **Info**: SkyBlue 400 (#42ACFF)

## 📐 Espaciado

El sistema utiliza un espaciado basado en múltiplos de 4dp:

```kotlin
enum class BcpSpacingSize {
    None,    // 0dp
    Small,   // 8dp
    Medium,  // 16dp
    Large,   // 24dp
    XLarge   // 32dp
}
```

## 🔧 Configuración Avanzada

### Personalizar el Tema

```kotlin
@Composable
fun CustomBcpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        ComposeTheme.DarkColorScheme.copy(
            // Personalizar colores aquí
            primary = Color(0xFF175EFB)
        )
    } else {
        ComposeTheme.LightColorScheme.copy(
            // Personalizar colores aquí
            primary = Color(0xFF175EFB)
        )
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
```

### Crear Componentes Personalizados

```kotlin
@Composable
fun CustomBcpButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        content()
    }
}
```

## 📚 Estructura del Proyecto

```
resources/
├── src/main/
│   ├── java/com/gongora/resources/
│   │   ├── tokens/                    # Tokens base
│   │   ├── theme/                     # Temas base
│   │   ├── compose/
│   │   │   ├── ComposeTheme.kt        # Sistema de temas Compose
│   │   │   └── components/
│   │   │       └── BcpComponents.kt   # Componentes Compose
│   │   ├── ThemeManager.kt            # Gestor de temas
│   │   └── BCPResources.kt            # Punto de entrada
│   └── res/
│       └── values/
│           ├── colors.xml             # Colores XML
│           └── dimens.xml             # Dimensiones XML
└── README_COMPOSE.md
```

## 🎯 Mejores Prácticas

1. **Usar componentes BCP**: Siempre usa los componentes predefinidos para consistencia
2. **Aplicar el tema**: Envuelve tu app con `BcpTheme`
3. **Usar espaciado consistente**: Utiliza `BcpSpacingSize` para espaciado
4. **Mantener tipos seguros**: Usa los enums y tipos definidos
5. **Documentar personalizaciones**: Documenta cualquier componente personalizado

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

Para soporte técnico o preguntas sobre la implementación en Compose, contacta al equipo de desarrollo de BCP.
