package com.gongora.resources.demo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gongora.resources.demo.presentation.screens.BorderScreen
import com.gongora.resources.demo.presentation.screens.ColorsScreen
import com.gongora.resources.demo.presentation.screens.EffectsScreen
import com.gongora.resources.demo.presentation.screens.HomeScreen
import com.gongora.resources.demo.presentation.screens.IconsScreen
import com.gongora.resources.demo.presentation.screens.SpacingScreen
import com.gongora.resources.demo.presentation.screens.TypographyScreen

/**
 * Navigation routes for the demo application.
 */
object DemoRoutes {
    const val HOME = "home"
    const val COLORS = "colors"
    const val TYPOGRAPHY = "typography"
    const val BORDER = "border"
    const val SPACING = "spacing"
    const val EFFECTS = "effects"
    const val ICONS = "icons"
}

/**
 * Navigation graph for the demo application.
 * @param navController Navigation controller for handling navigation
 */
@Composable
fun DemoNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DemoRoutes.HOME
    ) {
        composable(DemoRoutes.HOME) {
            HomeScreen(
                onNavigateToColors = { navController.navigate(DemoRoutes.COLORS) },
                onNavigateToTypography = { navController.navigate(DemoRoutes.TYPOGRAPHY) },
                onNavigateToBorder = { navController.navigate(DemoRoutes.BORDER) },
                onNavigateToSpacing = { navController.navigate(DemoRoutes.SPACING) },
                onNavigateToEffects = { navController.navigate(DemoRoutes.EFFECTS) },
                onNavigateToIcons = { navController.navigate(DemoRoutes.ICONS) }
            )
        }
        
        composable(DemoRoutes.COLORS) {
            ColorsScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(DemoRoutes.TYPOGRAPHY) {
            TypographyScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(DemoRoutes.BORDER) {
            BorderScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(DemoRoutes.SPACING) {
            SpacingScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(DemoRoutes.EFFECTS) {
            EffectsScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(DemoRoutes.ICONS) {
            IconsScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
