package com.arpita.week1.solid;

public class NotificationSender {
    private final Notifier notifier;

    public NotificationSender(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.notify(message);
    }
}
