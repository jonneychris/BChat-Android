package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ActionsClass {

	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="io.beldex.bchat:id/bchatHeaderImage")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save your seed']")
	private WebElement PopupSaveSeed;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement buttonOk;
	
	public  String popuptitle() {
		String popupTitle = PopupSaveSeed.getText();
		return popupTitle;
	}
	
	public void clickok() {
		buttonOk.click();
	}
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
}
