package com.ingen;

import com.ingen.dao.requestdao;
import com.ingen.entitiy.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Employee user = new Employee("admin","admin","Manager","admin","admin");

       requestdao dao = new requestdao();

       dao.insert(user);

    }
}
