package com.FEPS.pages.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.FEPS.pages.PageBase;

/**
 * Author : JeevanKumar K V Email id : jeevankumar.kv@conduent.com
 */

public class FEPS_Home_Page_UI_Object extends PageBase {

	public FEPS_Home_Page_UI_Object(WebDriver driver) {
		super(driver);
	}

	// Sandbox:
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sandbox:")
	public WebElement login_as_system_message;

	// Document Intake Case
	@FindBy(how = How.XPATH, using = "//a[text()='']//ancestor::tr//span[text()='New']//ancestor::tr//a[@data-refid='recordId']")
	public WebElement document_intake_case;
	
	public static String document_intake_case1 = "//a[text()='']//ancestor::tr//a[@data-refid='recordId']";
	

	// Document Intake Case Header
	@FindBy(how = How.XPATH, using = "//h1/div[text()='Case']")
	public WebElement document_intake_case_header;
	
	// Document Intake Case Header
	@FindBy(how = How.XPATH, using = "//div[text()='Case']//parent::h1//slot//lightning-formatted-text")
	public WebElement case_number;

	// Drop down button
	@FindBy(how = How.CSS, using = "button[title='Select a List View']")
	public WebElement select_a_list_view;
	
	// Drop down for  Program 1
	@FindBy(how = How.XPATH, using = "//a[@role='option']//span[text()='ABCCompany Program1 Queue']")
	public WebElement dropdown_for_program_one;
	
	// Drop down for  Program 2
	@FindBy(how = How.XPATH, using = "//a[@role='option']//span[text()='ABCCompany Program2 Queue']")
	public WebElement dropdown_for_rb_program;
	
	// Drop down for  Document Intake
	@FindBy(how = How.XPATH, using = "//a[@role='option']//span[text()='Document Intake']")
	public WebElement dropdown_for_doc_intake;
	
	// Document Intake Case Program 2
	@FindBy(how = How.XPATH, using = "//th//a[@data-refid='recordId']")
	public WebElement case_for_rb_program;
	
	// Case which is In-progress and Inbound case phone
	@FindBy(how = How.XPATH, using = "//a[text()='Inbound Case:Phone']//ancestor::tr//span[text()='In_Progress']//ancestor::tr//a[@data-refid='recordId']")
	public WebElement inbound_case_in_progress;
	
	// Case which is Closed and Inbound case phone
	@FindBy(how = How.XPATH, using = "//a[text()='Inbound Case:Phone']//ancestor::tr//span[text()='Closed']//ancestor::tr//a[@data-refid='recordId']")
	public WebElement inbound_case_closed;
	
	public static String inbound_case_in_progress1 = "//a[text()='Inbound Case:Phone']//ancestor::tr//span[text()='In_Progress']//ancestor::tr//a[@data-refid='recordId']";
	public static String inbound_case_closed1 = "//a[text()='Inbound Case:Phone']//ancestor::tr//span[text()='Closed']//ancestor::tr//a[@data-refid='recordId']";
	
	// Case which is In-progress and Doc intake
	@FindBy(how = How.XPATH, using = "//a[text()='']//ancestor::tr//span[contains(text(),'Progress')]//ancestor::tr//a[@data-refid='recordId']")
	public WebElement document_case_in_progress;
	
	// Incontact api Phone Icon
	@FindBy(how = How.CSS, using = "button lightning-icon.slds-icon-utility-call")
	public WebElement incontact_api_phone_number_icon;
	
	// Omni Channel Icon
	@FindBy(how = How.CSS, using = "button lightning-icon.slds-icon-utility-routing-offline")
	public WebElement omni_channel_icon;
	
	// User session Icon
	@FindBy(how = How.CSS, using = "button lightning-icon.slds-icon-utility-fallback ")
	public WebElement user_session_icon;
	
	// Incontact api Phone Icon status Logged out
	@FindBy(how = How.XPATH, using = "//lightning-icon//following-sibling::span[text()='Logged out']")
	public WebElement incontact_api_phone_number_status_logged_out;
	
	// Sign In Header for max agent
	@FindBy(how = How.XPATH, using = "//div[@class='login-form-header'][text()='Sign In']")
	public WebElement sign_in_header_for_max_agent;
	
	//Dropdown for Omni channel
	@FindBy(how = How.XPATH, using = "//span[text()='Change your Omni-Channel status']//ancestor::button")
	public WebElement omni_channel_dropdown;
	
	// Username textbox for max agent
	@FindBy(how = How.CSS, using = "input[id='agentNameId']")
	public WebElement incontact_agent_username_textbox;
	
	// Password textbox for max agent
	@FindBy(how = How.CSS, using = "input[id='agentPwdId']")
	public WebElement incontact_agent_password_textbox;
	
	// Sign in button for max agent
	@FindBy(how = How.CSS, using = "input[value='Sign In']")
	public WebElement incontact_agent_sign_in_button;
	
	// Save Button in incontact option screen
	@FindBy(how = How.CSS, using = "div[title='Save']")
	public WebElement save_button_incontact_option_screen;
	
	//INCONTACT HOME PAGE ICONS
	
