package Bchat.TestScenarios;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.collect.ImmutableMap;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.LandingPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import Utiles.baseClass;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import Bchat.TestScenarios.*;

/*
Test Scenario:	To check the working of the Create Account Flow Displayname Screen
 */
public class Create_Account_Flow_DisplayName_Screen_And_Functionalities extends baseClass {
	
	 
	RegisterPage registerpage;
	WebDriverWait wait;
	DisplayNamePage displaynamepage;
   CreatePasswordPage createpasswordpage;
   RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	
	/*
	 PreSetup method to this class
	 */
	@Test(priority = 5,groups = {"Regression","Smoke"})
	public void PreSetup () {
		landingpage.clickCreateAccount();
    	displaynamepage = new DisplayNamePage(driver);
     	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
	}
	
	
	
    /*
     TC_37 :Validate the presence of placeholder in the text box of the Display Name screen.
     */    
        @Test(priority = 6, groups = {"Regression"} )
		public void TC_37_To_Validate_presence_of_placeholder_in_Display_Name_Textbox() {
	
        	displaynamepage = new DisplayNamePage(driver);
			Assert.assertEquals(displaynamepage.NameTextBoxPlachoder(),"Enter a display name");
		   
        }
		
        
        /*
         TC_36 : Validate whether crusher blink on clicking the text box of Display Name screen.
         */
        @Test(priority = 7,groups = {"Regression"})
		public void TC_36_To_Validate_whether_crusher_blink_on_clicking_textbox_of_Display_Name() {
		   
        	displaynamepage = new DisplayNamePage(driver);
        	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
			try {
				displaynamepage.clickTextBox();
				WebElement active=driver.switchTo().activeElement();
				Assert.assertTrue(displaynamepage.txtboxDisplayName.equals(active));
				//Assert.assertTrue(displaynamepage.txtboxDisplayName.equals(driver.switchTo().activeElement()));
				
			}
			catch(Throwable th) {
				th.printStackTrace();
			}
					
		     
		}
		
    /*
     TC_30 : Validate the continue functionality without enter any value in the text box.
     */
	@Test(priority = 8,groups = {"Regression"})
	public void TC_30_To_Validate_DisplayName_WithoutAny_Value () {
		
		displaynamepage = new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
        displaynamepage.clickContinue();
        Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
   
    }
	
	/*
	
	 */
	@Test(priority = 9,groups = {"Regression"})
	public void TC_34_To_Validate_DisplayName_With_Empty_Value () {
		
		displaynamepage = new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
		displaynamepage.setDisplayName("   ");
        displaynamepage.clickContinue();
   try {
    Assert.assertEquals(Toast(),"Please pick a display name");
   }
   catch (NoSuchElementException e) {
	   displaynamepage.clickContinue();
	   Assert.assertEquals(Toast(),"Please pick a display name");
   }
   catch (StaleElementReferenceException e) {
	   displaynamepage.clickContinue();
	   Assert.assertEquals(Toast(),"Please pick a display name");
   }
   catch (Exception e) {
	   Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
   }
   displaynamepage.cleardisplayname();
    }
    
    
	/*
	 TC_31 : Validate the text box of the Display Name screen by entering values above boundary value.
	 */
	@Test(priority = 10,groups = {"Regression"})
	public void TC_31_To_Validate_DisplayName_With_Above_Boundary_Value () {
		
		displaynamepage = new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");	
		displaynamepage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
        displaynamepage.clickContinue();
    try {
    Assert.assertEquals(Toast(),"Please pick a shorter display name");
    }
    catch (NoSuchElementException e) {
    	displaynamepage.clickContinue();
    	Assert.assertEquals(Toast(),"Please pick a shorter display name");
	} 
    catch (StaleElementReferenceException e) {
    	displaynamepage.clickContinue();
    	Assert.assertEquals(Toast(),"Please pick a shorter display name");
	} 
    catch (Exception e) {
    	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");	
	}
    displaynamepage.cleardisplayname();
    }
	
	/*
	    TC_34	Validate the text box of the Display Name screen with empty Space.
        TC_32	: Validate the text box of the Display Name screen by using special Characters.	
     TC_41	: Validate whether the value entered in the text box of display Name screen is editable.	
     TC_42	: Validate whether the value entered in the text box of display Name screen is deleteable.
	 */
	
