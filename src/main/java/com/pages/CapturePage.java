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

public class CapturePage extends BasePage {
	// Initializing the Page Objects:................................................................
	public CapturePage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	//Page Title Verification
	@FindBy(xpath="//a[text()='Capture']")
	WebElement captureText;

	@FindBy(xpath=".//*[@id='txtSearch']")
	static WebElement searchBox;

	@FindBy(css=".fa.fa-search")
	static WebElement searchBtn;

	@FindBy(xpath="//a[@title='Add Record']")
	WebElement addBtn;
	
	static By saveBtn = By.xpath(".//*[@id='btnSave']");
	/*@FindBy(xpath=".//*[@id='btnSave']")
	static WebElement saveBtn;*/

	// Navigating to Questionnaires
	@FindBy(xpath=".//*[@id='btnFolderBack']")
	WebElement folderBackBtn;

	@FindBy(xpath="//h3[text()='Demo1']")
	WebElement demo1Folder;

	@FindBy(xpath="//h3[text()='Demo2']")
	WebElement demo2Folder;

	@FindBy(xpath="//h3[text()='HR Maintenance']")
	WebElement findQuestionnaire;

	// Text capture
	@FindBy(xpath="//span[text()='1.']")
	WebElement L1;

	@FindBy(xpath="//span[text()='1.1.']")
	WebElement L2;

	@FindBy(xpath="//span[text()='1.1.1.']")
	WebElement L3;

	@FindBy(xpath="//span[text()='1.1.1.1.']")
	WebElement L4;

	@FindBy(xpath="//span[text()='1.1.1.1.1.']")
	WebElement L5;

	@FindBy(xpath="(//span[text()='1.']/following::input)[1]")
	WebElement L1TextBox;

	@FindBy(xpath="(//span[text()='1.1.']/following::input)[1]")
	WebElement L2TextBox;

	@FindBy(xpath="(//span[text()='1.1.1.']/following::input)[1]")
	WebElement L3TextBox;

	@FindBy(xpath="(//span[text()='1.1.1.1.']/following::input)[1]")
	WebElement L4TextBox;

	@FindBy(xpath="(//span[text()='1.1.1.1.1.']/following::input)[1]")
	WebElement L5TextBox;

	@FindBy(xpath="//div[contains(.,'You cannot save this iQapture as there are still unanswered mandatory questions highlighted in red.')]")
	WebElement alertOnSaveWithoutFillingMandatory;

	@FindBy(xpath="//div[contains(.,'You cannot complete this iQapture as there are still unanswered mandatory questions highlighted in red.')]")
	WebElement alertOnCompleteWithoutFillingMandatory;

	@FindBy(xpath="(//span[text()='4.']/following::input)[1]")
	WebElement mandatoryOnSaveTextBox;

	@FindBy(xpath="(//span[text()='5.']/following::input)[1]")
	WebElement mandatoryOnCompleteTextBox;

	@FindBy(xpath="(//span[text()='6.']/following::input)[1]")
	WebElement commentQAns;

	@FindBy(xpath="(//span[text()='6.']/following::textarea)[1]")
	WebElement commentTextBox;

	@FindBy(xpath="(//span[text()='7.']/following::input)[1]")
	WebElement additionalQAnsTextBox;

	@FindBy(xpath="(//span[text()='7.']/following::input)[2]")
	WebElement additionalQAnsTextBox2;

	@FindBy(xpath="//span[@class='capture-answer-btn capture-answer-add']")
	WebElement addBtn_additionalAns;

	@FindBy(xpath="//span[@class='capture-answer-btn capture-answer-remove']")
	WebElement removeBtn_additionalAns;

	@FindBy(xpath="(//span[text()='8.']/following::input)[1]")
	WebElement hintQTextBox;

	@FindBy(xpath="//div[@class='inline-block tooltips']")
	WebElement hintToolTip;

	@FindBy(xpath="(//span[text()='9.']/following::input)[1]")
	WebElement smtbCompareTextBox;

	@FindBy(xpath="(//span[text()='10.']/following::input)[1]")
	WebElement smtbCompareTextBox2;

	@FindBy(xpath="(//span[text()='10.']/following::input)[1]/..")
	WebElement colour_smtbCompareTextBox2;

	@FindBy(xpath="(//span[text()='11.']/following::textarea)[1]")
	WebElement largeTB;

	@FindBy(xpath="(//span[text()='12.']/following::textarea)[1]")
	WebElement largeTB2;

	// MultiChoice Capture
	@FindBy(xpath="//span[text()='6.']/following::textarea[1]")
	WebElement mcCommentTextBox;

	@FindBy(xpath="//span[text()='11.']/following::div[1]")
	WebElement mcDD1;

	@FindBy(xpath="//span[text()='12.']/following::div[1]")
	WebElement mcDD2;

	@FindBy(xpath="//span[text()='12.']/following::span[3]")
	WebElement colour_mcDD2;

	@FindBy(xpath="//span[text()='13.']/following::div[1]")
	WebElement searchableDD1;

	@FindBy(xpath="//span[text()='14.']/following::div[1]")
	WebElement searchableDD2;

	@FindBy(xpath="//input[@type='search']")
	WebElement ddSearchBox;

	@FindBy(xpath="//span[text()='14.']/following::span[3]")
	WebElement colour_searchableDD2;

	@FindBy(xpath="//span[text()='15.']/following::span[1]")
	WebElement cb1;

	@FindBy(xpath="//span[text()='15.']/following::span[2]")
	WebElement cb2;

	@FindBy(xpath="//span[text()='15.']//preceding::span[1]")
	WebElement checkBoxScore;

	// Date
	@FindBy(xpath="(//span[text()='6.']/following::textarea)[1]")
	WebElement dateCommentTextBox;

