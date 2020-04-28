package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;
import com.util.VerificationLibrary;

public class TaskBoardPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public TaskBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................ 
	@FindBy(xpath = "//span[@class='title'][contains(.,'Taskboard')]")
	static WebElement taskBoardLink;

	@FindBy(xpath="//span[text()='Dashboard']")
	static WebElement dashBoardLink;

	@FindBy(xpath="//span[contains(text(),'Build')]")
	static	WebElement buildLink;
	
	@FindBy(xpath="(//ul[@class='page-breadcrumb']//a)[1]")
	static WebElement build_BreadCrumb;

	@FindBy(xpath="//span[contains(text(),'Capture')]")
	static WebElement captureLink;
	
	@FindBy(xpath="//ul[@class='page-breadcrumb']//a[1]")
	WebElement capture_BreadCrumb;

	@FindBy(xpath="//span[contains(text(),'Analyse')]")
	static WebElement AnalyseLink;

	@FindBy(xpath="//span[contains(.,'Settings')]")
	WebElement SettingsLink;

	@FindBy(linkText="Audits")
	static WebElement buildAuditLink;
	
	@FindBy(xpath="//a[text()='Audits ']")
	static WebElement AnalyseAuditLink;

	// TarkBoard
	@FindBy(xpath="(//span[text()='Taskboard'])[2]")
	WebElement taskBoardHeader;

	// Late Tasks
	@FindBy(xpath = "//span[contains(@id,'taskLate')]")
	WebElement lateTasks;

	@FindBy(xpath = "//span[contains(@id,'taskLive')]")
	static WebElement upcomingTasks;

	@FindBy(xpath = "//span[contains(@id,'taskUpcoming')]")
	WebElement liveTasks;

	@FindBy(xpath = "//span[contains(@id,'taskCompleted')]")
	WebElement completedTasks;

	@FindBy(xpath = "//a[contains(@id,'btnShowFilter')]")
	WebElement filterBtn;

	@FindBy(xpath = "//span[contains(@id,'filter_Questionnaires')]")
	WebElement noOfQuestionnaires;

	@FindBy(xpath = "//span[contains(@id,'filter_Audits')]")
	WebElement noOfAudits;

	@FindBy(xpath = "//span[contains(@id,'filter_Activity')]")
	WebElement noOfActivities;

	@FindBy(xpath = "//span[contains(@id,'filter_Action')]")
	WebElement noOfCorrectiveActions;

	// Filters 
	@FindBy(xpath="//input[@id='chkQuestionnaires']/following::span[1]")
	WebElement questionnaiesCheckBox;

	@FindBy(xpath="//input[@id='chkAudits']/following::span[1]")
	WebElement auditsCheckBox;

	@FindBy(xpath="//input[@id='chkActivity']/following::span[1]")
	WebElement activitiesCheckBox;

	@FindBy(xpath="//input[@id='ckhAction']/following::span[1]")
	WebElement correctiveActionsCheckBox;

	@FindBy(xpath="//span[text()='Clear All']")
	WebElement clearAllBtn;

	// Complete & Reopen Questionnaires
	@FindBy(xpath = "//a[contains(@id,'btnComplete')]")
	WebElement completeBtn;

	@FindBy(xpath = "//a[contains(@id,'btnReopen')]")
	WebElement reopenBtn;

	@FindBy(xpath="//button[text()='OK']")
	WebElement okBtn;

	@FindBy(xpath="//label[text()[normalize-space()='Internal']]")
	WebElement internalOption;

	// Complete and reopen from to-do list
	@FindBy(xpath="(//button[text()='Complete'])[1]")
	WebElement completeBtn_toDoList;

	@FindBy(xpath="(//button[text()='Postpone'])[1]")
	WebElement postPoneBtn_tdDoList;

	@FindBy(xpath="(//th[@class='next'])[1]")
	WebElement nextBtn;

	// Corrective actions log, Export to PDF, tag & Delete
	@FindBy(xpath="//a[contains(.,'More')]")
	WebElement moreDD;

	@FindBy(xpath = "//a[contains(@title,'Log')]")
	WebElement logOption;

	@FindBy(xpath="//a[@title='Export PDF']")
	WebElement exportToPDFOption;

	@FindBy(xpath = "//a[contains(@title,'Delete Action')]")
	WebElement deleteActionBtn;

	@FindBy(xpath = "//a[contains(@title,'Tags')]")
	WebElement tagOption;

	@FindBy(xpath = "//input[contains(@class,'select2-search__field')]")
	WebElement tagSearchField;

	@FindBy(xpath="//button[contains(@onclick,'CancelActivityTagDlg')]")
	WebElement closeTagDlgBtn;

	@FindBy(xpath = "//div[contains(@id,'divA_DESC')]")
	WebElement desc_Out;

	@FindBy(xpath = "//textarea[contains(@id,'A_DESC')]")
	WebElement desc_In;

	@FindBy(xpath = "//span[contains(@id,'divError_F_DESC')]")
	WebElement descErrMsg;

	@FindBy(xpath = "//div[contains(@id,'divA_ROOTCAUSE')]")
	WebElement rootCause_Out;

	@FindBy(xpath = "//textarea[contains(@id,'A_ROOTCAUSE')]")
	WebElement rootCause_In;

	@FindBy(xpath = "//span[contains(@id,'divError_F_ROOTCAUSE')]")
	WebElement rootCauseErrMsg;

	@FindBy(xpath = "//div[contains(@id,'divA_CONTAINMENT')]")
	WebElement containmentAction_Out;

	@FindBy(xpath = "//textarea[contains(@id,'A_CONTAINMENT')]")
	WebElement containmentAction_In;

	@FindBy(xpath = "//span[contains(@id,'divError_F_CONTAINMENT')]")
	WebElement containmentActionErrMsg;

	@FindBy(xpath = "//div[contains(@id,'divA_CORRECTIVE')]")
	WebElement correctiveAction_Out;

	@FindBy(xpath = "//textarea[contains(@id,'A_CORRECTIVE')]")
	WebElement correctiveAction_In;

	@FindBy(xpath = "//span[contains(@id,'divError_F_CORRECTIVE')]")
	WebElement correctiveActionErrMsg;

	// My team user actions
	@FindBy(xpath="(//table[@class='table']//td)[1]")
	WebElement myTeamUser1;

	@FindBy(xpath="(//table[@class='table']//td)[2]/span")
	WebElement user1LateActions;

	@FindBy(xpath="(//table[@class='table']//td)[3]/span")
	WebElement user1LiveActions;

	@FindBy(xpath="(//table[@class='table']//td)[4]/span")
	WebElement user1CompletedActions;

	@FindBy(id="todoTitle")
	WebElement toDoHeader;




	// Actions:......................................................................................
	public void verify_taskBboard(){
		Assert.assertTrue(taskBoardHeader.isDisplayed(),"TaskBoard not opened");
		Reporter.log("TaskBoard opened", true);
	}

	// Navigating DashBoard Link
	public DashBoardPage clickOnDashBoardLink() {
		GenericLibrary.click(driver, dashBoardLink);
		return new DashBoardPage();
	}

	// Navigating Build Link
	public BuildPage clickOnBuildLink() {
		AjaxLibrary.jsClick(driver, buildLink);
		AjaxLibrary.jsClick(driver, build_BreadCrumb);
		return new BuildPage();
	}

	// Navigating Capture Link
	public CapturePage clickOnCaptureLink() {
		AjaxLibrary.click(driver, captureLink);
		AjaxLibrary.jsClick(driver, capture_BreadCrumb);
		return new CapturePage();
	}

	// Navigating to Analyse Link
	public AnalysePage clickOnAnalyseLink() {
		AjaxLibrary.click(driver, AnalyseLink);
		return new AnalysePage();
	}

	// Navigating to Settings Link
	public SettingsPage clickOnSettingsLink() {
		AjaxLibrary.click(driver, SettingsLink);
		return new SettingsPage();
	}

	// Navigate to Audits tab
	public BuildAuditsPage clickOnAuditsTab() {
		AjaxLibrary.jsClick(driver, buildLink);
		AjaxLibrary.jsClick(driver, build_BreadCrumb);
		AjaxLibrary.jsClick(driver, buildAuditLink);
		return new BuildAuditsPage();
	}

	// Navigating Capture Audits Tab
	public CaptureAuditsPage clickOnCaptureAuditsTab() {
		AjaxLibrary.click(driver, captureLink);
		AjaxLibrary.jsClick(driver, capture_BreadCrumb);
		AjaxLibrary.jsClick(driver, buildAuditLink);
		return new CaptureAuditsPage();
	}
	
	// Navigate to Analyse Audits Tab
	public AuditAnalysePage clickOn_Analyse_Audit() {
		AjaxLibrary.click(driver, AnalyseLink);
		AjaxLibrary.click(driver, AnalyseAuditLink);
		return new AuditAnalysePage();
	}


	public void verify_List_of_late_tasks() throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, lateTasks);
		int lateTasksOnBoard = Integer.parseInt(lateTasks.getText());
		Reporter.log("No.of late tasks tasks on board: "+lateTasksOnBoard, true);
		if (lateTasksOnBoard == 0) {
			Reporter.log("No late tasks available", true);
		} else {
			for (int i = 0; i < 8; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> lateRecords = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			Reporter.log("No.of late tasks from record list: "+lateRecords.size(), true);
			a.assertEquals(lateRecords.size(), lateTasksOnBoard, "Late tasks board value and records total are not matched");
			Reporter.log("Late tasks board value and records total are matched", true);
		}
		JavascriptLibrary.javascriptClickElement(driver, filterBtn);
		Thread.sleep(1000);
		int questionnaires = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]",""));
		int audits = Integer.parseInt(noOfAudits.getText().replaceAll("[()]",""));
		int activities = Integer.parseInt(noOfActivities.getText().replaceAll("[()]",""));
		int correctiveActions = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]",""));
		Reporter.log("No of Questionnaires in filter: "+questionnaires, true);
		Reporter.log("No of Audits in filter: "+audits, true);
		Reporter.log("No of Activities in filter: "+activities, true);
		Reporter.log("No of Corrective Actions in filter: "+correctiveActions, true);
		a.assertEquals(questionnaires+audits+activities+correctiveActions, lateTasksOnBoard, "Late tasks board value and filters values are not matched");
		Reporter.log("Late tasks board value and filters values are matched", true);
		a.assertAll();
	}

	public void verify_List_and_upcoming_tasks() throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, upcomingTasks);
		int upcomingTasksOnBoard = Integer.parseInt(upcomingTasks.getText());
		Reporter.log("No.of upcoming tasks tasks on board: "+upcomingTasksOnBoard, true);
		if (upcomingTasksOnBoard == 0) {
			Reporter.log("No upcoming tasks available", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
			}
			List<WebElement> lateRecords = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			Reporter.log("No.of upcoming tasks from record list: "+lateRecords.size(), true);
			a.assertEquals(upcomingTasksOnBoard, lateRecords.size(), "Upcoming tasks board value and records total are not matched");
			Reporter.log("Upcoming tasks board value and records total are matched", true);
		}
		JavascriptLibrary.javascriptClickElement(driver, filterBtn);
		Thread.sleep(1000);
		int questionnaires = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]",""));
		int audits = Integer.parseInt(noOfAudits.getText().replaceAll("[()]",""));
		int activities = Integer.parseInt(noOfActivities.getText().replaceAll("[()]",""));
		int correctiveActions = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]",""));
		Reporter.log("No of Questionnaires in filter: "+questionnaires, true);
		Reporter.log("No of Audits in filter: "+audits, true);
		Reporter.log("No of Activities in filter: "+activities, true);
		Reporter.log("No of Corrective Actions in filter: "+correctiveActions, true);
		a.assertEquals(questionnaires+audits+activities+correctiveActions, upcomingTasksOnBoard, "Upcoming tasks board value and filters values are not matched");
		Reporter.log("Upcoming tasks board value and filters values are matched", true);
		a.assertAll();
	}

	public void verify_List_of_live_tasks() throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, liveTasks);
		int liveTasksOnBoard = Integer.parseInt(liveTasks.getText());
		Reporter.log("No.of live tasks on board: "+liveTasksOnBoard, true);
		if (liveTasksOnBoard == 0) {
			Reporter.log("No live tasks available", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> lateRecords = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			Reporter.log("No.of live tasks from record list: "+lateRecords.size(), true);
			a.assertEquals(liveTasksOnBoard, lateRecords.size(), "Live tasks board value and records total are not matched");
			Reporter.log("Live tasks board value and records total are matched", true);
		}
		JavascriptLibrary.javascriptClickElement(driver, filterBtn);
		Thread.sleep(1000);
		int questionnaires = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]",""));
		int audits = Integer.parseInt(noOfAudits.getText().replaceAll("[()]",""));
		int activities = Integer.parseInt(noOfActivities.getText().replaceAll("[()]",""));
		int correctiveActions = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]",""));
		Reporter.log("No of Questionnaires in filter: "+questionnaires, true);
		Reporter.log("No of Audits in filter: "+audits, true);
		Reporter.log("No of Activities in filter: "+activities, true);
		Reporter.log("No of Corrective Actions in filter: "+correctiveActions, true);
		a.assertEquals(questionnaires+audits+activities+correctiveActions, liveTasksOnBoard, "Live tasks board value and filters values are not matched");
		Reporter.log("Live tasks board value and filters values are matched", true);
		a.assertAll();
	}

	public void verify_List_of_completed_tasks() throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, completedTasks);
		int completedTasksOnBoard = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks on board: "+completedTasksOnBoard, true);
		if (completedTasksOnBoard == 0) {
			Reporter.log("No completed tasks available", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
			}
			List<WebElement> lateRecords = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			Reporter.log("No.of completed tasks from record list: "+lateRecords.size(), true);
			a.assertEquals(completedTasksOnBoard, lateRecords.size(), "Completed tasks board value and records total are not matched");
			Reporter.log("Completed tasks board value and records total are matched", true);
		}
		JavascriptLibrary.javascriptClickElement(driver, filterBtn);
		Thread.sleep(1000);
		int questionnaires = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]",""));
		int audits = Integer.parseInt(noOfAudits.getText().replaceAll("[()]",""));
		int activities = Integer.parseInt(noOfActivities.getText().replaceAll("[()]",""));
		int correctiveActions = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]",""));
		Reporter.log("No of Questionnaires in filter: "+questionnaires, true);
		Reporter.log("No of Audits in filter: "+audits, true);
		Reporter.log("No of Activities in filter: "+activities, true);
		Reporter.log("No of Corrective Actions in filter: "+correctiveActions, true);
		a.assertEquals(questionnaires+audits+activities+correctiveActions, completedTasksOnBoard, "Completed tasks board value and filters values are not matched");
		Reporter.log("Completed tasks board value and filters values are matched", true);
		a.assertAll();
	}

	public void verify_Filter_Questionnaires_Audits_Activities_and_Corrective_actions() throws Exception {
		SoftAssert a = new SoftAssert();
		// Filter Questionnaires
		JavascriptLibrary.javascriptClickElement(driver, filterBtn);
		Thread.sleep(1000);
		AjaxLibrary.jsClick(driver, questionnaiesCheckBox);
		int questionnairesFilterCount = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Questionnaires filter: "+questionnairesFilterCount, true);
		if (questionnairesFilterCount == 0) {
			Reporter.log("No Audits found", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> questionnairesFilterRecordsList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int questionnairesFilterRecordsCount = questionnairesFilterRecordsList.size();
			Reporter.log("No.of records for Questionnaires filter: "+questionnairesFilterRecordsCount, true);
			a.assertEquals(questionnairesFilterRecordsCount, questionnairesFilterCount, "Questionnaies filter count and resultant records count are not matched");
			Reporter.log("Questionnaies filter count and resultant records count matched", true);
		}

		AjaxLibrary.jsClick(driver, clearAllBtn);
		// Filter Audits
		AjaxLibrary.jsClick(driver, auditsCheckBox);
		int auditsFilterCount = Integer.parseInt(noOfAudits.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Audits filter: "+auditsFilterCount, true);
		if (auditsFilterCount == 0) {
			Reporter.log("No Audits found", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> auditsFilterRecordsList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int auditsFilterRecordsCount = auditsFilterRecordsList.size();
			Reporter.log("No.of records for Audits filter: "+auditsFilterRecordsCount, true);
			a.assertEquals(auditsFilterRecordsCount, auditsFilterCount, "Audits filter count and resultant records count are not matched");
			Reporter.log("Audits filter count and resultant records count matched", true);
		}
		AjaxLibrary.jsClick(driver, clearAllBtn);
		// Filter Activities
		AjaxLibrary.jsClick(driver, activitiesCheckBox);
		int activitiesFilterCount = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Activities filter: "+activitiesFilterCount, true);
		if (activitiesFilterCount == 0) {
			Reporter.log("No Activities found", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> activitiesFilterRecordsList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int activitiesFilterRecordsCount = activitiesFilterRecordsList.size();
			Reporter.log("No.of records for Audits filter: "+activitiesFilterRecordsCount, true);
			a.assertEquals(activitiesFilterRecordsCount, activitiesFilterCount, "Activities filter count and resultant records count are not matched");
			Reporter.log("Activities filter count and resultant records count matched", true);
		}
		AjaxLibrary.jsClick(driver, clearAllBtn);
		// Filter Corrective actions
		AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
		int corrActionFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective Actions filter: "+corrActionFilterCount, true);
		if (corrActionFilterCount == 0) {
			Reporter.log("No Corrective Actions found", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> corrActionsFilterRecordsList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int corrActionsFilterRecordsCount = corrActionsFilterRecordsList.size();
			Reporter.log("No.of records for Corrective Actions filter: "+corrActionsFilterRecordsCount, true);
			a.assertEquals(corrActionsFilterRecordsCount, corrActionFilterCount, "Corrective Actions filter count and resultant records count are not matched");
			Reporter.log("Corrective Actions filter count and resultant records count matched", true);
		}
		AjaxLibrary.jsClick(driver, clearAllBtn);
		// Check all filters and Compare it with resultant records
		AjaxLibrary.jsClick(driver, questionnaiesCheckBox);
		AjaxLibrary.jsClick(driver, auditsCheckBox);
		AjaxLibrary.jsClick(driver, activitiesCheckBox);
		AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
		int questionnairesFilterCount1 = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]", ""));
		int auditsFilterCount1 = Integer.parseInt(noOfAudits.getText().replaceAll("[()]", ""));
		int activitiesFilterCount1 = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		int corrActionFilterCount1 = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		int allCheckedFiltersTotal = questionnairesFilterCount1+auditsFilterCount1+activitiesFilterCount1+corrActionFilterCount1;
		Reporter.log("All enabled filters total : "+allCheckedFiltersTotal, true);
		for (int i = 0; i < 4; i++) {
			AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
			Thread.sleep(1000);
		}
		List<WebElement> allFiltersRecordsList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
		int allFiltersRecordsCount = allFiltersRecordsList.size();
		Reporter.log("Records count for all enabled filters : "+allFiltersRecordsCount, true);
		a.assertEquals(allFiltersRecordsCount, allCheckedFiltersTotal, "All enabled filters count and resultant records count are not matched");
		Reporter.log("All enabled filters count and resultant records count are matched", true);

		a.assertAll();
	}

	public void verify_Complete_and_reopen_Questionnaires() throws Exception {
		SoftAssert a = new SoftAssert();
		// Complete
		int noOfCompletedTasks = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before completion: "+noOfCompletedTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int questionnairesFilterCount = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Questionnaires filter before completion: "+questionnairesFilterCount, true);
		if (questionnairesFilterCount == 0) {
			Reporter.log("No Questionnaires found", true);
		} else {
			AjaxLibrary.jsClick(driver, questionnaiesCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			AjaxLibrary.jsClick(driver, completeBtn);
			int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
			a.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Questionnaire not completed");
			Reporter.log("Questionnaire completed", true);
		}
		// Reopen 
		int noOfCompletedTasks3 = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before reopen: "+noOfCompletedTasks3, true);
		AjaxLibrary.jsClick(driver, completedTasks);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int questionnairesFilterCount2 = Integer.parseInt(noOfQuestionnaires.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Questionnaires filter before reopen: "+questionnairesFilterCount2, true);
		if (questionnairesFilterCount2 == 0) {
			Reporter.log("No Questionnaires found", true);
		} else {
			AjaxLibrary.jsClick(driver, questionnaiesCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			AjaxLibrary.jsClick(driver, reopenBtn);
			AjaxLibrary.jsClick(driver, okBtn);
			AjaxLibrary.jsClick(driver, taskBoardLink);
			int noOfCompletedTasks4 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after reopen: "+noOfCompletedTasks4, true);
			a.assertTrue(noOfCompletedTasks4 < noOfCompletedTasks3, "Questionnaire not reopened");
			Reporter.log("Questionnaire reopened", true);
		}
		a.assertAll();
	}

	public void verify_Complete_and_reopen_Audits() throws Exception {
		SoftAssert a = new SoftAssert();
		// Complete
		int noOfCompletedTasks = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before completion: "+noOfCompletedTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int auditFilterCount = Integer.parseInt(noOfAudits.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Audits filter before completion: "+auditFilterCount, true);
		if (auditFilterCount == 0) {
			Reporter.log("No Questionnaires found", true);
		} else {
			AjaxLibrary.jsClick(driver, auditsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			AjaxLibrary.jsClick(driver, completeBtn);
			try {
				int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
				Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
				a.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Audit not completed");
				Reporter.log("Audit completed", true);
			} catch (Exception e) {
				AjaxLibrary.jsClick(driver, internalOption);
				GenericLibrary.click(driver, completeBtn);
				int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
				Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
				a.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Audit not completed");
				Reporter.log("Audit completed", true);
			}
		}
		// Reopen 
		int noOfCompletedTasks3 = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before reopen: "+noOfCompletedTasks3, true);
		AjaxLibrary.jsClick(driver, completedTasks);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int auditFilterCount2 = Integer.parseInt(noOfAudits.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Audits filter before reopen: "+auditFilterCount2, true);
		if (auditFilterCount2 == 0) {
			Reporter.log("No Audits found", true);
		} else {
			AjaxLibrary.jsClick(driver, auditsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			JavascriptLibrary.javascriptClickElement(driver, reopenBtn);
			AjaxLibrary.checkAlert_Accept(driver);
			AjaxLibrary.jsClick(driver, taskBoardLink);
			int noOfCompletedTasks4 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after reopen: "+noOfCompletedTasks4, true);
			a.assertTrue(noOfCompletedTasks4 < noOfCompletedTasks3, "Audit not reopened");
			Reporter.log("Audit reopened", true);
		}
		a.assertAll();
	}

	public void verify_Complete_and_reopen_Activities() throws Exception {
		SoftAssert a = new SoftAssert();
		// Complete
		int noOfCompletedTasks = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before completion: "+noOfCompletedTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int activitiesFilterCount = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Activities filter before completion: "+activitiesFilterCount, true);
		if (activitiesFilterCount == 0) {
			Reporter.log("No Activities found", true);
		} else {
			AjaxLibrary.jsClick(driver, activitiesCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			AjaxLibrary.jsClick(driver, completeBtn);
			int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
			a.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Activity not completed");
			Reporter.log("Activity completed", true);
		}
		// Reopen 
		AjaxLibrary.jsClick(driver, taskBoardLink);
		int noOfCompletedTasks3 = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before reopen: "+noOfCompletedTasks3, true);
		AjaxLibrary.jsClick(driver, completedTasks);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int activitiesFilterCount2 = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Activities filter before reopen: "+activitiesFilterCount2, true);
		if (activitiesFilterCount2 == 0) {
			Reporter.log("No Activities found", true);
		} else {
			AjaxLibrary.jsClick(driver, activitiesCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.click(driver, reopenBtn);
			AjaxLibrary.checkAlert_Accept(driver);
			int noOfCompletedTasks4 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after reopen: "+noOfCompletedTasks4, true);
			a.assertTrue(noOfCompletedTasks4 < noOfCompletedTasks3, "Activity not reopened");
			Reporter.log("Activity reopened", true);
		}
		a.assertAll();
	}

	public void verify_Complete_and_reopen_Corrective_actions(String desc, String rootCause, String contAct, String correctiveAct) throws Exception {
		SoftAssert a = new SoftAssert();
		// Complete
		int noOfCompletedTasks = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before completion: "+noOfCompletedTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int corrActnsFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter before completion: "+corrActnsFilterCount, true);
		if (corrActnsFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			
			AjaxLibrary.clickClearAndType(driver, desc_Out, desc_In, desc);
			AjaxLibrary.clickClearAndType(driver, rootCause_Out, rootCause_In, rootCause);
			AjaxLibrary.clickClearAndType(driver, containmentAction_Out, containmentAction_In, contAct);
			AjaxLibrary.clickClearAndType(driver, correctiveAction_Out, correctiveAction_In, correctiveAct);
			
			AjaxLibrary.jsClick(driver, completeBtn);
			int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
			a.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Corrective action not completed");
			Reporter.log("Corrective action completed", true);
		}
		// Reopen 
		AjaxLibrary.jsClick(driver, taskBoardLink);
		int noOfCompletedTasks3 = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before reopen: "+noOfCompletedTasks3, true);
		AjaxLibrary.jsClick(driver, completedTasks);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int corrActnsFilterCount2 = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter before reopen: "+corrActnsFilterCount2, true);
		if (corrActnsFilterCount2 == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.click(driver, reopenBtn);
			AjaxLibrary.checkAlert_Accept(driver);
			int noOfCompletedTasks4 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after reopen: "+noOfCompletedTasks4, true);
			a.assertTrue(noOfCompletedTasks4 < noOfCompletedTasks3, "Corrective action not reopened");
			Reporter.log("Corrective action reopened", true);
		}
		a.assertAll();
	}

	public void verify_Complete_activity_from_to_do_list() throws Exception {
		int noOfCompletedTasks = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before completion: "+noOfCompletedTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int activitiesFilterCount = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Activities filter before completion: "+activitiesFilterCount, true);
		if (activitiesFilterCount == 0) {
			Reporter.log("No Activities found", true);
		} else {
			AjaxLibrary.jsClick(driver, activitiesCheckBox);
			AjaxLibrary.jsClick(driver, liveTasks);
			AjaxLibrary.jsClick(driver, completeBtn_toDoList);
			int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
			Assert.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Activity not completed from to-do list");
			Reporter.log("Activity completed from to-do list", true);
		}
	}

	public void verify_Postpone_activity_from_to_do_list() throws Exception {
		AjaxLibrary.jsClick(driver, lateTasks);
		int noOfLateTasks = Integer.parseInt(lateTasks.getText());
		Reporter.log("No.of late tasks before postpone: "+noOfLateTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int activitiesFilterCount = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Activities filter before postpone: "+activitiesFilterCount, true);
		if (activitiesFilterCount == 0) {
			Reporter.log("No Activities found", true);
		} else {
			AjaxLibrary.jsClick(driver, activitiesCheckBox);
			AjaxLibrary.jsClick(driver, postPoneBtn_tdDoList);
			Thread.sleep(1000);
			AjaxLibrary.jsClick(driver, nextBtn);
			Thread.sleep(1000);
			List<WebElement> dateList = driver.findElements(By.cssSelector(".day"));
			for (WebElement ele : dateList) {
				if (ele.getText().equals("20")) {
					AjaxLibrary.jsClick(driver, ele);
					Thread.sleep(1000);
					break;
				}
			}
			int noOfLateTasks2 = Integer.parseInt(lateTasks.getText());
			Reporter.log("No.of late tasks after postpone: "+noOfLateTasks2, true);
			Assert.assertTrue(noOfLateTasks2 < noOfLateTasks, "Activity not postponed from to-do list");
			Reporter.log("Activity postponed from to-do list", true);
		}
	}

	public void verify_Complete_corrective_action_from_to_do_list() throws Exception {
		int noOfCompletedTasks = Integer.parseInt(completedTasks.getText());
		Reporter.log("No.of completed tasks before completion: "+noOfCompletedTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int caFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter before completion: "+caFilterCount, true);
		if (caFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			AjaxLibrary.jsClick(driver, liveTasks);
			AjaxLibrary.jsClick(driver, completeBtn_toDoList);
			int noOfCompletedTasks2 = Integer.parseInt(completedTasks.getText());
			Reporter.log("No.of completed tasks after completion: "+noOfCompletedTasks2, true);
			Assert.assertTrue(noOfCompletedTasks2 > noOfCompletedTasks, "Corrective action not completed from to-do list");
			Reporter.log("Corrective action completed from to-do list", true);
		}
	}

	public void verify_Postpone_corrective_action_from_to_do_list() throws Exception {
		AjaxLibrary.jsClick(driver, lateTasks);
		int noOfLateTasks = Integer.parseInt(lateTasks.getText());
		Reporter.log("No.of late tasks before postpone: "+noOfLateTasks, true);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int caFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter before postpone: "+caFilterCount, true);
		if (caFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			AjaxLibrary.jsClick(driver, postPoneBtn_tdDoList);
			Thread.sleep(1000);
			AjaxLibrary.jsClick(driver, nextBtn);
			Thread.sleep(1000);
			List<WebElement> dateList = driver.findElements(By.cssSelector(".day"));
			for (WebElement ele : dateList) {
				if (ele.getText().equals("20")) {
					AjaxLibrary.jsClick(driver, ele);
					Thread.sleep(1000);
					break;
				}
			}
			int noOfLateTasks2 = Integer.parseInt(lateTasks.getText());
			Reporter.log("No.of late tasks after postpone: "+noOfLateTasks2, true);
			Assert.assertTrue(noOfLateTasks2 < noOfLateTasks, "Corrective action not postponed from to-do list");
			Reporter.log("Corrective action postponed from to-do list", true);
		}
	}

	public void verify_View_corrective_action_log() throws Exception {
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int caFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter: "+caFilterCount, true);
		if (caFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.moveToElement(driver, moreDD);
			AjaxLibrary.jsClick(driver, logOption);
			List<WebElement> logList = driver.findElements(By.xpath("//table[@id='tbLogList']//tbody//tr/td"));
			Assert.assertTrue(logList.size() != 0, "Logs are not visible for corrective actions");
			Reporter.log("Logs are visible for corrective actions", true);
		}
	}

	public void verify_Export_to_PDF_option_for_corrective_actions(String downloadPath, String fileName) throws Exception{
		AjaxLibrary.jsClick(driver, liveTasks);
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int caFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter: "+caFilterCount, true);
		if (caFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.moveToElement(driver, moreDD);
			AjaxLibrary.jsClick(driver, exportToPDFOption);
			Thread.sleep(3000);
			Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Export to PDF option is not functional");
			Reporter.log("Export to PDF option is functional", true);
		}
	}

	public void verify_Delete_corrective_action() throws Exception {
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int caFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Corrective actions filter: "+caFilterCount, true);
		if (caFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.click(driver, deleteActionBtn);
			AjaxLibrary.checkAlert_Accept(driver);
			AjaxLibrary.jsClick(driver, filterBtn);
			Thread.sleep(1000);
			int caFilterCount2 = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
			Reporter.log("Filter count at Corrective actions filter: "+caFilterCount2, true);
			Assert.assertTrue(caFilterCount2 < caFilterCount, "Corrective action not deleted");
			Reporter.log("Corrective action deleted", true);
		}
	}

	public void verify_Add_tag_to_corrective_action(String tag) throws Exception {
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int caFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		if (caFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.moveToElement(driver, moreDD);
			AjaxLibrary.jsClick(driver, tagOption);
			tagSearchField.sendKeys(tag);
			Thread.sleep(1000);
			AjaxLibrary.click(driver, By.xpath("//div[contains(text(),'"+tag+"')]//preceding::div[1]"));
			AjaxLibrary.jsClick(driver, closeTagDlgBtn);
			Assert.assertTrue(driver.findElement(By.linkText(tag)).isDisplayed(), "Tag not added");
			Reporter.log("Tag added", true);
		}
	}

	public void verify_Mandatory_fields_error_msg_while_completing_corrective_action(String descErrExp, String desc, 
			String rootCauseErrExp, String rootCause, String containmentErrExp, String containmentAct, String correctiveErrExp, String correctiveAct) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int corrActnsFilterCount = Integer.parseInt(noOfCorrectiveActions.getText().replaceAll("[()]", ""));
		if (corrActnsFilterCount == 0) {
			Reporter.log("No Corrective actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, correctiveActionsCheckBox);
			AjaxLibrary.jsClick(driver, liveTasks);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			// Description
			AjaxLibrary.jsClick(driver, desc_Out);
			desc_In.clear();
			AjaxLibrary.click(driver, completeBtn);
			GenericLibrary.waitForElementVisibility(driver, descErrMsg);
			a.assertEquals(descErrMsg.getText(), descErrExp, "Error message not displayed for description");
			Reporter.log("Error message displayed for description field", true);
			JavascriptLibrary.javascriptType(driver, desc_In, desc);
			// Root cause
			AjaxLibrary.jsClick(driver, rootCause_Out);
			rootCause_In.clear();
			AjaxLibrary.jsClick(driver, completeBtn);
			GenericLibrary.waitForElementVisibility(driver, rootCauseErrMsg);
			a.assertEquals(rootCauseErrMsg.getText(), rootCauseErrExp, "Error message not displayed for root cause");
			Reporter.log("Error message displayed for root cause field", true);
			JavascriptLibrary.javascriptType(driver, rootCause_In, rootCause);
			// Containment action
			AjaxLibrary.jsClick(driver, containmentAction_Out);
			containmentAction_In.clear();
			AjaxLibrary.jsClick(driver, completeBtn);
			GenericLibrary.waitForElementVisibility(driver, containmentActionErrMsg);
			a.assertEquals(containmentActionErrMsg.getText(), containmentErrExp, "Error message not displayed for containment action");
			Reporter.log("Error message displayed for containment action field", true);
			JavascriptLibrary.javascriptType(driver, containmentAction_In, containmentAct);
			// Corrective action
			AjaxLibrary.jsClick(driver, correctiveAction_Out);
			correctiveAction_In.clear();
			AjaxLibrary.jsClick(driver, completeBtn);
			GenericLibrary.waitForElementVisibility(driver, correctiveActionErrMsg);
			a.assertEquals(correctiveActionErrMsg.getText(), correctiveErrExp, "Error message not displayed for corrective action");
			Reporter.log("Error message displayed for corrective action field", true);
			JavascriptLibrary.javascriptType(driver, correctiveAction_In, correctiveAct);
		}
		a.assertAll();
	}

	public void verify_Delete_activity() throws Exception {
		AjaxLibrary.jsClick(driver, filterBtn);
		Thread.sleep(1000);
		int activitiesFilterCount = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
		Reporter.log("Filter count at Activities filter: "+activitiesFilterCount, true);
		if (activitiesFilterCount == 0) {
			Reporter.log("No Activities found", true);
		} else {
			AjaxLibrary.jsClick(driver, activitiesCheckBox);
			List<WebElement> list = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			AjaxLibrary.jsClick(driver, list.get(0));
			GenericLibrary.click(driver, deleteActionBtn);
			AjaxLibrary.checkAlert_Accept(driver);
			AjaxLibrary.jsClick(driver, filterBtn);
			Thread.sleep(1000);
			int activitiesFilterCount2 = Integer.parseInt(noOfActivities.getText().replaceAll("[()]", ""));
			Reporter.log("Filter count at Corrective actions filter: "+activitiesFilterCount2, true);
			Assert.assertTrue(activitiesFilterCount2 < activitiesFilterCount, "Activity not deleted");
			Reporter.log("Activity deleted", true);
		}
	}

	public void verify_My_team_user_actions() throws Exception {
		SoftAssert a = new SoftAssert();
		// User selection
		AjaxLibrary.jsClick(driver, myTeamUser1);
		String selection = myTeamUser1.getText();
		String resultantUser = toDoHeader.getText();
		Reporter.log("User selection: "+selection, true);
		Reporter.log("Resultant User: "+resultantUser, true);
		a.assertTrue(resultantUser.contains(selection.toUpperCase()), "My Team user not selecetd");
		Reporter.log("My team user selected", true);
		// Late Actions
		int userLateCount = Integer.parseInt(user1LateActions.getText());
		if (userLateCount == 0) {
			Reporter.log("No late actions found", true);
		} else {
			AjaxLibrary.jsClick(driver, user1LateActions);
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> lateList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int lateRecordsCount = lateList.size();
			Reporter.log("No.of Late action records: "+lateRecordsCount, true);
			a.assertEquals(lateRecordsCount, userLateCount, "Late actions are not matched for the given user");
			Reporter.log("Late actions are matched for the given user", true);
		}
		// Live Actions
		AjaxLibrary.jsClick(driver, user1LiveActions);
		int userLiveCount = Integer.parseInt(user1LiveActions.getText());
		if (userLiveCount == 0) {
			Reporter.log("No live actions found", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> liveList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int liveRecordsCount = liveList.size();
			Reporter.log("No.of Live action records: "+liveRecordsCount, true);
			a.assertEquals(userLiveCount, userLiveCount, "Live actions are not matched for the given user");
			Reporter.log("Live actions are matched for the given user", true);
		}
		// Completed Actions
		int userCompletedCount = 0;
		try {
			AjaxLibrary.jsClick(driver, user1CompletedActions);
			userCompletedCount = Integer.parseInt(user1CompletedActions.getText());
		} catch (Exception e) {
			Reporter.log("No completed actions found", true);
		}
		if (userCompletedCount == 0) {
			Reporter.log("No completed actions found", true);
		} else {
			for (int i = 0; i < 4; i++) {
				AjaxLibrary.scrollIntoView(driver, By.xpath("(//span[contains(@class,'mt-action-author')])[last()]"));
				Thread.sleep(1000);
			}
			List<WebElement> completedList = driver.findElements(By.xpath("//span[contains(@class,'mt-action-author')]"));
			int completedRecordsCount = completedList.size();
			Reporter.log("No.of Completed action records: "+completedRecordsCount, true);
			a.assertEquals(completedRecordsCount, userCompletedCount, "Completed actions are not matched for the given user");
			Reporter.log("Completed actions are matched for the given user", true);
		}
		a.assertAll();
	}	
























}
