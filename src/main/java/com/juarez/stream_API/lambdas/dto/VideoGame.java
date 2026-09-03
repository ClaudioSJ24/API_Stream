package com.juarez.stream_API.lambdas.dto;

public record VideoGame(
        String title,
        String genre,
        String studio,
        int year,
        double rating
) {
}
