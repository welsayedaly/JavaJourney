package com.extra.something.java.features.util;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Number {
    public static boolean isGreaterThan0(Integer i) {
        return i > 0;
    }

    public static boolean isPrime(int i) {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }

    Product getProductName(String name) {
        return null;
    }
}
