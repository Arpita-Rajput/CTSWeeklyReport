package com.arpita.week1.singletonlogger;

public class App {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.info("Starting application...");
        logger2.info("Logger instance reused - same instance? " + (logger1 == logger2));
        logger1.error("An example error");
    }
}
