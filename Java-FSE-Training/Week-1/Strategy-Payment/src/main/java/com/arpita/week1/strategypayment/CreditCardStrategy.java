package com.arpita.week1.strategypayment;

public class CreditCardStrategy implements PaymentStrategy {
    private final String name;
    private final String cardNumber;

    public CreditCardStrategy(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paid %.2f using credit card (%s) for %s%n", amount, mask(cardNumber), name);
    }

    private String mask(String card) {
        if (card == null || card.length() < 4) return "****";
        return "****-****-****-" + card.substring(card.length() - 4);
    }
}
