package com.company.xor;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Igor Romanov");
        Employee employee1 = new Employee(2, "Jan Kowalski");
        Logistics logistics = new Logistics(1, "Logistics1");
        Logistics logistics1 = new Logistics(2, "Logistics2");
        Management management = new Management(1, "Management1");
        employee.addToDepartment(logistics);
        employee1.addToDepartment(logistics);
        System.out.println(employee);
//        System.out.println(employee1);
//        employee1.removeEmployee();
        System.out.println(employee1);
        management.addEmployee(employee1);
        //employee1.addToDepartment(management);
        System.out.println(employee1);
        System.out.println(logistics.getEmployees());
        System.out.println("=============================================");

        Employee employee2 = new Employee(3, "Ben Affleck", DepartmentType.LOGISTICS,
                3, "Logistics3");
        System.out.println(employee2);
        management.addEmployee(employee2);
        System.out.println(employee2);
        System.out.println(management.getEmployees());
        //System.out.println(employee2.getLogistics());

    }
}
