

/**

 * @author UmaMaheswararao
 */

package com.testcases;

import java.nio.file.Paths;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AnalysePage;
import com.pages.LoginPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;

public class AnalysePageTest extends BasePage {
	
	LoginPage loginPage;
	TaskBoardPage taskBoardPage;
	AnalysePage analysePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		analysePage = taskBoardPage.clickOnAnalyseLink();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void AnalysePage_Test() throws Exception {
		analysePage.verify_AnalysePage();
		Reporter.log("Analyse Page Verified Successfully",true);
	}
	
	@Test(dependsOnMethods="AnalysePage_Test")
	public void Questionnaire_selection_Test() throws Exception {
		analysePage.verify_Questionnaire_selection(reader.getCellData("Analyse", 0, 1));
		Reporter.log("Questionnaire selected successfully",true);
	}
	
	@Test(dependsOnMethods="Questionnaire_selection_Test")
	public void Create_report_Test() throws Exception {
		analysePage.verify_Create_report(reader.getCellData("Analyse", 0, 1), 
				reader.getOrderedRandomData("Analyse", 0, 2));
		Reporter.log("Report created successfully",true);
	}
		
	@Test(dependsOnMethods={"Create_report_Test"})
	public void Copy_report_Test() throws Exception {
		analysePage.verify_Copy_report(reader.getCellData("Analyse", 0, 2));
		Reporter.log("Report copied successfully",true);
	}
	
