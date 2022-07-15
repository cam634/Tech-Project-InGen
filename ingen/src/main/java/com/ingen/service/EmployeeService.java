package com.ingen.service;

import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeedaoInterface;

public class EmployeeService implements EmployeeServiceInterface {

    private EmployeedaoInterface employeeDao;

    public EmployeeService(EmployeedaoInterface employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee serviceinsertEmployee(Employee newEmployee) {
        return employeeDao.insertEmployee(newEmployee);
    }

}
    

