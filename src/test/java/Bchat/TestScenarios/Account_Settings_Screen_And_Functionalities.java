package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.AppLockPage;
import POM.BlockedContactsPage;
import POM.ChatPage;
import POM.ChatSettingsPage;
import POM.ClearDataPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.HopsPage;
import POM.LandingPage;
import POM.MenuPage;
import POM.MyAccountPage;
import POM.NewChatPage;
import POM.NoteToMyselfPage;
import POM.RecoveryPhrasePage;

import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Account_Settings_Screen_And_Functionalities extends baseClass {

	
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
	AppLockPage applockpage;
	BlockedContactsPage blockedcontactspage;
	ChatPage chatpage;
	HopsPage hopspage;
	ClearDataPage cleardatapage;
	ChatSettingsPage chatsettingspage;
	NoteToMyselfPage notetomyself;
	
	/*
	PreSetup
	*/
	@Test(priority = 0,groups ={"Regression","Smoke"} )
	public void presetup ()throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Chris");
		displaynamepage.clickContinue();
		
		try{
			registerpage= new RegisterPage(driver);
			wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		}
		catch (StaleElementReferenceException e) {
			Thread.sleep(3000);
			registerpage.clickNext();
		}
		Thread.sleep(3000);
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
	}
	
	
	/*
	 * To Validate the working of the Show BChatId option
	*/
	@Test(priority = 1,groups ={"Regression"} )
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
	@Test(priority = 2,groups ={"Regression"} )
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
	@Test(priority = 3,groups ={"Regression","Smoke"} )
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
	@Test(priority = 4,groups ={"Regression","Smoke"} )
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
	@Test(priority = 5,groups ={"Regression","Smoke"} )
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
	@Test(priority =6,groups ={"Regression"} )
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
	@Test(priority = 7,groups ={"Regression","Smoke"} )
    public void To_validate_the_working_of_the_share_qr_code () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.ClickQRCode();
		accountsettingspage.clickSharebtn();
		Assert.assertEquals(accountsettingspage.Share_Screen_Title(), "1 image in total");
		accountsettingspage.click_Cancel_In_share_option();
	}
	

	/*
	  Validate the verify function with invalid bns name
	 */
	@Test(priority = 8,groups ={"Regression","Smoke"} )
	public void To_Validate_the_verify_function_with_invalid_bns_name () throws InterruptedException {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Link_BNS_option();
		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
		accountsettingspage.Enter_Value_In_BNS_Name_field("name.bdx");
	
			accountsettingspage.click_Verify_Button();
		    Assert.assertEquals(Toast(), "Invalid BNS");
			Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");	
		
		accountsettingspage.clear_text_box();
		accountsettingspage.click_Cancel_Button_In_Popup_Screen();
	}
	
	
