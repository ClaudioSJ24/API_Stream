package com.juarez.stream_API.funtional_code.challenge_three;

import java.util.Arrays;

public enum TransferStatus {
    PENDING,
    ACCEPTED,
    CANCELLED,
    EXPIRED,
    COMPLETED,
    UNKNOWN;

    public static TransferStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            return UNKNOWN;
        }
        return Arrays.stream(values())
                .filter(s -> s.name().equalsIgnoreCase(value.trim()))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
