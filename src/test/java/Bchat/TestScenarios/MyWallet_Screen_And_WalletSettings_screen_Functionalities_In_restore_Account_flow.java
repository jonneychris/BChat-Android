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

import POM.CreatePasswordPage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyWalletPage;
import POM.RecoveryPhrasePage;
import POM.RestoreFromSeedPage;
import POM.SeedPage;
import POM.SendPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyWallet_Screen_And_WalletSettings_screen_Functionalities_In_restore_Account_flow extends baseClass{

	
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
	 preSetup to my wallet screen
	 */
	@Test(priority = 0, groups = {"Regression","Smoke"})
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
		
		//Always keep less than 3 to 4 lacks from current blockheight 		
		restorefromseedpage.setBlockheight("3200000");
	   	restorefromseedpage.clickBtnRestore();
	   	createpasswordpage = new CreatePasswordPage(driver);
	   	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	   	createpasswordpage.setValidPassword();
	   	Thread.sleep(2000);
	   	createpasswordpage.clickOk();
	   	homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"BChat");
	   	try{
	   		wait = new WebDriverWait(driver, Duration.ofMinutes(5));
	   	wait.until(ExpectedConditions.visibilityOf(homepage.Element_Of_chat_Item()));
	   	}
	   	catch (StaleElementReferenceException e) {
	   		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		}
	   	try {
	   	homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
	   	}
	   	catch (NoSuchElementException e) {
	   		//MobileElement clearallnotification=null; 
	   		driver. openNotifications();
	   		
		}
	   	menupage.click_option_Wallet();
		mywalletpage = new MyWalletPage(driver);
		try{
			mywalletpage.click_CheckBox();
		}
		catch (NoSuchElementException e) {
			menupage.click_option_Wallet();
		}
		mywalletpage.click_Enable_Wallet();
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
		createpasswordpage.setValidPassword();
		Thread.sleep(2000);
		createpasswordpage.clickOk();

	}
	
	/*
	Validate whether blocks sync happens well when we disconnect internet and connect internet while blocks syncing.
	*/
	@Test(priority = 1,groups = {"Regression","Smoke"})
	public void To_Validate_whether_blocks_sync_happens_well_when_we_disconnect_internet_and_connect_internet_while_blocks_syncing  () throws InterruptedException {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		int CurrentblocksRemaing = mywalletpage.get_Blocks_Remaining();
			turnOff_Mobile_Wifi();
			Thread.sleep(2000);
			turnOn_Mobile_Wifi();
			Thread.sleep(5000);
			try {
			Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
			}
			catch (AssertionError e) {
				Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
				Thread.sleep(5000);
				Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
			}
			catch (NumberFormatException e) {
				
				Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");	
				Thread.sleep(7000);
			}
		}
	
	/*
	  validate Working Of blocks syncing while navigate to homescreen and back Mywallet screen
	*/
	@Test(priority = 2,groups = {"Regression","Smoke"})
	public void To_validate_Working_Of_blocks_syncing_while_navigate_to_homescreen_and_back_Mywallet_screen () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		int CurrentblocksRemaing = mywalletpage.get_Blocks_Remaining();
		mywalletpage.Click_Back_Arrow();
		 homepage = new HomePage(driver);
		try{
			Assert.assertEquals(homepage.Pagetitle(), "BChat");
		}
		catch (NoSuchElementException e) {
			mywalletpage.Click_Back_Arrow();
		}
		   try{
			   homepage.clickMenuDrawer();
		    menupage =new MenuPage(driver);
		    Assert.assertEquals(menupage.pagetitle(),"Menu");
		   }
		   catch (NoSuchElementException e) {
			   homepage.clickMenuDrawer();
			   menupage =new MenuPage(driver);
			    Assert.assertEquals(menupage.pagetitle(),"Menu");
		}
		   
			menupage.click_option_Wallet();
			createpasswordpage = new CreatePasswordPage(driver);
			createpasswordpage.setPassword_1();
			Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		  
			
		if(mywalletpage.get_Blocks_Remaining() < CurrentblocksRemaing) {
			Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
			Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
		}
		else {
			Assert.assertEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
		}
	
	}
	
	/*
	 validate the working of blocks syncing while minimize and open the app
	 */
	@Test(priority = 3,groups = {"Regression","Smoke"})
	public void To_validate_the_working_of_blocks_syncing_while_minimize_and_open_the_app () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		int CurrentblocksRemaing = mywalletpage.get_Blocks_Remaining();
		Minimize_the_App();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");  
		if(mywalletpage.get_Blocks_Remaining() < CurrentblocksRemaing) {
			Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
			Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
		}
		else {
			Assert.assertEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
		}
	}
	
			
	
	/*
	Validate whether able to do transactions before synchronized of the blocks.
	*/
	@Test(priority = 4,groups = {"Regression","Smoke"})
	public void To_Validate_Whether_able_to_do_transactions_before_Blocks_synchronized () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Send_option();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
		mywalletpage.click_Scan_option();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
	}

	
	/*
	Validate the screen navigation occurs well inside wallet  while blocks syncing.
	*/
	@Test(priority = 6,groups = {"Regression"})
	public void To_Validate_screen_navigation_occurs_well_inside_wallet_while_blocks_syncing () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Recive_option();
		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
		mywalletpage.Click_Back_Arrow();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
	}
	
	/*
	Validate node changes well while blocks sync is in progress.
	*/
	@Test(priority = 7,groups = {"Regression","Smoke"})
	public void To_Validate_node_changes_well_while_blocks_syncing () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_WalletSettings_Option();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		String currentNode = walletsettingspage.get_Current_Node();
		if(currentNode.equalsIgnoreCase("Waiting for network..")) {
			Minimize_the_App();
			 Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
			 mywalletpage.click_WalletSettings_Option();
		}
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
	    walletsettingspage.click_Back_Arrow();
	    Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
	   
	}
	
	/*
	Validate the working of reconnect and rescan option while blocks syncing.
	*/
	@Test(priority = 8,groups = {"Regression","Smoke"})
	public void To_Validate_the_working_of_reconnect_and_rescan_option_while_blocks_syncing ()
	{
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Sync_option();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
	}
	
	/*
	Validate whether  transaction histories are visible.
	*/
	@Test(priority = 9,groups = {"Regression","Smoke"})
	public void To_Validate_whether_transaction_histories_are_visible (){
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		try{wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
		}
		catch (TimeoutException e) {
			wait = new WebDriverWait(driver, Duration.ofMinutes(10));
			wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
		}
		Assert.assertTrue(mywalletpage.Element_of_First_Transaction().isDisplayed());
		
	}
		
		