//	/*
//	  Validate the verify function with valid bns name
//	 */
//	@Test(priority = 9,groups ={"Regression","Smoke"} )
//	public void To_Validate_the_verify_function_with_valid_bns_name () throws InterruptedException {
//		accountsettingspage =new AccountSettingsPage(driver);
//		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
//		accountsettingspage.click_Link_BNS_option();
//		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
//		accountsettingspage.Enter_Value_In_BNS_Name_field(" ");
//			accountsettingspage.click_Verify_Button();
//			//
//	}
	
	/*
	 Validate whether verify and link buttons are enabled without entering any value in bns name
	 */
	@Test(priority = 10,groups ={"Regression"} )
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
	@Test(priority = 11,groups ={"Regression"} )
	public void To_validate_the_working_cancel_button_in_link_bns_popup_screen () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
		accountsettingspage.click_Cancel_Button_In_Popup_Screen();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	
	/*
	validate whether verify button is enabled without the word .bdx in bns name
	*/
	@Test(priority = 12,groups ={"Regression"} )
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
	 Validate whether link button is enabled for invalid bns name
	 */
	@Test(priority = 13,groups ={"Regression"} )
	public void To_validate_whether_link_button_is_enabled_for_invalid_bns_name () {
	 
		accountsettingspage =new AccountSettingsPage(driver);
	Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");	
	accountsettingspage.Enter_Value_In_BNS_Name_field("invalid.bdx");
	accountsettingspage.click_Verify_Button();
	wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	try{
		wait.until(ExpectedConditions.visibilityOf(accountsettingspage.Element_of_Link_BNS_PopScreen_content()));
	}
   catch (TimeoutException e) {
	   Minimize_the_App();
	   homepage = new HomePage(driver);
	   homepage.clickMenuDrawer();
	   menupage = new MenuPage(driver);
	   menupage.click_Account_Settings();
}
	 accountsettingspage.click_Link_Button_In_Popup_Screen();
	 Assert.assertEquals(accountsettingspage.get_Link_BNS_Popup_Screen_Title(), "Link BNS");
	accountsettingspage.click_Cancel_Button_In_Popup_Screen();
	
	}
	
	
	
	/*
	 Validate Whether the screen is scrollable.
	 */
	@Test(priority = 14,groups ={"Regression"} )
	public void To_Validate_Whether_the_screen_is_scrollable () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.scroll_the_page(100, 100, 500, "down");
		Assert.assertEquals(accountsettingspage.Content_changelog(), "Changelog");
	
	}
	/*
	Validate the working of the FeedBack option
	*/
	@Test(priority = 15,groups ={"Regression"} )
	public void To_Validate_the_working_of_the_FeedBack_option () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Feedback_option();
		Assert.assertEquals(accountsettingspage.feedback_mail_Id(), "feedback@beldex.io");
		
	}
	
	
	/*
	Validate whether able to navigate back to the my account screen from gamil
	*/
	@Test(priority = 16,groups ={"Regression"} )
	public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_from_gmail () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.feedback_mail_Id(), "feedback@beldex.io");
		driver.navigate().back();
		driver.navigate().back();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	/*
 	Validate the working of the  FAQ option 
	 */
	@Test(priority = 17,groups ={"Regression"} )
	public void To_Validate_the_working_of_the_FAQ_option () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_FAQ_option();
		Assert.assertEquals(accountsettingspage.FAQ_Page_Title(), "Frequently Asked Questions");
	}
	
	/*
	Validate whether able to navigate back to the my account screen From FAQ Screen.
	*/
	@Test(priority = 18,groups ={"Regression"} )
     public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_From_FAQ_Screen () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.FAQ_Page_Title(), "Frequently Asked Questions");
		driver.navigate().back();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	
	/*
	 Validate the working of the change log option
	 */
	@Test (priority =19,groups ={"Regression"} )
	public void To_Validate_the_working_of_change_log_option () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Changelog_option();
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		
	}
	
	/*
	Validate the working of the dropdown.
	*/
	@Test(priority = 20,groups ={"Regression"} )
	public void To_Validate_the_working_of_the_dropdown () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.click_First_Log();
		Assert.assertTrue(accountsettingspage.FirstLog_content().isDisplayed());
	}
	
	/*
	Validate Whether screen is scrollable
	*/
	@Test(priority = 21,groups ={"Regression"} )
	public void To_Validate_Whether_screen_is_scrollable () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.scrollgesture_Using_text("2.5.0");
		Assert.assertTrue(accountsettingspage.lastLog().isDisplayed());
	}
	
	
	
	/*
	Validate whether able to navigate back to the my Account Settings screen
	*/
	@Test(priority = 22,groups ={"Regression"} )
	public void To_Validate_whether_able_to_navigate_back_to_my_account_screen_from_changeLog () {
		accountsettingspage =new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.ChangeLog_PageTitle(), "Changelog");
		accountsettingspage.Click_back_arrow();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}

	
	
	/*
	 * 
	 * Hops Screen
	 * 
	 * 
	 */
	
	
	
	/*
	Validate the working of the Hops Screen without Internet Connection.
	*/
	@Test(priority = 23,groups ={"Regression"})
	public void To_Validate_the_working_of_the_Hops_Screen_without_Internet_Connection () throws InterruptedException {
		turnOff_Mobile_Wifi();
		accountsettingspage = new AccountSettingsPage(driver);
		accountsettingspage.Click_back_arrow();
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.hops_Warning().isDisplayed());
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
		accountsettingspage.click_Hops_Option();
		hopspage =new HopsPage(driver);
		try {
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		}
		catch (NoSuchElementException e) {
			Minimize_the_App();
		}
		try {
		Assert.assertFalse(hopspage.Element_Entry_Node().isDisplayed());
		Assert.assertFalse(hopspage.Element_Master_Node().isDisplayed());			
		}
		catch (NoSuchElementException e) {
			turnOn_Mobile_Wifi();
			Thread.sleep(5000);
		}
		Assert.assertEquals(hopspage.pageTitle(), "Hops");
		
	}
	

	   
	/*
	Validate whether able to navigate back to the My Account Screen.
	*/
	@Test(priority = 24,groups ={"Regression"})
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
	@Test(priority = 25,groups ={"Regression"})
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
		driver.navigate().back();
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	}
	
	
	
		
			/*
			 * 
			 * App lock screen and its functions
			 * 
			 */
		
	
	
	/*
	Validate whether the functions present in the App Lock screen response for the touch action.
	Validate navigation to the functions in the App Lock screen in both forward and backward direction.
	*/
	@Test(priority = 26,groups ={"Regression"} )
	public void To_Validate_navigation_to_the_functions_in_the_App_Lock_screen () {
		 accountsettingspage =new AccountSettingsPage(driver);
	        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	        accountsettingspage.click_App_Lock_Option();
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		
		applockpage.click_ChangePassword_option();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		applockpage.click_Back_Arrow();
		applockpage.click_ScreenLockTimeOut_option();
		Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
		applockpage.Clicl_Cancel_Icon();
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		
		
	}	
	
	/*
	Validate whether able to navigate back to the Account Settings Screen.
	*/
	@Test(priority = 27,groups ={"Regression"} )
	public void To_Validate_whether_able_to_navigate_back_to_the_AccountSettings_Screen () {
		

		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		driver.navigate().back();
		accountsettingspage =new AccountSettingsPage(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	  
	   
		
	}
	
 
	 /*
	Validate the Change password fields with Invalid Old password value
	*/
	@Test(priority = 28,groups ={"Regression","Smoke"} )
	public void To_Validate_the_Change_password_fields_with_Invalid_Old_password_value () {
		accountsettingspage =new AccountSettingsPage(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	    accountsettingspage.click_App_Lock_Option();
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ChangePassword_option();
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setPassword_0();
		try {
		createpasswordpage.clickNext();
		Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		catch (StaleElementReferenceException e) {
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		catch (NoSuchElementException e) {
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		catch (Exception e) {
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		}
		}
	
	
	/*
	Validate whether next button clickable without entering the values in all fields
	*/
	@Test(priority = 29,groups ={"Regression"} )
	public void To_Validate_whether_next_button_clickable_without_entering_the_values_in_all_fields () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		createpasswordpage.clickNext();
		driver.navigate().back();
	}
	
	
	/*
	Validate the password fields with valid Old password and valid New Password and invalid Reenter password
	*/
	 @Test(priority = 30,groups ={"Regression"} )
	 public void To_Validate_password_fields_with_valid_Old_password_and_valid_New_Password_and_invalid_ReEnter_password () {
		 applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			try {
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Password does not match.");
			}
			catch(StaleElementReferenceException e) {
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(), "Password does not match.");
			}
			catch(NoSuchElementException e) {
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(), "Password does not match.");
			}
			catch (Exception e) {
				Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
			}
			driver.navigate().back();
	 }
	
	 /*
	     Validate whether able to set the new password with old password value
	     */
	 @Test(priority = 31,groups ={"Regression"} )
	 public void To_Validate_whether_able_to_set_the_new_password_with_old_password_value () {
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ChangePassword_option();
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.setPassword_1();
		try {
		createpasswordpage.clickNext();
		Assert.assertEquals(Toast(),"New password should not be same as old password.");
		}
		catch (StaleElementReferenceException e) {
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(),"New password should not be same as old password.");
		}
		catch (NoSuchElementException e) {
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(),"New password should not be same as old password.");
		}
		catch (Exception e) {
			Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		}
		driver.navigate().back();
	 
	 }

	 
	 /*
		Validate whether the value entered in all pin number fields is editable.
		Validate whether the value entered in all pin number fields is deleteable.
		*/
		@Test(priority=32,groups ={"Regression"} )
		public void TC_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
			
			
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.Delete_And_Edit_pin_field();	
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.cancel_Values();
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();  
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
			createpasswordpage.Delete_And_Edit_pin_field();
			driver.navigate().back();
				
				
			}
	 
	 /*
	Validate both the Password fields by entering values Below boundary value.
	*/
		@Test(priority =33,groups ={"Regression"} )
		public void TC_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
			
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click1();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");	
				createpasswordpage.click1();
				createpasswordpage.clickNext();
			
				Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click0();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");	
				createpasswordpage.click0();
				createpasswordpage.clickNext();	
				
				Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click0();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");	
			
			driver.navigate().back();
				
												         		         						
		}
	
	
		  /* 
		Validate whether values entered in the pin number fields are visible
		*/
		@Test(priority = 34,groups ={"Regression"} )
		public void To_Validate_whether_values_entered_in_the_pin_number_fields_are_visible () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_1();
			
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[1, 1, 1, 1]");
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");	
			createpasswordpage.setPassword_0();
		
			
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[0, 0, 0, 0]");
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[1, 1, 1, 1]");
	
			driver.navigate().back();
			
			
		}

		
		/*
		Validate the password fields with valid Old password and Valid New Password.
		*/
		@Test(priority = 35,groups ={"Regression","Smoke"} )
		public void To_Validate_password_fields_with_valid_Old_password_and_Valid_New_Password () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.change_password_with_Valid_value();
			Assert.assertEquals(createpasswordpage.text_PasswordSuccessful(), "Password changed successfully.");
			createpasswordpage.clickOk();
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_Back_Arrow();
			accountsettingspage = new AccountSettingsPage(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		}
		 
		/*
		 Validate the scrolling in both upward and downward direction.
		 */
		@Test (priority = 36,groups ={"Regression"} )
		public void To_Validate_the_scrolling_in_both_upward_and_downward_direction () {
			accountsettingspage = new AccountSettingsPage(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_App_Lock_Option();
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Selected_option_In_Screenlock(), "None");
		
			
			for(int i =0;i <6;i++) {
				Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.scroll_the_page(530, 1225, 100, "down");
			}
			Assert.assertEquals(applockpage.Selected_option_In_Screenlock(), "30 Minutes");
			for(int i =0;i <6;i++) {
				Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
				applockpage.scroll_the_page(530, 1225, 100, "Up");
				}
			Assert.assertEquals(applockpage.Selected_option_In_Screenlock(), "None");
			    applockpage.click_cancel_Icon_In_screenlock();	
			}
		
		/*
		 Validate the working of the Ok and Cancel option in the Screenlock inactivity timeout functionality
		 */
		@Test (priority = 37,groups ={"Regression"} )
		public void To_Validate_working_of_Ok_and_Cancel_option_in_Screenlock_inactivity_timeout_functionality () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.click_cancel_Icon_In_screenlock();
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.click_Ok_In_Screenlock();
			
			
		}
		
		
		/*
		 Validate the whether able to select all timing options in Screenlock inactivity timeout functionality
		 Validate whether the selected option is displayed in the AppLock screen.
		 */
		@Test (priority = 38,groups ={"Regression"} )
		public void To_Validate_whether_able_to_select_all_timing_options_in_Screenlock_inactivity_timeout_functionality_And_Selected_option_Is_displayed_in_AppLock_Screen () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			
			Assert.assertEquals(applockpage.Showing_option_in_app_lock_screen(),"None");
			
		
			for(int i=0;i<6;i++) {
				applockpage.click_ScreenLockTimeOut_option();
				Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.scroll_the_page(530, 1225, 100, "down");
			applockpage.click_Ok_In_Screenlock();
			}
			Assert.assertEquals(applockpage.Showing_option_in_app_lock_screen(),"30 Minutes");
			applockpage.click_Back_Arrow();
		}
	
		
		
		
		
		   /*
		    * 
		    * 
		    * Chat Settings Screen Test Cases
		    * 
		    * 
		    */
	

		/*
		Validate whether able to navigate back to the Account Settings screen
		*/
		@Test(priority = 39,groups ={"Regression"} )
		public void To_Validate_whether_Able_to_navigate_back_to_Account_Settings_screen () {
			accountsettingspage = new AccountSettingsPage(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_option_Chat_settings();
			chatsettingspage=new ChatSettingsPage(driver);
			Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
			chatsettingspage.click_Back_Arrow();
			accountsettingspage =new AccountSettingsPage(driver);
	        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			
		}


		
		/*
		Validate the working of the enter is send option in the messaging screen in on condition.
	    */
	   @Test(priority = 40,groups ={"Regression"} )
		public void To_Validate_working_of_enterkey_is_send_option_in_messaging_screen_in_on_condition () {
		  
		   accountsettingspage =new AccountSettingsPage(driver);
	       Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	       accountsettingspage.click_option_Chat_settings();
	       chatsettingspage = new ChatSettingsPage(driver);
	   	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   	   chatsettingspage.click_Swipe_button_In_Enter_key();
	   	   chatsettingspage.click_Back_Arrow();
	   	   driver.navigate().back();
	   	   homepage = new HomePage(driver);
	   	   homepage.clickSearch();
	   	   homepage.click_Option_Note_To_Myself();
	   	   notetomyself = new NoteToMyselfPage(driver); 
	   	   notetomyself.clickTextBox();
	   	   notetomyself.Set_Values_In_Message_textbox("Hello");
	   	   ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	   	   Assert.assertTrue(notetomyself.SendMessageCard().isDisplayed());   
	   	   notetomyself.click_Back_Arrow(); 
		   
		   
	   }
	   
		/*
		Validate the working of the enter is send option in the messaging screen in off condition.
		*/
	   @Test(priority =41 ,groups ={"Regression"} )
	   public void To_Validate_working_of_enter_is_send_option_in_messaging_screen_in_off_condition () {
		   	homepage = new HomePage(driver);
		   	homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_Account_Settings();
	        accountsettingspage =new AccountSettingsPage(driver);
	        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	        accountsettingspage.click_option_Chat_settings();
	        chatsettingspage = new ChatSettingsPage(driver);
	        Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	        chatsettingspage.click_Swipe_button_In_Enter_key();
	    	  
	    	   chatsettingspage.click_Back_Arrow();
	    	   driver.navigate().back();
	    	
	 	homepage.clickSearch();
	 	homepage.click_Option_Note_To_Myself();
	 	notetomyself = new NoteToMyselfPage(driver); 
	    	notetomyself.clickTextBox();
	    	notetomyself.Set_Values_In_Message_textbox("Hii");
	     ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	 	Assert.assertNotEquals(notetomyself.get_Send_Message_Value(), "Hii");
	 	notetomyself.click_Back_Arrow();  
	 	
	   }
		
		
	   
	   /*
	    Validate Whether option in message trimming are clickabble without enabled delete old messages
		*/
	   @Test(priority = 42,groups ={"Regression"} )
	   public void To_Validate_Whether_option_in_message_trimming_are_clickabble_without_enabled_delete_old_messages () {
		   homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_Account_Settings();
	       accountsettingspage =new AccountSettingsPage(driver);
	       Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	       accountsettingspage.click_option_Chat_settings();
	       chatsettingspage = new ChatSettingsPage(driver);
	   	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   	   chatsettingspage.click_Option_Conversation_Length();
	   	   Assert.assertEquals(chatsettingspage.pageTitle(), "Chat Settings");
	   	chatsettingspage.click_option_Trim_conversation();
		   Assert.assertEquals(chatsettingspage.pageTitle(), "Chat Settings");
	   }
	   
	   /*
	  Validate the Whether able to change the value in the conversation length limit
	   */
	  @Test(priority = 43,groups ={"Regression"} )
	   public void To_Validate_the_Whether_able_to_change_the_value_in_the_conversation_length_limit () {
		  
		  chatsettingspage = new ChatSettingsPage(driver);
	  	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  	   chatsettingspage.click_Swipe_button_In_delete();
	  	   chatsettingspage.click_Option_Conversation_Length();
	  	   Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	  	   chatsettingspage.change_Value_In_Conversation_Length("100");
	  	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),100);
	  	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		  
	  }
	  
	  /*
	   Validate whether entered value in conversation length limit field is displayed chat Setting Screen.
	    Validate whether the value entered in Conversation length limit field is editable and deleteable.
	   */
	  @Test(priority =44,groups ={"Regression"} )
	  public void To_Validate_whether_entered_value_in_conversation_length_limit_field_is_displayed_In_Chat_Settings () {
		  chatsettingspage = new ChatSettingsPage(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   chatsettingspage.click_Option_Conversation_Length();
	 	  Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	 	   chatsettingspage.change_Value_In_Conversation_Length("200");
	 	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),200);
	 	  chatsettingspage.click_Option_Conversation_Length();
	 	  Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	 	   chatsettingspage.change_Value_In_Conversation_Length("300");
	 	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),300);
	 	   
	 	
	  }
	  
	  
	   /*
	  Validate the working of the Ok and cancel buttons in conversation length
		*/
	  @Test(priority = 45,groups ={"Regression"} )
	  public void To_Validate_the_working_of_Ok_and_cancel_buttons_in_conversation_length () {
		  chatsettingspage = new ChatSettingsPage(driver);
	 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	  chatsettingspage.click_Option_Conversation_Length();
	 	   Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	 	   chatsettingspage.click_Cancel_In_conversation_Length_Popup();
	 	  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	 	  chatsettingspage.click_Option_Conversation_Length();
	 	 Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
		   chatsettingspage.click_Ok_In_Conversation_Popup();
		  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  }

	   /*
	 Validate the working of the delete button in the Delete all old messages now
		*/
	  @Test(priority = 46,groups ={"Regression"} ) 
	  public void To_Validate_the_working_of_delete_button_in_Delete_all_old_messages_now () {
		  chatsettingspage = new ChatSettingsPage(driver);
		   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		   chatsettingspage.click_option_Trim_conversation();
		   Assert.assertEquals(chatsettingspage.Delete_Old_Messages_Popup_Title(),"Delete All Old Messages Now?");
		  
		 try {
			 chatsettingspage.click_delete_In_Delete_Messages_Popup();
		   Assert.assertEquals(Toast(),"Old messages successfully deleted");
		 }
		 catch (StaleElementReferenceException e) {
			 chatsettingspage.click_option_Trim_conversation();
			 chatsettingspage.click_delete_In_Delete_Messages_Popup();
			 Assert.assertEquals(Toast(),"Old messages successfully deleted");
		}
		 catch (NoSuchElementException e) {
			 chatsettingspage.click_option_Trim_conversation();
			 chatsettingspage.click_delete_In_Delete_Messages_Popup();
			 Assert.assertEquals(Toast(),"Old messages successfully deleted");
		}
		 catch (Exception e) {
			  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		 }		   
	  }
	  
	  
	   /*
	  Validate the working of the cancel button in the Delete all old messages now
	    */
	   @Test(priority =47,groups ={"Regression"}  )
	   public void To_Validate_working_of_cancel_button_in_Delete_all_old_messages_now () {
		   chatsettingspage = new ChatSettingsPage(driver);
		   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		   chatsettingspage.click_option_Trim_conversation();
		   Assert.assertEquals(chatsettingspage.Delete_Old_Messages_Popup_Title(),"Delete All Old Messages Now?");
		   chatsettingspage.click_Cancel_In_Delete_Messages_Popup();
		   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   }
	   
	   
	   /*
	   Validate Conversation length limit field Whether allowing space.
	   */
	   @Test(priority = 48,groups ={"Regression"} )
	   public void To_Validate_Conversation_length_limit_field_Whether_allowing_space () {
		   chatsettingspage = new ChatSettingsPage(driver);
		   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		   chatsettingspage.click_Option_Conversation_Length();
		   chatsettingspage.set_Space_Inbetween_Values();
		   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),200);
		   
	   }
	   
	   /*
	   validate whether paste option is working on Conversation length limit field.
	   */
	   @Test(priority = 49,groups ={"Regression"} )
	   public void To_Validate_whether_paste_option_is_working_on_Conversation_length_limit_field () {
		   chatsettingspage = new ChatSettingsPage(driver);
		   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		   chatsettingspage.click_Option_Conversation_Length();
		   chatsettingspage.Copy_And_Paste_Values();
		   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),500);
		   chatsettingspage.click_Back_Arrow();
		   
	   }
	   
		
				
			/*
			 * 
			 * 
			 * Blocked Contact Screen test cases
			 * 
			 * 
			 */
			
		
		/*
		Validate the Blocked Contacts screen when there is no blocked contact
		*/
		@Test (priority = 50,groups ={"Regression","Smoke"} )
		public void To_Validate_the_Blocked_Contacts_screen_when_there_is_no_blocked_contact () {
		
			accountsettingspage = new AccountSettingsPage(driver);
			 Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			  accountsettingspage.click_Blocked_contact_Option();
			  blockedcontactspage = new BlockedContactsPage(driver);
			  Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			  Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
			  blockedcontactspage.click_Back_Arrow();
			 
		}
		
		/*
		Validate whether blocked contacts is showing.
		*/
		@Test (priority = 51,groups ={"Regression","Smoke"} )
		public void To_Validate_whether_blocked_contacts_is_showing () {
			 accountsettingspage = new AccountSettingsPage(driver);
			 Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			 accountsettingspage.Click_back_arrow();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.OpenNewChat();
			newchatpage = new NewChatPage(driver);
			newchatpage.Check_with_ValidId_1();
			chatpage = new ChatPage(driver);
			chatpage.Set_Values_In_Message_textbox("Hello");
			chatpage.click_Send_Button();
			driver.navigate().back();
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			 String blockedContact=  homepage.get_DisplayName_Or_Id_Of_ChatItem().toLowerCase();
			   homepage.Block_First_Contact();
			   homepage.clickMenuDrawer();
			   menupage = new MenuPage(driver);
			   menupage.click_Account_Settings();
			   accountsettingspage.click_Blocked_contact_Option();
			   Assert.assertEquals(blockedContact,blockedcontactspage.get_Blocked_Contact_Id_Or_Name());	
			   blockedcontactspage.click_Back_Arrow();
		}	    
			
		
		/*
		Validate whether able to navigate back to Account settings screen.
		*/
		@Test(priority = 52,groups ={"Regression"} )
		public void To_Validate_whether_able_to_navigate_back_to_AccoutSettings_screen_from_Blocked_Screen () {
			accountsettingspage = new AccountSettingsPage(driver);
			  accountsettingspage.click_Blocked_contact_Option();
			 blockedcontactspage = new BlockedContactsPage(driver);
			 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			 blockedcontactspage.click_Back_Arrow();
			  accountsettingspage = new AccountSettingsPage(driver);
			  Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			
		}
		
		
		/*
		 	Validate the working of the cancel button in the unblock users popup.
		 */
		@Test(priority = 53,groups ={"Regression"} )
		public void To_Validate_the_working_of_cancel_button_in_unblock_users_popup () {
			accountsettingspage = new AccountSettingsPage(driver);
			  accountsettingspage.click_Blocked_contact_Option();
			blockedcontactspage = new BlockedContactsPage(driver);
			 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			 blockedcontactspage.check_Cancel_button_In_unblockusers_Popup();
			 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		}
		
		
		/*
		Validate whether able to unblock the blocked contacts.
	    */
		@Test(priority = 54,groups ={"Regression"} )
		public void To_Validate_whether_able_to_unblock_the_blocked_contacts () {
			blockedcontactspage = new BlockedContactsPage(driver);
			 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			 blockedcontactspage.UnBlock_contact();
			  Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
			  
		}
	
		
		/*
		Validate whether able to unblock by multiselect the contacts in the blocked contacts screen.
		*/
		@Test(priority = 55,groups ={"Regression"} )
		public void To_Validate_whether_able_to__Unblock_By_multiselect_the_contacts_in_blocked_contacts_screen() {
			blockedcontactspage = new BlockedContactsPage(driver);
			 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			 blockedcontactspage.click_Back_Arrow();
			 driver.navigate().back();
			 homepage = new HomePage(driver);
			 homepage.OpenNewChat();
			 newchatpage = new NewChatPage(driver);
			 newchatpage.Check_with_ValidId_2();
			 chatpage = new ChatPage(driver);
			 chatpage.Set_Values_In_Message_textbox("Hello");
			 chatpage.click_Send_Button();
			 chatpage.click_Back_Arrow();			 
			 homepage.Block_First_Contact();
			 homepage.Block_Second_Contact();
			 homepage.clickMenuDrawer();
			 menupage = new MenuPage(driver);
			 menupage.click_Account_Settings();
			 accountsettingspage = new AccountSettingsPage(driver);
			 accountsettingspage.click_Blocked_contact_Option();
			 blockedcontactspage.UnBlock_By_Using_MultiSelect_option();
			 Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
			 blockedcontactspage.click_Back_Arrow();
		}
	
				
		
				/*
				 * 
				 * 
				 * Clear data screen
				 * 
				 * 	
				 */
		
		
		/*
	     Validate whether able to navigate back to the Account Settings screen from clear data popup
	 	*/
		@Test(priority = 56,groups ={"Regression"} )
		public void To_Validate_whether_able_to_navigate_back_to_Account_Settings_Screen () {
			accountsettingspage= new AccountSettingsPage(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Clear_Data_option();
			cleardatapage = new ClearDataPage(driver);
			Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
			driver.navigate().back();
			accountsettingspage= new AccountSettingsPage(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			
		}
		
		/*
	    Validate the working of the cancel button in all popup 
		*/
		@Test(priority = 57,groups ={"Regression"} )
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
		@Test(priority = 58,groups ={"Regression","Smoke"} )
		public void To_Validate_the_working_of_clear_all_data_option () {
			accountsettingspage= new AccountSettingsPage(driver);
			accountsettingspage.click_Clear_Data_option();
			cleardatapage = new ClearDataPage(driver);
			Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
			cleardatapage.click_ok();
			Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
			cleardatapage.click_Clear_Or_delete_option();
			try{
				landingpage = new LandingPage(driver);
			Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
			}
			catch (StaleElementReferenceException e) {
				landingpage = new LandingPage(driver);
				Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
			}
		}
		
		
	    /*
	     Validate the working of the delete option.
	    */
		@Test(priority = 59,groups ={"Regression","Smoke"} )
		public void To_Validate_the_working_of_delete_option () throws InterruptedException {
		        presetup();
		        accountsettingspage= new AccountSettingsPage(driver);
				accountsettingspage.click_Clear_Data_option();
		    	cleardatapage = new ClearDataPage(driver);
				Assert.assertEquals(cleardatapage.pageTitle(),"Clear All Data");
				cleardatapage.click_option_deleteAccount();
				cleardatapage.click_ok();
				Assert.assertEquals(cleardatapage.DeleteAccount_popup_screen_title(), "Delete Entire Account");
				cleardatapage.click_Clear_Or_delete_option();
				
				try {
					landingpage = new LandingPage(driver);
				Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
				}
				catch (NoSuchElementException e) {
					Assert.assertEquals(cleardatapage.DeleteAccount_popup_screen_title(), "Delete Entire Account");
					cleardatapage.click_Clear_Or_delete_option();
				}
				catch (StaleElementReferenceException e) {
					landingpage = new LandingPage(driver);
					Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
				}
			
		}
		
		
		
		
		
		
}







