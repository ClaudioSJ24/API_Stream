package com.juarez.stream_API.lambdas.impl_lambda;

import com.juarez.stream_API.lambdas.interfaces_lambda.TransformFunc;

public class Transformers {

    private Transformers() {}

//    public static TransformFunc<String> tuUpperCase =
//            str -> str.toUpperCase();
//
//    public static TransformFunc<Double> floor =
//            num -> Math.floor(num);
//
//    public static TransformFunc<String> toLowerCase =
//            str -> str.toLowerCase();

    public static TransformFunc<String> tuUpperCase =
            String::toUpperCase;

    public static TransformFunc<Double> floor =
            Math::floor;

    public static TransformFunc<String> toLowerCase =
            String::toLowerCase;
}
