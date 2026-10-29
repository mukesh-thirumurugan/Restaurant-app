package com.rest.cli;

import com.rest.model.Table;
import com.rest.service.tableService;

import java.util.List;
import java.util.Scanner;

public class tableCli {

    private final tableService service;
    private final Scanner sc = new Scanner(System.in);

    public tableCli(tableService service) {
        this.service = service;
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n===== Table Management =====");
            System.out.println("1. All Tables");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    List<Table> tables = service.getAll();

                    System.out.println("\nID\tCapacity\tStatus");

                    for (Table table : tables) {

                        System.out.println(
                            table.getId() + "\t" +
                            table.getCapacity() + "\t\t" +
                            table.getStatus()
                        );

                    }

                    break;

                case 0:

                    System.out.println("Exiting Table Management...");

                    break;

                default:

                    System.out.println("Invalid choice!");

                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}