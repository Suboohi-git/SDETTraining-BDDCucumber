
@hrmact4

Feature: HRM Activity 4
  
 Scenario Outline: Creating multiple vacancies using data the Examples tables
    Given Navigate to HRM "Recruitment" page
    And Click on the "Vacancies" menu item to navigate to the vacancies page
    When Click on the "Add" button to navigate to Add Job Vacancy form
    And Fill out "<Job_Title>" and "<JobVacancy_name>" and "<hiringManager>" and "<noOfPositions>" and Click the "Save" button
    Then Verify that the vacancy "<JobVacancy_name>" was created
    
    Examples:
		|Job_Title    | JobVacancy_name   | hiringManager 		| noOfPositions |
		| 1           | SDET Automation	  | Test Auto   			| 3  						|
		
    
 
    

 