package com.ingen.service;

import java.util.ArrayList;
import java.util.List;

import com.ingen.entitiy.Request;
import com.ingen.repository.RequestdaoInterface;

public class RequestService implements RequestServiceInterface{
    private RequestdaoInterface requestDao;
    public RequestService(RequestServiceInterface requestService){
        this.requestDao = requestDao;
    }

    @Override
    public Boolean checkRequestReasonLength(Request RequestToCheck){
        if(RequestToCheck.getRequestReason().length() <= 500){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkValue(Request request){
        if (request.getValue() <= 1000){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Request serviceCreateRequest(Request request){
        if (checkValue(request) && checkRequestReasonLength(request)){
            return this.requestDao.createRequest(request);
        } else {
            return null;
        }
    }

    @Override
    public List<Request> viewAuthorizedRequests(List<Request> requestList, String username){
        List<Request> newRequestList = new ArrayList<Request>();
        for (Request request : requestList){
            if (request.getRequestedBy().equals(username)){
                newRequestList.add(request);	
            }	
        }
        return newRequestList;
    }

    @Override
    public boolean checkReviewReasonLength (Request requestToCheck){
        if (requestToCheck.getReviewReason().length() <= 500){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Request serviceUpdateRequest(Request request){
        if (checkReviewReasonLength(request)){
            return this.requestDao.updateRequest(request);
        } else {
            return null;
        }
    }

}
