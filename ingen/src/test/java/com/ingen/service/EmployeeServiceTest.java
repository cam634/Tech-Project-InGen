package com.ingen.service;

import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.EmployeeDaoInterface;

public class EmployeeServiceTest {
    public static EmployeeDaoInterface employeeDao;
    public static EmployeeServiceInterface employeeService;
    public static int employeeIdHolder;
    public static Employee testEmployee = new Employee("EmployeeServiceLayerTester", "password", "Employee", "Test", "Account");

    @BeforeClass
    public static void setup(){
        employeeDao = new EmployeeDao();
        employeeService = new EmployeeService(employeeDao);
        Employee createdEmployee = employeeService.serviceCreateEmployee(testEmployee);
        EmployeeServiceTest.employeeIdHolder = createdEmployee.getId();
        System.out.println("A" + EmployeeServiceTest.employeeIdHolder);
    }

    @Test
    public void checkUsernameUniquenessNegativeTest(){
        try{
            Employee sameNameCreatedEmployee = employeeService.serviceCreateEmployee(testEmployee);
            employeeService.serviceDeleteEmployee(sameNameCreatedEmployee);
            Assert.fail();
        } catch (PersistenceException e){
            Assert.assertEquals("org.hibernate.exception.ConstraintViolationException: could not execute statement", e.getMessage());
        } 
    }

    @AfterClass
    public static void teardown(){
        Employee testEmployeeToBeDeleted = employeeService.serviceGetEmployeeById(EmployeeServiceTest.employeeIdHolder);
        employeeService.serviceDeleteEmployee(testEmployeeToBeDeleted);
    }
    
}