	@Test(dataProvider="setInvaliddata",priority = 11,groups = {"Regression"})
	public void TC_To_Validate_DisplayName_With_Invalid_Datas (HashMap<String,String> input) throws IOException {
		
		//openingpage.clickCreateAccount();
		displaynamepage = new DisplayNamePage(driver);
		
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		displaynamepage.cleardisplayname();
		displaynamepage.setDisplayName(input.get("DisplayName"));
  		displaynamepage.clickContinue();
  		try {
  		Assert.assertEquals(Toast(),"Please enter a valid name"); 
  		}
  		catch (NoSuchElementException e) {
  	    	displaynamepage.clickContinue();
  	    	Assert.assertEquals(Toast(),"Please enter a valid name");
  		} 
  	    catch (StaleElementReferenceException e) {
  	    	displaynamepage.clickContinue();
  	    	Assert.assertEquals(Toast(),"Please enter a valid name");
  		} 
  	    catch (Exception e) {
  	    	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");	
  		}
	}
	
	
	@DataProvider
	public Object[][] setInvaliddata() throws IOException {
		
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//InvalidDisplayName.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
		
	}
	/*
	      TC_33	: Validate the text box of the Display Name screen using Alaphabats both in uppercase and lower case.
          TC_35	: Validate the text box of the Display Name screen by numerical value.
	 */
	@Test(dataProvider="setValiddata",priority = 12,groups = {"Regression","Smoke"})
	public void TC_To_Validate_DisplayName_With_valid_Datas (HashMap<String,String> input) throws IOException, InterruptedException {
		
		//openingpage.clickCreateAccount();
		displaynamepage = new DisplayNamePage(driver);
		
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		displaynamepage.cleardisplayname();
		displaynamepage.setDisplayName(input.get("DisplayName"));
   		displaynamepage.clickContinue();
		registerpage =	new RegisterPage(driver);		
		try {
		Assert.assertEquals(registerpage.pageTitle(), "Register"); 		
		}
		catch (StaleElementReferenceException e) {
			 Thread.sleep(3000);
			 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		}
		catch (NoSuchElementException e) {
			 Thread.sleep(3000);
			 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		}
		driver.navigate().back();	
		
		   

		    
	}
	
	
	@DataProvider
	public Object[][] setValiddata() throws IOException {
		
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//ValidDisplayName.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
		
	}
	
	/*
	 TC_39	: validate whether paste option is working on the text box display Name screen.
	 */
	@Test(priority =13,groups = {"Regression","Smoke"} )
	public void TC_39_To_Validate_Whether_Able_To_Paste_Values_In_TextBox () throws InterruptedException {
		displaynamepage = new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
		displaynamepage.pasteDisplayName("ChrisLan");
		displaynamepage.clickContinue();
	
		try {
			registerpage =	new RegisterPage(driver);		
			Assert.assertEquals(registerpage.pageTitle(), "Register"); 		
			}
			catch (StaleElementReferenceException e) {
				 Thread.sleep(3000);
				 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
			}
			catch (NoSuchElementException e) {
				 Thread.sleep(3000);
				 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
			}
	}
	
	
			/*
			 *
			 *
			 * Register screen
			 *
			 *
			 */
	
	/*
	 TC_48 : Validate Whether able to navigate to the previous screen.
	 */
	@Test(priority = 15,groups = {"Regression"})
	public void TC_48_To_Validate_Whether_able_to_navigate_to_previous_screen () {
		registerpage =new RegisterPage(driver);
		Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		driver.navigate().back();
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 		
		
	}
	
	/*
	 TC_49	: Validate whether ID and Address are change while navigating back and navigating in into the register screen.
	 */
	@Test(priority = 16,groups = {"Regression"})
	public void TC_49_To_Validate_whether_ID_And_Address_are_change_while_navigating_back_and_navigate_into_register_screen() throws InterruptedException {
	    
		displaynamepage =new DisplayNamePage(driver);
		 displaynamepage.clickContinue();
		 try {
			registerpage =new RegisterPage(driver);
			Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		 }
		 catch (StaleElementReferenceException e) {
			 Thread.sleep(3000);
			 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		}
		catch (NoSuchElementException e) {
			 Thread.sleep(3000);
			 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		}
		 String oldBChatId= registerpage.BChatID();
		String oldBeldexAddress= registerpage.BeldexAddress();
		driver.navigate().back();
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		 displaynamepage.clickContinue();
		 	Assert.assertNotEquals(oldBChatId, registerpage.BChatID());
			Assert.assertNotEquals(oldBeldexAddress, registerpage.BeldexAddress());
		
	
	}

