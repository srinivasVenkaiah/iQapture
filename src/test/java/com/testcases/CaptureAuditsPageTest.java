/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.nio.file.Paths;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.CaptureAuditsPage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;
import com.util.TestUtil;

public class CaptureAuditsPageTest extends BasePage {
	
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	CaptureAuditsPage captureAuditsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		captureAuditsPage = taskBoardPage.clickOnCaptureAuditsTab();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Capture_Audits_tab_Test() {
		captureAuditsPage.verify_Capture_Audits_tab();
	}
	
	@Test(dependsOnMethods="verify_Capture_Audits_tab_Test")	
	public void verify_Audit_search_option_Test() {
		captureAuditsPage.verify_Audit_search_option();
	}
	
	@Test(dependsOnMethods="verify_Capture_Audits_tab_Test")
	public void verify_Error_message_for_invalid_search_Test() {
		captureAuditsPage.verify_Error_message_for_invalid_search();
	}
	
	@DataProvider
	public Object[][] getAuditTestData() {
		Object[][] data = TestUtil.getTestData("auditCaptureDD");
		return data;
	}
	
	@Test(dataProvider="getAuditTestData")
	public void verify_Create_records_against_the_audit_Test(String audit, String type, 
			String Q1option, String Q2option, String Q3option, String Q4option,
			String Q5option, String Q6option, String Q7option, String Q8option,
			String Q1Comment, String Q2Comment, String Q5Comment) throws Exception {
		captureAuditsPage.verify_Create_records_against_the_audit(audit, type, Q1option, Q2option, 
				Q3option, Q4option, Q5option, Q6option, Q7option, Q8option, Q1Comment, Q2Comment, Q5Comment);
	}
	
	@Test(dependsOnMethods="verify_Capture_Audits_tab_Test")
	public void verify_Add_activity_for_the_external_audit_Test() throws Exception {
		captureAuditsPage.verify_Add_activity_for_the_external_audit(reader.getCellData("Audits", 0, 5), 
				reader.getCellData("CaptureAudits", 0, 1), reader.getCellData("CaptureAudits", 1, 1), 
				reader.getCellData("CaptureAudits", 2, 1), reader.getCellData("CaptureAudits", 3, 1), 
				reader.getCellData("CaptureAudits", 4, 1), System.getProperty("user.dir")+"\\Files\\audit.jpg", 
				reader.getCellData("CaptureAudits", 5, 1), reader.getCellData("CaptureAudits", 6, 1),
				reader.getCellData("CaptureAudits", 7, 1), reader.getCellData("CaptureAudits", 8, 1), 
				reader.getCellData("CaptureAudits", 9, 1), reader.getCellData("CaptureAudits", 10, 1));
	}
	
	@Test(dependsOnMethods="verify_Capture_Audits_tab_Test")
	public void verify_Error_message_on_save_against_the_mandatory_fields_and_alert_on_hitting_back_button_without_saving_Questionnaire_Test() throws Exception {
		captureAuditsPage.verify_Error_message_on_save_against_the_mandatory_fields_and_alert_on_hitting_back_button_without_saving_Questionnaire(
				reader.getCellData("Audits", 0, 8), reader.getCellData("CaptureAudits", 0, 1));
	}
	
	@Test(dependsOnMethods="verify_Capture_Audits_tab_Test")
	public void verify_Complete_audit_reopen_audit_and_delete_record_Test() throws Exception {
		captureAuditsPage.verify_Complete_audit_reopen_audit_and_delete_record(reader.getCellData("Audits", 0, 8), 
				reader.getCellData("CaptureAudits", 0, 1), reader.getCellData("CaptureAudits", 3, 1));
	}
	
	@Test(dependsOnMethods="verify_Capture_Audits_tab_Test")
	public void verify_Export_to_PDF_option_Test() throws Exception {
		captureAuditsPage.verify_Export_to_PDF_option(reader.getCellData("Audits", 0, 8), 
				Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("CaptureAudits", 0, 2));
		Reporter.log("Export to PDF option is functional", true);
	}
	
	
	
	
	
}
