package Bchat.TestScenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



import Utiles.baseClass;
import POM.openingPage;

public class demo extends baseClass{

	@Test
	public void openapplandingpage() throws InterruptedException {
		// driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		openingPage openingpage = new openingPage(driver);
		driver.navigate().back();
		openingpage.openApp();
		Thread.sleep(5000);
	}
	
	
}
