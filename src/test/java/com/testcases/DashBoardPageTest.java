/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;

public class DashBoardPageTest extends BasePage {
	
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	DashBoardPage dashBoardPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage = taskBoardPage.clickOnDashBoardLink();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void Verify_DashBoardLink_Test(){
		Assert.assertTrue(dashBoardPage.verifyDashboardLink(), "Dashboard Link Not Present - Test FAIL");
		Reporter.log("DashBoardLink Verified - Test PASS", true);
	}
	
	@Test
	public void verify_View_my_audit_and_my_questionnaires_in_dashboard_Test(){
		dashBoardPage.verify_View_my_audit_and_my_questionnaires_in_dashboard();
	}
	
	@Test
	public void verify_Record_full_screen_option_Test() throws Exception{
		dashBoardPage.verify_Record_full_screen_option();
	}
	
	@Test
	public void verify_Add_reports_to_dashboard_Test() throws Exception{
		//dashBoardPage.verify_Add_reports_to_dashboard(reader.getCellData("Analyse", 0, 2));
		dashBoardPage.verify_Add_reports_to_dashboard("Report Test");
	}
	
	@Test
	public void verify_Preview_report_option_Test() throws Exception{
		//dashBoardPage.verify_Preview_report_option(reader.getCellData("Analyse", 0, 2));
		dashBoardPage.verify_Preview_report_option("Report Test");
	}
	
	@Test(dependsOnMethods="verify_Add_reports_to_dashboard_Test")
	public void verify_Remove_reports_from_dashboard_Test() throws Exception{
		dashBoardPage.verify_Remove_reports_from_dashboard();
	}
	

}
