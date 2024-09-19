package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Note_To_Self_Screen_And_its_Functionalities extends baseClass {
	
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
	/*
	 pre setup
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
		Thread.sleep(2000);
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	   homepage.open_Note_to_Myself();
	
	}
	
	
	
	
//	/*
//	Validate the text box of the Messaging Functionality using special Characters.
//	*/
//	@Test(priority = 1)
//	public void To_Validate_the_textbox_of_the_Messaging_Functionality_using_special_Characters () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("!@#$$%&");
//		chatpage.click_Send_Button();
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"!@#$$%&");
//		
//	}
//	
//	/*
//	Validate the working of cancel button in the delete popup 
//	 */
//	@Test(priority = 2)
//	public void To_Validate_the_working_of_cancel_button_in_delete_popup () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"!@#$$%&");
//		chatpage.delete_Send_Message();
//		
//		try{
//			chatpage.click_Cancel_in_popup();
//		}
//		catch (NoSuchElementException e) {
//	     //
//		}
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"!@#$$%&");
//	}
//	
//	
//	/*
//	 Validate Whether able to delete the send message
//	 */
//	@Test(priority = 3)
//	public void To_Validate_Whether_able_to_delete_the_send_message () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"!@#$$%&");
//		chatpage.delete_Send_Message();
//		try {
//	chatpage.click_DeleteForMe();
//		}
//		catch (NoSuchElementException e) {
//					chatpage.click_delete_In_Popup();
//		}
//		try {
//		Assert.assertFalse(chatpage.SendMessageCard().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");	
//		}
//	}
//	
//	/*
//	Validate the text box of the Messaging functionality is allowing null value.
//	*/
//	@Test(priority = 4)
//	public void To_Validate_the_textbox_of_Messaging_functionality_is_allowing_null_value () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("  ");
//		chatpage.click_Send_Button();
//		try {
//		Assert.assertFalse(chatpage.SendMessageCard().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		}
//	}
//
//	
//	
//	/*
//	Validate the text box of the Messaging Functionality using Alphabets both in uppercase and lower case.
//	*/
//	@Test(priority = 5)
//	public void To_Validate_the_textbox_of_Messaging_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("ABCDEFGH");
//		chatpage.click_Send_Button();
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"ABCDEFGH");
//		chatpage.delete_Send_Message();
//		try {
//	chatpage.click_DeleteForMe();
//		}
//		catch (NoSuchElementException e) {
//	chatpage.click_delete_In_Popup();
//		}
//		chatpage.Set_Values_In_Message_textbox("abcdefg");
//		chatpage.click_Send_Button();
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"abcdefg");
//		chatpage.delete_Send_Message();
//		try {
//		chatpage.click_delete_In_Popup();
//		}
//		catch (NoSuchElementException e) {
//			chatpage.click_DeleteForMe();
//		}
//	}
//	
//	/*
//	Validate the text box of the Messaging Functionality is Allowing the Space in between the value.
//	*/
//	@Test(priority = 6)
//	public void To_Validate_the_textbox_of_Messaging_Functionality_is_Allowing_the_Space_in_between_the_value () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("hi hello how are you");
//		chatpage.click_Send_Button();
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"hi hello how are you");
//		chatpage.delete_Send_Message();
//		try {
//				chatpage.click_DeleteForMe();
//		}
//		catch (NoSuchElementException e) {
//	chatpage.click_delete_In_Popup();
//		}
//	}
//	
//	/*
//	Validate the text box of the Messaging Functionality by numerical value.
//	*/
//	@Test(priority = 7)
//	public void To_Validate_the_textbox_of_Messaging_Functionality_by_numerical_value () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("12346789");
//		chatpage.click_Send_Button();
//		Assert.assertEquals(chatpage.get_Send_Message_Value(),"12346789");
//		chatpage.delete_Send_Message();
//		try {
//	chatpage.click_DeleteForMe();
//		}
//		catch (NoSuchElementException e) {
//		chatpage.click_delete_In_Popup();
//		}
//	}
//	
//	
//	/*
//	Validate whether the value entered in the text box of Message functionality is editable and deleteable.
//	*/
//	@Test(priority = 8)
//	public void To_Validate_whether_the_value_entered_in_textbox_of_Message_functionality_is_editable_and_deleteable () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("Hii");
//		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hii");
//		chatpage.clear_textBox();
//		chatpage.Set_Values_In_Message_textbox("Hello");
//		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
//		chatpage.clear_textBox();
//	}
//	
//	
//	/*
//	Validate the presence of placeholder in the text box of Message functionality.
//	*/
//	@Test(priority = 9)
//	public void To_Validate_the_presence_of_placeholder_in_textbox_of_Message_functionality () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message....");
//		
//	}
//	
//	
//	/*
//	Validate whether crusher blink on clicking the text box of Message functionality.
//	*/
//	@Test(priority = 10)
//	public void To_Validate_whether_crusher_blink_on_clicking_the_textbox_of_Message_functionality () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.click_Textbox();
//		Assert.assertTrue(chatpage.activeElement().isDisplayed());
//	}
//		
//	/*
//	Validate whether able enter a lengthy value in the text box Message functionality.
//	*/
//	@Test(priority = 11)
//	public void To_Validate_whether_able_enter_a_lengthy_value_in_textbox_Message_functionality () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Set_Values_In_Message_textbox("Hii hello are you there to here that in the message and ok then now its ok mm hmm ok ");
//		chatpage.click_Send_Button();
//		Assert.assertTrue(chatpage.SendMessageCard().isDisplayed());
//		try{
//			chatpage.delete_Send_Message();
//			chatpage.click_DeleteForMe();
//		}
//		catch (NoSuchElementException e) {
//			chatpage.click_delete_In_Popup();
//		}
//	}
//	/*
//	validate whether paste option is working on the text box Note to myself functionality.
//	*/
//	@Test(priority = 12)
//	public void To_validate_whether_paste_option_is_working_on_the_textbox_Note_to_myself_functionality () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.paste_values("Hello");
//		chatpage.click_Send_Button();
//		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
//		try{
//			chatpage.delete_Send_Message();
//			chatpage.click_DeleteForMe();
//		}
//		catch (NoSuchElementException e) {
//			chatpage.click_delete_In_Popup();
//		}
//		
//	}
//	
	  
	/*
	Validate All media screen when empty
	*/
	@Test(priority = 13)
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
	@Test(priority = 14)
	public void To_Validate_the_search_option_with_valid_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		chatpage.Enter_Values_In_Search_Textbox("Hii");
		Assert.assertTrue(chatpage.Element_Down_arrow().isDisplayed());
		chatpage.click_CloseIcon_Search();
	}
	
	/*
	validate the search option with invalid value
	*/
	@Test(priority = 15)
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
	@Test(priority = 16)
	public void To_Validate_the_working_of_cancel_button_in_Add_to_home_screen_popup () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Check_Cancel_button_in_AddToHome_Screen();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	 
	/*
	Validate the working of Add to home screen shortcut
	*/
	@Test(priority = 17)
	public void To_Validate_the_working_of_Add_To_home_screen () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Click_Add_In_Add_To_HomeScreen();
		chatpage.click_Back_Arrow();
		driver.navigate().back();
		chatpage.click_ShortCut_icon();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	
	/*
	Validate the working of copy text option
	*/
	@Test(priority = 18)
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
	@Test(priority = 19)
	public void To_Validate_the_navigation_to_message_details_screen () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.open_Message_details_Screen();
		Assert.assertEquals(chatpage.Message_Detials_screen_Title(),"Message details");
		driver.navigate().back();
	}
	
	/*
	Validate whether able to un select the selected message
	*/
	@Test(priority = 20)
	public void To_Validate_whether_able_to_unselect_the_selected_message () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.unselect_the_message();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	
	/*
	validate the working of reply option
	*/
	@Test(priority = 21)
	public void To_validate_the_working_of_reply_option () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Reply_to_Message("Hii");
		Assert.assertTrue(chatpage.replyCard().isDisplayed());
	}
	

