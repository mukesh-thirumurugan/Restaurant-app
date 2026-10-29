package com.rest.service;

import com.rest.model.Order;
import com.rest.model.OrderItem;
import com.rest.repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepository;
    private int nextOrderId = 101;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(int tableId) {

        Order order = new Order(nextOrderId, tableId);

        nextOrderId++;

        orderRepository.saveOrder(order);

        return order;
    }

    public void addItemToOrder(
            int orderId,
            int menuItemId,
            String itemName,
            double price,
            int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero."
            );
        }

        Order order = orderRepository.getOrderById(orderId);

        if (order == null) {
            throw new IllegalArgumentException(
                    "Order not found."
            );
        }

        OrderItem item = new OrderItem(
                menuItemId,
                itemName,
                price,
                quantity
        );

        order.addItem(item);
    }

    public double getOrderTotal(int orderId) {

        Order order = orderRepository.getOrderById(orderId);

        if (order == null) {
            throw new IllegalArgumentException(
                    "Order not found."
            );
        }

        return order.calculateTotal();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.getOrderById(orderId);
    }
}