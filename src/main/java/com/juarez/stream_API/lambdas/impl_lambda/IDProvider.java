package com.juarez.stream_API.lambdas.impl_lambda;

import com.juarez.stream_API.lambdas.interfaces_lambda.Provider;

import java.util.UUID;

public class IDProvider {

    private IDProvider() {}

    public static Provider<String> uuid =
            () -> UUID.randomUUID().toString();

    public static Provider<Integer> randomInt =
            () -> (int) (Math.random() * 100);

}