//	   Not able to catch the values in the transaction history
//	/*
//	Validate the working of the transactions filter by incoming.
//	*/
//	@Test(priority = 10,groups = {"Regression"})
//	public void To_Validate_the_working_of_transactions_filter_by_incoming () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Transaction_Filter();
//		mywalletpage.click_Outgoing_CheckBox();
//		Assert.assertEquals(Toast(), "Filter applied");
//	}
//	
//	
//	/*
//	Validate the working of the transactions filter by outgoing.
//	*/
//	@Test(priority = 11,groups = {"Regression"})
//	public void To_Validate_the_working_of_transactions_filter_by_outgoing () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Outgoing_CheckBox();
//		mywalletpage.click_Incoming_CheckBox();
//		Assert.assertEquals(Toast(), "Filter applied");
//		
//	}
	
	/*
	 Validate the working of cancel button in the filter by date
	 */
	@Test(priority = 12,groups = {"Regression"})
	public void To_Validate_the_working_of_cancel_button_in_filter_by_date () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Transaction_Filter();
		mywalletpage.click_Filter_By_date();
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		mywalletpage.click_Cancel_In_FilterDate();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	}
	
	/*
	Validate the working of the transactions filter by date.
	*/
	@Test(priority = 13,groups = {"Regression"})
	public void To_Validate_the_working_of_transactions_filter_by_date () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Filter_By_date();
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		mywalletpage.Select_FromDate_previousMonth(1);
		mywalletpage.Select_ToDate_As_TodayDate();
		mywalletpage.click_ok_In_FilterDate();
		try{
			Assert.assertEquals(Toast(),"Filter applied");
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		}
		catch (StaleElementReferenceException e) {
			Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		}
		
	}
	
	/*
	 Validate the working of Transaction filter by date without selecting both date
	 */
	@Test(priority = 14,groups = {"Regression"})
	public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_both_date () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Filter_By_date();
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		mywalletpage.click_ok_In_FilterDate();
		try {
			Assert.assertEquals(Toast(), "Please enter from date");
			}
			catch (NoSuchElementException e) {
				try{
					mywalletpage.click_ok_In_FilterDate();				
				Assert.assertEquals(Toast(), "Please enter from date");
				}
				catch (Exception e1) {
					Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
				}
				}
			catch (StaleElementReferenceException e) {
				try{
					mywalletpage.click_ok_In_FilterDate();				
				Assert.assertEquals(Toast(), "Please enter from date");
				}
				catch (Exception e1) {
					Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
				}
			}		
	}
      
     /*
	Validate the working of Transaction filter by date without selecting from date
	*/
	@Test(priority = 15,groups = {"Regression"})
	public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_from_date () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		mywalletpage.Select_ToDate_As_TodayDate();
		mywalletpage.click_ok_In_FilterDate();
		try {
		Assert.assertEquals(Toast(), "Please enter from date");
		}
		catch (NoSuchElementException e) {
			try{
				mywalletpage.click_ok_In_FilterDate();				
			Assert.assertEquals(Toast(), "Please enter from date");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			}
		}
		catch (StaleElementReferenceException e) {
			try{
				mywalletpage.click_ok_In_FilterDate();				
			Assert.assertEquals(Toast(), "Please enter from date");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			}
		}
		
		mywalletpage.click_Cancel_In_FilterDate();
		
	}
	
	/*
	 Validate the working of Transaction filter by date without selecting To date
	 */
	@Test(priority = 16,groups = {"Regression"})
	public void To_Validate_the_working_of_Transactionfilter_by_date_without_selecting_To_date () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Filter_By_date();
		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
		mywalletpage.Select_FromDate_previousMonth(1);;
		mywalletpage.click_ok_In_FilterDate();
		try {
		Assert.assertEquals(Toast(), "Please enter to date");
		}
		catch (NoSuchElementException e) {
			try{
				mywalletpage.click_ok_In_FilterDate();
			Assert.assertEquals(Toast(), "Please enter to date");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			}
			
			}
		catch (StaleElementReferenceException e) {
			try{
				mywalletpage.click_ok_In_FilterDate();
			Assert.assertEquals(Toast(), "Please enter to date");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
			}
		}	
		mywalletpage.click_Cancel_In_FilterDate();
	}
	
	/*
	Validate the working of transaction details dropdown
	*/
	@Test(priority = 17,groups = {"Regression"})
	public void To_Validate_the_working_of_transaction_details_dropdown () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_Transaction_Filter();
		mywalletpage.click_First_Transaction();
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_BackArrow_In_details();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	}
	
	/*
	validate whether same amount showing in the transaction history and in details 
	*/
	@Test(priority = 18,groups = {"Regression","Smoke"})
	public void To_validate_whether_same_amount_showing_in_transaction_history_and_details () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		String FirstAmount = mywalletpage.get_first_Transaction_amount();
		mywalletpage.click_First_Transaction();
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		Assert.assertEquals(FirstAmount, mywalletpage.get_Amount_In_details());
	
	}
	
	
	/*
	validate the navigation to explorer page on clicking transaction Id
	*/
	@Test(priority = 19,groups = {"Regression"})
	public void To_validate_the_navigation_to_explorer_page_on_clicking_transactionId () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_transactionID();
		//Assert.assertTrue(mywalletpage.get_Explorer_Url().contains("explorer.beldex.io"));
		driver.navigate().back();
	}
	
	/*
	validate the working of the copy icons in the transaction details
	*/
	@Test(priority = 20,groups = {"Regression","Smoke"})
	public void To_validate_the_working_of_copy_icon_in_transaction_details () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_CopyIcon_In_details();
		try {
		Assert.assertEquals(Toast(), "Copied to clip board");
		}
		catch (StaleElementReferenceException e) {
			try{mywalletpage.click_CopyIcon_In_details();
			Assert.assertEquals(Toast(), "Copied to clip board");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			}
		}
		catch (NoSuchElementException e) {
			try{mywalletpage.click_CopyIcon_In_details();
			Assert.assertEquals(Toast(), "Copied to clip board");
			}
			catch (Exception e1) {
				Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
			}
			}
		
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_BackArrow_In_details();
		
		
		}
	
	
		   /*
		    * 
		    * 
		    *  Send Screen
		    *  
		    *  
		    */
	
	
	/*
	validate the working of the send amount functionality with amount greater than balance
	*/
	@Test(priority = 21,groups = {"Regression"})
	public void To_validate_the_working_of_send_amount_functionality_with_amount_greater_than_balance () {
		mywalletpage = new MyWalletPage(driver);
		mywalletpage.click_Send_option();
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
	 Validate the working of the send functionality with a Invalid Address and Valid Amount.
	 */
	@Test(priority = 22,groups = {"Regression","Smoke"})
	public void To_Validate_the_working_of_send_functionality_with_Invalid_Address_and_Valid_Amount () {
		
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc3P1trLBnjiLEgu3SjwqqnWuTv3446ejLgMV4gi5s1fMJnar3A");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.click_send();
		createpasswordpage = new CreatePasswordPage(driver);
	    try{
	    	createpasswordpage.setPassword_1();
	    }
	    catch (NoSuchElementException e) {
			
		}
	    Assert.assertEquals(sendpage.transactionError_popup_Title(),"Create Transaction Error");
		sendpage.click_ok();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		
		
		
	}
	
	
	/*
	Validate the working of the send functionality with a valid Address and Invalid Amount.
	*/
	@Test(priority = 23,groups = {"Regression","Smoke"})
	public void To_Validate_the_working_of_send_functionality_with_valid_Address_and_Invalid_Amount () {
		
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
	@Test(priority = 24,groups = {"Regression"})
	public void To_Validate_amount_entered_in_BDX_conversion_to_selected_currency () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Amount("10");
		Assert.assertNotEquals(sendpage.get_fiatCurrency_Value(),"0.0000 USD");
		sendpage.clear_TextBoxes();
	}
	
	
	
	/*
	Validate the working of the send amount functionality without internet connection
	*/
	@Test(priority = 25,groups = {"Regression"})
	public void To_Validate_the_working_of_send_amount_functionality_without_internet_connection () throws InterruptedException {
		turnOff_Mobile_Wifi();
		sendpage = new SendPage(driver);
		try{
			Assert.assertEquals(sendpage.pagetitle(),"Send");
		}
		catch (NoSuchElementException e) {
			mywalletpage = new MyWalletPage(driver);
			mywalletpage.click_Send_option();
			Assert.assertEquals(sendpage.pagetitle(),"Send");
		}
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.00001");
		sendpage.click_send();
		try{
			Assert.assertEquals(Toast(), "Please check your internet connection");
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		turnOn_Mobile_Wifi();
		sendpage.clear_TextBoxes();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		
	}
	

	/*
	Validate whether the values in the text boxes got cleared after navigate to pin screen
	*/
	@Test(priority = 26,groups = {"Regression"})
	public void To_Validate_whether_the_values_in_text_boxes_got_cleared_after_navigate_to_pin_screen () {
		
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
	@Test(priority = 27,groups = {"Regression"})
	public void To_Validate_the_working_of_cancel_button_in_confirm_popup () {
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.0001");
		sendpage.click_send();
		createpasswordpage = new CreatePasswordPage(driver);
		createpasswordpage.setPassword_1();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sendpage.Element_Confirm_Popup()));
		sendpage.click_Cancel_In_confrimPopup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		
	
	}
	
	/*
	 validate whether able to enter multiple dots and commas in amount field
	 */
	@Test(priority = 28,groups = {"Regression"})
	public void To_validate_whether_able_to_enter_multiple_dots_and_commas_in_amount_field () {
		
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
	@Test(priority = 29,groups = {"Regression"})
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
	@Test(priority = 30,groups = {"Regression"})
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
	@Test(priority = 31,groups = {"Regression","Smoke"})
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
	//	System.out.println((sendpage.Element_Confirm_Popup().getCssValue("background-color")));
		sendpage.click_Cancel_In_confrimPopup();
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		
		
	}
	
	/*
	Validate the working of the send functionality with a valid Address and Valid Amount.
	*/
	@Test(priority = 32,groups = {"Regression","Smoke"})
	public void To_Validate_the_working_of_send_functionality_with_valid_Address_and_Valid_Amount () {
				
		sendpage = new SendPage(driver);
		Assert.assertEquals(sendpage.pagetitle(),"Send");
		sendpage.Enter_Values_In_Address("bxc6bAQw5zYEsxvdWdrHKL9w5hpWXxENtgviLJYHJoB6EYLawPNQGiJ2GsahHNMUPoSQwu6vS3jmqXkF3F66Cz4o1z4DgQAqC");
		sendpage.Enter_Values_In_Amount("0.0001");
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
	 * 
	 * 
	 * Wallet Settings screen
	 * 
	 * 
	 */
	

	
	/*
	Validate the node screen without Internet connection
	*/
	@Test(priority = 33,groups = {"Regression","Smoke"})
	public void To_Validate_the_node_screen_without_internet_connection () throws InterruptedException {
		turnOff_Mobile_Wifi();
		Thread.sleep(5000);
		mywalletpage = new MyWalletPage(driver);	
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");	
		mywalletpage.click_WalletSettings_Option();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
        try {		
			Assert.assertEquals(walletsettingspage.get_Current_Node(),"Waiting for network..");
			turnOn_Mobile_Wifi();
        }
        catch (NoSuchElementException e) {
        	walletsettingspage.click_Back_Arrow();
        	mywalletpage.click_WalletSettings_Option();
        	Assert.assertEquals(walletsettingspage.get_Current_Node(),"Waiting for network..");
			turnOn_Mobile_Wifi();
		}
	}

	
	/*
	 Validate the working of cancel icon in all popup
	 */
	@Test(priority = 34,groups = {"Regression"})
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
	@Test(priority = 35,groups = {"Regression"})
	public void To_Validate_whether_able_to_select_all_options_in_DisplayBalanceAs () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Full Balance");
		walletsettingspage.Select_All_Options_In_DisplayBalanceAs();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Hidden");
	}
	
	/*
	 Validate the working of the beldex hidden option in Display Balance As
	 */
	@Test(priority = 36,groups = {"Regression"})
	public void To_Validate_the_working_of_beldex_hidden_option_in_DisplayBalanceAs () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
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
	@Test(priority = 37,groups = {"Regression"})
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
	@Test(priority = 38,groups = {"Regression"})
	public void To_Validate_whether_able_to_select_all_options_in_currency () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_currency_Value(), "USD");
		walletsettingspage.Select_All_options_Currency();
		Assert.assertEquals( walletsettingspage.get_currency_Value(), "CNY");
		
		//walletsettingspage.scrollgesture_Using_text("HKD");
	}
	
	
