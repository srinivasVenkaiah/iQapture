package com.pages;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import org.apache.commons.codec.language.Nysiis;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
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

public class AuditAnalysePage extends BasePage{
	// Initializing the Page Objects:...
	public AuditAnalysePage() {
		PageFactory.initElements(driver, this);
	}

	//Object Repository
	@FindBy(xpath="//*[@id='txtSearch_audit']")
	WebElement analysesSearchBox;

	// verify Audit selection 
	@FindBy(xpath="(//i[@class='fa fa-search'])[3]")
	WebElement searchAuditBtn;

	@FindBy(xpath="//span[contains(@id,'spanAuditName')]")
	WebElement selectedAudit;

	@FindBy(xpath="//a[@id='btnNewAuditReport']")
	WebElement createReportBtn;

	// Create report 
	@FindBy(xpath=".//*[@id='REPORTNAME']")
	WebElement reportNameTextBox;

	@FindBy(xpath="//a[@id='btnPageBack']")
	WebElement backBtn;

	@FindBy(xpath="//a[@title='Save Report']")
	WebElement saveBtn;

	@FindBy(xpath="//input[@id='txtSearchForAuditReport']")
	WebElement searchReportTextBox;

	@FindBy(xpath="(//i[@class='fa fa-search'])[4]")
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

	@FindBy(xpath="(//div[@closeid='title0'])[1]")
	WebElement column0Header;

	@FindBy(xpath="(//div[@closeid='title1'])[1]")
	WebElement column1Header;

	@FindBy(xpath="//tr[@data-index='0']//td[2]")
	WebElement cellDataForColumn1;

	@FindBy(xpath="(//tr[@data-index='0']//td[1])[1]")
	WebElement cellDataForColumn0;


	@FindBy(xpath="(//div[@closeid='title2'])[1]")
	WebElement column2Header;

	@FindBy(xpath="(//div[@closeid='title3'])[1]")
	WebElement column3Header;

	@FindBy(xpath="(//div[@closeid='title12'])[1]")
	WebElement column12Header;

	@FindBy(xpath="//tr[@data-index='0']//td[4]")
	WebElement cellDataForColumn3;

	@FindBy(xpath="(//div[@closeid='title4'])[1]")
	WebElement column5Header;

	@FindBy(xpath="//tr[@data-index='0']//td[3]")
	WebElement cellDataForColumn2;

	// Delete columns
	@FindBy(xpath="(//i[@name='titclose'])[4]")
	WebElement deleteColumnBtn;

	// Add all and Remove all fields
	@FindBy(xpath="//button[text()='Remove all']")
	WebElement removeAllBtn;

	// Add selected fields to report
	@FindBy(xpath="//div[contains(@id,'divFieldDrop')]")
	WebElement dropField;

	@FindBy(xpath="//div[text()='Author of Audit']")
	WebElement authorofAudit;

	@FindBy(xpath="//div[text()='Q1']")
	WebElement Q1;
	
	@FindBy(xpath="(//i[@class='fa fa-plus'])[2]")
	WebElement Q1plus;

	@FindBy(xpath="(//div[text()='Q1']//following::div[text()='Comments'])[1]")
	WebElement comment1stQ1;

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
	@FindBy(xpath="//div[text()='RecordID']")
	WebElement RecordId;

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
	@FindBy(xpath="(//div[contains(text(),'Date Created')])[1]")
	WebElement createdDate;

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

	@FindBy(xpath="//button[@data-id='settingFilter']")
	WebElement settingsFilter;
	
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

	@FindBy(xpath="//div[contains(@id,'X')][contains(.,'drop field to here add x axis.')]")
	WebElement pie_X;

	
	@FindBy(xpath="//div[@id='portlet_x2']//div[@id='divDragHint_X2']")
	WebElement pie_X2;

