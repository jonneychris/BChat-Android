package Bchat.TestScenarios;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
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

import POM.DisplayNamePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import Utiles.baseClass;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;


/*
Test Scenario:	To check the working of the Create Account Flow Displayname Screen
 */
public class Create_Account_Flow_DisplayName_Screen_And_Functionalities extends baseClass{
	
	 
	RegisterPage registerpage;
	WebDriverWait wait;
    DisplayNamePage displaynamepage;
	
	
    /*
     TC_37 :Validate the presence of placeholder in the text box of the Display Name screen.
     */    
  
        @Test(priority = 0)
		public void TC_37_To_Validate_presence_of_placeholder_in_Display_Name_Textbox() {
		   
        	landingpage.clickCreateAccount();
        	displaynamepage = new DisplayNamePage(driver);
        	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
			Assert.assertEquals(displaynamepage.NameTextBoxPlachoder(),"Enter a display name");
		   
        }
		
        
//        /*
//         TC_36 : Validate whether crusher blink on clicking the text box of Display Name screen.
//         */
//        @Test(priority = 1)
//		public void TC_36_To_Validate_whether_crusher_blink_on_clicking_textbox_of_Display_Name() {
//		   
//        	displaynamepage = new DisplayNamePage(driver);
//        	Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
//			try {
//				displaynamepage.clickTextBox();
//				WebElement active=driver.switchTo().activeElement();
//				Assert.assertTrue(displaynamepage.txtboxDisplayName.equals(active));
//				//Assert.assertTrue(displaynamepage.txtboxDisplayName.equals(driver.switchTo().activeElement()));
//				
//			}
//			catch(Throwable th) {
//				th.printStackTrace();
//			}
//					
//		     
//		}
//		
//    /*
//     TC_30 : Validate the continue functionality without enter any value in the text box.
//     */
//	@Test(priority = 2)
//	public void TC_30_To_Validate_DisplayName_WithoutAny_Value () {
//		
//		displaynamepage = new DisplayNamePage(driver);
//		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
//    try {
//    displaynamepage.clickContinue();
//    Assert.assertEquals(Toast(),"Please pick a display name");
//    
//    }
//    catch(Throwable e) {
//    	e.printStackTrace();
//    }
//    }
//	
//	/*
//	
//	 */
//	@Test(priority = 3)
//	public void TC_34__To_Validate_DisplayName_With_Empty_Value () {
//		
//		displaynamepage = new DisplayNamePage(driver);
//		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
//		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
//    displaynamepage.setDisplayName("   ");
//    try {
//    displaynamepage.clickContinue();
//    Assert.assertEquals(Toast(),"Please pick a display name");
//    displaynamepage.cleardisplayname();
//    }
//    
//    catch(Throwable e) {
//    	e.printStackTrace();
//    }
//    }
//	/*
//	 TC_31 : Validate the text box of the Display Name screen by entering values above boundary value.
//	 */
//	@Test(priority = 4)
//	public void TC_31_To_Validate_DisplayName_With_Above_Boundary_Value () {
//		
//		displaynamepage = new DisplayNamePage(driver);
//		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");	
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
//    displaynamepage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
//    displaynamepage.clickContinue();
//    Assert.assertEquals(Toast(),"Please pick a shorter display name");
//    displaynamepage.cleardisplayname();
//    }
//	
	/*
	    TC_34	Validate the text box of the Display Name screen with empty Space.
        TC_32	: Validate the text box of the Display Name screen by using special Characters.	
     TC_41	: Validate whether the value entered in the text box of display Name screen is editable.	
     TC_42	: Validate whether the value entered in the text box of display Name screen is deleteable.
	 */
	
	@Test(dataProvider="setInvaliddata",priority = 5)
	public void TC_To_Validate_DisplayName_With_Invalid_Datas (HashMap<String,String> input) throws IOException {
		
		//openingpage.clickCreateAccount();
		displaynamepage = new DisplayNamePage(driver);
		
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		displaynamepage.cleardisplayname();
		displaynamepage.setDisplayName(input.get("DisplayName"));
  		displaynamepage.clickContinue();
  		Assert.assertEquals(Toast(),"Please enter a valid name"); 
		
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
	@Test(dataProvider="setValiddata",priority = 6)
	public void TC_To_Validate_DisplayName_With_valid_Datas (HashMap<String,String> input) throws IOException {
		
		//openingpage.clickCreateAccount();
		displaynamepage = new DisplayNamePage(driver);
		
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		displaynamepage.cleardisplayname();
		displaynamepage.setDisplayName(input.get("DisplayName"));
   		displaynamepage.clickContinue();
			registerpage =	new RegisterPage(driver);		 
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));		    
			Assert.assertEquals(registerpage.pageTitle(), "Register"); 		
		    driver.navigate().back();	
		    wait.until(ExpectedConditions.visibilityOf(displaynamepage.textPageTitle));
  
	}
	
	
	@DataProvider
	public Object[][] setValiddata() throws IOException {
		
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//ValidDisplayName.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
		
	}
//	
//	/*
//	 TC_39	: validate whether paste option is working on the text box display Name screen.
//	 */
//	@Test(priority =6 )
//	public void TC_39_To_Validate_Whether_Able_To_Paste_Values_In_TextBox () throws InterruptedException {
//		displaynamepage = new DisplayNamePage(driver);
//		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name");
//		
//		
//		try {
//			displaynamepage.pasteDisplayName("ChrisLang");
//		displaynamepage.clickContinue();
//		registerpage =	new RegisterPage(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
//		Assert.assertEquals(registerpage.pageTitle(), "Register"); 
//		driver.navigate().back();
//		displaynamepage.cleardisplayname();
//		}
//		catch(Throwable th) {
//			th.printStackTrace();
//		}
//      
//	}
//	
//	
//	
//	
//	
//	
//	
}
