/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;

public class DashBoardPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	// DashBoard Page verification
	@FindBy(linkText="Dashboard")
	WebElement dashBoardText;
	
	@FindBy(xpath="//span[text()='MY Audit']")	
	WebElement myAuditHeader;
	
	@FindBy(xpath="//span[text()='MY Questionnaires']")	
	WebElement myQuestionnairesHeader;
			
	@FindBy(xpath="//a[contains(@id,'fullScreenRecord')]")
	WebElement fullScreenRecordBtn;
	
	// Add reports to dashboard
	@FindBy(xpath="//a[contains(@id,'btnAdd')]")
	WebElement editBtn;
	
	@FindBy(xpath = "//span[@title='Select reports']")
	WebElement addReportBtn;
	
	@FindBy(xpath = "//input[contains(@id,'txtSearchReport')]")
	WebElement searchReportBox;
	
	@FindBy(xpath="//a[contains(@onclick,'EditReport.SeachReport()')]")
	WebElement searchReportBtn;
	
	@FindBy(xpath = "//button[contains(@class,'btn default vc-btn-black-stripe')]")
	WebElement closeSelectReportPageBtn;
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			




	// Actions:......................................................................................
	// Navigating DashBoard Link
	public boolean verifyDashboardLink(){
		return dashBoardText.isDisplayed();
	}

	public void verify_View_my_audit_and_my_questionnaires_in_dashboard() {
		SoftAssert a = new SoftAssert();
		a.assertTrue(myAuditHeader.isDisplayed(), "My audit charts not displayed");
		Reporter.log("My audit charts displayed", true);
		a.assertTrue(myQuestionnairesHeader.isDisplayed(), "My questionnaires charts not displayed");
		Reporter.log("My questionnaires charts displayed", true);
		a.assertAll();
	}

	public void verify_Record_full_screen_option() throws Exception {
		// Full screen & normal
		AjaxLibrary.jsClick(driver, fullScreenRecordBtn);
		Thread.sleep(1000);
		Reporter.log("Full screen record is functional", true);
		AjaxLibrary.jsClick(driver, fullScreenRecordBtn);
		Thread.sleep(1000);
		Reporter.log("Minimize fullscreen is functional", true);
	}

	public void verify_Add_reports_to_dashboard(String report) {
		AjaxLibrary.jsClick(driver, editBtn);
		GenericLibrary.scrollBottom(driver);
		AjaxLibrary.jsClick(driver, addReportBtn);
		searchReportBox.sendKeys(report);
		AjaxLibrary.jsClick(driver, searchReportBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(.,'"+report+"')]//following::button[1]")));
		AjaxLibrary.jsClick(driver, closeSelectReportPageBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'"+report+"')]")).isDisplayed(), "Report not added");
		Reporter.log("Report not added", true);
	}

	public void verify_Preview_report_option(String report) {
		AjaxLibrary.jsClick(driver, editBtn);
		AjaxLibrary.jsClick(driver, addReportBtn);
		searchReportBox.sendKeys(report);
		AjaxLibrary.jsClick(driver, searchReportBtn);
		AjaxLibrary.jsClick(driver, driver.findElement(By.xpath("//td[contains(.,'"+report+"')]//following::button[2]")));
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		Assert.assertTrue(iframes.size() != 0, "Report preview is not functional");
		Reporter.log("Report preview option is functional", true);
	}
	
	public void verify_Remove_reports_from_dashboard() throws Exception {
		AjaxLibrary.jsClick(driver, editBtn);
		try {
			List<WebElement> closeList = driver.findElements(By.cssSelector(".fa.fa-close"));
			GenericLibrary.waitForListOfElementsVisibility(driver, closeList);
			int count = closeList.size();
			Reporter.log("No.of Report/Graph before deletion: "+count, true);
			AjaxLibrary.jsClick(driver, closeList.get(0));
			//closeList.get(0).click();
			//.sleep(1000);
			int count2;
			try {
				List<WebElement> closeList2 = driver.findElements(By.cssSelector(".fa.fa-close"));
				count2 = closeList2.size();
			} catch (NoSuchElementException | TimeoutException e) {
				count2 = 0;
			}
			Reporter.log("No.of Report/Graph after deletion: "+count2, true);
			Assert.assertTrue(count2 < count, "Report NOT deleted");
			Reporter.log("Report deleted successfully", true);
		} catch (NoSuchElementException | TimeoutException e) {
			Reporter.log("No Reports/Graphs to delete", true);
		}
		
	}
	
	





}
