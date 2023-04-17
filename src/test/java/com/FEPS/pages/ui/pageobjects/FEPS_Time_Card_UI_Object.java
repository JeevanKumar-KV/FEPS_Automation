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

public class FEPS_Time_Card_UI_Object extends PageBase {

	public FEPS_Time_Card_UI_Object(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Time Card']")
	public WebElement Time_Card;
	
    @FindBy(how = How.XPATH, using = "//a[@class='select2-choice']")
	public WebElement Company_Code;

    @FindBy(how = How.XPATH, using = "//select[@id='cboCCInnerddl']")
	public WebElement Company_Code_dropdown;

    @FindBy(how = How.XPATH, using = "(//a[@class='select2-choice'])[2]")
	public WebElement SBU;
    
    @FindBy(how = How.XPATH, using = "//select[@id='cboSBUInnerddl']")
	public WebElement SBU_dropdown;
    
    @FindBy(how = How.XPATH, using = "(//a[@class='select2-choice'])[6]")
	public WebElement Dates;
    
    @FindBy(how = How.XPATH, using = "//option[text()='Custom']")
	public WebElement Dates_dropdown;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_ucDateRangeNavigatorControl_TATextBoxFromDate']")
    public WebElement Date1_Textfield;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_ucDateRangeNavigatorControl_TATextBoxToDate']")
    public WebElement Date2_Textfield;

    @FindBy(how = How.XPATH, using = "//input[@class='btn_feps']")
	public WebElement submit;
    
    @FindBy(how = How.XPATH, using = "(//a[@class='add_tc_img'])[3]")
   	public WebElement Add_Time_Clock;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_BeginTimeTxt']")
   	public WebElement Clock_In;
    
    @FindBy(how = How.XPATH, using = "(//input[@class='Width_100px'])[2]")
   	public WebElement Clock_Out;
    
    @FindBy(how = How.XPATH, using = "(//iframe[contains(@id,'TimeClockFrame')])[3]")
   	public WebElement Time_Clock_Frame_Element;
    
    @FindBy(how = How.XPATH, using = "//textarea[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_MgrNoteTxt']")
   	public WebElement Add_Manager_Note;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_SubmitBtn']")
   	public WebElement Add_Time_Clock_Btn;
    
    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Edit')]")
   	public WebElement Edit_Time_Clock;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_BeginTimeTxt']")
   	public WebElement Clock_In_Update;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_EndTimeTxt']")
   	public WebElement Clock_Out_Update;
    
    @FindBy(how = How.XPATH, using = "//textarea[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_MgrNoteTxt']")
   	public WebElement Add_Manager_Note_for_Update;
    
    @FindBy(how = How.XPATH, using = "//input[@name='ctl00$ctl00$MainPageControlsCph$ContentPlaceHolder$SubmitBtn']")
   	public WebElement Update_Time_Clock_Btn;
    
    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_TimeClocksGrid_ctl00_ctl10_ClockInLnk']")
   	public WebElement Edit_Time_Clock_for_Delete;
    
    @FindBy(how = How.XPATH, using = "//textarea[contains(@name,'MgrNoteTxt')]")
   	public WebElement Add_Manager_Note_for_Delete;
    
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_ctl00_MainPageControlsCph_ContentPlaceHolder_DeleteBtn']")
   	public WebElement Delete_Time_Clock_Btn;
	
    @FindBy(how = How.XPATH, using = "//button[text()='OK']")
   	public WebElement Click_on_OK;


	public String menu_item_string = "//a//span[text()='menu_item']";

}
