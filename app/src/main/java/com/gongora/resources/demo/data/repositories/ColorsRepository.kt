package com.gongora.resources.demo.data.repositories

import com.gongora.resources.demo.domain.models.ColorCategory
import com.gongora.resources.demo.domain.models.ColorToken
import com.gongora.resources.tokens.Colors

/**
 * Repository interface for color tokens.
 * 
 * This interface defines the contract for accessing color tokens from the resources library,
 * following Clean Architecture principles by abstracting the data source.
 */
interface ColorsRepository {
    
    /**
     * Retrieves all color tokens organized by categories.
     * @return Map of color categories to their respective tokens
     */
    suspend fun getColorTokens(): Map<ColorCategory, List<ColorToken>>
}

/**
 * Implementation of ColorsRepository that accesses the resources library directly.
 * 
 * This implementation provides access to color tokens from the BCP resources library,
 * organizing them by categories for the demo application.
 */
class ColorsRepositoryImpl : ColorsRepository {
    
    override suspend fun getColorTokens(): Map<ColorCategory, List<ColorToken>> {
        return buildMap {
            put(ColorCategory.BRAND, createBrandColors())
            put(ColorCategory.NEUTRAL, createNeutralColors())
            put(ColorCategory.FUNCTIONAL, createFunctionalColors())
            put(ColorCategory.DECORATIVE, createDecorativeColors())
        }
    }
    
    /**
     * Creates brand color tokens (BCP Blue and Orange)
     */
    private fun createBrandColors(): List<ColorToken> = listOf(
        // BCP Blue
        ColorToken("brand.bcp_blue.050", Colors.Brand.BcpBlue.blue050, "BCP Blue 050", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.100", Colors.Brand.BcpBlue.blue100, "BCP Blue 100", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.200", Colors.Brand.BcpBlue.blue200, "BCP Blue 200", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.300", Colors.Brand.BcpBlue.blue300, "BCP Blue 300", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.400", Colors.Brand.BcpBlue.blue400, "BCP Blue 400", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.500", Colors.Brand.BcpBlue.blue500, "BCP Blue 500", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.600", Colors.Brand.BcpBlue.blue600, "BCP Blue 600", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.700", Colors.Brand.BcpBlue.blue700, "BCP Blue 700", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.800", Colors.Brand.BcpBlue.blue800, "BCP Blue 800", ColorCategory.BRAND),
        ColorToken("brand.bcp_blue.900", Colors.Brand.BcpBlue.blue900, "BCP Blue 900", ColorCategory.BRAND),
        
        // BCP Orange
        ColorToken("brand.bcp_orange.050", Colors.Brand.BcpOrange.orange050, "BCP Orange 050", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.100", Colors.Brand.BcpOrange.orange100, "BCP Orange 100", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.200", Colors.Brand.BcpOrange.orange200, "BCP Orange 200", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.300", Colors.Brand.BcpOrange.orange300, "BCP Orange 300", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.400", Colors.Brand.BcpOrange.orange400, "BCP Orange 400", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.500", Colors.Brand.BcpOrange.orange500, "BCP Orange 500", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.600", Colors.Brand.BcpOrange.orange600, "BCP Orange 600", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.700", Colors.Brand.BcpOrange.orange700, "BCP Orange 700", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.800", Colors.Brand.BcpOrange.orange800, "BCP Orange 800", ColorCategory.BRAND),
        ColorToken("brand.bcp_orange.900", Colors.Brand.BcpOrange.orange900, "BCP Orange 900", ColorCategory.BRAND)
    )
    
    /**
     * Creates neutral color tokens (Gray, White, Black)
     */
    private fun createNeutralColors(): List<ColorToken> = listOf(
        // Gray
        ColorToken("neutral.gray.050", Colors.Neutral.Gray.gray050, "Gray 050", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.100", Colors.Neutral.Gray.gray100, "Gray 100", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.200", Colors.Neutral.Gray.gray200, "Gray 200", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.300", Colors.Neutral.Gray.gray300, "Gray 300", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.400", Colors.Neutral.Gray.gray400, "Gray 400", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.500", Colors.Neutral.Gray.gray500, "Gray 500", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.600", Colors.Neutral.Gray.gray600, "Gray 600", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.700", Colors.Neutral.Gray.gray700, "Gray 700", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.800", Colors.Neutral.Gray.gray800, "Gray 800", ColorCategory.NEUTRAL),
        ColorToken("neutral.gray.900", Colors.Neutral.Gray.gray900, "Gray 900", ColorCategory.NEUTRAL),
        
        // White
        ColorToken("neutral.white.100", Colors.Neutral.white, "White 100", ColorCategory.NEUTRAL),
        
        // Black
        ColorToken("neutral.black.100", Colors.Neutral.black, "Black 100", ColorCategory.NEUTRAL)
    )
    
