package com.arpita.week1.builderstudent;

public class App {
    public static void main(String[] args) {
        Student student = new Student.Builder()
                .firstName("Arpita")
                .lastName("Rajput")
                .age(25)
                .email("arpita@example.com")
                .build();

        System.out.println(student);
    }
}
