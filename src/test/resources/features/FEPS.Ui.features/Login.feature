@Test @LoginPage @US1
Feature: US_705299 Document Intake UI Changes

  Background: 
    Given User launches the PAS URL
    When User Clicks on login through SSO
    When User logs in with valid agent credentials
    Then User is logged into application
    When user Select "Time" menu

  @01 @FEPS
  Scenario: Test Case 100: Verify below mentioned fields of Absence Report: Time Menu
   
  Then Select AbsenceReport and  Company Code as "BPS", SBU as "APAH", Dates as "Custom"
   And user enter Date1 as "07/22/2022", Date2 as "08/17/2022"
  Then user clicks on generateReport
  Then check for Company Code
  Then click on Employee hyperlink
  Then check for page name
  Then click on date hyperlink in absence detail page
  Then check for employeeid in Time Clock Activity page
  Then click on favorite button
  Then click on Dashoard 
  
  @02 @FEPS
  Scenario: Test Case 100: Verify below mentioned fields of Assumed Hours Worked Today Report: Time Menu
  Then Select Assumed Hours Worked Today and  Company Code as "BPS", SBU as "BANK"
  Then user clicks on generateReport in Assumed Hours
  Then check for the page title
  Then Click on Show Hirearcy Columns
  Then Click on Feedback
  Then Enter Feedback for Assumed Hours Worked Today and click on rating
  Then Click on Submit button
  Then Click on Help and check for the title of help pop up and close the pop up
  # Added new comments for Git

  #Added
  #same modifed

  
#	Then chick on logout button
    
   #gradle runTest  -PtestTag="@01" -Penv=QA  -Pplt=UI -Pbrowser=chrome -Pthreads=1