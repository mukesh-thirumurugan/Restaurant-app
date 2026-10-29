package com.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private int tableId;
    private List<OrderItem> items;

    public Order(int orderId, int tableId) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total = total + item.calculateSubtotal();
        }

        return total;
    }
}