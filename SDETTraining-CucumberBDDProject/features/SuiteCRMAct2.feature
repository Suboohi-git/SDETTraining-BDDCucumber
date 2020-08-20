
@crmact2
Feature: CRM Activity 2 Create lead using parameter

  
  Scenario: Opening a webpage using Selenium
    Given User is on CRM Login page2
    When User enters username and password2
    Then Navigate to sales and create lead 
    And fill the details "Fname" and "Lname" save
    And Navigate to lead page see the result
    And Close the Browser2

  
