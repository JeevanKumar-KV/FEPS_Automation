package com.FEPS.test.stepdefinition.ui;

import com.FEPS.pages.ui_pageactions.FEPS_Login_Page_UI_Action;
import com.FEPS.pages.ui_pageactions.FEPS_Time_Absence_Report_UI_Action;
import com.FEPS.pages.ui_pageactions.FEPS_Time_Card_UI_Action;
import com.FEPS.pages.ui_pageactions.FEPS_Time_Clock_Activity_UI_Action;
import com.FEPS.pages.ui_pageactions.FEPS_Time_Menu_UI_Action;
import com.FEPS.pages.ui_pageactions.fepsAssumeHoursWorkedTodayUIAction;
import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.NavigationHelper;

public class BaseStepClass_UI {
	
	public NavigationHelper navigation = new NavigationHelper(ObjectRepo.driver);
	public FEPS_Login_Page_UI_Action loginPageActions = new FEPS_Login_Page_UI_Action(ObjectRepo.driver,ObjectRepo.scenario);
	public FEPS_Time_Menu_UI_Action TimePageActions = new FEPS_Time_Menu_UI_Action(ObjectRepo.driver,ObjectRepo.scenario);
	public FEPS_Time_Clock_Activity_UI_Action TimeCAPageActions = new FEPS_Time_Clock_Activity_UI_Action(ObjectRepo.driver,ObjectRepo.scenario);
	public FEPS_Time_Card_UI_Action TimeCPageActions = new FEPS_Time_Card_UI_Action(ObjectRepo.driver,ObjectRepo.scenario);
	public FEPS_Time_Absence_Report_UI_Action TimeAbsencePageActions = new FEPS_Time_Absence_Report_UI_Action(ObjectRepo.driver,ObjectRepo.scenario);
	public fepsAssumeHoursWorkedTodayUIAction assumeHoursPageActions = new fepsAssumeHoursWorkedTodayUIAction(ObjectRepo.driver,ObjectRepo.scenario);
}
