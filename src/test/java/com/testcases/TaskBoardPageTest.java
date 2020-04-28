package com.testcases;

import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;

public class TaskBoardPageTest extends BasePage {
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	DashBoardPage dashBoardPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_taskBoard_Test() {
		taskBoardPage.verify_taskBboard();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_List_of_late_tasks_Test() throws Exception {
		taskBoardPage.verify_List_of_late_tasks();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_List_and_upcoming_tasks_Test() throws Exception {
		taskBoardPage.verify_List_and_upcoming_tasks();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_List_of_live_tasks_Test() throws Exception {
		taskBoardPage.verify_List_of_live_tasks();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_List_of_completed_tasks_Test() throws Exception {
		taskBoardPage.verify_List_of_completed_tasks();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Filter_Questionnaires_Audits_Activities_and_Corrective_actions_Test() throws Exception {
		taskBoardPage.verify_Filter_Questionnaires_Audits_Activities_and_Corrective_actions();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Complete_and_reopen_Questionnaires_Test() throws Exception {
		taskBoardPage.verify_Complete_and_reopen_Questionnaires();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Complete_and_reopen_Audits_Test() throws Exception {
		taskBoardPage.verify_Complete_and_reopen_Audits();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Complete_and_reopen_Activities_Test() throws Exception {
		taskBoardPage.verify_Complete_and_reopen_Activities();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Complete_and_reopen_Corrective_actions_Test() throws Exception {
		taskBoardPage.verify_Complete_and_reopen_Corrective_actions(
				reader.getCellData("TaskBoard", 1, 3), reader.getCellData("TaskBoard", 3, 3), 
				reader.getCellData("TaskBoard", 5, 3), reader.getCellData("TaskBoard", 7, 3));
	}
	
	@Test//(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Complete_activity_from_to_do_list_Test() throws Exception {
		taskBoardPage.verify_Complete_activity_from_to_do_list();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Postpone_activity_from_to_do_list_Test() throws Exception {
		taskBoardPage.verify_Postpone_activity_from_to_do_list();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Complete_corrective_action_from_to_do_list_Test() throws Exception {
		taskBoardPage.verify_Complete_corrective_action_from_to_do_list();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Postpone_corrective_action_from_to_do_list_Test() throws Exception {
		taskBoardPage.verify_Postpone_corrective_action_from_to_do_list();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_View_corrective_action_log_Test() throws Exception {
		taskBoardPage.verify_View_corrective_action_log();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Export_to_PDF_option_for_corrective_actions_Test() throws Exception {
		taskBoardPage.verify_Export_to_PDF_option_for_corrective_actions(
				Paths.get(System.getProperty("user.home"),"Downloads").toString(), reader.getCellData("TaskBoard", 0, 1));
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Delete_corrective_action_Test() throws Exception {
		taskBoardPage.verify_Delete_corrective_action();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Add_tag_to_corrective_action_Test() throws Exception {
		taskBoardPage.verify_Add_tag_to_corrective_action(reader.getCellData("TaskBoard", 0, 2));
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Mandatory_fields_error_msg_while_completing_corrective_action_Test() throws Exception {
		taskBoardPage.verify_Mandatory_fields_error_msg_while_completing_corrective_action(
				reader.getCellData("TaskBoard", 0, 3), reader.getCellData("TaskBoard", 1, 3), 
				reader.getCellData("TaskBoard", 2, 3), reader.getCellData("TaskBoard", 3, 3), 
				reader.getCellData("TaskBoard", 4, 3), reader.getCellData("TaskBoard", 5, 3), 
				reader.getCellData("TaskBoard", 6, 3), reader.getCellData("TaskBoard", 7, 3));
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_Delete_activity_Test() throws Exception {
		taskBoardPage.verify_Delete_activity();
	}
	
	@Test(dependsOnMethods="verify_taskBoard_Test")
	public void verify_My_team_user_actions_Test() throws Exception {
		taskBoardPage.verify_My_team_user_actions();
	}
	
	
	
	
	
}
