package com.company.bag;

import java.time.LocalDate;
import java.util.List;

public class Route {
    private long id;
    private String name;

    public Route(long id, String name) {
        this.id = id;
        this.setName(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null!");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBus(Bus bus, LocalDate arrival, LocalDate departure) {
        new BusRoute(bus, this, arrival, departure);
    }

    public List<BusRoute> getBusRoutes() {
        return BusRoute.find(this);
    }

    public String toString() {
        return getName();
    }
}
