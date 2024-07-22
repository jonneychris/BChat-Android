package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends ActionsClass{

	AndroidDriver driver;
	public LandingPage(AndroidDriver driver) {
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

	@AndroidFindBy(accessibility ="BChat Messenger")
	private WebElement AppIcon;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
	private WebElement buttonDeny;
	
	@AndroidFindBy(id="com.android.launcher:id/all_apps_content")
	private WebElement Devicehome;
	//com.android.launcher:id/all_apps_content"
	
	@AndroidFindBy(id="com.android.launcher:id/recent_container")
	private WebElement AppList;
	
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
	
	public WebElement WebElementCreateAccount() {
		
		WebElement element = buttonCreateAccount;
		return element;
	}
	
public WebElement WebElementDeviceHome() {
		
		WebElement element = Devicehome;
		return element;
	
	}


public WebElement WebElementAppList() {
		
		WebElement element = AppList;
		return element;
	
	}

public void openApp() {
		AppIcon.click();
	}

public boolean isCreateAccountClickable() {
	return isClickable(buttonCreateAccount);
	
}

public boolean isSignInClickable() {
	return isClickable(buttonSignIn);
	
}

public boolean isTermsAndConditionsClickable() {
	return isClickable(linkTermsAndConditions);
	
}

}
