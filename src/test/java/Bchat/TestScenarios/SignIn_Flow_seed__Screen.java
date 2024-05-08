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
public class SignIn_Flow_seed__Screen extends baseClass{

	SeedPage seedpage;
	RestoreFromSeedPage restorefromseedpage;
	
	/*
	 TC_90.1	To Validate Whether Able to Navigate Previous screen 
	 */
	@Test(priority =0)
	public void TC_90_1_To_Validate_Whether_Able_to_Navigate_Previous_screen () {
		
		landingpage.clickSignIn();
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
	Validate the presence of placeholder in the text box of the Display Name screen.
	*/
	@Test(priority =1)
	public void TC_To_Validate_the_presence_of_placeholder_in_the_Restore_From_seed_text_box () {
		
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		Assert.assertEquals(seedpage.Placeholder(),"Enter your recovery seed to restore your account.");
		
	}
		
	/*
	Validate whether crusher blink on clicking the text box of Restore from screen.
    */
	@Test(priority =2)
    public void	TC_To_Validate_whether_crusher_blink_on_clicking_the_Restore_From_Seed_text_Box () {
	
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
	 TC_92 :	Validate the working of the next option without entering seed.
	 */
	@Test(priority =3)
	 public void TC_92_To_Validate_the_working_of_the_next_option_without_entering_seed () {
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clickNext();
		Assert.assertEquals(Toast(), "Please enter valid seed");
		
	}
	
	
//	/*
//	 TC_ :	Validate the working of the paste button without copying seed.
//	 */
//	@Test(priority =4)
//	 public void TC_To_Validate_the_working_of_the_paste_button_without_copying_seed () {
//		
//		seedpage = new SeedPage(driver);
//		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
//		driver.getClipboardText();
//		seedpage.clickPasteButton();
//		Assert.assertEquals(Toast(), "Make sure you have copied the seed!");
//		
//	}
	
	/*
	 TC_89 : Validate whether able to paste the copied seed.	
	 */
	@Test(priority =5)
	public void TC_89_To_Validate_whether_able_to_paste_the_copied_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.pasteSeedValue();
	    Assert.assertEquals(seedpage.SeedValueCount(),"25/25");
	}
	
	/*
	 TC_90 :  Validate whether able to clear the entered seed
	 */
	@Test(priority =6)
	 public void TC_90_To_Validate_whether_able_to_clear_the_entered_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		Assert.assertEquals(seedpage.SeedValueCount(),"25/25");
		seedpage.clickClear();
		Assert.assertEquals(seedpage.SeedValueCount(),"0/25");
	 }
	
	/*
	Validate the text box of the restore from screen by entering values below boundary value.
	*/
	@Test(priority = 7)
	public void TC_To_Validate_the_text_box_of_the_restore_from_screen_by_entering_values_below_boundary_value () {
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
	Validate the text box of the restore from screen by entering values above boundary value.
   */
	@Test(priority = 8)
	public void TC_To_Validate_the_text_box_of_the_restore_from_seed_by_entering_values_above_boundary_value () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.set_above_Boundary_SeedValue();
		Assert.assertEquals(seedpage.SeedValueCount(), "25/25");
	}

	/*
	 TC_91 : Validate whether able to type a seed.
	 */
	@Test(priority = 9)
	 public void TC_91_To_Validate_whether_able_to_type_a_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.EnterSeedValue();
		Assert.assertEquals(seedpage.SeedValueCount(), "25/25");	
	 }
	
	/*
	 TC_95 :	Validate Whether entered seed is editable
	 */
	@Test(priority = 10)
  public void TC_95_To_Validate_Whether_Entered_seed_is_editable () {
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
	 TC_93 :	Validate the working of the next option by entering Invalid seed.
	 */
	@Test(dataProvider = "setdata",priority = 11)
	 public void TC_93_To_Validate_the_working_of_the_next_option_by_entering_Invalid_seed ( HashMap <String,String> input) {
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
	 Validate the working of next option by pasting 25 blank space value
	 */
	@Test(priority = 12)
	public void Validate_the_working_of_next_option_by_pasting_25_blank_space_value (){
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		
		seedpage.setSeedValue("                         ");
		seedpage.clickNext();
		Assert.assertEquals(Toast(), "Please enter valid seed");
	}
	
	/*
	 TC_94 :	Validate the working of the next option by entering Valid seed.
	 */
	@Test(priority = 13)
	public void TC_94_To_Validate_the_working_of_the_next_option_by_entering_Valid_seed () {
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.clearSeedValues();
		seedpage.EnterSeedValue();
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
		Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());	
	}
	

	
	
	
}
