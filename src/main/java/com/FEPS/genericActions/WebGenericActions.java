package com.FEPS.genericActions;

import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.LoggerHelper;

import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit;

public class WebGenericActions {

	private final Logger log = LoggerHelper.getLogger(WebGenericActions.class);
	public Scenario scenario = ObjectRepo.scenario;
	public WebDriver driver;
	Actions actions = new Actions(ObjectRepo.driver);

	public WebGenericActions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will return true if webElement is enabled and false if disabled
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return boolean
	 */
	public boolean isElementEnabled(WebElement webElement, int timeOutInSeconds) {
		waitUntilElementIsClickable(webElement, timeOutInSeconds);
		try {
			return webElement.isEnabled();
		} catch (Exception exception) {
			Logger("Exception " + exception.getMessage());
			return false;
		}
	}

	/**
	 * This method will return true if webElement is displayed and false if not
	 * displayed
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return boolean
	 */
	public boolean isElementDisplayed(WebElement webElement, int timeOutInSeconds) {
		waitUntilElementIsVisible(webElement, timeOutInSeconds);
		try {
			return webElement.isDisplayed();
		} catch (Exception exception) {
			Logger("Exception " + exception.getMessage());
			return false;
		}
	}

	/**
	 * This method will return true if webElement is selected and false if not
	 * selected
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return boolean
	 */
	public boolean isElementSelected(WebElement webElement, int timeOutInSeconds) {
		waitUntilElementIsSelected(webElement, timeOutInSeconds);
		try {
			return webElement.isSelected();
		} catch (Exception exception) {
			Logger("Exception " + exception.getMessage());
			return false;
		}
	}

	/**
	 * This method will return true if webElement is present in DOM
	 *
	 * @param webElement -> Element which needs to validated
	 * @return boolean
	 */
	public boolean isElementPresent(By locator) {
		try {
			ObjectRepo.driver.findElement(locator);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	/**
	 * This method will return true if webElement is present in DOM
	 *
	 * @param webElement -> Element which needs to validated
	 * @return boolean
	 */
	public boolean verify_field_is_displayed_if_multiple_elements_exist_in_dom(By locator) {
		List<WebElement> account_name_List = ObjectRepo.driver.findElements(locator);
		if(account_name_List.size()==2)
		{
		return (account_name_List.get(1).isDisplayed());
		}
		else
		{
			return (account_name_List.get(0).isDisplayed());
		}
	}

	/**
	 * This method will click on the 'webElement' and returns true if the action is
	 * successful
	 *
	 * @param webElement       -> Element on which the action needs to be done
	 * @param timeOutInSeconds -> Waits till 'timeOutInSeconds'
	 * @return boolean
	 */
	public boolean clickOnElement(WebElement webElement, int timeOutInSeconds) {
		boolean flag = false;
		waitUntilElementIsClickable(webElement, timeOutInSeconds);
		try {
			webElement.click();
			flag = true;
		} catch (Exception e) {
			Logger("Exception  : " + e.getMessage());
		}
		return flag;
	}

	/**
	 * This method will return the 'value' attribute of a webElement
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return string
	 */
	public String getValueOfElement(WebElement webElement) {
		String value = null;
		try {
			value = webElement.getAttribute("value");
		} catch (Exception e) {
			Logger("Couldn't get the value of the web element with Exception : " + e.getMessage());
		}
		return value;
	}

	/**
	 * This method will return the 'class' attribute of a webElement
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return string
	 */
	public String getClassOfElement(WebElement webElement) {
		String value = null;
		try {
			value = webElement.getAttribute("class");
		} catch (Exception e) {
			Logger("Couldn't get the class of the web element with Exception : " + e.getMessage());
		}
		return value;
	}

	/**
	 * This method will return the value of 'attribute' attribute of a webElement
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @param attribute  -> Attribute of an element
	 * @return string
	 */
	public String getAttributeOfElement(WebElement webElement, String attribute) {
		String propertyValue = null;
		try {
			propertyValue = webElement.getAttribute(attribute);
		} catch (Exception e) {
			Logger("Couldn't get the value of the web element with Exception : " + e.getMessage());
		}
		return propertyValue;
	}

	/**
	 * This method will return the 'text' attribute of a webElement
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return string
	 */
	public String getTextOfElement(WebElement webElement) {
		String text = null;
		try {
			text = webElement.getText();
		} catch (Exception e) {
			Logger("Exception : " + e.getMessage());
		}
		return text;
	}

	/**
	 * This method will enter the text using action class Use this method if regular
	 * sendKeys doesn't work
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @param input      -> Text input that needs to be entered
	 */
	public boolean clearAndSendKeys(WebElement webElement, String input) {
		try {
			webElement.clear();

			// This will clear the text if regular clear doesn't work
			if (getValueOfElement(webElement) != null) {
				clearText(webElement);
			}

			webElement.sendKeys(input);
			return true;
//            Logger("Entered Text : " + getValue(webElement));
		} catch (Exception e) {
			Logger("Exception  : " + e.getMessage());
			return false;
		}
	}

	/**
	 * This method will enter the text using action class Use this method if regular
	 * sendKeys doesn't work
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @param input      -> Text input that needs to be entered
	 */
	public void actionSendKeys(WebElement webElement, String input) {
		try {
			actions.click(webElement).build().perform();
			actions.sendKeys(webElement, input).build().perform();
//            Logger("Entered Text : " + getValue(webElement));
		} catch (Exception e) {
			Logger("Exception  : " + e.getMessage());
		}
	}

	/**
	 * This methods helps in waiting explicitly for element 'webElement' to be
	 * visible till time 't' seconds
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @param t          -> Timeout in seconds
	 */
	public void waitUntilElementIsVisible(WebElement webElement, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(t));
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			System.out.println("Waited for " + t + " seconds");
			System.out.println("Element is not visible.... ");
		}
	}

