package com.gongora.resources.demo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.gongora.resources.demo.domain.models.SpacingToken
import com.gongora.resources.demo.domain.usecases.GetSpacingTokensUseCase

/**
 * ViewModel for the spacing screen.
 * This ViewModel follows Clean Architecture principles by delegating business logic to use cases.
 */
class SpacingViewModel : ViewModel() {
    private val getSpacingTokensUseCase = GetSpacingTokensUseCase()
    
    /**
     * Spacing tokens in the same format as React Native.
     */
    val spacingTokens: List<SpacingToken> = getSpacingTokensUseCase().also { tokens ->
        // Debug: verificar que se obtuvieron todos los tokens
        println("DEBUG ViewModel: Total tokens: ${tokens.size}")
        tokens.forEach { token ->
            println("DEBUG ViewModel: ${token.key} = ${token.value}dp")
        }
    }
}
