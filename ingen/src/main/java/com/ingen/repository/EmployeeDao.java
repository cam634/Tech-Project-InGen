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
    return newEmployee;
   }

   @Override
   public List<Employee> getAllEmployees(){
    HibernateUtil.beginTransaction();
    List<Employee> employeelist = HibernateUtil.getSession().createQuery("from Employee", Employee.class).getResultList();
    HibernateUtil.endTransaction();
    return employeelist;
   }
   @Override
   public boolean deleteEmployee(int id){
    HibernateUtil.beginTransaction();
    Employee employee = HibernateUtil.getSession().get(Employee.class, id);
    HibernateUtil.getSession().delete(employee);
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

   


    
}
