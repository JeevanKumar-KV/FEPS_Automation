package com.FEPS.pages.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.FEPS.pages.PageBase;

public class FEPS_Case_Page_UI_Object extends PageBase {

	public FEPS_Case_Page_UI_Object(WebDriver driver) {
		super(driver);

	}

	// Document Intake Case Header
	@FindBy(how = How.XPATH, using = "//h1/div[text()='Case']")
	public WebElement document_intake_case_header;

	// Case Owner
	@FindBy(how = How.XPATH, using = "//span[text()='Case Owner']")
	public WebElement case_owner_field;

	String inlineFieldXpath = "//div[@class='slds-grid slds-size_1-of-1 label-inline']";

	// Case Number
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Case Number']")
	public WebElement case_number_field;

	// Account Name
	@FindBy(how = How.XPATH, using = "//div[text()='Case']//following::span[@class='test-id__field-label'][text()='Account Name']")
	public WebElement account_name_field;

	public static String account_name_multiple_elements = "//span[@class='test-id__field-label' and normalize-space()='Account Name']";
	public static String client_multiple_elements = "//span[@class='test-id__field-label' and normalize-space()='Client']";

	// Client
	@FindBy(how = How.XPATH, using = "//div[text()='Case']//following::span[@class='test-id__field-label'][text()='Client']")
	public WebElement client_field;

	// Application
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Application']")
	public WebElement application_field;

	// Program
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Program']")
	public WebElement program_field;

	// Source
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Source']")
	public WebElement source_field;

	// Escalated Case
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Escalated Case']")
	public WebElement esclated_case_field;

	// Status
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Status']")
	public WebElement status_field;
	
	// Status field text
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Status']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement status_field_text;

	// Date Received
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Date Received']")
	public WebElement date_received_field;

	// Case Type
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Case Type']")
	public WebElement case_type_field;

	// Priority
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Priority']")
	public WebElement priority_field;

