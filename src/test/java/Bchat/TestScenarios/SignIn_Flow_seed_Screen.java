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

import POM.RestoreFromSeedPage;
import POM.SeedPage;
import Utiles.baseClass;

/*
 Test Scenario:	To check the working of the Restore from seed functionality in the SigIn flow
 */
public class SignIn_Flow_seed_Screen extends baseClass{

	SeedPage seedpage;
	RestoreFromSeedPage restorefromseedpage;
	
	
	/*
	 presetup method for this class
	 */
	@Test(priority = 5,groups = {"Smoke","Regression"})
	public void PreSetup () {
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		
	}
	
	
	/*
	 TC_94	To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority =6,groups = {"Regression"})
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
	@Test(priority =7,groups = {"Regression"})
	public void TC_96_To_Validate_the_presence_of_placeholder_in_the_Restore_From_seed_text_box () {
		
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		Assert.assertEquals(seedpage.Placeholder(),"Enter your recovery seed to restore your account.");
		
	}
		
	/*
	TC_ 95 : Validate whether crusher blink on clicking the text box of Restore from screen.
    */
	@Test(priority =8,groups = {"Regression"})
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
	@Test(priority =9,groups = {"Regression"})
	 public void TC_102_To_Validate_the_working_of_the_next_option_without_entering_seed () {
		
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clickNext();
		Assert.assertEquals(Toast(), "Please enter valid seed");
		
	}
	
	
//	/*
//	 TC_101 :	Validate the working of the paste button without copying seed.
//	 */
//	@Test(priority =10,groups = {"Regression"})
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
	@Test(priority =11,groups = {"Regression"})
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
	@Test(priority =12,groups = {"Regression"})
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
	@Test(priority = 13,groups = {"Regression"})
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
	}

	/*
	TC_97 : Validate the text box of the restore from screen by entering values above boundary value.
   */
	@Test(priority = 14,groups = {"Regression"})
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
	@Test(priority = 15,groups = {"Regression"})
	 public void TC_99_To_Validate_whether_able_to_type_a_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.EnterSeedValue();
		Assert.assertEquals(seedpage.SeedValueCount(), "25/25");	
	 }
	
	/*
	 TC_105 :	Validate Whether entered seed is editable
	 */
	@Test(priority = 16,groups = {"Regression"})
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
	@Test(dataProvider = "setdata",priority = 17,groups = {"Regression"})
	 public void TC_103_To_Validate_the_working_of_the_next_option_by_entering_Invalid_seed ( HashMap <String,String> input) {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.setSeedValue(input.get("Seed"));
		try {
		seedpage.clickNext();
		Assert.assertEquals(Toast(),"There appears to be an invalid word in your mnemonic. Please check what you entered and try again.");
		}
		catch (Exception e) {
			seedpage.clickNext();
			Assert.assertEquals(Toast(),"There appears to be an invalid word in your mnemonic. Please check what you entered and try again.");
		}
		catch (AssertionError e) {
			seedpage.clickNext();
			Assert.assertEquals(Toast(),"Your mnemonic couldn't be verified. Please check what you entered and try again.");
		}
		}

	@DataProvider
	public Object[][] setdata() throws IOException {
		List <HashMap <String,String>>data=super.getjsonFile("//Datas//Invalid_Seed_Values.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
	}
	
	
	/*
	 TC_100 : Validate the working of next option by pasting 25 blank space value
	 */
	@Test(priority = 18,groups = {"Regression"})
	public void TC_100_To_Validate_the_working_of_next_option_by_pasting_25_blank_space_value (){
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		
		seedpage.setSeedValue("                         ");
		seedpage.clickNext();
		Assert.assertEquals(Toast(), "Please enter valid seed");
	}
	
	/*
	 TC_104 :	Validate the working of the next option by entering Valid seed.
	 */
	@Test(priority = 19,groups = {"Regression","Smoke"})
	public void TC_104_To_Validate_the_working_of_the_next_option_by_entering_Valid_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.EnterSeedValue();
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());	
	}
	

	
	
	
}
