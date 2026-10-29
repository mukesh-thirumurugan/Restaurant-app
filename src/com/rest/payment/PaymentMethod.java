package com.rest.payment;

public interface PaymentMethod {

    boolean pay(double amount);

    String getPaymentMethodName();
}