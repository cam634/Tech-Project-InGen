package com.ingen.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Employee {

    private WebDriver driver;

    @FindBy(id = "requestValue")
    public WebElement valueInput;

    @FindBy(id = "requestReason") 
    public WebElement textInput;

    @FindBy(id = "requestButton")
    public WebElement requestButton;

    
    @FindBy(id = "logoutButton")
    public WebElement logoutButton;

   public Employee(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   public void requestAmount(String value){
      this.valueInput.sendKeys(value);
   }

   public void enterRequestReason(String text){
      this.textInput.sendKeys(text);
   }

   public void requestButton(){
      this.requestButton.click();
   }

   public void logoutbutton(){
    this.logoutButton.click();
  }

}