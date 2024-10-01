package Bchat.TestScenarios;

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
import POM.MenuPage;
import POM.MessageRequestPage;
import POM.MyAccountPage;
import POM.NewChatPage;
import POM.NoteToMyselfPage;
import POM.NotificationPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeedPage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SettingsPage;
import POM.SocialGroupPage;
import POM.WalletPage;
import Utiles.baseClass;

public class Menu_Drawer_Screen_And_Functionalities extends baseClass{

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
	String EnteredDisplayName;
	NoteToMyselfPage notetomyself;
	SettingsPage settingspage;
	WalletPage walletpage;
	NotificationPage notificationpage;
	MessageRequestPage messagerequestpage;
	BlockedContactsPage blockedcontactspage;
	SeedPage seedpage;
	RestoreFromSeedPage restorefromseedpage;
	ChatPage chatpage;
	AccountSettingsPage accountsettingspage;
	ClearDataPage cleardatapage;
	RecoverySeedPage recoveryseedpage;
	MyAccountPage myaccountpage;
	
	
	/*
	 * 
	 * 
	 * All functions in the menu drawer screen except 1.Account Settings and 2.Wallet
	 * 
	 * 
	 */
			
	/*
	 Pre Setup to menu screen
	 */
	
	
	@Test(priority = 0,groups ={"Regression","Smoke"} )
	public void preSetup () throws InterruptedException {
		
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		 EnteredDisplayName =displaynamepage.setDisplayName("Chris");
		displaynamepage.clickContinue();
		registerpage= new RegisterPage(driver);
		try {
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		Thread.sleep(3000);
		}
		catch (StaleElementReferenceException e) {
			Assert.assertEquals(registerpage.pageTitle(),"Register");
			Thread.sleep(3000);
		}
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordPage(driver);
		try{
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		}
		catch (NoSuchElementException e) {
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		}
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
	     * 
	     * Menu Drawer screen
	     * 
	     * 		
	     */
	

	/*
	 Validate whether entered display name is showing in profile name.
	 */
	@Test (priority = 1,groups ={"Regression","Smoke"} )
	public void To_Validate_whether_entered_display_name_is_showing_in_profile_name () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
	     menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		Assert.assertEquals(menupage.getProfileName(), EnteredDisplayName);
		
	
	}
	

	
	/*
	TC_250 Validate the working of the scrolling action in both upward and downward direction.
	
	*/
	@Test (priority = 2,groups ={"Regression"} )
	public void TC_250_To_Validate_Whether_Screen_is_Scrollable () throws InterruptedException {
		
		menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.scroll_the_page(700, 750, 300, "down");
		Assert.assertEquals(menupage.contentAbout(), "About");
		
		
	}
	

	
	/*
	 * 
	 * 
	 * My Account Screen
	 * 
	 * 
	 */
	
	
	   /*
			Validate whether able to copy the Bchat Id and beldex Address
			*/
		@Test(priority =3,groups ={"Regression","Smoke"} )
		public void To_validate_whether_Able_to_Copy_Bchat_ID_and_Beldex_Address () {
			
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage = new MenuPage(driver);
			menupage.click_My_Account_option();
			   myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			  myaccountpage.click("BchatId");
		      myaccountpage.click("BchatId");
		  try {
		      
			  Assert.assertEquals(Toast(), "Copied to clip board");	  
		  }
		  catch (StaleElementReferenceException e) {
			  myaccountpage.click("BchatId");
			  Assert.assertEquals(Toast(), "Copied to clip board");	
		}
		  catch (NoSuchElementException e) {
			  myaccountpage.click("BchatId");
			  Assert.assertEquals(Toast(), "Copied to clip board");	
		}
		  myaccountpage.click("BeldexAddress");
		  myaccountpage.click("BeldexAddress");
		  try {
		  
			  Assert.assertEquals(Toast(), "Copied to clip board");
		  }
		  catch (StaleElementReferenceException e) {
			  myaccountpage.click("BeldexAddress");
			  Assert.assertEquals(Toast(), "Copied to clip board");
		}
		  catch (NoSuchElementException e) {
			  myaccountpage.click("BeldexAddress");
			  Assert.assertEquals(Toast(), "Copied to clip board");
		}
		}
		
