package com.gongora.resources.demo.domain.models

/**
 * Domain model representing a menu item in the demo application.
 * This follows Clean Architecture principles by being independent of UI frameworks.
 */
data class DemoMenuItem(
    val id: String,
    val title: String,
    val description: String,
    val route: String,
    val icon: String
)
