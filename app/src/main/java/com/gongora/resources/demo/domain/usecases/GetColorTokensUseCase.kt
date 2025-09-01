package com.gongora.resources.demo.domain.usecases

import com.gongora.resources.demo.domain.models.ColorCategory
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.tokens.Colors

/**
 * Use case for retrieving and organizing color tokens by categories.
 */
class GetColorTokensUseCase {
    
    /**
     * Executes the use case and returns color tokens organized by categories.
     * @return Map of color categories to their respective tokens
     */
    operator fun invoke(): Map<ColorCategory, List<ColorToken>> {
        val categories = mutableMapOf<ColorCategory, MutableList<ColorToken>>()
        
        // Initialize categories
        ColorCategory.entries.forEach { category ->
            categories[category] = mutableListOf()
        }
        
        // Add brand colors from the resources library
        categories[ColorCategory.BRAND]?.addAll(listOf(
            ColorToken("brand.bcp_blue_050", Colors.Brand.BcpBlue.blue050, "BCP Blue 050", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_100", Colors.Brand.BcpBlue.blue100, "BCP Blue 100", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_200", Colors.Brand.BcpBlue.blue200, "BCP Blue 200", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_300", Colors.Brand.BcpBlue.blue300, "BCP Blue 300", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_400", Colors.Brand.BcpBlue.blue400, "BCP Blue 400", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_500", Colors.Brand.BcpBlue.blue500, "BCP Blue 500", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_600", Colors.Brand.BcpBlue.blue600, "BCP Blue 600", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_700", Colors.Brand.BcpBlue.blue700, "BCP Blue 700", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_800", Colors.Brand.BcpBlue.blue800, "BCP Blue 800", ColorCategory.BRAND),
            ColorToken("brand.bcp_blue_900", Colors.Brand.BcpBlue.blue900, "BCP Blue 900", ColorCategory.BRAND)
        ))
        
        categories[ColorCategory.BRAND]?.addAll(listOf(
            ColorToken("brand.bcp_orange_050", Colors.Brand.BcpOrange.orange050, "BCP Orange 050", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_100", Colors.Brand.BcpOrange.orange100, "BCP Orange 100", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_200", Colors.Brand.BcpOrange.orange200, "BCP Orange 200", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_300", Colors.Brand.BcpOrange.orange300, "BCP Orange 300", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_400", Colors.Brand.BcpOrange.orange400, "BCP Orange 400", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_500", Colors.Brand.BcpOrange.orange500, "BCP Orange 500", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_600", Colors.Brand.BcpOrange.orange600, "BCP Orange 600", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_700", Colors.Brand.BcpOrange.orange700, "BCP Orange 700", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_800", Colors.Brand.BcpOrange.orange800, "BCP Orange 800", ColorCategory.BRAND),
            ColorToken("brand.bcp_orange_900", Colors.Brand.BcpOrange.orange900, "BCP Orange 900", ColorCategory.BRAND)
        ))
        
        // Add neutral colors from the resources library
        categories[ColorCategory.NEUTRAL]?.addAll(listOf(
            ColorToken("neutral.gray_050", Colors.Neutral.Gray.gray050, "Gray 050", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_100", Colors.Neutral.Gray.gray100, "Gray 100", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_200", Colors.Neutral.Gray.gray200, "Gray 200", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_300", Colors.Neutral.Gray.gray300, "Gray 300", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_400", Colors.Neutral.Gray.gray400, "Gray 400", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_500", Colors.Neutral.Gray.gray500, "Gray 500", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_600", Colors.Neutral.Gray.gray600, "Gray 600", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_700", Colors.Neutral.Gray.gray700, "Gray 700", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_800", Colors.Neutral.Gray.gray800, "Gray 800", ColorCategory.NEUTRAL),
            ColorToken("neutral.gray_900", Colors.Neutral.Gray.gray900, "Gray 900", ColorCategory.NEUTRAL),
            ColorToken("neutral.white_100", Colors.Neutral.white, "White 100", ColorCategory.NEUTRAL),
            ColorToken("neutral.black_100", Colors.Neutral.black, "Black 100", ColorCategory.NEUTRAL)
        ))
        
        // Add functional colors from the resources library
        categories[ColorCategory.FUNCTIONAL]?.addAll(listOf(
            ColorToken("functional.green_050", Colors.Functional.Green.green050, "Green 050", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_100", Colors.Functional.Green.green100, "Green 100", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_200", Colors.Functional.Green.green200, "Green 200", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_300", Colors.Functional.Green.green300, "Green 300", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_400", Colors.Functional.Green.green400, "Green 400", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_500", Colors.Functional.Green.green500, "Green 500", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_600", Colors.Functional.Green.green600, "Green 600", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_700", Colors.Functional.Green.green700, "Green 700", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_800", Colors.Functional.Green.green800, "Green 800", ColorCategory.FUNCTIONAL),
            ColorToken("functional.green_900", Colors.Functional.Green.green900, "Green 900", ColorCategory.FUNCTIONAL)
        ))
        
        categories[ColorCategory.FUNCTIONAL]?.addAll(listOf(
            ColorToken("functional.red_050", Colors.Functional.Red.red050, "Red 050", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_100", Colors.Functional.Red.red100, "Red 100", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_200", Colors.Functional.Red.red200, "Red 200", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_300", Colors.Functional.Red.red300, "Red 300", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_400", Colors.Functional.Red.red400, "Red 400", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_500", Colors.Functional.Red.red500, "Red 500", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_600", Colors.Functional.Red.red600, "Red 600", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_700", Colors.Functional.Red.red700, "Red 700", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_800", Colors.Functional.Red.red800, "Red 800", ColorCategory.FUNCTIONAL),
            ColorToken("functional.red_900", Colors.Functional.Red.red900, "Red 900", ColorCategory.FUNCTIONAL)
        ))
        
        categories[ColorCategory.FUNCTIONAL]?.addAll(listOf(
            ColorToken("functional.yellow_050", Colors.Functional.Yellow.yellow050, "Yellow 050", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_100", Colors.Functional.Yellow.yellow100, "Yellow 100", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_200", Colors.Functional.Yellow.yellow200, "Yellow 200", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_300", Colors.Functional.Yellow.yellow300, "Yellow 300", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_400", Colors.Functional.Yellow.yellow400, "Yellow 400", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_500", Colors.Functional.Yellow.yellow500, "Yellow 500", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_600", Colors.Functional.Yellow.yellow600, "Yellow 600", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_700", Colors.Functional.Yellow.yellow700, "Yellow 700", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_800", Colors.Functional.Yellow.yellow800, "Yellow 800", ColorCategory.FUNCTIONAL),
            ColorToken("functional.yellow_900", Colors.Functional.Yellow.yellow900, "Yellow 900", ColorCategory.FUNCTIONAL)
        ))
        
        categories[ColorCategory.FUNCTIONAL]?.addAll(listOf(
            ColorToken("functional.sky_050", Colors.Functional.Sky.sky050, "Sky 050", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_100", Colors.Functional.Sky.sky100, "Sky 100", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_200", Colors.Functional.Sky.sky200, "Sky 200", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_300", Colors.Functional.Sky.sky300, "Sky 300", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_400", Colors.Functional.Sky.sky400, "Sky 400", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_500", Colors.Functional.Sky.sky500, "Sky 500", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_600", Colors.Functional.Sky.sky600, "Sky 600", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_700", Colors.Functional.Sky.sky700, "Sky 700", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_800", Colors.Functional.Sky.sky800, "Sky 800", ColorCategory.FUNCTIONAL),
            ColorToken("functional.sky_900", Colors.Functional.Sky.sky900, "Sky 900", ColorCategory.FUNCTIONAL)
        ))
        
        // Add decorative colors from the resources library
        categories[ColorCategory.DECORATIVE]?.addAll(listOf(
            ColorToken("decorative.teal_050", Colors.Decorative.Teal.teal050, "Teal 050", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_100", Colors.Decorative.Teal.teal100, "Teal 100", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_200", Colors.Decorative.Teal.teal200, "Teal 200", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_300", Colors.Decorative.Teal.teal300, "Teal 300", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_400", Colors.Decorative.Teal.teal400, "Teal 400", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_500", Colors.Decorative.Teal.teal500, "Teal 500", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_600", Colors.Decorative.Teal.teal600, "Teal 600", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_700", Colors.Decorative.Teal.teal700, "Teal 700", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_800", Colors.Decorative.Teal.teal800, "Teal 800", ColorCategory.DECORATIVE),
            ColorToken("decorative.teal_900", Colors.Decorative.Teal.teal900, "Teal 900", ColorCategory.DECORATIVE)
        ))
        
        categories[ColorCategory.DECORATIVE]?.addAll(listOf(
            ColorToken("decorative.violet_050", Colors.Decorative.Violet.violet050, "Violet 050", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_100", Colors.Decorative.Violet.violet100, "Violet 100", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_200", Colors.Decorative.Violet.violet200, "Violet 200", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_300", Colors.Decorative.Violet.violet300, "Violet 300", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_400", Colors.Decorative.Violet.violet400, "Violet 400", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_500", Colors.Decorative.Violet.violet500, "Violet 500", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_600", Colors.Decorative.Violet.violet600, "Violet 600", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_700", Colors.Decorative.Violet.violet700, "Violet 700", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_800", Colors.Decorative.Violet.violet800, "Violet 800", ColorCategory.DECORATIVE),
            ColorToken("decorative.violet_900", Colors.Decorative.Violet.violet900, "Violet 900", ColorCategory.DECORATIVE)
        ))
        
        categories[ColorCategory.DECORATIVE]?.addAll(listOf(
            ColorToken("decorative.pink_050", Colors.Decorative.Pink.pink050, "Pink 050", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_100", Colors.Decorative.Pink.pink100, "Pink 100", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_200", Colors.Decorative.Pink.pink200, "Pink 200", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_300", Colors.Decorative.Pink.pink300, "Pink 300", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_400", Colors.Decorative.Pink.pink400, "Pink 400", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_500", Colors.Decorative.Pink.pink500, "Pink 500", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_600", Colors.Decorative.Pink.pink600, "Pink 600", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_700", Colors.Decorative.Pink.pink700, "Pink 700", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_800", Colors.Decorative.Pink.pink800, "Pink 800", ColorCategory.DECORATIVE),
            ColorToken("decorative.pink_900", Colors.Decorative.Pink.pink900, "Pink 900", ColorCategory.DECORATIVE)
        ))
        
        categories[ColorCategory.DECORATIVE]?.addAll(listOf(
            ColorToken("decorative.cyan_050", Colors.Decorative.Cyan.cyan050, "Cyan 050", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_100", Colors.Decorative.Cyan.cyan100, "Cyan 100", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_200", Colors.Decorative.Cyan.cyan200, "Cyan 200", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_300", Colors.Decorative.Cyan.cyan300, "Cyan 300", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_400", Colors.Decorative.Cyan.cyan400, "Cyan 400", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_500", Colors.Decorative.Cyan.cyan500, "Cyan 500", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_600", Colors.Decorative.Cyan.cyan600, "Cyan 600", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_700", Colors.Decorative.Cyan.cyan700, "Cyan 700", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_800", Colors.Decorative.Cyan.cyan800, "Cyan 800", ColorCategory.DECORATIVE),
            ColorToken("decorative.cyan_900", Colors.Decorative.Cyan.cyan900, "Cyan 900", ColorCategory.DECORATIVE)
        ))
        
        categories[ColorCategory.DECORATIVE]?.addAll(listOf(
            ColorToken("decorative.lime_050", Colors.Decorative.Lime.lime050, "Lime 050", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_100", Colors.Decorative.Lime.lime100, "Lime 100", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_200", Colors.Decorative.Lime.lime200, "Lime 200", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_300", Colors.Decorative.Lime.lime300, "Lime 300", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_400", Colors.Decorative.Lime.lime400, "Lime 400", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_500", Colors.Decorative.Lime.lime500, "Lime 500", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_600", Colors.Decorative.Lime.lime600, "Lime 600", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_700", Colors.Decorative.Lime.lime700, "Lime 700", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_800", Colors.Decorative.Lime.lime800, "Lime 800", ColorCategory.DECORATIVE),
            ColorToken("decorative.lime_900", Colors.Decorative.Lime.lime900, "Lime 900", ColorCategory.DECORATIVE)
        ))
        
        // Debug: verificar que todas las categorías tienen colores
        println("DEBUG UseCase: Final result:")
        categories.forEach { (category, colors) ->
            println("DEBUG UseCase: ${category.name} -> ${colors.size} colors")
        }
        
        return categories
    }
    
    private fun String.capitalize(): String {
        return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}
