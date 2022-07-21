package com.ingen.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Employee {

    public Employee(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    
}
