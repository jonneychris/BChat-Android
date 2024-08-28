package Bchat.TestScenarios;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
		restorefromseedpage.setBlockheight("3200000");
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
		Thread.sleep(2000);
		createpasswordpage.clickOk();

	}
	
	/*
	Validate whether blocks sync happens well when we disconnect internet and connect internet while blocks syncing.
	*/
	@Test(priority = 1)
	public void To_Validate_whether_blocks_sync_happens_well_when_we_disconnect_internet_and_connect_internet_while_blocks_syncing  () throws InterruptedException {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		
		int CurrentblocksRemaing = mywalletpage.get_Blocks_Remaining();
			turnOff_Mobile_Wifi();
			Thread.sleep(1000);
			turnOn_Mobile_Wifi();
			Thread.sleep(2000);
			try {
			Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
			}
			catch (AssertionError e) {
				Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
				Thread.sleep(5000);
				Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
			}
			catch (NumberFormatException e) {
				Thread.sleep(5000);
				//
				
			}
		}
	
//	/*
//	  validate Working Of blocks syncing while navigate to homescreen and back Mywallet screen
//	*/
//	@Test(priority = 2)
//	public void To_validate_Working_Of_blocks_syncing_while_navigate_to_homescreen_and_back_Mywallet_screen () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		int CurrentblocksRemaing = mywalletpage.get_Blocks_Remaining();
//		mywalletpage.Click_Back_Arrow();
//		homepage = new HomePage(driver);
//		Assert.assertEquals(homepage.Pagetitle(), "BChat");
//		 homepage.clickMenuDrawer();
//		    menupage =new MenuPage(driver);
//			Assert.assertEquals(menupage.pagetitle(),"Menu");
//			menupage.click_option_Wallet();
//			createpasswordpage = new CreatePasswordPage(driver);
//			createpasswordpage.setPassword_1();
//			Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		  
//			
//		if(mywalletpage.get_Blocks_Remaining() < CurrentblocksRemaing) {
//			Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
//			Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//		}
//		else {
//			Assert.assertEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
//		}
//	
//	}
//	
//	/*
//	 validate the working of blocks syncing while minimize and open the app
//	 */
//	@Test(priority = 3)
//	public void To_validate_the_working_of_blocks_syncing_while_minimize_and_open_the_app () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		int CurrentblocksRemaing = mywalletpage.get_Blocks_Remaining();
//		Minimize_the_App();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");  
//		if(mywalletpage.get_Blocks_Remaining() < CurrentblocksRemaing) {
//			Assert.assertNotEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
//			Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//		}
//		else {
//			Assert.assertEquals(mywalletpage.get_Blocks_Remaining(), CurrentblocksRemaing);
//		}
//	}
//	
//			
//	
//	/*
//	Validate whether able to do transactions before synchronized of the blocks.
//	*/
//	@Test(priority = 4)
//	public void To_Validate_Whether_able_to_do_transactions_before_Blocks_synchronized () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Send_option();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//		mywalletpage.click_Scan_option();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//	}
//	
//	/*
//	 Validate whether transactionFilter options are enabled while blocks syncing
//	 */
//	@Test(priority = 5)
//	public void To_Validate_whether_transactionFilter_options_are_enabled_while_blocks_syncing () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Transaction_Filter();
//		
//		try {
//			Assert.assertFalse(mywalletpage.Transaction_Filter_Enabled().isDisplayed());
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//		}
//	}
//	
//	/*
//	Validate the screen navigation occurs well inside wallet  while blocks syncing.
//	*/
//	@Test(priority = 6)
//	public void To_Validate_screen_navigation_occurs_well_inside_wallet_while_blocks_syncing () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Recive_option();
//		Assert.assertEquals(mywalletpage.Receive_Page_Title(),"Receive");
//		mywalletpage.Click_Back_Arrow();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//		mywalletpage.click_WalletSettings_Option();
//		walletsettingspage = new WalletSettingsPage(driver);
//		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
//		walletsettingspage.click_Back_Arrow();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//	}
	
	/*
	Validate node changes well while blocks sync is in progress.
	*/
	@Test(priority = 7)
	public void To_Validate_node_changes_well_while_blocks_syncing () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		mywalletpage.click_WalletSettings_Option();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
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
	    walletsettingspage.click_Back_Arrow();
	    Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
	   
	}
	