//	/*
//	 Validate whether currency list is Scrollable
//	 */
//	@Test(priority = 39,groups = {"Regression"})
//	public void To_Validate_whether_currency_list_is_Scrollable (){
//		walletsettingspage = new  WalletSettingsPage(driver);
//		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
//		walletsettingspage.click_Currency();
//		try {
//		walletsettingspage.scrollgesture_Using_text("ZAR");
//		//walletsettingspage.c
//		}
//		catch (NoSuchElementException e) {
//			walletsettingspage.scrollgesture_Using_text("ZAR");
//		}
//		
//	}
	
//	/*
//    validate the working of the search box with valid value
//    */
//	@Test (priority = 40,groups = {"Regression"})
//	public void To_validate_the_working_of_search_box_with_valid_value (){
//		
//		walletsettingspage = new  WalletSettingsPage(driver);
//		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
//		walletsettingspage.click_Currency();
//		walletsettingspage.Enter_values_In_Search_TextBox("INR");
//		walletsettingspage.click_Searched_Currency();
//		Assert.assertEquals(walletsettingspage.get_currency_Value(), "INR");
//	}
    	
	/*
	Validate the working of all options in Fee Priority.
	*/
	@Test(priority = 41,groups = {"Regression"})
	public void To_Validate_working_of_All_options_in_Fee_Priority () {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_FeePriority_value(),"Flash");
		walletsettingspage.Select_All_options_FeePriority();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		Assert.assertEquals(walletsettingspage.get_FeePriority_value(),"Slow");
	}
	
	
