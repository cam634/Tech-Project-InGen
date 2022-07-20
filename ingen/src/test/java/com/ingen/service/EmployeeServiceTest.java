package com.ingen.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ingen.entitiy.Employee;
import com.ingen.exceptions.Invalid;
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
            Employee setduplicateusnernameemployee = new Employee("Test","admin","employee","admin","admin");
            employeeService.serviceUniqueUsername(setduplicateusnernameemployee);
            Assert.fail();
        }catch(Invalid e){            
            Assert.assertEquals("Username already exists", e.getMessage());

        }
    }


    @Test 
    public void postiveTestCreateUniqueUsername(){
        
            Employee setduplicateusnernameemployee = new Employee("CameronHauser2640","admin","employee","admin","admin");
            employeeService.serviceUniqueUsername(setduplicateusnernameemployee);
            Assert.assertEquals("CameronHauser2640", setduplicateusnernameemployee.getUsername());
     
    }
}




    

