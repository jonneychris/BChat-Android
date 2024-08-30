package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
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
import POM.SecretGroupPage;
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
	
	
	@Test(priority = 0)
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
	
	
	
	
//	/*
//	Validate the all possible navigation from the home screen in both forward and backward direction
//	Validate whether able to navigate to the device home page directly.
//	*/
//	@Test(priority = 1)
//	public void To_Validate_navigation_from_the_home_screen_in_both_forward_and_backward_direction () throws InterruptedException {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		driver.navigate().back();
//		 driver.navigate().back();
//		 if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
//			 landingpage.openApp();
//	}
//		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
//	
//	}
//	
//	/*
//	 Validate the blank screen While creating new Account
//	 */
//	@Test(priority = 2)
//	public void To_Validate_the_blank_screen_While_creating_new_Account () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		Assert.assertTrue(homepage.BlankChatScreen.isDisplayed());
//	}
//	
//	
//	/*
//	Validate the navigation to the settings screen in both forward and backward direction.
//	*/
//	@Test(priority = 3)
//	public void To_Validate_the_Navigation_to_the_Menu_screen_in_both_forward_and_backward_direction() {
//		homepage = new HomePage(driver);
//		menupage =new MenuPage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//		Assert.assertEquals(menupage.pagetitle(), "Menu");
//		homepage.ClickCancel();
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//	}
//	
//	/*
//	Validate the navigation to the Search screen in both forward and backward direction.
//	*/
//	@Test(priority = 4)
//	public void To_Validate_the_Navigation_to_the_search_screen_in_both_forward_and_backward_direction() {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickSearch();
//		//Assert.assertEquals(homepage.searchTitle(), "Search");
//	  // homepage.clickBackArrow();
//	     driver.navigate().back();
//	     driver.navigate().back();
//		Assert.assertEquals(homepage.Pagetitle(), "BChat");
//	   
//	}
//	
//	
//	/*
//	 Validate the navigation to the new chat screen
//	 */
//	
//	@Test(priority=5)
//	public void To_validate_the_navigation_to_newChat_screen () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.OpenNewChat();
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(), "New Chat");
//		//homepage.clickBackArrow();
//		driver.navigate().back();
//	}
//	
//    /*
// 	 validate the navigation to the create secret group screen	
//    */
//	@Test(priority=6)
//	public void To_validate_the_navigation_to_Create_SecretGroup_screen () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.openNewSecretGroup();
//		secretgrouppage =new SecretGroupPage(driver);
//		Assert.assertEquals(secretgrouppage.Pagetitle(), "Secret Group");
//		//homepage.clickBackArrow();
//		driver.navigate().back();
//	}
//	
//	
//	/*
//	  Validate the navigation to the join social group screen
//	 */
//	@Test(priority=7)
//	public void To_validate_the_navigation_to_Join_Social_screen () {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.openJoinSocialGroup();
//		socialgrouppage = new SocialGroupPage(driver);
//		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
//		//homepage.clickBackArrow();
//		driver.navigate().back();
//	}
//	

	/*
	Validate the working of home screen without internet connection
	*/
	@Test(priority = 8)
	public void To_Validate_the_working_of_home_Screen_without_internet_connection () throws InterruptedException {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		Assert.assertTrue(homepage.hops_Warning().isDisplayed());
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
	}
	/*
     Validate whether able to pin a particular group or person chat.
     */
    @Test(priority = 9)
    public void To_Validate_whether_able_to_pin_particular_group_or_person_chat () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		newchatpage = new NewChatPage(driver);
		newchatpage.Check_with_ValidId_1();
		chatpage = new ChatPage(driver);
		chatpage.Send_one_msg();
		homepage.OpenNewChat();
		newchatpage.Check_with_ValidId_2();
		chatpage.Send_one_msg();
		String SecondId = homepage.get_Second_Id();
		homepage.pin_The_chat();
		Assert.assertEquals(SecondId, homepage.get_First_Id());
		Assert.assertTrue(homepage.Element_of_pinIcon().isDisplayed());
    }
	
	/*
     Validate whether able to unpin a pinned particular group or person chat.
     */
    @Test(priority=10)
    public void To_Validate_whether_able_to_unpin_a_pinned_particular_group_or_personchat () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertTrue(homepage.Element_of_pinIcon().isDisplayed());
		String FirstId = homepage.get_First_Id();
		homepage.Unpin_The_chat();
		try {
			Assert.assertFalse(homepage.Element_of_pinIcon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(FirstId, homepage.get_Second_Id());
		}
    }
    
	
	/*
     Validate whether able to mute the notifications of the a particular group or person chat.
    */
    @Test(priority=11)
    public void To_Validate_whether_able_to_mute_notifications_of_particular_group_or_person_chat () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.Mute_Notificaion_of_Chat();
		Assert.assertTrue(homepage.Element_Mute_Icon().isDisplayed());
    }
    
	
	/*
     Validate whether able to Unmute the notifications of the muted contacts.
	*/
    @Test(priority=12)
    public void To_Validate_whether_able_to_Unmute_notifications_of_muted_contacts () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertTrue(homepage.Element_Mute_Icon().isDisplayed());
		homepage.UnMute_Notificaion_of_Chat();
		try {
		Assert.assertFalse(homepage.Element_Mute_Icon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		}
    
    /*
     Validate Whether able to block the chat
     */
    @Test(priority=13)
    public void To_Validate_Whether_able_to_block_the_chat () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.Block_First_Contact();
		homepage.open_FirstChat();
		chatpage = new ChatPage(driver);
		Assert.assertTrue(chatpage.Element_of_Blocked_Banner().isDisplayed());
		chatpage.click_Back_Arrow();
    }
    
    /*
    Validate Whether able to Unblock the chat
    */
    @Test(priority=14)
    public void To_Validate_Whether_able_to_Unblock_the_chat () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.UnBlock_First_Contact();
		homepage.open_FirstChat();
		chatpage = new ChatPage(driver);
		try {
		Assert.assertFalse(chatpage.Element_of_Blocked_Banner().isDisplayed());
		}
		catch (NoSuchElementException e) {
			chatpage.click_Back_Arrow();
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}		
    }
    
    
    /*
     Validate whether able to delete the chats from chat history of the home screen 
     */
    @Test(priority=15)
    public void To_Validate_whether_able_to_delete_the_chats_from_chat_history_of_home_screen () {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		String FirstId = homepage.get_First_Id();
		homepage.Delete_FirstContact();
		Assert.assertEquals(Toast(), "Conversation deleted");
		Assert.assertNotEquals(FirstId,homepage.get_DisplayName_Or_Id_Of_ChatItem());
    
    }


    /*
     Validate the working of the notification settings mention options in group chat
     */
    @Test(priority=16)
    public void To_Validate_the_working_of_notification_settings_mention_options_in_group_chat () throws InterruptedException {
    	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
		socialgrouppage = new SocialGroupPage(driver);
		socialgrouppage.join_Beldex_Group();
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Beldex");
		chatpage.click_Back_Arrow();
		Thread.sleep(5000);
		try {
		homepage.Set_Mention_option();
		Assert.assertTrue(homepage.Element_Mention_Icon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Thread.sleep(5000);
			driver.navigate().back();
			homepage.Set_Mention_option();
			Assert.assertTrue(homepage.Element_Mention_Icon().isDisplayed());
		}
		}
    
    /*
    Validate the working of the notification settings All options in group chat
    */
   @Test(priority=17)
   public void To_Validate_the_working_of_notification_settings_All_options_in_group_chat () {
   	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.Set_All_option();
		try {
		Assert.assertFalse(homepage.Element_Mention_Icon().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
		}


   /*
    Validate the Working of cancel button in All popup
    */
   @Test(priority=18)
   public void To_Validate_the_Working_of_cancel_button_in_All_popup () {
   	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.validate_Cancel_in_Block();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.validate_Cancel_in_Delete();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.validate_Cancel_in_NotificationSettings();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
   }
   
   /*
    Validate the working of Mark All As Read option.
    */
   @Test(priority=19)
   public void To_Validate_the_working_of_Mark_All_As_Read_option () {
	 	homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertTrue(homepage.Element_of_Unread_Msg_Count().isDisplayed());
		homepage.Select_Mark_All_As_read();
		try {
		Assert.assertFalse(homepage.Element_of_Unread_Msg_Count().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
   }
}
