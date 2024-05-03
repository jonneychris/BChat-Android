package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RecoverySeed_Page extends ActionsClass {

	AndroidDriver driver;
	public RecoverySeed_Page(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/seed_permission_important_title")
	private WebElement importantScreen;
	
	public String importantScreen() {
		
		String pagetitle= importantScreen.getText();
		return pagetitle;
	}

}
