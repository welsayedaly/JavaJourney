package com.extra.something.java.features;

import com.extra.something.java.features.util.Number;
import com.extra.something.java.features.util.Product;
import com.extra.something.java.features.util.ProductFunctionalInterface;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8 {

    public static void main(String[] args) {

        //1. Interface Default and Static Methods
        System.out.println(java8Interface.StaticMethod());

        IntStream someInts = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        // 2. Reference to Static Method
        List<Integer> primes = someInts.filter(Number::isPrime)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(primes);


        // 1a. Reference to Constructor
        ProductFunctionalInterface productFunctionalInterface = Product::new;
        System.out.println(productFunctionalInterface.getFIProductName("Kitchen").getProductName());

        Function<String, Product> productFunction = Product::new;
        System.out.println(productFunction.apply("TV").getProductName());

        // 2. Optional
        String test = null;
        Optional<String> finallyAdoptedTheNPEWithOptional = Optional.ofNullable(test);

        System.out.println(finallyAdoptedTheNPEWithOptional.isPresent());

    }

}


