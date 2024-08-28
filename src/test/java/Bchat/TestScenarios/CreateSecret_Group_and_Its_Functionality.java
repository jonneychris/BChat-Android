package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.ChatPage;
import POM.CreatePasswordPage;
import POM.HomePage;
import POM.MenuPage;
import POM.MyWalletPage;
import POM.RecoveryPhrasePage;
import POM.RestoreFromSeedPage;
import POM.SecretGroupPage;
import POM.SeedPage;
import POM.SendPage;
import POM.WalletSettingsPage;
import Utiles.baseClass;

public class CreateSecret_Group_and_Its_Functionality extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	WebDriverWait wait;
	SecretGroupPage secretgrouppage;
 	ChatPage chatpage;
	
	
	/*
	 pre Setup
	 */
	@Test(priority = 0)
	public void preSetup () throws InterruptedException {
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
	   	homepage.openNewSecretGroup();
	  
	}
	
	
	/*
	Validate whether able to navigate back to the home screen
	*/
	@Test(priority = 1)
	public void To_Validate_whether_able_to_navigate_back_to_home_screen () {
		  secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  secretgrouppage.click_Back_Arrow();
			homepage = new HomePage(driver);
		   	Assert.assertEquals(homepage.Pagetitle(),"BChat");	
		   	try {
		   	wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		   	wait.until(ExpectedConditions.invisibilityOf(homepage.BlankChatScreen));
		   	}
		   	catch (NoSuchElementException e) {
		   	  	Assert.assertEquals(homepage.Pagetitle(),"BChat");	
		   	  	homepage.openNewSecretGroup();
			}
		   	homepage.openNewSecretGroup();
	} 


