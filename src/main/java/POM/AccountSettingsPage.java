package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountSettingsPage extends ActionsClass{

	AndroidDriver driver;
	public AccountSettingsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Account Settings']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[305,804][449,948]']")
	private WebElement BeldexaddressCopyIcon;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[588,804][732,948]']")
	private WebElement BchatIdCopyIcon;
	
	@AndroidFindBy(xpath="//android.view.View[@bounds='[728,852][969,1050]']")
	private WebElement optionQrCode;

	@AndroidFindBy(xpath="//android.view.View[@bounds='[111,852][401,1050]']")
	private WebElement optionBeldexAddress;
	
	@AndroidFindBy(xpath="//android.view.View[@bounds='[445,852][684,1050]']")
	private WebElement optionBchatId;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beldex Address']")
	private WebElement BeldexAddressPopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BChat ID']")
	private WebElement BchatIdPopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan QR code']")
	private WebElement QrCodePopupScreenTitle;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnShare;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnLinkBNS;
	
	@AndroidFindBy(accessibility = "Read more about BNS")
	private WebElement OptionAboutBNS;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='About BNS']")
	private WebElement AboutBNSScreenTitle;

	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement copyIcon;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;

	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Link BNS']")
	private WebElement LinkBNSPopupScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='4']")
	private WebElement textBoxBNSName;

	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button[@index='1']")
	private WebElement btnCancelInLinkBNS;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement btnCancelInShareoptionScreen;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.Button[@index='1']")
	private WebElement btnVerifyInLinkBNS;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.widget.Button[@index='1']")
	private WebElement btnLinkInLinkBNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verifying...']")
	private WebElement loadingAnimationScreen;
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Verified']")
	private WebElement btnVerified;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hops']")
	private WebElement optionHops;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App Lock']")
	private WebElement optionAppLock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Chat Settings']")
	private WebElement optionChatSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Blocked Contacts']")
	private WebElement optionBlockedContacts;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Clear Data']")
	private WebElement optionClearData;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Feedback']")
	private WebElement optionFeedback;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='FAQ']")
	private WebElement optionFAQ;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Changelog']")
	private WebElement optionChangeLog;

	@AndroidFindBy(accessibility = "feedback@beldex.io, feedback@beldex.io")
	private WebElement feedbackmailid;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout/android.widget.TextView[2][@text='1 image in total']")
	private WebElement ShareScreentitle;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Frequently Asked Questions']")
	private WebElement FAQPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='1']")
	private WebElement changelogPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1.0.0']")
	private WebElement firstlog;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2.5.0']")
	private WebElement log2_5_0;

	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Initial Release']")
	private WebElement firstLogContent;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Edit\"]")
	private WebElement btnEdit;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Done\"]")	
	private WebElement btnDone;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[5]/android.view.View")
	private WebElement CameraIcon;
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement textboxeditname;
			
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profile Picture']")
    private WebElement profilePictureScreenTitle;
	
	@AndroidFindBy(accessibility = "Close")
	private WebElement btnCancelinProfilepictureScreen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Upload']")
	private WebElement btnUpload;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Photos\"])[2]")
	private WebElement optionsPhotos;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Photos\"])[1]")
	private WebElement optionsPhotos2;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Camera']")
	private WebElement optionCamera;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='2']")
	private WebElement FirstFolderInGallery;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='1']")
	private WebElement FirstImageInGallery;
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/crop_image_menu_crop")
	private WebElement btnCrop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Remove Picture']")
	private WebElement btnRemovePicture;
	
	
	@AndroidFindBy(id = "com.oplus.camera:id/shutter_button")
	private WebElement btntakePhoto;
	
	@AndroidFindBy(id="com.oplus.camera:id/done_button")
	private WebElement btntickAfterTakingPhoto;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement btnCancelInGalleryOption;
	
	@AndroidFindBy(id="io.beldex.bchat:id/defaultRoomsLoader")
	private WebElement loaderAnimation;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back")
    private WebElement BackArrow; 
	
    public void EditDisplayName (String NewName) {
         btnEdit.click();
    	textboxeditname.click();
    	textboxeditname.clear();
    	textboxeditname.sendKeys(NewName);	
    	btnDone.click();
    }

    public  String profilePictureScreentitle() {
   	 return profilePictureScreenTitle.getText();
   }

   public void clickcancel_In_ProfilePicture_Screen() {
		btnCancelinProfilepictureScreen.click();
	}
    
   public void clickBackArrow () {
	   BackArrow.click();
   }
   
   public void clickDone_button () {
	btnDone.click();   
   }
   
   public void open_ProfilePicture_Popup () {
	   btnEdit.click();
	   CameraIcon.click();
	   
   }
   
   public void clickRemovePicture () {
	   btnRemovePicture.click();
   }
  
   public void clickUpload () {
	   btnUpload.click();
   }
  
   public void Set_Profile_Picture_from_Gallery () {
	   
	  btnUpload.click();
	   optionsPhotos.click();
 	   FirstFolderInGallery.click();
 	   FirstImageInGallery.click();
 	   btnCrop.click();   
 	   btnDone.click();
   }
   
   public void Set_Profile_Picture_from_Gallery2 () {
	  
	  
	   btnUpload.click();
		optionsPhotos2.click();
	 	FirstFolderInGallery.click();
	 	FirstImageInGallery.click();
	  btnCrop.click();
	  btnDone.click();
	   }
   
   public void Set_Profile_Picture_from_Camera () throws InterruptedException {
	   
	   
	   btnUpload.click();
	   optionCamera.click();
 	   btntakePhoto.click();
 	   Thread.sleep(3000);
 	   btntickAfterTakingPhoto.click();
 	   btnCrop.click(); 
 	   btnDone.click();
 	  
   }
   
   public void set_Profile_Picture_Without_Internet () {
	   
	   btnEdit.click();
	   CameraIcon.click();
	   btnUpload.click();
   }
   
   public WebElement Loading_Animation () {
	   return loaderAnimation;
   }
	
	public void Click_back_arrow () {
		btnBackArrow.click();
	}
	
	public WebElement lastLog () {
		return log2_5_0;
	}
	
	public WebElement ElementChangelog() {
		return optionChangeLog;
	}
	
    public String pageTitle() {
    	 return pageTitle.getText();
    }
    
    public String Share_Screen_Title () {
    	return ShareScreentitle.getText();
    }
    
    public void ClickBchatIdIcon () {
    	optionBchatId.click();
    }
    
    public void ClickBeldexAddressIcon () {
    	optionBeldexAddress.click();
    }
    
    public void click_option_Chat_settings () {
    	optionChatSettings.click();
    }
    public void ClickQRCode () {
    	optionQrCode.click();
    }
    public void CopyBchatId () {
    	BchatIdCopyIcon.click();
    }
  
    public void CopyBeldexAddress () {
    	BeldexaddressCopyIcon.click();
    }

    public String getPopupTitle (String ScreenName) {
       String 	Screentitle = null;
    	if(ScreenName.equalsIgnoreCase("BchatId"))
    	{
    		Screentitle = BchatIdPopupScreenTitle.getText();
    	}
    	if(ScreenName.equalsIgnoreCase("BeldexAddress")) {
    		Screentitle = BeldexAddressPopupScreenTitle.getText();
    	}
    	if(ScreenName.equalsIgnoreCase("QrCode")) {
    		Screentitle = QrCodePopupScreenTitle.getText();	
    	}
    	return Screentitle;
    	}

    public void clickCopyIcon() {
		copyIcon.click();
	}

    public void clickSharebtn () {
    	btnShare.click();
    }
    
    public void ClickAboutBNS () {
    	OptionAboutBNS.click();
    }
    
    public String get_About_BNS_Screen_title () {
		return AboutBNSScreenTitle.getText();
   	
    }
    
    public void click_Link_BNS_option () {
    	btnLinkBNS.click();
    }
    
    public String get_Link_BNS_Popup_Screen_Title () {
    	return LinkBNSPopupScreenTitle.getText();
    }
    
    public void Enter_Value_In_BNS_Name_field (String Value) {
    	//textBoxBNSName.click();
    	textBoxBNSName.sendKeys(Value);
    }
    
    public void click_Verify_Button () {
    btnVerifyInLinkBNS.click();
    }
    
    public void click_Link_Button_In_Popup_Screen () {
    	btnLinkInLinkBNS.click();
    }
    
    public void click_Cancel_Button_In_Popup_Screen () {
    	btnCancelInLinkBNS.click();
    }
    
    public void click_Cancel_In_share_option () {
    	btnCancelInShareoptionScreen.click();
    }
    
    public WebElement Loader_Animation () {
    	return loadingAnimationScreen;
    }
    
    public void  Scroll_the_screen () {
    	scrollgesture_Using_text(optionChangeLog.getText());
    }
    
    public void clear_text_box() {
    	textBoxBNSName.clear();
    }
     
    public void click_Hops_Option () {
    	optionHops.click();
    }
    
    public void click_App_Lock_Option () {
    	optionAppLock.click();
    }
    
    public String Content_changelog () {
		return optionChangeLog.getText();
    	
    }
    
    public WebElement Element_of_Link_BNS_PopScreen_content () {
		return LinkBNSPopupScreenTitle;
    	
    }
    
    public void click_Blocked_contact_Option () {
    	optionBlockedContacts.click();
    }
    
    public void click_Clear_Data_option (){
	optionClearData.click();
    }
    
    public void click_Feedback_option (){
    	optionFeedback.click();
    }

    public void click_FAQ_option (){
    	optionFAQ.click();
    }

    public void click_Changelog_option (){
    	optionChangeLog.click();
    }

    public String feedback_mail_Id () {
    	return feedbackmailid.getText();
    }

    public String FAQ_Page_Title () {
    	return FAQPageTitle.getText(); 
    }
    
    public String ChangeLog_PageTitle () {
    	return changelogPageTitle.getText();
    }
    
    public void click_First_Log () {
    	firstlog.click();
    }
    
    public WebElement FirstLog_content () {
    	return firstlog;
    }
}
