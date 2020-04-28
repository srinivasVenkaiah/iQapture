/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.GenericLibrary;
import com.util.JavascriptLibrary;

public class SettingsPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath = "//span[contains(.,'Setup')]")
	WebElement setUpText;

	// Dashboard Timescale
	@FindBy(xpath = "//select[contains(@id,'Timescale')]")
	WebElement timeScaleDD;

	@FindBy(xpath = "//span[@class='title'][contains(.,'Dashboard')]")
	WebElement dashBoardLink;

	@FindBy(xpath = "//input[contains(@id,'period')]")
	WebElement filterBtn;

	// People
	@FindBy(xpath = "//i[contains(@id,'btnActPeople')]")
	WebElement addPeopleBtn;

	@FindBy(xpath = "//input[contains(@id,'txtSearch')]")
	WebElement peopleSearchBox;

	@FindBy(xpath = "//a[contains(@id,'SearPeopleBtn')]")
	WebElement peopleSearchBtn;

	@FindBy(xpath=".//*[contains(@id,'UserAdd')]")
	WebElement AddUserBtn;

	@FindBy(xpath="//button[contains(@onclick, 'closePeopleModal')]")
	WebElement closeUserDlg;

	@FindBy(xpath = "//span[@class='title'][contains(.,'Build')]")
	WebElement buildLink;

	@FindBy(xpath=".//*[@id='btnNew']")
	WebElement AddBtn;

	@FindBy(xpath=".//*[@id='DS_NAME']")
	WebElement nameTxtBox;

	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement saveBtn;

	@FindBy(xpath=".//*[@id='btnMore']/a")
	WebElement moreBtn;

	@FindBy(xpath=".//*[@id='datasetset']/a")
	WebElement settingsBtn;

	@FindBy(xpath=".//*[@id='btnFolder']")
	WebElement folderBtn;

	// Defaults
	@FindBy(xpath="//span[contains(.,'Modern')]")
	WebElement enableClassicFolderStyleBtn;

	@FindBy(xpath="//a[@id='btnFolder']")
	WebElement foldersBtn;

	// Tool tips 
	@FindBy(xpath="//label[contains(.,'Timescale')]/..//div")
	WebElement timeScaleTooltipIcon;

	@FindBy(xpath="//label[contains(.,'People')]/..//div")
	WebElement peopleTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Folder Structure')]/..//div")
	WebElement folderStructureTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Question Type')]/..//div")
	WebElement questionTypeTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Text')]/..//div")
	WebElement textTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Date Time')]/..//div")
	WebElement dateTimeTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Number')]/..//div")
	WebElement numberTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Multi Choice')]/..//div")
	WebElement multiChoiceTooltipIcon;

	@FindBy(xpath="//label[contains(.,'Advanced')]/..//div")
	WebElement advancedTooltipIcon;












	// Actions:......................................................................................
	public void verify_Navigate_to_Settings_page() {
		Assert.assertTrue(setUpText.isDisplayed(), "Settings pagfe not opened");
	}

	public void verify_Dashboard_Time_scale_settings(String option) {
		String defOpt = GenericLibrary.getFirstSelectedOption(timeScaleDD);
		Reporter.log("Default option is: "+defOpt, true);
		Reporter.log("Given option is: "+option, true);
		GenericLibrary.selectElementByVisibleText(timeScaleDD, option);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, dashBoardLink);
		GenericLibrary.waitForAjax(driver);
		String resultOption = filterBtn.getAttribute("value");
		Reporter.log("Resultant option is: "+option, true);
		Assert.assertEquals(resultOption, option, "Time scale settings are not functional");
	}

	public void verify_Add_Default_people_or_companies_settings_and_verify_its_reflection_in_all_sections(
			String user, String qName) {
		GenericLibrary.click(driver, addPeopleBtn);
		GenericLibrary.waitForAjax(driver);
		peopleSearchBox.sendKeys(user);
		GenericLibrary.click(driver, peopleSearchBtn);
		GenericLibrary.click(driver, AddUserBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement addedUser = driver.findElement(By.xpath("(//span[contains(text(), '"+user+"')])[1]"));
		GenericLibrary.scrollIntoView(driver, addedUser);
		Assert.assertTrue(addedUser.isDisplayed(), "Unable to add default users");
		Reporter.log("Default user added in settings", true);
		// Verification
		JavascriptLibrary.javascriptClickElement(driver, closeUserDlg);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, buildLink);
		GenericLibrary.waitForAjax(driver);
		JavascriptLibrary.javascriptClickElement(driver, AddBtn);
		GenericLibrary.waitForElementVisibility(driver, nameTxtBox);
		JavascriptLibrary.javascriptType(driver, nameTxtBox, qName);
		JavascriptLibrary.javascriptClickElement(driver, saveBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.moveToElement(driver, moreBtn);
		JavascriptLibrary.javascriptClickElement(driver, settingsBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement reflectedUser = driver.findElement(By.xpath("(//span[contains(text(), '"+user+"')])[1]"));
		GenericLibrary.scrollIntoView(driver, reflectedUser);
		Assert.assertTrue(reflectedUser.isDisplayed(), "Added user or company is not reflected");
	}

	public void verify_Default_options_settings() {
		GenericLibrary.click(driver, enableClassicFolderStyleBtn);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, buildLink);
		GenericLibrary.waitForAjax(driver);
		GenericLibrary.click(driver, foldersBtn);
		GenericLibrary.waitForAjax(driver);
		WebElement treeStyle = driver.findElement(By.xpath("(//i[contains(@class,'jstree-themeicon')])[1]"));
		Assert.assertTrue(treeStyle.isDisplayed(), "Classic folder style not reflected");
		Reporter.log("Classic folder style settings reflected successfully");
	}

	public void verify_all_tooltips_in_settings_page(String timeScaleExpected, String peopleExpected,
			String folderStructureExpected, String questionTypeExpected, String textExpected, 
			String dateTimeExpected, String numberExpected, String multiChoiceExpected, String advancedExpected) throws Exception {
		SoftAssert a = new SoftAssert();
		// Time scale
		String timeScaleActual = GenericLibrary.getToolTip2(timeScaleTooltipIcon, "data-original-title");
		Reporter.log("Time scale tooltip is: "+timeScaleActual, true);
		a.assertEquals(timeScaleActual, timeScaleExpected, "Time scale tooltip not matched");
		Reporter.log("Time scale tooltip matched successfully", true);
		// People
		String peopleActual = GenericLibrary.getToolTip2(peopleTooltipIcon, "data-original-title");
		Reporter.log("People tooltip is: "+peopleActual, true);
		a.assertEquals(peopleActual, peopleExpected, "People tooltip not matched");
		Reporter.log("People tooltip matched successfully", true);
		// Folder Structure
		String folderStructureActual = GenericLibrary.getToolTip2(folderStructureTooltipIcon, "data-original-title");
		Reporter.log("Folder structure tooltip is: "+folderStructureActual, true);
		a.assertEquals(folderStructureActual, folderStructureExpected, "Folder structure tooltip not matched");
		Reporter.log("Folder structure tooltip matched successfully", true);
		// Question type
		String questionTypeActual = GenericLibrary.getToolTip2(questionTypeTooltipIcon, "data-original-title");
		Reporter.log("Question type tooltip is: "+questionTypeActual, true);
		a.assertEquals(questionTypeActual, questionTypeExpected, "Question type tooltip not matched");
		Reporter.log("Question type tooltip matched successfully", true);
		// Text 
		String textActual = GenericLibrary.getToolTip2(textTooltipIcon, "data-original-title");
		Reporter.log("Text tooltip is: "+textActual, true);
		a.assertEquals(textActual, textExpected, "Text tooltip not matched");
		Reporter.log("Text tooltip matched successfully", true);
		// Date Time
		String dateTimeActual = GenericLibrary.getToolTip2(dateTimeTooltipIcon, "data-original-title");
		Reporter.log("Date time tooltip is: "+dateTimeActual, true);
		a.assertEquals(dateTimeActual, dateTimeExpected, "Date time not matched");
		Reporter.log("Date time tooltip matched successfully", true);
		// Number
		String numberActual = GenericLibrary.getToolTip2(numberTooltipIcon, "data-original-title");
		Reporter.log("Number tooltip is: "+numberActual, true);
		a.assertEquals(numberActual, numberExpected, "Number not matched");
		Reporter.log("Number tooltip matched successfully", true);
		// MultiChoice
		String multiChoiceActual = GenericLibrary.getToolTip2(multiChoiceTooltipIcon, "data-original-title");
		Reporter.log("MultiChoice tooltip is: "+multiChoiceActual, true);
		a.assertEquals(multiChoiceActual, multiChoiceExpected, "MultiChoice not matched");
		Reporter.log("MultiChoice tooltip matched successfully", true);
		// Advanced
		String advancedActual = GenericLibrary.getToolTip2(advancedTooltipIcon, "data-original-title");
		Reporter.log("Advanced tooltip is: "+advancedActual, true);
		a.assertEquals(advancedActual, advancedExpected, "Advanced not matched");
		Reporter.log("Advanced tooltip matched successfully", true);
		a.assertAll();
	}









}
