package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SocialGroupPage extends ActionsClass {

	AndroidDriver driver;
	public SocialGroupPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Social Group']")
	private WebElement pageTitle;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement urlTextbox;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnNext;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BChat']")
	private WebElement bchatgroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Beldex']")
	private WebElement beldexgroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='BELNET']")
	private WebElement belnetgroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Crypto News']")
	private WebElement cryptoNewsgroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Masternode']")
	private WebElement MasterNodegroup;
	
	@AndroidFindBy(xpath = "//android.widget.EditText/android.view.View/android.widget.ImageView")
	private WebElement btnScanner;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/uploadFromGallery_Layout")
	private WebElement optionUploadFromGallery;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text='Photos'])[1]")
	private WebElement optionGallery;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Albums']")
	private WebElement optionAlbums;
	
	@AndroidFindBy(accessibility = "Invalid Qr,1 item,")
	private WebElement InvalidQRCodeFolder;
	
	@AndroidFindBy(id="com.oneplus.gallery:id/base_album_item_img")
	private WebElement QrCodePhoto;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter a social group URL']")
	private WebElement placeholder;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(id = "io.beldex.bchat:id/readButton")
	private  WebElement btnCommunityGuidelines; 
	
	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement communityGudlinesScreenTitle ;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationTitleView")
	private WebElement groupName;
	
	@AndroidFindBy(accessibility ="More options")
    private WebElement btnMoreoption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.beldex.bchat:id/title\" and @text=\"Add members\"]")
	private WebElement optionAddMembers;
	
	@AndroidFindBy(id="io.beldex.bchat:id/contentView")
	private WebElement ContactInList;
	
	@AndroidFindBy(id="io.beldex.bchat:id/addButton")
	private WebElement btnAdd;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationSubtitleView")
	private WebElement memberCount;
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public void Enter_Values_In_textBox (String value) {
		urlTextbox.sendKeys(value);
	}
	
	public void click_Next () {
		btnNext.click();
	}
	
	public void join_Bchat_Group () {
		bchatgroup.click();
	}
	
	public void join_MasterNode_Group () {
		MasterNodegroup.click();
	}
	
	public void join_Beldex_Group () {
		beldexgroup.click();
	}
	
	public void clear_textBox () {
		urlTextbox.clear();
	}
	
	public void click_Scanner () {
		btnScanner.click();
	}
	
	public void upload_Invalid_QR_code () {
		
		optionUploadFromGallery.click();
		optionGallery.click();
		optionAlbums.click();
		InvalidQRCodeFolder.click();
		QrCodePhoto.click();
		
	}
	
	public String get_Values_From_textbox () {
		return urlTextbox.getText();
	}
	
	
	public String get_Placeholder_Value () {
		return placeholder.getText();
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public void paste_Values(String value) {
		Copy_And_Paste_Values(value, urlTextbox);
	}
	
	public void click_Url_Textbox () {
		urlTextbox.click();
	}

	public List<WebElement> get_Element_of_Groups (){
		
		List<WebElement> list = new ArrayList<WebElement>();
		list.add(bchatgroup);
		list.add(beldexgroup);
		list.add(belnetgroup);
		list.add(MasterNodegroup);
		list.add(cryptoNewsgroup);
		
		return list;	
	}
	
	public void open_Community_Guidelines () {
		btnCommunityGuidelines.click();
	}
	
	public String community_Guidelines_Screen_title () {
		return communityGudlinesScreenTitle.getText();
	}

	public String groupName () {
		return groupName.getText();
	}
	
	public void Add_Member () {
		try {
    		clickGesture(1005, 180);
        	}
        	catch (NoSuchElementException e) {
            	btnMoreoption.click();
    		}
		optionAddMembers.click();
		ContactInList.click();
	    btnAdd.click();
	}
	
	public int get_Member_Count () {
	String MemeberCount = memberCount.getText();
	int count = Integer.parseInt(MemeberCount.substring(0,2));
	return count;
	
	}
}
