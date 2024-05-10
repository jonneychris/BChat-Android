package Bchat.TestScenarios;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.HomePage;
import POM.RestoreFromSeedPage;
import POM.SeedPage;
import Utiles.baseClass;
/*
 Test Scenario:	To check the working of the Restore from seed functionality in the SigIn screen
 */
public class SignIn_Fow_RestorefromBlockheight_Screen extends baseClass{

	RestoreFromSeedPage restorefromseedpage;
	SeedPage seedpage;
	CreatePasswordPage createpasswordpage;
	HomePage homepage;
	
	/*
	 PreSetup Method for this class
	 */
	@Test(priority = 20,alwaysRun = true)
	public void preSetup () {
		try {
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.pasteSeedValue();
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		}
		catch( NoSuchElementException E) {
			if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
				 landingpage.openApp();
				 landingpage.clickSignIn();
					seedpage = new SeedPage(driver);
					Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
					seedpage.pasteSeedValue();
					seedpage.clickNext();
					restorefromseedpage = new RestoreFromSeedPage(driver);
					Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		}
		}
		
	}
	
	
	/*
	TC_114 : Validate whether crusher blink on clicking the text box of screen.
	*/
	@Test(priority = 21,groups = {"Regression"})
	public void TC_114_To_Validate_whether_crusher_blink_on_clicking_the_text_box_of_screen () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		restorefromseedpage.clicktextboxDisplayname();
		restorefromseedpage.clicktextboxBLockheight();
	}
	
	/*
	TC_115 : Validate the presence of placeholder in the text box of the screen.
	*/
	@Test(priority = 22,groups = {"Regression"})
	public void TC_115_To_Validate_the_presence_of_placeholder_in_the_text_box_of_the_screen () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    Assert.assertEquals(restorefromseedpage.NamePlaceholder(), "Display Name");
	    Assert.assertEquals(restorefromseedpage.BlockheightPlaceholder(), "Restore from Blockheight");
	    restorefromseedpage.clickBtnDate();
	    Assert.assertEquals(restorefromseedpage.datePlaceholder(), "Restore from date");
	    restorefromseedpage.clickBtnBlockheight();
	}
	
	/*
	TC_108 : Validate the working of the restore option without Entering value in display name, restore from blockheight and restore from date.
	*/
	@Test(priority = 23,groups = {"Regression"})
	public void TC_108_To_Validate_the_working_of_restore_without_Entering_value_in_display_name_restore_from_blockheight_and_restore_from_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.clickBtnRestore();
	    Assert.assertEquals(Toast(),"Please pick a display name");
	    restorefromseedpage.clickBtnDate();
        restorefromseedpage.clickBtnRestore();
        Assert.assertEquals(Toast(),"Please pick a display name");
        restorefromseedpage.clickBtnBlockheight();
	}
	
	/*
	 TC_109 : Validate the working of the restore option with valid display name and Without entering a value in both blockheight and restore from date.
	 */
	@Test(priority = 24,groups = {"Regression"})
	public void TC_109_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Without_entering_both_blockheight_and_restore_from_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.clearValues();   	
	   	restorefromseedpage.setDisplayName("Chris");
	   	restorefromseedpage.clickBtnRestore();
	    Assert.assertEquals(Toast(),"Please enter a restore height");
	    restorefromseedpage.clickBtnDate();
	    restorefromseedpage.clickBtnRestore();
	    Assert.assertEquals(Toast(),"Please pick a restore date");	
        restorefromseedpage.clickBtnBlockheight();
           	
	}
	
	
	/*
	 TC_112 : Validate the working of the restore option with valid display name and Invalid blockheight 
	 */
	@Test(priority = 25,groups = {"Regression"})
	public void TC_112_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Invalid_blockheight () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("Chris");
	   	restorefromseedpage.setBlockheight("999999999");
	   //	Assert.assertEquals(Toast(),"Enter a valid height");
	   	restorefromseedpage.clickBtnRestore();
        Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
	}
	

	/*
	 TC_113 : Validate the working of the restore option with Invalid display name and Invalid blockheight
	 */
	@Test(priority = 26,groups = {"Regression"})
	public void TC_113_To_Validate_working_of_restore_option_with_Invalid_display_name_and_Invalid_blockheight () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("@#$5&89");
	   	restorefromseedpage.setBlockheight("999999999");
	   //	Assert.assertEquals(Toast(),"Enter a valid height");
	   	restorefromseedpage.clickBtnRestore();
        Assert.assertEquals(Toast(),"Please enter a valid name");
	}
	
	/*
	 TC_111 : Validate the working of the restore option with Invalid display name and valid blockheight
	 Tc_116 : Validate the working of the restore option with Invalid display name and valid restore date.
	 */
	@Test(dataProvider ="setInvaliddata",priority = 27,groups = {"Regression"})
	public void TC_111_And_116_To_Validate_the_working_of_the_restore_option_with_Invalid_display_names_and_valid_blockheight_and_Date(HashMap <String,String> Input){
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName(Input.get("DisplayName"));
	   	restorefromseedpage.setBlockheight("300000");
		 try{
			 restorefromseedpage.clickBtnRestore();		 
		 Assert.assertEquals(Toast(),"Please enter a valid name");
		 
		 }
		 catch(StaleElementReferenceException E) {
			 restorefromseedpage.clickBtnRestore();		 
			 Assert.assertEquals(Toast(),"Please enter a valid name");
			 
		 }
		 restorefromseedpage.selectTodayDate();
		try {
		 restorefromseedpage.clickBtnRestore();
		 Assert.assertEquals(Toast(),"Please enter a valid name");
		}
		catch (StaleElementReferenceException e) {
			 restorefromseedpage.clickBtnRestore();
			 Assert.assertEquals(Toast(),"Please enter a valid name");
		}
		restorefromseedpage.clickBtnBlockheight();
		
	}

	
	@DataProvider
	public Object[][] setInvaliddata() throws IOException {
		
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//InvalidDisplayName.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
		
	}
	
	/*
	 TC_110 : Validate the working of the restore option with valid display name and valid blockheight
	 */
	@Test(dataProvider = "setValiddata",priority = 28,groups = {"Regression","Smoke"} )
	public void TC_110_To_Validate_the_working_of_the_restore_option_with_valid_datas_display_name_and_valid_blockheight (HashMap <String,String> input) {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
		restorefromseedpage.setDisplayName(input.get("DisplayName"));
	   	restorefromseedpage.setBlockheight("3000000");
	   	restorefromseedpage.clickBtnRestore();
	   	 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	try {
	   	driver.navigate().back();
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	}
	   	catch( NoSuchElementException E) {
			if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
				 landingpage.openApp();
				 landingpage.clickSignIn();
					seedpage = new SeedPage(driver);
					Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
					seedpage.pasteSeedValue();
					seedpage.clickNext();
					restorefromseedpage = new RestoreFromSeedPage(driver);
					Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		}
	   	}
	}
	
	@DataProvider
	public Object[][] setValiddata() throws IOException {
		
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//ValidDisplayName.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
		
	}
	
	/*
	TC_117 : Validate whether able to select the future date in restore from date calendar
	*/
	@Test(priority = 29,groups = {"Regression"})
	public void TC_117_To_Validate_whether_able_to_select_the_future_date_in_restore_from_date_calendar () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.clickBtnDate();
	   	restorefromseedpage.clicktextboxDate();
	   Assert.assertFalse(restorefromseedpage.CheckFutureDate().isEnabled());
	   restorefromseedpage.clickCancel();
	   
	}
	
	/*
	 TC_122 : Validate the text box of the Display Name screen by entering values above boundary value.
	 */
	@Test(priority = 30,groups = {"Regression"})
	public void TC_122_To_Validate_DisplayName_With_Above_Boundary_Value () {
		
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
	    restorefromseedpage.clickBtnRestore();
        Assert.assertEquals(Toast(),"Please pick a shorter display name");
        restorefromseedpage.clearValues();
   }
	
	/*
	TC_120 : Validate whether able to paste Alphabets blockheight textbox.
	*/
	@Test(priority = 31,groups = {"Regression"})
	public void TC_120_To_Validate_whether_able_to_paste_Alphabets_Values_in_blockheight_textbox () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_Blockheight(("Abcde"));
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
	   
	}
	
	
	/*
	TC_121 : Validate whether able to paste Special characters in blockheight textbox.
	*/
	@Test(priority = 32,groups = {"Regression"})
	public void TC_To_Validate_whether_able_to_paste_Speical_Character_Values_in_blockheight_textbox () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_Blockheight("!@#$%");
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
	   
	}
	
	/*
	TC_119 : validate the working of the restore option by paste values in textboxes.
	*/
	@Test(priority = 33,groups = {"Regression"})
	public void TC_119_To_validate_the_working_of_the_restore_option_by_paste_values_in_textboxes () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_DisplayName("Chris");
	   	restorefromseedpage.paste_Value_In_Blockheight("3000000");
	   	try {
	   		restorefromseedpage.clickBtnRestore();
	   	 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
	   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   
	   	}
	   	catch( NoSuchElementException E) {
			if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
				 landingpage.openApp();
				 landingpage.clickSignIn();
					seedpage = new SeedPage(driver);
					Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
					seedpage.pasteSeedValue();
					seedpage.clickNext();
					restorefromseedpage = new RestoreFromSeedPage(driver);
					Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		}
	
	}	
	}
	/*
	TC_118 : Validate the working of the restore option with valid display name and valid restore date.
	*/
	@Test(priority = 34, groups = {"Regression","Smoke"})
	public void TC_118_To_Validate_the_working_of_the_restore_with_valid_display_name_and_valid_restore_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("chris");
	   	restorefromseedpage.selectTodayDate();
	  
	   		restorefromseedpage.clickBtnRestore();
	   	 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
	   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   
	}
	
	
	/*
	 Setup to navigate to home screeen in signInFlow
	 No need of create Password screen validation, because create password screen scenarios tested in create account flow
	 */
	@Test(priority = 35,groups = {"Regression","Smoke"})
	public void TC_TO_validate_Navigation_To_home_with_Valid_Password() {
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		try {
		createpasswordpage.setValidPassword();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		catch(NoSuchElementException E) {
			
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		
	}
	
	
	
	
}
