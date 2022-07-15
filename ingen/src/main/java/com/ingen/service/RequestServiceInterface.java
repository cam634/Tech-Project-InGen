package com.ingen.service;

import java.util.List;

import com.ingen.entitiy.Request;

public interface RequestServiceInterface {
    Boolean checkRequestReasonLength(Request RequestToCheck);

    public boolean checkValue(Request request);

    public Request serviceCreateRequest(Request request);

    public List<Request> viewAuthorizedRequests(List<Request> requestList, String username);

    boolean checkReviewReasonLength (Request requestToCheck);

    Request serviceUpdateRequest(Request request);
}
