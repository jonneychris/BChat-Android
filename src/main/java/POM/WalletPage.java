package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WalletPage extends ActionsClass{

	AndroidDriver driver;
	public WalletPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@index='1']")
	private WebElement TitleWalletPassword;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wallet']")
	private WebElement TitleWallet;
	
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public String  Title_Wallet_Password () {
		return TitleWalletPassword.getText();
	}

	public String Title_Wallet () {
		return TitleWallet.getText();				
	}

}
