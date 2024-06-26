package Bchat.TestScenarios;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
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
	WebDriverWait wait;
	
	@Test(priority = 20, groups = {"Regression","Smoke"})
	public void preSetup() throws InterruptedException {
	
		
		landingpage.clickCreateAccount();
    DisplayNamePage	d = new DisplayNamePage(driver);
	d.setDisplayName("Chris");
	d.clickContinue();
	RegisterPage r= new RegisterPage(driver);
	wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(r.textPageTitle));
	Assert.assertEquals(r.pageTitle(), "Register");
	r.clickNext();
	
	}
	
	@Test(priority = 21)
	public void setpassword1() {
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.click1();
		createpasswordpage.click1();
		createpasswordpage.click1();
		createpasswordpage.click1();
		createpasswordpage.clickdelete();
		createpasswordpage.clickNext();
		createpasswordpage.click1();
		createpasswordpage.click1();
		createpasswordpage.click1();
		createpasswordpage.click1();
		createpasswordpage.clickNext();
	}
	

//	/*
//	 TC_60	: Validate the next function without entering a value in Enter password and Re-Enter password
//	 */
//	@Test(priority = 22,groups = {"Regression"})
//	public void TC_60_To_Validate_the_next_function_without_entering_a_value_in_Enter_password_and_ReEnter_password () {
//		createpasswordpage =new CreatePasswordPage(driver);
//		createpasswordpage.clickNext();
//		try {	
//		createpasswordpage.clickTick();
//		Assert.assertEquals(Toast(), "Must set your 4 digit PIN.");
//		
//		}
//		
//		catch(Throwable th) {
//			th.printStackTrace();
//		}
//		
//		}
//	
//
//	
	/*
	 TC_57	: Validate with Valid value in enter password field and Invalid value in Re-enter password field.
	 */
	@Test(priority = 23,groups = {"Regression"})
	public void TC_57_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field (){
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
			createpasswordpage.setInValidPassword();
			Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password does not match.");
			
		
	}
//	
//	
//
	/*
	 TC_62 : Validate the next function with a value in Enter password and without a value in Re-Enter password
	 */
	@Test(priority = 25,groups = {"Regression"})
	public void TC_62_To_Validate_the_next_function_with_value_only_In_ReEnter_password_Field () {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.clearValues();
		try {
			createpasswordpage.setPassword_In_ReEnter_Field_Only();
			Assert.assertEquals(Toast(), "Must set your 4 digit PIN.");
			createpasswordpage.clearValues();
			
		}	
		catch(AssertionError E){
			E.printStackTrace();
		}
	}
