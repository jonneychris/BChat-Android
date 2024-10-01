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
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class Wallet_Settings_Screen_And_Its_Functionalities extends baseClass{

	

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
	WalletSettingsPage walletsettingspage;
	
	/*
	presetup
	*/
	@Test(priority  =0)
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
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_CheckBox();
		mywalletpage.click_Enable_Wallet();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
    	createpasswordpage.setValidPassword();
    	createpasswordpage.clickOk();
	    Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	    mywalletpage.click_WalletSettings_Option();
	    walletsettingspage = new  WalletSettingsPage(driver);
		walletsettingspage.scrollgesture_Using_text("Change Pin");
	    
	}
	
	/*
	 Validate the working of cancel icon in all popup
	 */
	@Test(priority = 1)
	public void To_Validate_the_working_of_cancel_icon_in_all_popup () {
	
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_DisplayBalanceAs();
		//
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Decimals();
		//
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		//
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Fee_priority();
		//
		walletsettingspage.click_CancelIcon_In_Popup();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	
	
	/*
	Validate whether able to select all options in Display Balance As .
	*/
	@Test(priority = 2)
	public void To_Validate_whether_able_to_select_all_options_in_DisplayBalanceAs () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Full Balance");
		walletsettingspage.Select_All_Options_In_DisplayBalanceAs();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Hidden");
	}
	
	/*
	 Validate the working of the beldex hidden option in Display Balance As
	 */
	@Test(priority = 3)
	public void To_Validate_the_working_of_beldex_hidden_option_in_DisplayBalanceAs () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		try {
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Hidden");
		}
		catch (NoSuchElementException e) {
			walletsettingspage.click_DisplayBalanceAs();
			walletsettingspage.scrollAndClick_Using_text("Beldex Hidden");
		}
		walletsettingspage.click_Back_Arrow();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.get_Bdx_value(),"---");
		mywalletpage.click_WalletSettings_Option();
	}
	
	
	
	/*
	Validate whether able to select all options in Decimals.
	*/
	@Test(priority = 4)
	public void To_Validate_whether_able_to_select_all_options_in_Decimals () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Assert.assertEquals(walletsettingspage.get_Decimals_Value(), "2 - Two (0.00)");
		walletsettingspage.Select_All_options_InDecimals();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_Decimals_Value(), "0 - Zero (0)");
	}
	
	
	/*
	Validate whether able to select all options in the currency.
   	*/
	@Test(priority = 5)
	public void To_Validate_whether_able_to_select_all_options_in_currency () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_currency_Value(), "USD");
		walletsettingspage.Select_All_options_Currency();
		Assert.assertEquals( walletsettingspage.get_currency_Value(), "CNY");
		
		//walletsettingspage.scrollgesture_Using_text("HKD");
	}
	
	
	/*
	 Validate whether currency list is Scrollable
	 */
	@Test(priority = 6)
	public void To_Validate_whether_currency_list_is_Scrollable (){
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		try {
		walletsettingspage.scrollAndClick_Using_text("ZAR");
		}
		catch (NoSuchElementException e) {
			walletsettingspage.scrollAndClick_Using_text("ZAR");
		}
		Assert.assertEquals(walletsettingspage.get_currency_Value(), "ZAR");
	}
	
	/*
    validate the working of the search box with valid value
    */
	@Test (priority = 7)
	public void To_validate_the_working_of_search_box_with_valid_value (){
		
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Currency();
		walletsettingspage.Enter_values_In_Search_TextBox("INR");
		//
		Assert.assertTrue(walletsettingspage.Value_In_CurrencyPopup().isBlank());
		walletsettingspage.click_CancelIcon_In_Popup();
	}
    
	
	
	/*
	Validate the working of all options in Fee Priority.
	*/
	@Test(priority = 8)
	public void To_Validate_working_of_All_options_in_Fee_Priority () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_FeePriority_value(),"Flash");
		walletsettingspage.Select_All_options_FeePriority();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_FeePriority_value(),"Slow");
	}
	
	
	/*
	 Validate whether selected option is option is displayed in wallet Settings and My Wallet screen 
	 */
	@Test(priority = 9)
	public void To_Validate_whether_selected_option_is_displayed_in_wallet_Settings_and_My_Wallet_screen () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_DisplayBalanceAs();
		walletsettingspage.scrollAndClick_Using_text("Beldex Full Balance");
		
		walletsettingspage.click_Decimals();
		walletsettingspage.scrollAndClick_Using_text("3 - Three (0.000)");
		
		walletsettingspage.click_Currency();;
		try {
		walletsettingspage.scrollAndClick_Using_text("SGD");
		}
		catch (NoSuchElementException e) {
			walletsettingspage.scrollAndClick_Using_text("SGD");
		}
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Full Balance");
		Assert.assertEquals(walletsettingspage.get_Decimals_Value(), "3 - Three (0.000)");
		Assert.assertEquals(walletsettingspage.get_currency_Value(), "SGD");
	
		walletsettingspage.click_Back_Arrow();
		mywalletpage = new MyWalletPage(driver);
		
		Assert.assertEquals(mywalletpage.get_Bdx_value(),"0.000");
		Assert.assertEquals(mywalletpage.get_FiatCurrency_value(),"0.00 SGD");
		mywalletpage.click_WalletSettings_Option();
	}
	
	
	/*
	Validate the Navigation to the address book.
	*/
	@Test(priority = 10)
	public void To_Validate_the_Navigate_to_Address_book () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	
	/*
	Validate the address book screen when empty
	*/
	@Test(priority = 11)
	public void To_Validate_the_address_book_screen_when_empty () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		Assert.assertEquals(walletsettingspage.emptyAddressBook_screen(), "No Addresses!");
		walletsettingspage.click_Back_Arrow();
	}
	
	
	/*
	Validate the Change pin functionality by entering a valid old pin.
	*/
	 @Test(priority = 12)
	public void To_Validate_the_Change_pin_functionality_by_entering_a_valid_old_pin () {
		 walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_change_Pin();	
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(),"Enter New PIN");
		walletsettingspage.click_Back_Arrow();
	 }
	 
	 
	/*
	Validate the Change pin functionality by entering a Incorrect old pin.
	*/
	@Test(priority = 13 )
	public void To_Validate_the_Change_pin_functionality_by_entering_Incorrect_old_pin () {
		 walletsettingspage = new  WalletSettingsPage(driver);
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
			walletsettingspage.click_change_Pin();	
			mywalletpage = new MyWalletPage(driver);
			Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			
			createpasswordpage.setPassword_0();
			createpasswordpage.clickNext();
			try {
			Assert.assertEquals(Toast(),"Incorrect PIN.");
			}
			catch (StaleElementReferenceException e) {
				createpasswordpage.setPassword_0();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(),"Incorrect PIN.");
			}
			catch (NoSuchElementException e) {
				createpasswordpage.setPassword_0();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(),"Incorrect PIN.");
			}
			walletsettingspage.click_Back_Arrow();
			} 
	
	/*
	Validate the Whether able to navigate to the next screen without entering a value enter pin fields.
	*/
	@Test(priority = 14 )
	public void To_Validatethe_Whether_able_to_navigate_to_next_screen_without_entering_a_values_in_pin_fields () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
		walletsettingspage.click_change_Pin();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
		createpasswordpage.setPassword_1();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
		createpasswordpage.setPassword_0();
		createpasswordpage.clickNext();
		Assert.assertEquals(createpasswordpage.textReEnter(), "Re-Enter your PIN");
		walletsettingspage.click_Back_Arrow();
	}
	
	
	/*
	 Validate whether able to set new pin with old pin value
	 */
	@Test(priority = 15 )
	public void To_Validate_whether_able_to_set_new_pin_with_old_pin_value () {
		    walletsettingspage = new  WalletSettingsPage(driver);
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
			walletsettingspage.click_change_Pin();	
			mywalletpage = new MyWalletPage(driver);
			Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			try {
			Assert.assertEquals(Toast(), "New PIN should not be same as old PIN.");
			}
			catch (NoSuchElementException e) {
				Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
			}
			catch (StaleElementReferenceException e) {
				Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
			}
			walletsettingspage.click_Back_Arrow();
	}
	
	/*
	Validate the Change Pin functionality by entering a valid value in New pin and invalid value in Re-Enter pin.
	*/
	@Test(priority = 16 )
	public void To_Validate_the_ChangePin_functionality_by_entering_a_valid_value_in_Newpin_and_invalid_value_in_ReEnter_pin () {
		   walletsettingspage = new  WalletSettingsPage(driver);
		   Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		   walletsettingspage.click_change_Pin();
		   mywalletpage = new MyWalletPage(driver);
			Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.setPassword_1();
			createpasswordpage.clickNext();
			createpasswordpage.setInValidPassword();
			try {
			Assert.assertEquals(Toast(),"Both PINs should be same.");
			}
			catch (NoSuchElementException e) {
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(),"Both PINs should be same.");
			}
			
				catch (StaleElementReferenceException e) {
					createpasswordpage.setPassword_1();
					createpasswordpage.clickNext();
					Assert.assertEquals(Toast(),"Both PINs should be same.");
				}
			
			walletsettingspage.click_Back_Arrow();
		
	}
	
	
	
	
	
	/*
	Validate the Change Pin functionality by entering a valid Create pin and valid Re-Enter pin.
	*/
	@Test(priority = 17 )
	public void To_Validate_the_Change_Pin_functionality_by_entering_a_valid_Create_pin_and_valid_ReEnter_pin () {
		walletsettingspage = new  WalletSettingsPage(driver);
		   Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		   mywalletpage = new MyWalletPage(driver);
		   walletsettingspage.click_change_Pin();
			Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.change_password_with_Valid_value();
			createpasswordpage.clickOk();
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	




}
