#!/usr/bin/env python3
"""
Script para generar automáticamente las referencias de iconos en Kotlin
basado en los archivos Vector Drawables existentes

Uso:
    python3 generate_icon_references.py --drawable-dir resources/src/main/res/drawable

Autor: BCP Design System Developer Team
"""

import os
import argparse
import re
from pathlib import Path
from collections import defaultdict


def generate_kotlin_references(drawable_dir: str) -> str:
    """Genera las referencias de iconos en Kotlin"""
    
    drawable_path = Path(drawable_dir)
    if not drawable_path.exists():
        return "❌ El directorio de drawable no existe"
    
    # Encontrar todos los archivos Vector Drawables
    drawable_files = list(drawable_path.glob("ic_*.xml"))
    
    if not drawable_files:
        return "❌ No se encontraron archivos Vector Drawables"
    
    # Organizar por categorías
    categories = defaultdict(list)
    
    for file_path in drawable_files:
        filename = file_path.stem  # Sin extensión
        if filename.startswith("ic_"):
            # Extraer categoría y nombre del icono
            parts = filename[3:].split("_", 1)  # Remover "ic_" y dividir por primer "_"
            if len(parts) >= 2:
                category = parts[0]
                icon_name = parts[1]
                categories[category].append((icon_name, filename))
    
    # Generar código Kotlin
    kotlin_code = """package com.gongora.resources.tokens

import androidx.annotation.DrawableRes

/**
 * Tokens de iconos para el sistema de diseño BCP
 *
 * Define un sistema de iconos completo que incluye:
 * - Iconos organizados por categorías semánticas
 * - Referencias a Vector Drawables
 * - Sistema de tipos para autocompletado
 *
 * @author BCP Design System Developer Team
 * @since 1.0.0
 * @version 1.0.0
 */
object Icons {
"""
    
    # Generar cada categoría
    for category, icons in sorted(categories.items()):
        # Convertir nombre de categoría a PascalCase
        category_name = "".join(word.capitalize() for word in category.split("-"))
        
        kotlin_code += f"""
    // ===== {category_name.upper()} ICONS =====
    
    /**
     * Iconos de {category.replace('-', ' ')}
     */
    object {category_name} {{"""
        
        # Agregar cada icono
        for icon_name, filename in sorted(icons):
            # Convertir nombre del icono a camelCase
            kotlin_name = re.sub(r'[^a-zA-Z0-9]', '_', icon_name)
            kotlin_name = ''.join(word.capitalize() if i > 0 else word.lower() 
                                 for i, word in enumerate(kotlin_name.split('_')))
            
            kotlin_code += f"""
        @DrawableRes val {kotlin_name} = com.gongora.resources.R.drawable.{filename}"""
        
        kotlin_code += """
    }
"""
    
    kotlin_code += """}
"""
    
    return kotlin_code


def main():
    parser = argparse.ArgumentParser(
        description="Genera referencias de iconos en Kotlin"
    )
    parser.add_argument(
        "--drawable-dir",
        default="resources/src/main/res/drawable",
        help="Directorio con archivos Vector Drawables"
    )
    parser.add_argument(
        "--output",
        default="resources/src/main/java/com/gongora/resources/tokens/Icons.kt",
        help="Archivo de salida para el código Kotlin"
    )
    
    args = parser.parse_args()
    
    # Generar código Kotlin
    kotlin_code = generate_kotlin_references(args.drawable_dir)
    
    # Escribir archivo
    output_path = Path(args.output)
    output_path.parent.mkdir(parents=True, exist_ok=True)
    
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write(kotlin_code)
    
    print(f"✅ Código Kotlin generado en: {output_path}")
    print(f"📊 Total de archivos procesados: {len(list(Path(args.drawable_dir).glob('ic_*.xml')))}")


if __name__ == "__main__":
    main()
