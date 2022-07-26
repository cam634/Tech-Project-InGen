package com.ingen.service;

import java.util.List;
import com.ingen.entitiy.Employee;
import com.ingen.repository.EmployeeDaoInterface;
import com.ingen.exceptions.Invalid;

public class EmployeeService implements EmployeeServiceInterface {

    private EmployeeDaoInterface employeeDao;

    public EmployeeService(EmployeeDaoInterface employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee serviceCreateEmployee(Employee newEmployee){
        return employeeDao.createEmployee(newEmployee);
    }

    @Override 
    public List<Employee> servicegetAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee serviceGetEmployeeById(int employeeId){
        return employeeDao.getEmployeeById(employeeId);
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

    @Override
    public boolean serviceDeleteEmployee(Employee employeeToBeDeleted){
        return this.employeeDao.deleteEmployee(employeeToBeDeleted);
    }
 
}
