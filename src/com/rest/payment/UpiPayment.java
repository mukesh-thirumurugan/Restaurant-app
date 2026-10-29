package com.rest.payment;

public class UpiPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return false;
        }

        System.out.println("Processing UPI payment...");
        System.out.println("UPI payment successful!");
        System.out.println("Amount: Rs." + amount);

        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "UPI";
    }
}