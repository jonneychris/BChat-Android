package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Join_SocialGroup_screen_And_its_Functionalities extends baseClass {

	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	MenuPage menupage;
	SocialGroupPage socialgrouppage;
	WebDriverWait wait;
	ChatPage chatpage;
	
	/*
	 pre Setup
	 */
	@Test(priority = 0)
	public void preSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		landingpage.clickCreateAccount();
		displaynamepage =new DisplayNamePage(driver);
		Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
		displaynamepage.setDisplayName("Chris");
		displaynamepage.clickContinue();
		registerpage= new RegisterPage(driver);
		wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
		Assert.assertEquals(registerpage.pageTitle(),"Register");
		Thread.sleep(2000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(2000);
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
	}
	
	/*
	Validate whether able to navigate back to the Home screen.
	*/
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_HomeScreen () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
	}
	
	
	/*
	Validate whether suggested social groups showing.
	*/
	@Test(priority = 2)
	public void To_Validate_whether_suggested_social_groups_showing () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		wait = new  WebDriverWait(driver, Duration.ofMinutes(5));
		//wait.until();
		for(int i =0; i<5 ; i++) {
		Assert.assertTrue(socialgrouppage.get_Element_of_Groups().get(i).isDisplayed());
		}
		
		}
	
	/*
	Validate whether able to join the groups shown in suggestion.
	*/
	@Test(priority = 3)
	public void To_Validate_whether_able_to_join_the_groups_shown_in_suggestion () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.join_Beldex_Group();
		chatpage = new ChatPage(driver);
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Beldex");
		chatpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
	}
	
	/*
	Validate next option in the Join Social group by entering a Invalid URL.
	*/
	@Test(priority = 4)
	public void To_Validate_next_option_in_Join_SocialGroup_by_entering_a_Invalid_URL () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("http://www.bchatgroup");
		try {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		socialgrouppage.clear_textBox();
	}
	
	
	/*
	Validate the next option without entering values in url 
	*/
	@Test(priority = 5)
	public void To_Validate_the_next_option_without_entering_values_in_url () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Next();
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
	}
	
	/*
	Validate the presence of placeholder inside the text box 
	*/
	@Test(priority = 6)
	public void To_Validate_the_presence_of_placeholder_inside_the_textbox () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		Assert.assertEquals(socialgrouppage.get_Placeholder_Value(), "Enter a social group URL");
	}
	
	
	/*
	Validate the next option in the join social group with empty space value
	*/
	@Test(priority = 7)
	public void To_Validate_the_next_option_in_join_socialGroup_with_empty_space_value () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("  ");
		
		try{
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Invalid URL");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Invalid URL");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Invalid URL");
		}
		socialgrouppage.clear_textBox();
	}
		
	
	/*
	Validate the text box of the join social Group using special Characters. 
	*/
	@Test(priority = 8)
	public void To_Validate_the_textbox_of_join_socialGroup_using_special_Characters () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("@#$%^&");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(),"@#$%^&");
	try {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Invalid URL");
	}
	catch (NoSuchElementException e) {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Invalid URL");
	}
	catch (StaleElementReferenceException e) {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Invalid URL");
	}
		socialgrouppage.clear_textBox();
	}
	
	/*
	 Validate Whether value entered inside textbox is editable.
	 */
	@Test(priority = 9)
	public void To_Validate_Whether_value_entered_inside_textbox_is_editable () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("www.Bchat");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(),"www.Bchat");
		socialgrouppage.clear_textBox();
		socialgrouppage.Enter_Values_In_textBox("www.beldex");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(),"www.beldex");
		socialgrouppage.clear_textBox();
	}
	
	
	/*
	Validate the text box of the join social Group using numerical values..
	*/
	@Test(priority = 10)
	public void To_Validate_the_textbox_of_join_socialGroup_using_numerical_values () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("123456");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(),"123456");
		try {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");			
		}
		
		socialgrouppage.clear_textBox();
	}
	
	
	/*
	Validate the text box of the join social Group using Alphabets both in uppercase and lower case. 
	*/
	@Test(priority = 11)
	public void To_Validate_the_textbox_of_join_socialGroup_using_Alphabets_both_in_upperCase_and_lowerCase () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("BCHAT");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(),"BCHAT");
		try {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		
		socialgrouppage.clear_textBox();
		socialgrouppage.Enter_Values_In_textBox("bchat");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(),"bchat");
		try {
		socialgrouppage.click_Next();
		Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.click_Next();
			Assert.assertEquals(Toast() ,"Couldn't join social group");
		}
		socialgrouppage.clear_textBox();
	}
	
	

	
	/*
	 Validate Whether able to paste values in text box.
	 */
	@Test(priority = 12)
	public void To_Validate_Whether_able_to_paste_values_in_textbox () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.paste_Values("Paste values");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(), "Paste values");
		socialgrouppage.clear_textBox();
	
	}
	
	

	/*
	Validate Scanner in the Join Social group by scanning a Invalid BarCode.
	*/
	@Test(priority = 13)
	public void To_Validate_Scanner_in_the_Join_SocialGroup_by_scanning_a_Invalid_BarCode () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Scanner();
		try {
		socialgrouppage.upload_Invalid_QR_code();
		}
        catch (NoSuchElementException e) {
			driver.navigate().back();
			driver.navigate().back();
			socialgrouppage.click_Scanner();
			socialgrouppage.upload_Invalid_QR_code();
			Assert.assertEquals(Toast(),"Invalid URL");
		}
		try {
		Assert.assertEquals(Toast(),"Invalid URL");
		}
		catch (NoSuchElementException e) {
			
			socialgrouppage.upload_Invalid_QR_code();
			Assert.assertEquals(Toast(),"Invalid URL");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.upload_Invalid_QR_code();
			Assert.assertEquals(Toast(),"Invalid URL");
		}
		driver.navigate().back();
		
		}
	

	/*
	Validate next option in the Join Social group by entering a valid URL. 
	*/
	@Test(priority = 14)
	public void To_Validate_next_option_in_Join_SocialGroup_by_entering_a_valid_URL () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.Enter_Values_In_textBox("http://social.beldex.io/bchat?public_key=0cfdbcc8bba5989a6787019c6635c08415c103174609360f9c3e4e764ef48073");
		socialgrouppage.click_Next();
		chatpage = new ChatPage(driver);
	try {
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bchat");
		chatpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
	}
	catch (AssertionError e) {
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"BChat");
		chatpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.openJoinSocialGroup();
	}
	
	
	}
	
	/*
	Validate whether able to join social group without internet connection.
	*/
	@Test(priority = 15)
	public void To_Validate_whether_able_to_join_socialGroup_without_internet_connection () throws InterruptedException {
		
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		try {
		socialgrouppage.join_MasterNode_Group();
		Assert.assertEquals(Toast(),"Couldn't join social group");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.join_MasterNode_Group();
			Assert.assertEquals(Toast(),"Couldn't join social group");
		}
		catch (StaleElementReferenceException e) {
			socialgrouppage.join_MasterNode_Group();
			Assert.assertEquals(Toast(),"Couldn't join social group");
		}
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
 
     }
	
	
	/*
	validate whether cursor blinks while clicking the textbox  
	*/
	@Test(priority = 16)
	public void To_validate_whether_cursor_blinks_while_clicking_the_textbox () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Url_Textbox();
		Assert.assertTrue(socialgrouppage.activeElement().isDisplayed());
	}	
	
	
}
	
