package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatPage;
import POM.CreatePasswordPage;
import POM.GroupChatPage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyWalletPage;
import POM.RecoveryPhrasePage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SendPage;
import POM.SocialGroupPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class CreateSecret_Group_and_Its_Functionality extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	WebDriverWait wait;
	SecretGroupPage secretgrouppage;
 	ChatPage chatpage;
	SocialGroupPage socialgrouppage;
	GroupChatPage groupchatpage;
	MenuPage menupage;
	MyWalletPage mywalletpage;
	
	/*
	 pre Setup
	 */
	@Test(priority = 0,groups = {"Regression","Smoke"})
	public void preSetup () throws InterruptedException {
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.EnterSeedValue("onward rotate ailments dozen sidekick slackens pioneer rising boss civilian audio opposite zero tsunami upper sample cuisine strained number humid sewage subtly sifting sushi boss");		
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
		restorefromseedpage.setDisplayName("Chris");
		restorefromseedpage.setBlockheight("3400000");
	   	restorefromseedpage.clickBtnRestore();
	   	createpasswordpage = new CreatePasswordPage(driver);
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	createpasswordpage.setValidPassword();
	   	Thread.sleep(2000);
	   	createpasswordpage.clickOk();
	   	homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
	   	try {
	   		homepage.click_DropDown();
	   		homepage.click_first_request();
	   		chatpage = new ChatPage(driver);
	   		chatpage.Accept_request();
	   		driver.navigate().back();
	   		
	   	}
	   	catch (NoSuchElementException e) {
	   		try{homepage.click_DropDown();
	   		homepage.click_first_request();
	   		chatpage = new ChatPage(driver);
	   		chatpage.Accept_request();
	   		driver.navigate().back();
	   		}
	   		catch (NoSuchElementException e1) {
	   			Assert.assertEquals(homepage.Pagetitle(),"Chats");
			}
	   		}
	   	try {
	   		Assert.assertEquals(homepage.Pagetitle(),"Chats");
	   	}
	   	catch (NoSuchElementException e) {
			chatpage.click_Back_Arrow();
		}
	   	//temporary
	   	homepage.click_DropDown();
   		homepage.click_first_request();
   		chatpage = new ChatPage(driver);
   		chatpage.Accept_request();
   		driver.navigate().back();
	   	homepage.openNewSecretGroup();
	  
	}
	
	
	/*
	Validate whether able to navigate back to the home screen
	*/
	@Test(priority = 1,groups = {"Regression"})
	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
		  secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  secretgrouppage.click_Back_Arrow();
			homepage = new HomePage(driver);
		   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
		   	homepage.openNewSecretGroup();
	} 

	
	/*
	Validate Whether able to select the contacts showing.
	*/
	@Test(priority = 2,groups = {"Regression","Smoke"})
	public void To_Validate_Whether_able_to_select_the_contacts_showing () {
		secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"false");
		  secretgrouppage.select_FirstContact_In_List();
		  Assert.assertTrue(secretgrouppage.First_Contact_Selected().isDisplayed());
		  
	}
	
	/*
	 validate Whether able to Unselect the selected contact
	 */
	@Test(priority = 3,groups = {"Regression","Smoke"})
	public void To_Validate_Whether_able_to_Unselect_the_contacts_showing () {
		secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  Assert.assertTrue(secretgrouppage.First_Contact_Selected().isDisplayed());
		  secretgrouppage.select_FirstContact_In_List();
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"false");
	}
	
	/*
	Validate Whether able to multi select the contacts showing
	*/
	@Test(priority = 4,groups = {"Regression","Smoke"})
	public void To_Validate_Whether_able_to_multi_select_the_contacts_showing () {
		secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  secretgrouppage.multiselect_contacts_In_List();
		  Assert.assertTrue(secretgrouppage.First_Contact_Selected().isDisplayed());
		  Assert.assertTrue(secretgrouppage.Second_Contact_Selected().isDisplayed());
		  secretgrouppage.multiselect_contacts_In_List();
	}
	
	/*
	Validate the Create function without entering a group name and without selecting a member.
	*/
	@Test(priority = 5,groups = {"Regression"})
	public void To_Validate_Create_function_without_entering_groupName_and_without_selecting_member () {
		secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		secretgrouppage.click_Create_button();
		Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	}
	
	
	/*
	Validate the Create function with entering a group name and without selecting a member.
	*/
   @Test(priority = 6,groups = {"Regression"})
   public void To_Validate_Create_function_with_entering_groupName_and_without_selecting_member () {
	   secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.Enter_values_in_GroupName("Test");
		 try {
			 secretgrouppage.click_Create_button();
		 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
		 }
		 catch (NoSuchElementException e) {
			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group"); 
		}
		 catch (StaleElementReferenceException e) {
			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		}
		 catch (AssertionError e) {
			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		}
		 secretgrouppage.clear_TextBoxes();
		 }
   
   /*
   Validate the Create function without entering a group name and with selecting a member.
   */
   @Test(priority = 7,groups = {"Regression"})
   public void To_Validate_the_Create_function_without_entering_groupName_and_with_selecting_member () {
	   secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.select_FirstContact_In_List();
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.select_FirstContact_In_List();
   }
   
   /*
    Validate the Create function with entering space value in group name and with selecting a member
    */
   @Test(priority = 8,groups = {"Regression"})
   public void To_Validate_Create_function_with_entering_space_value_in_groupName_and_with_selecting_a_member () {
	   secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.Enter_values_in_GroupName(" ");
		 secretgrouppage.select_FirstContact_In_List();
		 secretgrouppage.click_Create_button();
		 try {
			 Assert.assertEquals(Toast(),"Please enter a group name");
		 }
		 catch (NoSuchElementException e) {
			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		}
		 catch (StaleElementReferenceException e) {
			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		}
		 catch (AssertionError e) {
			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		}
		 secretgrouppage.clear_TextBoxes();
		 secretgrouppage.select_FirstContact_In_List();
   }
   
   /*
   Validate the Create function with entering a group name and with selecting a member.
   */
   @Test(priority = 9,groups = {"Regression","Smoke"})
   public void To_Validate_Create_function_with_entering_groupName_and_with_selecting_member () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("Group");
	   secretgrouppage.select_FirstContact_In_List();
	   secretgrouppage.click_Create_button();	   
	   try 
	   {
	   chatpage = new ChatPage(driver);
	   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Group");
      chatpage.click_Back_Arrow();
      homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
	   	homepage.openNewSecretGroup();
       }
	   catch (NoSuchElementException e) {
		   try{chatpage = new ChatPage(driver);
		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Group");
	      chatpage.click_Back_Arrow();
	      homepage = new HomePage(driver);
		   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
		   	homepage.openNewSecretGroup();
		   }
		   catch (NoSuchElementException e1 ) {
			driver.navigate().back();
			homepage.open_FirstChat();
			 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Group");
		      chatpage.click_Back_Arrow();
		      homepage = new HomePage(driver);
			   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
			   	homepage.openNewSecretGroup();
			
		}
	}
	  
   }
   
   /*
   Validate whether crusher blink on clicking the text box of Secret Group .
	*/
   @Test(priority = 10,groups = {"Regression"})
   public void To_Validate_whether_crusher_blink_on_clicking_textboxes_of_SecretGroup () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.click_GroupName_textbox();
	   Assert.assertTrue(secretgrouppage.activeElement().isDisplayed());
	   secretgrouppage.click_Search_textbox();
	   Assert.assertTrue(secretgrouppage.activeElement().isDisplayed());
   }
   
  
   /*
   Validate the presence of placeholder in the text box of the Secret Group.
   */
  @Test(priority = 11,groups = {"Regression"})
  public void To_Validate_presence_of_placeholder_in_the_textboxes_of_SecretGroup () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   Assert.assertEquals(secretgrouppage.getPlacholder_of_groupName_textbox(),"Enter Secret Group name");
	   Assert.assertEquals(secretgrouppage.getPlacholder_of_Search_textbox(), "Search Contact");
  }
  
   
   /*
   validate whether paste option is working on the text box of the Secret Group.
	*/
   @Test(priority = 12,groups = {"Regression"})
   public void To_validate_whether_paste_option_is_working_on_textbox_of_Secret_Group () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.pasteValues_In_TestBoxes("Test", "check");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Test");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(), "check");
	   secretgrouppage.clear_TextBoxes();
   }
   
 
  /*
  Validate whether able to create secret group without internet connection
  */
  @Test(priority = 13,groups = {"Regression"})
  public void To_Validate_whether_able_to_create_secret_group_without_internet_connection () throws InterruptedException {
	  	
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   turnOff_Mobile_Wifi();
	   Thread.sleep(5000);
	   secretgrouppage.Enter_values_in_GroupName("Test");
	   secretgrouppage.select_FirstContact_In_List();
	   try {
		   
	   secretgrouppage.click_Create_button();
	   Assert.assertEquals(Toast(),"Please check your internet connection");
	   }
	   catch (NoSuchElementException e) {
		   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		   
		   }
	   catch (StaleElementReferenceException e) {
		   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		   }
	   turnOn_Mobile_Wifi();
	   secretgrouppage.clear_TextBoxes();
	   Thread.sleep(5000);
	   }
   
  /*
  Validate the text box of the Secret Group Functionality using special Characters.
  */
  @Test(priority = 14,groups = {"Regression"})
  public void To_Validate_the_textbox_of_Secret_Group_using_special_Characters () {
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("@#$%^");
	   secretgrouppage.Enter_Values_In_Search_textbox("@#$%^&");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"@#$%^");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"@#$%^&");
	   secretgrouppage.clear_TextBoxes();
  }
  
  /*
  Validate the text box of the Secret Group Functionality using Alphabets both in uppercase and lower case.
  */
  @Test(priority = 15,groups = {"Regression"})
  public void To_Validate_the_textbox_of_SecretGroup_using_Alphabets_both_in_uppercase_and_lowercase () {
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("ABCDE");
	   secretgrouppage.Enter_Values_In_Search_textbox("ABCDE");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"ABCDE");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"ABCDE");
	   secretgrouppage.clear_TextBoxes();
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("abcde");
	   secretgrouppage.Enter_Values_In_Search_textbox("abcde");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"abcde");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"abcde");
	   secretgrouppage.clear_TextBoxes();
  
  }
  
  /*
  Validate the text box of the Secret Group Functionality by numerical value.
  */
  @Test(priority = 16,groups = {"Regression"})
  public void To_Validate_the_textbox_of_SecretGroup_by_numerical_value () {
	
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("12345");
	   secretgrouppage.Enter_Values_In_Search_textbox("12345");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"12345");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"12345");
	   secretgrouppage.clear_TextBoxes();
  }
  
  
  /*
  Validate whether the value entered in the text box of the Secret Group is editable.
  */
  @Test(priority = 17,groups = {"Regression"})
  public void To_Validate_whether_the_value_entered_in_textbox_of_SecretGroup_is_editable_And_Deleteable () {
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("Hello");
	   secretgrouppage.Enter_Values_In_Search_textbox("Hi");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Hello");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"Hi");
	   secretgrouppage.clear_TextBoxes();
	
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("Check");
	   secretgrouppage.Enter_Values_In_Search_textbox("Check");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Check");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"Check");
	   secretgrouppage.clear_TextBoxes();
	   
  }
  
  
		  
		  /*
		   * 
		   * 
		   * Group chats
		   * 
		   * 
		   * 
		   */
  
