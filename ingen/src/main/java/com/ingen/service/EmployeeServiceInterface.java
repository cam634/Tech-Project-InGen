package com.ingen.service;

import java.util.List;

import com.ingen.entitiy.Employee;


public interface EmployeeServiceInterface {
    
    Employee serviceCreateEmployee(Employee employee);

    List<Employee> servicegetAllEmployees();

    Employee serviceUpadteEmployee(Employee updatedemployee);

    boolean serviceDeleteEmployee(Employee employeeToBeDeled);

    Employee serviceLoginEmployee(Employee employeeToBeLoggedIn);

    Employee serviceUniqueUsername(Employee employeeUsernameToBechecked);

}
