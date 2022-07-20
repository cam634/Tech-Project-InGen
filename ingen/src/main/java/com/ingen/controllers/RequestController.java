package com.ingen.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;
import com.ingen.service.RequestServiceInterface;
import com.ingen.controllers.RequestController;
import com.ingen.repository.RequestdaoInterface;
import io.javalin.http.Handler;


public class RequestController {
    
    public Handler getHelloWorld = ctx -> {
        ctx.result("Hello World!");
        ctx.status(200);    
    };

    private RequestServiceInterface requestService;
    private Gson gson;

    public RequestController(RequestServiceInterface requestService){
        this.requestService = requestService;
        this.gson = new Gson();
    }

   
    public RequestController() {
    }


    public Handler Request = ctx -> {
        ctx.result("Request");
        ctx.status(200);
    };

    public Handler getAllRequest= ctx -> {
        List<Request> request = this.requestService.serviceGetAllRequests();
        
        String requestJSON = this.gson.toJson(request);
        ctx.result(requestJSON);
        ctx.status(200);
    };

    public Handler deleteRequest = ctx -> {
        // the ctx.body() method creates a java string object from the content of the request body
        String json = ctx.body();
        // we then use Gson to convert the json string into the java class we are working with
        Request requestToDelete = this.gson.fromJson(json, Request.class);
        // we then pass the java object we created into the appropriate service method for validation
        this.requestService.serviceDeleteRequest(requestToDelete);
        // because I am not returning any special entity with this method I will use a Map to create my key/value pair message for the json
        Map<String, String> message = new HashMap<>();
        message.put("message", "request was deleted");
        // once the map is made we convert it into a json
        String messageJson = this.gson.toJson(message);
        // then we attach it to the response body and set the status code
        ctx.result(messageJson);
        ctx.status(203); // will need to double check status code at some point
    };

    public Handler updateRequest = ctx -> {
        try{
            String json = ctx.body();
            Request updatedRequest = this.gson.fromJson(json, Request.class);
            // pass the data into the service layer and get method result back
            Request result = this.requestService.serviceUpdateRequest(updatedRequest);
            // convert the result into a json
            String resultJson = this.gson.toJson(result);
            // set the response body and status code
            ctx.result(resultJson);
            ctx.status(200);
        }catch(Exception e){
           Map<String, String> message = new HashMap<>();
           message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        };

    }


    

    public Handler createRequest = ctx -> {
        try{
            String json = ctx.body();
            Request newRequest = this.gson.fromJson(json, Request.class);
            Request result = this.requestService.serviceCreateRequest(newRequest);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
        }
        }


    }