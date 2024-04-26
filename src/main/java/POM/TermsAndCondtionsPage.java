package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TermsAndCondtionsPage extends ActionsClass{
	
AndroidDriver driver;
	public TermsAndCondtionsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='BChat Terms of Service']")
	public WebElement textPageTitle;
	
	
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	//android.widget.TextView[@text='BChat Terms of Service']
}
