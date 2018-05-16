package com.company.bag;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(1, "Neoplan", "N116");
        Route route = new Route(1, "Warszawa-Odessa");
        Bus bus1 = new Bus(2, "Setra", "AY9010");
        Route route1 = new Route(2, "Gdańsk-Kijów");
        BusRoute busRoute = new BusRoute(bus, route, LocalDate.of(2018, 12, 01),
                LocalDate.of(2018, 12, 02));
        //System.out.println(busRoute);
        BusRoute busRoute1 = new BusRoute(bus, route, LocalDate.of(2018, 01, 10),
                LocalDate.of(2018, 02, 16));
        BusRoute busRoute3 = new BusRoute(bus1, route1, LocalDate.of(2018, 11, 11),
                LocalDate.of(2018, 11, 10));
        BusRoute.printBusRoutes();
//        System.out.println(BusRoute.find(route1));
//        System.out.println(BusRoute.find(bus1));
//        busRoute.setRoute(route1);
        busRoute.setBus(bus1);
//        BusRoute.removeBusRoutes(route);
        bus.addRoute(route1, LocalDate.of(1900, 12, 12),
                LocalDate.of(2000, 11, 11));
        BusRoute.printBusRoutes();
//        System.out.println(route.getBusRoutes());
//        System.out.println(bus.getBusRoutes());
        busRoute.setArrival(LocalDate.of(1567, 11, 11));
        BusRoute.printBusRoutes();


    }
}