	/**
	 * This methods helps in waiting explicitly for element 'webElement' to be
	 * selected till time 't' seconds
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @param t          -> Timeout in seconds
	 */
	public void waitUntilElementIsSelected(WebElement webElement, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(t));
			wait.until(ExpectedConditions.elementToBeSelected(webElement));
		} catch (Exception e) {
			System.out.println("Waited for " + t + " seconds");
			System.out.println("Element is not visible.... ");
		}
	}

	/**
	 * This methods helps in waiting explicitly for element 'webElement' to be
	 * clickable till time 't' seconds
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @param t          -> Timeout in seconds
	 */
	public void waitUntilElementIsClickable(WebElement webElement, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(t));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			System.out.println("Waited for " + t + " seconds");
			System.out.println("Element is not clickable.... ");
		}
	}

	/**
	 * This methods helps in waiting explicitly for list of elements
	 * 'webElementList' to be visible till time 't' seconds
	 *
	 * @param webElementList -> Elements on which the action needs to be done
	 * @param t              -> Timeout in seconds
	 */
	public void waitUntilElementListIsVisible(List<WebElement> webElementList, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(t));
			wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
		} catch (Exception e) {
			System.out.println("Waited for " + t + " seconds");
			System.out.println("Element is not visible.... ");
		}
	}

	/**
	 * Clears text fields Use this when regular clear doesn't work
	 * 
	 * @param webElement -> Element on which the action needs to be done
	 */
	public void clearText(WebElement webElement) {
		String os = System.getProperty("os.name");
		if (isIOSTrue()) {
			while (!webElement.getAttribute("value").equals("")) {
				webElement.sendKeys(Keys.BACK_SPACE);
			}
		} else if (os.equalsIgnoreCase("WINDOWS")) {
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		} else {
			while (!webElement.getAttribute("value").equals("")) {
				webElement.sendKeys(Keys.BACK_SPACE);
			}
		}
//        webElement.clear();
	}

	/**
	 * returns X coordinate of webElement
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return X coordinate
	 */
	public int getXCoordinateOfElement(WebElement webElement) {
		return webElement.getLocation().getX();
	}

	/**
	 * returns Y coordinate of webElement
	 *
	 * @param webElement -> Element on which the action needs to be done
	 * @return Y coordinate
	 */
	public int getYCoordinateOfElement(WebElement webElement) {
		return webElement.getLocation().getY();
	}

	/**
	 * this methods waits for specific number of seconds
	 *
	 * @param timeOutInSeconds -> Timeout in seconds
	 */
	public void waitTill(int timeOutInSeconds) {
		try {
			Thread.sleep(timeOutInSeconds * 1000);
		} catch (Exception ignored) {
		}
	}

	/**
	 * Waits till the url contains expected string for time 't' seconds
	 *
	 * @param string -> part of url
	 * @param t      -> Timeout in seconds
	 */
	public void waitUntilUrlContains(String string, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.urlContains(string));
		} catch (Exception e) {
			Logger("Waited for " + t + " seconds");
			Logger("URL doesn't match....... ");
		}
	}

	/**
	 * Waits till the page title contains expected string for time 't' seconds
	 * 
	 * @param string -> part of page title
	 * @param t      -> Timeout in seconds
	 */
	public void waitUntilTitleContains(String string, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.titleContains(string));
		} catch (Exception e) {
			Logger("Waited for " + t + " seconds");
			Logger("Title doesn't match....... ");
		}
	}

	/**
	 * This method will return the current page title
	 * 
	 * @return string
	 */
	public String getPageTitle() {
		return (driver.getTitle());
	}

	/**
	 * This method will compare the expected and actual current page title and
	 * returns true if matched else returns false
	 * 
	 * @param expectedTitle -> Expected Page Title
	 * @return boolean
	 */
	public boolean comparePageTitle(String expectedTitle) {
		String actualTitle = getPageTitle();
		Logger("Expected Page Title : " + expectedTitle);
		Logger("Current Page Title  : " + actualTitle);
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			Logger("Title Matches ");
			return true;
		} else {
			Logger("Title doesn't match");
			return false;
		}
	}

	/**
	 * This method will switch to the 'tabNumber'^th tab next to the current tab
	 * 
	 * @param tabNumber
	 */
	public void switchToTab(int tabNumber) {
		waitTill(1);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNumber));
	}

	/**
	 * This method will return true if execution is on browserstack ios device
	 * 
	 * @return boolean
	 */
	public boolean isIOSTrue() {
		return ObjectRepo.reader.getPlatform().equalsIgnoreCase("Browserstack") &&
		// ObjectRepo.reader.getBSDevice().equalsIgnoreCase("Mobile") &&
				ObjectRepo.reader.get_Mobile_OS().equalsIgnoreCase("ios");
	}

	/**
	 * this method will help in printing logs into reports and other places wherever
	 * required
	 * 
	 * @param s -> string to be printed
	 */
	public void Logger(String s) {
		scenario.log(s);
		log.info(s);
//        Allure.step(s);
	}

	/**
	 * This method will handle Stale element exception
	 * 
	 * @param locator -> String locator which often fails with Stale element exception
	 */
	public void handle_Stale_Element_Exception(String locator) {
		List<WebElement> ele_list = driver.findElements(By.xpath(locator));
		for (int i = 0; i < 10000; i++) {
			ele_list = driver.findElements(By.xpath(locator));
			if (ele_list.size() > 0) {
				if (driver.findElement(By.xpath(locator)).isDisplayed()) {
					waitUntilElementListIsVisible(ele_list, 5);
					ele_list = driver.findElements(By.xpath(locator));
					driver.findElement(By.xpath(locator)).click();
					break;
				}
			}
		}
	}
	
	/**
	 * This method will click on the element which is displayed when multiple elements are present in DOM but not displayed
	 * 
	 * @param locator -> String 
	 */
	public void click_on_element_displayed(String locator) {
		List<WebElement> ele_list = ObjectRepo.driver.findElements(By.xpath(locator));
		for(WebElement element_to_be_clicked : ele_list) {
			if(element_to_be_clicked.isDisplayed()) {
				element_to_be_clicked.click();
			}
			else {
				System.out.println("Element not displayed, checking next element");
			}
		}	
	}

}
