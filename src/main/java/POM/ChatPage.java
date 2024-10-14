package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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
	
	@AndroidFindBy(accessibility = "Send")
	private WebElement btnSendInImage;
	
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
	
	@AndroidFindBy(id = "io.beldex.bchat:id/deleteForMeTextView")
	private WebElement optionDeleteForMe;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btndeleteInpopup;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btncancelInpopup;
	
	@AndroidFindBy(accessibility = "More options")
	private WebElement btnMoreoptions;
	
	@AndroidFindBy(className = "android.widget.ListView")
	private WebElement moreOptionsList;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/imageButton")
	private WebElement optionGallery;
	
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")
	private WebElement firstFolder;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mediapicker_menu_add")
	private WebElement Allmediaplusbutton;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@resource-id=\"io.beldex.bchat:id/mediapicker_select_off\"])[1]")
	private WebElement firstImageInAllMedia;
	
	@AndroidFindBy(id="io.beldex.bchat:id/mediasend_count_button_text")
	private WebElement btnArrowInGallery;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.ImageView[1][@index='0']")
	private WebElement AllMediaInGallery;
	
	@AndroidFindBy(id="io.beldex.bchat:id/attachmentsButtonContainer")
	private WebElement btnattachments;
	
	@AndroidFindBy(id="io.beldex.bchat:id/blockedBanner")
	private WebElement Elementblocked;
	
	@AndroidFindBy(id="io.beldex.bchat:id/cancelTextView")
	private WebElement CancelbuttonafterSend;
	
	@AndroidFindBy(id="io.beldex.bchat:id/connectedStatus")
	private WebElement internetStatus;
	
	@AndroidFindBy(accessibility = "Call")
	private WebElement callIcon;
	
	@AndroidFindBy(accessibility = "More options")
	private WebElement Moreoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='All media']")
	private WebElement optionAllMedia;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search']")
	private WebElement optionSearch;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add to home screen']")
	private WebElement AddtoHomeScreen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Disappearing messages']")
	private WebElement DisappearingMessages;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Block']")
	private WebElement Block;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mute notifications']")
	private WebElement muteNotifications;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Unmute']")
	private WebElement Unmute;
	
	@AndroidFindBy(id="io.beldex.bchat:id/muteIconImageView")
	private WebElement muteIcon;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnOkInPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement btnOkInPayAsYouChat;
	
	@AndroidFindBy(id="io.beldex.bchat:id/menu_expiring_messages")
	private WebElement icondisappearingmessages;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='All Media']")
	private WebElement AllMediaScreenTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/no_images")
	private WebElement emptyMediaScreen;
	
	@AndroidFindBy(id="io.beldex.bchat:id/search_query")
	private WebElement SearchTextbox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/noMatchesFoundTextview")
	private WebElement ContentNoMatchesFound;
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchDown")
	private WebElement iconSearchdown;
	
	@AndroidFindBy(id="io.beldex.bchat:id/close_search")
	private WebElement closeIconInSearch;
	
	@AndroidFindBy(id="android:id/button2")
	private WebElement btnCancelInAddToHomeScreen;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement btnAddInAddToHomeScreen;
	
	@AndroidFindBy(accessibility = "Chris")
	private WebElement ShortcutIconofNoteToSelf;
	
	@AndroidFindBy(accessibility = "test")
	private WebElement ShortcutIconoffriend;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Copy text']")
	private WebElement optionCopytext;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Message details']")
	private WebElement optionMessageDetails;
	
	@AndroidFindBy(accessibility = "Reply to message")
	private WebElement optionReply;
	
	@AndroidFindBy(accessibility = "Done")
	private WebElement btnCloseInChatScreen;
	
	@AndroidFindBy(id="io.beldex.bchat:id/quoteViewBodyTextView")
	private WebElement replycard;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Message details']")
	private WebElement messagedetailsScreentitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/declineMessageRequestButton")
	private WebElement btndecline;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cancel']")
	private WebElement btnCancel;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Yes']")
	private WebElement btnYes;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Unblock']")
	private WebElement btnUnblock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Decline']")
	private WebElement btnDeclineInpopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/attachment_container")
	private WebElement ElementsOfAttachments;
	
	@AndroidFindBy(id="io.beldex.bchat:id/delete_view")
	private WebElement btndeletevoicemsg;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.TextView[1]")
	private WebElement callUIPageTitle;
	
	@AndroidFindBy(accessibility = "end call")
	private WebElement endcall;
	
	@AndroidFindBy(id="io.beldex.bchat:id/expirationTimerView")
	private WebElement timerAnimation;
	
	@AndroidFindBy(id="io.beldex.bchat:id/textView")
	private WebElement contentDisappearingMessage;
	
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"io.beldex.bchat:id/visibleMessageView\"])[1]")
	private WebElement firstMessage;
	
	@AndroidFindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"io.beldex.bchat:id/visibleMessageView\"])[2]")
	private WebElement SecondMessage;
	
	@AndroidFindBy(id="io.beldex.bchat:id/settingsDialogBoxButton")
	private WebElement btnSettings;
	
	@AndroidFindBy(id="io.beldex.bchat:id/inChatBDX")
	private WebElement beldexIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/tooltip")
	private WebElement tooltip;
	
	@AndroidFindBy(id ="io.beldex.bchat:id/slideToPayButton")
	private WebElement btnSlideToPay;
	
	@AndroidFindBy(accessibility = "Media message")
	private WebElement image;
	
	@AndroidFindBy(accessibility = "Forward")
	private WebElement btnForward;
	
	@AndroidFindBy(accessibility = "Save attachment")
	private WebElement optionDownload;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement forwardPagetitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/voiceMessagePlaybackImageView")
	private WebElement voiceMessage;
	
	@AndroidFindBy(id="io.beldex.bchat:id/positiveButton")
	private WebElement btnYesInPopup;
	
	@AndroidFindBy(accessibility = "Media message")
	private WebElement ElementofMediaFile;
	
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
		messageTextbox.click();
	   messageTextbox.sendKeys(value);
	   driver.hideKeyboard();
	  // driver.navigate().back();
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
		longPress(sendMessageCard);
		btnDelete.click();		
	}
	
	public void delete_second_message () {
		longPress(SecondMessageCard);
		btnDelete.click();
	}
    public void click_DeleteForEveryone () {
		optionDeleteForEveryone.click();
		}
    
    public void click_DeleteForMe () {
  		optionDeleteForMe.click();
  		}
		
	
	public void click_Textbox () {
		messageTextbox.click();
	}
	
	
	public void paste_values (String value) {
		Copy_And_Paste_Values(value, messageTextbox);
		driver.navigate().back();
	}

	public void Record_Voice_Msg () throws InterruptedException {
		drap_Gesture(btnSend, 950, 1990);
	    Thread.sleep(1000);
	}
	
	public WebElement get_Element_of_MoreOptions () {
		return moreOptionsList;
	}
	
	public WebElement get_Element_Gallery () {
		return optionGallery;
	}
	
	public void click_Moreoption () {
		clickGesture(1005, 180);
		//btnMoreoptions.click();
	}
	
	public void click_Attachments () {
		btnattachments.click();
	}
	
	public void Send_image () throws InterruptedException {
		btnattachments.click();
		optionGallery.click();
		AllMediaInGallery.click();
		Thread.sleep(1000);
		
		try {
			Thread.sleep(1000);
			Allmediaplusbutton.click();
		    firstImageInAllMedia.click();
		    btnArrowInGallery.click();
		btnSendInImage.click();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			driver.navigate().back();
			driver.navigate().back();
				btnattachments.click();
				optionGallery.click();
				AllMediaInGallery.click();
				Thread.sleep(1000);
				Allmediaplusbutton.click();
			    firstImageInAllMedia.click();
			    btnArrowInGallery.click();
			btnSendInImage.click();
		}
		}
	
	
	public void click_delete_In_Popup () {
		btndeleteInpopup.click();
	}
	
	public void click_cancel_in_delete_for_me () {
		btnCancel.click();
	}
	public void click_Cancel_in_popup () {
		btncancelInpopup.click();
	}
	public void Send_one_msg () {
		Set_Values_In_Message_textbox("Hii");
		click_Send_Button();
		click_Back_Arrow();
	}
	
	public WebElement Element_of_Blocked_Banner () {
		return Elementblocked;
	}
	
	public String get_Send_message () {
		return messageCard.getText();
	}
	
	public WebElement get_Message_Status () {
		return messageStatus;
	}
	
	public String get_internet_status () {
		return internetStatus.getText();
	}

	public void open_AllMedia () {
		clickGesture(1005, 180);
		optionAllMedia.click();
	}
		
		public void open_Search () {
			clickGesture(1005, 180);
			optionSearch.click();
		}
		
		public void open_AddToHome () {
			clickGesture(1005, 180);
		AddtoHomeScreen.click();
		
		}
		
		
		public void open_Message_details_Screen () {
			longPress(messageStatus);
			clickGesture(1005, 180);
		   optionMessageDetails.click();
		}

		public String AllMedia_screen_Title () {
			return AllMediaScreenTitle.getText();
		}
		
		public String Message_Detials_screen_Title () {
			return messagedetailsScreentitle.getText();
		}
		
		public void Enter_Values_In_Search_Textbox (String value) {
			clickGesture(1005, 180);
			optionSearch.click();
			SearchTextbox.sendKeys(value);
		}
		
		public WebElement Element_of_Empty_media_Screen () {
			return emptyMediaScreen;
		}
		
		public void Click_Add_In_Add_To_HomeScreen () {
			clickGesture(1005, 180);
			AddtoHomeScreen.click();
			btnAddInAddToHomeScreen.click();
		}
		
		public void Check_Cancel_button_in_AddToHome_Screen () {
			clickGesture(1005, 180);
			AddtoHomeScreen.click();
			btnCancelInAddToHomeScreen.click();
		}
		
		public void unselect_the_message () {
			longPress(messageCard);
			btnCloseInChatScreen.click();
		}
		
		public void Reply_to_Message (String value) {
			longPress(messageCard);
			optionReply.click();
			messageTextbox.sendKeys(value);
			btnSend.click();
		}
		
		public WebElement Element_Down_arrow () {
			return iconSearchdown;
		}
		
		public String Content_No_Matches_found () {
			return ContentNoMatchesFound.getText();
		}
		
		public void click_CloseIcon_Search () {
			closeIconInSearch.click();
		}
		
		public void click_ShortCut_icon_of_Note_to_Self () {
			ShortcutIconofNoteToSelf.click();
		}
	
		public void click_ShortCut_icon_of_friend () {
			ShortcutIconoffriend.click();
		}
		
		
		public void check_Copy_text_option () {
			longPress(messageCard);
			clickGesture(1005, 180);
			optionCopytext.click();	
		}
		
		public WebElement replyCard () {
			return replycard;
		}
		
		public void Accept_request () {
			btnAccept.click();
			btnAcceptInPopup.click();
		}
		
		public void Decline_request () {
			btndecline.click();
			btnDeclineInpopup.click();
		}
		
		public void click_cancel_In_accept () {
			btnAccept.click();
			btncancelInpopup.click();
		}
		
		public void click_cancel_In_decline () {
			btndecline.click();	
			btncancelInpopup.click();
		}
		
		public WebElement Elements_of_Attachments () {
			return ElementsOfAttachments;
		}
		
		public void delete_Voice_message () {
			btndeletevoicemsg.click();
		}
		
		public WebElement Element_of_call_Icon () {
			return callIcon;
		}
		
		public void Mute_Notification () {
			clickGesture(1005, 180);
			muteNotifications.click();
			btnOkInPopup.click();
		}
		
		public void UnMute_Notification () {
			clickGesture(1005, 180);
			Unmute.click();		
		}
		
		public WebElement Element_of_Mute_Icon () {
			return muteIcon;
		}
		
		public WebElement Element_of_Disappearin_Messages () {
		   return	icondisappearingmessages;
		}
		
		public void set_Disappearing_Message () {
			clickGesture(1005, 180);
			DisappearingMessages.click();
			scroll_the_page(530, 1225, 125, "down");
			//scrollgesture_Using_text("5 seconds");
			btnOkInPopup.click();
		}
		
		public void Disable_Disappearing_message () throws InterruptedException {
		     icondisappearingmessages.click();
		     Thread.sleep(1000);
		     btnOkInPopup.click();
		}
		
		public void block_Contact () {
			clickGesture(1005, 180);
			Block.click();
			btnYes.click();
		}
		
		public void unblock_Contact () {
			clickGesture(1005, 180);
			btnUnblock.click();
			btnUnblock.click();	
		}
		
		public void click_Call_Icon () {
			callIcon.click();
		}
		
		public String callUI_page_title () {
			return callUIPageTitle.getText();
		}
		
		public void click_Cancel_Icon () {
			btncancelInpopup.click();
		}
		
		public void end_Call () {
			endcall.click();
		}
		
		public WebElement Element_of_Timer_Animation () {
			return timerAnimation;
		}
		
		public String content_DisappearingMessage () {
			return contentDisappearingMessage.getText();
		}
		
		public void delete_Send_And_Received_Message () {
			longPress(firstMessage);
			longPress(SecondMessage);
			btnDelete.click();
			optionDeleteForMe.click();
		}
		
		public void delete_Received_Message () {
			longPress(firstMessage);
			btnDelete.click();
			try{
				btndeleteInpopup.click();
			}
			catch (org.openqa.selenium.NoSuchElementException e) {
				optionDeleteForMe.click();
			}
		}
		
		public void click_Settings_option () {
			btnSettings.click();
		}
		
		public void enable_Pay_as_youChat () {
			longPress(beldexIcon);
			btnOkInPayAsYouChat.click();
		
		}
		
		public String tooltip () {
			 return tooltip.getText();
		}
		
		public WebElement Btn_Slide_to_pay () {
			return btnSlideToPay;
		}
		
		public void Download_Image () {
			longPress(image);
			optionDownload.click();
			btnYesInPopup.click();
		}
		
		public void Download_VoiceMessage () {
			longPress(voiceMessage);
			optionDownload.click();
			btnYesInPopup.click();
		}
		
		public void Forward_Image () {
			image.click();
			btnForward.click();
		}
		
		public String Forward_page_title () {
			 return forwardPagetitle.getText();
		}
		
		public void Delete_image_And_voiceMsg () {
			longPress(image);
			longPress(voiceMessage);
			//btnDelete.click();
			clickGesture(1005, 180);
			optionDeleteForMe.click();
		}
		
		public void Reply_To_Received_Message () {
			longPress(firstMessage);
			optionReply.click();
			Set_Values_In_Message_textbox("Hii");
			btnSend.click();
			
		}
		
		public WebElement Element_of_Media_file () {
			return ElementofMediaFile;
		}
		
}
