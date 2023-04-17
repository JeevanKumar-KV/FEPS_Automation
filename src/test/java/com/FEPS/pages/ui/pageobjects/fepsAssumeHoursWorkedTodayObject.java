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

public class fepsAssumeHoursWorkedTodayObject extends PageBase {

	public fepsAssumeHoursWorkedTodayObject(WebDriver driver) {
		super(driver);
	}

		@FindBy(how = How.XPATH, using = "//a[text()='Assumed Hours Worked Today']")
		public WebElement assumedHoursWorkedToday;
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
	    
	    @FindBy(how = How.XPATH, using = "//button[@id='ButtonViewReport']")
		public WebElement generateReport;
	    
	    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_ctl00_PageTitleCph_PageHeaderLbl']")
		public WebElement checkPageTitle;
	    
	    @FindBy(how = How.XPATH, using= "//a[@id='ctl00_ctl00_PageTitleCph_TopLinksPnl_PageLinksRP_ctl00_Pagelnk']")
	    public WebElement clickOnShowHirearcy;
	    
	    @FindBy(how=How.XPATH, using ="//a[@id='ctl00_ctl00_PageTitleCph_FeedbackLnk']")
	    public WebElement clickOnFeedback;
	   	
	    @FindBy(how =How.XPATH, using ="//textarea[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_CommentsTxt']")
	    public WebElement enterFeedBackInAssumedHoursWorkedToday;
	    
	    @FindBy(how =How.XPATH, using ="//a[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_RatingLnk5']")
	    public WebElement rateFeedBack;
	   
	    @FindBy(how =How.XPATH, using ="//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_SubmitBtn']")
	    public WebElement clickOnSubmit;
	    
	    @FindBy(how =How.XPATH, using ="//iframe[@id='DialogFrame']")
	    public WebElement iframe;
	    @FindBy(how =How.XPATH, using ="//a[@id='ctl00_ctl00_PageTitleCph_imgLinkToHelp']")
	    public WebElement clickOnHelp;
	    @FindBy(how =How.XPATH, using ="//span[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_lblPageHeader']")
	    public WebElement assumedHelpPopUpTitle;
	    @FindBy(how =How.XPATH, using ="//iframe[@id='DialogFrame']")
	    public WebElement clickOnCloseAssumePopUp;
	    
	    
	    @FindBy(how = How.XPATH, using = "//span[text()='Feedback submitted successfully.']")
		public WebElement feedBackSuccessMessage;
	    
	    
	public String menu_item_string = "//a//span[text()='menu_item']";

}
