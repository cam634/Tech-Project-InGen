package com.ingen;

import com.ingen.Utils.RequestBusinessRules;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;
import com.ingen.service.RequestService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


    Request newRequest = new Request("status", 100, "Lorem ipsum", "Check", "username", "employee");
    RequestDao Dao = new RequestDao();

    RequestBusinessRules buisnessrules = new RequestBusinessRules(); 
    RequestService newrequest = new RequestService(Dao ,buisnessrules);
   

    newrequest.serviceCreateRequest(newRequest);

    

  

    

    


    

    }
}
