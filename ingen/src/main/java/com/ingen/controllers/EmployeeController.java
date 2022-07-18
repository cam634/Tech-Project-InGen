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

    public Handler deleteEmployee = ctx -> {

        try{
        String json = ctx.body();

        Employee employeeToDelete = this.gson.fromJson(json, Employee.class);

        this.employeeService.serviceDeleteEmployee(employeeToDelete);

        Map<String, String> message = new HashMap<>();

        message.put("message", "Employee deleted successfully");

        String resultJson = this.gson.toJson(message);

        ctx.result(resultJson);
        ctx.status(200);
        }catch(Exception e){
            Map<String, String> message = new HashMap<>();

            message.put("message", "Employee not deleted");

            String resultJson = this.gson.toJson(message);

            ctx.result(resultJson);
            ctx.status(200);
        }

    };


    public Handler createEmployee = ctx ->{
        try{
        String json = ctx.body();
        Employee employeeToCreate = this.gson.fromJson(json, Employee.class);
        Employee createdEmployee = this.employeeService.serviceCreateEmployee(employeeToCreate);
        String resultJson = this.gson.toJson(createdEmployee);
        ctx.result(resultJson);
        ctx.status(201);
        }catch(javax.persistence.PersistenceException e){
        Map<String, String> message = new HashMap<>();
        message.put("message", e.getMessage());
        String messageJson = this.gson.toJson(message);
        ctx.result(messageJson);
        ctx.status(201);
    }
    };

    public Handler updateEmployee = ctx -> {
        try{
        String json = ctx.body();
        Employee employeeToUpdate = this.gson.fromJson(json, Employee.class);
        Employee updatedEmployee = this.employeeService.serviceUpadteEmployee(employeeToUpdate);
        String resultJson = this.gson.toJson(updatedEmployee);
        ctx.result(resultJson);
        ctx.status(200);}
        catch(javax.persistence.PersistenceException e){
              Map<String, String> message = new HashMap<>();
              message.put("message", e.getMessage());
              String messageJson = this.gson.toJson(message);
              ctx.result(messageJson);
              ctx.status(400);
        
    };
};

}

    

