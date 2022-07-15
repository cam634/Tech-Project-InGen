package com.ingen.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;
import com.ingen.repository.RequestdaoInterface;

public class RequestServiceTest {
    public static RequestdaoInterface requestdao;
    public static RequestServiceInterface requestService;
    @BeforeClass
    public static void setup(){
        requestdao = new RequestDao();
        requestService = new RequestService(requestService);
    }
    @Test
    public void checkforcharlimitNegativetest(){

        Request newRequest = new Request("status", 100, "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elem", "Check", "username", "employee");
        boolean result = requestService.serviceCreateNewRequestOverCharacterLimit(newRequest);

        Assert.assertFalse(result);

    }
}
