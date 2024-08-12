package Bchat.TestScenarios;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

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
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SendPage;
import POM.SocialGroupPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class Send_Screen_And_Its_Functionality_In_SignIn_Flow extends baseClass{

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	MenuPage menupage;
	WebDriverWait wait;
	MyWalletPage mywalletpage;
	SendPage sendpage;
	WalletSettingsPage walletsettingspage;
	
	/*
	 Pre setup to send screen
	 */
	@Test(priority = 0)
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
		restorefromseedpage.setBlockheight("3400000");
	   	restorefromseedpage.clickBtnRestore();
	   	createpasswordpage = new CreatePasswordPage(driver);
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	createpasswordpage.setValidPassword();
	   	Thread.sleep(2000);
	   	createpasswordpage.clickOk();
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
		Thread.sleep(3000);
		createpasswordpage.clickOk();
		wait = new WebDriverWait(driver,Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
		try {
		Assert.assertNotEquals(mywalletpage.get_Bdx_value(),"0.00");
		}
		catch (AssertionError e) {
			mywalletpage.click_Sync_option();
			mywalletpage.click_Rescan_Option();
			mywalletpage.click_To_Swicth_rescan_option();
			mywalletpage.rescan_From_date();
			wait = new WebDriverWait(driver,Duration.ofMinutes(10));
			wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
			Assert.assertNotEquals(mywalletpage.get_Bdx_value(),"0.00");
			mywalletpage.click_Send_option();
		}
		mywalletpage.click_Send_option();
	   	
	}
	
	
	/*
	 Validate the working of the send functionality with a Invalid Address and Valid Amount.
	 */
	@Test(priority = 1)
	public void To_Validate_the_working_of_send_functionality_with_Invalid_Address_and_Valid_Amount () {
		
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc3P1trLBnjiLEgu3SjwqqnWuTv3446ejLgMV4gi5s1fMJnar3A");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.click_send();
		createpasswordpage = new CreatePasswordPage(driver);
	    createpasswordpage.setPassword_1();
	    Assert.assertEquals(sendpage.transactionError_popup_Title(),"Create Transaction Error");
		sendpage.click_ok();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_BackArrow();
		
		
	}
	
	
	/*
	Validate the working of the send functionality with a valid Address and Invalid Amount.
	*/
	@Test(priority = 2)
	public void To_Validate_the_working_of_send_functionality_with_valid_Address_and_Invalid_Amount () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(),"My Wallet");
		mywalletpage.click_Send_option();
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.0000");
		sendpage.click_send();
		Assert.assertEquals(sendpage.get_Error_Msg_In_Amount(),"Enter a valid amount");
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.clear_TextBoxes();
		
	}
	
	
	/*
	Validate amount entered in BDX conversion to the selected currency.
	*/
	@Test(priority = 3)
	public void To_Validate_amount_entered_in_BDX_conversion_to_selected_currency () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Amount("10");
		Assert.assertNotEquals(sendpage.get_fiatCurrency_Value(),"0.0000 USD");
		sendpage.clear_TextBoxes();
	}
	
	/*
	validate the working of the send amount functionality with amount greater than balance
	*/
	@Test(priority = 4)
	public void To_validate_the_working_of_send_amount_functionality_with_amount_greater_than_balance () {
		
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("10");
		sendpage.click_send();
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_1();
		Assert.assertEquals(sendpage.transactionError_popup_Title(),"Create Transaction Error");
		sendpage.click_ok();
		
	}
	
	/*
	Validate the working of the send amount functionality without internet connection
	*/
	@Test(priority = 5)
	public void To_Validate_the_working_of_send_amount_functionality_without_internet_connection () throws InterruptedException {
		turnOff_Mobile_Wifi();
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.00001");
		sendpage.click_send();
		Assert.assertEquals(Toast(), "Please check your internet connection");
		turnOn_Mobile_Wifi();
		sendpage.clear_TextBoxes();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_BackArrow();
	}
	

	/*
	Validate whether the values in the text boxes got cleared after navigate to pin screen
	*/
	@Test(priority = 6)
	public void To_Validate_whether_the_values_in_text_boxes_got_cleared_after_navigate_to_pin_screen () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Send_option();
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.00001");
		sendpage.click_send();
		sendpage.click_BackArrow();
		Assert.assertEquals(sendpage.get_Values_In_AmountField(),"");
		Assert.assertEquals(sendpage.get_Values_In_AddressField(),"");

	}
	
	/*
	 Validate the working of cancel button in confirm popup
	 */
	@Test(priority = 7)
	public void To_Validate_the_working_of_cancel_button_in_confirm_popup () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.00001");
		sendpage.click_send();
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_1();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		sendpage.click_Cancel_In_confrimPopup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_BackArrow();
	
	}
	
	/*
	 validate whether able to enter multiple dots and commas in amount field
	 */
	@Test(priority = 8)
	public void To_validate_whether_able_to_enter_multiple_dots_and_commas_in_amount_field () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Send_option();
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.paste_Value_In_Amount("0.01.");
		Assert.assertTrue(sendpage.get_Values_In_AmountField().isEmpty());
	
	sendpage.paste_Value_In_Amount("0,01");
	Assert.assertTrue(sendpage.get_Values_In_AmountField().isEmpty());
	}	
	
	/*
	 validate the amount text box by entering lengthy amount value
	 */
	@Test(priority = 9)
	public void To_validate_the_amount_text_box_by_entering_lengthy_amount_value () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Amount("123456789012345");
		Assert.assertEquals(sendpage.get_Error_Msg_In_Amount(),"Enter a valid amount");
		sendpage.clear_TextBoxes();
		
	}
	
	/*
	 validate whether able to paste values in the text boxes
	 */
	@Test(priority = 10)
	public void To_Validate_Whether_Able_To_Paste_Values_in_text_Boxes () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.paste_Value_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.paste_Value_In_Amount("0.00001");
		Assert.assertFalse(sendpage.get_Values_In_AmountField().isEmpty());
		Assert.assertFalse(sendpage.get_Values_In_AddressField().isEmpty());
		sendpage.clear_TextBoxes();
	}
	
	/*
	 Validate the working of the send functionality by using contacts book.
	 */
	@Test(priority = 11)
	public void To_Validate_the_working_of_send_functionality_by_using_contacts_book () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
        sendpage.Enter_Values_In_Amount("0.0001");
        sendpage.click_AddressBook();
        walletsettingspage = new WalletSettingsPage(driver);
        walletsettingspage.click_CopyOrSend_Of_FirstAddress();
        sendpage.click_send();
        createpasswordpage = new CreatePasswordPage(driver);
        createpasswordpage.setPassword_1();
        wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		Assert.assertEquals(sendpage.Element_Confirm_Popup().getText(), "Confirm Sending");
		sendpage.click_Cancel_In_confrimPopup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.click_BackArrow();
	}
	
	/*
	Validate the working of the send functionality with a valid Address and Valid Amount.
	*/
	@Test(priority = 12)
	public void To_Validate_the_working_of_send_functionality_with_valid_Address_and_Valid_Amount () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Send_option();		
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.click_send();
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_1();
		wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		Assert.assertEquals(sendpage.Element_Confirm_Popup().getText(), "Confirm Sending");
		
	}
	
	
}
