package com.ingen.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ingen.entitiy.Request;

public class RequestTest {
    public static RequestDaoInterface RequestDao;

    @BeforeClass
    public static void setup(){
        RequestDao = new RequestDao();
        Request newRequest = new Request("status", 100, "NA", "Check", "username", "employee");
        RequestDao.createRequest(newRequest);
    }

    @Test
    public void createTestPostiveRequest(){
        RequestDao = new RequestDao();
        Request newRequest = new Request("status", 100, "NA", "Check", "username", "employee");
        RequestDao.createRequest(newRequest);
        Assert.assertNotNull(newRequest.getId());
    }

    @Test
    public void getAllRequestsPositiveTest(){
        List<Request> RequestList = RequestDao.getAllRequests();
        Assert.assertTrue(RequestList.size() >= 1);
    }

    @Test
    public void getRequestByIdPositiveTest(){
        RequestDao = new RequestDao();
        Request newRequest = new Request( "status", 100, "NA", "Check", "username", "employee");
        RequestDao.createRequest(newRequest);
        Request fetchedRequest = RequestDao.getRequestById(newRequest.getId());
        boolean result = newRequest.getId() == fetchedRequest.getId();
        RequestDao.deleteRequest(newRequest.getId());
        Assert.assertTrue(result);
    }

    @Test
    public void deleteRequestPositiveTest(){
        RequestDao = new RequestDao();
        Request newRequest = new Request("status", 100, "NA", "Check", "username", "employee");
        RequestDao.createRequest(newRequest);
        boolean result = RequestDao.deleteRequest(newRequest.getId());
        Assert.assertTrue(result);
    }
    
    @Test
    public void updateRequestPositiveTest(){
        RequestDao = new RequestDao();
        Request newRequest = new Request("status", 100, "NA", "Check", "username", "employee");
        RequestDao.createRequest(newRequest);
        Request updatedRequest = new Request(78,"approved", 100, "NA", "Check", "username", "employee");
        RequestDao.updateRequest(updatedRequest);
        Assert.assertEquals(updatedRequest.getStatus(), "approved");
    }
}
