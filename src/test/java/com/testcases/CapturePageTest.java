/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.CapturePage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.Container;
import com.util.ExcelUtility;
import com.util.TestUtil;

public class CapturePageTest extends BasePage {
	
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	CapturePage capturePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		capturePage = taskBoardPage.clickOnCaptureLink();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void CapturePage_Title_Test() {
		String actual = capturePage.verifyPageTitle();
		String expected = "Capture";
		Assert.assertEquals(actual, expected, "Capture Page Not Opened");
		Reporter.log("Capture Page Opened Successfully", true);
	}

	@Test
	public void verify_Capture_Text_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Text_questionnaire(reader.getCellData("Build", 0, 7), 
				reader.getCellData("Capture", 0, 1), reader.getCellData("Capture", 1, 1), 
				reader.getCellData("Capture", 2, 1), reader.getCellData("Capture", 3, 1), 
				reader.getCellData("Capture", 4, 1), reader.getCellData("Capture", 5, 1), 
				reader.getCellData("Capture", 6, 1), reader.getCellData("Capture", 7, 1),
				reader.getCellData("Capture", 8, 1), reader.getCellData("Capture", 9, 1), 
				reader.getCellData("Capture", 10, 1), reader.getCellData("Capture", 11, 1), 
				reader.getCellData("Capture", 12, 1), reader.getCellData("Capture", 13, 1), 
				reader.getCellData("Capture", 14, 1), reader.getCellData("Capture", 15, 1),
				reader.getCellData("Capture", 16, 1), reader.getCellData("Capture", 17, 1), 
				reader.getCellData("Capture", 18, 1), reader.getCellData("Capture", 19, 1));
		Reporter.log("Text Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_MultiChoice_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_MultiChoice_questionnaire(reader.getCellData("Build", 0, 8),
				reader.getCellData("Capture", 0, 2), reader.getCellData("Capture", 1, 2), 
				reader.getCellData("Capture", 2, 2), reader.getCellData("Capture", 3, 2), 
				reader.getCellData("Capture", 4, 2), reader.getCellData("Capture", 5, 2), 
				reader.getCellData("Capture", 6, 2), reader.getCellData("Capture", 7, 2),
				reader.getCellData("Capture", 8, 2), reader.getCellData("Capture", 9, 2), 
				reader.getCellData("Capture", 10, 2), reader.getCellData("Build", 29, 8), 
				reader.getCellData("Build", 32, 8), reader.getCellData("Capture", 11, 2));
		Reporter.log("MultiChoice Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_Date_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Date_questionnaire(reader.getCellData("Build", 0, 9), 
				reader.getCellData("Capture", 0, 3), reader.getCellData("Capture", 1, 3), 
				reader.getCellData("Capture", 2, 3));
		Reporter.log("Date Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_Number_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Number_questionnaire(reader.getCellData("Build", 0, 11), 
				reader.getCellData("Capture", 0, 4), reader.getCellData("Capture", 1, 4), 
				reader.getCellData("Capture", 2, 4), reader.getCellData("Capture", 3, 4),
				reader.getCellData("Capture", 4, 4), reader.getCellData("Capture", 5, 4),
				reader.getCellData("Capture", 6, 4), reader.getCellData("Capture", 7, 4),
				reader.getCellData("Capture", 8, 4), reader.getCellData("Capture", 9, 4),
				reader.getCellData("Capture", 10, 4), reader.getCellData("Capture", 11, 4),
				reader.getCellData("Capture", 12, 4), reader.getCellData("Capture", 13, 4),
				reader.getCellData("Capture", 14, 4), reader.getCellData("Capture", 15, 4),
				reader.getCellData("Capture", 16, 4), reader.getCellData("Capture", 17, 4),
				reader.getCellData("Capture", 18, 4), reader.getCellData("Capture", 19, 4));
		Reporter.log("Number Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_Upload_file_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Upload_file_questionnaire(reader.getCellData("Build", 0, 13),
				reader.getCellData("Capture", 0, 5), System.getProperty("user.dir")+"\\Files\\Aerospace Engineering.jpg", 
				reader.getCellData("Capture", 1, 5), reader.getCellData("Capture", 2, 5));
		Reporter.log("Upload file Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_Activity_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Activity_questionnaire(reader.getCellData("Build", 0, 12),
				reader.getCellData("Capture", 0, 6), reader.getCellData("Capture", 1, 6), 
				reader.getCellData("Capture", 2, 6), reader.getCellData("Capture", 3, 6), 
				reader.getCellData("Capture", 4, 6));
		Reporter.log("Activity Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_Advanced_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Advanced_questionnaire(reader.getCellData("Build", 0, 15),
				reader.getCellData("Capture", 0, 7), reader.getCellData("Capture", 1, 7), 
				reader.getCellData("Capture", 2, 7), reader.getCellData("Capture", 3, 7),
				reader.getCellData("Capture", 4, 7), reader.getCellData("Capture", 5, 7),
				reader.getCellData("Capture", 6, 7), reader.getCellData("Capture", 7, 7), 
				reader.getCellData("Capture", 8, 7), reader.getCellData("Capture", 9, 7),
				reader.getCellData("Capture", 10, 7));
		Reporter.log("Advanced Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Capture_Section_questionnaire_Test() throws Exception {
		capturePage.verify_Capture_Section_questionnaire(reader.getCellData("Build", 0, 14),
				reader.getCellData("Capture", 0, 8), reader.getCellData("Capture", 1, 8), 
				reader.getCellData("Capture", 2, 8));
		Reporter.log("Section Questionnaire captured successfully", true);
	}
	
