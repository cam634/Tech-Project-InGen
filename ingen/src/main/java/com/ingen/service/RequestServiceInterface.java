package com.ingen.service;

import java.util.List;
import com.ingen.entitiy.Request;

public interface RequestServiceInterface {
  
    Request serviceCreateRequest(Request request);

    List<Request> serviceGetRequestsByUsername(String username);

    List<Request> serviceGetRequests();

    Request serviceUpdateRequest(Request request);

}
