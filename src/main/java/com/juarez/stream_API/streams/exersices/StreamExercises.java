package com.juarez.stream_API.streams.exersices;

import com.juarez.stream_API.streams.dtos.Artist;
import com.juarez.stream_API.streams.dtos.ArtistSummary;
import com.juarez.stream_API.streams.dtos.Song;

import java.util.*;

public class StreamExercises {

    // ════════════════════════════════════════════════════════════════
    // CLASE 2 — filter + map
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 2.1 — SENCILLO
     * <p>     * Dado el listado de artistas en MusicData.ARTISTS,
     * retorna una lista con los NOMBRES de todos los artistas
     * cuyo género sea "Rock".
     * <p>     * Operadores: filter + map + toList
     * <p>     * Ejemplo de salida esperada:
     *   ["The Beatles", "Led Zeppelin", "Pink Floyd", ...]
     * <p>     * @return List<String> con los nombres de artistas de Rock
     */
    public List<String> getRockArtistNames() {
        throw new UnsupportedOperationException("Implementar ejercicio 2.1");
    }

    /**
     * EJERCICIO 2.2 — INTERMEDIO
     * <p>     * Dado el listado de artistas, retorna una lista de objetos ArtistSummary
     * que contenga únicamente los artistas que tengan MÁS DE UN álbum.
     * <p>     * ArtistSummary debe contener: nombre del artista y su país.
     * <p>     * Operadores: filter + map + toList
     * <p>     * Ejemplo de salida esperada:
     *   [ArtistSummary{name="The Beatles", country="UK"}, ...]
     * <p>     * @return List<ArtistSummary> de artistas con más de un álbum
     */
    public List<ArtistSummary> getArtistsWithMultipleAlbums() {
        throw new UnsupportedOperationException("Implementar ejercicio 2.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 3 — map vs flatMap
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 3.1 — SENCILLO
     * <p>     * Dado el listado de artistas, retorna una lista con TODOS
     * los títulos de álbumes de todos los artistas — sin importar
     * a quién pertenece cada álbum.
     * <p>     * Pista: cada artista tiene List<Album> — necesitas aplanar.
     * <p>     * Operadores: flatMap + map + toList
     * <p>     * Ejemplo de salida esperada:
     *   ["Abbey Road", "Let It Be", "Led Zeppelin IV", ...]
     * <p>     * @return List<String> con todos los títulos de álbumes
     */
    public List<String> getAllAlbumTitles() {
        throw new UnsupportedOperationException("Implementar ejercicio 3.1");
    }

    /**
     * EJERCICIO 3.2 — INTERMEDIO
     * <p>     * Dado el listado de artistas, retorna una lista con TODAS
     * las canciones de TODOS los álbumes de TODOS los artistas
     * cuyo género sea "Pop".
     * <p>     * Pista: necesitas dos niveles de flatMap — artistas → álbumes → canciones.
     * <p>     * Operadores: filter + flatMap + flatMap + toList
     * <p>     * Ejemplo de salida esperada:
     *   [Song{title="Thriller"}, Song{title="Billie Jean"}, ...]
     * <p>     * @return List<Song> con todas las canciones del género Pop
     */
    public List<Song> getAllSongsFromPopArtists() {
        throw new UnsupportedOperationException("Implementar ejercicio 3.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 4 — distinct + sorted + limit + skip
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 4.1 — SENCILLO
     * <p>     * Dado el listado de artistas, retorna una lista con los géneros
     * musicales únicos — sin repetidos — ordenados alfabéticamente.
     * <p>     * Operadores: map + distinct + sorted + toList
     * <p>     * Ejemplo de salida esperada:
     *   ["Electronic", "Hip-Hop", "Jazz", "Latin", "Pop", "Rock", "Soul"]
     * <p>     * @return List<String> con géneros únicos ordenados
     */
    public List<String> getUniqueGenresSorted() {
        throw new UnsupportedOperationException("Implementar ejercicio 4.1");
    }

    /**
     * EJERCICIO 4.2 — INTERMEDIO
     * <p>     * Dado el listado de artistas ordenados por nombre alfabéticamente,
     * salta los primeros 5 y retorna los siguientes 5.
     * <p>     * Simula una paginación: página 2, tamaño de página 5.
     * <p>     * Operadores: sorted + skip + limit + toList
     * <p>     * @return List<Artist> página 2 de artistas ordenados por nombre
     */

    public List<Artist> getArtistsPage2() {
        throw new UnsupportedOperationException("Implementar ejercicio 4.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 5 — count + min + max + findFirst + findAny
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 5.1 — SENCILLO
     * <p>     * Dado el listado de artistas, retorna cuántos artistas
     * son del país "USA".
     * <p>     * Operadores: filter + count
     * <p>     * Ejemplo de salida esperada:
     *   12
     * <p>     * @return long con la cantidad de artistas de USA
     */
    public long countUSAArtists() {
        throw new UnsupportedOperationException("Implementar ejercicio 5.1");
    }

    /**
     * EJERCICIO 5.2 — INTERMEDIO
     * <p>     * De TODAS las canciones de TODOS los artistas,
     * encuentra la canción con la duración más larga.
     * <p>     * Pista: necesitas flatMap para llegar a las canciones,
     * luego max con un Comparator sobre getDurationSeconds.
     * <p>     * Operadores: flatMap + flatMap + max
     * <p>     * Ejemplo de salida esperada:
     *   Optional[Song{title="Freddie Freeloader", duration=583s}]
     * <p>     * @return Optional<Song> con la canción más larga
     */
    public Optional<Song> getLongestSong() {
        throw new UnsupportedOperationException("Implementar ejercicio 5.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 6 — anyMatch + allMatch + noneMatch + reduce
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 6.1 — SENCILLO
     * <p>     * Verifica si TODOS los artistas del género "Jazz"
     * son de USA.
     * <p>     * Operadores: filter + allMatch
     * <p>     * Ejemplo de salida esperada:
     *   true
     * <p>     * @return boolean — true si todos los artistas de Jazz son de USA
     */
    public boolean areAllJazzArtistsFromUSA() {
        throw new UnsupportedOperationException("Implementar ejercicio 6.1");
    }

    /**
     * EJERCICIO 6.2 — INTERMEDIO
     * <p>     * Calcula el TOTAL de reproducciones de TODAS las canciones
     * de TODOS los artistas usando reduce.
     * <p>     * Pista: flatMap dos veces para llegar a Song,
     * mapToLong para obtener las reproducciones,
     * luego reduce para sumarlas todas.
     * <p>     * Operadores: flatMap + flatMap + mapToLong + reduce
     * <p>     * Ejemplo de salida esperada:
     *   87_430_000_000
     * <p>     * @return long con el total de reproducciones
     */
    public long getTotalReproductions() {
        throw new UnsupportedOperationException("Implementar ejercicio 6.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 7 — toList + toSet + toArray
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 7.1 — SENCILLO
     * <p>     * Retorna un SET con todos los países de los artistas.
     * Al ser Set, los países duplicados se eliminan automáticamente.
     * <p>     * Operadores: map + collect(toSet)
     * <p>     * Ejemplo de salida esperada:
     *   {UK, USA, France, Canada, Colombia, Puerto Rico}
     * <p>     * @return Set<String> con los países únicos
     */
    public Set<String> getUniqueCountries() {
        throw new UnsupportedOperationException("Implementar ejercicio 7.1");
    }

    /**
     * EJERCICIO 7.2 — INTERMEDIO
     * <p>     * Retorna un array con los nombres de los artistas
     * del género "Hip-Hop" ordenados por nombre descendente.
     * <p>     * Operadores: filter + map + sorted + toArray
     * <p>     * Ejemplo de salida esperada:
     *   ["Kendrick Lamar", "Kanye West", "Jay-Z", "Eminem", "Drake"]
     * <p>     * @return String[] con los nombres ordenados descendente
     */
    public String[] getHipHopArtistsSortedDesc() {
        throw new UnsupportedOperationException("Implementar ejercicio 7.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 8 — mapToInt + mapToLong + mapToDouble
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 8.1 — SENCILLO
     * <p>     * Calcula el promedio de duración en segundos de TODAS
     * las canciones de TODOS los artistas.
     * <p>     * Operadores: flatMap + flatMap + mapToInt + average
     * <p>     * Ejemplo de salida esperada:
     *   OptionalDouble[284.5]
     * <p>     * @return OptionalDouble con el promedio de duración
     */
    public OptionalDouble getAverageSongDuration() {
        throw new UnsupportedOperationException("Implementar ejercicio 8.1");
    }

    /**
     * EJERCICIO 8.2 — INTERMEDIO
     * <p>     * Retorna un resumen estadístico (count, sum, min, max, average)
     * de las reproducciones de todas las canciones del género "Pop".
     * <p>     * Pista: filter por género en artistas, flatMap dos veces,
     * mapToLong sobre getReproductions, summaryStatistics.
     * <p>     * Operadores: filter + flatMap + flatMap + mapToLong + summaryStatistics
     * <p>     * Ejemplo de salida esperada:
     *   LongSummaryStatistics{count=18, sum=..., min=..., max=..., average=...}
     * <p>     * @return LongSummaryStatistics de reproducciones del género Pop
     */
    public LongSummaryStatistics getPopReproductionStats() {
        throw new UnsupportedOperationException("Implementar ejercicio 8.2");
    }

    // ════════════════════════════════════════════════════════════════
    // CLASE 9 — takeWhile + dropWhile
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 9.1 — SENCILLO
     * <p>     * Dado el listado de artistas ordenado por nombre alfabéticamente,
     * toma artistas MIENTRAS su nombre empiece con una letra
     * anterior a la "M" (es decir, A-L).
     * <p>     * Operadores: sorted + takeWhile
     * <p>     * Ejemplo de salida esperada:
     *   ["Adele", "Amy Winehouse", "Aphex Twin", "Aretha Franklin", ...]
     * <p>     * @return List<Artist> con artistas cuyo nombre empieza antes de "M"
     */
    public List<Artist> getArtistsBeforeM() {
        throw new UnsupportedOperationException("Implementar ejercicio 9.1");
    }

    /**
     * EJERCICIO 9.2 — INTERMEDIO
     * <p>     * Dado el listado de artistas ordenado por número de álbumes
     * de menor a mayor, salta todos los artistas que tengan
     * UN solo álbum y retorna el resto.
     * <p>
     * Operadores: sorted + dropWhile + toList
     * <p>     * Ejemplo de salida esperada:
     *   [Artist con 2 álbumes, Artist con 2 álbumes, ...]
     * <p>     * @return List<Artist> con artistas que tienen más de un álbum
     */
    public List<Artist> getArtistsWithMoreThanOneAlbum() {
        throw new UnsupportedOperationException("Implementar ejercicio 9.2");
    }

    /**
     * EJERCICIO 10.1 — SENCILLO
     * Encuentra el PRIMER artista cuyo nombre contenga la palabra "The".
     * Operadores: filter + findFirst
     * Ejemplo de salida esperada:
     *   Optional[Artist{name="The Beatles"}]
     *
     * @return Optional<Artist> con el primer artista que contenga "The"
     */
    public Optional<Artist> findFirstArtistWithThe() {
        throw new UnsupportedOperationException("Implementar ejercicio 10.1");
    }

    /**
     * EJERCICIO 10.2 — SENCILLO
     * Encuentra CUALQUIER artista del género "Jazz".
     * En streams paralelos puede retornar cualquiera — no necesariamente el primero.
     * Operadores: filter + findAny
     *
     * @return Optional<Artist> con cualquier artista de Jazz
     */
    public Optional<Artist> findAnyJazzArtist() {
        throw new UnsupportedOperationException("Implementar ejercicio 10.2");
    }

}
