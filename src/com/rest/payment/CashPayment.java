package com.rest.payment;

public class CashPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return false;
        }

        System.out.println("Cash payment successful!");
        System.out.println("Amount: Rs." + amount);

        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "Cash";
    }
}