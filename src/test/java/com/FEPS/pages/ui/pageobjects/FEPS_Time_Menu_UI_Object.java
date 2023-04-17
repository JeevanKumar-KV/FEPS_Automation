package com.FEPS.pages.ui.pageobjects;

/**
 * Author : Cheerala Rachana
 * Email id  : cheerala.rachana@conduent.com
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.FEPS.pages.PageBase;

public class FEPS_Time_Menu_UI_Object extends PageBase {

	public FEPS_Time_Menu_UI_Object(WebDriver driver) {
		super(driver);
	}

	// FEPS Dashboard - Time menu
	@FindBy(how = How.XPATH, using = "//span[@class='rmText rmExpandDown']")
	public WebElement Time_menu;
	
	
	public String menu_item_string = "//a//span[text()='menu_item']";

}
