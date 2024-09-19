package Bchat.TestScenarios;

import java.awt.image.BufferedImage;
import java.io.File;
import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.google.common.collect.ImmutableMap;

import POM.CreatePasswordPage;
import POM.HomePage;
import POM.MenuPage;
import POM.RecoveryPhrasePage;
import POM.RestoreFromSeedPage;
import POM.SeedPage;
import Utiles.baseClass;
import io.appium.java_client.remote.MobilePlatform;

public class demo extends baseClass {

	CreatePasswordPage createpasswordpage;
	RecoveryPhrasePage recoveryphrasepage;
	HomePage homepage;
	SeedPage seedpage;
    RestoreFromSeedPage restorefromseedpage;
	MenuPage menupage;
	WebDriverWait wait;
	
   
	@Test
	public void check() throws InterruptedException {
		 // Get the color property
		
	//landingpage.clickTermsAndConditions();
	
		

		   landingpage.clickTermsAndConditions();
		  
		
 
		
		
	}
}
	  
	
//		  public static void main(String[] args) {
//		  String s = "3,056,0280 Blocks remaining";
//		  System.out.println(s);
//		 
//		  String s1 =s.replaceAll(",", "").substring(0, 7).trim();
//		  System.out.println(s1.trim());
//             int no=Integer.parseInt(s1.trim());  
//		 System.out.println(no); 
//	   }
		  
	  
	

