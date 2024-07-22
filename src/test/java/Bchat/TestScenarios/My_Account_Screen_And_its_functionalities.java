package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
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
import POM.MyAccountPage;
import POM.NewChatPage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.SecretGroupPage;
import POM.SocialGroupPage;
import Utiles.baseClass;

public class My_Account_Screen_And_its_functionalities extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	SocialGroupPage socialgrouppage;
	NewChatPage newchatpage;
	SecretGroupPage secretgrouppage;
	WebDriverWait wait;
	MenuPage menupage;
	MyAccountPage myaccountpage ;
	
	@Test(priority = 0)
   public void presetup () throws InterruptedException{
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
		menupage = new MenuPage(driver);
		menupage.click_My_Account_option();
        }
	
	   /*
		Validate whether able to copy the Bchat Id and beldex Address
		*/
	@Test(priority =1)
	public void To_validate_whether_Able_to_Copy_Bchat_ID_and_Beldex_Address () {
		
		   myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
	  try {
	      myaccountpage.click("BchatId");
		  Assert.assertEquals(Toast(), "Copied to clip board");	  
	  }
	  catch (StaleElementReferenceException e) {
		  myaccountpage.click("BchatId");
		  Assert.assertEquals(Toast(), "Copied to clip board");	
	}
	  catch (NoSuchElementException e) {
		  myaccountpage.click("BchatId");
		  Assert.assertEquals(Toast(), "Copied to clip board");	
	}
	  try {
	  myaccountpage.click("BeldexAddress");
		  Assert.assertEquals(Toast(), "Copied to clip board");
	  }
	  catch (StaleElementReferenceException e) {
		  myaccountpage.click("BeldexAddress");
		  Assert.assertEquals(Toast(), "Copied to clip board");
	}
	  catch (NoSuchElementException e) {
		  myaccountpage.click("BeldexAddress");
		  Assert.assertEquals(Toast(), "Copied to clip board");
	}
	}
	
	/*
	 Validate whether able to change the profile name.
	 */
	@Test(priority =2 )
	public void To_Validate_Whether_Able_to_Change_the_profile_name () {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		 myaccountpage.EditDisplayName("John");
		 myaccountpage.click_tick_inDisplayName();
		 driver.navigate().back();
		 homepage = new HomePage(driver);
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
		 homepage.clickMenuDrawer();
		 menupage = new MenuPage(driver);
		 Assert.assertEquals(menupage.getProfileName(),"John");
		 menupage.click_My_Account_option();
	}
	 
	 
	 
	 
	/* 
	Validate whether able to change the profile name multiple times.
	*/
	@Test(priority =3)
	public void To_Validate_Whether_Able_to_change_Profile_Name_Multiple_times () {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		 myaccountpage.EditDisplayName("Abcd");
		  myaccountpage.click_tick_inDisplayName();
		  driver.navigate().back();
		  homepage = new HomePage(driver);
		  Assert.assertEquals(homepage.Pagetitle(),"BChat");
		  homepage.clickMenuDrawer();
		  menupage = new MenuPage(driver);
		  Assert.assertEquals(menupage.getProfileName(),"Abcd");
		  menupage.click_My_Account_option();
		  
		 myaccountpage.EditDisplayName("1234");
		 myaccountpage.click_tick_inDisplayName();
		 driver.navigate().back();
		 homepage = new HomePage(driver);
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
		 homepage.clickMenuDrawer();
		 menupage = new MenuPage(driver);
		 Assert.assertEquals(menupage.getProfileName(),"1234");
		 menupage.click_My_Account_option();
		
		 myaccountpage.EditDisplayName("xyzz");
		 myaccountpage.click_tick_inDisplayName();
		 driver.navigate().back();
		 homepage = new HomePage(driver);
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
		 homepage.clickMenuDrawer();
		 menupage = new MenuPage(driver);
		 Assert.assertEquals(menupage.getProfileName(),"xyzz");
		 menupage.click_My_Account_option();
	}
	
	
	
	
	/*
	Validate the working of the share button QR code Functionality.
    */
	@Test(priority =4)
	public void To_Validate_Working_of_Share_Button () {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.scroll_the_page(200, 600, 50, "down");
		  myaccountpage.ClickshareButton();
		  Assert.assertTrue(myaccountpage.shareScreenTitle().equals("1 image in total"));
		  myaccountpage.clickcancel_In_share_Screen();
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
	}
	
	
	
	/*
	Validate the navigation to home screen in both forward and backward direction.
	*/
	@Test(priority = 5)
	public void	To_Validate_the_navigation_to_home_screen () {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.clickBackArrow();
		  homepage = new HomePage(driver);
			Assert.assertEquals(homepage.Pagetitle(),"BChat");
			homepage.clickMenuDrawer();
			menupage = new MenuPage(driver);
			menupage.click_My_Account_option();
			  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
	}
	
	
	/*
	 Validate whether profile photo functionality is enable.
	 */
	@Test(priority =6)
	public void To_Validate_whether_profile_photo_functionality_is_enable () {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.clickProfileIcon();
		 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");		  
		  myaccountpage.clickcancel_In_ProfilePicture_Screen();
		 
		 
	}
	
	/*
	 Validate whether remove picture button in profile popup is not clickable when there is no profile picture
	 */
	@Test(priority = 7)
	public void To_Validate_whether_remove_picture_button_not_clickable_when_there_is_no_profile_picture () {
		myaccountpage =new  MyAccountPage(driver);
		Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.clickProfileIcon();
		  
				 myaccountpage.clickRemovePicture();
				 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
		  myaccountpage.clickcancel_In_ProfilePicture_Screen();
	}
	
	/*
	 	Validate whether able to upload picture from gallery option of the device.
	 */
	@Test(priority = 8)
	public void To_Validate_whether_able_to_upload_picture_from_gallery_option_in_device () throws InterruptedException {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.clickProfileIcon();
		 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
		 myaccountpage.Set_Profile_Picture_from_Gallery();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(myaccountpage.Loading_Animation()));
		 myaccountpage.clickProfileIcon();
		 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
		 myaccountpage.clickRemovePicture();
	}
	
	
	
	
		  
	/*
	Validate whether able to upload picture using camera option of the device.
	*/
	@Test(priority = 9)
	public void To_Validate_whether_able_to_upload_picture_using_camera_option_of_the_device () throws InterruptedException {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.clickProfileIcon();
		 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
		 myaccountpage.Set_Profile_Picture_from_Camera();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOf(myaccountpage.Loading_Animation()));
		 myaccountpage.clickProfileIcon();
		 myaccountpage.clickRemovePicture();
		 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
	}
	
	
	/*
	Validate whether able to remove the uploaded profile photo.
	*/
	@Test(priority = 10)
	public void To_Validate_whether_able_to_remove_the_uploaded_profile_photo () throws InterruptedException {
		myaccountpage =new  MyAccountPage(driver);
		  Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		  myaccountpage.clickProfileIcon();
		 Assert.assertEquals(myaccountpage.profilePictureScreentitle(), "Profile Picture");	
		 myaccountpage.Set_Profile_Picture_from_Gallery();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOf(myaccountpage.Loading_Animation()));
		 myaccountpage.clickProfileIcon();
		 myaccountpage.clickRemovePicture();
		 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");

	}
	
	
	
	/*
	Validate the working of the upload profile photo without internet
	Validate Whether Able to Edit display Name without internet
	*/
	@Test(priority = 11)
	public void Validate_the_working_of_upload_profile_photo_and_Edit_Display_Name_without_internet () {
		myaccountpage =new  MyAccountPage(driver);
		 Assert.assertEquals(myaccountpage.pagetitle(),"My Account");
		
		turnOff_Mobile_Wifi();	
		myaccountpage.EditDisplayName("New"); 
		myaccountpage.click_tick_inDisplayName();
		 driver.navigate().back();
		 homepage = new HomePage(driver);
		 Assert.assertEquals(homepage.Pagetitle(),"BChat");
		 homepage.clickMenuDrawer();
		 menupage = new MenuPage(driver);
		 Assert.assertEquals(menupage.getProfileName(),"New");
		 menupage.click_My_Account_option();
		myaccountpage.clickProfileIcon();
		myaccountpage.clickUpload();
		Assert.assertEquals(Toast(),"Please check your internet connection");
		turnOn_Mobile_Wifi();
	}
	 
	

	
	
}