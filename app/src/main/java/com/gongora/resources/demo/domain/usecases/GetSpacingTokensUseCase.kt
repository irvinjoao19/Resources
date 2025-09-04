package com.gongora.resources.demo.domain.usecases

import com.gongora.resources.demo.domain.models.SpacingToken
import com.gongora.resources.tokens.Spacing

/**
 * Use case for retrieving spacing tokens in the same format as React Native.
 * 
 * This use case follows the exact same pattern as the React Native showcase,
 * providing a flat list of spacing tokens with their values.
 */
class GetSpacingTokensUseCase {
    
    /**
     * Executes the use case and returns spacing tokens in the same format as React Native.
     * @return List of spacing tokens
     */
    operator fun invoke(): List<SpacingToken> {
        return listOf(
            SpacingToken("none", Spacing.none, "None"),
            SpacingToken("3xsmall", Spacing.`3xsmall`, "3XSmall"),
            SpacingToken("2xsmall", Spacing.`2xsmall`, "2XSmall"),
            SpacingToken("xsmall", Spacing.xsmall, "XSmall"),
            SpacingToken("small", Spacing.small, "Small"),
            SpacingToken("medium", Spacing.medium, "Medium"),
            SpacingToken("large", Spacing.large, "Large"),
            SpacingToken("xlarge", Spacing.xlarge, "XLarge"),
            SpacingToken("2xlarge", Spacing.`2xlarge`, "2XLarge"),
            SpacingToken("3xlarge", Spacing.`3xlarge`, "3XLarge")
        )
    }
}
