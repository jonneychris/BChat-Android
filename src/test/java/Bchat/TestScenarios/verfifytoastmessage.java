package Bchat.TestScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DisplayNamePage;
import POM.RegisterPage;
import Utiles.baseClass;

public class verfifytoastmessage extends baseClass{
	
	
	RegisterPage registerpage;
	DisplayNamePage displaynamepage;
	@Test
	public void verifyToast() throws InterruptedException {
	
		landingpage.clickCreateAccount();
		Thread.sleep(3000);
		
		try{
			displaynamepage = new DisplayNamePage(driver);
			displaynamepage.clickTextBox();
			displaynamepage.setDisplayName("!@D^&8Dr");
			driver.findElement(By.id("io.beldex.bchat:id/registerButton")).click();
			registerpage =	new RegisterPage(driver);
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(registerpage.textPageTitle));
		    Assert.assertEquals(registerpage.pageTitle(), "Register");
		}
		catch(AssertionError e) {
			System.out.println(Toast());
			Assert.assertEquals(Toast(),"Please enter a valid name");
			
		}
		
		catch(Throwable e) {
			e.printStackTrace();
			
		}
		
		
	 
		
	}

}
