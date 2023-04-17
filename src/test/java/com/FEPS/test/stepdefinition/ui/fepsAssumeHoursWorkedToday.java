package com.FEPS.test.stepdefinition.ui;
import java.util.Properties;
import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.settings.ObjectRepo;
import io.cucumber.java.en.Then;
public class fepsAssumeHoursWorkedToday extends BaseStepClass_UI {
	Properties prop = new Properties();
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	
	@Then("Select Assumed Hours Worked Today and  Company Code as {string}, SBU as {string}")
	public void select_AssumeHours(String company_code_dropdown_value, String sbu_dropdown_value ) throws InterruptedException {
		assumeHoursPageActions.navigateToAssumeHoursWorkedToday(company_code_dropdown_value, sbu_dropdown_value );
	}
	@Then("user clicks on generateReport in Assumed Hours")
	public void user_clicks_on_generateReport() throws InterruptedException {
		assumeHoursPageActions.user_clicks_on_generateReport();
       }
	@Then("check for the page title")
	public void checkForPageTitle()  {
		assumeHoursPageActions.checkForPageTitle();
       }
	@Then("Click on Show Hirearcy Columns")
	public void clickOnShowHirearcy() throws InterruptedException{
		assumeHoursPageActions.clickOnShowHirearcy();
	}
	@Then("Click on Feedback")
	public void clickOnFeedback() throws InterruptedException{
		assumeHoursPageActions.clickOnFeedback();
	}
	@Then("Enter Feedback for Assumed Hours Worked Today and click on rating")
	public void enterFeedBackInAssumedHoursWorkedToday() throws InterruptedException{
		assumeHoursPageActions.enterFeedBackInAssumedHoursWorkedToday();
	}
	@Then("Click on Submit button")
	public void clickOnSubmit() throws InterruptedException{
		assumeHoursPageActions.clickOnSubmit();
	}
	@Then("Click on Help and check for the title of help pop up and close the pop up")
	public void clickOnHelp() throws InterruptedException{
		assumeHoursPageActions.clickOnHelp();
	}
	}	
