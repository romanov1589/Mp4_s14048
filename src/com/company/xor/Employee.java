package com.company.xor;

public class Employee {
    private long id;
    private String name;
    private Logistics logistics;
    private Management management;

    public Employee(long id, String name) {
        this.id = id;
        this.setName(name);
    }

    public Employee(long id, String name, DepartmentType type, long deptId, String deptName) {
        this.id = id;
        this.setName(name);
        if(type == DepartmentType.LOGISTICS){
            this.logistics = new Logistics(deptId, deptName);
            this.logistics.addEmployee(this);
        }
        else if(type == DepartmentType.MANAGEMENT){
            this.management = new Management(deptId, deptName);
            this.management.addEmployee(this);
        }
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
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }
        this.name = name;
    }

    public void addToDepartment(Management management) {
        if (management == null) {
            throw new IllegalArgumentException("Department can't be null");
        }
        if (this.management == management) {
            return;
        }
        this.management = management;
        if (this.logistics != null) {
            getLogistics().removeEmployee(this);
        }
        management.addEmployee(this);

    }

    public void addToDepartment(Logistics logistics) {
        if (logistics == null) {
            throw new IllegalArgumentException("Department can't be null");
        }
        if (this.logistics == logistics) {
            return;
        }
        this.logistics = logistics;
        if (this.management != null) {
            getManagement().removeEmployee(this);
        }
        logistics.addEmployee(this);
    }

    public void removeEmployee() {
        if (this.logistics != null) {
            this.logistics.removeEmployee(this);
            this.logistics = null;
        } else if (this.management != null) {
            this.management.removeEmployee(this);
            this.management = null;
        }
    }

    public Logistics getLogistics() {
        if(this.logistics == null){
            throw new IllegalArgumentException("Not an employee of logistics department");
        }
        return logistics;
    }

    public Management getManagement() {
        if(this.management == null){
            throw new IllegalArgumentException("Not an employee of management department");
        }
        return management;
    }

    public String toString() {
        return getId() + " " + getName() + "\n" + (this.logistics != null ? "Logistics: " + getLogistics() : "none")
                + "\n" + (this.management != null ? "Management: " + getManagement() : "none");
    }

}
