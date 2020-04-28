/**
 * @author UmaMaheswararao
 */

package com.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;
import com.util.VerificationLibrary;
import com.util.Wrappers;

public class AnalysePage extends BasePage {
	// Initializing the Page Objects:................................................................
	public AnalysePage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath="//*[@id='txtSearch']")
	WebElement analysesSearchBox;

	// verify Questionnaire selection 
	@FindBy(xpath="(//i[@class='fa fa-search'])[1]")
	WebElement searchQuestionnaireBtn;

	@FindBy(xpath="//span[contains(@id,'spanDSName')]")
	WebElement selectedQuestionnaire;

	@FindBy(xpath="//a[@id='btnNewIQReport']")
	WebElement createReportBtn;

	// Create report 
	@FindBy(xpath=".//*[@id='REPORTNAME']")
	WebElement reportNameTextBox;

	@FindBy(xpath="//a[@id='btnPageBack']")
	WebElement backBtn;

	@FindBy(xpath="//a[@title='Save Report']")
	WebElement saveBtn;

	@FindBy(xpath=".//*[@id='txtSearchForIQReport']")
	WebElement searchReportTextBox;

	@FindBy(xpath="(//i[@class='fa fa-search'])[2]")
	WebElement searchReportBtn;

	// Copy Report
	@FindBy(xpath="//a[@title='Edit report']")
	WebElement editBtn;

	@FindBy(xpath=".//*[@id='btnMore']/a")
	WebElement moreBtn;

	By previewReportBtn = By.xpath("//a[@id='btnPreview']");

	@FindBy(xpath="(//*[@id='btnMore']/ul/li/a)[2]")
	WebElement copyReportBtn;

	// Delete report
	@FindBy(xpath="//a[@id='btnDelete']")
	WebElement deleteBtn;

	// Swapping columns 
	@FindBy(xpath="//button[@id='btnAddAll']")
	WebElement addAllBtn;

	@FindBy(xpath="//button[text()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath="//th[2]/span[1]")
	WebElement column2Header;

	@FindBy(xpath="(//div[@closeid='title3'])[1]")
	WebElement column4Header;

	@FindBy(xpath="(//div[@closeid='title12'])[1]")
	WebElement column12Header;

	@FindBy(xpath="//tr[@data-index='0']//td[4]")
	WebElement cellDataForColumn4;

	@FindBy(xpath="(//div[@closeid='title4'])[1]")
	WebElement column5Header;

	@FindBy(xpath="//tr[@data-index='0']//td[5]")
	WebElement cellDataForColumn5;

	// Delete columns
	@FindBy(xpath="(//i[contains(@id,'title3')])[1]")
	WebElement deleteColumnBtn;

	// Add all and Remove all fields
	@FindBy(xpath="//button[text()='Remove all']")
	WebElement removeAllBtn;

	// Add selected fields to report
	@FindBy(xpath="//div[contains(@id,'divFieldDrop')]")
	WebElement dropField;

	@FindBy(xpath="//div[contains(text(),'EMP No.')]")
	WebElement empNo;

	@FindBy(xpath="//div[contains(text(),'EMP Name')]")
	WebElement empName;

	@FindBy(xpath="//div[text()='EMP Address']")
	WebElement empAddress;

	@FindBy(xpath="(//div[contains(text(),'EMP - Fee')])[2]")
	WebElement empFee;

	// Sorting fields
	@FindBy(xpath=".//*[@id='sortDrop']")
	WebElement sortDropField;

	@FindBy(xpath="//i[@class='fa  vc-order-asc']")
	WebElement descendingOrderBtn;

	@FindBy(xpath="//i[@class='fa vc-icon-round-delete']")
	WebElement closeSortingBtn;

	// Sort By Group
	@FindBy(xpath=".//*[@id='groupDrop']")
	WebElement sortByGroupField;

	@FindBy(xpath="//span[contains(text(),'Analyse')]")
	WebElement AnalyseLink;

	// Field Total
	@FindBy(xpath="//div[contains(text(),'EMP - Form Fee')]")
	WebElement empFormFee;

	@FindBy(xpath=".//*[@id='totalDrop']")
	WebElement totalDropField;

	@FindBy(xpath="//a[@title='Go to last page']")
	WebElement goToLastPageBtn;

	// Download report in CSV and Excel formats
	@FindBy(xpath=".//*[@id='dropdownMenu' or @title='More']")
	WebElement moreDropDownBtn;

	@FindBy(xpath="//a[text()='Csv']")
	WebElement CSV;

	@FindBy(xpath="//a[text()='Export']")
	WebElement Export;

	// Filter Option 
	@FindBy(xpath="(//button[@title='Nothing selected'])[2]")
	WebElement selectEmpAddress;

	@FindBy(xpath="//button[@title='N/A']//following::select[1]")
	WebElement empFormFeeTypeSelect;

	@FindBy(xpath="//*[text()='Start']//following::input[1]")
	WebElement empFormFeeStartTextBox;

	// Filter option - Number field
	@FindBy(xpath="//a[text()='Filter ']")
	WebElement filterOption;

	@FindBy(xpath=".//*[@id='divFilterDrop']")
	WebElement filterDropField;

	@FindBy(xpath="//label[contains(text(),'Type')]/following::button[1]")
	WebElement typeDropDown;

	@FindBy(xpath="//label[contains(text(),'Start')]/following::input[1]")
	WebElement startFieldTextBox;

	@FindBy(xpath="//span[text()='>']")
	WebElement greaterThanOption;

	@FindBy(xpath="//span[text()='>=']")
	WebElement greaterThanEqualsOption;

	@FindBy(xpath="//span[text()='<']")
	WebElement lessThanOption;

	@FindBy(xpath="//span[text()='<=']")
	WebElement lessThanEqualsOption;

	@FindBy(xpath="//span[text()='Range']")
	WebElement rangeOption;

	@FindBy(xpath="//label[contains(text(),'End')]/following::input[1]")
	WebElement endFieldTextBox;

	@FindBy(xpath="//span[text()='Max']")
	WebElement maxOption;

	@FindBy(xpath="//span[text()='N/A']")
	WebElement NA;

	// Filter Option - Date 
	@FindBy(xpath="(//div[contains(text(),'Joining Date')])[1]")
	WebElement joiningDate;

	@FindBy(xpath="(//span[@class='filter-option pull-left']")
	WebElement selectDateOption;

	@FindBy(xpath="//label[contains(text(),'Start')]/following::input[1]")
	WebElement startDateBtn;

	@FindBy(xpath="//label[contains(text(),'End')]/following::input[1]")
	WebElement endDateBtn;

	// Share Report
	@FindBy(xpath="//a[text()='Share ']")
	WebElement shareOption;

	@FindBy(xpath="//input[contains(@placeholder,'Search...')]")
	WebElement shareSearchBox;

	@FindBy(xpath="//a[contains(.,'Search')]")
	WebElement shareSearchBtn;

	@FindBy(xpath="//div[contains(text(),'no records found')]")
	WebElement noRecordsFoundMessage;

	@FindBy(xpath="//b[text()='Company']//following::button[1]")
	WebElement shareToCompany;

	@FindBy(xpath="//span[contains(@id,'_btnComUserAdd')]")
	WebElement shareToUser;

	@FindBy(xpath="//span[contains(@style,'color: #FFFFFF;')]")
	WebElement currentUserAcc;

	@FindBy(linkText="myAccount")
	WebElement myAccountLink;

	@FindBy(xpath="//span[text()='Log in as']")
	WebElement LoginAsBtn;

	@FindBy(id="txtUserSearch")
	WebElement logInEmailTextBox;

	@FindBy(xpath="//span[contains(text(),'Re Login')]")
	WebElement reLogInBtn;

	@FindBy(xpath="//a[text()='valuechain.com']//following::div[2]")
	WebElement viosMenu;

	@FindBy(xpath="//div[contains(text(),'no records found')]")
	WebElement noRecordsFound;

	// SummaryChart Design
	@FindBy(xpath="//a[@title='Summary']")
	WebElement summaryDesign;

	@FindBy(xpath=".//*[@id='divAxis_y']")
	WebElement summary_Y;

	@FindBy(xpath=".//*[@id='divDragHint_X']")
	WebElement summary_X;

	@FindBy(xpath="//div[@id='divAxis_z']")
	WebElement summary_Z;

	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	WebElement summaryDesignResultTable;

	// BarChart Design
	@FindBy(xpath="//a[@title='Bar']")
	WebElement barChartDesign;

	@FindBy(xpath="//div[text()='RecordID']")
	WebElement RecordID;


	@FindBy(xpath=".//*[@id='divDragHint_X']")
	WebElement bar_X;

	@FindBy(xpath=".//*[@id='divAxis_y']")
	WebElement bar_Y;

	@FindBy(xpath="//div[@id='divDragHint_X2']")
	WebElement bar_X2;

	@FindBy(xpath="(//label[text()='Columns']//following::span[@class='filter-option pull-left'])[1]")
	WebElement xColumns;
	
	@FindBy(xpath="(//div[@class='dropdown-menu open'])[8]//ul//li[6]")
	WebElement colValue;
	
	@FindBy(xpath="//a[@href='#portlet_x2']")
	WebElement x2;

	@FindBy(xpath="//input[@id='BAR_SHOWTARGET']")
	WebElement targetTextBox;

	@FindBy(xpath="//input[@id='WATERFALL_SHOWTARGET']")
	WebElement WATERFALLtargetTextBox;


	@FindBy(xpath="//input[@id='LINE_SHOWTARGET']")
	WebElement LineTargettextBox;

	@FindBy(xpath="(//span[contains(.,'OFF')])[1]")
	WebElement labelOFF;

	@FindBy(xpath="(//span[contains(.,'OFF')])[2]")
	WebElement reportTotalOFF;

	@FindBy(xpath="//label[text()='Column Total']//following::span[3]")
	WebElement columnTotalOFF;

	@FindBy(xpath="//button[@data-id='FormatSelect']")
	WebElement FormatingType;

	@FindBy(xpath="//span[text()='Conditional']")
	WebElement conditional;
	
	@FindBy(xpath="//select[@id='FormatNoteSelect']")
	WebElement formatingField;

	@FindBy(xpath="(//a[@title='Add Condition'])[1]")
	WebElement addCondtionBtn;
	
	@FindBy(xpath="(//span[@class='filter-option pull-left'][contains(.,'Noting Selected')])[1]")
	WebElement FormatnothingSelectedField;

	@FindBy(xpath="(//input[contains(@autocomplete,'off')])[2]")
	WebElement formatSearchBox;
	
	@FindBy(xpath="(//input[contains(@class,'form-control')])[6]")
	WebElement LayoutSearchBox;
	
	By removeCondition = By.xpath("(//i[@class='fa fa-remove vc-analyse-event-select-format-note-remove'])[2]");

	@FindBy(xpath="//input[contains(@updatefield,'FN_COLORVALUE')]")
	WebElement colorField;

	@FindBy(xpath="//button[@title='Noting Selected']")
	WebElement LayoutnothingSelectedField;

	@FindBy(xpath="//button[@data-id='LayOutSelect']")
	WebElement layoutType;

	@FindBy(xpath="//span[text()='Custom']")
	WebElement layoutCustom;

	@FindBy(xpath="//select[@id='LayOutNoteSelect']")
	WebElement layoutSelectDD;
	
	@FindBy(xpath="//a[@id='AddLayOutNote']")
	WebElement addLayoutCondition;

	@FindBy(xpath="//i[@class='fa vc-order-desc']")
	WebElement negativeValueGraphBtn;

	@FindBy(xpath="//span[text()='Layout']//following::select[contains(@id,'layoutItem')][1]")
	WebElement layoutSelect;

	// LineChart Design 
	@FindBy(xpath="//a[@title='Line']")
	WebElement lineChartDesign;

	@FindBy(xpath="(//div[@id='divDragHint_Y'])[1]")
	WebElement line_Y;

	@FindBy(xpath=".//*[@id='divY_Add']")
	WebElement line_Y2;

	@FindBy(xpath="//div[@id='divDragHint_X']")
	WebElement line_X;

	@FindBy(xpath=".//*[@id='Y_Add_li']/a")
	WebElement y2;

	@FindBy(xpath="//span[text()='Layout']//following::a[4]")
	WebElement addLineLayoutCondition;

	// PieChart Design
	@FindBy(xpath="//a[@title='Pie']")
	WebElement pieChartDesign;

	@FindBy(xpath="//div[@id='divAxis_x']")
	WebElement pie_X;

	@FindBy(xpath="//div[@id='divDragHint_X2']")
	WebElement pie_X2;

	@FindBy(xpath="(//div[@id='divDragHint_Y'])[1]")
	WebElement pie_Y;
	
	//By pie_Y = By.xpath("//div[@myaxis='y']");

	// ScatterChart Design
	@FindBy(xpath=".//*[@id='chartType5']")
	WebElement scatterChartDesign;

	@FindBy(xpath=".//*[@id='newyd']")
	WebElement scatter_yAxis;

	@FindBy(xpath=".//*[@id='yd']")
	WebElement scatter_xAxis;

	// WaterFallChart Design
	@FindBy(xpath="//a[@title='Waterfall']")
	WebElement waterFallChartDesign;

	@FindBy(xpath="//div[@id='divDragHint_Y']")
	WebElement waterFall_Y;

	@FindBy(xpath="//div[@id='divDragHint_X']")
	WebElement waterFall_X;

	// BoxPlotChart Design
	@FindBy(xpath=".//*[@id='chartType8']")
	WebElement boxPlotChartDesign;

	@FindBy(xpath=".//*[@id='yd']")
	WebElement boxPlot_Y;

	@FindBy(xpath=".//*[@id='xd']")
	WebElement boxPlot_X;

	// RoseChart Design
	@FindBy(xpath=".//*[@id='chartType9']")
	WebElement roseChartDesign;

	@FindBy(xpath=".//*[@id='yd']")
	WebElement rose_Y;

	@FindBy(xpath=".//*[@id='xd']")
	WebElement rose_X;

	@FindBy(xpath=".//*[@id='x2d']")
	WebElement rose_X2;

	// SpiderChart Design
	@FindBy(xpath=".//*[@id='chartType10']")
	WebElement spiderChartDesign;

	@FindBy(xpath=".//*[@id='yd']")
	WebElement spider_Y;

	@FindBy(xpath=".//*[@id='xd']")
	WebElement spider_X;

	@FindBy(xpath=".//*[@id='x2d']")
	WebElement spider_X2;

	// BubbleChart Design
	@FindBy(xpath=".//*[@id='chartType11']")
	WebElement bubbleChartDesign;

	@FindBy(xpath=".//*[@id='yd']")
	WebElement bubble_Y;

	@FindBy(xpath=".//*[@id='xd']")
	WebElement bubble_X;

	@FindBy(xpath=".//*[@id='newyd']")
	WebElement bubble_Z;

	// Publish Report
	@FindBy(xpath="//a[@title='Publish']")
	WebElement publishReportOption;

	@FindBy(xpath="//div[contains(text(),'EMP No.')]")
	WebElement copiedEmpNoField;

	@FindBy(xpath="//div[contains(text(),'EMP Name')]")
	WebElement copiedEmpNameField;

	@FindBy(xpath="//div[contains(text(),'EMP Address')]")
	WebElement copiedEmpAddressField;

	@FindBy(xpath=".//*[@id='dataSetDropzone']")
	WebElement reportDropZone;

	@FindBy(xpath="//a[contains(.,'publish report.xlsx')]")
	WebElement uploadedPublishReport;

	// View and Download published report
	@FindBy(xpath="//div[text()='Record']//following::span[2]")
	WebElement publishReport_record_1;

	@FindBy(xpath="//div[contains(.,'×CloseExport failed:Please upload the Template.')]")
	WebElement pleaseUploadTemplateErrorMsg;

	@FindBy(xpath="//body[text()='Field description tag is not found in the template.']")
	WebElement fieldDescriptionTagsMissingErrorMsg;

	// Filter by record status
	@FindBy(xpath = "(//div[text()='Record Status'])[1]")
	WebElement recordStatusField;

	@FindBy(xpath="//span[text()='Record Status']/following::select[1]")
	WebElement selectRecordStatusDD;


	// Deleted records visibility
	By recordIds = By.xpath("//td//a");
	By captureLink = By.xpath("//span[contains(text(),'Capture')]");
	By captureSearchBox = By.xpath(".//*[@id='txtSearch']");
	By captureSearchBtn = By.cssSelector(".fa.fa-search");
	By captureRecord1 = By.xpath("(//td//span[1])[1]");
	By captureDeleteRecordBtn = By.xpath(".//*[@id='deleteRecord']/a");
	By noOfRecordsAtCapture = By.xpath("(//td/span)[3]");
	By captureCompleteBtn = By.xpath("//a[@title='Complete']");


	//Re-Login
	By userDropDown = By.xpath("//i[@class='fa fa-angle-down']");
	By myAccount = By.xpath("//a[contains(.,'myAccount')]");
	By loginAs = By.xpath("//span[@class='title'][contains(.,'Log in as')]");
	By loginuserSearchbox = By.xpath("//input[@id='txtUserSearch']");
	By reLoginBtn = By.xpath("//button[contains(.,'Re Login')]");

	By menuBtn = By.xpath("//i[contains(@class,'fa vc-th')]");
	By iQaptureApp = By.xpath("(//span[text()='iQapture'])[1]");



	// Actions:......................................................................................

	public void verify_AnalysePage() throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		Assert.assertTrue(analysesSearchBox.isDisplayed(), "Unable to Navigate Analyse Page");
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(2000);
		/*driver.findElement(By.xpath("//a[contains(@title,'Return to the parent folder')]")).click();
		GenericLibrary.waitForAjax(driver);*/
	}

	public void verify_Questionnaire_selection(String QuestionnaireName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, selectedQuestionnaire);
		Assert.assertTrue(selectedQuestionnaire.isDisplayed(),"Questionnaire Selected Successfully");
		Reporter.log("Questionnaire selected successfully",true);
		Assert.assertTrue(createReportBtn.isDisplayed(), "Create report button is not displaying");
		Reporter.log("Create report button is displayed",true);
	}

	public void verify_Create_report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, selectedQuestionnaire);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		JavascriptLibrary.javascriptClickElement(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("//td[text()='"+reportName+"']"));
		GenericLibrary.waitForElementVisibility(driver, report);
		Assert.assertTrue(report.isDisplayed(), "Report Not Created");
	}

	public void verify_Copy_report(String createdReportName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(createdReportName);
		JavascriptLibrary.javascriptClickElement(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("//td[text()='"+createdReportName+"']"));
		GenericLibrary.click(driver, report);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, editBtn);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		GenericLibrary.waitForElementVisibility(driver, copyReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, copyReportBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		a.assertTrue(column4Header.isDisplayed(), "Table NOT visible after report copy");
		Reporter.log("Report visible after copying report",true);
		ActionUtils.ajaxJsClick(driver, saveBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//a[@onclick='EditReport.PageBack()']"));
		Thread.sleep(2000);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		searchReportTextBox.sendKeys(createdReportName);
		JavascriptLibrary.javascriptClickElement(driver, searchReportBtn);
		Assert.assertTrue(driver.findElement(
				By.xpath("//td[text()='"+createdReportName+" Copy(1)']")).isDisplayed(), "Report not copied");
		Reporter.log("Report copied successfull");
		a.assertAll();
	}

	public void verify_Delete_report(String createdReportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		JavascriptLibrary.javascriptType(driver, searchReportTextBox, createdReportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		WebElement report = driver.findElement(By.xpath("//td[text()='"+createdReportName+"']"));
		GenericLibrary.click(driver, report);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, editBtn);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		ActionUtils.ajaxJsClick(driver, deleteBtn);
		String expected = "Are you sure you want to delete this report?";
		String actual = driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
		Reporter.log("Alert message: "+actual, true);
		Assert.assertEquals(actual, expected, "Expected alert message not displayed");
		Reporter.log("Expected alert message displayed successfully", true);
		ActionUtils.ajaxJsClick(driver, yesBtn);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Swaping_columns(String QuestionnaireName, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		String ch1 = ActionUtils.readText(driver, column4Header);
		String ch2 = ActionUtils.readText(driver, column5Header);
		String ch1c1 = ActionUtils.readText(driver, cellDataForColumn4);
		String ch2c2 = ActionUtils.readText(driver, cellDataForColumn5);
		Reporter.log("Before action: Column1 - "+ch1+" & Column2 - "+ch2+"", true);
		Reporter.log("Before action: Column1 Cell1 Data - "+ch1c1+" & Column2 Cell1 Data - "+ch2c2+"", true);
		ActionUtils.waitForAjax(driver);
		ActionUtils.dragAndDrop(driver, column5Header, column4Header);
		Thread.sleep(3000);
		String ch1a = ActionUtils.readText(driver, column4Header);
		String ch2a = ActionUtils.readText(driver, column5Header);
		String ch1c1a = ActionUtils.readText(driver, cellDataForColumn4);
		String ch2c2a = ActionUtils.readText(driver, cellDataForColumn5);
		Thread.sleep(1000);
		Reporter.log("After action: Column1 - "+ch1a+" & Column2 - "+ch2a+"", true);
		Reporter.log("After action: Column1 Cell1 Data - "+ch1c1a+" & Column2 Cell1 Data - "+ch2c2a+"", true);
		Thread.sleep(1000);
		a.assertTrue(ch1.equals(ch2a) && ch2.equals(ch1a), "Columns headers not swapped");
		Reporter.log("Column headers swapped successfully", true);
		a.assertTrue(ch1c1.equals(ch2c2a) && ch2c2.equals(ch1c1a), "Columns data not swapped");
		Reporter.log("Column data swapped successfully", true);
		a.assertAll();
	}

	public void verify_Delete_columns(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, column4Header);
		JavascriptLibrary.javascriptClickElement(driver, column4Header);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, deleteColumnBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteColumnBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Add_all_columns_Remove_all_columns(String QuestionnaireName, String reportName, String columnName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		ActionUtils.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addAllBtn);
		ActionUtils.waitForAjax(driver);
		Assert.assertTrue(column4Header.isDisplayed(), "Columns not added");
		Reporter.log("All columns added successfully",true);
		GenericLibrary.waitForElementToBeClickable(driver, removeAllBtn);
		JavascriptLibrary.javascriptClickElement(driver, removeAllBtn);
		GenericLibrary.waitForElementVisibility(driver, yesBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		Reporter.log("All columns Removed",true);
	}

	public void verify_Adding_selected_fileds_to_report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, removeAllBtn);
		JavascriptLibrary.javascriptClickElement(driver, removeAllBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement field = driver.findElement(By.xpath("//div[text()='Record Status']"));
		GenericLibrary.dragAndDrop_Method3(driver, field, dropField);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, empNo, dropField);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, empName, dropField);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, dropField);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@closeid='title1'])[1]")).isDisplayed(), "dropped field not displayed");
		Reporter.log("dropped field displayed");


	}

	public void verify_Drop_sort_field_Ascending_and_Descending_Order(String QuestionnaireName, String reportName, String field1Column, String fieldToSort, String fieldToSort2, String field2Column) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list = driver.findElements(By.xpath("//tr/td["+field1Column.replace(".0", "")+"]"));
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getText();
			Reporter.log(""+fieldToSort+" Before Sorting "+i+":" +name ,true);
		}
		GenericLibrary.scrollIntoView(driver, sortDropField);
		WebElement field = driver.findElement(By.xpath("(//div[contains(text(),'"+fieldToSort+"')])[1]"));
		GenericLibrary.waitForElementVisibility(driver, field);
		GenericLibrary.dragAndDrop_Method3(driver, field, sortDropField);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list2 = driver.findElements(By.xpath("//tr/td["+field1Column.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableNumberDataOrder(driver, list2, "Ascending");
		Reporter.log("Ascending order is functional", true);
		JavascriptLibrary.javascriptClickElement(driver, descendingOrderBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list3 = driver.findElements(By.xpath("//tr/td["+field1Column.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableNumberDataOrder(driver, list3, "Descending");
		Reporter.log("Descending order is functional", true);
		GenericLibrary.waitForElementToBeClickable(driver, closeSortingBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeSortingBtn);
		GenericLibrary.waitForAjax(driver);
		// For Analyse drop some fields 
		// Field 1
		WebElement field1 = driver.findElement(By.xpath("(//div[contains(text(),'"+fieldToSort+"')])[1]"));
		GenericLibrary.dragAndDrop_Method3(driver, field1, sortDropField);
		GenericLibrary.waitForAjax(driver);
		// Open created report
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("(//td[text()='"+reportName+"'])[1]"));
		JavascriptLibrary.javascriptClickElement(driver, report);
		GenericLibrary.waitForAjax(driver);
		// Verify sorting by column headers 
		// Field 1
		// Ascending order
		List<WebElement> checkList = driver.findElements(By.xpath("//tr/td["+field1Column.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableNumberDataOrder(driver, checkList, "Ascending");
		Reporter.log("Ascending order is functional", true);
		// Descending order
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("(//div[contains(text(),'"+fieldToSort+"')])[1]")));
		GenericLibrary.waitForAjax(driver);
		List<WebElement> checkList2 = driver.findElements(By.xpath("//tr/td["+field1Column.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableNumberDataOrder(driver, checkList2, "Descending");
		Reporter.log("Descending order is functional", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//div[text()='"+fieldToSort+"'])[1]")));
		// Field 2
		ActionUtils.ajaxJsClick(driver, editBtn);
		GenericLibrary.waitForElementToBeClickable(driver, closeSortingBtn);
		JavascriptLibrary.javascriptClickElement(driver, closeSortingBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement field2 = driver.findElement(By.xpath("(//div[text()='"+fieldToSort2+"'])[1]"));
		GenericLibrary.dragAndDrop_Method3(driver, field2, sortDropField);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, previewReportBtn);
		// Ascending order
		GenericLibrary.waitForAjax(driver);
		List<WebElement> checkList3 = driver.findElements(By.xpath("//tr/td["+field2Column.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, checkList3, "Ascending");
		Reporter.log("Ascending order is functional", true);
		// Descending order
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//div[text()='"+fieldToSort2+"'])[1]")));
		List<WebElement> checkList4 = driver.findElements(By.xpath("//tr/td["+field2Column.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, checkList4, "Descending");
		Reporter.log("Descending order is functional", true);
	}

	public void verify_Sort_by_Group_report(String QuestionnaireName, String reportName, String fieldToSort) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.scrollIntoView(driver, sortByGroupField);
		WebElement field = driver.findElement(By.xpath("(//div[text()='"+fieldToSort+"'])[1]"));
		GenericLibrary.dragAndDrop_Method3(driver, field, sortByGroupField);
		GenericLibrary.waitForAjax(driver);
		/*JavascriptLibrary.javascriptClickElement(driver, AnalyseLink);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		searchReportTextBox.sendKeys(reportName);
		searchReportTextBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("//h3[text()='"+reportName+"']"));
		GenericLibrary.waitForElementVisibility(driver, report);
		JavascriptLibrary.javascriptClickElement(driver, report);*/
		ActionUtils.ajaxJsClick(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, previewReportBtn);
		WebElement addedField = driver.findElement(By.xpath("//th[text()='"+fieldToSort+"']"));
		GenericLibrary.waitForElementVisibility(driver, addedField);
		Assert.assertTrue(addedField.isDisplayed(), "Sort By Group is Not Functional");
	}

	public void verify_Total_of_the_selected_field_report(String QuestionnaireName, String reportName, String fieldToDrop, String fieldToDrop2, String field1Column, String field2Column) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.scrollIntoView(driver, totalDropField);
		// Field 1
		WebElement field1 = driver.findElement(By.xpath("//div[text()='"+fieldToDrop2+"']"));
		AjaxLibrary.dragAndDrop_Method3(driver, field1, totalDropField);
		/*// Field 2
		WebElement field2 = driver.findElement(By.xpath("(//span[contains(.,'"+fieldToDrop2+"')])[1]"));
		AjaxLibrary.dragAndDrop(driver, field2, totalDropField);*/
		/*// Open report
		JavascriptLibrary.javascriptClickElement(driver, AnalyseLink);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		searchReportTextBox.sendKeys(Keys.ENTER);
		WebElement fieldTotalReport = driver.findElement(By.xpath("//a[text()='"+reportName+"']"));
		GenericLibrary.waitForElementVisibility(driver, fieldTotalReport);
		JavascriptLibrary.javascriptClickElement(driver, fieldTotalReport);
		GenericLibrary.waitForAjax(driver);
		WebElement fieldTotalText = driver.findElement(By.xpath("//a[text()='"+reportName+"']"));
		GenericLibrary.waitForElementVisibility(driver, fieldTotalText);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.scrollIntoView(driver, goToLastPageBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, goToLastPageBtn);
		GenericLibrary.waitForAjax(driver);
		((JavascriptExecutor)driver).executeScript("scroll(0, 1000)");
		GenericLibrary.waitForAjax(driver);
		// Go to last columns
		WebElement totalCell = driver.findElement(By.xpath("//tr[last()]/td["+field1Column.replace(".0", "")+"]"));
		Integer total = Integer.parseInt(totalCell.getText());
		Reporter.log("Total of the selected field is: "+total,true);
		a.assertTrue(total != 0, "Column total is NOT found");
		Reporter.log("Given column total is found", true);
		WebElement totalCel2 = driver.findElement(By.xpath("//tr[last()]/td["+field2Column.replace(".0", "")+"]"));
		Integer total2 = Integer.parseInt(totalCel2.getText());
		Reporter.log("Total of the selected field is: "+totalCel2,true);
		a.assertTrue(total2 != 0, "Column total is NOT found");*/
		//Reporter.log("Given column total is found", true);
		WebElement totalCell = driver.findElement(By.xpath("//tr[last()]/td["+field1Column.replace(".0", "")+"]"));
		Integer total = Integer.parseInt(totalCell.getText().replaceAll("£", ""));
		Reporter.log("Total of the selected field is: "+total,true);
		a.assertTrue(total != 0, "Column total is NOT found");
		Reporter.log("Given column total is found", true);
		WebElement totalCel2 = driver.findElement(By.xpath("//tr[last()]/td["+field2Column.replace(".0", "")+"]"));
		Integer total2 = Integer.parseInt(totalCel2.getText().replaceAll("£", ""));
		Reporter.log("Total of the selected field is: "+totalCel2,true);
		a.assertTrue(total2 != 0, "Column total is NOT found");
		Reporter.log("Given column total is found", true);
		a.assertAll();
	}

	public void verify_Download_report_in_CSV_and_Excel_formats(String QuestionnaireName, String reportName, String downloadPath) throws Exception {
		//SoftAssert a= new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		searchReportTextBox.sendKeys(reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("(//td[contains(text(),'"+reportName+"')])[1]")));
		/*WebElement report = driver.findElement(By.xpath("(//td[contains(text(),'"+reportName+"')])[1]"));
		GenericLibrary.waitForElementVisibility(driver, report);
		JavascriptLibrary.javascriptClickElement(driver, report);*/
		GenericLibrary.waitForAjax(driver);
		ActionUtils.hoverToElement(driver, moreDropDownBtn);
		ActionUtils.ajaxJsClick(driver, Export);
		//GenericLibrary.downoadFile(Export);
		Thread.sleep(8000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, reportName), "Excel file not downloaded");
		Reporter.log("Excel file downloaded", true);
		/*JavascriptLibrary.javascriptClickElement(driver, moreDropDownBtn);
		GenericLibrary.waitForElementVisibility(driver, Excel);
		GenericLibrary.downoadFile(Excel);
		Thread.sleep(3000);
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, ""+reportName+".xls"), "Excel file not downloaded");
		Reporter.log("Excel file downloaded", true);*/
		//a.assertAll();
	}

	public void verify_Filter_Option_for_number_field(String QuestionnaireName, String reportName, String equalsValue, String greaterThanValue, 
			String greaterThanEqualsValue, String lessThanValue, String lessThanEqualsValue, String startValue, String endValue) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);

		// Emp Fee - Before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[7]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String fee = list.get(i).getText();
			Reporter.log("Emp Fee Before Filter Action "+i+":" +fee ,true);
		}

		// Emp Fee - After
		GenericLibrary.waitForElementToBeClickable(driver, filterOption);
		JavascriptLibrary.javascriptClickElement(driver, filterOption);
		GenericLibrary.waitForElementVisibility(driver, filterDropField);
		GenericLibrary.dragAndDrop_Method3(driver, empFee, filterDropField);

		// Blank
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='Blank']"));
		a.assertTrue(driver.findElement(By.xpath("//td[text()='No matching records found']")).isDisplayed(), "Blank option is functional");
		Reporter.log("Blank option is functional", true);
		Thread.sleep(2000);

		// '=' Option
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='=']"));
		startFieldTextBox.sendKeys(equalsValue.replace(".0", ""));
		startFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> equalsList = driver.findElements(By.xpath("//tr/td[7]"));
		int count2 = equalsList.size();
		for (int i = 0; i < count2; i++) {
			if (!equalsList.get(i).getText().contains(" ")) {
				String fee = equalsList.get(i).getText();
				Reporter.log("Emp Fee given: "+equalsValue.replace(".0", "")+" after '=' option: " +fee ,true);
				a.assertEquals(equalsValue.replace(".0", ""), fee);
				Reporter.log("'=' option in filter is functional", true);
			}
		}

		// '>' Option
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, NA);
		AjaxLibrary.click(driver, NA);
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, greaterThanOption);
		greaterThanOption.click();
		GenericLibrary.waitForAjax(driver);
		startFieldTextBox.clear();
		startFieldTextBox.sendKeys(greaterThanValue.replace(".0", ""));
		startFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> greaterList = driver.findElements(By.xpath("//tr/td[7]"));
		int count3 = greaterList.size();
		for (int i = 20; i < count3; i++) {
			if (!greaterList.get(i).getText().contains(" ")) {
				String fee = greaterList.get(i).getText();
				Reporter.log("Emp Fee given: "+greaterThanValue.replace(".0", "")+" after '>' option: " +fee ,true);
				int given = Integer.parseInt(greaterThanValue.replace(".0", ""));	
				int result = Integer.parseInt(fee);	
				if (result>given) {
					Reporter.log(result + " is '>' "+given, true);
				} else {
					Reporter.log("'>' option is NOT functional", true);
					a.fail();
				}
			}
		}
		Reporter.log("'>' option in filter is functional", true);

		// '≥' Option
		ActionUtils.ajaxJsClick(driver, typeDropDown);
		ActionUtils.ajaxJsClick(driver, NA);
		ActionUtils.ajaxJsClick(driver, typeDropDown);
		ActionUtils.ajaxJsClick(driver, greaterThanEqualsOption);
		GenericLibrary.waitForAjax(driver);
		startFieldTextBox.clear();
		startFieldTextBox.sendKeys(greaterThanEqualsValue.replace(".0", ""));
		startFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> greaterEqualsList = driver.findElements(By.xpath("//tr/td[7]"));
		int count4 = greaterEqualsList.size();
		for (int i = 0; i < count4; i++) {
			if (!greaterEqualsList.get(i).getText().contains(" ")) {
				String fee = greaterEqualsList.get(i).getText();
				Reporter.log("Emp Fee given: "+greaterThanEqualsValue.replace(".0", "")+" after '>=' option: " +fee ,true);
				int given = Integer.parseInt(greaterThanEqualsValue.replace(".0", ""));	
				int result = Integer.parseInt(fee);	
				if (result >= given) {
					Reporter.log(result + " is '>=' "+given, true);
				} else {
					Reporter.log("'>=' option is NOT functional", true);
					a.fail();
				}
			}
		}
		Reporter.log("'>=' option in filter is functional", true);

		// '<' Option
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, NA);
		AjaxLibrary.click(driver, NA);
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, lessThanOption);
		lessThanOption.click();
		GenericLibrary.waitForAjax(driver);
		startFieldTextBox.clear();
		startFieldTextBox.sendKeys(lessThanValue.replace(".0", ""));
		startFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> lessThanList = driver.findElements(By.xpath("//tr/td[7]"));
		int count5 = lessThanList.size();
		for (int i = 0; i < count5; i++) {
			if (!lessThanList.get(i).getText().contains(" ")) {
				String fee = lessThanList.get(i).getText();
				Reporter.log("Emp Fee given: "+lessThanValue.replace(".0", "")+" after '<' option: " +fee ,true);
				int given = Integer.parseInt(lessThanValue.replace(".0", ""));	
				int result = Integer.parseInt(fee);	
				if (result < given) {
					Reporter.log(result + " is '<' "+given, true);
				} else {
					Reporter.log("'<' option is NOT functional", true);
					a.fail();
				}
			}
		}
		Reporter.log("'<' option in filter is functional", true);

		// '≤' Option
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, NA);
		AjaxLibrary.click(driver, NA);
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, lessThanEqualsOption);
		lessThanEqualsOption.click();
		GenericLibrary.waitForAjax(driver);
		startFieldTextBox.clear();
		startFieldTextBox.sendKeys(lessThanEqualsValue.replace(".0", ""));
		startFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		//driver.switchTo().frame(1);
		List<WebElement> lessThanEqualsList = driver.findElements(By.xpath("//tr/td[7]"));
		int count6 = lessThanEqualsList.size();
		for (int i = 0; i < count6; i++) {
			if (!lessThanEqualsList.get(i).getText().contains(" ")) {
				String fee = lessThanEqualsList.get(i).getText();
				Reporter.log("Emp Fee given: "+lessThanEqualsValue.replace(".0", "")+" after '<=' option: " +fee ,true);
				int given = Integer.parseInt(lessThanEqualsValue.replace(".0", ""));	
				int result = Integer.parseInt(fee);	
				if (result <= given) {
					Reporter.log(result + " is '<=' "+given, true);
				} else {
					Reporter.log("'<=' option is NOT functional", true);
					a.fail();
				}
			}
		}
		Reporter.log("'<=' option in filter is functional", true);
		//driver.switchTo().defaultContent();

		// Range Option
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, NA);
		AjaxLibrary.click(driver, NA);
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, rangeOption);
		rangeOption.click();
		GenericLibrary.waitForAjax(driver);
		startFieldTextBox.clear();
		startFieldTextBox.sendKeys(startValue.replace(".0", ""));
		startFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		endFieldTextBox.clear();
		endFieldTextBox.sendKeys(endValue.replace(".0", ""));
		endFieldTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		//driver.switchTo().frame(1);
		List<WebElement> rangeList = driver.findElements(By.xpath("//tr/td[7]"));
		int count7 = rangeList.size();
		for (int i = 0; i < count7; i++) {
			if (!rangeList.get(i).getText().contains(" ")) {
				String fee = rangeList.get(i).getText();
				Reporter.log("Emp Fee given Range => Start: "+startValue+" End: "+endValue+" Result: "+fee ,true);
				int given1 = Integer.parseInt(startValue.replace(".0", ""));	
				int given2 = Integer.parseInt(endValue.replace(".0", ""));
				int result = Integer.parseInt(fee);	
				if ((result >= given1) && (result <= given2)) {
					Reporter.log(result + " is in the Range of "+given1+" & "+given2, true);
				} else {
					Reporter.log("Range option is NOT functional", true);
					a.fail();
				}
			}
		}
		Reporter.log("Range option in filter is functional", true);

		/*// Max Option
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, NA);
		AjaxLibrary.click(driver, NA);
		List<WebElement> vailableList = driver.findElements(By.xpath("//tr/td[7]"));
		List<Long> numList = new ArrayList<Long>();
		for (WebElement ele : vailableList) {
			if (!ele.getText().contains(" ")) {
				numList.add(Long.parseLong(ele.getText()));
			}
		}
		Long expMax = Collections.max(numList);
		Reporter.log("Expected max value is: "+expMax, true);
		driver.switchTo().defaultContent();
		GenericLibrary.waitForElementVisibility(driver, typeDropDown);
		JavascriptLibrary.javascriptClickElement(driver, typeDropDown);
		GenericLibrary.waitForElementVisibility(driver, maxOption);
		maxOption.click();
		GenericLibrary.waitForAjax(driver);
		List<WebElement> maxList = driver.findElements(By.xpath("//tr/td[7]"));
		int maxCount = 0;
		for (WebElement ele : maxList) {
			if (Long.parseLong(ele.getText()) == expMax) {
				Reporter.log("Max value from filter is: "+ele.getText() ,true);
				maxCount = maxCount+1;
			}
		}
		a.assertEquals(maxCount, maxList.size(), "Max option is not functional");
		Reporter.log("Max option in filter is functional", true);*/
		a.assertAll();
	}

	public void verify_Filter_Option_for_Text_field(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		// EMP Address - Before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[6]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String address = list.get(i).getText();
			Reporter.log("Emp address Before Filter Action "+i+":" +address ,true);
		}
		// EMP Address - After
		JavascriptLibrary.javascriptClickElement(driver, filterOption);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, filterDropField);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='Goa']")));
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list3 = driver.findElements(By.xpath("//tr/td[6]"));
		int count3 = list3.size();
		for (int i = 0; i < count3; i++) {
			String address = list3.get(i).getText();
			Reporter.log("Emp address After Filter Action(GOA) "+i+":" +address ,true);
		}
	}

	public void verify_Filter_Option_for_Date_field(String QuestionnaireName, String reportName, String option1, String option2,
			String startYear, String startMonth, String startDate, String endYear, String endMonth, String endDate) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		createReportBtn.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		// Date - Before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[15]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String date = list.get(i).getText();
			Reporter.log("Dates Before Filter Action "+i+":" +date ,true);
		}

		// Filter - Date - required option
		GenericLibrary.waitForElementToBeClickable(driver, filterOption);
		JavascriptLibrary.javascriptClickElement(driver, filterOption);
		GenericLibrary.waitForElementVisibility(driver, filterDropField);
		GenericLibrary.dragAndDrop_Method3(driver, joiningDate, filterDropField);
		/*JavascriptLibrary.javascriptClickElement(driver, selectDateOption);*/
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='Last Twelve Months']")));
		List<WebElement> dateList = driver.findElements(By.xpath("//tr/td[15]"));
		int count2 = dateList.size();
		for (int i = 0; i < count2; i++) {
			String date = dateList.get(i).getText();
			Reporter.log("Dates After Filter Action "+i+":" +date ,true);
		}

		// Filter - Date - Exact period
		/*//JavascriptLibrary.javascriptClickElement(driver, selectDateOption);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='Exact Period']")));

		// start date
		driver.findElement(By.xpath("//input[contains(@id,'_txtCondition_Start')]"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//th[contains(@title,'Select Month')]")).click();
		driver.findElement(By.xpath("//th[contains(@title,'Select Year')]")).click();
		List<WebElement> yearsList = driver.findElements(By.cssSelector(".year"));
		for (WebElement ele : yearsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(startYear.replace(".0", ""))) {
				ele.click();
				break;
			}
		}
		List<WebElement> monthsList = driver.findElements(By.cssSelector(".month"));
		for (WebElement ele : monthsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(startMonth)) {
				ele.click();
				break;
			}
		}
		List<WebElement> dayList = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(startDate.replace(".0", ""))) {
				ele.click();
				break;
			}
		}
		Thread.sleep(1000);
		// End date
		driver.findElement(By.xpath("//input[contains(@id,'_txtCondition_End')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//th[contains(@title,'Select Month')]")).click();
		driver.findElement(By.xpath("//th[contains(@title,'Select Year')]")).click();
		List<WebElement> yearsList1 = driver.findElements(By.cssSelector(".year"));
		for (WebElement ele : yearsList1) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(endYear.replace(".0", ""))) {
				ele.click();
				break;
			}
		}
		List<WebElement> monthsList1 = driver.findElements(By.cssSelector(".month"));
		for (WebElement ele : monthsList1) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(endMonth)) {
				ele.click();
				break;
			}
		}
		List<WebElement> dayList1 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList1) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(endDate.replace(".0", ""))) {
				ele.click();
				break;
			}
		}
		List<WebElement> periodDatesList = driver.findElements(By.xpath("//tr/td[15]"));
		for (WebElement ele : periodDatesList) {
			String date = ele.getText();
			Reporter.log("Dates After selecting duration from Filter Action: " +date ,true);
		}*/
	}

	public void verify_Share_Report_option(String QuestionnaireName, String reportName, String user) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, shareOption);
		JavascriptLibrary.javascriptClickElement(driver, shareOption);
		GenericLibrary.waitForAjax(driver);
		shareSearchBox.sendKeys(user);
		GenericLibrary.click(driver, shareSearchBtn);
		try {
			JavascriptLibrary.javascriptClickElement(driver, shareToUser);
			GenericLibrary.waitForAjax(driver);
			WebElement addedUser = driver.findElement(By.xpath("//span[text()='People Added']//following::span[contains(.,'Test User 3')]"));
			Assert.assertTrue(addedUser.isDisplayed(), "User not Added");
			Reporter.log("User Added Successfully", true);
			// Verify shared report
			ActionUtils.hoverToElement(driver, userDropDown);
			ActionUtils.ajaxJsClick(driver, myAccount);
			ActionUtils.ajaxJsClick(driver, loginAs);
			ActionUtils.ajaxJsType(driver, loginuserSearchbox, user);
			ActionUtils.getElement(driver, loginuserSearchbox).sendKeys(Keys.ENTER);
			ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+user+"']"));
			ActionUtils.ajaxJsClick(driver, reLoginBtn);
			ActionUtils.ajaxJsClick(driver, menuBtn);
			ActionUtils.ajaxJsClick(driver, iQaptureApp);
			AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseLink);
			searchReportTextBox.sendKeys(reportName);
			JavascriptLibrary.javascriptClickElement(driver, searchReportBtn);
			GenericLibrary.waitForAjax(driver);
			WebElement report = driver.findElement(By.xpath("//td[text()='"+reportName+"']"));
			Assert.assertTrue(report.isDisplayed(), "Report Not Created Successfully");
		} catch (NoSuchElementException e) {
			Assert.assertTrue(noRecordsFound.isDisplayed(),"'No records found' not displayed");
			Reporter.log("User Not Found", true);
		} catch (AssertionError e) {
			Assert.assertTrue(false, "User not Added");
		}
	}

	public void verify_Summary_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		ActionUtils.ajaxJsType(driver, analysesSearchBox, QuestionnaireName);
		ActionUtils.ajaxJsClick(driver, searchQuestionnaireBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.ajaxJsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveBtn);
		ActionUtils.ajaxJsClick(driver, summaryDesign);
		Thread.sleep(2000);
		/*GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, summaryDesign);
		JavascriptLibrary.javascriptClickElement(driver, summaryDesign);*/
		/*GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, summary_Y);
		GenericLibrary.dragAndDrop_Method3(driver, RecordID, summary_Y);*/
		ActionUtils.ajaxDragAndDrop_Method3(driver, RecordID, summary_Y);
		Thread.sleep(2000);
		/*GenericLibrary.waitForElementVisibility(driver, summary_X);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, summary_X);
		GenericLibrary.waitForAjax(driver);*/
		ActionUtils.ajaxDragAndDrop_Method3(driver, empAddress, summary_X);
		Thread.sleep(2000);
		/*GenericLibrary.waitForElementVisibility(driver, summary_Z);
		GenericLibrary.dragAndDrop_Method3(driver, empFormFee, summary_Z);
		GenericLibrary.waitForAjax(driver);*/
		ActionUtils.ajaxDragAndDrop_Method3(driver, empFormFee, summary_Z);
		Thread.sleep(1000);
		GenericLibrary.waitForElementVisibility(driver, summaryDesignResultTable);
		Assert.assertTrue(summaryDesignResultTable.isDisplayed(),"Table NOT created");
	}

	public void verify_BarChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, barChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, barChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bar_Y);
		GenericLibrary.dragAndDrop_Method3(driver, empFormFee, bar_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bar_X);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, bar_X);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, xColumns);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='5']")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, x2);
		GenericLibrary.click(driver, x2);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bar_X2);
		GenericLibrary.dragAndDrop(driver, RecordID, bar_X2);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClickClearAndType(driver, targetTextBox, "100");
		targetTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, reportTotalOFF);
		JavascriptLibrary.javascriptClickElement(driver, columnTotalOFF);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "EMP Address");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);
		/*GenericLibrary.waitForElementToBeClickable(driver, colorField);
		colorField.click();
		List<WebElement> colorList = driver.findElements(By.xpath("//tr/td"));
		for (WebElement ele : colorList) {
			String text = ele.getAttribute("title");
			if(text.contains("#ffff00")) {
				ele.click();
				break;
			}
		}*/

		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Bangalore");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.click(driver, layoutType);
		GenericLibrary.click(driver, layoutCustom);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(layoutSelectDD, "EMP Address");
		GenericLibrary.waitForElementToBeClickable(driver, addLayoutCondition);
		AjaxLibrary.jsClick(driver, addLayoutCondition);
		AjaxLibrary.jsClick(driver, negativeValueGraphBtn);
		GenericLibrary.waitForAjax(driver);
		LayoutnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, By.xpath("(//span[@class='text'][contains(.,'Bangalore')])[2]"));
		/*ActionUtils.ajaxJsClick(driver, LayoutSearchBox);
		ActionUtils.ajaxJsType(driver, LayoutSearchBox, "Bangalore"+Keys.TAB);*/
		ActionUtils.waitForAjax(driver);
	}

	public void verify_LineChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, lineChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, lineChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, line_Y);
		GenericLibrary.dragAndDrop_Method3(driver, empFormFee, line_Y);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, y2);
		GenericLibrary.dragAndDrop_Method3(driver, RecordID, line_Y2);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, line_X);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, xColumns);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='5']")));
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClickClearAndType(driver, LineTargettextBox, "50");
		LineTargettextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, reportTotalOFF);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "EMP Address");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Bangalore");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.click(driver, layoutType);
		GenericLibrary.click(driver, layoutCustom);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(layoutSelectDD, "EMP Address");
		GenericLibrary.waitForElementToBeClickable(driver, addLayoutCondition);
		AjaxLibrary.jsClick(driver, addLayoutCondition);
		AjaxLibrary.jsClick(driver, negativeValueGraphBtn);
		GenericLibrary.waitForAjax(driver);
		LayoutnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, By.xpath("(//span[@class='text'][contains(.,'Bangalore')])[2]"));
		/*ActionUtils.ajaxJsClick(driver, LayoutSearchBox);
		ActionUtils.ajaxJsType(driver, LayoutSearchBox, "Bangalore"+Keys.TAB);*/
		ActionUtils.waitForAjax(driver);
	}

	public void verify_PieChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, pieChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, pieChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, pie_X);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, pie_X);
		

		/*GenericLibrary.waitForElementVisibility(driver, xColumns);
		GenericLibrary.click(driver, xColumns);
		GenericLibrary.click(driver, colValue);*/
		GenericLibrary.waitForAjax(driver);
		/*GenericLibrary.waitForElementVisibility(driver, Piex2);
		GenericLibrary.click(driver, Piex2);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, pie_X2);
		GenericLibrary.dragAndDrop_Method3(driver, joiningDate, pie_X2);
		GenericLibrary.waitForAjax(driver);*/
		GenericLibrary.click(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reportTotalOFF);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, FormatingType);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.waitForElementVisibility(driver, conditional);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "EMP Address");
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, colorField);
		colorField.click();
		GenericLibrary.waitForAjax(driver);
		/*List<WebElement> colorList = driver.findElements(By.xpath("//tr/td"));
		for (WebElement ele : colorList) {
			String text = ele.getAttribute("title");
			if(text.contains("#ffff00")) {
				ele.click();
				break;
			}
		}*/
		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='dropdown-menu open'])[7]//ul//li"));
		for (WebElement ele : list) {
			String text = ele.getAttribute("innerHTML");
			if(text.contentEquals("Bangalore")) {
				ele.click();
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);
		
	}

	public void verify_ScatterChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, scatterChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, scatterChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, scatter_yAxis);
		GenericLibrary.dragAndDrop(driver, empFormFee, scatter_yAxis);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, scatter_xAxis);
		GenericLibrary.dragAndDrop(driver, empNo, scatter_xAxis);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_WaterFallChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, waterFallChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, waterFallChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, waterFall_Y);
		GenericLibrary.dragAndDrop_Method3(driver, empName, waterFall_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, waterFall_X);
		GenericLibrary.dragAndDrop_Method3(driver, empAddress, waterFall_X);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, xColumns);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='5']")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, WATERFALLtargetTextBox);
		WATERFALLtargetTextBox.sendKeys("20");
		WATERFALLtargetTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reportTotalOFF);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "EMP Address");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Bangalore");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);
		
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_BoxPlotChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, boxPlotChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, boxPlotChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, boxPlot_Y);
		GenericLibrary.dragAndDrop(driver, empName, boxPlot_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, boxPlot_X);
		GenericLibrary.dragAndDrop(driver, empAddress, boxPlot_X);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(xColumns, "12");
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, targetTextBox);
		targetTextBox.sendKeys("20");
		targetTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_RoseChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, roseChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, roseChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, rose_Y);
		GenericLibrary.dragAndDrop(driver, empFormFee, rose_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, rose_X);
		GenericLibrary.dragAndDrop(driver, empAddress, rose_X);
		GenericLibrary.waitForAjax(driver);
		x2.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, rose_X2);
		GenericLibrary.dragAndDrop(driver, RecordID, rose_X2);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reportTotalOFF);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_SpiderChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, spiderChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, spiderChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, spider_Y);
		GenericLibrary.dragAndDrop(driver, empFormFee, spider_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, spider_X);
		GenericLibrary.dragAndDrop(driver, empAddress, spider_X);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(xColumns, "12");
		GenericLibrary.waitForAjax(driver);
		x2.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, spider_X2);
		GenericLibrary.dragAndDrop(driver, RecordID, spider_X2);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reportTotalOFF);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_BubbleChart_Design_Report(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, bubbleChartDesign);
		JavascriptLibrary.javascriptClickElement(driver, bubbleChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bubble_Y);
		GenericLibrary.dragAndDrop(driver, empFormFee, bubble_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bubble_X);
		GenericLibrary.dragAndDrop(driver, empAddress, bubble_X);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bubble_Z);
		GenericLibrary.dragAndDrop(driver, RecordID, bubble_Z);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Create_Publish_Report(String QuestionnaireName, String reportName, String filePath) throws Exception {
		SoftAssert a=new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, publishReportOption);
		JavascriptLibrary.javascriptClickElement(driver, publishReportOption);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, empNo);
		JavascriptLibrary.javascriptClickElement(driver, empNo);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, copiedEmpNoField);
		a.assertTrue(copiedEmpNoField.isDisplayed(), "Field Not Copied to ClipBoard");
		Reporter.log("Emp No. Filed copied to ClipBoard successfully", true);
		JavascriptLibrary.javascriptClickElement(driver, empName);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, copiedEmpNameField);
		a.assertTrue(copiedEmpNameField.isDisplayed(), "Field Not Copied to ClipBoard");
		Reporter.log("Emp Name Filed copied to ClipBoard successfully", true);
		JavascriptLibrary.javascriptClickElement(driver, empAddress);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, copiedEmpAddressField);
		a.assertTrue(copiedEmpAddressField.isDisplayed(), "Field Not Copied to ClipBoard");
		Reporter.log("Emp Address Filed copied to ClipBoard successfully", true);
		ActionUtils.uploadFile(driver, reportDropZone, filePath);
		ActionUtils.waitForAjax(driver);
		a.assertTrue(uploadedPublishReport.isDisplayed(),"Template not uploaded");
		Reporter.log("Publish report template uploaded",true);
		a.assertAll();
	}

	public void verify_View_and_Download_published_report(String QuestionnaireName, String createdReportName, String downloadPath, String fileName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(createdReportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("(//td[text()='"+createdReportName+"'])[1]"));
		GenericLibrary.waitForElementVisibility(driver, report);
		report.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, publishReport_record_1);
		Reporter.log("All records are visible", true);
		JavascriptLibrary.javascriptClickElement(driver, publishReport_record_1);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "publishReport_record not exported");
		Reporter.log("Record downloaded successfully", true);
		Thread.sleep(2000);
	}

	public void verify_View_published_report_without_template(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, publishReportOption);
		JavascriptLibrary.javascriptClickElement(driver, publishReportOption);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']")).click();
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("//td[text()='"+reportName+"']"));
		GenericLibrary.waitForElementVisibility(driver, report);
		report.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, publishReport_record_1);
		JavascriptLibrary.javascriptClickElement(driver, publishReport_record_1);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(pleaseUploadTemplateErrorMsg.isDisplayed(), "Error message not displayed");
		Reporter.log("Please upload template error message is displayed successfully", true);
	}


	public void verify_Upload_report_without_tags_and_view_the_publish_report_and_verify_error_msg
	(String QuestionnaireName, String reportName, String filePath) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, publishReportOption);
		JavascriptLibrary.javascriptClickElement(driver, publishReportOption);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.uploadFile(reportDropZone, filePath);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']")).click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("//td[text()='"+reportName+"']"));
		GenericLibrary.waitForElementVisibility(driver, report);
		report.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, publishReport_record_1);
		JavascriptLibrary.javascriptClickElement(driver, publishReport_record_1		);

		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs.get(1));

		GenericLibrary.waitForElementVisibility(driver, fieldDescriptionTagsMissingErrorMsg);
		Assert.assertTrue(fieldDescriptionTagsMissingErrorMsg.isDisplayed(), "Error message not displayed");
		Reporter.log("'Field description tag is not found in the template.' error message is displayed successfully", true);
	}

	public void verify_Filter_by_record_status_field(String QuestionnaireName, String reportName, String option, String option2) throws Exception {
		SoftAssert a = new SoftAssert();
		// Complete some records in capture
		AjaxLibrary.jsClick(driver, captureLink);
		Wrappers.jsType(driver, captureSearchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, captureSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']")));
		for (int i = 1; i <= 5; i++) {
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//td[1]//span[1])["+i+"]")));
			AjaxLibrary.jsClick(driver, captureCompleteBtn);
		}
		// Goto analyse
		AjaxLibrary.jsClick(driver, AnalyseLink);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		// Filter by record status
		// Record status before filter
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String status = list.get(i).getText();
			Reporter.log("Record status Before Filter Action "+i+":" +status ,true);
		}
		// Record status after filter - Live
		JavascriptLibrary.javascriptClickElement(driver, filterOption);
		GenericLibrary.dragAndDrop_Method3(driver, recordStatusField, filterDropField);
		//GenericLibrary.selectElementByVisibleText(selectRecordStatusDD, option);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='Completed']"));
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list2 = driver.findElements(By.xpath("//tr/td[1]"));
		int count2 = list2.size();
		for (int i = 0; i < count2; i++) {
			String status = list2.get(i).getText();
			a.assertEquals(status, option, "Filter is not working for the given option");
			Reporter.log("Record status after filter action("+option+") "+i+":" +status ,true);
		}
		// Record status after filter - Live, Completed
		GenericLibrary.selectElementByVisibleText(selectRecordStatusDD, option2);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list3 = driver.findElements(By.xpath("//tr/td[1]"));
		int count3 = list3.size();
		for (int i = 0; i < count3; i++) {
			String status = list3.get(i).getText();
			a.assertTrue(status.equalsIgnoreCase(option)||status.equalsIgnoreCase(option2), "Filter is not working for the given option");
			Reporter.log("Record status after filter action("+option+","+option2+") "+i+":" +status ,true);
		}
	}

	public void verify_Open_captured_record_through_record_ID(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement questionnaire = driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']"));
		GenericLibrary.waitForElementVisibility(driver, questionnaire);
		questionnaire.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, selectedQuestionnaire);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		// Open captured record through record ID
		driver.findElement(By.xpath("//a[text()=13]")).click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.switchToNewWindow_new(driver);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+QuestionnaireName+"')]")).isDisplayed(), "Captured record NOT opened");
		Reporter.log("Captured record opened successfully", true);
	}

	public void verify_Deleted_and_trashed_records_deletion_in_analyse(String QuestionnaireName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']")));
		GenericLibrary.waitForElementVisibility(driver, selectedQuestionnaire);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, previewReportBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//button[contains(@data-toggle,'dropdown')]"));
		ActionUtils.ajaxJsClick(driver, By.xpath("//a[text()='25']"));
		// No of records before deletion
		List<WebElement> idList = driver.findElements(recordIds);
		int count1 = idList.size();
		Reporter.log("No.of records before delete/trash can action: "+ count1, true);
		// Delete records in capture
		AjaxLibrary.jsClick(driver, captureLink);
		Wrappers.jsType(driver, captureSearchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, captureSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']")));
		AjaxLibrary.jsClick(driver, captureRecord1);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		Wrappers.jsClick(driver, captureDeleteRecordBtn);
		GenericLibrary.waitForAlertPresent(driver);
		AjaxLibrary.checkAlert_Accept(driver);
		int recordCount = Integer.parseInt(Wrappers.readText(driver, noOfRecordsAtCapture));
		Reporter.log("No.of records at capture after deletion: "+recordCount, true);
		// Verify the no.of records at analyse
		AjaxLibrary.jsClick(driver, AnalyseLink);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+QuestionnaireName+"']")));
		GenericLibrary.waitForElementVisibility(driver, selectedQuestionnaire);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		JavascriptLibrary.javascriptClickElement(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement report = driver.findElement(By.xpath("//td[text()='"+reportName+"']"));
		GenericLibrary.click(driver, report);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> idList2 = driver.findElements(recordIds);
		int count2 = idList2.size();
		Reporter.log("No.of records after delete/trash can action: "+ count2, true);
		Assert.assertNotEquals(count1, count2, "Deleted records data still displaying at analyse");
		Reporter.log("Deleted records data deleted from analyse", true);
	}

}