    /**
     * Creates functional color tokens (Green, Red, Yellow, Sky)
     */
    private fun createFunctionalColors(): List<ColorToken> = listOf(
        // Green
        ColorToken("functional.green.050", Colors.Functional.Green.green050, "Green 050", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.100", Colors.Functional.Green.green100, "Green 100", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.200", Colors.Functional.Green.green200, "Green 200", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.300", Colors.Functional.Green.green300, "Green 300", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.400", Colors.Functional.Green.green400, "Green 400", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.500", Colors.Functional.Green.green500, "Green 500", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.600", Colors.Functional.Green.green600, "Green 600", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.700", Colors.Functional.Green.green700, "Green 700", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.800", Colors.Functional.Green.green800, "Green 800", ColorCategory.FUNCTIONAL),
        ColorToken("functional.green.900", Colors.Functional.Green.green900, "Green 900", ColorCategory.FUNCTIONAL),
        
        // Red
        ColorToken("functional.red.050", Colors.Functional.Red.red050, "Red 050", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.100", Colors.Functional.Red.red100, "Red 100", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.200", Colors.Functional.Red.red200, "Red 200", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.300", Colors.Functional.Red.red300, "Red 300", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.400", Colors.Functional.Red.red400, "Red 400", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.500", Colors.Functional.Red.red500, "Red 500", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.600", Colors.Functional.Red.red600, "Red 600", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.700", Colors.Functional.Red.red700, "Red 700", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.800", Colors.Functional.Red.red800, "Red 800", ColorCategory.FUNCTIONAL),
        ColorToken("functional.red.900", Colors.Functional.Red.red900, "Red 900", ColorCategory.FUNCTIONAL),
        
        // Yellow
        ColorToken("functional.yellow.050", Colors.Functional.Yellow.yellow050, "Yellow 050", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.100", Colors.Functional.Yellow.yellow100, "Yellow 100", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.200", Colors.Functional.Yellow.yellow200, "Yellow 200", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.300", Colors.Functional.Yellow.yellow300, "Yellow 300", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.400", Colors.Functional.Yellow.yellow400, "Yellow 400", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.500", Colors.Functional.Yellow.yellow500, "Yellow 500", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.600", Colors.Functional.Yellow.yellow600, "Yellow 600", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.700", Colors.Functional.Yellow.yellow700, "Yellow 700", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.800", Colors.Functional.Yellow.yellow800, "Yellow 800", ColorCategory.FUNCTIONAL),
        ColorToken("functional.yellow.900", Colors.Functional.Yellow.yellow900, "Yellow 900", ColorCategory.FUNCTIONAL),
        
        // Sky
        ColorToken("functional.sky.050", Colors.Functional.Sky.sky050, "Sky 050", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.100", Colors.Functional.Sky.sky100, "Sky 100", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.200", Colors.Functional.Sky.sky200, "Sky 200", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.300", Colors.Functional.Sky.sky300, "Sky 300", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.400", Colors.Functional.Sky.sky400, "Sky 400", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.500", Colors.Functional.Sky.sky500, "Sky 500", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.600", Colors.Functional.Sky.sky600, "Sky 600", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.700", Colors.Functional.Sky.sky700, "Sky 700", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.800", Colors.Functional.Sky.sky800, "Sky 800", ColorCategory.FUNCTIONAL),
        ColorToken("functional.sky.900", Colors.Functional.Sky.sky900, "Sky 900", ColorCategory.FUNCTIONAL)
    )
    
