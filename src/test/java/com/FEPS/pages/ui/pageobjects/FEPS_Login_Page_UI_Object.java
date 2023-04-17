package com.FEPS.pages.ui.pageobjects;

/**
 * Author : Cheerala Rachana
 * Email id  : cheerala.rachana@conduent.com
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.FEPS.pages.PageBase;

public class FEPS_Login_Page_UI_Object extends PageBase {

	public FEPS_Login_Page_UI_Object(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='UARLogOnBtn']")
	public WebElement Login_through_sso;

	// CommonOrg Login Screen - Username TextField
	@FindBy(how = How.XPATH, using = "//input[@id='Ecom_User_ID']")
	public WebElement userName_txtField;

	// CommonOrg Login Screen - Password TextField
	@FindBy(how = How.XPATH, using = "//input[@id='Ecom_Password']")
	public WebElement password_txtField;

	// CommonOrg Login Screen - Submit Button
	@FindBy(how = How.XPATH, using = "//span[@id='loginButton2']")
	public WebElement login_Btn;


	public String menu_item_string = "//a//span[text()='menu_item']";

}
