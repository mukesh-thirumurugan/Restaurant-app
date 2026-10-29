package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.model.Payment;

public class PaymentRepository {

    private List<Payment> payments = new ArrayList<>();

    public void savePayment(Payment payment) {
        payments.add(payment);
    }

    public Payment getPaymentById(int paymentId) {

        for (Payment payment : payments) {

            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }

        return null;
    }

    public List<Payment> getAllPayments() {
        return payments;
    }
}