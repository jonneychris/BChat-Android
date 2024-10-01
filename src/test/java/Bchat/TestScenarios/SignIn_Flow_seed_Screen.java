package Bchat.TestScenarios;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
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
 Test Scenario:	To check the working of the Restore from seed functionality in the SigIn flow
 */
public class SignIn_Flow_seed_Screen extends baseClass{

	SeedPage seedpage;
	RestoreFromSeedPage restorefromseedpage;
	CreatePasswordPage createpasswordpage;
	HomePage homepage;
	WebDriverWait wait;
	
	/*
	 * 
	 * Seed Screen
	 * 
	 */
	
	
	/*
	 presetup method for this class
	 */
	@Test(priority = 0,groups = {"Regression","Smoke"})
	public void PreSetup () {
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	}
	
	
	/*
	 TC_94	To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority =1,groups = {"Regression"})
	public void TC_94_To_Validate_Whether_Able_to_Navigate_Previous_screen () {
		
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		try {
			 driver.navigate().back();
			 if(landingpage.WebElementAppList().isDisplayed()||landingpage.WebElementAppList().isDisplayed()) {
				 landingpage.openApp();
			 }
			 }
		 catch(Throwable e) {
			 e.printStackTrace();
			 
		 }
		Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
	}
	
	/*
	TC_96 :Validate the presence of placeholder in the text box of the Display Name screen.
	*/
	@Test(priority =2,groups = {"Regression"})
	public void TC_96_To_Validate_the_presence_of_placeholder_in_the_Restore_From_seed_text_box () {
		
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		Assert.assertEquals(seedpage.Placeholder(),"Enter your Seed");
		
	}
		
	/*
	TC_ 95 : Validate whether crusher blink on clicking the text box of Restore from screen.
    */
	@Test(priority =3,groups = {"Regression"})
    public void	TC_95_To_Validate_whether_crusher_blink_on_clicking_the_Restore_From_Seed_text_Box () {
	
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clickTextBox();
		try {
		WebElement active=driver.switchTo().activeElement();
		Assert.assertTrue(seedpage.SeedTextBox.equals(active));
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		}

	/*
	 TC_102 :	Validate the working of the next option without entering seed.
	 */
	@Test(priority =4,groups = {"Regression"})
	 public void TC_102_To_Validate_the_working_of_the_next_option_without_entering_seed () {
		
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clickNext();
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		
	}
	
	
//	/*
//	 TC_101 :	Validate the working of the paste button without copying seed.
//	 */
//	@Test(priority =5,groups = {"Regression"})
//	 public void TC_101_To_Validate_the_working_of_the_paste_button_without_copying_seed () {
//		
//		seedpage = new SeedPage(driver);
//		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
//		driver.getClipboardText();
//		seedpage.clickPasteButton();
//		Assert.assertEquals(Toast(), "Make sure you have copied the seed!");
//		
//	}
	
	/*
	 TC_92 : Validate whether able to paste the copied seed.	
	 */
	@Test(priority =6,groups = {"Regression"})
	public void TC_92_To_Validate_whether_able_to_paste_the_copied_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.pasteSeedValue();
	    Assert.assertEquals(seedpage.SeedValueCount(),"25/25");
	}
	
