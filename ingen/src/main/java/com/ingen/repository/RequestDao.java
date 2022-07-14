package com.ingen.repository;




import java.util.List;

import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;



public class RequestDao implements RequestdaoInterface{


@Override
   public Request createRequest(Request newIdRequest){
    HibernateUtil.beginTransaction();
    HibernateUtil.getSession().save(newIdRequest);
    HibernateUtil.endTransaction();
    return newIdRequest;
   }

 
@Override
   public List<Request> getallRequest(){
    HibernateUtil.beginTransaction();
    List<Request> RequestList = HibernateUtil.getSession().createQuery("from Request", Request.class).getResultList();
    HibernateUtil.endTransaction();
    return RequestList;
   }
   
}

   


    