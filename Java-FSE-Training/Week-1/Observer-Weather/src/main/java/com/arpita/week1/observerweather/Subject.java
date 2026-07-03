package com.arpita.week1.observerweather;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
