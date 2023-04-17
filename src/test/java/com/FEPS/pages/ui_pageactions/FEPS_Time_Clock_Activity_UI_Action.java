package com.FEPS.pages.ui_pageactions;

import java.text.ParseException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.FEPS.genericActions.JavaScriptActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.pages.PageBase;
import com.FEPS.pages.ui.pageobjects.FEPS_Time_Clock_Activity_UI_Object;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

import io.cucumber.java.Scenario;

public class FEPS_Time_Clock_Activity_UI_Action extends FEPS_Time_Clock_Activity_UI_Object {

	public WebDriver driver;
	public Scenario scenario;
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	public JavaScriptActions js = new JavaScriptActions(driver);

	public FEPS_Time_Clock_Activity_UI_Action(WebDriver driver, Scenario scenario) {
		super(driver);
		this.driver = driver;
		this.scenario = scenario;
	}

	public void navigate_to_Time_Clock_Activity(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value) throws InterruptedException {
		new WebDriverWait(driver, Duration.ofSeconds(45))
        .until(ExpectedConditions.visibilityOf(Time_Clock_Activity));
		new WebDriverWait(driver, Duration.ofSeconds(45))
        .until(ExpectedConditions.elementToBeClickable(Time_Clock_Activity)).click();
		//Switching to frame
		commonMethods.switch_to_criteria_selection_frame();
		Logger("User navigates to Time Clock Activity page successfully");
		commonMethods.click_on_time_clock_activity_dropdown(Company_Code,company_code_dropdown_value);
		commonMethods.click_on_time_clock_activity_dropdown(SBU,sbu_dropdown_value);
		commonMethods.click_on_time_clock_activity_dropdown(Dates,dates_dropdown_value);
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
	
	public void navigates_to_Add_Time_Clock(String clock_in_value, String clock_out_value) throws InterruptedException, ParseException {
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.visibilityOf(Add_Time_Clock));
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.elementToBeClickable(Add_Time_Clock)).click();
		driver.switchTo().defaultContent();
		new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Time_Clock_Frame_Element));
		new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.visibilityOf(Clock_In));
		//Clock_In.sendKeys(commonMethods.generate_time());
		//Clock_Out.sendKeys(commonMethods.generate_time()); 	
		Clock_In.sendKeys(clock_in_value);
		Clock_Out.sendKeys(clock_out_value); 	
		        Add_Manager_Note.sendKeys(PageBase.randomString(10));
		    }
	
public void click_on_Add_Time_Clock_Btn() throws InterruptedException {
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.visibilityOf(Add_Time_Clock_Btn));
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Add_Time_Clock_Btn)).click();
    driver.switchTo().defaultContent();
}

public void click_on_Add_Time_Clock_Requests_Manager() throws InterruptedException {
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.visibilityOf(Time_Clock_Requests_Manager));
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Time_Clock_Requests_Manager)).click();
}

public void click_on_Edit_Time(String clock_in_update_value, String clock_out_update_value) throws InterruptedException {
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.visibilityOf(Edit_Time_Clock));
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Edit_Time_Clock));
	js.jsClick(Edit_Time_Clock);
	driver.switchTo().defaultContent();
	new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(15))
	.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Time_Clock_Frame_Element));
//	new WebDriverWait(driver, Duration.ofSeconds(15))
//   .until(ExpectedConditions.visibilityOf(Clock_In_Update));
	Clock_In_Update.clear();
	Clock_In_Update.sendKeys(clock_in_update_value);
	Clock_Out_Update.clear();
	Clock_Out_Update.sendKeys(clock_out_update_value); 	
	Add_Manager_Note_for_Update.sendKeys(PageBase.randomString(10));
}

//public void edit(String clock_in_value, String clock_out_value) throws InterruptedException, ParseException {
//	driver.switchTo().defaultContent();
//	new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(15))
//	.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Time_Clock_Frame_Element));
////	new WebDriverWait(driver, Duration.ofSeconds(15))
////    .until(ExpectedConditions.visibilityOf(edit));
//	new WebDriverWait(driver, Duration.ofSeconds(15))
//    .until(ExpectedConditions.elementToBeClickable(Edit_Time_Clock)).click();
//	Clock_In.sendKeys(clock_in_value);
//	Clock_Out.sendKeys(clock_out_value); 	
//	Add_Manager_Note.sendKeys(PageBase.randomString(15));
//	Thread.sleep(5000);
//}

