package com.ingen.repository;



import org.junit.BeforeClass;

import com.ingen.entitiy.Employee;




public class EmployeeTest {

    public static EmployeeDaoInterface EmployeeDao;

    @BeforeClass
    public static void setup(){
        EmployeeDao = new EmployeeDao();

        Employee setNewEmployee = new Employee("Manager32678","admin","employee","admin","admin");

        EmployeeDao.insertEmployee(setNewEmployee);
    }
   

  

}

