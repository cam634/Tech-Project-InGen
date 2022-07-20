package com.ingen.repository;

import java.util.List;
import com.ingen.entitiy.Request;

public interface RequestDaoInterface {

    Request createRequest(Request newIdRequest);

    Request getRequestById(int id);

    List<Request> getAllRequests();

    Request updateRequest(Request updatedRequest);

    boolean deleteRequest(Request requestToBeDeleted);

}