	// Dial pad Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeDialPadIconId']")
	public WebElement dial_pad_icon_incontact_screen;
	
	// Agents Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeAgentsIconId']")
	public WebElement agents_icon_incontact_screen;
	
	// Skills Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeSkillsIconId']")
	public WebElement skills_icon_incontact_screen;
	
	// Address Book Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeAddressBookIconId']")
	public WebElement address_icon_incontact_screen;
	
	// Contact History Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeContactHistoryIconId']")
	public WebElement contact_history_icon_incontact_screen;
	
	// Agent Information Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='HomeAgentInfoIconId']")
	public WebElement agent_info_icon_incontact_screen;
	
	// Email Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='HomeOBEmailIconDiv']")
	public WebElement ob_email_icon_incontact_screen;

	// Commitment Manager Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='HomePromiseKeeperIconDiv']")
	public WebElement commitment_manager_icon_incontact_screen;
	
	// Agent Reports Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeAgentReportsIconId']")
	public WebElement agent_report_icon_incontact_screen;
	
	// Messages Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeMessageIconId']")
	public WebElement messages_icon_incontact_screen;
	
	// Help Icon in incontact screen
	@FindBy(how = How.CSS, using = "[id='homeHelpIconId']")
	public WebElement help_icon_incontact_screen;
	
	// State for agent in incontact screen
	@FindBy(how = How.ID, using = "cStatePanelId")
	public WebElement state_panel;
	
	// Options header title
	@FindBy(how = How.XPATH, using = "//div[@id='optionHeaderTxtId'] [text()='Options']")
	public WebElement options_header_title;
	
	// Integrated Softphone title
	@FindBy(how = How.XPATH, using = "//div[text()='Integrated Softphone :']")
	public WebElement integrated_softphone_text;
	
	// Integrated Softphone option
	@FindBy(how = How.XPATH, using = "//div[@class='userValue'][text()='WebRTC']")
	public WebElement integrated_softphone_option_text;
	
	// Submit Feedback title
	@FindBy(how = How.XPATH, using = "//div[@title='Submit Feedback']")
	public WebElement submit_feedback_title;
	
	// Log Level title
	@FindBy(how = How.XPATH, using = "//div[@title='Log Level']")
	public WebElement log_level_title;
	
	// Log Level option text
	@FindBy(how = How.XPATH, using = "//div[@class='userValue'][text()='ERROR']")
	public WebElement log_level_option_text;
	
	// Edit button in options screen
	@FindBy(how = How.XPATH, using = "//div[@title='Edit']")
	public WebElement edit_button_options_screen;
	
	// SoftPhone volume title
	@FindBy(how = How.XPATH, using = "//div[@title='Softphone Volume']")
	public WebElement softphone_volume_title;
	
	// SoftPhone volume control slider
	@FindBy(how = How.XPATH, using = "//div[@class='volumeControl']")
	public WebElement softphone_volume_control_slider;
	
	// Log out button options screen
	@FindBy(how = How.XPATH, using = "//div[@id='logoutBtnId'][@title='Logout']")
	public WebElement logout_button_options_screen;
	
	// Download log button options screen
	@FindBy(how = How.XPATH, using = "//div[@id='downloadBtnId'][@title='Download Log']")
	public WebElement download_log_button_options_screen;
	
	// Audio header in settings
	@FindBy(how = How.XPATH, using = "//div[@class='settingsHeader']//span[text()='Audio']")
	public WebElement audio_header;
	
	// New agent message under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Audio']//following-sibling::div[@class='settingsLabelDiv']/input[@title='New agent message']")
	public WebElement new_agent_message_under_audio;
	
	// New contacts under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Audio']//following-sibling::div[@class='settingsLabelDiv']/input[@title='New contacts']")
	public WebElement new_contacts_under_audio;
	
	// New chat message under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Audio']//following-sibling::div[@class='settingsLabelDiv']/input[@title='New chat message']")
	public WebElement new_chat_message_under_audio;
	
	// end chat or call under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Audio']//following-sibling::div[@class='settingsLabelDiv']/input[@title='End chat or call']")
	public WebElement end_chat_or_call_under_audio;
	
	// Visual header in settings
	@FindBy(how = How.XPATH, using = "//div[@class='settingsHeader']//span[text()='Visual']")
	public WebElement visual_header;
	
	// New agent message under Visual header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Visual']//following-sibling::div[@class='settingsLabelDiv']/input[@title='New agent message']")
	public WebElement new_agent_message_under_visual;
	
	// New contacts under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Visual']//following-sibling::div[@class='settingsLabelDiv']/input[@title='New contacts']")
	public WebElement new_contacts_under_visual;
	
	// New chat message under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Visual']//following-sibling::div[@class='settingsLabelDiv']/input[@title='New chat message']")
	public WebElement new_chat_message_under_visual;
	
	// end chat or call under Audio header
	@FindBy(how = How.XPATH, using = "//div/span[text()='Visual']//following-sibling::div[@class='settingsLabelDiv']/input[@title='End chat or call']")
	public WebElement end_chat_or_call_under_visual;

	

}
