package Bchat.TestScenarios;

import static org.testng.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.AppLockPage;
import POM.ChatSettingsPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.NoteToMyselfPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.reactivex.rxjava3.functions.Action;

public class ChatSetteing_Screen_And_Functionalities extends baseClass{

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	MenuPage menupage;
	AccountSettingsPage accountsettingspage;
	AppLockPage applockpage;
	ChatSettingsPage chatsettingspage;
	NoteToMyselfPage notetomyself;
	
	/*
	 PreSetup
	 */
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
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
        accountsettingspage =new AccountSettingsPage(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_option_Chat_settings();
	}
	
	
	/*
	Validate whether able to navigate back to the my account screen
	*/
	@Test(priority = 1)
	public void To_Validate_whether_Able_to_navigate_back_to_my_account_screen () {
		
		chatsettingspage=new ChatSettingsPage(driver);
		Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
		chatsettingspage.click_Back_Arrow();
		accountsettingspage =new AccountSettingsPage(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		
	}


	
	/*
	Validate the working of the enter is send option in the messaging screen in on condition.
    */
   @Test(priority = 2)
	public void To_Validate_working_of_enterkey_is_send_option_in_messaging_screen_in_on_condition () {
	  
	   accountsettingspage =new AccountSettingsPage(driver);
       Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
       accountsettingspage.click_option_Chat_settings();
       chatsettingspage = new ChatSettingsPage(driver);
   	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
   	   chatsettingspage.click_Swipe_button_In_Enter_key();
   	   chatsettingspage.click_Back_Arrow();
   	   driver.navigate().back();
     	homepage = new HomePage(driver);
	homepage.clickSearch();
	homepage.click_Option_Note_To_Myself();
	notetomyself = new NoteToMyselfPage(driver); 
   	notetomyself.clickTextBox();
    notetomyself.Set_Values_In_Message_textbox("Hello");
   	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
   	Assert.assertTrue(notetomyself.SendMessageCard().isDisplayed());   
    notetomyself.click_Back_Arrow(); 
	   
	   
   }
   
	/*
	Validate the working of the enter is send option in the messaging screen in off condition.
	*/
   @Test(priority =3)
   public void To_Validate_working_of_enter_is_send_option_in_messaging_screen_in_off_condition () {
	   	homepage = new HomePage(driver);
	   	homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
        accountsettingspage =new AccountSettingsPage(driver);
        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
        accountsettingspage.click_option_Chat_settings();
        chatsettingspage = new ChatSettingsPage(driver);
        Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
        chatsettingspage.click_Swipe_button_In_Enter_key();
    	  
    	   chatsettingspage.click_Back_Arrow();
    	   driver.navigate().back();
    	
 	homepage.clickSearch();
 	homepage.click_Option_Note_To_Myself();
 	notetomyself = new NoteToMyselfPage(driver); 
    	notetomyself.clickTextBox();
    	notetomyself.Set_Values_In_Message_textbox("Hii");
     ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
 	Assert.assertNotEquals(notetomyself.get_Send_Message_Value(), "Hii");
 	notetomyself.click_Back_Arrow();  
 	
   }
	
	
   
   /*
    Validate Whether option in message trimming are clickabble without enabled delete old messages
	*/
   @Test(priority = 4)
   public void To_Validate_Whether_option_in_message_trimming_are_clickabble_without_enabled_delete_old_messages () {
	   homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_Account_Settings();
       accountsettingspage =new AccountSettingsPage(driver);
       Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
       accountsettingspage.click_option_Chat_settings();
       chatsettingspage = new ChatSettingsPage(driver);
   	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
   	   chatsettingspage.click_Option_Conversation_Length();
   	   Assert.assertEquals(chatsettingspage.pageTitle(), "Chat Settings");
   	chatsettingspage.click_option_Trim_conversation();
	   Assert.assertEquals(chatsettingspage.pageTitle(), "Chat Settings");
   }
   
   /*
  Validate the Whether able to change the value in the converstion length limit
   */
  @Test(priority = 5)
   public void To_Validate_the_Whether_able_to_change_the_value_in_the_converstion_length_limit () {
	  
	  chatsettingspage = new ChatSettingsPage(driver);
  	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
  	   chatsettingspage.click_Swipe_button_In_delete();
  	   chatsettingspage.click_Option_Conversation_Length();
  	   Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
  	   chatsettingspage.change_Value_In_Conversation_Length("100");
  	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
  	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),100);
  	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  
  }
  
  /*
   Validate whether entered value in conversation length limit field is displayed chat Setting Screen.
    Validate whether the value entered in Conversation length limit field is editable and deleteable.
   */
  @Test(priority =6)
  public void To_Validate_whether_entered_value_in_conversation_length_limit_field_is_displayed_In_Chat_Settings () {
	  chatsettingspage = new ChatSettingsPage(driver);
 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	   chatsettingspage.click_Option_Conversation_Length();
 	  Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
 	   chatsettingspage.change_Value_In_Conversation_Length("200");
 	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),200);
 	  chatsettingspage.click_Option_Conversation_Length();
 	  Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
 	   chatsettingspage.change_Value_In_Conversation_Length("300");
 	 Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),300);
 	   
 	
  }
  
  
   /*
  Validate the working of the Ok and cancel buttons in conversation length
	*/
  @Test(priority = 7)
  public void To_Validate_the_working_of_Ok_and_cancel_buttons_in_conversation_length () {
	  chatsettingspage = new ChatSettingsPage(driver);
 	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	  chatsettingspage.click_Option_Conversation_Length();
 	   Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
 	   chatsettingspage.click_Cancel_In_conversation_Length_Popup();
 	  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
 	  chatsettingspage.click_Option_Conversation_Length();
 	 Assert.assertEquals(chatsettingspage.conversation_Length_Popup_Title(), "Conversation length limit");
	   chatsettingspage.click_Ok_In_Conversation_Popup();
	  Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
  }

   /*
 Validate the working of the delete button in the Delete all old messages now
	*/
  @Test(priority = 8) 
  public void To_Validate_the_working_of_delete_button_in_Delete_all_old_messages_now () {
	  chatsettingspage = new ChatSettingsPage(driver);
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   chatsettingspage.click_option_Trim_conversation();
	   Assert.assertEquals(chatsettingspage.Delete_Old_Messages_Popup_Title(),"Delete All Old Messages Now?");
	   chatsettingspage.click_delete_In_Delete_Messages_Popup();
	 try {
		 chatsettingspage.click_delete_In_Delete_Messages_Popup();
	   Assert.assertEquals(Toast(),"Old messages successfully deleted");
	 }
	 catch (StaleElementReferenceException e) {
		 chatsettingspage.click_option_Trim_conversation();
		 chatsettingspage.click_delete_In_Delete_Messages_Popup();
		 Assert.assertEquals(Toast(),"Old messages successfully deleted");
	}
	 catch (NoSuchElementException e) {
		 chatsettingspage.click_option_Trim_conversation();
		 chatsettingspage.click_delete_In_Delete_Messages_Popup();
		 Assert.assertEquals(Toast(),"Old messages successfully deleted");
	}
	 
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	  
	   
  }
  
  
   /*
  Validate the working of the cancel button in the Delete all old messages now
    */
   @Test(priority =9 )
   public void To_Validate_working_of_cancel_button_in_Delete_all_old_messages_now () {
	   chatsettingspage = new ChatSettingsPage(driver);
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   chatsettingspage.click_option_Trim_conversation();
	   Assert.assertEquals(chatsettingspage.Delete_Old_Messages_Popup_Title(),"Delete All Old Messages Now?");
	   chatsettingspage.click_Cancel_In_Delete_Messages_Popup();
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
   }
   
   
   /*
   Validate Conversation length limit field Whether allowing space.
   */
   @Test(priority = 10)
   public void To_Validate_Conversation_length_limit_field_Whether_allowing_space () {
	   chatsettingspage = new ChatSettingsPage(driver);
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   chatsettingspage.click_Option_Conversation_Length();
	   chatsettingspage.set_Space_Inbetween_Values();
	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),200);
	   
   }
   
   /*
   validate whether paste option is working on Conversation length limit field.
   */
   @Test(priority = 11)
   public void To_Validate_whether_paste_option_is_working_on_Conversation_length_limit_field () {
	   chatsettingspage = new ChatSettingsPage(driver);
	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
	   chatsettingspage.click_Option_Conversation_Length();
	   chatsettingspage.Copy_And_Paste_Values();
	   Assert.assertEquals(chatsettingspage.getValue_from_Conversation_Length_option(),500);
   }
   
//   /*
//    Validate whether crusher blink in Conversation length limit field while clicking.
//    */
//   @Test(priority = 12)
//   public void To_Validate_whether_crusher_blink_in_Conversation_length_limit_field_while_clicking () {
//	   chatsettingspage = new ChatSettingsPage(driver);
//	   Assert.assertEquals(chatsettingspage.pageTitle(),"Chat Settings");
//	   chatsettingspage.click_Option_Conversation_Length();
//	   chatsettingspage.click_conversation_Length_text_box();
//	   WebElement active=driver.switchTo().activeElement();
//		Assert.assertTrue(.equals(active));
//   }
   
   
   
   
}
