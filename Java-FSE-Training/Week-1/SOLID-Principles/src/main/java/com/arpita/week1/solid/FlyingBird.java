package com.arpita.week1.solid;

public class FlyingBird extends Bird {
    public FlyingBird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
}
