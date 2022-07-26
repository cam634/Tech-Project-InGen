package com.ingen.repository;

import java.util.List;
import com.ingen.entitiy.Employee;

public interface EmployeeDaoInterface {

    Employee createEmployee(Employee newEmployee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    Employee loginEmployee(Employee employeeToBeLoggedIn);

    boolean deleteEmployee(Employee employeeToBeDeleted);

}
