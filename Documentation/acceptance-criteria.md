# Acceptance Criteria  

## Sign in: 
Feature: Users of my application should be able to login to their respective homepages 
    Scenario: As a manager I want to sign in to view my custom home page 
        Given the employee is on the login page 
        When the Manager enters their correct username 
        When the Manager enters their correct password 
        When the employee clicks the login button 
        Then the manager should be logged in to the manager's home page 

    Scenario: As a manager I want to sign in to view my custom home page 
        Given the employee is on the login page 
        When the employee enters their correct username 
        When the employee enters their correct password 
        When the employee clicks the login button 
        Then the employee should be logged in to the employee home page 

## Employee:  
Feature: Employees should be able to login to see employee custom homepages 
    Scenario: As an employee, I want to sign in to view employee homepage 
        Given the employee is on login page 
        When employee enters username 
        When employee enters password 
        When an employee clicks login button 
        Then the employee is logged in to the employee homepage 

    Scenario: As an employee, I want to create a reimbursement request to get money back I spent for the company 
        Given the employee is on the employee homepage 
        When the employee enters the amount of money to be reimbursed in the reimbursement textbox 
        When the employee provides a reason for the reimbursement request 	    
        When the employee clicks “enter” button 
        Then message appears indicating the reimbursement was made successfully 

    Scenario: As an employee, I want to view previous reimbursement requests 
        Given the employee is on the employee homepage 
        Then the employee is brought to page with all the previous reimbursements 

    Scenario: An employee should be able to sign out to prevent others from accessing information 
        Given the employee is on employee homepage 
        When an employee enters clicks on logout button 
        Then the employee is brought back to the login page 

    

## Manager: 
Feature: Manager on my application should be see approve and deny reimbursment request and provide a reason
    Scenario: As a manager I want to Approve Reimbursement Requests 
        Given the manager is on the manager homepage 
        When the manager selects approve reimbursement requests 
        When    the manager enters reason for approval or denial 
        When the manager clicks the submit button 
        Then there is an alert that the decision was input 

    Scenario: As a manager I want to Deny Reimbursement Requests 
        Given the manager is on the manager homepage 
        When the manager selects to deny reimbursement requests 
        When the manager enters reason for approval or denial 
        When the manager clicks the submit button 
        Then there is an alert that the decision was input 

## Buisness Rules
    ### Usernames
     Scenario: As an admin creating a username and password, I want to ensure each username is unique  
        Given The admin is creating a username 
        When the admin enters a username  
        When the admin enters a password  
        Then the admin submits a request it will pull and error if the username exists 

    ### Employees
    Scenario: An employee must provide a reason for a reimbursement request no longer than 500 characters 
        Given the employee is on the employee homepage 
        When the employee enters the amount of money to be reimbursed in the reimbursement textbox 
        When the employee provides a reason for the reimbursement request longer than 500 characters 
        When the employee clicks “enter” button 
        Then there is an alert that the request was input with a over 500 characters  

    Scenario: An employee must not try to request over $1000 
        Given the employee is on the employee homepage 
        When the employee enters over $100 of money to be reimbursed in the reimbursement textbox 
        When the employee provides a reason for the reimbursement request 	    
        When the employee clicks “enter” button 
        Then there is an alert that the request could not be process because over $1000 has been requested 

    ### Manager 
    Scenario: Managers must provide a reason for approving or denying a reimbursement request  	no longer than 500 characters 
        Given the manager is on the manager homepage 
        When the manager views reimbursement requests  
        When the manager selects deny reimbursement requests 
        When the manager does not enter reason for approval or denial 
        When the manager clicks submit button 
        Then there is an alert that the decision was input 




 

 

 

 

 

 

 