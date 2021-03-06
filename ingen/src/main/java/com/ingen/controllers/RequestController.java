package com.ingen.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.ingen.entitiy.Request;
import com.ingen.exceptions.InvalidRequest;
import com.ingen.service.RequestServiceInterface;
import com.ingen.controllers.RequestController;
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

    public Handler requests = ctx -> {
        ctx.result("requests");
        ctx.status(200);
    };

    public Handler getAllRequests = ctx -> {
        List<Request> requests = this.requestService.serviceGetRequests();
        String requestsJSON = this.gson.toJson(requests);
        ctx.result(requestsJSON);
        ctx.status(200);
    };

    public Handler getRequestsByUsername = ctx -> {
        List<Request> requests = this.requestService.serviceGetRequestsByUsername(ctx.pathParam("username"));
        String requestsJSON = this.gson.toJson(requests);
        ctx.result(requestsJSON);
        ctx.status(200);
    };

    public Handler updateRequest = ctx -> {
        try {
            String json = ctx.body();
            Request updatedRequest = this.gson.fromJson(json, Request.class);
            Request result = this.requestService.serviceUpdateRequest(updatedRequest);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch(Exception e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        };
    };

    public Handler createRequest = ctx -> {
        try{
            String json = ctx.body();
            Request newRequest = this.gson.fromJson(json, Request.class);
            Request result = this.requestService.serviceCreateRequest(newRequest);
            String resultJson = this.gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
        }catch(InvalidRequest e){
            Map<String, String> message = new HashMap<>();
            message.put("message", e.getMessage());
            String messageJson = this.gson.toJson(message);
            ctx.result(messageJson);
            ctx.status(400);
        };
    };

}