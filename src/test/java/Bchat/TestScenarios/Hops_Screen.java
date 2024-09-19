package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.HopsPage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeedPage;

import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Hops_Screen extends baseClass{

	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeedPage recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	MenuPage menupage;
	AccountSettingsPage accountsettingspage;
	HopsPage hopspage;
	/*
	 PreSetup to hop screen
	 */
	@Test(priority = 0)
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
		Thread.sleep(2000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(1000);
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		
		turnOff_Mobile_Wifi();
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");		
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
        accountsettingspage =new AccountSettingsPage(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_Hops_Option();
	}
	
	
	/*
	Validate the working of the Hops Screen without Internet Connection.
	*/
	@Test(priority = 1)
	public void To_Validate_the_working_of_the_Hops_Screen_without_Internet_Connection () {
		hopspage =new HopsPage(driver);
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		try {
		Assert.assertFalse(hopspage.Element_Entry_Node().isDisplayed());
		Assert.assertFalse(hopspage.Element_Master_Node().isDisplayed());			
		}
		catch (NoSuchElementException e) {
			turnOn_Mobile_Wifi();
		}
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		
	}
	

	   
	/*
	Validate whether able to navigate back to the My Account Screen.
	*/
	@Test(priority = 2)
	public void To_Validate_whether_able_to_navigate_back_to_the_My_Account_Screen () {
		
		hopspage =new HopsPage(driver);
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		hopspage.click_Back_Arrow();
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	
	
	
	/*
	Validate the working of the Hops Screen with Internet Connection.
	*/
	@Test(priority = 3)
	public void To_Validate_the_working_of_the_Hops_Screen_with_Internet_Connection () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		driver.navigate().back();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");		
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
        accountsettingspage =new AccountSettingsPage(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_Hops_Option();
		hopspage =new HopsPage(driver);
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		try {
		Assert.assertTrue(hopspage.Element_Entry_Node().isDisplayed());
		Assert.assertTrue(hopspage.Element_Master_Node().isDisplayed());
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
			accountsettingspage.click_Hops_Option();
			Assert.assertEquals(hopspage.pageTitle(), "Hops");
			Assert.assertTrue(hopspage.Element_Entry_Node().isDisplayed());
			Assert.assertTrue(hopspage.Element_Master_Node().isDisplayed());
		}
	}
	
	
	
}
