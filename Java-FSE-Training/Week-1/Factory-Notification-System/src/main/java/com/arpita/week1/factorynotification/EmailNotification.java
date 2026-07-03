package com.arpita.week1.factorynotification;

public class EmailNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.printf("Email sent to %s: %s\n", to, message);
    }
}
