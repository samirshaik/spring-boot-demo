package com.zenmonics.springboot.restservices;

public class HelloImpl implements Hello {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        hello.hello();
    }
}
