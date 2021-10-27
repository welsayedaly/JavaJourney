package com.extra.something.java.features;

public interface java8Interface {

    // 1. Interface with Static Methods

    static String StaticMethod() {
        return "Static Method Result";
    }

    // 1a. Interface with Default
    default String DefaultMethod() {
        return "DefaultMethod Result" + StaticMethod();
    }

}
