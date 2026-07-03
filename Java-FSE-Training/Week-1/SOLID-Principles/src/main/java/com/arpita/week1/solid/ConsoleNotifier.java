package com.arpita.week1.solid;

public class ConsoleNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Notifier: " + message);
    }
}
