package com.rest.cli;

import java.util.Scanner;

import com.rest.model.Payment;
import com.rest.service.PaymentService;

public class PaymentCLI {

    private Scanner sc;
    private PaymentService paymentService;

    public PaymentCLI(PaymentService paymentService, Scanner sc) {
        this.paymentService = paymentService;
        this.sc = sc;
    }

    public void makePayment() {

        System.out.println("\n========== PAYMENT ==========");

        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. Card");
        System.out.println("4. Others");
        System.out.println("0. Cancel Payment");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 0) {
            System.out.println("Payment cancelled.");
            return;
        }

        String paymentMethod;

        switch (choice) {

            case 1:
                paymentMethod = "Cash";
                break;

            case 2:
                paymentMethod = "UPI";
                break;

            case 3:
                paymentMethod = "Card";
                break;

            case 4:
                paymentMethod = "Others";
                break;

            default:
                System.out.println("Invalid payment option!");
                return;
        }

        try {

            Payment payment =
                    paymentService.makePayment(orderId, paymentMethod);

            System.out.println("\n======= PAYMENT RECEIPT =======");
            System.out.println("Payment ID: " + payment.getPaymentId());
            System.out.println("Order ID: " + payment.getOrderId());
            System.out.println("Payment Method: "
                    + payment.getPaymentMethod());

            System.out.printf(
                    "Amount Paid: Rs.%.2f%n",
                    payment.getAmount()
            );

            System.out.println("Payment Status: "
                    + payment.getPaymentStatus());

            System.out.println("===============================");

        } catch (IllegalArgumentException e) {

            System.out.println("Payment Failed: " + e.getMessage());
        }
    }
}