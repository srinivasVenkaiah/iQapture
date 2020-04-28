package com.testcases;

import java.nio.file.Paths;


import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AuditAnalysePage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;


public class AuditAnalysePageTest extends BasePage{
	
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	AuditAnalysePage auditAnalysePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		auditAnalysePage = taskBoardPage.clickOn_Analyse_Audit();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void AuditAnalysePage_Test() throws Exception {
		auditAnalysePage.verify_AuditAnalysePage();
		Reporter.log("AuditAnalyse Page Verified Successfully",true);
	}
	
	@Test(dependsOnMethods="AuditAnalysePage_Test")
	public void verify_Audit_selection_Test() throws Exception {
		auditAnalysePage.verify_Audit_selection(reader.getCellData("AuditAnalyse", 0, 1));
		Reporter.log("Questionnaire selected successfully",true);
	}
	
	@Test(dependsOnMethods="verify_Audit_selection_Test")
	public void Create_report_Test() throws Exception {
		auditAnalysePage.verify_Create_report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getOrderedRandomData("AuditAnalyse", 0, 2));
		Reporter.log("Report created successfully",true);
	}
		
	@Test(dependsOnMethods={"Create_report_Test"})
	public void Copy_report_Test() throws Exception {
		auditAnalysePage.verify_Copy_report(reader.getCellData("AuditAnalyse", 0, 2));
		Reporter.log("Report copied successfully",true);
	}
	
	@Test(dependsOnMethods={"Create_report_Test", "Copy_report_Test"})
	public void Delete_report_Test() throws Exception {
		auditAnalysePage.verify_Delete_report(reader.getCellData("AuditAnalyse", 0, 2));
		Reporter.log("Report deleted successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Swaping_columns_Test() throws Exception {
		auditAnalysePage.verify_Swaping_columns(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 3));
		Reporter.log("Columns swapped successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Delete_columns_Test() throws Exception {
		auditAnalysePage.verify_Delete_columns(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 4));
		Reporter.log("Columns deleted successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Add_all_and_Remove_all_columns_Test() throws Exception {
		auditAnalysePage.verify_Add_all_columns_Remove_all_columns(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 5), reader.getCellData("Build", 4, 49));
		Reporter.log("All columns adding and removing is functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Adding_selected_fileds_to_report_Test() throws Exception {
		auditAnalysePage.verify_Adding_selected_fileds_to_report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 6));
		Reporter.log("Selected fields added to the report Successfully",true);
	}
	
	//Pending
	@Test(dependsOnMethods="Create_report_Test", enabled=false)
	public void Drop_sort_field_Ascending_and_Descending_Order_Test() throws Exception {
		auditAnalysePage.verify_Drop_sort_field_Ascending_and_Descending_Order(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 7), reader.getCellData("AuditAnalyse", 1, 7), 
				reader.getCellData("AuditAnalyse", 2, 7), reader.getCellData("AuditAnalyse", 3, 7), 
				reader.getCellData("AuditAnalyse", 4, 7));
		Reporter.log("Dropped field sorted in order successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Sort_by_Group_report_Test() throws Exception {
		auditAnalysePage.verify_Sort_by_Group_report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 8), reader.getCellData("AuditAnalyse", 1, 8));
	}
	
	//Not usefull in Audit
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void Total_of_the_selected_field_report_Test() throws Exception {
		auditAnalysePage.verify_Total_of_the_selected_field_report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 9), reader.getCellData("AuditAnalyse", 1, 9), 
				reader.getCellData("AuditAnalyse", 2, 9), reader.getCellData("AuditAnalyse", 3, 9), 
				reader.getCellData("AuditAnalyse", 4, 9));
		Reporter.log("Total of the selected field option is Functional",true);
	}
	
	@Test(dependsOnMethods= "Create_report_Test")
	public void Download_report_in_CSV_and_Excel_formats_Test() throws Exception {
		auditAnalysePage.verify_Download_report_in_CSV_and_Excel_formats(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 2), Paths.get(System.getProperty("user.home"), "Downloads").toString());
		Reporter.log("Report downloaded in CSV and Excel formats successfully",true);
	}
	
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Filter_Option_for_Text_field_Test() throws Exception {
		auditAnalysePage.verify_Filter_Option_for_Text_field(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 10));
		Reporter.log("Filter Option for text field is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Filter_Option_for_Date_field_Test() throws Exception {
		auditAnalysePage.verify_Filter_Option_for_Date_field(reader.getCellData("AuditAnalyse", 0, 1),
				reader.getCellData("AuditAnalyse", 0, 12), reader.getCellData("AuditAnalyse", 1, 12), 
				reader.getCellData("AuditAnalyse", 2, 12), reader.getCellData("AuditAnalyse", 3, 12), 
				reader.getCellData("AuditAnalyse", 4, 12), reader.getCellData("AuditAnalyse", 5, 12), 
				reader.getCellData("AuditAnalyse", 6, 12), reader.getCellData("AuditAnalyse", 7, 12), 
				reader.getCellData("AuditAnalyse", 8, 12));
		Reporter.log("Filter options for date field is functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Share_Report_option_Test() throws Exception {
		auditAnalysePage.verify_Share_Report_option(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 12), reader.getCellData("AuditAnalyse", 1, 12));
		Reporter.log("Share Option is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void BarChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_BarChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 14));
		Reporter.log("BarChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void LineChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_LineChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 15));
		Reporter.log("LineChart design report is Functional",true);
	}
	
	//Pending
	@Test//(dependsOnMethods="Create_report_Test",enabled=false)
	public void PieChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_PieChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 16));
		Reporter.log("PieChart design report is Functional",true);
	}
	
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void ScatterChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_ScatterChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 18));
		Reporter.log("ScatterChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void WaterFallChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_WaterFallChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 18));
		Reporter.log("WaterFallChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void BoxPlotChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_BoxPlotChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 20));
		Reporter.log("BoxPlotChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void RoseChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_RoseChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 21));
		Reporter.log("RoseChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void SpiderChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_SpiderChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 22));
		Reporter.log("SpiderChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void BubbleChart_Design_Report_Test() throws Exception {
		auditAnalysePage.verify_BubbleChart_Design_Report(reader.getCellData("AuditAnalyse", 0, 1), 
				reader.getCellData("AuditAnalyse", 0, 23));
		Reporter.log("BubbleChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void verify_Filter_by_record_status_field() throws Exception {
		auditAnalysePage.verify_Filter_by_record_status_field(
				reader.getCellData("AuditAnalyse", 0, 1), reader.getCellData("AuditAnalyse", 0, 26), 
				reader.getCellData("AuditAnalyse", 1, 26), reader.getCellData("AuditAnalyse", 2, 26));
		Reporter.log("Filter by record status is functional", true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void verify_Open_captured_record_through_record_ID_Test() throws Exception {
		auditAnalysePage.verify_Open_captured_record_through_record_ID(
				reader.getCellData("AuditAnalyse", 0, 1), reader.getCellData("AuditAnalyse", 0, 26));
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void verify_Deleted_and_trashed_records_deletion_in_AuditAnalyse_Test() throws Exception {
		auditAnalysePage.verify_Deleted_and_trashed_records_deletion_in_analyse(reader.getCellData("AuditAnalyse", 0, 1), "VerifyDeletedRecord2");
	}
	
	
	
	
	
	
	
	
	
	
	
}
