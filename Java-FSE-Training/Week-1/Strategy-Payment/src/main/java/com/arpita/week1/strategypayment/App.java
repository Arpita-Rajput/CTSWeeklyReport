package com.arpita.week1.strategypayment;

public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardStrategy("Arpita Rajput", "1234567812345678"));
        cart.checkout(99.99);

        cart.setPaymentStrategy(new PaypalStrategy("arpita@example.com"));
        cart.checkout(15.50);
    }
}
