package com.rest.cli;

import java.util.Scanner;

import com.rest.model.Order;
import com.rest.service.OrderService;

public class OrderCLI {

    private Scanner sc;
    private OrderService orderService;

    public OrderCLI(OrderService orderService) {
        this.sc = new Scanner(System.in);
        this.orderService = orderService;
    }

    public void placeOrder() {

        System.out.println("\n===== PLACE ORDER =====");

        System.out.print("Enter Table ID: ");
        int tableId = sc.nextInt();

        Order order = orderService.createOrder(tableId);

        int choice;

        do {
            System.out.println("\n========== RESTAURANT MENU ==========");
            System.out.println("1. Chicken Biriyani     - Rs.180");
            System.out.println("2. Veg Biriyani         - Rs.120");
            System.out.println("3. Parotta              - Rs.20");
            System.out.println("4. Dosa                 - Rs.50");
            System.out.println("5. Chicken Fried Rice   - Rs.150");
            System.out.println("0. Finish Order");

            System.out.print("Enter Item ID: ");
            choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid Item ID!");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            String itemName = "";
            double price = 0;

            switch (choice) {

                case 1:
                    itemName = "Chicken Biriyani";
                    price = 180;
                    break;

                case 2:
                    itemName = "Veg Biriyani";
                    price = 120;
                    break;

                case 3:
                    itemName = "Parotta";
                    price = 20;
                    break;

                case 4:
                    itemName = "Dosa";
                    price = 50;
                    break;

                case 5:
                    itemName = "Chicken Fried Rice";
                    price = 150;
                    break;
            }

            try {
                orderService.addItemToOrder(
                        order.getOrderId(),
                        choice,
                        itemName,
                        price,
                        quantity
                );

                System.out.println("Item added successfully!");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (true);

        System.out.println("\n========== ORDER SUMMARY ==========");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Table ID: " + order.getTableId());

        System.out.println("-----------------------------------");

        order.getItems().forEach(item -> {
            System.out.println(
                    item.getItemName()
                    + " x " + item.getQuantity()
                    + " = Rs." + item.calculateSubtotal()
            );
        });

        System.out.println("-----------------------------------");
        System.out.println("Total Amount: Rs." +
                orderService.getOrderTotal(order.getOrderId()));

        System.out.println("===================================");
    }
}