/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;
import com.util.VerificationLibrary;

public class BuildPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public BuildPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	@FindBy(xpath=".//*[@id='btnFolderBack']")
	WebElement folderBackBtn;
	
	@FindBy(xpath=".//*[@id='btnNew']")
	WebElement AddBtn;

	@FindBy(xpath=".//*[@id='DS_NAME']")
	WebElement nameTxtBox;

	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement saveBtn;

	@FindBy(xpath=".//*[@id='divDS_NAME']")
	WebElement savedItem;

	@FindBy(xpath = "//a[contains(@id,'btnPageBack')]")
	WebElement pageBackBtn;

	// Create Folder
	@FindBy(xpath=".//*[@id='btnFolder']")
	WebElement folderBtn;

	By fb = By.xpath(".//*[@id='btnFolder']");

	@FindBy(xpath="(//p[contains(.,'iQapture')])[1]")
	WebElement parentFolder;

	@FindBy(xpath=".//*[@id='btnNew']")
	WebElement AddFolderBtn;

	@FindBy(xpath=".//*[@id='DC_NAME']")
	WebElement folderNameTextBox;

	@FindBy(xpath=".//*[@id='DC_DESC']")
	WebElement descTxt;

	@FindBy(xpath="//a[@title='Save']")
	WebElement folderSaveBtn;

	@FindBy(xpath=".//*[@id='divEditFolder']/div/div/div[1]/button")
	WebElement closeFolderEditPage;

	// Creating Nested folder
	@FindBy(xpath=".//*[@id='row0']/div[2]/div/ul/li[2]/a")
	WebElement RightArrow;

	// Uploading Image to a Questionnaires 
	@FindBy(css="#imgDataset")
	WebElement uploadImg;

	// Delete Questionnaires
	@FindBy(xpath=".//*[@id='btnMore']/a")
	WebElement moreBtn;

	@FindBy(xpath="//a[@title='Log']")
	WebElement captureLogsOption;

	@FindBy(xpath=".//*[@id='removedataset']/a")
	WebElement deleteBtn;

	@FindBy(xpath="//button[@data-bb-handler='confirm'][contains(.,'OK')]")
	WebElement okBtn;

	@FindBy(xpath="//div[text()='No matching records found']")
	WebElement noRecordsFoundMessage;

	// Add Questions with levels to the Questionnaire 
	@FindBy(xpath="//div[@title='New Item']")
	WebElement newItemBtn;

	@FindBy(xpath=".//*[@id='F_DESC']")
	WebElement descriptionTextBox;

	@FindBy(xpath=".//*[@id='divFieldMainType0']/span")
	WebElement textOption;

	@FindBy(xpath="//label[@title='Large box']")
	WebElement largeBoxOption;

	@FindBy(xpath="//div[@class='field_desc_txt']/child::span[1]")
	WebElement addedDesciption;

	// Add Items with More Levels
	@FindBy(xpath="//span[text()='More']")
	WebElement moreOptionsBtn;

	@FindBy(xpath=".//*[@id='rdLevel2']")
	WebElement level2Btn;

	@FindBy(xpath="//span[text()='ADVANCED']//following::button")
	WebElement closeBtn;

	@FindBy(xpath=".//*[@id='rdLevel3']")
	WebElement level3Btn;

	@FindBy(xpath=".//*[@id='rdLevel4']")
	WebElement level4Btn;

	@FindBy(xpath=".//*[@id='rdLevel5']")
	WebElement level5Btn;

	// Add Items with Numbers Manually And None
	@FindBy(css="#rdCutmNumberingType1")
	WebElement manualBtn;

	@FindBy(css="#F_CUTMNUMBERING")
	WebElement numberTxtBox;

	@FindBy(css="#rdCutmNumberingType2")
	WebElement noneBtn;

	// Comment Add/Edit/Delete
	@FindBy(css="#F_ISCOMMENT0")
	WebElement commentBtn;

	@FindBy(xpath="//*[text()='Comment']")
	WebElement addedComment;

	@FindBy(xpath="//a[@title='Delete']")
	WebElement commentDeleteBtn;

	// Add MultiChoice Item To The Questionnaire
	@FindBy(xpath=".//*[@id='divFieldMainType1']/span")
	WebElement multiChoiceBtn;

	// Add MultiChoice Item to Questionnaire with Priority and Score 
	@FindBy(xpath=".//*[@id='DropdownDefault']/a")
	WebElement defaultDropDown;

	@FindBy(xpath=".//*[@id='btnHML']")
	WebElement highMediumLowOption;

	@FindBy(xpath=".//*[@id='btnYNN']")
	WebElement yesNoNAOption;

	@FindBy(xpath="//input[@id='F_ISSCORE1']")
	WebElement scoreYesBtn;

	// Adding Answer, Hint, Color, Score Manually
	@FindBy(xpath="//a[contains(@onclick,'FieldEdit.NewRow()')]")
	WebElement plusSign;

	// MultiChoice Drop Down and CheckBoxes 
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement dropDownOption;

	@FindBy(xpath="//label[@title='Radio Buttons']")
	WebElement radioOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement checkBoxOption;

	@FindBy(xpath="//span[contains(.,'Drop Down Question')]")
	WebElement dropDownQuestion;

	@FindBy(xpath="//span[contains(.,'Check Box Question')]")
	WebElement checkBoxQuestion;

	// Date
	@FindBy(xpath=".//*[@id='divFieldMainType2']/span")
	WebElement dateBtn;

	@FindBy(xpath="//label[text()='DD/MM/YYYY HH:MM']")
	WebElement dateFarmat2Btn;

	@FindBy(xpath="//label[text()='HH:MM']")
	WebElement dateFarmat3Btn;

	@FindBy(xpath="//label[text()='WW/DD/YYYY']")
	WebElement dateFarmat4Btn;

	@FindBy(xpath="//span[contains(.,'Date Question')]")
	WebElement dateQuestion;

	@FindBy(xpath="//label[text()[normalize-space()='Now']]")
	WebElement defaultValue_Now;

	@FindBy(xpath="//label[text()[normalize-space()='Blank']]")
	WebElement defaultValue_Blank;

	// Number
	@FindBy(xpath=".//*[@id='divFieldMainType3']/span")
	WebElement numberBtn;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[1]")
	WebElement integerOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement floatOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement percentageOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[4]")
	WebElement currencyOption;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[5]")
	WebElement sliderOption;

	@FindBy(xpath=".//*[@id='F_MINVALUE']")
	WebElement sliderMinValue;

	@FindBy(xpath=".//*[@id='F_MAXVALUE']")
	WebElement sliderMaxValue;

	@FindBy(xpath=".//*[@id='F_STEPVALUE']")
	WebElement sliderStepValue;

	@FindBy(xpath="//a[contains(@onclick,'SliderInfo.NewRow()')]")
	WebElement plusSign2;

	@FindBy(xpath = "//input[contains(@name,'valDecimal')]")
	WebElement sliderValueField;

	@FindBy(xpath = "//input[contains(@placeholder,'Text')]")
	WebElement sliderTextField;

	// Upload File & Section 
	@FindBy(xpath=".//*[@id='divFieldMainType5']/span")
	WebElement uploadFileBtn;

	@FindBy(xpath="//span[contains(.,'Upload File Question')]")
	WebElement uploadFileQuestion;

	@FindBy(xpath=".//*[@id='divFieldMainType10']/span")
	WebElement sectionBtn;

	@FindBy(xpath = "//label[contains(@for,'FSI_MINIMIZE1')]")
	WebElement minimizeBtn;

	@FindBy(xpath=".//*[@id='FSI_DESC']")
	WebElement sectionDescription;

	@FindBy(xpath="//span[contains(.,'Section Question')]")
	WebElement sectionQuestion;

	// Activity
	@FindBy(xpath=".//*[@id='divFieldMainType11']/span")
	WebElement activityBtn;

	@FindBy(xpath=".//*[@id='btnActDate']/span/span")
	WebElement activityDate;

	@FindBy(xpath="//textarea[contains(@id,'FAI_DESC')]")
	WebElement activityDecriptionTxtBox;

	@FindBy(xpath="//textarea[contains(@id,'FAI_COMMENT')]")
	WebElement activityCommentTxtBox;

	@FindBy(xpath="//div[1]/table/tbody/tr[5]/td[2]")
	WebElement date_26;

	// Advanced - Table
	@FindBy(xpath=".//*[@id='divFieldMainType9']/span")
	WebElement advancedBtn;

	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[1]")
	WebElement tableOption;

	@FindBy(xpath="//a[contains(@title,'Create New Sub Field')]")
	WebElement addSubFieldBtn;

	@FindBy(xpath = "//span[contains(.,'Please enter Header.')]")
	WebElement headerErrorMessage;

	@FindBy(xpath="//span[text()='Type:']//following::input[1]")
	WebElement tableHeaderTxtBox;

	@FindBy(xpath="//span[text()='Type:']//following::textarea[1]")
	WebElement tableDescriptionTxtBox;

	@FindBy(xpath="//span[contains(.,'Advanced Table Question')]")
	WebElement tableQuestion;

	@FindBy(xpath="//span[contains(.,'Value Chain')]")
	WebElement tableHeaderQuestion;

	// Advanced - Property
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[2]")
	WebElement propertyOption;

	@FindBy(xpath=".//*[@id='ddlPropertiesAnswerType']")
	WebElement propertyDropDown;

	@FindBy(xpath="//span[contains(.,'Advanced Property Question')]")
	WebElement propertyQuestion;

	@FindBy(xpath = "//select[contains(@id,'ddlPropertiesSource')]")
	WebElement propertySourceDD;

	@FindBy(xpath = "//select[contains(@id,'ddlDateFormat')]")
	WebElement propertyFormatDD;

	// Advanced - Wizard
	@FindBy(xpath=".//*[@id='divFieldSubTypes']/label[3]")
	WebElement wizardBtn;

	@FindBy(xpath=".//*[@id='F_SUBFIELDSCOUNT']")
	WebElement noOfSubQuestionsTxtBox;

	@FindBy(xpath="//span[contains(.,'Advanced Wizard Question')]")
	WebElement wizardQuestion;
	
	@FindBy(xpath="//div[text()='The number of sub fields cannot be less than the current number.']")
	WebElement wizardQuestionWarningMsg;
	
	@FindBy(xpath="//button[@data-bb-handler='ok']")
	WebElement okBtn_wizardWarningMsg;

	// Preview Option
	@FindBy(xpath="//span[contains(.,'Preview Test Question')]")
	WebElement previewTestQuestion;

	@FindBy(xpath="//a[@title='Preview Questions']")
	WebElement previewOption;

	@FindBy(css=".btn.dark.btn-outline")
	WebElement previewCloseBtn;

	// Deleting All Files in Root Directory 
	@FindBy(xpath="//h3[@style='overflow-wrap: break-word;']")
	WebElement allFilesInRootDirectory;

	// Capture Linked Items
	@FindBy(xpath="//input[@id='rdMandatory1']")
	WebElement mandatoryBtn;

	@FindBy(xpath="//input[@field='F_ONLYCOMPLETED']/following-sibling::span[1]")
	WebElement mandatoryCheckBox_OnlyOnComplete;

	@FindBy(xpath="//input[@id='F_ISEXTENDANSWER1']")
	WebElement additionalAnswersBtn;

	@FindBy(xpath=".//*[@id='F_HINT']")
	WebElement hintField;

	@FindBy(xpath = "//select[contains(@id,'ddlCompareWith')]")
	WebElement compareWithDD;

	@FindBy(xpath="//input[@id='F_ISSHOWONCAPTURE1']")
	WebElement scoreShowInIqaptureBtn;

	@FindBy(xpath="//input[@id='F_ISMILESTONE1']")
	WebElement milestoneQuestionBtn;

	@FindBy(xpath="//input[@id='F_SEARCHABLE1']")
	WebElement searchableBtn;

	@FindBy(xpath = "//input[contains(@title,'No.of Answers Min Value')]")
	WebElement minValueTextBox;

	@FindBy(xpath = "//input[contains(@title,'No.of Answers Max Value')]")	
	WebElement maxValueTextBox;

	@FindBy(xpath="//input[@id='FDI_DEFVALTYPE1']")
	WebElement defaultValueBtn;

	// Settings
	@FindBy(xpath=".//*[@id='datasetset']/a")
	WebElement settingsBtn;

	@FindBy(xpath="//*[text()='Display score total on record']//following::label[1]")
	WebElement displayScoreTotalOnRecord_Yes;

	@FindBy(xpath="//*[text()='Multiply Scores']//following::label[1]")
	WebElement multiplyScores_Yes;

	@FindBy(xpath="//*[text()='Change record order']//following::label[1]")
	WebElement changeRecordOrder_Yes;

	@FindBy(xpath="//*[text()='Copy Records']//following::label[1]")
	WebElement copyRecords_Yes;

	@FindBy(xpath="//*[text()='Show Log']//following::label[1]")
	WebElement showLogs_Yes;

	@FindBy(xpath="//*[text()='Trash can action']//following::label[2]")
	WebElement trashCanAction_StrikeOut;

	@FindBy(xpath="//*[text()='Trash can action']//following::label[3]")
	WebElement trashCanAction_Delete;

	@FindBy(xpath="//a[@title='Upload Template']")
	WebElement uploadTemplate;

	@FindBy(xpath = "//a[@title='Download Template']")
	WebElement downloadQuestionsTemplateBtn;

	// Settings - Headers
	@FindBy(css=".select2-search__field")
	WebElement headersSearchField;

	@FindBy(xpath="//a[text()='View all']")
	WebElement viewAllLink;

	@FindBy(css=".select2-result-repository__title")
	WebElement headersSearchResults;

	@FindBy(xpath=".//*[@id='btnAddHeader']")
	WebElement headerAddBtn;

	// Settings - Schedules
	// Weekly
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

	@FindBy(xpath="//a[contains(@id,'removeField')]")
	WebElement deleteScheduleBtn;

	// Questionnaire Move From One Folder To Other Folder
	@FindBy(xpath=".//*[@id='divFolders']/div/div[2]/span[1]/span[1]/span")
	WebElement searchFolderTxtBox;

	@FindBy(css=".select2-search__field")
	WebElement searchFolderTxtBox_in;

	@FindBy(xpath=".//*[@id='btnAddHeader']")
	WebElement addToFolderBtn;

	// Folder Rename & Deletion 
	@FindBy(xpath=".//*[@id='btnEdit']")
	WebElement editBtn;

	@FindBy(xpath=".//*[@id='btnDelete']")
	WebElement folderDeleteBtn;

	// Cascade Test
	@FindBy(xpath=".//*[@id='btnAddFolder']")
	WebElement addFolderBtn;

	@FindBy(xpath="//span[contains(text(),'Build')]")
	WebElement buildLink;

	@FindBy(xpath=".//*[@id='txtSearch']")
	WebElement questionnaireSearchBox;
	
	@FindBy(xpath="//a[contains(@onclick,'DSList.Search()')]")
	WebElement questionnaireSearchBtn;

	@FindBy(xpath="//h3[text()='Cascade Test']")
	WebElement CascadeTest;

	// Up Issue
	@FindBy(xpath="//a[@title='Up Issue']")
	WebElement upIssueBtn;

	@FindBy(xpath=".//*[@id='ddlDSVersion']")
	WebElement upIssueVersionDropDown;

	@FindBy(xpath="//button[text()='Up Issue']")
	WebElement acceptUpIssueBtn;

	By cancelUpIssue = By.xpath("//button[@data-bb-handler='cancel']");

	@FindBy(xpath = "//button[contains(@id,'publishDataset')]")
	WebElement publishUpIssueBtn;

	@FindBy(xpath = "//div[@class='bootbox-body'][contains(.,'This operation is irreversible. It will Publish Version 2 of this iQapture and will immediately be available for capturing. Would like to continue?')]")
	WebElement publishConfirmationMsg;

	@FindBy(xpath = "//button[@data-bb-handler='confirm'][contains(.,'Ok')]")
	WebElement OkBtn;

	@FindBy(xpath=".//*[@id='txtSearch']")
	WebElement searchBox;

	@FindBy(css=".fa.fa-search")
	WebElement searchBtn;

	@FindBy(xpath="//div[@style='text-align: center;'][contains(.,'User not found')]")
	WebElement userNotFoundMessage;

	@FindBy(xpath="//a[@title='Add Record']")
	WebElement addBtn;

	@FindBy(xpath="//span[text()='1.']//following::input[1]")
	WebElement Q1TextBox;

	@FindBy(xpath="//span[text()='2.']//following::label[1]")
	WebElement Q2Ans1;

	@FindBy(xpath="//span[text()='3.']//following::input[1]")
	WebElement Q3TextBox;

	@FindBy(xpath=".//*[@id='btnSave']") 
	WebElement captureSaveBtn;

	@FindBy(xpath="//a[@title='back']")
	WebElement capturePageBackBtn;

	@FindBy(xpath="//a[@title='Download Question Template']")
	WebElement captureDownloadTemplate;

	@FindBy(xpath="//a[@title='Upload Questions'][contains(.,'Upload Template')]")
	WebElement captureUploadTemplate;

	@FindBy(xpath="(//table[@id='tbRecords']//td)[2]")
	WebElement captureRecord1;

	@FindBy(xpath = "//a[contains(@id,'btnComplete')]")
	WebElement captureCompleteBtn;

	@FindBy(xpath="//div[contains(.,'CloseYou cannot complete this iQapture as there are still unanswered mandatory questions highlighted in red.')]")
	WebElement captureErrorMessage;

	@FindBy(xpath=".//*[@id='deleteRecord']/a")
	WebElement deleteCaptureBtn;

	@FindBy(xpath="//tr[1]/td[4]/div")
	WebElement strikedOutLine;

	@FindBy(xpath="//td[contains(.,'No matching records found')]")
	WebElement noMatchingRecordsFoundMessage;

	// Up Issue - Modify questionnaire
	@FindBy(xpath=".//*[@id='txtSearch']")
	WebElement QuestionnaireSearchBox;

	// Up Issue - On Modifying MultiChoice Questionnaire 
	@FindBy(xpath="//a[@title='2']")
	WebElement Q2_Multichoice;

	@FindBy(xpath="//a[@title='3']")
	WebElement Q3_Table;

	// Up Issue - add/copy/download/upload Questions
	@FindBy(xpath="//a[@title='Copy Questions']")
	WebElement copyQuestionsBtn;

	@FindBy(xpath = "//select[contains(@id,'ddlCopyChoice')]")
	WebElement copyChoiceDD;

	@FindBy(xpath = "//select[contains(@id,'ddlCopyQuestion')]")
	WebElement copyQuestionDD;

	@FindBy(xpath = "//a[contains(@onclick,'FieldEdit.ExecCopy')]")
	WebElement confirmCopyBtn;

	@FindBy(xpath="//a[@title='Download Template']")
	WebElement downloadTemplateBtn;

	@FindBy(xpath="//a[@title='Upload Template']")
	WebElement uploadTemplateBtn;

	@FindBy(xpath="//a[@title='Delete']")
	WebElement removeFieldBtn;

	// Modifying the Captured Question
	@FindBy(xpath="//a[contains(@title,'Copy Questionnaire')]")
	WebElement copyQuestionnaireBtn;

	// Folder Permissions
	// Setup for folder permission
	@FindBy(xpath="//*[text()='Folder1']")
	WebElement folder1;

	@FindBy(xpath="//*[text()='Folder2']")
	WebElement folder2;

	@FindBy(xpath="//*[text()='Folder3']")
	WebElement folder3;

	@FindBy(xpath="//*[text()='Folder4']")
	WebElement folder4;

	@FindBy(xpath="//*[text()='Folder5']")
	WebElement folder5;

	@FindBy(xpath=".//*[@id='btnBack']")
	WebElement backFromFolders;

	@FindBy(xpath=".//*[@id='btnPageBack']")
	WebElement backFromQuestionnaire;

	@FindBy(xpath="//span[text()='CONTACTS']")
	WebElement contactsText;

	@FindBy(xpath="//span[text()='Aaron Cope']//following::span[1]")
	WebElement AaronCopeAddBtn;

	@FindBy(xpath="//span[text()='Alex Knight']//following::span[1]")
	WebElement AlexKnightAddBtn;

	@FindBy(xpath="//span[text()='People Added']")
	WebElement peopleAddedText;

	@FindBy(xpath="//span[text()='Aaron Cope']//following::select[1]")
	WebElement AaronCopeDropDown;

	@FindBy(xpath="//span[text()='Aaron Cope']//following::i[1]")
	WebElement AaronCopeDropDownLockSymbol;

	@FindBy(xpath="//span[text()='Aaron Cope']//following::i[1]")
	WebElement AaronCopeDropDownDeleteUserSymbol;

	@FindBy(xpath="//span[text()='Alex Knight']//following::select[1]")
	WebElement AlexKnightDropDown;

	// Set the user to view folders (Aaron Cope)
	@FindBy(xpath="//span[contains(.,'John Smith ')]")
	WebElement JohnSmithAccount;

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

	@FindBy(xpath="//span[text()='iQapture']")
	WebElement Newiqapture;

	@FindBy(xpath="//h3[text()='Test Questionnaire']")
	WebElement TestQuestionnaire;

	@FindBy(xpath="//button[text()='Yes']")
	WebElement YesBtn;

	// Adding companies/removing/giving permisions
	@FindBy(xpath=".//*[@id='txtSearch']")
	WebElement peopleSearchBox;

	@FindBy(xpath=".//*[@id='SearPeopleBtn']")
	WebElement peopleSearchBtn;

	@FindBy(xpath="//span[text()='DRDO']//following::i[1]")
	WebElement ISROdeleteBtn;

	@FindBy(xpath="//span[contains(.,'added')]")
	WebElement addedMessage;

	By userAddBtn = By.xpath(".//*[contains(@id,'UserAdd')]");

	// Settings - Options Tool tips 
	@FindBy(xpath="//*[contains(text(),'Display score total on record')]/span")
	WebElement scoreTotalTooltip;

	@FindBy(xpath="//*[contains(text(),'Change record order')]/span")
	WebElement changeRecordOrderTooltip;

	@FindBy(xpath="//*[contains(text(),'Copy Records')]/span")
	WebElement copyRecordsTooltip;

	@FindBy(xpath="//*[contains(text(),'Show Log')]/span")
	WebElement showLogTooltip;

	@FindBy(xpath="//*[contains(text(),'Trash can action')]/span")
	WebElement trashCanActionTooltip;

	@FindBy(xpath="//*[contains(text(),'Capture Presentation Style')]/span")
	WebElement capturePresentationStyleTooltip;

	@FindBy(xpath="//*[contains(text(),'Upload Questions')]/span")
	WebElement uploadQuestionsTooltip;

	@FindBy(xpath="//*[contains(text(),'People Added')]/../div")
	WebElement peopleAddedTooltip;

	@FindBy(xpath="//*[contains(text(),'CONTACTS')]/../div")
	WebElement contactsTooltip;

	@FindBy(xpath="//*[contains(text(),'schedule')]/../span[2]")
	WebElement scheduleTooltip;

	@FindBy(xpath="//*[contains(text(),'alerts')]/../span[2]")
	WebElement alertsTooltip;

	@FindBy(xpath="//*[contains(text(),'Headers')]/../span[2]")
	WebElement headersTooltip;

	@FindBy(xpath="//*[contains(text(),'Folders')]/../span[2]")
	WebElement foldersTooltip;

	@FindBy(xpath="(//*[contains(@id,'folderList')]//span)[1]")
	WebElement folderPathTootip;

	// Settings - Add alerts & Delte Alerts 
	@FindBy(xpath = "//a[contains(@id,'btnAddAlert')]")
	WebElement addAlertBtn;

	@FindBy(xpath=".//*[@id='R_NAME']")
	WebElement alertLabelTextBox;

	@FindBy(xpath="//i[contains(@id,'btnAltPeople')]")
	WebElement addAlertPeopleBtn;

	@FindBy(id="lblAltSimpPeople")
	WebElement addedAlertPeople;

	@FindBy(xpath="(.//*[contains(@id,'ddlFields')])[1]")
	WebElement conditionQuestionsDD1;

	@FindBy(xpath="(.//*[contains(@id,'ddlFields')])[2]")
	WebElement conditionQuestionsDD2;

	@FindBy(xpath="//div[@class='col-xs-3 col-md-3']//select[1]")
	WebElement alertConditionDD1;

	@FindBy(xpath="(.//*[contains(@id,'ddlOperators')])[2]")
	WebElement alertConditionDD2;

	@FindBy(xpath="(.//*[contains(@id,'txtCondition')])[1]")
	WebElement textCondition1;

	@FindBy(xpath="(.//*[contains(@id,'txtCondition')])[2]")
	WebElement textCondition2;

	@FindBy(xpath="(.//*[contains(@id,'ddlLogicOperators')])[1]")
	WebElement logicalOperatorDD;

	@FindBy(xpath=".//*[@id='btnAdd_Condition']")
	WebElement addCondition2;

	@FindBy(xpath="//span[contains(@id,'btnRemove_Condition-2')]")
	WebElement removeCondiotion2;

	@FindBy(xpath="//input[contains(@class,'select2-search__field')]")
	WebElement whatConditionSearch1;

	@FindBy(xpath = "//select[contains(@id,'ddlAlertWhen-1')]")
	WebElement whenDD1;

	@FindBy(xpath = "//select[contains(@id,'ddlAlertWhen-2')]")
	WebElement whenDD2;

	@FindBy(xpath=".//*[@id='btnAdd_AlertWhen']")
	WebElement addWhen2;

	@FindBy(xpath=".//*[@id='btnRemove_AlertWhen-2']")
	WebElement removeWhen2;

	@FindBy(xpath="//a[contains(@onclick,'Remove')]")
	WebElement deleteAlertBtn;

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

	@FindBy(xpath=".//*[@id='dlgAssign']//following::div[@class='modal-footer']//button[contains(text(),'Ok')]")
	WebElement okBtn_AssignWindow;

	@FindBy(xpath = "//span[@class='title'][contains(.,'Dashboard')]")
	WebElement dashBoardLink;

	// Deleted version Questions visibility in analyse sections 
	@FindBy(xpath="(//span[text()='2.']/following::input)[1]")
	WebElement Q2TextBox;

	@FindBy(xpath="//input[@id='txtSearch']")
	WebElement analysesSearchBox;

	@FindBy(xpath="//a[@onclick='DSList.Search()']")
	WebElement searchQuestionnaireBtn;

	@FindBy(xpath="//a[contains(@id,'btnNewIQReport')]")
	WebElement createReportBtn;

	@FindBy(xpath = "//div[@class='field_desc_txt tooltips copytext init'][contains(.,'Q3')]")
	WebElement Question3;

	// Up Issue Log 
	@FindBy(xpath="//a[@title='Issue Logs']")
	WebElement issueLogBtn;

	@FindBy(linkText="Version 2")
	WebElement issueLogHeader;

	By logList = By.xpath("//table[contains(@id,'tbLogList')]//td[2]");

	@FindBy(xpath="//span[text()='Q1']")
	WebElement Q1desc;

	@FindBy(xpath="//span[text()='Q']")
	WebElement Qdesc;

	@FindBy(xpath="//i[@title='Remove Item']")
	WebElement removeAnsBtn;

	@FindBy(xpath="//input[@placeholder='Answer']")
	WebElement answerField;

	@FindBy(xpath="(//table[@class='table table-hover']//tr//td[2])[last()]")
	WebElement lastElementInLogList;

	@FindBy(xpath="//i[@title='Remove Item']")
	WebElement removeSubFieldBtn;

	@FindBy(xpath="//span[text()='Question 1']")
	WebElement wizard_Question1;















	// Actions:......................................................................................
	public boolean verify_IQuapturePage() {
		return AddBtn.isDisplayed();
	}

	public void verify_Create_Folder(String folderName, String description) throws Exception {
		AjaxLibrary.jsClick(driver, fb);
		AjaxLibrary.jsClick(driver, parentFolder);
		AjaxLibrary.jsClick(driver, AddFolderBtn);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, folderName);
		JavascriptLibrary.javascriptType(driver, descTxt, description);
		AjaxLibrary.jsClick(driver, folderSaveBtn);
		try {
			WebElement folder = driver.findElement(By.xpath("//*[text()='"+folderName+"']"));
			GenericLibrary.waitForElementVisibility(driver, folder);
			Assert.assertTrue(folder.isDisplayed());
			Reporter.log("Folder created successfully",true);
		} catch (NoSuchElementException | TimeoutException e) {
			AjaxLibrary.jsClick(driver, RightArrow);
			WebElement folder = driver.findElement(By.xpath("//*[text()='"+folderName+"']"));
			GenericLibrary.waitForElementVisibility(driver, folder);
			Assert.assertTrue(folder.isDisplayed());
			Reporter.log("Folder created successfully",true);
		} catch (AssertionError e) {
			Reporter.log("Folder NOT created", true);
			Assert.fail();
		}
	}

	public void verify_Create_Nested_Folder(String mainFolderName, String subFolderName, String description) throws Exception {
		AjaxLibrary.jsClick(driver, folderBtn);
		try {
			WebElement parentFolder = driver.findElement(By.xpath("//*[text()='"+mainFolderName+"']"));
			AjaxLibrary.jsClick(driver, parentFolder);
		} catch (NoSuchElementException | TimeoutException e) {
			AjaxLibrary.jsClick(driver, RightArrow);
			WebElement parentFolder = driver.findElement(By.xpath("//*[text()='"+mainFolderName+"']"));
			AjaxLibrary.jsClick(driver, parentFolder);
		}
		AjaxLibrary.jsClick(driver, AddFolderBtn);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, subFolderName);
		JavascriptLibrary.javascriptType(driver, descTxt, description);
		AjaxLibrary.jsClick(driver, folderSaveBtn);
		try {
			WebElement childFolder = driver.findElement(By.xpath("//*[text()='"+subFolderName+"']"));
			GenericLibrary.waitForElementVisibility(driver, childFolder);
			Assert.assertTrue(childFolder.isDisplayed());
			Reporter.log("Nested-Folder Created successfully", true);
		} catch (NoSuchElementException | TimeoutException | AssertionError e) {
			Reporter.log("Nested folder Not created", true);
			Assert.fail();
		}
	}

	public void verify_Questionnaire_Creation(String mainFolder, String subFolder, String questionnaireName) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, questionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		GenericLibrary.waitForElementVisibility(driver, savedItem);
		String expected = questionnaireName;
		String actual = savedItem.getText();
		Assert.assertEquals(actual, expected, "Questionnaire Not Created");
	}

	public void verify_Upload_Image_To_Questionnaire(String mainFolder, String subFolder, String questionnaireName, String imgPath) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, questionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		GenericLibrary.waitForElementVisibility(driver, savedItem);
		String expected = questionnaireName;
		String actual = savedItem.getText();
		Assert.assertEquals(actual, expected, "Questionary Not Created");
		// Upload image
		AjaxLibrary.uploadFile(driver, uploadImg, imgPath);
	}

	public void verify_Delete_Questionnaire(String mainFolder, String subFolder, String qName) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, qName);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.click(driver, pageBackBtn);
		searchBox.sendKeys(qName);
		AjaxLibrary.click(driver, searchBtn);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[contains(@title,'"+qName+"')]")));
		GenericLibrary.moveToElement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, deleteBtn);
		AjaxLibrary.jsClick(driver, okBtn);
		searchBox.sendKeys(qName);
		AjaxLibrary.click(driver, searchBtn);
		Assert.assertTrue(noRecordsFoundMessage.isDisplayed(), "Questionnaire not deleted");
		Reporter.log("Questionary Deleted Successfully", true);
	}

	public void verify_Rename_Questionnaire(String mainFolder, String subFolder, String QuestionnaireName, String NewQuestionnaireName) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		GenericLibrary.waitForElementVisibility(driver, savedItem);
		Reporter.log("Before Rename => "+savedItem.getText(),true);
		AjaxLibrary.clickClearAndType(driver, savedItem, nameTxtBox, NewQuestionnaireName);
		GenericLibrary.waitForElementVisibility(driver, savedItem);
		Reporter.log("After Rename => "+savedItem.getText(),true);
	}

	public void verify_Add_Comment_update_and_delete(String mainFolder, String subFolder, String QuestionnaireName, String Q1, String newComment) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		GenericLibrary.waitForElementVisibility(driver, addedComment);
		Assert.assertTrue(addedComment.isDisplayed(), "Comment Not Added");
		Reporter.log("Comment Added successfully", true);
		//Updating Comment
		AjaxLibrary.jsClick(driver, addedComment);
		AjaxLibrary.jsType(driver, descriptionTextBox, newComment);
		WebElement updated = driver.findElement(By.xpath("//*[text()='"+newComment+"']"));
		Assert.assertEquals(updated.getText(), newComment, "Comment Not Updated");
		Reporter.log("Comment Updated successfully", true);
		//Deleting Comment
		JavascriptLibrary.javascriptClickElement(driver, addedComment);
		JavascriptLibrary.javascriptClickElement(driver, commentDeleteBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		Reporter.log("Comment Deleted successfully", true);
	}

	public void verify_Text_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, String Q9, String Q10, 
			String Q11, String Q12, String hint, String Q13, String Q14, String option, String Q15, String Q16, String optionLarge) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		String expectedLevel1 = "1";
		String actualLevel1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q1+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel1, expectedLevel1, "Level 1 NOT selected by default");
		Reporter.log("Question added with Level 1", true);
		//Level 2 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.type(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Mandatory
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Mandatory Quesion NOT added");
		Reporter.log("Mandatory Question added", true);
		// Mandatory - Only on complete
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, mandatoryCheckBox_OnlyOnComplete);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(mnQact2, Q9, "Mandatory Question only on complete NOT added");
		Reporter.log("Mandatory Question only on complete added", true);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(cmtQact, Q10, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		String cmtAct = driver.findElement(By.xpath("//span[text()='Comment']")).getText();
		a.assertEquals(cmtAct, "Comment", "Comment NOT added");
		Reporter.log("Comment added", true);
		// Additional answers
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, additionalAnswersBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String aaAct = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(aaAct, Q11, "Additional answers Question NOT added");
		Reporter.log("Additional answers Question added", true);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q12);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.type(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q12+"']]")).getText();
		a.assertEquals(hintQ, Q12, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		// Compare 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q13);
		String comp1Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q13+"']]")).getText();
		a.assertEquals(comp1Q, Q13, "Question to compare 1 NOT added");
		Reporter.log("Question to compare 1 added", true);
		// Compare 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q14);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String comp2Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q14+"']]")).getText();
		a.assertEquals(comp2Q, Q14, "Question to compare 2 NOT added");
		Reporter.log("Question to compare 2 added", true);
		// Text Large box
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q15);
		AjaxLibrary.jsClick(driver, largeBoxOption);
		String largeQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q15+"']]")).getText();
		a.assertEquals(largeQ, Q15, "Large box Question to compare 1 NOT added");
		Reporter.log("Large box Question to compare 1 added", true);
		// Text Large box - Compare
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q16);
		AjaxLibrary.jsClick(driver, largeBoxOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, optionLarge);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String largeQ2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q16+"']]")).getText();
		a.assertEquals(largeQ2, Q16, "Large box Question to compare 1 NOT added");
		Reporter.log("Large box Question to compare 1 added", true);
		a.assertAll();
	}

	public void verify_MultiChoice_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, 
			String Q9, String Q10, String Q11, String Q12, String hint, String Q13, String Q14, String option,
			String Q15, String Q16, String option2, String Q17, String Q18, String option3, String Q19, 
			String minValue, String maxValue, String ans1, String hint1, String score1, String ans2, String hint2, String score2, 
			String Q20, String choice, String question) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		String expectedLevel1 = "1";
		String actualLevel1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q1+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel1, expectedLevel1, "Level 1 NOT selected by default");
		Reporter.log("Question added with Level 1", true);
		//Level 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.jsType(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Mandatory 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Mandatory Quesion NOT added");
		Reporter.log("Mandatory Question added", true);
		// Mandatory - Only on complete
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, mandatoryCheckBox_OnlyOnComplete);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(mnQact2, Q9, "Mandatory Question only on complete NOT added");
		Reporter.log("Mandatory Question only on complete added", true);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(cmtQact, Q10, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		String cmtAct = driver.findElement(By.xpath("//span[text()='Comment']")).getText();
		a.assertEquals(cmtAct, "Comment", "Comment NOT added");
		Reporter.log("Comment added", true);
		// Score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String aaAct = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(aaAct, Q11, "Score Question NOT added");
		Reporter.log("Score Question added", true);
		// Hint
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q12);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsType(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q12+"']]")).getText();
		a.assertEquals(hintQ, Q12, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		// Radio compare
		// Radio
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q13);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		String comp1Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q13+"']]")).getText();
		a.assertEquals(comp1Q, Q13, "Radio Question to compare 1 NOT added");
		Reporter.log("Radio Question to compare 1 added", true);
		// Radio Compare
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q14);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String comp2Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q14+"']]")).getText();
		a.assertEquals(comp2Q, Q14, "Radio Question to compare 2 NOT added");
		Reporter.log("Radio Question to compare 2 added", true);
		// DropDown compare
		// DD
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q15);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, yesNoNAOption);
		String compDD1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q15+"']]")).getText();
		a.assertEquals(compDD1, Q15, "DropDown Question to compare 1 NOT added");
		Reporter.log("DropDown Question to compare 1 added", true);
		// DD Compare
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q16);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, yesNoNAOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option2);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String compDD2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q16+"']]")).getText();
		a.assertEquals(compDD2, Q16, "DropDown Question to compare 2 NOT added");
		Reporter.log("DropDown Question to compare 2 added", true);
		// Searchable - DD
		// Searchable DD
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q17);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, searchableBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String searchableQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q17+"']]")).getText();
		a.assertEquals(searchableQ, Q17, "Searchable Question 1 NOT added");
		Reporter.log("Searchable Question 1 added", true);
		// Searchable DD Compare
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q18);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, searchableBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option3);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String searchableQ2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q18+"']]")).getText();
		a.assertEquals(searchableQ2, Q18, "Searchable Question 2 NOT added");
		Reporter.log("Searchable Question 2 added", true);
		// Create new fields manually & No.of answers range
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q19);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, checkBoxOption);
		for (int i = 0; i < 2; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		JavascriptLibrary.javascriptType(driver, minValueTextBox, minValue.replace(".0", ""));
		JavascriptLibrary.javascriptType(driver, maxValueTextBox, maxValue.replace(".0", ""));
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> ansTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		List<WebElement> hintTextBoxes = driver.findElements(By.xpath("//textarea[@placeholder='Enter hint for answer…']"));
		List<WebElement> scoreTextBox = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		List<WebElement> eyelist = driver.findElements(By.xpath("//span[@class='desc hide-desc']"));
		// Set 1
		AjaxLibrary.jsType(driver, ansTextBoxes.get(0), ans1);
		AjaxLibrary.jsType(driver, hintTextBoxes.get(0), hint1);
		AjaxLibrary.jsClick(driver, eyelist.get(0));
		AjaxLibrary.jsType(driver, scoreTextBox.get(0), score1.replace(".0", ""));
		// Set 2
		AjaxLibrary.jsType(driver, ansTextBoxes.get(1), ans2);
		WebElement h2 = hintTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, h2);
		AjaxLibrary.jsType(driver, h2, hint2);
		AjaxLibrary.jsClick(driver, eyelist.get(1));
		AjaxLibrary.jsType(driver, scoreTextBox.get(1), score2.replace(".0", ""));
		String noOfAnsQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q18+"']]")).getText();
		a.assertEquals(noOfAnsQ, Q18, "Searchable Question NOT added");
		Reporter.log("Searchable Question to compare 1 added", true);
		// Copy Questions
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q20);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, copyQuestionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, copyChoiceDD, choice);
		AjaxLibrary.selectElementByVisibleText(driver, copyQuestionDD, question);
		JavascriptLibrary.javascriptClickElement(driver, confirmCopyBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		String copied = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q20+"']]")).getText();
		a.assertEquals(copied, Q20, "Question NOT copied");
		Reporter.log("Question copied", true);
		a.assertAll();
		// 




	}

	public void verify_Date_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, 
			String Q9, String Q10, String Q11, String Q12, String Q13, String Q14, String hint, 
			String Q15, String Q16, String option, String Q17, String Q18, String option2,
			String Q19, String Q20, String option3, String Q21, String Q22, String option4) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, dateBtn);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		String expectedLevel1 = "1";
		String actualLevel1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q1+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel1, expectedLevel1, "Level 1 NOT selected by default");
		Reporter.log("Question added with Level 1", true);
		//Level 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.jsType(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Mandatory 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Mandatory Quesion NOT added");
		Reporter.log("Mandatory Question added", true);
		// Mandatory - Only on complete
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, mandatoryCheckBox_OnlyOnComplete);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(mnQact2, Q9, "Mandatory Question only on complete NOT added");
		Reporter.log("Mandatory Question only on complete added", true);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(cmtQact, Q10, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		String cmtAct = driver.findElement(By.xpath("//span[text()='Comment']")).getText();
		a.assertEquals(cmtAct, "Comment", "Comment NOT added");
		Reporter.log("Comment added", true);
		// Default value - Blank
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, defaultValue_Blank);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String aaAct = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(aaAct, Q11, "Score Question NOT added");
		Reporter.log("Score Question added", true);
		// Default value - Now
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q12);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, defaultValue_Now);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String adtnlVal1Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q12+"']]")).getText();
		a.assertEquals(adtnlVal1Q, Q12, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		// Additional answers
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q13);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, additionalAnswersBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String adtnlVal2Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q13+"']]")).getText();
		a.assertEquals(adtnlVal2Q, Q13, "Additional answers Question NOT added");
		Reporter.log("Additional answers Question added", true);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q14);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsType(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q14+"']]")).getText();
		a.assertEquals(hintQ, Q14, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		// Format 1 - DD/MM/YYYY
		// Compare 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q15);
		AjaxLibrary.jsClick(driver, dateBtn);
		String comp1Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q15+"']]")).getText();
		a.assertEquals(comp1Q, Q15, "DD/MM/YYYY format Question 1 NOT added");
		Reporter.log("DD/MM/YYYY format Question 1 added", true);
		// Compare 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q16);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String comp2Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q16+"']]")).getText();
		a.assertEquals(comp2Q, Q16, "DD/MM/YYYY format Question 2 NOT added");
		Reporter.log("DD/MM/YYYY format Question 2 added", true);
		// Format 2 - DD/MM/YYYY HH:MM
		// Compare 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q17);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, dateFarmat2Btn);
		String compDD1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q17+"']]")).getText();
		a.assertEquals(compDD1, Q17, "DD/MM/YYYY HH:MM format Question 1 NOT added");
		Reporter.log("DD/MM/YYYY HH:MM format Question 1 added", true);
		// Compare 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q18);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, dateFarmat2Btn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option2);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String compDD2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q18+"']]")).getText();
		a.assertEquals(compDD2, Q18, "DD/MM/YYYY HH:MM format Question 2 NOT added");
		Reporter.log("DD/MM/YYYY HH:MM format Question 2 added", true);
		// Format 3 - HH:MM
		// Compare 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q19);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, dateFarmat3Btn);
		String compDD3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q19+"']]")).getText();
		a.assertEquals(compDD3, Q19, "HH:MM format Question 1 NOT added");
		Reporter.log("HH:MM format Question 1 added", true);
		// Compare 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q20);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, dateFarmat3Btn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option3);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String compDD4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q20+"']]")).getText();
		a.assertEquals(compDD4, Q20, "HH:MM format Question 2 NOT added");
		Reporter.log("HH:MM format Question 2 added", true);
		// Format 4 - WW/DD/YYYY
		// Compare 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q21);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, dateFarmat4Btn);
		String compDD5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q21+"']]")).getText();
		a.assertEquals(compDD5, Q21, "WW/DD/YYYY format Question 1 NOT added");
		Reporter.log("WW/DD/YYYY format Question 1 added", true);
		// Compare 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q22);
		AjaxLibrary.jsClick(driver, dateBtn);
		AjaxLibrary.jsClick(driver, dateFarmat4Btn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option4);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String compDD6 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q22+"']]")).getText();
		a.assertEquals(compDD6, Q22, "WW/DD/YYYY format Question 2 NOT added");
		Reporter.log("WW/DD/YYYY format Question 2 added", true);
		a.assertAll();
	}

	public void verify_MultiChoice_upload_and_download_button_functionality(String mainFolder, String subFolder, String  QuestionnaireName, String Q1,
			String filePath, String downloadPath, String fileName) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		// Upload Template
		AjaxLibrary.uploadFile(driver, uploadTemplate, filePath);
		WebElement uploadedItem = driver.findElement(By.xpath("//a[contains(.,'100')]"));
		a.assertTrue(uploadedItem.isDisplayed(), "Upload button not working");
		Reporter.log("Upload button is functional", true);
		// Download Template
		AjaxLibrary.jsClick(driver, downloadTemplateBtn);
		Thread.sleep(3000);
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Template NOT downloaded");
		Reporter.log("Template downloaded successfully", true);
		a.assertAll();
	}

	public void verify_Number_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, String Q9, String Q10, 
			String Q11, String Q12, String hint, String Q13, String Q14, String Q15, String Q16, 
			String minValue, String maxValue, String stepValue, String value, String text) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, numberBtn);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		String expectedLevel1 = "1";
		String actualLevel1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q1+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel1, expectedLevel1, "Level 1 NOT selected by default");
		Reporter.log("Question added with Level 1", true);
		//Level 2 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.type(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Mandatory
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Mandatory Quesion NOT added");
		Reporter.log("Mandatory Question added", true);
		// Mandatory - Only on complete
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, mandatoryCheckBox_OnlyOnComplete);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(mnQact2, Q9, "Mandatory Question only on complete NOT added");
		Reporter.log("Mandatory Question only on complete added", true);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(cmtQact, Q10, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		String cmtAct = driver.findElement(By.xpath("//span[text()='Comment']")).getText();
		a.assertEquals(cmtAct, "Comment", "Comment NOT added");
		Reporter.log("Comment added", true);
		// Additional answers
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, additionalAnswersBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String aaAct = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(aaAct, Q11, "Additional answers Question NOT added");
		Reporter.log("Additional answers Question added", true);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q12);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.type(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q12+"']]")).getText();
		a.assertEquals(hintQ, Q12, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		// Float
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q13);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, floatOption);
		String fQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q13+"']]")).getText();
		a.assertEquals(fQ, Q13, "Float Quesion NOT added");
		Reporter.log("Float Question added", true);
		// Percentage
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q14);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, percentageOption);
		String pQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q14+"']]")).getText();
		a.assertEquals(pQ, Q14, "Percentage Quesion NOT added");
		Reporter.log("Percentage Question added", true);
		// Percentage
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q15);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, currencyOption);
		String cQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q15+"']]")).getText();
		a.assertEquals(cQ, Q15, "Currency Quesion NOT added");
		Reporter.log("Currency Question added", true);
		// Range
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q16);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, sliderOption);
		AjaxLibrary.jsType(driver, sliderMinValue, minValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderMaxValue, maxValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderStepValue, stepValue.replace(".0", ""));
		AjaxLibrary.jsClick(driver, plusSign2);
		AjaxLibrary.jsType(driver, sliderValueField, value.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderTextField, text.replace(".0", ""));
		a.assertAll();
	}

	public void verify_Upload_file_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, 
			String Q9, String Q10, String Q11, String hint) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		//Level 2 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.type(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Mandatory
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Mandatory Quesion NOT added");
		Reporter.log("Mandatory Question added", true);
		// Mandatory - Only on complete
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, mandatoryCheckBox_OnlyOnComplete);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(mnQact2, Q9, "Mandatory Question only on complete NOT added");
		Reporter.log("Mandatory Question only on complete added", true);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(cmtQact, Q10, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, uploadFileBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.type(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(hintQ, Q11, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		a.assertAll();
	}

	public void verify_Section_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, 
			String Q9, String sectionDesc, String Q10, String hint) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, sectionBtn);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		//Level 2 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/../..//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/../..//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/../..//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/../..//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.type(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/../..//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/../..//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Minimize
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, minimizeBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Minimize Quesion NOT added");
		Reporter.log("Minimize Question added", true);
		// Description
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsType(driver, sectionDescription, sectionDesc);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(cmtQact, Q9, "Section description Question NOT added");
		Reporter.log("Section description Question added", true);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, sectionBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.type(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(hintQ, Q10, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		a.assertAll();
	}

	public void verify_Activity_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7, String Q8, String Q9, String Q10, 
			String Q11, String hint, String date, String desc, String comment, String user, String Q12, String Q13, String option) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, activityBtn);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		String expectedLevel1 = "1";
		String actualLevel1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q1+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel1, expectedLevel1, "Level 1 NOT selected by default");
		Reporter.log("Question added with Level 1", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> allDates = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele:allDates){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		//Level 2 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list2 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list2){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list3 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list3){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list4 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list4){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.type(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list5 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list5){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list6 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list6){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Mandatory
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(mnQact, Q8, "Mandatory Quesion NOT added");
		Reporter.log("Mandatory Question added", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list7 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list7){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Mandatory - Only on complete
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, mandatoryCheckBox_OnlyOnComplete);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String mnQact2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(mnQact2, Q9, "Mandatory Question only on complete NOT added");
		Reporter.log("Mandatory Question only on complete added", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list8 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list8){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(cmtQact, Q10, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		String cmtAct = driver.findElement(By.xpath("//span[text()='Comment']")).getText();
		a.assertEquals(cmtAct, "Comment", "Comment NOT added");
		Reporter.log("Comment added", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list9 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list9){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.type(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(hintQ, Q11, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list10 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list10){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Compare 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q12);
		AjaxLibrary.jsClick(driver, activityBtn);
		String comp1Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q12+"']]")).getText();
		a.assertEquals(comp1Q, Q12, "Activity Question to compare 1 NOT added");
		Reporter.log("Activity Question to compare 1 added", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list11 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list11){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		// Compare 2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q13);
		AjaxLibrary.jsClick(driver, activityBtn);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.selectElementByVisibleText(driver, compareWithDD, option);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String comp2Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q13+"']]")).getText();
		a.assertEquals(comp2Q, Q13, "Activity Question to compare 2 NOT added");
		Reporter.log("Activity Question to compare 2 added", true);
		AjaxLibrary.jsClick(driver, activityDate);
		List<WebElement> list12 = driver.findElements(By.cssSelector(".day"));
		for(WebElement ele : list12){
			String d=ele.getText();
			if(d.equalsIgnoreCase(date.replace(".0", ""))){
				AjaxLibrary.jsClick(driver, ele);
				break;
			}
		}
		AjaxLibrary.jsClick(driver, driver.findElement(By.cssSelector("#btnActPeople")));
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/..//input")));
		AjaxLibrary.clickClearAndType(driver, activityDecriptionTxtBox, activityDecriptionTxtBox, desc);
		AjaxLibrary.jsType(driver, activityCommentTxtBox, comment);
		a.assertAll();
	}

	public void verify_Advanced_dataset(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q2, String Q3, String Q4, String Q5, String Q6, String nm, String Q7,String Q8, 
			String Q9, String tHeader, String tDesc, String Q10, String hint, 
			String Q11, String option1, String Q12, String option2, String Q13, String option3, String Q14, String option4, 
			String sourceOption, String formatOption, String Q15, String noOfSubQ, String Q16) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		// Add Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Level 1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		WebElement q = driver.findElement(By.xpath("//span[text()='"+Q1+"']"));
		String actual = q.getText();
		a.assertEquals(actual, Q1, "Question NOT Added");
		Reporter.log("Question added", true);
		String expectedLevel1 = "1";
		String actualLevel1 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q1+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel1, expectedLevel1, "Level 1 NOT selected by default");
		Reporter.log("Question added with Level 1", true);
		//Level 2 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level2Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel2 = "1.1";
		String actualLevel2 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q2+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel2, expectedLevel2, "Level 2 Not Funtional");
		Reporter.log("Question added with Level 2", true);
		//Level 3
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level3Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel3 = "1.1.1";
		String actualLevel3 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q3+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel3, expectedLevel3, "Level 3 Not Funtional");
		Reporter.log("Question added with Level 3", true);
		//Level 4
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level4Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel4 = "1.1.1.1";
		String actualLevel4 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q4+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel4, expectedLevel4, "Level 4 Not Funtional");
		Reporter.log("Question added with Level 4", true);
		//Level 5
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, level5Btn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String expectedLevel5 = "1.1.1.1.1";
		String actualLevel5 = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q5+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(actualLevel5, expectedLevel5, "Level 5 Not Funtional");
		Reporter.log("Question added with Level 5", true);
		// Number manual
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q6);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, manualBtn);
		AjaxLibrary.type(driver, numberTxtBox, nm);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String manual = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q6+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(nm, manual, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Number None
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q7);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, noneBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String exp = "";
		String none = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q7+"']]/ancestor::div[@class='field_desc_wrap']//a")).getText();
		a.assertEquals(exp, none, "Number manual is Not Funtional");
		Reporter.log("Question added with number manual", true);
		// Comment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q8);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, commentBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String cmtQact = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q8+"']]")).getText();
		a.assertEquals(cmtQact, Q8, "Comment Question NOT added");
		Reporter.log("Comment Question added", true);
		String cmtAct = driver.findElement(By.xpath("//span[text()='Comment']")).getText();
		a.assertEquals(cmtAct, "Comment", "Comment NOT added");
		Reporter.log("Comment added", true);
		// Additional answers
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q9);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, addSubFieldBtn);
		AjaxLibrary.clickClearAndType(driver, tableHeaderTxtBox, tableHeaderTxtBox, tHeader);
		AjaxLibrary.jsType(driver, tableDescriptionTxtBox, tDesc);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, additionalAnswersBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String aaAct = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q9+"']]")).getText();
		a.assertEquals(aaAct, Q9, "Additional answers Question NOT added");
		Reporter.log("Additional answers Question added", true);
		// Hint 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q10);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.type(driver, hintField, hint);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		String hintQ = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q10+"']]")).getText();
		a.assertEquals(hintQ, Q10, "Hint Question NOT added");
		Reporter.log("Hint Question added", true);
		// Property
		// Created by 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q11);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, propertyOption);
		AjaxLibrary.selectElementByVisibleText(driver, propertyDropDown, option1);
		String p1Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q11+"']]")).getText();
		a.assertEquals(p1Q, Q11, "Property Question with 'Created By' option NOT added");
		Reporter.log("Property Question with 'Created By' option added", true);
		// Last Modified By
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q12);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, propertyOption);
		AjaxLibrary.selectElementByVisibleText(driver, propertyDropDown, option2);
		String p2Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q12+"']]")).getText();
		a.assertEquals(p2Q, Q12, "Property Question with 'Last Modified By' option NOT added");
		Reporter.log("Property Question with 'Last Modified By' option added", true);
		// Record ID at capture level
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q13);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, propertyOption);
		AjaxLibrary.selectElementByVisibleText(driver, propertyDropDown, option3);
		String p3Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q13+"']]")).getText();
		a.assertEquals(p3Q, Q13, "Property Question with 'Record ID at capture level' option NOT added");
		Reporter.log("Property Question with 'Record ID at capture level' option added", true);
		// Date property
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q14);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, propertyOption);
		AjaxLibrary.selectElementByVisibleText(driver, propertyDropDown, option4);
		AjaxLibrary.selectElementByVisibleText(driver, propertySourceDD, sourceOption);
		AjaxLibrary.selectElementByVisibleText(driver, propertyFormatDD, formatOption);
		String p4Q = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q14+"']]")).getText();
		a.assertEquals(p4Q, Q14, "Property Question with 'Date Property' option NOT added");
		Reporter.log("Property Question with 'Date Property' option added", true);
		// Wizard 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q15);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, wizardBtn);
		AjaxLibrary.jsType(driver, noOfSubQuestionsTxtBox, noOfSubQ.replace(".0", ""));
		String wiz = driver.findElement(By.xpath("//span[text()[normalize-space()='"+Q15+"']]")).getText();
		a.assertEquals(wiz, Q15, "Wizard Question NOT added");
		Reporter.log("Wizard Question added", true);
		List<WebElement> list = driver.findElements(By.xpath("//span[text()[normalize-space()='"+Q15+"']]/ancestor::div[contains(@id,'fieldItems')]//div[contains(@class,'sub_field')]"));
		a.assertEquals(list.size(), Integer.parseInt(noOfSubQ.replace(".0", "")), "Sub Questions NOT added to wizard");
		Reporter.log("Sub Questions added to wizard", true);
		// Table header error message
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q16);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, addSubFieldBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		a.assertTrue(headerErrorMessage.isDisplayed(), "Table header mandatory message NOT displayed");
		Reporter.log("Table header mandatory message displayed", true);
		a.assertAll();
	}

	public void verify_Preview_Quesionnaire(String mainFolder, String subFolder, String QuestionnaireName, String Q1) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		Assert.assertEquals(previewTestQuestion.getText(), "Preview Test Question", "Advanced Property Question Not Added");
		Reporter.log("Previw Test Question Created Successfully", true);
		GenericLibrary.moveToElement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, previewOption);
		AjaxLibrary.jsClick(driver, previewCloseBtn);
	}

	public void verify_Settings_Score_Addition_Delete_Copy_Questionnaire(String mainFolder, String subFolder, 
			String QuestionnaireName, String Q1, String Q1value1, String Q1value2, String Q1value3, 
			String Q2, String Q3, String Q3value1, String Q3value2, String Q3value3,
			String Q4, String minValue, String maxValue, String stepValue, String Q5) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> textBoxList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		WebElement textBox1 = textBoxList.get(0);
		GenericLibrary.scrollIntoView(driver, textBox1);
		AjaxLibrary.type(driver, textBox1, Q1value1.replace(".0", ""));
		WebElement textBox2 = textBoxList.get(1);
		GenericLibrary.scrollIntoView(driver, textBox2);
		AjaxLibrary.type(driver, textBox2, Q1value2.replace(".0", ""));
		WebElement textBox3 = textBoxList.get(2);
		GenericLibrary.scrollIntoView(driver, textBox3);
		AjaxLibrary.type(driver, textBox3, Q1value3.replace(".0", ""));
		// Text Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q2);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> scList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		WebElement scBox1 = scList.get(0);
		GenericLibrary.scrollIntoView(driver, scBox1);
		AjaxLibrary.jsType(driver, scBox1, Q3value1.replace(".0", ""));
		WebElement scBox2 = scList.get(1);
		GenericLibrary.scrollIntoView(driver, scBox2);
		AjaxLibrary.jsType(driver, scBox2, Q3value2.replace(".0", ""));
		WebElement scBox3 = scList.get(2);
		GenericLibrary.scrollIntoView(driver, scBox3);
		AjaxLibrary.jsType(driver, scBox3, Q3value3.replace(".0", ""));
		// Date Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, dateBtn);
		// Number Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, sliderOption);
		AjaxLibrary.jsType(driver, sliderMinValue, minValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderMaxValue, maxValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderStepValue, stepValue.replace(".0", ""));
		// Settings
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, displayScoreTotalOnRecord_Yes);
		AjaxLibrary.jsClick(driver, changeRecordOrder_Yes);
		AjaxLibrary.jsClick(driver, copyRecords_Yes);
		AjaxLibrary.jsClick(driver, showLogs_Yes);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		// Settings - Header
		GenericLibrary.scrollPageWrtXY(driver, 0, 800);
		Thread.sleep(1000);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//span[contains(@aria-labelledby,'select2-ddlHeaders-container')]")));
		AjaxLibrary.jsClick(driver, viewAllLink);
		List<WebElement> searchRusults = driver.findElements(By.cssSelector(".select2-result-repository__title"));
		for(int i=0; i<searchRusults.size(); i++) {
			String question = searchRusults.get(i).getText();
			if(question.equalsIgnoreCase("Text Item")) {
				AjaxLibrary.click(driver, searchRusults.get(i));
				break;
			}
		}
		AjaxLibrary.jsClick(driver, headerAddBtn); 
	}

	public void verify_Settings_ScoreMultiply_StrikeOut_FileUpload_Questionnaire(String mainFolder, String subFolder, 
			String QuestionnaireName, String Q1, String Q1value1, String Q1value2, String Q1value3, 
			String Q2, String Q3, String Q3value1, String Q3value2, String Q3value3,
			String Q4, String Q5, String minValue, String maxValue, String stepValue, String filePath,
			String downloadPath, String fileName) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> textBoxList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		WebElement textBox1 = textBoxList.get(0);
		GenericLibrary.scrollIntoView(driver, textBox1);
		AjaxLibrary.type(driver, textBox1, Q1value1.replace(".0", ""));
		WebElement textBox2 = textBoxList.get(1);
		GenericLibrary.scrollIntoView(driver, textBox2);
		AjaxLibrary.type(driver, textBox2, Q1value2.replace(".0", ""));
		WebElement textBox3 = textBoxList.get(2);
		GenericLibrary.scrollIntoView(driver, textBox3);
		AjaxLibrary.type(driver, textBox3, Q1value3.replace(".0", ""));
		// Text Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q2);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> scList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		WebElement scBox1 = scList.get(0);
		GenericLibrary.scrollIntoView(driver, scBox1);
		AjaxLibrary.jsType(driver, scBox1, Q3value1.replace(".0", ""));
		WebElement scBox2 = scList.get(1);
		GenericLibrary.scrollIntoView(driver, scBox2);
		AjaxLibrary.jsType(driver, scBox2, Q3value2.replace(".0", ""));
		WebElement scBox3 = scList.get(2);
		GenericLibrary.scrollIntoView(driver, scBox3);
		AjaxLibrary.jsType(driver, scBox3, Q3value3.replace(".0", ""));
		// Date Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, dateBtn);
		// Number Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, sliderOption);
		AjaxLibrary.jsType(driver, sliderMinValue, minValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderMaxValue, maxValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderStepValue, stepValue.replace(".0", ""));
		// Settings
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, displayScoreTotalOnRecord_Yes);
		AjaxLibrary.jsClick(driver, multiplyScores_Yes);
		AjaxLibrary.jsClick(driver, changeRecordOrder_Yes);
		AjaxLibrary.jsClick(driver, copyRecords_Yes);
		AjaxLibrary.jsClick(driver, showLogs_Yes);
		AjaxLibrary.jsClick(driver, trashCanAction_StrikeOut);
		// Upload Template
		AjaxLibrary.uploadFile(driver, uploadTemplate, filePath);
		Thread.sleep(2000);
		Reporter.log("Template uploaded successfully", true);
		// Download Template
		GenericLibrary.click(driver, downloadQuestionsTemplateBtn);
		Thread.sleep(3000);
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Template NOT downloaded");
		Reporter.log("Template downloaded successfully", true);
		// Settings - Header
		GenericLibrary.scrollPageWrtXY(driver, 0, 800);
		Thread.sleep(1000);
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//span[contains(@aria-labelledby,'select2-ddlHeaders-container')]")));
		AjaxLibrary.jsClick(driver, viewAllLink);
		List<WebElement> searchRusults = driver.findElements(By.cssSelector(".select2-result-repository__title"));
		for(int i=0; i<searchRusults.size(); i++) {
			String question = searchRusults.get(i).getText();
			if(question.equalsIgnoreCase("Date Item")) {
				AjaxLibrary.click(driver, searchRusults.get(i));
				break;
			}
		}
		AjaxLibrary.jsClick(driver, headerAddBtn); 
		Thread.sleep(1000);
		a.assertAll();
	}

	public void verify_Delete_functionality_for_the_Strike_out_record(String mainFolder, String subFolder, 
			String QuestionnaireName, String Q1) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Adding Questionnaire
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		// Settings - Enable Strike out option
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, displayScoreTotalOnRecord_Yes);
		AjaxLibrary.jsClick(driver, changeRecordOrder_Yes);
		AjaxLibrary.jsClick(driver, copyRecords_Yes);
		AjaxLibrary.jsClick(driver, showLogs_Yes);
		AjaxLibrary.jsClick(driver, trashCanAction_StrikeOut);
		// Capture Strike out option functionality
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//label[contains(.,'High')]")));
		AjaxLibrary.jsClick(driver, captureSaveBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteCaptureBtn);
		GenericLibrary.waitForAlertPresent(driver);
		AjaxLibrary.checkAlert_Accept(driver);
		Assert.assertTrue(strikedOutLine.isDisplayed(), "Strike out option not working");
		Reporter.log("Record strike out done successfully", true);
		// Change Settings - Strike out to Delete
		AjaxLibrary.jsClick(driver, buildLink);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);	
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		// Delete Strike out record
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		AjaxLibrary.jsClick(driver, strikedOutLine);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, deleteCaptureBtn);
		GenericLibrary.waitForAlertPresent(driver);
		AjaxLibrary.checkAlert_Accept(driver);
		Assert.assertTrue(noMatchingRecordsFoundMessage.isDisplayed(), "Strike out record not deleted");
		Reporter.log("Strike out record deleted successfully", true);
	}

	public void verify_Add_Scedules_and_delete_schedule_against_the_questionnaire(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String Q1value1, String Q1value2, String Q1value3, String Q2, 
			String Q3, String Q3value1, String Q3value2, String Q3value3,
			String Q4, String Q5, String minValue, String maxValue, String stepValue) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> textBoxList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		WebElement textBox1 = textBoxList.get(0);
		GenericLibrary.scrollIntoView(driver, textBox1);
		AjaxLibrary.type(driver, textBox1, Q1value1.replace(".0", ""));
		WebElement textBox2 = textBoxList.get(1);
		GenericLibrary.scrollIntoView(driver, textBox2);
		AjaxLibrary.type(driver, textBox2, Q1value2.replace(".0", ""));
		WebElement textBox3 = textBoxList.get(2);
		GenericLibrary.scrollIntoView(driver, textBox3);
		AjaxLibrary.type(driver, textBox3, Q1value3.replace(".0", ""));
		// Text Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q2);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> scList = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		WebElement scBox1 = scList.get(0);
		GenericLibrary.scrollIntoView(driver, scBox1);
		AjaxLibrary.jsType(driver, scBox1, Q3value1.replace(".0", ""));
		WebElement scBox2 = scList.get(1);
		GenericLibrary.scrollIntoView(driver, scBox2);
		AjaxLibrary.jsType(driver, scBox2, Q3value2.replace(".0", ""));
		WebElement scBox3 = scList.get(2);
		GenericLibrary.scrollIntoView(driver, scBox3);
		AjaxLibrary.jsType(driver, scBox3, Q3value3.replace(".0", ""));
		// Date Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q4);
		AjaxLibrary.jsClick(driver, dateBtn);
		// Number Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q5);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, sliderOption);
		AjaxLibrary.jsType(driver, sliderMinValue, minValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderMaxValue, maxValue.replace(".0", ""));
		AjaxLibrary.jsType(driver, sliderStepValue, stepValue.replace(".0", ""));
		// Settings - Schedules
		// Settings
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, displayScoreTotalOnRecord_Yes);
		AjaxLibrary.jsClick(driver, changeRecordOrder_Yes);
		AjaxLibrary.jsClick(driver, copyRecords_Yes);
		AjaxLibrary.jsClick(driver, showLogs_Yes);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
		// Settings - Weekly Schedule
		GenericLibrary.scrollPageWrtXY(driver, 0, 800);
		Thread.sleep(1000);
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
		List<WebElement> users = driver.findElements(By.xpath(".//*[@id='tbSchedulePeopleList']//td[1]/input"));
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
		Reporter.log("Schedule to delete created successfully", true);
		JavascriptLibrary.javascriptClickElement(driver, deleteScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			a.assertTrue(deleteItem.isDisplayed());
			a.assertTrue(false, "Schedule not deleted");
		} catch (Exception e) {
			Reporter.log("Schedule deleted successfully", true);
		}
	}

	public void verify_Move_Questionnaire_From_One_Folder_To_Other_Folders(String QuestionnaireName, String folderName) throws Exception {
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		GenericLibrary.moveToElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.scrollPageWrtXY(driver, 0, 1000);
		Thread.sleep(1000);
		searchFolderTxtBox.click();
		searchFolderTxtBox_in.sendKeys(folderName);
		driver.findElement(By.xpath("//div[text()='"+folderName+"']")).click();
		addToFolderBtn.click();
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
	}

	public void verify_Folder_Rename_And_Deletion(String folder1, String folder1Description, String folder2, String folder2Description) throws Exception {
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, parentFolder);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, AddFolderBtn);
		GenericLibrary.waitForElementVisibility(driver, folderNameTextBox);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, folder1);
		GenericLibrary.waitForElementVisibility(driver, descTxt);
		JavascriptLibrary.javascriptType(driver, descTxt, folder1Description);
		JavascriptLibrary.javascriptClickElement(driver, folderSaveBtn);
		try {
			Thread.sleep(2000);
			WebElement f = driver.findElement(By.xpath("//p[text()='"+folder1+"']"));
			JavascriptLibrary.javascriptClickElement(driver, f);
		} catch (WebDriverException e) {
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			Thread.sleep(2000);
			WebElement f = driver.findElement(By.xpath("//p[text()='"+folder1+"']"));
			JavascriptLibrary.javascriptClickElement(driver, f);
		}
		Thread.sleep(2000);
		GenericLibrary.click(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		folderNameTextBox.clear();
		folderNameTextBox.sendKeys(folder2);
		descTxt.clear();
		descTxt.sendKeys(folder2Description);
		folderSaveBtn.click();
		closeFolderEditPage.click();

		GenericLibrary.waitForAjax(driver);
		WebElement ele = driver.findElement(By.xpath("//p[text()='"+folder2+"']"));
		JavascriptLibrary.javascriptClickElement(driver, ele);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, ele);

		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, folderDeleteBtn);
		GenericLibrary.waitForAlertPresent(driver);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}

	public void verify_Cascading_Questionnaire_option(String QuestionnaireName, String folderName, String questionnaire,
			String mainFolder, String subFolder) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, AddBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		GenericLibrary.waitForElementVisibility(driver, savedItem);
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.scrollTop(driver);
		Thread.sleep(1000);
		searchFolderTxtBox.click();
		searchFolderTxtBox_in.sendKeys(folderName);
		driver.findElement(By.xpath("//div[text()='"+folderName+"']")).click();
		addFolderBtn.click();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//div[text()='"+mainFolder+"']/../..//input/following-sibling::span[1]")));
		((JavascriptExecutor)driver).executeScript("scroll(0, -1000)");
		JavascriptLibrary.javascriptClickElement(driver, buildLink);
		GenericLibrary.waitForElementVisibility(driver, questionnaireSearchBox);
		JavascriptLibrary.javascriptType(driver, questionnaireSearchBox, questionnaire);
		AjaxLibrary.jsClick(driver, questionnaireSearchBtn);
		GenericLibrary.waitForElementVisibility(driver, CascadeTest);
		Assert.assertTrue(CascadeTest.isDisplayed(), "Questionnaire Not Found");
		Reporter.log("Questionnaire created at root folder",true);
		JavascriptLibrary.javascriptClickElement(driver, buildLink);
		driver.findElement(By.xpath("//*[text()='"+mainFolder+"']")).click();
		GenericLibrary.waitForElementVisibility(driver, CascadeTest);
		Assert.assertTrue(CascadeTest.isDisplayed(), "Questionnaire Not Found");
		Reporter.log("Questionnaire copied to Parent folder",true);
		driver.findElement(By.xpath("//*[text()='"+subFolder+"']")).click();
		JavascriptLibrary.javascriptType(driver, questionnaireSearchBox, questionnaire);
		AjaxLibrary.jsClick(driver, questionnaireSearchBtn);
		GenericLibrary.waitForElementVisibility(driver, CascadeTest);
		Assert.assertTrue(CascadeTest.isDisplayed(), "Questionnaire Not Found");
		Reporter.log("Questionnaire copied to Child folder",true);
	}

	public void verify_Create_Up_Issue(String QuestionnaireName, String Q1, String Q2, String answer1, String hint1, String score1,
			String answer2, String hint2, String score2, String Q3, String header, String description, String searchItem,
			String Q1Ans, String Q3Ans) throws Exception {
		// Creating Questionnaire for Up Issue
		GenericLibrary.waitForElementVisibility(driver, AddBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		Assert.assertTrue(newItemBtn.isDisplayed(), "Questionnaire for Up Issue is not created");
		Reporter.log("Questionnaire for Up Issue created successfully and Create New field button is Displayed", true);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, upIssueBtn);
		AjaxLibrary.jsClick(driver, acceptUpIssueBtn);
		AjaxLibrary.selectElementByVisibleText(driver, upIssueVersionDropDown, "Version 2");
		Assert.assertTrue(newItemBtn.isDisplayed(), "Version 2 or up issue not created");
		Reporter.log("Up Issue created successfully and New Item button is displayed for Version 2", true);
		// Text Item
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		// MultiChoice Item - score
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q2);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, plusSign);
		AjaxLibrary.jsClick(driver, plusSign);
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		AjaxLibrary.jsClick(driver, scoreYesBtn);
		AjaxLibrary.jsClick(driver, scoreShowInIqaptureBtn);
		AjaxLibrary.jsClick(driver, mandatoryBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		List<WebElement> ansTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		List<WebElement> hintTextBoxes = driver.findElements(By.xpath("//textarea[@placeholder='Enter hint for answer…']"));
		List<WebElement> scoreTextBox = driver.findElements(By.xpath("//input[@field='FI_SCORE' and @type='text']"));
		List<WebElement> eyelist = driver.findElements(By.xpath("//span[@class='desc hide-desc']"));
		ansTextBoxes.get(0).sendKeys(answer1);
		ansTextBoxes.get(0).sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		hintTextBoxes.get(0).sendKeys(hint1);
		GenericLibrary.waitForAjax(driver);
		eyelist.get(0).click();
		GenericLibrary.waitForAjax(driver);
		scoreTextBox.get(0).sendKeys(score1.replace(".0", ""));
		scoreTextBox.get(0).sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		ansTextBoxes.get(1).sendKeys(answer2);
		ansTextBoxes.get(1).sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		WebElement h2 = hintTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, h2);
		h2.sendKeys(hint2);
		GenericLibrary.waitForAjax(driver);
		eyelist.get(1).click();
		GenericLibrary.waitForAjax(driver);
		scoreTextBox.get(1).sendKeys(score2.replace(".0", ""));
		scoreTextBox.get(1).sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		//Table
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, addSubFieldBtn);
		tableHeaderTxtBox.click();
		JavascriptLibrary.javascriptType(driver, tableHeaderTxtBox, header);
		tableDescriptionTxtBox.click();
		JavascriptLibrary.javascriptType(driver, tableDescriptionTxtBox, description);
		tableDescriptionTxtBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, "Q4");
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		// Publishing up issue
		JavascriptLibrary.javascriptClickElement(driver, publishUpIssueBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, publishConfirmationMsg);
		Assert.assertTrue(publishConfirmationMsg.isDisplayed(),"Publish confirmation message NOT displayed");
		Reporter.log("Publish confirmation message displayed", true);
		JavascriptLibrary.javascriptClickElement(driver, OkBtn);
		GenericLibrary.waitForAjax(driver);
		// Answering in Capture section
		JavascriptLibrary.javascriptClickElement(driver, TaskBoardPage.captureLink);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, searchItem);
		AjaxLibrary.jsClick(driver, searchBtn);
		List<WebElement> list = driver.findElements(By.xpath("//h3[@title='"+QuestionnaireName+"']"));
		AjaxLibrary.jsClick(driver, list.get(list.size()-1));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForElementVisibility(driver, Q1TextBox);
		Q1TextBox.sendKeys(Q1Ans);
		JavascriptLibrary.javascriptClickElement(driver, Q2Ans1);
		Q3TextBox.sendKeys(Q3Ans.replace(".0", ""));
		JavascriptLibrary.javascriptClickElement(driver, captureSaveBtn);
		GenericLibrary.waitForAjax(driver);
		Thread.sleep(1000);
	}

	public void verify_Up_Issue_on_modifying_questionnaire(String QuestionnaireName, String answer, String hint, String newDesc) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, QuestionnaireSearchBox);
		questionnaireSearchBox.sendKeys(QuestionnaireName);
		questionnaireSearchBox.sendKeys(Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//h3[@title='"+QuestionnaireName+"']"));
		AjaxLibrary.jsClick(driver, list.get(list.size()-1));
		// Up Issue On adding new Item / Modify existing Question
		GenericLibrary.waitForElementVisibility(driver, newItemBtn);
		JavascriptLibrary.javascriptClickElement(driver, newItemBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on adding new Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Up Issue On modifying MultiChoice question Ans/Hint/Score
		JavascriptLibrary.javascriptClickElement(driver, Q2_Multichoice);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> ansTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		WebElement ansTextBox1 = ansTextBoxes.get(0);
		GenericLibrary.waitForElementVisibility(driver, ansTextBox1);
		ansTextBox1.sendKeys(answer);
		ansTextBox1.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on modifying answer field for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Up Issue On Adding new field, Copy, Download answers and Upload answers
		// Add new Field
		GenericLibrary.waitForElementVisibility(driver, plusSign);
		JavascriptLibrary.javascriptClickElement(driver, plusSign);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on adding new field for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Copy Questions
		GenericLibrary.waitForElementVisibility(driver, copyQuestionsBtn);
		JavascriptLibrary.javascriptClickElement(driver, copyQuestionsBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on copying Questions for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Download Template
		GenericLibrary.waitForElementVisibility(driver, downloadTemplateBtn);
		JavascriptLibrary.javascriptClickElement(driver, downloadTemplateBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on downloading template for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Upload Template
		AjaxLibrary.jsClick(driver, uploadTemplateBtn);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on uploading template for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// No - Up Issue on on modifying Hint of the Answer
		List<WebElement> hintTextBoxes = driver.findElements(By.xpath("//textarea[@placeholder='Enter hint for answer…']"));
		WebElement hintTextBox1 = hintTextBoxes.get(0);
		GenericLibrary.waitForElementVisibility(driver, hintTextBox1);
		hintTextBox1.sendKeys(hint);
		hintTextBox1.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("No Up issue raised on modifying hint field for MultiCoice Question",true);
		// No - Up Issue on on modifying Show Hint of the Answer
		List<WebElement> eyeList = driver.findElements(By.xpath("//i[@title='Remove Item']//following::span[2]"));
		WebElement eyeList1 = eyeList.get(0);
		GenericLibrary.waitForElementVisibility(driver, eyeList1);
		JavascriptLibrary.javascriptClickElement(driver, eyeList1);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("No Up issue raised on show hint button for MultiCoice Question",true);
		// Up Issue On Deleting Answer for MultiChoice Question
		driver.navigate().refresh();
		JavascriptLibrary.javascriptClickElement(driver, Q2_Multichoice);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> removeAnsBtns = driver.findElements(By.xpath("//i[@title='Remove Item']"));
		WebElement removeAnsBtn1 = removeAnsBtns.get(0);
		GenericLibrary.waitForElementVisibility(driver, removeAnsBtn1);
		JavascriptLibrary.javascriptClickElement(driver, removeAnsBtn1);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on deleting answer for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Up Issue on changing the design type
		GenericLibrary.waitForElementVisibility(driver, advancedBtn);
		JavascriptLibrary.javascriptClickElement(driver, advancedBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on changing design type for MultiCoice Question",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Up Issue on Changing the description
		JavascriptLibrary.javascriptClickElement(driver, Q2_Multichoice);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, newDesc);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on changing description",true);
		AjaxLibrary.click(driver, cancelUpIssue);
		// Up issue on changing the sub field of table Questions
		JavascriptLibrary.javascriptClickElement(driver, Q3_Table);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, propertyOption);
		propertyOption.click();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on changing sub field of table Question",true);
		AjaxLibrary.actionClick(driver, cancelUpIssue);
		// Up issue on deleting the answered Question
		GenericLibrary.waitForElementVisibility(driver, removeFieldBtn);
		JavascriptLibrary.javascriptClickElement(driver, removeFieldBtn);
		driver.switchTo().alert().accept();
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on deleting Question",true);
		AjaxLibrary.actionClick(driver, cancelUpIssue);
		// Up issue on changing Table header and description
		GenericLibrary.waitForElementVisibility(driver, tableDescriptionTxtBox);
		Thread.sleep(2000);
		tableDescriptionTxtBox.click();
		tableDescriptionTxtBox.clear();
		tableDescriptionTxtBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		a.assertTrue(acceptUpIssueBtn.isDisplayed(), "Up Issue Not Created");
		Reporter.log("Up issue raised on changing table header and description of Table Question",true);
		AjaxLibrary.actionClick(driver, cancelUpIssue);
		// No Up issue on enabling Searchable option
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//span[text()='Q4']")));
		AjaxLibrary.jsClick(driver, moreOptionsBtn);
		AjaxLibrary.jsClick(driver, searchableBtn);
		GenericLibrary.doubleClickWebelement(driver, closeBtn);
		Reporter.log("No Up issue on enabling Searchable option", true);

		a.assertAll();
	}

	public void verify_modify_the_Captured_Question(String QuestionnaireName) throws Exception {
		SoftAssert a = new SoftAssert();
		GenericLibrary.waitForElementVisibility(driver, QuestionnaireSearchBox);
		questionnaireSearchBox.sendKeys(QuestionnaireName);
		questionnaireSearchBox.sendKeys(Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//h3[@title='"+QuestionnaireName+"']"));
		AjaxLibrary.jsClick(driver, list.get(list.size()-1));
		GenericLibrary.waitForElementVisibility(driver, newItemBtn);
		// Preview for the captured Questionnaire
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, previewOption);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(previewCloseBtn.isDisplayed(), "Preview is not functional");
		Reporter.log("Preview for the captured Questionnnaire is functional",true);
		previewCloseBtn.click();
		Thread.sleep(1000);
		// Copy the captured Questionnaire
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		GenericLibrary.waitForElementVisibility(driver, copyQuestionnaireBtn);
		JavascriptLibrary.javascriptClickElement(driver, copyQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		String copiedQuestionnaire = driver.findElement(By.xpath(".//*[@id='divDS_NAME']")).getText();
		a.assertEquals("Test Up Issue Copy", copiedQuestionnaire, "Copy is not functional");
		Reporter.log("Copy Questionnaire for the captured Questionnnaire is functional",true);

		a.assertAll();
	}

	public void verify_Latest_version_questions_are_not_reflecting_on_copying_old_version(
			String qName, String Q1, String Q2) throws Exception {
		// Version 1
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, qName);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		// Create up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		GenericLibrary.waitForElementVisibility(driver, upIssueBtn);
		JavascriptLibrary.javascriptClickElement(driver, upIssueBtn);
		GenericLibrary.waitForElementVisibility(driver, acceptUpIssueBtn);
		JavascriptLibrary.javascriptClickElement(driver, acceptUpIssueBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, upIssueVersionDropDown);
		Assert.assertTrue(VerificationLibrary.isOptionPresentInTheDropdown(upIssueVersionDropDown, "Version 2"), "Up issue not created");
		Reporter.log("Up Issue created successfully for verifying copy older version option", true);
		// Add new Question for latest version 
		JavascriptLibrary.javascriptClickElement(driver, newItemBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q2);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+Q2+"')]")).isDisplayed(), "New Question not added to latest version");
		Reporter.log("New Question added to Latest version successfully", true);
		// Copy old version
		GenericLibrary.selectElementByVisibleText(upIssueVersionDropDown, "Version 1");
		GenericLibrary.hoverWebelement(driver, moreBtn);
		GenericLibrary.waitForElementVisibility(driver, copyQuestionnaireBtn);
		JavascriptLibrary.javascriptClickElement(driver, copyQuestionnaireBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+Q2+"')]")).isDisplayed());
			Reporter.log("New version's newly added Questions copied to old version copy", true);
			Assert.assertTrue(false);
		} catch (AssertionError | NoSuchElementException e) {
			Reporter.log("New version's newly added Questions not copied to old version copy: Test Pass", true);
		}

		Thread.sleep(3000);
	}

	public void verify_Add_and_Remove_the_people_against_the_Questionnaire(String mainFolder, String subFolder, String QuestionnaireName, String Q1, String user) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		GenericLibrary.waitForElementVisibility(driver, nameTxtBox);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, newItemBtn);
		JavascriptLibrary.javascriptClickElement(driver, newItemBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings - Add & Remove people 
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		// Add unknown user and verify 'User not found' message
		GenericLibrary.waitForElementVisibility(driver, peopleSearchBox);
		peopleSearchBox.sendKeys("asdfghjkl");
		GenericLibrary.click(driver, peopleSearchBtn);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForAjax(driver);
		a.assertTrue(userNotFoundMessage.isDisplayed(), "No message displayed for unknown user search");
		Reporter.log("'User not found' message displayed successfully for unknown user search", true);
		// Add a valid user
		peopleSearchBox.clear();
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		try {
			AjaxLibrary.jsClick(driver, userAddBtn);
			Thread.sleep(1000);
			WebElement addedUser = driver.findElement(By.xpath("(//span[text()='"+user+"'])[1]"));
			GenericLibrary.scrollIntoView(driver, addedUser);
			a.assertEquals(addedUser.getText(), user, "User not added");
			Reporter.log("Given user added successfully", true);
		} catch (Exception e) {
			a.assertTrue(userNotFoundMessage.isDisplayed(), "No message displayed for unknown user search");
			Reporter.log("'User not found' message displayed successfully for unknown user search", true);
		}
		// Add the same user again and verify 'added' message
		peopleSearchBox.clear();
		peopleSearchBox.sendKeys(user);
		AjaxLibrary.jsClick(driver, peopleSearchBtn);
		try {
			a.assertTrue(addedMessage.isDisplayed(), "'Added' message not displayed for already added user");
			Reporter.log("'added' message displayed successfully for already added user", true);
		} catch (Exception e) {
			a.assertTrue(userNotFoundMessage.isDisplayed(), "No message displayed for unknown user search");
			Reporter.log("'User not found' message displayed successfully for unknown user search", true);
		}
		// Remove User
		WebElement userRemoveBtn = driver.findElement(By.xpath("//span[@class='comuser-username'][contains(.,'"+user+"')]/following::i[1]"));
		GenericLibrary.scrollIntoView(driver, userRemoveBtn);
		JavascriptLibrary.javascriptClickElement(driver, userRemoveBtn);
		JavascriptLibrary.javascriptClickElement(driver, YesBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("User deleted successfully", true);
		a.assertAll();
	}

	public void verify_Tool_tips_for_all_options_in_Settings(String mainFolder, String subFolder, String QuestionnaireName, 
			String tt1, String tt2, String tt3,String tt4, String tt5, String tt6, String tt7, String tt8, String tt9,
			String tt10, String tt11, String tt12, String tt13, String tt14) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		GenericLibrary.waitForElementVisibility(driver, nameTxtBox);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Settings 
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		// Verify tooltips
		String txt1 = GenericLibrary.getToolTip2(scoreTotalTooltip, "data-original-title");
		a.assertEquals(txt1, tt1, "Score total tooltip not displayed");
		Reporter.log("Score total tooltip verified successfully", true);

		String txt2 = GenericLibrary.getToolTip2(changeRecordOrderTooltip, "data-original-title");
		a.assertEquals(txt2, tt2, "Change record order tooltip not displayed");
		Reporter.log("Change record order tooltip verified successfully", true);

		String txt3 = GenericLibrary.getToolTip2(copyRecordsTooltip, "data-original-title");
		a.assertEquals(txt3, tt3, "Copy records tooltip not displayed");
		Reporter.log("Copy records tooltip verified successfully", true);

		String txt4 = GenericLibrary.getToolTip2(showLogTooltip, "data-original-title");
		a.assertEquals(txt4, tt4, "Show log tooltip not displayed");
		Reporter.log("Show log tooltip verified successfully", true);

		String txt5 = GenericLibrary.getToolTip2(trashCanActionTooltip, "data-original-title");
		a.assertEquals(txt5, tt5, "Trash can action tooltip not displayed");
		Reporter.log("Trash can action tooltip verified successfully", true);

		String txt6 = GenericLibrary.getToolTip2(capturePresentationStyleTooltip, "data-original-title");
		a.assertEquals(txt6, tt6, "Capture presentation style tooltip not displayed");
		Reporter.log("Capture presentation style tooltip verified successfully", true);

		String txt7 = GenericLibrary.getToolTip2(uploadQuestionsTooltip, "data-original-title");
		a.assertEquals(txt7, tt7, "Upload question tooltip not displayed");
		Reporter.log("Upload question tooltip verified successfully", true);

		String txt8 = GenericLibrary.getToolTip2(peopleAddedTooltip, "data-original-title");
		a.assertEquals(txt8, tt8, "People added tooltip not displayed");
		Reporter.log("People added tooltip verified successfully", true);

		String txt9 = GenericLibrary.getToolTip2(contactsTooltip, "data-original-title");
		a.assertEquals(txt9, tt9, "Contacts tooltip not displayed");
		Reporter.log("Contacts tooltip verified successfully", true);

		String txt10 = GenericLibrary.getToolTip2(scheduleTooltip, "data-original-title");
		a.assertEquals(txt10, tt10, "Schedule tooltip not displayed");
		Reporter.log("Schedule tooltip verified successfully", true);

		String txt11 = GenericLibrary.getToolTip2(alertsTooltip, "data-original-title");
		a.assertEquals(txt11, tt11, "Alerts tooltip not displayed");
		Reporter.log("Alerts tooltip verified successfully", true);

		String txt12 = GenericLibrary.getToolTip2(headersTooltip, "data-original-title");
		a.assertEquals(txt12, tt12, "Headers tooltip not displayed");
		Reporter.log("Headers tooltip verified successfully", true);

		String txt13 = GenericLibrary.getToolTip2(foldersTooltip, "data-original-title");
		a.assertEquals(txt13, tt13, "Folders tooltip not displayed");
		Reporter.log("Folders tooltip verified successfully", true);

		String txt14 = GenericLibrary.getToolTip2(folderPathTootip, "data-content");
		a.assertEquals(txt14, tt14, "Folder path tooltip not displayed");
		Reporter.log("Folder path tooltip verified successfully", true);
	}

	public void verify_Add_alert_and_Delete_alert_against_the_questionnaire(String mainFolder, String subFolder, String QuestionnaireName, String Q1, String Q2,
			String alert1, String condition1, String text1, String logicalCondition1, String condition2, String text2, String whenOption1, String whenOption2, String alert2) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Q1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		// Q2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q2);
		// Settings 
		AjaxLibrary.jsClick(driver, settingsBtn);
		// Add Alert 1
		GenericLibrary.click(driver, addAlertBtn);
		AjaxLibrary.jsType(driver, alertLabelTextBox, alert1);
		JavascriptLibrary.javascriptClickElement(driver, addAlertPeopleBtn);
		List<WebElement> peopleList = driver.findElements(By.cssSelector(".bs-checkbox>input"));
		for (int i = 0; i <= 1; i++) {
			JavascriptLibrary.javascriptClickElement(driver, peopleList.get(i));
		}
		JavascriptLibrary.javascriptClickElement(driver, addAlertPeopleBtn);
		Thread.sleep(3000);
		int count = Integer.parseInt(addedAlertPeople.getText());
		a.assertEquals((count), 2, "People not added");
		Reporter.log("People added to the alert: "+count, true);
		GenericLibrary.selectElementByVisibleText(conditionQuestionsDD1, Q1);
		Thread.sleep(2000);
		/*GenericLibrary.selectElementByVisibleText(alertConditionDD1, condition1);
		Thread.sleep(1000);*/
		textCondition1.sendKeys(text1);
		JavascriptLibrary.javascriptClickElement(driver, addCondition2);
		GenericLibrary.selectElementByVisibleText(logicalOperatorDD, logicalCondition1);
		GenericLibrary.selectElementByVisibleText(conditionQuestionsDD2, Q2);
		/*GenericLibrary.selectElementByVisibleText(alertConditionDD2, condition2);
		Thread.sleep(1000);*/
		textCondition2.sendKeys(text2);
		GenericLibrary.click(driver, whatConditionSearch1);
		driver.findElement(By.xpath("//li[contains(text(),'"+Q1+"')]")).click();
		whatConditionSearch1.sendKeys(Keys.TAB);
		GenericLibrary.selectElementByVisibleText(whenDD1, whenOption1);
		Thread.sleep(1000);
		GenericLibrary.click(driver, addWhen2);
		GenericLibrary.selectElementByVisibleText(whenDD2, whenOption2);
		a.assertTrue(driver.findElement(By.xpath("//label[contains(.,'"+alert1+"')]")).isDisplayed(), "Alert 1 NOT Added");
		Reporter.log("Alert 1 added", true);
		// Add Alert 2
		GenericLibrary.click(driver, addAlertBtn);
		AjaxLibrary.jsType(driver, alertLabelTextBox, alert2);
		WebElement alert = driver.findElement(By.xpath("//label[contains(.,'"+alert2+"')]"));
		a.assertTrue(alert.isDisplayed(), "Alert 2 NOT Added");
		Reporter.log("Alert 2 added", true);
		// Remove Alert
		JavascriptLibrary.javascriptClickElement(driver, deleteAlertBtn);
		Thread.sleep(1000);
		try {
			a.assertTrue(alert.isDisplayed());
			a.assertTrue(false, "Alert NOT deleted");
		} catch (Exception e) {
			Reporter.log("Alert 2 deleted", true);
		}
		a.assertAll();
	}

	public void verify_Save_and_Complete_assigned_iQapture_record_from_the_dashboard(String mainFolder, String subFolder,
			String QuestionnaireName, String Q1) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		GenericLibrary.waitForElementVisibility(driver, nameTxtBox);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Q1
		GenericLibrary.waitForElementVisibility(driver, newItemBtn);
		JavascriptLibrary.javascriptClickElement(driver, newItemBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings 
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		// Current Month Date
		GenericLibrary.scrollIntoView(driver, addScheduleBtn);
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Today");
		JavascriptLibrary.javascriptClickElement(driver, setDateCalenderBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> currentMonthDays = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : currentMonthDays) {
			if(ele.getAttribute("class").contains("day today")) {
				GenericLibrary.click(driver, ele);
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		// Verify Activity in Taskboard
		AjaxLibrary.jsClick(driver, TaskBoardPage.taskBoardLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.upcomingTasks);
		WebElement iQ = driver.findElement(By.xpath("//span[contains(.,'"+QuestionnaireName+"')]"));
		GenericLibrary.scrollIntoView(driver, iQ);
		GenericLibrary.click(driver, iQ);
		GenericLibrary.waitForAjax(driver);
		AjaxLibrary.jsClick(driver, CapturePage.saveBtn);
		Reporter.log("Assigned iQapture saved from the dashboard successfully", true);
		AjaxLibrary.jsClick(driver, CapturePage.completeBtn);
		Reporter.log("Assigned iQapture completed from the dashboard successfully", true);
	}

	public void verify_Assigned_record_is_removing_or_not_at_dashboard_when_the_record_deleted_at_capture(String mainFolder, String subFolder,
			String QuestionnaireName, String Q1, String user, String target) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		GenericLibrary.waitForElementVisibility(driver, nameTxtBox);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		// Q1
		GenericLibrary.waitForElementVisibility(driver, newItemBtn);
		JavascriptLibrary.javascriptClickElement(driver, newItemBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, Q1);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		// Settings 
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, trashCanAction_Delete);
		GenericLibrary.waitForAjax(driver);
		// Current Month Date
		GenericLibrary.scrollIntoView(driver, addScheduleBtn);
		JavascriptLibrary.javascriptClickElement(driver, addScheduleBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, setDateBtn);
		JavascriptLibrary.javascriptClickElement(driver, scheduleLabelTxtBox);
		scheduleLabelTxtBox_in.clear();
		JavascriptLibrary.javascriptType(driver, scheduleLabelTxtBox_in, "Today");
		JavascriptLibrary.javascriptClickElement(driver, setDateCalenderBtn);
		GenericLibrary.waitForAjax(driver);
		List<WebElement> currentMonthDays = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : currentMonthDays) {
			if(ele.getAttribute("class").contains("day today")) {
				GenericLibrary.click(driver, ele);
				break;
			}
		}
		GenericLibrary.waitForAjax(driver);
		// Create a record and Assign the user at Capture
		GenericLibrary.click(driver, TaskBoardPage.captureLink);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		GenericLibrary.waitForElementVisibility(driver, addBtn);
		JavascriptLibrary.javascriptClickElement(driver, addBtn);
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, assignBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, userField);
		userSearchField.sendKeys(user);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//div[contains(text(),'"+user+"')]")));
		GenericLibrary.waitForAjax(driver);
		assignTargetField.sendKeys(target);
		GenericLibrary.click(driver, swicthToHourBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, okBtn_AssignWindow);
		GenericLibrary.waitForAjax(driver);
		// Verify the record in dashboard
		AjaxLibrary.jsClick(driver, TaskBoardPage.taskBoardLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.upcomingTasks);
		List<WebElement> iQ = driver.findElements(By.xpath("//span[contains(.,'"+QuestionnaireName+"')]"));
		int count = iQ.size();
		Assert.assertTrue(count > 1, "Assigned record not displayed at dashbaord");
		Reporter.log("Assigned record displayed at dashboard", true);
		GenericLibrary.click(driver, TaskBoardPage.captureLink);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, driver.findElement(By.xpath("//td/span[contains(text(),'"+user+"')]")));
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.waitForElementVisibility(driver, moreBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		GenericLibrary.click(driver, deleteCaptureBtn);
		GenericLibrary.waitForAlertPresent(driver);
		GenericLibrary.checkAlert_Accept(driver);
		GenericLibrary.waitForAjax(driver);
		Assert.assertTrue(noMatchingRecordsFoundMessage.isDisplayed(), "Record not deleted at capture");
		Reporter.log("Record deleted at capture successfully", true);
		// Verify deleted record in dashboard
		AjaxLibrary.jsClick(driver, TaskBoardPage.taskBoardLink);
		AjaxLibrary.jsClick(driver, TaskBoardPage.upcomingTasks);
		List<WebElement> iQList = driver.findElements(By.xpath("//span[contains(.,'"+QuestionnaireName+"')]"));
		int count2 = iQList.size();
		Assert.assertTrue(count2 < count, "Assigned record not deleted from the dashboard on deleting the record at capture");
		Reporter.log("Assigned record deleted from the dashboard on deleting the record at capture", true);
	}

	public void verify_Change_record_order(String mainFolder, String subFolder,
			String QuestionnaireName, String Q1, String value, String from, String to) throws Exception {
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Q1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		// Settings 
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, changeRecordOrder_Yes);
		// Create a records 
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		for (int i = 0; i < 5; i++) {
			AjaxLibrary.jsClick(driver, addBtn);
			AjaxLibrary.jsType(driver, driver.findElement(By.xpath("(//span[text()='1.']/following::input)[1]")), value);
			AjaxLibrary.jsClick(driver, captureSaveBtn);
			AjaxLibrary.jsClick(driver, capturePageBackBtn);
		}
		WebElement fromRecord = driver.findElement(By.xpath("(//span[contains(@style,'padding-right')])[4*"+from.replace(".0", "")+"]"));
		WebElement toRecord = driver.findElement(By.xpath("(//span[contains(@style,'padding-right')])[4*"+to.replace(".0", "")+"]"));
		String id1 = fromRecord.getText();
		String id2 = toRecord.getText();
		Reporter.log("Before changing order record ID: "+id1, true);
		Reporter.log("Before changing order record ID: "+id2, true);
		AjaxLibrary.dragAndDrop(driver, fromRecord, toRecord);
		String id3 = driver.findElement(By.xpath("(//span[contains(@style,'padding-right')])[4*"+from.replace(".0", "")+"]")).getText();
		String id4 = driver.findElement(By.xpath("(//span[contains(@style,'padding-right')])[4*"+to.replace(".0", "")+"]")).getText();
		Reporter.log("After changing order record ID: "+id3, true);
		Reporter.log("After changing order record ID: "+id4, true);
		Assert.assertTrue(id1.equals(id4) && id2.equals(id3), "Record order not changed");
		Reporter.log("Record order changed", true);
	}

	public void verify_Capture_Logs_on_manual_entry_and_on_template_upload(String mainFolder, String subFolder,
			String QuestionnaireName, String Q1, String ans, String downloadPath, String filePath) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']")));
		AjaxLibrary.click(driver, driver.findElement(By.xpath("//h3[text()='"+subFolder+"']")));
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Q1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		// Capture logs
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		AjaxLibrary.jsClick(driver, addBtn);
		// Logs on manual entry
		AjaxLibrary.jsType(driver, driver.findElement(By.xpath("(//span[text()='1.']/following::input)[1]")), ans);
		AjaxLibrary.jsClick(driver, captureSaveBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, captureLogsOption);
		List<WebElement> logList = driver.findElements(By.xpath("//td[contains(@style,'vertical-align: middle; width: 330px; ')]"));
		a.assertNotEquals(logList.size(), 0, "Logs not generated on manual entry");
		for (int i = 0; i < logList.size(); i++) {
			Reporter.log("Log "+i+": "+logList.get(i).getText(), true);
		}
		Reporter.log("Logs generated on manual entry", true);
		// Logs on uploading template 
		AjaxLibrary.jsClick(driver, capturePageBackBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, captureDownloadTemplate);
		Thread.sleep(3000);
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, QuestionnaireName), "Template not downloaded");
		Reporter.log("Template downloaded", true);
		JavascriptLibrary.javascriptClickElement(driver, moreBtn);
		Thread.sleep(1000);
		AjaxLibrary.uploadFile(driver, captureUploadTemplate, filePath);
		AjaxLibrary.jsClick(driver, captureRecord1);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, captureLogsOption);
		List<WebElement> logList2 = driver.findElements(By.xpath("//td[contains(@style,'vertical-align: middle; width: 330px; ')]"));
		a.assertNotEquals(logList2.size(), 0, "Logs not generated on upload template");
		for (int i = 0; i < logList2.size(); i++) {
			Reporter.log("Log "+i+": "+logList2.get(i).getText(), true);
		}
		Reporter.log("Logs generated on upload template", true);
		a.assertAll();
	}

	public void verify_Deleted_version_questions_visibility_in_analyse_section(String QuestionnaireName, String Q1, String Q2, 
			String ans1, String ans2, String Q3) {
		SoftAssert a = new SoftAssert();
		// Create Questionnaire
		AjaxLibrary.jsClick(driver, AddBtn);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q2);
		// Capture Questionnaire
		AjaxLibrary.jsClick(driver, TaskBoardPage.captureLink);
		JavascriptLibrary.javascriptType(driver, searchBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//h3[@title='"+QuestionnaireName+"'])[last()]")));
		AjaxLibrary.jsClick(driver, addBtn);
		AjaxLibrary.jsType(driver, Q1TextBox, ans1);
		AjaxLibrary.jsType(driver, Q2TextBox, ans2);
		AjaxLibrary.jsClick(driver, captureSaveBtn);
		// Add Up issue in Build
		AjaxLibrary.jsClick(driver, buildLink);
		questionnaireSearchBox.sendKeys(QuestionnaireName);
		questionnaireSearchBox.sendKeys(Keys.ENTER);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//h3[@title='"+QuestionnaireName+"'])[last()]")));
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsClick(driver, acceptUpIssueBtn);
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.type(driver, descriptionTextBox, Q3);
		AjaxLibrary.jsClick(driver, publishUpIssueBtn);
		AjaxLibrary.jsClick(driver, OkBtn);
		// Goto Analyse section and verify Questions of all versions 
		AjaxLibrary.click(driver, TaskBoardPage.AnalyseLink);
		analysesSearchBox.sendKeys(QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchQuestionnaireBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//h3[@title='"+QuestionnaireName+"'])[last()]")));
		AjaxLibrary.jsClick(driver, createReportBtn);
		a.assertTrue(Question3.isDisplayed(),"Question in latest version is not displayed");
		Reporter.log("Question in latest version is displayed", true);
		// Delete latest version
		AjaxLibrary.jsClick(driver, buildLink);
		questionnaireSearchBox.sendKeys(QuestionnaireName);
		questionnaireSearchBox.sendKeys(Keys.ENTER);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//h3[@title='"+QuestionnaireName+"'])[last()]")));
		GenericLibrary.moveToElement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, deleteBtn);
		AjaxLibrary.jsClick(driver, okBtn);
		// Verify latest version question visibility in Analyse 
		AjaxLibrary.click(driver, TaskBoardPage.AnalyseLink);
		analysesSearchBox.sendKeys(QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchQuestionnaireBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("(//h3[@title='"+QuestionnaireName+"'])[last()]")));
		AjaxLibrary.jsClick(driver, createReportBtn);
		try {
			a.assertTrue(Question3.isDisplayed());
			a.assertTrue(false,"Question in latest version is still displayed even latest version deleted");
		} catch (NoSuchElementException e) {
			Reporter.log("Question in latest version is not displayed in analyse scetion when latest version deleted", true);
		}
		a.assertAll();
	}

	public void verify_Up_issue_log(String QuestionnaireName, String Q1, String Q, String ans, String tHeader, String tDesc, String propOpt, String sourceOption, String formatOption, String noOfSubQ, String filePath) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Log on Up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, upIssueBtn);
		AjaxLibrary.jsClick(driver, acceptUpIssueBtn);
		// Issue log on Version change/up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log1 = driver.findElements(logList);
		a.assertEquals(log1.size(), 1, "Log not generated on up issue:");
		Reporter.log("Log generated on up issue:", true);
		for (int i = 0; i < log1.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log1.get(i).getText(),true);
		}
		// Issue log on adding question 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log2 = driver.findElements(logList);
		a.assertNotEquals(log2.size(), log1.size(), "Log not generated on adding question:");
		Reporter.log("Log generated on adding question:", true);
		for (int i = 0; i < log2.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log2.get(i).getText(),true);
		}
		// Issue log on description change
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.clickSelectAndType(driver, descriptionTextBox, descriptionTextBox, Q);
		//AjaxLibrary.clickClearAndType(driver, descriptionTextBox, Q);
		a.assertTrue(Qdesc.isDisplayed(), "Description not changed");
		Reporter.log("Description changed", true);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log3 = driver.findElements(logList);
		a.assertNotEquals(log3.size(), log2.size(), "Log not generated on changing description:");
		Reporter.log("Log generated on changing description:", true);
		for (int i = 0; i < log3.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log3.get(i).getText(),true);
		}
		// Issue log on dataset type change
		AjaxLibrary.jsClick(driver, Qdesc);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log4 = driver.findElements(logList);
		a.assertNotEquals(log4.size(), log3.size(), "Log not generated on changing dataset type:");
		Reporter.log("Log generated on changing dataset type:", true);
		for (int i = 0; i < log4.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log4.get(i).getText(),true);
		}
		// Issue log on deleting question
		AjaxLibrary.jsClick(driver, Qdesc);
		GenericLibrary.click(driver, removeFieldBtn);
		AjaxLibrary.checkAlert_Accept(driver);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log5 = driver.findElements(logList);
		a.assertNotEquals(log5.size(), log4.size(), "Log not generated on deleting question:");
		Reporter.log("Log generated on deleting question:", true);
		for (int i = 0; i < log5.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log5.get(i).getText(),true);
		}
		// Issue on changing multiChoice radio to dropdown 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log6 = driver.findElements(logList);
		a.assertNotEquals(log6.size(), log5.size(), "Log not generated on changing multiChoice radio to dropdown:");
		Reporter.log("Log generated on changing multiChoice radio to dropdown:", true);
		for (int i = 0; i < log6.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log6.get(i).getText(),true);
		}
		// Issue on changing multiChoice dropdown to checkbox 
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, checkBoxOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log7 = driver.findElements(logList);
		a.assertNotEquals(log7.size(), log6.size(), "Log not generated on changing multiChoice dropdown to checkbox:");
		Reporter.log("Log generated on changing multiChoice dropdown to checkbox:", true);
		for (int i = 0; i < log7.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log7.get(i).getText(),true);
		}
		// Issue log on adding multiChoice answers
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, plusSign);
		AjaxLibrary.jsType(driver, answerField, ans);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log8 = driver.findElements(logList);
		a.assertNotEquals(log8.size(), log7.size(), "Log not generated on adding multiChoice answer:");
		Reporter.log("Log generated on adding multiChoice answer:", true);
		for (int i = 0; i < log8.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log8.get(i).getText(),true);
		}
		// Issue log on removing multiChoice answers
		AjaxLibrary.jsClick(driver, Q1desc);
		GenericLibrary.click(driver, removeAnsBtn);
		AjaxLibrary.checkAlert_Accept(driver);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log9 = driver.findElements(logList);
		a.assertNotEquals(log9.size(), log8.size(), "Log not generated on removing multiChoice answer:");
		Reporter.log("Log generated on removing multiChoice answer:", true);
		for (int i = 0; i < log9.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log9.get(i).getText(),true);
		}
		// Issue log on adding number integer
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.click(driver, numberBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		GenericLibrary.click(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log10 = driver.findElements(logList);
		a.assertNotEquals(log10.size(), log9.size(), "Log not generated on adding number integer:");
		Reporter.log("Log generated on adding number integer:", true);
		for (int i = 0; i < log10.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log10.get(i).getText(),true);
		}
		// Issue log on changing integer to float
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, floatOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log11 = driver.findElements(logList);
		a.assertNotEquals(log11.size(), log10.size(), "Log not generated on changing integer to float:");
		Reporter.log("Log generated on changing integer to float:", true);
		for (int i = 0; i < log11.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log11.get(i).getText(),true);
		}
		// Issue log on changing float to percentage
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, percentageOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log12 = driver.findElements(logList);
		a.assertNotEquals(log12.size(), log11.size(), "Log not generated on changing float to percentage:");
		Reporter.log("Log generated on changing float to percentage:", true);
		for (int i = 0; i < log12.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log12.get(i).getText(),true);
		}
		// Issue log on changing percentage to currency
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, currencyOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log13 = driver.findElements(logList);
		a.assertNotEquals(log13.size(), log12.size(), "Log not generated on on changing percentage to currency:");
		Reporter.log("Log generated on on changing percentage to currency:", true);
		for (int i = 0; i < log13.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log13.get(i).getText(),true);
		}
		// Issue log on changing currency to slider
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, sliderOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log14 = driver.findElements(logList);
		a.assertNotEquals(log14.size(), log13.size(), "Log not generated on changing currency to slider:");
		Reporter.log("Log generated on changing currency to slider:", true);
		for (int i = 0; i < log14.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log14.get(i).getText(),true);
		}
		// Issue log on changing slider values
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsType(driver, sliderMinValue, "1");
		AjaxLibrary.jsType(driver, sliderMaxValue, "10");
		AjaxLibrary.jsType(driver, sliderStepValue, "1");
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log15 = driver.findElements(logList);
		a.assertNotEquals(log15.size(), log14.size(), "Log not generated on changing currency to slider:");
		Reporter.log("Log generated on changing currency to slider:", true);
		for (int i = 0; i < log15.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log15.get(i).getText(),true);
		}
		// Issue log on adding Table subfield
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, tableOption);
		AjaxLibrary.jsClick(driver, addSubFieldBtn);
		AjaxLibrary.clickClearAndType(driver, tableHeaderTxtBox, tableHeaderTxtBox, tHeader);
		AjaxLibrary.jsType(driver, tableDescriptionTxtBox, tDesc);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log16 = driver.findElements(logList);
		a.assertNotEquals(log16.size(), log15.size(), "Log not generated on Adding table subfield:");
		Reporter.log("Log generated on Adding table subfield:", true);
		for (int i = 0; i < log16.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log16.get(i).getText(),true);
		}
		// Issue log on changing Table type/header/desc
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.clickClearAndType(driver, tableHeaderTxtBox, tableHeaderTxtBox, "New "+tHeader);
		AjaxLibrary.jsType(driver, tableDescriptionTxtBox, "New "+tDesc);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log17 = driver.findElements(logList);
		a.assertNotEquals(log17.size(), log16.size(), "Log not generated on changing table subfield:");
		Reporter.log("Log generated on changing table subfield:", true);
		for (int i = 0; i < log17.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log17.get(i).getText(),true);
		}
		// Issue log on deleting Table subfield
		AjaxLibrary.jsClick(driver, Q1desc);
		GenericLibrary.click(driver, removeSubFieldBtn);
		AjaxLibrary.checkAlert_Accept(driver);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log18 = driver.findElements(logList);
		a.assertNotEquals(log18.size(), log17.size(), "Log not generated on deleting table subfield:");
		Reporter.log("Log generated on deleting table subfield:", true);
		for (int i = 0; i < log18.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log18.get(i).getText(),true);
		}
		// Issue log on Adding Property question
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, propertyOption);
		AjaxLibrary.selectElementByVisibleText(driver, propertyDropDown, propOpt);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log19 = driver.findElements(logList);
		a.assertNotEquals(log19.size(), log18.size(), "Log not generated on adding property question:");
		Reporter.log("Log generated on adding property question:", true);
		for (int i = 0; i < log19.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log19.get(i).getText(),true);
		}
		
		
		
		
		
		// Issue log on changing source & format
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, propertyOption);
		ActionUtils.ajaxJsClick(driver, propertyDropDown);
		ActionUtils.selectElementByVisibleText(driver, propertyDropDown, "Date Property");
		ActionUtils.ajaxJsClick(driver, propertySourceDD);
		ActionUtils.selectElementByVisibleText(driver, propertySourceDD, "Last Modified Date");
		AjaxLibrary.selectElementByVisibleText(driver, propertyFormatDD, formatOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log20 = driver.findElements(logList);
		a.assertNotEquals(log20.size(), log19.size(), "Log not generated on changing property source & format:");
		Reporter.log("Log generated on changing property source & format:", true);
		for (int i = 0; i < log20.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log20.get(i).getText(),true);
		}
		// Issue log on adding sub fields of wizard table
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, wizardBtn);
		AjaxLibrary.jsType(driver, noOfSubQuestionsTxtBox, noOfSubQ.replace(".0", ""));
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log21 = driver.findElements(logList);
		a.assertNotEquals(log21.size(), log20.size(), "Log not generated on adding sub fields of wizard:");
		Reporter.log("Log generated on adding sub fields of wizard:", true);
		for (int i = 0; i < log21.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log21.get(i).getText(),true);
		}
		// Issue log on changing sub-field design type of wizard
		AjaxLibrary.jsClick(driver, wizard_Question1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log22 = driver.findElements(logList);
		a.assertNotEquals(log22.size(), log21.size(), "Log not generated on changing sub-field design type of wizard:");
		Reporter.log("Log generated on changing sub-field design type of wizard:", true);
		for (int i = 0; i < log22.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log22.get(i).getText(),true);
		}
		// Issue log on deleting sub-field design type of wizard
		AjaxLibrary.jsClick(driver, wizard_Question1);
		GenericLibrary.click(driver, removeFieldBtn);
		AjaxLibrary.checkAlert_Accept(driver);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log23 = driver.findElements(logList);
		a.assertNotEquals(log23.size(), log22.size(), "Log not generated on deleting sub-field design type of wizard:");
		Reporter.log("Log generated on deleting sub-field design type of wizard:", true);
		for (int i = 0; i < log23.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log23.get(i).getText(),true);
		}
		// Issue log on publish the questionnaire
		JavascriptLibrary.javascriptClickElement(driver, publishUpIssueBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, OkBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log24 = driver.findElements(logList);
		a.assertNotEquals(log24.size(), log23.size(), "Log not generated on publish the questionnaire:");
		Reporter.log("Log generated on publish the questionnaire:", true);
		for (int i = 0; i < log24.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log24.get(i).getText(),true);
		}
		// Issue log on uploading template
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, settingsBtn);
		Thread.sleep(1000);
		AjaxLibrary.uploadFile(driver, uploadTemplate, filePath);
		Thread.sleep(1000);
		AjaxLibrary.jsClick(driver, backFromQuestionnaire);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log25 = driver.findElements(logList);
		a.assertNotEquals(log25.size(), log24.size(), "Log not generated on uploading template:");
		Reporter.log("Log generated on uploading template:", true);
		for (int i = 0; i < log25.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log25.get(i).getText(),true);
		}
		// Issue log on changing from wizard to multichoice 
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log26 = driver.findElements(logList);
		a.assertNotEquals(log26.size(), log25.size(), "Log not generated on changing from wizard to multichoice:");
		Reporter.log("Log generated on changing from wizard to multichoice:", true);
		for (int i = 0; i < log26.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log26.get(i).getText(),true);
		}
		// No issue log on changing radio to dropdown
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, dropDownOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log27 = driver.findElements(logList);
		a.assertEquals(log27.size(), log26.size(), "Log generated on changing radio to dropdown:");
		Reporter.log("Log not generated on changing radio to dropdown", true);
		for (int i = 0; i < log27.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log27.get(i).getText(),true);
		}
		// No issue log on changing dropdown to radio 
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsClick(driver, radioOption);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log28 = driver.findElements(logList);
		a.assertEquals(log28.size(), log27.size(), "Log generated on changing dropdown to radio:");
		Reporter.log("Log not generated on changing dropdown to radio", true);
		for (int i = 0; i < log28.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log28.get(i).getText(),true);
		}

		a.assertAll();
	}

	public void verify_Up_issue_log_visibility_for_edit_user(String QuestionnaireName, String Q1, String user, String option) throws Exception {
		SoftAssert a = new SoftAssert();
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Log on Up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, upIssueBtn);
		AjaxLibrary.jsClick(driver, acceptUpIssueBtn);
		// Issue log on Version change/up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log1 = driver.findElements(logList);
		a.assertEquals(log1.size(), 1, "Log not generated on up issue:");
		Reporter.log("Log generated on up issue:", true);
		for (int i = 0; i < log1.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log1.get(i).getText(),true);
		}
		// Issue log on adding question 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log2 = driver.findElements(logList);
		a.assertNotEquals(log2.size(), log1.size(), "Log not generated on adding question:");
		Reporter.log("Log generated on adding question:", true);
		for (int i = 0; i < log2.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log2.get(i).getText(),true);
		}
		// Add user & give edit 
 
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, settingsBtn);
		searchBox.sendKeys(user);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath("(//span[text()='"+user+"']//following::span[1])[2]")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[text()='"+user+"']//following::span[1])[2]")));
		GenericLibrary.waitForAjax(driver);
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
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		// Open Questionnaire and verify issue log 
		searchBox.sendKeys(QuestionnaireName);
		AjaxLibrary.jsClick(driver, searchBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//h3[@title='"+QuestionnaireName+"']")));
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log3 = driver.findElements(logList);
		a.assertEquals(log3.size(), log2.size(), "Issue log not visible for edit user");
		Reporter.log("Issue log visible for edit user", true);
		for (int i = 0; i < log3.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log3.get(i).getText(),true);
		}

		a.assertAll();
	}

	public void verify_Up_issue_log_on_changing_no_of_questions_on_wizard_table(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String noOfSubQ, String noOfSubQ2) throws Exception {
		SoftAssert a = new SoftAssert();
		try {
			AjaxLibrary.jsClick(driver, folderBackBtn);
			Thread.sleep(1000);
			AjaxLibrary.jsClick(driver, folderBackBtn);
			WebElement mfolder = driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']"));
			AjaxLibrary.click(driver, mfolder);
			WebElement sfolder = driver.findElement(By.xpath("//h3[text()='"+subFolder+"']"));
			AjaxLibrary.click(driver, sfolder);
		} catch (NoSuchElementException | TimeoutException e) {
			WebElement mfolder = driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']"));
			AjaxLibrary.click(driver, mfolder);
			WebElement sfolder = driver.findElement(By.xpath("//h3[text()='"+subFolder+"']"));
			AjaxLibrary.click(driver, sfolder);
		}
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Log on Up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, upIssueBtn);
		AjaxLibrary.jsClick(driver, acceptUpIssueBtn);
		// Issue log on Version change/up issue
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		List<WebElement> log1 = driver.findElements(logList);
		a.assertEquals(log1.size(), 1, "Log not generated on up issue:");
		Reporter.log("Log generated on up issue:", true);
		for (int i = 0; i < log1.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log1.get(i).getText(),true);
		}
		// Issue log on adding wizard questions 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, wizardBtn);
		AjaxLibrary.jsType(driver, noOfSubQuestionsTxtBox, noOfSubQ.replace(".0", ""));
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log2 = driver.findElements(logList);
		a.assertNotEquals(log2.size(), log1.size(), "Log not generated on adding sub fields of wizard:");
		Reporter.log("Log generated on adding sub fields of wizard:", true);
		for (int i = 0; i < log2.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log2.get(i).getText(),true);
		}
		// Issue log on changing no.of questions
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsType(driver, noOfSubQuestionsTxtBox, noOfSubQ2.replace(".0", ""));
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, issueLogBtn);
		a.assertTrue(issueLogHeader.isDisplayed(), "Issue log window not opened");
		Reporter.log("Issue log window opened", true);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			AjaxLibrary.scrollIntoView(driver, lastElementInLogList);
		}
		List<WebElement> log3 = driver.findElements(logList);
		a.assertNotEquals(log3.size(), log2.size(), "Log not generated on changing no.of sub fields of wizard:");
		Reporter.log("Log generated on changing no.of sub fields of wizard:", true);
		for (int i = 0; i < log3.size(); i++) {
			Reporter.log("Log"+(i+1)+": "+log3.get(i).getText(),true);
		}
		
		a.assertAll();
	}
	
	public void verify_Warning_alert_on_adding_less_number_of_wizard_questions_than_existing(String mainFolder, String subFolder, String QuestionnaireName, 
			String Q1, String noOfSubQ, String noOfSubQ2, String expMsg) throws Exception {
		try {
			AjaxLibrary.jsClick(driver, folderBackBtn);
			Thread.sleep(1000);
			AjaxLibrary.jsClick(driver, folderBackBtn);
			WebElement mfolder = driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']"));
			AjaxLibrary.click(driver, mfolder);
			WebElement sfolder = driver.findElement(By.xpath("//h3[text()='"+subFolder+"']"));
			AjaxLibrary.click(driver, sfolder);
		} catch (NoSuchElementException | TimeoutException e) {
			WebElement mfolder = driver.findElement(By.xpath("//h3[text()='"+mainFolder+"']"));
			AjaxLibrary.click(driver, mfolder);
			WebElement sfolder = driver.findElement(By.xpath("//h3[text()='"+subFolder+"']"));
			AjaxLibrary.click(driver, sfolder);
		}
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Issue log on adding wizard questions 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, Q1);
		AjaxLibrary.jsClick(driver, advancedBtn);
		AjaxLibrary.jsClick(driver, wizardBtn);
		AjaxLibrary.jsType(driver, noOfSubQuestionsTxtBox, noOfSubQ.replace(".0", ""));
		// Warning alert on adding less no.of questions
		AjaxLibrary.jsClick(driver, Q1desc);
		AjaxLibrary.jsType(driver, noOfSubQuestionsTxtBox, noOfSubQ2.replace(".0", ""));
		Thread.sleep(1000);
		Assert.assertEquals(wizardQuestionWarningMsg.getText(), expMsg, "Warning alert not present on adding less no.of wizard questions");
		Reporter.log("Warning alert present on adding less no.of wizard questions", true);
		// Close Warning alert
		AjaxLibrary.jsClick(driver, okBtn_wizardWarningMsg);
		Thread.sleep(1000);
		try {
			Assert.assertTrue(okBtn_wizardWarningMsg.isDisplayed());
			Assert.fail("Warning alert not closed on clicking ok button");
		} catch (NoSuchElementException e) {
			Reporter.log("Warning alert closed on clicking ok button", true);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//---------------------- Folder Permissions (Start)---------------------------
	public void Create_setup_for_folder_permissions(String F1Name, String F1Desc, String F2Name, String F2Desc, String F3Name, String F3Desc,
			String QName, String QDesc, String user, String option) throws Exception {
		// Creating folder, nested folders and a Questionnaire
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, AddFolderBtn);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, F1Name);
		JavascriptLibrary.javascriptType(driver, descTxt, F1Desc);
		JavascriptLibrary.javascriptClickElement(driver, folderSaveBtn);
		try {
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
		}
		GenericLibrary.waitForElementVisibility(driver, AddFolderBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddFolderBtn);
		GenericLibrary.waitForElementVisibility(driver, folderNameTextBox);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, F2Name);
		JavascriptLibrary.javascriptType(driver, descTxt, F2Desc);
		JavascriptLibrary.javascriptClickElement(driver, folderSaveBtn);
		GenericLibrary.waitForElementVisibility(driver, folder2);

		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		Thread.sleep(1000);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);

		GenericLibrary.waitForElementVisibility(driver, AddFolderBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddFolderBtn);
		GenericLibrary.waitForElementVisibility(driver, folderNameTextBox);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, F3Name);
		JavascriptLibrary.javascriptType(driver, descTxt, F3Desc);
		JavascriptLibrary.javascriptClickElement(driver, folderSaveBtn);
		GenericLibrary.waitForElementVisibility(driver, folder3);
		JavascriptLibrary.javascriptClickElement(driver, backFromFolders);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		GenericLibrary.waitForElementVisibility(driver, AddBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		GenericLibrary.waitForElementVisibility(driver, nameTxtBox);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, QName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForElementVisibility(driver, newItemBtn);
		JavascriptLibrary.javascriptClickElement(driver, newItemBtn);
		GenericLibrary.waitForElementVisibility(driver, descriptionTextBox);
		JavascriptLibrary.javascriptType(driver, descriptionTextBox, QDesc);
		descriptionTextBox.sendKeys(Keys.TAB);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, backFromQuestionnaire);
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		// Adding user to Folders
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		searchBox.sendKeys(user);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath(".//*[contains(@id,'UserAdd')]")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath(".//*[contains(@id,'UserAdd')]")));
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
	}

	public void verify_set_the_folder_permission_to_VIEW_folders(String option, String user) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		// Adding user to Folders
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
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
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		boolean status = AddBtn.isDisplayed();
		if (status == true) {
			Reporter.log("Add Button Found & User can add datasets and Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		} else {
			Reporter.log("Add Button Not Found & User cann't create datasets and cann't create new Questionnaires inside the folder: TEST PASS",true);
		}
	}

	public void verify_set_the_folder_permission_to_DO_folders(String option, String user) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		// Adding user to Folders
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
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
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		try {
			GenericLibrary.waitForElementVisibility(driver, AddBtn);
			Assert.assertTrue(AddBtn.isDisplayed());
			Reporter.log("Add Button Found & User can add datasets, Questionnaires inside the folder & can give permission to other user: TEST PASS",true);
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Add Button Not Found & User cann't create datasets and cann't create new Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		}
		try {
			Assert.assertTrue(TestQuestionnaire.isDisplayed());
			Reporter.log("DO level user can see Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("DO level user can't see Questionnaires inside the folder: TEST PASS",true);
		}
	}

	public void verify_set_the_folder_permission_to_MODERATOR_folders(String option, String user) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		// Adding user to Folders
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
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
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		try {
			GenericLibrary.waitForElementVisibility(driver, AddBtn);
			Assert.assertTrue(AddBtn.isDisplayed());
			Reporter.log("Add Button Found & User can add datasets, Questionnaires inside the folder & can give permission to other user: TEST PASS",true);
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Add Button Not Found & User cann't create datasets and cann't create new Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		}
		try {
			Assert.assertTrue(TestQuestionnaire.isDisplayed());
			Reporter.log("Moderator can see Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Moderator can't see Questionnaires inside the folder: TEST PASS",true);
		}
	}

	public void verify_set_DO_permission_to_subfolder(String option, String user2) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		// Adding user to Folders
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				Thread.sleep(1000);
				GenericLibrary.waitForElementVisibility(driver, folder2);
				JavascriptLibrary.javascriptClickElement(driver, folder2);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				GenericLibrary.waitForElementVisibility(driver, folder2);
				JavascriptLibrary.javascriptClickElement(driver, folder2);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			GenericLibrary.waitForElementVisibility(driver, folder2);
			JavascriptLibrary.javascriptClickElement(driver, folder2);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		searchBox.sendKeys(user2);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath("(//span[text()='"+user2+"']//following::span[1])[2]")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[text()='"+user2+"']//following::span[1])[2]")));
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user2+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
		// Login as Test User
		AjaxLibrary.jsClick(driver, currentUserAcc);
		AjaxLibrary.jsClick(driver, myAccountLink);
		AjaxLibrary.jsClick(driver, LoginAsBtn);
		logInEmailTextBox.sendKeys(user2);
		GenericLibrary.waitForAjax(driver);
		WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user2+"']"));
		AjaxLibrary.jsClick(driver, newLoginAcc);
		AjaxLibrary.jsClick(driver, reLogInBtn);
		//AjaxLibrary.jsClick(driver, viosMenu);
		AjaxLibrary.jsClick(driver, LoginPage.menuBtn);
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		try {
			Assert.assertTrue(folder3.isDisplayed());
			Reporter.log("Co-folder at sub-folder is displaying with sub-folder permission as 'DO' : TEST FAIL",true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Co-folder at sub-folder level is hidden: TEST PASS",true);
		}
		GenericLibrary.waitForElementVisibility(driver, folder2);
		JavascriptLibrary.javascriptClickElement(driver, folder2);
		try {
			GenericLibrary.waitForElementVisibility(driver, AddBtn);
			Assert.assertTrue(AddBtn.isDisplayed());
			Reporter.log("Add Button Found & User can add datasets, Questionnaires inside the folder & can give permission to other user: TEST PASS",true);
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Add Button Not Found & User cann't create datasets and cann't create new Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		}
		try {
			Assert.assertTrue(TestQuestionnaire.isDisplayed());
			Reporter.log("Moderator can see Questionnaires inside the folder: TEST FAIL",true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Moderator can't see Questionnaires inside the folder: TEST PASS",true);
		}
	}

	public void set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_subfolders(String user, String option) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);

		GenericLibrary.waitForElementVisibility(driver, folder2);
		JavascriptLibrary.javascriptClickElement(driver, folder2);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		WebElement lockSymbol = driver.findElement(By.xpath("//span[text()='"+user+"']//following::i[1]"));
		GenericLibrary.scrollIntoView(driver, lockSymbol);
		Assert.assertTrue(lockSymbol.isDisplayed(), "Main folder settings not applied to sub-folders");
	}

	public void set_main_folder_permission_to_VIEW_and_verify_the_same_applied_to_newly_added_subfolders(String user, String option, String F4Name, String F4Desc) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
		// Creating new sub folder and checking the permission 
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		GenericLibrary.waitForElementVisibility(driver, AddFolderBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddFolderBtn);
		GenericLibrary.waitForElementVisibility(driver, folderNameTextBox);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, F4Name);
		JavascriptLibrary.javascriptType(driver, descTxt, F4Desc);
		JavascriptLibrary.javascriptClickElement(driver, folderSaveBtn);
		GenericLibrary.waitForElementVisibility(driver, folder4);
		JavascriptLibrary.javascriptClickElement(driver, folder4);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement lockSymbol = driver.findElement(By.xpath("//span[text()='"+user+"']//following::i[1]"));
		GenericLibrary.scrollIntoView(driver, lockSymbol);
		Assert.assertTrue(lockSymbol.isDisplayed(), "Mail folder settings not applied to sub-folders");
	}

	public void verify_Set_different_permission_to_locked_folder_and_reset_the_permissions_to_older(String user, String option) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				GenericLibrary.waitForElementVisibility(driver, folder4);
				JavascriptLibrary.javascriptClickElement(driver, folder4);
				Thread.sleep(1000);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				GenericLibrary.waitForElementVisibility(driver, folder4);
				JavascriptLibrary.javascriptClickElement(driver, folder4);
				Thread.sleep(1000);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			GenericLibrary.waitForElementVisibility(driver, folder4);
			JavascriptLibrary.javascriptClickElement(driver, folder4);
			Thread.sleep(1000);
		}
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);

		WebElement deleteSymbol = driver.findElement(By.xpath("//span[text()='"+user+"']//following::i[1]"));
		GenericLibrary.scrollIntoView(driver, deleteSymbol);
		Assert.assertTrue(deleteSymbol.isDisplayed(), "New permissions not applied");
		Reporter.log("Delete user button is visible on changing the permissions to locked folder", true);
		JavascriptLibrary.javascriptClickElement(driver, deleteSymbol);
		GenericLibrary.waitForElementVisibility(driver, YesBtn);
		JavascriptLibrary.javascriptClickElement(driver, YesBtn);
		WebElement lockSymbol = driver.findElement(By.xpath("//span[text()='"+user+"']//following::i[1]"));
		GenericLibrary.scrollIntoView(driver, lockSymbol);
		Assert.assertTrue(lockSymbol.isDisplayed(), "Resetting perminsions Not Done");
	}

	public void verify_Set_main_folder_permission_to_VIEW_and_Set_sub_folder_permission_to_DO(String user, String option1, String option2) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option1);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
		// Folder 2 setup
		GenericLibrary.waitForElementVisibility(driver, folder2);
		JavascriptLibrary.javascriptClickElement(driver, folder2);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown2 = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown2);
		GenericLibrary.selectElementByVisibleText(userDropDown2, option2);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
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
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		try {
			Assert.assertTrue(folder2.isDisplayed());
			Reporter.log("Sub-folders are visible on settings Main folder to 'VIEW' and sub-folder to 'DO': TEST PASS",true);
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Settings not reflceted and Sub-folders are not visible: TEST FAIL",true);
			Assert.fail();
		}
		try {
			Assert.assertTrue(AddBtn.isDisplayed());
			Reporter.log("Add Button Found & User can add datasets inside the Main folder: TEST FAIL",true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("User not allowed to craete datasets inside the main folder: TEST PASS",true);
		}
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, folder2);
		Thread.sleep(1000);
		try {
			Assert.assertTrue(AddBtn.isDisplayed());
			Reporter.log("Add Button found & User can create datasets inside the sub-folder: TEST PASS",true);
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Add Button Not Found & User cann't create datasets inside the sub-folder: TEST FAIL",true);
			Assert.fail();
		}
	}

	public void verify_Set_main_folder_to_VIEW_and_Set_sub_folder_to_DO_Delete_main_folder_permision_and_check_subfolder_permision_status(String user, String option1, String option2) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option1);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
		// Folder2 Setup
		GenericLibrary.waitForElementVisibility(driver, folder2);
		JavascriptLibrary.javascriptClickElement(driver, folder2);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown2 = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown2);
		GenericLibrary.selectElementByVisibleText(userDropDown2, option2);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
		// Verification
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement deleteSymbol = driver.findElement(By.xpath("//span[text()='"+user+"']//following::i[1]"));
		GenericLibrary.scrollIntoView(driver, deleteSymbol);
		JavascriptLibrary.javascriptClickElement(driver, deleteSymbol);
		GenericLibrary.waitForElementVisibility(driver, YesBtn);
		JavascriptLibrary.javascriptClickElement(driver, YesBtn);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);

		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		Thread.sleep(1000);
		GenericLibrary.waitForElementVisibility(driver, folder2);
		JavascriptLibrary.javascriptClickElement(driver, folder2);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown3 = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown3);
		Select sel = new Select(userDropDown3); 
		WebElement option = sel.getFirstSelectedOption();
		String text = option.getText();
		Reporter.log("Last selected option for Sub folder is: "+text, true);
		Assert.assertEquals(text, "Do", "Option changed on deleting main folder permision");
	}

	public void verify_Set_DENY_permission_to_folder(String user, String F5Name, String F5Desc, String option) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
		}
		GenericLibrary.waitForElementVisibility(driver, AddFolderBtn);
		JavascriptLibrary.javascriptClickElement(driver, AddFolderBtn);
		GenericLibrary.waitForElementVisibility(driver, folderNameTextBox);
		JavascriptLibrary.javascriptType(driver, folderNameTextBox, F5Name);
		JavascriptLibrary.javascriptType(driver, descTxt, F5Desc);
		JavascriptLibrary.javascriptClickElement(driver, folderSaveBtn);
		GenericLibrary.waitForElementVisibility(driver, folder5);
		JavascriptLibrary.javascriptClickElement(driver, folder5);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, editBtn);
		GenericLibrary.waitForAjax(driver);
		searchBox.sendKeys(user);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		AjaxLibrary.click(driver, userAddBtn);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Thread.sleep(1000);
		JavascriptLibrary.javascriptClickElement(driver, closeFolderEditPage);
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
		AjaxLibrary.jsClick(driver, Newiqapture);
		AjaxLibrary.jsClick(driver, buildLink);
		GenericLibrary.waitForElementVisibility(driver, folder1);
		JavascriptLibrary.javascriptClickElement(driver, folder1);
		try {
			Assert.assertTrue(folder5.isDisplayed());
			Reporter.log("Denyed folder found & Settings not reflected: TEST FAIL",true);
			Assert.fail();
		} catch (NoSuchElementException | AssertionError e) {
			Reporter.log("Denyed folder is Not found: TEST PASS",true);
		}
	}

	public void verify_Add_all_users_from_the_company_change_permissions_and_removing_users_from_company(String user, String option) throws Exception {
		GenericLibrary.waitForElementVisibility(driver, folderBtn);
		JavascriptLibrary.javascriptClickElement(driver, folderBtn);
		try {
			if (folder1.getAttribute("class").contains("selected")) {
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			} else {
				GenericLibrary.waitForElementVisibility(driver, folder1);
				JavascriptLibrary.javascriptClickElement(driver, folder1);
				Thread.sleep(1000);
				JavascriptLibrary.javascriptClickElement(driver, editBtn);
			}
		} catch (NoSuchElementException | TimeoutException e1) {
			GenericLibrary.waitForElementVisibility(driver, RightArrow);
			JavascriptLibrary.javascriptClickElement(driver, RightArrow);
			GenericLibrary.waitForElementVisibility(driver, folder1);
			JavascriptLibrary.javascriptClickElement(driver, folder1);
			Thread.sleep(1000);
			JavascriptLibrary.javascriptClickElement(driver, editBtn);
		}
		GenericLibrary.waitForAjax(driver);
		searchBox.sendKeys(user);
		JavascriptLibrary.javascriptClickElement(driver, searchBtn);
		GenericLibrary.waitForElementVisibility(driver, driver.findElement(By.xpath("(//span[contains(.,'"+user+"')])[2]/following::span[1]")));
		JavascriptLibrary.javascriptClickElement(driver, driver.findElement(By.xpath("(//span[contains(.,'"+user+"')])[2]/following::span[1]")));
		GenericLibrary.waitForAjax(driver);
		WebElement userDropDown = driver.findElement(By.xpath("//span[text()='"+user+"']//following::select[1]"));
		GenericLibrary.scrollIntoView(driver, userDropDown);
		Assert.assertTrue(userDropDown.isDisplayed(), "Company Not Added");
		Reporter.log("Company with all users Added successfully", true);
		GenericLibrary.selectElementByVisibleText(userDropDown, option);
		Reporter.log("Permissions changed to all users in the company successfully", true);
		Thread.sleep(1000);
		WebElement deleteSymbol = driver.findElement(By.xpath("//span[text()='"+user+"']//following::i[1]"));
		GenericLibrary.scrollIntoView(driver, deleteSymbol);
		JavascriptLibrary.javascriptClickElement(driver, deleteSymbol);
		GenericLibrary.waitForElementVisibility(driver, YesBtn);
		JavascriptLibrary.javascriptClickElement(driver, YesBtn);
		Thread.sleep(1000);
		GenericLibrary.waitForElementVisibility(driver, YesBtn);
		JavascriptLibrary.javascriptClickElement(driver, YesBtn);
		GenericLibrary.waitForAjax(driver);
		Reporter.log("Company deleted successfully", true);
	}

	//--------------------------- Folder permissions (End)-----------------------------------

	public void verify_Create_Questionnaire_for_Analyse(String QuestionnaireName, String empPersonnelDetails,
			String empNo, String empName, String empAddress, String city1, String city2, String city3, String city4, String city5, String city6, String city7, String city8, 
			String empFee, String empfFee, String empFormFee, String empRegFee, String empPercentage, String ssc, String inter, String graduate, String masters, String education,
			String completedEducation, String ssc2, String inter2, String graduate2, String masters2, String empJoiningAndExitDate, String joiningDate, String exitDate, String reasonToExit,
			String companyEnvironment, String bad, String good, String veryGood, String excellent, String salaryIncrement, String siBad, String siBetter, String siDissatisfied, String siSatisfied,
			String overall, String ovBad, String ovBetter, String ovDissatisfied, String ovSatisfied, String dropDown, String q1, String q2, String checkBox, 
			String cbQ1, String cbq1Bad, String cbq1Disagree, String cbq1Dissatisfied, String cbq1Agree, String cbq1Satisfied, String cbq1Good, 
			String cbQ2, String cbq2Bad, String cbq2Disagree, String cbq2Dissatisfied, String cbq2Agree, String cbq2Satisfied, String cbq2Good) throws Exception {
		AjaxLibrary.jsClick(driver, folderBackBtn);
		Thread.sleep(1000);
		AjaxLibrary.jsClick(driver, folderBackBtn);
		AjaxLibrary.jsClick(driver, AddBtn);
		AjaxLibrary.jsType(driver, nameTxtBox, QuestionnaireName);
		AjaxLibrary.jsClick(driver, saveBtn);
		// Emp personnel details 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empPersonnelDetails);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Emp no.
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empNo);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, integerOption);
		// Emp name
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empName);
		AjaxLibrary.jsClick(driver, textOption);
		// Emp address
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empAddress);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		for(int i = 0 ; i < 8 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> ansTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, ansTextBoxes.get(0), city1);
		WebElement a1 = ansTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, a1);
		AjaxLibrary.jsType(driver, a1, city2);
		WebElement a2 = ansTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, a2);
		AjaxLibrary.jsType(driver, a2, city3);
		WebElement a3 = ansTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, a3);
		AjaxLibrary.jsType(driver, a3, city4);
		WebElement a4 = ansTextBoxes.get(4);
		GenericLibrary.scrollIntoView(driver, a4);
		AjaxLibrary.jsType(driver, a4, city5);
		WebElement a5 = ansTextBoxes.get(5);
		GenericLibrary.scrollIntoView(driver, a5);
		AjaxLibrary.jsType(driver, a5, city6);
		WebElement a6 = ansTextBoxes.get(6);
		GenericLibrary.scrollIntoView(driver, a6);
		AjaxLibrary.jsType(driver, a6, city7);
		WebElement a7 = ansTextBoxes.get(7);
		GenericLibrary.scrollIntoView(driver, a7);
		AjaxLibrary.jsType(driver, a7, city8);
		// Emp fee
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empFee);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Emp fee
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empfFee);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, floatOption);
		// Emp form fee
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empFormFee);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, currencyOption);
		// Emp Registration fee
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empRegFee);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, floatOption);
		// Emp Percentage
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empPercentage);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// SSC
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, ssc);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, percentageOption);
		// Intermediate
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, inter);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, percentageOption);
		// Graduate
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, graduate);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, percentageOption);
		// Masters
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, masters);
		AjaxLibrary.jsClick(driver, numberBtn);
		AjaxLibrary.jsClick(driver, percentageOption);
		// Education
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, education);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Completed Education
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, completedEducation);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		for(int i = 0 ; i < 4 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> eduAnsTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, eduAnsTextBoxes.get(0), ssc2);
		WebElement e1 = eduAnsTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, e1);
		AjaxLibrary.jsType(driver, e1, inter2);
		WebElement e2 = eduAnsTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, e2);
		AjaxLibrary.jsType(driver, e2, graduate2);
		WebElement e3 = eduAnsTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, e3);
		AjaxLibrary.jsType(driver, e3, masters2);
		// Emp Joining & Exit Date
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, empJoiningAndExitDate);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Joining Date
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, joiningDate);
		AjaxLibrary.jsClick(driver, dateBtn);
		// Exit Date
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, exitDate);
		AjaxLibrary.jsClick(driver, dateBtn);
		// Reason to Exit
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, reasonToExit);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Company Environment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, companyEnvironment);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		for(int i = 0 ; i < 4 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> envAnsTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, envAnsTextBoxes.get(0), bad);
		WebElement env1 = envAnsTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, env1);
		AjaxLibrary.jsType(driver, env1, good);
		WebElement env2 = envAnsTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, env2);
		AjaxLibrary.jsType(driver, env2, veryGood);
		WebElement env3 = envAnsTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, env3);
		AjaxLibrary.jsType(driver, env3, excellent);
		// Salary Increment
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, salaryIncrement);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		for(int i = 0 ; i < 4 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> incAnsTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, incAnsTextBoxes.get(0), siBad);
		WebElement inc1 = incAnsTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, inc1);
		AjaxLibrary.jsType(driver, inc1, siBetter);
		WebElement inc2 = incAnsTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, inc2);
		AjaxLibrary.jsType(driver, inc2, siDissatisfied);
		WebElement inc3 = incAnsTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, inc3);
		AjaxLibrary.jsType(driver, inc3, siSatisfied);
		// Overall
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, overall);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		for(int i = 0 ; i < 4 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> ovlAnsTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, ovlAnsTextBoxes.get(0), ovBad);
		WebElement ovl1 = ovlAnsTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, ovl1);
		AjaxLibrary.jsType(driver, ovl1, ovBetter);
		WebElement ovl2 = ovlAnsTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, ovl2);
		AjaxLibrary.jsType(driver, ovl2, ovDissatisfied);
		WebElement ovl3 = ovlAnsTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, ovl3);
		AjaxLibrary.jsType(driver, ovl3, ovSatisfied);
		// Drop Down 
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, dropDown);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Q1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, q1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, dropDownOption);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, highMediumLowOption);
		// Q2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, q2);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, defaultDropDown);
		AjaxLibrary.jsClick(driver, yesNoNAOption);
		// CheckBox
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, checkBox);
		AjaxLibrary.jsClick(driver, sectionBtn);
		// Q1
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, cbQ1);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		AjaxLibrary.jsClick(driver, checkBoxOption);
		for(int i = 0 ; i < 6 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> ckAnsTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, ckAnsTextBoxes.get(0), cbq1Bad);
		WebElement ck1 = ckAnsTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, ck1);
		AjaxLibrary.jsType(driver, ck1, cbq1Disagree);
		WebElement ck2 = ckAnsTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, ck2);
		AjaxLibrary.jsType(driver, ck2, cbq1Dissatisfied);
		WebElement ck3 = ckAnsTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, ck3);
		AjaxLibrary.jsType(driver, ck3, cbq1Agree);
		WebElement ck4 = ckAnsTextBoxes.get(4);
		GenericLibrary.scrollIntoView(driver, ck4);
		AjaxLibrary.jsType(driver, ck4, cbq1Satisfied);
		WebElement ck5 = ckAnsTextBoxes.get(5);
		GenericLibrary.scrollIntoView(driver, ck5);
		AjaxLibrary.jsType(driver, ck5, cbq1Good);
		// Q2
		AjaxLibrary.jsClick(driver, newItemBtn);
		AjaxLibrary.jsType(driver, descriptionTextBox, cbQ2);
		AjaxLibrary.jsClick(driver, multiChoiceBtn);
		for(int i = 0 ; i < 6 ; i++) {
			AjaxLibrary.jsClick(driver, plusSign);
		}
		List<WebElement> qrAnsTextBoxes = driver.findElements(By.xpath("//input[@placeholder='Answer']"));
		AjaxLibrary.jsType(driver, qrAnsTextBoxes.get(0), cbq2Bad);
		WebElement qr1 = qrAnsTextBoxes.get(1);
		GenericLibrary.scrollIntoView(driver, qr1);
		AjaxLibrary.jsType(driver, qr1, cbq2Disagree);
		WebElement qr2 = qrAnsTextBoxes.get(2);
		GenericLibrary.scrollIntoView(driver, qr2);
		AjaxLibrary.jsType(driver, qr2, cbq2Dissatisfied);
		WebElement qr3 = qrAnsTextBoxes.get(3);
		GenericLibrary.scrollIntoView(driver, qr3);
		AjaxLibrary.jsType(driver, qr3, cbq2Agree);
		WebElement qr4 = qrAnsTextBoxes.get(4);
		GenericLibrary.scrollIntoView(driver, qr4);
		AjaxLibrary.jsType(driver, qr4, cbq2Satisfied);
		WebElement qr5 = qrAnsTextBoxes.get(5);
		GenericLibrary.scrollIntoView(driver, qr5);
		AjaxLibrary.jsType(driver, qr5, cbq2Good);
		// Enable delete records option
		GenericLibrary.hoverWebelement(driver, moreBtn);
		AjaxLibrary.jsClick(driver, settingsBtn);
		AjaxLibrary.jsClick(driver, trashCanAction_Delete);
	}




}

