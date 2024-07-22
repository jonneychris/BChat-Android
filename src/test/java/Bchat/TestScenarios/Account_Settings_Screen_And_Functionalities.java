package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyAccountPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Account_Settings_Screen_And_Functionalities extends baseClass {

	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	MenuPage menupage;
	AccountSettingsPage accountsettingspage;

	/*
	PreSetup
	*/
	@Test(priority = 0)
	public void presetup ()throws InterruptedException {
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
		menupage.click_Account_Settings();
	}
	
	
	/*
	 * To Validate the working of the Show BChatId option
	*/
	@Test(priority = 1)
	public void To_validate_the_working_of_the_Show_BChatId_option () {
	
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickBchatIdIcon();
		Assert.assertEquals(accountsettingspage.getPopupTitle("BChatId"),"BChat ID");
		driver.navigate().back();
	}
	
	/*
	To validate the working of the Show BeldexAddress option 
	*/
	@Test(priority = 2)
	public void To_validate_the_working_of_the_Show_Beldex_Address_option () {
	
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickBeldexAddressIcon();
		Assert.assertEquals(accountsettingspage.getPopupTitle("BeldexAddress"),"Beldex Address");
		driver.navigate().back();
	}
	
	
	/*
	To validate the working of the show Qrcode option 
	*/
	@Test(priority = 3)
	public void To_validate_the_working_of_the_Show_QrCode_option () {
	
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickQRCode();
		Assert.assertEquals(accountsettingspage.getPopupTitle("QrCode"),"Scan QR code");
		driver.navigate().back();
	}
	
	/*
	To validate the working of the copy icon in the bchat id in both normal view and in the popup screen
	*/
	@Test(priority = 4)
	public void To_validate_the_working_of_copy_icon_in_Bchat_Id () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	try {
		accountsettingspage.CopyBchatId();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	catch (NoSuchElementException e) {
		accountsettingspage.CopyBchatId();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	accountsettingspage.ClickBchatIdIcon();
	try {
		accountsettingspage.clickCopyIcon();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	catch (NoSuchElementException e) {
		accountsettingspage.clickCopyIcon();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	
	
	}
	
	
	/*
	To validate the working of the copy icon in the beldex Address in both normal view and in the popup screen
	*/
	@Test(priority = 5)
	public void To_validate_the_working_of_copy_icon_in_Beldex_Address () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	try {
		accountsettingspage.CopyBeldexAddress();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	catch (NoSuchElementException e) {
		accountsettingspage.CopyBeldexAddress();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	accountsettingspage.ClickBeldexAddressIcon();
	
	try {
		accountsettingspage.clickCopyIcon();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	catch (NoSuchElementException e) {
		accountsettingspage.clickCopyIcon();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	
	}
	
	
	/*
	 To Validate the Navigation to the About BNS screen
	 */
	@Test(priority =6)
	public void  To_Validate_the_Navigation_to_About_BNS_screen () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickAboutBNS();
		Assert.assertEquals(accountsettingspage.get_About_BNS_Screen_title(),"About BNS");
	
	driver.navigate().back();
	
	}
	
	/*
	To validate the working of the share qr code.
	*/
	@Test(priority = 7)
    public void To_validate_the_working_of_the_share_qr_code () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickQRCode();
		accountsettingspage.clickSharebtn();
		Assert.assertEquals(accountsettingspage.Share_Screen_Title(), "1 image in total");
		accountsettingspage.click_Cancel_In_share_option();
	}
	
	
	/*
	 Validate whether verify and link buttons are enabled without entering any value in bns name
	 */
	@Test(priority = 8)
	public void To_Validate_verify_and_link_buttons_are_enabled_without_entering_any_value_in_bns_name () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Link_BNS_option();
		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
		
			accountsettingspage.click_Verify_Button();
			Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
			accountsettingspage.click_Link_Button_In_Popup_Screen();;			
			Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
		
	}
	
	/*
	 validate the working cancel button in link bns popup screen
	 */
	@Test(priority = 9)
	public void To_validate_the_working_cancel_button_in_link_bns_popup_screen () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
		accountsettingspage.click_Cancel_Button_In_Popup_Screen();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	
	/*
	validate whether verify button is enabled without the word .bdx in bns name
	*/
	@Test(priority = 10)
	public void To_validate_Whether_verify_button_is_enabled_without_the_word_bdx_in_bns_name () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Link_BNS_option();
		accountsettingspage.Enter_Value_In_BNS_Name_field("Chris");		
	
		accountsettingspage.click_Verify_Button();
		Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
      accountsettingspage.clear_text_box();
		
	}
	
	/*
	  Validate the verify function with invalid bns name
	 */
	@Test(priority = 11)
	public void To_Validate_the_verify_function_with_invalid_bns_name () throws InterruptedException {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
		accountsettingspage.Enter_Value_In_BNS_Name_field("name.bdx");
		accountsettingspage.click_Verify_Button();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(accountsettingspage.Element_of_Link_BNS_PopScreen_content()));	
		Assert.assertEquals(Toast(), "Invalid BNS");
		accountsettingspage.clear_text_box();
	}
	
	
	/*
	 Validate whether link button is enabled for invalid bns name
	 */
	@Test(priority = 12)
	public void To_validate_whether_link_button_is_enabled_for_invalid_bns_name () {
	 
		accountsettingspage =new AccountSettingsPage(driver);
	Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");	
	accountsettingspage.Enter_Value_In_BNS_Name_field("name.bdx");
	accountsettingspage.click_Verify_Button();
	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(accountsettingspage.Element_of_Link_BNS_PopScreen_content()));

	 accountsettingspage.click_Link_Button_In_Popup_Screen();
	 Assert.assertNotEquals(accountsettingspage.Loader_Animation(), "Verifying...");
	accountsettingspage.click_Cancel_Button_In_Popup_Screen();
	
	}
	
	
	
	/*
	 Validate Whether the screen is scrollable.
	 */
	@Test(priority = 13)
	public void To_Validate_Whether_the_screen_is_scrollable () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
		accountsettingspage.scroll_the_page(100, 100, 500, "down");
		
		
		Assert.assertEquals(accountsettingspage.Content_changelog(), "Changelog");
	
	}
}
