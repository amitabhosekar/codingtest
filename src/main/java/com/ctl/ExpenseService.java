package com.ctl;



/**
 * Created by aabhos on 9/30/16.
 */


public class ExpenseService {



    public double getAllocationByManager(Manager manager){
        double allocation = 0;
            allocation += EmployeeType.getAllocation(manager.getEmployeeType());
            for (Employee employee : manager.getEmployeeList()){
                if (EmployeeType.MANAGER.equals(employee.getEmployeeType())){
                    allocation += getAllocationByManager((Manager) employee);
                }else{
                    allocation += EmployeeType.getAllocation(employee.getEmployeeType());
                }
            }

        return allocation;

    }

    public double getAllocationByDepartment(Department department){
        double allocation = 0;
        for(Employee employee : department.getEmployeeList())   {
            allocation += EmployeeType.getAllocation(employee.getEmployeeType());
        }
        return allocation;
    }
}
