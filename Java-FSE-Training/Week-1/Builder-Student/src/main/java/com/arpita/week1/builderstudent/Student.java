package com.arpita.week1.builderstudent;

public final class Student {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;

    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Student[firstName=%s, lastName=%s, age=%d, email=%s]", firstName, lastName, age, email);
    }
}