	@FindBy(xpath="(//span[text()='12.']/following::input)[1]/../..")
	WebElement colour_DateFormat1;

	@FindBy(xpath="(//span[text()='14.']/following::input)[1]/../..")
	WebElement colour_DateFormat2;

	@FindBy(xpath = "//button[contains(@title,'Toggle Period')]")
	WebElement togglePeriodBtn;

	@FindBy(xpath="(//span[text()='16.']/following::input)[1]/../..")
	WebElement colour_DateFormat3;

	@FindBy(xpath="(//span[text()='18.']/following::input)[1]/../..")
	WebElement colour_DateFormat4;

	// Number
	@FindBy(xpath="(//span[text()='9.']/following::input)[1]")
	WebElement floatNumberBox;

	@FindBy(xpath="(//span[text()='10.']/following::input)[1]")
	WebElement percentageNumberBox;

	@FindBy(xpath="(//span[text()='11.']/following::input)[1]")
	WebElement currencyNumberBox;

	@FindBy(xpath="//div[@class='noUi-origin noUi-background']")
	WebElement sliderBar;

	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-lower']")
	WebElement slider;

	@FindBy(xpath="//strong[text()='Value:' or text()='Barrier:']/following-sibling::span[1]")
	WebElement sliderValue;

	// Upload file
	@FindBy(xpath="(//span[text()='1.']/following::span)[1]")
	WebElement L1UploadBtn;

	@FindBy(id="fieldImgDropzone")
	WebElement fileBrowseBtn;

	@FindBy(xpath="(//span[text()='1.']/following::span)[2]")
	WebElement L1NoOfFiles;

	@FindBy(xpath="(//span[text()='4.']/following::span)[2]")
	WebElement mandatoryOnSaveUploadBtn;

	@FindBy(xpath="(//span[text()='4.']/following::span)[3]")
	WebElement mnsNoOfFiles;

	@FindBy(xpath="(//span[text()='5.']/following::span)[2]")
	WebElement mandatoryOnCompleteUploadBtn;

	@FindBy(xpath="(//span[text()='5.']/following::span)[3]")
	WebElement mncNoOfFiles;

	// Activity
	@FindBy(xpath="(//span[text()='1.']/following::span)[1]")
	WebElement L1ActBtn;

	@FindBy(xpath="(//span[text()='1.']/following::span)[2]")
	WebElement noOfActL1;

	@FindBy(xpath = "//a[contains(@id,'btnAtcSave')]")
	WebElement activitySaveBtn;

	@FindBy(xpath = "//a[contains(@id,'btnSendEmail')]")
	WebElement sendEmailBtn;

	@FindBy(xpath="//div[text()='A notification email has been sent.']")
	WebElement emailConfirmationMsg;

	@FindBy(xpath=".//*[@id='btnActDate']/span/span")
	WebElement targetDateBtn;

	@FindBy(xpath="//td[contains(@class,'day active')]")
	WebElement activeDateBtn;

	@FindBy(xpath=".//*[@id='txtActDesc']")
	WebElement descriptionTextBox;

	@FindBy(xpath=".//*[@id='txtActComment']")
	WebElement commenTextBox;

	@FindBy(xpath="(//span[text()='4.']/following::span)[2]")
	WebElement mandatoryOnSaveActBtn;

	@FindBy(xpath="(//span[text()='4.']/following::span)[3]")
	WebElement noOfActMandatoryOnSave;

	@FindBy(xpath="(//span[text()='4.']/following::span)[2]")
	WebElement mandatoryOnCompleteActBtn;

	@FindBy(xpath="(//span[text()='4.']/following::span)[3]")
	WebElement noOfActmandatoryOnComplete;

	// Advanced
	@FindBy(xpath="(//span[text()='4.']/following::textarea)[1]")
	WebElement advanceCommentTextBox;

	@FindBy(xpath="(//span[text()='5.']/following::input)[1]")
	WebElement additionalAnsheader1;

	@FindBy(xpath="(//span[text()='5.']/following::input)[2]")
	WebElement additionalAnsheader2;

	@FindBy(xpath="(//span[text()='11.']/following::textarea)[1]")
	WebElement wizardField;

	@FindBy(xpath="(//span[text()='11_a.']/following::input)[1]")
	WebElement wizardQa;

	@FindBy(xpath="(//span[text()='11_b.']/following::input)[1]")
	WebElement wizardQb;

	@FindBy(xpath="(//span[text()='11_c.']/following::input)[1]")
	WebElement wizardQc;

	@FindBy(xpath="(//span[text()='11_d.']/following::input)[1]")
	WebElement wizardQd;

	@FindBy(xpath="(//span[text()='11_e.']/following::input)[1]")
	WebElement wizardQe;

	@FindBy(xpath="(//span[text()='12.']/following::input)[1]")
	WebElement tableWithoutHeader;

	// Section 
	@FindBy(xpath="(//span[text()='5.']/following::div[@class='media-body']/div)[1]")
	WebElement sectionDescription;

	// Complete & Reopen
	static By completeBtn = By.xpath(".//*[@id='btnComplete']");
	/*@FindBy(xpath=".//*[@id='btnComplete']")
	static WebElement completeBtn;*/

	@FindBy(xpath="//tr[1]/td[2]")
	WebElement latestRecord;

	@FindBy(xpath=".//*[@id='btnReopen']")
	WebElement reOpenBtn;

	@FindBy(xpath = "//button[@data-bb-handler='confirm'][contains(.,'OK')]")
	WebElement OkBtn;

	// Settings Questionnaire
	@FindBy(xpath="//h3[text()='Q/Settings']")
	WebElement settings_Q;

	@FindBy(xpath="(//label[contains(.,'High')])[1]")
	WebElement Q1_High;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement Q2_textBox;

