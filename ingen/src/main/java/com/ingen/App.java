package com.ingen;

import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeeDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Employee user = new Employee("new15","admin","employee","admin","admin");

       EmployeeDao dao = new EmployeeDao();

        dao.insertEmployee(user);
       System.out.println(dao.getAllEmployees());

    }
}
