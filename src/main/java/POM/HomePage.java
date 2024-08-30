package POM;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ActionsClass {

	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="io.beldex.bchat:id/bchatHeaderImage")
	private WebElement pageTitle;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save your seed']")
	private WebElement PopupSaveSeed;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement buttonOk;
	
	@AndroidFindBy(id="io.beldex.bchat:id/profileButton")
	private WebElement btnMenuDrawer;
		
	@AndroidFindBy(xpath="android.widget.TextView[@text='Search']")
	private WebElement titleSearch;
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchBarBackButton")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_close_icon")
	private WebElement btncancel;
	
	
	@AndroidFindBy(accessibility="clear")
	private WebElement btntextboxcancel;
	
	@AndroidFindBy(className="android.widget.Button")
	private WebElement groupsIcon;
	
	//@AndroidFindBy(id="io.beldex.bchat:id/gradientView")
	//private WebElement chathistory;
	 
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/emptyStateContainerText")
	public WebElement BlankChatScreen;
	
	@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1632][1026,1800]']")
	private WebElement btnNewChat;
	
	
	@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1800][1026,1968]']")
	private WebElement btnSecretGroup;
	
	@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1968][1026,2136]']")
	private WebElement btnSocialGroup;
	
	//@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[45,190][165,280]']")
	//private WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Note to Self']")
	private WebElement optionNoteToMyself;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search people and groups']")
	private WebElement textboxplacholder;
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement textboxSearch;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.widget.TextView[1]")
	private WebElement FirstChatItem;
	
	@AndroidFindBy(xpath="(//android.view.ViewGroup/android.widget.TextView[1])[2]")
	private WebElement SecondChatItem;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Block']")
	private WebElement optionBlock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Unblock']")
	private WebElement optionUnblock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Block Contact']")
	private WebElement BlockContactPopupTitle;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btnCancelInPopup;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnYesInPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationViewDisplayNameTextView")
	private WebElement DisplayNameOfChatItem;
	
	@AndroidFindBy(id="io.beldex.bchat:id/recyclerView")
	private WebElement oldMessages;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Messages']")
	private WebElement Elementmessages; 
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search']")
	private WebElement SearchpageTitlte;

	@AndroidFindBy(id="io.beldex.bchat:id/pinnedViewContainer")
	private WebElement pinIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Pin']")
	private WebElement optionPin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Unpin']")
	private WebElement optionUnpin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Notification settings']")
	private WebElement optionNotificationSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mute notifications']")
	private WebElement optionMuteNotification;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Unmute']")
	private WebElement optionUnMute;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mark all as read']")
	private WebElement optionMarkAllAsRead;
	

	@AndroidFindBy(id="io.beldex.bchat:id/mute_icon")
	private WebElement muteIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Delete']")
	private WebElement optionDelete;
	
	@AndroidFindBy(id="io.beldex.bchat:id/hopsWarningLayout")
	private WebElement hopsWarning;

	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement cancelIconInPopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mentions']")
	private WebElement optionMentions;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='All']")
	private WebElement optionAll;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mute_icon")
	private WebElement MentionIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/unreadCountIndicator")
	private WebElement unreadMsgCount;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnOkInMutePopup;
	
	public  String popuptitle() {
		String popupTitle = PopupSaveSeed.getText();
		return popupTitle;
	}
	
	public void click_Option_Note_To_Myself () {
		optionNoteToMyself.click();
	}
	
	public void clickok() {
		buttonOk.click();
	}
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public String Search_PageTitle () {
		return SearchpageTitlte.getText();
	}
	
	public void clickMenuDrawer() {
		btnMenuDrawer.click();
	}
	
	public String searchTitle() {
		 String text= titleSearch.getText();
		 return text;
	}
	
	public void clickSearch() {
		textboxSearch.click();
		
	}
	
	public void clickBackArrow() {
		btnBackArrow.click();
	}
	
	public void OpenNewChat() {
		groupsIcon.click();
		btnNewChat.click();
	}

public void openNewSecretGroup() {
	groupsIcon.click();
	btnSecretGroup.click();
	}