		/*
		 Validate whether able to change the profile name.
		 */
		@Test(priority =4,groups ={"Regression","Smoke"}  )
		public void To_Validate_Whether_Able_to_Change_the_profile_name () {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			 myaccountpage.EditDisplayName("John");
			 myaccountpage.click_tick_inDisplayName();
			 driver.navigate().back();
			 homepage = new HomePage(driver);
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			 homepage.clickMenuDrawer();
			 menupage = new MenuPage(driver);
			 Assert.assertEquals(menupage.getProfileName(),"John");
			 menupage.click_My_Account_option();
		}
		 
		 
		 
		 
		/* 
		Validate whether able to change the profile name multiple times.
		*/
		@Test(priority = 5,groups ={"Regression"} )
		public void To_Validate_Whether_Able_to_change_Profile_Name_Multiple_times () {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			 myaccountpage.EditDisplayName("Abcd");
			  myaccountpage.click_tick_inDisplayName();
			  driver.navigate().back();
			  homepage = new HomePage(driver);
			  Assert.assertEquals(homepage.Pagetitle(),"BChat");
			  homepage.clickMenuDrawer();
			  menupage = new MenuPage(driver);
			  Assert.assertEquals(menupage.getProfileName(),"Abcd");
			  menupage.click_My_Account_option();
			  
			 myaccountpage.EditDisplayName("1234");
			 myaccountpage.click_tick_inDisplayName();
			 driver.navigate().back();
			 homepage = new HomePage(driver);
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			 homepage.clickMenuDrawer();
			 menupage = new MenuPage(driver);
			 Assert.assertEquals(menupage.getProfileName(),"1234");
			 menupage.click_My_Account_option();
			
			 myaccountpage.EditDisplayName("xyzz");
			 myaccountpage.click_tick_inDisplayName();
			 driver.navigate().back();
			 homepage = new HomePage(driver);
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			 homepage.clickMenuDrawer();
			 menupage = new MenuPage(driver);
			 Assert.assertEquals(menupage.getProfileName(),"xyzz");
			 menupage.click_My_Account_option();
		}
		
		
		
		
		/*
		Validate the working of the share button QR code Functionality.
	    */
		@Test(priority = 6 ,groups ={"Regression","Smoke"} )
		public void To_Validate_Working_of_Share_Button () {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			  myaccountpage.scroll_the_page(200, 600, 50, "down");
			  myaccountpage.ClickshareButton();
			  try{
				  Assert.assertTrue(myaccountpage.shareScreenTitle().equals("1 image in total"));
			  }
			  catch (NoSuchElementException e) {
				  myaccountpage.scroll_the_page(200, 600, 50, "down");
				  myaccountpage.ClickshareButton();
				  Assert.assertTrue(myaccountpage.shareScreenTitle().equals("1 image in total"));
			}
			  myaccountpage.clickcancel_In_share_Screen();
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		}
		
		
		
		/*
		Validate the navigation to home screen in both forward and backward direction.
		*/
		@Test(priority = 7,groups ={"Regression"} )
		public void	To_Validate_the_navigation_to_home_screen () {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			  myaccountpage.clickBackArrow();
			  homepage = new HomePage(driver);
				Assert.assertEquals(homepage.Pagetitle(),"BChat");
				homepage.clickMenuDrawer();
				menupage = new MenuPage(driver);
				menupage.click_My_Account_option();
				  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		}
		
		
		/*
		 Validate whether profile photo functionality is enable.
		 */
		@Test(priority =8,groups ={"Regression"} )
		public void To_Validate_whether_profile_photo_functionality_is_enable () {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			  myaccountpage.clickProfileIcon();
			 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");		  
			  myaccountpage.clickcancel_In_ProfilePicture_Screen();
			 
			 
		}
		
		/*
		 Validate whether remove picture button in profile popup is not clickable when there is no profile picture
		 */
		@Test(priority = 9,groups ={"Regression"} )
		public void To_Validate_whether_remove_picture_button_not_clickable_when_there_is_no_profile_picture () {
			myaccountpage =new  MyAccountPage(driver);
			Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			 myaccountpage.clickProfileIcon();
			 myaccountpage.clickRemovePicture();
			 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
			  myaccountpage.clickcancel_In_ProfilePicture_Screen();
		}
	
