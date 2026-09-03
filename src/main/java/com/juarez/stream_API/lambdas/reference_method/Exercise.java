package com.juarez.stream_API.lambdas.reference_method;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Exercise {

    public static void main(String[] args) {

        // ── Ejercicio 1 ─────────────────────────────────────────────
        // Una lista de temperaturas como String necesita convertirse a Double
        String[] temperaturas = {"36.6", "37.1", "38.0", "36.9"};
        Function<String, Double> parser = val -> Double.parseDouble(val);
        // TODO: convierte a referencia a método
        Function<String, Double> parseReference = Double::parseDouble;
        // TODO: argumenta qué tipo de referencia es y por qué
        // Tipo: referencia a método ESTÁTICO
        // Double.parseDouble es un método estático — no necesita instancia,
        // pertenece a la clase Double. La lambda solo lo invoca directamente,
        // por eso se puede reemplazar con Clase::método.

        // ── Ejercicio 2 ─────────────────────────────────────────────
        // Ordena los nombres de pacientes alfabéticamente ignorando mayúsculas
        String[] pacientes = {"zebra", "Alice", "BOB", "charlie"};
        Arrays.sort(pacientes, (a, b) -> a.compareToIgnoreCase(b));
        // TODO: convierte a referencia a método
        // referencia a método
        Arrays.sort(pacientes, String::compareToIgnoreCase);
        // TODO: argumenta qué tipo de referencia es y por qué
        // Tipo: referencia ARBITRARIA
        // compareToIgnoreCase es un método de instancia de String.
        // No hay un objeto concreto definido de antemano — 'a' es el objeto
        // sobre el que se llama el método y 'b' es el argumento.
        // Java resuelve esto automáticamente: (a, b) -> a.método(b)

        // ── Ejercicio 3
        // ¿Se puede convertir? Argumenta tu respuesta.
        BiFunction<String, String, Movie> factory = (title, year) -> {
            IO.println("Creando película: " + title);
            return new Movie(title, year);
        };
        // TODO: ¿se puede convertir a Movie::new? ¿por qué sí o por qué no?
        // Respuesta: NO se puede convertir a Movie::new
        //
        // Movie::new solo reemplaza lambdas que únicamente llaman al constructor.
        // Esta lambda hace dos cosas:
        //   1. imprime un mensaje con IO.println
        //   2. crea el objeto con new Movie(title, year)
        //
        // En el momento en que hay lógica adicional antes o después
        // de la llamada al método, la referencia ya no aplica.
        // La regla es: si la lambda hace algo más que llamar un método,
        // quédate con la lambda.


    }
}
