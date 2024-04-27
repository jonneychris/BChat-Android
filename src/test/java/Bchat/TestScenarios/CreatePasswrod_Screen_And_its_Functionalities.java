package Bchat.TestScenarios;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
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


public class CreatePasswrod_Screen_And_its_Functionalities extends baseClass{
	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	WebDriverWait wait;
	
	@Test(priority = 0)
	public void preSetup() throws InterruptedException {
		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
	try {
		Thread.sleep(1000);
		landingpage.clickCreateAccount();
    DisplayNamePage	d = new DisplayNamePage(driver);
	d.setDisplayName("Chris");
	d.clickContinue();
	RegisterPage r= new RegisterPage(driver);
	wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(r.textPageTitle));
	r.clickNext();
	
	}
	catch(Exception E) {
		E.printStackTrace();
	}
	
	}
	
	/*
	 TC_73	: Validate the presence of placeholder in the Pin number fields in the Create password.
	 */
	@Test (priority = 1)
  	public void TC_73_To_Validate_the_presence_of_placeholder_in_the_Create_password_Fields () {
		
		
	    createpasswordpage =new CreatePasswordPage(driver);
	     wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		Assert.assertEquals(createpasswordpage.checkEnterPaswordPlaceholder(), "Eg.0089");
		Assert.assertEquals(createpasswordpage.checkReEnterPaswordPlaceholder(), "Eg.0089");
		
	}

	/*
	 TC_60	: Validate the next function without entering a value in Enter password and Re-Enter password
	 */
	@Test(priority = 2)
	public void TC_60_To_Validate_the_next_function_without_entering_a_value_in_Enter_password_and_ReEnter_password () {
		createpasswordpage =new CreatePasswordPage(driver);
		createpasswordpage.clickNext();
		try {	
		createpasswordpage.clickTick();
		Assert.assertEquals(Toast(), "Must set your 4 digit PIN.");
		
		}
		
		catch(Throwable th) {
			th.printStackTrace();
		}
		
		}
	

	
	/*
	 TC_57	: Validate with Valid value in enter password field and Invalid value in Re-enter password field.
	 */
	@Test(priority = 3)
	public void TC_57_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field (){
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		try {
			createpasswordpage.setInValidPassword();
			recoveryphrasepage =new RecoveryPhrasePage(driver);
			Assert.assertEquals(createpasswordpage.textErrorMsg(),"Password is not matched");
			createpasswordpage.clearValues();
		}
		
		catch(Throwable th) {
			th.printStackTrace();
		}
	}
	
	/*
	 TC_61	: Validate the next function without entering a value in Enter password and with a value in Re-Enter password	
	 */
	@Test(priority = 4)
	public void TC_61_To_Validate_the_next_function_without_entering_a_value_in_Enter_password_and_with_a_value_in_ReEnter_password () {
		
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.clearValues();
		try {
			createpasswordpage.setPassword_In_Enter_Field_Only();
			Assert.assertEquals(Toast(), "Must set your 4 digit PIN.");
			
			
		}
		catch(NoSuchElementException E) {
			createpasswordpage.clickTick();
			Assert.assertEquals(Toast(), "Must set your 4 digit PIN.");
			createpasswordpage.clearValues();
		}
		catch(AssertionError E){
			E.printStackTrace();
		}
		
	}
	
	/*
	 TC_62 : Validate the next function with a value in Enter password and without a value in Re-Enter password
	 */
	@Test(priority = 5)
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
	
	/*
	TC_65:	Validate the Pin number fields in the Create password screen by entering values below boundary value_In both password and reenter password field.
	*/
	@Test(priority =6)
	public void TC_65_To_Validate_the_Pin_number_fields_by_entering_values_below_boundary_value_In_both_Fields() {
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.clearValues();
		try {
			createpasswordpage.setPassword_with_below_boundary_values_In_both_fields();
			Assert.assertEquals(createpasswordpage.textErrorMsg(), "Please enter 4 digit PIN.");
			createpasswordpage.clearValues();
		}	
		catch(AssertionError E){
			
			E.printStackTrace();
		}
		
	}
	
	/*
	 TC_66 : Validate the Pin number fields in the Create password screen by entering values below boundary value in any one field
	 */
	@Test(priority =7)
	public void TC_66_To_Validate_the_Password_number_fields_by_entering_values_below_boundary_value_in_any_one_field () {
		
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		
		try {
			createpasswordpage.clearValues();
			createpasswordpage.setPassword_with_below_boundary_values("EnterPasswordfield");
			Assert.assertEquals(createpasswordpage.textErrorMsg(), "Please enter 4 digit PIN.");
			
			
		}	
		catch(AssertionError E){
		   E.printStackTrace();	
		}
		
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		
		try {
			createpasswordpage.clearValues();
			createpasswordpage.setPassword_with_below_boundary_values("ReEnterPasswordField");
			Assert.assertEquals(createpasswordpage.Toast(), "Must set your 4 digit PIN.");
			createpasswordpage.clearValues();
			
		}	
		catch(AssertionError E){
			E.printStackTrace();
		}
	}
	
	
	/*
	TC_76	Validate whether the value entered in the Pin number fields of the Create password is editable.
    TC_77	Validate whether the value entered in the Pin number fields of the Create password is deleteable.	
	*/
	@Test(priority=8)
	public void TC_76_And_77_To_validate_Whether_Values_In_Password_Fields_are_Editable_And_deletable () {
		
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		try {
			createpasswordpage.clearValues();
			createpasswordpage.setPassword_0("EnterPasswordfield");
			String oldValue = createpasswordpage.textbox_Enter_field_Value();
			createpasswordpage.delete_Values("Enterpasswordfield");
			createpasswordpage.setPassword_1_In_Enter_field("EnterPasswordfield");
			Assert.assertNotEquals(oldValue, createpasswordpage.textbox_Enter_field_Value());
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		createpasswordpage =new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		
		
			
			createpasswordpage.setPassword_0("ReEnterPasswordfield");
			String oldValue = createpasswordpage.textbox_ReEnter_field_Value();
			createpasswordpage.delete_Values("ReEnterpasswordfield");
			try {
			createpasswordpage.setPassword_1_In_Enter_field("ReEnterPasswordField");
			Assert.assertNotEquals(oldValue, createpasswordpage.textbox_ReEnter_field_Value());
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		
	}
	/*
	TC_68 : Validate the Pin number fields in the Create password screen by using special Characters.	
	TC_69 : Validate the Pin number fields in the Create password screen using Alaphabats both in uppercase and lower case.
    TC_70 : Validate the Pin number fields in the Create password screen is Allowing the Space.	
    TC_74 : validate whether paste option is working on the Pin number fields in the Create password.
	*/
//	@Test(dataProvider = "setdata",priority = 9)
//      public void TC_To_Validate_Working_of_Paste_Option_With_different_InValid_values(HashMap<String,String> input,HashMap<String,String> input1 ) {
//    	  createpasswordpage =new CreatePasswordPage(driver);
//  		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//  		try {
//  			createpasswordpage.Paste_Values_In_Enter_Field(input.get("EnterPassword"));
//  			createpasswordpage.Paste_Values_In_ReEnter_Field(input1.get("ReEnterPassword"));
//  			createpasswordpage.clickTick();
//  			Assert.assertTrue(createpasswordpage.textbox_Enter_field_Value().isEmpty(),"Not able to Paste values other than numbers");
//  			Assert.assertTrue(createpasswordpage.textbox_ReEnter_field_Value().isEmpty(),"Not able to Paste values other than numbers");
//  			
//  		
//  		}
//  		catch(AssertionError E) {
//  			E.printStackTrace();
//  		}
//      }
//	
//	@DataProvider
//	public  Object setdata() throws IOException {
//	   List<HashMap<String, String>> file =  getjsonFile("\\Datas\\Password.json");
//	   Object[][] data = {{file.get(0)},{file.get(1)},{file.get(2)}};
//			   return data;
//	}
//	
	
	
	
	
	
	/*
	TC_71	Validate the Pin number fields in the Create password screen by pasting numerical value.
	*/
	
	@Test(priority = 10)
	public void TC_71_To_Validate_Create_password_by_pasting_numerical_value () {
		 createpasswordpage =new CreatePasswordPage(driver);
		 createpasswordpage.clearValues();
	  		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		 createpasswordpage.Paste_Values_In_Enter_Field("1111");
		 createpasswordpage.Paste_Values_In_ReEnter_Field("1111");
		
		 
		 createpasswordpage.clickTick();
		 recoveryphrasepage = new RecoveryPhrasePage(driver); 
		 Assert.assertEquals(recoveryphrasepage.pageTitle(),"Recovery Phrase");
		 driver.navigate().back();
		 createpasswordpage.clearValues();
		 Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
	}
	
	/*
	 TC_58	: Validate with Valid value in enter password field and Valid value in Re-enter password field.
	 */
	@Test(priority = 11 )
	public void TC_58_To_Validate_with_Valid_value_in_both_enter_password_field_and_in_ReEnter_password_field () {
		createpasswordpage =new CreatePasswordPage(driver);
		createpasswordpage.clearValues();
		try {
			createpasswordpage.setValidPassword();
			recoveryphrasepage =new RecoveryPhrasePage(driver);
			Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
			
		}
		catch(Throwable th) {
			th.printStackTrace();
		}
	}
		
	/*
//	 TC_59	: Validate with Valid value in enter password field and Invalid value in Re-enter password field and repeat it for multiple times.	
//	 */
//	@Test
//	public void TC_59_To_Validate_with_Valid_value_in_enter_password_field_and_Invalid_value_in_ReEnter_password_field_and_repeat_it_for_multiple_time(){
//		
//		
//		
//		
//	}
		
		

		
//	TC_63	Validate whether values entered in the pin number fields are visible

//	TC_64	Validate Whether able to make a values entered in the pin number fields invisible.
	
	

//	TC_66	Validate the Pin number fields in the Create password screen by entering values above boundary value.

	//	TC_72	Validate whether crusher blink on clicking the Pin number fields in the Create password.
	
//	TC_75	Validate whether the value enter in the Pin number fields of the Create password is able to copy.

		

}
