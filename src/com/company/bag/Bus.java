package com.company.bag;

import java.time.LocalDate;
import java.util.List;

public class Bus {
    private long id;
    private String type;
    private String model;

    public Bus(long id, String type, String model) {
        this.id = id;
        this.setType(type);
        this.setModel(model);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type can't be null!");
        }
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null) {
            throw new IllegalArgumentException("Model can't be null!");
        }
        this.model = model;
    }

    public void addRoute(Route route, LocalDate arrival, LocalDate departure) {
        new BusRoute(this, route, arrival, departure);
    }

    public List<BusRoute> getBusRoutes() {
        return BusRoute.find(this);
    }

    public String toString() {
        return getType() + " " + getModel();
    }
}