public void click_on_Update_Time_Clock_Btn() throws InterruptedException {
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.visibilityOf(Update_Time_Clock_Btn));
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Update_Time_Clock_Btn)).click();
}

    public void click_on_Edit_Time_for_Delete_and_Add_Manager_Note_and_click_on_Delete_Time_Clock() throws InterruptedException {
    	driver.switchTo().defaultContent();
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Edit_Time_Clock));
	
	js.jsClick(Edit_Time_Clock);
	driver.switchTo().defaultContent();
	new WebDriverWait(ObjectRepo.driver, Duration.ofSeconds(15))
	.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Time_Clock_Frame_Element));
	Add_Manager_Note_for_Delete.sendKeys(PageBase.randomString(10));
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.visibilityOf(Delete_Time_Clock_Btn));
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Delete_Time_Clock_Btn)).click();
	driver.switchTo().defaultContent();
	new WebDriverWait(driver, Duration.ofSeconds(30))
    .until(ExpectedConditions.elementToBeClickable(Click_on_OK)).click();
}




//	@SuppressWarnings("deprecation")
//	public void launchTextnow() throws InterruptedException, AWTException {
//		driver.get("https://www.textnow.com/messaging");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////		WebElement textNowTitle = driver.findElement(By.xpath("//title[text()='TextNow']"));
////		webGenericActions.waitUntilElementIsVisible(textNowTitle,5);
////		try {
////			WebElement notificationCloseButton = driver.findElement(By.xpath("//div[text()='Not now']"));
////			notificationCloseButton.click();
////		}
////		catch(NoSuchElementException e){
////			System.out.println("Notification pop up not displayed");
////		}
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.findElement(By.xpath("//span[text()='Continue with Google']")).click();
//		Thread.sleep(500);
//		ObjectRepo.driver.findElement(By.cssSelector("input[type='email']")).sendKeys("conduentbalaji@gmail.com");
//		Thread.sleep(500);
//		org.openqa.selenium.WebElement nextButton = ObjectRepo.driver.findElement(By.xpath("//span[text()='Next']"));
//		nextButton.click();
//		Thread.sleep(2000);
//		org.openqa.selenium.WebElement passwordText = ObjectRepo.driver
//				.findElement(By.cssSelector("input[type='password']"));
//		webGenericActions.waitUntilElementIsVisible(passwordText, 500);
//		passwordText.sendKeys("Conduent@123");
//		WebElement nextButton1 = ObjectRepo.driver.findElement(By.xpath("//span[text()='Next']"));
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		nextButton1.click();
////		ObjectRepo.driver.findElement(By.cssSelector("button[type='submit']")).click();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
////		PRESS AND HOLD - HUMAN VERIFICATION
////		WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@style,'block')]"));
////				WebElement frameElement = ObjectRepo.driver.findElement(By.cssSelector("iframe[style ^='display: block;']"));
////				WebElement frameElement = (WebElement) jsActions.executeScript("document.querySelector(\"iframe[style ^='display: block;']\")");
////				WebElement frameElement = (WebElement) js.executeScript(
////						"document.querySelector(\"iframe[style*='block;']\")");
////		WebElement frameElement = ObjectRepo.driver.findElement(By.cssSelector("iframe[id='ssIFrame_google']"));
//		ObjectRepo.driver.switchTo().parentFrame();
//		String currentFrame = js.executeScript("return self.name").toString();
//		String title = ObjectRepo.driver.getTitle().toString();
//		System.out.println("TITLE " + title);
//		System.out.println("CURRENT FRAME " + currentFrame);
//		java.awt.Robot r = new java.awt.Robot();
//		// Code to move mouse cursor to Press and Hold element
////		Actions action = new Actions(driver);
////					WebElement pressAndHold = ObjectRepo.driver.findElement(By.xpath("//div[@aria-label='Press and Hold']//p"));
////					webGenericActions.isElementDisplayed(pressAndHold, 15);
////					action.moveToElement(pressAndHold);
//		// Move cursor
//		try {
//			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//			int xCoord = screenSize.width / 2;
//			int yCoord = screenSize.height / 2;
//			r.mouseMove(xCoord, yCoord + 50);
//		} catch (Exception e) {
//			System.out.println("Not moved");
//		}
//		// Press and hold
//		Thread.sleep(500);
//		r.mousePress(InputEvent.BUTTON1_MASK);
//		r.mouseRelease(InputEvent.BUTTON1_MASK);
//		//
//		// Code to open new tab
////		java.awt.Robot r = new java.awt.Robot();
////		r.keyPress(KeyEvent.VK_CONTROL);
////		r.keyPress(KeyEvent.VK_T);
////		r.keyRelease(KeyEvent.VK_CONTROL);
////		r.keyRelease(KeyEvent.VK_T);
////		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//	}
//
//	public void launch_Textnow_in_a_new_tab() throws InterruptedException, AWTException {
//		java.awt.Robot r = new java.awt.Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_T);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_T);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		navigation.switchToTab(1);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.get("https://www.textnow.com/messaging");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	}
//
//	public void place_a_call() throws InterruptedException, AWTException {
//		try {
//			WebElement notificationCloseButton = driver.findElement(By.xpath("//div[text()='Not now']"));
//			notificationCloseButton.click();
//		} catch (NoSuchElementException e) {
//			System.out.println("Notification pop up not displayed");
//		}
//		WebElement callButton = driver.findElement(By.xpath(
//				"//h3[@data-number='(801) 981-4956']//ancestor::div[@class='js-conversation-title']//following-sibling::div//button[@class='start-conversation__button ']"));
//		webGenericActions.waitUntilElementIsClickable(callButton, 5);
//		callButton.click();
////		js.jsClick(callButton);	
//	}
//
//	public void open_the_dialer() throws InterruptedException, AWTException {
//		Thread.sleep(30000);
//		WebElement dialPad = driver.findElement(By.id("show-dialer"));
//		dialPad.click();
//	}
//
//	public void navigate_through_ivr() throws InterruptedException, AWTException {
//		Thread.sleep(2000);
//		WebElement keyPadSixForCommonOrg = driver.findElement(By.xpath("//div[text()='6']"));
//		webGenericActions.waitUntilElementIsClickable(keyPadSixForCommonOrg, 5);
//		keyPadSixForCommonOrg.click();
//		Thread.sleep(5000);
//	}
//
//	public void closeAllTabs() {
//
//		long noOfInactiveTabs;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		noOfInactiveTabs = (long) js.executeScript(
//				"return document.querySelectorAll(\"a[class^='tabHeader slds-context-bar__label-action']\").length;");
//		int tabsCnt = (int) noOfInactiveTabs;
//		System.out.println("No of tabs opened are " + noOfInactiveTabs);
//
//		for (int i = 0; i < tabsCnt; i++) {
//			try {
//				Thread.sleep(2000);
//				js.executeScript(
//						"document.querySelectorAll(\"a[class^='tabHeader slds-context-bar__label-action'][aria-selected='true']\")[0].parentNode.querySelectorAll(\"div[class^='close slds-col--bump-left slds-p-left--none slds-context-bar__icon-action']\")[0].querySelector(\"button\").click();");
//			} catch (Exception e) {
//
//				System.out.println("No tabs are opened");
//				try {
//					driver.switchTo().alert().dismiss();
//				} catch (NoAlertPresentException e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public void clear_if_credentials_are_prefilled() throws InterruptedException {
//		userName_txtField.click();
//		String usernamePrefilled = userName_txtField.getAttribute("value");
//		System.out.println("Prefilled username is " + usernamePrefilled);
//		while (!(usernamePrefilled.isEmpty())) {
//			userName_txtField.clear();
//			password_txtField.clear();
//			usernamePrefilled = userName_txtField.getAttribute("value");
//			System.out.println("Prefilled username after clear is " + usernamePrefilled);
//			System.out.println("Prefilled username after clear is " + usernamePrefilled.isEmpty());
//		}
//	}
//
//	public void launchIncontact() throws InterruptedException, AWTException {
//		java.awt.Robot r = new java.awt.Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_T);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_T);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		navigation.switchToTab(1);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.get("https://login.incontact.com/inContact/Login.aspx");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement username = driver.findElement(By.cssSelector("input[placeholder='Username']"));
//		WebElement nextButton = driver.findElement(By.cssSelector("input[value='Next']"));
//		webGenericActions.waitUntilElementIsVisible(username, 5);
//		username.sendKeys("pramukha.bharadwaj@conduent.com");
//		nextButton.click();
//		WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
//		WebElement launchAgentCheckbox = driver
//				.findElement(By.xpath("//label[text()='Launch Agent Upon Login']//preceding-sibling::input"));
//		WebElement signInButton = driver.findElement(By.cssSelector("input[value='Sign In']"));
//		webGenericActions.waitUntilElementIsVisible(password, 5);
//		password.sendKeys("Auto@1234");
//		launchAgentCheckbox.click();
//		Thread.sleep(2000);
//		signInButton.click();
//		try {
//			WebElement softPhoneRadioButton = driver.findElement(By.cssSelector("input[value='radSoftPhone']"));
//			webGenericActions.waitUntilElementIsVisible(softPhoneRadioButton, 5);
//			softPhoneRadioButton.click();
//		} catch (NoSuchElementException e) {
//			System.out.println("Already active session");
//		}
//		Thread.sleep(2000);
//		WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		continueButton.click();
//		Thread.sleep(10000);
//	}
//
//	public void placeAcall() throws InterruptedException, AWTException {
//		try {
//			new WebDriverWait(driver, Duration.ofMinutes(1))
//			.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[title='New']")));
//		}
//		catch(TimeoutException t) {
//			driver.navigate().refresh();
//			new WebDriverWait(driver, Duration.ofMinutes(1))
//			.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[title='New']")));
//		}
//		try {
//			WebElement newButton = driver.findElement(By.cssSelector("button[title='New']"));
//			new WebDriverWait(driver, Duration.ofMinutes(1))
//			.until(ExpectedConditions.elementToBeClickable(newButton)).click();
//		}
//		catch(ElementClickInterceptedException e) {
//			Thread.sleep(10000);
//			WebElement newButton = driver.findElement(By.cssSelector("button[title='New']"));
//			new WebDriverWait(driver, Duration.ofSeconds(30))
//			.until(ExpectedConditions.elementToBeClickable(newButton)).click();
//		}
//		WebElement searchNumber = driver.findElement(By.cssSelector("input[type='search']"));
//		webGenericActions.waitUntilElementIsVisible(searchNumber, 15);
//		searchNumber.sendKeys("8019814956");
//		WebElement callButton = driver.findElement(By.xpath("//h2[@title='8019814956']//parent::div//button[@title='Call']"));
//		new WebDriverWait(driver, Duration.ofSeconds(5))
//		.until(ExpectedConditions.elementToBeClickable(callButton)).click();
//		Thread.sleep(10000);
//		WebElement dialPad = driver.findElement(By.cssSelector("a[aria-label='Toggle phone keypad. Clickable digits or keypad input.']"));
//		try {
//			new WebDriverWait(driver, Duration.ofSeconds(30))
//			.until(ExpectedConditions.elementToBeClickable(dialPad)).click();
//		}
//		catch(ElementClickInterceptedException e) {
//			WebElement phone_dial = driver.findElement(By.cssSelector("[aria-labelledby='phone-outbound-title']"));
//			new WebDriverWait(driver, Duration.ofSeconds(10))
//			.until(ExpectedConditions.elementToBeClickable(phone_dial)).click();
//			new WebDriverWait(driver, Duration.ofSeconds(30))
//			.until(ExpectedConditions.elementToBeClickable(dialPad)).click();
//		}
//		Thread.sleep(20000);
//		WebElement numberSix = driver.findElement(By.xpath("//span[@class='button-text-number'][text()='6']"));
//		new WebDriverWait(driver, Duration.ofSeconds(60))
//		.until(ExpectedConditions.elementToBeClickable(numberSix)).click();
//	}
//	
//	public void receiveTheCall() throws InterruptedException, AWTException {
//		navigation.switchToTab(0);
//		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		WebElement frameElement = driver.findElement(By.cssSelector("iframe[name='sfdcSoftphone']"));
//		driver.switchTo().frame(frameElement);
//		Thread.sleep(10000);
//		WebElement acceptButton = driver.findElement(By.id("acceptBtnId"));
//		webGenericActions.waitUntilElementIsClickable(acceptButton,5);
//		js.jsClick(acceptButton);
//		Thread.sleep(10000);
//		WebElement rightArrowInBumberBox = driver.findElement(By.className("RightArrowInBumberBox"));
//		new WebDriverWait(driver, Duration.ofSeconds(60))
//		.until(ExpectedConditions.elementToBeClickable(rightArrowInBumberBox)).click();
//		Thread.sleep(2000);
//		WebElement endCallButton = driver.findElement(By.className("ImgDrop"));
//		new WebDriverWait(driver, Duration.ofSeconds(60))
//		.until(ExpectedConditions.elementToBeClickable(endCallButton)).click();
//		//
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		String actualStatus = driver.findElement(By.id("stateDescId")).getText();
//		if (actualStatus == "InboundContact") {
//			new WebDriverWait(driver, Duration.ofSeconds(60))
//			.until(ExpectedConditions.elementToBeClickable(rightArrowInBumberBox)).click();
//			Thread.sleep(2000);
//			new WebDriverWait(driver, Duration.ofSeconds(60))
//			.until(ExpectedConditions.elementToBeClickable(endCallButton)).click();
//		} else {
//			System.out.println("Call has been disconnected successfully");
//		}
//		//
//		Thread.sleep(10000); 
//	}

	

}
