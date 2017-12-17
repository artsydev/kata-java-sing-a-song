package com.github.artsydev;


public class Animal {

    private final String name;
    private final String behavior;

    public Animal(String name, String behavior) {
        this.name = name;
        this.behavior = behavior;
    }

    public String getName() {
        return name;
    }

    public String getBehavior() {
        return behavior;
    }
}
