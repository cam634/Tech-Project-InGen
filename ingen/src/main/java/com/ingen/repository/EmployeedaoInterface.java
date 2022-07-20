package com.ingen.repository;

import java.util.List;


import com.ingen.entitiy.Employee;

public interface EmployeeDaoInterface {


    List<Employee> getAllEmployees();


    Employee loginEmployee(Employee employeeToBeLoggedIn);





    
}
