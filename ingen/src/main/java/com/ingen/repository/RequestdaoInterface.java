package com.ingen.repository;

import java.util.List;

import com.ingen.entitiy.Request;
public interface RequestdaoInterface {

Request createRequest(Request newIdRequest);

List<Request> getallRequest();

Request updateRequest(Request updatedRequest);


}