package com.ingen.service;


import java.util.List;
import com.ingen.entitiy.Request;
import com.ingen.exceptions.InvalidRequest;
import com.ingen.repository.RequestDaoInterface;
import com.ingen.Utils.RequestBusinessRules;

public class RequestService implements RequestServiceInterface{

    private RequestDaoInterface requestDao;
    private RequestBusinessRules businessRules ;

    public RequestService(RequestDaoInterface requestDao, RequestBusinessRules businessRules) {
        this.requestDao = requestDao;
        this.businessRules = businessRules;
    }

    @Override
    public Request serviceCreateRequest(Request test){
        if (businessRules.checkValue(test) && businessRules.checkRequestReasonLength(test) && businessRules.checkReviewReasonLength(test)){
            return requestDao.createRequest(test);
        } else {
            throw new InvalidRequest("Invalid request: please try again");
        }
    }

    @Override
    //returns list of requests made by a specific user
    public List<Request> serviceGetRequestsByUsername(String username){
        List<Request> requestList= this.requestDao.getAllRequests();
        return this.businessRules.getSelfRequests(requestList, username);
    }

    @Override
    //returns list of all requests
    public List<Request> serviceGetRequests(){
        return this.requestDao.getAllRequests();
    }

    @Override
    public Request serviceUpdateRequest(Request request){
        if (this.businessRules.checkReviewReasonLength(request)){
            return this.requestDao.updateRequest(request);
        } else {
            throw new InvalidRequest("Invalid request: please try again");
        }
    }
}
