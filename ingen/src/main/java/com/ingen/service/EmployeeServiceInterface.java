package com.ingen.service;

import java.util.List;

import com.ingen.entitiy.Employee;


public interface EmployeeServiceInterface {
    

    List<Employee> servicegetAllEmployees();


    Employee serviceLoginEmployee(Employee employeeToBeLoggedIn);


}
