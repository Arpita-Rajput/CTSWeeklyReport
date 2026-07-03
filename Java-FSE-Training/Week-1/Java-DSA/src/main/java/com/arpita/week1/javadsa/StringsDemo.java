package com.arpita.week1.javadsa;

public class StringsDemo {
    public static void main(String[] args) {
        String s = "hello world";
        System.out.println("Upper: " + s.toUpperCase());
        System.out.println("Reverse: " + new StringBuilder(s).reverse().toString());
    }
}
