package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.domain.models.DemoMenuItem
import com.gongora.resources.demo.domain.usecases.GetDemoMenuItemsUseCase

/**
 * ViewModel for the home screen.
 * This ViewModel follows Clean Architecture principles by delegating business logic to use cases.
 */
class HomeViewModel : ViewModel() {
    private val getDemoMenuItemsUseCase = GetDemoMenuItemsUseCase()
    
    /**
     * Menu items for the demo application.
     */
    val menuItems: List<DemoMenuItem> = getDemoMenuItemsUseCase()
}
