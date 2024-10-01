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
import POM.NotificationPage;
import POM.ReceivePage;
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Receive_Screen_And_Its_Functionalities extends baseClass {

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
	NotificationPage notificationpage;
	MyWalletPage mywalletpage;
	ReceivePage receivepage;
	
	/*
	 Pre Setup
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
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_CheckBox();
		mywalletpage.click_Enable_Wallet();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpasswordpage.setValidPassword();
		Thread.sleep(1000);
		createpasswordpage.clickOk();
	}
	
	
	/*
	Validate whether able to copy the wallet Address.
	*/
	@Test(priority = 1)
	public void To_Validate_whether_able_to_copy_the_wallet_Address () throws InterruptedException {
		
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Recive_option();
		
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.click_copyIcon_In_receiveScreen();
		Assert.assertEquals(Toast(),"Copied to clip board");
	}
	
	/*
	 Validate the working of the share button
	 */
	@Test(priority = 2)
	public void To_Validate_the_working_of_share_button () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.click_share();
		Assert.assertEquals(receivepage.Share_Screen_Title(), "1 image in total");
		receivepage.click_Cancel();
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
	}
	
	/*
	Validate the amount text box with valid amount value.
	*/
	@Test(priority = 3)
	public void To_Validate_the_amount_textbox_with_valid_amount_value () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.Enter_Value_In_Amount_textBox("10");
		try {
		Assert.assertNotEquals(receivepage.get_ErrorMsg(), "Enter a valid amount");
		}
		catch (NoSuchElementException e) {
			receivepage.clear_TextBox();
		}
	}
	
	
	/*
	validate the amount text box with Invalid amount value.
	*/
	@Test(priority = 4)
	public void To_validate_the_amount_text_box_with_Invalid_amount_value () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.Enter_Value_In_Amount_textBox("0.0000");
		Assert.assertEquals(receivepage.get_ErrorMsg(), "Enter a valid amount");
		receivepage.clear_TextBox();
	}
	
	
	/*
	validate whether able to paste numerical value in the amount text box
	*/
	@Test(priority = 5)
	public void To_validate_whether_able_to_paste_numerical_value_in_amount_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.paste_values("100");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"100" );
		receivepage.clear_TextBox();
	}
	
	/*
	validate whether able to paste characters value in the amount text box
	*/
	@Test(priority = 6)
	public void To_validate_whether_able_to_paste_characters_value_in_amount_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.paste_values("abced");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"" );	
	}
	
	/*
	validate whether cursor blinks on clicking the text box
	*/
	@Test(priority = 7)
	public void To_validate_whether_cursor_blinks_on_clicking_the_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.click_textbox();
		Assert.assertTrue(receivepage.activeElement().isDisplayed());
	}
	
	/*
	Validate whether allowing to enter Special characters and multiple dots
	*/
	@Test(priority = 8)
	public void To_Validate_whether_allowing_to_enter_Special_characters_and_multiple_dots () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.paste_values(",-");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"" );	
		receivepage.paste_values("0.10.");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"" );	
	}
	
	
	/*
	validate the presence of place holder
	*/
	@Test(priority = 9)
	public void To_validate_the_presence_of_place_holder () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		Assert.assertEquals(receivepage.get_Placholder(), "0.0000");
	}
	
	/*
	Validate whether able to enter values above boundary limit
	*/
	@Test(priority = 10)
	public void To_Validate_whether_able_to_enter_values_above_boundary_limit () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.Enter_Value_In_Amount_textBox("12345678901234567");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"" );	
		receivepage.Enter_Value_In_Amount_textBox("1234567890123456");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"1234567890123456" );	
	}
}
