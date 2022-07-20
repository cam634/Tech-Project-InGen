package com.ingen.Utils;

import java.util.Iterator;
import java.util.List;

import com.ingen.entitiy.Request;

public class RequestBusinessRules {

    public boolean checkValue(Request request){
        if (request.getValue() <= 1000){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkRequestReasonLength(Request request){
        if(request.getRequestReason().length() <= 500){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkReviewReasonLength (Request request){
        if (request.getReviewReason().length() <= 500){
            return true;
        } else {
            return false;
        }
    }

    //Returns a list of all requests specific user has made. 
    public List<Request> getSelfRequests(List<Request> requestList, String username){
        Iterator<Request> itr = requestList.iterator();
        while (itr.hasNext()) {
            Request request = itr.next(); 
            if (!(request.getRequestedBy().equals(username))){
                itr.remove();	
            }	
        }
        return requestList;
    }











}
