package com.company.subset;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private long id;
    private String name;
    private Employee manager;
    private Set<Employee> employees = new HashSet<>();

    public Department(long id, String name) {
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
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Name can't be null!");
        }
        this.name = name;
    }

    private boolean hasDepartmentEmployee(Employee employee){
        if(this.employees.contains(employee)){
            return true;
        }
        return false;
    }

    public void addEmployee(Employee employee){
        if(!hasDepartmentEmployee(employee)){
            this.employees.add(employee);
            employee.addToDepartment(this);
        }
    }

    public void removeEmployee(Employee employee){
        if(hasDepartmentEmployee(employee)){
            this.employees.remove(employee);
            employee.removeFromDepartment(this);
        }
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        if(manager == null){
            removeManager();
        }
        else if(manager == this.manager){
            return;
        }
        if(hasDepartmentEmployee(manager)){
            if(this.manager != null){
                this.manager.stopBeingManagerOfDepartment(this);
            }
            this.manager = manager;
            manager.becomeManagerOfDepartment(this);
        }
        else{
            throw new IllegalArgumentException("This employee isn't in this Department. Can't be a manager");
        }

    }

    public void removeManager(){
        this.manager = null;
    }

    public Set<Employee> getEmployees() {
        Set<Employee> copyOfEmployees = this.employees;
        return copyOfEmployees;
    }

    public String toString(){
        String employee = "Employees: ";
        for(Employee emp : getEmployees()){
            employee+=emp.getName();
        }
        return getId() + " " + getName() + "\n" + employee + "\n" + "Manager: " + getManager();
    }

}
