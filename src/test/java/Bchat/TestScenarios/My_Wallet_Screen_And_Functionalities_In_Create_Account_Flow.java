package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

public class My_Wallet_Screen_And_Functionalities_In_Create_Account_Flow extends baseClass {

	
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
	ReceivePage receivepage;
	
	
	/*
	 Pre Setup to wallet enable
	 */
	@Test(priority = 0,groups ={"Regression","Smoke"})
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
		
	}
	
	
	/*
	 Validate whether able to navigate back  from wallet enable screen
	*/
	@Test (priority = 1,groups ={"Regression"})
	public void To_Validate_whether_able_to_navigate_back_from_wallet_enable_screen () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
		mywalletpage.Click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
	
	}
	
	
	/*
    Validate the working of enable wallet button without clicking the check box
	*/
	@Test(priority = 2,groups ={"Regression"})
	public void To_Validate_the_working_of_enable_wallet_button_without_clicking_the_check_box () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
		mywalletpage.click_Enable_Wallet();
		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
		//Assert.assertFalse(mywalletpage.Element_Of_Enable_wallet_button().isEnabled());
	}
	
	
	/*
    validate the working of the yes, i understand check box
	*/
	@Test(priority = 3,groups ={"Regression","Smoke"})
	public void To_validate_the_Working_of_the_yes_i_understand_check_box () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
		mywalletpage.click_CheckBox();
		Assert.assertTrue(mywalletpage.Element_Of_Enable_wallet_button().isEnabled());
		
	}
	
	
	/*
    Validate the working of the Enable wallet button
	 */
	@Test(priority = 4,groups ={"Regression","Smoke"})
	public void To_Validate_the_working_of_Enable_wallet_Button () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
		mywalletpage.click_Enable_Wallet();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
	}
	
	
	/*
	 Validate whether able to navigate to the re-enter pin field without entering a value in create pin field.
	*/
	@Test(priority = 6,groups ={"Regression"})
	public void To_Validate_whether_able_to_navigate_to_ReEnter_pin_field_without_entering_a_value_in_create_pin_field () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.clickNext();
		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
	}
	
	/*
	 Validate the Wallet password functionality by entering a valid value in Create pin and invaid value in Re-Enter pin.
	 */
	@Test(priority = 7,groups ={"Regression","Smoke"})
	public void To_Validate_Wallet_password_functionality_by_entering_valid_value_in_Create_pin_and_invaid_Value_in_ReEnter_pin () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		try {
		createpasswordpage.setInValidPassword();
		Assert.assertEquals(Toast(), "Both PINs should be same.");
		}
		catch (StaleElementReferenceException e) {
			try{
				createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Both PINs should be same.");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
			}
			
		}
		catch (NoSuchElementException e) {
			try{
				createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Both PINs should be same.");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
			}
		}
		catch (AssertionError e) {
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(Toast(), "Both PINs should be same.");
		}
		
	}
	
	
	
	/*
    Validate whether able to navigate to the next screen without entering a value in Re-Enter pin field.
	 */
	@Test(priority = 7,groups ={"Regression","Smoke"})
	public void To_Validate_whether_able_to_navigate_to_next_screen_without_entering_a_value_in_ReEnter_pin_field () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
		
	}
	
	
	
	/*
    Validate the Wallet password functionality by entering a valid Create pin and valid Re-Enter pin.
	*/
	@Test(priority = 8,groups ={"Regression","Smoke"})
    public void To_Validate_the_Wallet_password_functionality_by_entering_a_valid_Create_pin_and_valid_ReEnter_pin (){
	
		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		createpasswordpage.clickOk();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(),"My Wallet");
	    mywalletpage.Click_Back_Arrow();
	
	}
	
	/*
	Validate whether able to navigate out from verify pin screen.
	*/
	@Test(priority = 9,groups ={"Regression"})
	public void To_Validate_whether_able_to_navigate_out_from_VerifyPin_screen () throws InterruptedException {
		
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		mywalletpage.Click_Back_Arrow();
		
		
	}
	
	/*
	Validate the Wallet password functionality by entering a Incorrect pin.
	*/
	@Test(priority = 10,groups ={"Regression","Smoke"} )
	public void To_Validate_the_Wallet_password_functionality_by_entering_a_Incorrect_pin () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		try{
			createpasswordpage.setPassword_1();
			Assert.assertEquals(Toast(),"Incorrect PIN.");
		}
		catch (StaleElementReferenceException e) {
			try{createpasswordpage.setPassword_1();
			Assert.assertEquals(Toast(),"Incorrect PIN.");
			}
		  catch (Exception e1) {
			  Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		}
		}
		catch (NoSuchElementException e) {
			try{createpasswordpage.setPassword_1();
			Assert.assertEquals(Toast(),"Incorrect PIN.");
			}
		  catch (Exception e1) {
			  Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		}	
		}
		catch (AssertionError e) {
			try{createpasswordpage.setPassword_1();
			Assert.assertEquals(Toast(),"Incorrect PIN.");
			}
		  catch (Exception e1) {
			  Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		}
		}
		
	}
	
	
	/*
	Validate the Wallet password functionality by entering a valid pin.
	*/
	@Test(priority = 11,groups ={"Regression","Smoke"})
	public void To_Validate_the_Wallet_pin_functionality_by_entering_a_valid_pin () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_0();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	}
	
	/*
	Validate whether able to navigate out of the My Wallet
	*/
	@Test(priority = 12,groups ={"Regression"})
	public void To_Validate_whether_able_to_navigate_out_of_the_My_Wallet () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.Click_Back_Arrow();
		
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_0();
		
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	}
	
	/*
	Validate the Transaction history when empty
	*/
	@Test(priority = 13,groups ={"Regression","Smoke"})
	public void To_Validate_the_Transaction_history_when_empty () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		wait = new WebDriverWait(driver,Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));	
		Assert.assertEquals(mywalletpage.Transaction_History_empty_screen(), "No Transactions yet!");
	}
	
	/*
	 Validate the working of the Transaction filter when transaction is empty
	 */
	@Test (priority = 14,groups ={"Regression"})
	public void To_Validate_the_working_of_Transaction_filter_when_transaction_is_empty () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Transaction_Filter();
		
		try {
			Assert.assertFalse(mywalletpage.Transaction_Filter_Enabled().isDisplayed());
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(mywalletpage.Transaction_History_empty_screen(),"No Transactions yet!");
		}
	}
		
	
	/*
	Validate the working of the all possible navigation from the my wallet screen in both forward and backward direction.
	*/
	@Test(priority = 15,groups ={"Regression"})
	public void To_Validate_working_of_all_possible_navigation_from_my_wallet_screen_in_both_forward_and_backward_direction () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Scan_option();
		Assert.assertEquals(mywalletpage.Scan_Page_Title(), "Scan");
		mywalletpage.Click_Back_Arrow();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		mywalletpage.click_Send_option();
		
		Assert.assertEquals(mywalletpage.Send_Page_Title(), "Send");
		mywalletpage.Click_Back_Arrow();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		mywalletpage.click_Recive_option();
		
		Assert.assertEquals(mywalletpage.Receive_Page_Title(), "Receive");
		mywalletpage.Click_Back_Arrow();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		mywalletpage.click_Sync_option();
		//Assert.assertEquals(mywalletpage.SyncOption_Page_Title(),"");
		driver.navigate().back();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		mywalletpage.click_WalletSettings_Option();
		//Assert.assertEquals(false, null);
		mywalletpage.Click_Back_Arrow();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");

	}
	
	/*
	Validate the working of the MyWallet functionality without internet connection
	*/
	@Test(priority = 16,groups ={"Regression"})
	public void To_Validate_the_working_of_MyWallet_functionality_without_internet_connection () throws InterruptedException {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		turnOff_Mobile_Wifi();
		mywalletpage.Click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		try{
			Assert.assertEquals(Toast(),"Please check your internet connection");
		}
		catch (NoSuchElementException e) {
			homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
		catch (StaleElementReferenceException e) {
			homepage = new HomePage(driver);
				Assert.assertEquals(homepage.Pagetitle(),"BChat");
			
		}
		turnOn_Mobile_Wifi();
         Thread.sleep(5000);
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		try {
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		}
		catch (NoSuchElementException e) {
			
			homepage.clickMenuDrawer();
		    menupage =new MenuPage(driver);
			Assert.assertEquals(menupage.pagetitle(),"Menu");
			menupage.click_option_Wallet();
			mywalletpage = new MyWalletPage(driver);
		}
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_0();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	}
	
	
	
	/*
	 * 
	 * 
	 * Send screen 
	 * 
	 */
	
	
	/*
	 validate whether able to navigate out of the Send screen
	 */
	@Test(priority = 17,groups ={"Regression"})
	public void To_validate_whether_able_to_navigate_out_of_the_Send_screen () {
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Send_option();
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.click_BackArrow();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(),"My Wallet");
		
	
	}
	
	
	/*
	 validate the working of the scan option
	 */
	@Test(priority = 18,groups ={"Regression","Smoke"})
	public void To_validate_the_working_of_the_scan_option () {
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(),"My Wallet");
		mywalletpage.click_Send_option();
			sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.click_scanner();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Scan_Page_Title(),"Scan");
		mywalletpage.Click_Back_Arrow();
		Assert.assertEquals(sendPage.pagetitle(), "Send");
	}
	
	/*
	 validate the working of the address book option
	 */
	@Test(priority = 19,groups ={"Regression","Smoke"})
	public void To_validate_the_working_of_AddressBook_option () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.click_AddressBook();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(),"Address Book");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(sendPage.pagetitle(), "Send");
	}
	
	
	/*
	 validate the working of the send function without values in both address and amount
	 */
	@Test(priority = 20,groups ={"Regression","Smoke"})
	public void To_validate_the_working_of_send_function_without_values_in_both_address_and_amount () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.click_send();
		Assert.assertEquals(sendPage.pagetitle(), "Send");
	}
	
	
	/*
	 validate the presence of placeholder
	 */
	@Test(priority = 21,groups ={"Regression"})
	public void To_validate_the_presence_of_placeholder () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		Assert.assertEquals(sendPage.get_Amount_placeholder(),"0.0000");
		Assert.assertEquals(sendPage.get_Address_Placeholder(),"Enter Address");
		
	}
	
	
	/*
	 validate the cursor blinks on clicking the text box
	 */
	@Test(priority = 22,groups ={"Regression"})
	public void  To_Validate_the_cursor_blinks_on_Clicking_the_textbox () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.click_Amount_textbox();
		Assert.assertTrue(sendPage.activeElement().isDisplayed());
		sendPage.click_Address_textbox();
		Assert.assertTrue(sendPage.activeElement().isDisplayed());
		driver.navigate().back();
	}
	
	/*
	 validate the working of the dropdown in transaction priority
	 */
	@Test(priority = 23,groups ={"Regression"})
	public void To_validate_the_working_of_the_dropdown_in_transaction_priority () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.Set_Slow_inPriority();
		Assert.assertEquals(sendPage.get_priority_value(), "Slow");
	
		sendPage.Set_Flash_InPriority();
		Assert.assertEquals(sendPage.get_priority_value(), "Flash");
	
	
	}
	
	/*
	 validate the working of the send function with value amount and without value in address
	 */
	@Test(priority = 24,groups ={"Regression"})
	public void To_validate_the_working_of_send_function_with_value_amount_and_without_value_in_address () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.Enter_Values_In_Amount("10");
		sendPage.click_send();
		Assert.assertEquals(sendPage.pagetitle(), "Send"); 	
	}
	
	
	/*
	 Validate the Estimated Fee In Slow and Flash
	 */
	@Test(priority = 25,groups ={"Regression","Smoke"})
	public void To_Validate_the_estimated_fee_in_Slow_And_in_flash () {
		sendPage = new SendPage(driver);
		Assert.assertEquals(sendPage.pagetitle(),"Send");
		sendPage.Set_Slow_inPriority();
		//Assert.assertEquals(sendPage.get_Estimated_Fee(), "0.013532 BDX");
		sendPage.Set_Flash_InPriority();
		//Assert.assertEquals(sendPage.get_Estimated_Fee(), "0.040596 BDX");
		sendPage.click_BackArrow();
	}
	
	
		
	/*
	 * 
	 * Receive Screen 
	 * 
	 * 
	 */
	
	
	/*
	Validate whether able to copy the wallet Address.
	*/
	@Test(priority = 26,groups ={"Regression","Smoke"})
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
	@Test(priority = 27,groups ={"Regression","Smoke"})
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
	@Test(priority = 28,groups ={"Regression","Smoke"})
	public void To_Validate_the_amount_textbox_with_valid_amount_value () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.Enter_Value_In_Amount_textBox("10");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"10");
		receivepage.clear_TextBox();			
	}
	
	
	/*
	validate whether able to paste numerical value in the amount text box
	*/
	@Test(priority = 29,groups ={"Regression"})
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
	@Test(priority = 30,groups ={"Regression"})
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
	@Test(priority = 31,groups ={"Regression"})
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
	@Test(priority = 32,groups ={"Regression"})
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
	@Test(priority = 33,groups ={"Regression"})
	public void To_validate_the_presence_of_place_holder () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		Assert.assertEquals(receivepage.get_Placholder(), "0.0000");
	}
	
	/*
	Validate whether able to enter values above boundary limit
	*/
	@Test(priority = 34,groups ={"Regression"})
	public void To_Validate_whether_able_to_enter_values_above_boundary_limit () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.Enter_Value_In_Amount_textBox("12345678901234567");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"" );	
		receivepage.Enter_Value_In_Amount_textBox("1234567890123456");
		Assert.assertEquals(receivepage.get_Values_From_Amount_textbox(),"1234567890123456" );	
		receivepage.clear_TextBox();
	}
		
	
	/*
	validate the amount text box with Invalid amount value.
	*/
	@Test(priority = 35,groups ={"Regression","Smoke"})
	public void To_validate_the_amount_text_box_with_Invalid_amount_value () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		receivepage = new  ReceivePage(driver);
		receivepage.Enter_Value_In_Amount_textBox("0.0000");
		Assert.assertEquals(receivepage.get_ErrorMsg(), "Enter a valid amount");
		receivepage.clear_TextBox();
		driver.navigate().back();
	}
	
	
	
	/*
	 * 
	 * Nodes screen and its functions
	 * 
	 * 
	 */
	
	/*
	 Validate the navigation into and out from node screen
	 */
	@Test(priority =36,groups ={"Regression"})
	public void To_Validate_the_navigation_into_and_out_from_node_screen () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_WalletSettings_Option();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Back_Arrow();
	}
	
	/*
	Validate whether able to switch to the available nodes.
	*/
	@Test(priority = 37,groups ={"Regression","Smoke"})
	public void To_Validate_whether_able_to_switch_to_available_nodes () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_WalletSettings_Option();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		String currentNode = walletsettingspage.get_Current_Node();
		
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	
		
		if (currentNode.equalsIgnoreCase("publicnode1.rpcnode.stream") ) {
			walletsettingspage.click_publicNode2();
			
		}
		else if (currentNode.equals("publicnode2.rpcnode.stream")) {
			walletsettingspage.click_publicNode3();
		}
		else if (currentNode.equals("publicnode3.rpcnode.stream")) {
			walletsettingspage.click_publicNode4();
		}
		else if (currentNode.equals("publicnode4.rpcnode.stream")) {
			walletsettingspage.click_publicNode5();
		}
		else if (currentNode.equals("publicnode5.rpcnode.stream")) {
			walletsettingspage.click_publicNode1();
		}
		walletsettingspage.click_Back_Arrow();
		try {
		Assert.assertNotEquals(walletsettingspage.get_Current_Node(), currentNode);
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		}
	}
	
	/*
	Validate whether selected node is displayed as current Node
	*/
	@Test(priority = 38,groups ={"Regression","Smoke"})
	public void To_Validate_whether_selected_node_is_displayed_as_current_Node () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_Public_Node(1);
		walletsettingspage.click_Yes_InPopup();
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_Current_Node(), "publicnode1.rpcnode.stream");
	}


	/*
	 Validate the working of Refresh Node
	 */
	@Test(priority = 39,groups ={"Regression","Smoke"})
	public void To_Validate_the_working_of_Refresh_Node () throws InterruptedException {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		String currentNode = walletsettingspage.get_Current_Node();
		walletsettingspage.click_Current_Node();
		walletsettingspage.click_Refresh_Node();
		walletsettingspage.click_Yes_InPopup();
		Thread.sleep(2000);
		walletsettingspage.click_Back_Arrow();
		try {
			Assert.assertNotEquals(walletsettingspage.get_Current_Node(), currentNode);
			}
			catch (NoSuchElementException e) {
				Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
			}
		
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
	}
	
	
	/*
	 Validate the working of the cancel button in all popup
	 */
	@Test(priority = 40,groups ={"Regression"})
	public void To_Validate_the_working_of_the_cancel_button_in_all_popup () {
		walletsettingspage = new WalletSettingsPage(driver);		
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_Public_Node(2);
		walletsettingspage.click_Cancel_InPopup();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	
		walletsettingspage.click_Refresh_Node();
		walletsettingspage.click_Cancel_InPopup();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		
		walletsettingspage.click_AddNode();
		walletsettingspage.click_Cancel_InAddNode();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	}

	
	/*
	Validate the working of the Test node without entering a value in both Node Address and Node port.
	*/
	@Test(priority = 41,groups ={"Regression"})
	public void To_Validate_the_working_of_Test_node_without_entering_value_in_both_Node_Address_and_Node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"we need this");
	}
	
	
	/*
	Validate the working of the test node with Invalid Node Address and Invalid Node port
	*/
	@Test(priority = 42,groups ={"Regression"})
	public void To_Validate_the_working_of_Add_node_with_Invalid_Node_Address_and_Invalid_Node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("test");
		walletsettingspage.Enter_NodePort("1234");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();
	}
	
	
	/*
	Validate the working of the Test node with entering a valid value in Node Address and without value in Node port.
	*/
	@Test(priority = 43,groups ={"Regression"})
	public void To_Validate_the_working_of_Test_node_with_entering_a_valid_value_in_Node_Address_and_without_value_in_Node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.clear_TextBoxes();
	}
	
	
	/*
	Validate the working of the Test node with Invalid Node Address and Valid Node port
	*/
	@Test(priority = 44,groups ={"Regression"})
	public void To_Validate_the_working_of_Test_node_with_Invalid_Node_Address_and_Valid_Node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("test.rpc.node1");
		walletsettingspage.Enter_NodePort("1234");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();
	}

	/*
	Validate the working of the Test node with valid Node Address and InValid Node port
	*/
	@Test(priority = 45,groups ={"Regression"})
	public void To_Validate_the_working_of_Test_node_with_valid_Node_Address_and_InValid_Node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("1234");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"CONNECTION ERROR");
		walletsettingspage.clear_TextBoxes();
	}

	/*
	Validate whether able to add Node without test.
	*/
	@Test(priority = 46,groups ={"Regression"})
	public void To_Validate_whether_able_to_add_Node_without_test () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.click_Add_InAddNode();
		Assert.assertNotEquals(walletsettingspage.Success_Msg(),"Success");
	  	walletsettingspage.clear_TextBoxes();
		
	
				
	}
	
	/*
	Validate whether able to Add node with entering a value in Node Name, username and password.
	*/
	@Test(priority = 47,groups ={"Regression"})
	public void To_Validate_whether_able_to_Add_Node_with_entering_value_in_NodeName_username_and_password () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.Enter_NodeName("publicNode1");
		walletsettingspage.Enter_Username("chris");
		walletsettingspage.Enter_Password("1111");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.click_Add_InAddNode();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	}
	
	/*
	Validate the working of the Test node with valid Node Address and Valid Node port
	*/
	@Test(priority = 48,groups ={"Regression","Smoke"})
	public void To_Validate_the_working_of_Test_node_with_valid_NodeAddress_and_Valid_NodePort () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.click_Add_InAddNode();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
	}

	/*
	Validate whether able to add node without Internet connection
	*/
	@Test(priority = 49,groups ={"Regression"})
	public void To_Validate_whether_able_to_Add_Node_without_Internet_connection () throws InterruptedException {
		
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		turnOff_Mobile_Wifi();
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.Enter_NodePort("29095");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"cannot resolve host");
		turnOn_Mobile_Wifi();
		Thread.sleep(5000);
		walletsettingspage.clear_TextBoxes();
	}
	
	/*
	 Validate Whether able to paste Characters values in node port
	 */
	@Test(priority = 50,groups ={"Regression"})
	public void To_Validate_Whether_able_to_paste_Characters_values_in_node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.paste_Values_In_NodePort();
		walletsettingspage.click_Test();
	//	Assert.assertEquals(walletsettingspage.Success_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();
		
	}
	
	
	/*
	 Validate whether able to paste values in the text box fields
	 */
	@Test(priority = 51,groups ={"Regression"})
	public void To_Validate_whether_able_to_paste_values_in_the_text_box_fields () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.paste_values_In_All_TextBox_Fields();
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.clear_TextBoxes();
		driver.navigate().back();
		walletsettingspage.click_Back_Arrow();
		
	}
	
	
	/*
	Validate the address book screen when empty
	*/
	@Test(priority = 52,groups ={"Regression","Smoke"})
	public void To_Validate_the_address_book_screen_when_empty () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Address Book");
		walletsettingspage.click_AddressBook();
		try{
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		}
		catch (NoSuchElementException e) {
			walletsettingspage.click_AddressBook();
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		}
		Assert.assertEquals(walletsettingspage.emptyAddressBook_screen(), "No Addresses!");
		walletsettingspage.click_Back_Arrow();
		walletsettingspage.click_Back_Arrow();
	}
	

	/*
	 * 
	 * Sync options
	 * 
	 * 
	 */
	
	
	/*
	Validate the working of the rescan option without Entering any value
	*/
	@Test(priority = 53,groups ={"Regression"})
	public void To_Validate_the_working_of_the_rescan_option_Without_Any_Value () {
		try{mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		}
		catch (NoSuchElementException e) {
		  mywalletpage.Click_Back_Arrow();	
		}
		mywalletpage.click_Sync_option();
		mywalletpage.click_Rescan_Option();
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.click_Btn_Rescan();
		Assert.assertEquals(Toast(), "Please enter a restore height or Select a restore date");
	}
	
	/*
	validate the working of rescan with more than current block height value
	*/
	@Test(priority = 54,groups ={"Regression"})
	public void To_validate_the_working_of_rescan_with_more_than_current_blockheight_value () throws InterruptedException {
		mywalletpage = new MyWalletPage(driver);
	
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.Enter_values_In_Blockheight_textbox("99999999");
		mywalletpage.click_Btn_Rescan();
		
		Assert.assertEquals(mywalletpage.get_Error_Msg(),"Enter a valid blockheight");
		mywalletpage.clear_blockheight_textbox();
		
		}
	
	/*
	validate presence of placeholder in the text boxes
	*/
	@Test(priority = 55,groups ={"Regression"})
	public void To_validate_presence_of_placeholder_in_textboxes () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		Assert.assertEquals(mywalletpage.get_placholder_value(), "Restore from BlockHeight");
	
	}
	

	/*
	Validate whether able to paste numerical value in blockheight text box
	*/
	@Test(priority = 56,groups ={"Regression"})
	public void To_Validate_whether_able_to_paste_numerical_value_in_blockheight_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.paste_Values("12345");
		Assert.assertEquals(mywalletpage.get_Values_From_Blockheight_textbox(), "12345");
		mywalletpage.clear_blockheight_textbox();
	}
	
	/*
	validate whether able to paste characters value in blockheight text box
	validate whether able to navigate out of resacn screen
	*/
	@Test(priority = 57,groups ={"Regression"})
	public void To_validate_whether_able_to_paste_characters_value_in_blockheight_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.paste_Values("abced");
		Assert.assertEquals(mywalletpage.get_Values_From_Blockheight_textbox(), "");
		driver.navigate().back();
		
	}

	/*
	Validate the working of the reconnect option
	*/
	@Test(priority = 58,groups ={"Regression","Smoke"})
	public void To_Validate_the_working_of_reconnect_option () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Sync_option();
		mywalletpage.click_Reconnect_option();
		Assert.assertEquals(mywalletpage.Status_Reconnecting(), "Reconnecting...");
		 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
			wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
		  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());
	}
	
	/*
	validate the working of rescan with restore from date
	*/
	@Test(priority = 59,groups ={"Regression","Smoke"})
	public void To_validate_the_working_of_rescan_with_restore_from_date () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Sync_option();
		mywalletpage.click_Rescan_Option();
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.click_To_Swicth_rescan_option();
		mywalletpage.rescan_From_date();
		Assert.assertEquals(mywalletpage.get_Status_Syncing(),"Wallet Syncing..");
		 try{
			 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
			wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
		  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());
		 }
		 catch (NoSuchElementException e) {
			 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
				wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
			  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());
		}
	}
	
	/*
	validate the working of rescan with valid blockheight
	*/
	@Test(priority = 60,groups ={"Regression","Smoke"})
	public void To_validate_the_working_of_rescan_with_valid_blockheight () {
		
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Sync_option();;
		mywalletpage.click_Rescan_Option();
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.Enter_values_In_Blockheight_textbox("3500000");
	   mywalletpage.click_Btn_Rescan();
		Assert.assertEquals(mywalletpage.get_Status_Syncing(),"Wallet Syncing..");
	 try{
		 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
	  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());
	 }
	 catch (NoSuchElementException e) {
		 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
			wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
		  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());
	}

	}
	
	
	
}