public void openJoinSocialGroup() {
	groupsIcon.click();
	btnSocialGroup.click();
}


public String SearchPlaceholder () {
	return textboxplacholder.getText();
}

public void ClickCancel() {
	btncancel.click();
}

public void pastevalues(String text) {
	textboxSearch.click();
	Copy_And_Paste_Values(text, textboxSearch);
}

public void clearTextBox () {
	textboxSearch.clear();
}

public void enterValues (String text) {
	textboxSearch.click();
	textboxSearch.sendKeys(text);
}

public void click_cancel_icon_inside_textbox () {
	btntextboxcancel.click();
}

public boolean visiblity_of_placeholder () {
	boolean result =textboxSearch.isDisplayed();
	return result;
}
public boolean visblity_of_crusor() {
	textboxSearch.click();
	boolean result =textboxSearch.equals(activeElement());
 return result;
}

public void Block_First_Contact () {
	longPress(DisplayNameOfChatItem);
	optionBlock.click();
	btnYesInPopup.click();		
}

public void Block_Second_Contact () {
	longPress(SecondChatItem);
	optionBlock.click();
	btnYesInPopup.click();		
}

public void UnBlock_First_Contact () {
	longPress(DisplayNameOfChatItem);
	optionUnblock.click();
	btnYesInPopup.click();		
}

public String get_DisplayName_Or_Id_Of_ChatItem() {
	 return DisplayNameOfChatItem.getText();	 
}

public String get_Values_From_Search_textbox () {
	return textboxSearch.getText();
}

public WebElement Element_Messages () {
  return	Elementmessages;
}

public WebElement  Element_of_pinIcon () {
	return pinIcon;
}

public WebElement hops_Warning () {
	return hopsWarning;
}

public void pin_The_chat () {
	longPress(SecondChatItem);
	optionPin.click();
	
}

public void Unpin_The_chat () {
	longPress(FirstChatItem);
	optionUnpin.click();
	
}

public void Mute_Notificaion_of_Chat () {
	longPress(FirstChatItem);
	optionMuteNotification.click();
	btnOkInMutePopup.click();
	
}

  public void UnMute_Notificaion_of_Chat () {
	longPress(FirstChatItem);
	optionUnMute.click();
	
  }

	public WebElement Element_Mute_Icon () {
		
		return muteIcon;
	}
	
	public String get_First_Id () {
		return FirstChatItem.getText();
	}

	public String get_Second_Id () {
		return SecondChatItem.getText();
	}
	
	public void Delete_FirstContact () {
		longPress(FirstChatItem);
		optionDelete.click();
	   btnYesInPopup.click();
	   
	}
	
	public void open_FirstChat () {
		FirstChatItem.click();
	}
	
	public void validate_Cancel_in_Block () {
		longPress(FirstChatItem);
		optionBlock.click();
		btnCancelInPopup.click();
	}
	
	public void validate_Cancel_in_Delete () {
		longPress(FirstChatItem);
		optionDelete.click();
		btnCancelInPopup.click();
	}
	
	public void validate_Cancel_in_NotificationSettings () {
		longPress(SecondChatItem);
		optionNotificationSettings.click();
		cancelIconInPopup.click();
	}
	
	public void Set_Mention_option () {
		longPress(SecondChatItem);
		optionNotificationSettings.click();
		optionMentions.click();
	}
	
	public void Set_All_option () {
		longPress(SecondChatItem);
		optionNotificationSettings.click();
		optionAll.click();
	}
	
	public WebElement Element_Mention_Icon () {
		return MentionIcon;
	}
	
	public WebElement Element_of_Unread_Msg_Count () {
		return unreadMsgCount;
	}
	
	public void Select_Mark_All_As_read() {
		longPress(SecondChatItem);
		optionMarkAllAsRead.click();
		
	}
	
//public List OldMessages () {
//	int messagelist =oldMessages.getSize();
//	 
//	for(int i=0;i <=  ;i++) {
//		
//	}
//	return null;
//	
//}

}
