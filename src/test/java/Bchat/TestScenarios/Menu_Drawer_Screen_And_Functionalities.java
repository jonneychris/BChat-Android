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
import POM.RecoveryPhrasePage;

import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
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
	String EnterDisplayName;
	
	
	/*
	 Pre Setup to menu screen
	 */
	@Test(priority = 0)
	public void preSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		 EnterDisplayName =displaynamepage.setDisplayName("Chris");
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
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
			}
	
//	/*
//	 Validate whether entered display name is showing in profile name.
//	 */
//	@Test (priority = 1)
//	public void To_Validate_whether_entered_display_name_is_showing_in_profile_name () {
//		
//	     menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		Assert.assertEquals(menupage.getProfileName(), EnterDisplayName);
//		
//	}
//	
//	
//	/*
//	TC_249 Validate whether the icons and functions present in the Settings screen response for the touch action.
//	*/
//	@Test (priority = 2)
//	public void TC_249_To_Validate_Whether_icon_Response_For_touch_action (){
//		menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_My_Account_option();
//		
//		driver.navigate().back();
//		
//	}
//
//	/*
//	TC_250 Validate the working of the scrolling action in both upward and downward direction.
//	*/
//	@Test (priority = 3)
//	public void TC_250_To_Validate_Whether_Screen_is_Scrollable () throws InterruptedException {
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//		menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.scroll_the_page(700, 750, 300, "down");
//	  // menupage.Scroll_the_Screen();
//		Assert.assertEquals(menupage.contentAbout(), "About");
//		
//	}
	
	/*
	Validate the working of help functionality
	*/
	@Test(priority = 4)
	public void To_Validate_the_working_of_help_functionality () {
		menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Help();
		Assert.assertTrue(menupage.get_element_of_GmailScreen().isDisplayed());
	}
	
	
	/*
	Validate the to Gmail id in the Gmail screen.
	*/
	@Test(priority = 5)
	public void To_Validate_the_to_Gmail_id_in_Gmail_screen () {
		menupage =new MenuPage(driver);
		Assert.assertTrue(menupage.get_element_of_GmailScreen().isDisplayed());
		Assert.assertEquals(menupage.get_to_mail_Id(), "support beldex");
	}
	
	
	/*
	Validate whether able to navigate back to the Home screen from gmail screen.
	*/
	@Test(priority = 6)
	public void To_Validate_whether_able_to_navigate_back_to_Homescreen_from_gmailScreen () {
		menupage =new MenuPage(driver);
		Assert.assertTrue(menupage.get_element_of_GmailScreen().isDisplayed());
		driver.navigate().back();
		driver.navigate().back();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	/*
	Validate the working of the Invite functionality
	*/
	@Test(priority = 7)
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
	@Test(priority = 8)
	public void To_Validate_whether_able_to_navigate_back_to_HomeScreen_From_invite () {
		menupage =new MenuPage(driver);
		Assert.assertTrue(menupage.get_Invite_Screen_element().isDisplayed());
		menupage.click_cancel_In_Inivite();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	/*
	 Validate the working of about functionality
	 */
	@Test(priority = 9)
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
	Validate whether able to scroll the about screen
	*/
	@Test(priority = 10)
	public void To_Validate_whether_able_to_scroll_the_about_screen () {
		menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.About_Screen_Title(), "About");
		menupage.scroll_the_page(450, 1000 , 1000, "Down");
	}

	/*
	Validate whether able to navigate back to the Home screen from about screen.
	*/
	@Test(priority = 11)
	public void To_Validate_whether_able_to_navigate_back_to_HomeScreen_from_about_screen () {
		menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.About_Screen_Title(), "About");
		menupage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	
	/*
	 validate the working of theme button
	 */
	@Test(priority = 12)
	public void To_validate_the_working_of_theme_button () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage =new MenuPage(driver);
		menupage.click_theme_ChnageButton();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	/*
	 validate whether able to click the theme change button multiple times
	 */
	@Test(priority = 13)
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
