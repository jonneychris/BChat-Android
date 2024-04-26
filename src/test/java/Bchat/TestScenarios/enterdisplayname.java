package Bchat.TestScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DisplayNamePage;
import POM.RegisterPage;
import Utiles.baseClass;

public class enterdisplayname extends baseClass{
@Test
public void setdisplayname() throws InterruptedException {
	openingpage.clickCreateAccount();
	DisplayNamePage displaynamepage =new DisplayNamePage(driver);
	displaynamepage.setDisplayName("Aravind");
	displaynamepage.clickContinue();
	Thread.sleep(30000);
   RegisterPage	registerpage = new RegisterPage(driver);
	 if(registerpage.pageTitle()=="Register") {
		   driver.navigate().back();
	   }
    displaynamepage.cleardisplayname();
	Thread.sleep(5000);
}
}
