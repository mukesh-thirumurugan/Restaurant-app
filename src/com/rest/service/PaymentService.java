package com.rest.service;

import com.rest.model.Order;
import com.rest.model.Payment;

import com.rest.repository.OrderRepository;
import com.rest.repository.PaymentRepository;

import com.rest.payment.PaymentMethod;
import com.rest.payment.CashPayment;
import com.rest.payment.UpiPayment;
import com.rest.payment.CardPayment;

public class PaymentService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    private int nextPaymentId = 1;

    public PaymentService(
            OrderRepository orderRepository,
            PaymentRepository paymentRepository) {

        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(int orderId, String methodName) {

        // Step 1: Validate payment method input
        if (methodName == null) {
            throw new IllegalArgumentException(
                    "Payment method cannot be null!");
        }

        // Step 2: Find the order
        Order order = orderRepository.getOrderById(orderId);

        if (order == null) {
            throw new IllegalArgumentException("Order not found!");
        }

        // Step 3: Check whether order contains items
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException(
                    "Cannot pay for an empty order!");
        }

        // Step 4: Prevent duplicate payment
        for (Payment existingPayment : paymentRepository.getAllPayments()) {

            if (existingPayment.getOrderId() == orderId
                    && existingPayment.getPaymentStatus().equals("PAID")) {

                throw new IllegalArgumentException(
                        "This order is already paid!");
            }
        }

        // Step 5: Calculate total bill
        double amount = order.calculateTotal();

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Invalid order amount!");
        }

        // Step 6: Select payment method
        PaymentMethod paymentMethod;

        switch (methodName) {

            case "Cash":
                paymentMethod = new CashPayment();
                break;

            case "UPI":
                paymentMethod = new UpiPayment();
                break;

            case "Card":
                paymentMethod = new CardPayment();
                break;

            case "Others":
                paymentMethod = null;
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid payment method!");
        }

        // Step 7: Process payment
        boolean success;

        if (paymentMethod != null) {

            success = paymentMethod.pay(amount);

        } else {

            // Simulated payment for Others
            System.out.println("Processing other payment method...");
            System.out.println("Payment successful!");
            System.out.println("Amount: Rs." + amount);

            success = true;
        }

        // Step 8: Save payment only after success
        if (success) {

            Payment payment = new Payment(
                    nextPaymentId,
                    orderId,
                    amount,
                    methodName
            );

            payment.markAsPaid();

            paymentRepository.savePayment(payment);

            nextPaymentId++;

            return payment;
        }

        throw new IllegalArgumentException("Payment failed!");
    }
}