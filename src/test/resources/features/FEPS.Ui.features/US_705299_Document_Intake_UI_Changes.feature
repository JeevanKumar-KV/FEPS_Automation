 #@TestRun @DocumentIntakeUIChanges @US705299
#Feature: US_705299 Document Intake UI Changes
#
  #@729451 @PAS
  #Scenario: Test Case 729451: Verify general section contains below mentioned fields: Case Owner Case Account Name Client Application Program Source Escalated Case Case Status Date Received Case Type Priority Type of Document
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify general section contains following fields: Case Owner Case Number Account Name Client Application Program Source Escalated Case Case Status Date Received Case Type Priority Type of Document
    #Then User logs out of the application
#
  #@729452 @PAS
  #Scenario: Test Case 729452: Verify below mentioned fields of general section are Read-Only field: Client Program Case Type
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify general section are Read-Only field: Client Program Case Type
    #Then User logs out of the application
#
  #@729453 @PAS
  #Scenario: Test Case 729453: Verify that Territory Alignment section displays only if zip code routing is enabled for case and program
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case for Program2
    #Then User verifies Case details is displayed
    #And Verify that Territory Alignment section displays only if zip code routing is enabled for case and program
    #Then User logs out of the application
#
  #@729454 @PAS
  #Scenario: Test Case 729454: Verify that below mentioned fields are displaying under Territory Alignment section: HCP Region Territory Zipcode HCP Territory Patient Advocate Name
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case for Program2
    #Then User verifies Case details is displayed
    #And Verify that below mentioned fields are displaying under Territory Alignment section: HCP Region Territory Zipcode HCP Territory  Patient Advocate Name
    #Then User logs out of the application
#
  #@729455 @PAS
  #Scenario: Test Case 729455: Verify below mentioned fields of Territory Alignment section are Read-Only field: HCP Region HCP Territory Patient Advocate Name
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case for Program2
    #Then User verifies Case details is displayed
    #And Verify below mentioned fields of Territory Alignment section are Read-Only field: HCP Region HCP Territory Patient Advocate Name
    #Then User logs out of the application
#
  #@729456 @PAS
  #Scenario: Test Case 729456: Verify that Age Indicator and SLA Met fields are visible to supervisor
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify that Age Indicator and SLA Met fields are visible to supervisor
    #Then User logs out of the application
#
  #@729457 @PAS
  #Scenario: Test Case 729457: Open the application URL> Login with supervisor credentials> Open any of the document intake case>Verify that Age Indicator and SLA Met fields are read only fields
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify that Age Indicator and SLA Met fields are read only fields
    #Then User logs out of the application
#
  #@729459 @PAS @AVIS_OCR_Implementation
  #Scenario: Test Case 729459: Verify OCR Information section contains below mentioned fields: OCR Processed Number of pages Reviewed By No of templates processed OCR Reviewed By Rejected Pages Edit OCR Reviewed By Rejected Page Status
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify OCR Information section contains below mentioned fields OCR Processed Number of pages Reviewed By No of templates processed OCR Reviewed By Rejected Pages Edit OCR Reviewed By Rejected Page Status
    #Then User logs out of the application
#
  #@729460 @PAS @AVIS_OCR_Implementation
  #Scenario: Test Case 729460: Verify below mentioned fields of OCR Information section are Read-Only field: OCR Processed Number of pages Reviewed By No of templates processed OCR Reviewed By Rejected Pages Rejected Page Status
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify below mentioned fields of OCR Information section are Read-Only field OCR Processed Number of pages Reviewed By No of templates processed OCR Reviewed By Rejected Pages Edit OCR Reviewed By Rejected Page Status
    #Then User logs out of the application
#
  #@729462 @PAS
  #Scenario: Test Case 729462: Verify Reportable Events section has below mentioned fields: Reportable Event Identified Reportable Event Identified Date Time
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify Reportable Events section has mentioned fields Reportable Event Identified Reportable Event Reviewed Datetime
    #Then User logs out of the application
#
  #@729463 @PAS
  #Scenario: Test Case 729463: Verify that Reportable Event Identified and Document Review SLA Met fields are read only.
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify that Reportable Event Identified and Document Review SLA Met fields are read only
    #Then User logs out of the application
#
  #--------------------------Asima testcases ----------------------------------------------------------------------------------------------
  #@729464 @PAS
  #Scenario: Test Case 729464: Verify that Reportable Event Identified field is defaulted to blank
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User changes user session to program one
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify that reportable event section is blank
    #Then User logs out of the application
#
  #@729465 @PAS
  #Scenario: Test Case 729465: Verify that Additional Information section contains below mentioned values: Non - English Documents Case Origin Case Record Type
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify Additional Information section
    #Then User logs out of the application
#
  #@729466 @PAS
  #Scenario: Test Case 729466: Verify below mentioned fields of Additional Information section are Read-Only field: Case Origin Case Record Type
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And Verify Additional Information section case origin and record type is readable
    #Then User logs out of the application
