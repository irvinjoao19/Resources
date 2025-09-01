#!/usr/bin/env python3
"""
Script para generar automáticamente todas las referencias de banderas en Icons.kt
"""

import os
from pathlib import Path

def generate_flags_references():
    """Genera todas las referencias de banderas para Icons.kt"""
    
    drawable_dir = Path("resources/src/main/res/drawable")
    
    print("🔧 Generando referencias de banderas para Icons.kt...")
    
    # Buscar todos los archivos de banderas
    flag_files = list(drawable_dir.glob("ic_flags_*.xml"))
    
    if not flag_files:
        print("❌ No se encontraron archivos de banderas")
        return
    
    print(f"📁 Encontrados {len(flag_files)} archivos de banderas")
    
    # Generar el contenido de la sección Flags
    flags_content = "    object Flags {\n"
    
    for flag_file in sorted(flag_files):
        # Extraer el nombre de la bandera del archivo
        flag_name = flag_file.stem.replace("ic_flags_", "")
        
        # Convertir a camelCase para el nombre de la variable
        if "_" in flag_name:
            parts = flag_name.split("_")
            camel_case = parts[0] + "".join(word.capitalize() for word in parts[1:])
        else:
            camel_case = flag_name
        
        # Generar la línea de referencia
        flags_content += f"        @DrawableRes val {camel_case} = com.gongora.resources.R.drawable.{flag_file.stem}\n"
    
    flags_content += "    }"
    
    print("\n📝 Contenido generado para Icons.kt:")
    print("=" * 50)
    print(flags_content)
    print("=" * 50)
    
    # Guardar en un archivo temporal
    output_file = Path("scripts/generated_flags_references.txt")
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(flags_content)
    
    print(f"\n💾 Referencias guardadas en: {output_file}")
    print(f"📊 Total de banderas: {len(flag_files)}")
    print(f"💡 Copia este contenido y reemplaza la sección Flags en Icons.kt")

if __name__ == "__main__":
    generate_flags_references()
