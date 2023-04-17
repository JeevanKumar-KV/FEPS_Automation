package com.FEPS.interfaces;

import com.FEPS.configuration.browser.BrowserType;

public interface IconfigReader {

	/**
	 * Get the username from config
	 *
	 * @return the Username
	 */
	public String getUserName();

	/**
	 * Get the password from config
	 *
	 * @return the Password
	 */
	public String getPassword();

	/**
	 *
	 * @return the Page Load TimeOut
	 */
	public int getPageLoadTimeOut();

	/**
	 * Get the Implicit Wait time from config
	 *
	 * @return the Implicit Wait time
	 */
	public int getImplicitWait();

	/**
	 * Get the Explicit Wait time from config
	 *
	 * @return the Explicit Wait time
	 */
	public int getExplicitWait();

	/**
	 * Get the Browser from config
	 *
	 * @return the Browser
	 */
	public BrowserType getBrowser();

	/**
	 * Get the Environment from config
	 *
	 * @return the Environment
	 */
	public String get_Env();

	/**
	 * Get the username based on role
	 * 
	 * @return Role based username
	 */
	public String get_Role_Based_UserName();

	/**
	 * Get the password based on username role
	 * 
	 * @return Role based password
	 */
	public String get_Role_Based_Password();

	/**
	 * Get the password based on username role
	 * 
	 * @return Role based password
	 */
	public String get_Role_Based_Password(String password);

	/**
	 * Get the Common Org QA website from config This is used for Common Org UI
	 * testing
	 * 
	 * @return the Common Org website url
	 */
	public String get_FEPS_Website_URL();

	public String getPlatform();

	/********** Appium Capabilities *********/

	public String get_Mobile_OS();

	public String getDeviceName();

	public String getPlatformName();

	public String getPlatformVersion();

	public String getautomationName();

	public String getbrowserName();

	public String getnoResetProperty();

	public String getAppiumServerURL();

	/**
	 * Get geolocatiion setting for browser from config file
	 *
	 */
	public String getLocationShareSetting();
	
	//-----------API-------------------------
	
	//----------- Bearer Token Related Details -------------------------
	public String get_Bearer_Base_Api_Url();

	public String get_Bearer_endPoint_Url();

	public String get_Bearer_Username();

	public String get_Bearer_Password();

	public String get_Bearer_Client_Id();

	public String get_Bearer_Client_Secret();

	// --------------------Case Creation Api Url ----------------------------------------
	public String get_Case_Creation_Base_Api_Url();
	public String get_Case_Creation_Api_Endpoint_Url();


	//---------------------- OCR Process Api URL ----------------------------------------
	public String get_OCR_Process_Base_Api_Url();

	public String get_OCR_Process_Endpoint_Api_Url();
	
	//----------- InContact Bearer Token Related Details --------------------------------
	public String get_InContact_Bearer_Base_Api_Url();

	public String get_InContact_Bearer_EndPoint_Api_Url();
	
	//----------------------------------------------------------------------------------
	
	//----------- InContact Agent Details --------------------------------
	public String get_InContact_Agent_Id();
	
	public String get_InContact_Agent_Session_Base_Api_Url();
	
	public String get_InContact_Agent_Session_EndPoint_Api_Url();
	
	public String get_InContact_Agent_Leg_Connection_EndPoint_Api_Url();

}
