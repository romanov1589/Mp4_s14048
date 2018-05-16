package com.company.bag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusRoute {
    private Bus bus;
    private Route route;
    private LocalDate arrival;
    private LocalDate departure;
    private static List<BusRoute> busRoutes = new ArrayList<>(); // bug

    public BusRoute(Bus bus, Route route, LocalDate arrival, LocalDate departure) {
        this.setBus(bus);
        this.setRoute(route);
        this.setArrival(arrival);
        this.setDeparture(departure);
        addBusRoutes(this);
    }


    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        if (bus == null) {
            throw new IllegalArgumentException("Please set bus");
        }
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        if (route == null) {
            throw new IllegalArgumentException("Please set route");
        }
        this.route = route;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        if (arrival == null) {
            throw new IllegalArgumentException("Please set arrival date");
        }
        this.arrival = arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        if (departure == null) {
            throw new IllegalArgumentException("Please set departure date");
        }
        this.departure = departure;
    }

    /*
    Extend service
     */
    public static List<BusRoute> getBusRoutes() {
        List<BusRoute> copyOfBusRoutes = busRoutes;
        return copyOfBusRoutes;
    }

    public static void printBusRoutes() {
        for (BusRoute br : getBusRoutes()) {
            System.out.println(br.getRoute() + "->" + br.getBus() + " .Arrival-" + br.getArrival() +
                    " .Departure-" + br.getDeparture() + "\n");
        }

    }

    private static boolean areThere(Bus bus) {
        for (BusRoute busRoute : getBusRoutes()) {
            if (busRoute.getBus() == bus) {
                return true;
            }
        }
        return false;
    }

    private static boolean areThere(Route route) {
        for (BusRoute busRoute : getBusRoutes()) {
            if (busRoute.getRoute() == route) {
                return true;
            }
        }
        return false;
    }

    public static List<BusRoute> find(Bus bus) {
        List<BusRoute> buses = new ArrayList<>();
        for (BusRoute busRoute : getBusRoutes()) {
            if (busRoute.getBus() == bus) {
                buses.add(busRoute);
            }
        }
        return buses;
    }

    public static List<BusRoute> find(Route route) {
        List<BusRoute> routes = new ArrayList<>();
        for (BusRoute busRoute : getBusRoutes()) {
            if (busRoute.getRoute() == route) {
                routes.add(busRoute);
            }
        }
        return routes;
    }

    private static void addBusRoutes(BusRoute busRoute) {
        busRoutes.add(busRoute);
    }

    public static void removeBusRoutes(Bus bus) {
        if (areThere(bus)) {
            for (BusRoute busRoute : find(bus)) {
                busRoutes.remove(busRoute);
            }
        }
    }

    public static void removeBusRoutes(Route route) {
        if (areThere(route)) {
            for (BusRoute busRoute : find(route)) {
                busRoutes.remove(busRoute);
            }
        }
    }


    public String toString() {
        return getBus() + " -> " + getRoute() + ". Arrival-" +
                getArrival() + ". Departure-" + getDeparture();
    }
}
