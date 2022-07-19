package com.ingen;

import com.ingen.entitiy.Employee;
import com.ingen.entitiy.Request;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.RequestDao;
import com.ingen.service.EmployeeService;
import com.ingen.service.EmployeeServiceInterface;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    Request newRequest = new Request("status", 100, "NA", "Check", "username", "employee");
    RequestDao Dao = new RequestDao();
    Dao.createRequest(newRequest);
    System.out.println(Dao.getallRequest());

    EmployeeServiceInterface employeeService = new EmployeeService(new EmployeeDao());
    System.out.println(employeeService.servicegetAllEmployees());

  

    

    


    

    }
}
