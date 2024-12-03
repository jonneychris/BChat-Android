package Utiles;

import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

public class BrowserStack_Setup {
	
	private WebDriver driver;
	private String url;
	private MutableCapabilities capablities;
	private HashMap<String, Object> browserOptions;
	
	public void setbrowserstackoption(String browserdeviceval) {
		
		browserOptions.put("deviceName", "");
		browserOptions.put("realMobile", "");
		browserOptions.put("osVersion", "");
		browserOptions.put("sessionName", "");
		browserOptions.put("buildName", "");
	}

	
	@BeforeTest
	@Parameters("browserdeviceval")
	public void setUpConfig(String browserdeviceval) {
		url ="https://beldexglobalsoft_87lgcC@hub-cloud.browserstack.com/wd/hub"
	}
}
