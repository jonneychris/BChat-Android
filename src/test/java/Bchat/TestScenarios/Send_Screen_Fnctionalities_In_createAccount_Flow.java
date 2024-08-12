package Bchat.TestScenarios;

import java.time.Duration;

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
import POM.SendPage;
import POM.SocialGroupPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class Send_Screen_Fnctionalities_In_createAccount_Flow  extends baseClass {

	
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
	SendPage sendPage;
	WalletSettingsPage walletsettingspage; 
	
	/*
	 pre Setup
	 */
	@Test(priority = 0)
	public void PreSetup () throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofMinutes(5));
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
		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
		mywalletpage.click_Send_option();
		
	}
	
	
//	/*
//	 validate whether able to navigate out of the Send screen
//	 */
//	@Test(priority = 1)
//	public void To_validate_whether_able_to_navigate_out_of_the_Send_screen () {
//		sendPage = new SendPage(driver);
//		Assert.assertEquals(sendPage.pagetitle(),"Send");
//		sendPage.click_BackArrow();
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(),"My Wallet");
//		mywalletpage.click_Send_option();
//	
//	}
//	
//	
//	/*
//	 validate the working of the scan option
//	 */
//	@Test(priority = 2)
//	public void To_validate_the_working_of_the_scan_option () {
//		sendPage = new SendPage(driver);
//		Assert.assertEquals(sendPage.pagetitle(),"Send");
//		sendPage.click_scanner();
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.Scan_Page_Title(),"Scan");
//		mywalletpage.Click_Back_Arrow();
//		Assert.assertEquals(sendPage.pagetitle(), "Send");
//	}
//	
//	/*
//	 validate the working of the address book option
//	 */
//	@Test(priority = 3)
//	public void To_validate_the_working_of_AddressBook_option () {
//		sendPage = new SendPage(driver);
//		Assert.assertEquals(sendPage.pagetitle(),"Send");
//		sendPage.click_AddressBook();
//		walletsettingspage = new WalletSettingsPage(driver);
//		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(),"Address Book");
//		walletsettingspage.click_Back_Arrow();
//		Assert.assertEquals(sendPage.pagetitle(), "Send");
//	}
//	
//	
//	/*
//	 validate the working of the send function without values in both address and amount
//	 */
//	@Test(priority = 4)
//	public void To_validate_the_working_of_send_function_without_values_in_both_address_and_amount () {
//		sendPage = new SendPage(driver);
//		Assert.assertEquals(sendPage.pagetitle(),"Send");
//		sendPage.click_send();
//		Assert.assertEquals(sendPage.pagetitle(), "Send");
//	}
	
	
	/*
	 validate the presence of placeholder
	 */
	@Test(priority = 5)
	public void To_validate_the_presence_of_placeholder () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		Assert.assertEquals(sendPage.get_Amount_placeholder(),"0.0000");
		Assert.assertEquals(sendPage.get_Address_Placeholder(),"Enter Address");
		
	}
	
	
	/*
	 validate the cursor blinks on clicking the text box
	 */
	@Test(priority = 6)
	public void  To_Validate_the_cursor_blinks_on_Clicking_the_textbox () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.click_Amount_textbox();
		Assert.assertTrue(sendPage.activeElement().isDisplayed());
		sendPage.click_Address_textbox();
		Assert.assertTrue(sendPage.activeElement().isDisplayed());
	}
	/*
	 validate the working of the dropdown in transaction priority
	 */
	@Test(priority = 7)
	public void To_validate_the_working_of_the_dropdown_in_transaction_priority () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.Set_Slow_inPriority();
		Assert.assertEquals(sendPage.get_priority_value(), "Slow");
	
		sendPage.Set_Flash_InPriority();
		Assert.assertEquals(sendPage.get_priority_value(), "Flash");
	
	
	}
	
	/*
	 Validate the Estimated Fee In Slow and Flash
	 */
	@Test(priority = 8)
	public void To_Validate_the_estimated_fee_in_Slow_And_in_flash () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.Set_Slow_inPriority();
		Assert.assertEquals(sendPage.get_Estimated_Fee(), "0.013532 BDX");
		sendPage.Set_Flash_InPriority();
		Assert.assertEquals(sendPage.get_Estimated_Fee(), "0.040596 BDX");
	}
	
	/*
	 validate the working of the send function with value amount and without value in address
	 */
	@Test(priority = 9)
	public void To_validate_the_working_of_send_function_with_value_amount_and_without_value_in_address () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.Enter_Values_In_Amount("10");
		sendPage.click_send();
		Assert.assertEquals(sendPage.pagetitle(), "Send"); 	
	}
	
	
	
	
}
