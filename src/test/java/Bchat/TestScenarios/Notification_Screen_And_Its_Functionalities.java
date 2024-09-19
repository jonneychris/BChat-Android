package Bchat.TestScenarios;


import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.NotificationPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeedPage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Notification_Screen_And_Its_Functionalities extends baseClass {

	
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
	String EnterDisplayName;
	NotificationPage notificationpage;
	/*
	 PreSetup
	 */
	@Test(priority = 0)
	public void PreSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		 EnterDisplayName =displaynamepage.setDisplayName("Chris");
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
		menupage.click_Notification_option();
	}
	
	/*
	 Validate whether able to navigate back to the Settings screen
	 */
	@Test(priority = 1)
	public void To_Validate_Whether_Able_To_Navigate_Back_To_The_Settings_Screen () {
		notificationpage= new NotificationPage(driver);
		Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
		notificationpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		
	}
	
	/*
	 Validate all options in the Nofication screen is enable if All Notications in ON Condition.
	 */
	@Test(priority = 2)
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
	@Test(priority = 3)
	public void To_Validate_all_options_in_Nofication_screen_is_enable_if_All_Notications_in_Off_Condition () {
		
		
		notificationpage= new NotificationPage(driver);
		Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
		
		notificationpage.click_All_Notification_option();
		Assert.assertFalse(notificationpage.get_All_options_Element().isEnabled());
	}
	
	
	/*
	validate the navigation of the priority option
	*/
	@Test(priority = 4)
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
	@Test(priority = 5)
	public void To_Validate_the_working_of_all_radio_buttons_in_notification_content () {
		notificationpage= new NotificationPage(driver);
		Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
		notificationpage.Select_options_in_Show();
		Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
	}
	
	
	/*
	Validate whether the selected radio button is highlighted in the show option of the noftication content.
	*/
	@Test(priority = 6)
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
	@Test(priority = 7)
	public void To_Validate_the_working_of_cancel_button_in_Show_popup_screen () {
		notificationpage= new NotificationPage(driver);
		Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
		notificationpage.click_option_Show();
		Assert.assertEquals(notificationpage.Show_Popup_Title(), "Show");
		notificationpage.click_cancel_In_Show_Popup();
		Assert.assertEquals(notificationpage.pageTitle(),"Notifications");
	}


}
