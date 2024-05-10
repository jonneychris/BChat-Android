package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import Utiles.baseClass;

public class Home_Screen_And_Functionalities extends baseClass {
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	WebDriverWait wait;
	
	@Test(priority = 0)
	public void PreSetup () {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Chris");
		displaynamepage.clickContinue();
		registerpage= new RegisterPage(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
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
	public void To_Validate_navigation_from_the_home_screen_in_both_forward_and_backward_direction () {
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
	public void To_Validate_the_Navigation_to_the_settings_screen_in_both_forward_and_backward_direction() {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickSettingsDrawer();
		Assert.assertEquals(homepage.settingsTitle(), "Settings");
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
		Assert.assertEquals(homepage.searchTitle(), "Search");
	   homepage.clickBackArrow();
	   Assert.assertEquals(homepage.Pagetitle(), "BChat");
	   
	}
	
	/*
	Validate the presence of placeholder in the text box.
	*/
	@Test(priority = 5)
	public void To_Validate_the_presence_of_placeholder_in_the_text_box () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertEquals(homepage.SearchPlaceholder(), "Search people and groups");
	}
	
	
	

}
