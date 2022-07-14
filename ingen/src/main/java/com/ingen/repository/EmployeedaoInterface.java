package com.ingen.repository;

import java.util.List;


import com.ingen.entitiy.Employee;

public interface EmployeedaoInterface {

    public Employee insertEmployee(Employee newEmployee);


    List<Employee> getAllEmployees();

    boolean deleteEmployee(int id);

    Employee updateEmployee(Employee updatedEmployee);





    
}
