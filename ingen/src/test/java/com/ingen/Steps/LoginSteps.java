package com.ingen.Steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ingen.TestRunner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


@Given("the employee is on the login page")
public void the_employee_is_on_the_login_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("https://cam634.github.io/login");
}

@When("the manager enters their correct username")
public void the_manager_enters_their_correct_username() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.login.enterUsername("TestManager");
}

@When("the manager enters their correct password")
public void the_manager_enters_their_correct_password() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.login.enterPassword("password");
}

@When("the employee clicks the login button")
public void the_employee_clicks_the_login_button() {
    // Write code here that turns the phrase above into concrete actions
TestRunner.login.clickButton();
}

@Then("the manager should be logged in to the manager home page")
public void the_manager_should_be_logged_in_to_the_manager_home_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));
   String title = TestRunner.driver.getTitle();
   Assert.assertEquals("Manager Page", title);
}

@When("the employee enters their correct username")
public void the_employee_enters_their_correct_username() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.login.enterUsername("TestEmployee");
}
@When("the employee enters their correct password")
public void the_employee_enters_their_correct_password() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.login.enterPassword("password");
}

@Then("the employee should be logged in to the employee home page")
public void the_employee_should_be_logged_in_to_the_employee_home_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.wait.until(ExpectedConditions.titleIs("Employee Page"));
   String title = TestRunner.driver.getTitle();
   Assert.assertEquals("Employee Page", title);
}

    
}
