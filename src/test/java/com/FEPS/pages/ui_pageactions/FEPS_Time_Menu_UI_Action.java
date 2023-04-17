package com.FEPS.pages.ui_pageactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.pages.ui.pageobjects.FEPS_Time_Menu_UI_Object;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

import io.cucumber.java.Scenario;

public class FEPS_Time_Menu_UI_Action extends FEPS_Time_Menu_UI_Object {

	public WebDriver driver;
	public Scenario scenario;
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	public JavaScriptActions js = new JavaScriptActions(driver);

	public FEPS_Time_Menu_UI_Action(WebDriver driver, Scenario scenario) {
		super(driver);
		this.driver = driver;
		this.scenario = scenario;
	}
	
	public void navigate_to_menu(String menu_item) throws InterruptedException {
		new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.visibilityOf(Time_menu));
		String a = menu_item_string.replace("menu_item",menu_item);
		WebElement menu_item_element = driver.findElement(By.xpath(a));
		menu_item_element.click();
		Logger("User navigates to Time menu page successfully");
	}


	

}
