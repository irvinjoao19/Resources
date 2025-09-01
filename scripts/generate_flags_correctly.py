#!/usr/bin/env python3
"""
Script para generar banderas con sus colores y patrones específicos.
Cada bandera tendrá su estructura y colores únicos.
"""

import os
from pathlib import Path

# Definir los colores y patrones de las banderas principales
FLAG_DEFINITIONS = {
    "peru": {
        "colors": ["#FF1612", "#F0F0F0", "#FF1612"],
        "description": "Tricolor vertical: rojo-blanco-rojo"
    },
    "mexico": {
        "colors": ["#006847", "#FFFFFF", "#CE1126"],
        "description": "Tricolor vertical: verde-blanco-rojo"
    },
    "colombia": {
        "colors": ["#FCD116", "#003893", "#CE1126"],
        "description": "Tricolor horizontal: amarillo-azul-rojo"
    },
    "argentina": {
        "colors": ["#75AADB", "#FFFFFF", "#75AADB"],
        "description": "Tricolor horizontal: azul-blanco-azul"
    },
    "chile": {
        "colors": ["#D52B1E", "#FFFFFF", "#0039A6"],
        "description": "Bicolor: rojo-blanco con estrella azul"
    },
    "brazil": {
        "colors": ["#009C3B", "#FFDF00", "#002776"],
        "description": "Verde con diamante amarillo y círculo azul"
    },
    "ecuador": {
        "colors": ["#FCD116", "#003893", "#CE1126"],
        "description": "Tricolor horizontal: amarillo-azul-rojo"
    },
    "bolivia": {
        "colors": ["#DA291C", "#F4E400", "#007934"],
        "description": "Tricolor horizontal: rojo-amarillo-verde"
    },
    "venezuela": {
        "colors": ["#FCD116", "#003893", "#CE1126"],
        "description": "Tricolor horizontal: amarillo-azul-rojo"
    },
    "uruguay": {
        "colors": ["#FFFFFF", "#0038A8"],
        "description": "Bicolor: blanco-azul con franjas"
    },
    "paraguay": {
        "colors": ["#D52B1E", "#FFFFFF", "#0038A8"],
        "description": "Tricolor horizontal: rojo-blanco-azul"
    },
    "france": {
        "colors": ["#002395", "#FFFFFF", "#ED2939"],
        "description": "Tricolor vertical: azul-blanco-rojo"
    },
    "germany": {
        "colors": ["#000000", "#DD0000", "#FFCE00"],
        "description": "Tricolor horizontal: negro-rojo-amarillo"
    },
    "italy": {
        "colors": ["#009246", "#FFFFFF", "#CE2B37"],
        "description": "Tricolor vertical: verde-blanco-rojo"
    },
    "spain": {
        "colors": ["#AA151B", "#F1BF00"],
        "description": "Bicolor horizontal: rojo-amarillo"
    },
    "unitedKingdom": {
        "colors": ["#012169", "#FFFFFF", "#C8102E"],
        "description": "Union Jack: azul-blanco-rojo"
    },
    "unitedStates": {
        "colors": ["#B22234", "#FFFFFF", "#3C3B6E"],
        "description": "Estrellas y franjas: rojo-blanco-azul"
    },
    "canada": {
        "colors": ["#FF0000", "#FFFFFF"],
        "description": "Hoja de maple: rojo-blanco"
    },
    "russia": {
        "colors": ["#FFFFFF", "#0039A6", "#D52B1E"],
        "description": "Tricolor horizontal: blanco-azul-rojo"
    }
}

def generate_flag_content(flag_name, colors):
    """Genera el contenido XML para una bandera específica."""
    
    if len(colors) == 2:
        # Banderas de 2 colores (horizontal)
        return f'''<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="32dp"
    android:height="32dp"
    android:viewportWidth="32"
    android:viewportHeight="32">
  <group>
    <clip-path
        android:pathData="M0,0h32v32h-32z"/>
    <path
        android:pathData="M0,0h32v16h-32z"
        android:fillColor="{colors[0]}"
        android:fillType="evenOdd"/>
    <path
        android:pathData="M0,16h32v16h-32z"
        android:fillColor="{colors[1]}"
        android:fillType="evenOdd"/>
  </group>
</vector>'''
    
    elif len(colors) == 3:
        # Banderas de 3 colores (vertical o horizontal)
        if flag_name in ["peru", "mexico", "france", "italy"]:
            # Tricolor vertical
            return f'''<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="32dp"
    android:height="32dp"
    android:viewportWidth="32"
    android:viewportHeight="32">
  <group>
    <clip-path
        android:pathData="M0,0h32v32h-32z"/>
    <path
        android:pathData="M0,0h10.67v32h-10.67z"
        android:fillColor="{colors[0]}"
        android:fillType="evenOdd"/>
    <path
        android:pathData="M10.67,0h10.67v32h-10.67z"
        android:fillColor="{colors[1]}"
        android:fillType="evenOdd"/>
    <path
        android:pathData="M21.33,0h10.67v32h-10.67z"
        android:fillColor="{colors[2]}"
        android:fillType="evenOdd"/>
  </group>
</vector>'''
        else:
            # Tricolor horizontal
            return f'''<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="32dp"
    android:height="32dp"
    android:viewportWidth="32"
    android:viewportHeight="32">
  <group>
    <clip-path
        android:pathData="M0,0h32v32h-32z"/>
    <path
        android:pathData="M0,0h32v10.67h-32z"
        android:fillColor="{colors[0]}"
        android:fillType="evenOdd"/>
    <path
        android:pathData="M0,10.67h32v10.67h-32z"
        android:fillColor="{colors[1]}"
        android:fillType="evenOdd"/>
    <path
        android:pathData="M0,21.33h32v10.67h-32z"
        android:fillColor="{colors[2]}"
        android:fillType="evenOdd"/>
  </group>
</vector>'''

def generate_flags():
    """Genera todas las banderas con sus colores específicos."""
    
    drawable_dir = Path("resources/src/main/res/drawable")
    
    print("🎨 Generando banderas con colores específicos...")
    
    generated_count = 0
    
    for flag_name, definition in FLAG_DEFINITIONS.items():
        flag_file = drawable_dir / f"ic_flags_{flag_name}.xml"
        
        try:
            # Generar contenido específico para cada bandera
            content = generate_flag_content(flag_name, definition["colors"])
            
            # Escribir el archivo
            with open(flag_file, 'w', encoding='utf-8') as f:
                f.write(content)
            
            generated_count += 1
            print(f"  ✅ {flag_name}: {definition['description']}")
                
        except Exception as e:
            print(f"  ❌ Error generando {flag_name}: {e}")
    
    print(f"\n🎉 Proceso completado!")
    print(f"🔧 Banderas generadas: {generated_count}")
    print(f"📊 Total de definiciones: {len(FLAG_DEFINITIONS)}")

if __name__ == "__main__":
    generate_flags()
