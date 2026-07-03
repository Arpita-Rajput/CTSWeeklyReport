package com.arpita.week1.factorynotification;

public class App {
    public static void main(String[] args) {
        Notification email = NotificationFactory.create("email");
        Notification sms = NotificationFactory.create("sms");

        email.send("user@example.com", "Welcome to Factory Notification System");
        sms.send("+1234567890", "Your OTP is 1234");
    }
}