    /**
     * Creates decorative color tokens (Teal, Violet, Pink, Cyan, Lime)
     */
    private fun createDecorativeColors(): List<ColorToken> = listOf(
        // Teal
        ColorToken("decorative.teal.050", Colors.Decorative.Teal.teal050, "Teal 050", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.100", Colors.Decorative.Teal.teal100, "Teal 100", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.200", Colors.Decorative.Teal.teal200, "Teal 200", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.300", Colors.Decorative.Teal.teal300, "Teal 300", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.400", Colors.Decorative.Teal.teal400, "Teal 400", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.500", Colors.Decorative.Teal.teal500, "Teal 500", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.600", Colors.Decorative.Teal.teal600, "Teal 600", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.700", Colors.Decorative.Teal.teal700, "Teal 700", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.800", Colors.Decorative.Teal.teal800, "Teal 800", ColorCategory.DECORATIVE),
        ColorToken("decorative.teal.900", Colors.Decorative.Teal.teal900, "Teal 900", ColorCategory.DECORATIVE),
        
        // Violet
        ColorToken("decorative.violet.050", Colors.Decorative.Violet.violet050, "Violet 050", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.100", Colors.Decorative.Violet.violet100, "Violet 100", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.200", Colors.Decorative.Violet.violet200, "Violet 200", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.300", Colors.Decorative.Violet.violet300, "Violet 300", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.400", Colors.Decorative.Violet.violet400, "Violet 400", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.500", Colors.Decorative.Violet.violet500, "Violet 500", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.600", Colors.Decorative.Violet.violet600, "Violet 600", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.700", Colors.Decorative.Violet.violet700, "Violet 700", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.800", Colors.Decorative.Violet.violet800, "Violet 800", ColorCategory.DECORATIVE),
        ColorToken("decorative.violet.900", Colors.Decorative.Violet.violet900, "Violet 900", ColorCategory.DECORATIVE),
        
        // Pink
        ColorToken("decorative.pink.050", Colors.Decorative.Pink.pink050, "Pink 050", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.100", Colors.Decorative.Pink.pink100, "Pink 100", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.200", Colors.Decorative.Pink.pink200, "Pink 200", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.300", Colors.Decorative.Pink.pink300, "Pink 300", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.400", Colors.Decorative.Pink.pink400, "Pink 400", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.500", Colors.Decorative.Pink.pink500, "Pink 500", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.600", Colors.Decorative.Pink.pink600, "Pink 600", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.700", Colors.Decorative.Pink.pink700, "Pink 700", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.800", Colors.Decorative.Pink.pink800, "Pink 800", ColorCategory.DECORATIVE),
        ColorToken("decorative.pink.900", Colors.Decorative.Pink.pink900, "Pink 900", ColorCategory.DECORATIVE),
        
        // Cyan
        ColorToken("decorative.cyan.050", Colors.Decorative.Cyan.cyan050, "Cyan 050", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.100", Colors.Decorative.Cyan.cyan100, "Cyan 100", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.200", Colors.Decorative.Cyan.cyan200, "Cyan 200", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.300", Colors.Decorative.Cyan.cyan300, "Cyan 300", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.400", Colors.Decorative.Cyan.cyan400, "Cyan 400", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.500", Colors.Decorative.Cyan.cyan500, "Cyan 500", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.600", Colors.Decorative.Cyan.cyan600, "Cyan 600", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.700", Colors.Decorative.Cyan.cyan700, "Cyan 700", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.800", Colors.Decorative.Cyan.cyan800, "Cyan 800", ColorCategory.DECORATIVE),
        ColorToken("decorative.cyan.900", Colors.Decorative.Cyan.cyan900, "Cyan 900", ColorCategory.DECORATIVE),
        
        // Lime
        ColorToken("decorative.lime.050", Colors.Decorative.Lime.lime050, "Lime 050", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.100", Colors.Decorative.Lime.lime100, "Lime 100", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.200", Colors.Decorative.Lime.lime200, "Lime 200", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.300", Colors.Decorative.Lime.lime300, "Lime 300", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.400", Colors.Decorative.Lime.lime400, "Lime 400", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.500", Colors.Decorative.Lime.lime500, "Lime 500", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.600", Colors.Decorative.Lime.lime600, "Lime 600", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.700", Colors.Decorative.Lime.lime700, "Lime 700", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.800", Colors.Decorative.Lime.lime800, "Lime 800", ColorCategory.DECORATIVE),
        ColorToken("decorative.lime.900", Colors.Decorative.Lime.lime900, "Lime 900", ColorCategory.DECORATIVE)
    )
}
