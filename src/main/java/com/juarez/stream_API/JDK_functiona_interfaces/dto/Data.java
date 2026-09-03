package com.juarez.stream_API.JDK_functiona_interfaces.dto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Data {
    private Data () { }

    public static List<VideoGame> GAMES = List.of(
            new VideoGame("The Last of Us",       "Action",  "Naughty Dog",    2013, 9.5),
            new VideoGame("God of War",           "Action",  "Santa Monica",   2018, 9.4),
            new VideoGame("Hades",                "Roguelike","Supergiant",     2020, 9.2),
            new VideoGame("Hollow Knight",        "Metroidvania","Team Cherry", 2017, 9.0),
            new VideoGame("Red Dead Redemption",  "Adventure","Rockstar",       2018, 9.3)
    );


    static Map<String, Double> RATINGS = Map.of(
            "The Last of Us",      9.5,
            "God of War",          9.4,
            "Hades",               9.2,
            "Hollow Knight",       9.0,
            "Red Dead Redemption", 9.3
    );


    public static Optional<VideoGame> emptyGame   = Optional.empty();
    public static Optional<VideoGame> presentGame = Optional.of(
            new VideoGame("Geometry Dash", "Arcade", "Rob Top", 2014, 9.9)
    );

}
