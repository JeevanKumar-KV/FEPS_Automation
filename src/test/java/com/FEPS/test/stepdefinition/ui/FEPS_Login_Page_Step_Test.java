package com.FEPS.test.stepdefinition.ui;

import java.awt.AWTException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;



import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.settings.ObjectRepo;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FEPS_Login_Page_Step_Test extends BaseStepClass_UI {

	Properties prop = new Properties();
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);

	@Given("User launches the {string} URL")
	public void user_launches_the_common_org_url(String flow) {
	
		loginPageActions.verify_CommonOrg_Login_Page_Title();
		loginPageActions.execution_details(flow);
	}

	@Given("User launches the PAS URL")
	public void user_launches_the_common_org_pas_url() throws InterruptedException {
		//System.out.println("Website :" + ObjectRepo.reader.get_CommonOrg_Website_URL("PAS"));
		navigation.navigateTo("https://testfeps.services.conduent.com/Payroll/");
		loginPageActions.verify_CommonOrg_Login_Page_Title();
		loginPageActions.execution_details("PAS");
	}
	
	
	@When("User Clicks on login through SSO")
    public void User_Clicks_on_login_through_SSO() throws InterruptedException {
        loginPageActions.login_through_SSO();
	}

	@Given("User launches the PAS URL in new tab")
	public void user_launches_the_pas_url_in_new_tab() throws InterruptedException, AWTException {
		ObjectRepo.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginPageActions.verify_CommonOrg_Login_Page_Title();
		loginPageActions.execution_details("PAS");
	}

	@Given("User launches the Commercial URL")
	public void user_launches_the_common_org_commercial_url() {
	
		loginPageActions.verify_CommonOrg_Login_Page_Title();
		loginPageActions.execution_details("Commercial");
	}

	
	
	
	@When("^User logs in with valid ([^\"]*)agent credentials$")
	public void user_logs_in_with_valid_agent_credentials(String string) throws InterruptedException {
		//loginPageActions.clear_if_credentials_are_prefilled();
		loginPageActions.user_logs_in_with_credentials(string);
		loginPageActions.click_On_CommonOrg_login_button();
	}

	@Then("User is logged into application")
	public void user_is_logged_in_to_application() throws InterruptedException {
	
		loginPageActions.verify_CommonOrg_Page_Login_isSuccessfull();

	}
	
//	@Then("Select {string} menu")
//	public void select_Time_menu(String menu_item) throws InterruptedException {
//		loginPageActions.navigate_to_menu(menu_item);
//	}
//	
////	@Then("Select Time Card and Company Code as {string}, SBU as {string} Dates as {string}")
////	public void select_Time_Card(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value ) throws InterruptedException {
////	    loginPageActions.navigate_to_Time_Card(company_code_dropdown_value, sbu_dropdown_value, dates_dropdown_value );
////	}
//	
//	@Then("Select Time Clock Activity and Company Code as {string}, SBU as {string}, Dates as {string}")
//	public void select_Time_Clock_Activity(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value ) throws InterruptedException {
//	    loginPageActions.navigate_to_Time_Clock_Activity(company_code_dropdown_value, sbu_dropdown_value, dates_dropdown_value );
//	}
//	
//	@Then("user clicks on submit")
//	public void user_clicks_on_submit() throws InterruptedException {
//		loginPageActions.clicks_on_submit();
//       }
//	
//	@Then("user navigates to Add Time Clock and Clock In as {string}, Clock Out as {string} and Add Manager Note")
//	public void user_navigates_to_Add_Time_Clock(String clock_in_value, String clock_out_value) throws InterruptedException, ParseException {
//		loginPageActions.navigates_to_Add_Time_Clock(clock_in_value, clock_out_value);
//       }
//	
//	@And("click on Add Time Clock Btn")
//	public void Add_Time_Clock() throws InterruptedException {
//		loginPageActions.click_on_Add_Time_Clock_Btn();
//       }
//	
//	@And("click on Edit Time and Clock In Update as {string}, Clock Out Update as {string} and Add Manager Note")
//	public void click_on_Edit_Time(String clock_in_update_value, String clock_out_update_value) throws InterruptedException {
//		loginPageActions.click_on_Edit_Time(clock_in_update_value, clock_out_update_value);
//	}
//
////	@And("edit Clock In as {string}, Clock Out as {string} and Add Manager Note")
////	public void edit(String clock_in_value, String clock_out_value) throws InterruptedException, ParseException {
////		loginPageActions.edit(clock_in_value, clock_out_value);
////       }
//	
//	@And("click on Update Time Clock Btn")
//	public void click_on_Update_Time_Clock_Btn() throws InterruptedException {
//		loginPageActions.click_on_Update_Time_Clock_Btn();
//       }
//	
//	//@And("click on Edit Time for Delete and Add Manager Note and click on Delete Time Clock")
////	public void click_on_Edit_Time_for_Delete_and_Add_Manager_Note_and_click_on_Delete_Time_Clock() throws InterruptedException {
////		loginPageActions.click_on_Edit_Time_for_Delete_and_Add_Manager_Note_and_click_on_Delete_Time_Clock();
////	}
//
//	
////	@And("Add Manager Note and click on Delete Time Clock Btn")
////	public void Add_Manager_Note() throws InterruptedException {
////		loginPageActions.Add_Manager_Note_and_click_on_Delete_Time_Clock_Btn();
////       }
////	
////	@And("click on Delete Time Clock and click on OK")
////	public void Delete_Time_Clock() throws InterruptedException {
////		loginPageActions.click_on_Delete_Time_Clock_and_click_on_OK();
////       }
////	@And("Select SBU as {string}")
////	public void select_SBU(String SBU_dropdown_value) throws InterruptedException {
////	    loginPageActions.navigate_to_SBU(SBU_dropdown_value);
////	}
//	
//	//@Then("User Select Transactions menu")
//	//public void user_select_transactions_menu() throws InterruptedException {
//	  // loginPageActions.navigate_to_transactions_menu();
//	//}
//	
////	@Then("Select Maintenance menu and clicks on Employee Bulk Manager")
////	public void select_maintenance_menu_and_clicks_on_employee_bulk_manager() throws InterruptedException{
////	    loginPageActions.navigate_to_Maintenance_menu_and_clicks_on_Employee_Bulk_Manager();
////	}
//	
//	//@Then("User logs out of the application")
//	//public void user_logs_out_of_the_application() throws InterruptedException {
//		
//	//	loginPageActions.log_out_of_application();
////	}

	/// FEASIBILITY FOR TESTNOW
//	@Given("User launches the Test Now URL")
//	public void user_launches_the_test_now_url() throws InterruptedException, AWTException {
//		loginPageActions.launchTextnow();
//		Thread.sleep(3000);
//		navigation.switchToTab(1);
//	}
//	
//	@When("User switches to TextNow and places a call")
//	public void user_switches_to_text_now_and_places_a_call() throws InterruptedException, AWTException {
//		navigation.switchToTab(0);
//		Thread.sleep(2000);
//		loginPageActions.place_a_call();
//		loginPageActions.open_the_dialer();
//		loginPageActions.navigate_through_ivr();
//	}
}
