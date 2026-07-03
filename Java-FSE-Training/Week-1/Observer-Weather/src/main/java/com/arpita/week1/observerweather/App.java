package com.arpita.week1.observerweather;

public class App {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();
        Display lobby = new Display("LobbyDisplay");
        Display rooftop = new Display("RooftopDisplay");

        station.register(lobby);
        station.register(rooftop);

        station.setMeasurements(25.2, 65.0);
        Thread.sleep(200);
        station.setMeasurements(26.5, 60.5);

        station.unregister(rooftop);
        station.setMeasurements(27.0, 55.0);
    }
}
