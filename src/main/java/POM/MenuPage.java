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
	
	@AndroidFindBy(id="io.beldex.bchat:id/account_setting_img")
	private WebElement Qrcode;
	
	@AndroidFindBy(id="io.beldex.bchat:id/account_setting_img")
	private WebElement optionAccountSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"Settings\"]")
	private WebElement optionSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"Notification\"]")
	private WebElement optionNotification;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"Message Requests\"]")
	private WebElement optionMessageRequest;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Recovery Seed']")
	private WebElement optionRecoverySeed;
	
	@AndroidFindBy(id="io.beldex.bchat:id/navigation_SubIcon")
	private WebElement optionWallet;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"Report Issue\"]")
	private WebElement optionsReportIssue;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"Help\"]")
	private WebElement optionHelp;
	
	@AndroidFindBy(id="com.google.android.gm:id/compose_body_parent")
	private WebElement gmailScreen;
	
	@AndroidFindBy(accessibility = "support beldex, support@beldex.io")
	private WebElement ToMailIdInGmail;
	
	@AndroidFindBy(id = "android:id/content_preview_text")
	private WebElement InvitePopup;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement btnCancelInInvite;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"Invite\"]")
	private WebElement optionInvite;

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/navigation_title\" and @text=\"About\"]")
	private WebElement optionAbout;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
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

    public void click_Notification_option() {
		optionNotification.click();
	}
    
    public void click_option_Wallet () {
    	optionWallet.click();
    }
     
    public void click_option_Settings () {
    	optionSettings.click();
    }
    
    public void click_option_Message_requests () {
    	optionMessageRequest.click();
    }
    
    public void click_option_Recovery_Seed () {
    	optionRecoverySeed.click();
    }
    
    
    public void click_option_ReportIssue () {
    	optionsReportIssue.click();
    }
    
    public void click_option_Help () {
    	optionHelp.click();
    }
    
    public void click_option_Invite() {
		optionInvite.click();
	}
    
    public void click_option_About () {
    	optionAbout.click();
    }
    
    public void click_Back_Arrow () {
    	btnBackArrow.click();
    }
    
    public String About_Screen_Title () {
    	return optionAbout.getText();
    }
    
    public void click_cancel_In_Inivite () {
    	btnCancelInInvite.click();
    }

    public WebElement get_Invite_Screen_element () {
    	return InvitePopup;
    }
    
    public String get_to_mail_Id () {
    	return ToMailIdInGmail.getText();
    }
    
    public WebElement get_element_of_GmailScreen () {
    	return gmailScreen;
    }

    public void click_theme_ChnageButton() {
		optionThemeChange.click();
	}
    
    public void click_Close_Icon () {
    
    	Closeicon.click();
    	
    	
    }
}

