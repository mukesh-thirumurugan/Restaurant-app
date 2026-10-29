package com.rest.service;

import java.util.List;

import com.rest.model.Table;
import com.rest.repository.tableRep;

public class tableService {

    private final tableRep repos;

    public tableService() {
        repos = new tableRep();
    }

    public List<Table> getAll() {
        return repos.show();
    }
}