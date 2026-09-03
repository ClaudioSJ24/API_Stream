package com.juarez.stream_API.lambdas.desing_patterns.strategy;

/**
 * Representa una estrategia de cálculo de precio para un objeto de tipo T.
 * <p>
 * Cada implementación define un algoritmo de pricing intercambiable
 * que puede aplicarse sobre el mismo tipo de entrada sin modificar
 * el código que lo consume.
 * </p>
 *
 * @param <T> el tipo del objeto sobre el que se aplica la estrategia
 * @param <R> el tipo del resultado devuelto por la estrategia
 * @since 1.0
 */
@FunctionalInterface
public interface PricingStrategy<T, R>{

    R calculate(T input);
}
