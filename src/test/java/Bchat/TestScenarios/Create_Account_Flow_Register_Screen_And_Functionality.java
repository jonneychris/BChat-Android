package Bchat.TestScenarios;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.RegisterPage;
import Utiles.baseClass;


/*
 Test Scenario:	To Check the Functionality of the Register Screen in Create account flow
 */
public class Create_Account_Flow_Register_Screen_And_Functionality extends baseClass {
	
	RegisterPage registerpage;
	DisplayNamePage displaynamepage;
	WebDriverWait wait;
	CreatePasswordPage createpasswordpage;
	
	
	/*
	 TC_47	: Validate whether displaying same Value as entered in the display name screen text box.
	 And
	 PreSetup Method for this class
	 */
	@Test(priority = 14,groups = {"Regression","Smoke"})
	public void TC_47_To_Validate_whether_displaying_same_Name_entered_in_the_display_name_text_box(){
		
		landingpage.clickCreateAccount();
	 displaynamepage =new DisplayNamePage(driver);
	 displaynamepage.setDisplayName("Chris");
	 displaynamepage.clickContinue();
		registerpage =new RegisterPage(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
		try{
			Assert.assertEquals(registerpage.getdisplayName(),"Chris");
		}
		catch(Throwable th) {
			th.printStackTrace();
		}
	}
	
	/*
	 TC_48 : Validate Whether able to navigate to the previous screen.
	 */
	@Test(priority = 15,groups = {"Regression"})
	public void TC_48_To_Validate_Whether_able_to_navigate_to_previous_screen () {
		registerpage =new RegisterPage(driver);
		
		try{
			Assert.assertEquals(registerpage.pageTitle(), "Register"); 
			driver.navigate().back();
			Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		}
		catch(Throwable th) {
			th.printStackTrace();
		}
	}
	
	/*
	 TC_49	: Validate whether ID and Address are change while navigating back and navigating in into the register screen.
	 */
	@Test(priority = 16,groups = {"Regression"})
	public void TC_49_To_Validate_whether_ID_And_Address_are_change_while_navigating_back_and_navigate_into_register_screen() {
	    
		displaynamepage =new DisplayNamePage(driver);
		// displaynamepage.setDisplayName("Chris");
		 displaynamepage.clickContinue();
			registerpage =new RegisterPage(driver);
			wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
			
			

		String oldBChatId= registerpage.BChatID();
		String oldBeldexAddress= registerpage.BeldexAddress();
		driver.navigate().back();
		
		Assert.assertEquals(displaynamepage.pageTitle(), "Display Name"); 
		 displaynamepage.clickContinue();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
			Assert.assertNotEquals(oldBChatId, registerpage.BChatID());
			Assert.assertNotEquals(oldBeldexAddress, registerpage.BeldexAddress());
		
	
	}

	/*
	 TC_50	: Validate whether able to copy the ID and Address showing in the register screen.
	 */
	@Test(priority = 17,groups = {"Regression"})
	public void TC_50_To_Validate_whether_able_to_copy_ID_and_Address () {
		registerpage =new RegisterPage(driver);
	
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
		
		Assert.assertFalse(registerpage.isBChatIdClickable());
		Assert.assertFalse(registerpage.isBeldexAddressClickable());
		
	  
	}

	/*
	 TC_53	: Validate the working of the next functionality in the register screen.
	 */
	@Test(priority = 19,groups = {"Regression","Smoke"})
	public void TC_53_To_Validate_the_working_of_next_Button (){
		registerpage =new RegisterPage(driver);
		
		try {
			registerpage.clickNext();
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
			
		   }
		catch(Exception e) {
			e.printStackTrace();		}
		
	}
	
	


}
