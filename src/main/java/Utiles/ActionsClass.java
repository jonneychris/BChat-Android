package Utiles;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.options.UiAutomator2Options;

public abstract class ActionsClass {
	
	AndroidDriver driver;
	public ActionsClass(AndroidDriver driver) {
		
		this.driver=driver;
	}

	
	public void scrollgesture(String country) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));")).click();;	
	}
 
	public void click(WebElement button) {
		button.click();
	}
	
	public void longPress(WebElement Element) {
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId", ((RemoteWebElement) Element).getId(),
					"duration",10000));
			}

	public  static String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		
		File Source= driver.getScreenshotAs(OutputType.FILE);
		String Destination= System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(Source,new File(Destination));
		return Destination;
	}

	public String Toast() {
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastmsg =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		return toastmsg;
		
		
	}
	public void doubleClick(WebElement Element) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) Element).getId(),
				"duration",10000));
		}
	
	public void paste(String text) {
		driver.setClipboardText(text);
	}

	public void swipeUp(){
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "up",
		    "percent", 0.75
		));
	}
	public void swipeleft(){
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "left", 500, "top", 100, "width", 200, "height", 200,
		    "direction", "up",
		    "percent", 0.75
		));
	}
	public void Send_keys(WebElement element,String string) {
		Actions actions =new Actions(driver);
		actions.moveToElement(element).sendKeys(string).perform();
		driver.hideKeyboard();
	}
	
	
//	public CreateNewWallet1 Send_keys(String vasu) {
//		Actions ac=new Actions(driver);
//		ac.sendKeys(vasu).perform();
//		return this;
//	}
	
	
	
	
	
}
