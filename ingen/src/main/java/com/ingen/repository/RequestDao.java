package com.ingen.repository;




import java.util.List;

import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;



public class RequestDao implements RequestDaoInterface{

    @Override
    public Request createRequest(Request newRequest) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newRequest);
        HibernateUtil.endTransaction();
        return newRequest;
    }



    @Override
    public List<Request> getAllRequests(){
        HibernateUtil.beginTransaction();
        List<Request> RequestList = HibernateUtil.getSession().createQuery("from Request", Request.class).getResultList();
        HibernateUtil.endTransaction();
        return RequestList;
    }

    @Override
    public Request updateRequest(Request updatedRequest) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedRequest);
        HibernateUtil.endTransaction();
        return updatedRequest;
    }

}

   


    