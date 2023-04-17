package com.FEPS.test.stepdefinition.ui;

import java.util.Properties;

import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.settings.ObjectRepo;

import io.cucumber.java.en.Then;



public class FEPS_Time_Card_Step_Test extends BaseStepClass_UI {

	Properties prop = new Properties();
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);
	
	@Then("Select Time Card and Company Code as {string}, SBU as {string}, Dates as {string}")
	public void select_Time_Card(String company_code_dropdown_value, String sbu_dropdown_value, String dates_dropdown_value ) throws InterruptedException {
		TimeCPageActions.navigate_to_Time_Card(company_code_dropdown_value, sbu_dropdown_value, dates_dropdown_value );
	}
	
	
	
	
	
	




}