	// DNIS Number
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='DNIS Number']")
	public WebElement dnis_number_field;

	// Case Origin
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Case Origin']")
	public WebElement case_origin_field;

	// Assign To
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Assign To']")
	public WebElement assign_to_field;

	// Incontact Master ID
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Incontact Master ID']")
	public WebElement incontact_master_id_field;

	// Service Offering
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Service Offering']")
	public WebElement service_offering_field;

	// Type of Document
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Type Of Document']")
	public WebElement type_of_document_field;
	
	// Type of Document text
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Type Of Document']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement type_of_document_field_text;

	// Caller Type
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Caller Type']")
	public WebElement caller_type_field;

	// Caller Number
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Caller Number']")
	public WebElement caller_number_field;

	// Patient Representative
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Patient Representative']")
	public WebElement patient_respresentative_field;

	// HCP
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='HCP']")
	public WebElement hcp_field;

	// HCP Contact
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='HCP Contact']")
	public WebElement hcp_contact_field;

	// External Inquiry
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='External Inquiry']")
	public WebElement external_inquiry_field;

	// Client Field Read Only
	@FindBy(how = How.CSS, using = "button[title='Edit Client']")
	public WebElement client_field_read_only;

	// Program Read Only
	@FindBy(how = How.CSS, using = "button[title='Edit Program']")
	public WebElement program_field_read_only;

	// Case Type Read Only
	@FindBy(how = How.CSS, using = "button[title='Edit Case Type']")
	public WebElement case_type_field_read_only;

	// Program link - irrespective of Program 1 or Program 2
	@FindBy(how = How.XPATH, using = "//slot[@records-hoverablelink_hoverablelink]//span[contains(text(),'Program')]")
	public WebElement program_link;

	// Edit button for Enable Zip based Routing
	@FindBy(how = How.XPATH, using = "//button[@title='Edit Enable Zip based Routing']")
	public WebElement edit_button_for_zip_based_routing;

	// Enable zipcode based routing checkbox
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'Enable_Zip_based_Routing')]")
	public WebElement checkbox_for_zip_based_routing;

	// Save Button
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	public WebElement save_button;

	// Region Territory Title
	@FindBy(how = How.XPATH, using = "//a[text()='Region Territory']")
	public WebElement region_territory_title;

	// Region field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Region']")
	public WebElement region_field;

	// Territory Zipcode field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Territory Zipcode']")
	public WebElement territory_zipcode_field;

	// Territory field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Territory']")
	public WebElement territory_field;

	// Patient Advocate field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'slds-grow')]//span[text()='Patient Advocate']")
	public WebElement patient_advocate_field;

	// Region read only field
	@FindBy(how = How.CSS, using = "button[title='Edit Region']")
	public WebElement region_read_only;

	// Territory Zipcode read only field
	@FindBy(how = How.CSS, using = "button[title='Edit Territory Zipcode']")
	public WebElement territory_zipcode_read_only;

	// Territory read only field
	@FindBy(how = How.CSS, using = "button[title='Edit Territory']")
	public WebElement territory_read_only;

	// Patient Advocate read only field
	@FindBy(how = How.CSS, using = "button[title='Edit Patient Advocate']")
	public WebElement patient_advocate_read_only;

	// Aging Indicator field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Aging Indicator']")
	public WebElement aging_indicator_field;

	// SLA Met field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='SLA Met']")
	public WebElement sla_met_field;

	// View All Button for Supporting Documents
	@FindBy(how = How.XPATH, using = "//span[text()='Supporting Documents']//parent::span[@class='view-all-label']")
	public WebElement view_all_supporting_documents;

	// View All Button for Reportable Events
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Events']//parent::span[@class='view-all-label']")
	public WebElement view_all_reportable_events;

	// Reportable Event header
	@FindBy(how = How.XPATH, using = "//h1[text()='Reportable Events']")
	public WebElement reportable_event_view_all_header;

	// PDF file
	@FindBy(how = How.CSS, using = "a[title$='.pdf']")
	public WebElement pdf_file;

	// OCR Processed
	@FindBy(how = How.XPATH, using = "//div[text()='Supporting Document']//following::span[text()='OCR Processed']")
	public WebElement ocr_processed_supporting_document;

	// Number of Pages
	@FindBy(how = How.XPATH, using = "//div[text()='Supporting Document']//following::span[text()='No Of Pages']")
	public WebElement no_of_pages_supporting_document;

	// Reviewed By
	@FindBy(how = How.XPATH, using = "//div[text()='Supporting Document']//following::span[text()='Reviewed By']")
	public WebElement reviewed_by_supporting_document;

	// No of templates Processed
	@FindBy(how = How.XPATH, using = "//div[text()='Supporting Document']//following::span[text()='No of templates Processed']")
	public WebElement number_of_templates_processed_supporting_document;

	// OCR Reviewed By
	@FindBy(how = How.XPATH, using = "//div[text()='Supporting Document']//following::span[text()='OCR_Reviewed_By']")
	public WebElement ocr_reviewed_by_supporting_document;

	// Rejected Pages
	@FindBy(how = How.XPATH, using = "//div[text()='Supporting Document']//following::span[text()='Rejected Pages']")
	public WebElement rejected_pages_supporting_document;

	// Reportable Event Section Header
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'section-header') and text()='Reportable Events']")
	public WebElement reportable_event_section_header;

	// Reportable Event Identified
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Reportable Event Identified']")
	public WebElement reportable_event_identified_field;

	// RE Reportable Via
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='RE Reported Via']")
	public WebElement re_reported_via_field;

	// Description
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Description']")
	public WebElement description_field;

	// Created By
	@FindBy(how = How.XPATH, using = "//div[text()='Case']//following::span[@class='test-id__field-label'][text()='Created By']")
	public WebElement created_by_field;

	// Last Modified By
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Last Modified By']")
	public WebElement last_modified_by_field;

	// Reportable Event Reviewed Datetime
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__field')]//span[text()='Reportable Event Reviewed Datetime']")
	public WebElement reportable_event_reviewed_datetime_field;

	// -------------------------------------------Asima Page
	// Objects-------------------------------------------------

	// Reportable Events field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__section')]//span[text()='Reportable Events']")
	public WebElement reportable_events_field;

	// Additional Information Section - info field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__section')]//span[text()='Additional Information']")
	public WebElement additional_info_field;

	// Additional Information Section Fields - Case origin field
	@FindBy(how = How.XPATH, using = "//span[text()='Additional Information']//ancestor::h3//following-sibling::div//span[text()='Case Origin']")
	public WebElement additional_info_case_origin_field;

	// Additional Information Section Fields - Case record type field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__section')]//span[text()='Case Record Type']")
	public WebElement additional_info_case_record_type_field;

	// Reportable Event Identified field
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__section')]//span[text()='Reportable Event Identified']")
	public WebElement reportable_event_identified;

	// Additional Information Section Fields
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'test-id__section')]//span[text()='Non-English Documents']")
	public WebElement additional_info_non_english_doc_field;

	// Edit non english grammar
	@FindBy(how = How.XPATH, using = "//button[@title='Edit Non-English Documents']")
	public WebElement edit_btn_non_english_documents;

	// Click on dd
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Non-English Documents, --None--']")
	public WebElement edit_btn_non_english_doc_dropdown;

	// Spanish Option
	@FindBy(how = How.XPATH, using = "//span[@title='Spanish']")
	public WebElement spanish_option;

	// Digitized Data
	@FindBy(how = How.XPATH, using = "(//span[@title='Digitized Data'])[1]")
	public WebElement digitized_data;

	// Digitized Data OCR Fields
	@FindBy(how = How.XPATH, using = "(//dt[text()='Field Name:'])[1]")
	public WebElement digitized_data_ocr_feilds;

	// Digitized Data OCR Fields
	@FindBy(how = How.XPATH, using = "//span [@force-lookup_lookup][contains(text(),'DD-')]")
	public WebElement digitized_data_link;

	// Digitized Data OCR Fields
	@FindBy(how = How.XPATH, using = "//dt[text()='Field Value:']")
	public WebElement digitized_data_field_value;

	// Digitized Data OCR Fields
	@FindBy(how = How.XPATH, using = "//dt[text()='Accuracy Value:']")
	public WebElement digitized_data_accuracy_value;

	// Supporting Documents Header
	@FindBy(how = How.XPATH, using = "//span[@title='Supporting Documents']")
	public WebElement supporting_documents_header;

	// Edit Reportable Events
	@FindBy(how = How.XPATH, using = "//button[@title='Edit Reportable Events']")
	public WebElement edit_reportable_events;

	// Reportable Events Link
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Events']")
	public WebElement reportable_event_link;

	// -------------------------------------------End----------------------------------------------------------------
	// NBA Reportable Event
	@FindBy(how = How.XPATH, using = "//h2[@title='Next Best Action']//following::button[text()='Reportable Event']")
	public WebElement nba_reportable_event_button;

	// Case History Title
	@FindBy(how = How.XPATH, using = "//span[@title='Case History']")
	public WebElement case_history_title;

	// Reportable Event Heading and Description
	@FindBy(how = How.XPATH, using = "//div[text()='ReportableEvent']//following::div[text()='Please Proceed to review the Reportable Event Identified']")
	public WebElement reportable_event_header_and_description;
	
	// Reportable Event Button
	@FindBy(how = How.XPATH, using = "//button[text()='Reportable Event']")
	public WebElement reportable_event_button;

	// Add Disposition Button
	@FindBy(how = How.XPATH, using = "//button[text()='Add Disposition']")
	public WebElement add_disposition_button;

	// Attach Patient
	@FindBy(how = How.XPATH, using = "//button[text()='Attach Case To Patient']")
	public WebElement attach_case_to_patient_button;

	// Detach Patient Button
	@FindBy(how = How.XPATH, using = "//button[text()='Detach Patient']")
	public WebElement detach_patient_button;

	// Details Header
	@FindBy(how = How.XPATH, using = "(//li[@title='Details']//a)[2]")
	public WebElement details_header;

	// Message to add patient/hcp/rep on case details page
	@FindBy(how = How.XPATH, using = "//b[text()='Please provide any one field value Account or Hcp or Patient rep before closing the Case.']")
	public WebElement patient_not_added_in_case_page_message;

	// Message to add patient/hcp/rep before closing
	@FindBy(how = How.XPATH, using = "//div[@class='slds-card__body']//b[text()='Please provide any one field value Account or Hcp or Patient rep before closing the Case.']")
	public WebElement patient_not_added_before_closing_message;

	// Case disposition text
	@FindBy(how = How.XPATH, using = "//span[@title='Case Dispositions']//following::span[contains(text(),'CD-')]")
	public WebElement case_disposition_element;

	// Reportable Event blank
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Event Identified']//parent::div//following-sibling::div")
	public WebElement reportable_event_blank;

	// RE Review SLA MET
	@FindBy(how = How.XPATH, using = "//span[text()='RE Review SLA MET']//parent::div//following-sibling::div")
	public WebElement re_review_sla_blank;

	// RE Missed
	@FindBy(how = How.XPATH, using = "//span[text()='RE Missed']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement re_missed_blank;

	// Reviewed By
	@FindBy(how = How.XPATH, using = "//span[text()='Reviewed By']//parent::div//following-sibling::div/span")
	public WebElement reviewed_by_blank;

	// Call Notes
	@FindBy(how = How.XPATH, using = "//span[text()='Call Notes']//parent::div//following-sibling::div/span")
	public WebElement call_notes_blank;

	// Reportable Event Reviewed Datetime
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Event Reviewed Datetime']//parent::div//following-sibling::div")
	public WebElement reportable_event_reviewed_datetime_blank;

	// Reportable Event added
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Event Identified']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement reportable_event_added_text;

	// RE Review SLA MET
	@FindBy(how = How.XPATH, using = "//span[text()='RE Review SLA MET']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement re_review_sla_met_text;

	// Reportable Event Reviewed Datetime
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Event Reviewed Datetime']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement reportable_event_reviewed_datetime_text;

	// Date Received Datetime
	@FindBy(how = How.XPATH, using = "//span[text()='Date Received']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement date_received_text;

	// Third Supporting Document text
	@FindBy(how = How.XPATH, using = "(//dt[text()='Original Date/Time Received:']//preceding-sibling::dd//following-sibling::dd//lst-formatted-text)[3]")
	public WebElement original_date_time_text;

	// Case Doc Review Pending
	@FindBy(how = How.XPATH, using = "//p[text()='Doc Review Pending']//following-sibling::p")
	public WebElement case_doc_review_pending;

	// Doc Review Pending
	@FindBy(how = How.XPATH, using = "//span[text()='Doc Review Pending']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement doc_review_pending_text;

	// Reportable Event not added
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Events']//following-sibling::span[text()='(0)']")
	public WebElement no_reportable_event_added_header;

	// SLA Tracking
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'SLA & Tracking')]")
	public WebElement sla_tracking_header;

	// Special Alerts
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Special Alerts')]")
	public WebElement special_alerts_header;

	// RE Submission & Acknowledgement
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'RE Submission & Acknowledgement')]")
	public WebElement re_submission_and_acknowledgement_header;

	// System Information
	@FindBy(how = How.XPATH, using = "//div[text()='Case']//following::span[contains(text(),'System Information')]")
	public WebElement system_information_header;

	// Case milestones
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Case Milestones')]")
	public WebElement case_milestones;

	// Attachments
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Attachments')]")
	public WebElement attachments;

	// Case Dispositions not added
	@FindBy(how = How.XPATH, using = "//span[text()='Case Dispositions']//following-sibling::span[text()='(0)']")
	public WebElement no_disposition_added_header;

	// Supporting Documents header
	@FindBy(how = How.XPATH, using = "//span[text()='Supporting Documents']//following-sibling::span[text()='(3)']")
	public WebElement supporting_documents_added_header;

	// Reportable Event Identified Picklist Button
	@FindBy(how = How.XPATH, using = "//lightning-combobox[@class='slds-form-element']//div[contains(@class,'slds-dropdown-trigger')]//div")
	public WebElement reportable_event_picklist;

	// Reportable Event Review Header
	@FindBy(how = How.XPATH, using = "//h2//b[text()='Reportable Event Review']")
	public WebElement reportable_event_review_header;

	// Associate Patient/HCP/Patient Rep Header
	@FindBy(how = How.XPATH, using = "//span[text()='Associate Patient/Hcp/Patient Rep']")
	public WebElement associate_patient_hcp_patient_rep_header;

	// Associate Patient radio button
	@FindBy(how = How.XPATH, using = "//span[text()='Patient']//preceding-sibling::span")
	public WebElement associate_patient_radio_button;

	// Associate HCP radio button
	@FindBy(how = How.XPATH, using = "//span[text()='HCP']//preceding-sibling::span")
	public WebElement associate_hcp_radio_button;

	// Associate Patient rep radio button
	@FindBy(how = How.XPATH, using = "//span[text()='Patient Rep']//preceding-sibling::span")
	public WebElement associate_patient_rep_radio_button;

	// Disposition Header
	@FindBy(how = How.XPATH, using = "//h2[text()='New Case Disposition: Inbound Call']")
	public WebElement new_case_disposition_header;

	// Disposition dropdown
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Disposition, --None--']")
	public WebElement disposition_dropdown_option;

	// Reportable Event Identified Combobox value - Yes
	@FindBy(how = How.XPATH, using = "//lightning-base-combobox-item[@data-value='Yes']")
	public WebElement reportable_event_picklist_yes;

	// Reportable Event Identified Combobox value - No
	@FindBy(how = How.XPATH, using = "//lightning-base-combobox-item[@data-value='No']")
	public WebElement reportable_event_picklist_no;

	// Supporting Documents
	@FindBy(how = How.CSS, using = "lst-common-list-internal slot[records-hoverablelink_hoverablelink] span")
	public WebElement all_supporting_documents;

	// View File button at Case level for all documents
	@FindBy(how = How.XPATH, using = "//button[text()='View File']")
	public WebElement view_file_button_case_level;

	// Access denied text
	@FindBy(how = How.XPATH, using = "//Code[text()='AccessDenied']")
	public WebElement access_denied_text;

	// Case is in_progress state under status
	@FindBy(how = How.XPATH, using = "//p[@title='Status']//following-sibling::p//lightning-formatted-text[text()='In_Progress']")
	public WebElement case_in_progress_state;

	// Associate patient
	@FindBy(how = How.XPATH, using = "//button[text()='Associate Account']")
	public WebElement associate_patient_button;

	// None dropdown
	@FindBy(how = How.XPATH, using = "//button//span[text()='--None--']")
	public WebElement field_option_none;

	// Associate case to patient dropdown
	@FindBy(how = How.XPATH, using = "//div[@class='requiredInput']//select[@name='optionSelect']")
	public WebElement associate_case_to_patient_field_dropdown;

	// Associate Case to patient First Name
	@FindBy(how = How.XPATH, using = "//option[text()='FIRST NAME']")
	public WebElement associate_case_to_patient_field_dropdown_first_name;

	// Associate Case to patient First Input textbox
	@FindBy(how = How.XPATH, using = "//div[@class='requiredBlock']//input")
	public WebElement associate_case_to_patient_field_first_name_inputbox;

	// Associate Case to patient First patient searched
	@FindBy(how = How.XPATH, using = "//button[@title='View']")
	public WebElement associate_case_to_patient_first_search_option;
	
	// Associate Case to patient First Name
	@FindBy(how = How.XPATH, using = "//td[@data-label='FIRST NAME']")
	public WebElement associate_case_to_patient_first_name;
	
	// Associate Case to patient Last Name
	@FindBy(how = How.XPATH, using = "//td[@data-label='LAST NAME']")
	public WebElement associate_case_to_patient_last_name;

	// Associate Case to patient - Add Patient Button
	@FindBy(how = How.XPATH, using = "//button[text()='Add Patient']")
	public WebElement associate_case_to_patient_add_patient_button;

	// Associate Case to patient - Attach Button
	@FindBy(how = How.XPATH, using = "//button[text()='Attach']")
	public WebElement associate_case_to_patient_attach_button;

	// First Name
	@FindBy(how = How.XPATH, using = "//span[@title='First Name']")
	public WebElement first_name_dropdown_option;

	// First Input textbox
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter the input']")
	public WebElement first_input_textbox;

	// Search button in Patient/HCP/Patient rep page
	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	public WebElement associate_patient_search_button;

	// Search button in attach case to patient
	@FindBy(how = How.XPATH, using = "//button[text()='SEARCH']")
	public WebElement attach_case_to_patient_search_button;

	// Associate button in Patient/HCP/Patient rep page
	@FindBy(how = How.XPATH, using = "//button[text()='Associate']")
	public WebElement associate_button;

	// Search button in Patient/HCP/Patient rep page
	@FindBy(how = How.XPATH, using = "//label[contains(@class,'slds-radio__label')]")
	public WebElement first_radio_button_for_patient_search;

	// Program 1 created case
	@FindBy(how = How.XPATH, using = "//span[text()='Program']//parent::div//following-sibling::div//span[text()='Program1']")
	public WebElement case_created_for_program_one;

	// Case is populated as Phone
	@FindBy(how = How.XPATH, using = "//span[text()='Call Type']//parent::div//following-sibling::div//lightning-formatted-text[text()='Inbound Call']")
	public WebElement call_type_inbound_call;

	// Case priority
	@FindBy(how = How.XPATH, using = "//p[@title='Priority']//following-sibling::p//lightning-formatted-text[text()='Low']")
	public WebElement case_priority;

	// Inbound case phone
	@FindBy(how = How.XPATH, using = "//div[text()='Case']//parent::h1//following::slot[@name='primaryField']//lightning-formatted-text[text()='Inbound Case:Phone']")
	public WebElement inbound_case_phone;

	// Program 1 value
	@FindBy(how = How.XPATH, using = "//span[text()='Program']//parent::div//following::span[text()='Program1']")
	public WebElement program_one_field;

	// Reportable event identified combobox
	@FindBy(how = How.XPATH, using = "//lightning-combobox[@class='slds-form-element']//div[contains(@class,'slds-dropdown-trigger')]//div[contains(@class,'slds-combobox')]")
	public WebElement reportable_event_identified_combobox;

	// Reportable event identified next button
	@FindBy(how = How.XPATH, using = "//button[@title='Next']")
	public WebElement reportable_event_identified_next_button;

	// New Reportable event Header
	@FindBy(how = How.XPATH, using = "//div[@class='slds-modal__header']//h2['New Reportable Event: Reportable Event']")
	public WebElement new_reportable_event_header;

	// Dose at Intitiation inputbox
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Product Details...']")
	public WebElement dose_at_initiation_inputbox;

	// Case number in reportable event edit page
	@FindBy(how = How.XPATH, using = "//label[text()='Case']//following::input")
	public WebElement case_number_reportable_event_edit_page;

	// Dose at intitiation first option
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'slds-listbox__option-text')]")
	public WebElement dose_at_initiation_option;

	// Reportable Event Reaction button
	@FindBy(how = How.XPATH, using = "//button[text()='Reportable Event Reaction']")
	public WebElement reportable_event_reaction_button;

	// New Reportable event reaction Header
	@FindBy(how = How.XPATH, using = "//div[@class='slds-modal__header']//h2['New Reportable Event Reaction: Reportable Event Reaction']")
	public WebElement new_reportable_event_reaction_header;

	// Reportable Event Type
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Reportable Event Type, --None--']")
	public WebElement reportable_event_type_combobox;

	// Reportable Event Type - PQC
	@FindBy(how = How.XPATH, using = "//span[@title='PQC']")
	public WebElement reportable_event_type_pqc;

	// Supporting Document inputbox
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Supporting Documents...']")
	public WebElement supporting_document_inputbox;

	// supporting document first option
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'slds-listbox__option-text')]")
	public WebElement supporting_document_option;

	// Internal Reportable Event Reference Number Header field
	@FindBy(how = How.XPATH, using = "//p[@title='Internal RE Ref#']")
	public WebElement internal_ref_number_header;

	// Internal Reportable Event Reference Number Header field
	@FindBy(how = How.XPATH, using = "//span[text()='Internal RE Ref#']")
	public WebElement internal_ref_number_field;

	// Internal Reportable Event Reference Number Header field
	@FindBy(how = How.XPATH, using = "//p[@title='Internal RE Ref#']//following-sibling::p")
	public WebElement internal_ref_number_header_text;

	// Reportable Event Header
	@FindBy(how = How.XPATH, using = "//h1//div[text()='Reportable Event']")
	public WebElement reportable_event_header;

	// Person account Header
	@FindBy(how = How.XPATH, using = "//div[text()='Person Account']")
	public WebElement person_account_header;

	// Reportable Event Comments
	@FindBy(how = How.XPATH, using = "//label[text()='Reportable Event Comments']//following::textarea")
	public WebElement reportable_event_comments_textarea;

	// Reportable Event Comments textfield
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Event Comments']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement reportable_event_comments_textfield;

	// Reportable Event Text in RE Reaction page
	@FindBy(how = How.XPATH, using = "//span[text()='Reportable Event']//parent::div//following-sibling::div//slot//span")
	public WebElement reportable_event_text_reaction_page;

	// Source label
	@FindBy(how = How.XPATH, using = "//label[text()='Source']")
	public WebElement source_label_re_edit_page;

	// Case Number added
	@FindBy(how = How.XPATH, using = "//span[text()='Case Number']//parent::div//following-sibling::div//lightning-formatted-text")
	public WebElement case_number_text;
	
	// Patient added
	@FindBy(how = How.XPATH, using = "//span[text()='Account Name']//parent::div//following-sibling::div//slot//span")
	public WebElement patient_name_text;
	
	// Person Account 
	@FindBy(how = How.XPATH, using = "//div[text()='Person Account']//parent::h1//following::slot//lightning-formatted-name")
	public WebElement person_account_text;
	
	// Status text in Case header
	@FindBy(how = How.XPATH, using = "//p[text()='Status']//following::p//lightning-formatted-text")
	public WebElement case_header_status_field_text;

}