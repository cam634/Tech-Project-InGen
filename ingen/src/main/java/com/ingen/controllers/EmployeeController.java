package com.ingen.controllers;

import java.util.List;

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

    public Handler getHelloWorld = ctx -> {
        ctx.result("Hello World!");
        ctx.status(200);
    };

    public Handler getAllEmployees = ctx -> {
        List<Employee> employees = employeeService.servicegetAllEmployees();
        String resultJson = this.gson.toJson(employees);
        ctx.result(resultJson);
        ctx.status(200);
    };
}
