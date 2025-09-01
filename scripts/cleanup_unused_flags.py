#!/usr/bin/env python3
"""
Script para limpiar banderas no utilizadas en el showcase.
Mantiene solo las 19 banderas principales que están en GetIconsUseCase.kt
"""

import os
from pathlib import Path

# Lista de banderas que SÍ están en uso en el showcase
USED_FLAGS = {
    "peru", "mexico", "colombia", "argentina", "chile", "brazil", 
    "ecuador", "bolivia", "venezuela", "uruguay", "paraguay",
    "france", "germany", "italy", "spain", "united_kingdom", 
    "united_states", "canada", "russia"
}

def cleanup_unused_flags():
    """Elimina las banderas que no están siendo utilizadas."""
    
    drawable_dir = Path("resources/src/main/res/drawable")
    
    print("🧹 Limpiando banderas no utilizadas...")
    
    # Buscar todos los archivos de banderas
    flag_files = list(drawable_dir.glob("ic_flags_*.xml"))
    
    if not flag_files:
        print("❌ No se encontraron archivos de banderas")
        return
    
    print(f"📁 Encontrados {len(flag_files)} archivos de banderas")
    
    removed_count = 0
    kept_count = 0
    
    for flag_file in flag_files:
        # Extraer el nombre de la bandera del archivo
        flag_name = flag_file.stem.replace("ic_flags_", "")
        
        if flag_name in USED_FLAGS:
            kept_count += 1
            print(f"  ✅ Mantenido: {flag_file.name}")
        else:
            try:
                flag_file.unlink()
                removed_count += 1
                print(f"  🗑️ Eliminado: {flag_file.name}")
            except Exception as e:
                print(f"  ❌ Error eliminando {flag_file.name}: {e}")
    
    print(f"\n🎉 Limpieza completada!")
    print(f"📊 Archivos mantenidos: {kept_count}")
    print(f"🗑️ Archivos eliminados: {removed_count}")
    print(f"📋 Banderas en uso: {', '.join(sorted(USED_FLAGS))}")

if __name__ == "__main__":
    cleanup_unused_flags()
