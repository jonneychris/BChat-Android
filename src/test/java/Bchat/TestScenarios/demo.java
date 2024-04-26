package Bchat.TestScenarios;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.CreatePasswordPage;
import POM.DisplayNamePage;
import POM.RegisterPage;
import Utiles.baseClass;


public class demo extends baseClass{

	DisplayNamePage d;
	RegisterPage r;
	CreatePasswordPage c;
	@BeforeTest
	public void openapplandingpage() throws InterruptedException {
		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
	landingpage.clickCreateAccount();
	d = new DisplayNamePage(driver);
	d.setDisplayName("Chris");
	d.clickContinue();
	Thread.sleep(2000);
	r= new RegisterPage(driver);
	r.clickNext();
	
	}
	
	
}
