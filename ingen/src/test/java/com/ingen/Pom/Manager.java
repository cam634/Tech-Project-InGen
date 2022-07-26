package com.ingen.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manager {

    private WebDriver driver;

    public Manager(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(id = "name")
    public WebElement nameInput;

    @FindBy(id = "globalReimbursment")
    public WebElement globalReimbursment;

    @FindBy(id = "personallyApprovedReimbursment")
    public WebElement personallyApprovedReimbursment;

    @FindBy(tagName = "button")
    public WebElement logoutButton;

    public void nameInput(String name){
        this.nameInput.sendKeys(name);
    }

    public void ManagerglobalReimbursment(String globalReimbursment){
        this.globalReimbursment.sendKeys(globalReimbursment);
    }

    public void personallyApprovedReimbursment(String personallyApprovedReimbursement){
        this.personallyApprovedReimbursment.sendKeys(personallyApprovedReimbursement);
    }

    public void logoutButton(){
        this.logoutButton.click();
    }
}
