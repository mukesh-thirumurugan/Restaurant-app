package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.model.MenuItem;

public class menuRepository {

    private final List<MenuItem> menuItems = new ArrayList<>();

    public menuRepository() {
        menuItems.add(new MenuItem(1, "Chicken Biriyani", 180));
        menuItems.add(new MenuItem(2, "Veg Biriyani", 120));
        menuItems.add(new MenuItem(3, "Parotta", 20));
        menuItems.add(new MenuItem(4, "Dosa", 50));
        menuItems.add(new MenuItem(5, "Chicken Fried Rice", 150));
    }

    public List<MenuItem> showMenu() {
        return menuItems;
    }
}