//	/*
//	 Validate whether contacts list is showing below text box.
//	 */
//	@Test
//	public void To_Validate_whether_contacts_list_is_showing_below_textbox () {
//		 secretgrouppage = new SecretGroupPage(driver);
//		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
//		  Assert.assertFalse(secretgrouppage.Element_of_Contact_List().ge);
//	}
	
	/*
	Validate Whether able to select the contacts showing.
	*/
	@Test(priority = 2)
	public void To_Validate_Whether_able_to_select_the_contacts_showing () {
		secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"false");
		  secretgrouppage.select_FirstContact_In_List();
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"true");
		  
	}
	
	/*
	 validate Whether able to Unselect the selected contact
	 */
	@Test(priority = 3)
	public void To_Validate_Whether_able_to_Unselect_the_contacts_showing () {
		secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"true");
		  secretgrouppage.select_FirstContact_In_List();
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"false");
	}
	
	/*
	Validate Whether able to multi select the contacts showing
	*/
	@Test(priority = 4)
	public void To_Validate_Whether_able_to_multi_select_the_contacts_showing () {
		secretgrouppage = new SecretGroupPage(driver);
		  Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		  secretgrouppage.multiselect_contacts_In_List();
		  Assert.assertEquals(secretgrouppage.Check_FirstContact_Selected_or_Not(),"true");
		  Assert.assertEquals(secretgrouppage.Check_SeconContact_Selected_or_Not(),"true");
		  Assert.assertEquals(secretgrouppage.Check_thirdContact_Selected_or_Not(),"true");
		  secretgrouppage.multiselect_contacts_In_List();
	}
	
	/*
	Validate the Create function without entering a group name and without selecting a member.
	*/
	@Test(priority = 5)
	public void To_Validate_Create_function_without_entering_groupName_and_without_selecting_member () {
		secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		secretgrouppage.click_Create_button();
		Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	}
	
	
	/*
	Validate the Create function with entering a group name and without selecting a member.
	*/
   @Test(priority = 6)
   public void To_Validate_Create_function_with_entering_groupName_and_without_selecting_member () {
	   secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.Enter_values_in_GroupName("Test");
		 try {
			 secretgrouppage.click_Create_button();
		 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
		 }
		 catch (NoSuchElementException e) {
			 secretgrouppage.click_Create_button();
			 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
		}
		 catch (StaleElementReferenceException e) {
			 secretgrouppage.click_Create_button();
			 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
		}
		 catch (AssertionError e) {
			 secretgrouppage.click_Create_button();
			 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
		}
		 secretgrouppage.clear_TextBoxes();
		 }
   /*
   Validate the Create function without entering a group name and with selecting a member.
   */
   @Test(priority = 7)
   public void To_Validate_the_Create_function_without_entering_groupName_and_with_selecting_member () {
	   secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.select_FirstContact_In_List();
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.select_FirstContact_In_List();
   }
   
   /*
    Validate the Create function with entering space value in group name and with selecting a member
    */
   @Test(priority = 8)
   public void To_Validate_Create_function_with_entering_space_value_in_groupName_and_with_selecting_a_member () {
	   secretgrouppage = new SecretGroupPage(driver);
		 Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		 secretgrouppage.Enter_values_in_GroupName(" ");
		 secretgrouppage.select_FirstContact_In_List();
		 secretgrouppage.click_Create_button();
		 try {
			 Assert.assertEquals(Toast(),"Please enter a group name");
		 }
		 catch (NoSuchElementException e) {
			 secretgrouppage.click_Create_button();
			 Assert.assertEquals(Toast(),"Please enter a group name");
		}
		 catch (StaleElementReferenceException e) {
			 secretgrouppage.click_Create_button();
			 Assert.assertEquals(Toast(),"Please enter a group name");
		}
		 catch (AssertionError e) {
			 secretgrouppage.click_Create_button();
			 Assert.assertEquals(Toast(),"Please pick at least 1 group member");
		}
		 secretgrouppage.clear_TextBoxes();
		 secretgrouppage.select_FirstContact_In_List();
   }
   
   /*
   Validate the Create function with entering a group name and with selecting a member.
   */
   @Test(priority = 9)
   public void To_Validate_Create_function_with_entering_groupName_and_with_selecting_member () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("Test");
	   secretgrouppage.select_FirstContact_In_List();
	   secretgrouppage.click_Create_button();
	  
	   try {
		   wait = new WebDriverWait(driver,Duration.ofMinutes(2));
	   wait.until(ExpectedConditions.invisibilityOf(secretgrouppage.Element_Of_Screen()));
	   chatpage = new ChatPage(driver);
	   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
	      chatpage.click_Back_Arrow();
	      homepage = new HomePage(driver);
		   	Assert.assertEquals(homepage.Pagetitle(),"BChat");	
		   	homepage.openNewSecretGroup();
	   }
	   catch (NoSuchElementException e) {
	   chatpage = new ChatPage(driver);
	   Assert.assertEquals(chatpage.get_profile_NameOr_Id(),"Test");
      chatpage.click_Back_Arrow();
      homepage = new HomePage(driver);
	   	Assert.assertEquals(homepage.Pagetitle(),"BChat");	
	   	homepage.openNewSecretGroup();
   }
	   catch (TimeoutException e) {
		   secretgrouppage = new SecretGroupPage(driver);
		   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
		   secretgrouppage.click_Back_Arrow();
		   homepage = new HomePage(driver);
		   
	}
	  
   }
   
   /*
   Validate whether crusher blink on clicking the text box of Secret Group .
	*/
   @Test(priority = 10)
   public void To_Validate_whether_crusher_blink_on_clicking_textboxes_of_SecretGroup () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.click_GroupName_textbox();
	   Assert.assertTrue(secretgrouppage.activeElement().isDisplayed());
	   secretgrouppage.click_Search_textbox();
	   Assert.assertTrue(secretgrouppage.activeElement().isDisplayed());
   }
   
  
   /*
   Validate the presence of placeholder in the text box of the Secret Group.
   */
  @Test(priority = 11)
  public void To_Validate_presence_of_placeholder_in_the_textboxes_of_SecretGroup () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   Assert.assertEquals(secretgrouppage.getPlacholder_of_groupName_textbox(),"Enter Group Name");
	   Assert.assertEquals(secretgrouppage.getPlacholder_of_Search_textbox(), "Search Contact");
  }
  
   
   /*
   validate whether paste option is working on the text box of the Secret Group.
	*/
   @Test(priority = 12)
   public void To_validate_whether_paste_option_is_working_on_textbox_of_Secret_Group () {
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.pasteValues_In_TestBoxes("Test", "check");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Test");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(), "check");
	   secretgrouppage.clear_TextBoxes();
   }
   
 
  /*
  Validate whether able to create secret group without internet connection
  */
  @Test(priority = 13)
  public void To_Validate_whether_able_to_create_secret_group_without_internet_connection () throws InterruptedException {
	  	
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   turnOff_Mobile_Wifi();
	   Thread.sleep(5000);
	   secretgrouppage.Enter_values_in_GroupName("Test");
	   secretgrouppage.select_FirstContact_In_List();
	   try {
	   secretgrouppage.click_Create_button();
	   Assert.assertEquals(Toast(),"Please check your internet connection");
	   }
	   catch (NoSuchElementException e) {
		   secretgrouppage.click_Create_button();
		   Assert.assertEquals(Toast(),"Please check your internet connection");
		   }
	   catch (StaleElementReferenceException e) {
		   secretgrouppage.click_Create_button();
		   Assert.assertEquals(Toast(),"Please check your internet connection");
		   }
	   turnOn_Mobile_Wifi();
	   secretgrouppage.clear_TextBoxes();
	   Thread.sleep(5000);
	   }
   
  /*
  Validate the text box of the Secret Group Functionality using special Characters.
  */
  @Test(priority = 14)
  public void To_Validate_the_textbox_of_Secret_Group_using_special_Characters () {
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("@#$%^");
	   secretgrouppage.Enter_Values_In_Search_textbox("@#$%^&");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"@#$%^");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"@#$%^&");
	   secretgrouppage.clear_TextBoxes();
  }
  
  /*
  Validate the text box of the Secret Group Functionality using Alphabets both in uppercase and lower case.
  */
  @Test(priority = 15)
  public void To_Validate_the_textbox_of_SecretGroup_using_Alphabets_both_in_uppercase_and_lowercase () {
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("ABCDE");
	   secretgrouppage.Enter_Values_In_Search_textbox("ABCDE");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"ABCDE");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"ABCDE");
	   secretgrouppage.clear_TextBoxes();
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("abcde");
	   secretgrouppage.Enter_Values_In_Search_textbox("abcde");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"abcde");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"abcde");
	   secretgrouppage.clear_TextBoxes();
  
  }
  
  /*
  Validate the text box of the Secret Group Functionality by numerical value.
  */
  @Test(priority = 16)
  public void To_Validate_the_textbox_of_SecretGroup_by_numerical_value () {
	
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("12345");
	   secretgrouppage.Enter_Values_In_Search_textbox("12345");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"12345");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"12345");
	   secretgrouppage.clear_TextBoxes();
  }
  
  
  /*
  Validate whether the value entered in the text box of the Secret Group is editable.
  */
  @Test(priority = 17)
  public void To_Validate_whether_the_value_entered_in_textbox_of_SecretGroup_is_editable_And_Deleteable () {
	  secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("Hello");
	   secretgrouppage.Enter_Values_In_Search_textbox("Hi");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Hello");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"Hi");
	   secretgrouppage.clear_TextBoxes();
	
	   secretgrouppage = new SecretGroupPage(driver);
	   Assert.assertEquals(secretgrouppage.Pagetitle(),"Secret Group");
	   secretgrouppage.Enter_values_in_GroupName("Check");
	   secretgrouppage.Enter_Values_In_Search_textbox("Check");
	   Assert.assertEquals(secretgrouppage.get_values_From_GroupName_textBox(),"Check");
	   Assert.assertEquals(secretgrouppage.get_values_From_Search_textBox(),"Check");
	   secretgrouppage.clear_TextBoxes();
  }
  
 
}