	@FindBy(xpath = "(//label[contains(.,'Medium')])[2]")
	WebElement Q3_Medium;

	@FindBy(css="#btnPageBack")
	WebElement backBtn;

	@FindBy(xpath=".//*[@id='btnMore']/a")
	WebElement moreBtn;

	@FindBy(xpath=".//*[@id='deleteRecord']/a")
	WebElement deleteRecoredBtn;

	// Score multiply and strike out
	@FindBy(xpath="//tr[1]/td[4]/div")
	WebElement strikedOutLine;

	// Analyse Questionnaire 
	@FindBy(xpath="//span[text()='17.']//following::span[2]")
	WebElement joiningDateBtn;

	@FindBy(xpath="//span[text()='18.']//following::span[2]")
	WebElement exitDateBtn;

	@FindBy(xpath="//span[text()='24.']//following::select[1]")
	WebElement dropDown_Q1;

	By employeeNumber = By.xpath("(//span[text()='2.']/following::input)[1]");
	By employeeName = By.xpath("(//span[text()='3.']/following::input)[1]");
	By employeeFee = By.xpath("(//span[text()='6.']/following::input)[1]");
	By employeeFormFee = By.xpath("(//span[text()='7.']/following::input)[1]");
	By employeeRegistrationFee = By.xpath("(//span[text()='8.']/following::input)[1]");
	By sscMarks = By.xpath("(//span[text()='10.']/following::input)[1]");
	By interMarks = By.xpath("(//span[text()='11.']/following::input)[1]");
	By graduationMarks = By.xpath("(//span[text()='12.']/following::input)[1]");
	By mastersMarks = By.xpath("(//span[text()='13.']/following::input)[1]");

	// Assign
	@FindBy(xpath = "//a[contains(@title,'Assign')]")
	WebElement assignBtn;

	@FindBy(xpath = "//span[contains(@title,'User Name')]")
	WebElement userField;

	@FindBy(xpath="//input[@type='search']")
	WebElement userSearchField;

	@FindBy(xpath = "//input[contains(@id,'assignTarget')]")
	WebElement assignTargetField;

	@FindBy(xpath=".//*[@id='dlgAssign']//following::span[contains(text(),'Day')]")
	WebElement swicthToHourBtn;

	@FindBy(xpath=".//*[@id='dlgAssign']//following::div[@class='modal-footer']//button[contains(text(),'Close')]")
	WebElement closeBtn_AssignWindow;

	@FindBy(xpath=".//*[@id='dlgAssign']//following::div[@class='modal-footer']//button[contains(text(),'Ok')]")
	WebElement okBtn_AssignWindow;

	@FindBy(xpath="//span[contains(@id,'divError_User')]")
	WebElement userFiledErrorMsg;

	@FindBy(xpath = "//span[contains(@id,'divError_Target')]")
	WebElement targetFieldErrorMsg;
















	// Actions:......................................................................................
	public String verifyPageTitle() {
		return captureText.getText();
	}

