#!/usr/bin/env python3
"""
Script para convertir archivos SVG a Vector Drawables de Android
Basado en la estructura del proyecto React Native BCP Resources

Uso:
    python svg_to_vector_drawable.py --input-dir /path/to/svg --output-dir /path/to/drawable

Autor: BCP Design System Developer Team
"""

import os
import re
import argparse
import xml.etree.ElementTree as ET
from pathlib import Path
from typing import Dict, List, Optional


class SVGToVectorDrawableConverter:
    """Convierte archivos SVG a Vector Drawables de Android"""
    
    def __init__(self, input_dir: str, output_dir: str):
        self.input_dir = Path(input_dir)
        self.output_dir = Path(output_dir)
        
    def convert_svg_to_vector_drawable(self, svg_path: Path) -> Optional[str]:
        """Convierte un archivo SVG a Vector Drawable XML"""
        try:
            # Parsear el SVG
            tree = ET.parse(svg_path)
            root = tree.getroot()
            
            # Extraer dimensiones
            width = root.get('width', '24')
            height = root.get('height', '24')
            viewbox = root.get('viewBox', '0 0 24 24')
            
            # Extraer paths
            paths = []
            for path in root.findall('.//{http://www.w3.org/2000/svg}path'):
                path_data = path.get('d', '')
                if path_data:
                    paths.append(path_data)
            
            if not paths:
                print(f"⚠️  No se encontraron paths en {svg_path}")
                return None
            
            # Generar nombre del archivo basado en la estructura de directorios
            relative_path = svg_path.relative_to(self.input_dir)
            path_parts = relative_path.parts
            
            # Construir nombre del drawable
            if len(path_parts) >= 2:
                subcategory = path_parts[1]  # communication, navigation, etc.
                icon_name = svg_path.stem
                drawable_name = f"ic_{subcategory}_{icon_name}"
            else:
                category = svg_path.parent.name
                icon_name = svg_path.stem
                drawable_name = f"ic_{category}_{icon_name}"
            
            # Crear Vector Drawable XML
            vector_drawable = self._create_vector_drawable_xml(
                width, height, viewbox, paths, drawable_name
            )
            
            return vector_drawable
            
        except Exception as e:
            print(f"❌ Error procesando {svg_path}: {e}")
            return None
    
    def _create_vector_drawable_xml(self, width: str, height: str, viewbox: str, paths: List[str], name: str) -> str:
        """Crea el XML del Vector Drawable"""
        
        # Limpiar dimensiones
        width = width.replace('dp', '').replace('px', '')
        height = height.replace('dp', '').replace('px', '')
        
        # Extraer viewBox
        viewbox_parts = viewbox.split()
        if len(viewbox_parts) >= 4:
            viewbox_width = viewbox_parts[2]
            viewbox_height = viewbox_parts[3]
        else:
            viewbox_width = width
            viewbox_height = height
        
        # Crear XML
        xml_content = f'''<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="{width}dp"
    android:height="{height}dp"
    android:viewportWidth="{viewbox_width}"
    android:viewportHeight="{viewbox_height}">'''
        
        # Agregar paths
        for path_data in paths:
            xml_content += f'''
    <path
        android:fillColor="?attr/colorOnSurface"
        android:pathData="{path_data}" />'''
        
        xml_content += '''
</vector>'''
        
        return xml_content
    
    def process_directory(self):
        """Procesa todos los archivos SVG en el directorio de entrada"""
        
        if not self.input_dir.exists():
            print(f"❌ El directorio de entrada no existe: {self.input_dir}")
            return
        
        # Crear directorio de salida
        self.output_dir.mkdir(parents=True, exist_ok=True)
        
        # Contador de archivos procesados
        processed = 0
        errors = 0
        
        # Procesar archivos SVG recursivamente
        svg_files = list(self.input_dir.rglob("*.svg"))
        
        if not svg_files:
            print(f"❌ No se encontraron archivos SVG en {self.input_dir}")
            return
        
        print(f"📁 Encontrados {len(svg_files)} archivos SVG")
        
        # Procesar cada archivo SVG
        for svg_file in svg_files:
                print(f"  🔄 Procesando: {svg_file.name}")
                
                vector_drawable = self.convert_svg_to_vector_drawable(svg_file)
                
                if vector_drawable:
                    # Generar nombre del archivo de salida basado en la estructura de directorios
                    relative_path = svg_file.relative_to(self.input_dir)
                    path_parts = relative_path.parts
                    
                    # Construir nombre del drawable
                    if len(path_parts) >= 2:
                        subcategory = path_parts[1]  # communication, navigation, etc.
                        icon_name = svg_file.stem
                        drawable_name = f"ic_{subcategory}_{icon_name}"
                    else:
                        category = svg_file.parent.name
                        icon_name = svg_file.stem
                        drawable_name = f"ic_{category}_{icon_name}"
                    
                    output_file = self.output_dir / f"{drawable_name}.xml"
                    
                    # Escribir archivo
                    try:
                        with open(output_file, 'w', encoding='utf-8') as f:
                            f.write(vector_drawable)
                        print(f"  ✅ Creado: {output_file.name}")
                        processed += 1
                    except Exception as e:
                        print(f"  ❌ Error escribiendo {output_file}: {e}")
                        errors += 1
                else:
                    errors += 1
        
        print(f"\n📊 Resumen:")
        print(f"  ✅ Archivos procesados: {processed}")
        print(f"  ❌ Errores: {errors}")
        print(f"  📁 Directorio de salida: {self.output_dir}")


def main():
    parser = argparse.ArgumentParser(
        description="Convierte archivos SVG a Vector Drawables de Android"
    )
    parser.add_argument(
        "--input-dir",
        required=True,
        help="Directorio con archivos SVG organizados por categorías"
    )
    parser.add_argument(
        "--output-dir",
        required=True,
        help="Directorio de salida para los Vector Drawables"
    )
    
    args = parser.parse_args()
    
    converter = SVGToVectorDrawableConverter(args.input_dir, args.output_dir)
    converter.process_directory()


if __name__ == "__main__":
    main()
