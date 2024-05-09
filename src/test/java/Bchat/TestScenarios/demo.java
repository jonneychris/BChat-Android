package Bchat.TestScenarios;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.RegisterPage;
import POM.RestoreFromSeedPage;
import POM.SeedPage;
import Utiles.baseClass;


public class demo extends baseClass{

	RestoreFromSeedPage restorefromseedpage;
	SeedPage seedpage;
	
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
	
	
	@Test(priority = 0)
	public void method1() {
		System.out.println("test case 1");
	}
	
	@Test(priority = 1)
	public void method2() {
		System.out.println("test case 2");
	}
	
	
	}
	
	

