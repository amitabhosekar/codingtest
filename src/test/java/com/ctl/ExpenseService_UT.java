package com.ctl;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by aabhos on 9/30/16.
 */


public class ExpenseService_UT {


    private ExpenseService expenseService;

    @Before
    public void init(){
        expenseService = new ExpenseService();
    }

    @Test
    public void test_ManagerAllocation_simple(){
        Manager manager = setupManager2();
        Double allocation = expenseService.getAllocationByManager(manager);
        Assert.assertNotNull(allocation);
        Assert.assertEquals(2100D, allocation);

    }

    @Test
    public void test_ManagerAllocation(){
        Manager manager = setupManager1();
        Double allocation = expenseService.getAllocationByManager(manager);
        Assert.assertNotNull(allocation);
        Assert.assertEquals(4900D, allocation);

    }

    @Test
    public void test_AllocationByDepartment_simple(){
        Manager manager = setupManager2();
        Double allocation = expenseService.getAllocationByDepartment(manager.getDepartment());
        Assert.assertNotNull(allocation);
        Assert.assertEquals(2100D, allocation);

    }

    @Test
    public void test_AllocationByDepartment(){
        Manager manager = setupManager1();
        Double allocation = expenseService.getAllocationByDepartment(manager.getDepartment());
        Assert.assertNotNull(allocation);
        Assert.assertEquals(4900D, allocation);

    }

    private Manager setupManager1(){
        Department department = new Department(100,"IT");

        Manager manager1 = createManager(1L, "Joe","Brown", department, EmployeeType.MANAGER);
        Manager manager2 = createManager(2L, "Tim","Brown", department, EmployeeType.MANAGER);
        Manager manager3 = createManager(3L, "Erica","Brown", department, EmployeeType.MANAGER);
        Employee employee1 = createEmployee(10L, "Doe","Meyer", department, EmployeeType.DEVELOPER);
        Employee employee2 = createEmployee(11L, "Jane","Meyer", department, EmployeeType.QATESTER);
        Employee employee3 = createEmployee(10L, "Eric","Hyatt", department, EmployeeType.DEVELOPER);
        Employee employee4 = createEmployee(11L, "Pete","Hyatt", department, EmployeeType.QATESTER);
        Employee employee5 = createEmployee(10L, "Mark","Hyatt", department, EmployeeType.DEVELOPER);

        manager1.addEmployee(manager2);
        manager2.addEmployee(employee1);
        manager2.addEmployee(employee2);
        manager2.addEmployee(manager3);
        manager3.addEmployee(employee3);
        manager3.addEmployee(employee4);
        manager3.addEmployee(employee5);

        return manager1;

    }

    private Manager setupManager2(){
        Department department = new Department(100,"Breeding");

        Manager manager1 = createManager(1L,"Jack","Keller", department, EmployeeType.MANAGER);
        Manager manager2 = createManager(1L,"Jack","Keller", department, EmployeeType.MANAGER);
        manager1.addEmployee(manager2);
        Employee employee1 = createEmployee(100L, "Mary","Ching",department, EmployeeType.QATESTER);
        Employee employee2 = createEmployee(200L, "Karl","Rowe",department, EmployeeType.DEVELOPER);
        manager2.addEmployee(employee1);
        manager2.addEmployee(employee2);
        return manager1;

    }

    private Employee createEmployee(long id, String firstName, String lastName, Department department, EmployeeType employeeType){
        Employee employee = new Employee(id, firstName, lastName, employeeType, department);
        department.addEmployee(employee);
        return employee;
    }

    private Manager createManager(long id, String firstName, String lastName, Department department, EmployeeType employeeType){
        Manager manager = new Manager(id, firstName, lastName, employeeType, department);
        department.addEmployee(manager);
        return manager;
    }
}
