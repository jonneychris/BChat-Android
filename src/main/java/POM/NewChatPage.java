package POM;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewChatPage extends ActionsClass {

	AndroidDriver driver;
	public NewChatPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New Chat']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement BchatIDOrBNSNameTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='1']")
	private WebElement btnLetsBChat;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Chat ID']")
	private WebElement btnYourBchatId;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement optionUploadFromGallery;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Scan QR']")
	private WebElement ScanQRCodeTitle;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
	private WebElement btnScanner;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Photos'])[1]")
	private WebElement optionGallery;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Albums']")
	private WebElement optionAlbums;
	
	@AndroidFindBy(accessibility = "QR code,1 item,")
	private WebElement QrCodeFolder;
	
	@AndroidFindBy(accessibility = "Invalid Qr,1 item,")
	private WebElement InvalidQRCodeFolder;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.oneplus.gallery:id/albumset_title\" and @text=\"documents\"]")
	private WebElement imageFolder;
	
	@AndroidFindBy(id="com.oneplus.gallery:id/base_album_item_img")
	private WebElement QrCodePhoto;
	
	@AndroidFindBy(accessibility = "Select")
	private WebElement btnSelect;
	
	@AndroidFindBy(className = "android.widget.TextView")
	private WebElement loader;
	
	@AndroidFindBy(id="io.beldex.bchat:id/defaultRoomsLoader")
	private WebElement imageLoader;
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}

	public void id_for_Message_Request () {
		BchatIDOrBNSNameTextBox.sendKeys("bde004ef778926d42e6ab0f8327a645b3ad51159e3183a7ac512029012981f784b");
		btnLetsBChat.click();
	}
	public void Check_with_ValidId_1 () {
		BchatIDOrBNSNameTextBox.sendKeys("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		btnLetsBChat.click();
	}
	
	public void Check_with_ValidId_2 () {
		BchatIDOrBNSNameTextBox.sendKeys("bdb1c1832438f00669476dcf8d8ef6c4efdb49feeb4c389036f46db91951584b24");
		btnLetsBChat.click();
	}
	
	public void Check_with_Invalid() {
		BchatIDOrBNSNameTextBox.sendKeys("dgrb1c18ew438hajajakKbf0p6694760cl8oiaf644efdbrtfeeb4c389036fk6db91951584b24");
		btnLetsBChat.click();
	}
	
	public void Enter_BNS_Name(String value) {
		BchatIDOrBNSNameTextBox.sendKeys(value);
		
	}
	
	
	public void click_Your_BchatId () {
		btnYourBchatId.click();
	}
	
	public void click_Lets_Bchat () {
		btnLetsBChat.click();
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public void Upload_valid_Qr_code () {
		btnScanner.click();
		optionUploadFromGallery.click();
		optionGallery.click();
		optionAlbums.click();
	    try{
	    	QrCodeFolder.click();
		QrCodePhoto.click();
		btnSelect.click();
	    }
	    catch (NoSuchElementException e) {
			driver.navigate().back();
			optionUploadFromGallery.click();
			optionGallery.click();
			optionAlbums.click();
			QrCodeFolder.click();
			QrCodePhoto.click();
			btnSelect.click();
		}
	}
	
	public void Upload_Invalid_Qr_Code () {
		btnScanner.click();
		optionUploadFromGallery.click();
		optionGallery.click();
		optionAlbums.click();
		try {
    	InvalidQRCodeFolder.click();
   		QrCodePhoto.click();
   		btnSelect.click();
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
			optionUploadFromGallery.click();
			optionGallery.click();
			optionAlbums.click();
			InvalidQRCodeFolder.click();
	   		QrCodePhoto.click();
	   		btnSelect.click();
		}
	}
	
	public void Upload_image () {
		btnScanner.click();
		optionUploadFromGallery.click();
		optionGallery.click();
		optionAlbums.click();
		try {
		imageFolder.click();
		QrCodePhoto.click();
		btnSelect.click();
		}
		catch (NoSuchElementException e) {
			driver.navigate().back();
			optionUploadFromGallery.click();
			optionGallery.click();
			optionAlbums.click();
			imageFolder.click();
			QrCodePhoto.click();
			btnSelect.click();
		}
	}
	
	public WebElement Element_of_Loader () {
		return loader;
	}
	
	public WebElement Element_of_NewChat_screen () {
		return pageTitle;
	}
	
	public void clear_textBox () {
		BchatIDOrBNSNameTextBox.clear();
	}
	
	public void Paste_Values_In_textBox (String value) {
		Copy_And_Paste_Values(value, BchatIDOrBNSNameTextBox);
	}
	
	public WebElement imageLoader () {
		return imageLoader;
	}
	
	public String scan_Qr_Screen_title () {
		return ScanQRCodeTitle.getText();
	}
	
	public String get_Values_from_TextBox () {
		return BchatIDOrBNSNameTextBox.getText();
	}
}
