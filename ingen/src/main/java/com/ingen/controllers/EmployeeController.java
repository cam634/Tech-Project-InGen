package com.ingen.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.ingen.entitiy.Employee;
import com.ingen.service.EmployeeServiceInterface;

import io.javalin.http.Handler;

public class EmployeeController {
    private EmployeeServiceInterface employeeService;

    private Gson gson;

    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
        this.gson = new Gson();
    }

    public Handler getAllEmployees = ctx -> {
        List<Employee> employees = employeeService.servicegetAllEmployees();
        String resultJson = this.gson.toJson(employees);
        ctx.result(resultJson);
        ctx.status(200);
    };

    



public Handler loginEmployee = ctx -> {

    try{
        String json = ctx.body();
        Employee employeeToUpdate = this.gson.fromJson(json, Employee.class);
        Employee updatedEmployee = this.employeeService.serviceLoginEmployee(employeeToUpdate);
        String resultJson = this.gson.toJson(updatedEmployee);
        ctx.result(resultJson);
        ctx.status(200);}
        catch(Exception e){
              Map<String, String> message = new HashMap<>();
              message.put("message", e.getMessage());
              String messageJson = this.gson.toJson(message);
              ctx.result(messageJson);
              ctx.status(400);
        
    };



};

}

    

