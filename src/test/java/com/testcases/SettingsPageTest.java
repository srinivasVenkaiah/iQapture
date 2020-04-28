/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.pages.TaskBoardPage;
import com.util.ExcelUtility;

public class SettingsPageTest extends BasePage {
	
	LoginPage loginPage;
	TaskBoardPage taskhBoardPage;
	SettingsPage settingsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		taskhBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		settingsPage = taskhBoardPage.clickOnSettingsLink();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verify_Navigate_to_Settings_page_Test() {
		settingsPage.verify_Navigate_to_Settings_page();
		Reporter.log("Settings Page Opened Successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Navigate_to_Settings_page_Test", enabled=false)
	public void verify_Dashboard_Time_scale_settings_Test() {
		settingsPage.verify_Dashboard_Time_scale_settings(reader.getCellData("Settings", 0, 1));
		Reporter.log("Time scale settings are functional", true);
	}
	
	@Test(dependsOnMethods="verify_Navigate_to_Settings_page_Test")
	public void verify_Add_Default_people_or_companies_settings_and_verify_its_reflection_in_all_sections_Test() {
		settingsPage.verify_Add_Default_people_or_companies_settings_and_verify_its_reflection_in_all_sections(
				reader.getCellData("Settings", 0, 2), reader.getCellData("Settings", 1, 2));
		Reporter.log("Added user or company reflected in all sections successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Navigate_to_Settings_page_Test")
	public void verify_Default_options_settings_Test() {
		settingsPage.verify_Default_options_settings();
		Reporter.log("Default options reflected as per the settings successfully", true);
	}
	
	@Test(dependsOnMethods="verify_Navigate_to_Settings_page_Test")
	public void verify_all_tooltips_in_settings_page_Test() throws Exception {
		settingsPage.verify_all_tooltips_in_settings_page(reader.getCellData("Settings", 0, 3), 
				reader.getCellData("Settings", 1, 3), reader.getCellData("Settings", 2, 3), 
				reader.getCellData("Settings", 3, 3), reader.getCellData("Settings", 4, 3), 
				reader.getCellData("Settings", 5, 3), reader.getCellData("Settings", 6, 3), 
				reader.getCellData("Settings", 7, 3), reader.getCellData("Settings", 8, 3));
		Reporter.log("All tooltips in the settings page are verified successfully", true);
	}
	
	
	
	
	
	
	
	
	
}
