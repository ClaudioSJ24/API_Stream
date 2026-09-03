package com.juarez.stream_API.lambdas.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        // Consumer

        Consumer<String> consumer = IO::println;

        Path path = Paths.get("src/main/resources/games.txt");

        Files.lines(path)
                .forEach(consumer);

        // BiConsumer

        IO.println("------");

        BiConsumer<String, Double> biConsumer = (k, v) -> IO.println(
                "Title: " + k + " rating: " + v);

        Data.RATINGS.forEach(biConsumer);


        // Supplier

        IO.println("------");

        Supplier<VideoGame> videogameDefault = () -> new VideoGame(
                "Forza Horizon 6",
                "Cars",
                "Xbox",
                2026,
                9.9
        );

        VideoGame vg = Data.emptyGame.orElseGet(videogameDefault);

        IO.println(vg.toString());

        // Predicate

        IO.println("------");

        Predicate<VideoGame> lowRatings = game -> game.rating() < 9.3;

        List<VideoGame> games = new ArrayList<>(Data.GAMES);
        games.removeIf(lowRatings);

        games.forEach(IO::println);

        IO.println("------");

        BiPredicate<VideoGame, String> isFromStudio = (game, studio) ->
                game.studio().equals(studio);

        Data.GAMES.forEach(game -> {

            if (isFromStudio.test(game, "Supergiant")) {
                IO.println("Supergiant: " + game);
            } else {
                IO.println("Not Supergiant: " + game);
            }
        });


        // Function

        IO.println("------");

        Function<VideoGame, String> getTitle = VideoGame::title;

        String title = Data.presentGame.map(getTitle).orElseGet(() -> "Unknown");
        IO.println(title);


        IO.println("------");

        Map<String, Double> ratings = new HashMap<>(Data.RATINGS);


        ratings.merge("Hades", 9.5, (oldValue, newValue) -> (oldValue + newValue) / 2.0);

        ratings.forEach((key, val) -> IO.println(key + ": " + val));


        // UnaryOperator

        IO.println("------");

        List<String> titles = new ArrayList<>(List.of(
                "the last of us",
                "god of war",
                "hades",
                "hollow knight",
                "red dead redemption"
        ));

        UnaryOperator<String> toUpperCase = String::toUpperCase;

        titles.replaceAll(toUpperCase);

        titles.forEach(IO::println);

        // BinaryOperator

        IO.println("------");

        BinaryOperator<Double> average =
                (oldValue, newValue) -> (oldValue + newValue) / 2.0;

        ratings.merge("The Last of Us", 9.99, average);

        IO.println(ratings.get("The Last of Us"));



        // Comparator

        IO.println("------");

        Comparator<String> compareAscend =
                (title1, title2) -> title1.compareTo(title2);

        titles.sort(compareAscend);
        titles.forEach(IO::println);

        IO.println("------");

        Comparator<String> compareDescend =
                (title1, title2) -> title2.compareTo(title1);

        titles.sort(compareDescend);
        titles.forEach(IO::println);

        IO.println("------");

        List<VideoGame> gamesSorted = new ArrayList<>(Data.GAMES);

        Comparator<VideoGame> compareByTitle =
                Comparator.comparing(VideoGame::title);

        gamesSorted.sort(compareByTitle);
        gamesSorted.forEach(IO::println);

        IO.println("------");

        Comparator<VideoGame> compareByYear =
                Comparator.comparingInt(VideoGame::year);

        gamesSorted.sort(compareByYear);
        gamesSorted.forEach(IO::println);

        IO.println("------");

        Comparator<VideoGame> compareByRating =
                Comparator.comparingDouble(VideoGame::rating);

        gamesSorted.sort(compareByRating);
        gamesSorted.forEach(IO::println);

        Comparator<VideoGame> compareByYearAndRating =
                Comparator.comparingInt(VideoGame::year).thenComparingDouble(VideoGame::rating);

        IO.println("------");

        gamesSorted.sort(compareByYearAndRating);
        gamesSorted.forEach(IO::println);


        // Runnable

        IO.println("------");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IO.println(Thread.currentThread().getName());

        Runnable runnable = () ->
                IO.println("Loading game in background... " + Thread.currentThread().getName());

        executorService.submit(runnable);

        // Callable

        IO.println("------");
        Callable<VideoGame> callable = () -> {
            Thread.sleep(500);
            IO.println("Loading game in background callable... " + Thread.currentThread().getName());
            return Data.GAMES.get(0);
        };

        Future<VideoGame> response = executorService.submit(callable);


        IO.println(response.get().title());

    }
}
