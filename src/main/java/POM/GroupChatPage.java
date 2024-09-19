package POM;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GroupChatPage extends ActionsClass{

	AndroidDriver driver;
	public GroupChatPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/title\" and @text=\"Edit group\"]")
	private WebElement optionEditGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/title\" and @text=\"Leave group\"]")
	private WebElement optionLeaveGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/title\" and @text=\"Notification settings\"]")
	private WebElement optionNotificationSettings;
	
	@AndroidFindBy(accessibility = "Edit Group Name")
	private WebElement editIcon;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/edtGroupName")
	private WebElement groupNameTextBox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/btnSaveGroupNameEdit")
	private WebElement tickIconInTextBox;
	
	@AndroidFindBy(id="io.beldex.bchat:id/btnCancelGroupNameEdit")
	private WebElement cancelIconInTextBox;
	
	@AndroidFindBy(accessibility = "Apply")
	private WebElement addMemberIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/applyChangesBtn")
	private WebElement btnApplyChanges;
	
	@AndroidFindBy(id="io.beldex.bchat:id/actionIndicatorImageView")
	private WebElement removeIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/removeFromGroup")
	private WebElement btnRemoveFromGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Select Contacts\"]")
	private WebElement SelectContactPagetitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/contentView")
	private WebElement ContactInList;
	
	@AndroidFindBy(id="io.beldex.bchat:id/addButton")
	private WebElement btnAdd;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/textView\" and @text=\"You added test to the group\"]")
	private WebElement informationAboutAddedPerson;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/textView\" and @text=\"You removed test from the group\"]")
	private WebElement informationAboutRemovedPerson;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	private WebElement groupName;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Edit Group\"]")
	private WebElement editgrouppageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Leave\"]")
	private WebElement btnLeaveInPopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Cancel\"]")
	private WebElement btnCancelInPopup;

	@AndroidFindBy(id="io.beldex.bchat:id/noLongerParticipantTextView")
	private WebElement informationAboutNotInGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Mentions\"]")
	private WebElement optionMentions;
	
    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"All\"]")
	private WebElement optionAll;
    
    @AndroidFindBy(className = "android.widget.ImageView")
	private WebElement closeIconInpopup;
    
    @AndroidFindBy(accessibility ="More options")
    private WebElement btnMoreoption;
    
    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement CloseIconInEditgroup;
    
    @AndroidFindBy(id="io.beldex.bchat:id/inputBarEditText")
    private WebElement textbox;
    
    @AndroidFindBy(id="io.beldex.bchat:id/attachmentsButtonContainer")
	private WebElement btnattachments;
    
    @AndroidFindBy(id = "io.beldex.bchat:id/imageButton")
	private WebElement optionGallery;
    
    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")
	private WebElement firstFolder;
    
    @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.ImageView[1][@index='0']")
	private WebElement AllMediaInGallery;
    
    @AndroidFindBy(accessibility = "Send")
	private WebElement btnSendInImage;
    
    @AndroidFindBy(id="io.beldex.bchat:id/microphoneOrSendButtonContainer")
	private WebElement btnSend;
    
    @AndroidFindBy(id="io.beldex.bchat:id/bodyTextView")
    private WebElement messageCard;
    
    @AndroidFindBy(accessibility = "Message delivery status")
    private WebElement messageStatus;
    
    @AndroidFindBy(accessibility = "Delete message")
    private WebElement deleteIcon;
    
    @AndroidFindBy(id="io.beldex.bchat:id/deleteForMeTextView")
    private WebElement btnDeleteForMe;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/title\" and @text=\"Delete message\"]")
    private WebElement optionDeleteMessage;
    
    @AndroidFindBy(id="io.beldex.bchat:id/back_to_home_Btn")
    private WebElement btnBackArrow;
    
    @AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btndeleteInpopup;
    
    public String groupName () {
    	return groupName.getText();
    }
    
    public String EditGroup_Screen_title () {
    	return editgrouppageTitle.getText();
    }
    
    public String Select_contact_Screen_Title () {
    	return SelectContactPagetitle.getText();
    }
    
    public void Remove_member_from_group () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionEditGroup.click();
    	removeIcon.click();
    	btnRemoveFromGroup.click();
       btnApplyChanges.click();
    }
    
    public String get_information_About_removed () {
    	return informationAboutRemovedPerson.getText();
    }
    
    public void Add_person_in_Group () throws InterruptedException {
    	try {
    		
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionEditGroup.click();
    	try {
    		Thread.sleep(1000);
    		clickGesture(1005, 200);
    	}
    	catch (NoSuchElementException e) {
    		addMemberIcon.click();
		}
    	ContactInList.click();
    	btnAdd.click();
    	btnApplyChanges.click();
    }
    

    public String get_information_About_Added () {
    	return informationAboutAddedPerson.getText();
    }
    
    public void Change_group_name (String groupname) {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionEditGroup.click();
    	editIcon.click();
    	groupNameTextBox.clear();
    	groupNameTextBox.sendKeys(groupname);
    	tickIconInTextBox.click();
    	
    }
    
    public String get_groupName_textbox_placeholder () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionEditGroup.click();
    	editIcon.click();
    	groupNameTextBox.clear();
        return groupNameTextBox.getText();	
    }
    
    public void click_groupName_textbox () {
    	groupNameTextBox.click();
    }
    
    public void click_Apply_changes () {
    	btnApplyChanges.click();
    }
  
    public void click_cancel_In_LeaveGroup () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionLeaveGroup.click();
    	btnCancelInPopup.click();
    }
    
    public void Click_Close_in_NotificationSettings_popup () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionNotificationSettings.click();
    	closeIconInpopup.click();
    }
    
    public void Click_close_in_editGroup_Screen () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionEditGroup.click();
        CloseIconInEditgroup.click();
    }
    
    public void Set_Mentions_option () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionNotificationSettings.click();
    	optionMentions.click();
    }
    
    public void btn_More_option () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	
    }
    public void Set_All_option () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionNotificationSettings.click();
    	optionAll.click();
    }
    
    public void Set_Values_in_textbox (String value) {
       textbox.sendKeys(value);	
    }
    
    public void click_Send_button () {
    	btnSend.click();
    }
    
    public WebElement Message_Status () {
    return  messageStatus;	
    }
    
    public void Send_image () throws InterruptedException {
		btnattachments.click();
		optionGallery.click();
		AllMediaInGallery.click();
		Thread.sleep(1000);
		firstFolder.click();
		btnSendInImage.click();
	}
    
    public void Record_Voice_Msg () throws InterruptedException {
	//	longPress(btnSend);
		drap_Gesture(btnSend, 950, 1990);
	   Thread.sleep(2000);
    }
	
    public void deleteMessage () {
    	longPress(messageStatus);
    	deleteIcon.click();
    	try {
    	btnDeleteForMe.click();
    	}
    	catch (NoSuchElementException e) {
			btndeleteInpopup.click();
		}
    	}
    
    public void delete_voiceMsg_Or_attachment () {
    	longPress(messageStatus);
    	try {
        deleteIcon.click();
    	}
    	catch (NoSuchElementException e) {
			btn_More_option();
			optionDeleteMessage.click();
		}
    	try {
        	btnDeleteForMe.click();
        	}
        	catch (NoSuchElementException e) {
    			btndeleteInpopup.click();
    		}
    }
    
    public void Click_Back_Arrow () {
    	btnBackArrow.click();
    }
    public void click_delete_In_Popup () {
		btndeleteInpopup.click();
	}
    
    public void Leave_Group () {
    	try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
    	optionLeaveGroup.click();
    	btnLeaveInPopup.click();
    }
    
    public WebElement Information_about_not_In_Group () {
    	return informationAboutNotInGroup;
    }
    
}
