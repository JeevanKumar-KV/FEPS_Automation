 #@TestRun @DocumentIntakeUIChanges @1
#Feature: US_705299 Login_Page
#
#@2 @PAS  @FEPS
  #Scenario: Test Case 729475: Verify that user is provided option to manually update RE against each document.
    #Given User launches the FEPS URL
    #When User logs in with valid username "30134914" and "Test123" credentials
    #Then Select Time Card and Company Code as "BPS" 
  #// public void select_Time_Card(String company_code_dropdown_value) throws InterruptedException {
    #//    loginPageActions.navigate_to_Time_Card(company_code_dropdown_value);
    #}
    #Then User is logged into application
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify that user is provided option to manually update RE against each document
    #Then User logs out of the application
    #gradle runTest  -PtestTag="@FEPS" -Penv=QA  -Pplt=UI -Pbrowser=chrome -Pthreads=1