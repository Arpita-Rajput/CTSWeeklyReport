package com.arpita.week1.strategypayment;

public class PaypalStrategy implements PaymentStrategy {
    private final String email;

    public PaypalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid %.2f using PayPal account %s%n", amount, email);
    }
}
