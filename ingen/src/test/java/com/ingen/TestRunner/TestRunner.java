package com.ingen.TestRunner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ingen.Pom.Login;
import com.ingen.Pom.Manager;
import com.ingen.Pom.Employee;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Resources/Features", glue="com/ingen/Steps", plugin = {"pretty", "html:src/test/resources/reports/html-reports.html"})
public class TestRunner {
    public static WebDriver driver;

    public static WebDriverWait wait;

    public static Login login;

    public static Manager manager;

    public static Employee employee;





    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/Resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        login = new Login(driver);
        manager = new Manager(driver);
        employee = new Employee(driver);

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
