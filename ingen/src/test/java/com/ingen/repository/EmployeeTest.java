package com.ingen.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ingen.entitiy.Employee;

public class EmployeeTest {
    public static EmployeeDaoInterface EmployeeDao;


    @BeforeClass
    public static void setup(){
        EmployeeDao = new EmployeeDao();
    
    }

    @Test
    public void createEmployeePositive(){
        Employee testEmployee = new Employee("EmployeeRepositoryLayerTester", "password", "Employee", "Test", "Account");
        Employee createdEmployee = EmployeeDao.createEmployee(testEmployee);
        Assert.assertNotNull(createdEmployee.getId());
        EmployeeDao.deleteEmployee(createdEmployee);
    }

    @Test
    public void getAllEmployeesPositive(){
        List<Employee> allEmployees = EmployeeDao.getAllEmployees();
        Assert.assertNotNull(allEmployees);
    }

    @Test 
    public void getEmployeeByIdPositive(){
        Employee testEmployee = new Employee("EmployeeRepositoryLayerTester", "password", "Employee", "Test", "Account");
        Employee createdEmployee = EmployeeDao.createEmployee(testEmployee);
        Employee returnedEmployee = EmployeeDao.getEmployeeById(createdEmployee.getId());
        Assert.assertNotNull(returnedEmployee);
        EmployeeDao.deleteEmployee(createdEmployee);
    }

    @Test
    public void loginEmployeePositive(){
        Employee loginEmployee = new Employee("EmployeeRepositoryLayerTester","password");
        EmployeeDao.loginEmployee(loginEmployee);
        Assert.assertNotNull(loginEmployee);
    }
    
    @Test
    public void deleteEmployeePositive(){
        Employee testEmployee = new Employee("EmployeeRepositoryLayerTester", "password", "Employee", "Test", "Account");
        Employee createdEmployee = EmployeeDao.createEmployee(testEmployee);
        EmployeeDao.deleteEmployee(createdEmployee);
        Assert.assertNull(EmployeeDao.getEmployeeById(createdEmployee.getId()));
    }
}
