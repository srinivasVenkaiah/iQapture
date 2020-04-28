/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class CaptureAuditsPage extends BasePage {

	// Objects Repository(OR):........................................................................

	//Page Title Verification
	@FindBy(xpath="//*[@id='ulAudits']")
	WebElement auditsContainer;

	// Search
	@FindBy(xpath="//input[contains(@id,'txtSearch_audit')]")
	WebElement auditSearchBox;

	@FindBy(xpath="//a[contains(@onclick,'AuditsDSList.Search()')]")
	WebElement auditSearchBtn;

	@FindBy(xpath = "//div[@class='no-march'][contains(.,'No matching records found')]")
	WebElement noMatchingRecordsFound;

	// Create records
	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement saveBtn;

	@FindBy(xpath=".//*[@id='btnPageBack']")
	WebElement backBtn;

	@FindBy(xpath = "//a[@title='New Record'][contains(.,'Add')]")
	WebElement addBtn;

	// Upload file and add activity
	@FindBy(xpath="//*[contains(.,'Please insert name of Company responsible for the Audit.')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input")
	WebElement companyResponsibleforAudit;

	@FindBy(xpath="//*[contains(.,'Please insert name of the Company being Audited.')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input")
	WebElement companyBeingAudited;

	@FindBy(xpath = "//form[contains(@id,'fieldImgDropzone')]")
	WebElement fileBrowseBtn;

	@FindBy(xpath="//i[contains(@class,'fa fa-remove vc-btn-font-20')]")
	WebElement closeFileUploadPanel;

	@FindBy(xpath = "//span[contains(@title,'Activity')]")
	WebElement addActivityBtn;

	@FindBy(xpath = "//a[contains(@id,'btnAtcSave')]")
	WebElement saveActivityBtn;

	@FindBy(xpath = "//a[contains(@title,'Send Email')]")
	WebElement sendEmailBtn;

	@FindBy(xpath = "//span[contains(@class,'fa fa-calendar')]")
	WebElement targetDateBtn;

	@FindBy(xpath = "//td[contains(@class,'day active today')]")
	WebElement activeDateBtn;

	@FindBy(xpath = "//textarea[contains(@id,'txtActDesc')]")
	WebElement actDescTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'txtActRootCause')]")
	WebElement rootCauseTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'txtActContainment')]")
	WebElement containmentActionTextBox;

	@FindBy(xpath = "//textarea[contains(@id,'txtActCorrective')]")
	WebElement correctiveActionTextBox;

	@FindBy(xpath = "//i[contains(@id,'btnActPeople')]")
	WebElement addPeopleBtn;

	@FindBy(xpath = "//span[contains(@class,'l-btn-icon icon-red-delete-round-32')]")
	WebElement closePeoplePanel;

	@FindBy(xpath = "//span[contains(.,'Please enter Description.')]")
	WebElement errorMsgDescTextBox;

	@FindBy(xpath = "//div[contains(.,'notification email has been sent.')]")
	WebElement emailSentConfirmationMsg;

	// Save without filling & back errors
	@FindBy(xpath="//div[text()='You cannot save this Audit as there are still unanswered mandatory questions highlighted in red.']")
	WebElement errorMsgOnSaveAgainstMandatoryFields;

	@FindBy(xpath="//div[@class='bootbox-body'][contains(.,'Are you sure you want to exit?  You will lose any data in this capture if you continue.')]")
	WebElement warningAlertOnWithoutSavingQuestnr;

	@FindBy(xpath = "//button[@data-bb-handler='confirm'][contains(.,'OK')]")
	WebElement okBtn;

	@FindBy(xpath = "//button[@data-bb-handler='cancel'][contains(.,'Cancel')]")
	WebElement cancelBtn;

	@FindBy(xpath="//button[text()='Yes']")
	WebElement yesBtn;

	// Complete & reopen audit
	@FindBy(xpath = "//a[contains(@id,'btnComplete')]")
	WebElement completeBtn;

	@FindBy(xpath="//div[contains(@class,'complete')]")
	WebElement completedRecord;

	@FindBy(xpath = "//a[contains(@id,'btnReopen')]")
	WebElement reopenBtn;

	@FindBy(xpath = "//a[contains(.,'More')]")
	WebElement moreDD;

	@FindBy(xpath="//a[@title='Log']")
	WebElement logOption;

	@FindBy(xpath = "//a[@title='Delete'][contains(.,'Delete')]")
	WebElement deleteBtn;

	@FindBy(xpath = "//a[contains(.,'Export PDF')]")
	WebElement exportToPDFBtn;

	@FindBy(xpath="//label[contains(.,'Internal')]")
	WebElement auditInternal;

	@FindBy(xpath="//label[contains(.,'External')]")
	WebElement auditExternal;

	// Initializing the Page Objects:................................................................
	public CaptureAuditsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_Capture_Audits_tab() {
		Assert.assertTrue(auditsContainer.isDisplayed(), "Capture Audits tab not opened");
		Reporter.log("Capture Audits tab opened successfully", true);

	}

	public void verify_Audit_search_option() {
		List<WebElement> auditList = driver.findElements(By.xpath("//div[@id='ulAudits']//h3"));
		auditSearchBox.sendKeys(auditList.get(0).getText());
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

	public void verify_Create_records_against_the_audit(String audit, String type, 
			String Q1option, String Q2option, String Q3option, String Q4option, String Q5option,
			String Q6option, String Q7option, String Q8option, String Q1Comment, String Q2Comment, String Q5Comment) throws Exception {
		auditSearchBox.sendKeys(audit);
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+audit+"')]")));
		GenericLibrary.waitForAjax(driver);

		try {
			JavascriptLibrary.javascriptClickElement(driver, addBtn);
			GenericLibrary.waitForAjax(driver);
			// Type
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
			GenericLibrary.waitForAjax(driver);
		} catch (Exception e) {
			// Type
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
			GenericLibrary.waitForAjax(driver);
		}
		
		// Q1
		WebElement q1Ans = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q1Ans);
		JavascriptLibrary.javascriptClickElement(driver, q1Ans);
		GenericLibrary.waitForAjax(driver);
		
		WebElement q1Comment = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//textarea"));
		q1Comment.sendKeys(Q1Comment);
		GenericLibrary.waitForAjax(driver);
		
		// Q2
		WebElement q2Ans = driver.findElement(By.xpath("//*[contains(.,'Q2')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q2option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q2Ans);
		JavascriptLibrary.javascriptClickElement(driver, q2Ans);
		GenericLibrary.waitForAjax(driver);
		
		WebElement q2Comment = driver.findElement(By.xpath("//*[contains(.,'Q2')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//textarea"));
		q2Comment.sendKeys(Q2Comment);
		GenericLibrary.waitForAjax(driver);
		
		// Q3
		WebElement q3Ans = driver.findElement(By.xpath("//*[contains(.,'Q3')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q3option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q3Ans);
		JavascriptLibrary.javascriptClickElement(driver, q3Ans);
		GenericLibrary.waitForAjax(driver);
		// Q4
		WebElement q4Ans = driver.findElement(By.xpath("//*[contains(.,'Q4')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q4option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q4Ans);
		JavascriptLibrary.javascriptClickElement(driver, q4Ans);
		GenericLibrary.waitForAjax(driver);
		// Q5
		WebElement q5Ans = driver.findElement(By.xpath("//*[contains(.,'Q5')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q5option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q5Ans);
		JavascriptLibrary.javascriptClickElement(driver, q5Ans);
		GenericLibrary.waitForAjax(driver);
		
		WebElement q5Comment = driver.findElement(By.xpath("//*[contains(.,'Q5')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//textarea"));
		q5Comment.sendKeys(Q5Comment);
		GenericLibrary.waitForAjax(driver);
		
		// Q6
		WebElement q6Ans = driver.findElement(By.xpath("//*[contains(.,'Q6')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q6option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q6Ans);
		JavascriptLibrary.javascriptClickElement(driver, q6Ans);
		GenericLibrary.waitForAjax(driver);
		// Q7
		WebElement q7Ans = driver.findElement(By.xpath("//*[contains(.,'Q7')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q7option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q7Ans);
		JavascriptLibrary.javascriptClickElement(driver, q7Ans);
		GenericLibrary.waitForAjax(driver);
		// Q8
		WebElement q8Ans = driver.findElement(By.xpath("//*[contains(.,'Q8')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q8option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q8Ans);
		JavascriptLibrary.javascriptClickElement(driver, q8Ans);
		GenericLibrary.waitForAjax(driver);

		GenericLibrary.scrollTop(driver);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
	}

	public void verify_Add_activity_for_the_external_audit(String audit, String type, String respoComp, String audComp,
			String Q1option, String Q1Comment, String file, String Q2option, String Q2Comment, 
			String actDesc, String rootcause, String contmtAct, String correctiveAction) throws Exception {
		SoftAssert a= new SoftAssert();
		auditSearchBox.sendKeys(audit);
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+audit+"')]")));
		GenericLibrary.waitForAjax(driver);

		try {
			JavascriptLibrary.javascriptClickElement(driver, addBtn);
			GenericLibrary.waitForAjax(driver);
			// Type
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
			GenericLibrary.waitForAjax(driver);
		} catch (Exception e) {
			// Type
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
			GenericLibrary.waitForAjax(driver);
		}
		companyResponsibleforAudit.sendKeys(respoComp);
		companyBeingAudited.sendKeys(audComp);
		// Q1
		WebElement q1Ans = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q1Ans);
		JavascriptLibrary.javascriptClickElement(driver, q1Ans);
		GenericLibrary.waitForAjax(driver);
		WebElement q1Comment = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//textarea"));
		q1Comment.sendKeys(Q1Comment);
		WebElement q1UploadBtn = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//*[@title='Upload File']"));
		AjaxLibrary.jsClick(driver, q1UploadBtn);
		/*JavascriptLibrary.javascriptClickElement(driver, q1UploadBtn);
		GenericLibrary.waitForAjax(driver);*/
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, file);
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, file);
		Thread.sleep(2000);
		JavascriptLibrary.javascriptClickElement(driver, closeFileUploadPanel);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("File file upload panel closed successfully", true);
		WebElement Q1UploadCount = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//*[contains(@id,'lblCFCount')]"));
		Reporter.log("Q1 upload count: "+Q1UploadCount.getText(), true);
		a.assertTrue(Q1UploadCount.getText().equals("2"), "File upload not functional and upload count not displaying for conforming option");
		Reporter.log("File upload against questionnaire is functional and upload count displayed for conforming option", true);
		// Q2
		WebElement q2Ans = driver.findElement(By.xpath("//*[contains(.,'Q2')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q2option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q2Ans);
		JavascriptLibrary.javascriptClickElement(driver, q2Ans);
		GenericLibrary.waitForAjax(driver);
		WebElement q2Comment = driver.findElement(By.xpath("//*[contains(.,'Q2')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//textarea"));
		q2Comment.sendKeys(Q2Comment);
		WebElement q2UploadBtn = driver.findElement(By.xpath("//*[contains(.,'Q2')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//*[@title='Upload File']"));
		AjaxLibrary.jsClick(driver, q2UploadBtn);
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, file);
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, file);
		Thread.sleep(2000);
		JavascriptLibrary.javascriptClickElement(driver, closeFileUploadPanel);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("File file upload panel closed successfully", true);
		WebElement Q2UploadCount = driver.findElement(By.xpath("//*[contains(.,'Q2')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//*[contains(@id,'lblCFCount')]"));
		Reporter.log("Q2 upload count: "+Q2UploadCount.getText(), true);
		a.assertTrue(Q2UploadCount.getText().equals("2"), "File upload not functional and upload count not displaying for conforming option");
		Reporter.log("File upload against questionnaire is functional and upload count displayed for conforming option", true);
		// Add activity
		// Error message
		JavascriptLibrary.javascriptClickElement(driver, addActivityBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, saveActivityBtn);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(errorMsgDescTextBox.isDisplayed(), "Error message not displayed for actvity description text box");
		Reporter.log("Error message displayed for actvity description", true);
		// Activity
		JavascriptLibrary.javascriptClickElement(driver, targetDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, activeDateBtn);
		actDescTextBox.sendKeys(actDesc);
		GenericLibrary.scrollIntoView(driver, rootCauseTextBox);
		rootCauseTextBox.sendKeys(rootcause);
		GenericLibrary.scrollIntoView(driver, containmentActionTextBox);
		containmentActionTextBox.sendKeys(contmtAct);
		GenericLibrary.scrollIntoView(driver, correctiveActionTextBox);
		correctiveActionTextBox.sendKeys(correctiveAction);
		GenericLibrary.scrollIntoView(driver, addPeopleBtn);
		JavascriptLibrary.javascriptClickElement(driver, addPeopleBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> users = driver.findElements(By.cssSelector(".bs-checkbox>input"));
		JavascriptLibrary.javascriptClickElement(driver, users.get(1));
		JavascriptLibrary.javascriptClickElement(driver, closePeoplePanel);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(.,'Me + 1')]")).isDisplayed(), "People not added to actvity");
		Reporter.log("People added to activity", true);
		AjaxLibrary.jsClick(driver, saveActivityBtn);
		AjaxLibrary.jsClick(driver, sendEmailBtn);
		a.assertTrue(emailSentConfirmationMsg.isDisplayed(), "Email not sent");
		Reporter.log("Activity email sent successfully", true);
		AjaxLibrary.click(driver, By.xpath("//span[contains(.,'Q2')]"));
		WebElement actCount = driver.findElement(By.xpath("//span[@title='Activity']/following-sibling::span[1]"));
		Reporter.log("Q2 activity count: "+actCount.getText(), true);
		a.assertTrue(actCount.getText().contains("1"), "Activity not created and count not displayed");
		Reporter.log("Activity created and count displayed", true);
		a.assertAll();
	}

	public void verify_Error_message_on_save_against_the_mandatory_fields_and_alert_on_hitting_back_button_without_saving_Questionnaire(String audit, String type) throws Exception {
		SoftAssert a= new SoftAssert();
		auditSearchBox.sendKeys(audit);
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+audit+"')]")));
		GenericLibrary.waitForAjax(driver);
		try {
			AjaxLibrary.jsClick(driver, addBtn);
			AjaxLibrary.jsClick(driver, saveBtn);
		} catch (Exception e) {
			JavascriptLibrary.javascriptClickElement(driver, saveBtn);
			GenericLibrary.waitForAjax(driver);
		}
		a.assertTrue(errorMsgOnSaveAgainstMandatoryFields.isDisplayed(), "No error message for mandatory fields");
		Reporter.log("Error message on saving Questionnaire without filling mandatory fields is displayed", true);
		// Type
		/*JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		Thread.sleep(1000);
		a.assertTrue(warningAlertOnWithoutSavingQuestnr.isDisplayed(), "No alert on hitting back without save");
		Reporter.log("Warning alert displayed on hitting back without save is displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, yesBtn);
		GenericLibrary.waitForAjax(driver);
		a.assertAll();*/
	}

	public void verify_Complete_audit_reopen_audit_and_delete_record(String audit, String type, String Q1option) throws Exception {
		SoftAssert a= new SoftAssert();
		auditSearchBox.sendKeys(audit);
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+audit+"')]")));
		GenericLibrary.waitForAjax(driver);
		// fill
		try {
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
			GenericLibrary.waitForAjax(driver);
		} catch (Exception e) {
			JavascriptLibrary.javascriptClickElement(driver, addBtn);
			GenericLibrary.waitForAjax(driver);
			JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//label[contains(.,'"+type+"')]")));
			GenericLibrary.waitForAjax(driver);
		}
		WebElement q1Ans = driver.findElement(By.xpath("//*[contains(.,'Q1')][contains(@class,'field_desc_txt')]//ancestor::div[contains(@id,'FieldRow')]//input[@value='"+Q1option+"']/.."));
		GenericLibrary.scrollIntoView(driver, q1Ans);
		JavascriptLibrary.javascriptClickElement(driver, q1Ans);
		GenericLibrary.waitForAjax(driver);
		// Save & complete 
		GenericLibrary.scrollIntoView(driver, saveBtn);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> records = driver.findElements(By.xpath("//span[contains(.,'ID')]"));
		a.assertTrue(records.size() != 0, "Record not created");
		Reporter.log("Record created", true);
		JavascriptLibrary.javascriptClickElement(driver, records.get(0));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, completeBtn);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(completedRecord.isDisplayed(), "Record not completed");
		Reporter.log("Record completed and Grayed out", true);
		JavascriptLibrary.javascriptClickElement(driver, completedRecord);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, reopenBtn);
		Thread.sleep(1000);
		GenericLibrary.checkAlert_Accept(driver);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(completeBtn.isDisplayed(), "Record not reopened");
		Reporter.log("Record reopend", true);
		GenericLibrary.hoverWebelement(driver, moreDD);
		JavascriptLibrary.javascriptClickElement(driver, deleteBtn);
		Thread.sleep(1000);
		GenericLibrary.checkAlert_Accept(driver);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Record deleted", true);
		a.assertAll();
	}

	public void verify_Export_to_PDF_option(String audit, String downloadPath, String fileName) throws Exception {
		auditSearchBox.sendKeys(audit);
		GenericLibrary.click(driver, auditSearchBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+audit+"')]")));
		GenericLibrary.waitForAjax(driver);
		try {
			GenericLibrary.hoverWebelement(driver, moreDD);
		} catch (Exception e) {
			JavascriptLibrary.javascriptClickElement(driver, addBtn);
			GenericLibrary.waitForAjax(driver);
			GenericLibrary.hoverWebelement(driver, moreDD);
		}
		JavascriptLibrary.javascriptClickElement(driver, exportToPDFBtn);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(3000);
	}

}