	@Test
	public void verify_Complete_Reopen_Questionnaire_Test() throws Exception {
		capturePage.verify_Complete_Reopen_Questionnaire(reader.getCellData("Build", 0, 6));
		Reporter.log("MultiChoice - Complete & Reopen are Functional", true);
	}

	@Test
	public void Settings_Score_Addition_Delete_Copy_Questionnaire_Test() throws Exception {
		capturePage.verify_Settings_Score_Addition_Delete_Copy_Questionnaire(reader.getCellData("Build", 0, 17));
		Reporter.log("Settings - Scores Addtion, Delete Option And Copy Questionnaire Are Functional", true);
	}

	@Test
	public void Settings_Score_Multiply_StrikeOut_FileUpload_Questionnaire_Test() throws Exception {
		capturePage.verify_Settings_Score_Multiply_StrikeOut_File_Upload_Questionnaire(reader.getCellData("Build", 0, 18));
		Reporter.log("Settings - Scores Multiplication, StrikeOut Option And Copy Questionnaire Are Functional", true);
	}

	@Test
	public void verify_Assign_window_details_are_clearing_or_not_when_record_is_not_saved_Test() throws Exception {
		capturePage.verify_Assign_window_details_are_clearing_or_not_when_record_is_not_saved(
				reader.getCellData("Capture", 0, 9), reader.getCellData("Capture", 1, 9));
	}

	@Test
	public void verify_Assign_window_mandatory_fields_Test() throws Exception {
		capturePage.verify_Assign_window_mandatory_fields(reader.getCellData("Capture", 0, 10), 
				reader.getCellData("Capture", 0, 9), reader.getCellData("Capture", 1, 10));
		Reporter.log("Assign window mandatory fields verified successfully", true);
	}









	
	
	@DataProvider
	public Object[][] getCaptureTestData(){
		Object data[][] = TestUtil.getTestData("captureDD");
		return data;
	}

	@Test(dataProvider="getCaptureTestData", enabled=true)
	public void verify_Questionnaire_for_Analyse_Test(String searchItem, String empNo, String empName, String address,
			String empFee, String empFormFee, String empRegFee, String sscM, String interM, String graduateM, String mastersM, String qualification,
			String joiningYear, String joiningMonth, String joiningDate, String exitYear, String exitMonth, String exitDate, 
			String compEnv, String salaryIncrement, String overAll, String select, String yesNoNa,
			String checkBox1, String checkBox2, String checkBoxQ2) throws Exception {
		capturePage.verify_Questionnaire_for_Analyse(searchItem, empNo, empName, address, empFee, empFormFee, empRegFee, sscM, interM, graduateM, mastersM, 
				qualification, joiningYear, joiningMonth, joiningDate, exitYear, exitMonth, exitDate, compEnv, salaryIncrement, overAll, select, yesNoNa, 
				checkBox1, checkBox2, checkBoxQ2);
		Reporter.log("Questionnaire for Analyse is functional", true);
	}
	
	//******************* below one is using container
	
	@DataProvider
	public Iterator<Object[]> getEmpAnalyseData() {
		ArrayList<Object[]> testData = Container.getEmpAnalyseDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider="getEmpAnalyseData", enabled=false)
	public void Questionnaire_for_Analyse_Test_New(String searchItem, String empNo, String empName, String cityNo, String empFee, String empFormFee, String empRegFee, 
			String sscPercentage, String interPercentage, String graduationPercentage, String mastersPercentage, String qualification, 
			String joiningYear, String joiningMonth, String joiningDate, String exitYear, String exitMonth, String exitDate,
			String companyEnvironment, 
			String salaryIncrement, String overAll, String ddSelect, String yesNoNa, String checkBox1, String checkBox2, String checkBoxQ2) throws Exception {
		capturePage.verify_Questionnaire_for_Analyse(searchItem, empNo, empName, cityNo, empFee, empFormFee, empRegFee,
				sscPercentage, interPercentage, graduationPercentage, mastersPercentage, qualification, 
				joiningYear, joiningMonth, joiningDate, exitYear, exitMonth, exitDate,
				companyEnvironment, salaryIncrement, overAll, ddSelect, yesNoNa, checkBox1, checkBox2, checkBoxQ2);
		Reporter.log("Questionnaire for Analyse is functional", true);
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
