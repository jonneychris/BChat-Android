package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReceivePage extends ActionsClass {

	AndroidDriver driver;
	public ReceivePage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View/android.view.View[1][@index='3']")
	private WebElement copyIconInReceiveScreen;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
	private WebElement btnShareInReciveScreen;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Receive']")
	private WebElement ReceiveScreenTitle;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout/android.widget.TextView[2][@text='1 image in total']")
	private WebElement ShareScreentitle;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement btnCancel;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement amounttextbox;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[2]")
	private WebElement errorMsg;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='0.0000']")
	private WebElement placholder;
	
	   public void click_copyIcon_In_receiveScreen () {
	    	copyIconInReceiveScreen.click();
	    }
	    
	    public void click_share () {
	    	btnShareInReciveScreen.click();
	    }
	    
	    public String Receive_Screen_title () {
	     return	ReceiveScreenTitle.getText();
	    }
	    
	    public String Share_Screen_Title () {
	    	return ShareScreentitle.getText();
	    }
	    
	    public void click_Cancel () {
	    	btnCancel.click();
	    }

	    public void Enter_Value_In_Amount_textBox (String value) {
	    	amounttextbox.sendKeys(value);
	    }
	    
	    public String get_ErrorMsg () {
	    	return errorMsg.getText();
	    }
	    
	    public String get_Placholder () {
	    	return placholder.getText();
	    }
	    
	    public String get_Values_From_Amount_textbox () {
	    	return amounttextbox.getText();
	    }
	    
	    public void clear_TextBox () {
	    	amounttextbox.clear();
	    }
	    
	    public void paste_values (String value) {
	    	Copy_And_Paste_Values(value, amounttextbox);
	    }
	    
	    public void click_textbox () {
	    	amounttextbox.click();
	    }
	    
	   
}
