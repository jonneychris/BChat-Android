package Bchat.TestScenarios;

import static org.junit.Assert.assertArrayEquals;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
import POM.RecoverySeedPage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Recovery_Seed_Screen_And_Its_Functionality extends baseClass{

	
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
	RecoverySeedPage recoveryseedpage;
	
	/*
	Pre Setup To Recovery Seed screen
	*/
	@Test(priority = 0)
	public void Presetup () throws InterruptedException {
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
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Recovery_Seed();
	}
	
	/*
	Validate whether able to navigate back to the home screen
	*/
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
		recoveryseedpage = new RecoverySeedPage(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_BackArrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	
	
	
	/*
	Validate the working of the yes,I'm Safe option.
	*/
	@Test(priority = 2)
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
	validate Wehther able to navigate back to the previous screen from pin screen
	*/
	@Test(priority = 3)
	public void To_validate_Wehther_able_to_navigate_back_to_previous_screen_from_pin_screen () {
		recoveryseedpage = new RecoverySeedPage(driver);
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		recoveryseedpage.click_BackArrow();
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		
	}

	
	/*
	Validate whether the value entered in the pin field is visible.
	*/
	@Test(priority = 4)
	public void To_Validate_whether_the_value_entered_in_pin_field_is_visible ()
	{
		recoveryseedpage = new RecoverySeedPage(driver);
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
		recoveryseedpage.click_Yes_Iam_Safe();
   
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");	
		recoveryseedpage.Enter_Value_1();
		Assert.assertNotEquals(recoveryseedpage.text_Value_inPin_fields(), "[1, 1, 1]");
		recoveryseedpage.Delete_Values_In_password();
	}
	
	
	/*
	Validate whether value entered in the pin field is deletable.
	Validate whether value entered in the pin field is Editable.
	*/
	@Test(priority = 5)
	public void To_Validate_whether_value_entered_in_pin_field_is_deletable_and_Editable () {
		recoveryseedpage = new RecoverySeedPage(driver);
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		recoveryseedpage.Enter_Value_1();
		recoveryseedpage.Delete_Values_In_password();
		recoveryseedpage.Enter_Value_2();
		recoveryseedpage.Delete_Values_In_password();
		
	}
	
	
	/*
	Validate the password word functionality in the recover seed screen with Invalid pin.
	*/
	@Test(priority = 6)
	public void To_Validate_the_password_word_functionality_in_recover_seed_screen_with_Invalid_pin () {
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
	@Test(priority = 7)
	public void To_Validate_the_password_word_functionality_in_recover_seed_screen_with_valid_pin () {
		recoveryseedpage = new RecoverySeedPage(driver);
		Assert.assertEquals(recoveryseedpage.Pin_Screen_title(), "Verify PIN");
		recoveryseedpage.Enter_valid_Pin();
		Assert.assertEquals(recoveryseedpage.pageTitle(),"Recovery Seed");
	}
	
	
	/*
	Validate whether able to copy the seed.
	*/
	@Test(priority = 8)
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
	
	
}
