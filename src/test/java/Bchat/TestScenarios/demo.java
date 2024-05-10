package Bchat.TestScenarios;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.HomePage;
import POM.RecoveryPhrasePage;
import POM.RecoverySeed_Page;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SeedPage;
import Utiles.baseClass;


public class demo extends baseClass{


	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	RecoverySeed_Page recoveryseedpage ;
	DisplayNamePage displaynamepage;
    RegisterPage registerpage;
	WebDriverWait wait;
	
	
	//	public void openapplandingpage() throws InterruptedException {
//		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
//		
//	landingpage.clickSignIn();
//	restorefromseedpage = new RestoreFromSeedPage(driver);
//	seedpage = new  SeedPage(driver);
//	seedpage.pasteSeedValue();
//	seedpage.clickNext();
//	@Test
//	public void TC_To_Validate_whether_able_to_paste_invalid_Values_in_blockheight_textbox (HashMap <String,String > input) {
//		landingpage.clickSignIn();
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//		seedpage = new  SeedPage(driver);
//		seedpage.pasteSeedValue();
//		seedpage.clickNext();
//		restorefromseedpage = new RestoreFromSeedPage(driver);
//	   	Assert.assertTrue(restorefromseedpage.BlockheightTextBox().isDisplayed());
//	   	restorefromseedpage.paste_Value_In_Blockheight(input.get("Blockheight"));
//	   	Assert.assertNull(restorefromseedpage.BlockheightTextBox());
//	}
//	
//	
//	@DataProvider
//	public Object[][] setInValidblockheightdata() throws IOException {
//		
//		List <HashMap <String,String>>data=super.getjsonFile("//Datas//InValid_blockheight_Values.json");
//		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
//		
//	}
	
	@Test
	public void homescreen() {

	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	landingpage.clickCreateAccount();
	displaynamepage =new DisplayNamePage(driver);
	Assert.assertEquals(displaynamepage.pageTitle(),"Display Name");
	displaynamepage.setDisplayName("Chris");
	displaynamepage.clickContinue();
	registerpage= new RegisterPage(driver);
	wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
	Assert.assertEquals(registerpage.pageTitle(),"Register");
	registerpage.clickNext();
	createpasswordpage = new CreatePasswordPage(driver);
	Assert.assertEquals(createpasswordpage.pageTitle(),"Create Password");
	createpasswordpage.setValidPassword();
	recoveryphrasepage =new RecoveryPhrasePage(driver);
	Assert.assertEquals(recoveryphrasepage.pageTitle(), "Recovery Phrase");
	recoveryphrasepage.clickCopyIcon();
	recoveryphrasepage.ClickContinue();
	homepage = new HomePage(driver);
	Assert.assertEquals(homepage.Pagetitle(),"BChat");
	homepage.OpenNewChat();
	}
	}
	
	

