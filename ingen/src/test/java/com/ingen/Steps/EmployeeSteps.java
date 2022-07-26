
package com.ingen.Steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ingen.TestRunner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSteps {

@Given("the employee is on the employee homepage")
public void the_employee_is_on_the_employee_homepage() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("https://cam634.github.io/employee");
}

@When("the employee enters the amount of money to be reimbursed in the reimbursement textbox")
public void the_employee_enters_the_amount_of_money_to_be_reimbursed_in_the_reimbursement_textbox() {
    // Write code here that turns the phrase above into concrete actions

    TestRunner.employee.requestAmount("300");
}
@When("the employee provides a reason for the reimbursement request")
public void the_employee_provides_a_reason_for_the_reimbursement_request() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.employee.enterRequestReason("New embryo for testing");
}

@When("the employee clicks submit button")
public void the_employee_clicks_submit_button() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.employee.requestButton();
}


@Then("message appears indicating the reimbursement was made successfully")
public void message_appears_indicating_the_reimbursement_was_made_successfully() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='row317']/td[1]")));

    if(TestRunner.driver.getPageSource().contains("New embryo for testing")){
        ;
    }else{
        Assert.fail();
    }
}



@Then("the employee is brought to page with all the previous reimbursements")
public void the_employee_is_brought_to_page_with_all_the_previous_reimbursements() {
    // Write code here that turns the phrase above into concrete actions
    if(TestRunner.driver.getPageSource().contains("Requests")){
        ;
    }else{
        Assert.fail();
    }
   
}





@When("an employee enters clicks on logout button")
public void an_employee_enters_clicks_on_logout_button() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.employee.logoutbutton();
}
@Then("the employee is brought back to the login page")
public void the_employee_is_brought_back_to_the_login_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.wait.until(ExpectedConditions.titleIs("Login Page"));
   String title = TestRunner.driver.getTitle();
   Assert.assertEquals("Login Page", title);
}




    
}
