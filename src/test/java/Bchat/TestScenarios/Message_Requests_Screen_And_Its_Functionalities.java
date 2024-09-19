package Bchat.TestScenarios;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.AccountSettingsPage;
import POM.BlockedContactsPage;
import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.MenuPage;
import POM.MessageRequestPage;
import POM.NewChatPage;
import POM.ChatPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeedPage;

import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class Message_Requests_Screen_And_Its_Functionalities extends baseClass{

	CreatePasswordPage createpasswordpage;
	
	HomePage homepage;
	RecoverySeedPage recoveryseedpage ;
	
    RegisterPage registerpage;
	MenuPage menupage;
	SeedPage seedpage;
	WebDriverWait wait;
	MessageRequestPage messagerequestpage;
	RestoreFromSeedPage restorefromseedpage;
	ChatPage chatpage ;
	AccountSettingsPage accountsettingspage;
	BlockedContactsPage blockedContactsPage;
	
	/*
	 pre Setup to message request screen
	 */
	@Test(priority = 0)
	public void preSetup () throws InterruptedException {
		
		
		
		
		landingpage.clickSignIn();
		seedpage = new SeedPage(driver);
		seedpage.setSeedValue("else vaults hitched impel acidic afield woken yesterday casket adrenalin boldly unsafe fowls smash itches omnibus lagoon legion badge fictional pirate scamper tilt uptight badge");
		seedpage.clickNext();
		restorefromseedpage = new RestoreFromSeedPage(driver);
		restorefromseedpage.setDisplayName("Test");
		restorefromseedpage.selectTodayDate();
		restorefromseedpage.clickBtnRestore();
		createpasswordpage = new CreatePasswordPage(driver);
		Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
		createpasswordpage.setValidPassword();
		Thread.sleep(1000);
		createpasswordpage.clickOk();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_option_Message_requests();
	}

		
	
	/*
	 Validate whether able to navigate out of the screen
	 */
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_out_of_screen () {
		messagerequestpage = new MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		messagerequestpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
	}
	/*
	Validate whether Message requests recevied from others is showing.
	*/
	@Test(priority = 2)
	public void To_Validate_whether_Message_requests_recevied_from_others_is_showing() {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
	    menupage =new MenuPage(driver);
		menupage.click_option_Message_requests();
		messagerequestpage = new MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		try {
			wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.invisibilityOf(messagerequestpage.Empty_screen()));
						
		}
		catch(NoSuchElementException e){
			Assert.assertTrue(messagerequestpage.Element_Of_First_Received_Request().isDisplayed());
		}

	}

	/*
	Validate the working of the cancel button in all popup screen
	*/
	@Test(priority = 3)
	public void To_Validate_the_working_of_cancel_button_in_all_popup_screen () {
		messagerequestpage = new MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		messagerequestpage.Click_Block_option();
		Assert.assertEquals(messagerequestpage.PopupTilte(), "Message Request");
		messagerequestpage.click_cancel();
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		messagerequestpage.Click_Delete_option();
		Assert.assertEquals(messagerequestpage.PopupTilte(), "Message Request");
		messagerequestpage.click_cancel();
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");

	}
	
	/*
	Validate working of the Accept in  the Message Request
	*/
	@Test(priority = 4)
	public void To_Validate_working_of_Accept_in_Message_Request () {
		messagerequestpage = new MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		String IdorName =messagerequestpage.Element_Of_First_Received_Request().getText();
		messagerequestpage.Accept_First_Request_In_List();
		chatpage = new ChatPage(driver);
		chatpage.click_Accept();
		driver.navigate().back();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		Assert.assertEquals(homepage.get_DisplayName_Or_Id_Of_ChatItem(),IdorName);
		
	}
	
	/*
	Validate the working of the Block in the Message request
	*/
	@Test(priority = 5)
	public void To_Validate_the_working_of_Block_in_Message_request () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new  MenuPage(driver);
		menupage.click_option_Message_requests();
		messagerequestpage = new  MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		String IdorName =messagerequestpage.Element_Of_First_Received_Request().getText();
		messagerequestpage.Block_First_request_In_List();
		messagerequestpage.click_Back_Arrow();
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new  MenuPage(driver);
		Assert.assertEquals(menupage.pagetitle(),"Menu");
		menupage.click_Account_Settings();
		accountsettingspage = new AccountSettingsPage(driver);
		Assert.assertEquals(accountsettingspage.pageTitle(),"Account Settings");
		accountsettingspage.click_Blocked_contact_Option();
		blockedContactsPage = new BlockedContactsPage(driver);
		Assert.assertEquals(blockedContactsPage.pageTitle(),"Blocked Contacts");
		Assert.assertEquals(blockedContactsPage.get_Blocked_Contact_Id_Or_Name(),IdorName);
		blockedContactsPage.click_Back_Arrow();
		driver.navigate().back();
	}
	
	/*
	Validate working of the Delete in the Message request.
	*/
	@Test(priority = 6)
	public void To_Validate_working_of_the_Delete_in_Message_request () {
		homepage = new HomePage(driver);
		Assert.assertEquals(homepage.Pagetitle(),"BChat");
		homepage.clickMenuDrawer();
		menupage = new  MenuPage(driver);
		menupage.click_option_Message_requests();
		messagerequestpage = new  MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		messagerequestpage.Delete_First_Request_in_list();
		Assert.assertTrue(messagerequestpage.Empty_screen().isDisplayed());
		
	}
	
	
	/*
	 Validate Message Requests Screen without any message request.
	 */
	@Test(priority = 7)
	public void To_Validate_Message_Requests_Screen_without_any_message_request () {
		
		messagerequestpage = new MessageRequestPage(driver);
		Assert.assertEquals(messagerequestpage.pageTitle(),"Message Requests");
		Assert.assertTrue(messagerequestpage.Empty_screen().isDisplayed());
	}
	

}
