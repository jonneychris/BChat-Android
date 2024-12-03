package Bchat.TestScenarios;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.ChatPage;
import POM.ClearDataPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.LandingPage;
import POM.MenuPage;
import POM.NewChatPage;
import POM.NewPage;
import POM.NoteToMyselfPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SettingsPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class New_Screen_And_Its_Functionalities extends baseClass{

	
	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	MenuPage menupage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	ChatPage chatpage;
    SettingsPage settingspage;
	AccountSettingsPage accountSettingsPage;
    SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
    ClearDataPage cleardatapage;
	NewPage newpage;
    NoteToMyselfPage notetotself;
	
	/*
	 * Pre Setup to New Screen
	 */
	@Test(priority = 0)
	public void PreSetup () throws InterruptedException {
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
		Thread.sleep(2000);
//		try{
//			homepage= new HomePage(driver);
//		}
//		catch (Exception e) {
//			homepage= new HomePage(driver);
//		}
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.OpenNewChat();
//		newchatpage = new NewChatPage(driver);
//		newchatpage.Check_with_ValidId_2();
//		chatpage = new ChatPage(driver);
//		chatpage.Send_one_msg();
	}
//	
//	/*
//	 * Setup for Restore account
//	 */
//	@Test(priority = 1)
//	public void Setup_For_Restore_Account () throws InterruptedException {
//		homepage = new HomePage(driver);
//		homepage.clickMenuDrawer();
//		menupage = new MenuPage(driver);
//		menupage.click_Account_Settings();
//		accountSettingsPage = new AccountSettingsPage(driver);
//	   accountSettingsPage.click_Clear_Data_option();
//	   cleardatapage = new ClearDataPage(driver);
//	   cleardatapage.click_ok();
//		//Assert.assertEquals(cleardatapage.cleardata_popup_screen_title(), "Clear All Data");
//		cleardatapage.click_Clear_Or_delete_option();
//		landingpage = new LandingPage(driver);
//	try {	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(landingpage.landingpage_Element()));
//		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
//	}
//	catch (NoSuchElementException e) {
//		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
//	}
//	catch (StaleElementReferenceException e) {
//		Assert.assertEquals(landingpage.pageTitle(), "Welcome to");
//	}
//	landingpage.clickSignIn();
//	   seedpage = new SeedPage(driver);
//		Assert.assertTrue(seedpage.SeedTextBox().isDisplayed());
//		seedpage.EnterSeedValue("onward rotate ailments dozen sidekick slackens pioneer rising boss civilian audio opposite zero tsunami upper sample cuisine strained number humid sewage subtly sifting sushi boss");
//		seedpage.clickNext();
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//		restorefromseedpage.setDisplayName("Chris");
//		restorefromseedpage.setBlockheight("3200000");
//		
//	   	restorefromseedpage.clickBtnRestore();
//	   	createpasswordpage = new CreatePasswordPage(driver);
//	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
//	   	createpasswordpage.setValidPassword();
//	   	Thread.sleep(2000);
//	   	createpasswordpage.clickOk();	
//	   	homepage = new HomePage(driver);
//	   try {
//		   homepage.click_DropDown();
//	   }
//	   catch (NoSuchElementException e) {
//		   homepage.click_DropDown();
//	}
//	   	homepage.click_first_request();
//	   	chatpage = new ChatPage(driver);
//	   	chatpage.Accept_request();
//	   	driver.navigate().back();
//	}
//	
//	
//	
//	
//	
//	/*
//	 * 
//	 * 
//	 *     New Screen and its functionalities 
//	 * 
//	 */
//	
//	
//	
//	/*
//	 * Validate the working of invite contacts
//	 */
//	@Test(priority = 2)
//	public void To_Validate_the_working_of_invite_contacts () {
//		homepage = new HomePage(driver);
//		homepage.open_NewScreen();
//		newpage = new NewPage(driver);
//		newpage.click_Invite_friend();
//		newpage.click_cancel_in_Invite();
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//	}
//	
//	
//	/*
//	 * validate whether contacts present in the home screen are showing here
//	 */
//	@Test(priority = 3)
//	public void To_validate_whether_contacts_present_in_the_home_screen_are_showing_here () {
//		homepage = new HomePage(driver);
//	String contactname =	homepage.get_DisplayName_Or_Id_Of_ChatItem();
//		homepage.open_NewScreen();
//		newpage = new NewPage(driver);
//		String valueInNewScreen = newpage.get_Contact_value_from_List(contactname);
//		Assert.assertEquals(contactname, valueInNewScreen);
//		
//	}
//	
//	/*
//	 * Validate the presence of placeholder
//	 */
//	@Test(priority = 4)
//	public void To_Validate_the_Presenece_Of_Placeholder () {
//		newpage = new NewPage(driver);
//		newpage.click_search_icon();
//		Assert.assertEquals(newpage.search_textBox_Placeholder(), "Search people and groups");
//		newpage.click_search_icon();
//	}
//	
//	/*
//	 * Validate the search text box with valid value
//	 */
//	@Test(priority = 5)
//	public void To_Validate_the_search_text_box_with_valid_value () {
//		newpage = new NewPage(driver);
//		newpage.Enter_values_in_search_textbox("Chris");
//		Assert.assertTrue(newpage.get_Element_of_contact().isDisplayed());
//		newpage.clear_Values_in_Search_textbox();
//		newpage.click_search_icon();
//	}
//	
//	/*
//	 * Validate the search text box with invalid value
//	 */
//	@Test(priority = 6)
//	public void To_Validate_the_search_text_box_with_invalid_value () {
//		newpage = new NewPage(driver);
//		newpage.Enter_values_in_search_textbox("none");
//		try{
//			Assert.assertFalse(newpage.get_Element_of_contact().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			newpage.clear_Values_in_Search_textbox();
//		}
//		
//	}
//	
//	/*
//	 * Validate the working of the cancel icon inside the search text box
//	 */
//	@Test(priority = 7)
//	public void To_Validate_the_working_of_the_cancel_icon_inside_the_search_text_box () {
//		newpage = new NewPage(driver);
//		newpage.Enter_values_in_search_textbox("Hello");
//		Assert.assertEquals(newpage.get_Values_From_Search_textbox(), "Hello");
//		newpage.click_cancel_in_search_textbox();
//		Assert.assertEquals(newpage.get_Values_From_Search_textbox(), "");
//		
//	}
//	
//	/*
//	 * Validate whether able to paste values in the text box
//	 */
//	@Test(priority = 8)
//	public void To_Validate_whether_able_to_paste_values_in_the_text_box () {
//		newpage = new NewPage(driver);
//		newpage.paste_Values_in_Search_Textbox("Test");
//		Assert.assertEquals(newpage.get_Values_From_Search_textbox(), "Test");
//		newpage.clear_Values_in_Search_textbox();
//	}
//	
//	/*
//	 * Validate whether able to navigate back to the home screen
//	 */
//	@Test(priority = 9)
//	public void To_Validate_whether_able_to_navigate_back_to_the_home_screen () {
//		newpage = new NewPage(driver);
//		
//		newpage.click_Back_Arrow();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		homepage.open_NewScreen();
//	}
//	
//	/*
//	 * Validate the working of note to self option
//	 */
//	@Test(priority = 10)
//	public void To_Validate_the_working_of_note_to_self_option () {
//		newpage = new NewPage(driver);
//		newpage.Click_Note_to_Self();
//		notetotself = new NoteToMyselfPage(driver);
//		notetotself.click_Back_Arrow();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"Chats");
//		
//	}
//
//	
//	
//	
//	/*
//	 * 
//	 * 
//	 * 
//	 * New Chat Screen and its functionalities
//	 * 
//	 * 
//	 * 
//	 */
//	
//	
//	/*
//	 Validate whether able to navigate back to the home screen
//	 */
//	@Test(priority = 11,groups = {"Regression"})
//	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
//		homepage = new HomePage(driver);
//		homepage.OpenNewChat();
//	   newchatpage = new NewChatPage(driver);
//	   Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//	   newchatpage.click_Back_Arrow();
//	   homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		
//	
//	}
//
//	/*
//	Validate the New Chat by entering a Invalid BChat ID.
//	*/
//	@Test(priority = 12 ,groups = {"Regression","Smoke"})
//	public void To_Validate_the_NewChat_by_entering_a_Invalid_BChat_ID () {
//		homepage = new HomePage(driver);
//		homepage.OpenNewChat();
//		newchatpage = new NewChatPage(driver);
//		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 
//		 try {
//			 newchatpage.Check_with_Invalid();
//			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 }
//		 catch (NoSuchElementException e) {				
//				try {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//				catch (NoSuchElementException e1) {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//			 }		
//
//			 catch (StaleElementReferenceException e) {				
//					try {
//						Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//					}
//					catch (NoSuchElementException e1) {
//						Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//					}
//				 }
//		
//		 newchatpage.clear_textBox();
//	}
//	
//	
//	/*
//	validate the new chat with invalid bns name
//	*/
//	@Test(priority = 13,groups = {"Regression","Smoke"})
//	public void To_validate_the_new_chat_with_invalid_bns_name () {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 try {
//			 newchatpage.Enter_BNS_Name("invalidBns.bdx");
//			 newchatpage.click_Lets_Bchat();
//			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 }
//		 catch (NoSuchElementException e) {				
//			try {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//			catch (NoSuchElementException e1) {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//		 }		
//
//		 catch (StaleElementReferenceException e) {				
//				try {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//				catch (NoSuchElementException e1) {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//			 }	
//		
//		
//		 newchatpage.clear_textBox(); 
//	}
//	
//	
//	
//	/*
//	Validate Whether next button is enable without enter a value in the Enter BChat ID field.
//	*/
//	@Test(priority = 14,groups = {"Regression"})
//	public void To_Validate_Whether_next_button_is_enable_without_enter_a_value_in_BChatID_field () {
//		 newchatpage = new NewChatPage(driver);
//		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 newchatpage.click_Lets_Bchat();
//		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//	
//	
//	}
//
//	
//	/*
//	validate the new chat without entering .bdx in bns name
//	*/
//	@Test(priority = 15,groups = {"Regression"})
//	public void To_validate_the_new_chat_without_entering_bdx_in_bns_name (){
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 try {
//			 newchatpage.Enter_BNS_Name("test");
//			 newchatpage.click_Lets_Bchat();
//			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 }
//	
//		 catch (NoSuchElementException e) {				
//			try {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//			catch (NoSuchElementException e1) {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//		 }		
//
//		 catch (StaleElementReferenceException e) {				
//				try {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//				catch (NoSuchElementException e1) {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//			 }
//		 	 newchatpage.clear_textBox();
//	}
//	
//	/*
//	validate the new chat with empty space value
//	*/
//	@Test(priority = 16,groups = {"Regression"})
//	public void To_validate_the_new_chat_with_empty_space_value () {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 try {
//			 newchatpage.Enter_BNS_Name(" ");
//			 newchatpage.click_Lets_Bchat();
//			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 }
//		 catch (NoSuchElementException e) {				
//			try {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//			catch (NoSuchElementException e1) {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//		 }		
//
//		 catch (StaleElementReferenceException e) {				
//				try {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//				catch (NoSuchElementException e1) {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//			 }
//		 newchatpage.clear_textBox();
//		 
//			 }
//		 
//			
//	/*
//	validate the new chat with special characters
//	*/
//	@Test(priority = 17,groups = {"Regression"})
//	public void To_validate_the_new_chat_with_special_characters () {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 try {
//			 newchatpage.Enter_BNS_Name("@#$%.bdx");
//			 newchatpage.click_Lets_Bchat();
//			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		 }
//		 
//		 catch (NoSuchElementException e) {				
//			try {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//			catch (NoSuchElementException e1) {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//		 }		
//
//		 catch (StaleElementReferenceException e) {				
//				try {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//				catch (NoSuchElementException e1) {
//					Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//				}
//			 }
//		 newchatpage.clear_textBox();
//	}
//
//	/*
//	validate the new chat function without internet connection
//	*/
//	@Test(priority = 18,groups = {"Regression"})
//	public void To_validate_the_new_chat_function_without_internet_connection () throws InterruptedException {
//		
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		turnOff_Mobile_Wifi();
//		Thread.sleep(5000);
//		
//		newchatpage.Enter_BNS_Name("Snowman.bdx");
//		try {
//		newchatpage.click_Lets_Bchat();
//		Assert.assertEquals(Toast(),"Please check your internet connection");
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		}
//		catch (StaleElementReferenceException e) {
//			Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		}
//		newchatpage.clear_textBox();
//		newchatpage.Paste_Values_In_textBox("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
//		try {
//			newchatpage.click_Lets_Bchat();
//			Assert.assertEquals(Toast(),"Please check your internet connection");
//			}
//			catch (NoSuchElementException e) {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//			catch (StaleElementReferenceException e) {
//				Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//			}
//			turnOn_Mobile_Wifi();
//			newchatpage.clear_textBox();
//			Thread.sleep(5000);
//		}
//	
//	/*
//	validate whether able to paste values in the text box
//	*/
//	@Test(priority = 19,groups = {"Regression"})
//	public void To_validate_whether_able_to_paste_values_in_text_box () throws InterruptedException {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		newchatpage.Paste_Values_In_textBox("snowman.bdx");
//		Assert.assertEquals(newchatpage.get_Values_from_TextBox(), "snowman.bdx");
//		newchatpage.clear_textBox();
//		newchatpage.Paste_Values_In_textBox("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
//		Assert.assertEquals(newchatpage.get_Values_from_TextBox(),"bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
//		newchatpage.clear_textBox();
//	
//	}
//
//	
//	/*
//	Validate the working of upload from gallery option with valid Qr code image       
//	*/
//	@Test(priority = 20,groups = {"Regression"})
//	public void To_Validate_the_working_of_upload_from_gallery_option_with_valid_Qr_code_image () {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		newchatpage.Upload_valid_Qr_code();
//		chatpage = new ChatPage(driver);
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdaa7287016e543715768b572757bd84f6bdfa720327e067902bbe437e5ad76f46");
//		chatpage.click_Back_Arrow();
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.OpenNewChat();
//		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//
//		
//	}
//	
//	/*
//	Validate the working of upload from gallery option with invalid Qr code image
//	*/
//	@Test(priority = 21,groups = {"Regression"})
//	public void To_Validate_the_working_of_upload_from_gallery_option_with_invalid_Qr_code_image ()	{
//		newchatpage = new NewChatPage(driver);
//		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		
//		try{
//			newchatpage.Upload_Invalid_Qr_Code();
//			Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
//			
//		}
//		catch (NoSuchElementException e) {
//			try{
//				Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
//			}
//			catch (NoSuchElementException e1) {
//				Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
//			}
//		}
//		catch (StaleElementReferenceException e) {
//			Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
//		}
//		catch (TimeoutException e) {
//			 if(newchatpage.imageLoader().isDisplayed()) {
//				 Minimize_the_App();
//				 homepage.OpenNewChat();	
//				 }
//		}	
//		driver.navigate().back();
//	}
//	
//	
//	/*
//	Validate the New Chat by entering a valid BChat ID.
//	*/
//	@Test(priority = 22,groups = {"Regression","Smoke"})
//	public void To_Validate_the_New_Chat_by_entering_a_valid_BChat_ID () throws InterruptedException {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		newchatpage.Enter_BNS_Name("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
//		newchatpage.click_Lets_Bchat();
//		chatpage = new ChatPage(driver);
//		try {
//		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
//		}
//		catch (NoSuchElementException e) {
//			
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");	
//		}
//		chatpage.click_Back_Arrow();
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.OpenNewChat();
//		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//	}
//	
//	/*
//	validate the new chat with valid bns name
//	*/
//	@Test(priority = 23,groups = {"Regression","Smoke"})
//	public void To_validate_the_new_chat_with_valid_bns_name () throws InterruptedException {
//		newchatpage = new NewChatPage(driver);
//		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		try {
//			newchatpage.Enter_BNS_Name("snowman.bdx");
//			newchatpage.click_Lets_Bchat();
//			chatpage = new ChatPage(driver);
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Snowman.bdx");
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Snowman.bdx"); 
//		}
//		catch (TimeoutException e) {
//			
//			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Snowman.bdx"); 
//			
//		}
//		try{
//			chatpage.click_Back_Arrow();
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		}
//		catch (NoSuchElementException e) {
//			driver.navigate().back();
//			Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		}
//	}
//		
//	
//	
//	
//	/*
//	 * 
//	 * 
//	 * 
//	 * Create Secret group and its functionalities
//	 * 
//	 * 
//	 */
//	
//	
//	
//	/*
//	Validate whether able to navigate back to the home screen
//	*/
//	@Test(priority = 24,groups = {"Regression"})
//	public void To_Validate_whether_able_to_navigate_back_to_home_screen_From_Create_Secret_Screen () {
//		  secretgrouppage = new SecretGroupPage(driver);
//		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		  secretgrouppage.click_Back_Arrow();
//			homepage = new HomePage(driver);
//		   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
//		   	homepage.openNewSecretGroup();
//	} 
//
//	
//	/*
//	Validate Whether able to select the contacts showing.
//	*/
//	@Test(priority = 25,groups = {"Regression","Smoke"})
//	public void To_Validate_Whether_able_to_select_the_contacts_showing () {
//		secretgrouppage = new SecretGroupPage(driver);
//		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"false");
//		  secretgrouppage.select_FirstContact_In_List();
//		  Assert.assertTrue(secretgrouppage.First_Contact_Selected().isDisplayed());
//		  
//	}
//	
//	/*
//	 validate Whether able to Unselect the selected contact
//	 */
//	@Test(priority = 26,groups = {"Regression","Smoke"})
//	public void To_Validate_Whether_able_to_Unselect_the_contacts_showing () {
//		secretgrouppage = new SecretGroupPage(driver);
//		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		  Assert.assertTrue(secretgrouppage.First_Contact_Selected().isDisplayed());
//		  secretgrouppage.select_FirstContact_In_List();
//		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"false");
//	}
//	
//	/*
//	Validate Whether able to multi select the contacts showing
//	*/
//	@Test(priority = 27,groups = {"Regression","Smoke"})
//	public void To_Validate_Whether_able_to_multi_select_the_contacts_showing () {
//		secretgrouppage = new SecretGroupPage(driver);
//		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		  secretgrouppage.multiselect_contacts_In_List();
//		  Assert.assertTrue(secretgrouppage.First_Contact_Selected().isDisplayed());
//		  Assert.assertTrue(secretgrouppage.Second_Contact_Selected().isDisplayed());
//		  secretgrouppage.multiselect_contacts_In_List();
//	}
//	
//	/*
//	Validate the Create function without entering a group name and without selecting a member.
//	*/
//	@Test(priority = 28,groups = {"Regression"})
//	public void To_Validate_Create_function_without_entering_groupName_and_without_selecting_member () {
//		secretgrouppage = new SecretGroupPage(driver);
//		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		secretgrouppage.click_Create_button();
//		Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	}
//	
//	
//	/*
//	Validate the Create function with entering a group name and without selecting a member.
//	*/
//   @Test(priority = 29,groups = {"Regression"})
//   public void To_Validate_Create_function_with_entering_groupName_and_without_selecting_member () {
//	   secretgrouppage = new SecretGroupPage(driver);
//		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		 secretgrouppage.Enter_values_in_GroupName("Test");
//		 try {
//			 secretgrouppage.click_Create_button();
//		 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
//		 }
//		 catch (NoSuchElementException e) {
//			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group"); 
//		}
//		 catch (StaleElementReferenceException e) {
//			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		}
//		 catch (AssertionError e) {
//			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		}
//		 secretgrouppage.clear_TextBoxes();
//		 }
//   
//   /*
//   Validate the Create function without entering a group name and with selecting a member.
//   */
//   @Test(priority = 30,groups = {"Regression"})
//   public void To_Validate_the_Create_function_without_entering_groupName_and_with_selecting_member () {
//	   secretgrouppage = new SecretGroupPage(driver);
//		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		 secretgrouppage.select_FirstContact_In_List();
//		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		 secretgrouppage.select_FirstContact_In_List();
//   }
//   
//   /*
//    Validate the Create function with entering space value in group name and with selecting a member
//    */
//   @Test(priority = 31,groups = {"Regression"})
//   public void To_Validate_Create_function_with_entering_space_value_in_groupName_and_with_selecting_a_member () {
//	   secretgrouppage = new SecretGroupPage(driver);
//		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		 secretgrouppage.Enter_values_in_GroupName(" ");
//		 secretgrouppage.select_FirstContact_In_List();
//		 secretgrouppage.click_Create_button();
//		 try {
//			 Assert.assertEquals(Toast(),"Please enter a group name");
//		 }
//		 catch (NoSuchElementException e) {
//			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		}
//		 catch (StaleElementReferenceException e) {
//			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		}
//		 catch (AssertionError e) {
//			 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		}
//		 secretgrouppage.clear_TextBoxes();
//		 secretgrouppage.select_FirstContact_In_List();
//   }
//   
//   /*
//   Validate the Create function with entering a group name and with selecting a member.
//   */
//   @Test(priority = 32,groups = {"Regression","Smoke"})
//   public void To_Validate_Create_function_with_entering_groupName_and_with_selecting_member () {
//	   secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("Group");
//	   secretgrouppage.select_FirstContact_In_List();
//	   secretgrouppage.click_Create_button();	   
//	   try 
//	   {
//	   chatpage = new ChatPage(driver);
//	   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Group");
//      chatpage.click_Back_Arrow();
//      homepage = new HomePage(driver);
//	   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
//	   	homepage.openNewSecretGroup();
//       }
//	   catch (NoSuchElementException e) {
//		   try{chatpage = new ChatPage(driver);
//		   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Group");
//	      chatpage.click_Back_Arrow();
//	      homepage = new HomePage(driver);
//		   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
//		   	homepage.openNewSecretGroup();
//		   }
//		   catch (NoSuchElementException e1 ) {
//			driver.navigate().back();
//			homepage.open_FirstChat();
//			 Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Group");
//		      chatpage.click_Back_Arrow();
//		      homepage = new HomePage(driver);
//			   	Assert.assertEquals(homepage.Pagetitle(),"Chats");	
//			   	homepage.openNewSecretGroup();
//			
//		}
//	}
//	  
//   }
//   
//   /*
//   Validate whether crusher blink on clicking the text box of Secret Group .
//	*/
//   @Test(priority = 33,groups = {"Regression"})
//   public void To_Validate_whether_crusher_blink_on_clicking_textboxes_of_SecretGroup () {
//	   secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.click_GroupName_textbox();
//	   Assert.assertTrue(secretgrouppage.activeElement().isDisplayed());
//	   secretgrouppage.click_Search_textbox();
//	   Assert.assertTrue(secretgrouppage.activeElement().isDisplayed());
//   }
//   
//  
//   /*
//   Validate the presence of placeholder in the text box of the Secret Group.
//   */
//  @Test(priority = 34,groups = {"Regression"})
//  public void To_Validate_presence_of_placeholder_in_the_textboxes_of_SecretGroup () {
//	   secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   Assert.assertEquals(secretgrouppage.getPlacholder_of_groupName_textbox(),"Enter Secret Group name");
//	   Assert.assertEquals(secretgrouppage.getPlacholder_of_Search_textbox(), "Search Contact");
//  }
//  
//   
//   /*
//   validate whether paste option is working on the text box of the Secret Group.
//	*/
//   @Test(priority = 35,groups = {"Regression"})
//   public void To_validate_whether_paste_option_is_working_on_textbox_of_Secret_Group () {
//	   secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.pasteValues_In_TestBoxes("Test", "check");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Test");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(), "check");
//	   secretgrouppage.clear_TextBoxes();
//   }
//   
// 
//  /*
//  Validate whether able to create secret group without internet connection
//  */
//  @Test(priority = 36,groups = {"Regression"})
//  public void To_Validate_whether_able_to_create_secret_group_without_internet_connection () throws InterruptedException {
//	  	
//	  secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   turnOff_Mobile_Wifi();
//	   Thread.sleep(5000);
//	   secretgrouppage.Enter_values_in_GroupName("Test");
//	   secretgrouppage.select_FirstContact_In_List();
//	   try {
//		   
//	   secretgrouppage.click_Create_button();
//	   Assert.assertEquals(Toast(),"Please check your internet connection");
//	   }
//	   catch (NoSuchElementException e) {
//		   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		   
//		   }
//	   catch (StaleElementReferenceException e) {
//		   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		   }
//	   turnOn_Mobile_Wifi();
//	   secretgrouppage.clear_TextBoxes();
//	   Thread.sleep(5000);
//	   }
//   
//  /*
//  Validate the text box of the Secret Group Functionality using special Characters.
//  */
//  @Test(priority = 37,groups = {"Regression"})
//  public void To_Validate_the_textbox_of_Secret_Group_using_special_Characters () {
//	  secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("@#$%^");
//	   secretgrouppage.Enter_Values_In_Search_textbox("@#$%^&");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"@#$%^");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"@#$%^&");
//	   secretgrouppage.clear_TextBoxes();
//  }
//  
//  /*
//  Validate the text box of the Secret Group Functionality using Alphabets both in uppercase and lower case.
//  */
//  @Test(priority = 38,groups = {"Regression"})
//  public void To_Validate_the_textbox_of_SecretGroup_using_Alphabets_both_in_uppercase_and_lowercase () {
//	  secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("ABCDE");
//	   secretgrouppage.Enter_Values_In_Search_textbox("ABCDE");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"ABCDE");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"ABCDE");
//	   secretgrouppage.clear_TextBoxes();
//	   secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("abcde");
//	   secretgrouppage.Enter_Values_In_Search_textbox("abcde");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"abcde");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"abcde");
//	   secretgrouppage.clear_TextBoxes();
//  
//  }
//  
//  /*
//  Validate the text box of the Secret Group Functionality by numerical value.
//  */
//  @Test(priority = 39,groups = {"Regression"})
//  public void To_Validate_the_textbox_of_SecretGroup_by_numerical_value () {
//	
//	  secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("12345");
//	   secretgrouppage.Enter_Values_In_Search_textbox("12345");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"12345");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"12345");
//	   secretgrouppage.clear_TextBoxes();
//  }
//  
//  
//  /*
//  Validate whether the value entered in the text box of the Secret Group is editable.
//  */
//  @Test(priority = 40,groups = {"Regression"})
//  public void To_Validate_whether_the_value_entered_in_textbox_of_SecretGroup_is_editable_And_Deleteable () {
//	  secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("Hello");
//	   secretgrouppage.Enter_Values_In_Search_textbox("Hi");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Hello");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"Hi");
//	   secretgrouppage.clear_TextBoxes();
//	
//	   secretgrouppage = new SecretGroupPage(driver);
//	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//	   secretgrouppage.Enter_values_in_GroupName("Check");
//	   secretgrouppage.Enter_Values_In_Search_textbox("Check");
//	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Check");
//	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"Check");
//	   secretgrouppage.clear_TextBoxes();
//	   
//  }
	
  
  
	/*
	 * 
	 * 
	 *  join Social Group and its functionalities 
	 * 
	 * 
	 * 
	 */
	
	/*
	Validate whether able to navigate back to the Home screen.
	*/
	@Test(priority = 41,groups = {"Regression"})
	public void To_Validate_whether_able_to_navigate_back_to_HomeScreen () {
		homepage = new HomePage(driver);
		homepage.openJoinSocialGroup();
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		
	}
	
	
	/*
	Validate whether suggested social groups showing.
	*/
	@Test(priority = 42,groups = {"Regression","Smoke"})
	public void To_Validate_whether_suggested_social_groups_showing () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.openJoinSocialGroup();
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		wait = new  WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(socialgrouppage.Element_of_bchat()));
		for(int i =0; i<5 ; i++) {
		Assert.assertTrue(socialgrouppage.get_Element_of_Groups().get(i).isDisplayed());
		}		
		}

	/*
	Validate next option in the Join Social group by entering a Invalid URL.
	*/
	@Test(priority = 43,groups = {"Regression"})
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
	Validate whether able to join the groups shown in suggestion.
	*/
	@Test(priority = 44,groups = {"Regression","Smoke"})
	public void To_Validate_whether_able_to_join_the_groups_shown_in_suggestion () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.join_Beldex_Group();
		chatpage = new ChatPage(driver);
		try{
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Beldex");
		}
		catch (NoSuchElementException e) {
			socialgrouppage.join_Beldex_Group();
			Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Beldex");
		}
		chatpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.openJoinSocialGroup();
	}
	
	/*
	Validate the next option without entering values in url 
	*/
	@Test(priority = 45,groups = {"Regression"})
	public void To_Validate_the_next_option_without_entering_values_in_url () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Next();
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
	}
	
	/*
	Validate the presence of placeholder inside the text box 
	*/
	@Test(priority = 46,groups = {"Regression"})
	public void To_Validate_the_presence_of_placeholder_inside_the_textbox () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		Assert.assertEquals(socialgrouppage.get_Placeholder_Value(), "Enter a social group URL");
	}
	
	
	/*
	Validate the next option in the join social group with empty space value
	*/
	@Test(priority = 47,groups = {"Regression"})
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
		catch (AssertionError e) {
			e.printStackTrace();
			Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		}
		socialgrouppage.clear_textBox();
	}
		
	
	/*
	Validate the text box of the join social Group using special Characters. 
	*/
	@Test(priority = 48,groups = {"Regression"})
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
	catch (AssertionError e) {
		e.printStackTrace();
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
	}
		socialgrouppage.clear_textBox();
	}
	
	/*
	 Validate Whether value entered inside textbox is editable.
	 */
	@Test(priority = 49,groups = {"Regression"})
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
	 Validate Whether able to paste values in text box.
	 */
	@Test(priority = 50,groups = {"Regression"})
	public void To_Validate_Whether_able_to_paste_values_in_textbox () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.paste_Values("Paste values");
		Assert.assertEquals(socialgrouppage.get_Values_From_textbox(), "Paste values");
		socialgrouppage.clear_textBox();
	
	}
	
	//
	/*
	Validate the text box of the join social Group using numerical values..
	*/
	@Test(priority = 51,groups = {"Regression"})
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
		catch (AssertionError e) {
			e.printStackTrace();
			Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		}
		
		socialgrouppage.clear_textBox();
	}
	
	
	/*
	Validate the text box of the join social Group using Alphabets both in uppercase and lower case. 
	*/
	@Test(priority = 52,groups = {"Regression"})
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
		catch (AssertionError e) {
			e.printStackTrace();
			Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
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
	Validate next option in the Join Social group by entering a valid URL. 
	*/
	@Test(priority = 53,groups = {"Regression","Smoke"})
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
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.openJoinSocialGroup();
	}
	catch (AssertionError e) {
		Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"BChat");
		chatpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"Chats");
		homepage.openJoinSocialGroup();
	}
	
	
	}
	
	/*
	Validate whether able to join social group without internet connection.
	*/
	@Test(priority = 54,groups = {"Regression"})
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
		catch (AssertionError e) {
			Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		}
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
 
     }
	
	
	/*
	validate whether cursor blinks while clicking the textbox  
	*/
	@Test(priority = 55,groups = {"Regression"})
	public void To_validate_whether_cursor_blinks_while_clicking_the_textbox () {
		socialgrouppage = new SocialGroupPage(driver);
		Assert.assertEquals(socialgrouppage.Pagetitle(), "Social Group");
		socialgrouppage.click_Url_Textbox();
		Assert.assertTrue(socialgrouppage.activeElement().isDisplayed());
		try{
			socialgrouppage.click_Back_Arrow();
			homepage = new  HomePage(driver);
		   Assert.assertEquals(homepage.Pagetitle(), "Chats");
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
		}	
	}	
}
