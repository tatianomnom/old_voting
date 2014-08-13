package com.tatianomnom.choozorro.hello;

public class DefaultGreeter implements Greeter {
    public String greet(final String name) {
        return "Hello " + name;
    }
}
