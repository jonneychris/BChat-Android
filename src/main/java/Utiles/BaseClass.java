package Utiles;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import POM.LandingPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;



public class baseClass  {


	public AndroidDriver driver;
	
	public AppiumDriverLocalService service ;
	
	 public LandingPage landingpage;
	 
	
	
	@BeforeClass(alwaysRun = true)
	public void openApp() throws InterruptedException, IOException {
//		  service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//itsup//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723)
//	  .build();
//		 service.start();
		    
		 //   String path = System.getProperty("user.dir")+"\\reports\\index.html";
		 
		 //cap.setBrowserName(System.getProperty("user.dir")+"//Resources//General-Store.apk");
		try {
			UiAutomator2Options options = new UiAutomator2Options();
		
			options.setCapability("automationName", "UiAutomator2");	
			 options.setCapability("deviceName", "one plus nord ce 3");		 
			 options.setCapability("platformName","Android");
			 options.setCapability("platformVersion","13");
			 options.setCapability("udid", "d6a08b3e");
			// options.setCapability(MobileCapabilityType.NO_RESET, "true");
			// options.setCapability("noReset", "true");
			 options.setCapability("ignoreHiddenApiPolicyError", true);
			 options.setCapability("appium:fullReset",true);
			 options.setCapability("autoGrantPermissions", true);
			options.setApp(System.getProperty("user.dir")+"\\resources\\Bchat-2.5.0-arm64-v8a-18-07-2024-Mainnet-Apk (1).apk");
			
		  	 options.setCapability("appPackage", "io.beldex.bchat");	
			 //For To wait until the landing screen activity comes 
			 options.setCapability("appWaitActivity", "com.thoughtcrimes.securesms.onboarding.LandingActivity"); 
			 //options.setCapability("autoLaunch", true);
		
			// driver = new AndroidDriver(new URL(null), options);
			 driver = new AndroidDriver( new URL("http://127.0.0.1:4723"), options);
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				  
					landingpage =new LandingPage(driver);
		}
				 
		catch(Exception E) {
			try {
				UiAutomator2Options options = new UiAutomator2Options();
				
				options.setCapability("automationName", "UiAutomator2");	
				 options.setCapability("deviceName", "one plus nord ce 3");		 
				 options.setCapability("platformName","Android");
				 options.setCapability("platformVersion","13");
				 options.setCapability("udid", "d6a08b3e");
				// options.setCapability(MobileCapabilityType.NO_RESET, "true");
				// options.setCap ability("noReset", "true");
				 options.setCapability("ignoreHiddenApiPolicyError", true);
				 options.setCapability("appium:fullReset",true);
				 options.setCapability("autoGrantPermissions", true);
				options.setApp(System.getProperty("user.dir")+"\\resources\\Bchat-2.5.0-arm64-v8a-16-04-2024.apk");
				
			  	 options.setCapability("appPackage", "io.beldex.bchat");	
				 //For To wait until the landing screen activity comes 
				 options.setCapability("appWaitActivity", "com.thoughtcrimes.securesms.onboarding.LandingActivity"); 
				 //options.setCapability("autoLaunch", true);
					
				 
				 driver = new AndroidDriver( new URL("http://127.0.0.1:4723"), options);
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						landingpage =new LandingPage(driver);
					  
			}
			catch(Exception E1) {
				E1.printStackTrace();
			}		    
		}
		
	}
	
	
	@AfterClass(alwaysRun = true)
 public void closeApp() {
		
		
		driver.quit();
		
		//service.stop();
 }
	
public List<HashMap<String ,String>> getjsonFile(String filepath) throws IOException {
		//Json file to json string
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+filepath),StandardCharsets.UTF_8);
		
		//json string to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap<String,String>> data= mapper.readValue(jsoncontent, new TypeReference <List<HashMap<String,String>>> (){
			
		});
		
		return data;
		
	}

public String Toast() {
	
	String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	return toastmsg;
	
	
}

public void turnOff_Mobile_Wifi () {
	
	 driver.openNotifications();
	driver.findElement(By.id("com.android.systemui:id/hl_tile_one_holder")).click();
	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "left", 350, "top", 2345, "width", 100, "height", 1345,
		    "direction", "Up",
		    "percent", 0.75
		));
}

public void turnOn_Mobile_Wifi () {
	
	 driver.openNotifications();
	driver.findElement(By.id("com.android.systemui:id/hl_tile_one_holder")).click();
	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "left", 350, "top", 2345, "width", 100, "height", 1345,
		    "direction", "Up",
		    "percent", 0.75
		));
}
}




