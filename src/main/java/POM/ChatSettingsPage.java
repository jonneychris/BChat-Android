package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChatSettingsPage extends ActionsClass{

	AndroidDriver driver;
	public ChatSettingsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement pageTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement SwipebtnEnterKey;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement SwipebtnDelteOld;
	
	@AndroidFindBy(id="android:id/summary")
	private WebElement optionConersationLength ;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Trim all conversations now']")
	private WebElement optionTrimConversation;
	
	@AndroidFindBy(id="io.beldex.bchat:id/titleTextView")
	private WebElement conversationLenthPopupTitle ;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Delete All Old Messages Now?']")
	private WebElement DeleteMessagePopupTitle;
	
	@AndroidFindBy(id="android:id/edit")
	private WebElement ConversationLengthTextbox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement btnOkInConversationPopup ;
	
	@AndroidFindBy(id="io.beldex.bchat:id/cancelButton")
	private WebElement btnCancelInConversationPopup ;
	
	@AndroidFindBy(id="io.beldex.bchat:id/delete_all_old_messages_dialog_cancel")
	private WebElement btnCancelInDeleteMessagePopup;
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/delete_all_old_messages_dialog_delete")
	private WebElement btnDelteInDeleteMessagePopup;
	
	
	
	public void click_Option_Conversation_Length () {
		optionConersationLength.click();
	}
	
	public void click_option_Trim_conversation () {
		optionTrimConversation.click();
	}
	
	public String pageTitle () {
		return pageTitle.getText();
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}

	public void click_Swipe_button_In_Enter_key () {
		SwipebtnEnterKey.click();
	}
	
	public void click_Swipe_button_In_delete () {
		SwipebtnDelteOld.click();
	}
	
	public String conversation_Length_Popup_Title () {
		return conversationLenthPopupTitle.getText();
	}
	
	public String Delete_Old_Messages_Popup_Title () {
		return DeleteMessagePopupTitle.getText();
	}

	public void change_Value_In_Conversation_Length (String value) {
	
		ConversationLengthTextbox.clear();
		ConversationLengthTextbox.sendKeys(value);
		btnOkInConversationPopup.click();
		
	}

	public void set_Space_Inbetween_Values () {
	
		ConversationLengthTextbox.clear();
		ConversationLengthTextbox.sendKeys("20");
		 ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.SPACE));
		 ConversationLengthTextbox.sendKeys("0");
		btnOkInConversationPopup.click();
	}
	
	public int getValue_from_Conversation_Length_option () {
		String Stringvalue= optionConersationLength.getText().substring(0, 3);
		int value= Integer.parseInt(Stringvalue);
		return value;	
	}
	
	public void click_Cancel_In_conversation_Length_Popup () {
		btnCancelInConversationPopup.click();
	}
	
	public void click_Cancel_In_Delete_Messages_Popup () {
		btnCancelInDeleteMessagePopup.click();
	}
	
	public void click_Ok_In_Conversation_Popup () {
		btnOkInConversationPopup.click();
	}
	
	public void click_delete_In_Delete_Messages_Popup () {
		btnCancelInDeleteMessagePopup.click();
	}
	
	public void click_conversation_Length_text_box () {
		ConversationLengthTextbox.click();
	}
	public void Copy_And_Paste_Values() {
		ConversationLengthTextbox.clear();
		super.Copy_And_Paste_Values("500", ConversationLengthTextbox);
		btnOkInConversationPopup.click();
	}
}
