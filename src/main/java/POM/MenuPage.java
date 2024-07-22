package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage extends ActionsClass {
	
	AndroidDriver driver;
	public MenuPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_settings_title")
	private WebElement pagetitle;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/drawer_profile_name")
	private WebElement profileName;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_close_icon")
	private WebElement Closeicon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_qrcode_img")
	private WebElement Qrcode;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Account Settings']")
	private WebElement optionAccountSettings;
	
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	private WebElement optionSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Notification']")
	private WebElement optionNotification;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Message Requests']")
	private WebElement optionMessageRequest;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Recovery Seed']")
	private WebElement optionRecoverySeed;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Wallet']")
	private WebElement optionWallet;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Report Issue']")
	private WebElement optionsReportIssue;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Help']")
	private WebElement optionHelp;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Invite']")
	private WebElement optionInvite;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='About']")
	private WebElement optionAbout;
	
	@AndroidFindBy(className="android.widget.Switch")
	private WebElement optionThemeChange;
	

	public String pagetitle() {
	String title=	pagetitle.getText();
	return title;
	}
	
     public void click_My_Account_option () {
		Qrcode.click();
	 }
	
    public String getProfileName () {
		return profileName.getText();	
    }
    
    public void click_Account_Settings () {
    	optionAccountSettings.click();
    }
     
    public void Scroll_the_Screen () {
    	scrollgesture_Using_WebElement(optionAbout);
    	}
    
    public String contentAbout () {
		return optionAbout.getText();
    	
    }
     
     
}

