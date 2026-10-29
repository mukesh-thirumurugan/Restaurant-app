package com.rest.payment;

public class CardPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return false;
        }

        System.out.println("Processing Card payment...");
        System.out.println("Card payment successful!");
        System.out.println("Amount: Rs." + amount);

        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "Card";
    }
}