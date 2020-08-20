
@hrmact3

Feature: HRM Activity 3
  
   Scenario Outline: Add multiple employees using an the Examples table
    Given Navigate to HRM PIM page
    When Click on the "Add" button to navigate to the employee information form
    And Fill out "<firstName>" and "<lastName>" and "<username>" and Create Login Details checkbox is checked
    And Fill out the necessary details and Click the "Save" button
    Then Navigate back to the employee page to confirm employee "<firstName>" entry
    
    Examples:
		    | firstName   | lastName 		| username |
		    | john				| Automation 	| John406  |
		  
    
 
    

 