package Bchat.TestScenarios;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.BlockedContactsPage;
import POM.ChatPage;
import POM.ClearDataPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.LandingPage;
import POM.MenuPage;
import POM.MyAccountPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SettingsPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class ArchivedChats_and_its_Funtionality extends baseClass {

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
	ChatPage chatpage;
    SettingsPage settingspage;
	AccountSettingsPage accountSettingsPage;
    SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
    ClearDataPage cleardatapage;
    
	@Test(priority = 0)
	public void preSetup() throws InterruptedException {
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
		Thread.sleep(2000);
		try{
			homepage= new HomePage(driver);
		}
		catch (Exception e) {
			homepage= new HomePage(driver);
		}
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.OpenNewChat();
		newchatpage = new NewChatPage(driver);
		newchatpage.Check_with_ValidId_2();
		chatpage = new ChatPage(driver);
		chatpage.Send_one_msg();
	}

	
	
	/*
	Validate whether archived chats option is not showing when no chat is archived
	*/
	@Test(priority = 1)
	public void To_Validate_whether_archived_chats_option_is_not_showing_when_no_chat_is_archived () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
	
		try {
			Assert.assertFalse(homepage.Element_of_archivedChats().isDisplayed());
		}
		catch (NoSuchElementException e) {
		//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
		}
	}
	

	
	/*
	Validate whether able to archive all chats (one to one, secret group and social group) 
	*/
	@Test(priority = 2)
	public void To_Validate_whether_able_to_archive_all_Kind_of_chats () {
		homepage.openJoinSocialGroup();
		socialgrouppage = new SocialGroupPage(driver);
		socialgrouppage.join_Bchat_Group();
		driver.navigate().back();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		try {
			homepage.ArchiveFirstChat();
		}
		catch (NoSuchElementException e) {
			homepage.ArchiveFirstChat();
		}
		catch (StaleElementReferenceException e) {
			homepage.ArchiveFirstChat();
		}
		//Secrete hroup
	}
	
	
	/*
	Validate whether able to navigate back to home screen
	*/
	@Test(priority = 3)
	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.openArchivedChats();
		Assert.assertEquals(homepage.archivedChatspageTitle(),"Archived Chats");
		driver.navigate().back();
	
	}
	
	/*
	Validate whether archived chats counts are showing correctly
	*/
	@Test(priority = 4)
	public void To_Validate_whether_archived_chats_counts_are_showing_correctly () {
		homepage = new HomePage(driver);
	//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
		
		try{
			Assert.assertEquals(homepage.archivedChatsCount(), 1);
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(homepage.archivedChatsCount(), 1);
		}
	}
	
	
	/*
	 Validate whether archived chats option is showing when chats are archived 
	 */
	@Test(priority = 5)
	public void To_Validate_whether_archived_chats_option_is_showing_when_chats_are_archived () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		try{
			Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
		}
	}
	
	
	/*
	Validate whether able to Unarchive the archived chats 
	*/
	@Test(priority = 6)
	public void To_Validate_whether_able_to_Unarchive_the_archived_chats () {
		homepage = new HomePage(driver);
	//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.openArchivedChats();
		//for(int i=0;i<2;i++) {
			homepage.unarchivechats();
		//}
		
	}
	
	/*
	Validate whether working of the more option of the chats in the archived 
	*/
	@Test(priority=7)
	public void To_Validate_whether_working_of_more_option_of_the_chats_in_the_archived () {
		
	}
	
	
    /*
	Validate whether able to search the archived chats  
	*/
	@Test(priority = 8)
	public void To_Validate_whether_able_to_search_the_archived_chats () {
		homepage = new HomePage(driver);
		homepage.clickSearch();
		homepage.enterValues("Hi");
		Assert.assertTrue(homepage.Element_Messages().isDisplayed());
		driver.navigate().back();
		driver.navigate().back();
	}
	
	/*
	 Validate whether chats are not getting unarchived while sending messages 
	 */
	@Test(priority = 9)
	public void To_Validate_whether_chats_are_not_getting_unarchived_while_sending_messages () {
		homepage = new HomePage(driver);
		homepage.openArchivedChats();
		homepage.openFirstArchivedChat();
		 chatpage = new ChatPage(driver);
		 chatpage.Send_one_msg();
		Assert.assertTrue( homepage.Element_of_archivedChats().isDisplayed());
	}
	
	/*
	 setup for restored account
	 */
	@Test(priority = 10)
	public void setupFor_Restored_Account () throws InterruptedException {
		
		homepage = new HomePage(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
		accountSettingsPage = new AccountSettingsPage(driver);
	   accountSettingsPage.click_Clear_Data_option();
	   cleardatapage = new ClearDataPage(driver);
	   cleardatapage.click_ok();
		//Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
		cleardatapage.click_Clear_Or_delete_option();
		landingpage = new LandingPage(driver);
	try {	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
	}
	catch (NoSuchElementException e) {
		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
	}
	catch (StaleElementReferenceException e) {
		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
	}
	landingpage.clickSignIn();
	   seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.EnterSeedValue("onward rotate ailments dozen sidekick slackens pioneer rising boss civilian audio opposite zero tsunami upper sample cuisine strained number humid sewage subtly sifting sushi boss");
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.setDisplayName("Chris");
		restorefromseedpage.setBlockheight("3200000");
		
	   	restorefromseedpage.clickBtnRestore();
	   	createpasswordpage = new CreatePasswordPage(driver);
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	createpasswordpage.setValidPassword();
	   	Thread.sleep(2000);
	   	createpasswordpage.clickOk();	
	   	homepage = new HomePage(driver);
	   try {
		   homepage.click_DropDown();
	   }
	   catch (NoSuchElementException e) {
		   homepage.click_DropDown();
	}
	   	homepage.click_first_request();
	   	chatpage = new ChatPage(driver);
	   	chatpage.Accept_request();
	   	driver.navigate().back();
	   	homepage.ArchiveFirstChat();
	}
	
	/*
	Validate whether chat is getting unarchive while doing the call
	*/
	@Test(priority = 11)
	public void To_Validate_whether_chat_is_getting_unarchive_while_doing_the_call () {
		homepage = new HomePage(driver);
		homepage.openArchivedChats();
		homepage.openFirstArchivedChat();
		chatpage = new ChatPage(driver);
		chatpage.click_Call_Icon();
		chatpage.click_Settings_option();
		settingspage = new SettingsPage(driver);
		settingspage.scrollgesture_Using_text("Voice and video calls");
		settingspage.click_Voice_Call();
		settingspage.click_Enable();
		driver.navigate().back();
		chatpage.click_Call_Icon();
		chatpage.end_Call();
		driver.navigate().back();
		try{
			Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(), "Chris");
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(homepage.get_First_Id(), "Chris");
		}
		catch (AssertionError e) {
			try{
				Assert.assertEquals(homepage.get_First_Id(), "chris");
			}
			catch (NoSuchElementException e1) {
				Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(), "chris");
			}
		}		
		
	}

	/*
	Validate whether able to archive and unarchive the chats without internet connection
	*/
	@Test(priority = 12)
	public void To_Validate_whether_able_to_archive_and_unarchive_the_chats_without_internet_connection () throws InterruptedException {
		homepage = new HomePage(driver);
	Assert.assertEquals(homepage.Pagetitle(),"Chats");
	   homepage.openNewSecretGroup();
	   secretgrouppage = new SecretGroupPage(driver);
	   secretgrouppage.select_FirstContact_In_List();
	   secretgrouppage.Enter_values_in_GroupName("Grp");
	   secretgrouppage.click_Create_button();
	   secretgrouppage.click_Back_Arrow();
	   turnOff_Mobile_Wifi();
	   homepage.ArchiveFirstChat();
	   try{
		   Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
	   }
	   catch (NoSuchElementException e) {
		   Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
	}
	   
	}
	
	
}