//	/*
//	Validate the working of reconnect and rescan option while blocks syncing.
//	*/
//	@Test(priority = 8)
//	public void To_Validate_the_working_of_reconnect_and_rescan_option_while_blocks_syncing ()
//	{
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Sync_option();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		Assert.assertEquals(mywalletpage.get_Status_Syncing(), "Wallet Syncing..");
//	}
//	
//	/*
//	Validate whether  transaction histories are visible.
//	*/
//	@Test(priority = 9)
//	public void To_Validate_whether_transaction_histories_are_visible (){
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		wait = new WebDriverWait(driver, Duration.ofMinutes(10));
//		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
//		try {
//		Assert.assertNotEquals(mywalletpage.Transaction_History_empty_screen(),"No Transactions yet!");
//		}
//		catch (NoSuchElementException e) {
//			Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		}
//		}
//	
//	/*
//	Validate the working of the transactions filter by incoming.
//	*/
//	@Test(priority = 10)
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
//	@Test(priority = 11)
//	public void To_Validate_the_working_of_transactions_filter_by_outgoing () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Outgoing_CheckBox();
//		mywalletpage.click_Incoming_CheckBox();
//		Assert.assertEquals(Toast(), "Filter applied");
//		
//	}
//	
//	/*
//	 Validate the working of cancel button in the filter by date
//	 */
//	@Test(priority = 12)
//	public void To_Validate_the_working_of_cancel_button_in_filter_by_date () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Incoming_CheckBox();
//		mywalletpage.click_Filter_By_date();
//		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
//		mywalletpage.click_Cancel_In_FilterDate();
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//	}
//	
//	/*
//	Validate the working of the transactions filter by date.
//	*/
//	@Test(priority = 13)
//	public void To_Validate_the_working_of_transactions_filter_by_date () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Filter_By_date();
//		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
//		mywalletpage.Select_FromDate_previousMonth(1);
//		mywalletpage.Select_ToDate_As_TodayDate();
//		mywalletpage.click_ok_In_FilterDate();
//		Assert.assertEquals(Toast(),"Filter applied");
//		
//	}
//	
//	/*
//	 Validate the working of Transaction filter by date without selecting both date
//	 */
//	@Test(priority = 14)
//	public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_both_date () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Filter_By_date();
//		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
//		mywalletpage.click_ok_In_FilterDate();
//		try {
//			Assert.assertEquals(Toast(), "Please enter from date");
//			}
//			catch (NoSuchElementException e) {
//				mywalletpage.click_ok_In_FilterDate();
//				Assert.assertEquals(Toast(), "Please enter from date");
//			}
//			catch (StaleElementReferenceException e) {
//				mywalletpage.click_ok_In_FilterDate();
//				Assert.assertEquals(Toast(), "Please enter from date");
//			}		
//	}
//      
//     /*
//	Validate the working of Transaction filter by date without selecting from date
//	*/
//	@Test(priority = 15)
//	public void To_Validate_the_working_of_Transaction_filter_by_date_without_selecting_from_date () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
//		mywalletpage.Select_ToDate_As_TodayDate();
//		mywalletpage.click_ok_In_FilterDate();
//		try {
//		Assert.assertEquals(Toast(), "Please enter from date");
//		}
//		catch (NoSuchElementException e) {
//			mywalletpage.click_ok_In_FilterDate();
//			Assert.assertEquals(Toast(), "Please enter from date");
//		}
//		catch (StaleElementReferenceException e) {
//			mywalletpage.click_ok_In_FilterDate();
//			Assert.assertEquals(Toast(), "Please enter from date");
//		}
//		
//		mywalletpage.click_Cancel_In_FilterDate();
//		
//	}
//	
//	/*
//	 Validate the working of Transaction filter by date without selecting To date
//	 */
//	@Test(priority = 16)
//	public void To_Validate_the_working_of_Transactionfilter_by_date_without_selecting_To_date () {
//		mywalletpage = new MyWalletPage(driver);
//		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
//		mywalletpage.click_Filter_By_date();
//		Assert.assertEquals(mywalletpage.Filter_By_Date_Popup_Title(),"Select Date Range");
//		mywalletpage.Select_FromDate_previousMonth(1);;
//		mywalletpage.click_ok_In_FilterDate();
//		try {
//		Assert.assertEquals(Toast(), "Please enter to date");
//		}
//		catch (NoSuchElementException e) {
//			mywalletpage.click_ok_In_FilterDate();
//			Assert.assertEquals(Toast(), "Please enter to date");
//		}
//		catch (StaleElementReferenceException e) {
//			mywalletpage.click_ok_In_FilterDate();
//			Assert.assertEquals(Toast(), "Please enter to date");
//		}		
//	}
	
	/*
	Validate the working of transaction details dropdown
	*/
	@Test(priority = 17)
	public void To_Validate_the_working_of_transaction_details_dropdown () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");

		wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(mywalletpage.Status_Synchronized()));
		mywalletpage.click_First_Transaction();
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_BackArrow_In_details();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	}
	
	/*
	validate whether same amount showing in the transaction history and in details 
	*/
	@Test(priority = 18)
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
	@Test(priority = 19)
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
	@Test(priority = 20)
	public void To_validate_the_working_of_copy_icon_in_transaction_details () {
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_CopyIcon_In_details();
		try {
		Assert.assertEquals(Toast(), "Copied to clip board");
		}
		catch (StaleElementReferenceException e) {
			mywalletpage.click_CopyIcon_In_details();
			Assert.assertEquals(Toast(), "Copied to clip board");
		}
		catch (NoSuchElementException e) {
			mywalletpage.click_CopyIcon_In_details();
			Assert.assertEquals(Toast(), "Copied to clip board");
		}
		
		}
	
	/*
	Validate the node screen without Internet connection
	*/
	@Test(priority = 21)
	public void To_Validate_the_node_screen_without_internet_connection () {
		turnOff_Mobile_Wifi();
		mywalletpage = new MyWalletPage(driver);
		Assert.assertEquals(mywalletpage.Details_screen_title(),"Details");
		mywalletpage.click_BackArrow_In_details();
		Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");	
		mywalletpage.click_WalletSettings_Option();
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		walletsettingspage.click_Current_Node();
		try {
		walletsettingspage.click_publicNode1();
		}
		catch (NoSuchElementException e) {
			mywalletpage.Click_Back_Arrow();
			Assert.assertEquals(walletsettingspage.get_Current_Node(),"Waiting for network..");
			turnOn_Mobile_Wifi();
		}
		
	
	}
	
	/*
	 Validate the Address book screen while having a contacts.
	 */
	@Test(priority = 22)
	public void To_Validate_the_Addressbook_screen_while_having_a_contacts () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(),"Wallet settings");
		walletsettingspage.scrollgesture_Using_text("Change Pin");
		walletsettingspage.click_AddressBook();
		try {
		Assert.assertEquals(walletsettingspage.emptyAddressBook_screen(),"No Addresses!");
		}
		catch (NoSuchElementException e) {
			Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		}
	}
	
	
	/*
	validate the working of copy icon in the address book
	*/
	@Test(priority = 23)
	public void To_validate_the_working_of_copy_icon_in_address_book () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.click_CopyOrSend_Of_FirstAddress();
		try {
		Assert.assertEquals(Toast(),"Copied to clipboard");
		}
		catch (StaleElementReferenceException e) {
			walletsettingspage.click_CopyOrSend_Of_FirstAddress();
			Assert.assertEquals(Toast(),"Copied to clipboard");
		}
		catch (NoSuchElementException e) {
			walletsettingspage.click_CopyOrSend_Of_FirstAddress();
			Assert.assertEquals(Toast(),"Copied to clipboard");
		}
	
	}
	
	
	/*
	validate the working of the search option with invalid contact name
	*/
	@Test(priority = 24)
	public void To_validate_the_working_of_search_option_with_Invalid_contactName () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.Enter_values_In_Search_TextBox("*1234@#45");
	//	Assert.assertEquals(walletsettingspage.Element_No_Contacts(),"No Contacts");
		walletsettingspage.clear_search_textbox();
	}
	
	
	/*
	validate whether able to paste the contact name in search text box
	*/
	@Test(priority = 25)
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
	@Test(priority = 26)
	public void To_validate_the_working_of_cancel_icon_inside_the_search_textbox () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddressBook_screen_title(), "Address Book");
		walletsettingspage.paste_Values_In_Searchtextbox("check");
		walletsettingspage.click_closeIcon_In_searchtextbox();
		Assert.assertEquals(walletsettingspage.get_values_In_searchTextBox(),"");
	}
	
	
		
	
}
