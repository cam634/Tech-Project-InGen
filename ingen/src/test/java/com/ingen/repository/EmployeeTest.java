package com.ingen.repository;

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
    public void updateEmployeePostive(){
        EmployeeDao = new EmployeeDao();
        Employee updatedEmployee = new Employee(88,"ThisisATest","Test","Test","Test","Test");
        EmployeeDao.updateEmployee(updatedEmployee);
        
        Assert.assertTrue(updatedEmployee.getId() == 88);
    }
    
    
}
