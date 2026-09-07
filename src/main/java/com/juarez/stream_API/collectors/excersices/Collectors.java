package com.juarez.stream_API.collectors.excersices;

import java.util.Map;

public class Collectors {
    public static void main(String[] args) {

        CollectorsExercise collectorsExercise = new CollectorsExercise();


        IO.println(collectorsExercise.getTotalArtistsMessage());

    }

    public static <K, V> void printMap(Map<K, V> map) {
        map.forEach((key, val) -> IO.println(key + " → " + val));
    }
}
