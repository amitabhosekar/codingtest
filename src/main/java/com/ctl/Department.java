package com.ctl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aabhos on 9/30/16.
 */
public class Department {

    private int id;

    private String name;

    public Department(){
        super();
    }

    public Department(int id, String name){
        this.id = id;
        this.name = name;
    }

    private List<Employee> employeeList = new ArrayList<Employee>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

}
