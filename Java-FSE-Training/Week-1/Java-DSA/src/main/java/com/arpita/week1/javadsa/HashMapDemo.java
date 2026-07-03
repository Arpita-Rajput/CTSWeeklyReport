package com.arpita.week1.javadsa;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println("Map contains 'one': " + map.get("one"));
    }
}
