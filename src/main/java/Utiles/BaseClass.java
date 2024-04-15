package Utiles;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import POM.openingPage;
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



public class BaseClass  {


	public AndroidDriver driver;
	
	public AppiumDriverLocalService service ;
	 
	@BeforeClass
	public void openApp() throws MalformedURLException {
//		  service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//itsup//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723)
//	  .build();
//		 service.start();
		    
		 //   String path = System.getProperty("user.dir")+"\\reports\\index.html";
		 
		 //cap.setBrowserName(System.getProperty("user.dir")+"//Resources//General-Store.apk");
		    
			 UiAutomator2Options options = new UiAutomator2Options();
			 //DesiredCapabilities cap = new DesiredCapabilities();
			 //options.setCapability("deviceName", "one plus nord ce 3");		 
			 //options.setCapability("udid", "d6a08b3e");
			 //options.setCapability("platformName","Android");
			 //options.setCapability("platformVersion","13");
             //options.setApp(System.getProperty("user.dir")+"\\resources\\Bchat-2.5.0-armeabi-v7a.apk");
			
				
			 
			// options.setCapability("app","C:\\Users\\itsup\\Downloads\\screensecuritydisabled (1).apk");
			 //URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			 options.setCapability("appPackage", "io.beldex.bchat");
			 options.setCapability("appActivity", "com.thoughtcrimes.securesms.onboarding.LandingActivity");
			 options.setCapability("ignoreHiddenApiPolicyError" , true);
		
			 options.setDeviceName("device");
		
			
			 //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			 driver = new AndroidDriver( new URL("http://127.0.0.1:4723"), options);
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		    // driver.findElement(By.id("android:id/button1")).click();
			 //driver.findElement(MobileBy.id("com.android.permissioncontroller:id/permission_deny_button")).click();     
           
	}
//	@BeforeMethod
//public void preSetup() {
//		
//		 
//	
//		// options.setCapability("appPackage", "com.google.android.permissioncontroller");
//		 //options.setCapability("appActivity", "com.android.permissioncontroller.permission.ui.GrantPermissionsActivity");
//		 driver.findElement(By.id("android:id/button1")).click();
//		 openingPage openingpage = new openingPage(driver);
//			openingpage.clickAllow();
//			//com.google.android.permissioncontroller
//	}
	
	

	
	
	@AfterClass
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
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
	return toastmsg;
	
	
}

}




