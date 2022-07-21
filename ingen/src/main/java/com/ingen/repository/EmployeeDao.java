package com.ingen.repository;



import java.util.List;

import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Employee;




public class EmployeeDao implements EmployeeDaoInterface{


   @Override
   public List<Employee> getAllEmployees(){
    HibernateUtil.beginTransaction();
    List<Employee> employeelist = HibernateUtil.getSession().createQuery("from Employee", Employee.class).getResultList();
    HibernateUtil.endTransaction();
    return employeelist;
   }



    @Override
    public Employee loginEmployee(Employee employeeToBeLoggedIn){
        HibernateUtil.beginTransaction();
        Employee employee = (Employee) HibernateUtil.getSession().createQuery("from Employee where username = :username and password = :password", Employee.class).setParameter("username", employeeToBeLoggedIn.getUsername()).setParameter("password", employeeToBeLoggedIn.getPassword()).uniqueResult();
        HibernateUtil.endTransaction();
        return employee;
        
    }

   


    
}
