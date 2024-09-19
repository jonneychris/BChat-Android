package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.ChatPage;
import POM.ClearDataPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.LandingPage;
import POM.MenuPage;
import POM.MyWalletPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SettingsPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class OneToOne_Chat_Screen_And_its_functionalities extends baseClass{

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
	String bchatId;
	AccountSettingsPage accountSettingsPage;
	ClearDataPage cleardatapage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	SettingsPage settingspage;
	MyWalletPage mywalletpage;
	/*
	 pre Setup
	 */
	@Test(priority = 0, invocationCount = 2)
	public void PreSetup () throws InterruptedException {
		landingpage = new LandingPage(driver);
		try {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(landingpage.landingpage_Element().isDisplayed());
		landingpage.clickCreateAccount();
		}
		catch (NoSuchElementException e) {
			chatpage = new ChatPage(driver);
			chatpage.click_Back_Arrow();
			homepage = new HomePage(driver);
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_Account_Settings();
			accountSettingsPage = new AccountSettingsPage(driver);
		   accountSettingsPage.click_Clear_Data_option();
		   cleardatapage = new ClearDataPage(driver);
		   cleardatapage.click_ok();
		   cleardatapage.click_Clear_Or_delete_option();
		   landingpage.clickCreateAccount();
		}
		
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("test");
		displaynamepage.clickContinue();
		registerpage= new RegisterPage(driver);
		Thread.sleep(5000);
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
		homepage.OpenNewChat();
		newchatpage = new NewChatPage(driver);
		newchatpage.Check_with_ValidId_2();
		chatpage = new ChatPage(driver);
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		
	
	}
	
	
	/*
	Validate whether record option in the message functionality is enabled before message request got accepted
	*/
	@Test(priority = 1)
	public void To_Validate_whether_record_option_in_message_functionality_is_enabled_before_message_request_got_accepted () throws InterruptedException {
	
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		chatpage.Record_Voice_Msg();
		chatpage.click_Send_Button();
		try {
		Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		}		
	}
	
	
	/*
	Validate whether attachment option in the message functionality is enabled before message request got accepted
	*/
	@Test(priority = 2)
	public void To_Validate_whether_attachment_option_in_message_functionality_is_enabled_before_message_request_got_accepted () throws InterruptedException {
		
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		chatpage.click_Attachments();
	   try {
		   chatpage.Send_image();
	   }
	   catch (NoSuchElementException e) {
		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		   chatpage = new ChatPage(driver);
		   chatpage.Set_Values_In_Message_textbox("Hii");
		   chatpage.click_Send_Button();
			chatpage.click_Back_Arrow();
	   }
		
	}

	
	/*
	 Setup for clear data
	 */
	@Test(priority = 3)
	public void setup_for_clear_data () throws InterruptedException {
		
		driver.navigate().back();
		homepage = new HomePage(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
		accountSettingsPage = new AccountSettingsPage(driver);
	   accountSettingsPage.click_Clear_Data_option();
	   cleardatapage = new ClearDataPage(driver);
	   cleardatapage.click_ok();
		Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
		cleardatapage.click_Clear_Or_delete_option();
		landingpage = new LandingPage(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
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
	}
	
		
	/*
	 validate the working of message request drop down
	 */
	@Test(priority = 4,dependsOnMethods = "setup_for_clear_data")
	public void To_validate_the_working_of_message_request_drop_down () throws InterruptedException {
	   	homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.click_DropDown();
        homepage.click_first_request();
        chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
	}
	
	
	/*
	 validate the working of cancel button in all popup
	 */
	@Test(priority = 5)
	public void To_validate_the_working_of_cancel_button_in_all_popup () {
		   chatpage = new ChatPage(driver);
		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		   chatpage.click_cancel_In_accept();
		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		   chatpage.click_cancel_In_decline();
		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
	}
	
	
	/*
	 validate the working of the decline option
	 */
	@Test(priority = 6)
	public void To_validate_the_working_of_the_decline_option () {
		   chatpage = new ChatPage(driver);
		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		   chatpage.Decline_request();
		   homepage = new HomePage(driver);
		   Assert.assertEquals(homepage.Pagetitle(), "BChat");
	}
	
	
	/*
	 Validate whether text box is enable before accept the request
	 */
	@Test(priority =7)
	public void To_Validate_whether_textbox_is_enable_before_accept_the_request () {
		homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.click_DropDown();
        homepage.click_first_request();
		 chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		 chatpage.Set_Values_In_Message_textbox("Hii");
		 Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Hii");
		 chatpage.clear_textBox();
	}
	
	/*
	Validate whether attachments is enable before accept the request
	*/
	@Test(priority = 8)
	public void To_Validate_whether_attachments_is_enable_before_accept_the_request () {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		 chatpage.click_Attachments();
		 Assert.assertFalse(chatpage.Elements_of_Attachments().isDisplayed());
		 chatpage.click_Attachments();
	}
	
	/*
	Validate whether voice record is enable before accept the request
	*/
	@Test(priority = 9)
	public void To_Validate_whether_voice_record_is_enable_before_accept_the_request () throws InterruptedException {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		 chatpage.Record_Voice_Msg();
		 chatpage.delete_Voice_message();
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test"); 
	}
	
	/*
	Validate whether call icon showing before accept the request
	*/
	@Test(priority = 10)
	public void To_Validate_whether_call_icon_showing_before_accept_the_request () {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		 try {
			 Assert.assertFalse(chatpage.Element_of_call_Icon().isDisplayed());
		 }
		 catch (NoSuchElementException e) {
			 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		}
	}
	
	
	/*
	 validate the working of accept option
	 */
	@Test(priority = 11)
	public void To_validate_the_working_of_accept_option () {
		
		 chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		 chatpage.Accept_request();
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
	}
	
	/*
	Validate whether call icon showing After accept the request
	*/
	@Test(priority = 12)
	public void To_Validate_whether_call_icon_showing_After_accept_the_request () {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		 Assert.assertTrue(chatpage.Element_of_call_Icon().isDisplayed());
		 
	}

	
	
	/*
	 Validate the working of delete function while recording voice message
	 */
	@Test(priority = 13)
	public void To_Validate_the_working_of_delete_function_while_recording_voice_message () throws InterruptedException {
		
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		 chatpage.Record_Voice_Msg();
		 chatpage.delete_Voice_message();
	    try {
	    	Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
	    }
	    catch (NoSuchElementException e) {
	    	Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		}
	}
	
	/*
	Validate whether able to enable voice call using shortcut
	*/
	@Test(priority = 14)
	public void To_Validate_whether_able_to_enable_voice_call_using_shortcut () throws InterruptedException {
		
		
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.click_Call_Icon();
		chatpage.click_Settings_option();
		settingspage = new SettingsPage(driver);
		settingspage.scrollgesture_Using_text("Voice and video calls");
		settingspage.click_Voice_Call();
		settingspage.click_Enable();
		settingspage.click_Back_Arrow();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
	}
	
	
	/*
	 validate the working of the call icon
	 */
	@Test(priority = 15)
	public void To_validate_the_working_of_the_call_icon () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.click_Call_Icon();
		Assert.assertEquals(chatpage.callUI_page_title(), "Voice Call");
		chatpage.end_Call();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
	}
	
	/*
	Validate working of the Mute option in the menu bar
	*/
	@Test(priority = 16)
	public void To_Validate_working_of_Mute_option_in_the_menu_bar () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.Mute_Notification();
		Assert.assertTrue(chatpage.Element_of_Mute_Icon().isDisplayed());
		
	}

	/*
	 Validate the working of unmute option in the menu bar
	 */
	@Test(priority = 17)
	public void To_Validate_the_working_of_unmute_option_in_the_menu_bar () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.UnMute_Notification();
		try {
			Assert.assertFalse(chatpage.Element_of_Mute_Icon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		}
	}
	
	/*
	Validate the working of Block option in the menu bar () {
	*/
	@Test(priority = 18)
	public void To_Validate_the_working_of_Block_option_in_the_menu_bar () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.block_Contact();
		Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
		
	}
	
	
	/*
	 Validate whether message and call functionalities are enabled during contact is blocked 
	 */
	@Test(priority = 19)
	public void To_Validate_whether_message_and_call_functionalities_are_enabled_during_contact_is_blocked () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.click_Call_Icon();
		try {
		Assert.assertNotEquals(chatpage.callUI_page_title(), "Voice Call");
		chatpage.click_Cancel_in_popup();
		}
		catch (NoSuchElementException e) {
			chatpage.click_Cancel_in_popup();
			Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
		}
		try {
			chatpage.Set_Values_In_Message_textbox("Hi");
			chatpage.click_Send_Button();
			Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
		}
		catch (NoSuchElementException e) {
			chatpage.click_Cancel_in_popup();
			Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
		}
		}
	
	/*
	 Validate the working of unblock option in menu bar
	 */
	@Test(priority = 20)
	public void To_Validate_the_working_of_unblock_option_in_menu_bar () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.unblock_Contact();
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}	
	
	/*
	 
	 */
	@Test(priority = 21)
	public void To_Validate_Search_option_in_the_menu_bar_with_valid_value () {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		 chatpage.click_Moreoption();
		 chatpage.open_Search();
		 chatpage.Enter_Values_In_Search_Textbox("Hii");
			Assert.assertTrue(chatpage.Element_Down_arrow().isDisplayed());
			chatpage.click_CloseIcon_Search();
	}

	/*
	 
	 */
	@Test(priority = 22)
	public void To_Validate_Search_option_in_the_menu_bar_with_invalid_value () {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		// chatpage.click_Moreoption();
		 chatpage.open_Search();
		 chatpage.Enter_Values_In_Search_Textbox("check");
		 Assert.assertEquals(chatpage.Content_No_Matches_found(), "No Matches found!");
			chatpage.click_CloseIcon_Search();
	}
	
	/*
	Validate the working of the Add to home screen option in the menu bar.
	*/
	@Test(priority = 23)
	public void To_Validate_the_working_of_the_Add_To_home_screen_option_in_menu_bar () {
		chatpage = new ChatPage(driver);
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		 chatpage.click_Moreoption();
		chatpage.Click_Add_In_Add_To_HomeScreen();
		chatpage.click_Back_Arrow();
		driver.navigate().back();
		chatpage.click_ShortCut_icon();
		 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
	}
	
	/*
	Validate the working of the all media screen when empty
	*/
	@Test(priority = 24)
	public void To_Validate_All_media_screen_when_empty () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		chatpage.open_AllMedia();
		Assert.assertEquals(chatpage.AllMedia_screen_Title(), "All Media");
		Assert.assertTrue(chatpage.Element_of_Empty_media_Screen().isDisplayed());
		driver.navigate().back();
	}
	
	
	/*
	Validate Whether able to send  Alphabets both in uppercase and lower case.
	*/
	@Test(priority = 25)
	public void To_Validate_Whether_able_to_send_Alphabets_both_in_uppercase_and_lower_case () {
		chatpage = new ChatPage(driver);
		try {
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
		}
		catch (AssertionError e) {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
		}
		chatpage.Set_Values_In_Message_textbox("ABCDEFGH");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"ABCDEFGH");
		chatpage.delete_Send_Message();
		try {
	chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
	chatpage.click_delete_In_Popup();
		}
		chatpage.Set_Values_In_Message_textbox("abcdefg");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"abcdefg");
		
	}
	
	
	/*
	Validate the navigation to the message details screen
	*/
	@Test(priority = 26)
	public void To_Validate_the_navigation_to_message_details_screen () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.open_Message_details_Screen();
		Assert.assertEquals(chatpage.Message_Detials_screen_Title(),"Message details");
		driver.navigate().back();
		chatpage.delete_Send_Message();
		try {
	chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
	chatpage.click_delete_In_Popup();
		}
	}
	
	
	/*
	Validate Whether able to send special Characters.
	*/
	@Test(priority = 27)
	public void To_Validate_Whether_able_to_send_special_Characters () {
				chatpage = new ChatPage(driver);
				try {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
					}
					catch (AssertionError e) {
						Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
					}
		chatpage.Set_Values_In_Message_textbox("!@#$$%&");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"!@#$$%&");
	}
	
	
	/*
	 Validate the text box of the Messaging Functionality is Allowing the Space in between the value.
	 */
	@Test(priority = 28)
	public void To_Validate_the_textbox_of_Messaging_Functionality_is_Allowing_the_Space_in_between_the_value () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Set_Values_In_Message_textbox("hi hello how are you");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"hi hello how are you");
		chatpage.delete_Send_Message();
		try {
			chatpage.click_DeleteForMe();
		}
			
		catch (NoSuchElementException e) {
	          chatpage.click_delete_In_Popup();
		}
	}
	
	
	/*
	 Validate Whether able to send  numerical value.
	 */
	@Test(priority = 29)
	public void To_Validate_Whether_able_to_send_numerical_value () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Set_Values_In_Message_textbox("12346789");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"12346789");
		chatpage.delete_Send_Message();
		try {
	chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
		chatpage.click_delete_In_Popup();
		}
	}
	
	/*
	 * Validate the presence of placeholder in the text box of Message functionality.
	 */
	@Test(priority = 30)
	public void To_Validate_the_presence_of_placeholder_in_the_textbox_of_Message_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message....");
	}
	
	/*
	  Validate whether crusher blink on clicking the text box of Message functionality.
	 */
	@Test(priority = 31)
	public void To_Validate_whether_crusher_blink_on_clicking_the_textbox_of_Message_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.click_Textbox();
		Assert.assertTrue(chatpage.activeElement().isDisplayed());	
	}
	
	
	
	/*
	 * validate whether paste option is working on the text box Message functionality.
	 */
	@Test(priority = 32)
	public void To_validate_whether_paste_option_is_working_on_the_textbox_Message_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.paste_values("Hello");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		try{
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
		}	
	}
	
	/*
	 * Validate whether the value entered in the text box of Message functionality is editable and deleteable.
	 */
	@Test(priority = 33)
	public void To_Validate_whether_the_value_entered_in_textbox_of_Message_functionality_is_editable_and_deleteable () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Set_Values_In_Message_textbox("Hii");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hii");
		chatpage.clear_textBox();
		chatpage.Set_Values_In_Message_textbox("Hello");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
		chatpage.clear_textBox();
	}
	
	/*
	 *Validate whether able enter a lengthy value in the text box Message functionality.
	 */
	@Test(priority = 34)
	public void To_Validate_whether_able_enter_a_lengthy_value_in_textbox_Message_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Set_Values_In_Message_textbox("Hii hello are you there to here that in the message and ok then now its ok mm hmm ok ");
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.SendMessageCard().isDisplayed());
		try{
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
		}
	}
	
	
	
	
	/*
	 Validate the text box of the Messaging functionality is allowing null value.
	 */
	@Test(priority = 35)
	public void To_Validate_Whether_able_to_send_null_value (){
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Set_Values_In_Message_textbox("  ");
		chatpage.click_Send_Button();
		try {
		Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			chatpage.clear_textBox();
		}
	}
	
	/*
	 *Validate the Message Functionality response without internet.
	 */
	@Test(priority = 36)
	public void To_Validate_the_Message_Functionality_response_without_internet () throws InterruptedException {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		Assert.assertEquals(chatpage.get_internet_status(),"No connection");
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		//Assertion need to done after get different id for delivery status
		turnOn_Mobile_Wifi();
		//wait.until(ExpectedConditions.invisibilityOf(chatpage.get_internet_status()));
		try{
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
		}
	
	}
	
	/*
	 Validate whether able to delete both send and received messages in the chat screen	
	 */
	@Test(priority = 37)
	public void To_Validate_whether_able_to_delete_both_send_and_received_messages_in_the_chat_screen () {
		
	
		
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		 
		 try {
			 chatpage.delete_Send_And_Received_Message();
		 }
		 catch (NoSuchElementException e) {
			 driver.navigate().back();
			 try {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
					}
					catch (AssertionError e1) {
						Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
					}
		}
	}
	

	/*
	Validate whether the chat history present above message text box is deletable.
	*/
	@Test(priority = 38)
	public void To_Validate_whether_the_chat_history_present_above_message_textbox_is_deletable () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		
		 chatpage.delete_Received_Message();
		  chatpage.delete_Send_Message();
		  chatpage.click_DeleteForMe();
		
	}
	
	
	/*
	Validate the working of disappearing message in on condition.
	*/
	@Test(priority = 39)
	public void To_Validate_the_working_of_disappearing_message_in_on_condition () throws InterruptedException {
		
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		 chatpage.set_Disappearing_Message();
		 chatpage.Set_Values_In_Message_textbox("Hii");
		 chatpage.click_Send_Button();
		  try {
			     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 wait.until(ExpectedConditions.invisibilityOf(chatpage.Element_of_Timer_Animation()));				
	        	 Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
		 }
		 catch (NoSuchElementException e) {
			Assert.assertEquals(chatpage.content_DisappearingMessage(), "You set the disappearing message timer to 5 seconds");		
		}
	}
	
	/*
	validate the working of disappearing message in off condition.
	*/
	@Test(priority = 40)
	public void To_validate_the_working_of_disappearing_message_in_off_condition () throws InterruptedException {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		 chatpage.Disable_Disappearing_message();
		 chatpage.Set_Values_In_Message_textbox("Hii");
		 chatpage.click_Send_Button();
		 try {
			 Assert.assertFalse(chatpage.Element_of_Timer_Animation().isDisplayed());
		 }
		 catch (NoSuchElementException e) {
			 Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		}
	}

	/*
	Validate whether able to reply received message
	*/
	@Test(priority = 41)	
	public void To_Validate_whether_able_to_reply_received_message () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Reply_To_Received_Message();
		Assert.assertTrue(chatpage.replyCard().isDisplayed());
	}
		
	/*
	Validate whether able to share the files,photos.
	*/
	@Test(priority = 42)
	public void To_Validate_whether_able_to_share_the_files_photos_in_the_note_to_myself () throws InterruptedException {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Send_image();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}
	
	/*
	Validate the working of the record option
	*/
	@Test(priority = 43)
	public void To_Validate_the_working_of_record_option () throws InterruptedException {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Record_Voice_Msg();
		chatpage.click_Send_Button();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}
	
	/*
	validate the all media with image
	*/
	@Test(priority = 44)
	public void To_validate_the_all_media_with_image () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.open_AllMedia();
		Assert.assertEquals(chatpage.AllMedia_screen_Title(), "All Media");
		try {
		Assert.assertFalse(chatpage.Element_of_Empty_media_Screen().isDisplayed());
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
		}
	}
	
	/*
	validate whether able to enable pay as you chat using shortcut
	*/
	@Test(priority = 45)
	public void To_validate_whether_able_to_enable_pay_as_you_chat_using_shortcut () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
		mywalletpage.click_CheckBox();
		mywalletpage.click_Enable_Wallet();
        homepage.open_FirstChat();
        chatpage.enable_Pay_as_youChat();
        settingspage = new SettingsPage(driver);
        settingspage.click_PayAsYouChat();
        settingspage.Click_SetupPin();
        createpasswordpage = new CreatePasswordPage(driver);
        createpasswordpage.setValidPassword();
        createpasswordpage.clickOk();
        settingspage.click_PayAsYouChat();
        settingspage.click_Back_Arrow();
       chatpage.Set_Values_In_Message_textbox("1");
       Assert.assertTrue(chatpage.Btn_Slide_to_pay().isDisplayed());
        
        
	}

	/*
	validate whether able to disable pay as you chat using shortcut
	*/
	@Test(priority = 46)
	public void To_validate_whether_able_to_disable_pay_as_you_chat_using_shortcut () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.enable_Pay_as_youChat();
        settingspage = new SettingsPage(driver);
        settingspage.click_PayAsYouChat();
        settingspage.click_Back_Arrow();
      try {
        Assert.assertFalse(chatpage.Btn_Slide_to_pay().isDisplayed());
      }
      catch (NoSuchElementException e) {
		chatpage.clear_textBox();
	}
	}
	
	/*
	 *Validate whether able to download media 
	 */
	@Test(priority = 47)
	public void To_Validate_whether_able_to_download_media () throws InterruptedException {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		try {
		chatpage.Download_Image();
		Assert.assertEquals(Toast(), "Saved to media");
		}
		catch (NoSuchElementException e) {
			chatpage.Download_Image();
			Assert.assertEquals(Toast(), "Saved to media");		
		}
		catch (StaleElementReferenceException e) {
			chatpage.Download_Image();
			Assert.assertEquals(Toast(), "Saved to media");		
		}
	}
	
	/*
	 *Validate the working of the forward media files option
	 */
	@Test(priority = 48)
	public void To_Validate_the_working_of_the_forwarding_media_files_option () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Forward_Image();
		Assert.assertEquals(chatpage.Forward_page_title(),"Forward");
		driver.navigate().back();
		driver.navigate().back();
	}
	
	/*
	 Validate whether able to download voice Message 
	 */
	@Test(priority = 49)
	public void To_Validate_whether_able_to_download_voice_Message () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		try {
		chatpage.Download_VoiceMessage();
		Assert.assertEquals(Toast(), "Saved to media");
		}
		catch (NoSuchElementException e) {
			chatpage.Download_VoiceMessage();
			Assert.assertEquals(Toast(), "Saved to media");
		}
		catch (StaleElementReferenceException e) {
			chatpage.Download_VoiceMessage();
			Assert.assertEquals(Toast(), "Saved to media");
		}
		
		}

	/*
	 Validate Whether able to delete voice message and image
	 */
    @Test(priority = 50)
    public void To_Validate_Whether_able_to_delete_voice_message_and_image () {
    	chatpage = new ChatPage(driver);
    	try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"test");
			}
			catch (AssertionError e) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
			}
		chatpage.Delete_image_And_voiceMsg();
		
    }
}
