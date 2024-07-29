package Bchat.TestScenarios;

import Utiles.baseClass;

import static org.junit.Assert.assertArrayEquals;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.NoteToMyselfPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SettingsPage;
import POM.SocialGroupPage;
import POM.WalletPage;
public class Settings_Screen_And_Its_Functionalities extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	MenuPage menupage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	SettingsPage settingspage;
	WalletPage walletpage;
	NoteToMyselfPage notetomyself;
	
	/*
	 preSetup
	 */
	@Test(priority = 0)
	public void PreSetup () throws InterruptedException {
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
		Thread.sleep(2000);
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
	}
	/*
	 Validate whether able to navigate back to the Menu screen
	 */
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_Menu_screen () {
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		
	}
	
	/*
	Validate the working of the pay as you without enabling the wallet
	*/
	@Test(priority = 2)
	public void To_Validate_the_working_of_pay_as_you_without_enabling_the_wallet () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		Assert.assertFalse(settingspage.Check_payAsYouChat_option().isEnabled());
	}
	
	/*
	 Validate the working of the Start wallet 
	*/
	@Test(priority = 3)
	public void To_Validate_the_working_of_Start_wallet () {
		
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_start_wallet();
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickMenuDrawer();
		menupage.click_option_Wallet();
		walletpage = new WalletPage(driver);
		Assert.assertEquals(walletpage.Title_Wallet_Password(),"Create PIN");
		walletpage.click_Back_Arrow();
		
		
	}
	

	
	/*
	validate the working of the pay as you while enabling first time before entering into wallet
	 */
	@Test(priority = 4)
	public void To_validate_the_working_of_pay_as_you_while_enabling_first_time_before_entering_into_wallet () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_PayAsYouChat();
		Assert.assertEquals(settingspage.popupSetupPin(), "Setup Pin");
		settingspage.click_Cancel();
	}
	
	/*
	 Validate the working of the Send Link Previews option in both On and Off condition.
	*/
	@Test(priority = 5)
	public void To_Validate_the_working_of_Send_Link_Previews_option_in_both_On_and_Off_condition () throws InterruptedException {
		// to check in on condition
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Send_LinkPreview();
		settingspage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		notetomyself = new NoteToMyselfPage(driver);
		notetomyself.Set_Values_In_Message_textbox("https://youtube.com/shorts/QE8EBWPLOUs?si=j5YE10X8O0_MHeWJ");
		notetomyself.click_send_Button();
		//Assert.assertTrue(notetomyself.Link_Preview().isDisplayed());
		
		
		//To check in off condition
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Send_LinkPreview();
		settingspage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		notetomyself = new NoteToMyselfPage(driver);
		try {
		notetomyself.Set_Values_In_Message_textbox("https://youtube.com/shorts/QE8EBWPLOUs?si=j5YE10X8O0_MHeWJ");
		Thread.sleep(1000);
		notetomyself.click_send_Button();
		//Assert.assertTrue(notetomyself.Link_Preview().isDisplayed());
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
		}
		
		
		
		
	}
	
	
	
}