	@Test(dependsOnMethods={"Create_report_Test", "Copy_report_Test"})
	public void Delete_report_Test() throws Exception {
		analysePage.verify_Delete_report(reader.getCellData("Analyse", 0, 2));
		Reporter.log("Report deleted successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Swaping_columns_Test() throws Exception {
		analysePage.verify_Swaping_columns(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 3));
		Reporter.log("Columns swapped successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Delete_columns_Test() throws Exception {
		analysePage.verify_Delete_columns(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 4));
		Reporter.log("Columns deleted successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Add_all_and_Remove_all_columns_Test() throws Exception {
		analysePage.verify_Add_all_columns_Remove_all_columns(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 5), reader.getCellData("Build", 4, 49));
		Reporter.log("All columns adding and removing is functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Adding_selected_fileds_to_report_Test() throws Exception {
		analysePage.verify_Adding_selected_fileds_to_report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 6));
		Reporter.log("Selected fields added to the report Successfully",true);
	}
	
	//Pending
	@Test(dependsOnMethods="Create_report_Test", enabled=false)
	public void Drop_sort_field_Ascending_and_Descending_Order_Test() throws Exception {
		analysePage.verify_Drop_sort_field_Ascending_and_Descending_Order(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 7), reader.getCellData("Analyse", 1, 7), 
				reader.getCellData("Analyse", 2, 7), reader.getCellData("Analyse", 3, 7), 
				reader.getCellData("Analyse", 4, 7));
		Reporter.log("Dropped field sorted in order successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Sort_by_Group_report_Test() throws Exception {
		analysePage.verify_Sort_by_Group_report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 8), reader.getCellData("Analyse", 1, 8));
		Reporter.log("Sort By Group option is functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Total_of_the_selected_field_report_Test() throws Exception {
		analysePage.verify_Total_of_the_selected_field_report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 9), reader.getCellData("Analyse", 1, 9), 
				reader.getCellData("Analyse", 2, 9), reader.getCellData("Analyse", 3, 9), 
				reader.getCellData("Analyse", 4, 9));
		Reporter.log("Total of the selected field option is Functional",true);
	}
	
	@Test(dependsOnMethods= "Total_of_the_selected_field_report_Test")
	public void Download_report_in_CSV_and_Excel_formats_Test() throws Exception {
		analysePage.verify_Download_report_in_CSV_and_Excel_formats(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 9), Paths.get(System.getProperty("user.home"), "Downloads").toString());
		Reporter.log("Report downloaded in CSV and Excel formats successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Filter_Option_for_number_field_Test() throws Exception {
		analysePage.verify_Filter_Option_for_number_field(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 10), reader.getCellData("Analyse", 1, 10), 
				reader.getCellData("Analyse", 2, 10), reader.getCellData("Analyse", 3, 10), 
				reader.getCellData("Analyse", 4, 10), reader.getCellData("Analyse", 5, 10), 
				reader.getCellData("Analyse", 6, 10), reader.getCellData("Analyse", 7, 10));
		Reporter.log("Filter options for number field is functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Filter_Option_for_Text_field_Test() throws Exception {
		analysePage.verify_Filter_Option_for_Text_field(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 11));
		Reporter.log("Filter Option for text field is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Filter_Option_for_Date_field_Test() throws Exception {
		analysePage.verify_Filter_Option_for_Date_field(reader.getCellData("Analyse", 0, 1),
				reader.getCellData("Analyse", 0, 12), reader.getCellData("Analyse", 1, 12), 
				reader.getCellData("Analyse", 2, 12), reader.getCellData("Analyse", 3, 12), 
				reader.getCellData("Analyse", 4, 12), reader.getCellData("Analyse", 5, 12), 
				reader.getCellData("Analyse", 6, 12), reader.getCellData("Analyse", 7, 12), 
				reader.getCellData("Analyse", 8, 12));
		Reporter.log("Filter options for date field is functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Share_Report_option_Test() throws Exception {
		analysePage.verify_Share_Report_option(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 13), reader.getCellData("Analyse", 1, 13));
		Reporter.log("Share Option is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Summary_Design_Report_Test() throws Exception {
		analysePage.verify_Summary_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 14));
		Reporter.log("Summary design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void BarChart_Design_Report_Test() throws Exception {
		analysePage.verify_BarChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 15));
		Reporter.log("BarChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void LineChart_Design_Report_Test() throws Exception {
		analysePage.verify_LineChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 16));
		Reporter.log("LineChart design report is Functional",true);
	}
	
	//Pending
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void PieChart_Design_Report_Test() throws Exception {
		analysePage.verify_PieChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 17));
		Reporter.log("PieChart design report is Functional",true);
	}
	
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void ScatterChart_Design_Report_Test() throws Exception {
		analysePage.verify_ScatterChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 18));
		Reporter.log("ScatterChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void WaterFallChart_Design_Report_Test() throws Exception {
		analysePage.verify_WaterFallChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 19));
		Reporter.log("WaterFallChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void BoxPlotChart_Design_Report_Test() throws Exception {
		analysePage.verify_BoxPlotChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 20));
		Reporter.log("BoxPlotChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void RoseChart_Design_Report_Test() throws Exception {
		analysePage.verify_RoseChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 21));
		Reporter.log("RoseChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void SpiderChart_Design_Report_Test() throws Exception {
		analysePage.verify_SpiderChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 22));
		Reporter.log("SpiderChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void BubbleChart_Design_Report_Test() throws Exception {
		analysePage.verify_BubbleChart_Design_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 23));
		Reporter.log("BubbleChart design report is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void Create_Publish_Report_Test() throws Exception {
		analysePage.verify_Create_Publish_Report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 24), System.getProperty("user.dir")+"\\Files\\Publish Report.xlsx");
		Reporter.log("Publish report option is Functional",true);
	}
	
	@Test(dependsOnMethods="Create_Publish_Report_Test")
	public void View_and_Download_published_report_Test() throws Exception {
		analysePage.verify_View_and_Download_published_report(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 24), Paths.get(System.getProperty("user.home"), "Downloads").toString(), 
				"publish report");
		Reporter.log("Published report viewed and record is Downloaded successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void View_published_report_without_template_Test() throws Exception {
		analysePage.verify_View_published_report_without_template(reader.getCellData("Analyse", 0, 1), 
				reader.getCellData("Analyse", 0, 25));
		Reporter.log("Publish report option is Functional",true);
	}
	
	// Need to confirm with Renan
	@Test(dependsOnMethods="Create_report_Test",enabled=false)
	public void Upload_report_without_tags_and_view_the_publish_report_and_verify_error_msg_Test() throws Exception {
		analysePage.verify_Upload_report_without_tags_and_view_the_publish_report_and_verify_error_msg(
				reader.getCellData("Analyse", 0, 1), reader.getCellData("Analyse", 0, 26), 
				System.getProperty("user.dir")+"\\Files\\Publish Report - without tags.xlsx");
		Reporter.log("'Field description tag is not found in the template.' message verified successfully",true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void verify_Filter_by_record_status_field() throws Exception {
		analysePage.verify_Filter_by_record_status_field(
				reader.getCellData("Analyse", 0, 1), reader.getCellData("Analyse", 0, 27), 
				reader.getCellData("Analyse", 1, 27), reader.getCellData("Analyse", 2, 27));
		Reporter.log("Filter by record status is functional", true);
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void verify_Open_captured_record_through_record_ID_Test() throws Exception {
		analysePage.verify_Open_captured_record_through_record_ID(
				reader.getCellData("Analyse", 0, 1), reader.getCellData("Analyse", 0, 27));
	}
	
	@Test(dependsOnMethods="Create_report_Test")
	public void verify_Deleted_and_trashed_records_deletion_in_analyse_Test() throws Exception {
		analysePage.verify_Deleted_and_trashed_records_deletion_in_analyse(reader.getCellData("Analyse", 0, 1), "VerifyDeletedRecord");
	}
	
	
	
	
	
	
	
	
	
	
	
}
