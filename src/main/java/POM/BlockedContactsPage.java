package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BlockedContactsPage extends ActionsClass {

	AndroidDriver driver;
	public BlockedContactsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Blocked Contacts']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='No blocked contacts yet']")
	private WebElement emptyScreen;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnbackArrow;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement blockedContactCheckBox;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.CheckBox")
	private WebElement FirstContactCheckBox;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.CheckBox")
	private WebElement SecondContactCheckBox;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[2]")
	private WebElement btnMultiSelect;
	
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[2]")
	private WebElement btnUnlockContact;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.TextView[2]")
	private WebElement btnUnlockForFirstContact;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.TextView[2]")
	private WebElement btnUnlockForSecondtContact;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnUnblockSelected;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[1]")
	private WebElement UnlockUserspopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[3]")
	private WebElement btnCancelInPopup;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[4]")
	private WebElement btnContinueInPopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@index='0']")
	private WebElement BlockedContactIdOrName;
	
	public void click_Back_Arrow () {
		btnbackArrow.click();
	}
	
	
	public String pageTitle () {
		return pageTitle.getText();
	}
	
	public String Empty_Screen_content () {
		return emptyScreen.getText();
	}
	
	
	public void UnBlock_contact () {
		btnUnlockForFirstContact.click();
	}
	
	public String get_Blocked_Contact_Id_Or_Name () {
	 return BlockedContactIdOrName.getText();
	}
	
	public void UnBlock_By_Using_MultiSelect_option () {
		btnMultiSelect.click();
		FirstContactCheckBox.click();
		SecondContactCheckBox.click();
		btnUnblockSelected.click();
		btnContinueInPopup.click();
	}
	
	public void check_Cancel_button_In_unblockusers_Popup () {
		
		btnMultiSelect.click();
		blockedContactCheckBox.click();
		btnUnblockSelected.click();
		btnCancelInPopup.click();
		btnMultiSelect.click();
		
	}
	
	
}
