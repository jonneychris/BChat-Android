package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.AppLockPage;
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

public class App_Lock_Screen_And_Its_functionalities extends baseClass{

	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;

	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	MenuPage menupage;
	AccountSettingsPage accountsettingspage;
	AppLockPage applockpage;
	/*
	 PreSetup to AppLock screen
	 */
	@Test(priority =0,groups ={"Regression","Smoke"} )
	public void preSetup () throws InterruptedException {
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
        accountsettingspage.click_App_Lock_Option();
	}
	

	/*
	Validate whether able to navigate back to the Account Screen.
	*/
	@Test(priority = 1,groups ={"Regression"} )
	public void To_Validate_whether_able_to_navigate_back_to_the_Account_Screen () {
		  accountsettingspage =new AccountSettingsPage(driver);
	        Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	        accountsettingspage.click_App_Lock_Option();
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_Back_Arrow();
		accountsettingspage =new AccountSettingsPage(driver);
	    Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
	    accountsettingspage.click_App_Lock_Option();
	    Assert.assertEquals(applockpage.pageTitle(),"App Lock");
	   
		
	}
	
	
	/*
	Validate whether the functions present in the App Lock screen response for the touch action.
	Validate navigation to the functions in the App Lock screen in both forward and backward direction.
	*/
	@Test(priority = 2,groups ={"Regression"} )
	public void To_Validate_navigation_to_the_functions_in_the_App_Lock_screen () {
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		
		applockpage.click_ChangePassword_option();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		applockpage.click_Back_Arrow();
		applockpage.click_ScreenLockTimeOut_option();
		Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
		applockpage.Clicl_Cancel_Icon();
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		
		
	}
		 
	 
	 /*
	Validate the Change password fields with Invalid Old password value
	*/
	@Test(priority = 3,groups ={"Regression","Smoke"} )
	public void To_Validate_the_Change_password_fields_with_Invalid_Old_password_value () {
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ChangePassword_option();
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setPassword_0();
		try {
		createpasswordpage.clickNext();
		Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		catch (StaleElementReferenceException e) {
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Incorrect password entered");
		}
		}
	
	
	/*
	Validate whether next button clickable without entering the values in all fields
	*/
	@Test(priority = 4,groups ={"Regression"} )
	public void To_Validate_whether_next_button_clickable_without_entering_the_values_in_all_fields () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		createpasswordpage.clickNext();
		driver.navigate().back();
	}
	/*
	Validate the password fields with valid Old password and valid New Password and invalid Reenter password
	*/
	 @Test(priority = 5,groups ={"Regression"} )
	 public void To_Validate_password_fields_with_valid_Old_password_and_valid_New_Password_and_invalid_ReEnter_password () {
		 applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			try {
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Password does not match.");
			}
			catch(StaleElementReferenceException e) {
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(), "Password does not match.");
			}
			driver.navigate().back();
	 }
	    /*
	     Validate whether able to set the new password with old password value
	     */
	 @Test(priority = 6,groups ={"Regression"} )
	 public void To_Validate_whether_able_to_set_the_new_password_with_old_password_value () {
		applockpage = new AppLockPage(driver);
		Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		applockpage.click_ChangePassword_option();
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		createpasswordpage.setPassword_1();
		try {
		createpasswordpage.clickNext();
		Assert.assertEquals(Toast(),"New password should not be same as old password.");
		}
		catch (StaleElementReferenceException e) {
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(),"New password should not be same as old password.");
		}
		driver.navigate().back();
	 
	 }

	 
	 /*
		Validate whether the value entered in all pin number fields is editable.
		Validate whether the value entered in all pin number fields is deleteable.
		*/
		@Test(priority=7,groups ={"Regression"} )
		public void TC_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
			
			
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.Delete_And_Edit_pin_field();	
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.cancel_Values();
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();  
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
			createpasswordpage.Delete_And_Edit_pin_field();
			driver.navigate().back();
				
				
			}
	 
	 /*
	Validate both the Password fields by entering values Below boundary value.
	*/
		@Test(priority =8,groups ={"Regression"} )
		public void TC_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
			
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click1();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");	
				createpasswordpage.click1();
				createpasswordpage.clickNext();
			
				Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click0();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");	
				createpasswordpage.click0();
				createpasswordpage.clickNext();	
				
				Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
				for(int i=0;i<3;i++){
					createpasswordpage.click0();
				}						
				createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");	
			
			driver.navigate().back();
				
												         		         						
		}
	
	
		  /* 
		Validate whether values entered in the pin number fields are visible
		*/
		@Test(priority = 9,groups ={"Regression"} )
		public void To_Validate_whether_values_entered_in_the_pin_number_fields_are_visible () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_1();
			
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[1, 1, 1, 1]");
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");	
			createpasswordpage.setPassword_0();
		
			
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[0, 0, 0, 0]");
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
			createpasswordpage.setPassword_1();
			Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[1, 1, 1, 1]");
	
			driver.navigate().back();
			
			
		}

		
		/*
		Validate the password fields with valid Old password and Valid New Password.
		*/
		@Test(priority = 10,groups ={"Regression","Smoke"} )
		public void To_Validate_password_fields_with_valid_Old_password_and_Valid_New_Password () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ChangePassword_option();
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textOldPin(),"Enter Old PIN");
			createpasswordpage.change_password_with_Valid_value();
			Assert.assertEquals(createpasswordpage.text_PasswordSuccessful(), "Password changed successfully.");
			createpasswordpage.clickOk();
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
		}
		 
		/*
		 Validate the scrolling in both upward and downward direction.
		 */
		@Test (priority = 11,groups ={"Regression"} )
		public void To_Validate_the_scrolling_in_both_upward_and_downward_direction () {
			
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Selected_option_In_Screenlock(), "None");
		
			
			for(int i =0;i <6;i++) {
				Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.scroll_the_page(530, 1225, 100, "down");
			}
			Assert.assertEquals(applockpage.Selected_option_In_Screenlock(), "30 Minutes");
			for(int i =0;i <6;i++) {
				Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
				applockpage.scroll_the_page(530, 1225, 100, "Up");
				}
			Assert.assertEquals(applockpage.Selected_option_In_Screenlock(), "None");
			
			
			    applockpage.click_cancel_Icon_In_screenlock();
			
			
			
			}
		
		/*
		 Validate the working of the Ok and Cancel option in the Screenlock inactivity timeout functionality
		 */
		@Test (priority = 12,groups ={"Regression"} )
		public void To_Validate_working_of_Ok_and_Cancel_option_in_Screenlock_inactivity_timeout_functionality () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.click_cancel_Icon_In_screenlock();
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			applockpage.click_ScreenLockTimeOut_option();
			Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.click_Ok_In_Screenlock();
			
			
		}
		
		
		/*
		 Validate the whether able to select all timing options in Screenlock inactivity timeout functionality
		 Validate whether the selected option is displayed in the AppLock screen.
		 */
		@Test (priority = 13,groups ={"Regression"} )
		public void To_Validate_whether_able_to_select_all_timing_options_in_Screenlock_inactivity_timeout_functionality_And_Selected_option_Is_displayed_in_AppLock_Screen () {
			applockpage = new AppLockPage(driver);
			Assert.assertEquals(applockpage.pageTitle(),"App Lock");
			
			Assert.assertEquals(applockpage.Showing_option_in_app_lock_screen(),"None");
			
		
			for(int i=0;i<6;i++) {
				applockpage.click_ScreenLockTimeOut_option();
				Assert.assertEquals(applockpage.Screen_TimeOut_Popup_screen_Title(), "Screen Inactivity Timeout");
			applockpage.scroll_the_page(530, 1225, 100, "down");
			applockpage.click_Ok_In_Screenlock();
			}
			Assert.assertEquals(applockpage.Showing_option_in_app_lock_screen(),"30 Minutes");
			
		}
		
		
}
