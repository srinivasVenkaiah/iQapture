package com.testcases;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.BuildAuditsPage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;

public class BuildAuditPageTest extends BasePage {
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	BuildAuditsPage buildAuditsPage;
	ExcelUtility reader;

	@BeforeMethod(groups="AuditPermissions")
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		buildAuditsPage = taskBoardPage.clickOnAuditsTab();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}

	@AfterMethod(groups="AuditPermissions")
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verify_AuditsTab_Test(){
		Assert.assertTrue(buildAuditsPage.verify_AuditsTab(), "Audit Add Button is Missing on the Page");
		Reporter.log("Audit Add Button Present - Test PASS", true);
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Audit_search_option_Test() {
		buildAuditsPage.verify_Audit_search_option();
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Error_message_for_invalid_search_Test() {
		buildAuditsPage.verify_Error_message_for_invalid_search();
	}

	@Test//(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Create_audit_and_upload_image_to_audit_Test() throws Exception {
		buildAuditsPage.verify_Create_audit_and_upload_image_to_audit(
				reader.getCellData("Audits", 0, 1), System.getProperty("user.dir")+"\\Files\\audit.jpg");
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Delete_audit_Test() throws Exception {
		buildAuditsPage.verify_Delete_audit(reader.getCellData("Audits", 0, 2));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Description_field_error_message_Test() throws Exception {
		buildAuditsPage.verify_Description_field_error_message(reader.getCellData("Audits", 0, 3));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Add_dataset_to_audit_Test() throws Exception {
		buildAuditsPage.verify_Add_dataset_to_audit(reader.getCellData("Audits", 0, 4), 
				reader.getCellData("Audits", 1, 4), reader.getCellData("Audits", 2, 4), 
				reader.getCellData("Audits", 3, 4), reader.getCellData("Audits", 4, 4), 
				reader.getCellData("Audits", 5, 4), reader.getCellData("Audits", 6, 4), 
				reader.getCellData("Audits", 7, 4), reader.getCellData("Audits", 8, 4), 
				reader.getCellData("Audits", 9, 4), reader.getCellData("Audits", 10, 4), 
				reader.getCellData("Audits", 11, 4), reader.getCellData("Audits", 12, 4));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Open_and_close_field_panel_and_Delete_created_field_Test() throws Exception {
		buildAuditsPage.verify_Open_and_close_field_panel_and_Delete_created_field(reader.getCellData("Audits", 0, 5), 
				reader.getCellData("Audits", 1, 5), reader.getCellData("Audits", 2, 5), 
				reader.getCellData("Audits", 3, 5));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Add_Schedules_and_delete_schedule_against_the_audit_Test() throws Exception {
		buildAuditsPage.verify_Add_Schedules_and_delete_schedule_against_the_audit(reader.getCellData("Audits", 0, 6), 
				reader.getCellData("Audits", 1, 6));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Add_people_and_company_and_Delete_added_people_and_company_against_the_audit_Test() throws Exception {
		buildAuditsPage.verify_Add_people_and_company_and_Delete_added_people_and_company_against_the_audit(reader.getCellData("Audits", 0, 7), 
				reader.getCellData("Audits", 1, 7), reader.getCellData("Audits", 2, 7));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Show_audit_log_and_Trash_can_action_options_Test() throws Exception {
		buildAuditsPage.verify_Show_audit_log_and_Trash_can_action_options(reader.getCellData("Audits", 0, 8), 
				reader.getCellData("Audits", 1, 8));
	}

	@Test(dependsOnMethods="verify_AuditsTab_Test")
	public void verify_Download_and_Upload_questions_template_Test() throws Exception {
		buildAuditsPage.verify_Download_and_Upload_questions_template(reader.getCellData("Audits", 0, 9), 
				Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("Audits", 1, 9), System.getProperty("user.dir")+"\\Files\\Audits Questions Template.xlsx");
	}

	//--------------------------------- Audit Permissions (Start) ---------------------------------------------------------
	@Test(groups="AuditPermissions")
	public void verify_Audit_Build_Owner_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Build_Owner_user_permissions(reader.getCellData("Audits", 0, 21), 
				reader.getCellData("Audits", 1, 21), reader.getCellData("Audits", 2, 21), 
				reader.getCellData("Audits", 3, 21), reader.getCellData("Audits", 4, 21), 
				reader.getCellData("Audits", 5, 21), reader.getCellData("Audits", 6, 21));
		Reporter.log("Audits Owner user permissions are functional", true);
	}

	@Test(groups="AuditPermissions")
	public void verify_Audit_Build_Edit_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Build_Edit_user_permissions(reader.getCellData("Audits", 0, 22), 
				reader.getCellData("Audits", 1, 22), reader.getCellData("Audits", 2, 22), 
				reader.getCellData("Audits", 3, 22), reader.getCellData("Audits", 4, 22), 
				reader.getCellData("Audits", 5, 22));
		Reporter.log("Audits Edit user permissions are functional", true);
	}

	@Test(groups="AuditPermissions")
	public void verify_Audit_Build_Do_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Build_Do_user_permissions(reader.getCellData("Audits", 0, 23), 
				reader.getCellData("Audits", 1, 23), reader.getCellData("Audits", 2, 23), 
				reader.getCellData("Audits", 3, 23), reader.getCellData("Audits", 4, 23));
		Reporter.log("Audits Do user permissions are functional", true);
	}

	@Test(groups="AuditPermissions")
	public void verify_Audit_Build_View_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Build_View_user_permissions(reader.getCellData("Audits", 0, 24), 
				reader.getCellData("Audits", 1, 24), reader.getCellData("Audits", 2, 24), 
				reader.getCellData("Audits", 3, 24), reader.getCellData("Audits", 4, 24));
		Reporter.log("Audits View user permissions are functional", true);
	}
	//--------------------------------- Audit Permissions (End)---------------------------------------------------------

	//--------------------------------- Audit Capture Permissions (Start) ---------------------------------------------------------
	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Audit_Capture_Owner_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Capture_Owner_user_permissions(reader.getCellData("Audits", 0, 25), 
				reader.getCellData("Audits", 1, 25), reader.getCellData("Audits", 2, 25), 
				reader.getCellData("Audits", 3, 25), reader.getCellData("Audits", 4, 25), 
				reader.getCellData("Audits", 5, 25), reader.getCellData("Audits", 6, 25), 
				reader.getCellData("Audits", 7, 25));
		Reporter.log("Audit Owner user permissions are functional", true);
	}

	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Audit_Capture_Edit_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Capture_Edit_user_permissions(reader.getCellData("Audits", 0, 26), 
				reader.getCellData("Audits", 1, 26), reader.getCellData("Audits", 2, 26), 
				reader.getCellData("Audits", 3, 26), reader.getCellData("Audits", 4, 26), 
				reader.getCellData("Audits", 5, 26), reader.getCellData("Audits", 6, 26), 
				reader.getCellData("Audits", 7, 26));
		Reporter.log("Audit Edit user permissions are functional", true);
	}

	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Audit_Capture_Do_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Capture_Do_user_permissions(reader.getCellData("Audits", 0, 27), 
				reader.getCellData("Audits", 1, 27), reader.getCellData("Audits", 2, 27), 
				reader.getCellData("Audits", 3, 27), reader.getCellData("Audits", 4, 27), 
				reader.getCellData("Audits", 5, 27), reader.getCellData("Audits", 6, 27), 
				reader.getCellData("Audits", 7, 27));
		Reporter.log("Audit Do user permissions are functional", true);
	}

	@Test(dependsOnMethods= {"verify_Audit_Capture_Do_user_permissions_Test"}, groups="AuditPermissions", enabled=true)
	public void verify_Audit_Capture_View_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Audit_Capture_View_user_permissions(reader.getCellData("Audits", 0, 28), 
				reader.getCellData("Audits", 1, 28), reader.getCellData("Audits", 2, 28), 
				reader.getCellData("Audits", 3, 28), reader.getCellData("Audits", 4, 28), 
				reader.getCellData("Audits", 5, 28), reader.getCellData("Audits", 6, 28), 
				reader.getCellData("Audits", 7, 28));
		Reporter.log("Audit View user permissions are functional", true);
	}
	//--------------------------------- Audit Capture Permissions (End)---------------------------------------------------------

	//--------------------------------- Analyse Permissions (Start) ---------------------------------------------------------
	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Analyse_Owner_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Analyse_Owner_user_permissions(reader.getCellData("Audits", 0, 29), 
				reader.getCellData("Audits", 1, 29), reader.getCellData("Audits", 2, 29), 
				reader.getCellData("Audits", 3, 29), reader.getCellData("Audits", 4, 29));
		Reporter.log("Analyse Owner user permissions are functional", true);
	}

	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Analyse_Edit_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Analyse_Edit_user_permissions(reader.getCellData("Audits", 0, 30), 
				reader.getCellData("Audits", 1, 30), reader.getCellData("Audits", 2, 30), 
				reader.getCellData("Audits", 3, 30), reader.getCellData("Audits", 4, 30));
		Reporter.log("Analyse Edit user permissions are functional", true);
	}

	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Analyse_Do_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Analyse_Do_user_permissions(reader.getCellData("Audits", 0, 31), 
				reader.getCellData("Audits", 1, 31), reader.getCellData("Audits", 2, 31), 
				reader.getCellData("Audits", 3, 31), reader.getCellData("Audits", 4, 31));
		Reporter.log("Analyse Do user permissions are functional", true);
	}

	@Test(groups="AuditPermissions", enabled=true)
	public void verify_Analyse_View_user_permissions_Test() throws Exception {
		buildAuditsPage.verify_Analyse_View_user_permissions(reader.getCellData("Audits", 0, 32), 
				reader.getCellData("Audits", 1, 32), reader.getCellData("Audits", 2, 32), 
				reader.getCellData("Audits", 3, 32), reader.getCellData("Audits", 4, 32));
		Reporter.log("Analyse View user permissions are functional", true);
	}
	//--------------------------------- Analyse Permissions (End)---------------------------------------------------------


	











}
