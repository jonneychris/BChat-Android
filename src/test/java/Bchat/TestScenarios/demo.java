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
	@Test
	public void openapplandingpage() throws InterruptedException {
		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		
	landingpage.clickSignIn();
	driver.findElement(By.id("io.beldex.bchat:id/mnemonicEditText")).click();
	driver.findElement(By.id("io.beldex.bchat:id/mnemonicEditText")).sendKeys("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25");
    driver.findElement(By.id("io.beldex.bchat:id/restoreButton")).click();
	System.out.println(Toast());
	}
	
	
}
