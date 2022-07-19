package com.ingen.repository;




import java.util.List;

import com.ingen.Utils.HibernateUtil;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;



public class RequestDao implements RequestDaoInterface{

    @Override
    public Request createRequest(Request newIdRequest){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newIdRequest);
        HibernateUtil.endTransaction();
        return newIdRequest;
    }

    @Override
    public Request getRequestById(int id){
        HibernateUtil.beginTransaction();
        Request request = HibernateUtil.getSession().get(Request.class, id);
        HibernateUtil.endTransaction();
        return request;
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

    @Override
    public boolean deleteRequest(int id){
        HibernateUtil.beginTransaction();
        Request request = HibernateUtil.getSession().get(Request.class, id);
        HibernateUtil.getSession().delete(request);
        HibernateUtil.endTransaction();
        return true;
    }
}

   


    