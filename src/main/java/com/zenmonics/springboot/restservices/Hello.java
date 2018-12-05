package com.zenmonics.springboot.restservices;

public interface Hello {
    default void hello() {
        System.out.println("Hello");
    }
}
