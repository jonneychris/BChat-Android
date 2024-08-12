package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OneToOneChatPage extends ActionsClass {

	AndroidDriver driver;
	public OneToOneChatPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	private WebElement profileNameOrId; 
	
	@AndroidFindBy(id="io.beldex.bchat:id/inputBarEditText")
	private WebElement messageTextbox;
	
	@AndroidFindBy(accessibility = "Message delivery status")
	private WebElement messageStatus;
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement sendMessageCard;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back_to_home_Btn")
	private WebElement btnbackArrow ;
	
	@AndroidFindBy(id="io.beldex.bchat:id/microphoneOrSendButtonContainer")
	private WebElement btnSend;
	
	@AndroidFindBy(id="io.beldex.bchat:id/acceptMessageRequestButton")
	private WebElement btnAccept;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnAcceptInPopup;
	
	public void clickTextBox () {
		messageTextbox.click();
	}
	public void click_Back_Arrow () {
		btnbackArrow.click();
	}
	
	public WebElement SendMessageCard () {
		return messageStatus;
	}
	
	public String get_Send_Message_Value () {
		return sendMessageCard.getText();
	}
	
	
	public void Set_Values_In_Message_textbox (String value) {
	   messageTextbox.sendKeys(value);
	}
	
	public void click_Send_Button () {
		btnSend.click();
	}
	
	public String get_profile_NameOr_Id () {
		 return profileNameOrId.getText();
	}
 
	public void click_Accept () {
		btnAccept.click();
		btnAcceptInPopup.click();
	}
	
}
