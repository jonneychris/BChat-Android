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
	
	/*
	 Pre Setup to wallet enable
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
		
	}
	
	
//	/*
//	 Validate whether able to navigate back  from wallet enable screen
//	*/
//	@Test (priority = 1)
//	public void To_Validate_whether_able_to_navigate_back_from_wallet_enable_screen () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
//		mywalletpage.Click_Back_Arrow();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_option_Wallet();
//	
//	}
//	
//	
//	/*
//    Validate the working of enable wallet button without clicking the check box
//	*/
//	@Test(priority = 2)
//	public void To_Validate_the_working_of_enable_wallet_button_without_clicking_the_check_box () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
//		mywalletpage.click_Enable_Wallet();
//		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
//		//Assert.assertFalse(mywalletpage.Element_Of_Enable_wallet_button().isEnabled());
//	}
//	
//	
//	/*
//    validate the working of the yes, i understand check box
//	*/
//	@Test(priority = 3)
//	public void To_validate_the_Working_of_the_yes_i_understand_check_box () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
//		mywalletpage.click_CheckBox();
//		Assert.assertTrue(mywalletpage.Element_Of_Enable_wallet_button().isEnabled());
//		
//	}
//	
//	
//	/*
//    Validate the working of the Enable wallet button
//	 */
//	@Test(priority = 4)
//	public void To_Validate_the_working_of_Enable_wallet_Button () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.Enable_Wallet_Screen_Title(),"Wallet");
//		mywalletpage.click_Enable_Wallet();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_option_Wallet();
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
//	}
//	
//	
//	/*
//	 Validate whether able to navigate to the re-enter pin field without entering a value in create pin field.
//	*/
//	@Test(priority = 6)
//	public void To_Validate_whether_able_to_navigate_to_ReEnter_pin_field_without_entering_a_value_in_create_pin_field () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		createpasswordpage.clickNext();
//		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
//	}
//	
//	/*
//	 Validate the Wallet password functionality by entering a valid value in Create pin and invaid value in Re-Enter pin.
//	 */
//	@Test(priority = 7)
//	public void To_Validate_Wallet_password_functionality_by_entering_valid_value_in_Create_pin_and_invaid_Value_in_ReEnter_pin () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		try {
//		createpasswordpage.setInValidPassword();
//		Assert.assertEquals(Toast(), "Both PINs should be same.");
//		}
//		catch (StaleElementReferenceException e) {
//			createpasswordpage.setPassword_1();
//			createpasswordpage.clickNext();
//			Assert.assertEquals(Toast(), "Both PINs should be same.");
//			
//		}
//		catch (NoSuchElementException e) {
//			createpasswordpage.setPassword_1();
//			createpasswordpage.clickNext();
//			Assert.assertEquals(Toast(), "Both PINs should be same.");
//		}
//	}
//	
//	
//	
//	/*
//    Validate whether able to navigate to the next screen without entering a value in Re-Enter pin field.
//	 */
//	@Test(priority = 7)
//	public void To_Validate_whether_able_to_navigate_to_next_screen_without_entering_a_value_in_ReEnter_pin_field () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
//		createpasswordpage.clickNext();
//		Assert.assertEquals(createpasswordpage.textReEnter(),"Re-Enter your PIN");
//	}
//	
//	
//	
//	/*
//    Validate the Wallet password functionality by entering a valid Create pin and valid Re-Enter pin.
//    Validate Whether entered value is visible or not
//	*/
//	@Test(priority = 8)
//    public void To_Validate_the_Wallet_password_functionality_by_entering_a_valid_Create_pin_and_valid_ReEnter_pin (){
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.CreatePin_Screen_Title(),"Create PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		createpasswordpage.setPassword_0();
//		Assert.assertNotEquals(createpasswordpage.text_Value_inPin_fields(),"[0, 0, 0]");
//		createpasswordpage.clickNext();
//		createpasswordpage.clickOk();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(),"My Wallet");
//		mywalletpage.Click_Back_Arrow();
//	
//	}
//	
//	/*
//	Validate whether able to navigate out from verify pin screen.
//	*/
//	@Test(priority = 9)
//	public void To_Validate_whether_able_to_navigate_out_from_VerifyPin_screen () throws InterruptedException {
//		
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_option_Wallet();
//		
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
//		mywalletpage.Click_Back_Arrow();
//		
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_option_Wallet();
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
//	}
//	
//	/*
//	Validate the Wallet password functionality by entering a Incorrect pin.
//	*/
//	@Test(priority = 10 )
//	public void To_Validate_the_Wallet_password_functionality_by_entering_a_Incorrect_pin () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		try{
//			createpasswordpage.setPassword_1();
//			Assert.assertEquals(Toast(),"Incorrect PIN.");
//		}
//		catch (StaleElementReferenceException e) {
//			createpasswordpage.setPassword_1();
//			Assert.assertEquals(Toast(),"Incorrect PIN.");	
//		}
//		catch (NoSuchElementException e) {
//			createpasswordpage.setPassword_1();
//			Assert.assertEquals(Toast(),"Incorrect PIN.");
//		}
//	}
//	
//	
//	/*
//	Validate the Wallet password functionality by entering a valid pin.
//	*/
//	@Test(priority = 11)
//	public void To_Validate_the_Wallet_pin_functionality_by_entering_a_valid_pin () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		createpasswordpage.setPassword_0();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//	}
//	/*
//	Validate whether able to navigate out of the My Wallet
//	*/
//	@Test(priority = 12)
//	public void To_Validate_whether_able_to_navigate_out_of_the_My_Wallet () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.Click_Back_Arrow();
//		
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_option_Wallet();
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
//		createpasswordpage = new CreatePasswordPage(driver);
//		createpasswordpage.setPassword_0();
//		
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//	}
//	
//	/*
//	Validate the Transaction history when empty
//	*/
//	@Test(priority = 13)
//	public void To_Validate_the_Transaction_history_when_empty () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		wait = new WebDriverWait(driver,Duration.ofMinutes(10));
//		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
//		Assert.assertEquals(mywalletpage.Transaction_History_empty_screen(), "No Transactions yet!");
//	}
//	
//	/*
//	 Validate the working of the Transaction filter when transaction is empty
//	 */
//	@Test (priority = 14)
//	public void To_Validate_the_working_of_Transaction_filter_when_transaction_is_empty () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Transaction_Filter();
//		
//		try {
//			Assert.assertFalse(mywalletpage.Transaction_Filter_Enabled().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(mywalletpage.Transaction_History_empty_screen(),"No Transactions yet!");
//		}
//	}
//	
//	/*
//	Validate the working of the reconnect option
//	*/
//	@Test(priority = 15)
//	public void To_Validate_the_working_of_reconnect_option () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Sync_option();
//		mywalletpage.click_Reconnect_option();
//		Assert.assertEquals(mywalletpage.Status_Reconnecting(), "Reconnecting...");
//	}
//	
//	
//	/*
//	Validate the working of the all possible navigation from the my wallet screen in both forward and backward direction.
//	*/
//	@Test(priority = 16)
//	public void To_Validate_working_of_all_possible_navigation_from_my_wallet_screen_in_both_forward_and_backward_direction () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Scan_option();
//		Assert.assertEquals(mywalletpage.Scan_Page_Title(), "Scan");
//		mywalletpage.Click_Back_Arrow();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		
//		mywalletpage.click_Send_option();
//		
//		Assert.assertEquals(mywalletpage.Send_Page_Title(), "Send");
//		mywalletpage.Click_Back_Arrow();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		
//		mywalletpage.click_Recive_option();
//		
//		Assert.assertEquals(mywalletpage.Receive_Page_Title(), "Receive");
//		mywalletpage.Click_Back_Arrow();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		
//		mywalletpage.click_Sync_option();
//		//Assert.assertEquals(mywalletpage.SyncOption_Page_Title(),"");
//		driver.navigate().back();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		
//		mywalletpage.click_WalletSettings_Option();
//		//Assert.assertEquals(false, null);
//		mywalletpage.Click_Back_Arrow();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//
//	}
//	
//	/*
//	Validate the working of the MyWallet functionality without internet connection
//	*/
//	@Test(priority = 17)
//	public void To_Validate_the_working_of_MyWallet_functionality_without_internet_connection () throws InterruptedException {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		turnOff_Mobile_Wifi();
//		mywalletpage.Click_Back_Arrow();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		menupage.click_option_Wallet();
//		Assert.assertEquals(Toast(),"Please check your internet connection");
//		turnOn_Mobile_Wifi();
//		
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(),"BChat");
//		homepage.clickMenuDrawer();
//	    menupage =new MenuPage(driver);
//		Assert.assertEquals(menupage.pagetitle(),"Menu");
//		try {
//		menupage.click_option_Wallet();
//		mywalletpage = new MyWalletPage(driver);
//		}
//		catch (NoSuchElementException e) {
//			Thread.sleep(5000);
//			homepage.clickMenuDrawer();
//		    menupage =new MenuPage(driver);
//			Assert.assertEquals(menupage.pagetitle(),"Menu");
//			menupage.click_option_Wallet();
//			mywalletpage = new MyWalletPage(driver);
//		}
//		createpasswordpage = new CreatePasswordPage(driver);
//		createpasswordpage.setPassword_0();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//	}
//	
//	
//
//	/*
//	Validate the working of the rescan option without Entering any value
//	*/
//	@Test(priority = 18)
//	public void To_Validate_the_working_of_the_rescan_option_Without_Any_Value () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Sync_option();
//		mywalletpage.click_Rescan_Option();
//		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
//		mywalletpage.click_Btn_Rescan();
//		Assert.assertEquals(Toast(), "Please enter a restore height or Select a restore date");
//	}
	
	/*
	validate the working of rescan with more than current block height value
	*/
	@Test(priority = 19)
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
	@Test(priority = 20)
	public void To_validate_presence_of_placeholder_in_textboxes () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		Assert.assertEquals(mywalletpage.get_placholder_value(), "Restore from BlockHeight");
	
	}
	
	
	/*
	Validate whether able to paste numerical value in blockheight text box
	*/
	@Test(priority = 21)
	public void To_Validate_whether_able_to_paste_numerical_value_in_blockheight_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.paste_Values("12345");
		Assert.assertEquals(mywalletpage.get_Values_From_Blockheight_textbox(), "12345");
		mywalletpage.clear_blockheight_textbox();
	}
	
	/*
	validate whether able to paste characters value in blockheight text box
	*/
	@Test(priority = 22)
	public void To_validate_whether_able_to_paste_characters_value_in_blockheight_textbox () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.paste_Values("abced");
		Assert.assertEquals(mywalletpage.get_Values_From_Blockheight_textbox(), "");
		
	}

	
	/*
	validate the working of rescan with restore from date
	*/
	@Test(priority = 23)
	public void To_validate_the_working_of_rescan_with_restore_from_date () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.click_To_Swicth_rescan_option();
		mywalletpage.rescan_From_date();
		Assert.assertEquals(mywalletpage.get_Status_Syncing(),"Wallet Syncing..");
	 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
	  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());
	}
	
	/*
	validate the working of rescan with valid blockheight
	*/
	@Test(priority = 24)
	public void To_validate_the_working_of_rescan_with_valid_blockheight () {
		
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Sync_option();;
		mywalletpage.click_Rescan_Option();
		Assert.assertEquals(mywalletpage.Rescan_page_Title(),"Rescan");
		mywalletpage.Enter_values_In_Blockheight_textbox("3300000");
	   mywalletpage.click_Btn_Rescan();
		Assert.assertEquals(mywalletpage.get_Status_Syncing(),"Wallet Syncing..");
	 wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOf( mywalletpage.Status_Synchronized()));
	  Assert.assertTrue(mywalletpage.Status_Synchronized().isDisplayed());

	}
}
