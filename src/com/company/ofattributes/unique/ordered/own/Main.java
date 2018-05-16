package com.company.ofattributes.unique.ordered.own;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(3, "Neoplan", "N116", "WAG00K19FF1003H18", 42, 0);
        Bus bus1 = new Bus(1, "Neoplan", "N1116", "WAG190FF00PP1008F", 43, 255);
        Bus bus2 = new Bus(2, "Setra", "Y115", "WAG1900100PP14581", 62, 300000);
        bus2.setKilometrage(300000);
//        for(Map.Entry<Long, Bus> entry : Bus.getBuses().entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        Bus.removeBusFromExtendList(2);
        Bus.printBusesFromExtend();

    }
}
