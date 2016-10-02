package com.ctl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aabhos on 9/30/16.
 */
public class Manager extends Employee {

    public Manager(long employeeId, String firstName, String lastName, EmployeeType employeeType, Department department ){
        super(employeeId, firstName, lastName, employeeType, department);
    }


    private List<Employee> employeeList = new ArrayList<Employee>();

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

}
