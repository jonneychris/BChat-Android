package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MessageRequestPage extends ActionsClass {

	AndroidDriver driver;
	public MessageRequestPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Message Requests']")
	private WebElement pagetitle;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;

	@AndroidFindBy(accessibility = "No Pending message Requests!")
	private WebElement emptyScreen;


	@AndroidFindBy(xpath="//android.view.View/android.view.View[1]/android.widget.TextView[@index='0']")
	private WebElement ReceivedRequest;
	
	@AndroidFindBy(xpath="//android.view.View/android.view.View[1][@index='1']")
	private WebElement optionDeleteInFirstContact;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[2][@index='2']")
	private WebElement optionBlockInFirstContact;
	
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[3][@index='3']")
	private WebElement optionAcceptInFirstContact;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btnCancelInPopup;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnYesInPopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Message Request']")
	private WebElement popupTitle;
	
	public WebElement Element_Of_First_Received_Request () {
	  return ReceivedRequest;	
	}
	
	public String pageTitle () {
		return pagetitle.getText();
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public WebElement Empty_screen () {
		return emptyScreen;
	}
	
	public void Click_Block_option () {
		optionBlockInFirstContact.click();
	}
	
    public void Click_Delete_option () {
		optionDeleteInFirstContact.click();
	}
	
	public void Block_First_request_In_List () {
		optionBlockInFirstContact.click();
		btnYesInPopup.click();
	}
	
	public void Accept_First_Request_In_List () {
		optionAcceptInFirstContact.click();
	}
	
	public void Delete_First_Request_in_list () {
		optionDeleteInFirstContact.click();
		btnYesInPopup.click();
		
	}
	
	public String PopupTilte () {
		return popupTitle.getText();
	}
	
	public void click_cancel () {
		btnCancelInPopup.click();
	}
}
