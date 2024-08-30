package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChatPage extends ActionsClass {

	AndroidDriver driver;
	public ChatPage(AndroidDriver driver) {
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
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Message delivery status\"])[1]")
	private WebElement messagestatusofFirstMessage;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc=\"Message delivery status\"])[2]")
	private WebElement messagestatusofSecondMessage;
	
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
	
	@AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
	private WebElement messageCard;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/bodyTextView\"])[2]")
	private WebElement SecondMessageCard;
	
	@AndroidFindBy(accessibility = "Delete message")
	private WebElement btnDelete;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/deleteForEveryoneTextView")
	private WebElement optionDeleteForEveryone;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btndeleteInpopup;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
	private WebElement btnMoreoptions;
	
	@AndroidFindBy(className = "android.widget.ListView")
	private WebElement moreOptionsList;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/imageButton")
	private WebElement optionGallery;
	
	@AndroidFindBy(id="io.beldex.bchat:id/attachmentsButtonContainer")
	private WebElement btnattachments;
	
	@AndroidFindBy(id="io.beldex.bchat:id/blockedBanner")
	private WebElement Elementblocked;
	
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
	
	public String get_Second_Message_Value() {
		return SecondMessageCard.getText();
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
	
	public String get_Values_from_TextBox () {
		 return messageTextbox.getText();
	}
	
	public void clear_textBox () {
		messageTextbox.clear();
	}
	
	public void delete_Send_Message () {
		longPress(messageCard);
		btnDelete.click();
		
	}
    public void click_DeleteForEveryone () {
		optionDeleteForEveryone.click();
		}
    
	
		
	
	public void click_Textbox () {
		messageTextbox.click();
	}
	
	
	public void paste_values (String value) {
		Copy_And_Paste_Values(value, messageTextbox);
	}

	public void Record_Voice_Msg () {
		longPress(btnSend);
		swipeGesture(950, 2260 , 100, 150, "up");
	}
	
	public WebElement get_Element_of_MoreOptions () {
		return moreOptionsList;
	}
	
	public WebElement get_Element_Gallery () {
		return optionGallery;
	}
	
	public void click_Moreoption () {
		btnMoreoptions.click();
	}
	
	public void click_Attachments () {
		btnattachments.click();
	}
	
	public void click_delete_In_Popup () {
		btndeleteInpopup.click();
	}
	
	public void Send_one_msg () {
		Set_Values_In_Message_textbox("Hii");
		click_Send_Button();
		click_Back_Arrow();
	}
	
	public WebElement Element_of_Blocked_Banner () {
		return Elementblocked;
	}
}
