package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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

public class Home_Screen_And_Functionalities_In_Create_Account_Flow extends baseClass {
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
	MyAccountPage myaccountpage;
	AccountSettingsPage accountsettingspage;
	BlockedContactsPage blockedcontactspage;
	SettingsPage settingspage;
	AccountSettingsPage accountSettingsPage;
	SeedPage seedpage;
	ClearDataPage cleardatapage;
	RestoreFromSeedPage restorefromseedpage;
	
	@Test(priority = 0,groups = {"Regression","Smoke"} )
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
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		
	}
		
	
//	/*
//	Validate the all possible navigation from the home screen in both forward and backward direction
//	Validate whether able to navigate to the device home page directly.
//	*/
//	@Test(priority = 1,groups = {"Regression","Smoke"} )
//	public void To_Validate_navigation_from_the_home_screen_in_both_forward_and_backward_direction () throws InterruptedException {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		driver.navigate().back();
//		 driver.navigate().back();
//		 if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
//			 landingpage.openApp();
//	}
//		 Assert.assertEquals(homepage.Pagetitle(),"Chats");	
//	}
//	
//
//	/*
//	Validate the working of home screen without internet connection
//	*/
//	@Test(priority = 2,groups = {"Regression","Smoke"} )
//	public void To_Validate_the_working_of_home_Screen_without_internet_connection () throws InterruptedException {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		turnOff_Mobile_Wifi();
//		Thread.sleep(5000);
//		try{
//			Assert.assertTrue(homepage.hops_Warning().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertTrue(homepage.hops_Warning().isDisplayed());
//		}
//		turnOn_Mobile_Wifi();
//		Thread.sleep(5000);
//	}
//
//	/*
//     Validate whether able to pin a particular group or person chat.
//     */
//    @Test(priority = 3,groups = {"Regression","Smoke"} )
//    public void To_Validate_whether_able_to_pin_particular_group_or_person_chat () throws InterruptedException {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.OpenNewChat();
//		newchatpage = new NewChatPage(driver);
//		newchatpage.Check_with_ValidId_1();
//		chatpage = new ChatPage(driver);
//		chatpage.Send_one_msg();
//		try{
//			homepage.OpenNewChat();
//		}
//		catch (NoSuchElementException e) {
//			driver.navigate().back();
//			homepage.OpenNewChat();
//		}
//		newchatpage.Check_with_ValidId_2();
//		chatpage.Send_one_msg();
//		String SecondId = homepage.get_Second_Id();
//		homepage.pin_The_chat();
//		Thread.sleep(1000);
//		Assert.assertEquals(SecondId, homepage.get_First_Id());
//		Assert.assertTrue(homepage.Element_of_pinIcon().isDisplayed());
//    }
//	
//	/*
//     Validate whether able to unpin a pinned particular group or person chat.
//     */
//    @Test(priority=4,groups = {"Regression","Smoke"})
//    public void To_Validate_whether_able_to_unpin_a_pinned_particular_group_or_personchat () {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		Assert.assertTrue(homepage.Element_of_pinIcon().isDisplayed());
//		String FirstId = homepage.get_First_Id();
//		homepage.Unpin_The_chat();		
//			Assert.assertEquals(FirstId, homepage.get_Second_Id());
//		
//    }
//    
//	
//	/*
//     Validate whether able to mute the notifications of the a particular group or person chat.
//    */
//    @Test(priority=5,groups = {"Regression","Smoke"})
//    public void To_Validate_whether_able_to_mute_notifications_of_particular_group_or_person_chat () {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.Mute_Notificaion_of_Chat();
//		Assert.assertTrue(homepage.Element_Mute_Icon().isDisplayed());
//    }
//    
//	
//	/*
//     Validate whether able to Unmute the notifications of the muted contacts.
//	*/
//    @Test(priority=6,groups = {"Regression","Smoke"})
//    public void To_Validate_whether_able_to_Unmute_notifications_of_muted_contacts () {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		Assert.assertTrue(homepage.Element_Mute_Icon().isDisplayed());
//		homepage.UnMute_Notificaion_of_Chat();
//		
//		}
//    
//    /*
//     Validate Whether able to block the chat
//     */
//    @Test(priority=7,groups = {"Regression","Smoke"})
//    public void To_Validate_Whether_able_to_block_the_chat () {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.Block_First_Contact();
//		homepage.open_FirstChat();
//		chatpage = new ChatPage(driver);
//		Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
//		chatpage.click_Back_Arrow();
//    }
//    
//    /*
//    Validate Whether able to Unblock the chat
//    */
//    @Test(priority=8,groups = {"Regression","Smoke"})
//    public void To_Validate_Whether_able_to_Unblock_the_chat () {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.UnBlock_First_Contact();
//		homepage.clickMenuDrawer();
//		menupage = new MenuPage(driver);
//		menupage.click_Account_Settings();
//		accountsettingspage = new AccountSettingsPage(driver);
//		accountsettingspage.click_Blocked_contact_Option();
//		blockedcontactspage = new  BlockedContactsPage(driver);
//		Assert.assertEquals(blockedcontactspage.Empty_Screen_content(),"No blocked contacts yet");
//		blockedcontactspage.click_Back_Arrow();
//		driver.navigate().back();
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		
//    }
//    
//    
//    /*
//     Validate whether able to delete the chats from chat history of the home screen 
//     */
//    @Test(priority=9,groups = {"Regression","Smoke"})
//    public void To_Validate_whether_able_to_delete_the_chats_from_chat_history_of_home_screen () {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		String FirstId = homepage.get_First_Id();
//		homepage.Delete_FirstContact();
//		try{
//			Assert.assertEquals(Toast(), "Conversation deleted");
//		}
//		catch (Exception e) {
//			Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		}
//		Assert.assertNotEquals(FirstId,homepage.get_DisplayName_Or_Id_Of_ChatItem());
//    
//    }
//
//
//    /*
//     Validate the working of the notification settings mention options in group chat
//     */
//    @Test(priority=10,groups = {"Regression"})
//    public void To_Validate_the_working_of_notification_settings_mention_options_in_group_chat () throws InterruptedException {
//    	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.openJoinSocialGroup();
//		socialgrouppage = new SocialGroupPage(driver);
//		try{
//			socialgrouppage.join_CryptoNews();
//		}
//		catch (NoSuchElementException e) {
//			socialgrouppage.join_CryptoNews();	
//		}
//		chatpage = new ChatPage(driver);
//		try{
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Crypto news");
//		}
//		catch (AssertionError e) {
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Crypto News");
//		}
//		chatpage.click_Back_Arrow();
//		Thread.sleep(5000);
//		try {
//		homepage.Set_Mention_option();
//		Assert.assertTrue(homepage.Element_Mention_Icon().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Thread.sleep(5000);
//			driver.navigate().back();
//			homepage.Set_Mention_option();
//			Assert.assertTrue(homepage.Element_Mention_Icon().isDisplayed());
//		}
//		}
//    
//    /*
//    Validate the working of the notification settings All options in group chat
//    To check whether mute icon and mention icon is displayed or not
//    */
//   @Test(priority=11,groups = {"Regression"})
//   public void To_Validate_the_working_of_notification_settings_All_options_in_group_chat () {
//   	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.Set_All_option();
//		try {
//		Assert.assertFalse(homepage.Element_Mention_Icon().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		}		
//		}
//
//
//   /*
//    Validate the Working of cancel button in All popup
//    */
//   @Test(priority=12,groups = {"Regression"})
//   public void To_Validate_the_Working_of_cancel_button_in_All_popup () {
//   	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.validate_Cancel_in_Block();
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.validate_Cancel_in_Delete();
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.validate_Cancel_in_NotificationSettings();
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//   }
//   
//   /*
//    Validate the working of Mark All As Read option.
//    */
//   @Test(priority=13,groups = {"Regression"})
//   public void To_Validate_the_working_of_Mark_All_As_Read_option () throws InterruptedException {
//	 	homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		Assert.assertTrue(homepage.Element_of_Unread_Msg_Count().isDisplayed());
//		homepage.Select_Mark_All_As_read();
//		try {
//			Thread.sleep(1000);
//		Assert.assertFalse(homepage.Element_of_Unread_Msg_Count().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		}
//   }
//
//   
//   /*
//    * 
//    * 
//    * 
//    * Archive and Unarchive function
//    * 
//    * 
//    */
//   
//	/*
//	Validate whether archived chats option is not showing when no chat is archived
//	*/
//	@Test(priority = 1)
//	public void To_Validate_whether_archived_chats_option_is_not_showing_when_no_chat_is_archived () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//	
//		try {
//			Assert.assertFalse(homepage.Element_of_archivedChats().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//		//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		}
//	}
//	
//
//	
//	/*
//	Validate whether able to archive all chats (one to one, secret group and social group) 
//	*/
//	@Test(priority = 2)
//	public void To_Validate_whether_able_to_archive_all_Kind_of_chats () {
//		homepage.openJoinSocialGroup();
//		socialgrouppage = new SocialGroupPage(driver);
//		socialgrouppage.join_BChat_Group();
//		driver.navigate().back();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		try {
//			homepage.ArchiveFirstChat();
//		}
//		catch (NoSuchElementException e) {
//			homepage.ArchiveFirstChat();
//		}
//		catch (StaleElementReferenceException e) {
//			homepage.ArchiveFirstChat();
//		}
//		//Secrete hroup
//	}
//	
//	
//	/*
//	Validate whether able to navigate back to home screen
//	*/
//	@Test(priority = 3)
//	public void To_Validate_whether_able_to_navigate_back_to_home_screen_From_archive_Screen () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.openArchivedChats();
//		Assert.assertEquals(homepage.archivedChatspageTitle(),"Archived Chats");
//		driver.navigate().back();
//	
//	}
//	
//	/*
//	Validate whether archived chats counts are showing correctly
//	*/
//	@Test(priority = 4)
//	public void To_Validate_whether_archived_chats_counts_are_showing_correctly () {
//		homepage = new HomePage(driver);
//	//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		
//		try{
//			Assert.assertEquals(homepage.archivedChatsCount(), 1);
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(homepage.archivedChatsCount(), 1);
//		}
//	}
//	
//	
//	/*
//	 Validate whether archived chats option is showing when chats are archived 
//	 */
//	@Test(priority = 5)
//	public void To_Validate_whether_archived_chats_option_is_showing_when_chats_are_archived () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		try{
//			Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
//		}
//	}
//	
//	
//	/*
//	Validate whether able to Unarchive the archived chats 
//	*/
//	@Test(priority = 6)
//	public void To_Validate_whether_able_to_Unarchive_the_archived_chats () {
//		homepage = new HomePage(driver);
//	//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.openArchivedChats();
//		//for(int i=0;i<2;i++) {
//			homepage.unarchivechats();
//		//}
//		
//	}
//	
//	/*
//	Validate whether working of the more option of the chats in the archived 
//	*/
//	@Test(priority=7)
//	public void To_Validate_whether_working_of_more_option_of_the_chats_in_the_archived () {
//		
//	}
//	
//	
//   /*
//	Validate whether able to search the archived chats  
//	*/
//	@Test(priority = 8)
//	public void To_Validate_whether_able_to_search_the_archived_chats () {
//		homepage = new HomePage(driver);
//		homepage.clickSearch();
//		homepage.enterValues("Hi");
//		Assert.assertTrue(homepage.Element_Messages().isDisplayed());
//		driver.navigate().back();
//		driver.navigate().back();
//	}
//	
//	/*
//	 Validate whether chats are not getting unarchived while sending messages 
//	 */
//	@Test(priority = 9)
//	public void To_Validate_whether_chats_are_not_getting_unarchived_while_sending_messages () {
//		homepage = new HomePage(driver);
//		homepage.openArchivedChats();
//		homepage.openFirstArchivedChat();
//		 chatpage = new ChatPage(driver);
//		 chatpage.Send_one_msg();
//		Assert.assertTrue( homepage.Element_of_archivedChats().isDisplayed());
//	}
//	
//	/*
//	 setup for restored account
//	 */
//	@Test(priority = 10)
//	public void setupFor_Restored_Account () throws InterruptedException {
//		
//		homepage = new HomePage(driver);
//		homepage.clickMenuDrawer();
//		menupage = new MenuPage(driver);
//		menupage.click_Account_Settings();
//		accountSettingsPage = new AccountSettingsPage(driver);
//	   accountSettingsPage.click_Clear_Data_option();
//	   cleardatapage = new ClearDataPage(driver);
//	   cleardatapage.click_ok();
//		//Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
//		cleardatapage.click_Clear_Or_delete_option();
//		landingpage = new LandingPage(driver);
//	try {	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
//		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
//	}
//	catch (NoSuchElementException e) {
//		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
//	}
//	catch (StaleElementReferenceException e) {
//		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
//	}
//	landingpage.clickSignIn();
//	   seedpage = new SeedPage(driver);
//		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
//		seedpage.EnterSeedValue("onward rotate ailments dozen sidekick slackens pioneer rising boss civilian audio opposite zero tsunami upper sample cuisine strained number humid sewage subtly sifting sushi boss");
//		seedpage.clickNext();
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//		restorefromseedpage.setDisplayName("Chris");
//		restorefromseedpage.setBlockheight("3200000");
//		
//	   	restorefromseedpage.clickBtnRestore();
//	   	createpasswordpage = new CreatePasswordPage(driver);
//	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//	   	createpasswordpage.setValidPassword();
//	   	Thread.sleep(2000);
//	   	createpasswordpage.clickOk();	
//	   	homepage = new HomePage(driver);
//	   try {
//		   homepage.click_DropDown();
//	   }
//	   catch (NoSuchElementException e) {
//		   homepage.click_DropDown();
//	}
//	   	homepage.click_first_request();
//	   	chatpage = new ChatPage(driver);
//	   	chatpage.Accept_request();
//	   	driver.navigate().back();
//	   	homepage.ArchiveFirstChat();
//	}
//	
//	/*
//	Validate whether chat is getting unarchive while doing the call
//	*/
//	@Test(priority = 11)
//	public void To_Validate_whether_chat_is_getting_unarchive_while_doing_the_call () {
//		homepage = new HomePage(driver);
//		homepage.openArchivedChats();
//		homepage.openFirstArchivedChat();
//		chatpage = new ChatPage(driver);
//		chatpage.click_Call_Icon();
//		chatpage.click_Settings_option();
//		settingspage = new SettingsPage(driver);
//		settingspage.scrollgesture_Using_text("Voice and video calls");
//		settingspage.click_Voice_Call();
//		settingspage.click_Enable();
//		driver.navigate().back();
//		chatpage.click_Call_Icon();
//		chatpage.end_Call();
//		driver.navigate().back();
//		try{
//			Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(), "Chris");
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(homepage.get_First_Id(), "Chris");
//		}
//		catch (AssertionError e) {
//			try{
//				Assert.assertEquals(homepage.get_First_Id(), "chris");
//			}
//			catch (NoSuchElementException e1) {
//				Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(), "chris");
//			}
//		}		
//		
//	}
//
//	/*
//	Validate whether able to archive and unarchive the chats without internet connection
//	*/
//	@Test(priority = 12)
//	public void To_Validate_whether_able_to_archive_and_unarchive_the_chats_without_internet_connection () throws InterruptedException {
//		homepage = new HomePage(driver);
//	Assert.assertEquals(homepage.Pagetitle(),"Chats");
//	   homepage.openNewSecretGroup();
//	   secretgrouppage = new SecretGroupPage(driver);
//	   secretgrouppage.select_FirstContact_In_List();
//	   secretgrouppage.Enter_values_in_GroupName("Grp");
//	   secretgrouppage.click_Create_button();
//	   secretgrouppage.click_Back_Arrow();
//	   turnOff_Mobile_Wifi();
//	   homepage.ArchiveFirstChat();
//	   try{
//		   Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
//	   }
//	   catch (NoSuchElementException e) {
//		   Assert.assertTrue(homepage.Element_of_archivedChats().isDisplayed());
//	}
//	   
//	}
// 
//      /*
//       * 
//       * 
//       *  Search Screen and its funtionalities 
//       * 
//       * 
//       * 
//       */
//
//	
//	
//	/*
//	Validate the presence of placeholder in the text box.
//	*/
//	@Test(priority = 13,groups = {"Regression"} )
//	public void To_Validate_the_presence_of_placeholder_in_the_text_box () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		Assert.assertEquals(homepage.SearchPlaceholder(), "Search people and groups");
//	}
//	
//	
//	/*
//	Validate whether crusher blink on clicking the text box of search functionality.
//	*/
//	@Test(priority =14,groups = {"Regression"})
//	public void To_Validate_Whether_crusor_Blinks_on_clicking_the_search_textbox () {
//		homepage = new HomePage(driver);
//		homepage.clickSearch();
//	   Assert.assertTrue(homepage.visblity_of_crusor());
//	   Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//	}
//	
//	/*
//	validate whether paste option is working on the text box.
//	*/
//	@Test(priority=15,groups = {"Regression"})
//	public void To_Validate_wether_paste_option_on_the_text_box () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.pastevalues("hello");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"hello");
//		homepage.clearTextBox();
//	}
//	
//	
//	
//	/*
//	Validate whether the value entered in the text box is editable.
//	Validate whether the value entered in the text box is delete able.
//	*/
//	@Test(priority = 16,groups = {"Regression"})
//	public void To_Validate_Values_enterd_in_textbox_is_editable_and_deleteable () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.enterValues("text");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"text");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//		homepage.enterValues("Check");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"Check");
//		homepage.clearTextBox();
//		
//	}
//	
//	/*
//	 validate the working of the cancel icon inside the text box
//	 */
//	@Test(priority = 17,groups = {"Regression"})
//	public void To_validate_working_of_cnacel_icon_inside_the_textbox () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.enterValues("text");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//	}
//	
//	
//	/*
//	Validate the text box of the search Functionality using special Characters.
//	*/
//	@Test(priority = 18,groups = {"Regression"})
//	public void To_Validate_the_textbox_of_the_search_Functionality_using_special_Characters () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.enterValues("@#$%");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"@#$%");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//	}
//	
//	/*
//	Validate the text box of the search Functionality using Alphabets both in uppercase and lower case.
//	*/
//	@Test(priority = 19,groups = {"Regression"})
//	public void To_Validate_the_textbox_of_search_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.enterValues("ABCDE");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"ABCDE");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//		homepage.enterValues("abcde");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"abcde");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//		
//	}
//	
//	
//	/*
//	Validate the text box of the search Functionality is Allowing the Space.
//	*/
//	@Test(priority = 20,groups = {"Regression"})
//	public void To_Validate_the_textbox_of_search_Functionality_is_Allowing_the_Space () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.enterValues("Hi Hello ok");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"Hi Hello ok");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//	}
//	
//	/*
//	Validate the text box of the search Functionality by numerical value.
//	*/
//	@Test(priority = 21,groups = {"Regression"})
//	public void To_Validate_the_textbox_of_search_Functionality_by_Numerical_values () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		homepage.enterValues("123456");
//		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"123456");
//		homepage.click_cancel_icon_inside_textbox();
//		Assert.assertTrue(homepage.visiblity_of_placeholder());
//	}
//	
//	
//	/*
//	Validate whether searched messages are showing in the list
//	*/
//	@Test(priority = 22,groups = {"Regression"})
//	public void To_Validate_whether_searched_messages_are_showing_in_the_list () {
//		homepage = new HomePage(driver);
//		try {
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//		}
//		catch (NoSuchElementException e) {
//			homepage.clickSearch();
//		}
//		try {
//		homepage.enterValues("Hii");
//		Assert.assertTrue(homepage.Element_Messages().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			homepage.enterValues("Hello");
//			Assert.assertTrue(homepage.Element_Messages().isDisplayed());		
//		}
//		homepage.clearTextBox();
//	}
//	
//	/*
//	Validate the search functionality using Invalid value 
//	*/
//	@Test(priority = 23,groups = {"Regression"})
//	public void To_Validate_the_search_functionality_using_Invalid_value () {
//	homepage = new HomePage(driver);
//	Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//	try {
//	homepage.enterValues("asdfghjkl");
//	Assert.assertTrue(homepage.Element_Messages().isDisplayed());
//	}
//	catch (NoSuchElementException e) {
//		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
//	}
//	homepage.clearTextBox();
//	}
	
	
	/*
	 * 
	 * 
	 * Note To Self Screen
	 * 
	 * 
	 */
	
	
	/*
	Validate the text box of the Messaging Functionality using special Characters.
	*/
	@Test(priority = 24,groups = {"Regression"})
	public void To_Validate_the_textbox_of_the_Messaging_Functionality_using_special_Characters () {
		homepage = new HomePage(driver);
		homepage.click_Option_Note_To_Myself();
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		chatpage.Set_Values_In_Message_textbox("!@#$$%&");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value().trim(),"!@#$$%&");
		
	}
	
	/*
	Validate the working of cancel button in the delete popup 
	 */
	@Test(priority = 25,groups = {"Regression"})
	public void To_Validate_the_working_of_cancel_button_in_delete_popup () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.delete_second_message();
		
		try{
			chatpage.click_Cancel_in_popup();
		}
		catch (NoSuchElementException e) {
	     chatpage.click_cancel_in_delete_for_me();
		}
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	/*
	 * Validate Whether able to delete the send message	
	 */
	@Test(priority =26,groups = {"Regression"})
	public void To_Validate_Whether_able_to_delete_the_send_message () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.delete_second_message();
		try {
			chatpage.click_DeleteForMe();
				}
				catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
				}
		
		
	}
	
	/*
	Validate the text box of the Messaging Functionality using Alphabets both in uppercase and lower case.
	
	*/
	@Test(priority = 27,groups = {"Regression"})
	public void To_Validate_the_textbox_of_Messaging_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("ABCDEFGH");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value().trim(),"ABCDEFGH");
		chatpage.delete_second_message();
		try {
	chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
	chatpage.click_delete_In_Popup();
		}
		chatpage.Set_Values_In_Message_textbox("abcdefg");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value().trim(),"abcdefg");
		chatpage.delete_second_message();
		try {
		chatpage.click_delete_In_Popup();
		}
		catch (NoSuchElementException e) {
			chatpage.click_DeleteForMe();
		}
	}
	
	/*
	Validate the text box of the Messaging Functionality is Allowing the Space in between the value.
	*/
	@Test(priority = 28,groups = {"Regression"})
	public void To_Validate_the_textbox_of_Messaging_Functionality_is_Allowing_the_Space_in_between_the_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("hi hello how are you");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(),"hi hello how are you             ");
		chatpage.delete_second_message();
		try {
				chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
	chatpage.click_delete_In_Popup();
		}
	}
	
	/*
	Validate the text box of the Messaging Functionality by numerical value.
	*/
	@Test(priority = 29,groups = {"Regression"})
	public void To_Validate_the_textbox_of_Messaging_Functionality_by_numerical_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("12346789");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value().trim(),"12346789");
		chatpage.delete_second_message();
		try {
	chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
		chatpage.click_delete_In_Popup();
		}
	}
	
	
	/*
	Validate whether the value entered in the text box of Message functionality is editable and deleteable.
	*/
	@Test(priority = 30,groups = {"Regression"})
	public void To_Validate_whether_the_value_entered_in_textbox_of_Message_functionality_is_editable_and_deleteable () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("Hii");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hii");
		chatpage.clear_textBox();
		chatpage.Set_Values_In_Message_textbox("Hello");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
		chatpage.clear_textBox();
	}
	
	
	/*
	Validate the presence of placeholder in the text box of Message functionality.
	*/
	@Test(priority = 31,groups = {"Regression"})
	public void To_Validate_the_presence_of_placeholder_in_textbox_of_Message_functionality () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message....");
		
	}
	
	
	/*
	Validate whether crusher blink on clicking the text box of Message functionality.
	*/
	@Test(priority = 32,groups = {"Regression"})
	public void To_Validate_whether_crusher_blink_on_clicking_the_textbox_of_Message_functionality () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.click_Textbox();
		Assert.assertTrue(chatpage.activeElement().isDisplayed());
	}
		
	/*
	Validate whether able enter a lengthy value in the text box Message functionality.
	*/
	@Test(priority = 33,groups = {"Regression"})
	public void To_Validate_whether_able_enter_a_lengthy_value_in_textbox_Message_functionality () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("Hii hello are you there to here that in the message and ok then now its ok mm hmm ok ");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.SendMessageCard().isDisplayed());
		try{
			chatpage.delete_second_message();
			chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
		}
	}
	/*
	validate whether paste option is working on the text box Note to myself functionality.
	*/
	@Test(priority =34,groups = {"Regression"})
	public void To_validate_whether_paste_option_is_working_on_the_textbox_Note_to_myself_functionality () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.paste_values("Hello");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		try{
			chatpage.delete_second_message();
			chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
		}
		
	}
	
	  
	/*
	Validate All media screen when empty
	*/
	@Test(priority = 35,groups = {"Regression"})
	public void To_Validate_All_media_screen_when_empty () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.open_AllMedia();
		Assert.assertEquals(chatpage.AllMedia_screen_Title(), "All Media");
		Assert.assertTrue(chatpage.Element_of_Empty_media_Screen().isDisplayed());
		driver.navigate().back();
	}
	

	/*
	Validate the search option with valid value
	*/
	@Test(priority = 36,groups = {"Regression"})
	public void To_Validate_the_search_option_with_valid_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");	
		chatpage.Enter_Values_In_Search_Textbox("Hii");
		Assert.assertTrue(chatpage.Element_Down_arrow().isDisplayed());
		chatpage.click_CloseIcon_Search();
	}
	
	/*
	validate the search option with invalid value
	*/
	@Test(priority = 37,groups = {"Regression"})
	public void To_validate_the_search_option_with_invalid_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Enter_Values_In_Search_Textbox("check");
		Assert.assertEquals(chatpage.Content_No_Matches_found(), "No Matches found!");
		chatpage.click_CloseIcon_Search();
	}
	
	/*
	 Validate the working of cancel button in Add to home screen popup
	 */
	@Test(priority = 38,groups = {"Regression"})
	public void To_Validate_the_working_of_cancel_button_in_Add_to_home_screen_popup () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Check_Cancel_button_in_AddToHome_Screen();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	 
	/*
	Validate the working of Add to home screen shortcut
	*/
	@Test(priority = 39,groups = {"Regression"})
	public void To_Validate_the_working_of_Add_To_home_screen () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Click_Add_In_Add_To_HomeScreen();
		chatpage.click_Back_Arrow();
		driver.navigate().back();
		//chatpage.click_ShortCut_icon_of_Note_to_Self();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	
	/*
	Validate the working of copy text option
	*/
	@Test(priority = 40,groups = {"Regression"})
	public void To_Validate_the_working_of_copy_text_option () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.check_Copy_text_option();
		try {
		Assert.assertEquals(Toast(), "Copied to clipboard");
		}
		catch (NoSuchElementException e) {
			chatpage.check_Copy_text_option();
			Assert.assertEquals(Toast(), "Copied to clipboard");
		}
		catch (StaleElementReferenceException e) {
			chatpage.check_Copy_text_option();
			Assert.assertEquals(Toast(), "Copied to clipboard");
		}
		}
	
	/*
	Validate the navigation to the message details screen
	*/
	@Test(priority = 41,groups = {"Regression"})
	public void To_Validate_the_navigation_to_message_details_screen () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.open_Message_details_Screen();
		Assert.assertEquals(chatpage.Message_Detials_screen_Title(),"Message Details");
		driver.navigate().back();
	}
	
	/*
	Validate whether able to un select the selected message
	*/
	@Test(priority = 42,groups = {"Regression"})
	public void To_Validate_whether_able_to_unselect_the_selected_message () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.unselect_the_message();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	
	/*
	Validate the working of the record option
	*/
	@Test(priority = 43,groups = {"Regression"})
	public void To_Validate_the_working_of_record_option () throws InterruptedException {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Record_Voice_Msg();
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}
	
	
	/*
	Validate whether able to share the files,photos in the note to myself
	*/
	@Test(priority = 44,groups = {"Regression"})
	public void To_Validate_whether_able_to_share_the_files_photos_in_the_note_to_myself () throws InterruptedException {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Send_image();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}
	
	/*
	validate the all media with image
	*/
	@Test(priority = 45,groups = {"Regression"})
	public void To_validate_the_all_media_with_image () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.open_AllMedia();
		Assert.assertEquals(chatpage.AllMedia_screen_Title(), "All Media");
		Assert.assertTrue(chatpage.Element_of_Media_file().isDisplayed());		
			driver.navigate().back();
		
	}
   
}
