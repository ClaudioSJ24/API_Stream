package com.juarez.stream_API.desing_patterns.strategy;

import com.juarez.stream_API.desing_patterns.dtos.Ticket;

public class PricingStrategies {

    public static PricingStrategy<Ticket, Double> traditional = ticket -> {
        IO.println("Strategy: traditional");

        return (ticket.basePrice() * ticket.quantity());
    };


    public static PricingStrategy<Ticket, Double> combo = ticket ->{
        IO.println("Strategy: combo");

        return (ticket.basePrice() * ticket.quantity()) * 0.85;
    };


    public static PricingStrategy<Ticket, Double> vipClub = ticket ->{
        IO.println("Strategy: vipClub");

        return (ticket.basePrice() * ticket.quantity()) * 0.75;

    };


    public static PricingStrategy<Ticket, Double> loyaltyPoints = ticket ->{
        IO.println("Strategy: loyaltyPoints");
        int loyaltyPointsQuantity = ticket.user().loyaltyPoints();
        return (ticket.basePrice() * ticket.quantity()) - loyaltyPointsQuantity;
    };

}
