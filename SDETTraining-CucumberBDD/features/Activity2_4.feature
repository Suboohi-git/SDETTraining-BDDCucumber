@activity2_4
Feature: Data driven test without Example

Scenario: Testing with Data from Scenario
    Given User is on Log page
    When User enters "admin" and "password"
    Then Read the page title and confirm message
    And Close all Browser