//	/*
//	 Validate whether selected option is option is displayed in wallet Settings and My Wallet screen 
//	 */
//	@Test(priority = 42,groups = {"Regression"})
//	public void To_Validate_whether_selected_option_is_displayed_in_wallet_Settings_and_My_Wallet_screen () {
//		walletsettingspage = new  WalletSettingsPage(driver);
//		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
//		walletsettingspage.click_DisplayBalanceAs();
//		walletsettingspage.scrollAndClick_Using_text("Beldex Full Balance");
//		
//		walletsettingspage.click_Decimals();
//		walletsettingspage.scrollAndClick_Using_text("3 - Three (0.000)");
//		
//		walletsettingspage.click_Currency();;
//		walletsettingspage.Enter_values_In_Search_TextBox("SGD");
//		walletsettingspage.click_Searched_Currency();
//		Assert.assertEquals(walletsettingspage.get_DisplayBalanceAs_Value(), "Beldex Full Balance");
//		Assert.assertEquals(walletsettingspage.get_Decimals_Value(), "3 - Three (0.000)");
//		Assert.assertEquals(walletsettingspage.get_currency_Value(), "SGD");
//	
//		walletsettingspage.click_Back_Arrow();
//		mywalletpage = new MyWalletPage(driver);
//		
//		Assert.assertEquals(mywalletpage.get_Bdx_value(),"0.000");
//		Assert.assertEquals(mywalletpage.get_FiatCurrency_value(),"0.00 SGD");
//		mywalletpage.click_WalletSettings_Option();
//	}
	
	
	/*
	Validate the Navigation to the address book.
	*/
	@Test(priority = 43,groups = {"Regression"})
	public void To_Validate_the_Navigate_to_Address_book () throws InterruptedException {
		walletsettingspage = new  WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(1000);
		walletsettingspage.click_AddressBook();
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	
		
	/*
	 Validate the Address book screen while having a contacts.
	 */
	@Test(priority = 44,groups = {"Regression","Smoke"})
	public void To_Validate_the_Addressbook_screen_while_having_a_contacts () throws InterruptedException {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		Thread.sleep(2000);
		walletsettingspage.click_AddressBook();
		Assert.assertTrue(walletsettingspage.Element_of_Copy_Icon().isDisplayed());
	}
	
	
	/*
	validate the working of the search option with invalid contact name
	*/
	@Test(priority = 45,groups = {"Regression","Smoke"})
	public void To_validate_the_working_of_search_option_with_Invalid_contactName () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.Enter_values_In_Search_TextBox("*1234@#45");
		Assert.assertEquals(walletsettingspage.Element_No_Contacts(),"No Contacts");
		walletsettingspage.clear_search_textbox();
	}
	
	
	/*
	validate whether able to paste the contact name in search text box
	*/
	@Test(priority = 46,groups = {"Regression"})
	public void To_validate_whether_able_to_paste_contactName_in_search_textbox () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.paste_Values_In_Searchtextbox("Test");
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"Test");
		walletsettingspage.clear_search_textbox();
	}
	
	
	/*
	validate the working of the cancel icon inside the search text box
	*/
	@Test(priority = 47,groups = {"Regression"})
	public void To_validate_the_working_of_cancel_icon_inside_the_search_textbox () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.paste_Values_In_Searchtextbox("check");
		walletsettingspage.click_closeIcon_In_searchtextbox();
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"");
	}	

	

	/*
	validate the working of copy icon in the address book
	*/
	@Test(priority = 48,groups = {"Regression","Smoke"})
	public void To_validate_the_working_of_copy_icon_in_address_book () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.click_CopyOrSend_Of_FirstAddress();
		try {
		Assert.assertEquals(Toast(),"Copied to clipboard");
		}
		catch (StaleElementReferenceException e) {
			try{walletsettingspage.click_CopyOrSend_Of_FirstAddress();
			Assert.assertEquals(Toast(),"Copied to clipboard");
			}
		catch (Exception e1) {
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		}	
		}
		catch (NoSuchElementException e) {
			try{walletsettingspage.click_CopyOrSend_Of_FirstAddress();
			Assert.assertEquals(Toast(),"Copied to clipboard");
			}
		catch (Exception e1) {
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		}	
		}
		driver.navigate().back();
	
	}
	
	
	/*
	Validate the Change pin functionality by entering a valid old pin.
	*/
	 @Test(priority = 49,groups = {"Regression","Smoke"})
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
	@Test(priority = 50,groups = {"Regression"} )
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
				try{createpasswordpage.setPassword_0();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(),"Incorrect PIN.");
				}
			catch (Exception e1) {
				Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			}	
			}
			catch (NoSuchElementException e) {
				try{createpasswordpage.setPassword_0();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(),"Incorrect PIN.");
				}
			catch (Exception e1) {
				Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			}
			}
			walletsettingspage.click_Back_Arrow();
			} 
	
	/*
	Validate the Whether able to navigate to the next screen without entering a value enter pin fields.
	*/
	@Test(priority = 51,groups = {"Regression"} )
	public void To_Validatethe_Whether_able_to_navigate_to_next_screen_without_entering_a_values_in_pin_fields () {
		walletsettingspage = new  WalletSettingsPage(driver);
		
		walletsettingspage.click_change_Pin();
		Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
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
	@Test(priority = 52,groups = {"Regression"} )
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
				try{
					Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(), "New PIN should not be same as old PIN.");
				}
				catch (Exception e1) {
					Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				}
			}
			catch (StaleElementReferenceException e) {
				try{
					Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(), "New PIN should not be same as old PIN.");
				}
				catch (Exception e1) {
					Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				}
			}
			
			walletsettingspage.click_Back_Arrow();
	}
	
	/*
	Validate the Change Pin functionality by entering a valid value in New pin and invalid value in Re-Enter pin.
	*/
	@Test(priority = 53,groups = {"Regression","Smoke"} )
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
				try{
					createpasswordpage.setPassword_1();
				createpasswordpage.clickNext();
				Assert.assertEquals(Toast(),"Both PINs should be same.");
				}
				catch (Exception e1) {
					Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
				}
				
				}
			
				catch (StaleElementReferenceException e) {
					try{
						createpasswordpage.setPassword_1();
					createpasswordpage.clickNext();
					Assert.assertEquals(Toast(),"Both PINs should be same.");
					}
					catch (Exception e1) {
						Assert.assertEquals(createpasswordpage.textNewPin(), "Enter New PIN");
					}
				}
			
			walletsettingspage.click_Back_Arrow();
		
	}
	
	/*
	Validate the Change Pin functionality by entering a valid Create pin and valid Re-Enter pin.
	*/
	@Test(priority = 54 ,groups = {"Regression","Smoke"})
	public void To_Validate_the_Change_Pin_functionality_by_entering_a_valid_Create_pin_and_valid_ReEnter_pin () throws InterruptedException {
		walletsettingspage = new  WalletSettingsPage(driver);
		   Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		   mywalletpage = new MyWalletPage(driver);
		   walletsettingspage.click_change_Pin();
			Assert.assertEquals(mywalletpage.VerifyPin_Screen_Title(),"Verify PIN");
			createpasswordpage = new CreatePasswordPage(driver);
			Assert.assertEquals(createpasswordpage.textOldPin(), "Enter Old PIN");
			createpasswordpage.change_password_with_Valid_value();
			Thread.sleep(1000);
			createpasswordpage.clickOk();
			Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	
	
		
	
}
