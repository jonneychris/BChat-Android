package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyWalletPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SendPage;
import POM.SocialGroupPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class Home_Screen_and_its_functionalities_In_Restore_Account_Flow extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	MenuPage menupage;
	WebDriverWait wait;
	
	
	/*
	 pre setup
	 */
	@Test(priority = 0,groups = {"Regression"} )
	public void PreSetup () throws InterruptedException {
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
		seedpage.pasteSeedValue();
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
	   	restorefromseedpage.clearValues();
		restorefromseedpage.setDisplayName("Chris");
		restorefromseedpage.setBlockheight("3200000");
	   	restorefromseedpage.clickBtnRestore();
	   	createpasswordpage = new CreatePasswordPage(driver);
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	createpasswordpage.setValidPassword();
	   	Thread.sleep(2000);
	   	createpasswordpage.clickOk();
	   	homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"BChat");

	}
	
	/*
	 Validate whether the recent chat histories are showing .
	 */
	@Test(priority = 55,groups = {"Regression"} )
	public void To_Validate_whether_the_recent_chat_histories_are_showing () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		
		try {
			wait = new WebDriverWait(driver, Duration.ofMinutes(5));
			wait.until(ExpectedConditions.invisibilityOf(homepage.BlankChatScreen));
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
	}
	
	/*
	Validate the presence of placeholder in the text box.
	*/
	@Test(priority = 56,groups = {"Regression"} )
	public void To_Validate_the_presence_of_placeholder_in_the_text_box () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertEquals(homepage.SearchPlaceholder(), "Search people and groups");
	}
	
	/*
	Validate whether crusher blink on clicking the text box of search functionality.
	*/
	@Test(priority =57,groups = {"Regression"})
	public void To_Validate_Whether_crusor_Blinks_on_clicking_the_search_textbox () {
		homepage = new HomePage(driver);
	   Assert.assertTrue(homepage.visblity_of_crusor());
	   Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	}
	
	/*
	validate whether paste option is working on the text box.
	*/
	@Test(priority=58,groups = {"Regression"})
	public void To_Validate_wether_paste_option_on_the_text_box () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.pastevalues("hello");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"hello");
		homepage.clearTextBox();
	}
	
	
	
	/*
	Validate whether the value entered in the text box is editable.
	Validate whether the value entered in the text box is delete able.
	*/
	@Test(priority = 59,groups = {"Regression"})
	public void To_Validate_Values_enterd_in_textbox_is_editable_and_deleteable () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("text");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"text");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
		homepage.enterValues("Check");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"Check");
		homepage.clearTextBox();
		
	}
	
	/*
	 validate the working of the cancel icon inside the text box
	 */
	@Test(priority = 60,groups = {"Regression"})
	public void To_validate_working_of_cnacel_icon_inside_the_textbox () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("text");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
	}
	
	/*
	Validate the text box of the search functionality with null value.
	*/
	@Test(priority = 61,groups = {"Regression"})
	public void To_Validate_the_textbox_of_the_search_functionality_with_null_value () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("  ");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
	}
	
	/*
	Validate the text box of the search Functionality using special Characters.
	*/
	@Test(priority = 62,groups = {"Regression"})
	public void To_Validate_the_textbox_of_the_search_Functionality_using_special_Characters () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("@#$%");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"@#$%");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
	}
	
	/*
	Validate the text box of the search Functionality using Alphabets both in uppercase and lower case.
	*/
	@Test(priority = 63,groups = {"Regression"})
	public void To_Validate_the_textbox_of_search_Functionality_using_Alphabets_both_in_UpperCase_and_lowerCase () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("ABCDE");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"ABCDE");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
		homepage.enterValues("abcde");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"abcde");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
		
	}
	
	
	/*
	Validate the text box of the search Functionality is Allowing the Space.
	*/
	@Test(priority = 64,groups = {"Regression"})
	public void To_Validate_the_textbox_of_search_Functionality_is_Allowing_the_Space () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("Hi Hello ok");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"Hi Hello ok");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
	}
	
	/*
	Validate the text box of the search Functionality by numerical value.
	*/
	@Test(priority = 65,groups = {"Regression"})
	public void To_Validate_the_textbox_of_search_Functionality_by_Numerical_values () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		homepage.enterValues("123456");
		Assert.assertEquals(homepage.get_Values_From_Search_textbox(),"123456");
		homepage.click_cancel_icon_inside_textbox();
		Assert.assertTrue(homepage.visiblity_of_placeholder());
	}
	
	
	/*
	Validate whether searched messages are showing in the list
	*/
	@Test(priority = 66,groups = {"Regression"})
	public void To_Validate_whether_searched_messages_are_showing_in_the_list () {
		homepage = new HomePage(driver);
		try {
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
		}
		catch (NoSuchElementException e) {
			homepage.clickSearch();
		}
		try {
		homepage.enterValues("Hii");
		Assert.assertTrue(homepage.Element_Messages().isDisplayed());
		}
		catch (NoSuchElementException e) {
			homepage.enterValues("Hello");
			Assert.assertTrue(homepage.Element_Messages().isDisplayed());
			
		}
	}
	
	
	
	/*
	Validate the search functionality using Invalid value 
	*/
	@Test(priority = 67,groups = {"Regression"})
	public void To_Validate_the_search_functionality_using_Invalid_value () {
	homepage = new HomePage(driver);
	Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	try {
	homepage.enterValues("asdfghjkl");
	Assert.assertTrue(homepage.Element_Messages().isDisplayed());
	}
	catch (NoSuchElementException e) {
		Assert.assertEquals(homepage.Search_PageTitle(), "Search");
	}
	
	}
	
	
	
}