#
  #@729467 @PAS @Doc
  #Scenario: Test Case 729467: Verify that Spanish is the picklist value of Non - English Documents field
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And User Verfies Spanish option is present in the Non-English Documents picklist
    #Then User logs out of the application
#
  #@729468 @PAS @Doc
  #Scenario: Test Case 729468: Verify case is assigned to agent who is assigned to work on Non-English documents
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case
    #Then User verifies Case details is displayed
    #And User Verfies Spanish option is present in the Non-English Documents picklist
    #Then User logs out of the application
#
  #@729469 @PAS @Doc
  #Scenario: Test Case 729469: Verify that all the digitized data are displaying within a related list
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify documents are digitized
    #Then User logs out of the application
#
  #@729470 @PAS 
  #Scenario Outline: Test Case 729470: Verify all the OCR Data related list are renamed as Digitized Data
    #Given User should have the Case Creation base URL
    #And User passes payload parameters like Program "<Program>" & documentSource "<Doc_Source>"  in CaseCreation JsonPayloadFile "<CaseCreation_Payload_JsonFile>"
    #Then User initiates post request with CaseCreation Services  endpoint
    #And User should get status code as "200" in response
    #And User verifies StatusMessage should be Document Created "Document Created" in the response
    #Then User also verifies caseNumber should be dislayed in the response
    #And User should have the OCR base Url
    #And User passes payload parameters like processedDate  & filename  in OCR JsonPayloadFile "<OCR_Payload_JsonFile>"
    #Then User initiates post call using OCR endpoint along with above payload
    #And User should get status code as "200" in response
    #And User verifies StatusMessage and it should be "Document Processed." in the OCR Post response
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #Then Verify Case is created
    #Then User verifies Case details is displayed
    #And Verify OCR data listed as Digitized data
    #Then User logs out of the application
    #
    #Examples: 
      #| Program  | Doc_Source | CaseCreation_Payload_JsonFile | OCR_Payload_JsonFile     |
      #| Program1 | PAP        | Case_Creation_Payload.json    | OCR_Process_Payload.json |
#
  #@729471 @PAS 
  #Scenario Outline: Test Case 729471: Verify that all the digitized data and record indicates document intake source
#		 Given User should have the Case Creation base URL
    #And User passes payload parameters like Program "<Program>" & documentSource "<Doc_Source>"  in CaseCreation JsonPayloadFile "<CaseCreation_Payload_JsonFile>"
    #Then User initiates post request with CaseCreation Services  endpoint
    #And User should get status code as "200" in response
    #And User verifies StatusMessage should be Document Created "Document Created" in the response
    #Then User also verifies caseNumber should be dislayed in the response
    #And User should have the OCR base Url
    #And User passes payload parameters like processedDate  & filename  in OCR JsonPayloadFile "<OCR_Payload_JsonFile>"
    #Then User initiates post call using OCR endpoint along with above payload
    #And User should get status code as "200" in response
    #And User verifies StatusMessage and it should be "Document Processed." in the OCR Post response
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #Then Verify Case is created
    #Then User verifies Case details is displayed
    #And Verify OCR data listed as Digitized data and indicates document intake
    #Then User logs out of the application
#
 #			Examples: 
      #| Program  | Doc_Source | CaseCreation_Payload_JsonFile | OCR_Payload_JsonFile     |
      #| Program1 | PAP        | Case_Creation_Payload.json    | OCR_Process_Payload.json |
      #
  #@729472 @PAS 
  #Scenario: Test Case 729472: Verify user is able to create reportable event within the case
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify user able to create reportable event
    #Then User logs out of the application
#
  #@729473 @PAS 
  #Scenario: Test Case 729473: Verify reportable event is linked to the case and associated Patient
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify reportable event is linked
    #Then User logs out of the application
#
  #----------------------------------------------End-------------------------------------------------------
  #@729474 @PAS 
  #Scenario: Test Case 729474: Verify that reportable event is linked only to that document for which reportable event identified
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify that reportable event is linked only to that document for which reportable event identified
    #Then User logs out of the application
#
  #@729475 @PAS 
  #Scenario: Test Case 729475: Verify that user is provided option to manually update RE against each document.
    #Given User launches the PAS URL
    #When User logs in with valid agent credentials
    #Then User is logged into application
    #And User selects a Document Intake Case which is In-Progress
    #Then User verifies Case details is displayed
    #And Verify that user is provided option to manually update RE against each document
    #Then User logs out of the application
#gradle runTest  -PtestTag="@729464" -Penv=QA  -Pplt=UI -Pbrowser=chrome -Pthreads=1
#gradle runTest  -PtestTag="@DocumentIntakeUIChanges" -Penv=QA  -Pplt=UI -Pbrowser=chrome -Pthreads=2
#gradle runTest  -PtestTag="@TestRun" -Penv=QA  -Pplt=UI -Pbrowser=chrome -Pthreads=2
