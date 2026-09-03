package com.juarez.stream_API.desing_patterns;

import com.juarez.stream_API.desing_patterns.dtos.Ticket;
import com.juarez.stream_API.desing_patterns.dtos.User;
import com.juarez.stream_API.desing_patterns.strategy.PricingStrategies;
import com.juarez.stream_API.desing_patterns.strategy.PricingStrategy;
import com.juarez.stream_API.desing_patterns.validator.BusinessValidator;

import java.util.List;

public class Main{

    public static void main(String[] args) {

            /*
        Ticket ticket = new Ticket(
                "Coldplay World Tour",
                "Foro Sol",
                "GENERAL",
                850.0, 2,
                new User("Alejandro", "alejandro@mail.com",
                        true,  true,  true,
                        150
        ));

        PricingStrategy<Ticket, Double> traditional    = PricingStrategies.traditional;
        PricingStrategy<Ticket, Double> combo          = PricingStrategies.combo;
        PricingStrategy<Ticket, Double> vipClub        = PricingStrategies.vipClub;
        PricingStrategy<Ticket, Double> loyaltyPoints  = PricingStrategies.loyaltyPoints;

        IO.println("Traditional:    $" + traditional.calculate(ticket));
        IO.println("Combo:          $" + combo.calculate(ticket));
        IO.println("VIP Club:       $" + vipClub.calculate(ticket));
        IO.println("Loyalty Points: $" + loyaltyPoints.calculate(ticket));

    */

    /*

        User user1 = new User("Alejandro", "alejandro@mail.com", true,  true,  true,  150);
        User user2 = new User("María",     "debuggeandoideas@mail.com",     true,  false, true,  0);
        User user3 = new User("Carlos",    "user@mail.com",    false, false, false, 0);

        List<BusinessValidator<User>> validators = List.of(
            UserValidators.isLoyaltyMember,
            UserValidators.wasActiveLastMonth,
            UserValidators.hasEligibleCard,
            UserValidators.isPayingWithPoints
        );

        IO.println("Alejandro aplica descuento: " + applyAll(validators, user1)); // true
        IO.println("María aplica descuento:     " + applyAll(validators, user2)); // false
        IO.println("Carlos aplica descuento:    " + applyAll(validators, user3)); // false
     */



        Ticket ticket = new Ticket(
                "Coldplay World Tour",
                "Foro Sol",
                "GENERAL",
                850.0, 2,
                new User("Alejandro", "alejandro@mail.com",
                        true,  true,  true,
                        150
                ));

        String paymentType = "COMBO"; //TRADITIONAL, VIP, PONTS


        PricingStrategy<Ticket, Double> strategy = switch (paymentType) {
            case "COMBO" -> PricingStrategies.combo;
            case "TRADITIONAL" -> PricingStrategies.traditional;
            case "VIP" -> PricingStrategies.vipClub;
            case "POINTS" -> PricingStrategies.loyaltyPoints;
            default -> throw new IllegalStateException("Unexpected value: " + paymentType);
        };

        IO.println("Price: " + strategy.calculate(ticket));


    }

    private static boolean applyAll(List<BusinessValidator<User>> validators, User user) {
        return validators.stream()
                .allMatch(validator -> validator.validate(user));
    }


}
