package com.rest.model;

public class OrderItem {

    private int menuItemId;
    private String itemName;
    private double price;
    private int quantity;

    public OrderItem(int menuItemId, String itemName, double price, int quantity) {
        this.menuItemId = menuItemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateSubtotal() {
        return price * quantity;
    }
}