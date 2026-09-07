package com.juarez.stream_API.collectors.excersices;

import com.juarez.stream_API.streams.data.DBMusic;
import com.juarez.stream_API.streams.dtos.Album;
import com.juarez.stream_API.streams.dtos.Artist;
import com.juarez.stream_API.streams.dtos.Song;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExercise {

    private static List<Artist> artistList = DBMusic.ARTISTS;
    /**
     * groupingBy
     * <p>
     * Agrupa artistas por género y dentro de cada grupo
     * los ordena alfabéticamente por nombre.
     *
     * @return Map<String, List<Artist>> género → artistas ordenados por nombre
     */
    public Map<String, List<Artist>> groupArtistsByGenreSorted() {
        return artistList.stream()
                .collect(
                        Collectors.groupingBy( // Collector
                                Artist::getGenre, // Group
                                Collectors.collectingAndThen( // Collector
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparing(Artist::getName))
                                                .toList()
                                )
                        )
                );
    }

    /**
     * groupingBy + counting
     * <p>
     * Cuenta cuántas canciones totales hay por género.
     * Requiere flatMap para llegar a las canciones antes de agrupar.
     *
     * @return Map<String, Long> género → total de canciones
     */
    public Map<String, Set<String>> countSongsByGenre() {
        return artistList.stream()
                .collect(
                        Collectors.groupingBy(
                                Artist::getGenre,
                                Collectors.flatMapping(
                                        artist -> artist.getAlbums().stream()
                                                .map(Album::getTitle),
                                        Collectors.toSet()
                                )
                        )
                );
    }

    /**
     * groupingBy + mapping
     * <p>
     * Por género, retorna la lista de títulos de todos sus álbumes sin duplicados.
     * Requiere flatMap + distinct dentro del mapping.
     *
     * @return Map<String, List<String>> género → títulos de álbumes sin duplicados
     */
    public Map<String, Set<String>> getAlbumTitlesByGenre() {
        return artistList.stream()
                .collect(
                        Collectors.groupingBy(
                                Artist::getGenre,
                                Collectors.flatMapping(
                                        artist ->  artist.getAlbums().stream()
                                                .map(Album::getTitle),
                                        Collectors.toSet()
                                )
                        )
                );
    }

    /**
     * groupingBy + summarizingLong
     * <p>
     * Retorna estadísticas de reproducciones totales por género
     * solo de artistas con más de 2 álbumes.
     * Requiere filter antes de agrupar.
     *
     * @return Map<String, LongSummaryStatistics> género → estadísticas de reproducciones
     */
    public Map<String, LongSummaryStatistics> getReproductionStatsByGenre() {
        return artistList.stream()
                .collect(
                        Collectors.groupingBy(
                                Artist::getGenre,
                                Collectors.summarizingLong(
                                        artist -> artist.getAlbums().stream()
                                                .flatMap(album -> album.getSongs().stream())
                                                .mapToLong(Song::getReproductions)
                                                .sum()
                                )
                        )
                );
    }

    /**
     * groupingBy + maxBy
     * <p>
     * Por género, encuentra la canción más reproducida.
     * Requiere flatMap + flatMap antes de agrupar.
     *
     * @return Map<String, Optional<Song>> género → canción más reproducida
     */
    public Map<String, Optional<Song>> getMostReproducedSongByGenre() {
        throw new UnsupportedOperationException("Implementar groupingBy + maxBy");
    }

    /**
     * groupingBy + minBy
     * <p>
     * Por país del artista, encuentra la canción más corta.
     * Requiere flatMap + flatMap antes de agrupar.
     *
     * @return Map<String, Optional<Song>> país → canción más corta
     */
    public Map<String, Optional<Song>> getShortestSongByCountry() {
        throw new UnsupportedOperationException("Implementar groupingBy + minBy");
    }

    /**
     * partitioningBy
     * <p>
     * Divide artistas entre los que son de UK y los que no,
     * contando cuántos hay en cada grupo.
     *
     * @return Map<Boolean, Long> true → artistas de UK | false → resto
     */
    public Map<Boolean, Long> partitionArtistsByUK() {
        return artistList.stream()
                .collect(Collectors.partitioningBy(
                        artist ->  artist.getCountry().equals("UK"),
                                Collectors.counting()
                ));
    }

    /**
     * toMap
     * <p>
     * Retorna un mapa con el nombre del artista
     * y el total de canciones que tiene en todo su catálogo.
     * Requiere flatMap para contar las canciones.
     *
     * @return Map<String, Long> nombre → total de canciones
     */
    public Map<String, Long> getArtistSongCount() {
        return artistList.stream()
                .collect(
                        Collectors.toMap(
                                Artist::getName,
                                artist -> artist.getAlbums().stream()
                                        .mapToLong(album -> album.getSongs().size())
                                        .sum(),
                                (existingValue, newValue) -> existingValue
                        )
                );
    }

    /**
     * joining
     * <p>
     * Por género, concatena los títulos de todos sus álbumes
     * separados por " | ".
     * Requiere groupingBy + mapping + joining como downstream.
     *
     * @return Map<String, String> género → títulos de álbumes concatenados
     */
    public Map<String, String> getAlbumTitlesJoinedByGenre() {
        return artistList.stream()
                .collect(Collectors.groupingBy(
                        Artist::getGenre,
                        Collectors.mapping(
                                artist -> artist.getAlbums().stream()
                                        .map(Album::getTitle)
                                        .collect(Collectors.joining(" | ")),
                                Collectors.joining(" | ")
                        )
                ));
    }

    /**
     * collectingAndThen
     * <p>
     * Agrupa artistas por país, cuenta cuántos hay en cada grupo
     * y devuelve el mapa inmutable.
     *
     * @return Map<String, Long> inmutable — país → cantidad de artistas
     */
    public Map<String, Long> getImmutableArtistCountByCountry() {
        throw new UnsupportedOperationException("Implementar collectingAndThen");
    }

    /**
     * mapping
     * <p>
     * Por género, retorna la lista de títulos de todas sus canciones
     * sin duplicados.
     * Requiere flatMap + flatMap + distinct dentro del mapping.
     *
     * @return Map<String, List<String>> género → títulos de canciones sin duplicados
     */
    public Map<String, List<String>> getSongTitlesByGenre() {
        throw new UnsupportedOperationException("Implementar mapping");
    }

    /**
     * collectingAndThen
     * <p>
     * Cuenta el total de artistas del catálogo
     * y devuelve el resultado como un mensaje formateado.
     * Ejemplo de salida esperada:
     *   "Total de artistas en el catálogo: 39"
     *
     * @return String con el total de artistas formateado
     */
    public String getTotalArtistsMessage() {
        return artistList.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> "Total de artistas en el catálogo: " + count
                        )
                );
    }
}
