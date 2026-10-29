package com.rest;

import java.util.Scanner;

import com.rest.cli.OrderCLI;
import com.rest.cli.PaymentCLI;

import com.rest.repository.OrderRepository;
import com.rest.repository.PaymentRepository;

import com.rest.service.OrderService;
import com.rest.service.PaymentService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Order objects
        OrderRepository orderRepository = new OrderRepository();

        OrderService orderService =
                new OrderService(orderRepository);

        OrderCLI orderCLI = new OrderCLI(orderService);

        // Payment objects
        PaymentRepository paymentRepository =
                new PaymentRepository();

        PaymentService paymentService =
                new PaymentService(
                        orderRepository,
                        paymentRepository
                );

        PaymentCLI paymentCLI =
                new PaymentCLI(paymentService, sc);

        int choice;

        do {

            System.out.println("\n===== RESTAURANT MANAGEMENT =====");
            System.out.println("1. Manage Tables");
            System.out.println("2. View Restaurant Menu");
            System.out.println("3. Place Order");
            System.out.println("4. Make Payment");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(
                            "Table Management integration pending."
                    );
                    break;

                case 2:
                    System.out.println(
                            "Menu display integration pending."
                    );
                    break;

                case 3:
                    orderCLI.placeOrder();
                    break;

                case 4:
                    paymentCLI.makePayment();
                    break;

                case 0:
                    System.out.println(
                            "Exiting Restaurant Management..."
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}