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
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		
	}
	
	
	
	
	/*
	Validate the all possible navigation from the home screen in both forward and backward direction
	Validate whether able to navigate to the device home page directly.
	*/
	@Test(priority = 1)
	public void To_Validate_navigation_from_the_home_screen_in_both_forward_and_backward_direction () throws InterruptedException {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		driver.navigate().back();
		 driver.navigate().back();
		 if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
			 landingpage.openApp();
	}
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
	
	}
	
	/*
	 Validate the blank screen While creating new Account
	 */
	@Test(priority = 2)
	public void To_Validate_the_blank_screen_While_creating_new_Account () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertTrue(homepage.BlankChatScreen.isDisplayed());
	}
	
	
	/*
	Validate the navigation to the settings screen in both forward and backward direction.
	*/
	@Test(priority = 3)
	public void To_Validate_the_Navigation_to_the_Menu_screen_in_both_forward_and_backward_direction() {
		homepage = new HomePage(driver);
		menupage =new MenuPage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		Assert.assertEquals(menupage.pagetitle(), "Menu");
		homepage.ClickCancel();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	/*
	Validate the navigation to the Search screen in both forward and backward direction.
	*/
	@Test(priority = 4)
	public void To_Validate_the_Navigation_to_the_search_screen_in_both_forward_and_backward_direction() {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickSearch();
		//Assert.assertEquals(homepage.searchTitle(), "Search");
	  // homepage.clickBackArrow();
	     driver.navigate().back();
	     driver.navigate().back();
		Assert.assertEquals(homepage.Pagetitle(), "BChat");
	   
	}
	
	
	/*
	 Validate the navigation to the new chat screen
	 */
	
	@Test(priority=5)
	public void To_validate_the_navigation_to_newChat_screen () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(), "New Chat");
		//homepage.clickBackArrow();
		driver.navigate().back();
	}
	
    /*
 	 validate the navigation to the create secret group screen	
    */
	@Test(priority=6)
	public void To_validate_the_navigation_to_Create_SecretGroup_screen () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openNewSecretGroup();
		secretgrouppage =new SecretGroupPage(driver);
		Assert.assertEquals(secretgrouppage.Pagetitle(), "Secret Group");
		//homepage.clickBackArrow();
		driver.navigate().back();
	}
	
	
	/*
	  Validate the navigation to the join social group screen
	 */
	@Test(priority=7)
	public void To_validate_the_navigation_to_Join_Social_screen () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		//homepage.clickBackArrow();
		driver.navigate().back();
	}
	


}
