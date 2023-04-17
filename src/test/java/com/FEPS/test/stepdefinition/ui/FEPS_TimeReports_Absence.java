package com.FEPS.test.stepdefinition.ui;
import java.util.Properties;
import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.pages.CommonMethods;
import com.FEPS.settings.ObjectRepo;
import io.cucumber.java.en.Then;
public class FEPS_TimeReports_Absence extends BaseStepClass_UI {
	Properties prop = new Properties();
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);
	public CommonMethods commonMethods = new CommonMethods(ObjectRepo.driver,ObjectRepo.scenario);
	
	@Then("Select AbsenceReport and  Company Code as {string}, SBU as {string}, Dates as {string}")
	public void select_Absence(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value ) throws InterruptedException {
		TimeAbsencePageActions.navigate_to_Absence(company_code_dropdown_value, sbu_dropdown_value, dates_dropdown_value );
	}
	@Then("user clicks on generateReport")
	public void user_clicks_on_generateReport() throws InterruptedException {
		TimeAbsencePageActions.user_clicks_on_generateReport();
       }
	@Then("check for Company Code")
	public void CheckCC() throws InterruptedException {
		TimeAbsencePageActions.CheckCC();
       }
	@Then("click on favorite button")
	public void enableFavorite() throws InterruptedException {
		TimeAbsencePageActions.enableFavorite();
       }
	@Then("click on Dashoard")
	public void clickOnDashboard() throws InterruptedException {
		commonMethods.user_clicks_on_dashboard();
       }
	@Then("click on Employee hyperlink")
	public void clickOnEmployeeHyerlink() throws InterruptedException {
		TimeAbsencePageActions.clickOnEmployeeHyerlink();
       }
	@Then("check for page name")
	public void checkPageName() throws InterruptedException {
		TimeAbsencePageActions.checkPageName();
       }
	@Then("click on date hyperlink in absence detail page")
	public void clickOnDateHyperLink() throws InterruptedException {
		TimeAbsencePageActions.clickOnDateHyperLink();
       }		
	@Then("check for employeeid in Time Clock Activity page")
	public void checkEmployeeID() throws InterruptedException {
			TimeAbsencePageActions.checkEmployeeID();
	       }
	@Then("chick on logout button")
	public void clickOnLogout() throws InterruptedException {
		TimeAbsencePageActions.clickOnLogout();
		}
}	
