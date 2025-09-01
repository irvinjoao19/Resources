#!/usr/bin/env python3
"""
Script para corregir los colores de las banderas usando colores transparentes.
Esto permite que las banderas mantengan sus colores originales del SVG.
"""

import os
import re
from pathlib import Path

def fix_flag_colors_transparent():
    """Corrige los colores de las banderas usando colores transparentes."""
    
    # Ruta a los archivos de banderas
    flags_dir = Path("resources/src/main/res/drawable")
    
    # Contador de archivos procesados
    processed_count = 0
    fixed_count = 0
    
    print("🔧 Corrigiendo colores de banderas con transparencia...")
    
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
            
            # Verificar si el archivo usa ?attr/colorOnSurface o #FFFFFF
            if '?attr/colorOnSurface' in content or 'android:fillColor="#FFFFFF"' in content:
                # Reemplazar con color transparente para que se vean los colores originales
                fixed_content = content.replace(
                    'android:fillColor="?attr/colorOnSurface"',
                    'android:fillColor="#00000000"'
                ).replace(
                    'android:fillColor="#FFFFFF"',
                    'android:fillColor="#00000000"'
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
        print(f"\n💡 Las banderas ahora deberían mostrar sus colores originales del SVG.")
        print(f"   Se usó 'android:fillColor=\"#00000000\"' (transparente)")

if __name__ == "__main__":
    fix_flag_colors_transparent()
