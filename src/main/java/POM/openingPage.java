package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class openingPage extends ActionsClass{

	AndroidDriver driver;
	public openingPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	private WebElement buttonCreateAccount;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreButton")
	private WebElement buttonSignIn;

	@AndroidFindBy(id="io.beldex.bchat:id/TermsandCondtionsTxt")
	private WebElement linkTermsAndConditions;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	private WebElement buttonAllow;

	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
	private WebElement buttonDeny;
	
	public void clickCreateAccount() {
		super.click(buttonCreateAccount);
	}
	
	public void clickSignIn() {
		super.click(buttonSignIn);
	}
	
	public void clickTermsAndConditions() {
		super.click(linkTermsAndConditions);
	}
	
	public void clickAllow() {
		super.click(buttonAllow);
	}
	
	public void clickDeny() {
		super.click(buttonDeny);
	}
}