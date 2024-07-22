package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import Utiles.baseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLockPage extends ActionsClass{

	AndroidDriver driver;
	public AppLockPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change Password']")
	private WebElement optionChangePassword;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Screenlock Inactivity Timeout']")
	private WebElement optionScreenLockTimeout;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App Lock']")
	private WebElement pagetTitle;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Screen Inactivity Timeout']")
	private WebElement ScreenTimeoutPopupScreenTitle;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement btnCancelIcon;
	
	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement cancelIconInScreenLock;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement bntOkInScreenLock;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[2][@index='1']")
    private WebElement selectedoptionInScreenLock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[2][@index='2']")
	private WebElement showingoptionInApplockScreen;
	
	public void click_ChangePassword_option () {
		optionChangePassword.click();
	}
	
	public void click_cancel_Icon_In_screenlock () {
		cancelIconInScreenLock.click();
	}
	
	public void click_Ok_In_Screenlock () {
		bntOkInScreenLock.click();
	}
	
	public void click_ScreenLockTimeOut_option () {
	  optionScreenLockTimeout.click();
	}
	
	public String Selected_option_In_Screenlock() {
		return selectedoptionInScreenLock.getText();
		
	}
	
	public String Showing_option_in_app_lock_screen () {
		 return showingoptionInApplockScreen.getText();
	}
	
	public String pageTitle () {
		return pagetTitle.getText();
		
	}
	
	public String Screen_TimeOut_Popup_screen_Title () {
		return ScreenTimeoutPopupScreenTitle.getText();
	}
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public void Clicl_Cancel_Icon () {
		btnCancelIcon.click();
	}
}