	public void verify_Capture_Text_questionnaire(String Questionnaire, String nm, 
			String L1Ans, String L2Ans, String L3Ans, String L4Ans, String L5Ans, 
			String nmAns, String nnAns, String mandySaveAns, String mandyCompleteAns, 
			String commentAns, String comment, String additionalAns, String additionalAns2, 
			String hintQAns, String actHint, String smtbCompareAns, String smtbCompareAns2, 
			String largeAns, String largeAns2) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		AjaxLibrary.jsType(driver, L1TextBox, L1Ans);
		AjaxLibrary.jsType(driver, L2TextBox, L2Ans);
		AjaxLibrary.jsType(driver, L3TextBox, L3Ans);
		AjaxLibrary.jsType(driver, L4TextBox, L4Ans);
		AjaxLibrary.jsType(driver, L5TextBox, L5Ans);
		AjaxLibrary.jsType(driver, driver.findElement(By.xpath("(//span[text()='"+nm+".']/following::input)[1]")), nmAns);
		AjaxLibrary.jsType(driver, driver.findElement(By.xpath("(//span[text()='"+nm+".']/following::input)[2]")), nnAns);
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertTrue(alertOnSaveWithoutFillingMandatory.isDisplayed(), "No alert on save without filling mandatory");
		Reporter.log("Alert on save without filling mandatory is displayed", true);
		AjaxLibrary.jsType(driver, mandatoryOnSaveTextBox, mandySaveAns);	
		AjaxLibrary.jsClick(driver, completeBtn);
		a.assertTrue(alertOnCompleteWithoutFillingMandatory.isDisplayed(), "No alert on complete without filling mandatory");
		Reporter.log("Alert on complete without filling mandatory is displayed", true);
		AjaxLibrary.jsType(driver, mandatoryOnCompleteTextBox, mandyCompleteAns);
		AjaxLibrary.jsType(driver, commentQAns, commentAns);
		AjaxLibrary.jsType(driver, commentTextBox, comment);
		AjaxLibrary.jsType(driver, additionalQAnsTextBox, additionalAns);
		AjaxLibrary.jsClick(driver, addBtn_additionalAns);
		AjaxLibrary.jsType(driver, additionalQAnsTextBox2, additionalAns2);
		AjaxLibrary.jsClick(driver, removeBtn_additionalAns);
		AjaxLibrary.jsType(driver, hintQTextBox, hintQAns);
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		AjaxLibrary.jsType(driver, smtbCompareTextBox, smtbCompareAns);
		AjaxLibrary.jsType(driver, smtbCompareTextBox2, smtbCompareAns2);
		a.assertTrue(colour_smtbCompareTextBox2.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing small text boxes with different answers");
		Reporter.log("Red colour displayed on comparing small text boxes with different answers", true);
		AjaxLibrary.clearAndType(driver, smtbCompareTextBox2, smtbCompareAns);
		a.assertTrue(colour_smtbCompareTextBox2.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing small text boxes with different answers");
		Reporter.log("Green colour displayed on comparing small text boxes with different answers", true);
		AjaxLibrary.jsType(driver, largeTB, largeAns);
		AjaxLibrary.jsType(driver, largeTB2, largeAns2);
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_MultiChoice_questionnaire(String Questionnaire, String nm, 
			String mandyOnSaveOpt, String mandyOnCompleteOpt, String comment, String actHint, 
			String compare, String compare2, String option1, String option2, String searchOption, 
			String searchOption2, String cbScore1, String cbScore2, String copyQopt) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		// Levels
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		// Mandatory 
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertTrue(alertOnSaveWithoutFillingMandatory.isDisplayed(), "No alert on save without filling mandatory");
		Reporter.log("Alert on save without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='4.']/following::label[text()[normalize-space()='"+mandyOnSaveOpt+"']][1]")));
		AjaxLibrary.jsClick(driver, completeBtn);
		a.assertTrue(alertOnCompleteWithoutFillingMandatory.isDisplayed(), "No alert on complete without filling mandatory");
		Reporter.log("Alert on complete without filling mandatory is displayed", true);
		// Comment 
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='5.']/following::label[text()[normalize-space()='"+mandyOnCompleteOpt+"']][1]")));
		AjaxLibrary.jsType(driver, mcCommentTextBox, comment);
		// Hint
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		// Radio
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='9.']/following::label[text()[normalize-space()='"+compare+"']][1]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='10.']/following::label[text()[normalize-space()='"+compare2+"']][1]")));
		a.assertTrue(driver.findElement(By.xpath("//span[text()='10.']/following::label[text()[normalize-space()='"+compare2+"']][1]")).getAttribute("class").contains("red"), 
				"Red colour NOT displayed on comparing radio buttons with different answers");
		Reporter.log("Red colour displayed on comparing radio buttons with different answers", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='10.']/following::label[text()[normalize-space()='"+compare+"']][1]")));
		a.assertTrue(driver.findElement(By.xpath("//span[text()='10.']/following::label[text()[normalize-space()='"+compare+"']][1]")).getAttribute("class").contains("green"), 
				"Green colour NOT displayed on comparing radio buttons with same answers");
		Reporter.log("Green colour displayed on comparing radio buttons with same answers", true);
		// DD
		AjaxLibrary.click(driver, mcDD1);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+option1+"')]")));
		AjaxLibrary.click(driver, mcDD2);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+option2+"')]")));
		a.assertTrue(colour_mcDD2.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing drop downs with different answers");
		Reporter.log("Red colour displayed on comparing drop downs with different answers", true);
		AjaxLibrary.click(driver, mcDD2);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+option1+"')]")));
		a.assertTrue(colour_mcDD2.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing drop downs with same answers");
		Reporter.log("Green colour displayed on comparing drop downs with same answers", true);
		// Searchable DD
		AjaxLibrary.click(driver, searchableDD1);
		ddSearchBox.sendKeys(searchOption);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+searchOption+"')]")));
		AjaxLibrary.click(driver, searchableDD2);
		ddSearchBox.sendKeys(searchOption2);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+searchOption2+"')]")));
		a.assertTrue(colour_searchableDD2.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing searchable drop downs with different answers");
		Reporter.log("Red colour displayed on comparing searchable drop downs with different answers", true);
		AjaxLibrary.click(driver, searchableDD2);
		ddSearchBox.sendKeys(searchOption);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+searchOption+"')]")));
		a.assertTrue(colour_searchableDD2.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing searchable drop downs with same answers");
		Reporter.log("Green colour displayed on comparing searchable drop downs with same answers", true);
		// Check box
		JavascriptLibrary.javascriptClickElement(driver, cb1);
		int expScore1 = Integer.parseInt(cbScore1.replace(".0", ""));
		a.assertEquals(Integer.parseInt(checkBoxScore.getText()), expScore1, "Checkbox 1 score not displayed");
		Reporter.log("Checkbox 1 score displayed", true);
		int expScore2 = Integer.parseInt(cbScore2.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, cb2);
		a.assertEquals(Integer.parseInt(checkBoxScore.getText()), (expScore1+expScore2), "Checkbox 2 score not displayed");
		Reporter.log("Checkbox 2 score displayed", true);
		// Copies Question
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='16.']/following::label[text()[normalize-space()='"+copyQopt+"']][1]")));
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_Date_questionnaire(String Questionnaire, String nm, String comment, String actHint) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='1.']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c1 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c1) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='1.1.']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c2 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c2) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='1.1.1.']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c3 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c3) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='1.1.1.1.']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c4 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c4) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='1.1.1.1.1.']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c5 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c5) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+nm+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c6 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c6) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+nm+".']/following::span[@class='fa fa-calendar'])[2]")));
		List<WebElement> c7 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c7) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertTrue(alertOnSaveWithoutFillingMandatory.isDisplayed(), "No alert on save without filling mandatory");
		Reporter.log("Alert on save without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+4+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c8 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c8) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, completeBtn);
		a.assertTrue(alertOnCompleteWithoutFillingMandatory.isDisplayed(), "No alert on complete without filling mandatory");
		Reporter.log("Alert on complete without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+5+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c9 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c9) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+6+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c10 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c10) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsType(driver, dateCommentTextBox, comment);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+7+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c11 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c11) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+8+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c12 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c12) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+9+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c13 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c13) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, addBtn_additionalAns);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+9+".']/following::span[@class='fa fa-calendar'])[2]")));
		List<WebElement> c14 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c14) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, removeBtn_additionalAns);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+10+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c15 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c15) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		// Format 1
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+11+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c16 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c16) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+12+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c17 = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < c17.size(); i++) {
			if (c17.get(i).getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, c17.get(i+1));
				break;
			}
		}
		a.assertTrue(colour_DateFormat1.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing date formate 1 with different answers");
		Reporter.log("Red colour displayed on comparing date formate 1 with different answers", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+12+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c18 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c18) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		// Format 2
		a.assertTrue(colour_DateFormat1.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing date formate 1 with same answers");
		Reporter.log("Green colour displayed on comparing date formate 1 with same answers", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+13+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c19 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c19) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+14+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c20 = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < c20.size(); i++) {
			if (c20.get(i).getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, c20.get(i+1));
				break;
			}
		}
		a.assertTrue(colour_DateFormat2.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing date formate 2 with different answers");
		Reporter.log("Red colour displayed on comparing date formate 2 with different answers", true);
		//AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+14+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c21 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c21) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		a.assertTrue(colour_DateFormat2.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing date formate 2 with same answers");
		Reporter.log("Green colour displayed on comparing date formate 2 with same answers", true);
		// Format 3
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+15+".']/following::span[@class='fa fa-calendar'])[1]")));
		AjaxLibrary.jsClick(driver, togglePeriodBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+16+".']/following::span[@class='fa fa-calendar'])[1]")));
		AjaxLibrary.jsClick(driver, togglePeriodBtn);
		AjaxLibrary.jsClick(driver, togglePeriodBtn);
		a.assertTrue(colour_DateFormat3.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing date formate 3 with different answers");
		Reporter.log("Red colour displayed on comparing date formate 3 with different answers", true);
		//AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+16+".']/following::span[@class='fa fa-calendar'])[1]")));
		AjaxLibrary.jsClick(driver, togglePeriodBtn);
		a.assertTrue(colour_DateFormat3.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing date formate 3 with same answers");
		Reporter.log("Green colour displayed on comparing date formate 3 with same answers", true);
		// Format 4
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+17+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c22 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c22) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+18+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c23 = driver.findElements(By.cssSelector(".day"));
		for (int i = 0; i < c23.size(); i++) {
			if (c23.get(i).getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, c23.get(i+1));
				break;
			}
		}
		a.assertTrue(colour_DateFormat4.getAttribute("class").contains("red"), "Red colour NOT displayed on comparing date formate 1 with different answers");
		Reporter.log("Red colour displayed on comparing date formate 4 with different answers", true);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//span[text()='"+18+".']/following::span[@class='fa fa-calendar'])[1]")));
		List<WebElement> c24 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : c24) {
			if (ele.getAttribute("class").equals("day today")) {
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		a.assertTrue(colour_DateFormat4.getAttribute("class").contains("green"), "Green colour NOT displayed on comparing date formate 4 with same answers");
		Reporter.log("Green colour displayed on comparing date formate 4 with same answers", true);
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_Number_questionnaire(String Questionnaire, String nm, 
			String L1Ans, String L2Ans, String L3Ans, String L4Ans, String L5Ans, 
			String nmAns, String nnAns, String mandySaveAns, String mandyCompleteAns, 
			String commentAns, String comment, String additionalAns, String additionalAns2, 
			String hintQAns, String actHint, String floatQAns, String percentageQAns, String currencyQAns, 
			String sliderChoice) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		AjaxLibrary.jsType(driver, L1TextBox, L1Ans.replace(".0", ""));
		AjaxLibrary.jsType(driver, L2TextBox, L2Ans.replace(".0", ""));
		AjaxLibrary.jsType(driver, L3TextBox, L3Ans.replace(".0", ""));
		AjaxLibrary.jsType(driver, L4TextBox, L4Ans.replace(".0", ""));
		AjaxLibrary.jsType(driver, L5TextBox, L5Ans.replace(".0", ""));
		AjaxLibrary.jsType(driver, driver.findElement(By.xpath("(//span[text()='"+nm+".']/following::input)[1]")), nmAns.replace(".0", ""));
		AjaxLibrary.jsType(driver, driver.findElement(By.xpath("(//span[text()='"+nm+".']/following::input)[2]")), nnAns.replace(".0", ""));
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertTrue(alertOnSaveWithoutFillingMandatory.isDisplayed(), "No alert on save without filling mandatory");
		Reporter.log("Alert on save without filling mandatory is displayed", true);
		AjaxLibrary.jsType(driver, mandatoryOnSaveTextBox, mandySaveAns.replace(".0", ""));	
		AjaxLibrary.jsClick(driver, completeBtn);
		a.assertTrue(alertOnCompleteWithoutFillingMandatory.isDisplayed(), "No alert on complete without filling mandatory");
		Reporter.log("Alert on complete without filling mandatory is displayed", true);
		AjaxLibrary.jsType(driver, mandatoryOnCompleteTextBox, mandyCompleteAns.replace(".0", ""));
		AjaxLibrary.jsType(driver, commentQAns, commentAns.replace(".0", ""));
		AjaxLibrary.jsType(driver, commentTextBox, comment);
		AjaxLibrary.jsType(driver, additionalQAnsTextBox, additionalAns.replace(".0", ""));
		AjaxLibrary.jsClick(driver, addBtn_additionalAns);
		AjaxLibrary.jsType(driver, additionalQAnsTextBox2, additionalAns2.replace(".0", ""));
		AjaxLibrary.jsClick(driver, removeBtn_additionalAns);
		AjaxLibrary.jsType(driver, hintQTextBox, hintQAns);
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		AjaxLibrary.jsType(driver, floatNumberBox, floatQAns);
		AjaxLibrary.jsType(driver, percentageNumberBox, percentageQAns);
		AjaxLibrary.jsType(driver, currencyNumberBox, currencyQAns);
		// Slider
		String v1 = sliderValue.getText();
		Reporter.log("Slider value before: "+v1, true);
		GenericLibrary.sliderDragAndDrap(driver, sliderBar, slider, sliderChoice.replace(".0", ""));
		String v2 = sliderValue.getText();
		Reporter.log("Slider value after: "+v2, true);
		a.assertNotEquals(v1, v2, "Slider option is not working");
		Reporter.log("Slider option is working", true);
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_Upload_file_questionnaire(String Questionnaire, String nm, 
			String filePath, String comment, String actHint) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		// Levels
		AjaxLibrary.jsClick(driver, L1UploadBtn);
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, filePath);
		AjaxLibrary.click(driver, L1UploadBtn);
		a.assertEquals(L1NoOfFiles.getText(), "1", "No file uploaded for the Question");
		Reporter.log("File uploaded for the Question", true);
		// Mandatory on save
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertTrue(alertOnSaveWithoutFillingMandatory.isDisplayed(), "No alert on save without filling mandatory");
		Reporter.log("Alert on save without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, mandatoryOnSaveUploadBtn);
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, filePath);
		AjaxLibrary.click(driver, mandatoryOnSaveUploadBtn);
		a.assertEquals(mnsNoOfFiles.getText(), "1", "No file uploaded for the mandatory on save Question");
		Reporter.log("File uploaded for the mandatory on save Question", true);
		// Mandatory on complete
		AjaxLibrary.jsClick(driver, completeBtn);
		a.assertTrue(alertOnCompleteWithoutFillingMandatory.isDisplayed(), "No alert on complete without filling mandatory");
		Reporter.log("Alert on complete without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, mandatoryOnCompleteUploadBtn);
		AjaxLibrary.uploadFile(driver, fileBrowseBtn, filePath);
		AjaxLibrary.click(driver, mandatoryOnCompleteUploadBtn);
		a.assertEquals(mncNoOfFiles.getText(), "1", "No file uploaded for the mandatory on complete Question");
		Reporter.log("File uploaded for the mandatory on complete Question", true);
		// Comment
		AjaxLibrary.jsType(driver, commentTextBox, comment);
		// Hint
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_Activity_questionnaire(String Questionnaire, String nm, 
			String actDesc, String actComment, String comment, String actHint) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		/*
		// L1
		AjaxLibrary.jsClick(driver, L1ActBtn);
		AjaxLibrary.jsClick(driver, targetDateBtn);
		AjaxLibrary.jsClick(driver, activeDateBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, actDesc);
		AjaxLibrary.jsType(driver, commenTextBox, actComment);
		AjaxLibrary.jsClick(driver, activitySaveBtn);
		a.assertTrue(noOfActL1.isDisplayed(), "L1 Activity not captured");
		Reporter.log("L1 Activity captured", true);
		AjaxLibrary.jsClick(driver, sendEmailBtn);
		a.assertEquals(emailConfirmationMsg.getText(), "A notification email has been sent.", "No confirmation message for emails sent");
		Reporter.log("Confirmation message for emails sent displayed");
		// Mandatory on save
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertTrue(alertOnSaveWithoutFillingMandatory.isDisplayed(), "No alert on save without filling mandatory");
		Reporter.log("Alert on save without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, mandatoryOnSaveActBtn);
		AjaxLibrary.jsClick(driver, targetDateBtn);
		AjaxLibrary.jsClick(driver, activeDateBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, actDesc);
		AjaxLibrary.jsType(driver, commenTextBox, actComment);
		AjaxLibrary.jsClick(driver, activitySaveBtn);
		a.assertTrue(noOfActMandatoryOnSave.isDisplayed(), "Mandatory on save Activity not captured");
		Reporter.log("Mandatory on save Activity captured", true);
		AjaxLibrary.jsClick(driver, sendEmailBtn);
		a.assertEquals(emailConfirmationMsg.getText(), "A notification email has been sent.", "No confirmation message for emails sent");
		Reporter.log("Confirmation message for emails sent displayed");
		// mandatory on complete
		AjaxLibrary.jsClick(driver, completeBtn);
		a.assertTrue(alertOnCompleteWithoutFillingMandatory.isDisplayed(), "No alert on complete without filling mandatory");
		Reporter.log("Alert on complete without filling mandatory is displayed", true);
		AjaxLibrary.jsClick(driver, mandatoryOnCompleteActBtn);
		AjaxLibrary.jsClick(driver, targetDateBtn);
		AjaxLibrary.jsClick(driver, activeDateBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, actDesc);
		AjaxLibrary.jsType(driver, commenTextBox, actComment);
		AjaxLibrary.jsClick(driver, activitySaveBtn);
		a.assertTrue(noOfActmandatoryOnComplete.isDisplayed(), "Mandatory on complete Activity not captured");
		Reporter.log("Mandatory on complete Activity captured", true);
		AjaxLibrary.jsClick(driver, sendEmailBtn);
		a.assertEquals(emailConfirmationMsg.getText(), "A notification email has been sent.", "No confirmation message for emails sent");
		Reporter.log("Confirmation message for emails sent displayed");
		// Comment
		AjaxLibrary.jsType(driver, commentTextBox, comment);
		// Hint
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		// Compare
		// Compare 1

		// Compare 2

		 */
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_Advanced_questionnaire(String Questionnaire, String nm, 
			String comment, String additionalAns, String additionalAns2, String actHint, 
			String wQa, String wQb, String wQc, String wQd, String wQe, String noHeaderField) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		// Comment
		AjaxLibrary.jsType(driver, advanceCommentTextBox, comment);
		// Additional answers
		AjaxLibrary.jsType(driver, additionalAnsheader1, additionalAns);
		AjaxLibrary.jsClick(driver, addBtn_additionalAns);
		AjaxLibrary.jsType(driver, additionalAnsheader2, additionalAns2);
		AjaxLibrary.jsClick(driver, removeBtn_additionalAns);
		// Hint
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, actHint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		// Wizard
		AjaxLibrary.jsType(driver, wizardQa, wQa);
		AjaxLibrary.jsType(driver, wizardQb, wQb);
		AjaxLibrary.jsType(driver, wizardQc, wQc);
		AjaxLibrary.jsType(driver, wizardQd, wQd);
		AjaxLibrary.jsType(driver, wizardQe, wQe);
		// Table without header
		AjaxLibrary.jsType(driver, tableWithoutHeader, noHeaderField);

		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Capture_Section_questionnaire(String Questionnaire, String nm, 
			String desc, String hint) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		JavascriptLibrary.javascriptType(driver, searchBox, Questionnaire);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+Questionnaire+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		a.assertTrue(L1.isDisplayed(), "'Level 1' Question number NOT displayed");
		Reporter.log("'Level 1' Question number displayed", true);
		a.assertTrue(L2.isDisplayed(), "'Level 2' Question number NOT displayed");
		Reporter.log("'Level 2' Question number displayed", true);
		a.assertTrue(L3.isDisplayed(), "'Level 3' Question number NOT displayed");
		Reporter.log("'Level 3' Question number displayed", true);
		a.assertTrue(L4.isDisplayed(), "'Level 4' Question number NOT displayed");
		Reporter.log("'Level 4' Question number displayed", true);
		a.assertTrue(L5.isDisplayed(), "'Level 5' Question number NOT displayed");
		Reporter.log("'Level 5' Question number displayed", true);
		a.assertTrue(driver.findElement(By.xpath("//span[text()='"+nm+".']")).isDisplayed(), "Manually added Question number NOT displayed");
		Reporter.log("Manually added Question number displayed", true);
		a.assertEquals(sectionDescription.getText(), desc, "Section description not displayed");
		Reporter.log("Section description displayed", true);
		String tt = GenericLibrary.getToolTip2(hintToolTip, "data-original-title");
		a.assertEquals(tt, hint, "Hint not displayed");
		Reporter.log("Hint is displated", true);
		AjaxLibrary.jsClick(driver, saveBtn);
		a.assertAll();
	}

	public void verify_Complete_Reopen_Questionnaire(String searchItem) throws Exception {
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+searchItem+"']")));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, completeBtn);
		Reporter.log("Questionnaire Completed Successfully",true);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, latestRecord);
		JavascriptLibrary.javascriptClickElement(driver, latestRecord);
		GenericLibrary.waitForElementVisibility(driver, reOpenBtn);
		JavascriptLibrary.javascriptClickElement(driver, reOpenBtn);
		GenericLibrary.waitForElementVisibility(driver, OkBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Questionnaire Reopened Successfully",true);
	}

	public void verify_Settings_Score_Addition_Delete_Copy_Questionnaire(String searchItem) throws Exception {
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+searchItem+"']")));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForElementVisibility(driver, Q1_High);
		JavascriptLibrary.javascriptClickElement(driver, Q1_High);
		Q2_textBox.sendKeys("Text Area");
		JavascriptLibrary.javascriptClickElement(driver, Q3_Medium);
		AjaxLibrary.jsClick(driver, saveBtn);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		// Copy Record
		List<WebElement> copyList = driver.findElements(By.xpath("//*[starts-with(@id,'btnCopy')]"));
		Reporter.log("Records Bofore Copy => "+copyList.size(),true);
		JavascriptLibrary.javascriptClickElement(driver, copyList.get(0));
		GenericLibrary.waitForElementVisibility(driver, Q1_High);
		AjaxLibrary.jsClick(driver, saveBtn);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> copyList2 = driver.findElements(By.xpath("//*[starts-with(@id,'btnCopy')]"));
		Reporter.log("Records After Copy => "+copyList2.size(),true);
		Assert.assertTrue(copyList2.size() > copyList.size(), "Copy not working");
		Reporter.log("Copy functionality is working fine", true);
		// Delete Record 
		List<WebElement> copyList3 = driver.findElements(By.xpath("//*[starts-with(@id,'btnCopy')]"));
		JavascriptLibrary.javascriptClickElement(driver, copyList3.get(0));
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteRecoredBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public void verify_Settings_Score_Multiply_StrikeOut_File_Upload_Questionnaire(String searchItem) throws Exception {
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		List<WebElement> list = driver.findElements(By.xpath("//h3[text()='"+searchItem+"']"));
		AjaxLibrary.jsClick(driver, list.get(list.size()-1));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForElementVisibility(driver, Q1_High);
		JavascriptLibrary.javascriptClickElement(driver, Q1_High);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, Q3_Medium);
		driver.findElement(By.xpath("//span[text()='6.']/following::input[1]")).sendKeys("Text Area");
		driver.findElement(By.xpath("//span[text()='6.1.1.']/following::input[1]")).sendKeys("Text Area");
		WebElement b = driver.findElement(By.xpath("//span[text()='b.']/following::input[1]"));
		GenericLibrary.scrollIntoView(driver, b);
		b.sendKeys("Text Area");
		AjaxLibrary.jsClick(driver, saveBtn);
		JavascriptLibrary.javascriptClickElement(driver, backBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		// Multiply Scores
		List<WebElement> multipliedScoreList = driver.findElements(By.xpath("//span[@class='number-rebc-empty']"));
		String scoreResult = multipliedScoreList.get(0).getText();
		Reporter.log("Multiplied Scores for 100 and 75: "+scoreResult,true);
		Assert.assertEquals(scoreResult, "7500", "Scores Multiplication is Not Functional" );
		Reporter.log("Score Multiplications is Functional", true);
		// StrikeOut Record 
		List<WebElement> recordList = driver.findElements(By.xpath(".//*[@id='tbRecords']/tbody/tr/td[2]"));
		JavascriptLibrary.javascriptClickElement(driver, recordList.get(0));
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteRecoredBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(strikedOutLine.isDisplayed(), "Strike out option not working");
		Reporter.log("Strike out option is functional", true);
	}

	public void verify_Assign_window_details_are_clearing_or_not_when_record_is_not_saved(String user, String target) throws Exception{
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		AjaxLibrary.jsClick(driver, driver.findElements(By.xpath("//*[@id='ulDatasets']//h3")).get(0));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, assignBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, userField);
		userSearchField.sendKeys(user);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+user+"')]")));
		GenericLibrary.waitForAjax(driver);
		assignTargetField.sendKeys(target);
		JavascriptLibrary.javascriptClickElement(driver, closeBtn_AssignWindow);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, assignBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[@class='myselectedtag'][contains(.,'"+user+"')]")).isDisplayed());
			Assert.assertTrue(false, "Assign window content not cleared when user don't save the record");
		} catch (Exception e) {
			Reporter.log("Assign window content cleared successfully user don't save the record", true);
		}
	}

	public void verify_Assign_window_mandatory_fields(String expUserFieldErrorMessage, String user, String exptargetFieldErrorMessage) throws Exception{
		AjaxLibrary.jsClick(driver, demo1Folder);
		AjaxLibrary.jsClick(driver, demo2Folder);
		AjaxLibrary.jsClick(driver, driver.findElements(By.xpath("//*[@id='ulDatasets']//h3")).get(0));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, assignBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, okBtn_AssignWindow);
		GenericLibrary.waitForAjax(driver);
		String actUserFieldErrorMessage = userFiledErrorMsg.getText();
		Reporter.log("User filed error message is: "+actUserFieldErrorMessage, true);
		Assert.assertEquals(actUserFieldErrorMessage, expUserFieldErrorMessage, "User field error message not displayed");
		Reporter.log("User field erorr message displayed successfully", true);
		GenericLibrary.click(driver, userField);
		userSearchField.sendKeys(user);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+user+"')]")));
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, okBtn_AssignWindow);
		GenericLibrary.waitForAjax(driver);
		String actTargetFieldErrorMsg = targetFieldErrorMsg.getText();
		Reporter.log("Target filed error message is: "+actTargetFieldErrorMsg, true);
		Assert.assertEquals(actTargetFieldErrorMsg, exptargetFieldErrorMessage, "Target field error message not displayed");
		Reporter.log("Target field erorr message displayed successfully", true);
	}

	public void verify_Questionnaire_for_Analyse(String searchItem, String empNo, String empName, String address,
			String empFee, String empFormFee, String empRegFee, String sscM, String interM, String graduateM, String mastersM, String qualification,
			String joiningYear, String joiningMonth, String joiningDate, String exitYear, String exitMonth, String exitDate, 
			String compEnv, String salaryIncrement, String overAll, String select, String yesNoNa,
			String checkBox1, String checkBox2, String checkBoxQ2) throws Exception {
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[text()='"+searchItem+"']")));
		AjaxLibrary.jsClick(driver, addBtn);

		driver.findElement(employeeNumber).sendKeys(empNo.replace(".0", ""));
		driver.findElement(employeeName).sendKeys(empName);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='4.']//following::label[text()[normalize-space()='"+address+"']]")));
		driver.findElement(employeeFee).sendKeys(empFee.replace(".0", ""));
		driver.findElement(employeeFormFee).sendKeys(empFormFee.replace(".0", ""));
		driver.findElement(employeeRegistrationFee).sendKeys(empRegFee.replace(".0", ""));
		driver.findElement(sscMarks).sendKeys(sscM.replace(".0", ""));
		driver.findElement(interMarks).sendKeys(interM.replace(".0", ""));
		driver.findElement(graduationMarks).sendKeys(graduateM.replace(".0", ""));
		driver.findElement(mastersMarks).sendKeys(mastersM.replace(".0", ""));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='15.']//following::label[text()[normalize-space()='"+qualification+"']]")));
		GenericLibrary.scrollIntoView(driver, joiningDateBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, joiningDateBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//th[@title='Select Month']")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//th[@title='Select Year']")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[contains(.,'"+joiningYear.replace(".0", "")+"')]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[contains(.,'"+joiningMonth+"')]")));
		List<WebElement> dayList = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(joiningDate.replace(".0", ""))) {
				JavascriptLibrary.javascriptClickElement(driver, ele);
				break;
			}
		}
		GenericLibrary.scrollIntoView(driver, exitDateBtn);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, exitDateBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//th[@title='Select Month']")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//th[@title='Select Year']")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[contains(.,'"+exitYear.replace(".0", "")+"')]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[contains(.,'"+exitMonth+"')]")));
		List<WebElement> dayList2 = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList2) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(exitDate.replace(".0", ""))) {
				JavascriptLibrary.javascriptClickElement(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='20.']//following::label[text()[normalize-space()='"+compEnv+"']]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='21.']//following::label[text()[normalize-space()='"+salaryIncrement+"']]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='22.']//following::label[text()[normalize-space()='"+overAll+"']]")));
		GenericLibrary.scrollIntoView(driver, dropDown_Q1);
		AjaxLibrary.selectElementByVisibleText(driver, dropDown_Q1, select);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='25.']//following::label[text()[normalize-space()='"+yesNoNa+"']]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//input[@value='"+checkBox1+"']/following-sibling::span[1]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//input[@value='"+checkBox2+"']/following-sibling::span[1]")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='28.']//following::label[text()[normalize-space()='"+checkBoxQ2+"']]")));
		GenericLibrary.scrollTop(driver);
		AjaxLibrary.jsClick(driver, saveBtn);
	}













}
