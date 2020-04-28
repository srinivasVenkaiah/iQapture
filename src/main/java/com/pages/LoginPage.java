package com.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.BasePage;
import com.util.AjaxLibrary;
import com.util.GenericLibrary;

public class LoginPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	@FindBy(id="txtLoginName")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	//@FindBy(xpath=".//*[@id='lblMainMenuHint']") // Alpha 
	//@FindBy(xpath=".//*[@id='btnMainMenuTitle']//preceding::a[20]") // Local
	@FindBy(xpath="(//i[contains(@style,'color: #FFFFFF;')])[1]") // Test
	static WebElement menuBtn;

	@FindBy(xpath="//span[text()='iQapture']")
	static	WebElement newiQaptureBtn;

	@FindBy(xpath="(//span[text()='Taskboard'])[2]")
	WebElement taskBoardLink;

	// Valuechain website navigation
	@FindBy(xpath="//img[contains(@src,'ex.png')]")
	WebElement valuechainLogo;


	// Verify login form
	@FindBy(xpath=".//*[@id='info']/span")
	WebElement errorMsg;

















	// Actions:......................................................................................
	public String validate_LoginPage_Title(){
		return driver.getTitle();
	}

	public TaskBoardPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		AjaxLibrary.jsClick(driver, loginBtn);
		AjaxLibrary.jsClick(driver, menuBtn);
		AjaxLibrary.click(driver, newiQaptureBtn);
		Assert.assertTrue(taskBoardLink.isDisplayed());
		return new TaskBoardPage();
	}

	public void verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo(String expTitle) throws Exception {
		AjaxLibrary.click(driver, valuechainLogo);
		GenericLibrary.switchToNewWindow(driver);
		Thread.sleep(3000);
		String title = driver.getTitle();
		Reporter.log("Title of the page is: "+title, true);
		Assert.assertTrue(title.equalsIgnoreCase(expTitle), "Unable to navigate valuechain website");
	}

	public void verify_Login_form(String un, String pwd) {
		try {
			GenericLibrary.waitForElementVisibility(driver, username);
			Assert.assertTrue(username.isDisplayed(), "Login NOT opened");
			Reporter.log("Login page opened successfully", true);
			username.sendKeys(un);
			password.sendKeys(pwd);
			AjaxLibrary.jsClick(driver, loginBtn);
			AjaxLibrary.jsClick(driver, menuBtn);
			AjaxLibrary.click(driver, newiQaptureBtn);
			Assert.assertTrue(taskBoardLink.isDisplayed(), "Login FAIL");
			Reporter.log("Login PASS & DashBoard page opened successfully");

		} catch (NoSuchElementException e) {
			String msg = errorMsg.getText();
			if (msg.equalsIgnoreCase("Please fill email.")) {
				Reporter.log("Invalid EMAIL", true);
				Assert.fail();
			} else if(msg.equalsIgnoreCase("Please fill password.")){
				Reporter.log("Invalid PASSWORD", true);
				Assert.fail();
			} else {
				Reporter.log("Sorry, the username or password is incorrect. Please try again.", true);
				Assert.fail();
			}
		}
	}




}



