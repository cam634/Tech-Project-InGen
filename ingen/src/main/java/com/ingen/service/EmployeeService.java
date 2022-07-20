package com.ingen.service;

import java.util.List;

import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeeDaoInterface;
import com.ingen.exceptions.Invalid;


public class EmployeeService implements EmployeeServiceInterface {

    private EmployeeDaoInterface employeeDao;

    public EmployeeService(EmployeeDaoInterface employeedao) {
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

    @Override   
    public Employee serviceUpadteEmployee(Employee updatedemployee) {
        return employeeDao.updateEmployee(updatedemployee);
    }

    @Override
    public boolean serviceDeleteEmployee(Employee employeeToBeDeled){
        return employeeDao.deleteEmployee(employeeToBeDeled);
    }

    @Override
    public Employee serviceLoginEmployee(Employee employeeToBeLoggedIn){ 

        Employee result = employeeDao.loginEmployee(employeeToBeLoggedIn);
        if(result != null){
            return result;
        }else{
            throw new Invalid("Invalid username or password");
        }
    };
}
