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
	
	
	
	@Test(priority = 0,alwaysRun = true)
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
	
	
//	/*
//	Validate whether crusher blink on clicking the text box of screen.
//	*/
//	@Test
//	public void To_Validate_whether_crusher_blink_on_clicking_the_text_box_of_screen () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//		restorefromseedpage.clicktextboxDisplayname();
//		restorefromseedpage.clicktextboxBLockheight();
//	}
//	
//	/*
//	Validate the presence of placeholder in the text box of the screen.
//	*/
//	@Test(priority = 1)
//	public void To_Validate_the_presence_of_placeholder_in_the_text_box_of_the_screen () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	    Assert.assertEquals(restorefromseedpage.NamePlaceholder(), "Display Name");
//	    Assert.assertEquals(restorefromseedpage.BlockheightPlaceholder(), "Restore from Blockheight");
//	    restorefromseedpage.clickBtnDate();
//	    Assert.assertEquals(restorefromseedpage.datePlaceholder(), "Restore from date");
//	    restorefromseedpage.clickBtnBlockheight();
//	}
//	
//	/*
//	Validate the working of the restore option without Entering value in display name, restore from blockheight and restore from date.
//	*/
//	@Test(priority = 2)
//	public void Validate_the_working_of_restore_without_Entering_value_in_display_name_restore_from_blockheight_and_restore_from_date () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	    restorefromseedpage.clickBtnRestore();
//	    Assert.assertEquals(Toast(),"Please pick a display name");
//	    restorefromseedpage.clickBtnDate();
//        restorefromseedpage.clickBtnRestore();
//        Assert.assertEquals(Toast(),"Please pick a display name");
//        restorefromseedpage.clickBtnBlockheight();
//	}
//	
//	/*
//	 TC_ : Validate the working of the restore option with valid display name and Without entering a value in both blockheight and restore from date.
//	 */
//	@Test(priority = 3)
//	public void TC_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Without_entering_both_blockheight_and_restore_from_date () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	    restorefromseedpage.clearValues();   	
//	   	restorefromseedpage.setDisplayName("Chris");
//	   	restorefromseedpage.clickBtnRestore();
//	    Assert.assertEquals(Toast(),"Please enter a restore height");
//	    restorefromseedpage.clickBtnDate();
//	    restorefromseedpage.clickBtnRestore();
//	    Assert.assertEquals(Toast(),"Please pick a restore date");	
//        restorefromseedpage.clickBtnBlockheight();
//           	
//	}
//	
//	
//	/*
//	 TC : Validate the working of the restore option with valid display name and Invalid blockheight 
//	 */
//	@Test(priority = 4)
//	public void To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Invalid_blockheight () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	restorefromseedpage.clearValues();
//	   	restorefromseedpage.setDisplayName("Chris");
//	   	restorefromseedpage.setBlockheight("999999999");
//	   //	Assert.assertEquals(Toast(),"Enter a valid height");
//	   	restorefromseedpage.clickBtnRestore();
//        Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
//	}
//	
//
//	/*
//	 Validate the working of the restore option with Invalid display name and Invalid blockheight
//	 */
//	@Test(priority = 5)
//	public void TC_To_Validate_working_of_restore_option_with_Invalid_display_name_and_Invalid_blockheight () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	restorefromseedpage.clearValues();
//	   	restorefromseedpage.setDisplayName("@#$5&89");
//	   	restorefromseedpage.setBlockheight("999999999");
//	   //	Assert.assertEquals(Toast(),"Enter a valid height");
//	   	restorefromseedpage.clickBtnRestore();
//        Assert.assertEquals(Toast(),"Please enter a valid name");
//	}
//	
//	/*
//	 Validate the working of the restore option with Invalid display name and valid blockheight
//	 Validate the working of the restore option with Invalid display name and valid restore date.
//	 */
//	@Test(dataProvider ="setInvaliddata",priority = 6)
//	public void TC_To_Validate_the_working_of_the_restore_option_with_Invalid_display_names_and_valid_blockheight(HashMap <String,String> Input){
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	restorefromseedpage.clearValues();
//	   	restorefromseedpage.setDisplayName(Input.get("DisplayName"));
//	   	restorefromseedpage.setBlockheight("300000");
//		 try{
//			 restorefromseedpage.clickBtnRestore();		 
//		 Assert.assertEquals(Toast(),"Please enter a valid name");
//		 
//		 }
//		 catch(StaleElementReferenceException E) {
//			 restorefromseedpage.clickBtnRestore();		 
//			 Assert.assertEquals(Toast(),"Please enter a valid name");
//			 
//		 }
//		 restorefromseedpage.selectTodayDate();
//		try {
//		 restorefromseedpage.clickBtnRestore();
//		 Assert.assertEquals(Toast(),"Please enter a valid name");
//		}
//		catch (StaleElementReferenceException e) {
//			 restorefromseedpage.clickBtnRestore();
//			 Assert.assertEquals(Toast(),"Please enter a valid name");
//		}
//		restorefromseedpage.clickBtnBlockheight();
//		
//	}
//
//	
//	@DataProvider
//	public Object[][] setInvaliddata() throws IOException {
//		
//		List <HashMap <String,String>>data=super.getjsonFile("//Datas//InvalidDisplayName.json");
//		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
//		
//	}
//	
//	/*
//	 Validate the working of the restore option with valid display name and valid blockheight
//	 */
//	@Test(dataProvider = "setValiddata",priority = 7 )
//	public void TC_To_Validate_the_working_of_the_restore_option_with_valid_datas_display_name_and_valid_blockheight (HashMap <String,String> input) {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	restorefromseedpage.clearValues();
//		restorefromseedpage.setDisplayName(input.get("DisplayName"));
//	   	restorefromseedpage.setBlockheight("3000000");
//	   	restorefromseedpage.clickBtnRestore();
//	   	 createpasswordpage = new CreatePasswordPage(driver);
//	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
//	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//	   	try {
//	   	driver.navigate().back();
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	}
//	   	catch( NoSuchElementException E) {
//			if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
//				 landingpage.openApp();
//				 landingpage.clickSignIn();
//					seedpage = new SeedPage(driver);
//					Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
//					seedpage.pasteSeedValue();
//					seedpage.clickNext();
//					restorefromseedpage = new RestoreFromSeedPage(driver);
//					Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//		}
//	   	}
//	}
//	
//	@DataProvider
//	public Object[][] setValiddata() throws IOException {
//		
//		List <HashMap <String,String>>data=super.getjsonFile("//Datas//ValidDisplayName.json");
//		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
//		
//	}
//	
//	/*
//	Validate whether able to select the future date in restore from date calendar
//	*/
//	@Test(priority = 8)
//	public void TC_To_Validate_whether_able_to_select_the_future_date_in_restore_from_date_calendar () {
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	restorefromseedpage.clearValues();
//	   	restorefromseedpage.clickBtnDate();
//	   	restorefromseedpage.clicktextboxDate();
//	   Assert.assertFalse(restorefromseedpage.CheckFutureDate().isEnabled());
//	   restorefromseedpage.clickCancel();
//	   
//	}
	
	/*
	 TC_ : Validate the text box of the Display Name screen by entering values above boundary value.
	 */
	@Test(priority = 9)
	public void TC_To_Validate_DisplayName_With_Above_Boundary_Value () {
		
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
	    restorefromseedpage.clickBtnRestore();
        Assert.assertEquals(Toast(),"Please pick a shorter display name");
        restorefromseedpage.clearValues();
   }
	
	/*
	Validate whether able to paste invalid datas in blockheight textbox.
	*/
	@Test(priority = 10)
	public void TC_To_Validate_whether_able_to_paste_Alphabets_Values_in_blockheight_textbox () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_Blockheight(("Abcde"));
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
	   
	}
	
	
	/*
	Validate whether able to paste invalid datas in blockheight textbox.
	*/
	@Test(priority = 11)
	public void TC_To_Validate_whether_able_to_paste_Speical_Character_Values_in_blockheight_textbox () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_Blockheight("!@#$%");
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
	   
	}
	
	
	
	/*
	Validate the working of the restore option with valid display name and valid restore date.
	*/
	@Test(priority = 12, groups ="Smoke")
	public void TC_To_Validate_the_working_of_the_restore_with_valid_display_name_and_valid_restore_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("chris");
	   	restorefromseedpage.selectTodayDate();
	   	restorefromseedpage.clickBtnRestore();
	   	 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
	 
	   	try {
	   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
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
	
	
	/*
	validate the working of the restore option by paste values in textboxes.
	*/
	@Test(priority = 13)
	public void TC_To_validate_the_working_of_the_restore_option_by_paste_values_in_textboxes () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_DisplayName("Chris");
	   	restorefromseedpage.paste_Value_In_Blockheight("3000000");
	   	restorefromseedpage.clickBtnRestore();
		 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.textPageTitle));
	   	 Assert.assertEquals(createpasswordpage.pageTitle(), "Create Password");
	}
	
	
	
	
	
	
}
