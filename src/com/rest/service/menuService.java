package com.rest.service;

import java.util.List;

import com.rest.model.MenuItem;
import com.rest.repository.menuRepository;

public class menuService {

    private final menuRepository repos;

    public menuService() {
        repos = new menuRepository();
    }

    public List<MenuItem> getAllMenuItems() {
        return repos.showMenu();
    }
}