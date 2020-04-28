/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.BuildPage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;

public class BuildPageTest extends BasePage {
	
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	BuildPage buildPage;
	ExcelUtility reader;
	
	@BeforeMethod(groups= {"FolderPermissions", "Upissue"})
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		buildPage = taskBoardPage.clickOnBuildLink();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod//(groups={"FolderPermissions", "Upissue"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void Verify_BuidPage_Test() {
		Assert.assertTrue(buildPage.verify_IQuapturePage(), "New IQapture Button is Missing on the Page");
		Reporter.log("New IQapture Button Present - Test PASS", true);
	}

	@Test(dependsOnMethods="Verify_BuidPage_Test")
	public void Create_Folder_Test() throws Exception {
		buildPage.verify_Create_Folder(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 1, 1));
	}

	@Test(dependsOnMethods="Create_Folder_Test")
	public void Create_Nested_Folder_Test() throws Exception {
		buildPage.verify_Create_Nested_Folder(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 1, 2));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Create_Questionnaire_Test() throws Exception {
		buildPage.verify_Questionnaire_Creation(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 3));
		Reporter.log("Questionary Created successfully", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Upload_Image_To_Questionnaire_Test() throws Exception {
		buildPage.verify_Upload_Image_To_Questionnaire(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 4), 
				System.getProperty("user.dir")+"\\Files\\hrandpayroll.jpg");
		Reporter.log("Image Added To Questionnaires Successfully", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Delete_Questionnairie_Test() throws Exception {
		buildPage.verify_Delete_Questionnaire(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 1, 3));
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Rename_Questionnaire_Test() throws Exception {
		buildPage.verify_Rename_Questionnaire(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 5), 
				reader.getCellData("Build", 1, 5));
		Reporter.log("Questionnairie Renamed Successfully", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Add_Comment_update_and_delete_Test() throws Exception {
		buildPage.verify_Add_Comment_update_and_delete(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 6), 
				reader.getCellData("Build", 1, 6), reader.getCellData("Build", 2, 6));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Text_dataset_Test() throws Exception {
		buildPage.verify_Text_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 7), reader.getCellData("Build", 1, 7), 
				reader.getCellData("Build", 2, 7), reader.getCellData("Build", 3, 7), 
				reader.getCellData("Build", 4, 7), reader.getCellData("Build", 5, 7), 
				reader.getCellData("Build", 6, 7), reader.getCellData("Build", 7, 7), 
				reader.getCellData("Build", 8, 7), reader.getCellData("Build", 9, 7), 
				reader.getCellData("Build", 10, 7), reader.getCellData("Build", 11, 7), 
				reader.getCellData("Build", 12, 7), reader.getCellData("Build", 13, 7), 
				reader.getCellData("Build", 14, 7), reader.getCellData("Build", 15, 7), 
				reader.getCellData("Build", 16, 7), reader.getCellData("Build", 17, 7), 
				reader.getCellData("Build", 18, 7), reader.getCellData("Build", 19, 7), 
				reader.getCellData("Build", 20, 7));
		Reporter.log("Text dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_MultiChoice_dataset_Test() throws Exception {
		buildPage.verify_MultiChoice_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 8), reader.getCellData("Build", 1, 8), 
				reader.getCellData("Build", 2, 8), reader.getCellData("Build", 3, 8), 
				reader.getCellData("Build", 4, 8), reader.getCellData("Build", 5, 8), 
				reader.getCellData("Build", 6, 8), reader.getCellData("Build", 7, 8), 
				reader.getCellData("Build", 8, 8), reader.getCellData("Build", 9, 8), 
				reader.getCellData("Build", 10, 8), reader.getCellData("Build", 11, 8), 
				reader.getCellData("Build", 12, 8), reader.getCellData("Build", 13, 8), 
				reader.getCellData("Build", 14, 8), reader.getCellData("Build", 15, 8), 
				reader.getCellData("Build", 16, 8), reader.getCellData("Build", 17, 8), 
				reader.getCellData("Build", 18, 8), reader.getCellData("Build", 19, 8), 
				reader.getCellData("Build", 20, 8), reader.getCellData("Build", 21, 8),  
				reader.getCellData("Build", 22, 8), reader.getCellData("Build", 23, 8), 
				reader.getCellData("Build", 24, 8), reader.getCellData("Build", 25, 8), 
				reader.getCellData("Build", 26, 8), reader.getCellData("Build", 27, 8),  
				reader.getCellData("Build", 28, 8), reader.getCellData("Build", 29, 8),  
				reader.getCellData("Build", 30, 8), reader.getCellData("Build", 31, 8),  
				reader.getCellData("Build", 32, 8), reader.getCellData("Build", 33, 8), 
				reader.getCellData("Build", 34, 8), reader.getCellData("Build", 35, 8));
		Reporter.log("MultiChoice dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Date_dataset_Test() throws Exception {
		buildPage.verify_Date_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2),
				reader.getCellData("Build", 0, 9), reader.getCellData("Build", 1, 9), 
				reader.getCellData("Build", 2, 9), reader.getCellData("Build", 3, 9), 
				reader.getCellData("Build", 4, 9), reader.getCellData("Build", 5, 9), 
				reader.getCellData("Build", 6, 9), reader.getCellData("Build", 7, 9), 
				reader.getCellData("Build", 8, 9), reader.getCellData("Build", 9, 9), 
				reader.getCellData("Build", 10, 9), reader.getCellData("Build", 11, 9), 
				reader.getCellData("Build", 12, 9), reader.getCellData("Build", 13, 9), 
				reader.getCellData("Build", 14, 9), reader.getCellData("Build", 15, 9), 
				reader.getCellData("Build", 16, 9), reader.getCellData("Build", 17, 9), 
				reader.getCellData("Build", 18, 9), reader.getCellData("Build", 19, 9), 
				reader.getCellData("Build", 20, 9), reader.getCellData("Build", 21, 9), 
				reader.getCellData("Build", 22, 9), reader.getCellData("Build", 23, 9), 
				reader.getCellData("Build", 24, 9), reader.getCellData("Build", 25, 9), 
				reader.getCellData("Build", 26, 9), reader.getCellData("Build", 27, 9), 
				reader.getCellData("Build", 28, 9));
		Reporter.log("MultiChoice dataset is functional", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_MultiChoice_upload_and_download_button_functionality_Test() throws Exception {
		buildPage.verify_MultiChoice_upload_and_download_button_functionality(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 10), 
				reader.getCellData("Build", 1, 10), System.getProperty("user.dir")+"\\Files\\Dropdown List Items.xlsx", 
				Paths.get(System.getProperty("user.home"), "Downloads").toString(), reader.getCellData("Build", 2, 10));
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Number_dataset_Test() throws Exception {
		buildPage.verify_Number_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 11), reader.getCellData("Build", 1, 11), 
				reader.getCellData("Build", 2, 11), reader.getCellData("Build", 3, 11),  
				reader.getCellData("Build", 4, 11), reader.getCellData("Build", 5, 11), 
				reader.getCellData("Build", 6, 11), reader.getCellData("Build", 7, 11),  
				reader.getCellData("Build", 8, 11), reader.getCellData("Build", 9, 11), 
				reader.getCellData("Build", 10, 11), reader.getCellData("Build", 11, 11),  
				reader.getCellData("Build", 12, 11), reader.getCellData("Build", 13, 11),  
				reader.getCellData("Build", 14, 11), reader.getCellData("Build", 15, 11), 
				reader.getCellData("Build", 16, 11), reader.getCellData("Build", 17, 11), 
				reader.getCellData("Build", 18, 11), reader.getCellData("Build", 19, 11), 
				reader.getCellData("Build", 20, 11), reader.getCellData("Build", 21, 11),  
				reader.getCellData("Build", 22, 11), reader.getCellData("Build", 23, 11));
		Reporter.log("Number dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Activity_dataset_Test() throws Exception {
		buildPage.verify_Activity_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 12), reader.getCellData("Build", 1, 12), 
				reader.getCellData("Build", 2, 12), reader.getCellData("Build", 3, 12),
				reader.getCellData("Build", 4, 12), reader.getCellData("Build", 5, 12),
				reader.getCellData("Build", 6, 12), reader.getCellData("Build", 7, 12), 
				reader.getCellData("Build", 8, 12), reader.getCellData("Build", 9, 12), 
				reader.getCellData("Build", 10, 12), reader.getCellData("Build", 11, 12), 
				reader.getCellData("Build", 12, 12), reader.getCellData("Build", 13, 12), 
				reader.getCellData("Build", 14, 12), reader.getCellData("Build", 15, 12), 
				reader.getCellData("Build", 16, 12), prop.getProperty("loginUser"), 
				reader.getCellData("Build", 17, 12), reader.getCellData("Build", 18, 12), 
				reader.getCellData("Build", 19, 12));
		Reporter.log("Number dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Upload_file_dataset_Test() throws Exception {
		buildPage.verify_Upload_file_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 13), reader.getCellData("Build", 1, 13), 
				reader.getCellData("Build", 2, 13), reader.getCellData("Build", 3, 13),
				reader.getCellData("Build", 4, 13), reader.getCellData("Build", 5, 13),
				reader.getCellData("Build", 6, 13), reader.getCellData("Build", 7, 13),
				reader.getCellData("Build", 8, 13), reader.getCellData("Build", 9, 13),
				reader.getCellData("Build", 10, 13), reader.getCellData("Build", 11, 13),
				reader.getCellData("Build", 12, 13), reader.getCellData("Build", 13, 13));
		Reporter.log("Upload file dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Section_dataset_Test() throws Exception {
		buildPage.verify_Section_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 14), reader.getCellData("Build", 1, 14), 
				reader.getCellData("Build", 2, 14), reader.getCellData("Build", 3, 14), 
				reader.getCellData("Build", 4, 14), reader.getCellData("Build", 5, 14), 
				reader.getCellData("Build", 6, 14), reader.getCellData("Build", 7, 14),
				reader.getCellData("Build", 8, 14), reader.getCellData("Build", 9, 14),
				reader.getCellData("Build", 10, 14), reader.getCellData("Build", 11, 14),
				reader.getCellData("Build", 12, 14), reader.getCellData("Build", 13, 14));
		Reporter.log("Section dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Advanced_dataset_Test() throws Exception {
		buildPage.verify_Advanced_dataset(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 15), reader.getCellData("Build", 1, 15), 
				reader.getCellData("Build", 2, 15), reader.getCellData("Build", 3, 15), 
				reader.getCellData("Build", 4, 15), reader.getCellData("Build", 5, 15), 
				reader.getCellData("Build", 6, 15), reader.getCellData("Build", 7, 15),
				reader.getCellData("Build", 8, 15), reader.getCellData("Build", 9, 15), 
				reader.getCellData("Build", 10, 15), reader.getCellData("Build", 11, 15), 
				reader.getCellData("Build", 12, 15), reader.getCellData("Build", 13, 15),
				reader.getCellData("Build", 14, 15), reader.getCellData("Build", 15, 15),
				reader.getCellData("Build", 16, 15), reader.getCellData("Build", 17, 15), 
				reader.getCellData("Build", 18, 15), reader.getCellData("Build", 19, 15), 
				reader.getCellData("Build", 20, 15), reader.getCellData("Build", 21, 15), 
				reader.getCellData("Build", 22, 15), reader.getCellData("Build", 23, 15),
				reader.getCellData("Build", 24, 15), reader.getCellData("Build", 25, 15),
				reader.getCellData("Build", 26, 15), reader.getCellData("Build", 27, 15));
		Reporter.log("Advanced dataset is functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Preview_Quesionnaire_Test() throws Exception {
		buildPage.verify_Preview_Quesionnaire(reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 16), reader.getCellData("Build", 1, 16));
		Reporter.log("Questionnaire Preview is Functional", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Settings_Score_Addition_Delete_Copy_Questionnaire_Test() throws Exception {
		buildPage.verify_Settings_Score_Addition_Delete_Copy_Questionnaire(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 17), 
				reader.getCellData("Build", 1, 17), reader.getCellData("Build", 2, 17), 
				reader.getCellData("Build", 3, 17), reader.getCellData("Build", 4, 17), 
				reader.getCellData("Build", 5, 17), reader.getCellData("Build", 6, 17), 
				reader.getCellData("Build", 7, 17), reader.getCellData("Build", 8, 17), 
				reader.getCellData("Build", 9, 17), reader.getCellData("Build", 10, 17), 
				reader.getCellData("Build", 11, 17), reader.getCellData("Build", 12, 17), 
				reader.getCellData("Build", 13, 17), reader.getCellData("Build", 14, 17));
		Reporter.log("All Settings Are Enabled And Functional", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Settings_Score_Multiply_StrikeOut_FileUpload_Questionnaire_Test() throws Exception {
		buildPage.verify_Settings_ScoreMultiply_StrikeOut_FileUpload_Questionnaire(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 18), 
				reader.getCellData("Build", 1, 18), reader.getCellData("Build", 2, 18), 
				reader.getCellData("Build", 3, 18), reader.getCellData("Build", 4, 18), 
				reader.getCellData("Build", 5, 18), reader.getCellData("Build", 6, 18), 
				reader.getCellData("Build", 7, 18), reader.getCellData("Build", 8, 18), 
				reader.getCellData("Build", 9, 18), reader.getCellData("Build", 10, 18), 
				reader.getCellData("Build", 11, 18), reader.getCellData("Build", 12, 18), 
				reader.getCellData("Build", 13, 18), reader.getCellData("Build", 14, 18), 
				System.getProperty("user.dir")+"\\Files\\Questions Template.xlsx", 
				Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				reader.getCellData("Build", 15, 18));
		Reporter.log("All Settings Are Enabled And Functional", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Settings_Delete_functionality_for_the_Strike_out_record() throws Exception {
		buildPage.verify_Delete_functionality_for_the_Strike_out_record(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 19), 
				reader.getCellData("Build", 1, 19));
		Reporter.log("Delete option for the strike out records is functional", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Add_Scedules_and_delete_schedule_against_the_questionnaire_Test() throws Exception {
		buildPage.verify_Add_Scedules_and_delete_schedule_against_the_questionnaire(reader.getCellData("Build", 0, 1), 
				reader.getCellData("Build", 0, 2), reader.getCellData("Build", 0, 20), 
				reader.getCellData("Build", 1, 20), reader.getCellData("Build", 2, 20), 
				reader.getCellData("Build", 3, 20), reader.getCellData("Build", 4, 20), 
				reader.getCellData("Build", 5, 20), reader.getCellData("Build", 6, 20), 
				reader.getCellData("Build", 7, 20), reader.getCellData("Build", 8, 20), 
				reader.getCellData("Build", 9, 20), reader.getCellData("Build", 10, 20), 
				reader.getCellData("Build", 11, 20), reader.getCellData("Build", 12, 20), 
				reader.getCellData("Build", 13, 20), reader.getCellData("Build", 14, 20));
		Reporter.log("Schedules added and deleted successfully", true);
	}

	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void Move_Questionnaire_From_One_Folder_To_Other_Folder_Test() throws Exception {
		buildPage.verify_Move_Questionnaire_From_One_Folder_To_Other_Folders(reader.getCellData("Build", 0, 21), 
				reader.getCellData("Build", 0, 2));
		Reporter.log("Questionnaire is moved Successfully from One folder to other folder", true);
	}

	@Test
	public void Folder_Rename_And_Deletion_Test() throws Exception{
		buildPage.verify_Folder_Rename_And_Deletion(reader.getCellData("Build", 0, 22), 
				reader.getCellData("Build", 1, 22), reader.getCellData("Build", 2, 22), 
				reader.getCellData("Build", 3, 22));
		Reporter.log("Folder Rename and Deletion are Functional", true);
	}

	@Test(dependsOnMethods="Create_Nested_Folder_Test")
	public void Cascading_Questionnaire_option_Test() throws Exception{
		buildPage.verify_Cascading_Questionnaire_option(reader.getCellData("Build", 0, 23), 
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 23), 
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2));
		Reporter.log("Cascading Questionnaire Option is Functional", true);
	}

	@Test(groups="Upissue")
	public void Create_Up_Issue_Test() throws Exception {
		buildPage.verify_Create_Up_Issue(reader.getCellData("Build", 0, 24), 
				reader.getCellData("Build", 1, 24), reader.getCellData("Build", 2, 24), 
				reader.getCellData("Build", 3, 24), reader.getCellData("Build", 4, 24), 
				reader.getCellData("Build", 5, 24), reader.getCellData("Build", 6, 24), 
				reader.getCellData("Build", 7, 24), reader.getCellData("Build", 8, 24), 
				reader.getCellData("Build", 9, 24), reader.getCellData("Build", 10, 24), 
				reader.getCellData("Build", 11, 24), reader.getCellData("Build", 12, 24), 
				reader.getCellData("Build", 13, 24), reader.getCellData("Build", 14, 24));
		Reporter.log("Up Issue functionalities are verified successfully", true);
	}

	@Test(dependsOnMethods="Create_Up_Issue_Test", groups="Upissue")
	public void Up_Issue_on_modifying_questionnaire_Test() throws Exception {
		buildPage.verify_Up_Issue_on_modifying_questionnaire(reader.getCellData("Build", 0, 24), 
				reader.getCellData("Build", 0, 25), reader.getCellData("Build", 1, 25), 
				reader.getCellData("Build", 2, 25));
	}

	@Test(dependsOnMethods="Create_Up_Issue_Test", groups="Upissue")
	public void Modify_the_Captured_Question_Test() throws Exception {
		buildPage.verify_modify_the_Captured_Question(reader.getCellData("Build", 0, 24));
	}
	
	@Test(groups="Upissue")
	public void verify_Latest_version_questions_are_not_reflecting_on_copying_old_version_Test() throws Exception {
		buildPage.verify_Latest_version_questions_are_not_reflecting_on_copying_old_version(
				reader.getCellData("Build", 0, 26), reader.getCellData("Build", 1, 26),
				reader.getCellData("Build", 2, 26));
		Reporter.log("Latest version questions not reflecting on copying old version", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Add_and_Remove_the_people_against_the_Questionnaire() throws Exception {
		buildPage.verify_Add_and_Remove_the_people_against_the_Questionnaire(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2),
				reader.getCellData("Build", 0, 27), reader.getCellData("Build", 1, 27), 
				reader.getCellData("Build", 2, 27));
		Reporter.log("People added & removed against the Questionnaire successfully", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Tool_tips_for_all_options_in_Settings_Test() throws Exception {
		buildPage.verify_Tool_tips_for_all_options_in_Settings( 
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2),
				reader.getCellData("Build", 0, 28), reader.getCellData("Build", 1, 28),
				reader.getCellData("Build", 2, 28), reader.getCellData("Build", 3, 28), 
				reader.getCellData("Build", 4, 28), reader.getCellData("Build", 5, 28), 
				reader.getCellData("Build", 6, 28), reader.getCellData("Build", 7, 28), 
				reader.getCellData("Build", 8, 28), reader.getCellData("Build", 9, 28), 
				reader.getCellData("Build", 10, 28), reader.getCellData("Build", 11, 28), 
				reader.getCellData("Build", 12, 28), reader.getCellData("Build", 13, 28), 
				reader.getCellData("Build", 14, 28));
		Reporter.log("Tooltips for all options in settings are verified successfully", true);
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Add_alert_and_Delete_alert_against_the_questionnaire_Test() throws Exception {
		buildPage.verify_Add_alert_and_Delete_alert_against_the_questionnaire(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 29), reader.getCellData("Build", 1, 29), 
				reader.getCellData("Build", 2, 29), reader.getCellData("Build", 3, 29), 
				reader.getCellData("Build", 4, 29), reader.getCellData("Build", 5, 29), 
				reader.getCellData("Build", 6, 29), reader.getCellData("Build", 7, 29), 
				reader.getCellData("Build", 8, 29), reader.getCellData("Build", 9, 29), 
				reader.getCellData("Build", 10, 29), reader.getCellData("Build", 11, 29));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Save_and_Complete_assigned_iQapture_record_from_the_dashboard_Test() throws Exception {
		buildPage.verify_Save_and_Complete_assigned_iQapture_record_from_the_dashboard(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2),
				reader.getCellData("Build", 0, 30), reader.getCellData("Build", 1, 30));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Assigned_record_is_removing_or_not_at_dashboard_when_the_record_deleted_at_capture_Test() throws Exception {
		buildPage.verify_Assigned_record_is_removing_or_not_at_dashboard_when_the_record_deleted_at_capture(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2),
				reader.getCellData("Build", 0, 31), reader.getCellData("Build", 1, 31), 
				reader.getCellData("Build", 2, 31), reader.getCellData("Build", 3, 31));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Change_record_order_Test() throws Exception {
		buildPage.verify_Change_record_order(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2),
				reader.getCellData("Build", 0, 32), reader.getCellData("Build", 1, 32), 
				reader.getCellData("Build", 2, 32), reader.getCellData("Build", 3, 32), 
				reader.getCellData("Build", 4, 32));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Capture_Logs_on_manual_entry_and_on_template_upload_Test() throws Exception {
		buildPage.verify_Capture_Logs_on_manual_entry_and_on_template_upload(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 33), reader.getCellData("Build", 1, 33), 
				reader.getCellData("Build", 2, 33), Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				System.getProperty("user.dir")+"\\Files\\Capture logs.xlsx");
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"}) //groups="Upissue"
	public void verify_Deleted_version_questions_visibility_in_analyse_section_Test() throws Exception {
		buildPage.verify_Deleted_version_questions_visibility_in_analyse_section(
				reader.getCellData("Build", 0, 34), reader.getCellData("Build", 1, 34), 
				reader.getCellData("Build", 2, 34), reader.getCellData("Build", 3, 34), 
				reader.getCellData("Build", 4, 34), reader.getCellData("Build", 5, 34));
	}
	
	@Test//(groups="Upissue")
	public void verify_Up_issue_log_Test() throws Exception {
		buildPage.verify_Up_issue_log(
				reader.getCellData("Build", 0, 35), reader.getCellData("Build", 1, 35), 
				reader.getCellData("Build", 2, 35), reader.getCellData("Build", 3, 35), 
				reader.getCellData("Build", 4, 35), reader.getCellData("Build", 5, 35),
				reader.getCellData("Build", 6, 35), reader.getCellData("Build", 7, 35), 
				reader.getCellData("Build", 8, 35), reader.getCellData("Build", 9, 35), 
				System.getProperty("user.dir")+"\\Files\\Questions Template.xlsx");
	}
	
	@Test(groups="Up_issue_log")
	public void verify_Up_issue_log_visibility_for_edit_user_Test() throws Exception {
		buildPage.verify_Up_issue_log_visibility_for_edit_user(
				reader.getCellData("Build", 0, 36), reader.getCellData("Build", 1, 36), 
				reader.getCellData("Build", 2, 36), reader.getCellData("Build", 3, 36));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"}) // groups="Upissue"
	public void verify_Up_issue_log_on_changing_no_of_questions_on_wizard_table_Test() throws Exception {
		buildPage.verify_Up_issue_log_on_changing_no_of_questions_on_wizard_table(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 52), reader.getCellData("Build", 1, 52), 
				reader.getCellData("Build", 2, 52), reader.getCellData("Build", 3, 52));
	}
	
	@Test(dependsOnMethods={"Create_Folder_Test", "Create_Nested_Folder_Test"})
	public void verify_Warning_alert_on_adding_less_number_of_wizard_questions_than_existing_Test() throws Exception {
		buildPage.verify_Warning_alert_on_adding_less_number_of_wizard_questions_than_existing(
				reader.getCellData("Build", 0, 1), reader.getCellData("Build", 0, 2), 
				reader.getCellData("Build", 0, 53), reader.getCellData("Build", 1, 53), 
				reader.getCellData("Build", 2, 53), reader.getCellData("Build", 3, 53), 
				reader.getCellData("Build", 4, 53));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//--------------------------- Folder permissions (Start)-----------------------------------
	@Test(groups="FolderPermissions")
	public void Create_setup_for_folder_permissions_Test() throws Exception {
		buildPage.Create_setup_for_folder_permissions(
				reader.getCellData("Build", 0, 38), reader.getCellData("Build", 1, 38), 
				reader.getCellData("Build", 2, 38), reader.getCellData("Build", 3, 38), 
				reader.getCellData("Build", 4, 38), reader.getCellData("Build", 5, 38), 
				reader.getCellData("Build", 6, 38), reader.getCellData("Build", 7, 38), 
				prop.getProperty("testUser"), reader.getCellData("Build", 8, 38));
		Reporter.log("Setup folder permission is created successfully", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_the_folder_permission_to_VIEW_folders_Test() throws Exception {
		buildPage.verify_set_the_folder_permission_to_VIEW_folders(reader.getCellData("Build", 0, 39), 
				prop.getProperty("testUser"));
		Reporter.log("Folder permission for 'View' user is functional", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_the_folder_permission_to_DO_folders_Test() throws Exception {
		buildPage.verify_set_the_folder_permission_to_DO_folders(reader.getCellData("Build", 0, 40), 
				prop.getProperty("testUser"));
		Reporter.log("Folder permission for 'Do' user is functional", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_the_folder_permission_to_MODERATOR_folders_Test() throws Exception {
		buildPage.verify_set_the_folder_permission_to_MODERATOR_folders(reader.getCellData("Build", 0, 41), 
				prop.getProperty("testUser"));
		Reporter.log("Folder permission for 'Moderator' user is functional", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_DO_permission_to_subfolder_Test() throws Exception {
		buildPage.verify_set_DO_permission_to_subfolder(reader.getCellData("Build", 0, 40), 
				prop.getProperty("testUser2"));
		Reporter.log("'Do' prermission for subfolder is functional", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_subfolders_Test() throws Exception {
		buildPage.set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_subfolders(prop.getProperty("testUser"), 
				reader.getCellData("Build", 0, 39));
		Reporter.log("'VIEW' permission to main folder is applied to sub-folders successfully", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_newly_added_subfolders_Test() throws Exception {
		buildPage.set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_newly_added_subfolders(prop.getProperty("testUser"), 
				reader.getCellData("Build", 0, 42), reader.getCellData("Build", 1, 42), 
				reader.getCellData("Build", 2, 42));
		Reporter.log("'VIEW' permission to main folder is applied to newly added sub-folders successfully", true);
	}

	@Test(dependsOnMethods="Set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_newly_added_subfolders_Test", groups="FolderPermissions")
	public void Set_different_permission_to_locked_folder_and_reset_the_permissions_to_older_Test() throws Exception {
		buildPage.verify_Set_different_permission_to_locked_folder_and_reset_the_permissions_to_older(prop.getProperty("testUser"), 
				reader.getCellData("Build", 0, 43));
		Reporter.log("Delete user button is visible on changing the permissions to locked folder and setteings got reset on deleting the user", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_main_folder_permission_to_VIEW_and_Set_sub_folder_permission_to_DO_Test() throws Exception {
		buildPage.verify_Set_main_folder_permission_to_VIEW_and_Set_sub_folder_permission_to_DO(prop.getProperty("testUser"), 
				reader.getCellData("Build", 0, 44), reader.getCellData("Build", 1, 44));
		Reporter.log("'Do' permissions to subfolders is functional", true);
	}

	@Test(dependsOnMethods="Set_main_folder_permission_to_VIEW_and_Set_sub_folder_permission_to_DO_Test", groups="FolderPermissions")
	public void Set_main_folder_to_VIEW_and_Set_sub_folder_to_DO_Delete_main_folder_permision_and_check_subfolder_permision_status_Test() throws Exception {
		buildPage.verify_Set_main_folder_to_VIEW_and_Set_sub_folder_to_DO_Delete_main_folder_permision_and_check_subfolder_permision_status(prop.getProperty("testUser"), 
				reader.getCellData("Build", 0, 44), reader.getCellData("Build", 1, 44));
		Reporter.log("'Do' permissions to subfolders after deleting main folder permision is functional", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="FolderPermissions")
	public void Set_DENY_permission_to_folder_Test() throws Exception {
		buildPage.verify_Set_DENY_permission_to_folder(prop.getProperty("testUser"), 
				reader.getCellData("Build", 0, 45), reader.getCellData("Build", 1, 45), 
				reader.getCellData("Build", 2, 45));
		Reporter.log("'Deny' permission on folders is functional", true);
	}

	@Test(dependsOnMethods="Create_setup_for_folder_permissions_Test", groups="Folder Permissions")
	public void Add_all_users_from_the_company_change_permissions_and_removing_users_from_company_Test() throws Exception {
		buildPage.verify_Add_all_users_from_the_company_change_permissions_and_removing_users_from_company(
				reader.getCellData("Build", 0, 46), reader.getCellData("Build", 1, 46));
		Reporter.log("All users added from the company, changed the permissions and removed the users from company successfully", true);
	}
	//--------------------------- Folder permissions (End)-----------------------------------

	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	@Test(enabled=true)
	public void Create_Questionnaire_for_Analyse_Test() throws Exception{
		buildPage.verify_Create_Questionnaire_for_Analyse(reader.getCellData("Build", 0, 48), reader.getCellData("Build", 1, 48), 
				reader.getCellData("Build", 2, 48), reader.getCellData("Build", 3, 48), reader.getCellData("Build", 4, 48), 
				reader.getCellData("Build", 5, 48), reader.getCellData("Build", 6, 48), reader.getCellData("Build", 7, 48), 
				reader.getCellData("Build", 8, 48), reader.getCellData("Build", 9, 48), reader.getCellData("Build", 10, 48), 
				reader.getCellData("Build", 11, 48), reader.getCellData("Build", 12, 48), reader.getCellData("Build", 13, 48), 
				reader.getCellData("Build", 14, 48), reader.getCellData("Build", 15, 48), reader.getCellData("Build", 16, 48), 
				reader.getCellData("Build", 17, 48), reader.getCellData("Build", 18, 48), reader.getCellData("Build", 19, 48), 
				reader.getCellData("Build", 20, 48), reader.getCellData("Build", 21, 48), reader.getCellData("Build", 0, 49),
				reader.getCellData("Build", 1, 49), reader.getCellData("Build", 2, 49), reader.getCellData("Build", 3, 49), 
				reader.getCellData("Build", 4, 49), reader.getCellData("Build", 5, 49), reader.getCellData("Build", 6, 49), 
				reader.getCellData("Build", 7, 49), reader.getCellData("Build", 8, 49), reader.getCellData("Build", 9, 49),
				reader.getCellData("Build", 10, 49), reader.getCellData("Build", 11, 49), reader.getCellData("Build", 12, 49), 
				reader.getCellData("Build", 13, 49), reader.getCellData("Build", 14, 49), reader.getCellData("Build", 15, 49), 
				reader.getCellData("Build", 16, 49), reader.getCellData("Build", 17, 49), reader.getCellData("Build", 18, 49), 
				reader.getCellData("Build", 19, 49), reader.getCellData("Build", 20, 49), reader.getCellData("Build", 21, 49), 
				reader.getCellData("Build", 0, 50), reader.getCellData("Build", 1, 50), reader.getCellData("Build", 2, 50), 
				reader.getCellData("Build", 3, 50), reader.getCellData("Build", 4, 50), reader.getCellData("Build", 5, 50), 
				reader.getCellData("Build", 6, 50),  reader.getCellData("Build", 7, 50), reader.getCellData("Build", 8, 50), 
				reader.getCellData("Build", 9, 50), reader.getCellData("Build", 10, 50), reader.getCellData("Build", 11, 50), 
				reader.getCellData("Build", 12, 50), reader.getCellData("Build", 13, 50), reader.getCellData("Build", 14, 50), 
				reader.getCellData("Build", 15, 50), reader.getCellData("Build", 16, 50), reader.getCellData("Build", 17, 50), 
				reader.getCellData("Build", 18, 50), reader.getCellData("Build", 19, 50), reader.getCellData("Build", 20, 50));
		Reporter.log("Emp Analyse Questionnaire Created Successfully", true);
	}
	
	

	
	
	
	
	
}
