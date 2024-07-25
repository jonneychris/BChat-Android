package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DisplayNamePage;
import POM.LandingPage;
import POM.RestoreFromSeedPage;
import POM.TermsAndCondtionsPage;

import Utiles.baseClass;


/*
 Test Scenario:	To Check the working of the Landing page screen and its Functionalities
 */
public class Landing_Screen_And_Functionality extends baseClass{
	
 	DisplayNamePage displaynamepage;
	RestoreFromSeedPage restorefromseedpage;
	TermsAndCondtionsPage termsandcondtionspage;
	WebDriverWait wait;
	
	
	/*
	 TC_3 : Validate whether functions and buttons in the openings screen response for the touch action. 
	 */
	@Test(priority = 0,groups = {"Regression"})
	public void  TC_3_Validate_whether_functions_and_buttons_is_Clickable () {
		
		landingpage =new LandingPage(driver);
		Assert.assertTrue(landingpage.isCreateAccountClickable());
		Assert.assertTrue(landingpage.isSignInClickable());
		Assert.assertTrue(landingpage.isTermsAndConditionsClickable());
	}
	
	
	/*
	TC_8 :	Validate whether able to navigate out of the App.
	 */
	@Test(priority = 1,groups = {"Regression"})
	public void TC_8_To_Validate_whether_able_to_navigate_out_And_Open_the_App_Again() {
		
		landingpage =new LandingPage(driver);
		 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
		 driver.navigate().back();
		try {
		 landingpage.openApp();
		Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
		}
		catch(Exception E) {
			 landingpage.openApp();
		}
	 
	}
	

	/*
	TC_4 : Validate the working of navigation to Create Account screen in both forward and backward direction
	 */
	@Test(priority = 2,groups = {"Regression","Smoke"})
	public void TC_4_To_Validate_the_navigation_to_Create_Account_screen_both_forward_and_backward_direction() {
		landingpage =new LandingPage(driver);
	 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	 landingpage.clickCreateAccount();
	 displaynamepage = new DisplayNamePage(driver);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
	 
	 Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
	 try {
		 driver.navigate().back();
		 if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
			 landingpage.openApp();
		 }
		 }
	 catch(Throwable e) {
		 e.printStackTrace();
		 
	 }
	 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	 
	}
	 

	/*
	TC_5 : Validate the working of navigation to Sign In screen in both forward and backward direction.
	 */
	@Test(priority = 3,groups = {"Regression","Smoke"})
	public void TC_5_To_Validate_the_navigation_to_SignIn_screen_both_forward_and_backward_direction() {
		landingpage =new LandingPage(driver);
		 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	 landingpage.clickSignIn();
	 restorefromseedpage =new RestoreFromSeedPage(driver);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOf(restorefromseedpage.textPageTitle));
	 Assert.assertEquals(restorefromseedpage.pageTitle(),"Restore Seed");

	 try {
		 driver.navigate().back();
		 if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
			 landingpage.openApp();
		 }
		 }
	 catch(Throwable e) {
		 e.printStackTrace();
		 
	 }
	 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	
	 
	}
	

	/*
	TC_6 : Validate the working of navigation to terms & conditions page in both forward and backward direction.
	 */
	@Test(priority = 4,groups ={"Regression","Smoke"} )
	public void TC_6_To_Validate_the_navigation_to_Terms_And_Conditions_screen_both_forward_and_backward_direction() throws InterruptedException {
		landingpage =new LandingPage(driver);
		 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	 landingpage.clickTermsAndConditions();
	 termsandcondtionspage =new TermsAndCondtionsPage(driver);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.visibilityOf(termsandcondtionspage.textPageTitle));
	 Assert.assertEquals(termsandcondtionspage.pageTitle(),"BChat Terms of Service");
	 driver.navigate().back();
	 Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	 
	}
	
	
	}
	
	


