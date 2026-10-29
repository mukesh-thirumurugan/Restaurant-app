package com.rest.repository;

import java.util.ArrayList;
import java.util.List;

import com.rest.model.Table;

public class tableRep {

    private final List<Table> tables = new ArrayList<>();

    public tableRep() {

        tables.add(new Table(1, 5));
        tables.add(new Table(2, 4));
        tables.add(new Table(3, 3));

    }

    public List<Table> show() {
        return tables;
    }
}