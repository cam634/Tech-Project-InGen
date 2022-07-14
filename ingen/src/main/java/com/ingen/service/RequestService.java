package com.ingen.service;

import com.ingen.entitiy.Request;
import com.ingen.repository.RequestdaoInterface;

public class RequestService implements RequestServiceInterface{
    private RequestdaoInterface requestDao;
    public RequestService(RequestServiceInterface requestService){
        this.requestDao = requestDao;
    }
    @Override
    public Boolean serviceCreateNewRequestOverCharacterLimit(Request RequestToCheck){
        if(RequestToCheck.getRequestReason().length() > 500){
            return false;
        } else {
            return true;
        }
    }
}
