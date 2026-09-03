package com.juarez.stream_API.desing_patterns.validator;

import com.juarez.stream_API.desing_patterns.dtos.User;

public class UserValidators {

    private UserValidators(){}

   public static BusinessValidator<User> isLoyaltyMember = user -> {
        IO.println("validating: isLoyaltyMember");
        return user.loyaltyMember();
   } ;

    public static BusinessValidator<User> wasActiveLastMonth = user -> {
        IO.println("validating: wasActiveLastMonth");
        return user.activeLastMonth();
    };

    public static BusinessValidator<User> hasEligibleCard = user -> {
        IO.println("validating: isElegibleCard");
        return user.eligibleCard();
    };

    public static BusinessValidator<User> isPayingWithPoints = user -> {
        IO.println("validating: isPayingWithPoints");
        return user.loyaltyPoints() > 1;
    };

    public static BusinessValidator<User> everyTimeFalse = user -> {
        IO.println("validating: everyTimeFalse");
        return false;
    };
}
