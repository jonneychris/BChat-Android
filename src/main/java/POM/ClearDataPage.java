package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClearDataPage extends ActionsClass {

	AndroidDriver driver;
	public ClearDataPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Clear All Data']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Clear All Data']")
	private WebElement ClearPopupTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Delete Entire Account']")
	private WebElement DeletePopupTitle;
	
	@AndroidFindBy(xpath ="//android.view.View[2]/android.widget.RadioButton")
	private WebElement optionDeleteAccount;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button")
	private WebElement btnCancelInoptionsPopup;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.widget.Button")
	private WebElement btnOk;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btnCancelInCleardataOrDeleteAccount;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnClearOrDelete;
	
	@AndroidFindBy(className = "android.widget.ProgressBar")
	private WebElement loadingAnimation;



	public String pageTitle () {
		return pageTitle.getText();
	}

	public String cleardata_popup_screen_title () {
		return ClearPopupTitle.getText();
	}


	public String DeleteAccount_popup_screen_title () {
		return DeletePopupTitle.getText();
	}

	public void click_Cancel_Option_popup () {
	    btnCancelInoptionsPopup.click();	
	}
	
	public void click_ok () {
		btnOk.click();
	}
	
	public void click_cancel_In_clear_Or_Delete_popup () {
		btnCancelInCleardataOrDeleteAccount.click();
	}
	
	public void click_Clear_Or_delete_option () {
		btnClearOrDelete.click();
	}
	
	public void click_option_deleteAccount () {
		optionDeleteAccount.click();
	}
	
	public WebElement Loading_animation() {
		return loadingAnimation;
	}
}
