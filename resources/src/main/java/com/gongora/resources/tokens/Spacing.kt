package com.gongora.resources.tokens

/**
 * @fileoverview Tokens de espaciado
 *
 * Define un sistema de espaciado consistente basado en una escala armónica de múltiplos de 4dp.
 * Proporciona valores estandarizados para márgenes, padding, gaps y separaciones entre elementos,
 * garantizando coherencia visual y ritmo en toda la interfaz.
 *
 * El sistema sigue principios de diseño modular donde cada valor tiene un propósito específico:
 * - Valores pequeños (2dp-8dp): Para detalles y separaciones sutiles
 * - Valores medios (12dp-24dp): Para espaciado estándar entre componentes
 * - Valores grandes (32dp-48dp): Para separaciones estructurales y jerarquía
 *
 * @author BCP Design System Developer Team
 * @since 1.0.0
 * @version 1.0.0
 * @readonly
 * @public
 */

/**
 * Valores de espaciado disponibles
 * @description Define una escala de espaciado consistente basada en múltiplos de 4dp para crear layouts armónicos
 * 
 * @see {@link https://www.figma.com/design/DnlJ7BE1KZftITuYewsCux/DS-%7C-Platform?node-id=10032-24447&t=jjEgHolK3uOlQXBF-4 Figma - Spacing}
 * 
 * @example
 * ```kotlin
 * val containerPadding = spacing.medium // 16dp
 * val buttonMargin = spacing.small // 12dp
 * val sectionGap = spacing.large // 24dp
 * ```
 */
object Spacing {
    /** Sin espaciado - 0dp - Para elementos que deben estar pegados */
    const val none = 0f
    
    /** Espaciado extra extra pequeño - 2dp - Para separaciones mínimas */
    const val `3xsmall` = 2f
    
    /** Espaciado extra pequeño - 4dp - Para separaciones muy sutiles */
    const val `2xsmall` = 4f
    
    /** Espaciado pequeño - 8dp - Para separaciones entre elementos relacionados */
    const val xsmall = 8f
    
    /** Espaciado pequeño-medio - 12dp - Para márgenes internos de componentes */
    const val small = 12f
    
    /** Espaciado medio/base - 16dp - Espaciado estándar para la mayoría de casos */
    const val medium = 16f
    
    /** Espaciado grande - 24dp - Para separar secciones relacionadas */
    const val large = 24f
    
    /** Espaciado extra grande - 32dp - Para separar grupos de contenido */
    const val xlarge = 32f
    
    /** Espaciado doble extra grande - 40dp - Para separaciones importantes */
    const val `2xlarge` = 40f
    
    /** Espaciado triple extra grande - 48dp - Para separaciones principales entre secciones */
    const val `3xlarge` = 48f
}

/**
 * Tipo que representa las claves disponibles para valores de espaciado
 * @description Proporciona autocompletado y verificación de tipos para spacing
 */
typealias SpacingType = String