	@FindBy(xpath="//div[@id='divDragHint_Y']")
	WebElement pie_Y;


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
	By captureAudit = By.xpath("//a[text()='Audits ']");
	By captureSearchBox = By.xpath("//*[@id='txtSearch_audit']");
	By captureSearchBtn = By.xpath("(//i[@class='fa fa-search'])[2]");
	By captureRecord1 = By.xpath("(//div[@id='divList']//span[1])[1]");
	By captureDeleteRecordBtn = By.xpath("//a[@title='Delete']");
	By noOfRecordsAtCapture = By.xpath("//li//span[4]");
	By captureCompleteBtn = By.xpath("//a[@title='Complete Record']");


	//Re-Login
	By userDropDown = By.xpath("//i[@class='fa fa-angle-down']");
	By myAccount = By.xpath("//a[contains(.,'myAccount')]");
	By loginAs = By.xpath("//span[@class='title'][contains(.,'Log in as')]");
	By loginuserSearchbox = By.xpath("//input[@id='txtUserSearch']");
	By reLoginBtn = By.xpath("//button[contains(.,'Re Login')]");

	By menuBtn = By.xpath("//i[contains(@class,'fa vc-th')]");
	By iQaptureApp = By.xpath("(//span[text()='iQapture'])[1]");



	// Actions:......................................................................................

