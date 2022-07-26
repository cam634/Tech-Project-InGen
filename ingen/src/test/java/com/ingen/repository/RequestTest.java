package com.ingen.repository;

import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ingen.entitiy.Request;

public class RequestTest {
    public static RequestDaoInterface requestDao;

    @BeforeClass
    public static void setup(){
        requestDao = new RequestDao();
    }

    @Test
    public void createTestPostiveRequest(){
        Request newRequest = new Request("Pending", 100, "NA", "Check", "username", "employee");
        Request createdRequest = requestDao.createRequest(newRequest);
        Assert.assertNotNull(createdRequest);
        requestDao.deleteRequest(createdRequest);
    }

    @Test
    public void getAllRequestsPositiveTest(){
        List<Request> RequestList = requestDao.getAllRequests();
        Assert.assertTrue(RequestList.size() >= 1);
    }

    @Test
    public void getRequestByIdPositiveTest(){
        Request newRequest = new Request("Pending", 100, "NA", "Check", "username", "employee");
        Request createdRequest = requestDao.createRequest(newRequest);
        Request gottenRequest = requestDao.getRequestById(createdRequest.getId());
        Assert.assertEquals(createdRequest.getId(), gottenRequest.getId());
        requestDao.deleteRequest(gottenRequest);
    }

    @Test
    public void updateRequestPositiveTest(){
        Request newRequest = new Request("Pending", 100, "NA", "Check", "username", "employee");
        Request createdRequest = requestDao.createRequest(newRequest);
        Request requestToUpdate = new Request(createdRequest.getId(),"Approved", 100, "NA", "Check", "username", "employee");
        Request updatedRequest = requestDao.updateRequest(requestToUpdate);
        Assert.assertEquals(updatedRequest.getStatus(), "Approved");
        requestDao.deleteRequest(updatedRequest);
    }

    @Test
    public void deleteRequestPositiveTest(){
        Request newRequest = new Request("Pending", 100, "NA", "Check", "username", "employee");
        Request createdRequest = requestDao.createRequest(newRequest);
        requestDao.deleteRequest(createdRequest);
        Assert.assertNull(requestDao.getRequestById(createdRequest.getId()));
    }

}
