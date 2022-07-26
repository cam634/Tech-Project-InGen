package com.ingen.service;

import java.util.List;
import com.ingen.entitiy.Employee;

public interface EmployeeServiceInterface {

    Employee serviceCreateEmployee(Employee newEmployee);
    
    List<Employee> servicegetAllEmployees();

    Employee serviceGetEmployeeById(int employeeId);

    Employee serviceLoginEmployee(Employee employeeToBeLoggedIn);

    boolean serviceDeleteEmployee(Employee employeeToBeDeleted);

}
