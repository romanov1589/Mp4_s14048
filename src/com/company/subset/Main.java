package com.company.subset;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Igor Romanov");
        Department department = new Department(1, "Logistics");
        Employee employee1 = new Employee(2,"Jan Kowalski");
        employee.addToDepartment(department);
        department.addEmployee(employee1);
        //System.out.println(employee);
        System.out.println(department);
        System.out.println("==========================");
        //department.setManager(employee);
        //employee.becomeManagerOfDepartment(department);
        department.setManager(employee);
        System.out.println(department);
        System.out.println("===========================");
        department.setManager(employee1);
        employee.stopBeingManagerOfDepartment(department);
        System.out.println(department);
//        System.out.println(department;



    }
}
