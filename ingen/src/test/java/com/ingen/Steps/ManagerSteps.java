package com.ingen.Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ingen.TestRunner.TestRunner;
import com.ingen.Utils.RequestBusinessRules;
import com.ingen.entitiy.Request;
import com.ingen.repository.RequestDao;
import com.ingen.service.RequestService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ManagerSteps {
    public static int idHolder;
    public static Request newRequest = new Request("Pending", 100, "Lorem ipsum", " " ,"TestEmployee", "");
    public static RequestDao Dao = new RequestDao();
    public static RequestBusinessRules businessRules = new RequestBusinessRules();
    public static RequestService newRequestService = new RequestService(Dao, businessRules);
    
    public static String amountholder; 


    @Given("the manager is on the manager homepage")
    public void the_manager_is_on_the_manager_homepage() {
        // Write code here that turns the phrase above into concrete actions
        Request createdRequest = newRequestService.serviceCreateRequest(newRequest);
        idHolder = createdRequest.getId();
        TestRunner.driver.get("https://cam634.github.io/webpages/login.html");
        TestRunner.login.enterUsername("TestManager");
        TestRunner.login.enterPassword("password");
        TestRunner.login.clickButton();
        TestRunner.wait.until(ExpectedConditions.titleIs("Manager Page"));String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Manager Page", title);
    }



    @Then("the manager sees all current reimbusment request")
    public void the_manager_sees_all_current_reimbusment_request() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> rows_table = TestRunner.driver.findElements(By.tagName("tr"));
        if(rows_table.size() > 5){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
        Request requestTobeDeleted = newRequestService.serviceGetRequestById(idHolder);
        newRequestService.serviceDeleteRequest(requestTobeDeleted);
    }

    @When("the manager enters reason for approval or denial")
    public void the_manager_enters_reason_for_approval_or_denial() {
        // Write code here that turns the phrase above into concrete actions
        String reviewReasonId = "reviewReason" + idHolder;
        TestRunner.driver.findElement(By.id(reviewReasonId)).sendKeys("Test");
    }
    @When("the manager selects approve reimbursement requests")
    public void the_manager_selects_approve_reimbursement_requests() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.findElement(By.id("approveButton" + idHolder)).click();
    }
    @Then("there is an alert that the decision was input")
    public void there_is_an_alert_that_the_decision_was_input() {
        // Write code here that turns the phrase above into concrete actions
        Request requestTobeDeleted = newRequestService.serviceGetRequestById(idHolder);
        newRequestService.serviceDeleteRequest(requestTobeDeleted);
    }


    @When("the manager selects deny reimbursement requests")
    public void the_manager_selects_deny_reimbursement_requests() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.findElement(By.id("denyButton" + idHolder)).click();
    }

    @When("an manager enters clicks on logout button")
    public void an_manager_enters_clicks_on_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.employee.logoutbutton();
    }
    @Then("the manager is brought back to the login page")
    public void the_manager_is_brought_back_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.titleIs("Login Page"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Login Page", title);
        Request requestTobeDeleted = newRequestService.serviceGetRequestById(idHolder);
        newRequestService.serviceDeleteRequest(requestTobeDeleted);
    }



    @When("the manager sees total amount approved")
    public void the_manager_sees_total_amount_approved() {
    // Write code here that turns the phrase above into concrete actions
    amountholder = TestRunner.driver.findElement(By.id("personallyApprovedReimbursements")).getAttribute("innerText");
    }


    @Then("the manager sees the updated total")
    public void the_manager_sees_the_updated_total() {
    String expectedText = Integer.toString(Integer.parseInt(amountholder) + 100);
    TestRunner.wait.until(ExpectedConditions.textToBe(By.id("personallyApprovedReimbursements"), expectedText));
    // Write code here that turns the phrase above into concrete actions
    String newAmount = TestRunner.driver.findElement(By.id("personallyApprovedReimbursements")).getAttribute("innerText");
    Assert.assertEquals(Integer.parseInt(amountholder) + 100, Integer.parseInt(newAmount));
    Request requestTobeDeleted = newRequestService.serviceGetRequestById(idHolder);
    newRequestService.serviceDeleteRequest(requestTobeDeleted);

    }





}
