package com.arpita.week1.factorynotification;

public class SMSNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.printf("SMS sent to %s: %s\n", to, message);
    }
}
