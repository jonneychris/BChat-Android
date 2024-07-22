package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyAccountPage extends ActionsClass {

	AndroidDriver driver;
	public  MyAccountPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View[@index='0']")
	private WebElement IDCopyIcon;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.view.View[@index='0']")
	private WebElement addressCopyIcon;
	
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=''][1]")
	private WebElement profileIcon;
	
	//[588,578][684,674]
	@AndroidFindBy(xpath="//android.widget.ImageView[@index='1']")
	private WebElement EditdisplayNameIcon;
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/share")
	private WebElement btnShare;

	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement textboxeditname;
		
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[@index='0']")
	private WebElement tickIcon;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout/android.widget.TextView[2][@text='1 image in total']")
    private WebElement ShareScreenTitle; 	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profile Picture']")
    private WebElement profilePictureScreenTitle;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement btnCancelinShareScreen;
	
	@AndroidFindBy(accessibility = "Close")
	private WebElement btnCancelinProfilepictureScreen;
	//Close
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Upload']")
	private WebElement btnUpload;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back")
    private WebElement BackArrow; 

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[4]/android.widget.ImageView")
	private WebElement optionsPhotos;
	
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
	
	//@Android
	//android.widget.TextView[@text='Photos']
	public String pagetitle() {
		return pageTitle.getText();
	}
	

	public void click (String option) {
		if(option.equalsIgnoreCase("BChatId")) {
			IDCopyIcon.click();
		}
		if(option.equalsIgnoreCase("Beldexaddress")) {
			addressCopyIcon.click();
		}		
	}

    public void ClickshareButton () {
		btnShare.click();
	}
    
    

    
    public void EditDisplayName (String NewName) {
         EditdisplayNameIcon.click();
    	textboxeditname.click();
    	textboxeditname.clear();
    	textboxeditname.sendKeys(NewName);
    	
    	
    }
    
    public void click_tick_inDisplayName () { 	
    tickIcon.click();
    }
    
    public void clickProfileIcon () {
         profileIcon.click();
       
    } 

    public  String shareScreenTitle() {
    	 return ShareScreenTitle.getText();
    }
    
    public  String profilePictureScreentitle() {
   	 return profilePictureScreenTitle.getText();
   }
    
   public void clickcancel_In_share_Screen() {
	btnCancelinShareScreen.click();
}
   public void clickcancel_In_ProfilePicture_Screen() {
		btnCancelinProfilepictureScreen.click();
	}
    
   public void clickBackArrow () {
	   BackArrow.click();
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
   }
   
   public void Set_Profile_Picture_from_Camera () throws InterruptedException {
	   btnUpload.click();
	   optionCamera.click();
 	   btntakePhoto.click();
 	   Thread.sleep(2000);
 	   btntickAfterTakingPhoto.click();
 	   btnCrop.click();   
   }
   
   public void set_Profile_Picture_Without_Internet () {
	   
	   profileIcon.click();
	   btnUpload.click();
   }
   
   public WebElement Loading_Animation () {
	   return loaderAnimation;
   }
}
