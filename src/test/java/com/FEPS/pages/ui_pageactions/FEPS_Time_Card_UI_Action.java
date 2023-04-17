package com.FEPS.pages.ui_pageactions;


import java.time.Duration;


/**
 * Author : Balaji Singh
 * Email id  : balaji.singhy@conduent.com
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.pages.ui.pageobjects.FEPS_Time_Card_UI_Object;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

import io.cucumber.java.Scenario;

public class FEPS_Time_Card_UI_Action extends FEPS_Time_Card_UI_Object {

	
	public WebDriver driver;
	public Scenario scenario;
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	public JavaScriptActions js = new JavaScriptActions(driver);

	public FEPS_Time_Card_UI_Action(WebDriver driver, Scenario scenario) {
		super(driver);
		this.driver = driver;
		this.scenario = scenario;
	}

	public void navigate_to_Time_Card(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value) throws InterruptedException {
//		new WebDriverWait(driver, Duration.ofSeconds(45))
//        .until(ExpectedConditions.visibilityOf(Time_Card));
		new WebDriverWait(driver, Duration.ofSeconds(45))
        .until(ExpectedConditions.elementToBeClickable(Time_Card)).click();
		//Switching to frame
		commonMethods.switch_to_criteria_selection_frame();
		Logger("User navigates to Time Card page successfully");
		commonMethods.click_on_time_card_dropdown(Company_Code,company_code_dropdown_value);
		commonMethods.click_on_time_card_dropdown(SBU,sbu_dropdown_value);
		commonMethods.click_on_time_card_dropdown(Dates,dates_dropdown_value);
	}
	
	public void user_enter(String Date1, String Date2) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
	    .until(ExpectedConditions.visibilityOf(Date1_Textfield));
		new WebDriverWait(driver, Duration.ofSeconds(30))
	    .until(ExpectedConditions.elementToBeClickable(Date1_Textfield)).click();
         Date1_Textfield.clear();
         Date1_Textfield.sendKeys(Date1);
         new WebDriverWait(driver, Duration.ofSeconds(30))
 	    .until(ExpectedConditions.visibilityOf(Date2_Textfield));
 		new WebDriverWait(driver, Duration.ofSeconds(30))
 	    .until(ExpectedConditions.elementToBeClickable(Date2_Textfield)).click();
         Date2_Textfield.clear();
         Date2_Textfield.sendKeys(Date2);
	}
	
	public void clicks_on_submit() {
		new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
	
	

}
