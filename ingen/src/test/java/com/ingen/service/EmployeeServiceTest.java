package com.ingen.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.EmployeeDaoInterface;

public class EmployeeServiceTest {

    public static EmployeeDaoInterface employeedao;

    public static EmployeeServiceInterface employeeService;
    
    @BeforeClass
    public static void setup(){
        employeedao = new EmployeeDao();
        employeeService = new EmployeeService(employeedao);
    }





    @Test
    public void neagitivetestCreatesameUsername(){
         ;
        try {
            Employee setNewEmployee = new Employee("admin24356781232","admin","employee","admin","admin");
            employeeService.serviceCreateEmployee(setNewEmployee);
            Employee setduplicateusnernameemployee = new Employee("admin2435678","admin","employee","admin","admin");
            employeeService.serviceCreateEmployee(setduplicateusnernameemployee);
            Assert.fail();
        }catch(javax.persistence.PersistenceException e){
        }
    }


    @Test 
    public void postiveTestCreateUniqueUsername(){
        Employee setNewEmployee = new Employee("4564789","admin","employee","admin","admin");
        employeeService.serviceCreateEmployee(setNewEmployee);
    }
}




    

