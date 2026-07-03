package com.arpita.week1.solid;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String content) {
        System.out.println("Printing to console: " + content);
    }
}
