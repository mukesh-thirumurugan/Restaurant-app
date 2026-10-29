package com.rest.model;

public class Table {

    public enum Availability {
        OCCUPIED, FREE
    }

    private int id;
    private int capacity;
    private Availability status;

    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.status = Availability.FREE;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public Availability getStatus() {
        return status;
    }

    public void booking() {

        if (status == Availability.FREE) {

            status = Availability.OCCUPIED;
            System.out.println("Table booked successfully!");

        } else {

            System.out.println("Table is already occupied!");

        }
    }

    public void free() {
        status = Availability.FREE;
    }
}