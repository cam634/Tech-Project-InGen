package com.ingen.repository;

import java.util.List;
import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Employee;

public class EmployeeDao implements EmployeeDaoInterface{

    @Override
    public Employee createEmployee(Employee newEmployee){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newEmployee);
        HibernateUtil.endTransaction();
        return newEmployee;
    }

    @Override
    public List<Employee> getAllEmployees(){
        HibernateUtil.beginTransaction();
        List<Employee> employeeList = HibernateUtil.getSession().createQuery("from Employee", Employee.class).getResultList();
        HibernateUtil.endTransaction();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int employeeId){
        HibernateUtil.beginTransaction();
        Employee employee = HibernateUtil.getSession().get(Employee.class, employeeId);
        HibernateUtil.endTransaction();
        return employee;
    }

    @Override
    public Employee loginEmployee(Employee employeeToBeLoggedIn){
        HibernateUtil.beginTransaction();
        Employee employee = (Employee) HibernateUtil.getSession().createQuery("from Employee where username = :username and password = :password", Employee.class).setParameter("username", employeeToBeLoggedIn.getUsername()).setParameter("password", employeeToBeLoggedIn.getPassword()).uniqueResult();
        HibernateUtil.endTransaction();
        return employee; 
    }

    @Override
    public boolean deleteEmployee(Employee employeeToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(employeeToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

}
