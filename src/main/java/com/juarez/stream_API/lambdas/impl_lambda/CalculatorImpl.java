package com.juarez.stream_API.lambdas.impl_lambda;

import com.juarez.stream_API.lambdas.interfaces_lambda.Calculator;

public class CalculatorImpl {

    private  CalculatorImpl(){}

    //public static Calculator sum = (Double  a, Double b) -> a + b;
    public static Calculator sum = Double::sum;

    public static Calculator subs
            = (a, b) -> a - b;

    public static Calculator multiply
            = (a, b) -> a * b;


   // public static Calculator min = (a, b) -> Math.min(a, b);
   public static Calculator min = Math::min;


}
