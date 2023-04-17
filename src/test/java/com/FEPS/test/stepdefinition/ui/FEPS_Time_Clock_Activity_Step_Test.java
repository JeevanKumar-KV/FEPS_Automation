package com.FEPS.test.stepdefinition.ui;


import java.text.ParseException;
import java.util.Properties;



import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.settings.ObjectRepo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FEPS_Time_Clock_Activity_Step_Test extends BaseStepClass_UI {

	Properties prop = new Properties();
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);
	
	@Then("Select Time Clock Activity and Company Code as {string}, SBU as {string}, Dates as {string}")
	public void select_Time_Clock_Activity(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value ) throws InterruptedException {
		TimeCAPageActions.navigate_to_Time_Clock_Activity(company_code_dropdown_value, sbu_dropdown_value, dates_dropdown_value );
	}
	
	@And("user enter Date1 as {string}, Date2 as {string}")
	public void user_enter(String Date1, String Date2) throws InterruptedException {
		TimeCAPageActions.user_enter(Date1, Date2);
	}
	
	@Then("user clicks on submit")
	public void user_clicks_on_submit() throws InterruptedException {
		TimeCAPageActions.clicks_on_submit();
       }
	
	@Then("user navigates to Add Time Clock and Clock In as {string}, Clock Out as {string} and Add Manager Note")
	public void user_navigates_to_Add_Time_Clock(String clock_in_value, String clock_out_value) throws InterruptedException, ParseException {
		TimeCAPageActions.navigates_to_Add_Time_Clock(clock_in_value, clock_out_value);
       }
	
	@And("click on Add Time Clock Btn")
	public void Add_Time_Clock() throws InterruptedException {
		TimeCAPageActions.click_on_Add_Time_Clock_Btn();
       }
	
	@Then("click on Time Clock Requests Manager link")
	public void Time_Clock_Requests_Manager() throws InterruptedException {
		TimeCAPageActions.click_on_Add_Time_Clock_Requests_Manager();
	}
	
	@And("click on Edit Time and Clock In Update as {string}, Clock Out Update as {string} and Add Manager Note")
	public void click_on_Edit_Time(String clock_in_update_value, String clock_out_update_value) throws InterruptedException {
		TimeCAPageActions.click_on_Edit_Time(clock_in_update_value, clock_out_update_value);
	}

//	@And("edit Clock In as {string}, Clock Out as {string} and Add Manager Note")
//	public void edit(String clock_in_value, String clock_out_value) throws InterruptedException, ParseException {
//		TimeCAPageActions.edit(clock_in_value, clock_out_value);
//       }
	
	@And("click on Update Time Clock Btn")
	public void click_on_Update_Time_Clock_Btn() throws InterruptedException {
		TimeCAPageActions.click_on_Update_Time_Clock_Btn();
       }
	
     @Then("click on Edit Time for Delete and Add Manager Note and click on Delete Time Clock")
	public void click_on_Edit_Time_for_Delete_and_Add_Manager_Note_and_click_on_Delete_Time_Clock() throws InterruptedException {
		TimeCAPageActions.click_on_Edit_Time_for_Delete_and_Add_Manager_Note_and_click_on_Delete_Time_Clock();
	}




}
