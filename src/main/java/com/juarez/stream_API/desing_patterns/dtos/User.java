package com.juarez.stream_API.desing_patterns.dtos;

public record User(

        String name,
        String email,

        boolean loyaltyMember,
        boolean activeLastMonth,
        boolean eligibleCard,

        int loyaltyPoints
) {
}
