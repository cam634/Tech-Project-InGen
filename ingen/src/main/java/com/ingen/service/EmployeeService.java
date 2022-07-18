package com.ingen.service;

import java.util.List;

import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeedaoInterface;

public class EmployeeService implements EmployeeServiceInterface {

    private EmployeedaoInterface employeeDao;

    public EmployeeService(EmployeedaoInterface employeedao) {
        this.employeeDao = employeedao;
    }

    @Override
    public Employee serviceCreateEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }
    @Override 
    public List<Employee> servicegetAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    
}
