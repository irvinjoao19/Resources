#!/usr/bin/env python3
"""
Script para renombrar todas las banderas que no tienen el prefijo ic_flags_
"""

import os
from pathlib import Path

def rename_all_flags():
    """Renombra todas las banderas para que tengan el prefijo ic_flags_"""
    
    drawable_dir = Path("/Users/irvin/DevAndroid/Personal/Resources/resources/src/main/res/drawable")
    
    print("🔄 Renombrando todas las banderas...")
    
    # Lista de archivos que ya tienen el prefijo ic_flags_
    already_renamed = [
        "ic_flags_argentina.xml", "ic_flags_bolivia.xml", "ic_flags_brazil.xml",
        "ic_flags_canada.xml", "ic_flags_chile.xml", "ic_flags_colombia.xml",
        "ic_flags_ecuador.xml", "ic_flags_france.xml", "ic_flags_germany.xml",
        "ic_flags_italy.xml", "ic_flags_mexico.xml", "ic_flags_paraguay.xml",
        "ic_flags_peru.xml", "ic_flags_russia.xml"
    ]
    
    # Lista de archivos que son banderas pero no tienen el prefijo
    flag_files_to_rename = [
        "venezuela.xml", "uruguay.xml", "united_kingdom.xml", "united_states.xml",
        "spain.xml", "albania.xml", "algeria.xml", "andorra.xml", "angola.xml",
        "antigua_and_barbuda.xml", "aruba.xml", "austria.xml", "bahamas.xml",
        "barbados.xml", "belarus.xml", "belgium.xml", "belize.xml", "benin.xml",
        "bosnia_and_herzegovina.xml", "botswana.xml", "bulgaria.xml", "burkina_faso.xml",
        "burundi.xml", "cameroon.xml", "cape_verde.xml", "cayman_islands.xml",
        "central_african_republic.xml", "chad.xml", "comoros.xml", "congo.xml",
        "costa_rica.xml", "croatia.xml", "cuba.xml", "curacao.xml", "cyprus.xml",
        "czechia.xml", "democratic_republic_of_the_congo.xml", "denmark.xml",
        "djibouti.xml", "dominica.xml", "dominican_republic.xml", "egypt.xml",
        "el_salvador.xml", "equatorial_guinea.xml", "eritrea.xml", "estonia.xml",
        "eswatini.xml", "ethiopia.xml", "european_union.xml", "falkland_islands.xml",
        "finland.xml", "french_guiana.xml", "gabon.xml", "gambia.xml", "ghana.xml",
        "gibraltar.xml", "greece.xml", "greenland.xml", "grenada.xml", "guatemala.xml",
        "guernsey.xml", "guinea_bissau.xml", "guinea.xml", "guyana.xml", "haiti.xml",
        "honduras.xml", "hungary.xml", "iceland.xml", "ireland.xml", "isle_of_man.xml",
        "ivory_coast.xml", "jamaica.xml", "jersey.xml", "kenya.xml", "kosovo.xml",
        "latvia.xml", "lesotho.xml", "liberia.xml", "libya.xml", "liechtenstein.xml",
        "lithuania.xml", "luxembourg.xml", "macedonia.xml", "madagascar.xml",
        "malawi.xml", "mali.xml", "malta.xml", "mauritania.xml", "mauritius.xml",
        "moldova.xml", "monaco.xml", "montenegro.xml", "morocco.xml", "mozambique.xml",
        "namibia.xml", "netherlands.xml", "nicaragua.xml", "niger.xml", "nigeria.xml",
        "norway.xml", "panama.xml", "poland.xml", "portugal.xml", "puerto_rico.xml",
        "romania.xml", "rwanda.xml", "sahrawi_arab_democratic_republic.xml",
        "saint_kitts_and_nevis.xml", "saint_lucia.xml", "saint_marten.xml",
        "san_marino.xml", "sao_tome_and_principe.xml", "sark.xml", "senegal.xml",
        "serbia.xml", "seychelles.xml", "sierra_leone.xml", "slovakia.xml",
        "slovenia.xml", "somalia.xml", "somaliland.xml", "south_africa.xml",
        "south_ossetia.xml", "south_sudan.xml", "st_vincent_and_the_grenadines.xml",
        "sudan.xml", "suriname.xml", "sweden.xml", "switzerland.xml", "tanzania.xml",
        "togo.xml", "transnistria.xml", "trinidad_and_tobago.xml", "tunisia.xml",
        "uganda.xml", "ukraine.xml", "us_virgin_islands.xml", "vatican_city.xml",
        "zambia.xml", "zimbabwe.xml"
    ]
    
    renamed_count = 0
    
    for flag_file in flag_files_to_rename:
        old_path = drawable_dir / flag_file
        new_path = drawable_dir / f"ic_flags_{flag_file}"
        
        if old_path.exists():
            try:
                old_path.rename(new_path)
                renamed_count += 1
                print(f"  ✅ Renombrado: {flag_file} -> ic_flags_{flag_file}")
            except Exception as e:
                print(f"  ❌ Error renombrando {flag_file}: {e}")
        else:
            print(f"  ⚠️ No encontrado: {flag_file}")
    
    print(f"\n🎉 Proceso completado!")
    print(f"📊 Archivos renombrados: {renamed_count}")
    print(f"📋 Total de banderas: {len(already_renamed) + renamed_count}")

if __name__ == "__main__":
    rename_all_flags()
