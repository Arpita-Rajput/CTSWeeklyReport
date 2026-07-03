package com.arpita.week1.solid;

public abstract class Bird {
    protected final String name;

    protected Bird(String name) {
        this.name = name;
    }

    public abstract void fly();
}
