package com.FEPS.test.stepdefinition.ui;

import java.util.Properties;



import com.FEPS.configreader.PropertyFileReader;
import com.FEPS.genericActions.WebGenericActions;
import com.FEPS.settings.ObjectRepo;

import io.cucumber.java.en.When;

public class FEPS_Time_Menu_Step_Test extends BaseStepClass_UI {

	Properties prop = new Properties();
	public PropertyFileReader propertyFileReader = new PropertyFileReader();
	public WebGenericActions webGenericActions = new WebGenericActions(ObjectRepo.driver);


	@When("user Select {string} menu")
	public void select_Time_menu(String menu_item) throws InterruptedException {
		TimePageActions.navigate_to_menu(menu_item);
	}
	
}
