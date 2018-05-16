package com.company.ofattributes.unique.ordered.own;

import java.util.*;

public class Bus {
    private long id; // {unique}
    private String type;
    private String model;
    private String VIN; //own constraint. regex
    private int numberOfSeats; // static constraint of attribute
    private int kilometrage; // dynamic constraint of attribute
    private static Set<Long> ids = new TreeSet<>(); // collection for {unique}
    private final static int minNumberOfSeats = 42;
    private final static int maxNumberOfSeats = 64;


    private static Map<Long, Bus> buses = new TreeMap<>(); // extend. {ordered by id}

    public Bus(long id, String type, String model, String VIN, int numberOfSeats, int kilometrage) {
        this.setId(id);
        this.setType(type);
        this.setModel(model);
        this.setVIN(VIN);
        this.setNumberOfSeats(numberOfSeats);
        this.setKilometrage(kilometrage);
        addBusToExtendList(id, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long newId) {
        if (newId <= 0) {
            throw new IllegalArgumentException("Id can't be 0 or less than 0");
        }
        if (!isUnique(newId)) {
            throw new IllegalArgumentException("Id isn't unique!");
        }
        if (ids.contains(this.id)) {
            ids.remove(this.id);
        }
        this.id = newId;
        ids.add(newId);

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

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        if (VIN == null) {
            throw new IllegalArgumentException("VIN can't be null");
        }
        if (!VIN.matches("^[A-Z]{3}[A-Z0-9]{14}$")) {
            throw new IllegalArgumentException("VIN should be 17 characters");
        }
        this.VIN = VIN;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats < minNumberOfSeats) {
            throw new IllegalArgumentException("You should provide seats equals or more than " + minNumberOfSeats);
        }
        if (numberOfSeats > maxNumberOfSeats) {
            throw new IllegalArgumentException("You should provide seats equals or less than " + maxNumberOfSeats);
        }
        this.numberOfSeats = numberOfSeats;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        if (kilometrage < this.kilometrage) {
            throw new IllegalArgumentException("Mileage can't decrease");
        }
        this.kilometrage = kilometrage;
    }

    public boolean isUnique(long id) {
        if (ids.contains(id)) {
            return false;
        }
        return true;
    }

    public static void printBusesFromExtend() {
        for (Map.Entry<Long, Bus> entry : getBuses().entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    public static void addBusToExtendList(Long key, Bus bus) {
        buses.put(key, bus);
    }

    public static void removeBusFromExtendList(long id) {
        buses.remove(id);

    }

    public static Bus findBusById(long id) {
        for (Map.Entry<Long, Bus> entry : getBuses().entrySet()) {
            if (entry.getValue().getId() == id) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static int getMinNumberOfSeats() {
        return minNumberOfSeats;
    }

    public static int getMaxNumberOfSeats() {
        return maxNumberOfSeats;
    }

    public static Set<Long> getIds() {
        Set<Long> copyIds = ids;
        return copyIds;
    }

    public static Map<Long, Bus> getBuses() {
        Map<Long, Bus> copyOfBuses = buses;
        return copyOfBuses;
    }

    public String toString() {
        return getModel() + " " + getType() + " " + getNumberOfSeats();
    }

}