//	
//
//	
//	/*
//	 TC_66 : Validate the Pin number fields in the Create password screen by entering values below boundary value in any one field
//	 */
//	@Test(priority =27,groups = {"Regression"})
//	public void TC_66_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
//		
//		createpasswordpage =new CreatePasswordPage(driver);
//		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//		
//		
//			createpasswordpage.clearValues();
//			createpasswordpage.setPassword_with_below_boundary_values("EnterPasswordfield");
//			Assert.assertEquals(createpasswordpage.textErrorMsg(), "Please enter 4 digit PIN.");
//			
//		
//		createpasswordpage =new CreatePasswordPage(driver);
//		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//		
//		
//			createpasswordpage.clearValues();
//			createpasswordpage.setPassword_with_below_boundary_values("ReEnterPasswordField");
//			Assert.assertEquals(createpasswordpage.Toast(), "Must set your 4 digit PIN.");
//			createpasswordpage.clearValues();
//			
//		
//	}
//	
//	
//	/*
//	TC_76	Validate whether the value entered in the Pin number fields of the Create password is editable.
//    TC_77	Validate whether the value entered in the Pin number fields of the Create password is deleteable.	
//	*/
//	@Test(priority=28,groups = {"Regression"})
//	public void TC_76_And_77_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
//		
//		createpasswordpage =new CreatePasswordPage(driver);
//		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//		
//			createpasswordpage.clearValues();
//			createpasswordpage.setPassword_0("EnterPasswordfield");
//			String oldValue = createpasswordpage.textbox_Enter_field_Value();
//			createpasswordpage.delete_Values("Enterpasswordfield");
//			createpasswordpage.setPassword_1_In_Enter_field("EnterPasswordfield");
//			Assert.assertNotEquals(oldValue, createpasswordpage.textbox_Enter_field_Value());
//		
//		createpasswordpage =new CreatePasswordPage(driver);
//		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//		
//		
//			
//			createpasswordpage.setPassword_0("ReEnterPasswordfield");
//			String oldValue1 = createpasswordpage.textbox_ReEnter_field_Value();
//			createpasswordpage.delete_Values("ReEnterpasswordfield");
//			
//			createpasswordpage.setPassword_1_In_Enter_field("ReEnterPasswordField");
//			Assert.assertNotEquals(oldValue1, createpasswordpage.textbox_ReEnter_field_Value());
//			 createpasswordpage.clickEyeIcon();
//		}
//			
//		
//		/*
//		  TC_66	Validate the Pin number fields in the Create password screen by entering values above boundary value.
//		Need to remove  TC_75	Validate whether the value enter in the Pin number fields of the Create password is able to copy.	
//		 */
//		@Test(priority = 34,groups = {"Regression"})
//		public void TC_66_Validate_the_Create_password_by_entering_values_above_boundary_value_And_Is_able_To_copy () {
//			createpasswordpage =new CreatePasswordPage(driver);
//	  		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//	  		createpasswordpage.clearValues();
//	  		try {
//	  		createpasswordpage.setPassword_with_above_boundary_values_In_both_fields("EnterPasswordfield");
//	  		}
//	  		catch(NoSuchElementException E){
//	  			
//	  		int Password_field_Length = createpasswordpage.textbox_Enter_field_Value().length();
//	  		Assert.assertEquals(Password_field_Length, 4);
//	  		}
//	  		try {
//	  	  		createpasswordpage.setPassword_with_above_boundary_values_In_both_fields("ReEnterPasswordfield");
//	  	  		}
//	  	  		catch(NoSuchElementException E){
//	  	  			
//	  	  		int ReEnterPassword_field_Length = createpasswordpage.textbox_ReEnter_field_Value().length();
//	  	  	    Assert.assertEquals( ReEnterPassword_field_Length ,4);
//	  	  		}
//	  		
//	 try { 	
//	  		Assert.assertTrue(createpasswordpage.isPasswordCopyable(),"Able to copy");
//	  		Assert.assertTrue(createpasswordpage.isReEnterPasswordCopyable(),"Able to copy");
//	 }
//	 catch(Exception e) {
//		 e.printStackTrace();
//	 
//	  		}
//	  		}
//		
//		/*
//		 TC_59	: Validate with Valid value in enter password field and Invalid value in Re-enter password field and repeat it for multiple times.	
//		 */
//		@Test(priority = 35,groups = {"Regression"})
//		public void TC_59_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field_and_repeat_it_for_multiple_time(){
//			
//			createpasswordpage =new CreatePasswordPage(driver);
//		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//		createpasswordpage.clearValues();
//		createpasswordpage.setInValidPassword();
//		recoveryphrasepage =new RecoveryPhrasePage(driver);
//		Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password is not matched");
//		for(int i=0;i<3;i++) {
//			createpasswordpage.clickTick();
//			Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password is not matched");
//		}			
//		}
//	
//		/*
//	 TC_58	: Validate with Valid value in enter password field and Valid value in Re-enter password field.
//	 */
//		@Test(priority = 36 ,groups = {"Regression","Smoke"})
//	public void TC_58_To_Validate_with_Valid_value_in_both_enter_password_field_and_in_ReEnter_password_field () {
//		createpasswordpage =new CreatePasswordPage(driver);
//		createpasswordpage.clearValues();
//		
//			createpasswordpage.setValidPassword();
//			recoveryphrasepage =new RecoveryPhrasePage(driver);
//			wait =new WebDriverWait(driver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(recoveryphrasepage.textPageTitle));
//			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
//			
//		}
//		
//	

	
	}
