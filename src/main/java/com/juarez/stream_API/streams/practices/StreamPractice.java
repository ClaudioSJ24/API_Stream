package com.juarez.stream_API.streams.practices;

import com.juarez.stream_API.streams.data.DBMusic;
import com.juarez.stream_API.streams.dtos.Album;
import com.juarez.stream_API.streams.dtos.Artist;
import com.juarez.stream_API.streams.dtos.Song;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamPractice {

    // ════════════════════════════════════════════════════════════════
    // EJERCICIOS DE PRÁCTICA — Stream API
    // ════════════════════════════════════════════════════════════════

    /**
     * EJERCICIO 1 — FÁCIL
     * <p>
     * Retorna una lista con los nombres de todos los artistas
     * ordenados por la cantidad de álbumes de MAYOR a MENOR.
     * <p>
     * Operadores: sorted + map + toList
     * <p>
     * Ejemplo de salida esperada:
     *   ["The Beatles", "Pink Floyd", "Led Zeppelin", ...]
     * <p>
     * @return List<String> nombres ordenados por cantidad de álbumes descendente
     */
    public List<String> getArtistsSortedByAlbumCountDesc() {

        return DBMusic.ARTISTS.stream()
                // comparingInt espera un int para comparar
                // negamos el tamaño para invertir el orden — sin el negativo ordenaría de menor a mayor
                .sorted(Comparator.comparingInt(artist -> -artist.getAlbums().size()))
                // una vez ordenados solo necesitamos el nombre — no el objeto completo
                .map(Artist::getName)
                // colectamos en una lista inmutable
                .toList();

    }

    /**
     * EJERCICIO 2 — FÁCIL
     * <p>
     * Retorna true si existe AL MENOS UN artista de Francia.
     * <p>
     * Operadores: anyMatch
     * <p>
     * Ejemplo de salida esperada:
     *   true
     * <p>
     * @return boolean — true si hay algún artista de Francia
     */
    public boolean hasArtistFromFrance() {

        return DBMusic.ARTISTS.stream()
                // anyMatch para en cuanto encuentra el primero que cumple
                // no recorre toda la lista — es más eficiente que filter + count > 0
                .anyMatch(artist -> artist.getCountry().equals("France"));

    }

    /**
     * EJERCICIO 3 — FÁCIL
     * <p>
     * Retorna el nombre del artista con el nombre más largo.
     * <p>
     * Operadores: map + max
     * <p>
     * Ejemplo de salida esperada:
     *   Optional["Red Hot Chili Peppers"]
     * <p>
     * @return Optional<String> con el nombre más largo
     */
    public Optional<String> getLongestArtistName() {
        return  DBMusic.ARTISTS.stream()
                // primero extraemos los nombres para trabajar con Strings directamente
                // si no mapeamos aquí, tendríamos que hacer artist.getName().length() en el max
                .map(Artist::getName)
                // comparamos por longitud — max devuelve el String más largo según ese criterio
                // devuelve Optional porque el stream podría estar vacío
                .max(Comparator.comparingInt(String::length));
    }

    /**
     * EJERCICIO 4 — FÁCIL
     * <p>
     * Retorna una lista con los títulos de todos los álbumes
     * lanzados después del año 2000, sin duplicados.
     * <p>
     * Operadores: flatMap + filter + map + distinct + toList
     * <p>
     * @return List<String> títulos de álbumes post-2000 sin duplicados
     */
    public List<String> getAlbumTitlesAfter2000() {
        return DBMusic.ARTISTS.stream()
                // aplanamos — cada artista tiene List<Album>, necesitamos un stream de álbumes
                .flatMap(artist -> artist.getAlbums().stream())
                // filtramos solo los posteriores al año 2000
                .filter(album -> album.getYear() > 200)
                // extraemos el título — ya no necesitamos el objeto Album completo
                .map(Album::getTitle)
                // eliminamos títulos duplicados — puede haber álbumes con el mismo nombre
                .distinct()
                .toList();
    }

    /**
     * EJERCICIO 5 — FÁCIL
     * <p>
     * Retorna la canción con más reproducciones de TODO el catálogo.
     * <p>
     * Operadores: flatMap + flatMap + max
     * <p>
     * Ejemplo de salida esperada:
     *   Optional[Song{title="Blinding Lights"}]
     * <p>
     * @return Optional<Song> con la canción más reproducida
     */
    public Optional<Song> getMostReproducedSong() {
        return DBMusic.ARTISTS.stream()
                // primer nivel de aplanado — artistas → álbumes
                .flatMap(artist -> artist.getAlbums().stream())
                // segundo nivel — álbumes → canciones
                // después de esto tenemos un Stream<Song> plano con todas las canciones
                .flatMap(album -> album.getSongs().stream())
                // max con comparingInt sobre reproducciones
                // devuelve Optional porque el stream podría estar vacío
                .max(Comparator.comparingInt(Song::getReproductions));
    }

    /**
     * EJERCICIO 6 — INTERMEDIO
     * <p>
     * Retorna true si NINGÚN artista del género "Jazz"
     * es de un país fuera de USA.
     * <p>
     * Operadores: filter + noneMatch
     * <p>
     * Ejemplo de salida esperada:
     *   true
     * <p>
     * @return boolean — true si todos los artistas de Jazz son de USA
     */
    public boolean noJazzArtistOutsideUSA() {

        return DBMusic.ARTISTS.stream()
                // primero filtramos solo Jazz — reducimos el stream antes de evaluar
                .filter(artist -> artist.getGenre().equals("Jazz"))
                // noneMatch devuelve true si NINGUNO cumple la condición
                // es más semántico que !anyMatch — expresa mejor la intención
                .noneMatch(artist -> !artist.getCountry().equals("USA"));
    }

    /**
     * EJERCICIO 7 — INTERMEDIO
     * <p>
     * Retorna una lista con los títulos de las canciones
     * que duren MÁS de 5 minutos (300 segundos),
     * ordenadas por duración de MAYOR a MENOR.
     * <p>
     * Operadores: flatMap + flatMap + filter + sorted + map + toList
     * <p>
     * @return List<String> títulos de canciones de más de 5 minutos
     */
    public List<String> getSongsLongerThan5Minutes() {
        return DBMusic.ARTISTS.stream()
                // aplanamos dos niveles para llegar a las canciones
                .flatMap(artist -> artist.getAlbums().stream())
                .flatMap(album -> album.getSongs().stream())
                // 5 minutos = 300 segundos — filtramos las que superan ese umbral
                .filter(song -> song.getDurationSeconds() > 300)
                // reversed() invierte el comparador — de mayor duración a menor
                .sorted(Comparator.comparingInt(Song::getDurationSeconds).reversed())
                // ya filtradas y ordenadas, solo necesitamos el título
                .map(Song::getTitle)
                .toList();
    }

    /**
     * EJERCICIO 8 — INTERMEDIO
     * <p>
     * Calcula el promedio de reproducciones de todas las canciones
     * del género "Rock".
     * <p>
     * Operadores: filter + flatMap + flatMap + mapToLong + average
     * <p>
     * Ejemplo de salida esperada:
     *   OptionalDouble[754_320_000.0]
     * <p>
     * @return OptionalDouble con el promedio de reproducciones del género Rock
     */
    public OptionalDouble getAverageReproductionsRock() {
        return DBMusic.ARTISTS.stream()
                // filtramos artistas Rock antes de aplanar — reducimos trabajo innecesario
                .filter(artist -> artist.getGenre().equals("Rock"))
                // aplanamos hasta llegar a las canciones
                .flatMap(artist -> artist.getAlbums().stream())
                .flatMap(album -> album.getSongs().stream())
                // mapToLong convierte a LongStream — evita autoboxing de Long
                // además average() no existe en Stream<Song>, solo en LongStream/IntStream
                .mapToLong(Song::getReproductions)
                // average devuelve OptionalDouble — podría no haber canciones de Rock
                .average();
    }

    /**
     * EJERCICIO 9 — INTERMEDIO
     * <p>
     * Retorna el total de canciones de TODOS los artistas
     * de Latinoamérica (género "Latin") usando reduce.
     * <p>
     * Operadores: filter + flatMap + flatMap + mapToLong + reduce
     * <p>
     * Ejemplo de salida esperada:
     *   34
     * <p>
     * @return long con el total de canciones del género Latin
     */
    public long getTotalLatinSongs() {

        return DBMusic.ARTISTS.stream()
                // solo artistas Latin
                .filter(artist -> artist.getGenre().equals("Latin"))
                // aplanamos hasta canciones
                .flatMap(artist -> artist.getAlbums().stream())
                .flatMap(album -> album.getSongs().stream())
                // mapToLong para trabajar con primitivos — sin autoboxing
                .mapToLong(song -> 1L)
                // reduce con identidad 0 — si no hay canciones devuelve 0 directamente
                // suma 1 por cada canción — equivale a count() pero usando reduce explícitamente
                .reduce(0L, Long::sum);
    }

    /**
     * EJERCICIO 10 — INTERMEDIO
     * <p>
     * Calcula el TOTAL de reproducciones de todas las canciones
     * del catálogo completo procesando el stream en PARALELO.
     * <p>
     * Nota: este ejercicio simula un dataset enorme donde
     * el procesamiento paralelo tiene sentido.
     * Compara el resultado con un stream secuencial — deben ser iguales.
     * <p>
     * Operadores: parallelStream + flatMap + flatMap + mapToLong + sum
     * <p>
     * @return long total de reproducciones procesado en paralelo
     */
    public long getTotalReproductionsParallel() {

        return DBMusic.ARTISTS.parallelStream()
                // parallelStream divide la lista en chunks y los procesa en múltiples hilos
                // el resultado es el mismo que stream() secuencial — solo cambia el rendimiento
                .flatMap(artist -> artist.getAlbums().stream())
                .flatMap(album -> album.getSongs().stream())
                // mapToLong antes de sum — sum solo existe en LongStream, no en Stream<Song>
                .mapToLong(Song::getReproductions)
                // sum es equivalente a reduce(0L, Long::sum) pero más legible
                .sum();
    }
}
