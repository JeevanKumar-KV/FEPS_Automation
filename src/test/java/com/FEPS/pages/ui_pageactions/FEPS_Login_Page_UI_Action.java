package com.FEPS.pages.ui_pageactions;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.pages.ui.pageobjects.FEPS_Login_Page_UI_Object;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

import io.cucumber.java.Scenario;

public class FEPS_Login_Page_UI_Action extends FEPS_Login_Page_UI_Object {

	public WebDriver driver;
	public Scenario scenario;
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	public JavaScriptActions js = new JavaScriptActions(driver);

	public FEPS_Login_Page_UI_Action(WebDriver driver, Scenario scenario) {
		super(driver);
		this.driver = driver;
		this.scenario = scenario;
	}

	public void execution_details(String module) {
		Logger("Launching the URL ");
		Logger("Env : " + ObjectRepo.reader.get_Env().toUpperCase());
		Logger("Platform : " + ObjectRepo.Platform.toUpperCase());
		// Logger("Logged In Username : " + ObjectRepo.role_Based_UserName);
	}

	public void verify_CommonOrg_Login_Page_Title() {
		System.out.println("Common Org Title :" + driver.getTitle().toString());
		Assert.assertEquals(driver.getTitle().toString(), "FEPS Landing",
				"Failed - Due to CommonOrg Login Page title mismatch");
	}
	
	public void login_through_SSO() throws InterruptedException {
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.elementToBeClickable(Login_through_sso)).click();
      
        Logger("User successfully Logged in FEPS login page.");
        
	}

	public void user_logs_in_with_credentials(String string) {
		if (string != null && !string.trim().isEmpty()) {
			System.out.println("Provided agent credentials " + string + " will be taken");
			enter_Username_In_CommonOrg_login_Page(string);
		} else {
			System.out.println("Default credentials will be taken");
			enter_Username_In_CommonOrg_login_Page(ObjectRepo.reader.get_Role_Based_UserName().trim());
			enter_Password_In_CommonOrg_login_Page(ObjectRepo.reader.get_Role_Based_Password("Agent").trim());
		}
	}

	public boolean verify_UserName_TxtField_isDiplayed_And_Enabled_On_CommonOrg_Login_Page() {
		Assert.assertTrue(userName_txtField.isDisplayed(),
				"Failed - Username TextField is not displayed on CommonOrg Login Page");
		Assert.assertTrue(userName_txtField.isEnabled(),
				"Failed - Due to Username TextField is not Enabled on CommonOrg Login Page");
		return true;
	}

	public boolean verify_Password_TxtField_isDiplayed_And_Enabled_On_CommonOrg_Login_Page() {

		Assert.assertTrue(password_txtField.isDisplayed(),
				"Failed - Due to Password TextField is not displayed on CommonOrg Login Page");
		Assert.assertTrue(password_txtField.isEnabled(),
				"Failed - Due to Password TextField is not Enabled on CommonOrg Login Page");
		return true;
	}

	public void enter_Username_In_CommonOrg_login_Page(String username) {
		userName_txtField.clear();
		System.out.println("Role_Based_UserName : " + username);
		userName_txtField.sendKeys(username);
		Logger("Logging into Common Org site with username : " + username);
	}

	public void enter_Password_In_CommonOrg_login_Page(String password) {
		password_txtField.clear();
		password_txtField.sendKeys(password);
	}

	public void click_On_CommonOrg_login_button() throws InterruptedException {
		login_Btn.click();
	}

	public void commonOrg_Page_Login() throws InterruptedException {

		if (verify_UserName_TxtField_isDiplayed_And_Enabled_On_CommonOrg_Login_Page()) {
//			enter_Username_In_CommonOrg_login_Page();
//			enter_Password_In_CommonOrg_login_Page();
//			click_On_CommonOrg_login_button();
		}

	}

	//public void login_to_CommonOrg_with_security_code() throws InterruptedException {
		//try {
			//ObjectRepo.driver.findElement(By.xpath("//a[text()='Remind Me Later']")).click();
			//Assert.assertTrue(
				//	ObjectRepo.driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
			//System.out.println("Logged In Succesfully");
		//} catch (NoSuchElementException Ex) {
			//try {
				//Assert.assertTrue(
					//	ObjectRepo.driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
				//System.out.println("Logged In Succesfully");
			//} catch (UnhandledAlertException e) {
				//ObjectRepo.driver.switchTo().alert().accept();
			//} catch (NoSuchElementException e) {
				//try {
					//ObjectRepo.driver.findElement(By.xpath("//a[text()='here']")).click();
					//System.out.println("Logged In Succesfully");
				//} catch (NoSuchElementException e1) {
					//System.out.println("Enter The OTP");
					//String OTPtoEnter;
					//OTPtoEnter = EmailUtility.get_OTP_From_Outlook("pramukha.bharadwaj@conduent.com", "ConJan@22");
					//Thread.sleep(2000);
					//System.out.println("THE OTP is " + OTPtoEnter);
					//verification_code_textbox.sendKeys(OTPtoEnter);
					//verify_button.click();
					//Logger("Logging into Common Org Application after entering Security code.");
				//}
			//}

		//} catch (UnhandledAlertException e) {
			//Assert.assertTrue(
			//		ObjectRepo.driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
		//}
	//}

	public void verify_CommonOrg_Page_Login_isSuccessfull() throws InterruptedException {
		boolean flag = false;

		if (!(isAlertPresent())) {
			flag = true;
		}

		if (flag) {
			Assert.assertTrue(true);
			Logger("Successfully Logged into Common Org Application");

		} else {
			Logger("Failed - Unable to Login into CommonOrg  Application due to Invalid Credentials");
			Assert.fail("Failed - Unable to Login into CommonOrg Application due to Invalid Credentials");
		}
	}

//	public void veify_logged_In() throws InterruptedException {
//		Thread.sleep(2000);
//		Assert.assertTrue(login_as_system_message.isDisplayed());
//	}

}
