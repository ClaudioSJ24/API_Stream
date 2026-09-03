package com.juarez.stream_API.desing_patterns.validator;



/**
 * Representa una regla de validación de negocio sobre un objeto de tipo T.
 * <p>
 * Cada implementación encapsula una regla específica que puede ser evaluada
 * de forma independiente o combinada con otras validaciones.
 * </p>
 *
 * @param <T> el tipo del objeto a validar
 * @since 1.0
 */
@FunctionalInterface
public interface BusinessValidator<T>{
    boolean validate(T value);
}
