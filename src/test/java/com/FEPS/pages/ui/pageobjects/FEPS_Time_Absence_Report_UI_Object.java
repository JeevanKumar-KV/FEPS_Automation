package com.FEPS.pages.ui.pageobjects;

/**
 * Author : Jeevan Kumar K V
 * Email id  : jeevankumar.kv@conduent.com
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.FEPS.pages.PageBase;

public class FEPS_Time_Absence_Report_UI_Object extends PageBase {

	public FEPS_Time_Absence_Report_UI_Object(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Absence (For Scheduled Days)']")
	public WebElement Absence_report;
	 @FindBy(how = How.XPATH, using = "//div[@id='s2id_cboCCInnerddl']")
		public WebElement Company_Code;

	    @FindBy(how = How.XPATH, using = "//select[@id='cboCCInnerddl']")
		public WebElement Company_Code_dropdown;

	    @FindBy(how = How.XPATH, using = "(//a[@class='select2-choice'])[2]")
		public WebElement SBU;
	    
	    @FindBy(how = How.XPATH, using = "//select[@id='cboSBUInnerddl']")
		public WebElement SBU_dropdown;
	    
	    @FindBy(how = How.XPATH, using = "//input[@class='select2-input select2-default']")
		public WebElement Employees;
	    
	    @FindBy(how = How.XPATH, using = "//div[@id='divChooseOption']")
		public WebElement Dates;
	    
	    @FindBy(how = How.XPATH, using = "//option[text()='Custom']")
		public WebElement Dates_dropdown;
	    
	    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_ucDateRangeNavigatorControl_TATextBoxFromDate']")
	    public WebElement Date1_Textfield;
	    
	    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_ucDateRangeNavigatorControl_TATextBoxToDate']")
	    public WebElement Date2_Textfield;

	    @FindBy(how = How.XPATH, using = "//input[@class='btn_feps']")
		public WebElement generateReport;
	    
	    @FindBy(how = How.XPATH, using = "//span[text()='Absence Summary']")
	  		public WebElement absencePagetitle;
	  
	    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Company Code:')]/b")
		public WebElement CheckCC;
	    
	    @FindBy(how = How.XPATH, using = "//a[@id ='ctl00_ctl00_PageTitleCph_imgBtnAddFav']")
		public WebElement enableFavorite;
	    
	    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_FavouritesLinksRP_ctl07_lblText']")
		public WebElement absenceFavorite;
	    
	    @FindBy(how = How.XPATH, using = "//a[text()='20386346  ']")
	  		public WebElement clickOnEmployeeHyerlink;
	    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_ctl00_PageTitleCph_PageHeaderLbl']")
  		public WebElement checkPageName;
	    @FindBy(how = How.XPATH, using = "//a[text()='07/23/2022']")
  		public WebElement clickOnDateHyperLink;
	    @FindBy(how = How.XPATH, using = "//b[normalize-space()='20386346']")
  		public WebElement checkEmployeeID;
	   
	    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ctl00_FEPSTitleCph_SiteToolBar_lnkLogOff']")
		public WebElement clickOnLogout;
	  

	public String menu_item_string = "//a//span[text()='menu_item']";

}
