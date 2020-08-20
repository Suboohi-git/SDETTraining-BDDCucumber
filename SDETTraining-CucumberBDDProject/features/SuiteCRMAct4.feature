
@crmact4
Feature: CRM Activity 4 creating a product

  
  Scenario Outline: Opening a webpage using Selenium
    Given User is on CRM Login page4
    When User enters username and password4
    Then Navigate to product create product
    And Retrive "<Productname>" and "<Price>" and enter product and save
    And Goto view product and see the product
    And Close the Browser4

Examples:
    | Productname | Price	|
    | testCRM	    | 24		|
