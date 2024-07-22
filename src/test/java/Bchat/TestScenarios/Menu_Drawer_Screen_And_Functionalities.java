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
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Menu_Drawer_Screen_And_Functionalities extends baseClass{

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
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
	
	/*
	 Validate whether entered display name is showing in profile name.
	 */
	@Test (priority = 1)
	public void To_Validate_whether_entered_display_name_is_showing_in_profile_name () {
		
	     menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		Assert.assertEquals(menupage.getProfileName(), EnterDisplayName);
		
	}
	
	
	/*
	TC_249 Validate whether the icons and functions present in the Settings screen response for the touch action.
	*/
	@Test (priority = 2)
	public void TC_249_To_Validate_Whether_icon_Response_For_touch_action (){
		menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_My_Account_option();
		
		driver.navigate().back();
		
	}

	/*
	TC_250 Validate the working of the scrolling action in both upward and downward direction.
	*/
	@Test (priority = 3)
	public void TC_250_To_Validate_Whether_Screen_is_Scrollable () throws InterruptedException {
		menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.scroll_the_page(700, 750, 300, "down");
	  // menupage.Scroll_the_Screen();
		Assert.assertEquals(menupage.contentAbout(), "About");
		Thread.sleep(5000);
	}
	
	
}
