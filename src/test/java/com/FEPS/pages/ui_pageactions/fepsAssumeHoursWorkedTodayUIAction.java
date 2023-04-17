package com.FEPS.pages.ui_pageactions;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.pages.ui.pageobjects.fepsAssumeHoursWorkedTodayObject;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

import io.cucumber.java.Scenario;

public class fepsAssumeHoursWorkedTodayUIAction extends fepsAssumeHoursWorkedTodayObject {

	public WebDriver driver;
	public Scenario scenario;
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	public JavaScriptActions js = new JavaScriptActions(driver);

	public fepsAssumeHoursWorkedTodayUIAction(WebDriver driver, Scenario scenario) {
		super(driver);
		this.driver = driver;
		this.scenario = scenario;
	}
	
		
		public void navigateToAssumeHoursWorkedToday(String company_code_dropdown_value, String sbu_dropdown_value) throws InterruptedException {
			new WebDriverWait(driver, Duration.ofSeconds(45))
	        .until(ExpectedConditions.visibilityOf(assumedHoursWorkedToday));
			new WebDriverWait(driver, Duration.ofSeconds(45))
	        .until(ExpectedConditions.elementToBeClickable(assumedHoursWorkedToday)).click();
			//Switching to frame
			driver.switchTo().defaultContent();
			commonMethods.switch_to_criteria_selection_frame();
			Logger("User navigates to Assume Hours WorkedToday page successfully");
			commonMethods.clickOnCriteriaAssumeHoursDropdown(Company_Code,company_code_dropdown_value);
			commonMethods.clickOnCriteriaAssumeHoursDropdown(SBU,sbu_dropdown_value);
			
	}
		
		public void user_clicks_on_generateReport() {
			new WebDriverWait(driver, Duration.ofSeconds(30))
	        .until(ExpectedConditions.elementToBeClickable(generateReport)).click();
		}		
		public void checkForPageTitle() {
			new WebDriverWait(driver, Duration.ofSeconds(45))
	        .until(ExpectedConditions.visibilityOf(checkPageTitle));
			Assert.assertEquals(checkPageTitle.getText(),"Assumed Hours Worked Todays" );
		}
		public void clickOnShowHirearcy() throws InterruptedException {
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(clickOnShowHirearcy));
			Thread.sleep(3);
		}
		public void clickOnFeedback() throws InterruptedException{
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(clickOnFeedback)).click();
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		}
		
		public void enterFeedBackInAssumedHoursWorkedToday() throws InterruptedException {
			 new WebDriverWait(driver, Duration.ofSeconds(30))
			 .until(ExpectedConditions.visibilityOf(enterFeedBackInAssumedHoursWorkedToday)).sendKeys("Assumed Hours feedback tesed");
			  
			 	
			 try {
				 WebElement five_star_rating_element = driver.findElement(By.xpath("//a[@class='lnk_rating_unselected5']"));
				 new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.elementToBeClickable(five_star_rating_element));
				 js.jsClick(five_star_rating_element);
			 }
			 catch(org.openqa.selenium.NoSuchElementException e) {
				 System.out.println("Rating is already selected!");
				 WebElement five_star_rating_selected = driver.findElement(By.xpath("//a[@class='lnk_rating_selected5']"));
				 Assert.assertTrue(five_star_rating_selected.isDisplayed());
			 }
			 
		}
		
		public void clickOnSubmit(){
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(clickOnSubmit)).click();
			driver.switchTo().defaultContent();
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.invisibilityOf(feedBackSuccessMessage));
		}
		
		
		public void clickOnHelp(){
			new WebDriverWait(driver, Duration.ofSeconds(30))
			.until(ExpectedConditions.elementToBeClickable(clickOnHelp)).click();
//			new WebDriverWait(driver, Duration.ofSeconds(30))
//			.until(ExpectedConditions.visibilityOf(assumedHelpPopUpTitle));
//			Assert.assertEquals(assumedHelpPopUpTitle.getText(),"FEPS Help - Assumed Hours Worked Today" );
//			new WebDriverWait(driver, Duration.ofSeconds(30))
//			.until(ExpectedConditions.elementToBeClickable(clickOnCloseAssumePopUp)).click();
			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		      //switch to new tab
		      driver.switchTo().window(newTb.get(1));
		     
		      System.out.println("Page title of new tab: " + driver.getCurrentUrl());
		      //switch to parent window
		      driver.switchTo().window(newTb.get(0));
		      System.out.println("Page title of parent window: " + driver.getCurrentUrl());
		    
		}
	}


