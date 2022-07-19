package com.ingen.service;

import java.util.Iterator;
import java.util.List;

import com.ingen.entitiy.Request;
import com.ingen.exceptions.InvalidRequest;
import com.ingen.repository.RequestDaoInterface;
import com.ingen.Utils.RequestBusinessRules;;

public class RequestService implements RequestServiceInterface{

    private RequestDaoInterface requestDao;
    private RequestBusinessRules businessRules;

    public RequestService(RequestDaoInterface requestDao, RequestBusinessRules businessRules){
        this.requestDao = requestDao;
        this.businessRules = businessRules;
    }

    @Override
    public Request serviceCreateRequest(Request request){
        if (this.businessRules.checkValue(request) && this.businessRules.checkRequestReasonLength(request)){
            return this.requestDao.createRequest(request);
        } else {
            throw new InvalidRequest("Invalid request: please try again");
        }
    }

    @Override
    public Request serviceGetRequestById(int id){
        return this.requestDao.getRequestById(id);
    }

    @Override
    //returns list of requests made by a specific user
    public List<Request> serviceGetSelfRequests(String username){
        List<Request> requestList= this.requestDao.getAllRequests();
        return this.businessRules.getSelfRequests(requestList, username);
    }

    @Override
    //returns list of all requests
    public List<Request> serviceGetAllRequests(){
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

    @Override
    public boolean serviceDeleteRequest(int id){
        return this.requestDao.deleteRequest(id);
    }

    @Override
    //Returns a list of all Pending requests
    public List<Request> getPendingRequests(List<Request> requestList){
        Iterator<Request> itr = requestList.iterator();
        while (itr.hasNext()) {
            Request request = itr.next(); 
            String status = request.getStatus();
            boolean pending = status.equals("Pending");
            if (!pending){
                itr.remove();	
            }	
        }
        return requestList;
    }
    
    @Override
    //Returns total value of all requests approved by the company
    public int getApprovalTotal(List<Request> requestList){
        int total = 0;
        for (Request request : requestList){
            if (request.getStatus().equals("Approved")){
                total += request.getValue();
            }
        }
        return total;
    }
    
    @Override 
    //Returns total value of all request approved by specific user 
    public int getSelfApprovalTotal(List<Request> requestList, String username){
        int total = 0;
        for (Request request : requestList){
            if (request.getStatus().equals("Approved") && request.getReviewedBy().equals(username)){
                total += request.getValue();
            }
        }
        return total;
    }
}
