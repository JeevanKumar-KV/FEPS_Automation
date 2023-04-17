package com.FEPS.pages.ui_pageactions;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.pages.ui.pageobjects.FEPS_Time_Absence_Report_UI_Object;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

import io.cucumber.java.Scenario;

public class FEPS_Time_Absence_Report_UI_Action extends FEPS_Time_Absence_Report_UI_Object {

	public WebDriver driver;
	public Scenario scenario;
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	public JavaScriptActions js = new JavaScriptActions(driver);

	public FEPS_Time_Absence_Report_UI_Action(WebDriver driver, Scenario scenario) {
		super(driver);
		this.driver = driver;
		this.scenario = scenario;
	}
	
		
		public void navigate_to_Absence(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value) throws InterruptedException {
			new WebDriverWait(driver, Duration.ofSeconds(45))
	        .until(ExpectedConditions.visibilityOf(Absence_report));
			new WebDriverWait(driver, Duration.ofSeconds(45))
	        .until(ExpectedConditions.elementToBeClickable(Absence_report)).click();
			//Switching to frame
			driver.switchTo().defaultContent();
			commonMethods.switch_to_criteria_selection_frame();
			Logger("User navigates to Absence Report page successfully");
			commonMethods.click_on_absence_dropdown(Company_Code,company_code_dropdown_value);
			commonMethods.click_on_absence_dropdown(SBU,sbu_dropdown_value);
			commonMethods.click_on_absence_dropdown(Dates,dates_dropdown_value);
	}
		
		public void user_enter_absence(String Date1, String Date2) {
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
		
		public void user_clicks_on_generateReport() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.elementToBeClickable(generateReport)).click();
		}
		
		public void CheckCC() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.visibilityOf(absencePagetitle));
			Assert.assertEquals(CheckCC.getText(),"BPS" );
		}
		
		public void enableFavorite() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(enableFavorite)).click();
			//Assert.assertEquals(enableFavorite.getText(),"BPS" );
		}
		public void clickOnEmployeeHyerlink() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(clickOnEmployeeHyerlink)).click();
			//Assert.assertEquals(enableFavorite.getText(),"BPS" );
		}
		public void checkPageName() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(checkPageName));
			Assert.assertEquals(checkPageName.getText(),"Absence Detail" );
		}
		public void clickOnDateHyperLink() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(clickOnDateHyperLink));
			//Assert.assertEquals(clickOnDateHyperLink.getText(),"20386346" );
		}
		public void checkEmployeeID() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(checkEmployeeID));
			Assert.assertEquals(checkEmployeeID.getText(),"20386346" );
		}
		public void checkAbsenceFavorite() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.visibilityOf(absenceFavorite));
		}
		public void clickOnLogout() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.elementToBeClickable(clickOnLogout)).click();
		}
		
		
	}


