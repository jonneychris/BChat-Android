package Bchat.TestScenarios;

import static org.testng.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.BlockedContactsPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.OneToOneChatPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.BaseClass;
import Utiles.baseClass;

public class Blocked_Contact_Screen_And_Its_Functionalities extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	MenuPage menupage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	AccountSettingsPage accountsettingspage;
	OneToOneChatPage onetonechatpage;
	BlockedContactsPage blockedcontactspage;
	
	@Test(priority = 0)
	public void Presetup () throws InterruptedException {
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
		
		homepage.OpenNewChat();
		newchatpage = new NewChatPage(driver);
		   newchatpage.Check_with_ValidId_1();
		onetonechatpage = new OneToOneChatPage(driver);
		onetonechatpage.Set_Values_In_Message_textbox("Hello");
		onetonechatpage.click_Send_Button();
		onetonechatpage.click_Back_Arrow();

		homepage.clickMenuDrawer();
		
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
	  accountsettingspage = new AccountSettingsPage(driver);
	  accountsettingspage.click_Blocked_contact_Option();
	  
	}
	
//	/*
//	Validate whether able to navigate back to the my account screen.
//	*/
//	@Test(priority = 1)
//	public void To_Validate_whether_able_to_navigate_back_to_my_account_screen () {
//		 blockedcontactspage = new BlockedContactsPage(driver);
//		 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
//		 blockedcontactspage.click_Back_Arrow();
//		  accountsettingspage = new AccountSettingsPage(driver);
//		  Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
//		
//	}
//	
//	
//	
//	
//	
//	/*
//	Validate the Blocked Contacts screen when there is no blocked contact
//	*/
//	@Test (priority = 2)
//	public void To_Validate_the_Blocked_Contacts_screen_when_there_is_no_blocked_contact () {
//	
//		accountsettingspage = new AccountSettingsPage(driver);
//		  accountsettingspage.click_Blocked_contact_Option();
//		  
//		  blockedcontactspage = new BlockedContactsPage(driver);
//		  Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
//		  Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
//		 
//	}

	/*
	Validate whether blocked contacts is showing.
	*/
	@Test (priority = 3)
	public void To_Validate_whether_blocked_contacts_is_showing () {
		  blockedcontactspage = new BlockedContactsPage(driver);
		  Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		  blockedcontactspage.click_Back_Arrow();
		    accountsettingspage = new AccountSettingsPage(driver);
		    driver.navigate().back();
		    homepage = new HomePage(driver);
		  String blockedContact=  homepage.get_DisplayName_Or_Id_Of_ChatItem().toLowerCase();
		    homepage.Block_First_Contact();
		    homepage.clickMenuDrawer();
		    menupage = new MenuPage(driver);
		    menupage.click_Account_Settings();
		    accountsettingspage.click_Blocked_contact_Option();
		    Assert.assertEquals(blockedContact,blockedcontactspage.get_Blocked_Contact_Id_Or_Name());

		    
		
	}
	
	/*
	 	Validate the working of the cancel button in the unblock users popup.
	 */
	@Test(priority = 4)
	public void To_Validate_the_working_of_cancel_button_in_unblock_users_popup () {
		blockedcontactspage = new BlockedContactsPage(driver);
		 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		 blockedcontactspage.check_Cancel_button_In_unblockusers_Popup();
		 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
	}
	
	
	/*
	Validate whether able to unblock the blocked contacts.
    */
	@Test(priority = 5)
	public void To_Validate_whether_able_to_unblock_the_blocked_contacts () {
		blockedcontactspage = new BlockedContactsPage(driver);
		 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		 blockedcontactspage.UnBlock_contact();
		  Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
		  
	}
	
	
	
	/*

	Validate whether able to unblock by multiselect the contacts in the blocked contacts screen.
	*/
	@Test(priority = 6)
	public void To_Validate_whether_able_to__Unblock_By_multiselect_the_contacts_in_blocked_contacts_screen() {
		blockedcontactspage = new BlockedContactsPage(driver);
		 Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
		 blockedcontactspage.click_Back_Arrow();
		 driver.navigate().back();
		 homepage = new HomePage(driver);
		 homepage.OpenNewChat();
		 newchatpage = new NewChatPage(driver);
		 newchatpage.Check_with_ValidId_2();
		 onetonechatpage = new OneToOneChatPage(driver);
		 onetonechatpage.Set_Values_In_Message_textbox("Hello");
		 onetonechatpage.click_Send_Button();

		 onetonechatpage.click_Back_Arrow();
		 
		 homepage.Block_First_Contact();
		 homepage.Block_Second_Contact();
		 homepage.clickMenuDrawer();
		 menupage = new MenuPage(driver);
		 menupage.click_Account_Settings();
		 accountsettingspage = new AccountSettingsPage(driver);
		 accountsettingspage.click_Blocked_contact_Option();
		 blockedcontactspage.UnBlock_By_Using_MultiSelect_option();
		 Assert.assertEquals(blockedcontactspage.Empty_Screen_content(), "No blocked contacts yet");
		 
	}
	



}
