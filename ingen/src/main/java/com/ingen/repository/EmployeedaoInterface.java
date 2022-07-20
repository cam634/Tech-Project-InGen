package com.ingen.repository;

import java.util.List;


import com.ingen.entitiy.Employee;

public interface EmployeeDaoInterface {

    public Employee insertEmployee(Employee newEmployee);


    List<Employee> getAllEmployees();

    boolean deleteEmployee(Employee employeeToBeDeleted);

    Employee updateEmployee(Employee updatedEmployee);

    Employee loginEmployee(Employee employeeToBeLoggedIn);





    
}
