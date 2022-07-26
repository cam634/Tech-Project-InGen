package com.ingen;


import com.ingen.Utils.RequestBusinessRules;
import com.ingen.controllers.EmployeeController;
import com.ingen.controllers.RequestController;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.EmployeedaoInterface;
import com.ingen.repository.RequestDao;
import com.ingen.service.EmployeeService;
import com.ingen.service.EmployeeServiceInterface;
import com.ingen.service.RequestService;
import com.ingen.service.RequestServiceInterface;

import io.javalin.Javalin;

public class Main {
    

    public static void main(String[] args) {

        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();

        }).start();

        EmployeedaoInterface employeeDao = new EmployeeDao();
        EmployeeServiceInterface employeeService = new EmployeeService(employeeDao);
        EmployeeController employeeController = new EmployeeController(employeeService);

        app.get("/employee", employeeController.getAllEmployees);

        app.patch("/employee", employeeController.loginEmployee);

        RequestDao requestDao = new RequestDao();
        RequestBusinessRules requestBusinessRules = new RequestBusinessRules();
        RequestServiceInterface requestService = new RequestService(requestDao, requestBusinessRules);
        RequestController requestController = new RequestController(requestService);
        
        app.get("/requests", requestController.getAllRequests);

        app.get("/requests/{username}", requestController.getRequestsByUsername);

        app.post("/request", requestController.createRequest);

        app.patch("/request", requestController.updateRequest);
    }
    
}
