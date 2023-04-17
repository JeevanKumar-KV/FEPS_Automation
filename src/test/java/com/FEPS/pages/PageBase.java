package com.FEPS.pages;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.DateTimeHelper;
import com.FEPS.utility.EncryptDecryptHelper;
import com.FEPS.utility.LoggerHelper;

import io.cucumber.java.Scenario;



public abstract class PageBase {

    private final Logger log = LoggerHelper.getLogger(PageBase.class);
    public Scenario scenario = ObjectRepo.scenario;
    protected WebDriver driver;
    public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);
    public JavaScriptActions jsActions = new JavaScriptActions(ObjectRepo.driver);
    public DateTimeHelper dateTimeHelper = new DateTimeHelper();
    public EncryptDecryptHelper encryptDecryptHelper = new EncryptDecryptHelper();


    public PageBase(WebDriver driver) {
        if (driver == null)
            throw new IllegalArgumentException("Driver object is null");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        this.driver = driver;
    }

    public String getURL() {
        return (driver.getCurrentUrl());
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    //returns random String containing only characters of length 'len'
    public static String randomString(int len) {
        return RandomStringUtils.random(len, true, false);
    }

    //returns random String containing only numbers of length 'len'
    public String randomNumber(int len) {
        return RandomStringUtils.random(len, false, true);
    }

    /**
     * return true if the execution is on Browserstack Mobile
     */
    //public boolean isBSMobileTrue() {
    //    return ObjectRepo.reader.getPlatform().equalsIgnoreCase("Browserstack") && ObjectRepo.reader.getBSDevice().equalsIgnoreCase("Mobile");
   // }

    /**
     * return true if the execution is on Safari
     */
   // public boolean isSafariTrue() {
   //     return (ObjectRepo.reader.getBrowser().toString().equalsIgnoreCase("Safari") || ObjectRepo.reader.getBSWebBrowser().equalsIgnoreCase("Safari"));
   // }

    /**
     * takes screenshot
     */
    public void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", "screenshot");
        Logger("Error Message Displayed - Screenshot Taken");

    }
    
    public void Logger(String s) {
        log.info(s);
        scenario.log(s);
//		Allure.step(s);
    }
    
    public boolean isAlertPresent(){
	    boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	        Alert alert= driver.switchTo().alert();
	        alert.accept();
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
}
