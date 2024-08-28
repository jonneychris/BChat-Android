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
import POM.RecoveryPhrasePage;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import POM.WalletPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class Nodes_And_AddNode_Screen_And_its_Functionalities extends baseClass{
	
	
	
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
	 PreSetup to wallet Settings page 
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
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Wallet();
    	createpasswordpage.setValidPassword();
    	createpasswordpage.clickOk();
	    Assert.assertEquals(mywalletpage.MyWalletScreenTitle(), "My Wallet");
	    mywalletpage.click_WalletSettings_Option();
	}
	
	/*
	 Validate the navigation into and out from node screen
	 */
	@Test(priority = 1)
	public void To_Validate_the_navigation_into_and_out_from_node_screen () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_Back_Arrow();
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
	}
	
	/*
	Validate whether able to switch to the available nodes.
	*/
	@Test(priority = 2)
	public void To_Validate_whether_able_to_switch_to_available_nodes () {
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
	@Test(priority = 3)
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
	 Validate the working of the cancel button in all popup
	 */
	@Test(priority = 4)
	public void To_Validate_the_working_of_the_cancel_button_in_all_popup () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
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
	 Validate the working of Refresh Node
	 */
	@Test(priority = 5)
	public void To_Validate_the_working_of_Refresh_Node () throws InterruptedException {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_Back_Arrow();
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
		
		
	}
	
	/*
	Validate the working of the Test node without entering a value in both Node Address and Node port.
	*/
	@Test(priority = 6)
	public void To_Validate_the_working_of_Test_node_without_entering_value_in_both_Node_Address_and_Node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.walletSettings_screen_Title(), "Wallet settings");
		walletsettingspage.click_Current_Node();
		Assert.assertEquals(walletsettingspage.Nodes_Screen_title(),"Nodes");
		walletsettingspage.click_AddNode();
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.error_Msg(),"we need this");
	}
	
	
	/*
	Validate the working of the test node with Invalid Node Address and Invalid Node port
	*/
	@Test(priority = 7)
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
	@Test(priority = 8)
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
	@Test(priority = 9)
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
	@Test(priority = 10)
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
	@Test(priority = 11)
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
	@Test(priority = 12)
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
	@Test(priority = 13)
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
	@Test(priority = 14)
	public void To_Validate_whether_able_to_Add_Node_without_Internet_connection () {
		
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
		walletsettingspage.clear_TextBoxes();
	}
	
	/*
	 Validate Whether able to paste Characters values in node port
	 */
	@Test(priority = 15)
	public void To_Validate_Whether_able_to_paste_Characters_values_in_node_port () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.Enter_NodeAddress("publicnode1.rpcnode.stream");
		walletsettingspage.paste_Values_In_NodePort();
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"cannot resolve host");
		walletsettingspage.clear_TextBoxes();
		
	}
	
	
	/*
	 Validate whether able to paste values in the text box fields
	 */
	@Test(priority = 16)
	public void To_Validate_whether_able_to_paste_values_in_the_text_box_fields () {
		walletsettingspage = new WalletSettingsPage(driver);
		Assert.assertEquals(walletsettingspage.AddNode_Screen_Title(), "Add Node");
		walletsettingspage.paste_values_In_All_TextBox_Fields();
		walletsettingspage.click_Test();
		Assert.assertEquals(walletsettingspage.Success_Msg(),"Success");
		walletsettingspage.clear_TextBoxes();
		
	}
	

}