	/*
	 TC_50	: Validate whether able to copy the ID and Address showing in the register screen.
	 */
	@Test(priority = 17,groups = {"Regression"})
	public void TC_50_To_Validate_whether_able_to_copy_ID_and_Address () {
		registerpage =new RegisterPage(driver);
		Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		Assert.assertFalse(registerpage.isBChatIdLongClickable());
		Assert.assertFalse(registerpage.isBeldexAddressLongClickable());
		
		
	}
	
	/*
	 TC_52	 : Validate whether ID and Address response for the touch action.
	 TC_52.1 : Validate whether able to edit the ID and Address
	 */
	@Test(priority = 18,groups = {"Regression"})
	public void TC_52_To_Validate_whether_ID_and_Address_were_Clickable_And_Editable() {
		registerpage =new RegisterPage(driver);
		Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		Assert.assertFalse(registerpage.isBChatIdClickable());
		Assert.assertFalse(registerpage.isBeldexAddressClickable());
		
	  
	}

	/*
	 TC_53	: Validate the working of the next functionality in the register screen.
	 */
	@Test(priority = 19,groups = {"Regression","Smoke"})
	public void TC_53_To_Validate_the_working_of_next_Button () {
		    registerpage =new RegisterPage(driver);	
		    Assert.assertEquals(registerpage.pageTitle(), "Register"); 
			registerpage.clickNext();
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
			
	}
	
	
	/*
	 * 
	 * 
	 * Create Password Screen
	 * 
	 * 
	 */
	
	
	/*
	 TC_60	: Validate the next function without entering a value in Enter password 
	 */
	@Test(priority = 21,groups = {"Regression"})
	public void TC_60_To_Validate_the_next_function_without_entering_a_value_in_Enter_password_and_ReEnter_password () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		createpasswordpage.clickNext(); 
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN"); 
			
		
		}

	/*
	 TC_57	: Validate with Valid value in password field and Invalid value in Re-enter password field.
	 */
	@Test(priority = 22,groups = {"Regression"})
	public void TC_57_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field (){
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
	try {
		createpasswordpage.setInValidPassword();
		Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password does not match.");		
	}
	catch (NoSuchElementException e) {
	   createpasswordpage.setPassword_1();
	   createpasswordpage.clickNext();
	   Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password does not match.");
	}
	catch (StaleElementReferenceException e) {
		   createpasswordpage.setPassword_1();
		   createpasswordpage.clickNext();
		   Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password does not match.");
		}
	catch (Exception e) {
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
	}
	       driver.navigate().back();
			registerpage = new RegisterPage(driver);
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");			
	}
	
	
	/*
	 TC_62 : Validate the next function with a value in Enter password and without a value in Re-Enter password
	 */
	@Test(priority = 23,groups = {"Regression"})
	public void TC_62_To_Validate_the_next_function_with_value_only_In_Enter_password_Field () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		
		createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		   driver.navigate().back();
		
	}

	
	/*
	 TC_66 : Validate the Pin number fields in the Create password screen by entering values below boundary value in any one field
	 */
	@Test(priority =24,groups = {"Regression"})
	public void TC_66_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
		
		registerpage = new RegisterPage(driver);
		registerpage.clickNext();
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		
		
			createpasswordpage.setPassword_with_below_boundary_value();
			createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textEnter(), "Enter your PIN");	
			createpasswordpage.click1();
			createpasswordpage.clickNext();
		
			createpasswordpage.setPassword_with_below_boundary_value();
			createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		
	         
	         driver.navigate().back();
				
		
		
	}
	
	
	/*
	TC_76	Validate whether the value entered in the Pin number fields of the Create password is editable.
   TC_77	Validate whether the value entered in the Pin number fields of the Create password is deleteable.	
	*/
	@Test(priority=25,groups = {"Regression"})
	public void TC_76_And_77_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
		registerpage = new RegisterPage(driver);
		registerpage.clickNext();
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
			
			createpasswordpage.setPassword_0();
			
			createpasswordpage.cancel_Values();
			
			createpasswordpage.setPassword_1();
			 
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
           createpasswordpage.setPassword_0();
			
			createpasswordpage.cancel_Values();
			
			createpasswordpage.setPassword_1();
			
			driver.navigate().back();
			
		}
			
		

		
		/*
		 TC_59	: Validate with Valid value in enter password field and Invalid value in Re-enter password field and repeat it for multiple times.	
		 */
		@Test(priority = 26,groups = {"Regression"})
		public void TC_59_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field_and_repeat_it_for_multiple_time(){
			registerpage = new RegisterPage(driver);
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
			
	
		for(int i=0;i<3;i++) {
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
				createpasswordpage.setInValidPassword();
				Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
				driver.navigate().back();
				registerpage = new RegisterPage(driver);
				registerpage.clickNext();
				Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
				Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		}		
		
		    driver.navigate().back();
		
		}
	
		/*
	     TC_58	: Validate with Valid value in enter password field and Valid value in Re-enter password field.
	    */
		@Test(priority = 27 ,groups = {"Regression","Smoke"})
	public void TC_58_To_Validate_with_Valid_value_in_both_enter_password_field_and_in_ReEnter_password_field () throws InterruptedException {
			registerpage = new RegisterPage(driver);
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
			createpasswordpage.setValidPassword();
			Thread.sleep(2000);
			createpasswordpage.clickOk();
			recoveryphrasepage =new RecoveryPhrasePage(driver);
			
			wait =new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(recoveryphrasepage.textPageTitle));
			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
			
		}
	
	
	
	
	/*
	 * 
	 * Recovery seed screen
	 * 
	 */

		
	
	
	/*
	 TC_82	Validate whether able to navigate to the next screen without copying the recovery seed.	
	 TC_83	Validate whether continue function is enable without copying the recovery seed.	
	 */
	@Test(priority = 29,groups = {"Regression"})
	 public void TC_82_To_Validate_whether_able_to_navigate_to_the_next_screen_without_copying_the_recovery_seed () {
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		try {
		recoveryphrasepage.ClickContinue();
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		}
		catch(ElementClickInterceptedException e) {
			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		}
	}
	
	
	/*
	 TC_81	Validate the working of the copy option in the recovery phase screen.
	 */
	@Test(priority = 30,groups = {"Regression"})
	public void TC_81_To_Validate_the_working_of_the_copy_option_in_the_recovery_phase_screen () {
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		Assert.assertEquals(Toast(),"Copied to clipboard");
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
	}
	
	
	

