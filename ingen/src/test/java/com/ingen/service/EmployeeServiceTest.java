package com.ingen.service;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.EmployeedaoInterface;

import net.bytebuddy.asm.Advice.Return;

public class EmployeeServiceTest {

    public static EmployeedaoInterface employeedao;

    public static EmployeeServiceInterface employeeService;
    
    @BeforeClass
    public static void setup(){
        employeedao = new EmployeeDao();
        employeeService = new EmployeeService(employeedao);
    }





    @Test
    public void neagitivetestCreatesameUsername(){
        try {
            Employee setNewEmployee = new Employee("admin24356781232","admin","employee","admin","admin");
            employeeService.serviceCreateEmployee(setNewEmployee);
            Employee setduplicateusnernameemployee = new Employee("admin2435678","admin","employee","admin","admin");
            employeeService.serviceCreateEmployee(setduplicateusnernameemployee);
        }catch(javax.persistence.PersistenceException e){
            System.out.println(e.getMessage());
        }
    }


    @Test 
    public void postiveTestCreateUniqueUsername(){
        Employee setNewEmployee = new Employee("232456789076wqeqeew543","admin","employee","admin","admin");
        employeeService.serviceCreateEmployee(setNewEmployee);
    }
}




    

