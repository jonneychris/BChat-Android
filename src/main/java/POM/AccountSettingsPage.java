package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountSettingsPage extends ActionsClass{

	AndroidDriver driver;
	public AccountSettingsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Account Settings']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[305,804][449,948]']")
	private WebElement BeldexaddressCopyIcon;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[588,804][732,948]']")
	private WebElement BchatIdCopyIcon;
	
	@AndroidFindBy(xpath="//android.view.View[@bounds='[728,852][969,1050]']")
	private WebElement optionQrCode;

	@AndroidFindBy(xpath="//android.view.View[@bounds='[111,852][401,1050]']")
	private WebElement optionBeldexAddress;
	
	@AndroidFindBy(xpath="//android.view.View[@bounds='[445,852][684,1050]']")
	private WebElement optionBchatId;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beldex Address']")
	private WebElement BeldexAddressPopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BChat ID']")
	private WebElement BchatIdPopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan QR code']")
	private WebElement QrCodePopupScreenTitle;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnShare;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnLinkBNS;
	
	@AndroidFindBy(xpath="//android.view.View[@bounds='[48,1306][1032,1432]']")
	private WebElement OptionAboutBNS;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='About BNS']")
	private WebElement AboutBNSScreenTitle;

	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement copyIcon;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;

	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Link BNS']")
	private WebElement LinkBNSPopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='4']")
	private WebElement textBoxBNSName;

	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button[@index='1']")
	private WebElement btnCancelInLinkBNS;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement btnCancelInShareoptionScreen;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button[@index='1']")
	private WebElement btnVerifyInLinkBNS;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.widget.Button[@index='1']")
	private WebElement btnLinkInLinkBNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verifying...']")
	private WebElement loadingAnimationScreen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Changelog']")
	private WebElement optionChangeLog;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Verified']")
	private WebElement btnVerified;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hops']")
	private WebElement optionHops;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App Lock']")
	private WebElement optionAppLock;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout/android.widget.TextView[2][@text='1 image in total']")
	private WebElement ShareScreentitle;

	
	public WebElement ElementChangelog() {
		return optionChangeLog;
	}
	
    public String pageTitle() {
    	 return pageTitle.getText();
    }
    
    public String Share_Screen_Title () {
    	return ShareScreentitle.getText();
    }
    
    public void ClickBchatIdIcon () {
    	optionBchatId.click();
    }
    
    public void ClickBeldexAddressIcon () {
    	optionBeldexAddress.click();
    }
    
    public void ClickQRCode () {
    	optionQrCode.click();
    }
    public void CopyBchatId () {
    	BchatIdCopyIcon.click();
    }
  
    public void CopyBeldexAddress () {
    	BeldexaddressCopyIcon.click();
    }

    public String getPopupTitle (String ScreenName) {
       String 	Screentitle = null;
    	if(ScreenName.equalsIgnoreCase("BchatId"))
    	{
    		Screentitle = BchatIdPopupScreenTitle.getText();
    	}
    	if(ScreenName.equalsIgnoreCase("BeldexAddress")) {
    		Screentitle = BeldexAddressPopupScreenTitle.getText();
    	}
    	if(ScreenName.equalsIgnoreCase("QrCode")) {
    		Screentitle = QrCodePopupScreenTitle.getText();	
    	}
    	return Screentitle;
    	}

    public void clickCopyIcon() {
		copyIcon.click();
	}

    public void clickSharebtn () {
    	btnShare.click();
    }
    
    public void ClickAboutBNS () {
    	OptionAboutBNS.click();
    }
    
    public String get_About_BNS_Screen_title () {
		return AboutBNSScreenTitle.getText();
   	
    }
    
    public void click_Link_BNS_option () {
    	btnLinkBNS.click();
    }
    
    public String get_Link_BNS_Popup_Screen_Title () {
    	return LinkBNSPopupScreenTitle.getText();
    }
    
    public void Enter_Value_In_BNS_Name_field (String Value) {
    	//textBoxBNSName.click();
    	textBoxBNSName.sendKeys(Value);
    }
    
    public void click_Verify_Button () {
    btnVerifyInLinkBNS.click();
    }
    
    public void click_Link_Button_In_Popup_Screen () {
    	btnLinkInLinkBNS.click();
    }
    
    public void click_Cancel_Button_In_Popup_Screen () {
    	btnCancelInLinkBNS.click();
    }
    
    public void click_Cancel_In_share_option () {
    	btnCancelInShareoptionScreen.click();
    }
    
    public WebElement Loader_Animation () {
    	return loadingAnimationScreen;
    }
    
    public void  Scroll_the_screen () {
    	scrollgesture_Using_text(optionChangeLog.getText());
    }
    
    public void clear_text_box() {
    	textBoxBNSName.clear();
    }
     
    public void click_Hops_Option () {
    	optionHops.click();
    }
    
    public void click_App_Lock_Option () {
    	optionAppLock.click();
    }
    
    public String Content_changelog () {
		return optionChangeLog.getText();
    	
    }
    
    public WebElement Element_of_Link_BNS_PopScreen_content () {
		return LinkBNSPopupScreenTitle;
    	
    }
}
