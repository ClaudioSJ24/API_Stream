package com.juarez.stream_API.desing_patterns.dtos;

public record Ticket(

        String event,
        String venue,
        String category,     // GENERAL, VIP, PLATINUM

        double basePrice,
        int quantity,

        User user

) {
}
