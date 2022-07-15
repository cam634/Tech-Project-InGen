package com.ingen.repository;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ingen.entitiy.Employee;




public class EmployeeTest {

    public static EmployeedaoInterface EmployeeDao;

    @BeforeClass
    public static void setup(){
        EmployeeDao = new EmployeeDao();

        Employee setNewEmployee = new Employee("Manager39","admin","employee","admin","admin");

        EmployeeDao.insertEmployee(setNewEmployee);
    }
    @Test
    public void createEmployeePostiveTest(){
        Employee setNewEmployee = new Employee("admin34","admin","employee","admin","admin");
        Employee result = EmployeeDao.insertEmployee(setNewEmployee);
       Assert.assertNotNull(result.getId());
    }

    @Test
    public void neagitivetestCreatesameUsername(){
        try {
            Employee setNewEmployee = new Employee("admin","admin","employee","admin","admin");
            EmployeeDao.insertEmployee(setNewEmployee);
        }catch(javax.persistence.PersistenceException e){
            System.out.println(e.getMessage());
    }
}

}