//	
//	/*
//	Validate the working of the record option
//	*/
//	@Test(priority = 22)
//	public void To_Validate_the_working_of_record_option () {
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		chatpage.Record_Voice_Msg();
//		chatpage.click_Send_Button();
//		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
//		
//	}
	
	
	/*
	Validate whether able to share the files,photos in the note to myself
	*/
	@Test(priority = 23)
	public void To_Validate_whether_able_to_share_the_files_photos_in_the_note_to_myself () throws InterruptedException {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Send_image();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}
	
	/*
	validate the all media with image
	*/
	@Test(priority = 24)
	public void To_validate_the_all_media_with_image () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.open_AllMedia();
		Assert.assertEquals(chatpage.AllMedia_screen_Title(), "All Media");
		try {
		Assert.assertFalse(chatpage.Element_of_Empty_media_Screen().isDisplayed());
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
		}
	}
	
//	
//	/*
//	Validate the Message screen and  response without internet.
//	*/
//	@Test(priority = 25)
//	public void To_Validate_the_Message_screen_and_response_without_internet () throws InterruptedException
//	{
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
//		turnOff_Mobile_Wifi();
//		Thread.sleep(5000);
//		Assert.assertEquals(chatpage.get_internet_status(),"No connection");
//		chatpage.Set_Values_In_Message_textbox("Hii");
//		chatpage.click_Send_Button();
//		//Assertion need to done after get different id for delivery status
//		turnOn_Mobile_Wifi();
//		//wait.until(ExpectedConditions.invisibilityOf(chatpage.get_internet_status()));
//	}

	
    

}
