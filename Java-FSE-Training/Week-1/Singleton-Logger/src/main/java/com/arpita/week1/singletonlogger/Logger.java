package com.arpita.week1.singletonlogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Logger {
    private static volatile Logger instance;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void info(String message) {
        System.out.println(format("INFO", message));
    }

    public void error(String message) {
        System.err.println(format("ERROR", message));
    }

    private String format(String level, String message) {
        return String.format("%s [%s] %s", LocalDateTime.now().format(formatter), level, message);
    }
}
