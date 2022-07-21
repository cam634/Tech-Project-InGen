Feature: Manager on my application should be see approve and deny reimbursment request and provide a reason
Scenario: As a manager I want to Approve Reimbursement Requests 
    Given the manager is on the manager homepage 
    Then the manager sees all current reimbusment request 



Scenario: As a manager I want to Approve Reimbursement Requests 
    Given the manager is on the manager homepage 
    When the manager enters reason for approval or denial 
    When the manager selects approve reimbursement requests 
    Then there is an alert that the decision was input 

 

Scenario: As a manager I want to Deny Reimbursement Requests 
    Given the manager is on the manager homepage 
    When  the manager enters reason for approval or denial 
    When the manager selects deny reimbursement requests 
    Then there is an alert that the decision was input 


Scenario: An Manager should be able to sign out to prevent others from accessing information 
    Given the manager is on the manager homepage 
    When an manager enters clicks on logout button 
    Then the manager is brought back to the login page 

 