package com.ingen.service;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.ingen.Utils.RequestBusinessRules;
import com.ingen.exceptions.InvalidRequest;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;
import com.ingen.repository.RequestDaoInterface;

public class RequestServiceTest {
    public static RequestDaoInterface requestDao;
    public static RequestServiceInterface requestService;
    public static RequestBusinessRules businessRules;

    public static RequestDaoInterface mockDao;
    public static RequestServiceInterface mockService;
    public static RequestBusinessRules mockRules;

    @BeforeClass
    public static void setup(){
       
        businessRules = new RequestBusinessRules();
    
        mockDao = Mockito.mock(RequestDao.class); 
        mockRules = Mockito.mock(RequestBusinessRules.class); 
        mockService = new RequestService(mockDao, mockRules);
    }

    @Test
    public void checkRequestReasonLimitNegativeTest(){
        Request newRequest = new Request("status", 100, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "Check", "username", "employee");
        boolean result = businessRules.checkRequestReasonLength(newRequest);
        Assert.assertFalse(result);
    }

    @Test
    public void checkRequestReasonLimitPositiveTest(){
        Request newRequest = new Request("status", 100, "Lorem ipsum", "Check", "username", "employee");
        boolean result = businessRules.checkRequestReasonLength(newRequest);
        Assert.assertTrue(result);
    }

    @Test
    public void checkForValueLimitNegativeTest(){
        Request newRequest = new Request("status", 1001, "Lorem ipsum", "Check", "username", "employee");
        boolean result = businessRules.checkValue(newRequest);
        Assert.assertFalse(result);
    }

    @Test
    public void checkForValueLimitPositiveTest(){
        Request newRequest = new Request("status", 100, "Lorem ipsum", "Check", "username", "employee");
        boolean result = businessRules.checkValue(newRequest);
        Assert.assertTrue(result);
    }

    @Test
    public void checkReviewReasonLimitNegativeTest(){
        Request newRequest = new Request("status", 100, "check", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "username", "employee");
        boolean result = businessRules.checkReviewReasonLength(newRequest);
        Assert.assertFalse(result);
    }

    @Test
    public void checkReviewReasonLimitPositiveTest(){
        Request newRequest = new Request("status", 100, "", "Lorem ipsum", "username", "employee");
        boolean result = businessRules.checkReviewReasonLength(newRequest);
        Assert.assertTrue(result);
    }

    @Test
    public void getSelfRequestsPositiveTest(){
        Request user1Request = new Request("status", 100, "", "Lorem ipsum", "user1", "employee");
        Request user2Request = new Request("status", 100, "", "Lorem ipsum", "user2", "employee");
        List<Request> requestList = new ArrayList<Request>();
        requestList.add(user1Request);
        requestList.add(user2Request);
        requestList = businessRules.getSelfRequests(requestList, "user1");
        boolean result = false;
        if (requestList.contains(user1Request)){
            result = true;
        }
        Assert.assertTrue(result);
    }

    @Test
    public void getSelfRequestsNegativeTest(){
        Request user1Request = new Request("status", 100, "", "Lorem ipsum", "user1", "employee");
        Request user2Request = new Request("status", 100, "", "Lorem ipsum", "user2", "employee");
        List<Request> requestList = new ArrayList<Request>();
        requestList.add(user1Request);
        requestList.add(user2Request);
        requestList = businessRules.getSelfRequests(requestList, "user2");
        boolean result = false;
        if (requestList.contains(user1Request) && !(requestList.contains(user2Request))){
            result = true;
        }
        Assert.assertFalse(result);
    }

    @Test 
    public void mockCreateRequestNegativeRequestReason(){
        try{
            Request badRequest = new Request("status", 100, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "Check", "username", "employee");
            Mockito.when(mockRules.checkRequestReasonLength(badRequest)).thenReturn(false);
            Mockito.when(mockRules.checkReviewReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkValue(badRequest)).thenReturn(true);
            mockService.serviceCreateRequest(badRequest);
            Assert.fail();
        } catch (InvalidRequest e) {
            Assert.assertEquals("Invalid request: please try again", e.getMessage());
        }
    }

    @Test 
    public void mockCreateRequestNegativeValue(){
        try{
            Request badRequest = new Request("status", 10000, "Check", "Check", "username", "employee");
            Mockito.when(mockRules.checkRequestReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkReviewReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkValue(badRequest)).thenReturn(false);
            mockService.serviceCreateRequest(badRequest);
            Assert.fail();
        } catch (InvalidRequest e) {            
            Assert.assertEquals("Invalid request: please try again", e.getMessage());

        }
    }

    @Test 
    public void mockCreateRequestNegativeReviewReason(){
    try{
            Request badRequest = new Request("status", 100, "check", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "username", "employee");
            Mockito.when(mockRules.checkRequestReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkReviewReasonLength(badRequest)).thenReturn(false);
            Mockito.when(mockRules.checkValue(badRequest)).thenReturn(true);
            mockService.serviceCreateRequest(badRequest);
            Assert.fail();
        } catch (InvalidRequest e) {
            Assert.assertEquals("Invalid request: please try again", e.getMessage());
        }
    }

    @Test 
    public void mockUpdateRequestNegativeRequestReason(){
    try{
            Request badRequest = new Request("status", 100, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "Check", "username", "employee");
            Mockito.when(mockRules.checkRequestReasonLength(badRequest)).thenReturn(false);
            Mockito.when(mockRules.checkReviewReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkValue(badRequest)).thenReturn(true);
            mockService.serviceUpdateRequest(badRequest);
            Assert.fail();
        } catch (InvalidRequest e) {
            Assert.assertEquals("Invalid request: please try again", e.getMessage());
        }
    }

    @Test 
    public void mockUpdateRequestNegativeValue(){
    try{
            Request badRequest = new Request("status", 10000, "Check", "Check", "username", "employee");
            Mockito.when(mockRules.checkRequestReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkReviewReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkValue(badRequest)).thenReturn(false);
            mockService.serviceUpdateRequest(badRequest);
            Assert.fail();
        } catch (InvalidRequest e) {
            Assert.assertEquals("Invalid request: please try again", e.getMessage());
        }
    }

    @Test 
    public void mockUpdateRequestNegativeReviewReason(){
    try{
            Request badRequest = new Request("status", 100, "check", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "username", "employee");
            Mockito.when(mockRules.checkRequestReasonLength(badRequest)).thenReturn(true);
            Mockito.when(mockRules.checkReviewReasonLength(badRequest)).thenReturn(false);
            Mockito.when(mockRules.checkValue(badRequest)).thenReturn(true);
            mockService.serviceUpdateRequest(badRequest);
            Assert.fail();
        } catch (InvalidRequest e) {
            Assert.assertEquals("", e.getMessage());
        }
    }
}
