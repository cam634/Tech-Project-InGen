package com.ingen.dao;



import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Employee;



public class requestdao {


  
   
   public void insert(Employee requestdata){
    HibernateUtil.beginTransaction();
    HibernateUtil.getSession().save(requestdata);
    HibernateUtil.endTransaction();
   }


    
}
