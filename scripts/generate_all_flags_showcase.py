#!/usr/bin/env python3
"""
Script para generar todas las 132 banderas para el showcase
"""

import os
from pathlib import Path

def generate_all_flags_showcase():
    """Genera todas las banderas para el showcase"""
    
    drawable_dir = Path("resources/src/main/res/drawable")
    
    print("🔧 Generando todas las banderas para el showcase...")
    
    # Buscar todos los archivos de banderas
    flag_files = list(drawable_dir.glob("ic_flags_*.xml"))
    
    if not flag_files:
        print("❌ No se encontraron archivos de banderas")
        return
    
    print(f"📁 Encontrados {len(flag_files)} archivos de banderas")
    
    # Generar el contenido para el showcase
    showcase_content = "        // Flags icons - ALL 132 FLAGS\n        categories[\"Flags\"] = mutableListOf(\n"
    
    for i, flag_file in enumerate(sorted(flag_files)):
        # Extraer el nombre de la bandera del archivo
        flag_name = flag_file.stem.replace("ic_flags_", "")
        
        # Convertir a camelCase para el nombre de la variable en Icons.Flags
        if "_" in flag_name:
            parts = flag_name.split("_")
            camel_case = parts[0] + "".join(word.capitalize() for word in parts[1:])
        else:
            camel_case = flag_name
        
        # Generar la línea de IconToken
        showcase_content += f"            IconToken(\"{flag_file.stem}\", Icons.Flags.{camel_case}, \"{flag_file.stem}\", \"Flags\")"
        
        # Agregar coma si no es el último elemento
        if i < len(flag_files) - 1:
            showcase_content += ","
        
        showcase_content += "\n"
    
    showcase_content += "        )"
    
    print("\n📝 Contenido generado para el showcase:")
    print("=" * 80)
    print(showcase_content)
    print("=" * 80)
    
    # Guardar en un archivo temporal
    output_file = Path("scripts/generated_flags_showcase.txt")
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(showcase_content)
    
    print(f"\n💾 Showcase generado en: {output_file}")
    print(f"📊 Total de banderas: {len(flag_files)}")
    print(f"💡 Copia este contenido y reemplaza la sección Flags en GetIconsUseCase.kt")

if __name__ == "__main__":
    generate_all_flags_showcase()
