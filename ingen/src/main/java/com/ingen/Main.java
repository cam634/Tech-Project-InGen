package com.ingen;


import com.ingen.controllers.EmployeeController;
import com.ingen.repository.EmployeeDao;
import com.ingen.repository.EmployeeDaoInterface;
import com.ingen.service.EmployeeService;
import com.ingen.service.EmployeeServiceInterface;

import io.javalin.Javalin;

public class Main {
    

    public static void main(String[] args) {


        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();

        }).start();

        EmployeeDaoInterface employeeDao = new EmployeeDao();
        EmployeeServiceInterface employeeService = new EmployeeService(employeeDao);
        EmployeeController employeeController = new EmployeeController(employeeService);


        app.get("/employee", employeeController.getAllEmployees);

        app.delete("/employee", employeeController.deleteEmployee);

        app.post("/employee", employeeController.createEmployee);

        app.put("/employee", employeeController.updateEmployee);

        app.patch("/employee", employeeController.loginEmployee);

        
    }
    
}
