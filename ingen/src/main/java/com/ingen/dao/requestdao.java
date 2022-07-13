package com.ingen.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingen.entitiy.Employee;

import org.hibernate.Transaction;


public class requestdao {

    private Session session;
    private Transaction transaction;


    private static SessionFactory getsessionFactory(){
        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        return factory;
    }



    private void beginTransaction(){
         this.session = requestdao.getsessionFactory().openSession();

         this.transaction = session.beginTransaction();

    }

    private void endTransaction(){
        transaction.commit();
        session.close();
    }

  

   public void insert(Employee requestdata){
    beginTransaction();
    session.save(requestdata);
    endTransaction();
   }


   public Employee getById(int id) {
    beginTransaction();
    Employee requestdata = session.get(Employee.class, id);
    endTransaction();
    return requestdata;
   }

    
}
