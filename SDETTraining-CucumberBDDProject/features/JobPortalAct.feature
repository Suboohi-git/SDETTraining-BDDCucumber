

@jobBoardActivities
Feature: Testing Alchemy Jobs website

  @jbact1
  Scenario: Visit the site’s backend and create a new user 
    Given User is on Alchemy Jobs Login page
    When User enters username and password
    Then Locate the "Add New" button and click it
    And  Fill in the necessary details
    And Click the "Add New User" button
    And Verify that the user was created
    And close the browser
    
   @jbact2
   Scenario: Searching for jobs and applying to them using XPath
   Given Open browser with Alchemy jobs site and navigate to Jobs page
    When Type in keywords to search for jobs and change the Job type to "Full Time" jobs
    Then Find the title of the job listing using XPath and print it to the console
    And  Find and Click on the "Apply for job" button
		And close the browser
		
		@jbact3
		Scenario: Post a job using details passed from the Feature file
		Given Open browser with Alchemy jobs site and navigate to Post Jobs page
    When fill in the details "test@123.com" and "Test Automation Analyst" and "Gurgaon" and "Job is for Automation" and "IBM"
    And submit the details
    Then Go to the Jobs page and Confirm job listing is shown on page
		And close the browser
    
    @jbact4
		Scenario Outline: Scenario Outline and Examples table to post a job
			Given Open browser with Alchemy jobs site and navigate to Post Jobs page
    	When fill in the details "<email>" and "<job_title>" and "<job_location>" and "<job_description>" and "<company>"
    	And submit the details
    	Then Go to the Jobs page and Confirm job "<job_title>" listing is shown on page
			And close the browser
		    
		Examples:
		    | email            | job_title 					| job_location | job_description    | company |
		    | john46@123.com| Automation Junior  | Bangalore    | jobs in automation | abc     |
		    
    
    
   