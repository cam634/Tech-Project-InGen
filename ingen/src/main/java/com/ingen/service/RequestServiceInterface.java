package com.ingen.service;

import java.util.List;

import com.ingen.entitiy.Request;

public interface RequestServiceInterface {
  
    Request serviceCreateRequest(Request request);

    Request serviceGetRequestById(int id);

    List<Request> serviceGetSelfRequests(String username);

    List<Request> serviceGetAllRequests();

    Request serviceUpdateRequest(Request request);

    boolean serviceDeleteRequest(Request requestToBeDeleted);

    List<Request> getPendingRequests(List<Request> requestList);

    int getApprovalTotal(List<Request> requestList);

    int getSelfApprovalTotal(List<Request> requestList, String username);
}
