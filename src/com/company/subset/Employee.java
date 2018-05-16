package com.company.subset;

import java.util.HashSet;
import java.util.Set;

public class Employee {
    private long id;
    private String name;
    private Set<Department> employeeOfDepartments = new HashSet<>();
    private Set<Department> managerOfDepartments = new HashSet<>();

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
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
            throw new IllegalArgumentException("Name can't be null");
        }
        this.name = name;
    }

    private boolean isEmployeeInDepartment(Department department){
        if(this.employeeOfDepartments.contains(department)){
            return true;
        }
        return false;
    }

    public void addToDepartment(Department department){
        if(!isEmployeeInDepartment(department)){
            this.employeeOfDepartments.add(department);
            department.addEmployee(this);
        }
    }

    public void removeFromDepartment(Department department){
        if(isEmployeeInDepartment(department)){
            this.employeeOfDepartments.remove(department);
            department.removeEmployee(this);
        }
    }

    private boolean isManagerInDepartment(Department department){
        if(this.managerOfDepartments.contains(department)){
            return true;
        }
        return false;
    }

    public void becomeManagerOfDepartment(Department department){
        if(isEmployeeInDepartment(department)){
            if(!isManagerInDepartment(department)) {
                this.managerOfDepartments.add(department);
                department.setManager(this);
            }
        }else{
            throw new IllegalArgumentException("This person can't become a manager of this department, because he's " +
                    "not departments' employee");
        }
    }

    public void stopBeingManagerOfDepartment(Department department){
        if(isManagerInDepartment(department)){
            this.managerOfDepartments.remove(department);
            department.removeManager();
        }
    }



    public Set<Department> getEmployeeOfDepartments() {
        Set<Department> copyOfDepartments = this.employeeOfDepartments;
        return copyOfDepartments;
    }

    public Set<Department> getManagerOfDepartments() {
        Set<Department> copyOfManagerOfDepartments = this.managerOfDepartments;
        return copyOfManagerOfDepartments;
    }

    public String toString(){
        String department = "Departments: ";
        for(Department dept : getEmployeeOfDepartments()){
            department+=dept.getName();
        }
        String department1 = "Manager departments: ";
        for(Department dept : getManagerOfDepartments()){
            department1+=dept.getName();
        }
        return getId() + " " + getName() + "\n" + department + "\n" + department1;
    }

}
