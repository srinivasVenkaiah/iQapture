package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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

public class BuildAuditsPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public BuildAuditsPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	@FindBy(xpath="//a[@id='btnAdd']")
	WebElement AddBtn;

	// Search option
	@FindBy(xpath = "//input[contains(@id,'txtSearch_audit')]")
	WebElement auditSearchBox;
	
	@FindBy(xpath="//a[contains(@onclick,'AuditsDSList.Search()')]")
	WebElement auditSearchBtn;
	
	@FindBy(id="txtSearch")
	WebElement peopleSearchBox;

	@FindBy(id="SearPeopleBtn")
	WebElement peopleSearchBtn;

	@FindBy(xpath = "//div[@class='no-march'][contains(.,'No matching records found')]")
	WebElement noMatchingRecordsFound;

	// Create Audit
	@FindBy(xpath = "//input[contains(@id,'DS_NAME')]")
	WebElement nameTextBox;

	@FindBy(id="divDS_NAME")
	WebElement nameTextBox_outer;

	@FindBy(xpath="//a[@id='btnSave']")
	WebElement saveBtn;

	@FindBy(xpath="//div[contains(@class,'field_desc_txt')][contains(.,'AUDIT INFO')]")
	WebElement auditsDefaultInfo;

	@FindBy(xpath = "//img[contains(@id,'imgDataset')]")
	WebElement uploadImageBtn;

	// Delete Audit
	@FindBy(xpath="//a[@id='btnPageBack']")
	WebElement backBtn;

	@FindBy(xpath = "//a[contains(.,'More')]")
	WebElement moreDD;

	@FindBy (xpath="//a[@title='Settings']")
	WebElement moreSettings;
	
	@FindBy(xpath = "//a[@title='Delete Audit'][contains(.,'Delete')]")
	WebElement deleteAuditBtn;

	@FindBy(xpath = "//button[@data-bb-handler='confirm'][contains(.,'OK')]")
	WebElement OkBtn;

	// Add data set to audit
	@FindBy(xpath = "//div[contains(@title,'New Item')]")
	WebElement addNewItemBtn;

	@FindBy(xpath = "//span[contains(.,'Please enter Description.')]")
	WebElement descTxtBoxErrMsg;

	@FindBy(xpath = "//textarea[contains(@id,'F_DESC')]")
	WebElement descTextBox;

	@FindBy(xpath="//div[contains(@title,'Section')]/span")
	WebElement sectionOption;

	@FindBy(xpath="//div[contains(@title,'Multi-Choice')]/span")
	WebElement multiChoiceOption;

	@FindBy(xpath = "//button[contains(@id,'rdLevel2')]")
	WebElement level2Btn;

	@FindBy(xpath = "//button[contains(@id,'rdLevel3')]")
	WebElement level3Btn;

	@FindBy(xpath = "//button[contains(@id,'rdLevel4')]")
	WebElement level4Btn;

	@FindBy(xpath = "//button[contains(@id,'rdLevel5')]")
	WebElement level5Btn;

	@FindBy(xpath = "//label[contains(.,'MANUAL')]")
	WebElement numberManual;

	@FindBy(xpath = "//label[contains(.,'NONE')]")
	WebElement numberNone;

	@FindBy(xpath = "//label[contains(@for,'rdMandatory0')]")
	WebElement mandatoryNoBtn;

	@FindBy(xpath = "//label[contains(@for,'rdMandatory1')]")
	WebElement mandatoryYesBtn;

	@FindBy(xpath = "//textarea[contains(@id,'F_HINT')]")
	WebElement hintTextBox;

	@FindBy(xpath = "//label[contains(@for,'FSI_MINIMIZE1')]")
	WebElement minimizeYesBtn;

	@FindBy(xpath = "//input[contains(@title,'Numbering')]")
	WebElement numberManualTextBox;

	// Field panel Close & Open and Delete Question
	@FindBy(xpath="//*[contains(@id,'panel_close')]")
	WebElement closeFiledPanelBtn;

	@FindBy(xpath="//a[@title='Delete']")
	WebElement removeFieldBtn;

	// Settings - Schedules
	// Weekly
	@FindBy(xpath = "//a[@title='Settings'][contains(.,'Settings')]")
	WebElement settingsOption;

	@FindBy(xpath=".//*[@id='btnAdd']")
	WebElement addScheduleBtn;

	@FindBy(xpath=".//*[@id='divDSS_LABEL']")
	WebElement scheduleLabelTxtBox;

	@FindBy(xpath=".//*[@id='DSS_LABEL']")
	WebElement scheduleLabelTxtBox_in;

	@FindBy(xpath=".//*[@id='btnActPeople']")
	WebElement addPeopleBtn;

	// Monthly
	@FindBy(xpath=".//*[@id='periodictiy']/div/label[3]")
	WebElement monthlyBtn;

	@FindBy(xpath=".//*[@id='divDSS_DAY']")
	WebElement setDayTxtBox;

	@FindBy(xpath=".//*[@id='DSS_DAY']")
	WebElement setDayTxtBox_in;

	// Set Date
	@FindBy(xpath=".//*[@id='periodictiy']/div/label[1]")
	WebElement setDateBtn;

	@FindBy(xpath=".//*[@id='btnActDate']/span/i")
	WebElement setDateCalenderBtn;

	@FindBy(xpath="//a[contains(@onclick,'DeleteSchedule')]")
	WebElement deleteScheduleBtn;

	// Add/Delete Users
	@FindBy(xpath="//div[text()='User not found']")
	WebElement userNotFoundMessage;

	@FindBy(xpath=".//*[contains(@id,'UserAdd')]")
	WebElement addUserBtn;

	// Logs & Trash can action
	@FindBy(xpath="//h5[contains(text(),'Show Audit Log')]/..//div/label[1]")
	WebElement showAuditLog_Yes;

	@FindBy(xpath="//h5[contains(text(),'Show Audit Log')]/..//div/label[2]")
	WebElement showAuditLog_No;

	@FindBy(xpath="//h5[contains(text(),'Trash can action')]/..//div/label[1]")
	WebElement trashCanAction_Disabled;

	@FindBy(xpath="//h5[contains(text(),'Trash can action')]/..//div/label[2]")
	WebElement trashCanAction_Delete;

	// Download & upload templates
	@FindBy(xpath="//a[contains(@title,'Download Template')]")
	WebElement downloadTemplateBtn;

	@FindBy(xpath="//a[@title='Upload Template']")
	WebElement uploadTemplateBtn;

	// Permissions 
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

	@FindBy(xpath="//button[text()='Yes']")
	WebElement YesBtn;

	@FindBy(xpath="//div[text()='You do not have permission to make changes to this Audit.']")
	WebElement DoPermissionWarningAlert;

	@FindBy(xpath = "//a[@title='New Record'][contains(.,'Add')]")
	WebElement addRecordBtn;

	@FindBy(xpath="//*[contains(.,'Please insert name of Company responsible for the Audit.')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input")
	static WebElement companyResponsibleforAudit;

	@FindBy(xpath="//*[contains(.,'Please insert name of the Company being Audited.')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input")
	static WebElement companyBeingAudited;

	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement saveRecordBtn;

	@FindBy(xpath=".//*[@id='btnPageBack']")
	WebElement backToRecordsBtn;

	@FindBy(xpath = "//a[contains(@id,'btnComplete')]")
	WebElement completeRecordBtn;

	@FindBy(xpath="//div[contains(@class,'complete')]")
	WebElement completedRecord;

	@FindBy(xpath = "//a[contains(@id,'btnReopen')]")
	WebElement reopenRecordBtn;

	@FindBy(xpath = "//a[@title='Delete'][contains(.,'Delete')]")
	WebElement deleteRecordBtn;

	@FindBy(xpath="//span[text()[normalize-space()='ACTIVITY LOG']]")
	WebElement auditLogText;

	@FindBy(xpath="//a[@title='Log']")
	WebElement logOption;

	@FindBy(xpath="//input[contains(@id,'searchAnalyses')]")
	WebElement analysesSearchBox;

	@FindBy(xpath=".//*[@id='searchAnalyses']//preceding::span[1]")
	WebElement searchQuestionnaireBtn;

	@FindBy(xpath=".//*[@id='CreateBtn']/a")
	WebElement createReportBtn;

	@FindBy(xpath="//input[@id='REPORTNAME']")
	WebElement reportNameTextBox;

	@FindBy(xpath="//a[@title='Save Report']")
	WebElement saveReportBtn;

	@FindBy(xpath="//a[text()='Share ']")
	WebElement shareOption;

	@FindBy(xpath="//input[contains(@placeholder,'Search...')]")
	WebElement shareSearchBox;

	
	@FindBy(xpath="//a[text()='Search']")
	WebElement shareSearchBtn;

	@FindBy(xpath="//span[contains(@id,'_btnComUserAdd')]")
	WebElement shareToUser;

	By closeAlert = By.xpath("//button[@data-bb-handler='ok'][contains(.,'OK')]");

	By AuditTab = By.xpath("//a[contains(.,'Audits')]");
    By AuditSearchBox = By.xpath("//input[@id='txtSearch_audit']");
    By AuditSearchBtn = By.xpath("//a[contains(@onclick,'AuditsDSList.Search()')]");
    By AuditNewReport = By.xpath("//a[contains(@id,'btnNewAuditReport')]");
    







	// Actions:......................................................................................
	public boolean verify_AuditsTab() {
		return AddBtn.isDisplayed();
	}

	public void verify_Audit_search_option() {
		auditSearchBox.sendKeys(driver.findElements(By.xpath("//div[@id='ulAudits']//h3")).get(0).getText());
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> auditList2 = driver.findElements(By.xpath("//div[@id='ulAudits']//h3"));
		Assert.assertTrue(auditList2.size() == 1, "Audit search option is not working");
		Reporter.log("Audit search option is functional", true);
	}

	public void verify_Error_message_for_invalid_search() {
		auditSearchBox.sendKeys("asdfghjk");
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(noMatchingRecordsFound.isDisplayed(), "No error message displayed for invalid search");
		Reporter.log("Error message displayed successfully for invalid search", true);
	}

	public void verify_Create_audit_and_upload_image_to_audit(String name, String path) throws Exception {
		// Create audit
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		AjaxLibrary.jsClick(driver, saveBtn);
		Assert.assertTrue(auditsDefaultInfo.isDisplayed(), "Audit not created & Default audits info not displayed");
		Reporter.log("Audit created & default audit info displayed successfully", true);
		// Upload image to audit
		Thread.sleep(1000);
		GenericLibrary.uploadFile(uploadImageBtn, path);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(3000);
		String img = uploadImageBtn.getAttribute("src");
		Assert.assertTrue(img.contains("data"), "Image not uploaded");
		Reporter.log("Image uploaded for the audit successfully", true);
	}

	public void verify_Delete_audit(String name) throws Exception {
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		auditSearchBox.sendKeys(name);
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+name+"')]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, deleteAuditBtn);
		JavascriptLibrary.javascriptClickElement(driver, OkBtn);
		GenericLibrary.waitForAjax(driver);
		auditSearchBox.sendKeys(name);
		GenericLibrary.click(driver, auditSearchBtn);
		Assert.assertTrue(noMatchingRecordsFound.isDisplayed(), "Audit not deleted");
		Reporter.log("Audit deleted successfully", true);
	}

	public void verify_Description_field_error_message(String name) throws Exception {
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, addNewItemBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, addNewItemBtn);
		Thread.sleep(2000);
		Assert.assertTrue(descTxtBoxErrMsg.isDisplayed(), "Error message not displayed for description text box");
		Reporter.log("Error message displayed sucessfully for description field", true);
	}

	public void verify_Add_dataset_to_audit(String name, 
			String m1, String m2, String m3, String m4, String m5, String m6, 
			String nm1, String m7, String hint1, String m8, String s1, String s2) throws Exception {
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(name);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// MultiChoice 
		// Q1 - L1
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m1);
		// Q2 - L2/Mandatory No
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m2);
		AjaxLibrary.jsClick(driver, level2Btn);
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		// Q3 - L3/Mandatory No
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m3);
		AjaxLibrary.jsClick(driver, level3Btn);
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		// Q4 - L4/Mandatory No
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m4);
		AjaxLibrary.jsClick(driver, level4Btn);
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		// Q5 - L5/Mandatory No
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m5);
		AjaxLibrary.jsClick(driver, level5Btn);
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		// Q6 - Number manual
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m6);
		AjaxLibrary.jsClick(driver, numberManual);
		AjaxLibrary.jsType(driver, numberManualTextBox, nm1.replace(".0", ""));
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		// Q7 - Mandatory No/Hint
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m7);
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		AjaxLibrary.jsType(driver, hintTextBox, hint1);
		// Q8 - Number None/Mandatory No
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, m8);
		AjaxLibrary.jsClick(driver, numberNone);
		AjaxLibrary.jsClick(driver, mandatoryNoBtn);
		// Q9 - Section 
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, s1);
		AjaxLibrary.jsClick(driver, sectionOption);
		// Q10 - Section/Minimize
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, s2);
		AjaxLibrary.jsClick(driver, sectionOption);
		AjaxLibrary.jsClick(driver, minimizeYesBtn);
		// Enable trash can action
		GenericLibrary.scrollTop(driver);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
	}

	public void verify_Open_and_close_field_panel_and_Delete_created_field(String Qname, String Q1, String Q2, String Q3) throws Exception {
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Q1 
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Q2 
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q2);
		// Q3
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q3);
		// Close and Open Field panel
		AjaxLibrary.jsClick(driver, closeFiledPanelBtn);
		WebElement createdField = driver.findElement(By.xpath("//span[text()='"+Q3+"']"));
		AjaxLibrary.jsClick(driver, createdField);
		Reporter.log("Field panel closed and opened successfully", true);
		// Delete Question
		GenericLibrary.click(driver, removeFieldBtn);
		GenericLibrary.checkAlert_Accept(driver);
		GenericLibrary.waitForAjax(driver);
		try {
			Assert.assertTrue(createdField.isDisplayed());
			Assert.assertTrue(false, "Created field not deleted");
		} catch (Exception e) {
			Reporter.log("Created field deleted successfully", true);
		}
	}

	public void verify_Add_Schedules_and_delete_schedule_against_the_audit(String Qname, String Q1) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(Qname);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Q1 
		GenericLibrary.click(driver, addNewItemBtn);
		GenericLibrary.waitForAjax(driver);
		descTextBox.sendKeys(Q1);
		descTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Schedule Audit
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, settingsOption);
		GenericLibrary.waitForAjax(driver);
		// Settings - Weekly Schedule
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Weekly Schedule");
		scheduleLabelTxtBox_in.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> weeksList = driver.findElements(By.xpath(".//*[@id='divWeekly']//label/span"));
		GenericLibrary.click(driver, weeksList.get(0));
		GenericLibrary.click(driver, weeksList.get(2));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, addPeopleBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> users = driver.findElements(By.cssSelector(".bs-checkbox>input"));
		GenericLibrary.click(driver, users.get(1));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, users.get(2));
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Weekly Schedule')]")).isDisplayed(), "Weekly schedule not created");
		Reporter.log("Weekly schedule set successfully", true);
		// Settings - Monthly Schedule
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Monthly Schedule");
		scheduleLabelTxtBox_in.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDayTxtBox);
		JavascriptLibrary.javascriptType(driver, setDayTxtBox_in, "10");
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, monthlyBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> monthsList = driver.findElements(By.xpath(".//*[@id='divMyActions']/div/label/span"));
		WebElement jan = monthsList.get(1);
		GenericLibrary.scrollIntoView(driver, jan);
		jan.click();
		WebElement aug = monthsList.get(9);
		GenericLibrary.scrollIntoView(driver, aug);
		aug.click();
		WebElement dec = monthsList.get(12);
		GenericLibrary.scrollIntoView(driver, dec);
		dec.click();
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Monthly Schedule')]")).isDisplayed(), "Monthly Schedule not created");
		Reporter.log("Monthly schedule set successfully", true);
		// Settings - Set Date
		// Current Month Date
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Current Month Schedule");
		scheduleLabelTxtBox_in.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateCalenderBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> currentMonthDays = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < currentMonthDays.size(); i++) {
			String day = currentMonthDays.get(i).getText();
			if(day.equalsIgnoreCase("15")) {
				GenericLibrary.click(driver, currentMonthDays.get(i));
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Current Month Schedule')]")).isDisplayed(), "Current Month schedule not created");
		Reporter.log("Current month schedule set successfully", true);
		// Last Month Date
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Last Month Schedule");
		scheduleLabelTxtBox_in.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateCalenderBtn);
		List<WebElement> leftBtns = driver.findElements(By.cssSelector(".fa.fa-angle-left"));
		leftBtns.get(0).click();
		GenericLibrary.waitForAjax(driver);
		List<WebElement> lastMonthDays = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < lastMonthDays.size(); i++) {
			String day = lastMonthDays.get(i).getText();
			if(day.equalsIgnoreCase("10")) {
				lastMonthDays.get(i).click();
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Last Month Schedule')]")).isDisplayed(), "Last Month Schedule not created");
		Reporter.log("Last month schedule set successfully", true);
		// Next Month Date
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Next Month Schedule");
		scheduleLabelTxtBox_in.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateCalenderBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> rightBtns = driver.findElements(By.cssSelector(".fa.fa-angle-right"));
		rightBtns.get(0).click();
		GenericLibrary.waitForAjax(driver);
		List<WebElement> nextMonthDays = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < nextMonthDays.size(); i++) {
			String day = nextMonthDays.get(i).getText();
			if(day.equalsIgnoreCase("10")) {
				nextMonthDays.get(i).click();
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Next Month Schedule')]")).isDisplayed(), "Next Month Scedule not created");
		Reporter.log("Next month schedule set successfully", true);
		// Delete schedule
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Delete Schedule");
		scheduleLabelTxtBox_in.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		WebElement deleteItem = driver.findElement(By.xpath("//label[contains(text(),'Delete Schedule')]"));
		a.assertTrue(deleteItem.isDisplayed(), "Scedule to delete not created");
		Reporter.log("Schedule to delete set successfully", true);
		JavascriptLibrary.javascriptClickElement(driver, deleteScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			a.assertTrue(deleteItem.isDisplayed());
			a.assertTrue(false, "Schedule not deleted");
		} catch (Exception e) {
			Reporter.log("Schedule deleted successfully", true);
		}
		a.assertAll();
	}

	public void verify_Add_people_and_company_and_Delete_added_people_and_company_against_the_audit(String Qname,
			String user, String company) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(Qname);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Settings
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, settingsOption);
		GenericLibrary.waitForAjax(driver);
		// Add user
		peopleSearchBox.sendKeys(user);
		JavascriptLibrary.javascriptClickElement(driver, peopleSearchBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			JavascriptLibrary.javascriptClickElement(driver, addUserBtn);
			GenericLibrary.waitForAjax(driver);
			WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
			a.assertTrue(userAdded.isDisplayed(), "User not added");
			Reporter.log("User added", true);
			// Delete user
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//span[text()='"+user+"']/../..//following::div/i[@title='Remove user']")));
			AjaxLibrary.checkAlert_Accept(driver);
			Thread.sleep(1000);
			try {
				a.assertFalse(driver.findElement(By.xpath("//span[text()='"+user+"']")).isDisplayed(), "User not deleted");
				Reporter.log("User deleted", true);
			} catch (NoSuchElementException e) {
				Reporter.log("User deleted", true);
			}
		} catch (Exception e) {
			a.assertTrue(userNotFoundMessage.isDisplayed(),"'User not found' message not displayed");
			Reporter.log("User not found", true);
		}
		// Add company
		peopleSearchBox.clear();
		peopleSearchBox.sendKeys(company);
		JavascriptLibrary.javascriptClickElement(driver, peopleSearchBtn);
		try {
			JavascriptLibrary.javascriptClickElement(driver, addUserBtn);
			GenericLibrary.waitForAjax(driver);
			WebElement companyAdded = driver.findElement(By.xpath("(//span[text()='"+company+"'])[1]"));
			a.assertTrue(companyAdded.isDisplayed(), "Company not added");
			Reporter.log("Company added", true);
			// Delete company
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//span[text()='"+company+"']/../..//following::div/i[@title='Remove all added users under this company']")));
			AjaxLibrary.checkAlert_Accept(driver);
			Thread.sleep(1000);
			try {
				a.assertFalse(driver.findElement(By.xpath("(//span[text()='"+company+"'])[1]")).isDisplayed(), "Company not deleted");
				Reporter.log("Company deleted", true);
			} catch (NoSuchElementException e) {
				Reporter.log("Company not deleted", true);
			}
		} catch (Exception e) {
			a.assertTrue(userNotFoundMessage.isDisplayed(),"'User not found' message not displayed");
			Reporter.log("Company not found", true);
		}
		// Search unknown user and verify error message
		peopleSearchBox.clear();
		peopleSearchBox.sendKeys("asdfghjkl");
		JavascriptLibrary.javascriptClickElement(driver, peopleSearchBtn);
		a.assertTrue(userNotFoundMessage.isDisplayed(), "Not promt message for unknown user search");
		Reporter.log("Prompt message displayed for unknown user search", true);
		a.assertAll();
	}

	public void verify_Show_audit_log_and_Trash_can_action_options(String Qname, String Q1) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(Qname);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Q1 
		GenericLibrary.click(driver, addNewItemBtn);
		GenericLibrary.waitForAjax(driver);
		descTextBox.sendKeys(Q1);
		descTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, settingsOption);
		GenericLibrary.waitForAjax(driver);
		// Enable show log
		a.assertTrue(showAuditLog_Yes.getAttribute("class").contains("active"), "Show audit log YES button disabled by default");
		Reporter.log("Show audit log YES button enabled by default", true);
		GenericLibrary.click(driver, showAuditLog_No);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(showAuditLog_No.getAttribute("class").contains("active"), "Unable to enable Show audit log NO button");
		Reporter.log("Show audit log NO button enabled successfully", true);
		// Back to default status
		GenericLibrary.click(driver, showAuditLog_Yes);
		GenericLibrary.waitForAjax(driver);
		// Enable Trash can action
		a.assertTrue(trashCanAction_Disabled.getAttribute("class").contains("active"), "Trash can action DISABLED button disabled by default");
		Reporter.log("Trash can action DISABLED button enabled by default", true);
		GenericLibrary.click(driver, trashCanAction_Delete);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(trashCanAction_Delete.getAttribute("class").contains("active"), "Unable to enable Trash can action DELETE button");
		Reporter.log("Trash can action DELETE button enabled successfully", true);
		a.assertAll();
	}

	public void verify_Download_and_Upload_questions_template(String Qname, String downloadPath, String fileName, String filePath) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(Qname);
		GenericLibrary.click(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Settings
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, settingsOption);
		GenericLibrary.waitForAjax(driver);
		// Upload Questions
		// Download template
		GenericLibrary.click(driver, downloadTemplateBtn);
		Thread.sleep(3000);
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Template not dowloaded");
		Reporter.log("Template downloaded successfully", true);
		// Upload template
		GenericLibrary.uploadFile(uploadTemplateBtn, filePath);
		GenericLibrary.waitForAjax(driver);
		for (int i = 1; i <= 4; i++) {
			a.assertTrue(driver.findElement(By.xpath("//div[@class='field_desc_txt'][contains(.,'Q"+i+"')]")).isDisplayed(), "Template not uploaded");
		}
		Reporter.log("Template uploaded successfully", true);
		a.assertAll();
	}



	//--------------------------------- Audit Permissions (Start) ---------------------------------------------------------
	public void verify_Audit_Build_Owner_user_permissions(String Qname, String Q1, 
			String user, String option, String newQ1, String newQname, String newUser) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Open the Audit
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		a.assertTrue(addNewItemBtn.isDisplayed(),"Owner can't access the audit");
		Reporter.log("Owner can access the audit", true);
		// Edit
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='"+Q1+"']")));
		AjaxLibrary.clickSelectAndType(driver, descTextBox, descTextBox, newQ1);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+newQ1+"']")).isDisplayed(),"Owner can't edit the audit");
		Reporter.log("Owner can edit the audit", true);
		// Rename
		AjaxLibrary.jsClickClearAndType(driver, nameTextBox_outer, nameTextBox, newQname);
		a.assertEquals(nameTextBox_outer.getText(), newQname, "Owner can't rename the audit");
		Reporter.log("Owner can rename the audit", true);
		// Change settings
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		a.assertTrue(trashCanAction_Delete.getAttribute("class").contains("active"), "Owner can't change the audit settings");
		Reporter.log("Owner can change the audit settings", true);
		// Add users and remove users
		peopleSearchBox.sendKeys(newUser);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement newUserAdded = driver.findElement(By.xpath("//span[text()='"+newUser+"']"));
		a.assertTrue(newUserAdded.isDisplayed(), "Owner can't add the users");
		Reporter.log("Owner can add the users", true);
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//span[text()='"+newUser+"']/../..//following::div/i[@title='Remove user']")));
		AjaxLibrary.checkAlert_Accept(driver);
		Thread.sleep(1000);
		try {
			a.assertFalse(driver.findElement(By.xpath("//span[text()='"+newUser+"']")).isDisplayed(), "Owner can't delete the user");
			Reporter.log("Owner can delete the user", true);
		} catch (NoSuchElementException e) {
			Reporter.log("Owner can delete the user", true);
		}   
		// Delete audit
		AjaxLibrary.jsClick(driver, backBtn);
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, deleteAuditBtn);
		AjaxLibrary.jsClick(driver, OkBtn);
		auditSearchBox.sendKeys(newQname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		a.assertTrue(noMatchingRecordsFound.isDisplayed(), "Owner can't delete the audit");
		Reporter.log("Owner can delete the audit", true);
		a.assertAll();
	}

	public void verify_Audit_Build_Edit_user_permissions(String Qname, String Q1, 
			String user, String option, String newQ1, String newQname) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Open the Audit
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		a.assertTrue(addNewItemBtn.isDisplayed(),"Edit user can't access the audit");
		Reporter.log("Edit user can access the audit", true);
		// Edit
		GenericLibrary.click(driver, driver.findElement(By.xpath("//span[text()='"+Q1+"']")));
		AjaxLibrary.clickSelectAndType(driver, descTextBox, descTextBox, newQ1);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+newQ1+"']")).isDisplayed(),"Edit user can't edit the audit");
		Reporter.log("Edit user can edit the audit", true);
		// Rename
		try {
			AjaxLibrary.jsClickClearAndType(driver, nameTextBox_outer, nameTextBox, newQname);
			a.assertEquals(nameTextBox_outer.getText(), newQname, "Edit user can't rename the audit");
			Reporter.log("Edit user can rename the audit", true);
		} catch (InvalidElementStateException e1) {
			Reporter.log("Edit user can't rename the audit", true);
		}
		// Change settings
		try {
			a.assertTrue(moreDD.isDisplayed(),"Edit user can't change the settings, can't add people, can't delete the audit");
			Reporter.log("Edit user can change the settings, can add people, can delete the audit", true);
		} catch (NoSuchElementException e1) {
			Reporter.log("Edit user can't change the settings, can't add people and can't delete the audit", true);
		}
		a.assertAll();
	}

	public void verify_Audit_Build_Do_user_permissions(String Qname, String Q1, 
			String user, String option, String msg) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Open the Audit
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		Thread.sleep(1000);
		a.assertEquals(DoPermissionWarningAlert.getText(), msg, "Do user can access the audit");
		AjaxLibrary.jsClick(driver, closeAlert);
		Reporter.log("Do user can't access the audit", true);
		a.assertAll();
	}

	public void verify_Audit_Build_View_user_permissions(String Qname, String Q1, 
			String user, String option, String msg) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Open the Audit
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		Thread.sleep(1000);
		a.assertEquals(DoPermissionWarningAlert.getText(), msg, "View user can access the audit");
		AjaxLibrary.jsClick(driver, closeAlert);
		Reporter.log("View user can't access the audit", true);
		a.assertAll();
	}

	//--------------------------------- Audit Permissions (End) ---------------------------------------------------------

	//--------------------------------- Audit Capture Permissions (Start) ---------------------------------------------------------
	public void verify_Audit_Capture_Owner_user_permissions(String Qname, String Q1, 
			String user, String option, String type, String respoComp, String audComp, String Q1option) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Create a record
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		try {
			AjaxLibrary.jsClick(driver, addRecordBtn);
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		} catch (Exception e) {
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		}
		companyResponsibleforAudit.sendKeys(respoComp);
		companyBeingAudited.sendKeys(audComp);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/..")));
		AjaxLibrary.jsClick(driver, saveRecordBtn);
		AjaxLibrary.jsClick(driver, backToRecordsBtn);
		List<WebElement> records = driver.findElements(By.xpath("//span[contains(.,'ID')]"));
		a.assertTrue(records.size() != 0, "Owner can't create the record");
		Reporter.log("Owner can create the record", true);
		// Complete record
		AjaxLibrary.jsClick(driver, records.get(0));
		AjaxLibrary.jsClick(driver, completeRecordBtn);
		a.assertTrue(completedRecord.isDisplayed(), "Owner can't complete the record");
		Reporter.log("Owner can complete the record", true);
		// View audit logs
		AjaxLibrary.jsClick(driver, completedRecord);
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, logOption);
		a.assertTrue(auditLogText.isDisplayed(), "Owner can't see the logs");
		Reporter.log("Owner can see the logs", true);
		a.assertAll();
	}

	public void verify_Audit_Capture_Edit_user_permissions(String Qname, String Q1, 
			String user, String option, String type, String respoComp, String audComp, String Q1option) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Create a record
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		try {
			AjaxLibrary.jsClick(driver, addRecordBtn);
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		} catch (Exception e) {
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		}
		companyResponsibleforAudit.sendKeys(respoComp);
		companyBeingAudited.sendKeys(audComp);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/..")));
		AjaxLibrary.jsClick(driver, saveRecordBtn);
		AjaxLibrary.jsClick(driver, backToRecordsBtn);
		List<WebElement> records = driver.findElements(By.xpath("//span[contains(.,'ID')]"));
		a.assertTrue(records.size() != 0, "Edit user can't create the record");
		Reporter.log("Edit user can create the record", true);
		// Complete record
		AjaxLibrary.jsClick(driver, records.get(0));
		AjaxLibrary.jsClick(driver, completeRecordBtn);
		a.assertTrue(completedRecord.isDisplayed(), "Edit user can't complete the record");
		Reporter.log("Edit user can complete the record", true);
		// View audit logs
		AjaxLibrary.jsClick(driver, completedRecord);
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, logOption);
		a.assertTrue(auditLogText.isDisplayed(), "Edit user can't see the logs");
		Reporter.log("Edit user can see the logs", true);
		a.assertAll();
	}

	public void verify_Audit_Capture_Do_user_permissions(String Qname, String Q1, 
			String user, String option, String type, String respoComp, String audComp, String Q1option) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Create a record
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		try {
			AjaxLibrary.jsClick(driver, addRecordBtn);
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		} catch (Exception e) {
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		}
		companyResponsibleforAudit.sendKeys(respoComp);
		companyBeingAudited.sendKeys(audComp);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/..")));
		AjaxLibrary.jsClick(driver, saveRecordBtn);
		AjaxLibrary.jsClick(driver, backToRecordsBtn);
		List<WebElement> records = driver.findElements(By.xpath("//span[contains(.,'ID')]"));
		a.assertTrue(records.size() != 0, "Do user can't create the record");
		Reporter.log("Do user can create the record", true);
		// Complete record
		AjaxLibrary.jsClick(driver, records.get(0));
		AjaxLibrary.jsClick(driver, completeRecordBtn);
		a.assertTrue(completedRecord.isDisplayed(), "Do user can't complete the record");
		Reporter.log("Do user can complete the record", true);
		// View audit logs
		AjaxLibrary.jsClick(driver, completedRecord);
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, logOption);
		a.assertTrue(auditLogText.isDisplayed(), "Do user can't see the logs");
		Reporter.log("Do user can see the logs", true);
		a.assertAll();
	}

	public void verify_Audit_Capture_View_user_permissions(String Qname, String Q1, 
			String user, String option, String type, String respoComp, String audComp, String Q1option) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Create a record with owner
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		try {
			AjaxLibrary.jsClick(driver, addRecordBtn);
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		} catch (Exception e) {
			// Type
			AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		}
		companyResponsibleforAudit.sendKeys(respoComp);
		companyBeingAudited.sendKeys(audComp);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/..")));
		AjaxLibrary.jsClick(driver, saveRecordBtn);
		AjaxLibrary.jsClick(driver, backToRecordsBtn);
		List<WebElement> records = driver.findElements(By.xpath("//span[contains(.,'ID')]"));
		a.assertTrue(records.size() != 0, "Key user can't create the record");
		Reporter.log("Key user created the record", true);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.buildAuditLink);
		// Open Questionnaire
		auditSearchBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, auditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+Qname+"']")));
		// View record
		List<WebElement> recordsList = driver.findElements(By.xpath("//span[contains(.,'ID')]"));
		AjaxLibrary.jsClick(driver, recordsList.get(0));
		a.assertTrue(moreDD.isDisplayed(), "View user can't view the record");
		Reporter.log("View user can view the record", true);
		// Complete record
		AjaxLibrary.jsClick(driver, completeRecordBtn);
		//AjaxLibrary.jsClick(driver, YesBtn);
		a.assertTrue(completedRecord.isDisplayed(), "View user can't complete the record");
		Reporter.log("View user can complete the record", true);
		a.assertAll();
	}
	//--------------------------------- Audit Capture Permissions (End) ---------------------------------------------------------
	
	//--------------------------------- Analyse Permissions (Start) ---------------------------------------------------------
	public void verify_Analyse_Owner_user_permissions(String Qname, String Q1, 
			String user, String option, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseLink);
		// Create a report in Audit
		ActionUtils.ajaxJsClick(driver, AuditTab);
		ActionUtils.ajaxJsType(driver, AuditSearchBox, Qname);
		ActionUtils.ajaxJsClick(driver, AuditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Qname+"']")));
		ActionUtils.ajaxJsClick(driver, AuditNewReport);
		AjaxLibrary.jsType(driver, reportNameTextBox, reportName);
		AjaxLibrary.jsClick(driver, saveReportBtn);
		Reporter.log("Owner can create report", true);
		AjaxLibrary.jsClick(driver, shareOption);
		shareSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, shareSearchBtn);
		AjaxLibrary.jsClick(driver, shareToUser);
		WebElement sharedUser = driver.findElement(By.xpath("//span[contains(.,'"+user+"')]"));
		a.assertTrue(sharedUser.isDisplayed(), "Owner can't share the report");
		Reporter.log("Owner can share the report", true);
		a.assertAll();
	}

	public void verify_Analyse_Edit_user_permissions(String Qname, String Q1, 
			String user, String option, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseLink);
		// Create a report
		ActionUtils.ajaxJsClick(driver, AuditTab);
		ActionUtils.ajaxJsType(driver, AuditSearchBox, Qname);
		ActionUtils.ajaxJsClick(driver, AuditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Qname+"']")));
		ActionUtils.ajaxJsClick(driver, AuditNewReport);
		AjaxLibrary.jsType(driver, reportNameTextBox, reportName);
		AjaxLibrary.jsClick(driver, saveReportBtn);
		Reporter.log("Edit user can create report", true);
		AjaxLibrary.jsClick(driver, shareOption);
		shareSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, shareSearchBtn);
		AjaxLibrary.jsClick(driver, shareToUser);
		WebElement sharedUser = driver.findElement(By.xpath("//span[contains(.,'"+user+"')]"));
		a.assertTrue(sharedUser.isDisplayed(), "Edit user can't share the report");
		Reporter.log("Edit user can share the report", true);
		a.assertAll();
	}

	public void verify_Analyse_Do_user_permissions(String Qname, String Q1, 
			String user, String option, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseLink);
		// Create a report
		ActionUtils.ajaxJsClick(driver, AuditTab);
		ActionUtils.ajaxJsType(driver, AuditSearchBox, Qname);
		ActionUtils.ajaxJsClick(driver, AuditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Qname+"']")));
		ActionUtils.ajaxJsClick(driver, AuditNewReport);
		AjaxLibrary.jsType(driver, reportNameTextBox, reportName);
		AjaxLibrary.jsClick(driver, saveReportBtn);
		Reporter.log("Edit user can create report", true);
		AjaxLibrary.jsClick(driver, shareOption);
		shareSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, shareSearchBtn);
		AjaxLibrary.jsClick(driver, shareToUser);
		WebElement sharedUser = driver.findElement(By.xpath("//span[contains(.,'"+user+"')]"));
		a.assertTrue(sharedUser.isDisplayed(), "Do user can't share the report");
		Reporter.log("Do user can share the report", true);
		a.assertAll();
	}

	public void verify_Analyse_View_user_permissions(String Qname, String Q1, 
			String user, String option, String reportName) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add Audit
		AjaxLibrary.jsClick(driver, AddBtn);
		nameTextBox.sendKeys(Qname);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, addNewItemBtn);
		AjaxLibrary.jsType(driver, descTextBox, Q1);
		// Settings - Add user and Set as owner
		GenericLibrary.hoverWebelement(driver, moreDD);
		AjaxLibrary.jsClick(driver, settingsOption);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		AjaxLibrary.jsClick(driver, addUserBtn);
		WebElement userAdded = driver.findElement(By.xpath("//span[text()='"+user+"']"));
		a.assertTrue(userAdded.isDisplayed(), "User not added");
		Reporter.log("User added", true);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		AjaxLibrary.selectElementByVisibleText(driver, userDropDown, option);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, LoginPage.newiQaptureBtn);
		AjaxLibrary.jsClick(driver, TaskBoardPage.AnalyseLink);
		// Create a report
		ActionUtils.ajaxJsClick(driver, AuditTab);
		ActionUtils.ajaxJsType(driver, AuditSearchBox, Qname);
		ActionUtils.ajaxJsClick(driver, AuditSearchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Qname+"']")));
		ActionUtils.ajaxJsClick(driver, AuditNewReport);
		AjaxLibrary.jsType(driver, reportNameTextBox, reportName);
		AjaxLibrary.jsClick(driver, saveReportBtn);
		Reporter.log("Edit user can create report", true);
		AjaxLibrary.jsClick(driver, shareOption);
		shareSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, shareSearchBtn);
		AjaxLibrary.jsClick(driver, shareToUser);
		WebElement sharedUser = driver.findElement(By.xpath("//span[contains(.,'"+user+"')]"));
		a.assertTrue(sharedUser.isDisplayed(), "View user can't share the report");
		Reporter.log("View user can share the report", true);
		a.assertAll();
	}

	//--------------------------------- Analyse Permissions (End) ---------------------------------------------------------

	//Create Audit to check Analyse section
		
	public void createAudit_For_Analyse(String Auditname, String filePath) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.click(driver, AddBtn);
		GenericLibrary.waitForAjax(driver);
		nameTextBox.sendKeys(Auditname);
		AjaxLibrary.jsClick(driver, saveBtn);
		GenericLibrary.hoverWebelement(driver, moreDD);
		GenericLibrary.click(driver, moreSettings);
		Thread.sleep(2000);
		GenericLibrary.uploadFile(uploadTemplateBtn, filePath);
		Thread.sleep(3000);
	}









}
