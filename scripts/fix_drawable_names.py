#!/usr/bin/env python3
"""
Script para renombrar archivos Vector Drawables
Reemplaza guiones (-) por guiones bajos (_) en los nombres de archivos

Uso:
    python3 fix_drawable_names.py --drawable-dir resources/src/main/res/drawable

Autor: BCP Design System Developer Team
"""

import os
import argparse
from pathlib import Path


def fix_drawable_names(drawable_dir: str):
    """Renombra archivos Vector Drawables para usar guiones bajos"""
    
    drawable_path = Path(drawable_dir)
    if not drawable_path.exists():
        print(f"❌ El directorio de drawable no existe: {drawable_path}")
        return
    
    # Encontrar todos los archivos Vector Drawables
    drawable_files = list(drawable_path.glob("ic_*.xml"))
    
    if not drawable_files:
        print(f"❌ No se encontraron archivos Vector Drawables en {drawable_path}")
        return
    
    print(f"📁 Encontrados {len(drawable_files)} archivos Vector Drawables")
    
    renamed_count = 0
    
    for file_path in drawable_files:
        old_name = file_path.name
        
        # Reemplazar guiones por guiones bajos
        if "-" in old_name:
            new_name = old_name.replace("-", "_")
            new_path = file_path.parent / new_name
            
            try:
                file_path.rename(new_path)
                print(f"  ✅ Renombrado: {old_name} → {new_name}")
                renamed_count += 1
            except Exception as e:
                print(f"  ❌ Error renombrando {old_name}: {e}")
    
    print(f"\n📊 Resumen:")
    print(f"  ✅ Archivos renombrados: {renamed_count}")
    print(f"  📁 Directorio: {drawable_path}")


def main():
    parser = argparse.ArgumentParser(
        description="Renombra archivos Vector Drawables para usar guiones bajos"
    )
    parser.add_argument(
        "--drawable-dir",
        default="resources/src/main/res/drawable",
        help="Directorio con archivos Vector Drawables"
    )
    
    args = parser.parse_args()
    
    fix_drawable_names(args.drawable_dir)


if __name__ == "__main__":
    main()