		/*
		Validate whether able to upload picture using camera option of the device.
		*/
		@Test(priority = 10,groups ={"Regression","Smoke"} )
		public void To_Validate_whether_able_to_upload_picture_using_camera_option_of_the_device () throws InterruptedException {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			  myaccountpage.clickProfileIcon();
			 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
			 myaccountpage.Set_Profile_Picture_from_Camera();
			 try{
				 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.invisibilityOf(myaccountpage.Loading_Animation()));
				myaccountpage.clickProfileIcon();
			 }
			 catch (NoSuchElementException e) {
				 myaccountpage.clickProfileIcon();
			}
			 myaccountpage.clickRemovePicture();
			 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		}
		
		/*
		 	Validate whether able to upload picture from gallery option of the device.
		 */
		@Test(priority = 11,groups ={"Regression","Smoke"} )
		public void To_Validate_whether_able_to_upload_picture_from_gallery_option_in_device () throws InterruptedException {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			  myaccountpage.clickProfileIcon();
			 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
			 try{
				 myaccountpage.Set_Profile_Picture_from_Gallery();
			 }
			 catch (NoSuchElementException e) {
				driver.navigate().back();
				myaccountpage.Set_Profile_Picture_from_Gallery2();
			}
			try {
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
				wait.until(ExpectedConditions.invisibilityOf(myaccountpage.Loading_Animation()));
			}
			catch (NoSuchElementException e) {
				Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			}
			}
		
			  		
		
		/*
		Validate whether able to remove the uploaded profile photo.
		*/
		@Test(priority = 12,groups ={"Regression","Smoke"} )
		public void To_Validate_whether_able_to_remove_the_uploaded_profile_photo () throws InterruptedException {
			myaccountpage =new  MyAccountPage(driver);
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			myaccountpage.clickProfileIcon();
			 myaccountpage.clickRemovePicture();
			 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
            myaccountpage.clickBackArrow();
		}
		
		
		
		/*
		Validate the working of the upload profile photo without internet
		Validate Whether Able to Edit display Name without internet
		*/
		@Test(priority = 13,groups ={"Regression"} )
		public void Validate_the_working_of_upload_profile_photo_and_Edit_Display_Name_without_internet () {			
			turnOff_Mobile_Wifi();	
			homepage = new HomePage(driver);
			try {
			Assert.assertTrue(homepage.hops_Warning().isDisplayed());
			}
			catch (NoSuchElementException e) {
				Assert.assertTrue(homepage.hops_Warning().isDisplayed());
			}
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_My_Account_option();
			myaccountpage =new  MyAccountPage(driver);
			 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
			myaccountpage.EditDisplayName("New"); 
			myaccountpage.click_tick_inDisplayName();
			 driver.navigate().back();
			 homepage = new HomePage(driver);
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			 homepage.clickMenuDrawer();
			 menupage = new MenuPage(driver);
			 Assert.assertEquals(menupage.getProfileName(),"New");
			 menupage.click_My_Account_option();
			
			try{
				myaccountpage.clickProfileIcon();
				myaccountpage.clickUpload();			
			Assert.assertEquals(Toast(),"Please check your internet connection");
			turnOn_Mobile_Wifi();
			}
			catch (NoSuchElementException e) {
				 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
				 turnOn_Mobile_Wifi();
			}
			
			myaccountpage.clickBackArrow();
			
		}
	

	
		/*
		 * 
		 * Settings screen 
		 * 
		 * 
		 */
	
	
	
	/*
	 Validate whether able to navigate back to the Menu screen
	 */
	@Test(priority = 14,groups ={"Regression"})
	public void To_Validate_whether_able_to_navigate_back_to_Menu_screen () {
		homepage = new HomePage(driver);
		homepage.clickMenuDrawer();
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		
	}
	
	/*
	Validate the working of the pay as you without enabling the wallet
	*/
	@Test(priority = 15,groups ={"Regression"})
	public void To_Validate_the_working_of_pay_as_you_without_enabling_the_wallet () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_PayAsYouChat();
		Assert.assertFalse(settingspage.Check_payAsYouChat_option().isEnabled());
	}
	
	/*
	 Validate the working of the Start wallet 
	*/
	@Test(priority = 16,groups ={"Regression","Smoke"})
	public void To_Validate_the_working_of_Start_wallet () {
		
		try{
			settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		}
		catch (NoSuchElementException e) {
			homepage = new HomePage(driver);
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_option_Settings();
			settingspage = new SettingsPage(driver);
			Assert.assertEquals(settingspage.pageTitle(),"Settings");
		}
		settingspage.click_start_wallet();
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickMenuDrawer();
		menupage.click_option_Wallet();
		walletpage = new WalletPage(driver);
		Assert.assertEquals(walletpage.Title_Wallet_Password(),"Create PIN");
		walletpage.click_Back_Arrow();
		
		
	}
	
	/*
	validate the working of the pay as you while enabling first time before entering into wallet
	 */
	@Test(priority = 17,groups ={"Regression"})
	public void To_validate_the_working_of_pay_as_you_while_enabling_first_time_before_entering_into_wallet () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_PayAsYouChat();
		Assert.assertEquals(settingspage.popupSetupPin(), "Setup Pin");
		settingspage.click_Cancel();
	}
	
	/*
	 Validate the working of the Send Link Previews option in both On and Off condition.
	*/
	@Test(priority = 18,groups ={"Regression"})
	public void To_Validate_the_working_of_Send_Link_Previews_option_in_both_On_and_Off_condition () throws InterruptedException {
		// to check in on condition
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		notetomyself = new NoteToMyselfPage(driver);
		notetomyself.Set_Values_In_Message_textbox("https://youtube.com/shorts/QE8EBWPLOUs?si=j5YE10X8O0_MHeWJ");
		Thread.sleep(2000);
		notetomyself.click_send_Button();
		Assert.assertTrue(notetomyself.Link_Preview().isDisplayed());
		notetomyself.delete_link();
		driver.navigate().back();
		
		//To check in off condition
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();	
		menupage = new MenuPage(driver);
		menupage.click_option_Settings();
		settingspage = new SettingsPage(driver);
		Assert.assertEquals(settingspage.pageTitle(),"Settings");
		settingspage.scrollgesture_Using_text("Voice and video calls");
		settingspage.click_Send_LinkPreview();
		settingspage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
		homepage.clickSearch();
		homepage.click_Option_Note_To_Myself();
		notetomyself = new NoteToMyselfPage(driver);
		try {
		notetomyself.Set_Values_In_Message_textbox("https://youtube.com/shorts/QE8EBWPLOUs?si=j5YE10X8O0_MHeWJ");
		Thread.sleep(1000);
		notetomyself.click_send_Button();
		Assert.assertFalse(notetomyself.Link_Preview().isDisplayed());
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
		}
	}
		
	
	
		/*
		 * 
		 * 
		 * Notification Screen
		 * 
		 * 
		 */
		
		
		/*
		 Validate whether able to navigate back to the Settings screen
		 */
		@Test(priority = 19,groups ={"Regression"})
		public void To_Validate_Whether_Able_To_Navigate_Back_To_The_Settings_Screen () {
			try {
			homepage = new HomePage(driver);
			homepage.clickMenuDrawer();
			}
			catch (NoSuchElementException e) {
				driver.navigate().back();
				homepage.clickMenuDrawer();
			}
			menupage = new MenuPage(driver);
		    menupage.click_Notification_option();
			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.click_Back_Arrow();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			
		}
		
		/*
		 Validate all options in the Nofication screen is enable if All Notications in ON Condition.
		 */
		@Test(priority = 20,groups ={"Regression"})
		public void To_Validate_all_options_in_Nofication_screen_is_enable_if_All_Notications_in_ON_Condition () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_Notification_option();
			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.scrollgesture_Using_text("Show");
			Assert.assertTrue(notificationpage.get_All_options_Element().isEnabled());
		}

		
		/*
		 Validate all options in the Nofication screen is enable if All Notications in Off Condition.
		 */
		@Test(priority = 21,groups ={"Regression"})
		public void To_Validate_all_options_in_Nofication_screen_is_enable_if_All_Notications_in_Off_Condition () {
			
			
			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			
			notificationpage.click_All_Notification_option();
			Assert.assertFalse(notificationpage.get_All_options_Element().isEnabled());
		}
		
		
		/*
		validate the navigation of the priority option
		*/
		@Test(priority = 22,groups ={"Regression"})
		public void To_validate_the_navigation_of_priority_option () {

			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.click_All_Notification_option();
			notificationpage.click_option_Priority();
			Assert.assertEquals(notificationpage.priority_screen_title(),"Default");
			driver.navigate().back();
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
		}
		
		
		/*
		Validate the working of the all radio buttons in the notification content.
		*/
		@Test(priority = 23,groups ={"Regression"})
		public void To_Validate_the_working_of_all_radio_buttons_in_notification_content () {
			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.Select_options_in_Show();
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
		}
		
		
		/*
		Validate whether the selected radio button is highlighted in the show option of the noftication content.
		*/
		@Test(priority = 24,groups ={"Regression"})
		public void To_Validate_whether_the_selected_radio_button_is_highlighted_in_show_option_of_noftication_content () {
			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.click_option_Show();
			Assert.assertEquals(notificationpage.Show_Popup_Title(), "Show");
			notificationpage.select_option_Name_Only();
			Assert.assertEquals(notificationpage.get_Showing_option_In_Show_field(), "Name only");
		
			notificationpage.click_option_Show();
			Assert.assertEquals(notificationpage.Show_Popup_Title(), "Show");
			notificationpage.select_option_No_Name_Or_content();
			Assert.assertEquals(notificationpage.get_Showing_option_In_Show_field(), "No name or content");
			
			notificationpage.click_option_Show();
			Assert.assertEquals(notificationpage.Show_Popup_Title(), "Show");
			notificationpage.select_option_Name_and_content();;
			Assert.assertEquals(notificationpage.get_Showing_option_In_Show_field(), "Name and content");
		}

		/*
		Validate the working of the cancel button in Show popup screen
		*/
		@Test(priority = 25,groups ={"Regression"})
		public void To_Validate_the_working_of_cancel_button_in_Show_popup_screen () {
			notificationpage= new NotificationPage(driver);
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.click_option_Show();
			Assert.assertEquals(notificationpage.Show_Popup_Title(), "Show");
			notificationpage.click_cancel_In_Show_Popup();
			Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
			notificationpage.click_Back_Arrow();
		}


		/*
		 * 
		 * 
		 * Report Issue Screen
		 * 
		 * 
		 */
		
		
		/*
		Validate whether able to navigate back to the home screen.
		*/
		@Test(priority = 26,groups ={"Regression"})
		public void To_Validate_whether_able_to_navigate_back_to_home_screen_from_Report_Issue () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_option_ReportIssue();
			chatpage = new ChatPage(driver);
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
			driver.navigate().back();
		   
			
		}
			

		/*
		Validate the text box of the Report Issue Functionality using special Characters.
		 Validate whether able to delete the send report
		*/
		@Test(priority = 29,groups ={"Regression"})
		public void To_Validate_the_textbox_of_Report_Issue_Functionality_using_special_Characters ()  {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			try{
				homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_option_ReportIssue();
			}
			catch (NoSuchElementException e) {
				homepage.clickMenuDrawer();
				menupage.click_option_ReportIssue();
			}
			chatpage = new ChatPage(driver);
			try {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
				}
				catch (AssertionError e1) {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
				}
			chatpage.Set_Values_In_Message_textbox("hi");
			chatpage.click_Send_Button();
			chatpage.Set_Values_In_Message_textbox("@!#$%");
			chatpage.click_Send_Button();
			Assert.assertEquals(chatpage.get_Second_Message_Value(),"@!#$%");
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
			
		}
		
		/*
		Validate the text box of the Report Issue Functionality using Alaphabats both in uppercase and lower case.
		*/
		@Test(priority = 30,groups ={"Regression"})
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
			Assert.assertEquals(chatpage.get_Second_Message_Value(), "ABCDEH");
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
			chatpage.Set_Values_In_Message_textbox("abcdef");
			chatpage.click_Send_Button();
			Assert.assertEquals(chatpage.get_Second_Message_Value(), "abcdef");
			wait.until(ExpectedConditions.visibilityOf(chatpage.SendMessageCard()));
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
			}
		
		/*
		Validate the text box of the Report Issue Functionality is Allowing the Space in between the value.
		*/
		@Test(priority = 31,groups ={"Regression"})
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
			Assert.assertEquals(chatpage.get_Second_Message_Value(), "Hi Hello ok");
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
			
		}
		
		/*
		Validate the text box of the Report Issue Functionality by numerical value.
		*/
		@Test(priority = 32,groups ={"Regression"})
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
			Assert.assertEquals(chatpage.get_Second_Message_Value(), "123456");
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
		}
		
		/*
		Validate the presence of placeholder in the text box of Report Issue functionality.
		*/
		@Test (priority = 33,groups ={"Regression"})
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
		@Test(priority = 34,groups ={"Regression"})
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
		@Test(priority = 35,groups ={"Regression"})
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
		@Test(priority = 36,groups ={"Regression"})
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
			Assert.assertEquals(chatpage.get_Second_Message_Value(), "Hello");
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
		}
		
			
		
		/*
		Validate whether able enter a lengthy value in the text box Report Issue functionality.
		*/
		@Test(priority = 37,groups ={"Regression"})
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
			Assert.assertEquals(chatpage.get_Second_Message_Value(), "hi hello iam doing good to havw erreo akdm anj jolhs odjjd oshsb okk nho");
			 try {
					chatpage.delete_second_message();
			     }
			     catch (NoSuchElementException e) {
			    	 chatpage.delete_second_message();
				}
					 try {chatpage.click_DeleteForEveryone();
					
			      }
			      catch (NoSuchElementException e) {
			    	  chatpage.click_delete_In_Popup();
					
				}
					try{
						chatpage.delete_Send_Message();
					}
					catch (NoSuchElementException e) {
						chatpage.delete_Send_Message();
					}
					chatpage.click_DeleteForEveryone();
		}
	
		
		/*
		Validate whether record option in the message functionality is enable.
		*/
		@Test(priority = 38,groups ={"Regression"})
		public void To_Validate_whether_record_option_in_message_functionality_is_enable () throws InterruptedException {
			chatpage = new ChatPage(driver);
			try {
				Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");
				}
				catch (AssertionError e1) {
					Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"bdb890a974a25ef50c64cc4e3270c4c49c7096c433b8eecaf011c1ad000e426813");	
				}
			chatpage.Record_Voice_Msg();
			chatpage.delete_Voice_message();
			
			}
		
		/*
		Validate whether the functions and icons response for the touch action.
		*/
		@Test(priority = 39,groups ={"Regression"})
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
			Assert.assertTrue(chatpage.Elements_of_Attachments().isDisplayed());
			driver.navigate().back();
		}
		
		
		
		/*
		 * 
		 * 
		 * 
		 * Message Request screen
		 * 
		 * 
		 */
		
		
		
		/*
		 Validate Message Requests Screen without any message request.
		 Validate whether able to navigate out of the screen
		 */
		@Test(priority = 40,groups ={"Regression","Smoke"})
		public void To_Validate_Message_Requests_Screen_without_any_message_request () {
			homepage = new HomePage(driver);
			try
			{
				homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_option_Message_requests();
			}
			catch (NoSuchElementException e) {
				menupage = new MenuPage(driver);
				menupage.click_option_Message_requests();				
			}
			messagerequestpage = new MessageRequestPage(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			Assert.assertTrue(messagerequestpage.Empty_screen().isDisplayed());
			messagerequestpage.click_Back_Arrow();
			
		}
		
				
		
		/*
		 pre for message request list in message request screen
		 */
		@Test(priority = 41,groups ={"Regression","Smoke"},invocationCount = 3)
		public void preSetup_For_Message_requests () throws InterruptedException {
			
			homepage = new HomePage(driver);
			homepage.OpenNewChat();
			newchatpage = new NewChatPage(driver);
			newchatpage.id_for_Message_Request();
			chatpage = new ChatPage(driver);
			chatpage.Send_one_msg();
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_Account_Settings();
			accountsettingspage = new AccountSettingsPage(driver);
			accountsettingspage.click_Clear_Data_option();
			cleardatapage = new ClearDataPage(driver);
			cleardatapage.click_ok();
			cleardatapage.click_Clear_Or_delete_option();
			preSetup();
					
	
		}

		
		/*
		Validate whether Message requests recevied from others is showing.
		*/
		@Test(priority = 42,groups ={"Regression","Smoke"})
		public void To_Validate_whether_Message_requests_recevied_from_others_is_showing() throws InterruptedException {
		     homepage = new HomePage(driver);
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_Account_Settings();
			accountsettingspage = new AccountSettingsPage(driver);
			accountsettingspage.click_Clear_Data_option();
			cleardatapage = new ClearDataPage(driver);
			cleardatapage.click_ok();
			cleardatapage.click_Clear_Or_delete_option();
			
			landingpage.clickSignIn();
			seedpage = new SeedPage(driver);
			seedpage.setSeedValue("else vaults hitched impel acidic afield woken yesterday casket adrenalin boldly unsafe fowls smash itches omnibus lagoon legion badge fictional pirate scamper tilt uptight badge");
			seedpage.clickNext();
			restorefromseedpage = new RestoreFromSeedPage(driver);
			restorefromseedpage.setDisplayName("Test");
			restorefromseedpage.selectTodayDate();
			restorefromseedpage.clickBtnRestore();
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			createpasswordpage.setValidPassword();
			Thread.sleep(1000);
			createpasswordpage.clickOk();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
		    menupage =new MenuPage(driver);
			menupage.click_option_Message_requests();
			messagerequestpage = new MessageRequestPage(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			try{
				Assert.assertTrue(messagerequestpage.Element_Of_First_Received_Request().isDisplayed());
			}
			catch (NoSuchElementException e) {
				Assert.assertTrue(messagerequestpage.Element_Of_First_Received_Request().isDisplayed());
			}
			

		}
            
		
		/*
		Validate the working of the cancel button in all popup screen
		*/
		@Test(priority = 43,groups ={"Regression"})
		public void To_Validate_the_working_of_cancel_button_in_all_popup_screen () {
			
			messagerequestpage = new MessageRequestPage(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			messagerequestpage.Click_Block_option();	
			messagerequestpage.click_cancel();
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			messagerequestpage.Click_Delete_option();
			messagerequestpage.click_cancel();
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");

		}
		
		/*
		Validate working of the Accept in  the Message Request
		*/
		@Test(priority = 44,groups ={"Regression","Smoke"})
		public void To_Validate_working_of_Accept_in_Message_Request () {
			
			messagerequestpage = new MessageRequestPage(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			String IdorName =messagerequestpage.Element_Of_First_Received_Request().getText();
			messagerequestpage.Accept_First_Request_In_List();
			chatpage = new ChatPage(driver);
			chatpage.click_Accept();
			chatpage.Set_Values_In_Message_textbox("hii");
			chatpage.click_Send_Button();
			driver.navigate().back();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(),IdorName);
			
		}
		
		/*
		Validate the working of the Block in the Message request
		*/
		@Test(priority = 45,groups ={"Regression","Smoke"})
		public void To_Validate_the_working_of_Block_in_Message_request () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new  MenuPage(driver);
			menupage.click_option_Message_requests();
			messagerequestpage = new  MessageRequestPage(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			String IdorName =messagerequestpage.Element_Of_First_Received_Request().getText();
			messagerequestpage.Block_First_request_In_List();
			messagerequestpage.click_Back_Arrow();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new  MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_Account_Settings();
			accountsettingspage = new AccountSettingsPage(driver);
			Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
			accountsettingspage.click_Blocked_contact_Option();
			blockedcontactspage = new BlockedContactsPage(driver);
			Assert.assertEquals(blockedcontactspage.pageTitle(),"Blocked Contacts");
			Assert.assertEquals(blockedcontactspage.get_Blocked_Contact_Id_Or_Name(),IdorName);
			blockedcontactspage.click_Back_Arrow();
			driver.navigate().back();
		}
		
		/*
		Validate working of the Delete in the Message request.
		*/
		@Test(priority = 46,groups ={"Regression","Smoke"})
		public void To_Validate_working_of_the_Delete_in_Message_request () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new  MenuPage(driver);
			menupage.click_option_Message_requests();
			messagerequestpage = new  MessageRequestPage(driver);
			Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
			messagerequestpage.Delete_First_Request_in_list();
			messagerequestpage.click_Back_Arrow();
			
		}

		
		
		
		/*
		 * 
		 * 
		 * Recovery Seed Screen
		 * 
		 * 
		 */
		
		
		/*
		Validate the working of the yes,I'm Safe option.
		*/
		@Test(priority = 47,groups ={"Regression"})
		public void To_Validate_the_working_of_yesIm_Safe_button () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
		    menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_option_Recovery_Seed();
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
			recoveryseedpage.click_Yes_Iam_Safe();
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		}
								
		
		/*
		Validate whether the value entered in the pin field is visible.
		*/
		@Test(priority = 48,groups ={"Regression"})
		public void To_Validate_whether_the_value_entered_in_pin_field_is_visible ()
		{
			recoveryseedpage = new RecoverySeedPage(driver); 
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");	
			recoveryseedpage.Enter_Value_1();
			Assert.assertNotEquals(recoveryseedpage.text_Value_inPin_fields(), "[1, 1, 1]");
			recoveryseedpage.Delete_Values_In_password();
		}
		
		
		/*
		Validate whether value entered in the pin field is deletable.
		Validate whether value entered in the pin field is Editable.
		*/
		@Test(priority = 49,groups ={"Regression"})
		public void To_Validate_whether_value_entered_in_pin_field_is_deletable_and_Editable () {
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
			recoveryseedpage.Enter_Value_1();
			recoveryseedpage.Delete_Values_In_password();
			recoveryseedpage.Enter_Value_2();
			recoveryseedpage.Delete_Values_In_password();
			
		}
		
		
		/*
		validate Whether able to navigate back to the previous screen from pin screen
		*/
		@Test(priority = 50,groups ={"Regression"})
		public void To_validate_Whether_able_to_navigate_back_to_previous_screen_from_pin_screen () {
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
			recoveryseedpage.click_BackArrow();
			Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
			
		}
		
		
		/*
		Validate whether able to navigate back to the home screen
		*/
		@Test(priority = 51,groups ={"Regression"})
		public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
			recoveryseedpage.click_BackArrow();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
		
		/*
		Validate the password word functionality in the recover seed screen with Invalid pin.
		*/
		@Test(priority = 52,groups ={"Regression","Smoke"})
		public void To_Validate_the_password_word_functionality_in_recover_seed_screen_with_Invalid_pin () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
		    menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_option_Recovery_Seed();
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
			recoveryseedpage.click_Yes_Iam_Safe();
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");			
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
			try {
			recoveryseedpage.Enter_InValid_Pin();
			Assert.assertEquals(Toast(), "Invalid Password.");
			}
			catch (StaleElementReferenceException e) {
				recoveryseedpage.Enter_InValid_Pin();
				Assert.assertEquals(Toast(), "Invalid Password.");
			}
			catch (NoSuchElementException e) {
				recoveryseedpage.Enter_InValid_Pin();
				Assert.assertEquals(Toast(), "Invalid Password.");
			}
			
			}
		
		/*
		Validate the password word functionality in the recover seed screen with valid pin.
		*/
		@Test(priority = 53,groups ={"Regression","Smoke"})
		public void To_Validate_the_password_word_functionality_in_recover_seed_screen_with_valid_pin () {
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
			recoveryseedpage.Enter_valid_Pin();
			Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		}
		
		
		/*
		Validate whether able to copy the seed.
		*/
		@Test(priority = 54,groups ={"Regression","Smoke"})
		public void To_Validate_whether_able_to_copy_the_seed (){
			recoveryseedpage = new RecoverySeedPage(driver);
			Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
			recoveryseedpage.click_Copy();
			try {
				recoveryseedpage.click_Copy();
			Assert.assertEquals(Toast(), "Copied to clip board");
			recoveryseedpage.click_BackArrow();
			}
			catch (StaleElementReferenceException e) {
				recoveryseedpage.click_Copy();
				Assert.assertEquals(Toast(), "Copied to clip board");
				recoveryseedpage.click_BackArrow();
			}
			catch (NoSuchElementException e) {
				recoveryseedpage.click_Copy();
				Assert.assertEquals(Toast(), "Copied to clip board");
				recoveryseedpage.click_BackArrow();
			}
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			
		}
		
							
		/*
		 * 
		 * 
		 * Help Screen and its function
		 * 
		 * 
		 */

		
		/*
		Validate the working of help functionality
		*/
		@Test(priority = 55,groups ={"Regression"} )
		public void To_Validate_the_working_of_help_functionality () {
			homepage = new HomePage(driver);
			homepage.clickMenuDrawer();			
			menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_option_Help();
			Assert.assertTrue(menupage.get_element_of_GmailScreen().isDisplayed());
		}
		
		
		/*
		Validate the to Gmail id in the Gmail screen.
		*/
		@Test(priority = 56,groups ={"Regression"} )
		public void To_Validate_the_to_Gmail_id_in_Gmail_screen () {
			menupage =new MenuPage(driver);
			Assert.assertTrue(menupage.get_element_of_GmailScreen().isDisplayed());
			Assert.assertEquals(menupage.get_to_mail_Id(), "support beldex");
		}
		
		
		/*
		Validate whether able to navigate back to the Home screen from gmail screen.
		*/
		@Test(priority = 57,groups ={"Regression"} )
		public void To_Validate_whether_able_to_navigate_back_to_Homescreen_from_gmailScreen () {
			menupage =new MenuPage(driver);
			Assert.assertTrue(menupage.get_element_of_GmailScreen().isDisplayed());
			driver.navigate().back();
			driver.navigate().back();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
		
		/*
		 * 
		 * Invite Function
		 * 
		 * 
		 */
		
		
		/*
		Validate the working of the Invite functionality
		*/
		@Test(priority = 58,groups ={"Regression","Smoke"} )
		public void To_Validate_the_working_of_Invite_functionality () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_option_Invite();
			Assert.assertTrue(menupage.get_Invite_Screen_element().isDisplayed());
		}
		
		/*
		Validate whether able to navigate back to the Home screen from invite.
		*/
		@Test(priority = 59,groups ={"Regression","Smoke"} )
		public void To_Validate_whether_able_to_navigate_back_to_HomeScreen_From_invite () {
			menupage =new MenuPage(driver);
			Assert.assertTrue(menupage.get_Invite_Screen_element().isDisplayed());
			menupage.click_cancel_In_Inivite();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
		
		/*
		 * 
		 * 
		 * About Screen
		 * 
		 * 
		 */
		
		
		/*
		 Validate the working of about functionality
		 */
		@Test(priority = 60,groups ={"Regression"} )
		public void To_Validate_the_working_of_about_functionality () {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.scroll_the_page(700, 750, 300, "down");
			Assert.assertEquals(menupage.contentAbout(), "About");
			menupage.click_option_About();
			Assert.assertEquals(menupage.About_Screen_Title(), "About");
			
		}
		

		/*
		Validate whether able to navigate back to the Home screen from about screen.
		*/
		@Test(priority = 61,groups ={"Regression"} )
		public void To_Validate_whether_able_to_navigate_back_to_HomeScreen_from_about_screen () {
			menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.About_Screen_Title(), "About");
			driver.navigate().back();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
		
		/*
		 * 
		 * 
		 * Theme Change Function
		 * 
		 */
		
		
		/*
		 validate the working of theme button
		 */
		@Test(priority = 62,groups ={"Regression","Smoke"} )
		public void To_validate_the_working_of_theme_Change_button () {
			homepage = new HomePage(driver);
			homepage.clickMenuDrawer();
			menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_theme_ChnageButton();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
		/*
		 validate whether able to click the theme change button multiple times
		 */
		@Test(priority = 63,groups ={"Regression"} )
		public void To_validate_whether_able_to_change_theme_multiple_times () {
			for(int i =0; i<=10;i++) {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage =new MenuPage(driver);
			menupage.click_theme_ChnageButton();
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			}
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			
		}
		 
}