	public void verify_AuditAnalysePage() throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		Assert.assertTrue(analysesSearchBox.isDisplayed(), "Unable to Navigate Audit Analyse Page");
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(2000);
	}

	public void verify_Audit_selection(String AuditName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, audit);
		audit.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, selectedAudit);
		Assert.assertTrue(selectedAudit.isDisplayed(),"Audit Selected Successfully");
		Reporter.log("Audit selected successfully",true);
		Assert.assertTrue(createReportBtn.isDisplayed(), "Create report button is not displaying");
		Reporter.log("Create report button is displayed",true);
	}

	public void verify_Create_report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, selectedAudit);
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
		a.assertTrue(column3Header.isDisplayed(), "Table NOT visible after report copy");
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
		JavascriptLibrary.javascriptType(driver, searchReportTextBox, createdReportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//tr[@class='no-records-found']")).isDisplayed(), "Record not deleted");
		Reporter.log("Record deleted",true);
	}

	public void verify_Swaping_columns(String AuditName, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addAllBtn);
		Thread.sleep(1000);
		String ch1 = driver.findElement(By.xpath("(//div[@closeid='title0'])[1]")).getText();
		Thread.sleep(2000);
		String ch2 = driver.findElement(By.xpath("(//div[@closeid='title1'])[1]")).getText();
		String ch1c1 = ActionUtils.readText(driver, cellDataForColumn0);
		String ch2c2 = ActionUtils.readText(driver, cellDataForColumn1);
		Reporter.log("Before action: Column1 - "+ch1+" & Column2 - "+ch2+"", true);
		Reporter.log("Before action: Column1 Cell1 Data - "+ch1c1+" & Column2 Cell1 Data - "+ch2c2+"", true);
		Thread.sleep(2000);
		ActionUtils.dragAndDrop(driver, column1Header, column0Header);
		Thread.sleep(5000);
		String ch1a = ActionUtils.readText(driver, column0Header);
		String ch2a = ActionUtils.readText(driver, column1Header);
		String ch1c1a = ActionUtils.readText(driver, cellDataForColumn0);
		String ch2c2a = ActionUtils.readText(driver, cellDataForColumn1);
		Thread.sleep(3000);
		Reporter.log("After action: Column1 - "+ch1a+" & Column2 - "+ch2a+"", true);
		Reporter.log("After action: Column1 Cell1 Data - "+ch1c1a+" & Column2 Cell1 Data - "+ch2c2a+"", true);
		Thread.sleep(3000);
		a.assertTrue(ch1.equals(ch2a) && ch2.equals(ch1a), "Columns headers not swapped");
		Reporter.log("Column headers swapped successfully", true);
		Thread.sleep(1000);
		a.assertTrue(ch1c1.equals(ch2c2a) && ch2c2.equals(ch1c1a), "Columns data not swapped");
		Reporter.log("Column data swapped successfully", true);
		a.assertAll();
	}

	public void verify_Delete_columns(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.waitForElementToBeClickable(driver, column2Header);
		JavascriptLibrary.javascriptClickElement(driver, column2Header);
		GenericLibrary.waitForAjax(driver);
		String headerName = column2Header.getText();
		GenericLibrary.waitForElementToBeClickable(driver, deleteColumnBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteColumnBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		GenericLibrary.waitForAjax(driver);
		
		boolean tableHeaderName = true;
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='fixed-table-header']//table//thead//tr//th"));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.equalsIgnoreCase(headerName)) {
				tableHeaderName = false;
			}
		}
		Assert.assertTrue(tableHeaderName, "Column not deleted");
		Reporter.log("Column deleted", true);
		
	
	}

	public void verify_Add_all_columns_Remove_all_columns(String AuditName, String reportName, String columnName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		ActionUtils.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, removeAllBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, addAllBtn);
		ActionUtils.waitForAjax(driver);
		Assert.assertTrue(column3Header.isDisplayed(), "Columns not added");
		Reporter.log("All columns added successfully",true);
		GenericLibrary.waitForElementToBeClickable(driver, removeAllBtn);
		JavascriptLibrary.javascriptClickElement(driver, removeAllBtn);
		GenericLibrary.waitForElementVisibility(driver, yesBtn);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='No matching records found']")).isDisplayed(), "All columns not removed");
		Reporter.log("All columns Removed",true);
		a.assertAll();
	}

	public void verify_Adding_selected_fileds_to_report(String AuditName, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop_Method3(driver, authorofAudit, dropField);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, Q1, dropField);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, Q1plus);
		JavascriptLibrary.javascriptClickElement(driver, Q1plus);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, comment1stQ1, dropField);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(ActionUtils.getElement(driver, 
				By.xpath("//div[@class='fixed-table-header']//table//thead//tr//th//div//div[text()=' Author of Audit ']")).isDisplayed(), 
				"Author column not added");
		Reporter.log("Author column added",true);
		
		a.assertTrue(ActionUtils.getElement(driver, 
				By.xpath("//div[@class='fixed-table-header']//table//thead//tr//th//div//div[text()=' Q1 ']")).isDisplayed(), 
				"Q1 column not added");
		Reporter.log("Q1 column added",true);
		
		a.assertTrue(ActionUtils.getElement(driver, 
				By.xpath("//div[@class='fixed-table-header']//table//thead//tr//th//div//div[text()=' Comments ']")).isDisplayed(), 
				"Comments column not added");
		Reporter.log("Comments column added",true);
		
		a.assertAll();
	}

	public void verify_Drop_sort_field_Ascending_and_Descending_Order(String AuditName, String reportName, String field1Column, String fieldToSort, String fieldToSort2, String field2Column) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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

	public void verify_Sort_by_Group_report(String AuditName, String reportName, String fieldToSort) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		WebElement field = driver.findElement(By.xpath("//div[text()='"+fieldToSort+"']"));
		GenericLibrary.dragAndDrop_Method3(driver, field, sortByGroupField);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, previewReportBtn);
		Thread.sleep(1000);
		String externalVal = ActionUtils.readText(driver, By.xpath("//div[text()='External']//following::table[@id='tbList_0']//tbody//tr//td[3]"));
		String expectedVal = "External";
		a.assertEquals(externalVal, expectedVal,"Group sort is not functional");
		Reporter.log("Group sort is functional");
		String internalVal = ActionUtils.readText(driver, By.xpath("//div[text()='Internal']//following::table[@id='tbList_1']//tbody//tr//td[3]"));
		String interexpectedVal = "Internal";
		a.assertEquals(internalVal, interexpectedVal,"Group sort is not functional");
		Reporter.log("Group sort is functional");
		a.assertAll();
	}
	
	

	public void verify_Total_of_the_selected_field_report(String AuditName, String reportName, String fieldToDrop, String fieldToDrop2, String field1Column, String field2Column) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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

	public void verify_Download_report_in_CSV_and_Excel_formats(String AuditName, String reportName, String downloadPath) throws Exception {
		//SoftAssert a= new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
		GenericLibrary.waitForAjax(driver);
		searchReportTextBox.sendKeys(reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("(//td[contains(text(),'"+reportName+"')])[1]")));
		GenericLibrary.waitForAjax(driver);
		ActionUtils.hoverToElement(driver, moreDropDownBtn);
		ActionUtils.ajaxJsClick(driver, Export);
		Thread.sleep(8000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, reportName), "Excel file not downloaded");
		Reporter.log("Excel file downloaded", true);
	}

	public void verify_Filter_Option_for_Text_field(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		// Record Status - Before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[8]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String address = list.get(i).getText();
			Reporter.log("Q1 Before Filter Action "+i+":" +address ,true);
		}
		// Record Status - After
		JavascriptLibrary.javascriptClickElement(driver, filterOption);
		GenericLibrary.dragAndDrop_Method3(driver, Q1, filterDropField);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='Conforming']")));
		GenericLibrary.waitForAjax(driver);
		List<WebElement> list3 = driver.findElements(By.xpath("//tr/td[8]"));
		int count3 = list3.size();
		for (int i = 0; i < count3; i++) {
			String address = list3.get(i).getText();
			Reporter.log("Q1 After Filter Action(Conforming) "+i+":" +address ,true);
		}
	}

	public void verify_Filter_Option_for_Date_field(String AuditName, String reportName, String option1, String option2,
			String startYear, String startMonth, String startDate, String endYear, String endMonth, String endDate) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[5]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String date = list.get(i).getText();
			Reporter.log("Dates Before Filter Action "+i+":" +date ,true);
		}

		// Filter - Date - required option
		GenericLibrary.waitForElementToBeClickable(driver, filterOption);
		JavascriptLibrary.javascriptClickElement(driver, filterOption);
		GenericLibrary.waitForElementVisibility(driver, filterDropField);
		GenericLibrary.dragAndDrop_Method3(driver, createdDate, filterDropField);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='<=This Week']")));
		List<WebElement> dateList = driver.findElements(By.xpath("//tr/td[5]"));
		int count2 = dateList.size();
		for (int i = 0; i < count2; i++) {
			String date = dateList.get(i).getText();
			Reporter.log("Dates After Filter Action "+i+":" +date ,true);
		}

		// Select Next Year
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@class='filter-option pull-left']"));
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='Next Year']")));
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='No matching records found']")).isDisplayed(), "Record displayed");
		Reporter.log("No matchiing found",true);
	}

	public void verify_Share_Report_option(String AuditName, String reportName, String user) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
			WebElement addedUser = driver.findElement(By.xpath("//span[text()='People Added']//following::span[contains(.,'Test User 1')]"));
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
			AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseAuditLink);
			Thread.sleep(1000);
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


	public void verify_BarChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop_Method3(driver, RecordId, bar_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bar_X);
		GenericLibrary.dragAndDrop_Method3(driver, Q1, bar_X);
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
		
		//ActionUtils.ajaxJsClick(driver, settingsFilter);
		ActionUtils.ajaxJsClickClearAndType(driver, targetTextBox, "5");
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
		GenericLibrary.selectElementByVisibleText(formatingField, "Q1");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Conforming");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.click(driver, layoutType);
		GenericLibrary.click(driver, layoutCustom);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(layoutSelectDD, "Q1");
		GenericLibrary.waitForElementToBeClickable(driver, addLayoutCondition);
		AjaxLibrary.jsClick(driver, addLayoutCondition);
		//AjaxLibrary.jsClick(driver, negativeValueGraphBtn);
		GenericLibrary.waitForAjax(driver);
		LayoutnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, By.xpath("(//span[@class='text'][contains(.,'Conforming')])[1]"));
		ActionUtils.waitForAjax(driver);
	}

	
	public void verify_LineChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop_Method3(driver, RecordId, line_Y);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, y2);
		GenericLibrary.dragAndDrop_Method3(driver, RecordID, line_Y2);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.dragAndDrop_Method3(driver, Q1, line_X);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, xColumns);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='5']")));
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClickClearAndType(driver, LineTargettextBox, "5");
		LineTargettextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, reportTotalOFF);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "Q1");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Conforming");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.click(driver, layoutType);
		GenericLibrary.click(driver, layoutCustom);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(layoutSelectDD, "Q1");
		GenericLibrary.waitForElementToBeClickable(driver, addLayoutCondition);
		AjaxLibrary.jsClick(driver, addLayoutCondition);
		//AjaxLibrary.jsClick(driver, negativeValueGraphBtn);
		GenericLibrary.scrollBottom(driver);
		GenericLibrary.waitForAjax(driver);
		LayoutnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, By.xpath("(//span[@class='text'][contains(.,'Conforming')])[1]"));
		ActionUtils.waitForAjax(driver);
	}

	public void verify_PieChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, createReportBtn);
		JavascriptLibrary.javascriptClickElement(driver, createReportBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, reportNameTextBox);
		JavascriptLibrary.javascriptType(driver, reportNameTextBox, reportName);
		JavascriptLibrary.javascriptClickElement(driver,  saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementToBeClickable(driver, pieChartDesign);
		GenericLibrary.click(driver, pieChartDesign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, RecordId);
		GenericLibrary.dragAndDrop_Method3(driver, Q1, pie_X);
		//GenericLibrary.waitForElementVisibility(driver, pie_Y);
		GenericLibrary.dragAndDrop_Method3(driver, RecordId, pie_Y);
		//GenericLibrary.waitForElementVisibility(driver, pie_X);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, x2);
		GenericLibrary.click(driver, x2);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, pie_X2);
		GenericLibrary.dragAndDrop(driver, createdDate, pie_X2);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reportTotalOFF);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, FormatingType);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "Q1");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Conforming");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_ScatterChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop(driver, RecordId, scatter_yAxis);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, scatter_xAxis);
		GenericLibrary.dragAndDrop(driver, Q1, scatter_xAxis);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_WaterFallChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop_Method3(driver, RecordId, waterFall_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, waterFall_X);
		GenericLibrary.dragAndDrop_Method3(driver, Q1, waterFall_X);
		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, xColumns);
		ActionUtils.ajaxJsClick(driver, driver.findElement(By.xpath("//span[text()='5']")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, WATERFALLtargetTextBox);
		WATERFALLtargetTextBox.sendKeys("5");
		WATERFALLtargetTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, labelOFF);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reportTotalOFF);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, FormatingType);
		GenericLibrary.click(driver, conditional);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.selectElementByVisibleText(formatingField, "Q1");
		GenericLibrary.waitForElementToBeClickable(driver, addCondtionBtn);
		JavascriptLibrary.javascriptClickElement(driver, addCondtionBtn);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		FormatnothingSelectedField.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, formatSearchBox);
		formatSearchBox.sendKeys("Conforming");
		formatSearchBox.sendKeys(Keys.ENTER);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.waitForAjax(driver);
		ActionUtils.ajaxJsClick(driver, addCondtionBtn);
		ActionUtils.ajaxJsClick(driver, removeCondition);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_BoxPlotChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop(driver, RecordID, boxPlot_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, boxPlot_X);
		GenericLibrary.dragAndDrop(driver, Q1, boxPlot_X);
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

	public void verify_RoseChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop(driver, RecordID, rose_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, rose_X);
		GenericLibrary.dragAndDrop(driver, Q1, rose_X);
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

	public void verify_SpiderChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop(driver, RecordId, spider_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, spider_X);
		GenericLibrary.dragAndDrop(driver, Q1, spider_X);
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

	public void verify_BubbleChart_Design_Report(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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
		GenericLibrary.dragAndDrop(driver, RecordId, bubble_Y);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bubble_X);
		GenericLibrary.dragAndDrop(driver, Q1, bubble_X);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, bubble_Z);
		GenericLibrary.dragAndDrop(driver, RecordID, bubble_Z);
		GenericLibrary.waitForAjax(driver);
	}


	public void verify_Filter_by_record_status_field(String AuditName, String reportName, String option, String option2) throws Exception {
		SoftAssert a = new SoftAssert();
		// Complete some records in capture
		AjaxLibrary.jsClick(driver, captureLink);
		AjaxLibrary.jsClick(driver, captureAudit);
		Thread.sleep(1000);
		Wrappers.jsType(driver, captureSearchBox, AuditName);
		AjaxLibrary.jsClick(driver, captureSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+AuditName+"']")));
		for (int i = 1; i <= 5; i++) {
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='ID:"+i+"']")));
			AjaxLibrary.jsClick(driver, captureCompleteBtn);
		}
		// Goto analyse
		AjaxLibrary.jsClick(driver, AnalyseLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseAuditLink);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
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

	public void verify_Open_captured_record_through_record_ID(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement Audit = driver.findElement(By.xpath("//h3[text()='"+AuditName+"']"));
		GenericLibrary.waitForElementVisibility(driver, Audit);
		Audit.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, searchReportTextBox);
		searchReportTextBox.sendKeys(reportName);
		GenericLibrary.click(driver, searchReportBtn);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//td[text()='"+reportName+"']")));
		GenericLibrary.click(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		// Open captured record through record ID
		driver.findElement(By.xpath("//a[text()=3]")).click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.switchToNewWindow_new(driver);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+AuditName+"')]")).isDisplayed(), "Captured record NOT opened");
		Reporter.log("Captured record opened successfully", true);
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='btnReopen']")).isDisplayed(), "Captured record Re-opened");
		Reporter.log("Captured record NOT opened to edit", true);
	}

	public void verify_Deleted_and_trashed_records_deletion_in_analyse(String AuditName, String reportName) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+AuditName+"']")));
		GenericLibrary.waitForElementVisibility(driver, selectedAudit);
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
		AjaxLibrary.jsClick(driver, captureAudit);
		Wrappers.jsType(driver, captureSearchBox, AuditName);
		AjaxLibrary.jsClick(driver, captureSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+AuditName+"']")));
		AjaxLibrary.jsClick(driver, captureRecord1);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		Wrappers.jsClick(driver, captureDeleteRecordBtn);
		GenericLibrary.waitForAlertPresent(driver);
		AjaxLibrary.checkAlert_Accept(driver);
		Thread.sleep(1000);
		List<WebElement> recordlist = driver.findElements(noOfRecordsAtCapture);
		int recordCount = recordlist.size();
		Reporter.log("No.of records at capture after deletion: "+recordCount, true);
		// Verify the no.of records at analyse
		AjaxLibrary.jsClick(driver, AnalyseLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseAuditLink);
		GenericLibrary.waitForElementVisibility(driver, analysesSearchBox);
		JavascriptLibrary.javascriptType(driver, analysesSearchBox, AuditName);
		JavascriptLibrary.javascriptClickElement(driver, searchAuditBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+AuditName+"']")));
		GenericLibrary.waitForElementVisibility(driver, selectedAudit);
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
		Assert.assertEquals(recordCount, count2, "Deleted records data still displaying at analyse");
		Reporter.log("Deleted records data deleted from analyse", true);
	}

}




