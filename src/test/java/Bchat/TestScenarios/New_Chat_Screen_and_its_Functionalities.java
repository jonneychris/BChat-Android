package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyAccountPage;
import POM.NewChatPage;
import POM.OneToOneChatPage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class New_Chat_Screen_and_its_Functionalities extends baseClass{

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	NewChatPage newchatpage;
	MyAccountPage myaccountpage;
	OneToOneChatPage onetoonechatpage;
	WebDriverWait wait;
	
	/*
	 preSetup to new chat screen
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
		Thread.sleep(1000);
		registerpage.clickNext();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(1000);
		createpasswordpage.clickOk();
		recoveryphrasepage =new RecoveryPhrasePage(driver);
		Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Seed");
		recoveryphrasepage.clickCopyIcon();
		recoveryphrasepage.ClickContinue();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
	}
	
//	/*
//	 Validate whether able to navigate back to the home screen
//	 */
//	@Test(priority = 1)
//	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
//	   newchatpage = new NewChatPage(driver);
//	   Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//	   newchatpage.click_Back_Arrow();
//	   homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.OpenNewChat();
//	
//	}
//	
//	
//	/*
//	Validate the working of your bchat id option
//	*/
//	@Test(priority = 2)
//	public void To_Validate_the_working_of_your_bchatId_option () {
//		   newchatpage = new NewChatPage(driver);
//		   Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
//		   newchatpage.click_Your_BchatId();
//		   myaccountpage = new MyAccountPage(driver);
//		   Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
//	}
//	
//	
//	/*
//	validate whether able to copy BChat id and beldex address 
//	*/
//	@Test(priority = 3)
//	public void To_validate_whether_able_to_copy_BChatId_and_beldexAddress () {
//		  	
//			myaccountpage =new  MyAccountPage(driver);
//			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
//		  try {
//		      myaccountpage.click("BchatId");
//			  Assert.assertEquals(Toast(), "Copied to clip board");	  
//		  }
//		  catch (StaleElementReferenceException e) {
//			  myaccountpage.click("BchatId");
//			  Assert.assertEquals(Toast(), "Copied to clip board");	
//		}
//		  catch (NoSuchElementException e) {
//			  myaccountpage.click("BchatId");
//			  Assert.assertEquals(Toast(), "Copied to clip board");	
//		}
//		  try {
//		  myaccountpage.click("BeldexAddress");
//			  Assert.assertEquals(Toast(), "Copied to clip board");
//		  }
//		  catch (StaleElementReferenceException e) {
//			  myaccountpage.click("BeldexAddress");
//			  Assert.assertEquals(Toast(), "Copied to clip board");
//		}
//		  catch (NoSuchElementException e) {
//			  myaccountpage.click("BeldexAddress");
//			  Assert.assertEquals(Toast(), "Copied to clip board");
//		}
//	}
//	
//	/*
//	Validate the working of the share button QR code Functionality.
//    */
//	@Test(priority =4)
//	public void To_Validate_Working_of_Share_Button () {
//		myaccountpage =new  MyAccountPage(driver);
//		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
//		  myaccountpage.scroll_the_page(450, 1400, 100, "down");
//		  myaccountpage.ClickshareButton();
//		  Assert.assertTrue(myaccountpage.shareScreenTitle().equals("1 image in total"));
//		  myaccountpage.clickcancel_In_share_Screen();
//		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
//		  myaccountpage.clickBackArrow();
//	}
	
	/*
	Validate Whether next button is enable without enter a value in the Enter BChat ID field.
	*/
	@Test(priority = 5)
	public void To_Validate_Whether_next_button_is_enable_without_enter_a_value_in_BChatID_field () {
		 newchatpage = new NewChatPage(driver);
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 newchatpage.click_Lets_Bchat();
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	
	
	}
	
	/*
	Validate the New Chat by entering a Invalid BChat ID.
	*/
	@Test(priority = 6)
	public void To_Validate_the_NewChat_by_entering_a_Invalid_BChat_ID () {
		newchatpage = new NewChatPage(driver);
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 
		 try {
			 newchatpage.Check_with_Invalid();
			 wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			 wait.until(ExpectedConditions.visibilityOf(newchatpage.Element_of_NewChat_screen()));
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }
		 catch (NoSuchElementException e) {
				
					 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
				 }		
		
		 catch (TimeoutException e) {
			 if(newchatpage.Element_of_Loader().isDisplayed()) {
				 driver.terminateApp("io.beldex.bchat");
				 try {
					 landingpage.openApp();
					 Assert.assertEquals(homepage.Pagetitle(),"BChat");
						homepage.OpenNewChat();
			 }
			 catch (NoSuchElementException e1) {
				 createpasswordpage = new CreatePasswordPage(driver);
				 createpasswordpage.setPassword_1();
				 Assert.assertEquals(homepage.Pagetitle(),"BChat");
					homepage.OpenNewChat();	 
			}	 
			 }
			 else {
				 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
			 }	
		}
		
		 newchatpage.clear_textBox();
	}
	
	
	/*
	validate the new chat with invalid bns name
	*/
	@Test(priority = 7)
	public void To_validate_the_new_chat_with_invalid_bns_name () {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 try {
			 newchatpage.Enter_BNS_Name("invalidBns.bdx");
			 newchatpage.click_Lets_Bchat();
			 wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			 wait.until(ExpectedConditions.visibilityOf(newchatpage.Element_of_NewChat_screen()));
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }
		 catch (NoSuchElementException e) {
				
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }		

 catch (TimeoutException e) {
	 if(newchatpage.Element_of_Loader().isDisplayed()) {
		 driver.terminateApp("io.beldex.bchat");
		 try {
			 landingpage.openApp();
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
				homepage.OpenNewChat();
	 }
	 catch (NoSuchElementException e1) {
		 createpasswordpage = new CreatePasswordPage(driver);
		 createpasswordpage.setPassword_1();
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.OpenNewChat();	 
	}	 
	 }
	 else {
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	 }	
}
		
	
		 newchatpage.clear_textBox(); 
	}
	
	/*
	validate the new chat without entering .bdx in bns name
	*/
	@Test(priority = 8)
	public void To_validate_the_new_chat_without_entering_bdx_in_bns_name (){
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 try {
			 newchatpage.Enter_BNS_Name("test");
			 newchatpage.click_Lets_Bchat();
			 wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			 wait.until(ExpectedConditions.visibilityOf(newchatpage.Element_of_NewChat_screen()));
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }
		 catch (NoSuchElementException e) {
				
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }		

 catch (TimeoutException e) {
	 if(newchatpage.Element_of_Loader().isDisplayed()) {
		 driver.terminateApp("io.beldex.bchat");
		 try {
			 landingpage.openApp();
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
				homepage.OpenNewChat();
	 }
	 catch (NoSuchElementException e1) {
		 createpasswordpage = new CreatePasswordPage(driver);
		 createpasswordpage.setPassword_1();
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.OpenNewChat();	 
	}	 
	 }
	 else {
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	 }	
}
		 newchatpage.clear_textBox();
	}
	
	/*
	validate the new chat with empty space value
	*/
	@Test(priority = 9)
	public void To_validate_the_new_chat_with_empty_space_value () {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 try {
			 newchatpage.Enter_BNS_Name(" ");
			 newchatpage.click_Lets_Bchat();
			 wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			 wait.until(ExpectedConditions.visibilityOf(newchatpage.Element_of_NewChat_screen()));
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }
		 catch (NoSuchElementException e) {
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }
		 catch (TimeoutException e) {
			 if(newchatpage.Element_of_Loader().isDisplayed()) {
				 driver.terminateApp("io.beldex.bchat");
				 try {
					 landingpage.openApp();
					 Assert.assertEquals(homepage.Pagetitle(),"BChat");
						homepage.OpenNewChat();
			 }
			 catch (NoSuchElementException e1) {
				 createpasswordpage = new CreatePasswordPage(driver);
				 createpasswordpage.setPassword_1();
				 Assert.assertEquals(homepage.Pagetitle(),"BChat");
					homepage.OpenNewChat();	 
			}	 
			 }
			 else {
				 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
			 }	
		}
		 newchatpage.clear_textBox();
		 
			 }
		 
			
	/*
	validate the new chat with special characters
	*/
	@Test(priority = 10)
	public void To_validate_the_new_chat_with_special_characters () {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 try {
			 newchatpage.Enter_BNS_Name("@#$%.bdx");
			 newchatpage.click_Lets_Bchat();
			 wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			 wait.until(ExpectedConditions.visibilityOf(newchatpage.Element_of_NewChat_screen()));
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }
		 catch (NoSuchElementException e) {
				
			 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		 }		

 catch (TimeoutException e) {
	 if(newchatpage.Element_of_Loader().isDisplayed()) {
		 driver.terminateApp("io.beldex.bchat");
		 try {
			 landingpage.openApp();
			 Assert.assertEquals(homepage.Pagetitle(),"BChat");
				homepage.OpenNewChat();
	 }
	 catch (NoSuchElementException e1) {
		 createpasswordpage = new CreatePasswordPage(driver);
		 createpasswordpage.setPassword_1();
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.OpenNewChat();	 
	}	 
	 }
	 else {
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	 }	
}
		 newchatpage.clear_textBox();
	}

	/*
	validate the new chat function without internet connection
	*/
	@Test(priority = 11)
	public void To_validate_the_new_chat_function_without_internet_connection () throws InterruptedException {
		
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		
		newchatpage.Enter_BNS_Name("Snowman.bdx");
		try {
		newchatpage.click_Lets_Bchat();
		Assert.assertEquals(Toast(),"Please check your internet connection");
		}
		catch (NoSuchElementException e) {
			newchatpage.click_Lets_Bchat();
			Assert.assertEquals(Toast(),"Please check your internet connection");
		}
		catch (StaleElementReferenceException e) {
			newchatpage.click_Lets_Bchat();
			Assert.assertEquals(Toast(),"Please check your internet connection");
		}
		newchatpage.clear_textBox();
		newchatpage.Paste_Values_In_textBox("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		try {
			newchatpage.click_Lets_Bchat();
			Assert.assertEquals(Toast(),"Please check your internet connection");
			}
			catch (NoSuchElementException e) {
				newchatpage.click_Lets_Bchat();
				Assert.assertEquals(Toast(),"Please check your internet connection");
			}
			catch (StaleElementReferenceException e) {
				newchatpage.click_Lets_Bchat();
				Assert.assertEquals(Toast(),"Please check your internet connection");
			}
			turnOn_Mobile_Wifi();
			newchatpage.clear_textBox();
			Thread.sleep(5000);
		}
	
	/*
	validate whether able to paste values in the text box
	*/
	@Test(priority = 12)
	public void To_validate_whether_able_to_paste_values_in_text_box () throws InterruptedException {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		newchatpage.Paste_Values_In_textBox("snowman.bdx");
		Assert.assertEquals(newchatpage.get_Values_from_TextBox(), "snowman.bdx");
		newchatpage.clear_textBox();
		newchatpage.Paste_Values_In_textBox("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		Assert.assertEquals(newchatpage.get_Values_from_TextBox(),"bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		newchatpage.clear_textBox();
	
	}

	/*
	Validate the New Chat by entering a valid BChat ID.
	*/
	@Test(priority = 13)
	public void To_Validate_the_New_Chat_by_entering_a_valid_BChat_ID () throws InterruptedException {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		newchatpage.Enter_BNS_Name("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		newchatpage.click_Lets_Bchat();
		onetoonechatpage = new OneToOneChatPage(driver);
		try {
		Assert.assertEquals(onetoonechatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		}
		catch (NoSuchElementException e) {
			
			Assert.assertEquals(onetoonechatpage.get_profile_NameOr_Id(),"Bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");	
		}
		onetoonechatpage.click_Back_Arrow();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	}
	
	/*
	validate the new chat with valid bns name
	*/
	@Test(priority = 14)
	public void To_validate_the_new_chat_with_valid_bns_name () throws InterruptedException {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		try {
			newchatpage.Enter_BNS_Name("snowman.bdx");
			newchatpage.click_Lets_Bchat();
			onetoonechatpage = new OneToOneChatPage(driver);
			wait = new  WebDriverWait(driver, Duration.ofMinutes(2));
			wait.until(ExpectedConditions.invisibilityOf(newchatpage.Element_of_Loader()));
			Assert.assertEquals(onetoonechatpage.get_profile_NameOr_Id(),"Snowman.bdx");
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(onetoonechatpage.get_profile_NameOr_Id(),"Snowman.bdx"); 
		}
		catch (TimeoutException e) {
			
			Assert.assertEquals(onetoonechatpage.get_profile_NameOr_Id(),"Snowman.bdx"); 
			
		}
		onetoonechatpage.click_Back_Arrow();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
	}
	
	
	


	/*
	Validate the working of upload from gallery option with valid Qr code image       
	*/
	@Test(priority = 15)
	public void To_Validate_the_working_of_upload_from_gallery_option_with_valid_Qr_code_image () {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		newchatpage.Upload_valid_Qr_code();
		onetoonechatpage = new OneToOneChatPage(driver);
		Assert.assertEquals(onetoonechatpage.get_profile_NameOr_Id(),"Bde017476a81bbd8ff6dc58a59e0a70cd26b8b9e876217f2e3c4620116efe22038");
		onetoonechatpage.click_Back_Arrow();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.OpenNewChat();
		 Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");

		
	}
	
	/*
	validate the working of upload from gallery option with normal image 
	*/
	@Test(priority = 16)
	public void To_validate_the_working_of_upload_from_gallery_option_with_normal_image () {
		newchatpage = new NewChatPage(driver);
		Assert.assertEquals(newchatpage.Pagetitle(),"New Chat");
		newchatpage.Upload_image();
		try {
		Assert.assertEquals(Toast(),"Unable to recognized a valid code from uploaded image");
		}
		catch (NoSuchElementException e) {
			//Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
		}
		catch (StaleElementReferenceException e) {
			//Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
		}
	}	
	
	/*
	Validate the working of upload from gallery option with invalid Qr code image
	*/
	@Test(priority = 17)
	public void To_Validate_the_working_of_upload_from_gallery_option_with_invalid_Qr_code_image ()	{
		newchatpage = new NewChatPage(driver);
	//	Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
		
		try{
			newchatpage.Upload_Invalid_Qr_Code();
			wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.invisibilityOf(newchatpage.imageLoader()));
			Assert.assertEquals(Toast(),"An error occurred.");
		}
		catch (NoSuchElementException e) {
		//	Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
		}
		catch (StaleElementReferenceException e) {
	//		Assert.assertEquals(newchatpage.scan_Qr_Screen_title(),"Scan QR");
		}
		catch (TimeoutException e) {
			 if(newchatpage.imageLoader().isDisplayed()) {
				 driver.terminateApp("io.beldex.bchat");
			 }
		}	
	}
		 
	
	
	
	
	
}