	/*
	 TC_93 :  Validate whether able to clear the entered seed
	 */
	@Test(priority =7,groups = {"Regression"})
	 public void TC_93_To_Validate_whether_able_to_clear_the_entered_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		Assert.assertEquals(seedpage.SeedValueCount(),"25/25");
		seedpage.clickClear();
		Assert.assertEquals(seedpage.SeedValueCount(),"0/25");
	 }
	
	/*
	TC_98 : Validate the text box of the restore from screen by entering values below boundary value.
	*/
	@Test(priority = 8,groups = {"Regression"})
	public void TC_98_To_Validate_the_text_box_of_the_restore_from_screen_by_entering_values_below_boundary_value () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.set_Below_Boundary_SeedValue();
	try {
		seedpage.clickNext();
		Assert.assertEquals(Toast(),"Please enter valid seed");
	}
	catch(StaleElementReferenceException E) {
		seedpage.clickNext();
		Assert.assertEquals(Toast(),"Please enter valid seed");
	}
	catch(NoSuchElementException E) {
		seedpage.clickNext();
		Assert.assertEquals(Toast(),"Please enter valid seed");
	}
	catch(Exception E) {
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	}
	}

	/*
	TC_97 : Validate the text box of the restore from screen by entering values above boundary value.
   */
	@Test(priority = 9,groups = {"Regression"})
	public void TC_97_To_Validate_the_text_box_of_the_restore_from_seed_by_entering_values_above_boundary_value () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.set_above_Boundary_SeedValue();
		Assert.assertEquals(seedpage.SeedValueCount(), "25/25");
	}

	/*
	 TC_99 : Validate whether able to type a seed.
	 */
	@Test(priority = 10,groups = {"Regression"})
	 public void TC_99_To_Validate_whether_able_to_type_a_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.EnterSeedValue("cement apology toilet venomous buffet junk duration tanks village ankle lazy joining candy peculiar mayor biscuit almost unquoted vessel slackens jaunt loudly vipers voice venomous");
		Assert.assertEquals(seedpage.SeedValueCount(), "25/25");	
	 }
	
	/*
	 TC_105 :	Validate Whether entered seed is editable
	 */
	@Test(priority = 11,groups = {"Regression"})
  public void TC_105_To_Validate_Whether_Entered_seed_is_editable () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.setSeedValue("Football");
		String value1 = seedpage.SeedtextboxValues();
		seedpage.clearSeedValues();
		seedpage.setSeedValue("isolated");
		String value2 = seedpage.SeedtextboxValues();
		Assert.assertNotEquals( value1, value2);
		
	}	
	
	/*
	 TC_103 :	Validate the working of the next option by entering Invalid seed.
	 */
	@Test(dataProvider = "setdata",priority = 12,groups = {"Regression"})
	 public void TC_103_To_Validate_the_working_of_the_next_option_by_entering_Invalid_seed ( HashMap <String,String> input) {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.setSeedValue(input.get("Seed"));
		seedpage.clickNext();
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());			
		
		}

	@DataProvider
	public Object[][] setdata() throws IOException {
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//Invalid_Seed_Values.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
	}
	
	
	/*
	 TC_100 : Validate the working of next option by pasting 25 blank space value
	 */
	@Test(priority = 13,groups = {"Regression"})
	public void TC_100_To_Validate_the_working_of_next_option_by_pasting_25_blank_space_value (){
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		
		seedpage.setSeedValue("                         ");
		seedpage.clickNext();
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
	}
	
	/*
	 TC_104 :	Validate the working of the next option by entering Valid seed.
	 */
	@Test(priority = 14,groups = {"Regression","Smoke"})
	public void TC_104_To_Validate_the_working_of_the_next_option_by_entering_Valid_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.EnterSeedValue("cement apology toilet venomous buffet junk duration tanks village ankle lazy joining candy peculiar mayor biscuit almost unquoted vessel slackens jaunt loudly vipers voice venomous");
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());	
	}
	
	
	
			/*
			 * 
			 * 
			 * Restore from blockheight screen
			 * 
			 * 
			 */
	
	
	
	/*
	TC_115 : Validate the presence of placeholder in the text box of the screen.
	*/
	@Test(priority = 15,groups = {"Regression"})
	public void TC_115_To_Validate_the_presence_of_placeholder_in_the_text_box_of_the_screen () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    Assert.assertEquals(restorefromseedpage.NamePlaceholder(), "Enter name");
	    Assert.assertEquals(restorefromseedpage.BlockheightPlaceholder(), "Enter Block height to Restore");
	    restorefromseedpage.clickBtnDate();
	    Assert.assertEquals(restorefromseedpage.datePlaceholder(), "Select Date");
	    restorefromseedpage.clickBtnBlockheight();
	}
	
	/*
	TC_108 : Validate the working of the restore option without Entering value in display name, restore from blockheight and restore from date.
	*/
	@Test(priority = 16,groups = {"Regression"})
	public void TC_108_To_Validate_the_working_of_restore_without_Entering_value_in_display_name_restore_from_blockheight_and_restore_from_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.clickBtnRestore();
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.clickBtnDate();
        restorefromseedpage.clickBtnRestore();
        restorefromseedpage.clickBtnBlockheight();
	}
	
	/*
	 TC_109 : Validate the working of the restore option with valid display name and Without entering a value in both blockheight and restore from date.
	 */
	@Test(priority = 17,groups = {"Regression"})
	public void TC_109_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Without_entering_both_blockheight_and_restore_from_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.clearValues();   	
	   	restorefromseedpage.setDisplayName("Chris");
	   	restorefromseedpage.clickBtnRestore();
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clickBtnDate();
	    restorefromseedpage.clickBtnRestore();
	    restorefromseedpage.clickBtnBlockheight();
           	
	}
	
	
	/*
	 TC_112 : Validate the working of the restore option with valid display name and Invalid blockheight 
	 */
	@Test(priority = 18,groups = {"Regression"})
	public void TC_112_To_Validate_the_working_of_the_restore_option_with_valid_display_name_and_Invalid_blockheight () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("Chris");
	   	restorefromseedpage.setBlockheight("999999999");
	   	restorefromseedpage.clickBtnRestore();
        try{
        	Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
        }
        catch (NoSuchElementException e) {
        	restorefromseedpage.clickBtnRestore();
        	Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
		}
        catch (StaleElementReferenceException e) {
        	restorefromseedpage.clickBtnRestore();
        	Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
		}
        catch (Exception e) {
        	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		}
	}
	

	/*
	 TC_113 : Validate the working of the restore option with Invalid display name and Invalid blockheight
	 */
	@Test(priority = 19,groups = {"Regression"})
	public void TC_113_To_Validate_working_of_restore_option_with_Invalid_display_name_and_Invalid_blockheight () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("@#$5&89");
	   	restorefromseedpage.setBlockheight("999999999");
	   	restorefromseedpage.clickBtnRestore();
        try {
	   	Assert.assertEquals(Toast(),"Please enter a valid name");
        }
        catch (NoSuchElementException e) {
        	restorefromseedpage.clickBtnRestore();
        	Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
		}
        catch (StaleElementReferenceException e) {
        	restorefromseedpage.clickBtnRestore();
        	Assert.assertEquals(Toast(),"Enter blockheight less than current blockheight.");
		}
        catch (Exception e) {
        	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
		}
	}
	
	/*
	 TC_111 : Validate the working of the restore option with Invalid display name and valid blockheight
	 Tc_116 : Validate the working of the restore option with Invalid display name and valid restore date.
	 */
	@Test(dataProvider ="setInvaliddata",priority = 20,groups = {"Regression"})
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
		 catch(NoSuchElementException E) {
			 restorefromseedpage.clickBtnRestore();		 
			 Assert.assertEquals(Toast(),"Please enter a valid name");			 
		 }
		 catch (Exception e) {
				Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
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
		 catch(NoSuchElementException E) {
			 restorefromseedpage.clickBtnRestore();		 
			 Assert.assertEquals(Toast(),"Please enter a valid name");			 
		 }
		 catch (Exception e) {
			//	
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
	@Test(dataProvider = "setValiddata",priority = 21,groups = {"Regression","Smoke"} )
	public void TC_110_To_Validate_the_working_of_the_restore_option_with_valid_datas_display_name_and_valid_blockheight (HashMap <String,String> input) throws InterruptedException {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
		restorefromseedpage.setDisplayName(input.get("DisplayName"));
	   	restorefromseedpage.setBlockheight("3000000");
	   	restorefromseedpage.clickBtnRestore();
	   	 try{
	   		 createpasswordpage = new CreatePasswordPage(driver);	   	 
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	 }
	   	 catch (StaleElementReferenceException e) {
			Thread.sleep(2000);
			Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		}
	   	driver.navigate().back();
	   	
	
	}
	   	
	   	
	
	@DataProvider
	public Object[][] setValiddata() throws IOException {
		
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//ValidDisplayName.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
		
	}
	
	/*
	TC_117 : Validate whether able to select the future date in restore from date calendar
	*/
	@Test(priority = 22,groups = {"Regression"})
	public void TC_117_To_Validate_whether_able_to_select_the_future_date_in_restore_from_date_calendar () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.clickBtnDate();
	   	restorefromseedpage.clicktextboxDate();
	   Assert.assertFalse(restorefromseedpage.CheckFutureDate().isEnabled());
	   restorefromseedpage.clickCancel();
	   restorefromseedpage.clickBtnBlockheight();
	   
	}
	
	/*
	 TC_122 : Validate the text box of the Display Name screen by entering values above boundary value.
	 */
	@Test(priority = 23,groups = {"Regression"})
	public void TC_122_To_Validate_DisplayName_With_Above_Boundary_Value () {
		
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	    restorefromseedpage.setDisplayName("Abcdefghijklmnopqrstuvwxyz1");
	    restorefromseedpage.setBlockheight("3500000");
	    restorefromseedpage.clickBtnRestore();
       try {
    	   Assert.assertEquals(Toast(),"Please pick a shorter display name");
       }
       catch (NoSuchElementException e) {
    	   restorefromseedpage.clickBtnRestore();
    	   Assert.assertEquals(Toast(),"Please pick a shorter display name");
     	}
       catch (StaleElementReferenceException e) {
    	   restorefromseedpage.clickBtnRestore();
    	   Assert.assertEquals(Toast(),"Please pick a shorter display name");
	     }
       catch (Exception e) {
    	   Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	}
       restorefromseedpage.clearValues();
   }
	
	/*
	TC_120 : Validate whether able to paste Alphabets blockheight textbox.
	*/
	@Test(priority = 24,groups = {"Regression"})
	public void TC_120_To_Validate_whether_able_to_paste_Alphabets_Values_in_blockheight_textbox () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_Blockheight(("Abcde"));
	   	Assert.assertFalse(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
	   
	}
	
	
	/*
	TC_121 : Validate whether able to paste Special characters in blockheight textbox.
	*/
	@Test(priority = 25,groups = {"Regression"})
	public void TC_To_Validate_whether_able_to_paste_Speical_Character_Values_in_blockheight_textbox () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_Blockheight("!@#$%");
	   	Assert.assertFalse(restorefromseedpage.BlockheightTextBox().equals(null),"Able to paste invalid datas");
	   
	}
	
	/*
	TC_119 : validate the working of the restore option by paste values in textboxes.
	*/
	@Test(priority = 26,groups = {"Regression","Smoke"})
	public void TC_119_To_validate_the_working_of_the_restore_option_by_paste_values_in_textboxes () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.paste_Value_In_DisplayName("Chris");
	   	restorefromseedpage.paste_Value_In_Blockheight("3000000");
	   	
	   		restorefromseedpage.clickBtnRestore();
	   	 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.getTextPageTitle()));
	   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   		driver.navigate().back();
	   		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());	
	}
	
	
	/*
	TC_118 : Validate the working of the restore option with valid display name and valid restore date.
	*/
	@Test(priority = 27, groups = {"Regression","Smoke"})
	public void TC_118_To_Validate_the_working_of_the_restore_with_valid_display_name_and_valid_restore_date () {
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
	   	restorefromseedpage.setDisplayName("chris");
	   	restorefromseedpage.selectTodayDate();
	  
	   		restorefromseedpage.clickBtnRestore();
	   	 createpasswordpage = new CreatePasswordPage(driver);
	   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   	 wait.until(ExpectedConditions.visibilityOf(createpasswordpage.getTextPageTitle()));
	   		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   
	}
	
	
	/*
	 Setup to navigate to home screeen in signInFlow
	 No need of create Password screen validation, because create password screen scenarios tested in create account flow
	 */
	@Test(priority = 28,groups = {"Regression","Smoke"})
	public void TC_TO_validate_Navigation_To_home_with_Valid_Password() throws InterruptedException {
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(2000);
		createpasswordpage.clickOk();
		homepage = new HomePage(driver);
		try {
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.visibilityOf(homepage.Element_Of_chat_Item()));
		Assert.assertTrue(homepage.Element_Of_chat_Item().isDisplayed());
		}
		catch (StaleElementReferenceException e) {
			Assert.assertTrue(homepage.Element_Of_chat_Item().isDisplayed());
		}
		
		
	
}
	
}

