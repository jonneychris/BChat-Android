package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.ClearDataPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.LandingPage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;

import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;


public class ClearData_Screen_And_its_Functionalities extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	MenuPage menupage;
	AccountSettingsPage accountsettingspage;
	ClearDataPage cleardatapage ;
	
	/*
	 PreSetup to clera data popup screen
	 */
	@Test(priority = 0,groups ={"Regression","Smoke"} )
	
	public void preSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Chris");
		displaynamepage.clickContinue();
		registerpage= new RegisterPage(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		Thread.sleep(1000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(1000);
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
		accountsettingspage= new AccountSettingsPage(driver);
		accountsettingspage.click_Clear_Data_option();
		
	}
	
	
	
	
	/*
     Validate whether able to navigate back to the Account Settings screen from clear data popup
 	*/
	@Test(priority = 1,groups ={"Regression"} )
	public void To_Validate_whether_able_to_navigate_back_to_Account_Settings_Screen () {
		cleardatapage = new ClearDataPage(driver);
		Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
		driver.navigate().back();
		accountsettingspage= new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}
	
	/*
    Validate the working of the cancel button in all popup 
	*/
	@Test(priority = 2,groups ={"Regression"} )
	public void To_Validate_the_working_of_cancel_button_in_all_popup () {
		accountsettingspage= new AccountSettingsPage(driver);
		accountsettingspage.click_Clear_Data_option();
		cleardatapage = new ClearDataPage(driver);
		Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
		cleardatapage.click_Cancel_Option_popup();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Clear_Data_option();
		cleardatapage.click_ok();
		Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
		cleardatapage.click_cancel_In_clear_Or_Delete_popup();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Clear_Data_option();
		cleardatapage.click_option_deleteAccount();
		cleardatapage.click_ok();
		Assert.assertEquals(cleardatapage.DeleteAccount_popup_screen_title(), "Delete Entire Account");
		cleardatapage.click_cancel_In_clear_Or_Delete_popup();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}
	
	/*
    Validate the working of the clear all data option 
     */
	@Test(priority = 3,groups ={"Regression","Smoke"} )
	public void To_Validate_the_working_of_clear_all_data_option () {
		accountsettingspage= new AccountSettingsPage(driver);
		accountsettingspage.click_Clear_Data_option();
		cleardatapage = new ClearDataPage(driver);
		Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
		cleardatapage.click_ok();
		Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
		cleardatapage.click_Clear_Or_delete_option();
		landingpage = new LandingPage(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
		
	}
	
	
    /*
     Validate the working of the delete option.
    */
	@Test(priority = 4,groups ={"Regression","Smoke"} )
	public void To_Validate_the_working_of_delete_option () throws InterruptedException {
	        preSetup();
	    	cleardatapage = new ClearDataPage(driver);
			Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
			cleardatapage.click_option_deleteAccount();
			cleardatapage.click_ok();
			Assert.assertEquals(cleardatapage.DeleteAccount_popup_screen_title(), "Delete Entire Account");
			
			
			try {
				cleardatapage.click_Clear_Or_delete_option();
			wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			landingpage = new LandingPage(driver);
			wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
			Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
			}
			catch (AssertionError e) {
				cleardatapage.click_Clear_Or_delete_option();
				wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				landingpage = new LandingPage(driver);
				wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
				Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
			}
		
	}
	

	
}
