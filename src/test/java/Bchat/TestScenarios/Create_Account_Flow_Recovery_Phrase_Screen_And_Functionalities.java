package Bchat.TestScenarios;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import Utiles.baseClass;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import pages.OpeningPage;
/*
 Test Scenario:	To Check the working of the Recovery phase Screen in create account flow
 */
public class Create_Account_Flow_Recovery_Phrase_Screen_And_Functionalities extends baseClass{

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	WebDriverWait wait;
	
    @Test(priority = 37,groups = {"Regression","Smoke"})
	public void presetup() {
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
	}
	
	

	/*
	 TC_82	Validate whether able to navigate to the next screen without copying the recovery seed.	
	 TC_83	Validate whether continue function is enable without copying the recovery seed.	
	 */
	@Test(priority = 38,groups = {"Regression"})
	 public void TC_82_To_Validate_whether_able_to_navigate_to_the_next_screen_without_copying_the_recovery_seed () {
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
		try {
		recoveryphrasepage.ClickContinue();
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
		}
		catch(ElementClickInterceptedException e) {
			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
		}
	}
	
	
	/*
	 TC_81	Validate the working of the copy option in the recovery phase screen.
	 */
	@Test(priority = 39,groups = {"Regression"})
	public void TC_81_To_Validate_the_working_of_the_copy_option_in_the_recovery_phase_screen () {
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
		recoveryphrasepage.clickCopyIcon();
		Assert.assertEquals(Toast(),"Copied to clipboard");
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
	}
	
	
	

//	/*
//	 TC_ 87: To Validate by minimizing and open the App before copying the Seed 
//	 */
//	@Test(priority = 40 )
//	public void TC_87_To_Validate_by_minimizing_and_open_the_App_before_copying_the_Seed () {
//		recoveryphrasepage =new RecoveryPhrasePage(driver);
//		driver.runAppInBackground(Duration.ofSeconds(3));
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.popuptitle(),"Save your seed");
//		homepage.clickok();
//	  recoveryseedpage = new RecoverySeed_Page(driver);
//	  Assert.assertEquals(recoveryseedpage.importantScreen(), "IMPORTANT");
//	  driver.navigate().back();
//	  
//	 }
//	
//	/*
//	 TC_ 88: To Validate by minimizing and open the App after copying the Seed 
//	 */
//	@Test(priority = 41)
//   public void TC_88_To_Validate_by_minimizing_and_open_the_App_After_copying_the_Seed () {
//		recoveryphrasepage =new RecoveryPhrasePage(driver);
//		driver.runAppInBackground(Duration.ofSeconds(3));
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.pageTitle,"BChat");
//	}
	
	
	/*
	TC_94 : To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority = 42,groups = {"Regression"})
	public void TC_85_To_Validate_Whether_Able_to_Navigate_Previous_screen () {
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
		driver.navigate().back();
		createpasswordpage = new CreatePasswordPage(driver);
       Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
       displaynamepage =new DisplayNamePage(driver);
       displaynamepage.clickContinue();
       createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
       
	}
	
	/*
	 * TC_84	Validate whether continue function is enable after copying the recovery seed.
	 TC_85	Validate the working of the  continue button after copying the recovery seed.
	 */
	@Test(priority = 43,groups = {"Regression","Smoke"} )
	public void TC_84_And_85_To_Validate_the_working_of_the_continue_button_after_copying_the_recovery_seed () {
		
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
		recoveryphrasepage.clickCopyIcon();
		try {
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		catch(NoSuchElementException E) {
			
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		}
	
	
	
	

	
	
	
	
}
