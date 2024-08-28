package Bchat.TestScenarios;

import java.awt.image.BufferedImage;
import java.io.File;
import java.security.PublicKey;
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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.google.common.collect.ImmutableMap;

import Utiles.baseClass;
import io.appium.java_client.remote.MobilePlatform;

public class demo extends baseClass {

	
   
	@Test
	public void check() throws InterruptedException {
		 // Get the color property
		
	//landingpage.clickTermsAndConditions();
	
		

       landingpage.clickCreateAccount();
       driver.terminateApp("io.beldex.bchat");
		
       try {
  		 landingpage.openApp();
  		Assert.assertTrue(landingpage.WebElementCreateAccount().isDisplayed());
  		}
  		catch(Exception E) {
  			 landingpage.openApp();
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
		  
	  
	
}