//	/*
//	 TC_ 87: To Validate by minimizing and open the App before copying the Seed 
//	 */
//	@Test(priority = 31 )
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
//	@Test(priority = 32)
//  public void TC_88_To_Validate_by_minimizing_and_open_the_App_After_copying_the_Seed () {
//		recoveryphrasepage =new RecoveryPhrasePage(driver);
//		driver.runAppInBackground(Duration.ofSeconds(3));
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.pageTitle,"BChat");
//	}
	
	
	/*
	TC_94 : To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority = 33,groups = {"Regression"})
	public void TC_85_To_Validate_Whether_Able_to_Navigate_Previous_screen () throws InterruptedException {
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		driver.navigate().back();	
       displaynamepage =new DisplayNamePage(driver);
       displaynamepage.clickContinue();
   	try {
		registerpage =	new RegisterPage(driver);		
		Assert.assertEquals(registerpage.pageTitle(), "Register"); 
		registerpage.clickNext();
		}
		catch (StaleElementReferenceException e) {
			 Thread.sleep(3000);
			 Assert.assertEquals(registerpage.pageTitle(), "Register"); 
			 registerpage.clickNext();
		}
      
      createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(2000);
        createpasswordpage.clickOk();
	}
	
	/*
	 * TC_84	Validate whether continue function is enable after copying the recovery seed.
	 TC_85	Validate the working of the  continue button after copying the recovery seed.
	 */
	@Test(priority = 34,groups = {"Regression","Smoke"} )
	public void TC_84_And_85_To_Validate_the_working_of_the_continue_button_after_copying_the_recovery_seed () {
		
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		try {
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertTrue(homepage.BlankChatScreen.isDisplayed());
		}
		catch(NoSuchElementException E) {
			
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			Assert.assertTrue(homepage.BlankChatScreen.isDisplayed());
		}
		}
	
}
