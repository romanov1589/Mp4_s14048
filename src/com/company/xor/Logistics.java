package com.company.xor;

import java.util.HashSet;
import java.util.Set;

public class Logistics {
    private long id;
    private String name;
    private Set<Employee> employees = new HashSet<>();

    public Logistics(long id, String name) {
        this.id = id;
        this.setName(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null!");
        }
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        if (!this.employees.contains(employee)) {
            this.employees.add(employee);
            employee.addToDepartment(this);
        }
    }

    public void removeEmployee(Employee employee) {
        if (this.employees.contains(employee)) {
            this.employees.remove(employee);
            employee.removeEmployee();
        }
    }

    public Set<Employee> getEmployees() {
        Set<Employee> copyOfEmployees = this.employees;
        return copyOfEmployees;
    }

    public String toString() {
        return getName();
    }
}
