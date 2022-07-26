package com.ingen.repository;

import java.util.List;


import com.ingen.entitiy.Employee;

public interface EmployeedaoInterface {


    List<Employee> getAllEmployees();


    Employee loginEmployee(Employee employeeToBeLoggedIn);





    
}
