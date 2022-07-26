package com.ingen.repository;

import java.util.List;
import com.ingen.entitiy.Request;

public interface RequestDaoInterface {

    Request createRequest(Request newIdRequest);

    List<Request> getAllRequests();

    Request updateRequest(Request updatedRequest);


}
