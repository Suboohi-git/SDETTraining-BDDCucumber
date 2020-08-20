
@crmact3
Feature: CRM Activity 3 Creating meeting inviting users

  
  Scenario Outline: Opening a webpage using Selenium
    Given User is on CRM Login page3
    When User enters username and password3
    Then Navigate to meeting Schedule Meeting
    And search for user "<UserFname1>" , "<UserLname1>" and "<UserFname2>" , "<UserLname2>" add and save
    And Navigate to meeting page and confirm meeting creation
    And Close the Browser3

Examples:
    | UserFname1 | UserLname1 	| UserFname2 	|	UserLname2	|
    | FName	     | LName  			|	Test1				|	test				|
  
