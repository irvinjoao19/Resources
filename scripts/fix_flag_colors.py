#!/usr/bin/env python3
"""
Script para corregir los colores de las banderas en los Vector Drawables.
Reemplaza ?attr/colorOnSurface con colores específicos para que las banderas
mantengan sus colores originales.
"""

import os
import re
from pathlib import Path

def fix_flag_colors():
    """Corrige los colores de las banderas reemplazando ?attr/colorOnSurface con colores específicos."""
    
    # Ruta a los archivos de banderas
    flags_dir = Path("resources/src/main/res/drawable")
    
    # Contador de archivos procesados
    processed_count = 0
    fixed_count = 0
    
    print("🔧 Corrigiendo colores de banderas...")
    
    # Buscar todos los archivos de banderas
    flag_files = list(flags_dir.glob("ic_flags_*.xml"))
    
    if not flag_files:
        print("❌ No se encontraron archivos de banderas")
        return
    
    print(f"📁 Encontrados {len(flag_files)} archivos de banderas")
    
    for flag_file in flag_files:
        processed_count += 1
        print(f"📄 Procesando: {flag_file.name}")
        
        try:
            # Leer el contenido del archivo
            with open(flag_file, 'r', encoding='utf-8') as f:
                content = f.read()
            
            # Verificar si el archivo usa ?attr/colorOnSurface
            if '?attr/colorOnSurface' in content:
                # Reemplazar ?attr/colorOnSurface con colores específicos
                # Para banderas, usamos colores que permitan que se vean los colores originales
                fixed_content = content.replace(
                    'android:fillColor="?attr/colorOnSurface"',
                    'android:fillColor="#FFFFFF"'
                )
                
                # Escribir el contenido corregido
                with open(flag_file, 'w', encoding='utf-8') as f:
                    f.write(fixed_content)
                
                fixed_count += 1
                print(f"  ✅ Corregido: {flag_file.name}")
            else:
                print(f"  ⏭️  Ya está bien: {flag_file.name}")
                
        except Exception as e:
            print(f"  ❌ Error procesando {flag_file.name}: {e}")
    
    print(f"\n🎉 Proceso completado!")
    print(f"📊 Archivos procesados: {processed_count}")
    print(f"🔧 Archivos corregidos: {fixed_count}")
    
    if fixed_count > 0:
        print(f"\n💡 Las banderas ahora deberían mostrar sus colores originales.")
        print(f"   Si aún aparecen negras, puede ser necesario usar 'android:fillColor=\"#00000000\"' (transparente)")

if __name__ == "__main__":
    fix_flag_colors()
