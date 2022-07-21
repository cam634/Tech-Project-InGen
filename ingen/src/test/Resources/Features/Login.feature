Feature: Users of my application should be able to login to their respective homepages 
    Scenario: As a manager I want to sign in to view my custom home page 
        Given the employee is on the login page 
        When the manager enters their correct username 
        When the manager enters their correct password 
        When the employee clicks the login button
        Then the manager should be logged in to the manager home page

    Scenario: As a employee I want to sign in to view my custom home page 
        Given the employee is on the login page 
        When the employee enters their correct username 
        When the employee enters their correct password 
        When the employee clicks the login button
        Then the employee should be logged in to the employee home page
 
 

 
