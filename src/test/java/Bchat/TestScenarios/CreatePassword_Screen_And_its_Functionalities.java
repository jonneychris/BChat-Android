package Bchat.TestScenarios;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import Utiles.baseClass;


public class CreatePassword_Screen_And_its_Functionalities extends baseClass{
	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	RegisterPage registerpage;
	WebDriverWait wait;
	
	@Test(priority = 20, groups = {"Regression","Smoke"})
	public void preSetup() throws InterruptedException {
	
		
		landingpage.clickCreateAccount();
    DisplayNamePage	d = new DisplayNamePage(driver);
	d.setDisplayName("Chris");
	d.clickContinue();
	 registerpage = new RegisterPage(driver);
	wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
	Assert.assertEquals(registerpage.pageTitle(), "Register");
	registerpage.clickNext();
	
	}
		
	/*
	 TC_60	: Validate the next function without entering a value in Enter password 
	 */
	@Test(priority = 22,groups = {"Regression"})
	public void TC_60_To_Validate_the_next_function_without_entering_a_value_in_Enter_password_and_ReEnter_password () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		try {
		createpasswordpage.clickNext(); 
		}
		catch (ElementNotInteractableException e) {
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN"); 
			
		}
		}

	/*
	 TC_57	: Validate with Valid value in password field and Invalid value in Re-enter password field.
	 */
	@Test(priority = 23,groups = {"Regression"})
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
	Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
	driver.navigate().back();
			registerpage = new RegisterPage(driver);
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");			
	}
	
	
	/*
	 TC_62 : Validate the next function with a value in Enter password and without a value in Re-Enter password
	 */
	@Test(priority = 25,groups = {"Regression"})
	public void TC_62_To_Validate_the_next_function_with_value_only_In_Enter_password_Field () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		
		createpasswordpage.setPassword_0();
		try {
			createpasswordpage.clickNext();
			createpasswordpage.clickNext();
		}	
		catch(ElementNotInteractableException E){
			driver.navigate().back();
			registerpage = new RegisterPage(driver);
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		}
		
	}

	
	/*
	 TC_66 : Validate the Pin number fields in the Create password screen by entering values below boundary value in any one field
	 */
	@Test(priority =27,groups = {"Regression"})
	public void TC_66_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
		
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
				registerpage = new RegisterPage(driver);
				registerpage.clickNext();
				Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
				Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		
		
	}
	
	
	/*
	TC_76	Validate whether the value entered in the Pin number fields of the Create password is editable.
    TC_77	Validate whether the value entered in the Pin number fields of the Create password is deleteable.	
	*/
	@Test(priority=28,groups = {"Regression"})
	public void TC_76_And_77_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
		
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
			registerpage = new RegisterPage(driver);
			registerpage.clickNext();
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		}
			
		

		
		/*
		 TC_59	: Validate with Valid value in enter password field and Invalid value in Re-enter password field and repeat it for multiple times.	
		 */
		@Test(priority = 35,groups = {"Regression"})
		public void TC_59_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field_and_repeat_it_for_multiple_time(){
			
			
	
		for(int i=0;i<3;i++) {
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
				createpasswordpage.setInValidPassword();
				Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password does not match.");
				driver.navigate().back();
				registerpage = new RegisterPage(driver);
				registerpage.clickNext();
				Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
				Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
		}			
		}
	
		/*
	     TC_58	: Validate with Valid value in enter password field and Valid value in Re-enter password field.
	    */
		@Test(priority = 36 ,groups = {"Regression","Smoke"})
	public void TC_58_To_Validate_with_Valid_value_in_both_enter_password_field_and_in_ReEnter_password_field () {
	 
			createpasswordpage =new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			Assert.assertEquals(createpasswordpage.textEnter(),"Enter your PIN");
			createpasswordpage.setValidPassword();
			createpasswordpage.clickOk();
			recoveryphrasepage =new RecoveryPhrasePage(driver);
			
			wait =new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(recoveryphrasepage.textPageTitle));
			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
			
		}
		
	}
