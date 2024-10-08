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
import POM.MyWalletPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SendPage;
import POM.SocialGroupPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class Search_Screen_and_Note_To_Self_functionalities extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	MenuPage menupage;
	WebDriverWait wait;
	ChatPage chatpage;
	DisplayNamePage displaynamepage;
	RegisterPage registerpage;
	
	
	/*
	 * 
	 *Global Search screen
	 * 
	 */
	
	
	/*
	 pre setup
	 */
	@Test(priority = 0,groups = {"Regression"} )
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
	  
	}
	
	
	/*
	Validate the presence of placeholder in the text box.
	*/
	@Test(priority = 2,groups = {"Regression"} )
	public void To_Validate_the_presence_of_placeholder_in_the_text_box () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertEquals(homepage.SearchPlaceholder(), "Search people and groups");
	}
	
	
//	/*
//	Validate whether crusher blink on clicking the text box of search functionality.
//	*/
//	@Test(priority =3,groups = {"Regression"})
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
//	@Test(priority=4,groups = {"Regression"})
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
//	@Test(priority = 5,groups = {"Regression"})
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
//	@Test(priority = 6,groups = {"Regression"})
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
//	@Test(priority = 7,groups = {"Regression"})
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
//	@Test(priority = 8,groups = {"Regression"})
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
//	@Test(priority = 9,groups = {"Regression"})
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
//	@Test(priority = 10,groups = {"Regression"})
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
//	@Test(priority = 11,groups = {"Regression"})
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
//	@Test(priority = 12,groups = {"Regression"})
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
	@Test(priority = 13,groups = {"Regression"})
	public void To_Validate_the_textbox_of_the_Messaging_Functionality_using_special_Characters () {
		homepage = new HomePage(driver);
		homepage.click_Option_Note_To_Myself();
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("Hii");
		chatpage.click_Send_Button();
		chatpage.Set_Values_In_Message_textbox("!@#$$%&");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(),"!@#$$%&");
		
	}
	
	/*
	Validate the working of cancel button in the delete popup 
	 */
	@Test(priority = 14,groups = {"Regression"})
	public void To_Validate_the_working_of_cancel_button_in_delete_popup () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.delete_second_message();
		
		try{
			chatpage.click_Cancel_in_popup();
		}
		catch (NoSuchElementException e) {
	     //
		}
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
		
	
	/*
	Validate the text box of the Messaging Functionality using Alphabets both in uppercase and lower case.
	Validate Whether able to delete the send message
	*/
	@Test(priority = 17,groups = {"Regression"})
	public void To_Validate_the_textbox_of_Messaging_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("ABCDEFGH");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(),"ABCDEFGH");
		chatpage.delete_second_message();
		try {
	chatpage.click_DeleteForMe();
		}
		catch (NoSuchElementException e) {
	chatpage.click_delete_In_Popup();
		}
		chatpage.Set_Values_In_Message_textbox("abcdefg");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(),"abcdefg");
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
	@Test(priority = 19,groups = {"Regression"})
	public void To_Validate_the_textbox_of_Messaging_Functionality_is_Allowing_the_Space_in_between_the_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("hi hello how are you");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(),"hi hello how are you");
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
	@Test(priority = 20,groups = {"Regression"})
	public void To_Validate_the_textbox_of_Messaging_Functionality_by_numerical_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Set_Values_In_Message_textbox("12346789");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(),"12346789");
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
	@Test(priority = 21,groups = {"Regression"})
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
	@Test(priority = 22,groups = {"Regression"})
	public void To_Validate_the_presence_of_placeholder_in_textbox_of_Message_functionality () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(),"Write a message....");
		
	}
	
	
	/*
	Validate whether crusher blink on clicking the text box of Message functionality.
	*/
	@Test(priority = 23,groups = {"Regression"})
	public void To_Validate_whether_crusher_blink_on_clicking_the_textbox_of_Message_functionality () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.click_Textbox();
		Assert.assertTrue(chatpage.activeElement().isDisplayed());
	}
		
	/*
	Validate whether able enter a lengthy value in the text box Message functionality.
	*/
	@Test(priority = 24,groups = {"Regression"})
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
	@Test(priority = 25,groups = {"Regression"})
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
	@Test(priority = 26,groups = {"Regression"})
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
	@Test(priority = 27,groups = {"Regression"})
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
	@Test(priority = 28,groups = {"Regression"})
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
	@Test(priority = 29,groups = {"Regression"})
	public void To_Validate_the_working_of_cancel_button_in_Add_to_home_screen_popup () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Check_Cancel_button_in_AddToHome_Screen();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	 
	/*
	Validate the working of Add to home screen shortcut
	*/
	@Test(priority = 30,groups = {"Regression"})
	public void To_Validate_the_working_of_Add_To_home_screen () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Click_Add_In_Add_To_HomeScreen();
		chatpage.click_Back_Arrow();
		driver.navigate().back();
		chatpage.click_ShortCut_icon_of_Note_to_Self();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	
	/*
	Validate the working of copy text option
	*/
	@Test(priority = 31,groups = {"Regression"})
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
	@Test(priority = 32,groups = {"Regression"})
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
	@Test(priority = 33,groups = {"Regression"})
	public void To_Validate_whether_able_to_unselect_the_selected_message () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.unselect_the_message();
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
	}
	
	
	/*
	Validate the working of the record option
	*/
	@Test(priority = 35,groups = {"Regression"})
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
	@Test(priority = 36,groups = {"Regression"})
	public void To_Validate_whether_able_to_share_the_files_photos_in_the_note_to_myself () throws InterruptedException {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.Send_image();
		Assert.assertTrue(chatpage.get_Message_Status().isDisplayed());
		
	}
	
	/*
	validate the all media with image
	*/
	@Test(priority = 37,groups = {"Regression"})
	public void To_validate_the_all_media_with_image () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Note to Self");
		chatpage.open_AllMedia();
		Assert.assertEquals(chatpage.AllMedia_screen_Title(), "All Media");
		Assert.assertTrue(chatpage.Element_of_Media_file().isDisplayed());		
			driver.navigate().back();
		
	}
	

	
	
	
	
}