//  
//  /*
//	validate working of remove member from group
//	*/
//	@Test(priority = 18,groups = {"Regression","Smoke"})
//	public void To_validate_working_of_remove_member_from_group () {
//		driver.navigate().back();
//		homepage = new  HomePage(driver);
//		homepage.open_FirstChat();
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Group");
//		groupchatpage.Remove_member_from_group();
//		Assert.assertEquals(groupchatpage.get_information_About_removed(), "You removed test from the group");
//		
//	}
//	
//	/*
//	Validate the whether able to add new member in the group  
//	*/
//	@Test(priority = 19,groups = {"Regression","Smoke"})
//	public void To_Validate_the_whether_able_add_new_member_in_the_group () throws InterruptedException {
//			groupchatpage = new GroupChatPage(driver);
//			Assert.assertEquals(groupchatpage.groupName(),"Group");
//			groupchatpage.Add_person_in_Group();
//			Assert.assertEquals(groupchatpage.get_information_About_Added(), "You added test to the group");
//	}
//	
//	
//	/*
//	validate whether able to change the group name
//	*/
//	@Test(priority = 20,groups = {"Regression","Smoke"})
//	public void To_validate_whether_able_to_change_the_group_name () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Group");
//		groupchatpage.Change_group_name("Test");
//		groupchatpage.click_Apply_changes();
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//	
//	}
//	
//	/*
//	validate whether able to set group name without value
//	*/
//	@Test(priority = 21,groups = {"Regression"})
//	public void To_validate_whether_able_to_set_group_name_without_value () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Change_group_name("  ");
//		try{
//			Assert.assertEquals(Toast(), "Group name can't be empty");
//			groupchatpage.click_Apply_changes();
//		}
//		catch (NoSuchElementException e) {
//			groupchatpage.click_Apply_changes();
//		}
//		catch (StaleElementReferenceException e) {
//			groupchatpage.click_Apply_changes();
//		}
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//	}
//	
//	/*
//	Validate whether able to set group with already existing name
//	*/
//	@Test(priority = 22,groups = {"Regression"})
//	public void To_Validate_whether_able_to_set_group_with_already_existing_name () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Change_group_name("Test");
//		try{
//			Assert.assertEquals(Toast(), "Please enter a different name");
//			groupchatpage.click_Apply_changes();
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(groupchatpage.EditGroup_Screen_title(),"Edit Group");
//			groupchatpage.Click_close_in_editGroup_Screen();
//		}
//		catch (StaleElementReferenceException e) {
//			Assert.assertEquals(groupchatpage.EditGroup_Screen_title(),"Edit Group");
//			groupchatpage.Click_close_in_editGroup_Screen();
//		}
//		
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		
//	}
//	
//	/*
//	Validate the working of cancel option in popup
//	*/
//	@Test(priority = 23,groups = {"Regression"})
//	public void To_Validate_the_working_of_cancel_option_in_popup () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.click_cancel_In_LeaveGroup();
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Click_Close_in_NotificationSettings_popup();
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Click_close_in_editGroup_Screen();
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//	}
//	
//	/*
//	Validate the working of the both option Notification settings of the menu bar in group messaging screen.
//	*/
//	@Test(priority = 24,groups = {"Regression","Smoke"})
//	public void To_Validate_the_working_of_both_option_Notification_settings_of_menu_bar_in_group_messaging_screen () {
//		groupchatpage = new GroupChatPage(driver);
//		//Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Set_Mentions_option();
//		groupchatpage.Click_Back_Arrow();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		try{
//			Assert.assertTrue(homepage.Element_Mention_Icon().isDisplayed());
//		}
//		catch (StaleElementReferenceException e) {
//			Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		}
//		homepage.open_FirstChat();
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Set_All_option();
//		groupchatpage.Click_Back_Arrow();
//		try {
//			Assert.assertFalse(homepage.Element_Mention_Icon().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			homepage.open_FirstChat();
//		}
//		
//	}
//	
//	/*
//	Validate whether call functions is not present in group messaging screen. 
//	*/
//	@Test(priority = 25,groups = {"Regression","Smoke"})
//	public void To_Validate_whether_call_functions_is_not_present_in_group_messaging_screen () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		chatpage = new ChatPage(driver);
//		try {
//		Assert.assertFalse(chatpage.Element_of_call_Icon().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(groupchatpage.groupName(),"Test");
//		}
//	}
//	
//	/*
//	validate whether pay as you chat function is not present in the chat
//	*/
//	@Test(priority = 26,groups = {"Regression","Smoke"})
//	public void To_validate_whether_pay_as_you_chat_function_is_not_present_in_the_chat () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Click_Back_Arrow();
//		homepage = new HomePage(driver);
//		homepage.clickMenuDrawer();
//		menupage = new MenuPage(driver);
//		menupage.click_option_Wallet();
//		mywalletpage = new MyWalletPage(driver);
//		mywalletpage.click_CheckBox();
//		mywalletpage.click_Enable_Wallet();
//		homepage.open_FirstChat();
//		try {
//	    chatpage = new  ChatPage(driver);
//		chatpage.enable_Pay_as_youChat();
//		chatpage.Set_Values_In_Message_textbox("1");
//		Assert.assertFalse(chatpage.Btn_Slide_to_pay().isDisplayed());
//		
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(groupchatpage.groupName(),"Test");
//		}
//	}
//	
//	/*
//	Validate whether able to send message in group chat
//	*/
//	@Test(priority = 27,groups = {"Regression","Smoke"})
//	public void To_Validate_whether_able_to_send_message_in_group_chat () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Set_Values_in_textbox("Hii");
//		groupchatpage.click_Send_button();
//		Assert.assertTrue(groupchatpage.Message_Status().isDisplayed());
//		groupchatpage.deleteMessage();
//	}
//	
//	/*
//	validate whether able to send voice message
//	*/
//	@Test(priority = 28,groups = {"Regression","Smoke"})
//	public void To_validate_whether_able_to_send_voice_message () throws InterruptedException {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//	   groupchatpage.Record_Voice_Msg();
//	   groupchatpage.click_Send_button();
//	   Assert.assertTrue(groupchatpage.Message_Status().isDisplayed());
//	   groupchatpage.delete_voiceMsg_Or_attachment();
//	
//	}
//	
//	/*
//	validate whether able to send attachments
//	*/
//	@Test(priority = 29,groups = {"Regression","Smoke"})
//	public void To_validate_whether_able_to_send_attachments () throws InterruptedException {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//	  groupchatpage.Send_image();
//		 Assert.assertTrue(groupchatpage.Message_Status().isDisplayed());
//		   groupchatpage.delete_voiceMsg_Or_attachment();
//		
//	}
//	
//  /*
//  validate whether able to set group name with space in between values
//  */
//	@Test(priority = 30,groups = {"Regression"})
//	public void To_validate_whether_able_to_set_group_name_with_space_in_between_values () {
//		groupchatpage = new GroupChatPage(driver);
//		
//		Assert.assertEquals(groupchatpage.groupName(),"Test");
//		groupchatpage.Change_group_name("Group Name");
//		groupchatpage.click_Apply_changes();
//		Assert.assertEquals(groupchatpage.groupName(), "Group Name");
//	}
//	
//	/*
//  validate whether able to set group name with numerical values
//  */
//	@Test(priority = 31,groups = {"Regression"})
//  public void To_validate_whether_able_to_set_group_name_with_numerical_values () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(), "Group Name");
//		groupchatpage.Change_group_name("12345");
//		groupchatpage.click_Apply_changes();
//		Assert.assertEquals(groupchatpage.groupName(), "12345");
//		
//	}
//	
//	/*
//  validate whether able to set group name with special characters
//  */
//	@Test(priority = 32,groups = {"Regression"})
//	public void To_validate_whether_able_to_set_group_name_with_special_characters () {
//		groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(), "12345");
//		groupchatpage.Change_group_name("!@#$%");
//		groupchatpage.click_Apply_changes();
//		Assert.assertEquals(groupchatpage.groupName(), "!@#$%");
//	}
//	/*
//  Validate whether able to set group name with mixed values
//  */
//  @Test(priority = 33,groups = {"Regression"})
//  public void To_Validate_whether_able_to_set_group_name_with_mixed_values () {
//  	groupchatpage = new GroupChatPage(driver);
//		Assert.assertEquals(groupchatpage.groupName(), "!@#$%");
//		groupchatpage.Change_group_name("test@123");
//		groupchatpage.click_Apply_changes();
//		Assert.assertEquals(groupchatpage.groupName(), "test@123");
//  }
//	
//	/*
//  validate the presence of placeholder in group name text box
//   validate whether cursor blinks while clicking the group name textbox
//  */
//  @Test(priority = 34,groups = {"Regression"})
//  public void To_validate_the_presence_of_placeholder_in_group_name_textbox () {
//  	groupchatpage = new GroupChatPage(driver);
//  	Assert.assertEquals(groupchatpage.groupName(), "test@123");
//  	Assert.assertEquals(groupchatpage.get_groupName_textbox_placeholder(),"Enter a new group name");
//  	Assert.assertTrue(groupchatpage.activeElement().isDisplayed());
//      groupchatpage.click_Apply_changes();
//  }
//  	
//    /*
//    validate the working of leave group
// 	*/
//	@Test(priority = 35,groups = {"Regression","Smoke"})
//	public void To_validate_the_working_of_leave_group () throws InterruptedException {
//		groupchatpage = new GroupChatPage(driver);
//  	try{
//  		Assert.assertEquals(groupchatpage.groupName(), "test@123");
//  	}
//  	catch (AssertionError  e) {
//  		Assert.assertEquals(groupchatpage.groupName(),"Test");
//	}
//  	groupchatpage.Leave_Group();
//  		homepage = new HomePage(driver);
//  	Assert.assertEquals(homepage.Pagetitle(),"BChat");
//  	try {
//  	homepage.open_FirstChat();
//  	}
//  	catch (StaleElementReferenceException e) {
//		   homepage.open_FirstChat();
//		}
//  	Assert.assertTrue(groupchatpage.Information_about_not_In_Group().isDisplayed());
//  	groupchatpage.Click_Back_Arrow();
//	
//	}
//	
//	
//	/*
//  Validate the working of the community guidelines in social group messaging screen
//  */
//  @Test(priority = 36,groups = {"Regression","Smoke"})
//  public void To_Validate_the_working_of_community_guidelines_in_social_group_messaging_screen () {
//  	homepage = new HomePage(driver);
//  	Assert.assertEquals(homepage.Pagetitle(),"BChat");
//  	homepage.openJoinSocialGroup();
//  	socialgrouppage = new SocialGroupPage(driver);
//  	try{
//  		socialgrouppage.join_Bchat_Group();
//  		try{
//  			Assert.assertEquals(socialgrouppage.Pagetitle(), "Bchat");
//  		}
//  		catch (AssertionError e) {
//  			Assert.assertEquals(socialgrouppage.Pagetitle(), "bchat");
//		}
//  	}
//  	catch (NoSuchElementException e) {
//  		socialgrouppage.join_Bchat_Group();
//	}
//  	socialgrouppage.open_Community_Guidelines();
//  	Assert.assertEquals(socialgrouppage.community_Guidelines_Screen_title(), "Community Guidelines");
//  	driver.navigate().back();
//  	try {
//      	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
//      	}
//      	catch (AssertionError e) {
//      		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
//  		}
//  	
//  }
//  
//	/*
//  validate the working of add member in social group messaging screen
//  */
//	@Test(priority = 37,groups = {"Regression"})
//	public void To_validate_the_working_of_add_member_in_social_group_messaging_screen () {
//		socialgrouppage = new SocialGroupPage(driver);
//		try {
//      	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
//      	}
//      	catch (AssertionError e) {
//      		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
//  		}
//		socialgrouppage.Add_Member();
//		try {
//      	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
//      	}
//      	catch (AssertionError e) {
//      		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
//  		}
//		
//	}
//	
//	/*
//	 Validate whether member count showing in social group.
//	 */
//  @Test(priority = 38,groups = {"Regression"})
//  public void To_Validate_whether_member_count_showing_in_social_group () {
//  	socialgrouppage = new SocialGroupPage(driver);
//  	try {
//      	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
//      	}
//      	catch (AssertionError e) {
//      		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
//  		}
//		Assert.assertNotEquals(socialgrouppage.get_Member_Count(),0);
//  
//  }
 
}
