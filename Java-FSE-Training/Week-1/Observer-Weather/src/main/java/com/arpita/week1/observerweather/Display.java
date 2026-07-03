package com.arpita.week1.observerweather;

public class Display implements Observer {
    private final String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(double temperature, double humidity) {
        System.out.printf("%s - Current conditions: temperature=%.2f°C, humidity=%.2f%%%n", name, temperature, humidity);
    }
}
