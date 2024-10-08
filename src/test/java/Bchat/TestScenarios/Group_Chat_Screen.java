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
import POM.GroupChatPage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyWalletPage;
import POM.RecoveryPhrasePage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Group_Chat_Screen extends baseClass{

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	MenuPage menupage;
	WebDriverWait wait;
	SecretGroupPage secretgrouppage;
	ChatPage chatpage;
	GroupChatPage groupchatpage;
	MyWalletPage mywalletpage;
	SocialGroupPage socialgrouppage;
	
	/*
	 preSetup
	 */
	@Test(priority = 0,groups = {"Regression","Smoke"})
	public void PreSetup () throws InterruptedException {
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
		   	Thread.sleep(30000);
		   	homepage = new HomePage(driver);
		   	
		   
		   //	homepage.click_DropDown();
		   //	homepage.click_first_request();
		   //  chatpage = new ChatPage(driver);
		   //  chatpage.Accept_request();
		   //  chatpage.click_Back_Arrow();
		   	homepage.openNewSecretGroup();
		   	secretgrouppage = new SecretGroupPage(driver);
		   	secretgrouppage.Enter_values_in_GroupName("Group");
		   	secretgrouppage.select_FirstContact_In_List();
		   	secretgrouppage.click_Create_button();

	}

	
	/*
	validate working of remove member from group
	*/
	@Test(priority = 1,groups = {"Regression"})
	public void To_validate_working_of_remove_member_from_group () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Group");
		groupchatpage.Remove_member_from_group();
		Assert.assertEquals(groupchatpage.get_information_About_removed(), "You removed test from the group");
		
	}
	
	
	
	/*
	Validate the whether able to add new member in the group  
	*/
	@Test(priority = 2,groups = {"Regression"})
	public void To_Validate_the_whether_able_add_new_member_in_the_group () throws InterruptedException {
			groupchatpage = new GroupChatPage(driver);
			Assert.assertEquals(groupchatpage.groupName(),"Group");
			groupchatpage.Add_person_in_Group();
			Assert.assertEquals(groupchatpage.get_information_About_Added(), "You added test to the group");
	}
	
	
	/*
	validate whether able to change the group name
	*/
	@Test(priority = 3,groups = {"Regression"})
	public void To_validate_whether_able_to_change_the_group_name () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Group");
		groupchatpage.Change_group_name("Test");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
	
	}
	
	/*
	validate whether able to set group name without value
	*/
	@Test(priority = 4,groups = {"Regression"})
	public void To_validate_whether_able_to_set_group_name_without_value () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Change_group_name("  ");
		Assert.assertEquals(Toast(), "Group name can't be empty");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
	}
	
	/*
	Validate whether able to set group with already existing name
	*/
	@Test(priority = 5)
	public void To_Validate_whether_able_to_set_group_with_already_existing_name () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Change_group_name("Test");
		Assert.assertEquals(Toast(), "Please enter a different name");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		
	}
	
	/*
	Validate the working of cancel option in popup
	*/
	@Test(priority = 6)
	public void To_Validate_the_working_of_cancel_option_in_popup () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.click_cancel_In_LeaveGroup();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Click_Close_in_NotificationSettings_popup();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Click_close_in_editGroup_Screen();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
	}
	
	/*
	Validate the working of the both option Notification settings of the menu bar in group messaging screen.
	*/
	@Test(priority = 7)
	public void To_Validate_the_working_of_both_option_Notification_settings_of_menu_bar_in_group_messaging_screen () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Set_Mentions_option();
		groupchatpage.Click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.Element_Mention_Icon().isDisplayed());
		homepage.open_FirstChat();
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Set_All_option();
		groupchatpage.Click_Back_Arrow();
		try {
			Assert.assertFalse(homepage.Element_Mention_Icon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			homepage.open_FirstChat();
		}
		
	}
	
	/*
	Validate whether call functions is not present in group messaging screen. 
	*/
	@Test(priority = 8)
	public void To_Validate_whether_call_functions_is_not_present_in_group_messaging_screen () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		chatpage = new ChatPage(driver);
		try {
		Assert.assertFalse(chatpage.Element_of_call_Icon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(groupchatpage.groupName(),"Test");
		}
	}
	
	/*
	validate whether pay as you chat function is not present in the chat
	*/
	@Test(priority = 9)
	public void To_validate_whether_pay_as_you_chat_function_is_not_present_in_the_chat () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Click_Back_Arrow();
		homepage = new HomePage(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_CheckBox();
		mywalletpage.click_Enable_Wallet();
		homepage.open_FirstChat();
		try {
	    chatpage = new  ChatPage(driver);
		chatpage.enable_Pay_as_youChat();
		chatpage.Set_Values_In_Message_textbox("1");
		Assert.assertFalse(chatpage.Btn_Slide_to_pay().isDisplayed());
		
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(groupchatpage.groupName(),"Test");
		}
	}
	
	/*
	Validate whether able to send message in group chat
	*/
	@Test(priority = 10)
	public void To_Validate_whether_able_to_send_message_in_group_chat () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
		groupchatpage.Set_Values_in_textbox("Hii");
		groupchatpage.click_Send_button();
		Assert.assertTrue(groupchatpage.Message_Status().isDisplayed());
		groupchatpage.deleteMessage();
	}
	
	/*
	validate whether able to send voice message
	*/
	@Test(priority = 11)
	public void To_validate_whether_able_to_send_voice_message () throws InterruptedException {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
	   groupchatpage.Record_Voice_Msg();
	   groupchatpage.click_Send_button();
	   Assert.assertTrue(groupchatpage.Message_Status().isDisplayed());
	   groupchatpage.delete_voiceMsg_Or_attachment();
	
	}
	
	/*
	validate whether able to send attachments
	*/
	@Test(priority = 12)
	public void To_validate_whether_able_to_send_attachments () throws InterruptedException {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(),"Test");
	  groupchatpage.Send_image();
		 Assert.assertTrue(groupchatpage.Message_Status().isDisplayed());
		   groupchatpage.delete_voiceMsg_Or_attachment();
		
	}
	
    /*
    validate whether able to set group name with space in between values
    */
	@Test(priority = 13)
	public void To_validate_whether_able_to_set_group_name_with_space_in_between_values () {
		groupchatpage = new GroupChatPage(driver);
		// Temporrary
		Assert.assertEquals(groupchatpage.groupName(),"Group");
		groupchatpage.Change_group_name("Group Name");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(), "Group Name");
	}
	
	/*
    validate whether able to set group name with numerical values
    */
	@Test(priority = 14)
    public void To_validate_whether_able_to_set_group_name_with_numerical_values () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(), "Group Name");
		groupchatpage.Change_group_name("12345");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(), "12345");
		
	}
	
	/*
    validate whether able to set group name with special characters
    */
	@Test(priority = 15)
	public void To_validate_whether_able_to_set_group_name_with_special_characters () {
		groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(), "12345");
		groupchatpage.Change_group_name("!@#$%");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(), "!@#$%");
	}
	/*
    Validate whether able to set group name with mixed values
    */
    @Test(priority = 16)
    public void To_Validate_whether_able_to_set_group_name_with_mixed_values () {
    	groupchatpage = new GroupChatPage(driver);
		Assert.assertEquals(groupchatpage.groupName(), "!@#$%");
		groupchatpage.Change_group_name("test@123");
		groupchatpage.click_Apply_changes();
		Assert.assertEquals(groupchatpage.groupName(), "test@123");
    }
	
	/*
    validate the presence of placeholder in group name text box
     validate whether cursor blinks while clicking the group name textbox
    */
    @Test(priority = 17)
    public void To_validate_the_presence_of_placeholder_in_group_name_textbox () {
    	groupchatpage = new GroupChatPage(driver);
    	Assert.assertEquals(groupchatpage.groupName(), "test@123");
    	Assert.assertEquals(groupchatpage.get_groupName_textbox_placeholder(),"Enter a new group name");
    	Assert.assertTrue(groupchatpage.activeElement().isDisplayed());
        groupchatpage.click_Apply_changes();
    }
    
	

    /*
    validate the working of leave group
   	*/
	@Test(priority = 18)
	public void To_validate_the_working_of_leave_group () throws InterruptedException {
		groupchatpage = new GroupChatPage(driver);
    	Assert.assertEquals(groupchatpage.groupName(), "test@123");
    	groupchatpage.Leave_Group();
    		homepage = new HomePage(driver);
    	Assert.assertEquals(homepage.Pagetitle(),"BChat");
    	try {
    	homepage.open_FirstChat();
    	}
    	catch (StaleElementReferenceException e) {
		   homepage.open_FirstChat();
		}
    	Assert.assertTrue(groupchatpage.Information_about_not_In_Group().isDisplayed());
    	groupchatpage.Click_Back_Arrow();
	
	}
	
	
	/*
    Validate the working of the community guidelines in social group messaging screen
    */
    @Test(priority = 19)
    public void To_Validate_the_working_of_community_guidelines_in_social_group_messaging_screen () {
    	homepage = new HomePage(driver);
    	Assert.assertEquals(homepage.Pagetitle(),"BChat");
    	homepage.openJoinSocialGroup();
    	socialgrouppage = new SocialGroupPage(driver);
    	socialgrouppage.join_Bchat_Group();
    	socialgrouppage.open_Community_Guidelines();
    	Assert.assertEquals(socialgrouppage.community_Guidelines_Screen_title(), "Community Guidelines");
    	driver.navigate().back();
    	try {
        	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
        	}
        	catch (AssertionError e) {
        		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
    		}
    	
    }
    
	/*
    validate the working of add member in social group messaging screen
    */
	@Test(priority = 20)
	public void To_validate_the_working_of_add_member_in_social_group_messaging_screen () {
		socialgrouppage = new SocialGroupPage(driver);
		try {
        	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
        	}
        	catch (AssertionError e) {
        		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
    		}
		socialgrouppage.Add_Member();
		try {
        	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
        	}
        	catch (AssertionError e) {
        		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
    		}
		
	}
	
	/*
	 Validate whether member count showing in social group.
	 */
    @Test(priority = 21)
    public void To_Validate_whether_member_count_showing_in_social_group () {
    	socialgrouppage = new SocialGroupPage(driver);
    	try {
        	Assert.assertEquals(socialgrouppage.groupName(),"BChat");
        	}
        	catch (AssertionError e) {
        		Assert.assertEquals(socialgrouppage.groupName(),"Bchat");
    		}
		Assert.assertNotEquals(socialgrouppage.get_Member_Count(),0);
    
    }
}
