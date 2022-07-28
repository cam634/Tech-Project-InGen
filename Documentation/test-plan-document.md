# InGen Test Plan  

The Ingen company will be building and testing an employee reimbursement system, so that employees can create reimbursement requests from their company, and also view previous reimbursement requests that they have made within the company they work for. within these features we want to give them the ability to do these things so that they can prevent others from accessing their information, get money back that the employee spent for the company and also to see whether they should be able to expect money back or not. Also, with this application we want to give managers the ability to view the reimbursement requests that are made by the employee and immediately start addressing them with the ability to approve or deny.  What this approve or deny feature will do is give the company an awareness whether to pay out or not. After these actions have been taken by both manager and employee, we also want each user to be able to sign out of their homepages.  

Within this project there will be a couple of ways that we will be testing each user's story. We will be using:  


Unit testing: Repository Layer (all methods must have one positive test), Service layer (all methods must have one negative test per business rule enforced). 

Integration Testing: Testing for the API (all routes must have one positive test, and if applicable all routes must have a negative test for each business rule. 

End to End Testing: All acceptance criteria must be tested via Cucumber and Selenium.  

 

For our project the technologies being utilized are Java, Selenium, cucumber, JavaScript, html, CSS and dbeaver, along with AWS to create our databases.  

7/12/2022-7/15/2022: Our required Documentation will be created and then approved; We will Create database with correct table; Confirm our project can successfully connect to the database; begin writing test for repository, and service layer interfaces of application; Start implementing repository and service layer interfaces to pass unit tests.  

7/18/2022-7/22/2022: Repository and service unit test will be implemented, and pass unit testing; API work should begin; Work will be started on UI using basic html/CSS/JavaScript; E2E testing will begin to be designed.  

7/25/2022-7/28/2022: API Should be finished; E2E should be finished; Any final debugging should be finished by the end of the day 7/28 or 7/27; Code freeze should be implemented 7/28 ideally; Documentation needs to be prepared.  

7/29/2022: We present our project.  


# Test Cases

## Sign in Test Suite
As a user I want to be able to sign in to our website. 
    Unit test
        When given a password and username return the user -- Completed by Cameron
            method: loginEmployee()
    Service Tetst 
        N/A

As a admin I want to be able to get all employee
    Unit test 
       return a list of all employees --Completed by Cameron Hauser 
            Method: getAllEmployees()
    Service Test
        N/A

## Request Test Suite
As a Employee I want to be able to be able to create a reimbursment request(Will be in pending table)
    Unit Test -- Completed By Che
        Create reimbursment request with all fields -- Completed By Nirlouse 
            Method: CreateReimbursmentRequest()
    Service Test -- Completed by Che
        Employees must only be able to request up to $1000 on the request -- Completed by Che
            Method:checkValue() -- Completed by Che
        Employees must provide a reason for the reimbursement request no longer than 500 characters -- Completed by Che
            Method: checkRequestReasonLength() -- Completed by Che

As an Employee I want to be able to see my previous request
    Unit Test -- Completed by Che
       View all request -- Completed by Nirlouse 
            Method: getAllRequests()
        View all request by Id -- Completed by Che 
            Method: viewDecidedRequest()
As a manager I want to be able to update request with my deciosn 
    Unit Test -- Completed by Che 
        Update request -- completed by Nirlouse 
            Method:checkReviewReasonLength();
        Service Test -- Completed by Che
            Managers must provide a reason no longer then 500 charcters when updating a request 
                Method: checkRequestReasonLength() -- Completed by Che
        




    

