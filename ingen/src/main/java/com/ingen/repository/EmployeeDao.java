package com.ingen.repository;



import java.util.List;

import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Employee;




public class EmployeeDao implements EmployeedaoInterface{


@Override
   public Employee insertEmployee(Employee newEmployee){
    
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newEmployee);
        HibernateUtil.endTransaction();
        return newEmployee ;
    

   }

   @Override
   public List<Employee> getAllEmployees(){
    HibernateUtil.beginTransaction();
    List<Employee> employeelist = HibernateUtil.getSession().createQuery("from Employee", Employee.class).getResultList();
    HibernateUtil.endTransaction();
    return employeelist;
   }
   @Override
   public boolean deleteEmployee(Employee employeeToBeDeleted){
    HibernateUtil.beginTransaction();
    HibernateUtil.getSession().delete(employeeToBeDeleted);
    HibernateUtil.endTransaction();
    return true;
   }
   @Override
    public Employee updateEmployee(Employee updatedEmployee){
     HibernateUtil.beginTransaction();
     HibernateUtil.getSession().update(updatedEmployee);
     HibernateUtil.endTransaction();
     return updatedEmployee;
    }


    @Override
    public Employee loginEmployee(Employee employeeToBeLoggedIn){
        HibernateUtil.beginTransaction();
        Employee employee = (Employee) HibernateUtil.getSession().createQuery("from Employee where username = :username and password = :password", Employee.class).setParameter("username", employeeToBeLoggedIn.getUsername()).setParameter("password", employeeToBeLoggedIn.getPassword()).uniqueResult();
        if(employee != null){
            HibernateUtil.endTransaction();
            return employee;
        }else{
               HibernateUtil.endTransaction();
               return null;
        }
    }

   


    
}
