package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RestoreFromSeedPage extends ActionsClass{
	
	AndroidDriver driver;
	public RestoreFromSeedPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletName")
	private WebElement txtboxDisplayName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletRestoreHeight")
	private WebElement txtboxBlockheight;
	

	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedRestoreButton")
	private WebElement btnRestore;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreFromDateButton")
	private WebElement btnRestoreFromDate;
	
	@AndroidFindBy(id="io.beldex.bchat:id/restoreSeedWalletRestoreDate")
	private WebElement btnCalendar;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement btnOk;
	
	@AndroidFindBy(id="android:id/button2")
	private WebElement btnCancel;
	
	
	
	
	
	
	
}
