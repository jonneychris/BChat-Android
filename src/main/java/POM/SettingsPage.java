package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends ActionsClass {

	AndroidDriver driver;
	public SettingsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}

	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionStartWallet;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[6]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionPayAsYouChat;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionSendLinkPreview;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[9]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement optionVoiceCalls;

   @AndroidFindBy(id="io.beldex.bchat:id/callPermissionEnableButton")
   private WebElement btnEnableInCallsPopup;
   
   @AndroidFindBy(id="io.beldex.bchat:id/alertTitle")
   private WebElement SetupPinPopupTitle;
   
   @AndroidFindBy(id="android:id/button1")
   private WebElement bntSetup;
   
   @AndroidFindBy(id="android:id/button2")
   private WebElement btncancel;
	
   @AndroidFindBy(id="io.beldex.bchat:id/walletSetUpTitle")
   private WebElement walletSetupLoader;

   @AndroidFindBy(id="io.beldex.bchat:id/back")
   private WebElement btnBackArrow;
   
   public void click_Back_Arrow () {
	   btnBackArrow.click();
   }
   
   public String pageTitle () {
	   return pageTitle.getText();
   }
   
   public void click_start_wallet () {
	   optionStartWallet.click();
	   }
   
   public void click_PayAsYouChat () {
	   optionPayAsYouChat.click();
   }
   
   public WebElement Check_payAsYouChat_option () {
	   return optionPayAsYouChat;
   }
   
   public void click_Send_LinkPreview () {
	   optionSendLinkPreview.click();
   }
   
   public String popupSetupPin () {
	   return SetupPinPopupTitle.getText();
   }
   
   public void click_Cancel () {
	   btncancel.click();
   }
   
   
}
