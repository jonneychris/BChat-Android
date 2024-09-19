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

import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import Utiles.baseClass;

public class ReportIssue_screen_And_its_functionalities extends baseClass{

	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	MenuPage menupage;
	WebDriverWait wait;
	ChatPage chatpage;
	
	/*
	 pre Setup to report screen
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
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_ReportIssue();
	}
	
	/*
	Validate whether able to navigate back to the home screen.
	*/
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		chatpage.click_Back_Arrow();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_ReportIssue();
		
	}
		
	/*
	Validate the text box of the Report Issue functionality is allowing null value.
	*/
	@Test(priority = 2)
	public void To_Validate_the_textbox_of_Report_Issue_functionality_is_allowing_null_value () {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		chatpage.Set_Values_In_Message_textbox(" ");
		try{
			chatpage.click_Send_Button();
		}
		catch( NoSuchElementException e)
		{
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		}
	}
	
	
	/*
	 Validate whether able to delete the send report
	 */
	@Test(priority = 3)
	public void To_Validate_whether_able_to_delete_the_send_report ()  {
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
		chatpage.Set_Values_In_Message_textbox("hello");
		chatpage.click_Send_Button();
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(chatpage.SendMessageCard()));
      try {
		chatpage.delete_Send_Message();
		chatpage.click_delete_In_Popup();
      }
      catch (NoSuchElementException e) {
		
		chatpage.click_DeleteForEveryone();
	}
		try {
			Assert.assertFalse(chatpage.SendMessageCard().isDisplayed());
		}
		catch (NoSuchElementException e) {
			try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e2) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		}
		catch (StaleElementReferenceException e) {
			try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		}
	}
	/*
	Validate the text box of the Report Issue Functionality using special Characters.
	*/
	@Test(priority = 4)
	public void To_Validate_the_textbox_of_Report_Issue_Functionality_using_special_Characters ()  {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("@!#$%");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(),"@!#$%");
		try {
			chatpage.delete_Send_Message();
			chatpage.click_delete_In_Popup();
			}
	   catch (NoSuchElementException e) {
		   chatpage.click_DeleteForEveryone();
				
			}
		
	}
	
	/*
	Validate the text box of the Report Issue Functionality using Alaphabats both in uppercase and lower case.
	*/
	@Test(priority = 5)
	public void To_Validate_textbox_of_Report_Issue_Functionality_using_Alaphabats_both_in_uppercase_and_lowercase ()  {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("ABCDEH");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "ABCDEH");
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
			
			}
	   catch (NoSuchElementException e) {
		   chatpage.click_delete_In_Popup();
			}
		chatpage.Set_Values_In_Message_textbox("abcdef");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "abcdef");
		wait.until(ExpectedConditions.visibilityOf(chatpage.SendMessageCard()));
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
			}
			catch (NoSuchElementException e) {
			chatpage.click_delete_In_Popup();
			}
		}
	
	/*
	Validate the text box of the Report Issue Functionality is Allowing the Space in between the value.
	*/
	@Test(priority = 6)
	public void To_Validate_textbox_of_Report_Issue_Functionality_is_Allowing_Space_in_between_the_value ()    {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("Hi Hello ok");
		
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "Hi Hello ok");
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
		}
			catch (NoSuchElementException e) {
				chatpage.click_delete_In_Popup();
			}
		
	}
	
	/*
	Validate the text box of the Report Issue Functionality by numerical value.
	*/
	@Test(priority = 7)
	public void To_Validate_textbox_of_Report_Issue_Functionality_by_numerical_value ()  {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("123456");
		
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "123456");
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();	
		}
			catch (NoSuchElementException e) {
				chatpage.click_delete_In_Popup();
			}
	}
	
	/*
	Validate the presence of placeholder in the text box of Report Issue functionality.
	*/
	@Test (priority = 8)
	public void To_Validate_the_presence_of_placeholder_in_textbox_of_Report_Issue_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Write a message....");		
		
	}
	
	
	/*
	Validate whether the value entered in the text box of Report Issue functionality is editable and deletable.	
	*/
	@Test(priority = 9)
	public void To_Validate_whether_value_entered_in_textbox_of_Report_Issue_functionality_is_editable_and_deletable () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("Hi");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hi");
		chatpage.clear_textBox();
		chatpage.Set_Values_In_Message_textbox("Hello");
		Assert.assertEquals(chatpage.get_Values_from_TextBox(), "Hello");
		chatpage.clear_textBox();
		
	}
	
	
	/*
	Validate whether crusher blink on clicking the text box of Report Issue functionality.
	*/
	@Test(priority = 10)
	public void To_Validate_whether_crusher_blink_on_clicking_textbox_of_Report_Issue_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.clickTextBox();
		Assert.assertTrue(chatpage.activeElement().isDisplayed());
	}
	
	
	
	/*
	validate whether paste option is working on the text box Report Issue functionality.
	*/
	@Test(priority = 11)
	public void To_validate_whether_paste_option_is_working_on_textbox_Report_Issue_functionality () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.paste_values("Hello");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "Hello");
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
		}
			catch (NoSuchElementException e) {
				chatpage.click_delete_In_Popup();
			}
	}
	
		
	
	/*
	Validate whether able enter a lengthy value in the text box Report Issue functionality.
	*/
	@Test(priority = 12)
	public void To_Validate_whether_able_enter_lengthy_value_in_text_box_Report_Issue_functionality ()  {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("hi hello iam doing good to havw erreo akdm anj jolhs odjjd oshsb okk nho");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "hi hello iam doing good to havw erreo akdm anj jolhs odjjd oshsb okk nho");
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(chatpage.SendMessageCard()));
		try {
			chatpage.delete_Send_Message();
			chatpage.click_DeleteForEveryone();
		}
			catch (NoSuchElementException e) {
			 chatpage.click_delete_In_Popup();
			}
	}
	
	/*
	Validate Whether able to send multiple reports.
	*/
	@Test(priority = 13)
	public void To_Validate_Whether_able_to_send_multiple_reports () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Set_Values_In_Message_textbox("hi");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Send_Message_Value(), "hi");
		chatpage.Set_Values_In_Message_textbox("hello");
		chatpage.click_Send_Button();
		Assert.assertEquals(chatpage.get_Second_Message_Value(), "hello");
		
	}
	
	/*
	Validate whether record option in the message functionality is enable.
	*/
	@Test(priority = 14)
	public void To_Validate_whether_record_option_in_message_functionality_is_enable () throws InterruptedException {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.Record_Voice_Msg();
		chatpage.click_Send_Button();
		try {
			Assert.assertFalse(chatpage.get_Message_Status().isDisplayed());
		}
		catch (NoSuchElementException e) {
			try {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
				}
				catch (AssertionError e1) {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
				}
		}
		
		}
	
	/*
	Validate whether the functions and icons response for the touch action.
	*/
	@Test(priority = 15)
	public void To_Validate_whether_the_functions_and_icons_response_fo_touch_action () {
		chatpage = new ChatPage(driver);
		try {
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			}
			catch (AssertionError e1) {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
			}
		chatpage.click_Moreoption();
		Assert.assertTrue(chatpage.get_Element_of_MoreOptions().isDisplayed());
		chatpage.click_Moreoption();
		chatpage.click_Attachments();
		try {
			Assert.assertFalse(chatpage.Elements_of_Attachments().isDisplayed());
		}
		catch (NoSuchElementException e) {
			try {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
				}
				catch (AssertionError e1) {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
				}
		}
	}
}
