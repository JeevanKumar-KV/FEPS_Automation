package com.FEPS.pages;
//Jeevan updated once again

import java.text.ParseException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FEPS.settings.ObjectRepo;

import io.cucumber.java.Scenario;

public class CommonMethods {

	public WebDriver driver;
	public Scenario scenario;

	public CommonMethods(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
	}

	public void closeAllTabs() {

		long noOfInactiveTabs;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e2) {
			e2.printStackTrace();
		}
		noOfInactiveTabs = (long) js.executeScript(
				"return document.querySelectorAll(\"a[class^='tabHeader slds-context-bar__label-action'][aria-selected='false']\").length;");
		int tabsCnt = (int) noOfInactiveTabs;
		System.out.println("No of tabs opened are " + noOfInactiveTabs);

		for (int i = 0; i < tabsCnt; i++) {
			try {
				Thread.sleep(2000);
				js.executeScript(
						"document.querySelectorAll(\"a[class^='tabHeader slds-context-bar__label-action'][aria-selected='false']\")[0].parentNode.querySelectorAll(\"div[class^='close slds-col--bump-left slds-p-left--none slds-context-bar__icon-action']\")[0].querySelector(\"button\").click();");
			} catch (Exception e) {

				System.out.println("No tabs are opened");
				try {
					driver.switchTo().alert().dismiss();
				} catch (NoAlertPresentException e2) {
					e2.printStackTrace();
				}
			}

		}

		// document.querySelectorAll("a[class^='tabHeader
		// slds-context-bar__label-action'][aria-selected='false']")[0].parentNode.querySelectorAll("div[class^='close
		// slds-col--bump-left slds-p-left--none
		// slds-context-bar__icon-action']")[0].querySelector("button").click();

	}

	public void switch_to_criteria_selection_frame() {
		// Frame switch
		WebElement frame_element = ObjectRepo.driver.findElement(By.xpath("//iframe[@name='CriteriaControl']"));
		new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(40))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame_element));
	}

	public void click_on_time_card_dropdown(WebElement dropdown_element, String dropdown_value) {
		// Frame switch
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(dropdown_element)).click();
		// CLick on dropdown value - eg:BPS
		WebElement company_code_element = driver
				.findElement(By.xpath("//div[@class='select2-result-label'][text()='" + dropdown_value + "']"));
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(company_code_element));
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(company_code_element)).click();
	}

	public void click_on_time_clock_activity_dropdown(WebElement dropdown_element, String dropdown_value) {
		// Frame switch
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(dropdown_element)).click();
		// CLick on dropdown value - eg:BPS
		WebElement company_code_element = driver
				.findElement(By.xpath("//div[@class='select2-result-label'][text()='" + dropdown_value + "']"));
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(company_code_element));
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(company_code_element)).click();
	}
	public void click_on_absence_dropdown(WebElement dropdown_element, String dropdown_value) {
		// Frame switch
		new WebDriverWait(driver, Duration.ofSeconds(25 ))
				.until(ExpectedConditions.elementToBeClickable(dropdown_element)).click();
		// CLick on dropdown value - eg:BPS
		WebElement company_code_element = driver
				.findElement(By.xpath("//div[@class='select2-result-label'][text()='" + dropdown_value + "']"));
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(company_code_element));
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(company_code_element)).click();
	}
	public void clickOnCriteriaAssumeHoursDropdown(WebElement dropdown_element, String dropdown_value) {
		// Frame switch
		new WebDriverWait(driver, Duration.ofSeconds(25 ))
				.until(ExpectedConditions.elementToBeClickable(dropdown_element)).click();
		// CLick on dropdown value - eg:BPS
		WebElement company_code_element = driver
				.findElement(By.xpath("//div[@class='select2-result-label'][text()='" + dropdown_value + "']"));
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(company_code_element));
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(company_code_element)).click();
	}
	
	public void user_clicks_on_dashboard() {
		WebElement clickOnDashboard = driver
				.findElement(By.xpath("//a[@id ='ctl00_ctl00_FEPSTitleCph_SiteToolBar_DashboardLnk']"));
		new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.elementToBeClickable(clickOnDashboard)).click();
	}
	

	public static String generate_time() throws ParseException {
	 String hour,min;
	 hour = randomBetween(1,12);
	 min = randomBetween(0,59);
	String time = hour+":"+min;
     return time;
	}

	public static String randomBetween(int start, int end) {
	 Integer random;
     random = start + (int)Math.round(Math.random() * (end - start));
	 return random.toString();
	}

}