Feature:  Employees should be able to create and view reimbursment request that they have previously made
 

Scenario: As an employee, I want to create a reimbursement request to get money back I spent for the company 
    Given the employee is on the employee homepage 
    When the employee enters the amount of money to be reimbursed in the reimbursement textbox 
    When the employee provides a reason for the reimbursement request 	    
    When the employee clicks submit button 
    Then message appears indicating the reimbursement was made successfully 


Scenario: As an employee, I want to view previous reimbursement requests 
    Given the employee is on the employee homepage 
    Then the employee is brought to page with all the previous reimbursements 

 

Scenario: An employee should be able to sign out to prevent others from accessing information 
    Given the employee is on the employee homepage  
    When an employee enters clicks on logout button 
    Then the employee is brought back to the login page 

 

 
